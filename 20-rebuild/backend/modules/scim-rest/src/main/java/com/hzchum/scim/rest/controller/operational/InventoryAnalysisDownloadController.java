package com.hzchum.scim.rest.controller.operational;

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

@Api(tags = "库存分析下载")
@RestController
@RequestMapping("/api/pc/operational/inventory/download")
public class InventoryAnalysisDownloadController {
   private static final Logger log = LoggerFactory.getLogger(InventoryAnalysisDownloadController.class);
   @Resource
   private WarehouseDataAnalysisBiz warehouseDataAnalysisBiz;

   @ApiOperation("每月结存费用下载")
   @GetMapping("/monthCost/detail")
   @PreAuthorize("@permission.check('stock_statistics:download')")
   public void getInventoryGroupByMonthDetail(@RequestParam LocalDate monthDate, @RequestParam(required = false) Long branchCompanyId) {
      log.info("API 调用 ：每月结存费用下载");
      this.warehouseDataAnalysisBiz.getInventoryGroupByMonthDetailDownload(monthDate, branchCompanyId);
   }

   @ApiOperation("每月出入库费用下载")
   @GetMapping("/outInCost")
   @PreAuthorize("@permission.check('steel_statistics:download','stock_statistics:download')")
   public void getOutInCostGroupByMonth(Integer basicClass, Long classifyId, LocalDate yearDate, Long branchCompanyId) {
      log.info("API 调用 ：每月出入库费用下载");
      this.warehouseDataAnalysisBiz.getOutInCostGroupByMonth(basicClass, classifyId, yearDate, branchCompanyId, null);
   }

   @ApiOperation("仓库实时库存详情下载")
   @GetMapping("/inventory/cost")
   @PreAuthorize("@permission.check('amount_statistics:download')")
   public void getInventoryInventoryCostDetail(
      @RequestParam LocalDate monthDate, @RequestParam Integer basicClass, @RequestParam(required = false) Long branchCompanyId, HttpServletResponse response
   ) {
      log.info("API 调用 ：仓库实时库存详情下载");
      this.warehouseDataAnalysisBiz.getInventoryInventoryCostDetailDownload(monthDate, branchCompanyId, basicClass, response);
   }
}
