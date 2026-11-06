package com.hzchum.scim.contract.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ListVO;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.PrintVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.biz.ContractSupplierInvoiceBiz;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.AuditTypeEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AuditPaymentEnum;
import com.hzchum.scim.contract.core.api.enums.payment.InvoiceTypeEnum;
import com.hzchum.scim.contract.core.api.enums.payment.OrderClassEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierSettlement;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.pojo.dto.SupplierSettlementDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierInvoiceDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierListDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementEchoDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseInvoiceDetailSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseInvoiceSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SubOrderInvoiceAddParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierInvoiceAddDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierInvoiceSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierInvoiceUpdateDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.scm.core.api.biz.PurchaseOrderBiz;
import com.hzchum.scim.scm.core.api.enums.PurchaseEnum;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo.dto.config.FinanceAmountLimitConfigDTO;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.wms.core.api.enums.DataStatusEnum;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = TransactionException.class)
public class ContractSupplierInvoiceBizImpl implements ContractSupplierInvoiceBiz {
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private PurchaseOrderBiz purchaseOrderBiz;
   @Resource
   private SupplierService supplierService;
   @Resource
   private SupplierInvoiceService supplierInvoiceService;
   @Resource
   private SupplierSettlementService supplierSettlementService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ConfigService configService;
   @Resource
   private SubcontractOrderService subcontractOrderService;
   @Resource
   private ContractAuditLedgerService auditLedgerService;
   @Autowired
   private ContractProjectService projectService;
   @Resource
   private WmsApproveRecordService approvalsService;
   @Resource
   private WmsApproveRecordDetailService approvalsDetailService;
   @Resource
   private SupplierPaymentService supplierPaymentService;

   @Override
   public PageVO<SupplierInvoiceDTO> pageListInvoiceByCondition(
      Long orderId, Integer propertyType, Long supplierId, Integer auditStatus, LocalDate startDate, LocalDate endDate, Integer pageNumber, Integer pageSize
   ) {
      PageHelper.startPage(pageNumber, pageSize);
      List<SupplierInvoiceDTO> supplierInvoiceDTOList = this.supplierInvoiceService
         .listByCondition(orderId, propertyType, supplierId, auditStatus, startDate, endDate);
      return new PageVO<>(supplierInvoiceDTOList);
   }

   @Override
   public ListVO<SupplierInvoiceDTO> listInvoiceByUnitId(Long branchCompanyId, Long supplierId, Integer auditStatus) {
      return new ListVO<>(this.supplierInvoiceService.listInvoiceByUnitId(branchCompanyId, supplierId, auditStatus));
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printInvoiceByCondition(
      Long orderId, Integer propertyType, Long supplierId, Integer auditStatus, LocalDate startDate, LocalDate endDate
   ) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      if (propertyType.equals(SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType()) && orderId != null) {
         PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(orderId);
         header.put("serialNumber", purchaseOrder.getSerialNumber());
         Supplier supplier = this.supplierService.getById(purchaseOrder.getSupplierId());
         header.put("supplierName", supplier != null ? supplier.getName() : "");
         header.put("signingTime", purchaseOrder.getSigningTime());
         header.put("amount", purchaseOrder.getAmount());
      }

      if (propertyType.equals(SupplierPropertyTypeEnum.SUB_FEE.getType()) && orderId != null) {
         SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(orderId);
         header.put("serialNumber", subcontractOrder.getSerialNumber());
         header.put("supplierName", subcontractOrder.getSupplierName());
         header.put("signingTime", subcontractOrder.getSignDate());
         header.put("amount", subcontractOrder.getAmount());
      }

      if (supplierId != null) {
         Supplier supplier = this.supplierService.getById(supplierId);
         header.put("supplierName", supplier.getName());
      }

      printVO.setHeader(header);
      List<Map<String, Object>> mapList = this.supplierInvoiceService
         .listByCondition(orderId, propertyType, supplierId, auditStatus, startDate, endDate)
         .stream()
         .map(BeanUtil::beanToMap)
         .collect(Collectors.toList());
      printVO.setTable(mapList);
      return printVO;
   }

   @Override
   public PrintVO<List<Map<String, Object>>> printInvoiceByUnitId(Long branchCompanyId, Long supplierId, Integer auditStatus) {
      PrintVO<List<Map<String, Object>>> printVO = new PrintVO<>();
      Map<String, Object> header = printVO.initHeader(UserUtil.getCurrentName());
      Supplier supplier = this.supplierService.getById(supplierId);
      header.put("supplierName", supplier.getName());
      printVO.setHeader(header);
      printVO.setTable(
         this.supplierInvoiceService
            .listInvoiceByUnitId(branchCompanyId, supplierId, auditStatus)
            .stream()
            .map(BeanUtil::beanToMap)
            .collect(Collectors.toList())
      );
      return printVO;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveSupplierInvoice(List<SupplierInvoiceSaveDTOParam> params) {
      List<SupplierInvoice> supplierInvoiceList = new ArrayList<>(16);
      params.forEach(
         param -> {
            Preconditions.checkArgument(param.getPropertyType() != null, "付款类型为空");
            Preconditions.checkArgument(SupplierPropertyTypeEnum.isExist(param.getPropertyType()), "付款类型错误");
            Preconditions.checkArgument(
               param.getPropertyType().equals(SupplierPropertyTypeEnum.TRANSPORT_FEE.getType()) || param.getOrderId() != null, "订单ID不能为空"
            );
            Preconditions.checkArgument(param.getBoolIncludeTax() || param.getTaxRate() == null || param.getTaxRate().compareTo(BigDecimal.ZERO) == 0, "税率有误!");
            Preconditions.checkArgument(!param.getBoolIncludeTax() || param.getTaxRate() != null, "税率不能为空!");
            if (param.getPropertyType().equals(SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())) {
               PurchaseOrder order = this.purchaseOrderService.getById(param.getOrderId());
               Preconditions.checkArgument(order != null, "原材料采购订单不存在");
            }

            if (param.getPropertyType().equals(SupplierPropertyTypeEnum.PURCHASE_FEE.getType())) {
            }

            if (param.getPropertyType().equals(SupplierPropertyTypeEnum.SUB_FEE.getType())) {
               SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(param.getOrderId());
               Preconditions.checkArgument(subcontractOrder != null, "分包订单不存在");
            }

            int count = this.supplierInvoiceService
               .count(
                  Wrappers.lambdaQuery(SupplierInvoice.class)
                     .eq(param.getOrderId() != null, SupplierInvoice::getOrderId, param.getOrderId())
                     .eq(SupplierInvoice::getPropertyType, param.getPropertyType())
                     .eq(SupplierInvoice::getSupplierId, param.getSupplierId())
                     .eq(SupplierInvoice::getBranchCompanyId, param.getBranchCompanyId())
                     .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType())
               );
            Preconditions.checkArgument(count == 0, "订单或供应商存在未审核的收票记录");
            SupplierInvoice invoice = BeanUtil.copy(param, SupplierInvoice.class);
            BranchCompany branchCompany = this.branchCompanyService.getById(param.getBranchCompanyId());
            invoice.setBranchCompanyName(branchCompany == null ? null : branchCompany.getName());
            if (param.getSupplierId() != null && param.getSupplierId() != 0L) {
               Supplier supplier = this.supplierService.getById(param.getSupplierId());
               Preconditions.checkArgument(supplier != null, "供应商不存在!");
               invoice.setSupplierName(supplier.getName());
            } else {
               invoice.setSupplierId(0L);
               invoice.setSupplierName("个人");
            }

            invoice.setApplyUserId(UserUtil.getCurrentUserId());
            invoice.setApplyUserName(UserUtil.getCurrentName());
            invoice.setAuditStatus(AuditStatusEnum.AUDITING.getType());
            invoice.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
            supplierInvoiceList.add(invoice);
         }
      );
      this.supplierInvoiceService.saveBatch(supplierInvoiceList);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean updateSupplierInvoice(SupplierInvoiceUpdateDTOParam param) {
      SupplierInvoice invoice = this.supplierInvoiceService.getById(param.getId());
      Preconditions.checkArgument(invoice != null, "收票记录不存在");
      Preconditions.checkArgument(invoice.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "收票记录已审核!");
      Preconditions.checkArgument(param.getBoolIncludeTax() || param.getTaxRate() == null || param.getTaxRate().compareTo(BigDecimal.ZERO) == 0, "税率有误!");
      Preconditions.checkArgument(!param.getBoolIncludeTax() || param.getTaxRate() != null, "税率不能为空!");
      BeanUtil.copy(param, invoice);
      String newIds = StringUtils.join(param.getAttachmentIds(), ",");
      this.attachmentService.replaceAttachment(invoice.getAttachmentIds(), newIds);
      invoice.setAttachmentIds(newIds);
      this.supplierInvoiceService.updateById(invoice);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean auditSupplierInvoice(Long id, Integer auditStatus) {
      Preconditions.checkArgument(auditStatus.equals(AuditStatusEnum.SUCCEED.getType()) || auditStatus.equals(AuditStatusEnum.FAILED.getType()), "审核状态传值有误!");
      SupplierInvoice invoice = this.supplierInvoiceService.getById(id);
      Preconditions.checkArgument(invoice != null, "发票填报信息不存在");
      Preconditions.checkArgument(invoice.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "该发票填报已审核!");
      invoice.setAuditStatus(auditStatus);
      invoice.setAuditUserId(UserUtil.getCurrentUserId());
      invoice.setAuditUserName(UserUtil.getCurrentName());
      invoice.setAuditTime(LocalDateTime.now());
      this.supplierInvoiceService.updateById(invoice);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean deleteById(Long id) {
      SupplierInvoice invoice = this.supplierInvoiceService.getById(id);
      Preconditions.checkArgument(invoice != null, "收票记录不存在");
      Preconditions.checkArgument(invoice.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "删除失败,收票已审核!");
      this.attachmentService.deleteIds(invoice.getAttachmentIds());
      this.supplierInvoiceService.removeById(id);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean addSupplierInvoiceSelfOwned(PurchaseInvoiceSaveParam param) {
      Set<Long> orderIds = param.getOrderInvoiceList().stream().map(PurchaseInvoiceDetailSaveParam::getOrderId).collect(Collectors.toSet());
      Preconditions.checkArgument(orderIds.size() == param.getOrderInvoiceList().size(), "开票订单出现重复!");
      List<PurchaseOrder> purchaseOrderList = this.purchaseOrderService.listByIds(orderIds);
      Set<Long> supplierIds = purchaseOrderList.stream().map(PurchaseOrder::getSupplierId).collect(Collectors.toSet());
      Preconditions.checkArgument(supplierIds.size() == 1, "选择订单供应商不相同!");
      Map<Long, PurchaseOrder> purchaseOrderMap = purchaseOrderList.stream().collect(Collectors.toMap(PurchaseOrder::getId, Function.identity()));
      Map<Long, BigDecimal> orderIdInvoiceAmountMap = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .in(SupplierInvoice::getOrderId, orderIds)
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .in(SupplierInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .collect(
            Collectors.groupingBy(
               SupplierInvoice::getOrderId,
               Collectors.mapping(
                  s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getInvoiceAmount() : s.getActualInvoiceAmount(),
                  Collectors.reducing(BigDecimal.ZERO, BigDecimal::add)
               )
            )
         );
      Map<Long, SupplierSettlement> orderSettlementMap = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .in(SupplierSettlement::getOrderId, orderIds)
               .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         )
         .stream()
         .collect(Collectors.toMap(SupplierSettlement::getOrderId, Function.identity()));
      FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
      List<SupplierInvoice> supplierInvoiceList = new ArrayList<>(param.getOrderInvoiceList().size());
      param.getOrderInvoiceList()
         .forEach(
            detailParam -> {
               Preconditions.checkArgument(detailParam.getInvoiceAmount().compareTo(BigDecimal.ZERO) != 0, "发票金额不能为0!");
               PurchaseOrder purchaseOrder = purchaseOrderMap.get(detailParam.getOrderId());
               Preconditions.checkArgument(purchaseOrder != null, "采购订单不存在!");
               Preconditions.checkArgument(
                  purchaseOrder.getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType())
                     && purchaseOrder.getDataStatus().equals(DataStatusEnum.SUCCEED.getType()),
                  "订单状态不允许收票入账!"
               );
               BigDecimal invoiceAmount = orderIdInvoiceAmountMap.getOrDefault(detailParam.getOrderId(), BigDecimal.ZERO);
               if (purchaseOrder.getSettlementStatus() == null || purchaseOrder.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType())) {
                  if (!financeAmountLimitConfig.getBoolAllowOverContractAmount()) {
                     Preconditions.checkArgument(
                        invoiceAmount.add(detailParam.getInvoiceAmount()).compareTo(purchaseOrder.getAmount()) <= 0, "发票额总和(含未审批)不能超过订单合同额!"
                     );
                  }

                  if (!financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
                     SupplierSettlement settlement = orderSettlementMap.get(detailParam.getOrderId());
                     Preconditions.checkArgument(
                        settlement == null || invoiceAmount.add(detailParam.getInvoiceAmount()).compareTo(settlement.getAmount()) <= 0, "发票额总和(含未审批)不能超过申请结算额!"
                     );
                  }
               }

               if (SettlementStatusEnum.SETTLED.getType().equals(purchaseOrder.getSettlementStatus())
                  && !financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
                  Preconditions.checkArgument(
                     invoiceAmount.add(detailParam.getInvoiceAmount()).compareTo(purchaseOrder.getSettlementAmount()) <= 0, "发票额总和(含未审批)不能超过订单结算额!"
                  );
               }

               String attachmentIds = CollectionUtils.isNotEmpty(param.getAttachmentIds()) ? StringUtils.join(param.getAttachmentIds(), ",") : null;
               SupplierInvoice invoice = BeanUtil.copy(detailParam, SupplierInvoice.class);
               invoice.setOrderId(detailParam.getOrderId());
               invoice.setInvoiceSerialNumber(param.getInvoiceSerialNumber());
               invoice.setReceiveInvoiceDate(LocalDate.now());
               invoice.setAuditStatus(AuditStatusEnum.AUDITING.getType());
               invoice.setPropertyType(
                  purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())
                     ? SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType()
                     : SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
               );
               invoice.setInvoiceType(purchaseOrder.getInvoiceType());
               invoice.setTaxRate(purchaseOrder.getTaxRate());
               invoice.setSupplierId(purchaseOrder.getSupplierId());
               invoice.setBranchCompanyId(purchaseOrder.getBranchCompanyId());
               invoice.setAttachmentIds(attachmentIds);
               invoice.setReceiveInvoiceDate(LocalDate.now());
               invoice.setApplyUserId(UserUtil.getCurrentUserId());
               invoice.setApplyUserName(UserUtil.getCurrentName());
               invoice.setRemark(param.getRemark());
               supplierInvoiceList.add(invoice);
            }
         );
      this.supplierInvoiceService.saveBatch(supplierInvoiceList);
      Set<Long> projectIds = new HashSet<>();
      purchaseOrderList.forEach(purchaseOrder -> {
         if (StringUtils.isNotBlank(purchaseOrder.getProjectIds())) {
            Set<Long> collect = Arrays.stream(StringUtils.split(purchaseOrder.getProjectIds(), ",")).map(Long::valueOf).collect(Collectors.toSet());
            projectIds.addAll(collect);
         }
      });
      Long projectManagerId = null;
      if (!projectIds.isEmpty()) {
         List<ContractProject> projectList = this.projectService.listByIds(projectIds);
         Set<Long> salesLeaderIds = projectList.stream().map(ContractProject::getSalesLeaderId).filter(Objects::nonNull).collect(Collectors.toSet());
         Set<Long> signerIds = projectList.stream().map(ContractProject::getSignerId).filter(Objects::nonNull).collect(Collectors.toSet());
         projectManagerId = !salesLeaderIds.isEmpty() ? salesLeaderIds.iterator().next() : (!signerIds.isEmpty() ? signerIds.iterator().next() : null);
      }

      String dataSerialNumber = purchaseOrderList.size() == 1 ? purchaseOrderList.get(0).getSerialNumber() : purchaseOrderList.get(0).getSerialNumber() + "等";
      ContractAuditLedger contractAuditLedger = new ContractAuditLedger()
         .setPaymentId(StringUtils.join(supplierInvoiceList.stream().map(SupplierInvoice::getId).collect(Collectors.toList()), ","))
         .setProjectAttribute(ProjectAttributeEnum.SELF_SUPPORT.getType())
         .setPaymentEnum(AuditPaymentEnum.INCOMING_INVOICES.getType())
         .setProjectManagerId(projectManagerId)
         .setFilingDate(LocalDate.now().atStartOfDay())
         .setInitiatorId(UserUtil.getCurrentUserId())
         .setContractSignBodyId(purchaseOrderList.get(0).getBranchCompanyId())
         .setContractId(StringUtils.join(orderIds, ","))
         .setContractNumber(dataSerialNumber)
         .setSupplierId(supplierIds.iterator().next())
         .setProjectId(projectIds.isEmpty() ? null : StringUtils.join(projectIds, ","))
         .setApplyAmount(param.getOrderInvoiceList().stream().map(PurchaseInvoiceDetailSaveParam::getInvoiceAmount).reduce(BigDecimal.ZERO, BigDecimal::add))
         .setAttachmentIds(supplierInvoiceList.get(0).getAttachmentIds())
         .setAuditType(AuditTypeEnum.PAYMENT_APPROVE.getType())
         .setAuditStatusEnum(AuditStatusEnum.AUDITING.getType());
      this.auditLedgerService.save(contractAuditLedger);
      WmsApproveRecord record = this.approvalsService
         .createRecord(
            contractAuditLedger.getId(),
            dataSerialNumber,
            ApproveProcessTypeEnumV2.SELF_BUYING_INVOICE_AUDIT.getType(),
            null,
            null,
            null,
            true,
            null,
            null,
            null
         );
      contractAuditLedger.setApproveRecordId(record.getId());
      this.auditLedgerService.updateById(contractAuditLedger);
      return Boolean.TRUE;
   }

   @Override
   public List<SupplierSettlementDto> getPaymentSelfOwnedList(Long orderId) {
      List<SupplierPayment> paymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, orderId)
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      List<SupplierInvoice> invoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, orderId)
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      List<SupplierSettlementEchoDto> dto = new ArrayList<>();
      paymentList.forEach(
         m -> {
            SupplierSettlementEchoDto echoDto = new SupplierSettlementEchoDto()
               .setPaymentDate(m.getPaymentDate().atStartOfDay())
               .setPaymentAmount(m.getActuallyPaymentAmount());
            dto.add(echoDto);
         }
      );
      invoiceList.forEach(
         m -> {
            SupplierSettlementEchoDto echoDto = new SupplierSettlementEchoDto()
               .setInvoiceDate(m.getReceiveInvoiceDate().atStartOfDay())
               .setInvoiceAmount(m.getActualInvoiceAmount());
            dto.add(echoDto);
         }
      );
      SupplierSettlementDto purchaseOrder = this.purchaseOrderService.getPurchaseOrder(orderId);
      purchaseOrder.setDto(dto);
      return Arrays.asList(purchaseOrder);
   }

   @Override
   public SupplierSettlementDto getSubcontractSelfList(Long orderId, Long auditId) {
      if (ObjectUtils.isNotEmpty(auditId)) {
         ContractAuditLedger auditLedger = this.auditLedgerService.getById(auditId);
         Preconditions.checkArgument(ObjectUtils.isNotEmpty(auditLedger), "审批单不存在");
         orderId = Long.valueOf(auditLedger.getContractId());
      }

      SubcontractOrder order = this.subcontractOrderService.getById(orderId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(order), "订单不存在");
      List<SupplierPayment> paymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, orderId)
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
         );
      List<SupplierInvoice> invoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, orderId)
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
         );
      BranchCompany branchCompany = this.branchCompanyService.getById(order.getBranchCompanyId());
      List<SupplierSettlementEchoDto> dtoList = new ArrayList<>();
      if (CollectionUtils.isNotEmpty(paymentList)) {
         paymentList.forEach(
            a -> dtoList.add(
               SupplierSettlementEchoDto.builder().paymentAmount(a.getActuallyPaymentAmount()).paymentDate(a.getPaymentDate().atStartOfDay()).build()
            )
         );
      }

      if (CollectionUtils.isNotEmpty(invoiceList)) {
         invoiceList.forEach(
            a -> dtoList.add(
               SupplierSettlementEchoDto.builder().invoiceDate(a.getReceiveInvoiceDate().atStartOfDay()).invoiceAmount(a.getActualInvoiceAmount()).build()
            )
         );
      }

      return SupplierSettlementDto.builder()
         .contractNumber(order.getSerialNumber())
         .branchCompanyId(order.getBranchCompanyId())
         .branchCompanyName(branchCompany.getName())
         .supplierId(order.getSupplierId())
         .supplierName(order.getSupplierName())
         .amount(order.getAmount())
         .subcontractClassId(order.getSubcontractClassId())
         .subcontractClassName(order.getSubcontractClassName())
         .settlementAmount(order.getSettlementAmount())
         .projectAttribute(order.getProjectAttribute())
         .basicClass(order.getSubcontractClassId().intValue())
         .basicClassName(order.getSubcontractClassName())
         .dto(dtoList)
         .build();
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveSubOrderInvoice(SubOrderInvoiceAddParam param) {
      Preconditions.checkArgument(param.getInvoiceAmount().compareTo(BigDecimal.ZERO) != 0, "发票金额不能为0!");
      SubcontractOrder order = this.subcontractOrderService.getById(param.getOrderId());
      Preconditions.checkArgument(order != null, "分包订单不存在!");
      ContractProject project = this.projectService.getById(order.getProjectId());
      Preconditions.checkArgument(project != null, "订单所属项目不存在!");
      BigDecimal invoiceAmount = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
               .eq(SupplierInvoice::getOrderId, param.getOrderId())
               .in(SupplierInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .map(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getInvoiceAmount() : s.getActualInvoiceAmount())
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
      if (!order.getBoolSettlementStatus()) {
         if (!financeAmountLimitConfig.getBoolAllowOverContractAmount()) {
            Preconditions.checkArgument(invoiceAmount.add(param.getInvoiceAmount()).compareTo(order.getAmount()) <= 0, "收票总额(含未审批)不能超过订单合同额!");
         }

         if (!financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
            SupplierSettlement settlement = this.supplierSettlementService
               .getOne(
                  Wrappers.lambdaQuery(SupplierSettlement.class)
                     .eq(SupplierSettlement::getOrderClass, OrderClassEnum.SUB_ORDER.getType())
                     .eq(SupplierSettlement::getOrderId, param.getOrderId())
                     .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
               );
            Preconditions.checkArgument(
               settlement == null || invoiceAmount.add(param.getInvoiceAmount()).compareTo(settlement.getAmount()) <= 0, "收票总额(含未审批)不能超过订单申请结算额!"
            );
         }
      }

      if (order.getBoolSettlementStatus() && !financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
         Preconditions.checkArgument(invoiceAmount.add(param.getInvoiceAmount()).compareTo(order.getSettlementAmount()) <= 0, "发票额总和(含未审批)不能超过订单结算额!");
      }

      String attachmentIds = CollectionUtils.isNotEmpty(param.getAttachmentId()) ? StringUtils.join(param.getAttachmentId(), ",") : null;
      SupplierInvoice invoice = BeanUtil.copy(param, SupplierInvoice.class);
      invoice.setPropertyType(SupplierPropertyTypeEnum.SUB_FEE.getType());
      invoice.setReceiveInvoiceDate(LocalDate.now());
      invoice.setInvoiceType(order.getInvoiceType());
      invoice.setTaxRate(order.getTaxRate());
      invoice.setBoolIncludeTax(!order.getInvoiceType().equals(InvoiceTypeEnum.RECEIPTS.getType()));
      invoice.setBranchCompanyId(order.getBranchCompanyId());
      invoice.setBranchCompanyName(this.branchCompanyService.getNameById(order.getBranchCompanyId()));
      invoice.setSupplierId(order.getSupplierId());
      invoice.setSupplierName(order.getSupplierName());
      invoice.setApplyUserId(UserUtil.getCurrentUserId());
      invoice.setApplyUserName(UserUtil.getCurrentName());
      invoice.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      invoice.setAttachmentIds(attachmentIds);
      this.supplierInvoiceService.save(invoice);
      ContractAuditLedger contractAuditLedger = new ContractAuditLedger()
         .setAuditType(AuditTypeEnum.SUB_CONTRACT_APPROVE.getType())
         .setPaymentId(invoice.getId().toString())
         .setProjectAttribute(order.getProjectAttribute())
         .setPaymentEnum(AuditPaymentEnum.INCOMING_INVOICES.getType())
         .setFilingDate(invoice.getReceiveInvoiceDate().atStartOfDay())
         .setInitiatorId(UserUtil.getCurrentUserId())
         .setContractSignBodyId(order.getBranchCompanyId())
         .setContractId(invoice.getOrderId().toString())
         .setContractNumber(order.getSerialNumber())
         .setProjectManagerId(project.getSalesLeaderId() != null ? project.getSalesLeaderId() : project.getSignerId())
         .setSupplierId(order.getSupplierId())
         .setProjectId(order.getProjectId().toString())
         .setApplyAmount(invoice.getInvoiceAmount())
         .setPaymentDate(invoice.getReceiveInvoiceDate().atStartOfDay())
         .setAttachmentIds(attachmentIds)
         .setAuditType(AuditTypeEnum.SUB_CONTRACT_APPROVE.getType())
         .setAuditStatusEnum(AuditStatusEnum.AUDITING.getType());
      this.auditLedgerService.save(contractAuditLedger);
      WmsApproveRecord record = this.approvalsService
         .createRecord(
            contractAuditLedger.getId(),
            contractAuditLedger.getContractNumber(),
            ApproveProcessTypeEnumV2.OUTSOURCING_ORDER_INVOICE_AUDIT.getType(),
            null,
            null,
            null,
            true,
            null,
            null,
            null
         );
      contractAuditLedger.setApproveRecordId(record.getId());
      this.auditLedgerService.updateById(contractAuditLedger);
      return true;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean AddSupplierInvoice(SupplierInvoiceAddDTOParam param) {
      SupplierInvoice one = this.supplierInvoiceService
         .getOne(Wrappers.lambdaQuery(SupplierInvoice.class).eq(SupplierInvoice::getInvoiceSerialNumber, param.getInvoiceSerialNumber()));
      Preconditions.checkArgument(one == null, "发票编号重复");
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(param.getOrderId());
      Preconditions.checkArgument(purchaseOrder != null, "订单不存在!");
      Preconditions.checkArgument(
         purchaseOrder.getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType()) && purchaseOrder.getDataStatus().equals(DataStatusEnum.SUCCEED.getType()),
         "订单当前状态不允许收票!"
      );
      if (purchaseOrder.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType())) {
         List<SupplierInvoice> invoiceList = this.supplierInvoiceService
            .list(
               Wrappers.lambdaQuery(SupplierInvoice.class)
                  .eq(SupplierInvoice::getOrderId, param.getOrderId())
                  .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
                  .in(
                     SupplierInvoice::getPropertyType,
                     SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(),
                     SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
                  )
            );
         BigDecimal invoiceAmount = invoiceList.stream()
            .map(SupplierInvoice::getActualInvoiceAmount)
            .filter(ObjectUtils::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(invoiceAmount.add(param.getInvoiceAmount()).compareTo(purchaseOrder.getSettlementAmount()) <= 0, "发票金额超出结算金额");
      }

      List<SupplierSettlement> supplierSettlementList = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, param.getOrderId())
               .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(supplierSettlementList.isEmpty(), "订单正在结算审批中,提交失败!");
      ContractProject project = this.projectService.getById(param.getProjectId());
      Preconditions.checkArgument(project.getContractAmount().compareTo(param.getInvoiceAmount()) >= 0, "发票面额超出合同金额");
      SupplierInvoice invoice = BeanUtil.copy(param, SupplierInvoice.class);
      if (param.getAttachmentId() != null) {
         invoice.setAttachmentIds(param.getAttachmentId().toString());
      }

      invoice.setReceiveInvoiceDate(LocalDate.now());
      invoice.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      invoice.setPropertyType(
         purchaseOrder.getPurchaseType().equals(PurchaseEnum.MATERIAL.getType())
            ? SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType()
            : SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
      );
      invoice.setInvoiceType(purchaseOrder.getInvoiceType());
      invoice.setBranchCompanyId(purchaseOrder.getBranchCompanyId());
      invoice.setSupplierId(purchaseOrder.getSupplierId());
      invoice.setInvoiceAmount(param.getInvoiceAmount());
      invoice.setTaxRate(purchaseOrder.getTaxRate());
      invoice.setReceiveInvoiceDate(param.getInvoiceDate() != null ? LocalDate.from(param.getInvoiceDate()) : LocalDate.now());
      invoice.setApplyUserId(UserUtil.getCurrentUserId());
      this.supplierInvoiceService.save(invoice);
      this.saveAudit(
         invoice,
         project,
         purchaseOrder.getBranchCompanyId(),
         purchaseOrder.getSerialNumber(),
         purchaseOrder.getProjectIds(),
         purchaseOrder.getProjectManagerId(),
         param.getRemark(),
         ApproveProcessTypeEnumV2.INNER_PACKAGE_INVOICE_AUDIT.getType(),
         AuditTypeEnum.PAYMENT_APPROVE.getType()
      );
      return Boolean.TRUE;
   }

   @Override
   public List<SupplierListDto> getPurchase(Long projectId, Long supplierId) {
      List<SupplierInvoice> list = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getProjectId, projectId)
               .eq(SupplierInvoice::getSupplierId, supplierId)
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      return list.stream().map(m -> BeanUtil.copy(m, SupplierListDto.class)).collect(Collectors.toList());
   }

   private void saveAudit(
      SupplierInvoice invoice,
      ContractProject project,
      Long branchCompanyId,
      String serialNumber,
      String projectId,
      Long userId,
      String remark,
      Integer approveProcessTypeEnumV2,
      Integer type
   ) {
      ContractAuditLedger contractAuditLedger = new ContractAuditLedger()
         .setAuditType(type)
         .setPaymentId(invoice.getId().toString())
         .setProjectAttribute(project != null ? project.getProjectAttribute() : ProjectAttributeEnum.SELF_SUPPORT.getType())
         .setPaymentEnum(AuditPaymentEnum.INCOMING_INVOICES.getType())
         .setFilingDate(invoice.getReceiveInvoiceDate().atStartOfDay())
         .setInitiatorId(UserUtil.getCurrentUserId())
         .setProjectManagerId(userId)
         .setContractSignBodyId(branchCompanyId)
         .setContractId(invoice.getOrderId().toString())
         .setContractNumber(serialNumber)
         .setSupplierId(invoice.getSupplierId())
         .setProjectId(StringUtils.isNotBlank(projectId) ? projectId : null)
         .setApplyAmount(invoice.getInvoiceAmount())
         .setPaymentType(AuditPaymentEnum.INCOMING_INVOICES.getType())
         .setAuditStatusEnum(AuditStatusEnum.AUDITING.getType());
      if (ObjectUtils.isNotEmpty(project)) {
         contractAuditLedger.setProjectManagerId(
            project.getProjectAttribute().equals(ProjectAttributeEnum.SELF_SUPPORT.getType()) ? project.getSalesLeaderId() : project.getProjectManagerId()
         );
      }

      this.auditLedgerService.save(contractAuditLedger);
      WmsApproveRecord record = this.approvalsService
         .createRecord(contractAuditLedger.getId(), contractAuditLedger.getContractNumber(), approveProcessTypeEnumV2, null, null, null, true, null, null, null);
      contractAuditLedger.setApproveRecordId(record.getId());
      this.auditLedgerService.updateById(contractAuditLedger);
      List<WmsApproveRecordDetail> oneDetail = this.approvalsDetailService
         .list(Wrappers.lambdaQuery(WmsApproveRecordDetail.class).eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, record.getSerialNumber()));
      List<WmsApproveRecordDetail> collect = oneDetail.stream()
         .filter(a -> a.getStatus().equals(AuditStatusEnum.SUCCEED.getType()))
         .collect(Collectors.toList());
      if (CollectionUtils.isNotEmpty(collect)) {
         WmsApproveRecordDetail detail = collect.get(0);
         detail.setOpinion(remark);
         this.approvalsDetailService.updateById(detail);
      }
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean auditSubcontractInvoice(SupplierInvoiceAddDTOParam params) {
      SupplierInvoice one = this.supplierInvoiceService
         .getOne(Wrappers.lambdaQuery(SupplierInvoice.class).eq(SupplierInvoice::getInvoiceSerialNumber, params.getInvoiceSerialNumber()));
      Preconditions.checkArgument(one == null, "发票编号重复");
      SubcontractOrder purchaseOrder = this.subcontractOrderService.getById(params.getOrderId());
      if (purchaseOrder.getBoolSettlementStatus()) {
         List<SupplierInvoice> invoiceList = this.supplierInvoiceService
            .list(
               Wrappers.lambdaQuery(SupplierInvoice.class)
                  .eq(SupplierInvoice::getOrderId, params.getOrderId())
                  .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
                  .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
            );
         BigDecimal invoiceAmount = invoiceList.stream()
            .map(SupplierInvoice::getActualInvoiceAmount)
            .filter(ObjectUtils::isNotEmpty)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(invoiceAmount.add(params.getInvoiceAmount()).compareTo(purchaseOrder.getSettlementAmount()) <= 0, "发票金额超出结算金额");
      }

      ContractProject project = this.projectService.getById(params.getProjectId());
      Preconditions.checkArgument(project.getContractAmount().compareTo(params.getInvoiceAmount()) >= 0, "发票面额超出合同金额");
      SupplierInvoice invoice = BeanUtil.copy(params, SupplierInvoice.class);
      if (params.getAttachmentId() != null) {
         invoice.setAttachmentIds(params.getAttachmentId().toString());
      }

      invoice.setReceiveInvoiceDate(LocalDate.now());
      invoice.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      invoice.setPropertyType(SupplierPropertyTypeEnum.SUB_FEE.getType());
      invoice.setInvoiceType(purchaseOrder.getInvoiceType());
      invoice.setTaxRate(purchaseOrder.getTaxRate());
      invoice.setSupplierId(purchaseOrder.getSupplierId());
      invoice.setInvoiceAmount(params.getInvoiceAmount());
      invoice.setReceiveInvoiceDate(params.getInvoiceDate() != null ? LocalDate.from(params.getInvoiceDate()) : LocalDate.now());
      invoice.setApplyUserId(UserUtil.getCurrentUserId());
      this.supplierInvoiceService.save(invoice);
      this.saveAudit(
         invoice,
         project,
         purchaseOrder.getBranchCompanyId(),
         purchaseOrder.getSerialNumber(),
         purchaseOrder.getProjectId().toString(),
         purchaseOrder.getProjectManagerId(),
         params.getRemark(),
         ApproveProcessTypeEnumV2.OUTSOURCING_ORDER_INVOICE_AUDIT.getType(),
         AuditTypeEnum.SUB_CONTRACT_APPROVE.getType()
      );
      return Boolean.TRUE;
   }

   @Override
   public List<SupplierListDto> getSubcontractPaymentList(Long orderId) {
      List<SupplierInvoice> list = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
               .eq(SupplierInvoice::getOrderId, orderId)
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      return list.stream().map(m -> BeanUtil.copy(m, SupplierListDto.class)).collect(Collectors.toList());
   }
}
