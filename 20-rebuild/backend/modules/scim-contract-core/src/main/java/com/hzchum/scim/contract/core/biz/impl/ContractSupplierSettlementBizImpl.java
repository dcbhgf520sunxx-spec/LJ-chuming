package com.hzchum.scim.contract.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.contract.core.api.biz.ContractSupplierSettlementBiz;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.enums.AuditTypeEnum;
import com.hzchum.scim.contract.core.api.enums.SettlementStatusEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AuditPaymentEnum;
import com.hzchum.scim.contract.core.api.enums.payment.OrderClassEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierSettlement;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SelfEmployedSettlement;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementEchoDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseSettlementSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SubOrderSettlementAddParam;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.contract.core.mapper.SupplierSettlementMapper;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.pojo.dto.config.FinanceAmountLimitConfigDTO;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.DataStatusEnum;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.BasicInbound;
import com.hzchum.scim.wms.core.api.service.wmsConfig.BasicConfigService;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContractSupplierSettlementBizImpl implements ContractSupplierSettlementBiz {
   private final ConfigService configService;
   private final ContractProjectService projectService;
   private final PurchaseOrderService purchaseOrderService;
   private final SubcontractOrderService subcontractOrderService;
   private final InboundService inboundService;
   private final SupplierSettlementService supplierSettlementService;
   private final SupplierSettlementMapper supplierSettlementMapper;
   private final SupplierPaymentService supplierPaymentService;
   private final SupplierInvoiceService supplierInvoiceService;
   private final ContractAuditLedgerService auditLedgerService;
   private final WmsApproveRecordService approveRecordService;
   private final BranchCompanyService branchCompanyService;
   private final UserService userService;
   private final BasicConfigService basicConfigService;

   @Transactional
   @Override
   public ResultVO saveOaSelfEmployed(PurchaseSettlementSaveParam param) {
      ResultVO<Object> resultBuild = ResultVO.<Object>builder().build();
      PurchaseOrder order = this.purchaseOrderService.getById(param.getOrderId());
      Preconditions.checkArgument(order != null, "订单不存在");
      Preconditions.checkArgument(
         order.getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType()) && order.getDataStatus().equals(DataStatusEnum.SUCCEED.getType()), "订单当前状态不允许结算!"
      );
      Preconditions.checkArgument(!SettlementStatusEnum.SETTLED.getType().equals(order.getSettlementStatus()), "订单已结算");
      int count = this.supplierSettlementMapper
         .selectCount(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, param.getOrderId())
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(count == 0, "订单已提交结算!");
      List<SupplierPayment> supplierPaymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, param.getOrderId())
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .in(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
         );
      List<SupplierInvoice> invoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, param.getOrderId())
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
               .in(SupplierInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
         );
      BigDecimal paymentAmount = supplierPaymentList.stream()
         .map(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getPaymentAmount() : s.getActuallyPaymentAmount())
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      Preconditions.checkArgument(paymentAmount.compareTo(param.getSettlementAmount()) <= 0, "结算金额不能小于付款总额(含未审批)!");
      BigDecimal invoiceAmount = invoiceList.stream()
         .map(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getInvoiceAmount() : s.getActualInvoiceAmount())
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      Preconditions.checkArgument(invoiceAmount.compareTo(param.getSettlementAmount()) <= 0, "结算金额不能小于收票总额(含未审批)!");
      String userName = UserUtil.getCurrentName();
      if (param.getUserId() != null) {
         userName = this.userService.getNameById(param.getUserId());
         Preconditions.checkArgument(StringUtils.isNotBlank(userName), "创建人不存在!");
      }

      SupplierSettlement supplierSettlement = SupplierSettlement.builder()
         .orderId(param.getOrderId())
         .supplierId(order.getSupplierId())
         .orderClass(order.getPurchaseType())
         .amount(param.getSettlementAmount())
         .applyDate(param.getCreateTime().toLocalDate())
         .applyUserId(param.getUserId() != null ? param.getUserId() : UserUtil.getCurrentUserId())
         .applyUserName(userName)
         .attachmentIds(CollectionUtils.isNotEmpty(param.getAttachmentId()) ? StringUtils.join(param.getAttachmentId(), ",") : null)
         .remark(param.getRemark())
         .createUserId(UserUtil.getCurrentUserId())
         .auditStatus(AuditStatusEnum.AUDITING.getType())
         .build();
      supplierSettlement.setBoolDeleteEnum(Boolean.TRUE);
      this.supplierSettlementMapper.insert(supplierSettlement);
      ContractAuditLedger build = ContractAuditLedger.builder()
         .paymentId(supplierSettlement.getId().toString())
         .paymentEnum(AuditPaymentEnum.PURCHASE_SETTLEMENT.getType())
         .filingDate(param.getCreateTime())
         .contractId(String.valueOf(order.getId()))
         .contractNumber(order.getSerialNumber())
         .projectId(order.getProjectIds())
         .contractSignBodyId(order.getBranchCompanyId())
         .projectManagerId(order.getProjectManagerId())
         .supplierId(order.getSupplierId())
         .attachmentIds(param.getAttachmentId() != null ? String.valueOf(param.getAttachmentId()) : null)
         .applyAmount(param.getSettlementAmount())
         .initiatorId(param.getUserId())
         .writtenById(UserUtil.getCurrentUserId())
         .submitDate(LocalDateTime.now())
         .projectAttribute(order.getProjectAttribute())
         .auditStatusEnum(AuditStatusEnum.AUDITING.getType())
         .build();
      build.setBoolDeleteEnum(Boolean.TRUE);
      this.auditLedgerService.save(build);
      resultBuild.setData(build.getId());
      resultBuild.setCode(20000L);
      return resultBuild;
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveSelfEmployed(PurchaseSettlementSaveParam param) {
      PurchaseOrder order = this.purchaseOrderService.getById(param.getOrderId());
      Preconditions.checkArgument(order != null, "订单不存在");
      Preconditions.checkArgument(
         order.getReviewStatus().equals(ReviewStatusEnum.REVIEWED.getType()) && order.getDataStatus().equals(DataStatusEnum.SUCCEED.getType()), "订单当前状态不允许结算!"
      );
      Preconditions.checkArgument(!SettlementStatusEnum.SETTLED.getType().equals(order.getSettlementStatus()), "订单已结算");
      Preconditions.checkArgument(param.getSettlementAmount() != null && param.getSettlementAmount().compareTo(BigDecimal.ZERO) > 0, "申请金额必须大于0!");
      BasicInbound purchaseSpecBasicConf = this.basicConfigService.getPurchaseSpecBasicConf();
      if (Integer.valueOf(1).equals(purchaseSpecBasicConf.getSettlementInventoryAmount())) {
         BigDecimal actualInboundAmount = this.purchaseOrderService.getActualInboundAmount(param.getOrderId(), order.getOrderPlace(), order.getPurchaseType());
         Preconditions.checkArgument(actualInboundAmount != null && actualInboundAmount.compareTo(BigDecimal.ZERO) > 0, "采购单入库额必须大于0!");
      }

      List<SupplierSettlement> settlementList = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, param.getOrderId())
               .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
               .in(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
         );
      Preconditions.checkArgument(settlementList.isEmpty() || settlementList.stream().allMatch(SupplierSettlement::getBoolPreSettlement), "订单已提交结算!");
      BigDecimal preSettlementAmount = settlementList.stream().map(SupplierSettlement::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add);
      if (param.getBoolPreSettlement()) {
         BigDecimal actualInboundAmount = this.inboundService.getActualInboundAmount(param.getOrderId(), order.getOrderPlace(), order.getPurchaseType());
         Preconditions.checkArgument(preSettlementAmount.add(param.getSettlementAmount()).compareTo(actualInboundAmount) <= 0, "预结算总额不能大于订单入库额!");
      } else {
         Preconditions.checkArgument(param.getSettlementAmount().compareTo(preSettlementAmount) >= 0, "订单结算额不能预结算总额(含未审批)!");
         FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
         if (!financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
            BigDecimal paymentAmount = this.supplierPaymentService
               .list(
                  Wrappers.lambdaQuery(SupplierPayment.class)
                     .eq(SupplierPayment::getOrderId, param.getOrderId())
                     .in(
                        SupplierPayment::getPropertyType,
                        SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(),
                        SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
                     )
                     .in(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
               )
               .stream()
               .map(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getPaymentAmount() : s.getActuallyPaymentAmount())
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            Preconditions.checkArgument(param.getSettlementAmount().compareTo(paymentAmount) >= 0, "结算金额不能小于付款总额(含未审批)!");
            BigDecimal invoiceAmount = this.supplierInvoiceService
               .list(
                  Wrappers.lambdaQuery(SupplierInvoice.class)
                     .eq(SupplierInvoice::getOrderId, param.getOrderId())
                     .in(
                        SupplierInvoice::getPropertyType,
                        SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(),
                        SupplierPropertyTypeEnum.PURCHASE_FEE.getType()
                     )
                     .in(SupplierInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
               )
               .stream()
               .map(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getInvoiceAmount() : s.getActualInvoiceAmount())
               .reduce(BigDecimal.ZERO, BigDecimal::add);
            Preconditions.checkArgument(param.getSettlementAmount().compareTo(invoiceAmount) >= 0, "结算金额不能小于收票总额(含未审批)!");
         }
      }

      String userName = UserUtil.getCurrentName();
      if (param.getUserId() != null) {
         userName = this.userService.getNameById(param.getUserId());
         Preconditions.checkArgument(StringUtils.isNotBlank(userName), "创建人不存在!");
      }

      String attachmentIds = CollectionUtils.isNotEmpty(param.getAttachmentId()) ? StringUtils.join(param.getAttachmentId(), ",") : null;
      SupplierSettlement supplierSettlement = SupplierSettlement.builder()
         .boolPreSettlement(param.getBoolPreSettlement())
         .orderId(param.getOrderId())
         .supplierId(order.getSupplierId())
         .orderClass(order.getPurchaseType())
         .amount(param.getSettlementAmount())
         .applyDate(param.getCreateTime().toLocalDate())
         .applyUserId(param.getUserId() != null ? param.getUserId() : UserUtil.getCurrentUserId())
         .applyUserName(userName)
         .attachmentIds(attachmentIds)
         .remark(param.getRemark())
         .createUserId(UserUtil.getCurrentUserId())
         .auditStatus(AuditStatusEnum.AUDITING.getType())
         .build();
      this.supplierSettlementService.save(supplierSettlement);
      Long projectManagerId = null;
      if (StringUtils.isNotBlank(order.getProjectIds())) {
         List<Long> projectIds = Arrays.stream(order.getProjectIds().split(",")).map(Long::valueOf).collect(Collectors.toList());
         List<ContractProject> projectList = this.projectService.listByIds(projectIds);
         if (CollectionUtils.isNotEmpty(projectList)) {
            ContractProject project = projectList.get(0);
            projectManagerId = project.getSalesLeaderId() != null
               ? project.getSalesLeaderId()
               : (project.getSignerId() != null ? project.getSignerId() : project.getProjectManagerId());
         }
      }

      ContractAuditLedger build = ContractAuditLedger.builder()
         .auditType(AuditTypeEnum.PAYMENT_APPROVE.getType())
         .paymentId(supplierSettlement.getId().toString())
         .paymentEnum(param.getBoolPreSettlement() ? AuditPaymentEnum.PURCHASE_PRE_SETTLEMENT.getType() : AuditPaymentEnum.PURCHASE_SETTLEMENT.getType())
         .filingDate(param.getCreateTime())
         .contractId(String.valueOf(order.getId()))
         .contractNumber(order.getSerialNumber())
         .projectId(order.getProjectIds())
         .contractSignBodyId(order.getBranchCompanyId())
         .projectManagerId(projectManagerId)
         .supplierId(order.getSupplierId())
         .applyAmount(param.getSettlementAmount())
         .initiatorId(param.getUserId())
         .projectAttribute(order.getProjectAttribute())
         .auditStatusEnum(AuditStatusEnum.AUDITING.getType())
         .attachmentIds(attachmentIds)
         .build();
      this.auditLedgerService.save(build);
      Integer approveProcessType = param.getBoolPreSettlement()
         ? ApproveProcessTypeEnumV2.SELF_BUYING_PRE_SETTLE_AUDIT.getType()
         : ApproveProcessTypeEnumV2.SELF_BUYING_SETTLEANACCOUNT_AUDIT.getType();
      WmsApproveRecord record = this.approveRecordService
         .createRecord(build.getId(), build.getContractNumber(), approveProcessType, null, null, null, true, null, null, null);
      build.setApproveRecordId(record.getId());
      this.auditLedgerService.updateById(build);
      return true;
   }

   @Override
   public SelfEmployedSettlement getSupplierSettlement(Long orderId) {
      List<SupplierSettlementEchoDto> delegateList = new ArrayList<>(16);
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(orderId);
      Preconditions.checkArgument(purchaseOrder != null, "订单不存在");
      String projectName = null;
      if (purchaseOrder.getProjectIds() != null && !purchaseOrder.getProjectIds().isEmpty()) {
         List<Long> projectIds = Arrays.stream(purchaseOrder.getProjectIds().split(",")).map(Long::valueOf).collect(Collectors.toList());
         if (!projectIds.isEmpty()) {
            List<ContractProject> projectList = this.projectService.list(Wrappers.lambdaQuery(ContractProject.class).in(ContractProject::getId, projectIds));
            projectName = projectList.stream().map(ContractProject::getShortName).collect(Collectors.joining("+"));
         }
      }

      List<SupplierPayment> paymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, orderId)
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .in(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
         );
      List<SupplierInvoice> invoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, orderId)
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .in(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType(), SupplierPropertyTypeEnum.PURCHASE_FEE.getType())
         );
      paymentList.forEach(
         a -> delegateList.add(new SupplierSettlementEchoDto().setPaymentDate(a.getPaymentDate().atStartOfDay()).setPaymentAmount(a.getActuallyPaymentAmount()))
      );
      invoiceList.forEach(
         invoice -> delegateList.add(
            new SupplierSettlementEchoDto().setInvoiceAmount(invoice.getActualInvoiceAmount()).setInvoiceDate(invoice.getReceiveInvoiceDate().atStartOfDay())
         )
      );
      BigDecimal preSettlementAmount = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, orderId)
               .eq(SupplierSettlement::getBoolPreSettlement, true)
               .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         )
         .stream()
         .map(SupplierSettlement::getAmount)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      return new SelfEmployedSettlement()
         .setProjectName(projectName)
         .setBranchCompanyName(this.branchCompanyService.getNameById(purchaseOrder.getBranchCompanyId()))
         .setContractAmount(purchaseOrder.getAmount())
         .setPaymentAmountSum(paymentList.stream().map(SupplierPayment::getActuallyPaymentAmount).reduce(BigDecimal.ZERO, BigDecimal::add))
         .setInvoiceAmountSum(invoiceList.stream().map(SupplierInvoice::getActualInvoiceAmount).reduce(BigDecimal.ZERO, BigDecimal::add))
         .setInboundAmountSum(this.inboundService.getActualInboundAmount(orderId, purchaseOrder.getOrderPlace(), purchaseOrder.getPurchaseType()))
         .setPreSettlementAmount(preSettlementAmount)
         .setSupplierSettlementEchoDtoPageVO(delegateList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveSubcontractOrder(SubOrderSettlementAddParam param) {
      Preconditions.checkArgument(param.getSettlementAmount().compareTo(BigDecimal.ZERO) > 0, "结算额必须大于0!!");
      SubcontractOrder order = this.subcontractOrderService.getById(param.getOrderId());
      Preconditions.checkArgument(order != null, "订单不存在");
      Preconditions.checkArgument(!order.getBoolSettlementStatus(), "订单已结算!");
      ContractProject project = this.projectService.getById(order.getProjectId());
      Preconditions.checkArgument(project != null, "分包订单项目数据丢失!");
      List<SupplierSettlement> supplierSettlements = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, order.getId())
               .eq(SupplierSettlement::getBoolPreSettlement, false)
               .eq(SupplierSettlement::getOrderClass, OrderClassEnum.SUB_ORDER.getType())
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(CollectionUtils.isEmpty(supplierSettlements), "订单结算正在审批中!");
      FinanceAmountLimitConfigDTO financeAmountLimitConfig = this.configService.getFinanceAmountLimitConfig();
      if (!financeAmountLimitConfig.getBoolAllowOverSettleAmount()) {
         BigDecimal paymentAmount = this.supplierPaymentService
            .list(
               Wrappers.lambdaQuery(SupplierPayment.class)
                  .eq(SupplierPayment::getOrderId, param.getOrderId())
                  .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                  .in(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .map(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getPaymentAmount() : s.getActuallyPaymentAmount())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(param.getSettlementAmount().compareTo(paymentAmount) >= 0, "结算金额不能小于付款总额(含未审批)!");
         BigDecimal invoiceAmount = this.supplierInvoiceService
            .list(
               Wrappers.lambdaQuery(SupplierInvoice.class)
                  .eq(SupplierInvoice::getOrderId, param.getOrderId())
                  .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                  .in(SupplierInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .map(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? s.getInvoiceAmount() : s.getActualInvoiceAmount())
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(param.getSettlementAmount().compareTo(invoiceAmount) >= 0, "结算金额不能小于收票总额(含未审批)!");
      }

      String attachmentIds = CollectionUtils.isNotEmpty(param.getAttachmentId()) ? StringUtils.join(param.getAttachmentId(), ",") : null;
      SupplierSettlement settlement = BeanUtil.copy(param, SupplierSettlement.class);
      settlement.setAuditStatus(AuditStatusEnum.AUDITING.getType())
         .setAmount(param.getSettlementAmount())
         .setBoolPreSettlement(false)
         .setOrderClass(OrderClassEnum.SUB_ORDER.getType())
         .setSupplierId(order.getSupplierId())
         .setApplyUserId(param.getUserId() != null ? param.getUserId() : UserUtil.getCurrentUserId())
         .setApplyUserName(param.getUserId() != null ? this.userService.getNameById(param.getUserId()) : UserUtil.getCurrentName())
         .setApplyDate(param.getCreateTime() != null ? param.getCreateTime().toLocalDate() : LocalDate.now())
         .setRemark(param.getRemark())
         .setAttachmentIds(attachmentIds)
         .setCreateUserId(UserUtil.getCurrentUserId());
      this.supplierSettlementService.save(settlement);
      ContractAuditLedger contractAuditLedger = new ContractAuditLedger()
         .setAuditType(AuditTypeEnum.SUB_CONTRACT_APPROVE.getType())
         .setPaymentId(settlement.getId().toString())
         .setContractId(param.getOrderId().toString())
         .setFilingDate(param.getCreateTime())
         .setPaymentEnum(AuditPaymentEnum.SUBCONTRACT_SETTLEMENT.getType())
         .setContractNumber(order.getSerialNumber())
         .setProjectAttribute(order.getProjectAttribute())
         .setInitiatorId(UserUtil.getCurrentUserId())
         .setProjectId(order.getProjectId().toString())
         .setContractSignBodyId(order.getBranchCompanyId())
         .setProjectManagerId(project.getSalesLeaderId() != null ? project.getSalesLeaderId() : project.getSignerId())
         .setSupplierId(order.getSupplierId())
         .setApplyAmount(param.getSettlementAmount())
         .setPaymentDate(param.getCreateTime())
         .setAttachmentIds(attachmentIds)
         .setAuditStatusEnum(AuditStatusEnum.AUDITING.getType());
      this.auditLedgerService.save(contractAuditLedger);
      WmsApproveRecord record = this.approveRecordService
         .createRecord(
            contractAuditLedger.getId(),
            contractAuditLedger.getContractNumber(),
            ApproveProcessTypeEnumV2.OUTSOURCING_ORDER_SETTLE_AUDIT.getType(),
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
   public SelfEmployedSettlement getSubcontractOrder(Long orderId) {
      SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(orderId);
      Preconditions.checkArgument(ObjectUtils.isNotEmpty(subcontractOrder), "分包订单不存在");
      List<SupplierSettlementEchoDto> delegateList = new ArrayList<>(16);
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
      paymentList.forEach(
         a -> delegateList.add(new SupplierSettlementEchoDto().setPaymentDate(a.getPaymentDate().atStartOfDay()).setPaymentAmount(a.getActuallyPaymentAmount()))
      );
      invoiceList.forEach(
         invoice -> delegateList.add(
            new SupplierSettlementEchoDto().setInvoiceAmount(invoice.getActualInvoiceAmount()).setInvoiceDate(invoice.getReceiveInvoiceDate().atStartOfDay())
         )
      );
      return new SelfEmployedSettlement()
         .setProjectName(this.projectService.getById(subcontractOrder.getProjectId()).getShortName())
         .setBranchCompanyName(this.branchCompanyService.getNameById(subcontractOrder.getBranchCompanyId()))
         .setContractAmount(subcontractOrder.getAmount())
         .setSupplierSettlementEchoDtoPageVO(delegateList);
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveSubcontractOrderPre(SubOrderSettlementAddParam param) {
      Preconditions.checkArgument(param.getSettlementAmount().compareTo(BigDecimal.ZERO) != 0, "预结算金额不能为0!");
      if (param.getUserId() != null) {
         User user = this.userService.getById(param.getUserId());
         Preconditions.checkArgument(user != null, "创建人不存在!");
      }

      SubcontractOrder order = this.subcontractOrderService.getById(param.getOrderId());
      Preconditions.checkArgument(order != null, "分包订单不存在!");
      Preconditions.checkArgument(!order.getBoolSettlementStatus(), "订单已结算!");
      ContractProject project = this.projectService.getById(order.getProjectId());
      Preconditions.checkArgument(project != null, "分包订单项目数据丢失!");
      List<SupplierSettlement> supplierSettlements = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, param.getOrderId())
               .eq(SupplierSettlement::getOrderClass, OrderClassEnum.SUB_ORDER.getType())
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(supplierSettlements.stream().allMatch(SupplierSettlement::getBoolPreSettlement), "订单存在未审批的预结算记录!!");
      Preconditions.checkArgument(supplierSettlements.isEmpty(), "订单存在未审批的预结算记录!!");
      String attachmentIds = CollectionUtils.isNotEmpty(param.getAttachmentId()) ? StringUtils.join(param.getAttachmentId(), ",") : null;
      SupplierSettlement settlement = SupplierSettlement.builder()
         .orderId(param.getOrderId())
         .orderClass(OrderClassEnum.SUB_ORDER.getType())
         .boolPreSettlement(true)
         .amount(param.getSettlementAmount())
         .applyDate(param.getCreateTime().toLocalDate())
         .supplierId(order.getSupplierId())
         .applyUserId(param.getUserId() != null ? param.getUserId() : UserUtil.getCurrentUserId())
         .applyUserName(param.getUserId() != null ? this.userService.getNameById(param.getUserId()) : UserUtil.getCurrentName())
         .createUserId(UserUtil.getCurrentUserId())
         .auditStatus(AuditStatusEnum.AUDITING.getType())
         .remark(param.getRemark())
         .attachmentIds(attachmentIds)
         .build();
      boolean save = this.supplierSettlementService.save(settlement);
      ContractAuditLedger contractAuditLedger = new ContractAuditLedger()
         .setAuditType(AuditTypeEnum.SUB_CONTRACT_APPROVE.getType())
         .setPaymentEnum(AuditPaymentEnum.SUBCONTRACT_PRE_SETTLEMENT.getType())
         .setPaymentId(settlement.getId().toString())
         .setPaymentDate(param.getCreateTime())
         .setContractId(param.getOrderId().toString())
         .setContractNumber(order.getSerialNumber())
         .setProjectAttribute(order.getProjectAttribute())
         .setProjectId(order.getProjectId().toString())
         .setContractSignBodyId(order.getBranchCompanyId())
         .setSupplierId(order.getSupplierId())
         .setFilingDate(param.getCreateTime())
         .setInitiatorId(UserUtil.getCurrentUserId())
         .setProjectManagerId(project.getSalesLeaderId() != null ? project.getSalesLeaderId() : project.getSignerId())
         .setApplyAmount(param.getSettlementAmount())
         .setAttachmentIds(attachmentIds)
         .setAuditStatusEnum(AuditStatusEnum.AUDITING.getType());
      this.auditLedgerService.save(contractAuditLedger);
      WmsApproveRecord record = this.approveRecordService
         .createRecord(
            contractAuditLedger.getId(),
            contractAuditLedger.getContractNumber(),
            ApproveProcessTypeEnumV2.OUTSOURCING_ORDER_PRE_SETTLE_AUDIT.getType(),
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
      return save;
   }

   public ContractSupplierSettlementBizImpl(
      final ConfigService configService,
      final ContractProjectService projectService,
      final PurchaseOrderService purchaseOrderService,
      final SubcontractOrderService subcontractOrderService,
      final InboundService inboundService,
      final SupplierSettlementService supplierSettlementService,
      final SupplierSettlementMapper supplierSettlementMapper,
      final SupplierPaymentService supplierPaymentService,
      final SupplierInvoiceService supplierInvoiceService,
      final ContractAuditLedgerService auditLedgerService,
      final WmsApproveRecordService approveRecordService,
      final BranchCompanyService branchCompanyService,
      final UserService userService,
      final BasicConfigService basicConfigService
   ) {
      this.configService = configService;
      this.projectService = projectService;
      this.purchaseOrderService = purchaseOrderService;
      this.subcontractOrderService = subcontractOrderService;
      this.inboundService = inboundService;
      this.supplierSettlementService = supplierSettlementService;
      this.supplierSettlementMapper = supplierSettlementMapper;
      this.supplierPaymentService = supplierPaymentService;
      this.supplierInvoiceService = supplierInvoiceService;
      this.auditLedgerService = auditLedgerService;
      this.approveRecordService = approveRecordService;
      this.branchCompanyService = branchCompanyService;
      this.userService = userService;
      this.basicConfigService = basicConfigService;
   }
}
