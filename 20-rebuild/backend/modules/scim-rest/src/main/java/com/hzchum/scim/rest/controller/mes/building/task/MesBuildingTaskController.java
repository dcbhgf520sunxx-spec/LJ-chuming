package com.hzchum.scim.rest.controller.mes.building.task;

import cn.hutool.json.JSONUtil;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingNewTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.scheduling.MesBuildingArtifactSchedulingParam;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.InspectionReportSavedDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.BatchInspectDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.team.BatchReportDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingProduceTeamReportDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.task.post.MachinePartReportSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.task.post.ReportSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.task.put.TaskProcessRevokeVORequest;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
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

@Api(tags = "MES任务")
@RestController
@RequestMapping("/api/mes/building/task")
public class MesBuildingTaskController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingTaskController.class);
   @Autowired
   private MesBuildingTaskBiz mesBuildingTaskBiz;
   @Autowired
   private MesBuildingNewTaskBiz newTaskBiz;

   @ApiOperation("用户获取任务列表")
   @GetMapping("/product_task")
   public ResultVO listProductTask(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String specification,
      String material,
      Long taskOrderId,
      Boolean boolCompleteEnum
   ) {
      log.info("API 调用 ：用户获取任务列表");
      Preconditions.checkArgument(taskTypeEnum != null, "taskTypeEnum不能为空");
      return ResultBuilder.success(
         new ListVO<>(
            this.mesBuildingTaskBiz
               .listProductTask(projectId, monomerId, areaId, processId, taskTypeEnum, serialNumber, specification, material, taskOrderId, boolCompleteEnum)
         )
      );
   }

   @ApiOperation("用户获取任务分页列表")
   @GetMapping("/product_task/page")
   public ResultVO productTaskPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      @RequestParam(required = false) String serialNumber,
      String specification,
      String material,
      Long taskOrderId,
      @RequestParam(required = false) String productionLineName,
      @RequestParam(required = false) String productName,
      @RequestParam(name = "boolCompleteEnum", defaultValue = "0") Boolean boolCompleteEnum,
      @RequestParam(required = false) List<LocalDateTime> dateTimeList,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：用户获取任务分页列表");
      Preconditions.checkArgument(taskTypeEnum != null, "taskTypeEnum不能为空");
      return ResultBuilder.success(
         this.mesBuildingTaskBiz
            .newProductTaskPage(
               projectId,
               monomerId,
               areaId,
               processId,
               taskTypeEnum,
               serialNumber,
               specification,
               material,
               taskOrderId,
               productionLineName,
               productName,
               boolCompleteEnum,
               dateTimeList,
               sort,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("构件任务撤回")
   @DeleteMapping("/task/revoke")
   @PreAuthorize("@permission.check('mes_work_order_artifact:batchRevoke') or (#taskIdList != null and #taskIdList.size() == 1 and @permission.check('mes_work_order_artifact:revoke'))")
   public ResultVO artifactTaskRevoke(@RequestBody List<Long> taskIdList) {
      log.info("API 调用 ：构件任务撤回");
      return ResultBuilder.success(this.mesBuildingTaskBiz.artifactTaskRevoke(taskIdList));
   }

   @ApiOperation("构件任务工单撤回")
   @DeleteMapping("/task_order/revoke/{id}")
   @PreAuthorize("@permission.check('mes_work_order_artifact:allRevoke')")
   public ResultVO artifactTaskOrderRevoke(@PathVariable(name = "id") Long id) {
      log.info("API 调用 ：构件任务工单撤回");
      return ResultBuilder.success(this.mesBuildingTaskBiz.artifactTaskOrderRevoke(id));
   }

   @ApiOperation("用户获取构件任务一物一码分页列表")
   @GetMapping("/product_task/artifact/list")
   public ResultVO artifactTaskPage(Long taskProcessId, Long number) {
      log.info("API 调用 ：用户获取构件任务一物一码分页列表");
      return ResultBuilder.success(new ListVO<>(this.mesBuildingTaskBiz.artifactTaskList(taskProcessId, number)));
   }

   @ApiOperation("用户获取任务类型汇总")
   @GetMapping("/product_task/summary")
   public ResultVO listProductTask() {
      log.info("API 调用 ：用户获取任务类型汇总");
      return ResultBuilder.success(this.mesBuildingTaskBiz.listProductTaskCount2(UserUtil.getCurrentUserId()));
   }

   @ApiOperation("用户获取构件任务一物一码质检分页列表")
   @GetMapping("/product_task/artifact/inspection/list")
   public ResultVO artifactInspectionTaskPage(Long taskProcessId, Long number, Long teamId) {
      log.info("API 调用 ：用户获取构件任务一物一码质检分页列表");
      return ResultBuilder.success(new ListVO<>(this.mesBuildingTaskBiz.artifactInspectionTaskList(taskProcessId, number, teamId)));
   }

   @ApiOperation("新增生产记录")
   @PostMapping("/produce/report")
   public ResultVO saveProduceTeamReport(@RequestBody @Validated ReportSaveVORequest saveVORequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：新增生产记录");
      return ResultBuilder.success(
         new ListVO<>(this.mesBuildingTaskBiz.saveProduceTeamReport(BeanUtil.copy(saveVORequest, MesBuildingProduceTeamReportDTOParam.class)))
      );
   }

   @ApiOperation("新增生产记录")
   @PostMapping("/v2/produce/report")
   public ResultVO saveNewProduceTeamReport(@RequestBody @Validated ReportSaveVORequest saveVORequest) {
      log.info("API 调用 ：新增生产记录，请求参数：{}", JSONUtil.toJsonStr(saveVORequest));
      return ResultBuilder.success(
         new ListVO<>(this.newTaskBiz.saveProduceTeamReport2(BeanUtil.copy(saveVORequest, MesBuildingProduceTeamReportDTOParam.class)))
      );
   }

   @ApiOperation("批量上报")
   @PostMapping("/produce/batch/report")
   @SignerCheck(boolMethodAndClassName = true, timeout = 100L, message = "正在批量上报中,请稍后刷新页面重试")
   public ResultVO revokeTaskPocess(@RequestBody List<BatchReportDTO> dtos) {
      log.info("API 调用 ：批量上报，共{}个任务", dtos.size());
      return ResultBuilder.success(this.newTaskBiz.saveProduceTeamBatchReport(dtos));
   }

   @ApiOperation("新增质检记录_一物一码定制")
   @PostMapping("/save/produce/inspection")
   public ResultVO saveProduceInspection(@RequestBody List<InspectionReportSavedDTO> saveVORequest) {
      log.info("API 调用 ：新增质检记录_一物一码定制");
      return ResultBuilder.success(this.mesBuildingTaskBiz.saveProduceInspection(saveVORequest));
   }

   @ApiOperation("(新)新增质检记录_一物一码定制")
   @PostMapping("/v2/save/produce/inspection")
   @SignerCheck(boolMethodAndClassName = true, timeout = 100L, message = "正在批量上报中,请稍后刷新页面重试")
   public ResultVO saveProduceInspection2(@RequestBody List<InspectionReportSavedDTO> saveVORequest) {
      log.info("API 调用 ：(新)新增质检记录_一物一码定制");
      return ResultBuilder.success(this.newTaskBiz.saveProduceInspection2(saveVORequest));
   }

   @ApiOperation("(新)批量新增质检记录_一物一码定制")
   @PostMapping("inspection/batch/report")
   public ResultVO saveBatchProduceInspection(@RequestBody List<BatchInspectDTO> dtos) {
      log.info("API 调用 ：(新)批量新增质检记录_一物一码定制");
      return ResultBuilder.success(this.newTaskBiz.saveBatchProduceInspection(dtos));
   }

   @ApiOperation("获取含有任务的生产线")
   @GetMapping("/productionLine/hasTask")
   public ResultVO getHasTask(Long projectId, Long monomerId, Long areaId, Long areaBatchId, Integer productType) {
      log.info("API 调用 ：获取含有任务的生产线");
      return ResultBuilder.success(this.mesBuildingTaskBiz.listHasTaskProductionLineId(projectId, monomerId, areaId, areaBatchId, productType));
   }

   @ApiOperation("查询可上报数")
   @GetMapping("/check_quantity")
   public ResultVO checkReportQuantity(@RequestParam(name = "id") Long id) {
      log.info("API 调用 ：查询可上报数");
      return ResultBuilder.success(this.mesBuildingTaskBiz.checkReportQuantity(id));
   }

   @ApiOperation("产品溯源")
   @GetMapping("/source")
   public ResultVO productSource(@RequestParam(name = "id") Long id, @RequestParam(name = "productType") Integer productType) {
      log.info("API 调用 ：产品溯源");
      return ResultBuilder.success(this.mesBuildingTaskBiz.productSource(id, productType));
   }

   @ApiOperation("撤销上报")
   @PutMapping("/revoke")
   @PreAuthorize("@permission.check('artifactCoordinationAV2','assembleCoordinationAV2','artifactManufactureAV2','assembleManufactureAV2')")
   public ResultVO revokeTaskPocess(@RequestBody TaskProcessRevokeVORequest voRequest) {
      log.info("API 调用 ：撤销上报");
      return ResultBuilder.success(this.newTaskBiz.revokeTaskPocess(voRequest.getId()));
   }

   @ApiOperation("用户获取任务工单下的切割指令单")
   @GetMapping("/task_order/nest_part/{taskOrderId}")
   public ResultVO taskOrderNestPartList(Long taskOrderId) {
      log.info("用户获取任务工单下的切割指令单");
      return ResultBuilder.success(new ListVO<>(this.mesBuildingTaskBiz.taskOrderNestPartList(taskOrderId)));
   }

   @ApiOperation("切割指令批量上报")
   @PostMapping("/produce/nest_cut_plate/report")
   @SignerCheck(lockKey = "#saveVORequest.nestCutPlateId", message = "该任务正在上报中,请稍后刷新重试!", timeout = 600L)
   public ResultVO saveNestCutPlateReport(@RequestBody @Validated MachinePartReportSaveVORequest saveVORequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：切割指令批量上报");
      return ResultBuilder.success(
         this.mesBuildingTaskBiz
            .saveNestCutPlateReport(
               saveVORequest.getNestCutPlateId(),
               saveVORequest.getPartIds(),
               saveVORequest.getNcCode(),
               saveVORequest.getReportType(),
               saveVORequest.getParts()
            )
      );
   }

   @ApiOperation("月度任务跟踪--按月分组")
   @GetMapping("/tracking/month")
   @PreAuthorize("@permission.check('mes_monthly_task_tracking:get')")
   public ResultVO taskTrackingMonth(LocalDateTime dateTime, Long workShopId, Long productionLineId) {
      log.info("API 调用 ：月度任务跟踪--按月分组");
      return ResultBuilder.success(this.mesBuildingTaskBiz.taskTrackingMonth(dateTime, workShopId, productionLineId));
   }

   @ApiOperation("获取某月的任务跟踪列表-分页")
   @GetMapping("/tracking/month/page")
   @PreAuthorize("@permission.check('mes_monthly_task_tracking:get')")
   public ResultVO taskTrackingMonthPage(
      LocalDateTime dateTime,
      Long workShopId,
      Long productionLineId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取某月的任务跟踪列表-分页");
      return ResultBuilder.success(this.mesBuildingTaskBiz.taskTrackingMonthPage(dateTime, workShopId, productionLineId, pageNumber, pageSize));
   }

   @ApiOperation("获取某月某个项目的任务跟踪列表-分页")
   @GetMapping("/tracking/month/project/page")
   @PreAuthorize("@permission.check('mes_monthly_task_tracking:get')")
   public ResultVO taskTrackingMonthProjectPage(
      LocalDateTime dateTime,
      Long workShopId,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取某月某个项目的任务跟踪列表-分页");
      return ResultBuilder.success(
         this.mesBuildingTaskBiz
            .taskTrackingMonthProjectPage(dateTime, workShopId, productionLineId, projectId, monomerId, areaId, serialNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("打印某月某个项目的任务跟踪列表")
   @GetMapping("/tracking/month/project/print")
   @PreAuthorize("@permission.check('mes_monthly_task_tracking:print')")
   public ResultVO taskTrackingMonthProjectPrint(
      LocalDateTime dateTime, Long workShopId, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber
   ) {
      log.info("API 调用 ：打印某月某个项目的任务跟踪列表");
      return ResultBuilder.success(
         this.mesBuildingTaskBiz.taskTrackingMonthProjectPrint(dateTime, workShopId, productionLineId, projectId, monomerId, areaId, serialNumber)
      );
   }

   @ApiOperation("产线跟踪列表")
   @GetMapping("/tracking/productionLine")
   @PreAuthorize("@permission.check('mes_production_line_tracking:get')")
   public ResultVO taskTrackProductionLine(LocalDateTime startTime, LocalDateTime endTime, Integer productType, Long workShopId, Long projectId) {
      log.info("API 调用 ：产线跟踪列表");
      return ResultBuilder.success(this.mesBuildingTaskBiz.taskTrackProductionLine(startTime, endTime, productType, workShopId, projectId));
   }

   @ApiOperation("产线跟踪详情列表-分页")
   @GetMapping("/tracking/productionLine/detail/page")
   @PreAuthorize("@permission.check('mes_production_line_tracking:detail')")
   public ResultVO taskTrackProductionLineDetailPage(
      LocalDateTime startTime,
      LocalDateTime endTime,
      Integer taskType,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：产线跟踪详情列表-分页");
      return ResultBuilder.success(
         this.mesBuildingTaskBiz
            .taskTrackProductionLineDetailPage(startTime, endTime, taskType, productionLineId, projectId, monomerId, areaId, serialNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("打印产线跟踪详情列表")
   @GetMapping("/tracking/productionLine/detail/print")
   @PreAuthorize("@permission.check('mes_production_line_tracking:print')")
   public ResultVO taskTrackProductionLineDetailPrint(
      LocalDateTime startTime, LocalDateTime endTime, Integer taskType, Long productionLineId, Long projectId, Long monomerId, Long areaId, String serialNumber
   ) {
      log.info("API 调用 ：打印产线跟踪详情列表");
      return ResultBuilder.success(
         this.mesBuildingTaskBiz.taskTrackProductionLineDetailPrint(startTime, endTime, taskType, productionLineId, projectId, monomerId, areaId, serialNumber)
      );
   }

   @ApiOperation("获取当前车间下的生产线")
   @GetMapping("/workShop/productionLine")
   public ResultVO getProductionLine(Integer productType, Long workShopId) {
      log.info("API 调用 ：获取当前车间下的生产线");
      return ResultBuilder.success(this.mesBuildingTaskBiz.getProductionLine(productType, workShopId));
   }

   @ApiOperation("查询部件产线信息")
   @GetMapping("/assemble/ProdLineSummary")
   public ResultVO findAssembleScheduledSummary(Long workshopId, Long projectId) {
      log.info("API 调用 ：查询部件产线信息");
      return ResultBuilder.success(this.newTaskBiz.findAssembleScheduledSummary(workshopId, projectId));
   }

   @ApiOperation("查询构件未排产信息")
   @GetMapping("/scheduling/ArtifactSummary")
   public ResultVO findSchedulingArtifactSummary(
      Long projectId,
      Long monomerId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：查询构件未排产信息");
      return ResultBuilder.success(this.newTaskBiz.findSchedulingArtifactSummary(projectId, monomerId, pageNumber, pageSize));
   }

   @ApiOperation("查询构件未排产详情信息-分页")
   @GetMapping("/scheduling/ArtifactDetail")
   public ResultVO findSchedulingArtifactDetail(
      MesBuildingArtifactSchedulingParam param,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：查询构件未排产详情信息-分页");
      return ResultBuilder.success(this.newTaskBiz.findSchedulingArtifactDetail(param, pageNumber, pageSize));
   }
}
