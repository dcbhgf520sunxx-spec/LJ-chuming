package com.hzchum.scim.rest.controller.mes.building.scheduling;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.common.core.api.biz.CommonTokenBiz;
import com.hzchum.scim.common.core.api.enums.NestingTaskModeEnum;
import com.hzchum.scim.cut.core.api.biz.NestBiz;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingGroupsBiz;
import com.hzchum.scim.mes.building.core.api.enums.WorkShopTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._dto.nesting.WorkTreeDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPAutoCutSchedulingDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPAutoCutSchedulingDetail;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory.MesBuildingGroupsDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.BatchSchedulingOutboundDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.BatchSchedulingOutboundDetailDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingCutJobParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingCutJobUpdateParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingCutParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingProductDetailDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MachinePartNestingTeamDTOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartNestingExportParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartNestingParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartSchedulingDTOParam;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskNeedMachinePartSchedulingService;
import com.hzchum.scim.rest.controller.wms.wmsUse.client.WmsWebSocketClient;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.mesFactory.groups.get.SchedulingGroupsTreeVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.post.MesBuildingMachinePartSchedulingSaveVORequest;
import com.hzchum.scim.system.core.api.pojo._do.MesBuildingNestingTeam;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.MesBuildingNestingTeamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES零件排产(套料)")
@RestController
@RequestMapping("/api/mes/building/machine_part/nesting")
public class MesBuildingMachinePartNestingController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingMachinePartNestingController.class);
   @Autowired
   private MesBuildingGroupsBiz groupsBiz;
   @Autowired
   private MesBuildingNestingTeamService mesBuildingNestingTeamService;
   private static String URLONE = "ws://pulsar-ws.fscut.com/ws/v2/consumer/non-persistent/prod/cloudnest/open_platform_";
   private static String URLTWO = "/Exclusive2?consumerName=gc-client1&receiverQueueSize=30&subscriptionType=Exclusive";
   @Resource
   private MesBuildingTaskNeedMachinePartSchedulingService mesBuildingTaskNeedMachinePartSchedulingService;
   @Resource
   private CommonTokenBiz commonTokenBiz;
   @Autowired
   private NestBiz nestBiz;
   @Autowired
   private ConfigService configService;

   @ApiOperation("查询待排产的车间集合")
   @ApiImplicitParam(name = "param", value = "查询参数", required = true, dataType = "MachinePartNestingTeamDTOParam")
   @GetMapping("/getWorkShopList")
   public ResultVO getWorkShopList(@Valid MachinePartNestingTeamDTOParam param) {
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.getWorkShopList(param));
   }

   @ApiOperation("查询待排产的项目集合")
   @GetMapping("get-project-list")
   public ResultVO getProjectList(MachinePartNestingTeamDTOParam param) {
      log.info("API 调用 ：查询待排产的项目集合");
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.getProjectList(param));
   }

   @ApiOperation("查询待排产的生产组")
   @GetMapping("/getTeamList")
   public ResultVO getTeamList(MachinePartNestingTeamDTOParam param) {
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.getTeamList(param));
   }

   @ApiOperation("查询待排产零件")
   @ApiImplicitParam(name = "param", value = "查询参数", required = true, dataType = "MachinePartNestingProductDTOParam")
   @PostMapping("/getNeedMachinePartDetailList")
   public ResultVO getNeedMachinePartDetailList(
      @RequestBody MachinePartNestingProductDetailDTOParam param,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：查询待排产零件");
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.getNeedMachinePartDetailList(param, pageNumber, pageSize));
   }

   @ApiOperation("查询待排产零件厚度集合")
   @ApiImplicitParam(name = "param", value = "查询参数", required = true, dataType = "MachinePartNestingProductDTOParam")
   @PostMapping("/getThickList")
   public ResultVO getThickList(@RequestBody MachinePartNestingProductDetailDTOParam param) {
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.getThickList(param));
   }

   @ApiOperation("查询待排产零件材质集合")
   @ApiImplicitParam(name = "param", value = "查询参数", required = true, dataType = "MachinePartNestingProductDTOParam")
   @PostMapping("/getMaterialList")
   public ResultVO getMaterialList(@RequestBody MachinePartNestingProductDetailDTOParam param) {
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.getMaterialList(param));
   }

   @ApiOperation("获取型材零件排产类型集合")
   @PostMapping("/getPartTypeList")
   public ResultVO getPartTypeList(@RequestBody MachinePartNestingProductDetailDTOParam param) {
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.getPartTypeList(param));
   }

   @ApiOperation("获取零件排产半自动切割可排产生产组树")
   @GetMapping("/scheduling/tree")
   public ResultVO getSchedulingGroupsTree(@Validated SchedulingGroupsTreeVORequest voRequest) {
      log.info("API 调用 ：分页获取生产组分页列表，参数{}", voRequest);
      return ResultBuilder.success(
         this.groupsBiz.getSchedulingGroupsTreeNesting(BeanUtil.copy(voRequest, MesBuildingGroupsDTOParam.class), WorkShopTypeEnum.BUILDING.getType())
      );
   }

   @ApiOperation("零件直接排产保存零件排产-新版")
   @PostMapping("/scheduling/saveMachinePartDirect")
   @SignerCheck(lockKey = "#voRequest.projectId", message = "当前项目直接排产下发中, 请稍后重试", timeout = 180L)
   public ResultVO saveMachinePartDirectScheduling(@RequestBody @Validated MesBuildingMachinePartSchedulingSaveVORequest voRequest) {
      log.info("API 调用 ：零件直接排产保存零件排产-新版：{}", voRequest);
      MesBuildingMachinePartSchedulingDTOParam mesBuildingMachinePartSchedulingDTOParam = BeanUtil.copy(
         voRequest, MesBuildingMachinePartSchedulingDTOParam.class
      );
      BatchSchedulingOutboundDTOParam batchSchedulingOutboundDTOParam = voRequest.getBatchOutboundDTOParam();
      if (batchSchedulingOutboundDTOParam != null) {
         if (CollectionUtils.isNotEmpty(voRequest.getBatchOutboundDTOParam().getList())) {
            List<BatchSchedulingOutboundDetailDTOParam> batchSchedulingOutboundDetailDTOParams = cn.hutool.core.bean.BeanUtil.copyToList(
               voRequest.getBatchOutboundDTOParam().getList(), BatchSchedulingOutboundDetailDTOParam.class
            );
            batchSchedulingOutboundDTOParam.setList(batchSchedulingOutboundDetailDTOParams);
         }

         mesBuildingMachinePartSchedulingDTOParam.setBatchOutboundDTOParam(batchSchedulingOutboundDTOParam);
      }

      Long aLong = this.mesBuildingTaskNeedMachinePartSchedulingService.saveMachinePartDirectScheduling(mesBuildingMachinePartSchedulingDTOParam);
      return ResultBuilder.success(aLong);
   }

   @ApiOperation("零件套料发送到套料软件")
   @PostMapping("/scheduling/sendToNesting")
   @SignerCheck(lockKey = "#mesBuildingMachinePartNestingParam.projectId", message = "当前项目套料下发中, 请稍后重试", timeout = 180L)
   public void sendToNesting(@RequestBody @Validated MesBuildingMachinePartNestingParam mesBuildingMachinePartNestingParam, HttpServletResponse response) {
      log.info("API 调用 ：零件套料发送到套料软件");
      Integer nestingTaskModeEnum = this.configService.nestingTaskSettingGet();
      if (Objects.equals(nestingTaskModeEnum, NestingTaskModeEnum.MODE_ONE.getType())) {
         this.mesBuildingTaskNeedMachinePartSchedulingService.sendToNestingV3(mesBuildingMachinePartNestingParam, response);
      }

      if (Objects.equals(nestingTaskModeEnum, NestingTaskModeEnum.MODE_TWO.getType())) {
         this.mesBuildingTaskNeedMachinePartSchedulingService.sendToNestingModeTwo(mesBuildingMachinePartNestingParam, response);
      }
   }

   @ApiOperation("手动处理零件下发到套料软件异常数据")
   @PutMapping("manually-processing-machine-part-issued-to-nesting-software-abnormal-data")
   public ResultVO manuallyProcessingMachinePartIssuedToNestingSoftwareAbnormalData(@RequestBody List<Long> taskOrderIdList) {
      log.info("API 调用 ：手动处理零件下发到套料软件异常数据");
      return ResultBuilder.success(
         this.mesBuildingTaskNeedMachinePartSchedulingService.manuallyProcessingMachinePartIssuedToNestingSoftwareAbnormalData(taskOrderIdList)
      );
   }

   @ApiOperation("获取作业分组树")
   @PostMapping("/getWorkTree")
   public ResultVO getWorkTree(@RequestBody WorkTreeDTO workTreeDTO) {
      log.info("API 调用 ：获取作业分组树");
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.getWorkTree(workTreeDTO));
   }

   @ApiOperation("获取套料软件下指定作业下的排版列表")
   @ApiImplicitParam(name = "param", value = "查询参数", required = true, dataType = "MesBuildingMachinePartNestingParam")
   @GetMapping("/getWorkMachinePartListFromNesting")
   public ResultVO getMachinePartListFromNesting(Integer jobId, Integer cutStatus, Integer cutSendStatus) {
      log.info("API 调用 ：获取套料软件下指定作业下的排版列表");
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.getWorkMachinePartListFromNesting(jobId, cutStatus, cutSendStatus));
   }

   @ApiOperation("获取套料软件下指定作业下的排版列表(本地)")
   @ApiImplicitParam(name = "param", value = "查询参数", required = true, dataType = "MesBuildingMachinePartNestingParam")
   @GetMapping("/getWorkMachinePartListFromNestingLocal")
   public ResultVO getMachinePartListFromNestingLocal(Integer jobId, Integer cutStatus, Integer cutSendStatus, String material, BigDecimal thickness) throws UnsupportedEncodingException {
      log.info("API 调用 ：获取套料软件下指定作业下的排版列表");
      return ResultBuilder.success(
         this.mesBuildingTaskNeedMachinePartSchedulingService.getWorkMachinePartListFromNestingLocal(jobId, cutStatus, cutSendStatus, material, thickness)
      );
   }

   @ApiOperation("导出套料软件下指定作业下的排版列表")
   @ApiImplicitParam(name = "param", value = "查询参数", required = true, dataType = "MesBuildingMachinePartNestingParam")
   @PostMapping("/exportWorkMachinePartListFromNesting")
   public ResultVO exportMachinePartListFromNesting(
      @RequestBody MesBuildingMachinePartNestingExportParam mesBuildingMachinePartNestingExportParam, HttpServletResponse response
   ) {
      log.info("API 调用 ：导出套料软件下指定作业下的排版列表");
      return ResultBuilder.success(
         this.mesBuildingTaskNeedMachinePartSchedulingService.exportMachinePartListFromNesting(mesBuildingMachinePartNestingExportParam, response)
      );
   }

   @ApiOperation("设置机床")
   @PostMapping("/scheduling/setMachineTool")
   public void setMachineTool(@RequestBody @Validated MachinePartNestingCutJobParam machinePartNestingCutJobParam) {
      log.info("API 调用 ：导出套料软件下指定作业下的排版列表");
      this.mesBuildingTaskNeedMachinePartSchedulingService.setMachineTool(machinePartNestingCutJobParam);
   }

   @ApiOperation("套料排产下发(切割任务下发)")
   @ApiImplicitParams(@ApiImplicitParam(name = "param", value = "查询参数", required = true, dataType = "MachinePartNestingCutParam"))
   @PostMapping("/scheduling/saveMachinePartNestingCut")
   @SignerCheck(lockKey = "#machinePartNestingCutParam.jobId", message = "当前正在保存套料排产，请稍后重试。")
   public ResultVO saveMachinePartNestingCut(@RequestBody @Validated MachinePartNestingCutParam machinePartNestingCutParam) {
      log.info("API 调用 ：套料排产下发");
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.saveMachinePartNestingCut(machinePartNestingCutParam));
   }

   @ApiOperation("修改切割任务状态")
   @ApiImplicitParam(name = "param", value = "查询参数", required = true, dataType = "MachinePartNestingCutJobUpdateParam")
   @PutMapping("/scheduling/updateMachinePartNestingJobStatus")
   public ResultVO updateMachinePartNestingCutJob(@RequestBody MachinePartNestingCutJobUpdateParam machinePartNestingCutJobUpdateParam) {
      this.commonTokenBiz.checkToken(machinePartNestingCutJobUpdateParam.getToken());
      log.info("API 调用 ：修改切割任务状态");
      return this.mesBuildingTaskNeedMachinePartSchedulingService.updateMachinePartNestingCutJob(machinePartNestingCutJobUpdateParam)
         ? ResultBuilder.success("切割任务状态修改成功")
         : ResultBuilder.failed("切割任务状态修改失败");
   }

   @ApiOperation("导出套料报告单")
   @ApiImplicitParam(name = "jobId", value = "任务ID", required = true, dataType = "Integer")
   @PostMapping("/downloadPDF")
   public void downloadPdf(
      HttpServletResponse response, @RequestParam("resultId") String resultId, @RequestParam(value = "machineToolId", required = false) Long machineToolId
   ) {
      log.info("API 调用 ：导出套料报告单");
      this.mesBuildingTaskNeedMachinePartSchedulingService.downloadPdf(response, resultId, machineToolId);
   }

   @ApiOperation("导出套料报告单")
   @ApiImplicitParam(name = "jobId", value = "任务ID", required = true, dataType = "Integer")
   @PostMapping("/getNestPdfData")
   public ResultVO getNestPdfData(@RequestParam("resultId") String resultId, @RequestParam("machineToolId") Long machineToolId) throws IOException {
      log.info("API 调用 ：导出套料报告单");
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.getNestPdfData(resultId, machineToolId));
   }

   @ApiOperation("通过jobId获取任务信息")
   @ApiImplicitParam(name = "jobId", value = "任务ID", required = true, dataType = "Integer")
   @GetMapping("/getJobInfoByJobId")
   public ResultVO getJobInfoByJobId(Integer jobId) {
      log.info("API 调用 ：通过jobId获取任务信息");
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.getJobInfoByJobId(jobId));
   }

   @ApiOperation("获取job的车间信息")
   @ApiImplicitParam(name = "jobId", value = "任务ID", required = true, dataType = "Integer")
   @GetMapping("/getJobWorkShopInfo")
   public ResultVO getJobWorkShopInfo() {
      log.info("API 调用 ：获取job的车间信息");
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.getJobWorkShopInfo());
   }

   @ApiOperation("获取job的车间信息")
   @ApiImplicitParam(name = "jobId", value = "任务ID", required = true, dataType = "Integer")
   @GetMapping("/getJobMaterial")
   public ResultVO getJobMaterial(Integer jobId) {
      log.info("API 调用 ：获取job的车间信息");
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.getJobMaterial(jobId));
   }

   @ApiOperation("删除套料任务")
   @ApiImplicitParam(name = "jobId", value = "任务ID", required = true, dataType = "Integer")
   @DeleteMapping("/deleteMachinePartNestingJob")
   public ResultVO deleteMachinePartNestingJobAll(Integer jobId) {
      log.info("API 调用 ：删除套料任务");
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.deleteMachinePartNestingJob(jobId));
   }

   @ApiOperation("根据条件删除套料任务")
   @ApiImplicitParam(name = "jobId", value = "任务ID", required = true, dataType = "Integer")
   @PostMapping("/deleteMachinePartNestingJobList")
   public ResultVO deleteMachinePartNestingJobList(@RequestBody MesBuildingMachinePartNestingExportParam mesBuildingMachinePartNestingExportParam) {
      log.info("API 调用 ：根据条件删除套料任务，mesBuildingMachinePartNestingExportParam{}", mesBuildingMachinePartNestingExportParam);
      return ResultBuilder.success(
         this.mesBuildingTaskNeedMachinePartSchedulingService.deleteMachinePartNestingJobList(mesBuildingMachinePartNestingExportParam)
      );
   }

   @ApiOperation("WS接受通知修改套料任务状态")
   @PostMapping("/updateMachinePartNestingJobStatus")
   public ResultVO updateMachinePartNestingJobStatus(@RequestParam(name = "wsJson") String wsJson) {
      log.info("API 调用 ：WS接受通知修改套料任务状态");
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.updateMachinePartNestingJobStatus(wsJson));
   }

   @ApiOperation("零件排产下载清单")
   @ApiImplicitParams(@ApiImplicitParam(name = "param", value = "查询参数", required = true, dataType = "MachinePartNestingProductDetailDTOParam"))
   @PostMapping("/exportMachinePartList")
   public void exportMachinePartList(@RequestBody MachinePartNestingProductDetailDTOParam param, HttpServletResponse response) {
      log.info("API 调用 ：零件排产下载清单");
      this.mesBuildingTaskNeedMachinePartSchedulingService.exportMachinePartList(param, response);
   }

   @ApiOperation("创建ws通知")
   @ApiImplicitParams(@ApiImplicitParam(name = "param", value = "查询参数", required = true, dataType = "MachinePartNestingProductDetailDTOParam"))
   @PostMapping("/nestConnectToServer")
   public void nestConnectToServer() {
      List<MesBuildingNestingTeam> mesBuildingNestingTeamList = this.mesBuildingNestingTeamService.list();

      for (MesBuildingNestingTeam mesBuildingNestingTeam : mesBuildingNestingTeamList.stream()
         .collect(Collectors.toMap(MesBuildingNestingTeam::getTeamCode, team -> (MesBuildingNestingTeam)team, (existing, replacement) -> existing))
         .values()
         .stream()
         .collect(Collectors.toList())) {
         WmsWebSocketClient nestingWebSocketClient = new WmsWebSocketClient();
         String teamCode = mesBuildingNestingTeam.getTeamCode();
         nestingWebSocketClient.startConnection(URLONE + teamCode + URLTWO);
      }
   }

   @ApiOperation("创建ws通知")
   @PostMapping("/nestConnectToServerOne")
   public void nestConnectToServerOne(@RequestParam(name = "teamCode") String teamCode) {
      WmsWebSocketClient nestingWebSocketClient = new WmsWebSocketClient();
      nestingWebSocketClient.startConnection(URLONE + teamCode + URLTWO);
   }

   @ApiOperation("生成MACHINE_PART approval record")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "schedulingId", value = "排产ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "orderNumber", value = "工单号", required = true, dataType = "String")
      }
   )
   @PostMapping("/createPartApprovalRecord")
   public ResultVO createPartApprovalRecord(@RequestParam Long schedulingId, @RequestParam(required = false) String orderNumber) {
      log.info("API 调用 ：生成part approval record");
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.createPartApprovalRecord(schedulingId, orderNumber));
   }

   @ApiOperation("生成生成数控切割审批记录")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(
               name = "appAutoCutSchedulingDTOList",
               value = "排产参数",
               dataType = "com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPAutoCutSchedulingDTO",
               paramType = "body"
            ),
            @ApiImplicitParam(
               name = "APPAutoCutSchedulingDTO",
               value = "token",
               dataType = "com.hzchum.scim.mes.building.core.api.pojo._dto.task.app.APPAutoCutSchedulingDTO"
            )
      }
   )
   @PostMapping("/createAutoCutApprovalRecord")
   public ResultVO createAutoPartApprovalRecord(@RequestBody APPAutoCutSchedulingDTO appAutoCutSchedulingDTO) {
      log.info("API 调用 ：生成part approval record");
      List<APPAutoCutSchedulingDetail> appAutoCutSchedulingDetailList = appAutoCutSchedulingDTO.getAppAutoCutSchedulingDetailList();
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.createAutoPartApprovalRecord(appAutoCutSchedulingDetailList));
   }

   @ApiOperation("型材,板材领料审批通过")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "id", value = "审批记录ID", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "decision", value = "审批结果 2：通过", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "serialNumber", value = "流水号", required = true, dataType = "String")
      }
   )
   @PostMapping("/approvePart")
   public ResultVO approvePart(@RequestParam Long id, @RequestParam Integer decision, @RequestParam(name = "serialNumber") String serialNumber) {
      log.info("API 调用 ： 型材,板材领料审批通过 参数id：{}, decision：{}, serialNumber：{}", id, decision, serialNumber);
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.approvePart(id, decision, serialNumber));
   }

   @ApiOperation("数控审批通过")
   @ApiImplicitParams(@ApiImplicitParam(name = "wmsApproveRecordId", value = "审批记录ID", required = true, dataType = "Long"))
   @PostMapping("/approveAutoCut")
   public ResultVO approveAutoCut(@RequestParam Long wmsApproveRecordId) {
      log.info("API 调用 ： 数控审批通过, 参数：wmsApproveRecordId：{}", wmsApproveRecordId);
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.approveAutoCut(wmsApproveRecordId));
   }

   @ApiOperation("型材审批记录")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "type", value = "固定值 MES_MACHINE_PART 60004", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "status", value = "1进行中  2结束", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "pageSize", value = "每页条数", required = true, dataType = "Integer")
      }
   )
   @PostMapping("/approvePartList")
   public ResultVO approvePartList(
      @RequestParam(defaultValue = "60004", required = false) Integer type,
      @RequestParam Integer status,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ： 型材审批记录");
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.approvePartList(type, status, pageNumber, pageSize));
   }

   @ApiOperation("型材审批详情")
   @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Long")
   @PostMapping("/approvePartDetail")
   public ResultVO approvePartListOne(@RequestParam Long id) {
      log.info("API 调用 ： approval record");
      return ResultBuilder.success(this.mesBuildingTaskNeedMachinePartSchedulingService.approvePartDetail(id));
   }

   @ApiOperation("重新获取套料心跳")
   @PostMapping("/getHeartBeat")
   public void getHeartBeat() {
      List<MesBuildingNestingTeam> mesBuildingNestingTeamList = this.mesBuildingNestingTeamService
         .list((Wrapper<MesBuildingNestingTeam>)new LambdaQueryWrapper<MesBuildingNestingTeam>().eq(MesBuildingNestingTeam::getBoolDrillHole, 1));

      for (MesBuildingNestingTeam mesBuildingNestingTeam : mesBuildingNestingTeamList.stream()
         .collect(Collectors.toMap(MesBuildingNestingTeam::getTeamCode, team -> (MesBuildingNestingTeam)team, (existing, replacement) -> existing))
         .values()
         .stream()
         .collect(Collectors.toList())) {
         WmsWebSocketClient wmsWebSocketClient = new WmsWebSocketClient();
         String teamCode = mesBuildingNestingTeam.getTeamCode();
         wmsWebSocketClient.startConnection(URLONE + teamCode + URLTWO);
      }
   }

   @ApiOperation("修复套料下发数据")
   @PostMapping("/repairNestingData")
   public void repairNestingData(@RequestParam List<String> childGuids) {
      this.nestBiz.generateSurplus(childGuids);
   }
}
