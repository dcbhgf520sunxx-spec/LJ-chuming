package com.hzchum.scim.rest.controller.operational;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.operational.analysis.core.api.biz.OperationalAnalysisBiz;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.InspectionDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.OrderDeliverDTO;
import com.hzchum.scim.operational.analysis.core.api.pojo._dto.ProductionLoadDTO;
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

@Api(tags = "运营分析")
@RestController
@RequestMapping("/api/operational/analysis")
public class OperationalAnalysisController {
   private static final Logger log = LoggerFactory.getLogger(OperationalAnalysisController.class);
   @Autowired
   private OperationalAnalysisBiz analysisBiz;

   @ApiOperation("订单分析")
   @GetMapping("/order")
   public ResultVO orderAnalysis(LocalDateTime dateTime) {
      log.info("API 调用 ：订单分析");
      return ResultBuilder.success(this.analysisBiz.orderAnalysis(dateTime));
   }

   @ApiOperation("产量分析")
   @GetMapping("/production")
   public ResultVO productionAnalysis(
      LocalDateTime dateTime,
      Long factoryId,
      @RequestParam(required = false, defaultValue = "0") Integer yearSize,
      @RequestParam(required = false) Integer productType
   ) {
      log.info("API 调用 ：产量分析");
      return ResultBuilder.success(new ListVO<>(this.analysisBiz.productionAnalysis(dateTime, factoryId, yearSize, productType)));
   }

   @ApiOperation("差异分析")
   @GetMapping("/difference")
   public ResultVO differenceAnalysis(LocalDateTime dateTime) {
      log.info("API 调用 ：差异分析");
      return ResultBuilder.success(new ListVO<>(this.analysisBiz.differenceAnalysis(dateTime)));
   }

   @ApiOperation("差异分析-平均差异率")
   @GetMapping("/difference/average")
   public ResultVO averageDifferenceRatioAnalysis(@RequestParam(defaultValue = "1") Integer range) {
      log.info("API 调用 ：差异分析-平均差异率");
      return ResultBuilder.success(new ListVO<>(this.analysisBiz.averageDifferenceRatioAnalysis(range)));
   }

   @ApiOperation("辅材费用")
   @GetMapping("/auxiliary_materials")
   public ResultVO auxiliaryMaterialsAnalysis(LocalDateTime dateTime, @RequestParam(required = false) Long factoryId) {
      log.info("API 调用 ：辅材费用");
      return ResultBuilder.success(this.analysisBiz.auxiliaryMaterialsAnalysis(dateTime, factoryId));
   }

   @ApiOperation("QHSE事件")
   @GetMapping("/qhse")
   public ResultVO qhseAnalysis(LocalDateTime dateTime) {
      log.info("API 调用 ：QHSE事件");
      return ResultBuilder.success(new ListVO<>(this.analysisBiz.qhseAnalysis(dateTime)));
   }

   @ApiOperation("生产品类型分析")
   @GetMapping("/production_type")
   public ResultVO productionTypeAnalysis(LocalDateTime dateTime, Integer productType) {
      log.info("API 调用 ：生产品类型分析");
      return ResultBuilder.success(new ListVO<>(this.analysisBiz.productionTypeAnalysis(dateTime, productType)));
   }

   @ApiOperation("采购价格分析")
   @GetMapping("/purchase/trend")
   public ResultVO purchaseTrendAnalysis(
      LocalDateTime dateTime, Integer basicClass, Long classifyId, Integer thickness, Long specId, Long sectionSteelSpecId, Integer range
   ) {
      log.info("API 调用 ：采购价格分析");
      return ResultBuilder.success(
         new ListVO<>(this.analysisBiz.purchaseTrendAnalysis(dateTime, basicClass, classifyId, thickness, specId, sectionSteelSpecId, range))
      );
   }

   @ApiOperation("采购占比分析")
   @GetMapping("/purchase/ratio")
   public ResultVO purchaseRatioAnalysis(LocalDateTime dateTime, Integer basicClass) {
      log.info("API 调用 ：采购占比分析");
      return ResultBuilder.success(new ListVO<>(this.analysisBiz.purchaseRatioAnalysis(dateTime, basicClass)));
   }

   @ApiOperation("进销存分析")
   @GetMapping("/inventory/summary")
   public ResultVO inventorySummaryAnalysis(LocalDateTime dateTime, Integer tax, Integer type) {
      log.info("API 调用 ：进销存分析");
      return ResultBuilder.success(new ListVO<>(this.analysisBiz.inventorySummaryAnalysis(dateTime, tax, type)));
   }

   @ApiOperation("进销存分析-库存")
   @GetMapping("/inventory/stock")
   public ResultVO inventoryStockAnalysis(LocalDateTime dateTime, Integer tax, Integer type) {
      log.info("API 调用 ：进销存分析-库存");
      return ResultBuilder.success(new ListVO<>(this.analysisBiz.inventoryStockAnalysis(dateTime, tax, type)));
   }

   @ApiOperation("进销存分析-钢材库存")
   @GetMapping("/inventory/stock/steel")
   public ResultVO inventoryStockSteelAnalysis(LocalDateTime dateTime, Integer tax) {
      log.info("API 调用 ：进销存分析-库存");
      return ResultBuilder.success(new ListVO<>(this.analysisBiz.inventoryStockSteelAnalysis(dateTime, tax)));
   }

   @ApiOperation("收支分析")
   @GetMapping("/income")
   public ResultVO incomeAnalysis(LocalDateTime dateTime, Long branchCompanyId) {
      log.info("API 调用 ：收支分析");
      return ResultBuilder.success(new ListVO<>(this.analysisBiz.incomeAnalysis(dateTime, branchCompanyId)));
   }

   @ApiOperation("应收款分析")
   @GetMapping("/collection")
   public ResultVO collectionAnalysis(
      @RequestParam Integer type, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API 调用 ：应收款分析");
      return ResultBuilder.success(this.analysisBiz.collectionAnalysis(type, pageNumber, pageSize));
   }

   @ApiOperation("项目直接成本")
   @GetMapping("/cost")
   public ResultVO costAnalysis(Integer settlementStatus, Integer status) {
      log.info("API 调用 ：项目直接成本");
      return ResultBuilder.success(this.analysisBiz.costAnalysis(settlementStatus, status));
   }

   @ApiOperation("产能负荷率")
   @GetMapping("/load")
   public ResultVO<ProductionLoadDTO> loadAnalysis(@RequestParam(name = "dateTime") LocalDateTime dateTime, Long factoryId) {
      log.info("API 调用 ：产能负荷率");
      return ResultBuilder.success(this.analysisBiz.loadAnalysis(dateTime, factoryId));
   }

   @ApiOperation("订单交付率")
   @GetMapping("/deliver")
   public ResultVO<OrderDeliverDTO> deliverAnalysis(@RequestParam(name = "dateTime") LocalDateTime dateTime) {
      log.info("API 调用 ：订单交付率");
      return ResultBuilder.success(this.analysisBiz.deliverAnalysis(dateTime));
   }

   @ApiOperation("质检合格率")
   @GetMapping("/inspection")
   public ResultVO<InspectionDTO> inspectionAnalysis(@RequestParam(name = "dateTime") LocalDateTime dateTime) {
      log.info("API 调用 ：质检合格率");
      return ResultBuilder.success(this.analysisBiz.inspectionAnalysis(dateTime));
   }
}
