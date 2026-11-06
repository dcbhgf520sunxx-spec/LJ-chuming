package com.hzchum.scim.rest.controller.mes.building.task.app;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingDrillTaskBiz;
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

@Api(tags = "APP-MES钻孔切割任务")
@RestController
@RequestMapping("/api/app/mes/building/drillTask")
public class MesBuildingAppDrillTaskController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingAppDrillTaskController.class);
   @Autowired
   private MesBuildingDrillTaskBiz mesBuildingDrillTaskBiz;

   @ApiOperation("用户获取任务工单分页列表")
   @GetMapping("/task_order/process/page")
   public ResultVO taskOrderPage(
      Long projectId,
      Long monomerId,
      Long areaId,
      String orderNumber,
      @RequestParam(name = "sort", required = false) String sort,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "15") Integer pageSize
   ) {
      log.info("API 调用 ：用户获取钻孔任务工单分页列表");
      return ResultBuilder.success(this.mesBuildingDrillTaskBiz.taskOrderPage(projectId, monomerId, areaId, orderNumber, sort, pageNumber, pageSize));
   }

   @ApiOperation("获取钻孔任务详情")
   @GetMapping("/task_order/detail")
   public ResultVO taskOrderDetail(Long taskOrderId, Long monomerId, Long areaId) {
      log.info("API 调用 ：获取钻孔任务详情");
      return ResultBuilder.success(this.mesBuildingDrillTaskBiz.taskOrderDetail(taskOrderId, monomerId, areaId));
   }

   @ApiOperation("获取钻孔切割任务历史记录详情")
   @GetMapping("/task_order/detailHistory")
   public ResultVO taskOrderDetailHistory(
      @RequestParam(name = "startDate", required = false) LocalDateTime startDate,
      @RequestParam(name = "endDate", required = false) LocalDateTime endDate,
      @RequestParam(name = "processType", required = false) Integer processType,
      @RequestParam(name = "taskTypeEnum", required = false) Integer taskTypeEnum,
      @RequestParam(name = "serialNumber", required = false) String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：获取半自动切割任务详情");
      return ResultBuilder.success(
         this.mesBuildingDrillTaskBiz.taskOrderDetailHistory(startDate, endDate, taskTypeEnum, processType, serialNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("修改零件打标状态")
   @GetMapping("/task_order/updatePartLabelStatus")
   public ResultVO updatePartLabelStatus(Long id) {
      log.info("API 调用 ：修改零件打标状态");
      return ResultBuilder.success(this.mesBuildingDrillTaskBiz.updatePartLabelStatus(id));
   }
}
