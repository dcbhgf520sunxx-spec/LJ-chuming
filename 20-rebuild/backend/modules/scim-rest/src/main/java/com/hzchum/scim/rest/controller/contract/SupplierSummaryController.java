package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.ContractSupplierSummaryBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSummaryCargoListDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSummaryLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSummaryLogisticsOrderDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSummaryPurchaseOrderDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSummarySubOrderDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierSummaryLedgerQueryParam;
import com.hzchum.scim.scm.core.api.biz.SubcontractOrderBiz;
import com.hzchum.scim.scm.core.api.pojo.dto.BriefPurchaseOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractOrderDTO;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundDTO;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-供应商汇总")
@RestController
@RequestMapping("/api/contract/supplier/summary")
public class SupplierSummaryController {
   private static final Logger log = LoggerFactory.getLogger(SupplierSummaryController.class);
   private final ContractSupplierSummaryBiz supplierSummaryLedgerBiz;
   private final PurchaseOrderService purchaseOrderService;
   private final SubcontractOrderBiz subcontractOrderBiz;
   private final InboundService inboundService;

   @ApiOperation("汇总列表")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('contract_supplier_payable_list:get')")
   public ResultVO<PageVO<SupplierSummaryLedgerDTO>> pageList(
      SupplierSummaryLedgerQueryParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:供应商应付汇总列表");
      List<SupplierSummaryLedgerDTO> supplierSummaryLedgerDTOList = this.supplierSummaryLedgerBiz.listSupplierLedger(param);
      return ResultBuilder.success(PageUtil.listPage(pageNumber, pageSize, supplierSummaryLedgerDTOList));
   }

   @ApiOperation("汇总列表-打印")
   @GetMapping("/list/print")
   @PreAuthorize("@permission.check('contract_supplier_payable_list:print')")
   public ResultVO<PrintVO<List<SupplierSummaryLedgerDTO>>> printList(SupplierSummaryLedgerQueryParam param) {
      log.info("Api调用:供应商应付汇总列表-打印");
      return ResultBuilder.success(this.supplierSummaryLedgerBiz.printSupplierLedgerList(param));
   }

   @ApiOperation("采购订单-列表")
   @GetMapping("/purchaseOrder/list")
   @PreAuthorize("@permission.check('contract_supplier_payable_list:detail')")
   public ResultVO<PageVO<SupplierSummaryPurchaseOrderDTO>> pageListPurchaseOrder(
      @RequestParam Long supplierId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:供应商应付汇总-采购订单列表");
      return ResultBuilder.success(this.supplierSummaryLedgerBiz.purchaseOrderPageList(supplierId, pageNumber, pageSize));
   }

   @ApiOperation("采购订单-列表-打印")
   @GetMapping("/purchaseOrder/list/print")
   @PreAuthorize("@permission.check('contract_supplier_payable_list:detail')")
   public ResultVO<PrintVO<List<SupplierSummaryPurchaseOrderDTO>>> printListPurchaseOrder(@RequestParam Long supplierId) {
      log.info("Api调用:供应商应付汇总-采购订单列表-打印");
      return ResultBuilder.success(this.supplierSummaryLedgerBiz.purchaseOrderListPrint(supplierId));
   }

   @ApiOperation("分包订单-列表")
   @GetMapping("/subcontractOrder/list")
   @PreAuthorize("@permission.check('contract_supplier_payable_list:detail')")
   public ResultVO<PageVO<SupplierSummarySubOrderDTO>> pageListSubContractOrder(
      @RequestParam Long supplierId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:供应商应付汇总-分包订单列表");
      return ResultBuilder.success(this.supplierSummaryLedgerBiz.subOrderPageList(supplierId, pageNumber, pageSize));
   }

   @ApiOperation("分包订单-列表-打印")
   @GetMapping("/subcontractOrder/list/print")
   @PreAuthorize("@permission.check('contract_supplier_payable_list:detail')")
   public ResultVO<PrintVO<List<SupplierSummarySubOrderDTO>>> printListSubContractOrder(@RequestParam Long supplierId) {
      log.info("Api调用:供应商应付汇总-分包订单列表-打印");
      return ResultBuilder.success(this.supplierSummaryLedgerBiz.subOrderListPrint(supplierId));
   }

   @ApiOperation("制品物流记录-列表")
   @GetMapping("/cargoList/list")
   @PreAuthorize("@permission.check('contract_supplier_payable_list:detail')")
   public ResultVO<PageVO<SupplierSummaryCargoListDTO>> pageListCargoList(
      @RequestParam Long supplierId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:供应商应付汇总-制成品物流记录列表");
      return ResultBuilder.success(this.supplierSummaryLedgerBiz.cargoListPageList(supplierId, pageNumber, pageSize));
   }

   @ApiOperation("制品物流记录-列表-打印")
   @GetMapping("/cargoList/list/print")
   @PreAuthorize("@permission.check('contract_supplier_payable_list:detail')")
   public ResultVO<PrintVO<List<SupplierSummaryCargoListDTO>>> printListCargoList(@RequestParam Long supplierId) {
      log.info("Api调用:供应商应付汇总-制成品物流记录列表-打印");
      return ResultBuilder.success(this.supplierSummaryLedgerBiz.cargoListPrint(supplierId));
   }

   @ApiOperation("原料物流记录-列表")
   @GetMapping("/logistics/list")
   @PreAuthorize("@permission.check('contract_supplier_payable_list:detail')")
   public ResultVO<PageVO<SupplierSummaryLogisticsOrderDTO>> pageListLogistics(
      @RequestParam Long supplierId, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:供应商应付汇总-制成品物流记录列表");
      return ResultBuilder.success(this.supplierSummaryLedgerBiz.logisticsPageList(supplierId, pageNumber, pageSize));
   }

   @ApiOperation("原料物流记录-列表-打印")
   @GetMapping("/logistics/list/print")
   @PreAuthorize("@permission.check('contract_supplier_payable_list:detail')")
   public ResultVO<PrintVO<List<SupplierSummaryLogisticsOrderDTO>>> printListLogistics(@RequestParam Long supplierId) {
      log.info("Api调用:供应商应付汇总-制成品物流记录列表-打印");
      return ResultBuilder.success(this.supplierSummaryLedgerBiz.logisticsListPrint(supplierId));
   }

   @ApiOperation("采购订单-详情")
   @GetMapping("/purchaseOrder/{orderId}")
   @PreAuthorize("@permission.check('contract_supplier_payable_list:detail')")
   public ResultVO<BriefPurchaseOrderDTO> getPurchaseOrderDetail(@PathVariable Long orderId) {
      log.info("API调用:供应商应付汇总-查询采购订单详情");
      return ResultBuilder.success(this.purchaseOrderService.selectByIdPurchaseOrder(orderId));
   }

   @ApiOperation("采购订单-详情-下载")
   @GetMapping("/purchaseOrder/{orderId}/download")
   @PreAuthorize("@permission.check('contract_supplier_payable_list:detail')")
   public void downloadPurchaseOrderDetail(@PathVariable("orderId") Long orderId, HttpServletResponse response) {
      log.info("API调用:供应商应付汇总-采购订单详情-下载");
      this.purchaseOrderService.purchaseExcel(orderId, response);
   }

   @ApiOperation("分包订单-详情")
   @GetMapping("/subcontractOrder/{orderId}")
   @PreAuthorize("@permission.check('contract_supplier_payable_list:detail')")
   public ResultVO<SubcontractOrderDTO> getSubcontractOrderDetail(@PathVariable Long orderId) {
      log.info("Api调用:供应商应付汇总-分包订单详情");
      return ResultBuilder.success(this.subcontractOrderBiz.getSubcontractOrderDetail(orderId));
   }

   @ApiOperation("原料物流-关联入库单详情")
   @GetMapping("/logistics/inboundOrder/{inboundId}")
   @PreAuthorize("@permission.check('contract_supplier_payable_list:detail')")
   public ResultVO<InboundDTO> getInboundDetail(@PathVariable Long inboundId) {
      log.info("API调用:供应商应付汇总-原料物流关联入库单详情");
      return ResultBuilder.success(this.inboundService.getListV2(inboundId, false));
   }

   public SupplierSummaryController(
      final ContractSupplierSummaryBiz supplierSummaryLedgerBiz,
      final PurchaseOrderService purchaseOrderService,
      final SubcontractOrderBiz subcontractOrderBiz,
      final InboundService inboundService
   ) {
      this.supplierSummaryLedgerBiz = supplierSummaryLedgerBiz;
      this.purchaseOrderService = purchaseOrderService;
      this.subcontractOrderBiz = subcontractOrderBiz;
      this.inboundService = inboundService;
   }
}
