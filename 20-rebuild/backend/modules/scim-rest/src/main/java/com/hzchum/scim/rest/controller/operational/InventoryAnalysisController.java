package com.hzchum.scim.rest.controller.operational;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.operational.analysis.core.api.biz.WarehouseDataAnalysisBiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "库存分析")
@RestController
@RequestMapping("/api/pc/operational/inventory")
public class InventoryAnalysisController {
   private static final Logger log = LoggerFactory.getLogger(InventoryAnalysisController.class);
   @Resource
   private WarehouseDataAnalysisBiz warehouseDataAnalysisBiz;

   @ApiOperation("仓库实时金额统计")
   @GetMapping("/cost")
   @PreAuthorize("@permission.check('stock_analysis:get')")
   public ResultVO getInventoryCost(
      @RequestParam(name = "yearDate") LocalDate yearDate, @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId
   ) {
      log.info("API 调用 ：仓库实时金额统计");
      return ResultBuilder.success(this.warehouseDataAnalysisBiz.getInventoryCost(yearDate, branchCompanyId));
   }

   @ApiOperation("仓库实时库存详情")
   @GetMapping("/inventory/cost")
   @PreAuthorize("@permission.check('amount_statistics:detail')")
   public ResultVO getInventoryInventoryCostDetail(
      @RequestParam LocalDate monthDate, @RequestParam Integer basicClass, @RequestParam(required = false) Long branchCompanyId
   ) {
      log.info("API 调用 ：仓库实时库存详情");
      return ResultBuilder.success(this.warehouseDataAnalysisBiz.getInventoryInventoryCostDetail(monthDate, branchCompanyId, basicClass));
   }

   @ApiOperation("每月期末结存")
   @GetMapping("month/cost")
   @PreAuthorize("@permission.check('stock_analysis:get')")
   public ResultVO getInventoryGroupByMonth(
      @RequestParam(name = "yearDate") LocalDate yearDate, @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId
   ) {
      log.info("API 调用 ：每月期末结存");
      return ResultBuilder.success(this.warehouseDataAnalysisBiz.getInventoryGroupByMonth(yearDate, branchCompanyId));
   }

   @ApiOperation("每月结存费用详情")
   @GetMapping("/month/cost/detai")
   @PreAuthorize("@permission.check('stock_statistics:detail')")
   public ResultVO getInventoryGroupByMonthDetail(
      @RequestParam(name = "yearDate") LocalDate monthDate, @RequestParam(name = "branchCompanyId", required = false) Long branchCompanyId
   ) {
      log.info("API 调用 ：每月结存费用详情");
      return ResultBuilder.success(this.warehouseDataAnalysisBiz.getInventoryGroupByMonthDetail(monthDate, branchCompanyId));
   }
}
