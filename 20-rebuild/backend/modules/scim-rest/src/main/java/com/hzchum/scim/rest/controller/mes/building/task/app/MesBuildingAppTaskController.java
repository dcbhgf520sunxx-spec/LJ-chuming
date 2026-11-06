package com.hzchum.scim.rest.controller.mes.building.task.app;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.mes.building.core.api.biz.scheduling.MesBuildingNestCutPlateBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingNewTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskFastBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTask;
import com.hzchum.scim.mes.building.core.api.pojo._dto.report.AssNumberArtNumberLinkDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.AppTaskProcessDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingProduceTeamReportDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.task.post.MachinePartReportSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.task.post.MachinePlateBindingSaveVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.task.post.ReportSaveVORequest;
import com.hzchum.scim.wms.core.api.manager.PickingApproveOutboundMesManger;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.MaterialConfig;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPickingApproveDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-MES任务")
@RestController
@RequestMapping("/api/app/mes/building/task")
public class MesBuildingAppTaskController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingAppTaskController.class);
   @Autowired
   private MesBuildingTaskBiz taskBiz;
   @Autowired
   private MesBuildingTaskFastBiz mesBuildingTaskFastBiz;
   @Autowired
   private MesBuildingNestCutPlateBiz cutPlateBiz;
   @Autowired
   private MesBuildingNewTaskBiz newTaskBiz;
   @Autowired
   private PickingApproveOutboundMesManger pickingApproveOutboundMesManger;
   @Resource
   private BasicConfigService basicConfigService;

   @ApiOperation("用户获取任务工单分页列表")
   @GetMapping("/task_order/page")
   @PreAuthorize("@permission.check('machinePartManufacture','artifactManufacture','assembleManufacture')")
   public ResultVO taskOrderPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer taskTypeEnum,
      String serialNumber,
      String orderNumber,
      @RequestParam(name = "boolLastProcessEnum", required = false, defaultValue = "0") Integer boolLastProcessEnum,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：用户获取任务工单分页列表");
      Preconditions.checkArgument(taskTypeEnum != null, "taskTypeEnum不能为空");
      return ResultBuilder.success(
         this.taskBiz.taskOrderPage(projectId, monomerId, areaId, taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum, sort, pageNumber, pageSize)
      );
   }

   @ApiOperation("(新)用户获取任务工单分页列表")
   @GetMapping("/v2/task_order/page")
   @PreAuthorize(
      "@permission.check('machinePartManufacture','artifactManufacture','assembleManufacture','machinePartManufactureAV2','artifactManufactureAV2','assembleManufactureAV2')"
   )
   public ResultVO taskOrderPage2(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Integer taskTypeEnum,
      String serialNumber,
      String orderNumber,
      @RequestParam(name = "boolLastProcessEnum", required = false, defaultValue = "0") Integer boolLastProcessEnum,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：(新)用户获取任务工单分页列表");
      Preconditions.checkArgument(taskTypeEnum != null, "taskTypeEnum不能为空");
      return ResultBuilder.success(
         this.taskBiz
            .taskOrderPage2(projectId, monomerId, areaId, areaBatchId, taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum, sort, pageNumber, pageSize)
      );
   }

   @ApiOperation("用户根据任务工单获取产品类型汇总")
   @GetMapping("/task_order/{id}/task/classType/summary")
   @PreAuthorize("@permission.check('artifactManufacture','assembleManufacture')")
   public ResultVO productTypeByTaskOrderId(
      Integer taskTypeEnum,
      @PathVariable("id") Long taskOrderId,
      @RequestParam(name = "boolLastProcessEnum", required = false, defaultValue = "0") Integer boolLastProcessEnum
   ) {
      log.info("API 调用 ：用户根据任务工单获取产品类型汇总");
      return ResultBuilder.success(this.taskBiz.productTypeByTaskOrderId(taskTypeEnum, taskOrderId, boolLastProcessEnum));
   }

   @ApiOperation("(新)用户根据任务工单获取产品类型汇总")
   @GetMapping("/v2/task_order/{id}/task/classType/summary")
   @PreAuthorize("@permission.check('artifactManufacture','assembleManufacture','artifactManufactureAV2','assembleManufactureAV2')")
   public ResultVO productTypeByTaskOrderId2(
      Integer taskTypeEnum,
      @PathVariable("id") Long taskOrderId,
      @RequestParam(name = "boolLastProcessEnum", required = false, defaultValue = "0") Integer boolLastProcessEnum
   ) {
      log.info("API 调用 ：(新)用户根据任务工单获取产品类型汇总");
      return ResultBuilder.success(this.newTaskBiz.productTypeByTaskOrderId2(taskTypeEnum, taskOrderId, boolLastProcessEnum));
   }

   @ApiOperation("用户根据任务工单获取任务列表")
   @GetMapping("/task_order/{id}/task/page")
   @PreAuthorize("@permission.check('artifactManufacture','assembleManufacture')")
   public ResultVO pageProductTaskByTaskOrderId(
      Integer taskTypeEnum,
      Long monomerId,
      Long areaId,
      Long classId,
      String serialNumber,
      @PathVariable("id") Long taskOrderId,
      @RequestParam(name = "boolLastProcessEnum", required = false, defaultValue = "0") Integer boolLastProcessEnum,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：用户根据任务工单获取任务列表");
      return ResultBuilder.success(
         this.taskBiz
            .pageProductTaskByTaskOrderId(taskTypeEnum, monomerId, areaId, classId, serialNumber, taskOrderId, boolLastProcessEnum, pageNumber, pageSize)
      );
   }

   @ApiOperation("用户根据任务工单获取任务列表")
   @GetMapping("/v2/task_order/{id}/task/page")
   @PreAuthorize("@permission.check('artifactManufacture','assembleManufacture','artifactManufactureAV2','assembleManufactureAV2')")
   public ResultVO pageProductTaskByTaskOrderId2(
      Integer taskTypeEnum,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long classId,
      Long processId,
      String specification,
      String serialNumber,
      @PathVariable("id") Long taskOrderId,
      @RequestParam(name = "reportType", required = false, defaultValue = "0") Integer reportType,
      @RequestParam(name = "boolLastProcessEnum", required = false, defaultValue = "0") Integer boolLastProcessEnum,
      @RequestParam(name = "boolMissingParts", required = false) Boolean boolMissingParts,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：用户根据任务工单获取任务列表");
      return ResultBuilder.success(
         this.taskBiz
            .pageProductTaskByTaskOrderId2(
               taskTypeEnum,
               projectId,
               monomerId,
               areaId,
               areaBatchId,
               classId,
               processId,
               specification,
               serialNumber,
               taskOrderId,
               boolLastProcessEnum,
               boolMissingParts,
               reportType,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("查询码号上一道工序上报时间、上报人")
   @GetMapping("/lastProcess/{id}")
   @PreAuthorize("@permission.check('artifactManufacture','assembleManufacture','artifactManufactureAV2','assembleManufactureAV2')")
   public ResultVO lastProcessInfo(@PathVariable("id") Long taskProcessId) {
      log.info("API 调用 ：查询码号上一道工序上报时间、上报人");
      return ResultBuilder.success(this.newTaskBiz.lastProcessInfo(taskProcessId));
   }

   @ApiOperation("获取协同任务列表")
   @GetMapping("/assist/task/page")
   @PreAuthorize("@permission.check('artifactCoordination','assembleCoordination')")
   public ResultVO pageProductAssistTask(
      Integer taskTypeEnum,
      Long taskId,
      Long monomerId,
      Long projectId,
      Long areaId,
      Long areaBatchId,
      String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：获取协同任务列表");
      return ResultBuilder.success(
         this.taskBiz.pageProductAssistTask(taskTypeEnum, taskId, projectId, monomerId, areaId, areaBatchId, serialNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("获取协同任务列表")
   @GetMapping("v2/assist/task/page")
   @PreAuthorize("@permission.check('artifactCoordination','assembleCoordination','artifactCoordinationAV2','assembleCoordinationAV2')")
   public ResultVO pageProductAssistTask2(
      Integer taskTypeEnum,
      Long taskId,
      Long monomerId,
      Long projectId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      String serialNumber,
      @RequestParam(name = "reportType", required = false, defaultValue = "0") Integer reportType,
      @RequestParam(name = "boolLastProcessEnum", required = false, defaultValue = "0") Integer boolLastProcessEnum,
      @RequestParam(name = "boolMissingParts", required = false) Boolean boolMissingParts,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：获取协同任务列表");
      return ResultBuilder.success(
         this.taskBiz
            .pageProductAssistTask2(
               taskTypeEnum,
               taskId,
               projectId,
               monomerId,
               areaId,
               areaBatchId,
               processId,
               serialNumber,
               boolLastProcessEnum,
               boolMissingParts,
               reportType,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("用户根据任务id获取任务列表")
   @GetMapping("/task/{id}/task_process")
   @PreAuthorize("@permission.check('artifactManufactureAV2','assembleManufactureAV2')")
   public ResultVO listTaskProcessByTaskId(
      @PathVariable(name = "id") Long taskId, @RequestParam(name = "boolLastProcessEnum", required = false, defaultValue = "0") Integer boolLastProcessEnum
   ) {
      log.info("API 调用 ：用户根据任务id获取任务列表");
      return ResultBuilder.success(new ListVO<>(this.taskBiz.listTaskProcessByTaskId(taskId, boolLastProcessEnum)));
   }

   @ApiOperation("用户根据任务id获取任务列表")
   @GetMapping("/{taskId}/task_process")
   public ResultVO listProductTaskByTaskId(
      @PathVariable("taskId") Long taskId, @RequestParam(name = "boolLastProcessEnum", required = false, defaultValue = "0") Integer boolLastProcessEnum
   ) {
      log.info("API 调用 ：用户根据任务id获取任务列表");
      return ResultBuilder.success(new ListVO<>(this.taskBiz.listProductTaskByTaskId(taskId, boolLastProcessEnum)));
   }

   @ApiOperation("用户根据任务工单获取任务详情")
   @GetMapping("/{id}/details")
   @PreAuthorize("@permission.check('artifactCoordination','assembleCoordination','artifactManufacture','assembleManufacture')")
   public ResultVO taskProcessDetails(@PathVariable("id") Long id, Boolean boolAssist, Long assistGroupId) {
      log.info("API 调用 ：用户根据任务工单获取任务详情");
      return ResultBuilder.success(this.taskBiz.taskProcessDetails(id, boolAssist, assistGroupId));
   }

   @ApiOperation("用户根据任务工单和产品码号获取任务详情")
   @GetMapping("/productNumber/details")
   public ResultVO productNumberDetails(
      @ApiParam(value = "任务ID", required = true) @RequestParam Long taskProcessId, @ApiParam("码号") @RequestParam(required = false) Integer productNumber
   ) {
      log.info("API 调用 ：用户根据任务工单和码号获取任务详情");
      return ResultBuilder.success(this.taskBiz.productNumberDetails(taskProcessId, productNumber));
   }

   @ApiOperation("用户根据任务工单获取任务详情")
   @GetMapping("/v2/{id}/details")
   @PreAuthorize(
      "@permission.check('artifactCoordination','assembleCoordination','artifactManufacture','assembleManufacture','artifactCoordinationAV2','assembleCoordinationAV2','artifactManufactureAV2','assembleManufactureAV2')"
   )
   public ResultVO taskProcessDetails2(@PathVariable("id") Long id, Boolean boolAssist, Long assistLineId) {
      log.info("API 调用 ：用户根据任务工单获取任务详情");
      return ResultBuilder.success(this.taskBiz.taskProcessDetails2(id, boolAssist, assistLineId, null));
   }

   @ApiOperation(value = "查询上报部件码号关联构件码号", notes = "查询上报部件码号关联构件码号")
   @GetMapping("/app/numberlink")
   public ResultVO<List<AssNumberArtNumberLinkDTO>> getAssembleNumberLink(
      @RequestParam(required = false) Integer assId, @RequestParam(required = false) List<Integer> assembleNumbers
   ) {
      log.info("app端 Api调用: 查询上报部件码号关联构件码号");
      return ResultBuilder.success(this.newTaskBiz.getAssembleNumberLink(assId, assembleNumbers));
   }

   @ApiOperation("根据任务工序id获取缺件信息")
   @GetMapping("/{id}/missing")
   @PreAuthorize("@permission.check('artifactCoordination','assembleCoordination','artifactManufacture','assembleManufacture')")
   public ResultVO taskProcessMissingDetails(@PathVariable("id") Long id, Boolean boolAssist, Long assistGroupId) {
      log.info("API 调用 ：根据任务工序id获取缺件信息");
      return ResultBuilder.success(new ListVO<>(this.taskBiz.taskProcessMissingDetails(id, boolAssist, assistGroupId)));
   }

   @ApiOperation("根据任务工序id获取缺件信息")
   @GetMapping("/v2/{id}/missing")
   @PreAuthorize("@permission.check('artifactCoordinationAV2','assembleCoordinationAV2','artifactManufactureAV2','assembleManufactureAV2')")
   public ResultVO taskProcessMissingDetails2(@PathVariable("id") Long id, Boolean boolAssist, Long assistLineId) {
      log.info("API 调用 ：根据任务工序id获取缺件信息");
      return ResultBuilder.success(new ListVO<>(this.taskBiz.taskProcessMissingDetails2(id, boolAssist, assistLineId)));
   }

   @ApiOperation("用户获取零件任务工单项目列表")
   @GetMapping("/task_order/project")
   public ResultVO taskOrderProjectList() {
      log.info("API 调用 ：用户获取任务工单项目列表");
      return ResultBuilder.success(this.taskBiz.taskOrderProjectList());
   }

   @ApiOperation("用户获取钻孔任务工单分页列表")
   @GetMapping("/drill/task_order/page")
   @PreAuthorize("@permission.check('machinePartDrillHole')")
   public ResultVO drillTaskOrderPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      String orderNumber,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：用户获取钻孔任务工单分页列表");
      return ResultBuilder.success(this.taskBiz.drillTaskOrderPage(projectId, monomerId, areaId, orderNumber, sort, pageNumber, pageSize));
   }

   @ApiOperation("用户获取钻孔任务工单项目列表")
   @GetMapping("/drill/task_order/project")
   public ResultVO drillTaskOrderProjectList() {
      log.info("API 调用 ：用户获取钻孔任务工单项目列表");
      return ResultBuilder.success(this.taskBiz.drillTaskOrderProjectList());
   }

   @ApiOperation("用户根据任务工单获取钻孔任务列表")
   @GetMapping("/drill/task_order/{id}/task/list")
   @PreAuthorize("@permission.check('machinePartDrillHole')")
   public ResultVO listDrillTaskByNestCutPlateId(@PathVariable("id") Long nestCutPlateId) {
      log.info("API 调用 ：用户根据任务工单获取钻孔任务列表");
      return ResultBuilder.success(new ListVO<>(this.taskBiz.listDrillTaskByNestCutPlateId(nestCutPlateId)));
   }

   @ApiOperation("用户获取任务工单下的切割指令单")
   @GetMapping("/task_order/{taskOrderId}/nest_part")
   @PreAuthorize("@permission.check('machinePartManufacture')")
   public ResultVO taskOrderNestPartList(@PathVariable(name = "taskOrderId") Long taskOrderId) {
      log.info("用户获取任务工单下的切割指令单");
      return ResultBuilder.success(new ListVO<>(this.taskBiz.taskOrderNestPartList(taskOrderId)));
   }

   @ApiOperation("用户获取钻孔任务工单下的切割指令单")
   @GetMapping("/drill/task_order/{taskOrderId}/nest_part")
   @PreAuthorize("@permission.check('machinePartDrillHole')")
   public ResultVO getDrillTaskOrderNestPartList(@PathVariable(name = "taskOrderId") Long taskOrderId) {
      log.info("用户获取钻孔任务工单下的切割指令单");
      return ResultBuilder.success(new ListVO<>(this.taskBiz.getDrillTaskOrderNestPartList(taskOrderId)));
   }

   @ApiOperation("获取零件原料列表")
   @GetMapping("get-machine-part-raw-material-list")
   public ResultVO getMachinePartRawMaterialList(QueryPickingApproveDetailDTOParam param) {
      log.info("API 调用 ：获取零件原料列表");
      MaterialConfig inventoryTypeConfig = this.basicConfigService.getInventoryTypeConfig();
      if (inventoryTypeConfig.getInventoryGainType().equals(2)) {
         return ResultBuilder.success(new ListVO());
      }

      Preconditions.checkArgument(this.pickingApproveOutboundMesManger.boolComplete(param.getTaskOrderId()), "对应工单钢材未办理出库，暂时不能生产");
      param.setBoolProcess(false);
      return ResultBuilder.success(new ListVO<>(this.pickingApproveOutboundMesManger.getPickingApproveDetail(param)));
   }

   @ApiOperation("切割指令批量上报")
   @PostMapping("/produce/report/nest_cut_plate")
   @SignerCheck(lockKey = "#saveVORequest.nestCutPlateId", message = "该任务正在上报中,请稍后刷新重试!", timeout = 600L)
   public ResultVO saveNestCutPlateReport(@RequestBody @Validated MachinePartReportSaveVORequest saveVORequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：切割指令批量上报");
      return ResultBuilder.success(
         this.mesBuildingTaskFastBiz
            .saveNestCutPlateReportFast(
               saveVORequest.getNestCutPlateId(),
               saveVORequest.getPartIds(),
               saveVORequest.getNcCode(),
               saveVORequest.getReportType(),
               saveVORequest.getParts(),
               null,
               saveVORequest.getRawMaterialList()
            )
      );
   }

   @ApiOperation("钻孔指令批量上报")
   @PostMapping("/drill/produce/report/nest_cut_plate")
   @SignerCheck(lockKey = "#saveVORequest.nestCutPlateId", message = "该任务正在上报中,请稍后刷新重试!", timeout = 600L)
   public ResultVO saveDrillNestCutPlateReport(@RequestBody @Validated MachinePartReportSaveVORequest saveVORequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：切割指令批量上报");
      return ResultBuilder.success(
         this.mesBuildingTaskFastBiz
            .saveDrillNestCutPlateReportFast(saveVORequest.getNestCutPlateId(), saveVORequest.getParts(), saveVORequest.getReportType(), null)
      );
   }

   @ApiOperation("钢板绑定")
   @PostMapping("/plate/binding")
   @PreAuthorize("@permission.check('machinePartManufacture')")
   public ResultVO savePlateBinding(@RequestBody MachinePlateBindingSaveVORequest request) {
      log.info("API 调用 ：钢板绑定");
      return ResultBuilder.success(this.cutPlateBiz.savePlateBinding(request.getNestCutPlateId(), request.getBarcode()));
   }

   @ApiOperation("钢板绑定列表")
   @GetMapping("/plate/binding")
   @PreAuthorize("@permission.check('machinePartManufacture')")
   public ResultVO savePlateBinding(Long id) {
      log.info("API 调用 ：钢板绑定");
      return ResultBuilder.success(this.cutPlateBiz.getPlateBindingLinkList(id));
   }

   @ApiOperation("删除绑定的钢板")
   @DeleteMapping("")
   public ResultVO deletePlateBinding(List<Long> bindingIds) {
      log.info("API 调用 ：删除绑定的钢板");
      return ResultBuilder.success(this.cutPlateBiz.deletePlateBinding(bindingIds));
   }

   @ApiOperation("新增生产记录")
   @PostMapping("/produce/report")
   @PreAuthorize("@permission.check('artifactCoordination','assembleCoordination','artifactManufacture','assembleManufacture')")
   public ResultVO saveProduceTeamReport(@RequestBody @Validated ReportSaveVORequest saveVORequest, BindingResult result) {
      if (result.hasErrors()) {
         throw new BusinessException(ResultCodeEnum.PARAMETER_MISSING, result.getFieldError().getDefaultMessage());
      }

      log.info("API 调用 ：新增生产记录");
      return ResultBuilder.success(new ListVO<>(this.taskBiz.saveProduceTeamReport(BeanUtil.copy(saveVORequest, MesBuildingProduceTeamReportDTOParam.class))));
   }

   @ApiOperation("新增生产记录")
   @PostMapping("/v2/produce/report")
   @SignerCheck(lockKey = "#saveVORequest.id", message = "当前任务正在处理中,请勿重复提交!")
   @PreAuthorize(
      "@permission.check('artifactCoordination','assembleCoordination','artifactManufacture','assembleManufacture','artifactCoordinationAV2','assembleCoordinationAV2','artifactManufactureAV2','assembleManufactureAV2')"
   )
   public ResultVO saveProduceTeamReport2(@RequestBody @Validated ReportSaveVORequest saveVORequest) {
      log.info("API 调用 ：新增生产记录");
      return ResultBuilder.success(
         new ListVO<>(this.newTaskBiz.saveProduceTeamReport2(BeanUtil.copy(saveVORequest, MesBuildingProduceTeamReportDTOParam.class)))
      );
   }

   @ApiOperation("用户获取质检任务列表")
   @GetMapping("/product_task/inspection/page")
   public ResultVO listProductTaskInspection(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String productName,
      Long taskId,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：用户获取质检任务列表");
      Preconditions.checkArgument(taskTypeEnum != null, "taskTypeEnum不能为空");
      return ResultBuilder.success(
         this.taskBiz
            .productTaskInspectionPage3(
               projectId, monomerId, areaId, null, processId, taskTypeEnum, serialNumber, productName, taskId, null, sort, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("(新)用户获取质检任务列表")
   @GetMapping("/v2/product_task/inspection/page")
   public ResultVO listProductTaskInspection2(
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      Long processId,
      Integer taskTypeEnum,
      String serialNumber,
      String productName,
      Long taskId,
      @RequestParam(name = "reportType", required = false, defaultValue = "0") Integer reportType,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：(新)用户获取质检任务列表");
      Preconditions.checkArgument(taskTypeEnum != null, "taskTypeEnum不能为空");
      return ResultBuilder.success(
         this.taskBiz
            .productTaskInspectionPage3(
               projectId, monomerId, areaId, areaBatchId, processId, taskTypeEnum, serialNumber, productName, taskId, reportType, sort, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("月度任务跟踪--按月分组")
   @GetMapping("/tracking/month")
   @PreAuthorize("@permission.check('workshopTaskTrance')")
   public ResultVO taskTrackingMonth(LocalDateTime dateTime, Long workShopId, Long productionLineId) {
      log.info("API 调用 ：月度任务跟踪--按月分组");
      return ResultBuilder.success(this.taskBiz.taskTrackingMonth(dateTime, workShopId, productionLineId));
   }

   @ApiOperation("获取某月的任务跟踪列表-分页")
   @GetMapping("/tracking/month/page")
   @PreAuthorize("@permission.check('workshopTaskTrance')")
   public ResultVO taskTrackingMonthPage(
      LocalDateTime dateTime,
      Long workShopId,
      Long productionLineId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取某月的任务跟踪列表-分页");
      return ResultBuilder.success(this.taskBiz.taskTrackingMonthPage(dateTime, workShopId, productionLineId, pageNumber, pageSize));
   }

   @ApiOperation("获取某月某个项目的任务跟踪列表-分页")
   @GetMapping("/tracking/month/project/page")
   public ResultVO taskTrackingMonthProjectPage(
      LocalDateTime dateTime,
      Long projectId,
      Long monomerId,
      Long areaId,
      String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取某月某个项目的任务跟踪列表-分页");
      return ResultBuilder.success(
         this.taskBiz.taskTrackingMonthProjectPage(dateTime, null, null, projectId, monomerId, areaId, serialNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("获取某月某个项目的任务跟踪列表汇总")
   @GetMapping("/tracking/month/project/summary")
   @PreAuthorize("@permission.check('workshopTaskTrance')")
   public ResultVO taskTrackingMonthProjectSummary(LocalDateTime dateTime, Long projectId, Long monomerId, Long areaId, String serialNumber) {
      log.info("API 调用 ：获取某月某个项目的任务跟踪列表汇总");
      return ResultBuilder.success(this.taskBiz.taskTrackingMonthProjectSummary(dateTime, projectId, monomerId, areaId, serialNumber));
   }

   @ApiOperation("产线列表")
   @GetMapping("/tracking/productionLine")
   @PreAuthorize("@permission.check('productionLineSummary')")
   public ResultVO taskProductionLineList(LocalDateTime startTime, LocalDateTime endTime, Integer productType, Integer type, Long processId) {
      log.info("API 调用 ：产线列表");
      return ResultBuilder.success(this.taskBiz.taskProductionLineList(startTime, endTime, productType, type, processId));
   }

   @ApiOperation("依据切割指令获取零件信息")
   @GetMapping("/cut/task_order/{id}/task/list")
   public ResultVO<ListVO<AppTaskProcessDTO>> getMachinePartListByCutId(
      @PathVariable("id") Long cutId, Long projectId, Long monomerId, Long areaId, String serialNumber
   ) {
      log.info("API 调用 ：依据切割指令获取零件信息");
      return ResultBuilder.success(new ListVO<>(this.taskBiz.getMachinePartListByCutId(cutId, projectId, monomerId, areaId, serialNumber)));
   }

   @ApiOperation("依据切割指令获取零件信息")
   @GetMapping("/test")
   public ResultVO<Map<Long, Integer>> test(Long id) {
      log.info("API 调用 ：依据切割指令获取零件信息");
      List<MesBuildingTask> taskList = this.taskBiz.listByIds(Collections.singleton(id));
      return ResultBuilder.success(this.taskBiz.minKitting(taskList));
   }
}
