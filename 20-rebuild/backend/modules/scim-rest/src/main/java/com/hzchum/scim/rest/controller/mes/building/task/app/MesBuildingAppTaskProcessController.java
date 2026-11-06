package com.hzchum.scim.rest.controller.mes.building.task.app;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskProcessBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-MES任务工序")
@RestController
@RequestMapping("/api/app/mes/building/task/process")
public class MesBuildingAppTaskProcessController {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingAppTaskProcessController.class);
   @Autowired
   private MesBuildingTaskProcessBiz taskProcessBiz;

   @ApiOperation("零件工序进度")
   @GetMapping("/machine_part/process")
   @PreAuthorize("@permission.check('taskOrderSummary')")
   public ResultVO taskMachinePartProcess(Long topTaskOrderId, Long workshopId, Long productionLineId, Integer productType) {
      log.info("API 调用 ：零件工序进度");
      return ResultBuilder.success(this.taskProcessBiz.taskMachinePartProcess(topTaskOrderId, null, null, null, workshopId, productionLineId, productType));
   }

   @ApiOperation("构件部件工序进度")
   @GetMapping("/artifact/process")
   @PreAuthorize("@permission.check('taskOrderSummary')")
   public ResultVO taskArtifactProcess(Long topTaskOrderId, Long workshopId, Long productionLineId) {
      log.info("API 调用 ：构件部件工序进度");
      return ResultBuilder.success(this.taskProcessBiz.taskArtifactProcess(topTaskOrderId, null, null, null, workshopId, productionLineId));
   }

   @ApiOperation("获取智能线构件工序进度")
   @GetMapping("/artifact/page")
   public ResultVO taskArtifactPage(
      Long topTaskOrderId,
      Long workshopId,
      Long productionLineId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：获取智能线构件工序进度");
      return ResultBuilder.success(this.taskProcessBiz.taskArtifactPage(topTaskOrderId, null, null, null, workshopId, productionLineId, pageNumber, pageSize));
   }

   @ApiOperation("工序进度详情-分页")
   @GetMapping("/product/page")
   @PreAuthorize("@permission.check('taskOrderSummary','lafReminder')")
   public ResultVO taskProcessProductPage(
      Long processId,
      Integer taskType,
      Long orderId,
      Long groupId,
      String name,
      Long monomerId,
      Long areaId,
      String serialNumber,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：工序进度详情-分页");
      return ResultBuilder.success(
         this.taskProcessBiz.appTaskProcessProductPage(processId, taskType, orderId, groupId, name, monomerId, areaId, serialNumber, pageNumber, pageSize)
      );
   }

   @ApiOperation("构件部件滞后提醒工序进度")
   @GetMapping("/dull/process/artifact")
   @PreAuthorize("@permission.check('lafReminder')")
   public ResultVO taskDullProcesslArtifact(Long topTaskOrderId, Long workshopId, Long productionLineId) {
      log.info("API 调用 ：构件部件滞后提醒工序进度");
      return ResultBuilder.success(this.taskProcessBiz.taskDullArtifact(topTaskOrderId, workshopId, productionLineId));
   }

   @ApiOperation("零件滞后提醒工序进度")
   @GetMapping("/dull/process")
   public ResultVO taskDullProcesslMachine(Long topTaskOrderId, Long workshopId, Long productionLineId, Integer productType) {
      log.info("API 调用 ：零件滞后提醒工序进度");
      return ResultBuilder.success(this.taskProcessBiz.taskDullMachine(topTaskOrderId, workshopId, productionLineId, productType));
   }

   @ApiOperation("滞后提醒工序进度详情")
   @GetMapping("/product/dull")
   public ResultVO taskDullProcessDetailPage(
      Long processId,
      Integer taskType,
      Long orderId,
      Long groupId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "10") Integer pageSize
   ) {
      log.info("API 调用 ：滞后提醒工序进度详情");
      return ResultBuilder.success(this.taskProcessBiz.taskDullProductProcessDetailPage(processId, taskType, orderId, groupId, pageNumber, pageSize));
   }
}
