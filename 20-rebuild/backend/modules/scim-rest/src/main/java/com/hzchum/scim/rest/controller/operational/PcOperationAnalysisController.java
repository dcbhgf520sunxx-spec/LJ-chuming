package com.hzchum.scim.rest.controller.operational;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.operational.analysis.core.api.biz.NewOperationAnalysisBiz;
import com.hzchum.scim.operational.analysis.core.api.biz.ProduceAchievementBiz;
import com.hzchum.scim.operational.analysis.core.api.biz.WarehouseDataAnalysisBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "运营分析（辅材/生产/仓库）分析")
@RestController
@RequestMapping("/api/pc/operational/analysis")
public class PcOperationAnalysisController {
   private static final Logger log = LoggerFactory.getLogger(PcOperationAnalysisController.class);
   @Resource
   private ProduceAchievementBiz produceAchievementBiz;
   @Resource
   private NewOperationAnalysisBiz newOperationAnalysisBiz;
   @Resource
   private WarehouseDataAnalysisBiz warehouseDataAnalysisBiz;

   @ApiOperation("COST-累计汇总")
   @GetMapping("/yearsSummary")
   @PreAuthorize("@permission.check('cost_analysis:get')")
   public ResultVO getYearsSummary(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：累计汇总");
      return ResultBuilder.success(this.newOperationAnalysisBiz.getYearsSummary(yearDate, branchCompanyId, workshopId));
   }

   @ApiOperation("COST-成本分析(饼图)")
   @GetMapping("/materialCost")
   @PreAuthorize("@permission.check('cost_analysis:get')")
   public ResultVO getProductionCostAnalysisSummary(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：成本分析(饼图)");
      return ResultBuilder.success(this.newOperationAnalysisBiz.getProductionCostAnalysisSummary(yearDate, branchCompanyId, workshopId));
   }

   @ApiOperation("COST-近三年综合平均单价")
   @GetMapping("/threeYearsAvgInfo")
   @PreAuthorize("@permission.check('cost_analysis:get')")
   public ResultVO getThreeYearsAvgInfo(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：近三年综合平均单价");
      return ResultBuilder.success(this.newOperationAnalysisBiz.getThreeYearsAvgInfo(yearDate, branchCompanyId, workshopId));
   }

   @ApiOperation("COST-成本明细表(列表)")
   @GetMapping("/costList")
   @PreAuthorize("@permission.check('cost_analysis:get')")
   public ResultVO getProductionCostAnalysisV2(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：成本明细表(列表)");
      return ResultBuilder.success(this.newOperationAnalysisBiz.getProductionCostAnalysisV2(yearDate, branchCompanyId, workshopId));
   }

   @ApiOperation("COST-成本明细表(下载)")
   @GetMapping("/downloadCost")
   @PreAuthorize("@permission.check('cost_analysis:download')")
   public void downloadProductionCostAnalysisV2(
      HttpServletResponse response,
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：成本明细表(下载)");
      this.newOperationAnalysisBiz.downloadProductionCostAnalysisV2(response, yearDate, branchCompanyId, workshopId);
   }

   @ApiOperation("MES-累计产量-去年同期")
   @GetMapping("/production")
   @PreAuthorize("@permission.check('production_performance_dashboard:get')")
   public ResultVO productionAnalysis(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：累计产量-去年同期");
      return ResultBuilder.success(this.produceAchievementBiz.getProductionSummary(yearDate, branchCompanyId, workshopId));
   }

   @ApiOperation("MES-目标产量达成率")
   @GetMapping("/targetRatio")
   @PreAuthorize("@permission.check('production_performance_dashboard:get')")
   public ResultVO getTargetRatio(
      @RequestParam(name = "yearDate") LocalDate dateTime,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：目标产量达成率");
      return ResultBuilder.success(this.produceAchievementBiz.getTargetRatio(dateTime, branchCompanyId, workshopId));
   }

   @ApiOperation("MES-目标产量达成率分析(列表)")
   @GetMapping("/targetProductionAnalysis")
   @PreAuthorize("@permission.check('workshop_mete_dashboard:detail')")
   public ResultVO getTargetProductionAnalysis(
      @RequestParam(name = "yearDate") LocalDate dateTime,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：目标产量达成率分析(列表)");
      return ResultBuilder.success(this.produceAchievementBiz.getTargetProductionAnalysis(dateTime, branchCompanyId, workshopId));
   }

   @ApiOperation("MES-目标产量达成率分析-下载)")
   @GetMapping("/targetProductionAnalysis/download")
   @PreAuthorize("@permission.check('workshop_mete_dashboard:download')")
   public void downloadTargetProductionAnalysis(
      @RequestParam(name = "yearDate") LocalDate dateTime,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：目标产量达成率分析-下载");
      this.produceAchievementBiz.downloadTargetProductionAnalysis(dateTime, branchCompanyId, workshopId);
   }

   @ApiOperation("MES-车间月度产量")
   @GetMapping("/productionMonthly")
   @PreAuthorize("@permission.check('production_performance_dashboard:get')")
   public ResultVO getProductionMonthly(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：车间月度产量");
      return ResultBuilder.success(this.produceAchievementBiz.getProductionMonthly(yearDate, branchCompanyId, workshopId));
   }

   @ApiOperation("MES-日产量统计")
   @GetMapping("/productionDay")
   @PreAuthorize("@permission.check('production_performance_dashboard:get')")
   public ResultVO getProductionDay(
      @RequestParam(name = "yearDate", required = false) LocalDate yearDate,
      @RequestParam(name = "mouthDate") LocalDate mouthDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：日产量统计");
      return ResultBuilder.success(this.produceAchievementBiz.getProductionDay(yearDate, mouthDate, branchCompanyId, workshopId));
   }

   @ApiOperation("MES-月/日产量统计(列表)")
   @GetMapping("/projectMete")
   @PreAuthorize("@permission.check('workshop_mete_dashboard:detail')")
   public ResultVO getProjectMete(
      @RequestParam(name = "yearDate") LocalDate dateTime,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam Boolean isMonthly
   ) {
      log.info("API 调用 ：月/日产量统计(列表)");
      return ResultBuilder.success(this.produceAchievementBiz.getProjectMete(dateTime, branchCompanyId, workshopId, isMonthly));
   }

   @ApiOperation("MES-月/日产量统计-下载")
   @GetMapping("/projectMete/download")
   @PreAuthorize("@permission.check('workshop_mete_dashboard:download')")
   public void getProjectMeteDownload(
      @RequestParam(name = "yearDate") LocalDate dateTime,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam Boolean isMonthly
   ) {
      log.info("API 调用 ：月/日产量统计-下载");
      this.produceAchievementBiz.getProjectMeteDownload(dateTime, branchCompanyId, workshopId, isMonthly);
   }

   @ApiOperation("MES-车间任务达成率")
   @GetMapping("/taskAccomplished")
   @PreAuthorize("@permission.check('production_performance_dashboard:get','workshop_task_dashboard:detail')")
   public ResultVO getTaskAccomplished(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：车间任务达成率");
      return ResultBuilder.success(this.produceAchievementBiz.getYearSchedulingProductionInfo(yearDate, branchCompanyId, workshopId));
   }

   @ApiOperation("MES-年度任务达成率-下载")
   @GetMapping("/taskAccomplished/download")
   @PreAuthorize("@permission.check('workshop_task_dashboard:download')")
   public void getYearSchedulingProductionInfoDownload(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：年度任务达成率");
      this.produceAchievementBiz.getYearSchedulingProductionInfoDownload(yearDate, branchCompanyId, workshopId);
   }

   @ApiOperation("MES-车间任务达成率分析")
   @GetMapping("/taskAccomplishedList")
   @PreAuthorize("@permission.check('workshop_task_dashboard:detail')")
   public ResultVO getProjectSchedulingProductionInfo(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：车间任务达成率分析");
      return ResultBuilder.success(this.produceAchievementBiz.getProjectSchedulingProductionInfo(yearDate, branchCompanyId, workshopId));
   }

   @ApiOperation("MES-月度任务达成率-下载")
   @GetMapping("/taskAccomplishedList/download")
   @PreAuthorize("@permission.check('workshop_task_dashboard:download')")
   public void getProjectSchedulingProductionInfoDownload(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：月度任务达成率");
      this.produceAchievementBiz.getProjectSchedulingProductionInfoDownload(yearDate, branchCompanyId, workshopId);
   }

   @ApiOperation("MES-班组产量统计")
   @GetMapping("/teamProduce")
   public ResultVO getTeamProduceOperateAnalyse(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "processId", required = false) Long processId
   ) {
      log.info("API 调用 ：班组产量统计");
      return ResultBuilder.success(this.produceAchievementBiz.getTeamProduceOperateAnalyse(yearDate, branchCompanyId, workshopId, processId));
   }

   @ApiOperation("MES-班组产量统计(列表)")
   @GetMapping("/teamProduceDetails")
   public ResultVO getTeamProduceDetailsOperateAnalyse(
      @RequestParam(name = "startDate", required = false) LocalDate startDate,
      @RequestParam(name = "endDate", required = false) LocalDate endDate,
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam Long teamId,
      @RequestParam Integer taskTypeEnum,
      @RequestParam Long processId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：班组产量统计(列表)");
      return ResultBuilder.success(
         this.produceAchievementBiz
            .getTeamProduceDetailsOperateAnalyse(
               yearDate, startDate, endDate, branchCompanyId, workshopId, teamId, taskTypeEnum, processId, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("MES-班组产量统计-下载")
   @GetMapping("/teamProduceDetails/download")
   public void getTeamProduceDetailsOperateAnalyseDownload(
      @RequestParam(name = "startDate", required = false) LocalDate startDate,
      @RequestParam(name = "endDate", required = false) LocalDate endDate,
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam Long teamId,
      @RequestParam Integer taskTypeEnum,
      @RequestParam Long processId
   ) {
      log.info("API 调用 ：班组产量统计-下载");
      this.produceAchievementBiz
         .getTeamProduceDetailsOperateAnalyseDownload(yearDate, startDate, endDate, branchCompanyId, workshopId, teamId, taskTypeEnum, processId);
   }

   @ApiOperation("MES-构件类型统计")
   @GetMapping("/productionType")
   public ResultVO getTeamProduceOperateAnalyse(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "productType", required = false) Integer productType,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId
   ) {
      log.info("API 调用 ：构件类型统计");
      return ResultBuilder.success(this.produceAchievementBiz.productionTypeAnalysisV2(yearDate, productType, branchCompanyId));
   }

   @ApiOperation("MES-月度人均产量")
   @GetMapping("/avgProduction")
   @PreAuthorize("@permission.check('production_performance_dashboard:get')")
   public ResultVO getAvgProduction(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：人均产量");
      return ResultBuilder.success(this.produceAchievementBiz.getAvgProduction(yearDate, branchCompanyId, workshopId));
   }

   @ApiOperation("MES-年度人均产量")
   @GetMapping("/avgYearProduction")
   @PreAuthorize("@permission.check('production_performance_dashboard:get')")
   public ResultVO getAvgProductionYear(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：人均产量");
      return ResultBuilder.success(this.produceAchievementBiz.getAvgProductionYear(yearDate, branchCompanyId, workshopId));
   }

   @ApiOperation("MES-主材损耗")
   @GetMapping("/mainOutMete")
   @PreAuthorize("@permission.check('production_performance_dashboard:get','loss_dashboard:detail')")
   public ResultVO getMainOutMete(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：主材损耗");
      return ResultBuilder.success(this.produceAchievementBiz.getMainOutMeteV2(yearDate, branchCompanyId, workshopId));
   }

   @ApiOperation("MES-主材损耗下载")
   @GetMapping("/mainOutMete/download")
   @PreAuthorize("@permission.check('loss_dashboard:download')")
   public void getMainOutMeteDownload(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：主材损耗下载");
      this.produceAchievementBiz.getMainOutMeteDownload(yearDate, branchCompanyId, workshopId);
   }

   @ApiOperation("MES-主材损耗详情")
   @GetMapping("/mainOutMeteDetails")
   public ResultVO getMaterialLossDetails(
      @RequestParam(name = "mouthDate") LocalDate mouthDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：主材损耗详情");
      return ResultBuilder.success(this.produceAchievementBiz.getMaterialLossDetails(mouthDate, branchCompanyId, workshopId));
   }

   @ApiOperation("MES-主材损耗详情V2")
   @GetMapping("/mainOutMeteDetailsV2")
   @PreAuthorize("@permission.check('production_performance_dashboard:get','loss_dashboard:detail')")
   public ResultVO getMaterialLossDetailsV2(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：主材损耗详情V2");
      return ResultBuilder.success(this.produceAchievementBiz.getMaterialLossDetailsV2(yearDate, branchCompanyId, workshopId));
   }

   @ApiOperation("MES-主材损耗详情下载")
   @GetMapping("/mainOutMeteDetails/download")
   @PreAuthorize("@permission.check('loss_dashboard:download')")
   public void getMaterialLossDetailsDownload(
      @RequestParam(name = "mouthDate") LocalDate mouthDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：主材损耗详情下载");
      this.produceAchievementBiz.getMaterialLossDetailsDownload(mouthDate, branchCompanyId, workshopId);
   }

   @ApiOperation("WMS-(钢材)实时库存-图形")
   @GetMapping("/classifyInventory")
   public ResultVO getOperationsAnalysisInventory(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：实时库存-图形");
      return ResultBuilder.success(this.warehouseDataAnalysisBiz.getSteelsInventoryInventory(yearDate, branchCompanyId, workshopId));
   }

   @ApiOperation("WMS-(辅材/办公用品)实时库存-图形")
   @GetMapping("/auxiliaryOrOther")
   public ResultVO getAuxiliaryOrOther(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "basicClass") Integer basicClass,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：实时库存-图形");
      return ResultBuilder.success(this.warehouseDataAnalysisBiz.getAuxiliaryOrOtherInventory(yearDate, basicClass, branchCompanyId, workshopId));
   }

   @ApiOperation("WMS-(钢材/辅材/办公用品)实时库存统计详情-表单")
   @GetMapping("/inventorySimpleDTOList")
   public ResultVO getInventorySimpleDTOList(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "basicClass") Integer basicClass,
      @RequestParam(name = "classifyId", required = false) Long classifyId,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：(钢材/辅材/办公用品)实时库存统计详情-表单");
      return ResultBuilder.success(
         this.warehouseDataAnalysisBiz.getInventorySimpleDTOPage(yearDate, basicClass, classifyId, branchCompanyId, workshopId, pageNumber, pageSize)
      );
   }

   @ApiOperation("WMS-年度库存详情-下载")
   @GetMapping("/inventorySimpleDTOList/download")
   public void getInventorySimpleDTODownload(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "basicClass") Integer basicClass,
      @RequestParam(name = "classifyId", required = false) Long classifyId,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：WMS-年度库存详情-下载");
      this.warehouseDataAnalysisBiz.getInventorySimpleDTODownload(yearDate, basicClass, classifyId, branchCompanyId, workshopId);
   }

   @ApiOperation("WMS-各月库存分析-图形")
   @GetMapping("/inventoryGroupByMonth")
   public ResultVO getOperationsAnalysisInventoryGroupByMonth(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "basicClass", required = false, defaultValue = "399") Integer basicClass,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：各月库存分析-图形");
      return ResultBuilder.success(this.warehouseDataAnalysisBiz.getOperationsAnalysisInventoryGroupByMonth(yearDate, basicClass, branchCompanyId, workshopId));
   }

   @ApiOperation("WMS-各月库存分析详情(表单)")
   @GetMapping("/inventoryMonthSimpleDTOList")
   public ResultVO getOperationsAnalysisInventoryGroupByMonthPageList(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "basicClass", required = false, defaultValue = "399") Integer basicClass,
      @RequestParam(name = "classifyId", required = false) Long classifyId,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：各月库存分析详情(列表)");
      return ResultBuilder.success(
         this.warehouseDataAnalysisBiz
            .getOperationsAnalysisInventoryGroupByMonthPageList(yearDate, basicClass, classifyId, branchCompanyId, workshopId, pageNumber, pageSize)
      );
   }

   @ApiOperation("WMS-月度库存详情-下载")
   @GetMapping("/inventoryMonthSimpleDTOList/download")
   public void getOperationsAnalysisInventoryGroupByMonthDownload(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "basicClass", required = false, defaultValue = "399") Integer basicClass,
      @RequestParam(name = "classifyId", required = false) Long classifyId,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：月度库存详情-下载");
      this.warehouseDataAnalysisBiz.getOperationsAnalysisInventoryGroupByMonthDownload(yearDate, basicClass, classifyId, branchCompanyId, workshopId);
   }

   @ApiOperation("WMS-钢材出入库数据统计-图形")
   @GetMapping("/mainMaterialOutInMete")
   @PreAuthorize("@permission.check('stock_analysis:get','steel_statistics:detail')")
   public ResultVO getMainMaterialOutInMete(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "basicClass", defaultValue = "263", required = false) Integer basicClass,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：钢材出入库数据统计");
      return ResultBuilder.success(this.warehouseDataAnalysisBiz.getMainMaterialOutInMete(basicClass, yearDate, branchCompanyId, workshopId));
   }

   @ApiOperation("WMS-辅材出入库数据统计-图形")
   @GetMapping("/auxiliaryMaterialOutInMete")
   @PreAuthorize("@permission.check('stock_analysis:get','auxiliary_statistics:detail')")
   public ResultVO getAuxiliaryMaterialOutInMete(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "classifyId", required = false) Long classifyId,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：辅材出入库数据统计");
      return ResultBuilder.success(this.warehouseDataAnalysisBiz.getAuxiliaryMaterialOutInMete(classifyId, yearDate, branchCompanyId, workshopId));
   }

   @ApiOperation("WMS-钢材/辅材出库统计-表单")
   @GetMapping("/materialOutRecord")
   public ResultVO getMaterialOutRecord(
      @RequestParam(name = "mouthDate") LocalDate mouthDate,
      @RequestParam(name = "basicClass", defaultValue = "263", required = false) Integer basicClass,
      @RequestParam(name = "classifyId", required = false) Long classifyId,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：钢材/辅材出库统计");
      return ResultBuilder.success(
         this.warehouseDataAnalysisBiz.getMaterialOutRecord(basicClass, classifyId, mouthDate, branchCompanyId, workshopId, pageNumber, pageSize)
      );
   }

   @ApiOperation("WMS-钢材/辅材出库统计-下载")
   @GetMapping("/materialOutRecord/download")
   public void getMaterialOutRecordDownload(
      @RequestParam(name = "mouthDate") LocalDate mouthDate,
      @RequestParam(name = "basicClass", defaultValue = "263", required = false) Integer basicClass,
      @RequestParam(name = "classifyId", required = false) Long classifyId,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：钢材/辅材出库统计-下载");
      this.warehouseDataAnalysisBiz.getMaterialOutRecordDownload(basicClass, classifyId, mouthDate, branchCompanyId, workshopId);
   }

   @ApiOperation("WMS-钢材/辅材入库统计-表单")
   @GetMapping("/materialInRecord")
   public ResultVO getMaterialInRecord(
      @RequestParam(name = "mouthDate") LocalDate mouthDate,
      @RequestParam(name = "basicClass", defaultValue = "263", required = false) Integer basicClass,
      @RequestParam(name = "classifyId", required = false) Long classifyId,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：钢材/辅材入库统计");
      return ResultBuilder.success(
         this.warehouseDataAnalysisBiz.getMaterialInRecord(basicClass, classifyId, mouthDate, branchCompanyId, workshopId, pageNumber, pageSize)
      );
   }

   @ApiOperation("WMS-钢材/辅材入库统计-下载")
   @GetMapping("/materialInRecord/download")
   public void getMaterialInRecordDownload(
      @RequestParam(name = "mouthDate") LocalDate mouthDate,
      @RequestParam(name = "basicClass", defaultValue = "263", required = false) Integer basicClass,
      @RequestParam(name = "classifyId", required = false) Long classifyId,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：钢材/辅材入库统计-下载");
      this.warehouseDataAnalysisBiz.getMaterialInRecordDownload(basicClass, classifyId, mouthDate, branchCompanyId, workshopId);
   }

   @ApiOperation("WMS-库存周转-图形表单共用")
   @GetMapping("/materialOutInCost")
   @PreAuthorize("@permission.check('stock_analysis:get','turnover_statistics:detail')")
   public ResultVO getMaterialOutInCost(
      @RequestParam LocalDate yearDate,
      @RequestParam(required = false) Integer basicClass,
      @RequestParam(required = false) Long branchCompanyId,
      @RequestParam(required = false) Long workshopId
   ) {
      log.info("API 调用 ：WMS-库存周转-图形表单共用");
      return ResultBuilder.success(this.warehouseDataAnalysisBiz.getMaterialOutInCost(basicClass, yearDate, branchCompanyId, workshopId));
   }

   @ApiOperation("WMS-库存周转-下载")
   @GetMapping("/materialOutInCost/download")
   @PreAuthorize("@permission.check('turnover_statistics:download')")
   public void getMaterialOutInCostDownload(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "basicClass", required = false) Integer basicClass,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：WMS-库存周转-下载");
      this.warehouseDataAnalysisBiz.getMaterialOutInCostDownload(basicClass, yearDate, branchCompanyId, workshopId);
   }

   @ApiOperation("WMS-项目钢材出库汇总信息")
   @GetMapping("/projectOutSummary")
   public ResultVO getProjectOutSummaryList(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "status", required = false) Integer status,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：项目钢材出库汇总信息");
      return ResultBuilder.success(this.warehouseDataAnalysisBiz.getProjectOutSummaryList(status, yearDate, branchCompanyId, workshopId));
   }

   @ApiOperation("WMS-项目钢材出库详情信息")
   @GetMapping("/projectOutDetail")
   public ResultVO getProjectOutDetailList(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "mouthDate", required = false) LocalDate mouthDate,
      @RequestParam(name = "projectId") Long projectId,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：项目钢材出库详情信息");
      return ResultBuilder.success(this.warehouseDataAnalysisBiz.getProjectOutDetailList(projectId, yearDate, mouthDate, branchCompanyId, workshopId));
   }

   @ApiOperation("WMS-项目钢材出库详情下载")
   @GetMapping("/downloadProjectOutDetail")
   public void downloadProjectOutDetailList(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "mouthDate", required = false) LocalDate mouthDate,
      @RequestParam(name = "projectId") Long projectId,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：项目钢材出库详情下载");
      this.warehouseDataAnalysisBiz.downloadProjectOutDetailList(projectId, yearDate, mouthDate, branchCompanyId, workshopId);
   }

   @ApiOperation("WMS-辅材一级科目")
   @GetMapping("/oneLevel")
   public ResultVO getAuxiliaryOneLevel() {
      log.info("API 调用 ：WMS-辅材一级科目");
      return ResultBuilder.success(this.warehouseDataAnalysisBiz.getAuxiliaryOneLevel());
   }

   @ApiOperation("WMS-余料库存")
   @GetMapping("/surplusMaterial")
   @PreAuthorize("@permission.check('stock_analysis:get','remain_statistics:detail')")
   public ResultVO getSurplusMaterialInventoryGroupByMonth(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：WMS-余料库存");
      return ResultBuilder.success(this.warehouseDataAnalysisBiz.getSurplusMaterialInventoryGroupByMonth(yearDate, branchCompanyId, workshopId));
   }

   @ApiOperation("WMS-余料库存-下载")
   @GetMapping("/surplusMaterial/download")
   @PreAuthorize("@permission.check('remain_statistics:download')")
   public void getSurplusMaterialInventoryGroupByMonthDownload(
      @RequestParam(name = "yearDate") LocalDate yearDate,
      @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId,
      @RequestParam(name = "workshopId", required = false) Long workshopId
   ) {
      log.info("API 调用 ：WMS-余料库存-下载");
      this.warehouseDataAnalysisBiz.getSurplusMaterialInventoryGroupByMonthDownload(yearDate, branchCompanyId, workshopId);
   }
}
