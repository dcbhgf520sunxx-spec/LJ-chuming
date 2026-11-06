package com.hzchum.scim.rest.controller.contract;

import org.springframework.security.access.prepost.PreAuthorize;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.PageUtil;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.common.core.api.enums.HandleMethodEnum;
import com.hzchum.scim.contract.core.api.biz.ContractScrapRecycleLedgerBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractRecycleInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractRecyclePaymentDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractReturnLedgerDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.ContractReturnProductDTO;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.RecycleInvoiceAuditParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.RecycleInvoiceSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.RecycleInvoiceUpdateParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.RecyclePaymentAuditParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.RecyclePaymentSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.RecyclePaymentUpdateParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

@Api(tags = "合同管理-制成品退货-回收台账")
@Validated
@RestController
@RequestMapping("/api/contract/return/recycle/ledger")
public class ContractReturnRecycleLedgerController {
   private static final Logger log = LoggerFactory.getLogger(ContractReturnRecycleLedgerController.class);
   private final ContractScrapRecycleLedgerBiz contractScrapRecycleLedgerBiz;

   @ApiOperation("台账列表")
   @GetMapping("/list")
   @PreAuthorize("@permission.check('product_recycling:get')")
   public ResultVO<PageVO<ContractReturnLedgerDTO>> pageListScrapSaleLedger(
      LocalDate startDate,
      LocalDate endDate,
      Long branchCompanyId,
      String customerUnit,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:制成品回收台账列表");
      List<ContractReturnLedgerDTO> ledgerDTOList = this.contractScrapRecycleLedgerBiz
         .listScrapRecycleLedger(startDate, endDate, branchCompanyId, customerUnit);
      return ResultBuilder.success(PageUtil.listPage(pageNumber, pageSize, ledgerDTOList));
   }

   @ApiOperation("台账列表-打印")
   @GetMapping("/list/print")
   @PreAuthorize("@permission.check('product_recycling:print')")
   public ResultVO<PrintVO<List<ContractReturnLedgerDTO>>> printListScrapSaleLedger(
      LocalDate startDate, LocalDate endDate, Long branchCompanyId, String customerUnit
   ) {
      log.info("Api调用:制成品回收台账列表-打印");
      return ResultBuilder.success(this.contractScrapRecycleLedgerBiz.printListScrapRecycleLedger(startDate, endDate, branchCompanyId, customerUnit));
   }

   @ApiOperation("回收总额")
   @GetMapping("/totalAmount")
   @PreAuthorize("@permission.check('product_recycling:get')")
   public ResultVO<BigDecimal> getRecycleTotalAmount(Long branchCompanyId, String customerUnit) {
      log.info("Api调用:制成品回收总额");
      return ResultBuilder.success(this.contractScrapRecycleLedgerBiz.getRecycleTotalAmount(branchCompanyId, customerUnit));
   }

   @ApiOperation("产品列表")
   @GetMapping("/product/list")
   @PreAuthorize("@permission.check('product_recycling:get')")
   public ResultVO<PageVO<ContractReturnProductDTO>> pageListReturnProduct(
      @RequestParam Long branchCompanyId,
      @RequestParam String customerUnit,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:制成品回收产品列表");
      return ResultBuilder.success(
         this.contractScrapRecycleLedgerBiz
            .pageListReturnProduct(branchCompanyId, customerUnit, null, HandleMethodEnum.RECYCLE.getType(), pageNumber, pageSize)
      );
   }

   @ApiOperation("产品列表-打印")
   @GetMapping("/product/list/print")
   @PreAuthorize("@permission.check('product_recycling:print')")
   public ResultVO<PrintVO<List<ContractReturnProductDTO>>> pageListReturnProduct(@RequestParam Long branchCompanyId, @RequestParam String customerUnit) {
      log.info("Api调用:制成品回收产品列表-打印");
      return ResultBuilder.success(
         this.contractScrapRecycleLedgerBiz.printListReturnProduct(branchCompanyId, customerUnit, null, HandleMethodEnum.RECYCLE.getType())
      );
   }

   @ApiOperation("付款列表")
   @GetMapping("/payment/list")
   @PreAuthorize("@permission.check('product_recycling:get')")
   public ResultVO<PageVO<ContractRecyclePaymentDTO>> pageListRecyclePayment(
      @RequestParam Long branchCompanyId,
      @RequestParam String customerUnit,
      @RequestParam(required = false) Integer auditStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:制成品回收付款列表");
      return ResultBuilder.success(this.contractScrapRecycleLedgerBiz.pageListPayment(branchCompanyId, customerUnit, auditStatus, pageNumber, pageSize));
   }

   @ApiOperation("付款列表-打印")
   @GetMapping("/payment/list/print")
   @PreAuthorize("@permission.check('product_recycling:print')")
   public ResultVO<PrintVO<List<ContractRecyclePaymentDTO>>> printListRecyclePayment(
      @RequestParam Long branchCompanyId, @RequestParam String customerUnit, @RequestParam(required = false) Integer auditStatus
   ) {
      log.info("Api调用:制成品回收付款列表-打印");
      return ResultBuilder.success(this.contractScrapRecycleLedgerBiz.printListPayment(branchCompanyId, customerUnit, auditStatus));
   }

   @ApiOperation("付款-新增")
   @PostMapping("/payment/save")
   @PreAuthorize("@permission.check('product_recycling:add')")
   public ResultVO<Boolean> savePayment(@RequestBody @Valid RecyclePaymentSaveParam param) {
      log.info("Api调用:制成品回收-新增付款");
      return ResultBuilder.success(this.contractScrapRecycleLedgerBiz.saveReturnPayment(Collections.singletonList(param)));
   }

   @ApiOperation("付款-修改")
   @PutMapping("/payment/update")
   @PreAuthorize("@permission.check('product_recycling:edit')")
   public ResultVO<Boolean> updatePayment(@RequestBody @Valid RecyclePaymentUpdateParam param) {
      log.info("Api调用:制成品回收-修改付款");
      return ResultBuilder.success(this.contractScrapRecycleLedgerBiz.updateReturnPayment(Collections.singletonList(param)));
   }

   @ApiOperation("付款-审核")
   @PutMapping("/payment/audit")
   @PreAuthorize("@permission.check('product_recycling:review')")
   public ResultVO<Boolean> auditPayment(@RequestBody @Valid RecyclePaymentAuditParam param) {
      log.info("Api调用:制成品回收-审核付款");
      return ResultBuilder.success(this.contractScrapRecycleLedgerBiz.auditReturnPayment(param));
   }

   @ApiOperation("付款-删除")
   @DeleteMapping("/payment/delete/{id}")
   @PreAuthorize("@permission.check('product_recycling:del')")
   public ResultVO<Boolean> removePayment(@PathVariable Long id) {
      log.info("Api调用:制成品回收-审核付款");
      return ResultBuilder.success(this.contractScrapRecycleLedgerBiz.removeReturnPayment(Collections.singletonList(id)));
   }

   @ApiOperation("收票列表")
   @GetMapping("/invoice/list")
   @PreAuthorize("@permission.check('product_recycling:get')")
   public ResultVO<PageVO<ContractRecycleInvoiceDTO>> pageListRecycleInvoice(
      @RequestParam Long branchCompanyId,
      @RequestParam String customerUnit,
      @RequestParam(required = false) Integer auditStatus,
      @RequestParam(defaultValue = "1") Integer pageNumber,
      @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("Api调用:制成品回收-收票列表");
      return ResultBuilder.success(this.contractScrapRecycleLedgerBiz.pageListInvoice(branchCompanyId, customerUnit, auditStatus, pageNumber, pageSize));
   }

   @ApiOperation("收票列表-打印")
   @GetMapping("/invoice/list/print")
   @PreAuthorize("@permission.check('product_recycling:print')")
   public ResultVO<PrintVO<List<ContractRecycleInvoiceDTO>>> printListRecycleInvoice(
      @RequestParam Long branchCompanyId, @RequestParam String customerUnit, @RequestParam(required = false) Integer auditStatus
   ) {
      log.info("Api调用:制成品回收-收票列表-打印");
      return ResultBuilder.success(this.contractScrapRecycleLedgerBiz.printListInvoice(branchCompanyId, customerUnit, auditStatus));
   }

   @ApiOperation("收票-新增")
   @PostMapping("/invoice/save")
   @PreAuthorize("@permission.check('product_recycling:add')")
   public ResultVO<Boolean> saveInvoice(@RequestBody @Valid RecycleInvoiceSaveParam param) {
      log.info("Api调用:制成品回收-新增收票");
      return ResultBuilder.success(this.contractScrapRecycleLedgerBiz.saveInvoice(Collections.singletonList(param)));
   }

   @ApiOperation("收票-修改")
   @PutMapping("/invoice/update")
   @PreAuthorize("@permission.check('product_recycling:edit')")
   public ResultVO<Boolean> updateInvoice(@RequestBody @Valid RecycleInvoiceUpdateParam param) {
      log.info("Api调用:制成品回收-修改收票");
      return ResultBuilder.success(this.contractScrapRecycleLedgerBiz.updateInvoice(Collections.singletonList(param)));
   }

   @ApiOperation("收票-审核")
   @PutMapping("/invoice/audit")
   @PreAuthorize("@permission.check('product_recycling:review')")
   public ResultVO<Boolean> auditInvoice(@RequestBody @Valid RecycleInvoiceAuditParam param) {
      log.info("Api调用:制成品回收-审核收票");
      return ResultBuilder.success(this.contractScrapRecycleLedgerBiz.auditInvoice(param));
   }

   @ApiOperation("收票-删除")
   @DeleteMapping("/invoice/delete/{id}")
   @PreAuthorize("@permission.check('product_recycling:del')")
   public ResultVO<Boolean> removeInvoice(@PathVariable Long id) {
      log.info("Api调用:制成品回收-删除收票");
      return ResultBuilder.success(this.contractScrapRecycleLedgerBiz.removeInvoice(Collections.singletonList(id)));
   }

   public ContractReturnRecycleLedgerController(final ContractScrapRecycleLedgerBiz contractScrapRecycleLedgerBiz) {
      this.contractScrapRecycleLedgerBiz = contractScrapRecycleLedgerBiz;
   }
}
