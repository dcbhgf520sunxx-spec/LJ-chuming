package com.hzchum.scim.rest.controller.contract.finance;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.finance.ContractOperationAnalysisBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.finance.ProductionCostAnalysisDTO;
import com.hzchum.scim.mes.building.core.api.pojo._dto.wages.ProjectPainingPriceDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "业财报表-运营分析")
@RestController
@RequestMapping("/api/contract/finance/operationAnalysis")
public class OperationAnalysisController {
   private static final Logger log = LoggerFactory.getLogger(OperationAnalysisController.class);
   @Resource
   private ContractOperationAnalysisBiz contractOperationAnalysisBiz;

   @ApiOperation("成本分析")
   @GetMapping("/cost-analysis")
   @PreAuthorize("@permission.check('production_cost_analysis:get')")
   public ResultVO<ListVO<ProductionCostAnalysisDTO>> productionCostAnalysis(@RequestParam Integer year) {
      log.info("Api调用:运营分析-成本分析列表");
      return ResultBuilder.success(new ListVO<>(this.contractOperationAnalysisBiz.productionCostAnalysis(year)));
   }

   @ApiOperation("成本分析-打印")
   @GetMapping("/cost-analysis/print")
   @PreAuthorize("@permission.check('production_cost_analysis:download')")
   public ResultVO printProductionCostAnalysis(@RequestParam Integer year) {
      log.info("Api调用:运营分析-成本分析列表打印");
      return ResultBuilder.success(this.contractOperationAnalysisBiz.printProductionCostAnalysis(year));
   }

   @ApiOperation("涂装费")
   @GetMapping("/painting-price")
   @PreAuthorize("@permission.check('painting_fee_analysis:get')")
   public ResultVO<ListVO<ProjectPainingPriceDTO>> listPaintingPrice(@RequestParam Integer year) {
      log.info("Api调用:运营分析-涂装费列表");
      return ResultBuilder.success(new ListVO<>(this.contractOperationAnalysisBiz.listProjectPaintingPrice(year)));
   }

   @ApiOperation("打印涂装费")
   @GetMapping("/painting-price/print")
   @PreAuthorize("@permission.check('painting_fee_analysis:download')")
   public ResultVO<PrintVO<List<Map<String, Object>>>> listPaintingPricePrint(@RequestParam Integer year) {
      log.info("Api调用:运营分析-打印涂装费");
      return ResultBuilder.success(this.contractOperationAnalysisBiz.listProjectPaintingPricePrint(year));
   }
}
