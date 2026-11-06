package com.hzchum.scim.rest.controller.operational;

import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
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

@Api(tags = "采购分析下载")
@RestController
@RequestMapping("/api/pc/operational/purchase/download")
public class PurchaseAnalysisDownloadController {
   private static final Logger log = LoggerFactory.getLogger(PurchaseAnalysisDownloadController.class);
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private InboundService inboundService;

   @ApiOperation("年度采购汇总下载")
   @GetMapping("/getGroupDetail/year")
   @PreAuthorize("@permission.check('all_year_statistics:download')")
   public void getGroupDetailYear(@RequestParam LocalDate yearDate, Boolean yearGroup, Long branchCompanyId, HttpServletResponse response) {
      log.info("Api调用: 年度采购数量详情");
      this.purchaseOrderService.getGroupDetailDownload(yearDate, yearGroup, branchCompanyId, response);
   }

   @ApiOperation("全年供应商详情下载")
   @GetMapping("/supplierGroupDetail")
   @PreAuthorize("@permission.check('supplier_statistics:download')")
   public void getSupplierGroupDetail(@RequestParam LocalDate yearDate, Long branchCompanyId, HttpServletResponse response) {
      log.info("Api调用: 全年供应商详情");
      this.purchaseOrderService.getSupplierGroupDetailDownload(yearDate, branchCompanyId, response);
   }

   @ApiOperation("前十采购供应商详情下载")
   @GetMapping("/groupMonthDetail")
   @PreAuthorize("@permission.check('supplier_statistics:download')")
   public void getGroupMonthDetail(@RequestParam LocalDate yearDate, Long branchCompanyId, @RequestParam Long supplierId, HttpServletResponse response) {
      log.info("Api调用: 前十采购供应商详情下载");
      this.purchaseOrderService.getGroupMonthDetailDownload(yearDate, branchCompanyId, supplierId, response);
   }

   @ApiOperation("入库详情下载")
   @GetMapping("/inboundDetail")
   @PreAuthorize("@permission.check('order_statistics:download')")
   public void getInboundDetail(@RequestParam Long orderId, HttpServletResponse response) {
      log.info("API 调用 ：入库详情下载");
      this.inboundService.orderDetailDownload(orderId, response);
   }
}
