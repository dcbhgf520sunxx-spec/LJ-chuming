package com.hzchum.scim.rest.controller.contract.audit;

import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.ResultBuilder;
import com.hzchum.scim.contract.core.api.biz.ContractInvoiceBiz;
import com.hzchum.scim.contract.core.api.biz.ContractSettlementBiz;
import com.hzchum.scim.contract.core.api.biz.ContractSupplierInvoiceBiz;
import com.hzchum.scim.contract.core.api.biz.ContractSupplierPaymentBiz;
import com.hzchum.scim.contract.core.api.biz.ContractSupplierSettlementBiz;
import com.hzchum.scim.contract.core.api.biz.audit.ContractAuditLedgerBiz;
import com.hzchum.scim.contract.core.api.pojo.dto.ProjectSettlementDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.SupplierSettlementDto;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.AuditUserDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractAuditLedgerDto;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractCollectionAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractReimbursementFeeAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractTestingFeeAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractWageFeeAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.ContractWaterElectricityFeeAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.InsourcingAuditDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.InsourcingDetailAuditDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.SelfemployedAuditDetail;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.SupplierInvoicePurchaseAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.SupplierInvoiceSubOrderAuditDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.audit.SupplierSettlementEchoAuditDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ContractInvoiceSaveParamV2;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.ProjectSettlementSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.AddContractAuditDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.ContractAuditLedgerQueryParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.FillFeeAuditSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.PaymentInvoiceDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.ProjectCollectionAuditParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.PurchaseInvoiceAuditParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.SettleAuditSaveDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.audit.SubOrderInvoiceAuditParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseInvoiceSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchasePaymentSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseSettlementSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SubOrderInvoiceAddParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SubOrderPaymentAddDtoParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SubOrderSettlementAddParam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "审批管理")
@RestController
@RequestMapping("/api/contract/audit")
@Validated
public class ContractAuditLedgerController {
   private static final Logger log = LoggerFactory.getLogger(ContractAuditLedgerController.class);
   @Resource
   private ContractAuditLedgerBiz contractAuditLedgerBiz;
   @Resource
   private ContractSupplierPaymentBiz supplierPaymentBiz;
   @Resource
   private ContractSupplierInvoiceBiz supplierInvoiceBiz;
   @Resource
   private ContractInvoiceBiz invoiceBiz;
   @Resource
   private ContractSupplierSettlementBiz supplierSettlementBiz;
   @Resource
   private ContractSettlementBiz projectSettlementBiz;

   @ApiOperation("审批列表")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "paymentEnum", value = "付款类型", required = false, paramType = "query"),
            @ApiImplicitParam(name = "time", value = "时间", required = false, paramType = "query"),
            @ApiImplicitParam(name = "auditStatusEnum", value = "审批状态(1:审核中2:审核通过4:驳回)", required = false, paramType = "query"),
            @ApiImplicitParam(name = "projectAttribute", value = "项目属性(自营、合营、内包制)", required = false, paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", required = false, paramType = "query"),
            @ApiImplicitParam(name = "initiatorId", value = "发起人", required = false, paramType = "query"),
            @ApiImplicitParam(name = "oaNumber", value = "OA编号", required = false, paramType = "query"),
            @ApiImplicitParam(name = "projectManagerId", value = "项目经理", required = false, paramType = "query"),
            @ApiImplicitParam(name = "supplierId", value = "供应商", required = false, paramType = "query"),
            @ApiImplicitParam(name = "writtenById", value = "填报人", required = false, paramType = "query")
      }
   )
   @GetMapping("/listPage")
   @PreAuthorize("@permission.check('examine-manage:get')")
   public ResultVO<PageVO<ContractAuditLedgerDto>> listAuditLedger(
      ContractAuditLedgerQueryParam param, @RequestParam(defaultValue = "1") Integer pageNumber, @RequestParam(defaultValue = "20") Integer pageSize
   ) {
      log.info("API调用:审批管理列表");
      return ResultBuilder.success(this.contractAuditLedgerBiz.listAuditLedger(param, pageNumber, pageSize));
   }

   @ApiOperation("项目开票审批-编辑")
   @PostMapping("/project/invoice/edit")
   @PreAuthorize("@contractCollectionAccess.invoiceWrite(#saveDTOParam.projectId,#saveDTOParam.level,#saveDTOParam.invoiceUnitId)")
   public ResultVO editProjectInvoiceAudit(@RequestBody @Valid ContractInvoiceSaveParamV2 saveDTOParam) {
      log.info("Api调用:项目开票审批-编辑");
      return ResultBuilder.success(this.invoiceBiz.saveInvoice(saveDTOParam));
   }

   @ApiOperation("项目结算审批-编辑")
   @PostMapping("/project/settlement/edit")
   @PreAuthorize("@contractCollectionAccess.settlementWrite(#param.projectId,#param.level,false)")
   public ResultVO editProjectSettlementAudit(@RequestBody ProjectSettlementSaveParam param) {
      log.info("Api调用:项目结算审批-编辑");
      return ResultBuilder.success(this.contractAuditLedgerBiz.saveProjectSettlement(param));
   }

   @ApiOperation("项目预结算审批-编辑")
   @PostMapping("/project/preSettlement/edit")
   @PreAuthorize("@contractCollectionAccess.settlementWrite(#param.projectId,#param.level,true)")
   public ResultVO saveProjectPreSettlement(
      @RequestBody @Valid ProjectSettlementSaveParam param, @RequestHeader(value = "financeBranchId", required = false) Long branchCompanyId
   ) {
      log.info("Api调用:项目预结算审批-编辑");
      param.setBranchCompanyId(branchCompanyId);
      return ResultBuilder.success(this.projectSettlementBiz.savePreSettlement(param));
   }

   @ApiOperation("采购付款审批-编辑")
   @PutMapping("/purchase/payment/edit")
   @PreAuthorize("@contractCollectionAccess.purchasePaymentCreate(#param)")
   public ResultVO editPurchasePaymentAudit(@RequestBody @Valid PurchasePaymentSaveParam param) {
      log.info("Api调用:采购付款审批-编辑");
      return ResultBuilder.success(this.supplierPaymentBiz.addSelfOwned(param));
   }

   @ApiOperation("采购收票审批-编辑")
   @PutMapping("/purchase/invoice/edit")
   @PreAuthorize("@contractCollectionAccess.purchaseInvoiceCreate(#param)")
   public ResultVO editPurchaseInvoiceAudit(@RequestBody @Valid PurchaseInvoiceSaveParam param) {
      log.info("Api调用:采购收票审批-编辑");
      return ResultBuilder.success(this.supplierInvoiceBiz.addSupplierInvoiceSelfOwned(param));
   }

   @ApiOperation("采购结算审批-编辑")
   @PutMapping("/purchase/settlement/edit")
   @PreAuthorize("@contractCollectionAccess.purchaseSettlementCreate(#param.orderId)")
   public ResultVO editPurchaseSettleAudit(@RequestBody @Valid PurchaseSettlementSaveParam param) {
      log.info("Api调用: 新增采购订单结算(自营)");
      return ResultBuilder.success(this.supplierSettlementBiz.saveSelfEmployed(param));
   }

   @ApiOperation("采购预结算审批-编辑")
   @PostMapping("/purchase/preSettlement/edit")
   @PreAuthorize("@contractCollectionAccess.purchaseSettlementCreate(#param.orderId)")
   public ResultVO saveSelfPreSettle(@RequestBody @Valid PurchaseSettlementSaveParam param) {
      log.info("Api调用:采购预结算审批-编辑");
      param.setBoolPreSettlement(true);
      return ResultBuilder.success(this.supplierSettlementBiz.saveSelfEmployed(param));
   }

   @ApiOperation("分包付款审批-编辑")
   @PutMapping("/subOrder/payment/edit")
   @PreAuthorize("@contractCollectionAccess.subcontractPaymentCreate(#param)")
   public ResultVO editSubOrderPaymentAudit(@RequestBody @Valid SubOrderPaymentAddDtoParam param) {
      log.info("Api调用:分包付款审批-编辑");
      return ResultBuilder.success(this.supplierPaymentBiz.addSelfOwnedSubcontractPayment(param));
   }

   @ApiOperation("分包收票审批-编辑")
   @PutMapping("/subOrder/invoice/edit")
   @PreAuthorize("@contractCollectionAccess.subcontractCreate(#param.orderId,'invoice_entry')")
   public ResultVO editSubOrderInvoiceAudit(@RequestBody @Valid SubOrderInvoiceAddParam param) {
      log.info("Api调用:分包收票审批-编辑");
      return ResultBuilder.success(this.supplierInvoiceBiz.saveSubOrderInvoice(param));
   }

   @ApiOperation("分包结算审批-编辑")
   @PostMapping("/subOrder/settlement/edit")
   @PreAuthorize("@contractCollectionAccess.subcontractCreate(#param.orderId,'payment')")
   public ResultVO saveSubcontractOrder(@RequestBody @Valid SubOrderSettlementAddParam param) {
      log.info("Api调用:分包结算审批-编辑");
      return ResultBuilder.success(this.supplierSettlementBiz.saveSubcontractOrder(param));
   }

   @ApiOperation("分包预结算审批-编辑")
   @PostMapping("/subOrder/preSettlement/edit")
   @PreAuthorize("@contractCollectionAccess.subcontractCreate(#param.orderId,'payment')")
   public ResultVO saveSubcontractOrderPre(@RequestBody @Valid SubOrderSettlementAddParam param) {
      log.info("Api调用: 新增:分包合同-预结算");
      return ResultBuilder.success(this.supplierSettlementBiz.saveSubcontractOrderPre(param));
   }

   @ApiOperation("审批台账-采购/分包-付款基本信息")
   @GetMapping("/selfemployedDetail")
   @PreAuthorize("@contractCollectionAccess.auditRecordRead(#auditId, 'detail')")
   public ResultVO<SelfemployedAuditDetail> selfemployedDetail(@RequestParam Long auditId) {
      log.info("API调用:获取审批台账-采购/分包付款基本信息");
      return ResultBuilder.success(this.contractAuditLedgerBiz.getSelfEmployedAuditDetail(auditId));
   }

   @ApiOperation("获取审批台账基本信息(内包制合营)")
   @GetMapping("/insourcingDetail")
   @PreAuthorize("@contractCollectionAccess.auditRecordRead(#auditId, 'detail')")
   public ResultVO<InsourcingDetailAuditDetail> insourcingDetail(@RequestParam Long auditId) {
      log.info("API 调用： 获取审批台账基本信息(内包制)");
      return ResultBuilder.success(this.contractAuditLedgerBiz.getInsourcingDetailAuditDetail(auditId));
   }

   @ApiOperation("审批台账-采购收票信息(进项)")
   @GetMapping("/purchaseInvoice")
   @PreAuthorize("@contractCollectionAccess.auditRecordRead(#auditId, 'detail')")
   public ResultVO<SupplierInvoicePurchaseAuditDTO> supplierInvoiceAuditInfo(@RequestParam Long auditId) {
      log.info("API调用:获取审批台账-采购订单发票信息");
      return ResultBuilder.success(this.contractAuditLedgerBiz.getPurchaseInvoiceAuditInfo(auditId));
   }

   @ApiOperation("审批台账-分包收票信息(进项)")
   @GetMapping("/supplierSettlement")
   @PreAuthorize("@contractCollectionAccess.auditRecordRead(#auditId, 'detail')")
   public ResultVO<SupplierInvoiceSubOrderAuditDTO> supplierSettlementEch(@RequestParam Long auditId) {
      log.info("API调用:获取审批台账-分包订单发票信息");
      return ResultBuilder.success(this.contractAuditLedgerBiz.getSupplierSettlementEchoDtos(auditId));
   }

   @ApiOperation("审批台账-项目开票信息(销项)")
   @GetMapping("/insourcingAudit")
   @PreAuthorize("@contractCollectionAccess.auditRecordRead(#auditId, 'detail')")
   public ResultVO<InsourcingAuditDetail> getInsourcingAuditDetail(@RequestParam Long auditId) {
      log.info("API调用:获取审批台账-项目开票信息");
      return ResultBuilder.success(this.contractAuditLedgerBiz.getInsourcingAuditDetail(auditId));
   }

   @ApiOperation("付款审批(合营、内包制)--采购")
   @PutMapping("/procurement")
   public ResultVO procurementAudit(@RequestBody @Valid AddContractAuditDtoParam param) {
      log.info("API 调用： 付款审批(内包制)--采购");
      return ResultBuilder.success(this.contractAuditLedgerBiz.procurementAudit(param));
   }

   @ApiOperation("付款审批(自营)--采购")
   @PutMapping("/procurementSelf")
   public ResultVO procurementSelfAudit(@RequestBody @Valid AddContractAuditDtoParam param) {
      log.info("API 调用： 付款审批(自营)--采购");
      return ResultBuilder.success(this.contractAuditLedgerBiz.procurementSelfAudit(param));
   }

   @ApiOperation("开票审批--采购")
   @PutMapping("/invoice")
   public ResultVO paymentInvoiceAudit(@RequestBody @Valid PurchaseInvoiceAuditParam param) {
      log.info("API 调用： 开票审批通用--进项开票");
      return ResultBuilder.success(this.contractAuditLedgerBiz.invoiceAudit(param));
   }

   @ApiOperation("项目收款-审批信息")
   @GetMapping("/project/collection/info")
   @PreAuthorize("@contractCollectionAccess.auditRecordRead(#auditId, 'detail')")
   public ResultVO<ContractCollectionAuditDTO> getProjectCollectionAuditInfo(@RequestParam Long auditId) {
      log.info("API调用:项目收款-审批信息");
      return ResultBuilder.success(this.contractAuditLedgerBiz.getProjectCollectionAuditInfo(auditId));
   }

   @ApiOperation("项目收款-审批")
   @PutMapping("/project/collection")
   public ResultVO projectCollectionAudit(@RequestBody @Valid ProjectCollectionAuditParam param) {
      log.info("API调用:项目收款-审批");
      return ResultBuilder.success(this.contractAuditLedgerBiz.projectCollectionAudit(param));
   }

   @ApiOperation("开票审批--销项开票")
   @PutMapping("/outputInvoice")
   public ResultVO outputInvoiceAudit(@RequestBody @Valid PaymentInvoiceDTOParam param) {
      log.info("API 调用： 开票审批通用--进项开票");
      return ResultBuilder.success(this.contractAuditLedgerBiz.outputInvoiceAudit(param));
   }

   @ApiOperation("获取审批流信息")
   @GetMapping("/getAudit/{auditId}")
   @PreAuthorize("@contractCollectionAccess.auditRecordRead(#auditId, 'detail')")
   public ResultVO<List<AuditUserDTO>> getAuditList(@PathVariable("auditId") Long auditId) {
      log.info("API 调用： 获取审批流信息");
      return ResultBuilder.success(this.contractAuditLedgerBiz.getAuditList(auditId));
   }

   @ApiOperation("审批打印")
   @ApiImplicitParams(
      {
            @ApiImplicitParam(name = "time", value = "时间", required = false, paramType = "query"),
            @ApiImplicitParam(name = "auditStatusEnum", value = "审批状态(1:审核中2:审核通过4:驳回)", required = false, paramType = "query"),
            @ApiImplicitParam(name = "projectAttribute", value = "项目属性(自营、合营、内包制)", required = false, paramType = "query"),
            @ApiImplicitParam(name = "projectId", value = "项目id", required = false, paramType = "query"),
            @ApiImplicitParam(name = "initiatorId", value = "发起人", required = false, paramType = "query"),
            @ApiImplicitParam(name = "oaNumber", value = "OA编号", required = false, paramType = "query"),
            @ApiImplicitParam(name = "projectManagerId", value = "项目经理", required = false, paramType = "query"),
            @ApiImplicitParam(name = "supplierId", value = "供应商", required = false, paramType = "query"),
            @ApiImplicitParam(name = "writtenById", value = "填报人", required = false, paramType = "query")
      }
   )
   @GetMapping("/print/downloadAll")
   @PreAuthorize("@permission.check('examine-manage:print')")
   public ResultVO downloadAll(ContractAuditLedgerQueryParam param) {
      log.info("API调用:审批管理列表打印");
      return ResultBuilder.success(this.contractAuditLedgerBiz.printDownloadAll(param));
   }

   @ApiOperation("审批打印-单独")
   @GetMapping("/print/download")
   @PreAuthorize("@contractCollectionAccess.auditRecordRead(#auditId, 'download')")
   public ResultVO print(@RequestParam("auditId") Long auditId, HttpServletResponse response) throws IOException {
      log.info("API 调用： 审批打印-单独");
      return ResultBuilder.success(this.contractAuditLedgerBiz.printDownload(auditId, response));
   }

   @ApiOperation("获取审批单详情")
   @GetMapping("/getAuditDetail/{auditId}")
   @PreAuthorize("@contractCollectionAccess.auditApprovalRecordRead(#auditId)")
   public ResultVO<ContractAuditLedgerDto> getAuditDetail(@PathVariable("auditId") Long auditId) {
      log.info("API 调用： 获取审批单详情");
      return ResultBuilder.success(this.contractAuditLedgerBiz.getAuditDetail(auditId));
   }

   @ApiOperation("审批台账-采购结算信息")
   @GetMapping("/settlementAudit/{auditId}")
   @PreAuthorize("@contractCollectionAccess.auditRecordRead(#auditId, 'detail')")
   public ResultVO<SupplierSettlementEchoAuditDto> settlementAudit(@PathVariable Long auditId) {
      log.info("API调用:获取审批台账-采购订单结算信息");
      return ResultBuilder.success(this.contractAuditLedgerBiz.settlementAuditDetail(auditId));
   }

   @ApiOperation("预结算-审批台账信息")
   @GetMapping("/preSettlementAudit/{auditId}")
   @PreAuthorize("@contractCollectionAccess.auditRecordRead(#auditId, 'detail')")
   public ResultVO<SupplierSettlementEchoAuditDto> preSettlementAudit(@PathVariable Long auditId) {
      log.info("API调用:预结算-审批台账信息");
      return ResultBuilder.success(this.contractAuditLedgerBiz.settlementAuditDetail(auditId));
   }

   @ApiOperation("结算审批(采购付款通用)")
   @PutMapping("/settlementAudit")
   public ResultVO settlementAudit(@RequestBody @Valid SettleAuditSaveDtoParam param) {
      log.info("API 调用： 结算审批(采购付款通用)");
      return ResultBuilder.success(this.contractAuditLedgerBiz.settlementAudit(param));
   }

   @ApiOperation("项目结算-校验")
   @GetMapping("/project/settlement/check")
   @PreAuthorize("@contractCollectionAccess.settlementDetail(null,#projectId,null)")
   public ResultVO<Map<String, Object>> checkBeforeProjectSettlement(Long projectId) {
      log.info("API调用:项目结算前校验");
      return ResultBuilder.success(this.contractAuditLedgerBiz.checkBeforeProjectSettlement(projectId));
   }

   @ApiOperation("项目台账-收入台账-新增结算")
   @PostMapping("/projectLedger/projectSettlementSave")
   @PreAuthorize("@contractCollectionAccess.settlementWrite(#param.projectId,#param.level,false)")
   public ResultVO saveProjectSettlement(@RequestBody @Valid ProjectSettlementSaveParam param) {
      log.info("Api调用:项目台账-收入台账-结算申请");
      return ResultBuilder.success(this.contractAuditLedgerBiz.saveProjectSettlement(param));
   }

   @ApiOperation("项目台账-项目台账结算详情")
   @GetMapping("/projectLedger/projectDetail")
   @PreAuthorize("@contractCollectionAccess.settlementDetail(#auditId,#projectId,#level)")
   public ResultVO<ProjectSettlementDTO> projectDetail(Long auditId, Long projectId, Integer level) {
      log.info("Api调用 ： 项目台账-项目台账结算申请");
      return ResultBuilder.success(this.contractAuditLedgerBiz.getProjectDetail(auditId, projectId, level));
   }

   @ApiOperation("项目台账-项目结算-审批")
   @PutMapping("/projectLedger/projectSettlementAudit")
   public ResultVO projectSettlementAudit(@RequestBody @Valid SettleAuditSaveDtoParam param) {
      log.info("Api调用 ： 项目台账-项目台账结算审批");
      return ResultBuilder.success(this.contractAuditLedgerBiz.projectSettlementAudit(param));
   }

   @ApiOperation("项目台账-项目预结算-审批")
   @PutMapping("/projectLedger/projectPreSettlementAudit")
   public ResultVO projectPreSettlementAudit(@RequestBody @Valid SettleAuditSaveDtoParam param) {
      log.info("Api调用:项目台账-项目预结算-审批");
      return ResultBuilder.success(this.contractAuditLedgerBiz.projectPreSettlementAudit(param));
   }

   @ApiOperation("分包订单-付款审批(自)")
   @PutMapping("/subcontract/selfPaymentAudit")
   public ResultVO subcontractSelfAudit(@RequestBody @Valid AddContractAuditDtoParam param) {
      log.info("API 调用： 供应链-分包订单付款审批(自)");
      return ResultBuilder.success(this.contractAuditLedgerBiz.subcontractSelfAudit(param));
   }

   @ApiOperation("分包订单-开票审批(自)")
   @PutMapping("/subcontract/selfInvoiceAudit")
   public ResultVO subcontractSelfInvoiceAudit(@RequestBody @Valid SubOrderInvoiceAuditParam param) {
      log.info("API 调用： 供应链-分包订单开票审批(自)");
      return ResultBuilder.success(this.contractAuditLedgerBiz.subcontractSelfInvoiceAudit(param));
   }

   @ApiOperation("分包订单-结算审批详情")
   @GetMapping("/subcontract/settlementAuditDetail")
   @PreAuthorize("@contractCollectionAccess.auditRecordRead(#auditId, 'detail')")
   public ResultVO<SupplierSettlementDto> subcontractSettlementAuditDetail(@RequestParam Long auditId) {
      log.info("API 调用： 供应链-分包结算审批详情(内、合)");
      return ResultBuilder.success(this.contractAuditLedgerBiz.subcontractSettlementAuditDetail(auditId));
   }

   @ApiOperation("分包订单-结算审批(自)")
   @PutMapping("/subcontract/selfSettlementAudit")
   public ResultVO subcontractOrderSettlementAudit(@RequestBody @Valid SettleAuditSaveDtoParam param) {
      log.info("API 调用： 供应链-分包订单-结算审批（内、合）");
      return ResultBuilder.success(this.contractAuditLedgerBiz.subcontractOrderSettlementAudit(param));
   }

   @ApiOperation("供应链-分包付款审批（内、合）")
   @PutMapping("/subcontractAudit")
   public ResultVO subcontractAudit(@RequestBody @Valid AddContractAuditDtoParam param) {
      log.info("API 调用： 供应链-分包付款审批（内、合）");
      return ResultBuilder.success(this.contractAuditLedgerBiz.subcontractAudit(param));
   }

   @ApiOperation("供应链-分包收票审批（内、合）")
   @PutMapping("/subcontractInvoiceAudit")
   public ResultVO subcontractInvoiceAudit(@RequestBody @Valid PaymentInvoiceDTOParam param) {
      log.info("API 调用： 供应链-分包收票审批（内、合）");
      return ResultBuilder.success(this.contractAuditLedgerBiz.subcontractInvoiceAudit(param));
   }

   @ApiOperation("供应链-分包订单结算审批（内、合）")
   @PutMapping("/subcontractOrderSettlementAudit")
   public ResultVO subcontractOrderSettlementAudit(@RequestParam Long auditId, @RequestParam Integer auditStatusEnum, BigDecimal actuallyPayAmount) {
      log.info("API 调用： 供应链-分包订单结算审批（内、合）");
      return ResultBuilder.success(this.contractAuditLedgerBiz.subcontractOrderSettlementAudit(auditId, auditStatusEnum, actuallyPayAmount));
   }

   @ApiOperation("分包订单-预结算审批(自)")
   @PutMapping("/subcontract/selfPreSettlementAudit")
   public ResultVO subcontractOrderPreSettlementAudit(@RequestBody @Valid SettleAuditSaveDtoParam param) {
      log.info("API 调用:供应链-分包订单-预结算审批");
      return ResultBuilder.success(this.contractAuditLedgerBiz.subcontractOrderPreSettlementAudit(param));
   }

   @ApiOperation("费用录入-检测费-审批详情")
   @GetMapping("/testingFee/auditDetail")
   @PreAuthorize("@contractFeeAuditAccess.read(#auditId, 14, 'expense_testing_cost')")
   public ResultVO<ContractTestingFeeAuditDTO> getTestingFeeAuditInfo(@RequestParam Long auditId) {
      log.info("Api调用:费用录入-检测费审批详情");
      return ResultBuilder.success(this.contractAuditLedgerBiz.getTestingFeeInfo(auditId));
   }

   @ApiOperation("费用录入-检测费-审批")
   @PostMapping("/testingFee/audit")
   public ResultVO<Boolean> auditTestingFee(@RequestBody FillFeeAuditSaveParam param) {
      log.info("Api调用:费用录入-检测费审批");
      return ResultBuilder.success(this.contractAuditLedgerBiz.auditTestingFee(param));
   }

   @ApiOperation("费用录入-水电物业费-审批详情")
   @GetMapping("/waterElectricityFee/auditDetail")
   @PreAuthorize("@contractFeeAuditAccess.read(#auditId, 15, 'water_electricity_property_cost')")
   public ResultVO<ContractWaterElectricityFeeAuditDTO> getWaterElectricityFeeAuditInfo(@RequestParam Long auditId) {
      log.info("Api调用:费用录入-水电物业费审批详情");
      return ResultBuilder.success(this.contractAuditLedgerBiz.getWaterElectricityFeeInfo(auditId));
   }

   @ApiOperation("费用录入-水电物业费-审批")
   @PostMapping("/waterElectricityFee/audit")
   public ResultVO<Boolean> auditWaterElectricityFee(@RequestBody FillFeeAuditSaveParam param) {
      log.info("Api调用:费用录入-水电物业费审批");
      return ResultBuilder.success(this.contractAuditLedgerBiz.auditWaterElectricityFee(param));
   }

   @ApiOperation("费用录入-报销费用-审批详情")
   @GetMapping("/reimbursementFee/auditDetail")
   @PreAuthorize("@contractFeeAuditAccess.read(#auditId, 16, 'reimburse_cost')")
   public ResultVO<ContractReimbursementFeeAuditDTO> getReimbursementFeeAuditInfo(@RequestParam Long auditId) {
      log.info("Api调用:费用录入-报销费用审批详情");
      return ResultBuilder.success(this.contractAuditLedgerBiz.getReimbursementFeeInfo(auditId));
   }

   @ApiOperation("费用录入-报销费用-审批")
   @PostMapping("/reimbursementFee/audit")
   public ResultVO<Boolean> auditReimbursementFee(@RequestBody FillFeeAuditSaveParam param) {
      log.info("Api调用:费用录入-报销费用审批");
      return ResultBuilder.success(this.contractAuditLedgerBiz.auditReimbursementFee(param));
   }

   @ApiOperation("费用录入-工资费用-审批详情")
   @GetMapping("/wageFee/auditDetail")
   @PreAuthorize("@contractFeeAuditAccess.read(#auditId, 17, 'expense_entry_wage_cost')")
   public ResultVO<ContractWageFeeAuditDTO> getWageFeeAuditInfo(@RequestParam Long auditId) {
      log.info("Api调用:费用录入-工资费用审批详情");
      return ResultBuilder.success(this.contractAuditLedgerBiz.getWageFeeInfo(auditId));
   }

   @ApiOperation("费用录入-工资费用-审批")
   @PostMapping("/wageFee/audit")
   public ResultVO<Boolean> auditWageFee(@RequestBody FillFeeAuditSaveParam param) {
      log.info("Api调用:费用录入-工资费用审批");
      return ResultBuilder.success(this.contractAuditLedgerBiz.auditWageFee(param));
   }
}
