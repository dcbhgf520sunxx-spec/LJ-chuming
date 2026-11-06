package com.hzchum.scim.rest.controller.mes.building.task.app;

import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingSemiAutoCutTaskBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-MES半自动零件切割任务")
@RestController
@RequestMapping("/api/app/mes/building/semiAutoCutTask")
public class MesBuildingAppSemiAutoCutTaskController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingAppSemiAutoCutTaskController.class);
   @Autowired
   private MesBuildingSemiAutoCutTaskBiz mesBuildingSemiAutoCutTaskBiz;

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
         this.mesBuildingSemiAutoCutTaskBiz
            .taskOrderPage(projectId, monomerId, areaId, taskTypeEnum, serialNumber, orderNumber, boolLastProcessEnum, sort, pageNumber, pageSize)
      );
   }

   @ApiOperation("获取半自动切割任务领料详情")
   @GetMapping("/task_order/process/detail")
   public ResultVO taskOrderProcessDetail(Long schedulingId) {
      log.info("API 调用 ：获取型材领料详情，param:{}", schedulingId);
      return ResultBuilder.success(this.mesBuildingSemiAutoCutTaskBiz.taskOrderProcessDetail(schedulingId));
   }

   @ApiOperation("获取半自动切割任务详情")
   @GetMapping("/task_order/detail")
   public ResultVO taskOrderDetail(Long taskOrderId, Long monomerId, Long areaId) {
      log.info("API 调用 ：获取半自动切割任务详情，参数：taskOrderId：{}", taskOrderId);
      return ResultBuilder.success(this.mesBuildingSemiAutoCutTaskBiz.taskOrderDetail(taskOrderId, monomerId, areaId));
   }

   @ApiOperation("获取半自动切割任务历史记录详情")
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
      log.info("API 调用 ：获取半自动切割任务历史记录详情");
      return ResultBuilder.success(
         this.mesBuildingSemiAutoCutTaskBiz.taskOrderDetailHistory(startDate, endDate, taskTypeEnum, processType, serialNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("修改零件打标状态")
   @GetMapping("/task_order/updatePartLabelStatus")
   public ResultVO updatePartLabelStatus(Long id) {
      log.info("API 调用 ：修改零件打标状态，id:{}", id);
      return ResultBuilder.success(this.mesBuildingSemiAutoCutTaskBiz.updatePartLabelStatus(id));
   }
}
