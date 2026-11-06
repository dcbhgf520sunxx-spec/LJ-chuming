package com.hzchum.scim.rest.controller.mes.building.report;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.ProjectProductionStatisticsBiz.MesDailyProductionStatisticsBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.ProjectProductionStatistics.MesDailyProductionTaskDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.ProjectProductionStatistics.ProjectProductionStatisticsDOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "当日产量统计")
@RestController
@RequestMapping("/api/mes/building/daily/statistics")
public class MesDailyProductionStatisticsController {
   private static final Logger log = LoggerFactory.getLogger(MesDailyProductionStatisticsController.class);
   @Resource
   private MesDailyProductionStatisticsBiz productionStatisticsBiz;

   @ApiOperation("获取当日产量统计-车间产线列表(焊接)")
   @GetMapping("/query/condition")
   public ResultVO getProjectQueryCondition(@Valid ProjectProductionStatisticsDOParam param) {
      log.info("API 调用 ：获取当日产量统计-车间产线列表(焊接)");
      return ResultBuilder.success(new ListVO<>(this.productionStatisticsBiz.getWorkAndLineQueryCondition(param)));
   }

   @ApiOperation("获取当日产量统计汇总")
   @GetMapping("/production/task/sum")
   public ResultVO getDayProductionTaskSum(@Valid MesDailyProductionTaskDOParam param) {
      log.info("API 调用 ：获取项目生产任务汇总");
      return ResultBuilder.success(this.productionStatisticsBiz.getDayProductionTaskSum(param));
   }

   @ApiOperation("打印当日产量统计汇总")
   @GetMapping("/production/task/sum/print")
   public void printDayProductionTaskSum(@Valid MesDailyProductionTaskDOParam param, HttpServletResponse response) {
      log.info("API 调用 ：打印当日产量统计汇总");
      this.productionStatisticsBiz.printDayProductionTaskSum(param, response);
   }

   @ApiOperation("获取产量明细")
   @GetMapping("/production/detail")
   public ResultVO getProductionDetailList(
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workShopId,
      @RequestParam(required = false) Long teamId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(required = false) Long processId,
      @RequestParam Integer meteUnitEnum
   ) {
      log.info("API 调用 ：获取产量明细");
      return ResultBuilder.success(
         this.productionStatisticsBiz.getProductionDetailList(projectId, workShopId, teamId, monomerId, dateTime, processId, meteUnitEnum)
      );
   }

   @ApiOperation("打印产量明细")
   @GetMapping("/production/detail/print")
   public ResultVO printProductionDetailList(
      @RequestParam(required = false) Long projectId,
      @RequestParam(required = false) Long workShopId,
      @RequestParam(required = false) Long teamId,
      @RequestParam(required = false) Long monomerId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(required = false) Long processId,
      @RequestParam Integer meteUnitEnum
   ) {
      log.info("API 调用 ：打印产量明细");
      return ResultBuilder.success(
         this.productionStatisticsBiz.printProductionDetailList(projectId, workShopId, teamId, monomerId, dateTime, processId, meteUnitEnum)
      );
   }

   @ApiOperation("获取打包详情")
   @GetMapping("/production/pack/detail")
   public ResultVO getPackDateailList(
      @RequestParam(required = false) Long projectId,
      Long workShopId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "50") Integer pageSize
   ) {
      log.info("API 调用 ：获取打包详情");
      return ResultBuilder.success(this.productionStatisticsBiz.getPackDateailList(projectId, workShopId, dateTime, pageNumber, pageSize));
   }

   @ApiOperation("打印打包详情")
   @GetMapping("/print/production/pack/detail")
   public ResultVO printPackDateailList(
      @RequestParam(required = false) Long projectId,
      Long workShopId,
      @RequestParam(required = false) LocalDateTime dateTime,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "500") Integer pageSize
   ) {
      log.info("API 调用 ：打印打包详情");
      return ResultBuilder.success(this.productionStatisticsBiz.printPackDateailList(projectId, workShopId, dateTime, pageNumber, pageSize));
   }
}
