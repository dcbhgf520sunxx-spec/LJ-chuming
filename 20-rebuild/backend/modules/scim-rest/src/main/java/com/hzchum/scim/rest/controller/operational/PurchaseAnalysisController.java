package com.hzchum.scim.rest.controller.operational;

import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryByMaterialDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundDetailService;
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

@Api(tags = "采购分析")
@RestController
@RequestMapping("/api/pc/operational/purchase")
public class PurchaseAnalysisController {
   private static final Logger log = LoggerFactory.getLogger(PurchaseAnalysisController.class);
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private InboundDetailService inboundDetailService;

   @ApiOperation("年度采购单数量汇总")
   @GetMapping("/purchaseSummary")
   @PreAuthorize("@permission.check('purchase_analysis:get')")
   public ResultVO getPurchaseSummary(@RequestParam(name = "yearDate") LocalDate yearDate, Long branchCompanyId) {
      log.info("Api调用: 年度采购单数量汇总");
      return ResultBuilder.success(this.purchaseOrderService.getPurchaseSummary(yearDate, branchCompanyId));
   }

   @ApiOperation("月度采购数量汇总")
   @GetMapping("/getGroupMonth")
   @PreAuthorize("@permission.check('purchase_analysis:get')")
   public ResultVO getGroupMonth(@RequestParam(name = "yearDate") LocalDate yearDate, Long branchCompanyId) {
      log.info("Api调用: 月度采购数量汇总");
      return ResultBuilder.success(this.purchaseOrderService.getGroupMonth(yearDate, branchCompanyId));
   }

   @ApiOperation("年度采购数量详情")
   @GetMapping("/getGroupDetail/year")
   @PreAuthorize("@permission.check('all_year_statistics:detail')")
   public ResultVO getGroupDetailYear(@RequestParam(name = "yearDate") LocalDate yearDate, Long branchCompanyId) {
      log.info("Api调用: 年度采购数量详情");
      return ResultBuilder.success(this.purchaseOrderService.getGroupDetail(yearDate, Boolean.TRUE, branchCompanyId));
   }

   @ApiOperation("月度采购数量详情")
   @GetMapping("/getGroupDetail/month")
   @PreAuthorize("@permission.check('all_year_statistics:detail')")
   public ResultVO getGroupDetailMonth(@RequestParam(name = "yearDate") LocalDate yearDate, Long branchCompanyId) {
      log.info("Api调用: 月度采购数量详情");
      return ResultBuilder.success(this.purchaseOrderService.getGroupDetail(yearDate, Boolean.FALSE, branchCompanyId));
   }

   @ApiOperation("主材采购价格走势选择材料")
   @GetMapping("/getInboundMaterial")
   @PreAuthorize("@permission.check('purchase_analysis:get')")
   public ResultVO getMaterialInbound(QueryByMaterialDTOParam param) {
      log.info("Api调用: 主材采购价格走势选择材料");
      return ResultBuilder.success(this.inboundDetailService.getMaterialInbound(param));
   }

   @ApiOperation("主材采购价格走势")
   @GetMapping("/getInboundPriceSummary")
   @PreAuthorize("@permission.check('purchase_analysis:get')")
   public ResultVO getInboundPriceSummary(QueryByMaterialDTOParam param) {
      log.info("Api调用: 主材采购价格走势选择材料");
      return ResultBuilder.success(this.inboundDetailService.getInboundPriceSummary(param));
   }

   @ApiOperation("全年采购供应商汇总")
   @GetMapping("/supplierSummary")
   @PreAuthorize("@permission.check('purchase_analysis:get')")
   public ResultVO getSupplierSummary(@RequestParam(name = "yearDate") LocalDate yearDate, Long branchCompanyId) {
      log.info("Api调用: 全年采购供应商汇总");
      return ResultBuilder.success(this.purchaseOrderService.getSupplierSummary(yearDate, branchCompanyId));
   }

   @ApiOperation("全年供应商详情")
   @GetMapping("/supplierGroupDetail")
   @PreAuthorize("@permission.check('supplier_statistics:detail')")
   public ResultVO getSupplierGroupDetail(@RequestParam(name = "yearDate") LocalDate yearDate, Long branchCompanyId) {
      log.info("Api调用: 全年供应商详情");
      return ResultBuilder.success(this.purchaseOrderService.getSupplierGroupDetail(yearDate, branchCompanyId));
   }

   @ApiOperation("前十采购供应商汇总")
   @GetMapping("/groupSupplierMonth")
   @PreAuthorize("@permission.check('purchase_analysis:get')")
   public ResultVO getGroupSupplierMonth(@RequestParam LocalDate yearDate, Long branchCompanyId, @RequestParam Boolean isAmountSort) {
      log.info("Api调用: 前十采购供应商汇总");
      return ResultBuilder.success(this.purchaseOrderService.getGroupSupplierMonth(yearDate, branchCompanyId, isAmountSort));
   }

   @ApiOperation("前十采购供应商详情")
   @GetMapping("/groupMonthDetail")
   @PreAuthorize("@permission.check('supplier_statistics:detail')")
   public ResultVO getGroupMonthDetail(@RequestParam LocalDate yearDate, Long branchCompanyId, @RequestParam Long supplierId) {
      log.info("Api调用: 前十采购供应商详情");
      return ResultBuilder.success(this.purchaseOrderService.getGroupMonthDetail(yearDate, branchCompanyId, supplierId));
   }
}
