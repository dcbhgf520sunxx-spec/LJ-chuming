package com.hzchum.scim.rest.controller.mes.building.task.app;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingAutoCutTaskBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-MES零件数控切割任务")
@RestController
@RequestMapping("/api/app/mes/building/AutoCutTask")
public class MesBuildingAppAutoCutTaskController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingAppAutoCutTaskController.class);
   @Autowired
   private MesBuildingAutoCutTaskBiz mesBuildingAutoCutTaskBiz;

   @ApiOperation("用户获取任务工单分页列表")
   @GetMapping("/task_order/process/page")
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
         this.mesBuildingAutoCutTaskBiz
            .taskOrderPage(projectId, monomerId, areaId, taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum, sort, pageNumber, pageSize)
      );
   }

   @ApiOperation("获取用户存在任务工单的项目列表")
   @GetMapping("/exist-task-order/project/list")
   public ResultVO existTaskOrderProjectList(
      @ApiParam(name = "任务类型", required = true) @RequestParam Integer taskTypeEnum,
      @ApiParam(name = "零件生产分类(1: 半自动切割, 2: 数控切割, 4: 型材切割, 8: 钻孔)", required = true) @RequestParam Integer machinePartProductionClass
   ) {
      log.info("API 调用 ：获取用户存在任务工单的项目列表");
      return ResultBuilder.success(new ListVO<>(this.mesBuildingAutoCutTaskBiz.existTaskOrderProjectList(taskTypeEnum, machinePartProductionClass)));
   }

   @ApiOperation("获取数控待领料审批详情")
   @GetMapping("/task_order/numericalControlDetail")
   public ResultVO taskOrderDetailNumericalControl(
      @RequestParam(name = "jobId") Long jobId,
      @RequestParam(name = "bcGuidList", required = false) List<String> bcGuidList,
      @RequestParam(name = "boolCheck") Boolean boolCheck
   ) {
      log.info("API 调用 ：获取数控待领料审批详情，jobId{}, bcGuidList{}, boolCheck{}", jobId, bcGuidList, boolCheck);
      return ResultBuilder.success(this.mesBuildingAutoCutTaskBiz.numericalControlDetail(jobId, bcGuidList, boolCheck));
   }

   @ApiOperation("获取数控待领料审批已提交详情")
   @GetMapping("/task_order/numericalControlDetailSubmit")
   public ResultVO numericalControlDetailSubmit(@RequestParam(name = "jobId") Long jobId) {
      log.info("API 调用 ：获取数控待领料审批已提交详情");
      return ResultBuilder.success(this.mesBuildingAutoCutTaskBiz.numericalControlDetailSubmit(jobId));
   }

   @ApiOperation("获取数控审批单详情")
   @GetMapping("/getApproveRecordDetail")
   public ResultVO taskOrderDetailNumericalControl(@RequestParam(name = "wmsApproveRecordId") Long wmsApproveRecordId) {
      log.info("API 调用 ：获取数控审批单详情");
      return ResultBuilder.success(this.mesBuildingAutoCutTaskBiz.getApproveRecordDetail(wmsApproveRecordId));
   }

   @ApiOperation("获取自动切割任务详情")
   @GetMapping("/task_order/detail")
   public ResultVO taskOrderDetail(Long jobId) {
      log.info("API 调用 ：获取自动切割任务详情");
      return ResultBuilder.success(this.mesBuildingAutoCutTaskBiz.taskOrderDetail(jobId));
   }

   @ApiOperation("获取数控切割打标详情")
   @GetMapping("/task_order/detailTwo")
   public ResultVO taskOrderDetailTwo(Long taskOrderId) {
      log.info("API 调用 ：获取数控切割打标详情,taskorderId{}", taskOrderId);
      return ResultBuilder.success(this.mesBuildingAutoCutTaskBiz.taskOrderDetailTwo(taskOrderId));
   }

   @ApiOperation("获取自动切割任务历史记录详情")
   @GetMapping("/task_order/detailHistory")
   public ResultVO taskOrderDetailHistory(
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "processType", required = false) Integer processType,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "taskTypeEnum") Integer taskTypeEnum,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：获取自动切割任务详情");
      return ResultBuilder.success(
         this.mesBuildingAutoCutTaskBiz.taskOrderDetailHistory(startDate, endDate, taskTypeEnum, processType, serialNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("修改零件打标状态")
   @GetMapping("/task_order/updatePartLabelStatus")
   public ResultVO updatePartLabelStatus(Long id) {
      log.info("API 调用 ：修改零件打标状态");
      return ResultBuilder.success(this.mesBuildingAutoCutTaskBiz.updatePartLabelStatus(id));
   }
}
