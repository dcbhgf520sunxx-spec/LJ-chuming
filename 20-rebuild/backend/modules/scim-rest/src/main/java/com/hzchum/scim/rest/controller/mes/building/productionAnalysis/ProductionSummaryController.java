package com.hzchum.scim.rest.controller.mes.building.productionAnalysis;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.mes.building.core.api.biz.productionAnalysis.ProductionAnalysisBiz;
import com.hzchum.scim.mes.building.core.api.pojo._doParam.productionAnalysis.ProductAnalysisDOParam;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.productionAnalysis.HysteresisDTOParam;
import com.hzchum.scim.mes.building.core.api.service.record.MesBuildingProductProductionSummaryService;
import com.hzchum.scim.mes.building.core.api.service.task.MesBuildingTaskService;
import com.hzchum.scim.rest.pojo.vo.mes.building.request.productionAnalysis.get.HysteresisVORequest;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "MES生产分析")
@RestController
@RequestMapping("/api/mes/building/analysis")
public class ProductionSummaryController {
   private static final Logger log = LoggerFactory.getLogger(ProductionSummaryController.class);
   @Autowired
   private MesBuildingProductProductionSummaryService productionSummaryService;
   @Autowired
   private ProductionAnalysisBiz analysisBiz;
   @Autowired
   private MesBuildingTaskService taskService;

   @ApiOperation("获取产品生产统计汇总")
   @GetMapping("/production_summary")
   public ResultVO productSummary(@Valid ProductAnalysisDOParam param) {
      log.info("API 调用 ：获取产品生产统计汇总");
      return ResultBuilder.success(this.productionSummaryService.productionSummary(param));
   }

   @ApiOperation("分组获取产品生产统计汇总")
   @GetMapping("/production_summary/group")
   public ResultVO productGroup(@Valid ProductAnalysisDOParam param) {
      log.info("API 调用 ：分组获取产品生产统计汇总");
      return ResultBuilder.success(this.productionSummaryService.productionGroup(param));
   }

   @ApiOperation("分组获取产品生产统计汇总打印")
   @GetMapping("/production_summary/group/print")
   public ResultVO productionGroupPrint(@Valid ProductAnalysisDOParam param) {
      log.info("API 调用 ：分组获取产品生产统计汇总打印");
      return ResultBuilder.success(this.productionSummaryService.productionGroupPrint(param));
   }

   @ApiOperation("获取产品生产统计详情-完成品")
   @GetMapping("/production_summary/complete/details")
   public ResultVO productCompleteDetails(@Valid ProductAnalysisDOParam param) {
      log.info("API 调用 ：获取产品生产统计详情-完成品");
      return ResultBuilder.success(this.productionSummaryService.productCompleteDetails(param));
   }

   @ApiOperation("获取产品生产统计详情打印-完成品")
   @GetMapping("/production_summary/complete/details/print")
   public ResultVO productCompleteDetailsPrint(@Valid ProductAnalysisDOParam param) {
      log.info("API 调用 ：获取产品生产统计详情打印-完成品");
      return ResultBuilder.success(this.productionSummaryService.productCompleteDetailsPrint(param));
   }

   @ApiOperation("获取产品生产统计详情-在制品")
   @GetMapping("/production_summary/in_production/details")
   public ResultVO productInProductionDetails(@Valid ProductAnalysisDOParam param) {
      log.info("API 调用 ：获取产品生产统计详情-在制品");
      return ResultBuilder.success(this.productionSummaryService.productInProductionDetails(param));
   }

   @ApiOperation("获取产品生产统计详情打印-在制品")
   @GetMapping("/production_summary/in_production/details/print")
   public ResultVO productInProductionDetailsPrint(@Valid ProductAnalysisDOParam param) {
      log.info("API 调用 ：获取产品生产统计详情打印-在制品");
      return ResultBuilder.success(this.productionSummaryService.productInProductionDetailsPrint(param));
   }

   @ApiOperation("获取产品生产统计详情-未制品")
   @GetMapping("/production_summary/un_production/details")
   public ResultVO productUnProductionDetails(@Valid ProductAnalysisDOParam param) {
      log.info("API 调用 ：获取产品生产统计详情-未制品");
      return ResultBuilder.success(this.productionSummaryService.productUnProductionDetails(param));
   }

   @ApiOperation("获取产品生产统计详情打印-未制品")
   @GetMapping("/production_summary/un_production/details/print")
   public ResultVO productUnProductionDetailsPrint(@Valid ProductAnalysisDOParam param) {
      log.info("API 调用 ：获取产品生产统计详情打印-未制品");
      return ResultBuilder.success(this.productionSummaryService.productUnProductionDetailsPrint(param));
   }

   @ApiOperation("获取迟滞生产汇总")
   @GetMapping("/hysteresis")
   public ResultVO hysteresisSummaryList(@Valid HysteresisVORequest voRequest) {
      log.info("API 调用 ：获取产品生产统计详情");
      return ResultBuilder.success(this.analysisBiz.hysteresisSummaryList(BeanUtil.copy(voRequest, HysteresisDTOParam.class)));
   }

   @ApiOperation("获取迟滞生产详细信息")
   @GetMapping("/hysteresis/details")
   public ResultVO hysteresisList(@Valid HysteresisVORequest voRequest) {
      log.info("API 调用 ：获取迟滞生产详细信息");
      return ResultBuilder.success(this.analysisBiz.hysteresisList(BeanUtil.copy(voRequest, HysteresisDTOParam.class)));
   }

   @ApiOperation("获取迟滞生产详细信息")
   @GetMapping("/hysteresis/details/print")
   public ResultVO hysteresisListPrint(@Valid HysteresisVORequest voRequest) {
      log.info("API 调用 ：获取迟滞生产详细信息");
      return ResultBuilder.success(this.analysisBiz.hysteresisListPrint(BeanUtil.copy(voRequest, HysteresisDTOParam.class)));
   }
}
