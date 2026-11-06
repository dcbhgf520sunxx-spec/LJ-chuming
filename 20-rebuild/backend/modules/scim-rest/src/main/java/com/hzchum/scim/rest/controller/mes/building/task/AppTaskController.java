package com.hzchum.scim.rest.controller.mes.building.task;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.task.MesBuildingTaskBiz;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "APP-MES-任务")
@RestController
@RequestMapping("/api/app/mes/building/task")
public class AppTaskController {
   private static final Logger log = LoggerFactory.getLogger(AppTaskController.class);
   @Autowired
   private MesBuildingTaskBiz mesBuildingTaskBiz;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;

   @ApiOperation("我的任务项目汇总")
   @GetMapping("/project/summary")
   public ResultVO listProductTask(String year, String month, @RequestParam Long productionLineId, @RequestParam Long processId) {
      log.info("API 调用 ：我的任务汇总");
      return ResultBuilder.success(this.mesBuildingTaskBiz.listGroupByProjectId(year, month, productionLineId, processId));
   }

   @ApiOperation("我的任务月份汇总")
   @GetMapping("/month/summary")
   public ResultVO listProductTask(String year, String month, @RequestParam Long projectId, @RequestParam Long productionLineId, @RequestParam Long processId) {
      log.info("API 调用 ：我的任务汇总");
      return ResultBuilder.success(this.mesBuildingTaskBiz.listGroupByMonth(year, month, projectId, productionLineId, processId));
   }

   @ApiOperation("我的任务-构件任务清单")
   @GetMapping("/artifact")
   public ResultVO listArtifact(
      String year,
      String month,
      @RequestParam Long projectId,
      @RequestParam Long productionLineId,
      @RequestParam Long processId,
      String name,
      String serialNumber
   ) {
      log.info("API 调用 ：我的任务-构件任务清单");
      return ResultBuilder.success(
         this.taskProcessService.listArtifactProcessByCondition(year, month, projectId, productionLineId, processId, name, serialNumber)
      );
   }

   @ApiOperation("我的任务-围护任务清单")
   @GetMapping("/enclosure")
   public ResultVO listEnclosure(
      String year,
      String month,
      @RequestParam Long projectId,
      @RequestParam Long productionLineId,
      @RequestParam Long processId,
      String name,
      String serialNumber
   ) {
      log.info("API 调用 ：我的任务-围护任务清单");
      return ResultBuilder.success(
         this.taskProcessService.listEnclosureProcessByCondition(year, month, projectId, productionLineId, processId, name, serialNumber)
      );
   }
}
