package com.hzchum.scim.rest.controller.largeScreen;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.factory.MesBuildingFactoryBiz;
import com.hzchum.scim.mes.building.core.api.biz.largesreen.NewLargeScreenBiz;
import com.hzchum.scim.mes.building.core.api.enums.WorkShopTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.factory.MesBuildingProductionLine;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.screen.ScreenMonthlyOutputVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.screen.ScreenProductionStatisticsVO;
import com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.screen.ScreenTeamAchievementRateProductionLineVO;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingProductionLineService;
import com.hzchum.scim.mes.building.core.api.service.factory.MesBuildingWorkshopService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskProcessService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDateTime;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "新大屏接口")
@RestController
@RequestMapping("/api/largeScreen/new")
public class NewLargeScreenController {
   private static final Logger log = LoggerFactory.getLogger(NewLargeScreenController.class);
   @Autowired
   private NewLargeScreenBiz screenBiz;
   @Autowired
   private MesBuildingTaskProcessService taskProcessService;
   @Autowired
   private MesBuildingWorkshopService workshopService;
   @Autowired
   private MesBuildingFactoryBiz factoryBiz;
   @Autowired
   private MesBuildingProductionLineService productionLineService;

   @ApiOperation("查询车间列表")
   @GetMapping("/workshop/simple")
   public ResultVO listWorkShop(Long factoryId) {
      log.info("API 调用 ：查询车间列表");
      return ResultBuilder.success(this.workshopService.listWorkShopSimple(factoryId, WorkShopTypeEnum.BUILDING.getType()));
   }

   @ApiOperation("以项目为维度零件，部件，部件工序完成率")
   @GetMapping("/getProjectProcessCompletionRate")
   public ResultVO getProjectProcessCompletionRate(
      @RequestParam(name = "年份", required = false) String year, @RequestParam(name = "车间ID", required = false) Long workshopId
   ) {
      log.info("API 调用 ：以项目为维度零件，部件，部件工序完成率");
      Object processCompletionRate = this.taskProcessService.getProjectProcessCompletionRate(year, workshopId);
      return ResultBuilder.success(processCompletionRate);
   }

   @ApiOperation("当日班组产量统计")
   @GetMapping("/getProductionStatistics")
   public ResultVO<List<ScreenProductionStatisticsVO>> getProductionStatistics(
      @RequestParam(name = "year", required = false) String year, @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：当日班组产量统计");
      List<ScreenProductionStatisticsVO> productionStatistics = this.taskProcessService.getProductionStatistics(year, workshopId);
      return ResultBuilder.success(productionStatistics);
   }

   @ApiOperation("班组达成率")
   @GetMapping("/getTeamAchievementRate")
   public ResultVO<List<ScreenTeamAchievementRateProductionLineVO>> getTeamAchievementRate(
      @RequestParam(name = "year", required = false) String year, @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：当日班组产量统计");
      List<ScreenTeamAchievementRateProductionLineVO> productionStatistics = this.taskProcessService.getTeamAchievementRate(year, workshopId);
      return ResultBuilder.success(productionStatistics);
   }

   @ApiOperation("月度产量前三排名")
   @GetMapping("/getMonthlyOutput")
   public ResultVO<List<ScreenMonthlyOutputVO>> getMonthlyOutput(
      @RequestParam(name = "year", required = false) String year,
      @RequestParam(name = "month", required = false) String month,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：月度产量前三排名");
      List<ScreenMonthlyOutputVO> productionStatistics = this.taskProcessService.getMonthlyOutput(year, month, workshopId);
      return ResultBuilder.success(productionStatistics);
   }

   @ApiOperation("获取头部汇总")
   @GetMapping("/header/summary")
   public ResultVO<?> getHeaderLargeScreenSummaryDTO(String year, Long workshopId) {
      log.info("API 调用 ：获取头部汇总");
      return ResultBuilder.success(this.screenBiz.getHeaderLargeScreenSummaryDTO(year, workshopId));
   }

   @ApiOperation("获取车间达成率分析")
   @GetMapping("/workshop/achievement_rate")
   public ResultVO<?> findWorkshopAchievements(String year, Long workshopId) {
      log.info("API 调用 ：获取车间达成率分析");
      return ResultBuilder.success(this.screenBiz.findWorkshopAchievements(workshopId, year));
   }

   @ApiOperation("车间月度产量统计")
   @GetMapping("/workshop/production_statistics")
   public ResultVO<?> findAchievementGroupWorkshop(String year) {
      log.info("API 调用 ：车间月度产量统计");
      return ResultBuilder.success(this.screenBiz.findAchievementGroupWorkshop(year));
   }

   @ApiOperation("班组质量问题排名")
   @GetMapping("/qhse/rank")
   public ResultVO<?> findTeamQhseQuantity(String year, Long workshopId) {
      log.info("API 调用 ：班组质量问题排名");
      return ResultBuilder.success(this.screenBiz.findTeamQhseQuantity(workshopId, year));
   }

   @ApiOperation("年度质量事件分析")
   @GetMapping("/qhse_analysis/year")
   public ResultVO<?> findQhseQuantityGroupQhseType(String year, Long workshopId) {
      log.info("API 调用 ：年度质量事件分析");
      return ResultBuilder.success(this.screenBiz.findQhseQuantityGroupQhseType(workshopId, year));
   }

   @ApiOperation("质量问题提醒")
   @GetMapping("/qhse/warn")
   public ResultVO<?> findQhseWarnToDay(Long workshopId) {
      log.info("API 调用 ：质量问题提醒");
      return ResultBuilder.success(this.screenBiz.findQhseWarnToDay(workshopId));
   }

   @ApiOperation("项目分析数据")
   @GetMapping("/project/analysis")
   public ResultVO<?> findProjectAnalysisDataDTO(Long workshopId, String year) {
      log.info("API 调用 ：项目分析数据");
      return ResultBuilder.success(this.screenBiz.findProjectAnalysisDataDTO(workshopId, year));
   }

   @ApiOperation("项目钢材领用")
   @GetMapping("/project/steel/acceptance")
   public ResultVO<?> findProjectSteelRearing(Long workshopId, String year) {
      log.info("API 调用 ：项目钢材领用");
      return ResultBuilder.success(this.screenBiz.findProjectSteelRearing(workshopId, year));
   }

   @ApiOperation("铆焊班组实时任务状态")
   @GetMapping("/workshop/team_task/status")
   public ResultVO<?> findTeamProjectProduceInfo(LocalDateTime year, Long workShopId, Long productionId) {
      log.info("API 调用 ：铆焊班组实时任务状态");
      return ResultBuilder.success(this.screenBiz.findTeamProjectProduceInfo(year, workShopId, productionId));
   }

   @ApiOperation("班组产量动态")
   @GetMapping("/workshop/team/produce")
   public ResultVO<?> findTeamProduceInfo(LocalDateTime year, Long workshopId, Long productionId) {
      log.info("API 调用 ：班组产量动态");
      return ResultBuilder.success(this.screenBiz.findTeamProduceInfo(year, workshopId, productionId));
   }

   @ApiOperation("车间产量动态")
   @GetMapping("/workshop/produce")
   public ResultVO<?> findWorkshopProjectProduceInfo(LocalDateTime year, Long workshopId, Long productionId) {
      log.info("API 调用 ：车间产量动态");
      return ResultBuilder.success(this.screenBiz.findWorkshopProjectProduceInfo(year, workshopId, productionId));
   }

   @ApiOperation("项目加工进度")
   @GetMapping("/workshop/project/processing")
   public ResultVO<?> projectProcessingProgress(LocalDateTime year, Long workshopId, Long productionId) {
      log.info("API 调用 ：项目加工进度");
      return ResultBuilder.success(this.screenBiz.projectProcessingProgress(year, workshopId, productionId));
   }

   @ApiOperation("本月实时入库数据")
   @GetMapping("/workshop/current_month/inbound")
   public ResultVO<?> getProjectInboundCurrentMonth(Long workshopId, Long productionId) {
      log.info("API 调用 ：本月实时入库数据");
      return ResultBuilder.success(this.screenBiz.getProjectInboundCurrentMonth(workshopId, productionId));
   }

   @ApiOperation("实时报检信息")
   @GetMapping("/workshop/inspect/realtime")
   public ResultVO<?> findInspectRealtimeInfo(Long workshopId, Long productionId) {
      log.info("API 调用 ：实时报检信息");
      return ResultBuilder.success(this.screenBiz.findInspectRealtimeInfo(workshopId, productionId));
   }

   @ApiOperation("实时发运动态")
   @GetMapping("/workshop/cargo/realtime")
   public ResultVO<?> findCargoRealtimeInfo() {
      log.info("API 调用 ：实时发运动态");
      return ResultBuilder.success(this.screenBiz.findCargoRealtimeInfo());
   }

   @ApiOperation("查询车间产线")
   @GetMapping("/workshop/List")
   public ResultVO<ListVO> ProductionLine(Long workshopId) {
      log.info("API 调用 ：查询车间产线");
      return ResultBuilder.success(
         new ListVO<>(
            this.productionLineService
               .list(
                  Wrappers.lambdaQuery(MesBuildingProductionLine.class)
                     .eq(workshopId != null, MesBuildingProductionLine::getWorkshopId, workshopId)
                     .eq(MesBuildingProductionLine::getProductType, 2)
                     .eq(MesBuildingProductionLine::getMesProductEnum, 1)
               )
         )
      );
   }

   @ApiOperation("质检管理看板头部汇总")
   @GetMapping("/insepect/header_summary")
   public ResultVO<?> findInsepectSummary(LocalDateTime date) {
      log.info("API 调用 ：质检管理看板头部汇总");
      return ResultBuilder.success(this.screenBiz.findInsepectSummary(date));
   }

   @ApiOperation("质检上报实时信息")
   @GetMapping("/inspect/report/info")
   public ResultVO<?> findInspectReportRealtime(Long workshopId) {
      log.info("API 调用 ：质检上报实时信息");
      return ResultBuilder.success(this.screenBiz.findInspectReportRealtime(workshopId));
   }

   @ApiOperation("年度质量事件分析")
   @GetMapping("/inspect/qhse/analysis_year")
   public ResultVO<?> findQualityGroupSummary(LocalDateTime year) {
      log.info("API 调用 ：年度质量事件分析");
      return ResultBuilder.success(this.screenBiz.findQualityGroupSummary(year));
   }

   @ApiOperation("月度质量问题统计")
   @GetMapping("/inspect/qhse_summary/month")
   public ResultVO<?> findQualityGroupMonthByYear(LocalDateTime year) {
      log.info("API 调用 ：月度质量问题统计");
      return ResultBuilder.success(this.screenBiz.findQualityGroupMonthByYear(year));
   }

   @ApiOperation("月度一次合格率分析")
   @GetMapping("/inspect/first_pass")
   public ResultVO<?> findMonthlyFirstPassRate(LocalDateTime year) {
      log.info("API 调用 ：月度一次合格率分析");
      return ResultBuilder.success(this.screenBiz.findMonthlyFirstPassRate(year));
   }

   @ApiOperation("质检未处理问题提醒")
   @GetMapping("/inspect/warn/qhse")
   public ResultVO<?> findTeamProduceInfo() {
      log.info("API 调用 ：质检未处理问题提醒");
      return ResultBuilder.success(this.screenBiz.findQuailyQhseAlert());
   }

   @ApiOperation("问题关闭提醒")
   @GetMapping("/inspect/warn/qhse_close")
   public ResultVO<?> findQuailyQhsePassAlert() {
      log.info("API 调用 ：问题关闭提醒");
      return ResultBuilder.success(this.screenBiz.findQuailyQhsePassAlert());
   }

   @ApiOperation("质检数量及问题统计")
   @GetMapping("/inspect/team/qhse_statistics")
   public ResultVO<?> findTeamProduceInfo(LocalDateTime year) {
      log.info("API 调用 ：质检数量及问题统计");
      return ResultBuilder.success(this.screenBiz.findQualityInspectionStatistics(year));
   }

   @ApiOperation("质检看板-班组质量问题排名")
   @GetMapping("/inspect/team/rank")
   public ResultVO<?> findTeamQhseRanking(LocalDateTime year) {
      log.info("API 调用 ：质检看板-班组质量问题排名");
      return ResultBuilder.success(this.screenBiz.findTeamQhseRanking(year));
   }

   public NewLargeScreenController(
      final NewLargeScreenBiz screenBiz,
      final MesBuildingTaskProcessService taskProcessService,
      final MesBuildingWorkshopService workshopService,
      final MesBuildingFactoryBiz factoryBiz,
      final MesBuildingProductionLineService productionLineService
   ) {
      this.screenBiz = screenBiz;
      this.taskProcessService = taskProcessService;
      this.workshopService = workshopService;
      this.factoryBiz = factoryBiz;
      this.productionLineService = productionLineService;
   }
}
