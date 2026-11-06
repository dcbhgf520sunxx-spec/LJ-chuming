package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.ContractSupplierPaymentBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierPaymentDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierPaymentRecordDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.InvoiceFindDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PaymentCheckDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PaymentFindDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseSupplierPaymentSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseSupplierPaymentUpdateDTOParam;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.scm.core.api.biz.SupplierBiz;
import com.hzchum.scim.scm.core.api.pojo.dto.SupplierPayableSummaryDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "合同管理-供应商付款")
@RestController
@RequestMapping("/api/contract/payment")
public class SupplierPaymentController {
   private static final Logger log = LoggerFactory.getLogger(SupplierPaymentController.class);
   @Resource
   private ContractSupplierPaymentBiz supplierPaymentBiz;
   @Resource
   private SupplierInvoiceService supplierInvoiceService;
   @Resource
   private SupplierPaymentService supplierPaymentService;
   @Resource
   private SupplierBiz supplierBiz;

   @ApiOperation("供应商订单付款列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "purchaseType", value = "1原材料采购订单 2制成品采购订单", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开日期", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "截止日期", paramType = "query"),
            @ApiImplicitParam(name = "basicClass", value = "物料分类", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "订单编号", paramType = "query"),
            @ApiImplicitParam(name = "supplierName", value = "供应商名字", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "settlementStatus", value = "结算状态 1已结算 0未结算", paramType = "query"),
            @ApiImplicitParam(name = "pageNumber", value = "页码", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "pageSize", value = "条数", paramType = "query", defaultValue = "20")
      }
   )
   @GetMapping("/order")
   @PreAuthorize("@permission.check('contract_supplier_material:get')")
   public ResultVO<PageVO<SupplierPaymentRecordDTO>> listSupplierPayments(
      Integer purchaseType,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      String serialNumber,
      Long supplierId,
      String supplierName,
      Long projectId,
      Integer settlementStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 供应商订单付款列表");
      return ResultBuilder.success(
         this.supplierPaymentBiz
            .pageOrderPayments(
               purchaseType, startDate, endDate, basicClass, serialNumber, supplierId, supplierName, projectId, settlementStatus, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("付款记录")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "orderId", value = "采购订单id", paramType = "query"),
            @ApiImplicitParam(name = "propertyType", value = "类型 1原材料-采购费 2物流费 4制成品-采购费 8分包订单费", paramType = "query", required = true),
            @ApiImplicitParam(name = "supplierId", value = "供应商id", paramType = "query"),
            @ApiImplicitParam(name = "paymentUnitId", value = "付款单位id", paramType = "query"),
            @ApiImplicitParam(name = "auditStatus", value = "审核状态", paramType = "query")
      }
   )
   @GetMapping("/list")
   @PreAuthorize(
      "@permission.check('contract_supplier_material_payment:get','subcontract_order_payment_manage:get','subcontract_order_payment_manage:detail','supplier_material_payment_application:get','supplier_material_paymentLog:get','supplier_logistics_payment_application:get','contract_supplier_logistics_payment:get')"
   )
   public ResultVO<PageVO<SupplierPaymentDTO>> listSupplierOrders(
      Long orderId,
      @RequestParam Integer propertyType,
      Long supplierId,
      Long branchCompanyId,
      Integer auditStatus,
      LocalDate startDate,
      LocalDate endDate,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 供应商付款记录");
      return ResultBuilder.success(
         this.supplierPaymentBiz.listPayment(orderId, propertyType, branchCompanyId, supplierId, auditStatus, startDate, endDate, pageNumber, pageSize)
      );
   }

   @ApiOperation("打印-付款记录")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "orderId", value = "采购订单id", paramType = "query"),
            @ApiImplicitParam(name = "propertyType", value = "1原材料-采购费 2物流费 4制成品-采购费 8分包订单费", paramType = "query", required = true),
            @ApiImplicitParam(name = "supplierId", value = "供应商id", paramType = "query"),
            @ApiImplicitParam(name = "paymentUnitId", value = "付款单位id", paramType = "query"),
            @ApiImplicitParam(name = "auditStatus", value = "审核状态", paramType = "query")
      }
   )
   @GetMapping("/list/print")
   @PreAuthorize(
      "@permission.check('contract_supplier_material_payment:print','subcontract_order_payment_manage:print','contract_supplier_logistics_payment:print')"
   )
   public ResultVO printSupplierPaymentList(
      Long orderId, @RequestParam Integer propertyType, Long supplierId, Long paymentUnitId, Integer auditStatus, LocalDate startDate, LocalDate endDate
   ) {
      log.info("Api调用: 打印-供应商付款记录");
      return ResultBuilder.success(this.supplierPaymentBiz.printPaymentList(orderId, propertyType, paymentUnitId, supplierId, auditStatus, startDate, endDate));
   }

   @ApiOperation("下载-付款记录")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "orderId", value = "采购订单id", paramType = "query"),
            @ApiImplicitParam(name = "propertyType", value = "1原材料-采购费 2物流费 4制成品-采购费 8分包订单费", paramType = "query", required = true),
            @ApiImplicitParam(name = "supplierId", value = "供应商id", paramType = "query"),
            @ApiImplicitParam(name = "paymentUnitId", value = "付款单位id", paramType = "query"),
            @ApiImplicitParam(name = "auditStatus", value = "审核状态", paramType = "query")
      }
   )
   @GetMapping("/list/export")
   @PreAuthorize("@permission.check('contract_supplier_material_payment:print','contract_supplier_logistics_payment:print')")
   public ResultVO exportSupplierPaymentList(
      Long orderId,
      @RequestParam Integer propertyType,
      Long supplierId,
      Long paymentUnitId,
      Integer auditStatus,
      LocalDate startDate,
      LocalDate endDate,
      HttpServletResponse response
   ) {
      log.info("Api调用: 下载-供应商付款记录");
      return ResultBuilder.success(
         this.supplierPaymentService.exportPaymentList(orderId, propertyType, paymentUnitId, supplierId, auditStatus, startDate, endDate, response)
      );
   }

   @ApiOperation("付款详情")
   @ApiImplicitParam(name = "paymentId", value = "付款id", paramType = "path", required = true)
   @GetMapping("/{paymentId}")
   @PreAuthorize("@permission.check('contract_supplier_material_payment:detail')")
   public ResultVO listOrdersByProperty(@PathVariable Long paymentId) {
      log.info("Api调用: 供应商付款详情");
      return ResultBuilder.success(this.supplierPaymentService.getDetailById(paymentId));
   }

   @ApiOperation("原材料采购订单-新增付款")
   @PostMapping("/save")
   @PreAuthorize("@permission.check('supplier_material_payment_application:add')")
   public ResultVO saveSupplierPayment(@RequestBody @Valid PurchaseSupplierPaymentSaveDTOParam param) {
      log.info("Api调用: 新增采购订单付款");
      return ResultBuilder.success(this.supplierPaymentBiz.saveSupplierPayment(param));
   }

   @ApiOperation("原材料采购订单-修改付款")
   @PutMapping("/update")
   @PreAuthorize("@permission.check('supplier_material_payment_application:edit')")
   public ResultVO updateSupplierPayment(@RequestBody @Valid PurchaseSupplierPaymentUpdateDTOParam param) {
      log.info("Api调用: 修改采购订单付款");
      return ResultBuilder.success(this.supplierPaymentBiz.updatePayment(param));
   }

   @ApiOperation("审核付款(全部)")
   @PutMapping("/audit")
   @PreAuthorize("@supplierPaymentAccess.audit(#param.id)")
   public ResultVO auditSupplierPayment(@RequestBody @Validated PaymentCheckDTOParam param) {
      log.info("Api调用: 审核-付款填报");
      return ResultBuilder.success(this.supplierPaymentBiz.auditSupplierPayment(param));
   }

   @ApiOperation("删除付款(全部)")
   @DeleteMapping("/del-payment")
   @PreAuthorize("@permission.check('supplier_material_payment_application:del','supplier_logistics_payment_application:del')")
   public ResultVO deleteSupplierPayment(@RequestBody @Valid List<Long> ids) {
      log.info("Api调用: 删除付款记录");
      return ResultBuilder.success(this.supplierPaymentBiz.deletePayment(ids));
   }

   @ApiOperation("付款台账-付款列表")
   @GetMapping("/payment/ledger")
   @PreAuthorize("@permission.check('contract_supplier_payment_ledger_payment:get')")
   public ResultVO ledgerPayment(
      PaymentFindDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("Api调用: 付款台账-收款");
      return ResultBuilder.success(this.supplierPaymentBiz.ledgerPayment(param, pageNumber, pageSize));
   }

   @ApiOperation("打印付款台账-付款列表")
   @GetMapping("/payment/ledger/print")
   @PreAuthorize("@permission.check('contract_supplier_payment_ledger_payment:print')")
   public ResultVO printLedgerPayment(PaymentFindDTOParam param) {
      log.info("Api调用: 打印付款台账-付款列表");
      return ResultBuilder.success(this.supplierPaymentBiz.printLedgerPayment(param));
   }

   @ApiOperation("累计付款额")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "supplierId", value = "供应商Id", paramType = "query"),
            @ApiImplicitParam(name = "propertyType", value = "传类型值或类型与运算结果:1原材料-采购费 2物流费 4制成品-采购费 8分包订单费", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始日期", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "截止日期", paramType = "query")
      }
   )
   @GetMapping("/payment/ledger/summary")
   public ResultVO sumLedgerPayment(Long supplierId, Integer propertyType, LocalDate startDate, LocalDate endDate) {
      log.info("Api调用: 累计付款额");
      return ResultBuilder.success(this.supplierPaymentService.getSumPaymentAmount(supplierId, propertyType, startDate, endDate));
   }

   @ApiOperation("付款台账-收票列表")
   @GetMapping("/payment/ledger/invoice")
   @PreAuthorize("@permission.check('contract_supplier_payment_ledger_invoice:get')")
   public ResultVO<PageVO<SupplierInvoiceDTO>> ledgerPaymentInvoice(
      InvoiceFindDTOParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "10") Integer pageSize
   ) {
      log.info("Api调用: 付款台账-收票列表");
      return ResultBuilder.success(this.supplierInvoiceService.ledgerPaymentInvoice(param, pageNumber, pageSize));
   }

   @ApiOperation("打印付款台账-收票列表")
   @GetMapping("/payment/ledger/invoice/print")
   @PreAuthorize("@permission.check('contract_supplier_payment_ledger_invoice:print')")
   public ResultVO printPaymentInvoice(InvoiceFindDTOParam param) {
      log.info("Api调用: 打印付款台账-收票列表");
      return ResultBuilder.success(this.supplierInvoiceService.printPaymentInvoice(param));
   }

   @ApiOperation("累计收票额")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "supplierId", value = "供应商id ", paramType = "query"),
            @ApiImplicitParam(name = "propertyType", value = "付款/收票属性值或与运算值", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始日期", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "截止日期", paramType = "query")
      }
   )
   @GetMapping("/payment/ledger/invoice/summary")
   public ResultVO sumLedgerPaymentInvoice(Long supplierId, Integer propertyType, LocalDate startDate, LocalDate endDate) {
      log.info("Api调用: 累计收票额");
      return ResultBuilder.success(this.supplierInvoiceService.getSumInvoiceAmount(supplierId, propertyType, startDate, endDate));
   }

   @ApiOperation("应付汇总-列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "supplierClassification", value = "127 采购供应商  1024 物流供应商", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始日期", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "截止日期", paramType = "query"),
            @ApiImplicitParam(name = "supplierName", value = "供应商名称", paramType = "query"),
            @ApiImplicitParam(name = "hasPay", value = " true有应付 false无应付", paramType = "query", dataType = "Boolean"),
            @ApiImplicitParam(name = "hasTax", value = "true有欠税 false无欠税", paramType = "query", dataType = "Boolean")
      }
   )
   @GetMapping("/payable/summary")
   @PreAuthorize("@permission.check('contract_supplier_payment_ledger_payment:get')")
   public ResultVO<ListVO<SupplierPayableSummaryDTO>> listSummaryPayable(
      Integer supplierClassification, String supplierName, LocalDate startDate, LocalDate endDate, Boolean hasPay, Boolean hasTax
   ) {
      log.info("Api调用: 应付汇总列表");
      return ResultBuilder.success(this.supplierBiz.summaryPayable(supplierClassification, supplierName, startDate, endDate, hasPay, hasTax));
   }

   @ApiOperation("打印应付汇总-列表")
   @GetMapping("/payable/summary/print")
   @PreAuthorize("@permission.check('contract_supplier_payment_ledger_payment:print')")
   public ResultVO printSummaryPayable(
      Integer supplierClassification, String supplierName, LocalDate startDate, LocalDate endDate, Boolean hasPay, Boolean hasTax
   ) {
      log.info("Api调用: 打印应付汇总列表");
      return ResultBuilder.success(this.supplierBiz.printListSummaryPayable(supplierClassification, supplierName, startDate, endDate, hasPay, hasTax));
   }
}
