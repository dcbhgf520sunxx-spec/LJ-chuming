package com.hzchum.scim.rest.controller.supplychain;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.ContractSupplierPaymentBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.OutsourcingBookDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.PurchaseStandingBookDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierPaymentRecordDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.InboundRecordDTO;
import com.hzchum.scim.wms.core.api.pojo.dto.wmsUse.PuchaseInboundDetailDTO;
import com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse.QueryPurchaseInboundDetailDTOParam;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "供应链管理-采购付款台账")
@RestController
@RequestMapping("/api/v2/supply-chain/order-payment")
public class OrderPaymentControllerV2 {
   private static final Logger log = LoggerFactory.getLogger(OrderPaymentControllerV2.class);
   @Autowired
   private ContractSupplierPaymentBiz supplierPaymentBiz;
   @Autowired
   private InboundService inboundService;

   @ApiOperation("供应商-外协合同")
   @GetMapping("/outsourcing/standingBook")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "year", value = "日期", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "1,已创建；2.未创建", paramType = "query"),
            @ApiImplicitParam(name = "serialNumber", value = "合同编号", paramType = "query"),
            @ApiImplicitParam(name = "projectName", value = "项目名称", paramType = "query"),
            @ApiImplicitParam(name = "supplierName", value = "供应商名称", paramType = "query")
      }
   )
   public ResultVO<PageVO<OutsourcingBookDTO>> listOutsourcing(
      LocalDateTime year,
      Integer type,
      String serialNumber,
      String projectName,
      String supplierName,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 供应链-供应商-外协合同");
      return ResultBuilder.success(this.supplierPaymentBiz.outsourcingList(year, type, serialNumber, projectName, supplierName, pageNumber, pageSize));
   }

   @ApiOperation("供应链-采购对账")
   @GetMapping("/reconciliation/standingBook")
   public ResultVO<PageVO<PurchaseStandingBookDTO>> listInbound(
      Long supplierId,
      Integer settlementStatus,
      String serialNumber,
      Integer basicClass,
      Long branchCompanyId,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 供应链-采购对账");
      return ResultBuilder.success(
         this.supplierPaymentBiz.listInboundV2(supplierId, settlementStatus, serialNumber, basicClass, branchCompanyId, pageNumber, pageSize)
      );
   }

   @ApiOperation("供应链-采购详情")
   @GetMapping("/orderDetail/{orderId}")
   public ResultVO<List<PuchaseInboundDetailDTO>> orderDetail(@PathVariable Long orderId, LocalDate startDate, LocalDate endDate) {
      log.info("Api调用: 供应链-采购详情");
      return ResultBuilder.success(this.inboundService.orderDetailV2(orderId, startDate, endDate));
   }

   @ApiOperation("供应链-采购详情下载")
   @GetMapping("/orderDetail/{orderId}/download")
   @PreAuthorize("@scmPurchaseOrderAccess.reconciliationOrderRead(#orderId)")
   public ResultVO orderDetailDownload(@PathVariable Long orderId, LocalDate startDate, LocalDate endDate) {
      log.info("Api调用: 供应链-采购详情");
      return ResultBuilder.success(this.inboundService.orderInboundDetailPrint(orderId, startDate, endDate));
   }

   @ApiOperation("供应商对账汇总V2")
   @GetMapping("/reconciliation/summary")
   public ResultVO supplierReconciliation(@RequestParam(required = false) String year, @RequestParam(required = false) Long supplierId) {
      log.info("Api调用: 供应商对账汇总V2");
      return ResultBuilder.success(this.supplierPaymentBiz.supplierReconciliationSummaryV2(year, supplierId));
   }

   @ApiOperation("付款台账-根据订单归类(采购订单)V2")
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
            .pageOrderPaymentsV2(
               purchaseType, startDate, endDate, basicClass, serialNumber, supplierId, supplierName, projectId, settlementStatus, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("供应商对账下载V2")
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
      log.info("Api调用: 供应商对账下载V2供应商对账下载V2");
      this.supplierPaymentBiz.supplierAndAcceptanceExportV2(year, supplierId, classifyId, purchaseOrderId, inboundTime, 1, response);
   }

   @ApiOperation("根据采购订单id、供应商id,查询入库记录V2")
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
      log.info("Api调用: 根据采购订单id、供应商id,查询入库记录V2");
      return ResultBuilder.success(
         this.supplierPaymentBiz
            .listInboundRecordV2(
               orderId, supplierId, startDate, endDate, basicClass, classifyId, classifyName, purchaseSn, inboundId, inboundSn, pageNumber, pageSize
            )
      );
   }

   @ApiOperation("采购对账-采购明细纬度")
   @GetMapping("/orderReconciliationDetailAll")
   public ResultVO<PageVO<PuchaseInboundDetailDTO>> orderReconciliationDetailAll(
      @Valid QueryPurchaseInboundDetailDTOParam queryDTOParam,
      @RequestParam(name = "pageNumber", defaultValue = "1") Integer pageNumber,
      @RequestParam(name = "pageSize", defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 采购对账-采购明细纬度");
      return ResultBuilder.success(this.inboundService.orderReconciliationDetailAll(queryDTOParam, pageNumber, pageSize));
   }

   @ApiOperation("采购对账-采购明细纬度打印")
   @GetMapping("/print/orderReconciliationDetailAll")
   @PreAuthorize("@scmPurchaseOrderAccess.reconciliationRead()")
   public ResultVO printOrderReconciliationDetailAll(@Valid QueryPurchaseInboundDetailDTOParam queryDTOParam) {
      log.info("Api调用: 采购对账-采购明细纬度打印");
      return ResultBuilder.success(this.inboundService.printOrderReconciliationDetailAll(queryDTOParam));
   }
}
