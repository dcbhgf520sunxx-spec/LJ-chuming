package com.hzchum.scim.rest.controller.mes.building.scheduling;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.common.core.api.enums.SteelPlateTypeEnum;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingBiz;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingMachinePartSchedulingLinkBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskNeedMachinePartSchedulingUnProductionBiz;
import com.hzchum.scim.mes.building.core.api.enums.MachinePartSchedulingIssueStatusEnum;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartSchedulingUnProductionParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartNestingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingPartCheckDrillDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.post.MesBuildingCheckDrillVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.post.MesBuildingMachinePartNestCutTaskSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.post.MesBuildingMachinePartNestingSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.post.MesBuildingMachinePartSchedulingSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.task.post.MachinePartUnProductionSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.task.put.MachinePartUnProductionUpdateVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task.WorkshopRequestParam;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES零件排产")
@RestController
@RequestMapping("/api/mes/building/machine_part/scheduling")
public class MesBuildingMachinePartSchedulingController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingMachinePartSchedulingController.class);
   @Resource
   private MesBuildingMachinePartSchedulingBiz machinePartSchedulingBiz;
   @Resource
   private MesBuildingMachinePartSchedulingLinkBiz machinePartSchedulingLinkBiz;
   @Resource
   private MesBuildingTaskNeedMachinePartSchedulingUnProductionBiz unProductionBiz;
   @Resource
   private RedisUtils redisUtils;

   @ApiOperation("获取可排产零件列表")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part:get')")
   public ResultVO getMachinePartList(
      @RequestParam(name = "projectIds", required = false) List<Long> projectIds,
      @RequestParam(name = "monomerIds", required = false) List<Long> monomerIds,
      @RequestParam(name = "areaIds", required = false) List<Long> areaIds,
      @RequestParam(name = "monthList") List<LocalDateTime> monthList,
      @RequestParam(name = "dateTime", required = false) LocalDateTime dateTime,
      @RequestParam(name = "material") String material,
      @RequestParam(name = "thick", required = false) String thick,
      @RequestParam(name = "thickList", required = false) List<String> thickList,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "minLength", required = false) BigDecimal minLength,
      @RequestParam(name = "maxLength", required = false) BigDecimal maxLength,
      @RequestParam(name = "taskTypeEnum", required = false) Integer taskTypeEnum,
      @RequestParam(name = "boolDxfEnum", required = false) Boolean boolDxfEnum,
      @RequestParam(name = "workshopIds", required = false) List<Long> workshopIds,
      @RequestParam(name = "productionLineIds", required = false) List<Long> productionLineIds,
      @RequestParam(name = "groupsIds", required = false) List<Long> groupsIds
   ) {
      log.info("API 调用 ：获取可排产零件列表");
      return ResultBuilder.success(
         this.machinePartSchedulingBiz
            .getMachinePartListAndSummary(
               projectIds,
               monomerIds,
               areaIds,
               monthList,
               dateTime,
               material,
               thick,
               thickList,
               serialNumber,
               minLength,
               maxLength,
               taskTypeEnum,
               boolDxfEnum,
               workshopIds,
               productionLineIds,
               groupsIds
            )
      );
   }

   @ApiOperation("获取零件已排产记录")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "issueStatus", value = "任务状态  任务状态 [1 未套料 2 套料中 4 套料完成 8 已下发]", paramType = "query"),
            @ApiImplicitParam(name = "dateTime", value = "排产日期", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "条数", paramType = "query", defaultValue = "20")
      }
   )
   @GetMapping("/record/page")
   @PreAuthorize(
      "@permission.check('mes_scheduling_machine_part_record:get','mes_scheduling_machine_part_record:del','mes_scheduling_machine_part_record:save')"
   )
   public ResultVO getMachinePartSchedulingRecordPage(
      @RequestParam(required = false) @EnumValidator(value = MachinePartSchedulingIssueStatusEnum.class, message = "任务状态错误") Integer issueStatusEnum,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：获取零件已排产记录");
      return ResultBuilder.success(this.machinePartSchedulingBiz.getMachinePartSchedulingRecordPage(issueStatusEnum, dateTime, pageNumber, pageSize));
   }

   @ApiOperation("获取零件已排产记录详情")
   @GetMapping("/record/{id}")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part_record:detail')")
   public ResultVO getMachinePartSchedulingRecordDetails(@PathVariable(name = "id") Long id) {
      log.info("API 调用 ：获取零件已排产记录详情");
      return ResultBuilder.success(this.machinePartSchedulingLinkBiz.getMachinePartSchedulingRecordDetails(id));
   }

   @ApiOperation("保存零件排产-新版")
   @PostMapping("/nest_cut")
   public ResultVO saveMachinePartNestCut(@RequestBody @Validated MesBuildingMachinePartSchedulingSaveVORequest voRequest) {
      log.info("API 调用 ：保存零件排产-新版");
      Boolean booleScheduling = (Boolean)this.redisUtils.get("booleScheduling");
      if (booleScheduling != null && !booleScheduling) {
         Preconditions.checkArgument(false, "下发失败!当前有正在下发的工单请刷新后重试!");
      } else {
         this.redisUtils.set("booleScheduling", Boolean.FALSE);
      }

      try {
         Long aLong = this.machinePartSchedulingBiz.saveMachinePartNestCut(BeanUtil.copy(voRequest, MesBuildingMachinePartSchedulingDTOParam.class));
         return ResultBuilder.success(aLong);
      } finally {
         this.redisUtils.set("booleScheduling", Boolean.TRUE);
      }
   }

   @ApiOperation("查询是否需要钻孔")
   @PostMapping("/check/drill")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part:get')")
   public ResultVO chenkDrill(@RequestBody MesBuildingCheckDrillVORequest voRequest) {
      log.info("API 调用 ：查询是否需要钻孔");
      return ResultBuilder.success(
         this.machinePartSchedulingBiz
            .chenkDrill(
               voRequest.getPartList() == null
                  ? null
                  : voRequest.getPartList().stream().map(e -> BeanUtil.copy(e, MesBuildingPartCheckDrillDTOParam.class)).collect(Collectors.toList()),
               voRequest.getSchedulingId(),
               voRequest.getCutConfigId(),
               voRequest.getThick()
            )
      );
   }

   @ApiOperation("查询是否需要钻孔V2")
   @PostMapping("/check/drill-v2")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part:get')")
   public ResultVO chenkDrillV2(@RequestBody MesBuildingCheckDrillVORequest voRequest) {
      log.info("API 调用 ：查询是否需要钻孔V2");
      return ResultBuilder.success(
         this.machinePartSchedulingBiz
            .chenkDrillV2(
               voRequest.getPartList() == null
                  ? null
                  : voRequest.getPartList().stream().map(e -> BeanUtil.copy(e, MesBuildingPartCheckDrillDTOParam.class)).collect(Collectors.toList()),
               voRequest.getSchedulingId(),
               voRequest.getCutConfigId(),
               voRequest.getThickList()
            )
      );
   }

   @ApiOperation("保存套料完成进行下发任务")
   @PostMapping("/nest_cut/task")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part:save','mes_scheduling_assemble:save')")
   public ResultVO saveMachinePartNestCut(@RequestBody @Validated MesBuildingMachinePartNestCutTaskSaveVORequest voRequest) {
      log.info("API 调用 ：保存套料完成进行下发任务");
      return ResultBuilder.success(
         this.machinePartSchedulingBiz.saveMachinePartNestCutTask(BeanUtil.copy(voRequest, MesBuildingMachinePartSchedulingDTOParam.class))
      );
   }

   @ApiOperation("获取可排产项目列表")
   @GetMapping("/project/list")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part:get')")
   public ResultVO getProjectList(
      @RequestParam(name = "monthList") List<LocalDateTime> monthList, @RequestParam(name = "dateTime", required = false) LocalDateTime dateTime
   ) {
      log.info("API 调用 ：获取可排产项目信息");
      return ResultBuilder.success(new ListVO<>(this.machinePartSchedulingBiz.getProjectList(monthList, dateTime)));
   }

   @ApiOperation("获取可排产项目树")
   @GetMapping("/project/tree")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part:get')")
   public ResultVO getProjectTree(
      @RequestParam(name = "monthList") List<LocalDateTime> monthList,
      @RequestParam(name = "dateTime", required = false) LocalDateTime dateTime,
      @RequestParam(required = false) Integer level
   ) {
      log.info("API 调用 ：获取可排产项目信息");
      return ResultBuilder.success(new ListVO<>(this.machinePartSchedulingBiz.getProjectTree(monthList, dateTime, level)));
   }

   @ApiOperation("获取可排产单体信息")
   @GetMapping("/monomer/list")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part:get')")
   public ResultVO getProjectList(
      @RequestParam(name = "projectIds") List<Long> projectIds,
      @RequestParam(name = "monthList") List<LocalDateTime> monthList,
      @RequestParam(name = "dateTime", required = false) LocalDateTime dateTime
   ) {
      log.info("API 调用 ：获取可排产单体信息");
      return ResultBuilder.success(new ListVO<>(this.machinePartSchedulingBiz.getMonomerList(projectIds, monthList, dateTime)));
   }

   @ApiOperation("获取可排产区域信息")
   @GetMapping("/area/list")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part:get')")
   public ResultVO getProjectList(
      @RequestParam(name = "projectIds") List<Long> projectIds,
      @RequestParam(name = "monomerIds", required = false) List<Long> monomerIds,
      @RequestParam(name = "monthList") List<LocalDateTime> monthList,
      @RequestParam(name = "dateTime", required = false) LocalDateTime dateTime
   ) {
      log.info("API 调用 ：获取可排产区域信息");
      return ResultBuilder.success(new ListVO<>(this.machinePartSchedulingBiz.getAreaList(projectIds, monomerIds, monthList, dateTime)));
   }

   @ApiOperation("获取可排产材质信息")
   @GetMapping("/material/list")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part:get')")
   public ResultVO getMaterialList(
      @RequestParam(name = "projectIds", required = false) List<Long> projectIds,
      @RequestParam(name = "monomerIds", required = false) List<Long> monomerIds,
      @RequestParam(name = "areaIds", required = false) List<Long> areaIds,
      @RequestParam(name = "monthList", required = false) List<LocalDateTime> monthList,
      @RequestParam(name = "dateTime", required = false) LocalDateTime dateTime,
      @RequestParam(name = "taskTypeEnum", required = false) Integer taskTypeEnum,
      @RequestParam(name = "workshopIds", required = false) List<Long> workshopIds,
      @RequestParam(name = "productionLineIds", required = false) List<Long> productionLineIds,
      @RequestParam(name = "groupsIds", required = false) List<Long> groupsIds
   ) {
      log.info("API 调用 ：获取可排产材质信息");
      return ResultBuilder.success(
         new ListVO<>(
            this.machinePartSchedulingBiz
               .getMaterialList(projectIds, monomerIds, areaIds, monthList, dateTime, taskTypeEnum, workshopIds, productionLineIds, groupsIds)
         )
      );
   }

   @ApiOperation("获取可排产零件类型")
   @GetMapping("/type/list")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part:get')")
   public ResultVO getPartTypeList(
      @RequestParam(name = "projectIds", required = false) List<Long> projectIds,
      @RequestParam(name = "monomerIds", required = false) List<Long> monomerIds,
      @RequestParam(name = "areaIds", required = false) List<Long> areaIds,
      @RequestParam(name = "monthList", required = false) List<LocalDateTime> monthList,
      @RequestParam(name = "dateTime", required = false) LocalDateTime dateTime,
      @RequestParam(name = "workshopIds", required = false) List<Long> workshopIds,
      @RequestParam(name = "productionLineIds", required = false) List<Long> productionLineIds,
      @RequestParam(name = "groupsIds", required = false) List<Long> groupsIds
   ) {
      log.info("API 调用 ：获取可排产零件类型");
      return ResultBuilder.success(
         new ListVO<>(
            this.machinePartSchedulingBiz.getPartTypeList(projectIds, monomerIds, areaIds, monthList, dateTime, workshopIds, productionLineIds, groupsIds)
         )
      );
   }

   @ApiOperation("获取可排产厚度信息")
   @GetMapping("/thick/list")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part:get')")
   public ResultVO getThickList(
      @RequestParam(name = "projectIds", required = false) List<Long> projectIds,
      @RequestParam(name = "monomerIds", required = false) List<Long> monomerIds,
      @RequestParam(name = "areaIds", required = false) List<Long> areaIds,
      @RequestParam(name = "monthList", required = false) List<LocalDateTime> monthList,
      @RequestParam(name = "dateTime", required = false) LocalDateTime dateTime,
      @RequestParam(name = "material") String material,
      @RequestParam(name = "taskTypeEnum", required = false) Integer taskTypeEnum,
      @RequestParam(name = "workshopIds", required = false) List<Long> workshopIds,
      @RequestParam(name = "productionLineIds", required = false) List<Long> productionLineIds,
      @RequestParam(name = "groupsIds", required = false) List<Long> groupsIds
   ) {
      log.info("API 调用 ：获取可排产厚度信息");
      return ResultBuilder.success(
         new ListVO<>(
            this.machinePartSchedulingBiz
               .getThickList(projectIds, monomerIds, areaIds, monthList, dateTime, material, taskTypeEnum, workshopIds, productionLineIds, groupsIds)
         )
      );
   }

   @ApiOperation("获取可排产日期")
   @GetMapping("/date/list")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part:get')")
   public ResultVO getDateList(@RequestParam(name = "dateTime") LocalDateTime dateTime) {
      log.info("API 调用 ：获取可排产日期");
      return ResultBuilder.success(new ListVO<>(this.machinePartSchedulingBiz.getDateList(dateTime)));
   }

   @ApiOperation("获取可排产月份")
   @GetMapping("/month/list")
   public ResultVO getMonthList(@RequestParam(name = "workshopId", required = false) Long workshopId) {
      log.info("API 调用 ：获取可排产月份");
      return ResultBuilder.success(new ListVO<>(this.machinePartSchedulingBiz.getMonthList(workshopId)));
   }

   @ApiOperation("获取可排产月份")
   @PostMapping("/month/listTwo")
   public ResultVO getMonthList(@RequestBody WorkshopRequestParam workshopRequestParam) {
      log.info("API 调用 ：获取可排产月份，传参：{}", workshopRequestParam);
      List<Long> workshopIds = workshopRequestParam.getWorkshopIds();
      new ArrayList();
      List steelPlateTypeEnum;
      if (null == workshopRequestParam.getSteelPlateTypeEnum()) {
         steelPlateTypeEnum = Arrays.asList(SteelPlateTypeEnum.PRIMARY_MEMBER.getType(), SteelPlateTypeEnum.SECONDARY_MEMBER.getType());
      } else {
         steelPlateTypeEnum = workshopRequestParam.getSteelPlateTypeEnum();
      }

      return ResultBuilder.success(
         new ListVO<>(this.machinePartSchedulingBiz.getMonthListTwo(workshopIds, steelPlateTypeEnum, workshopRequestParam.getSendStatus()))
      );
   }

   @ApiOperation("删除零件排产")
   @DeleteMapping("")
   public ResultVO removeList(@RequestBody List<Long> ids) {
      log.info("API 调用 ：删除零件排产");
      return ResultBuilder.success(this.machinePartSchedulingBiz.removeList(ids));
   }

   @ApiOperation("删除零件排产详情")
   @DeleteMapping("/detail/{id}")
   public ResultVO removeDetail(@PathVariable(name = "id") Long id) {
      log.info("API 调用 ：删除零件排产详情");
      return ResultBuilder.success(this.machinePartSchedulingBiz.removeDetail(id));
   }

   @ApiOperation("排产零件套料下发")
   @PostMapping("/nesting")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part_record:save')")
   public ResultVO saveMachinePartNestingIssued(@RequestBody List<MesBuildingMachinePartNestingSaveVORequest> requests) {
      log.info("API 调用 ：排产零件套料下发");
      return ResultBuilder.success(
         this.machinePartSchedulingBiz
            .saveMachinePartNestingIssued(
               requests.stream().map(e -> BeanUtil.copy(e, MesBuildingMachinePartNestingDTOParam.class)).collect(Collectors.toList())
            )
      );
   }

   @ApiOperation("获取可排产的切割任务单")
   @GetMapping("/task/list")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part_nesting_result:get','mes_scheduling_machine_part_nesting_result:del')")
   public ResultVO getMachinePartTaskIssuedList(LocalDateTime date, Boolean boolNestCutEnum, Integer issueStatusEnum, Long projectId) {
      log.info("API 调用 ：获取可排产的切割任务单");
      return ResultBuilder.success(new ListVO<>(this.machinePartSchedulingBiz.getMachinePartTaskIssuedList(date, boolNestCutEnum, issueStatusEnum, projectId)));
   }

   @ApiOperation("获取可排产的切割任务单")
   @GetMapping("/task/page")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part_nesting_result:get','mes_scheduling_machine_part_nesting_result:del')")
   public ResultVO getMachinePartTaskIssued(
      LocalDateTime date,
      Boolean boolNestCutEnum,
      Integer issueStatusEnum,
      String orderNumber,
      @RequestParam(name = "projectIds", required = false) List<Long> projectIds,
      @RequestParam(name = "monomerIds", required = false) List<Long> monomerIds,
      @RequestParam(name = "areaIds", required = false) List<Long> areaIds,
      String thick,
      String material,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：获取可排产的切割任务单");
      return ResultBuilder.success(
         this.machinePartSchedulingBiz
            .getMachinePartTaskIssuedPage(
               date, boolNestCutEnum, issueStatusEnum, orderNumber, projectIds, monomerIds, areaIds, thick, material, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("获取套料排产的项目列表")
   @GetMapping("/nest_cut/project/list")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part_nesting_result:get','mes_scheduling_machine_part_nesting_result:del')")
   public ResultVO getNestCutProjectList(LocalDateTime startDate, LocalDateTime endDate, String name, Integer issueStatusEnum) {
      log.info("API 调用 ：获取套料排产的项目列表");
      return ResultBuilder.success(new ListVO<>(this.machinePartSchedulingBiz.getNestCutProjectList(startDate, endDate, name, issueStatusEnum)));
   }

   @ApiOperation("获取可排产的切割任务单详情")
   @GetMapping("/task/{id}")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part_nesting_result:get')")
   public ResultVO getMachinePartTaskIssued(@PathVariable("id") Long id) {
      log.info("API 调用 ：获取可排产的切割任务单详情");
      return ResultBuilder.success(this.machinePartSchedulingBiz.getMachinePartTaskIssuedDetails(id));
   }

   @ApiOperation("获取工单下项目零件分布情况")
   @GetMapping("/project/distribution")
   public ResultVO partDistribution(Long id) {
      log.info("API 调用 ：获取工单下项目零件分布情况");
      return ResultBuilder.success(this.machinePartSchedulingBiz.partDistribution(id));
   }

   @ApiOperation("获取套料任务单PDF")
   @GetMapping("/pdf")
   public void getSchedulingPDF(@RequestParam Long id) {
      log.info("API 调用 ：获取套料任务单PDF");
      this.machinePartSchedulingBiz.getSchedulingPDF(id);
   }

   @ApiOperation("下载排产信息压缩包")
   @GetMapping("/download/file")
   public void downloadSchedulingFile(Long id) {
      log.info("API 调用 ：下载排产信息压缩包");
      this.machinePartSchedulingBiz.downloadSchedulingFile(id);
   }

   @ApiOperation("下载线下套料数据文件压缩包")
   @GetMapping("/download/off_line/file")
   public void downloadOffLineSchedulingFile(Long id) {
      log.info("API 调用 ：下载线下套料数据文件压缩包");
      this.machinePartSchedulingBiz.downloadOffLineSchedulingFile(id);
   }

   @ApiOperation("添加不排产零件")
   @PostMapping("/un_production")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part:unProductDel')")
   public ResultVO saveUnProduction(@RequestBody List<MachinePartUnProductionSaveVORequest> voRequestList) {
      log.info("API 调用 ：添加不排产零件");
      return ResultBuilder.success(
         this.unProductionBiz
            .saveUnProduction(
               voRequestList.stream().map(voRequest -> BeanUtil.copy(voRequest, MachinePartSchedulingUnProductionParam.class)).collect(Collectors.toList())
            )
      );
   }

   @ApiOperation("获取不排产零件列表")
   @GetMapping("/un_production/page")
   public ResultVO getUnProductionPage(
      @RequestParam(name = "projectId", required = false) Long projectId,
      @RequestParam(name = "monomerId", required = false) Long monomerId,
      @RequestParam(name = "areaIds", required = false) Long areaId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "productionLineId", required = false) Long productionLineId,
      @RequestParam(name = "groupsId", required = false) Long groupsId,
      @RequestParam(name = "artifactSerialNumber", required = false) String artifactSerialNumber,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：获取不排产零件列表");
      return ResultBuilder.success(
         this.unProductionBiz
            .getUnProductionPage(projectId, monomerId, areaId, workshopId, productionLineId, groupsId, artifactSerialNumber, serialNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("修改不排产零件")
   @PutMapping("/un_production")
   @PreAuthorize("@permission.check('mes_scheduling_machine_part:unProductDelRecord')")
   public ResultVO updateUnProduction(@RequestBody MachinePartUnProductionUpdateVORequest request) {
      log.info("API 调用 ：修改不排产零件");
      return ResultBuilder.success(this.unProductionBiz.updateUnProduction(request.getId(), request.getQuantity()));
   }

   @ApiOperation("根据id获取需排产零件详情")
   @GetMapping("/need/detail")
   public ResultVO getNeedDetail(@RequestParam("ids") List<Long> ids) {
      log.info("API 调用 ：根据id获取需排产零件详情");
      return ResultBuilder.success(new ListVO<>(this.machinePartSchedulingBiz.getNeedDetailByIds(ids)));
   }

   @ApiOperation("零件任务工单撤回")
   @DeleteMapping("/task_order/revoke/{id}")
   @SignerCheck(lockKey = "#id", message = "该零件工单正在撤回中,请稍后刷新重试!")
   public ResultVO artifactTaskOrderRevoke(@PathVariable(name = "id") Long id) {
      log.info("API 调用 ：零件任务工单撤回");
      return ResultBuilder.success(this.machinePartSchedulingBiz.partTaskOrderRevoke(id));
   }
}
