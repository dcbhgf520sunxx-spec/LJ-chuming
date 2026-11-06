package com.hzchum.scim.rest.controller.contract;

import com.google.common.base.Preconditions;
import java.util.Objects;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import org.springframework.security.access.prepost.PreAuthorize;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.ContractSupplierInvoiceBiz;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseInvoiceSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SubOrderInvoiceAddParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierInvoiceAddDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-供应商收票")
@RestController
@RequestMapping("/api/contract/receive-invoice/v2")
public class SupplierInvoiceControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(SupplierInvoiceControllerV2.class);
   @Autowired
   private ContractSupplierInvoiceBiz supplierInvoiceBiz;
   @Autowired
   private PurchaseOrderService purchaseOrderService;
   @Autowired
   private SubcontractOrderService subcontractOrderService;

   @ApiOperation("新增收票记录(内包制)")
   @PostMapping("/addPurchase")
   public ResultVO addPurchase(@RequestBody @Valid SupplierInvoiceAddDTOParam params) {
      log.info("Api调用: 新增收票记录");
      return ResultBuilder.success(this.supplierInvoiceBiz.AddSupplierInvoice(params));
   }

   @ApiOperation("发票记录(内包制)")
   @GetMapping("/getPurchase")
   public ResultVO getPurchase(Long projectId, Long supplierId) {
      log.info("Api调用: 收票记录");
      return ResultBuilder.success(this.supplierInvoiceBiz.getPurchase(projectId, supplierId));
   }

   @ApiOperation("采购订单-新增收票(自营)")
   @PostMapping("/addPurchase/SelfOwned")
   @PreAuthorize("@permission.check('scm_purchaseOrder_self_v2:invoice_entry')")
   public ResultVO addPurchase(@RequestBody @Valid PurchaseInvoiceSaveParam param) {
      Preconditions.checkArgument(param.getOrderInvoiceList() != null && !param.getOrderInvoiceList().isEmpty(), "订单不能为空");
      param.getOrderInvoiceList().forEach(row -> {
         Preconditions.checkArgument(row != null && row.getOrderId() != null, "订单不能为空");
         PurchaseOrder order = this.purchaseOrderService.getById(row.getOrderId());
         Preconditions.checkArgument(order != null && Objects.equals(order.getProjectAttribute(), 1), "仅允许自营采购订单");
      });
      log.info("Api调用: 新增收票记录");
      return ResultBuilder.success(this.supplierInvoiceBiz.addSupplierInvoiceSelfOwned(param));
   }

   @ApiOperation("采购订单-付款开票信息")
   @GetMapping("/getPurchase/SelfOwned/getPage")
   public ResultVO getPurchase(@RequestParam Long orderId) {
      log.info("Api调用: 新增收票记录获取采购合同的开票记录(自合营)");
      return ResultBuilder.success(this.supplierInvoiceBiz.getPaymentSelfOwnedList(orderId));
   }

   @ApiOperation("分包订单-新增收票(自营)")
   @PostMapping("/subcontrat/audit/saveSelfOwned")
   @PreAuthorize("@permission.check('self_sub_supplier:invoice_entry')")
   public ResultVO saveSubOrderInvoice(@RequestBody @Valid SubOrderInvoiceAddParam params) {
      SubcontractOrder order = this.subcontractOrderService.getById(params.getOrderId());
      Preconditions.checkArgument(order != null && Objects.equals(order.getProjectAttribute(), 1), "仅允许自营分包订单");
      log.info("Api调用:新增-分包订单收票");
      return ResultBuilder.success(this.supplierInvoiceBiz.saveSubOrderInvoice(params));
   }

   @ApiOperation("分包订单-收票支付记录(自营)")
   @GetMapping("/subcontrat/getPayment/SelfOwned/{orderId}")
   public ResultVO getPaymentSelfOwned(@PathVariable Long orderId, Long auditId) {
      log.info("Api调用: 分包订单-收票支付记录");
      return ResultBuilder.success(this.supplierInvoiceBiz.getSubcontractSelfList(orderId, auditId));
   }

   @ApiOperation("分包合同-新增分包合同收票审批(内、合)")
   @PostMapping("/subcontrat/audit")
   public ResultVO auditSubcontrat(@RequestBody @Valid SupplierInvoiceAddDTOParam params) {
      log.info("Api调用: 分包合同新增收票记录");
      return ResultBuilder.success(this.supplierInvoiceBiz.auditSubcontractInvoice(params));
   }

   @ApiOperation("分包合同-收票支付记录(内、合)")
   @GetMapping("/subcontrat/getPayment/{orderId}")
   public ResultVO getPayment(@PathVariable Long orderId) {
      log.info("Api调用: 分包合同收票支付记录");
      return ResultBuilder.success(this.supplierInvoiceBiz.getSubcontractPaymentList(orderId));
   }
}
