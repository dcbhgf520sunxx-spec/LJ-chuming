package com.hzchum.scim.rest.controller.supplychain;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.ContractSupplierPaymentBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierPaymentRecordDTO;
import com.hzchum.scim.scm.core.api.pojo.dto.PurchaseSupplierSummaryDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundRecordDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "供应链管理-采购付款台账")
@RestController
@RequestMapping("/api/supply-chain/order-payment")
public class OrderPaymentController {
   private static final Logger log = LoggerFactory.getLogger(OrderPaymentController.class);
   @Autowired
   private ContractSupplierPaymentBiz supplierPaymentBiz;

   @ApiOperation("付款台账-根据订单归类(采购订单)")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "purchaseType", value = "1原材料采购订单 2制成品采购订单", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开使日期", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "截止日期", paramType = "query"),
            @ApiImplicitParam(name = "basicClass", value = "物料分类", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "订单编号", paramType = "query"),
            @ApiImplicitParam(name = "supplierId", value = "供应商id", paramType = "query"),
            @ApiImplicitParam(name = "supplierName", value = "供应商名字", paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", paramType = "query"),
            @ApiImplicitParam(name = "settlementStatus", value = "结算状态 1已结算 0未结算", paramType = "query")
      }
   )
   @GetMapping
   @PreAuthorize("@permission.check('supplier_material_payment:get','supplier_material_inbound:get')")
   public ResultVO<PageVO<SupplierPaymentRecordDTO>> pageOrderPayments(
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
      log.info("Api调用: (采购)订单付款台账-根据订单归类");
      return ResultBuilder.success(
         this.supplierPaymentBiz
            .pageOrderPayments(
               purchaseType, startDate, endDate, basicClass, serialNumber, supplierId, supplierName, projectId, settlementStatus, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("打印-付款台账-根据订单归类(采购订单)")
   @GetMapping("/print")
   @PreAuthorize("@permission.check('supplier_material_payment:print')")
   public ResultVO printOrderPayments(
      Integer purchaseType,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      String serialNumber,
      Long supplierId,
      String supplierName,
      Integer settlementStatus
   ) {
      log.info("Api调用: 打印-订单付款台账-根据订单归类");
      return ResultBuilder.success(
         this.supplierPaymentBiz
            .printPurchaseOrderPayInfo(purchaseType, startDate, endDate, basicClass, serialNumber, supplierId, supplierName, settlementStatus)
      );
   }

   @ApiOperation("下载-付款台账-根据订单归类(采购订单)")
   @GetMapping("/export")
   @PreAuthorize("@permission.check('supplier_material_payment:print')")
   public ResultVO exportOrderPayments(
      Integer purchaseType,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      String serialNumber,
      Long supplierId,
      String supplierName,
      Integer settlementStatus,
      HttpServletResponse response
   ) {
      log.info("Api调用: 下载-订单付款台账-根据订单归类");
      this.supplierPaymentBiz
         .exportPurchaseOrderPayInfoList(purchaseType, startDate, endDate, basicClass, serialNumber, supplierId, supplierName, settlementStatus, response);
      return ResultBuilder.success(true);
   }

   @ApiOperation("付款台账-根据供应商归类(采购订单)")
   @ApiImplicitParam(name = "supplierName", value = "供应商名", paramType = "query")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "supplierName", value = "供应商名字", paramType = "query"),
            @ApiImplicitParam(name = "startDate", value = "开始日期", paramType = "query"),
            @ApiImplicitParam(name = "endDate", value = "截止日期", paramType = "query")
      }
   )
   @GetMapping("/sumBySupplier")
   @PreAuthorize("@permission.check('supplier_material_payment:get')")
   public ResultVO<PageVO<PurchaseSupplierSummaryDTO>> listSupplierPayments(
      String supplierName,
      LocalDate startDate,
      LocalDate endDate,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 订单付款台账-根据供应商归类");
      return ResultBuilder.success(this.supplierPaymentBiz.pageSupplierPayments(supplierName, startDate, endDate, pageNumber, pageSize));
   }

   @ApiOperation("打印付款台账-根据供应商归类(采购订单)")
   @ApiImplicitParam(name = "supplierName", value = "供应商名", paramType = "query")
   @GetMapping("/sumBySupplier/print")
   @PreAuthorize("@permission.check('supplier_material_payment:print')")
   public ResultVO printSupplierPayments(String supplierName, LocalDate startDate, LocalDate endDate) {
      log.info("Api调用: 打印订单付款台账-根据供应商归类");
      return ResultBuilder.success(this.supplierPaymentBiz.printSupplierPayments(supplierName, startDate, endDate));
   }

   @ApiOperation("根据采购订单id、供应商id,查询入库记录")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "orderId", value = "采购订单id", paramType = "query"),
            @ApiImplicitParam(name = "supplierId", value = "采购供应商id", paramType = "query")
      }
   )
   @GetMapping("/listInbound")
   @PreAuthorize("@permission.check('contract_supplier_material_inbound:get','supplier_material_inbound:detail','supplier_material_payment:detail')")
   public ResultVO<PageVO<InboundRecordDTO>> listInbound(
      Long orderId,
      Long supplierId,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      Long classifyId,
      String classifyName,
      String purchaseSn,
      Long inboundId,
      String inboundSn,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 付款台账-入库记录");
      return ResultBuilder.success(
         this.supplierPaymentBiz
            .listInboundRecord(
               orderId, supplierId, startDate, endDate, basicClass, classifyId, classifyName, purchaseSn, inboundId, inboundSn, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("打印入库记录")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "orderId", value = "采购订单id", paramType = "query"),
            @ApiImplicitParam(name = "supplierId", value = "采购供应商id", paramType = "query")
      }
   )
   @GetMapping("/listInbound/print")
   @PreAuthorize("@permission.check('contract_supplier_material_inbound:print','supplier_material_inbound:print')")
   public ResultVO printInboundList(
      Long orderId,
      Long supplierId,
      LocalDate startDate,
      LocalDate endDate,
      Integer basicClass,
      Long classifyId,
      String classifyName,
      String purchaseSn,
      Long inboundId,
      String inboundSn
   ) {
      log.info("Api调用: 打印入库记录");
      return ResultBuilder.success(
         this.supplierPaymentBiz
            .printInboundRecord(orderId, supplierId, startDate, endDate, basicClass, classifyId, classifyName, purchaseSn, inboundId, inboundSn)
      );
   }

   @ApiOperation("验收记录")
   @ApiImplicitParams(
      {@ApiImplicitParam(name = "year", value = "年", paramType = "query"), @ApiImplicitParam(name = "purchaseOrderId", value = "采购单ID", paramType = "query")}
   )
   @GetMapping("/acceptance")
   @PreAuthorize("@permission.check('purchase_acceptance_log:get')")
   public ResultVO acceptanceRecord(
      String year,
      @RequestParam(required = false) Long supplierId,
      @RequestParam(required = false) Long classifyId,
      @RequestParam(required = false) Long purchaseOrderId,
      @RequestParam(required = false) List<LocalDateTime> inboundTime,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 验收记录");
      return ResultBuilder.success(
         this.supplierPaymentBiz.supplierOrAcceptanceRecord(year, supplierId, classifyId, purchaseOrderId, inboundTime, pageNumber, pageSize, 2)
      );
   }

   @ApiOperation("供应商对账")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "purchaseOrderId", value = "采购单ID", paramType = "query"),
            @ApiImplicitParam(name = "createTime", value = "创建时间范围", paramType = "query")
      }
   )
   @GetMapping("/reconciliation")
   @PreAuthorize("@permission.check('supplier_reconciliation_Log:get')")
   public ResultVO supplierReconciliation(
      String year,
      @RequestParam(required = false) Long supplierId,
      @RequestParam(required = false) Long classifyId,
      @RequestParam(required = false) Long purchaseOrderId,
      @RequestParam(required = false) List<LocalDateTime> inboundTime,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 供应商对账");
      return ResultBuilder.success(
         this.supplierPaymentBiz.supplierOrAcceptanceRecord(year, supplierId, classifyId, purchaseOrderId, inboundTime, pageNumber, pageSize, 1)
      );
   }

   @ApiOperation("供应商对账汇总")
   @GetMapping("/reconciliation/summary")
   public ResultVO supplierReconciliation(@RequestParam(required = false) String year, @RequestParam(required = false) Long supplierId) {
      log.info("Api调用: 供应商对账汇总");
      return ResultBuilder.success(this.supplierPaymentBiz.supplierReconciliationSummary(year, supplierId));
   }

   @ApiOperation("验收记录下载")
   @GetMapping("/acceptance/export")
   @PreAuthorize("@permission.check('purchase_acceptance_log:download')")
   public void acceptanceRecordExport(
      String year,
      @RequestParam(required = false) Long supplierId,
      @RequestParam(required = false) Long classifyId,
      @RequestParam(required = false) List<LocalDateTime> inboundTime,
      @RequestParam(required = false) Long purchaseOrderId,
      HttpServletResponse response
   ) {
      log.info("Api调用: 验收记录下载");
      this.supplierPaymentBiz.supplierAndAcceptanceExport(year, supplierId, classifyId, purchaseOrderId, inboundTime, 2, response);
   }

   @ApiOperation("供应商对账下载")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "purchaseOrderId", value = "采购单ID", paramType = "query"),
            @ApiImplicitParam(name = "createTime", value = "创建时间范围", paramType = "query")
      }
   )
   @GetMapping("/reconciliation/export")
   @PreAuthorize("@permission.check('supplier_reconciliation_Log:download')")
   public void supplierReconciliationExport(
      String year,
      @RequestParam(required = false) Long supplierId,
      @RequestParam(required = false) Long classifyId,
      @RequestParam(required = false) List<LocalDateTime> inboundTime,
      @RequestParam(required = false) Long purchaseOrderId,
      HttpServletResponse response
   ) {
      log.info("Api调用: 供应商对账下载");
      this.supplierPaymentBiz.supplierAndAcceptanceExport(year, supplierId, classifyId, purchaseOrderId, inboundTime, 1, response);
   }
}
