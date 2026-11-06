package com.hzchum.scim.rest.controller.contract;

import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.ContractSupplierInvoiceBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierInvoiceSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierInvoiceUpdateDTOParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.time.LocalDate;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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

@Api(tags = "合同管理-供应商收票")
@RestController
@RequestMapping("/api/contract/receive-invoice")
@Validated
public class SupplierInvoiceController {
   private static final Logger log = LoggerFactory.getLogger(SupplierInvoiceController.class);
   @Autowired
   private ContractSupplierInvoiceBiz supplierInvoiceBiz;

   @ApiOperation("查询收票记录-订单")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "orderId", value = "采购单id", paramType = "query"),
            @ApiImplicitParam(name = "propertyType", value = "传类型或与运算结果 1原材料-采购费 2物流费 4制成品-采购费 8分包订单费", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "supplierId", value = "采购供应商id", paramType = "query"),
            @ApiImplicitParam(name = "auditStatus", value = "收票记录审核状态 1审核中 2已通过 4已驳回", paramType = "query")
      }
   )
   @GetMapping("/list")
   @PreAuthorize(
      "@permission.check('contract_supplier_material_invoice:get','contract_supplier_logistics_invoice:get','contract_supplier_subcontract_invoice:get','subcontract_order_payment:invoice')"
   )
   public ResultVO<PageVO<SupplierInvoiceDTO>> getPurchase(
      Long orderId,
      @RequestParam(defaultValue = "1") Integer propertyType,
      Long supplierId,
      Integer auditStatus,
      LocalDate startDate,
      LocalDate endDate,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用: 查询收票记录--订单（采购）");
      return ResultBuilder.success(
         this.supplierInvoiceBiz.pageListInvoiceByCondition(orderId, propertyType, supplierId, auditStatus, startDate, endDate, pageNumber, pageSize)
      );
   }

   @ApiOperation("打印收票记录-订单（采购）")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "orderId", value = "采购单id", paramType = "query"),
            @ApiImplicitParam(name = "propertyType", value = "类型 1原材料-采购费 2物流费 4制成品-采购费 8分包订单费", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "supplierId", value = "采购供应商id", paramType = "query"),
            @ApiImplicitParam(name = "auditStatus", value = "收票记录审核状态 1审核中 2已通过 4已驳回", paramType = "query")
      }
   )
   @GetMapping("/list/print")
   @PreAuthorize(
      "@permission.check('contract_supplier_material_invoice:print','contract_supplier_logistics_invoice:print','contract_supplier_subcontract_invoice:print','subcontract_order_payment:invoicePrint')"
   )
   public ResultVO printManufactures(
      Long orderId, @RequestParam(defaultValue = "1") Integer propertyType, Long supplierId, Integer auditStatus, LocalDate startDate, LocalDate endDate
   ) {
      log.info("Api调用: 打印收票记录-订单（采购）");
      return ResultBuilder.success(this.supplierInvoiceBiz.printInvoiceByCondition(orderId, propertyType, supplierId, auditStatus, startDate, endDate));
   }

   @ApiOperation("查询收票记录-物流")
   @GetMapping("/logistics")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "branchCompanyId", value = "购方单位(签订主体id)", paramType = "query", required = true),
            @ApiImplicitParam(name = "supplierId", value = "销售单位(供应商id)", paramType = "query", required = true)
      }
   )
   @PreAuthorize("@permission.check('contract_supplier_logistics_invoice:get','supplier_logistics_payment:detail')")
   public ResultVO<ListVO<SupplierInvoiceDTO>> getLogistics(
      @RequestParam Long branchCompanyId, @RequestParam(required = false) Long supplierId, Integer auditStatus
   ) {
      log.info("Api调用: 查询收票记录-物流");
      return ResultBuilder.success(this.supplierInvoiceBiz.listInvoiceByUnitId(branchCompanyId, supplierId, auditStatus));
   }

   @ApiOperation("打印收票记录-物流")
   @GetMapping("logistics/print")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "branchCompanyId", value = "购方单位(签订主体id)", paramType = "query", defaultValue = "1"),
            @ApiImplicitParam(name = "supplierId", value = "销售单位(供应商id)", paramType = "query", defaultValue = "10")
      }
   )
   @PreAuthorize("@permission.check('contract_supplier_logistics_invoice:print')")
   public ResultVO printLogistics(@RequestParam Long branchCompanyId, @RequestParam Long supplierId, Integer auditStatus) {
      log.info("Api调用: 打印收票记录-物流");
      return ResultBuilder.success(this.supplierInvoiceBiz.printInvoiceByUnitId(branchCompanyId, supplierId, auditStatus));
   }

   @ApiOperation("新增收票记录(全部)")
   @PostMapping
   @PreAuthorize(
      "@supplierInvoiceAccess.create(#params)"
   )
   public ResultVO purchase(@RequestBody @Valid List<SupplierInvoiceSaveDTOParam> params) {
      log.info("Api调用: 新增收票记录");
      return ResultBuilder.success(this.supplierInvoiceBiz.saveSupplierInvoice(params));
   }

   @ApiOperation("修改收票记录")
   @PutMapping
   @PreAuthorize(
      "@supplierInvoiceAccess.record(#param.id,'edit')"
   )
   public ResultVO auditSupplierPayment(@RequestBody @Valid SupplierInvoiceUpdateDTOParam param) {
      log.info("Api调用: 审核收票记录");
      return ResultBuilder.success(this.supplierInvoiceBiz.updateSupplierInvoice(param));
   }

   @ApiOperation("审核收票记录")
   @PutMapping("/audit")
   @PreAuthorize(
      "@supplierInvoiceAccess.record(#id,'audit')"
   )
   public ResultVO auditSupplierPayment(@RequestParam Long id, @RequestParam Integer auditStatus) {
      log.info("Api调用: 审核收票记录");
      return ResultBuilder.success(this.supplierInvoiceBiz.auditSupplierInvoice(id, auditStatus));
   }

   @ApiOperation("删除收票记录")
   @DeleteMapping("{id}")
   @PreAuthorize(
      "@supplierInvoiceAccess.record(#id,'del')"
   )
   public ResultVO auditSupplierPayment(@PathVariable Long id) {
      log.info("Api调用: 删除收票记录");
      return ResultBuilder.success(this.supplierInvoiceBiz.deleteById(id));
   }
}
