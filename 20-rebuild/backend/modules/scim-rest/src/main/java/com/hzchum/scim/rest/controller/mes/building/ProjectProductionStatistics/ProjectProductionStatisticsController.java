package com.hzchum.scim.rest.controller.mes.building.ProjectProductionStatistics;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.ProjectProductionStatisticsBiz.ProjectProductionStatisticsBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.ProjectProductionStatistics.ProjectProductionStatisticsDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.ProjectProductionStatistics.ProjectProductionTaskDOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "项目生产统计")
@RestController
@RequestMapping("/api/mes/building/project/statistics")
public class ProjectProductionStatisticsController {
   private static final Logger log = LoggerFactory.getLogger(ProjectProductionStatisticsController.class);
   @Resource
   private ProjectProductionStatisticsBiz productionStatisticsBiz;

   @ApiOperation("获取项目生产统计汇总")
   @GetMapping("/production/summary")
   public ResultVO projectProductionStatisticsSum(@Valid ProjectProductionStatisticsDOParam param) {
      log.info("API 调用 ：获取产品生产统计汇总");
      return ResultBuilder.success(this.productionStatisticsBiz.projectProductionStatisticsSum(param));
   }

   @ApiOperation("获取项目生产统计详情")
   @GetMapping("/production/detail")
   public ResultVO projectProductionStatisticsDetail(@Valid ProjectProductionStatisticsDOParam param) {
      log.info("API 调用 ：获取项目生产统计详情");
      return ResultBuilder.success(this.productionStatisticsBiz.projectProductionStatisticsDetail(param));
   }

   @ApiOperation("获取项目生产统计工序列表")
   @GetMapping("/query/process")
   public ResultVO getProjectProcessList(@Valid ProjectProductionStatisticsDOParam param) {
      log.info("API 调用 ：获取项目生产统计工序列表");
      return ResultBuilder.success(new ListVO<>(this.productionStatisticsBiz.getProjectProcessList(param)));
   }

   @ApiOperation("获取项目生产统计车间产线列表")
   @GetMapping("/query/condition")
   public ResultVO getProjectQueryCondition(@Valid ProjectProductionStatisticsDOParam param) {
      log.info("API 调用 ：获取项目生产统计车间产线列表");
      return ResultBuilder.success(new ListVO<>(this.productionStatisticsBiz.getProjectQueryCondition(param)));
   }

   @ApiOperation("获取项目生产任务详情")
   @GetMapping("/production/task/detail")
   public ResultVO getPageProjectProductionTaskDetail(@Valid ProjectProductionTaskDOParam param) {
      log.info("API 调用 ：获取项目生产统计详情");
      return ResultBuilder.success(this.productionStatisticsBiz.getPageProjectProductionTaskDetail(param));
   }

   @ApiOperation("获取项目生产任务汇总")
   @GetMapping("/production/task/sum")
   public ResultVO getProjectProductionTaskSum(@Valid ProjectProductionTaskDOParam param) {
      log.info("API 调用 ：获取项目生产任务汇总");
      return ResultBuilder.success(this.productionStatisticsBiz.getProjectProductionTaskSum(param));
   }

   @ApiOperation("打印项目生产任务详情")
   @GetMapping("/production/task/detail/print")
   public ResultVO printProjectProductionTaskDetail(@Valid ProjectProductionTaskDOParam param) {
      log.info("API 调用 ：打印项目生产任务详情");
      return ResultBuilder.success(this.productionStatisticsBiz.printProjectProductionTaskDetail(param));
   }

   @ApiOperation("获取项目生产班组任务详情")
   @GetMapping("/production/task/team/detail")
   public ResultVO getPageProjectProductionTaskTeamDetail(@Valid ProjectProductionTaskDOParam param) {
      log.info("API 调用 ：获取项目生产班组任务详情");
      return ResultBuilder.success(this.productionStatisticsBiz.getPageProjectProductionTaskTeamDetail(param));
   }

   @ApiOperation("获取项目班组生产任务汇总")
   @GetMapping("/production/task/team/sum")
   public ResultVO getProjectProductionTaskTeamSum(@Valid ProjectProductionTaskDOParam param) {
      log.info("API 调用 ：获取项目班组生产任务汇总");
      return ResultBuilder.success(this.productionStatisticsBiz.getProjectProductionTaskTeamSum(param));
   }

   @ApiOperation("打印项目班组生产任务详情")
   @GetMapping("/production/team/detail/print")
   public ResultVO printProjectProductionTaskTeamDetail(@Valid ProjectProductionTaskDOParam param) {
      log.info("API 调用 ：打印项目班组生产任务详情");
      return ResultBuilder.success(this.productionStatisticsBiz.printProjectProductionTaskTeamDetail(param));
   }
}
