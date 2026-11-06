package com.hzchum.scim.rest.controller.mes.building.workshopKanban;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.workshopKanban.WorkshopKanbanBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "车间看板")
@RestController
@RequestMapping("/api/mes/workshop/kanban/")
public class WorkshopKanbanController {
   private static final Logger log = LoggerFactory.getLogger(WorkshopKanbanController.class);
   @Resource
   private WorkshopKanbanBiz workshopKanbanBiz;

   @ApiOperation("车间任务达成率分析")
   @GetMapping("/complete/rate")
   public ResultVO getWorkShopTaskPercentageComplete(LocalDateTime date) {
      log.info("API 调用 ：车间任务达成率分析");
      return ResultBuilder.success(this.workshopKanbanBiz.getWorkShopTaskPercentageComplete(date));
   }

   @ApiOperation("班组任务达成率分析")
   @GetMapping("/team/complete/rate")
   public ResultVO getTeamTaskPercentageComplete(Long workShopId, Long processId, LocalDateTime time) {
      log.info("API 调用 ：班组任务达成率分析");
      return ResultBuilder.success(this.workshopKanbanBiz.getTeamTaskPercentageComplete(workShopId, processId, time));
   }

   @ApiOperation("车间项目详细达成率")
   @GetMapping("/complete/detail")
   public ResultVO findTaskPercentageDetail(LocalDateTime date, Long workShopId) {
      log.info("API 调用 ：车间项目详细达成率");
      return ResultBuilder.success(this.workshopKanbanBiz.findTaskPercentageDetail(date, workShopId));
   }

   @ApiOperation("班组项目详细达成率")
   @GetMapping("/team/complete/detail")
   public ResultVO findTeamPercentageDetail(LocalDateTime date, Long workShopId, Long processId, Long teamId) {
      log.info("API 调用 ：班组项目详细达成率");
      return ResultBuilder.success(this.workshopKanbanBiz.findTeamPercentageDetail(date, workShopId, processId, teamId));
   }
}
