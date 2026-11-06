package com.hzchum.scim.rest.controller.mes.building.task.app;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskOrderBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-MES任务工单")
@RestController
@RequestMapping("/api/app/mes/building/task/order")
public class MesBuildingAppTaskOrderController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingAppTaskOrderController.class);
   @Autowired
   private MesBuildingTaskOrderBiz taskOrderBiz;

   @ApiOperation("零件工单跟踪列表")
   @GetMapping("/tracking/machine_part/page")
   @PreAuthorize("@permission.check('taskOrderSummary')")
   public ResultVO taskTrackMachinePartPage(
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      Long projectId,
      Integer productType,
      Integer status,
      String orderNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：零件工单跟踪列表");
      return ResultBuilder.success(
         this.taskOrderBiz
            .taskTrackMachinePartPage(dateTime, workshopId, productionLineId, projectId, null, null, productType, status, orderNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("构件工单跟踪列表")
   @GetMapping("/tracking/artifact/page")
   @PreAuthorize("@permission.check('taskOrderSummary')")
   public ResultVO taskTrackArtifactPage(
      LocalDateTime dateTime,
      Long workshopId,
      Long productionLineId,
      Long projectId,
      Integer productType,
      Integer status,
      String orderNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：构件工单跟踪列表");
      return ResultBuilder.success(
         this.taskOrderBiz
            .taskTrackArtifactPage(dateTime, workshopId, productionLineId, projectId, null, null, null, productType, status, orderNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("滞后提醒")
   @GetMapping("/dull")
   @PreAuthorize("@permission.check('lafReminder')")
   public ResultVO taskDullPage(
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber, @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：滞后提醒");
      return ResultBuilder.success(this.taskOrderBiz.taskDullPage(pageNumber, pageSize));
   }
}
