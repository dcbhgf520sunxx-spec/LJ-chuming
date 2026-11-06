package com.hzchum.scim.rest.controller.mes.building.task;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.pangu.common.valid.SignerCheck;
import com.hzchum.scim.common.core.api.pojo.dto.NumberInfoDTO;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderBiz;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingArtifactTaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.task.MesBuildingMachineTaskOrderDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskOrderDTOParam;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.task.get.MesBuildingTaskOrderVORequest;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.task.post.MesBuildingTaskOrderSaveVORequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES任务工单")
@RestController
@RequestMapping("/api/mes/building/task/order")
public class MesBuildingTaskOrderController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingTaskOrderController.class);
   @Resource
   private MesBuildingTaskOrderBiz taskOrderBiz;

   @ApiOperation("保存任务工单")
   @PostMapping("")
   @PreAuthorize("@permission.check('mes_scheduling_assemble:save')")
   @SignerCheck(boolMethodAndClassName = true, message = "下发失败!当前有正在下发的工单请稍后重试!")
   public ResultVO saveTaskOrderList(@RequestBody @Validated MesBuildingTaskOrderSaveVORequest voRequest) {
      log.info("API 调用 ：保存任务工单");
      return ResultBuilder.success(this.taskOrderBiz.saveArtifactTaskOrder(BeanUtil.copy(voRequest, MesBuildingTaskOrderDTOParam.class), null));
   }

   @ApiOperation("保存任务工单")
   @PostMapping("/new")
   @PreAuthorize("@permission.check('mes_scheduling_assemble:save')")
   @SignerCheck(boolMethodAndClassName = true, message = "下发失败!当前有正在下发的工单请稍后重试!", timeout = 300L)
   public ResultVO saveTaskOrderList2(@RequestBody @Valid MesBuildingTaskOrderSaveVORequest voRequest) {
      log.info("API 调用 ：保存任务工单");
      return ResultBuilder.success(this.taskOrderBiz.saveArtifactTaskOrder2(BeanUtil.copy(voRequest, MesBuildingTaskOrderDTOParam.class)));
   }

   @ApiOperation("获取任务工单")
   @GetMapping("/page")
   public ResultVO gatTaskOrderPage(
      MesBuildingTaskOrderVORequest voRequest,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：获取任务工单");
      Integer type = voRequest.getTaskTypeEnum();
      if (type == null || !com.hzchum.scim.mes.building.core.api.enums.task.TaskTypeEnum.isExist(type)) {
         return ResultBuilder.failed("任务类型不正确");
      }
      MesBuildingTaskOrderDTOParam param = BeanUtil.copy(voRequest, MesBuildingTaskOrderDTOParam.class);
      param.setProductType(type);
      return ResultBuilder.success(this.taskOrderBiz.getTaskOrderPage(param, pageNumber, pageSize));
   }

   @ApiOperation("获取结构工单")
   @GetMapping("/artifact/page")
   @PreAuthorize("@permission.check('mes_work_order_artifact:get')")
   public ResultVO<PageVO<MesBuildingArtifactTaskOrderDTO>> getArtifactsTaskPage(
      @RequestParam(name = "projectIds") List<Long> projectIds,
      @RequestParam(name = "monomerIds", required = false) List<Long> monomerIds,
      @RequestParam(name = "areaIds", required = false) List<Long> areaIds,
      @RequestParam(name = "areaBatchIds", required = false) List<Long> areaBatchIds,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(required = false) Integer productType,
      Boolean printType,
      Long workshopId,
      LocalDateTime localDateTime,
      String orderNumber,
      LocalDateTime startDate,
      LocalDateTime endDate,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：获取结构工单");
      return ResultBuilder.success(
         this.taskOrderBiz
            .getArtifactsTaskPage(
               projectIds,
               monomerIds,
               areaIds,
               areaBatchIds,
               serialNumber,
               productType,
               printType,
               workshopId,
               localDateTime,
               orderNumber,
               startDate,
               endDate,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("获取结构工单的项目信息")
   @GetMapping("/artifact/project/list")
   public ResultVO getArtifactsTaskProjectList(LocalDateTime localDateTime, String serialNumber) {
      log.info("API 调用 ：获取结构工单的项目信息");
      return ResultBuilder.success(this.taskOrderBiz.getArtifactsTaskProjectList(localDateTime, serialNumber));
   }

   @ApiOperation("获取结构工单的项目信息V2")
   @GetMapping("/artifact/project/listV2")
   public ResultVO getArtifactsTaskProjectListV2(LocalDate localDateTime, String serialNumber, Long workshopId) {
      log.info("API 调用 ：获取结构工单的项目信息");
      return ResultBuilder.success(this.taskOrderBiz.getArtifactsTaskProjectListV2(localDateTime, serialNumber, workshopId));
   }

   @ApiOperation("零件工单跟踪列表")
   @GetMapping("/tracking/machine_part/page")
   public ResultVO taskTrackMachinePartPage(
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Integer productType,
      Integer status,
      String orderNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：零件工单跟踪列表");
      return ResultBuilder.success(
         this.taskOrderBiz
            .taskTrackMachinePartPage(
               dateTime, workshopId, productionLineId, projectId, monomerId, areaId, productType, status, orderNumber, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("构件工单跟踪列表")
   @GetMapping("/tracking/artifact/page")
   @PreAuthorize("@permission.check('mes_work_order_tracking:get')")
   public ResultVO taskTrackArtifactPage(
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      Long projectId,
      Long monomerId,
      Long areaId,
      Long areaBatchId,
      @RequestParam Integer productType,
      Integer status,
      String orderNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：构件工单跟踪列表");
      return ResultBuilder.success(
         this.taskOrderBiz
            .taskTrackArtifactPage(
               dateTime, workshopId, productionLineId, projectId, monomerId, areaId, areaBatchId, productType, status, orderNumber, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("获取零件工单")
   @GetMapping("/machinePart/page")
   public ResultVO<PageVO<MesBuildingMachineTaskOrderDTO>> getMachinePartTaskPage(
      @RequestParam(name = "projectIds", required = false) List<Long> projectIds,
      @RequestParam(name = "monomerIds", required = false) List<Long> monomerIds,
      @RequestParam(name = "areaIds", required = false) List<Long> areaIds,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam Integer processType,
      Boolean printType,
      Long workshopId,
      LocalDateTime localDateTime,
      String cutNumber,
      Integer boolNestCut,
      Long cutConfigId,
      @RequestParam(defaultValue = "1", required = false) Integer pageNumber,
      @RequestParam(defaultValue = "10", required = false) Integer pageSize
   ) {
      log.info("API 调用 ：获取零件工单");
      return ResultBuilder.success(
         this.taskOrderBiz
            .getMachinePartTaskPage(
               boolNestCut,
               projectIds,
               monomerIds,
               areaIds,
               serialNumber,
               processType,
               printType,
               workshopId,
               localDateTime,
               cutNumber,
               cutConfigId,
               pageNumber,
               pageSize
            )
      );
   }

   @ApiOperation("获取零件切割类型")
   @GetMapping("/machinePart/cutConfig/list")
   public ResultVO getMachinePartCutConfig(
      @RequestParam(name = "projectIds", required = false) List<Long> projectIds,
      @RequestParam(name = "monomerIds", required = false) List<Long> monomerIds,
      @RequestParam(name = "areaIds", required = false) List<Long> areaIds,
      @RequestParam Integer processType
   ) {
      log.info("API 调用 ：获取零件切割类型");
      return ResultBuilder.success(this.taskOrderBiz.getMachinePartCutConfig(projectIds, monomerIds, areaIds, processType));
   }

   @ApiOperation("获取零件工单的项目信息")
   @GetMapping("/machinePart/project/list")
   public ResultVO getMachinePartTaskprojectList(LocalDateTime localDateTime, String serialNumber, @RequestParam Integer processType) {
      log.info("API 调用 ：获取零件工单的项目信息");
      return ResultBuilder.success(this.taskOrderBiz.getMachinePartTaskprojectList(localDateTime, serialNumber, processType));
   }

   @ApiOperation("获取套料任务单(cut-pdf)")
   @GetMapping("/nesting")
   public void getMachinePartNesting(@RequestParam Long cutId) {
      log.info("API 调用 ：获取套料任务单");
      this.taskOrderBiz.getMachinePartNesting(cutId);
   }

   @ApiOperation("获取任务单")
   @GetMapping("/drilling")
   public ResultVO getMachinePartDrilling(@RequestParam Long cutId, @RequestParam Integer processType) {
      log.info("API 调用 ：获取任务单");
      return ResultBuilder.success(this.taskOrderBiz.getMachinePartDrilling(cutId, processType));
   }

   @ApiOperation("获取钻孔任务单")
   @GetMapping("/drilling/page")
   public ResultVO getMachinePartDrillingPage(
      @RequestParam Long cutId, @RequestParam Integer processType, @RequestParam Integer pageNumber, @RequestParam Integer pageSize
   ) {
      log.info("API 调用 ：获取钻孔任务单");
      return ResultBuilder.success(this.taskOrderBiz.getMachinePartDrillingPage(cutId, processType, pageNumber, pageSize));
   }

   @ApiOperation("获取钻孔任务单打印")
   @GetMapping("/drilling/print")
   public ResultVO getMachinePartDrillingPrint(@RequestParam Long cutId, Integer processType) {
      log.info("API 调用 ：获取钻孔任务单打印");
      return ResultBuilder.success(this.taskOrderBiz.getMachinePartDrillingPrint(cutId, processType));
   }

   @ApiOperation("绑码页面获取工单数据")
   @GetMapping("/listNumberOrder")
   @PreAuthorize("@permission.menu(32425L)")
   public ResultVO listNumberOrders(
      @RequestParam Long projectId, @RequestParam Long monomerId, Long areaId, Integer taskType, @RequestParam String serialNumber
   ) {
      log.info("API 调用 ：绑码页面获取工单数据");
      return ResultBuilder.success(this.taskOrderBiz.listNumberOrders(projectId, monomerId, areaId, taskType, serialNumber));
   }

   @ApiOperation("绑码页面依据工单获取产品数据")
   @GetMapping("/listProductNumbers")
   @PreAuthorize("@permission.menu(32425L)")
   public ResultVO listProductNumbers(@RequestParam Long orderId, @RequestParam Long productId, Integer number) {
      log.info("API 调用 ：绑码页面依据工单获取产品数据");
      return ResultBuilder.success(this.taskOrderBiz.listProductNumbers(orderId, productId, number));
   }

   @ApiOperation("绑码页面依据工单,构件获取绑码数据")
   @PostMapping("/list/linknumbers")
   @PreAuthorize("@permission.menu(32425L)")
   public ResultVO linknumbers(@RequestBody List<NumberInfoDTO> numbers) {
      log.info("API 调用 ：绑码页面依据工单获取产品数据");
      return ResultBuilder.success(this.taskOrderBiz.linknumbers(numbers));
   }
}
