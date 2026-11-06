package com.hzchum.scim.contract.core.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.pojo.vo.ResultVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.enums.ReviewStatusEnum;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.service.WmsApproveTemplateService;
import com.hzchum.scim.common.core.api.utils.PageUtils;
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
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementDTO;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementEchoDto;
import com.hzchum.scim.contract.core.api.pojo.dto.supplier.SupplierSettlementInvoiceDto;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseSettlementSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SubOrderSettlementAddParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierSettlementSaveDTOParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierSettlementUpdateDTOParam;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.contract.core.mapper.SupplierSettlementMapper;
import com.hzchum.scim.scm.core.api.enums.PurchaseStatusEnum;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo.dto.config.FinanceAmountLimitConfigDTO;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.ConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import com.hzchum.scim.wms.core.api.enums.DataStatusEnum;
import com.hzchum.scim.wms.core.api.service.wmsUse.InboundService;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SupplierSettlementAddDTOParam;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SupplierSettlementServiceImpl extends ServiceImpl<SupplierSettlementMapper, SupplierSettlement> implements SupplierSettlementService {
   @Resource
   private PurchaseOrderService purchaseOrderService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private SupplierPaymentService supplierPaymentService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private SupplierInvoiceService supplierInvoiceService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private WmsApproveTemplateService approveTemplateService;
   @Resource
   private ContractAuditLedgerService auditLedgerService;
   @Resource
   private WmsApproveRecordService approvalsService;
   @Resource
   private WmsApproveRecordDetailService approvalsDetailService;
   @Resource
   private InboundService inboundService;
   @Resource
   private SubcontractOrderService subcontractOrderService;
   @Resource
   private UserService userService;
   @Resource
   private ConfigService configService;

   @Override
   public PageVO<SupplierSettlementDTO> listSupplierSettlement(Long orderId, Integer orderClass, Integer auditStatus, Integer pageNumber, Integer pageSize) {
      PageHelper.startPage(pageNumber, pageSize);
      List<SupplierSettlement> settlementList = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(orderId != null, SupplierSettlement::getOrderId, orderId)
               .eq(orderClass != null, SupplierSettlement::getOrderClass, orderClass)
               .eq(auditStatus != null, SupplierSettlement::getAuditStatus, auditStatus)
         );
      List<SupplierSettlementDTO> supplierSettlementDTOS = settlementList.stream().map(s -> {
         SupplierSettlementDTO settlementDTO = BeanUtil.copy(s, SupplierSettlementDTO.class);
         settlementDTO.setAttachments(this.attachmentService.listByIds(s.getAttachmentIds()));
         return settlementDTO;
      }).collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(supplierSettlementDTOS, settlementList));
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public Boolean saveSupplierSettlement(SupplierSettlementSaveDTOParam param) {
      PurchaseOrder order = this.purchaseOrderService.getById(param.getOrderId());
      Preconditions.checkArgument(order != null, "订单不存在");
      Preconditions.checkArgument(!SettlementStatusEnum.SETTLED.getType().equals(order.getSettlementStatus()), "订单已结算");
      int count = this.baseMapper
         .selectCount(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, param.getOrderId())
               .ne(SupplierSettlement::getAuditStatus, AuditStatusEnum.FAILED.getType())
         );
      Preconditions.checkArgument(count == 0, "订单已提交结算!");
      SupplierSettlement supplierSettlement = BeanUtil.copy(param, SupplierSettlement.class);
      supplierSettlement.setSupplierId(order.getSupplierId());
      supplierSettlement.setApplyUserId(UserUtil.getCurrentUserId());
      supplierSettlement.setApplyUserName(UserUtil.getCurrentName());
      supplierSettlement.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      if (CollectionUtils.isNotEmpty(param.getAttachmentIds())) {
         String attachments = StringUtils.join(param.getAttachmentIds(), ",");
         supplierSettlement.setAttachmentIds(attachments);
      }

      return this.baseMapper.insert(supplierSettlement) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean updateSupplierSettlement(SupplierSettlementUpdateDTOParam updateDTOParam) {
      SupplierSettlement settlement = this.baseMapper.selectById(updateDTOParam.getId());
      Preconditions.checkArgument(settlement != null, "结算记录不存在");
      Preconditions.checkArgument(settlement.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "修改失败,结算记录已审核!");
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(settlement.getOrderId());
      Preconditions.checkArgument(purchaseOrder != null, "采购订单不存在");
      Preconditions.checkArgument(purchaseOrder.getSettlementStatus().equals(SettlementStatusEnum.UN_SETTLED.getType()), "修改失败,订单已结算!");
      BeanUtil.copy(updateDTOParam, settlement);
      String join = StringUtils.join(updateDTOParam.getAttachmentIds(), ",");
      this.attachmentService.replaceAttachment(settlement.getAttachmentIds(), join);
      settlement.setAttachmentIds(join);
      return this.baseMapper.updateById(settlement) == 1;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean delSupplierSettlement(Long id) {
      SupplierSettlement settlement = this.baseMapper.selectById(id);
      Preconditions.checkArgument(settlement != null, "删除失败,结算记录不存在!");
      Preconditions.checkArgument(settlement.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "删除失败,结算记录已审核!");
      if (StringUtils.isNotBlank(settlement.getAttachmentIds())) {
         this.attachmentService.deleteIds(settlement.getAttachmentIds());
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public Boolean checkSupplierSettlement(Long orderId, Integer auditStatus) {
      PurchaseOrder purchaseOrder = this.purchaseOrderService.getById(orderId);
      Preconditions.checkArgument(purchaseOrder != null, "审核失败,采购订单不存在!");
      SupplierSettlement settlement = this.baseMapper
         .selectOne(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, orderId)
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
               .orderByDesc(BaseEntity::getCreateTime)
               .last("limit 1")
         );
      Preconditions.checkArgument(settlement != null, "订单结算审核失败,结算记录不存在!");
      if (auditStatus.equals(AuditStatusEnum.SUCCEED.getType())) {
         purchaseOrder.setSettlementStatus(SettlementStatusEnum.SETTLED.getType());
         purchaseOrder.setSettlementAmount(settlement.getAmount());
         purchaseOrder.setPurchaseStatus(PurchaseStatusEnum.FINISH.getType());
         this.purchaseOrderService.updateById(purchaseOrder);
      }

      settlement.setAuditStatus(auditStatus);
      settlement.setAuditTime(LocalDateTime.now());
      settlement.setAuditUserId(UserUtil.getCurrentUserId());
      settlement.setAuditUserName(UserUtil.getCurrentName());
      return this.baseMapper.updateById(settlement) == 1;
   }

   @Override
   public BigDecimal getSettlementAmountBySupplierId(Long supplierId) {
      return this.baseMapper.selectSettlementAmount(supplierId);
   }

   @Override
   public Map<Long, BigDecimal> getSupplierSettlementAmountMap(Integer orderClass, Collection<Long> supplierIds, LocalDate startDate, LocalDate endDate) {
      LambdaQueryWrapper<SupplierSettlement> wrapper = Wrappers.lambdaQuery(SupplierSettlement.class)
         .eq(orderClass != null, SupplierSettlement::getOrderClass, orderClass)
         .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         .in(CollectionUtils.isNotEmpty(supplierIds), SupplierSettlement::getSupplierId, supplierIds);
      if (startDate != null) {
         wrapper.ge(BaseEntity::getCreateTime, startDate.atStartOfDay());
      }

      if (endDate != null) {
         wrapper.lt(BaseEntity::getCreateTime, endDate.plusDays(1L).atStartOfDay());
      }

      return this.baseMapper
         .selectList(wrapper)
         .stream()
         .collect(
            Collectors.groupingBy(
               SupplierSettlement::getSupplierId, Collectors.mapping(SupplierSettlement::getAmount, Collectors.reducing(BigDecimal.ZERO, BigDecimal::add))
            )
         );
   }

   private void checkInnerProjectAccess(Long projectId) {
      Preconditions.checkArgument(projectId != null && this.projectService.listSimpleProject(null, null, null, null)
         .getContent().stream().anyMatch(project -> projectId.equals(project.getId())), "无权限访问该项目");
   }

   @Transactional(rollbackFor = Exception.class)
   @Override
   public ResultVO addOaSupplierSettlement(SupplierSettlementAddDTOParam param) {
      this.checkInnerProjectAccess(param.getProjectId());
      PurchaseOrder order = this.purchaseOrderService.getById(param.getOrderId());
      Preconditions.checkArgument(order != null && String.valueOf(param.getProjectId()).equals(order.getProjectIds())
         && java.util.Objects.equals(order.getSupplierId(), param.getSupplierId())
         && java.util.Objects.equals(order.getProjectManagerId(), param.getProjectManagerId())
         && java.util.Objects.equals(order.getSerialNumber(), param.getPurchaseContractNumber()), "采购订单关联信息不匹配");
      // The legacy protocol represents one project; current multi-project orders use their existing newer workflow.
      SubOrderSettlementAddParam adapted = new SubOrderSettlementAddParam();
      adapted.setOrderId(order.getId());
      adapted.setCreateTime(param.getApplyDate());
      adapted.setSettlementAmount(param.getSettlementAmount());
      adapted.setRemark(param.getRemark());
      adapted.setAttachmentId(java.util.Collections.emptyList());
      return this.addOaSupplierSettlement(adapted);
   }

   @Transactional
   @Override
   public ResultVO addOaSupplierSettlement(SubOrderSettlementAddParam param) {
      ResultVO<Object> build = ResultVO.<Object>builder().build();
      PurchaseOrder orderServiceOne = this.purchaseOrderService.getOne(Wrappers.lambdaQuery(PurchaseOrder.class).eq(PurchaseOrder::getId, param.getOrderId()));
      Preconditions.checkArgument(orderServiceOne != null, "采购订单不存在");
      Preconditions.checkArgument(!orderServiceOne.getSettlementStatus().equals(SettlementStatusEnum.SETTLED.getType()), "采购订单已结算");
      List<SupplierSettlement> supplierSettlements = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, orderServiceOne.getId())
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(orderServiceOne.getProjectIds() != null && orderServiceOne.getProjectIds().matches("[0-9]+"), "内结算仅支持单项目订单");
      ContractProject project = this.projectService.getById(Long.valueOf(orderServiceOne.getProjectIds()));
      Preconditions.checkArgument(project != null, "项目不存在");
      Preconditions.checkArgument(CollectionUtils.isEmpty(supplierSettlements), "采购订单已存在结算记录");
      List<SupplierPayment> paymentList = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, param.getOrderId())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      BigDecimal paymentAmount = paymentList.stream()
         .map(SupplierPayment::getActuallyPaymentAmount)
         .filter(ObjectUtils::isNotEmpty)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      Preconditions.checkArgument(paymentAmount.compareTo(param.getSettlementAmount()) <= 0, "结算金额不能小于付款金额");
      List<SupplierInvoice> invoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, param.getOrderId())
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      BigDecimal invoiceAmount = invoiceList.stream()
         .map(SupplierInvoice::getInvoiceAmount)
         .filter(ObjectUtils::isNotEmpty)
         .reduce(BigDecimal.ZERO, BigDecimal::add);
      Preconditions.checkArgument(invoiceAmount.compareTo(param.getSettlementAmount()) <= 0, "结算金额不能小于发票金额");
      SupplierSettlement settlement = BeanUtil.copy(param, SupplierSettlement.class);
      settlement.setSupplierId(orderServiceOne.getSupplierId()).setOrderClass(orderServiceOne.getPurchaseType())
         .setAuditStatus(AuditStatusEnum.AUDITING.getType())
         .setAmount(param.getSettlementAmount())
         .setApplyUserId(UserUtil.getCurrentUserId())
         .setApplyUserName(UserUtil.getCurrentName())
         .setApplyDate(LocalDate.now())
         .setOrderId(param.getOrderId());
      settlement.setBoolDeleteEnum(Boolean.TRUE);
      this.baseMapper.insert(settlement);
      ContractAuditLedger contractAuditLedger = new ContractAuditLedger()
         .setAuditType(AuditTypeEnum.PAYMENT_APPROVE.getType())
         .setPaymentId(settlement.getId().toString())
         .setContractId(orderServiceOne.getId().toString())
         .setFilingDate(param.getCreateTime())
         .setSupplierId(orderServiceOne.getSupplierId())
         .setPaymentEnum(AuditPaymentEnum.PURCHASE_SETTLEMENT.getType())
         .setContractNumber(orderServiceOne.getSerialNumber())
         .setProjectAttribute(project.getProjectAttribute())
         .setInitiatorId(UserUtil.getCurrentUserId())
         .setProjectId(project.getId().toString())
         .setContractSignBodyId(orderServiceOne.getBranchCompanyId())
         .setProjectManagerId(project.getProjectManagerId() != null ? project.getProjectManagerId() : null)
         .setApplyAmount(param.getSettlementAmount())
         .setAuditStatusEnum(AuditStatusEnum.AUDITING.getType());
      contractAuditLedger.setBoolDeleteEnum(Boolean.TRUE);
      this.auditLedgerService.save(contractAuditLedger);
      build.setCode(20000L);
      build.setData(contractAuditLedger.getId());
      return build;
   }

   public void saveSettlement(
      SubOrderSettlementAddParam param, SubcontractOrder order, Integer approveProcessType, Integer orderClassType, Integer paymentEnum, Integer type
   ) {
      SupplierSettlement settlement = BeanUtil.copy(param, SupplierSettlement.class);
      settlement.setAuditStatus(AuditStatusEnum.AUDITING.getType())
         .setAmount(param.getSettlementAmount())
         .setOrderClass(orderClassType)
         .setSupplierId(order.getSupplierId())
         .setApplyUserId(param.getUserId() != null ? param.getUserId() : UserUtil.getCurrentUserId())
         .setApplyUserName(param.getUserId() != null ? this.userService.getNameById(param.getUserId()) : UserUtil.getCurrentName())
         .setApplyDate(param.getCreateTime() != null ? param.getCreateTime().toLocalDate() : LocalDate.now())
         .setRemark(param.getRemark())
         .setCreateUserId(UserUtil.getCurrentUserId());
      this.baseMapper.insert(settlement);
      ContractAuditLedger contractAuditLedger = new ContractAuditLedger()
         .setAuditType(type)
         .setPaymentId(settlement.getId().toString())
         .setContractId(param.getOrderId().toString())
         .setFilingDate(param.getCreateTime())
         .setPaymentEnum(paymentEnum)
         .setContractNumber(order.getSerialNumber())
         .setProjectAttribute(order.getProjectAttribute())
         .setInitiatorId(UserUtil.getCurrentUserId())
         .setProjectId(order.getProjectId().toString())
         .setContractSignBodyId(order.getBranchCompanyId())
         .setProjectManagerId(order.getProjectManagerId())
         .setSupplierId(order.getSupplierId())
         .setApplyAmount(param.getSettlementAmount())
         .setAuditStatusEnum(AuditStatusEnum.AUDITING.getType());
      this.auditLedgerService.save(contractAuditLedger);
      WmsApproveRecord record = this.approvalsService
         .createRecord(contractAuditLedger.getId(), contractAuditLedger.getContractNumber(), approveProcessType, null, null, null, true, null, null, null);
      contractAuditLedger.setApproveRecordId(record.getId());
      this.auditLedgerService.updateById(contractAuditLedger);
   }

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
      int count = this.baseMapper
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
      this.baseMapper.insert(supplierSettlement);
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
      int count = this.baseMapper
         .selectCount(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, param.getOrderId())
               .eq(SupplierSettlement::getBoolPreSettlement, false)
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(count == 0, "订单已提交结算!");
      Preconditions.checkArgument(param.getSettlementAmount() != null && param.getSettlementAmount().compareTo(BigDecimal.ZERO) > 0, "申请金额必须大于0!");
      if (param.getBoolPreSettlement()) {
         BigDecimal actualInboundAmount = this.inboundService.getActualInboundAmount(param.getOrderId(), order.getOrderPlace(), order.getPurchaseType());
         BigDecimal preSettlementAmount = this.baseMapper
            .selectList(
               Wrappers.lambdaQuery(SupplierSettlement.class)
                  .eq(SupplierSettlement::getOrderId, param.getOrderId())
                  .eq(SupplierSettlement::getBoolPreSettlement, true)
                  .in(SupplierSettlement::getOrderClass, OrderClassEnum.MATERIAL_ORDER.getType(), OrderClassEnum.MANUFACTURE_ORDER.getType())
                  .in(SupplierSettlement::getAuditStatus, AuditStatusEnum.AUDITING.getType(), AuditStatusEnum.SUCCEED.getType())
            )
            .stream()
            .map(SupplierSettlement::getAmount)
            .reduce(BigDecimal.ZERO, BigDecimal::add);
         Preconditions.checkArgument(preSettlementAmount.add(param.getSettlementAmount()).compareTo(actualInboundAmount) <= 0, "预结算总额不能大于订单入库额!");
      } else {
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
      this.baseMapper.insert(supplierSettlement);
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
      WmsApproveRecord record = this.approvalsService
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
      BigDecimal preSettlementAmount = this.baseMapper
         .selectList(
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
      SubcontractOrder order = this.subcontractOrderService.getById(param.getOrderId());
      Preconditions.checkArgument(order != null, "订单不存在");
      Preconditions.checkArgument(!order.getBoolSettlementStatus(), "订单已结算!");
      ContractProject project = this.projectService.getById(order.getProjectId());
      Preconditions.checkArgument(project != null, "分包订单项目数据丢失!");
      List<SupplierSettlement> supplierSettlements = this.baseMapper
         .selectList(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, order.getId())
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
         .setOrderClass(OrderClassEnum.SUB_ORDER.getType())
         .setSupplierId(order.getSupplierId())
         .setApplyUserId(param.getUserId() != null ? param.getUserId() : UserUtil.getCurrentUserId())
         .setApplyUserName(param.getUserId() != null ? this.userService.getNameById(param.getUserId()) : UserUtil.getCurrentName())
         .setApplyDate(param.getCreateTime() != null ? param.getCreateTime().toLocalDate() : LocalDate.now())
         .setRemark(param.getRemark())
         .setAttachmentIds(attachmentIds)
         .setCreateUserId(UserUtil.getCurrentUserId());
      this.baseMapper.insert(settlement);
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
      WmsApproveRecord record = this.approvalsService
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

   @Override
   public SupplierSettlementInvoiceDto getSupplierSettlementInner(
      Long projectId, Long projectManagerId, Long supplierId, String purchaseContractNumber, Integer pageNumber, Integer pageSize
   ) {
      this.checkInnerProjectAccess(projectId);
      PurchaseOrder purchaseOrderOne = this.purchaseOrderService
         .getOne(
            Wrappers.lambdaQuery(PurchaseOrder.class)
               .eq(PurchaseOrder::getProjectIds, String.valueOf(projectId))
               .eq(PurchaseOrder::getSupplierId, supplierId)
               .eq(PurchaseOrder::getSerialNumber, purchaseContractNumber)
               .eq(PurchaseOrder::getProjectManagerId, projectManagerId)
         );
      Preconditions.checkArgument(purchaseOrderOne != null, "订单不存在");
      ContractProject project = this.projectService.getById(projectId);
      Preconditions.checkArgument(project != null, "项目不存在");
      List<SupplierSettlementEchoDto> listDto = new ArrayList<>();
      List<SupplierPayment> list = this.supplierPaymentService
         .list(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, purchaseOrderOne.getId())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      List<SupplierInvoice> invoiceList = this.supplierInvoiceService
         .list(
            Wrappers.lambdaQuery(SupplierInvoice.class)
               .eq(SupplierInvoice::getOrderId, purchaseOrderOne.getId())
               .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
         );
      list.forEach(a -> {
         SupplierSettlementEchoDto settlementEchoDto = new SupplierSettlementEchoDto();
         settlementEchoDto.setPaymentAmount(a.getActuallyPaymentAmount());
         settlementEchoDto.setPaymentDate(a.getPaymentDate().atStartOfDay());
         listDto.add(settlementEchoDto);
      });
      invoiceList.forEach(invoice -> {
         SupplierSettlementEchoDto settlementEchoDto = new SupplierSettlementEchoDto();
         settlementEchoDto.setInvoiceAmount(invoice.getActualInvoiceAmount());
         settlementEchoDto.setInvoiceDate(invoice.getReceiveInvoiceDate().atStartOfDay());
         listDto.add(settlementEchoDto);
      });
      List<SupplierSettlementEchoDto> page = PageUtils.getPage(listDto, pageNumber, pageSize);
      PageVO<SupplierSettlementEchoDto> objectPageVO = new PageVO<>(page);
      objectPageVO.setTotalElements(listDto.size());
      return new SupplierSettlementInvoiceDto()
         .setOrderId(purchaseOrderOne.getId())
         .setList(objectPageVO)
         .setSettlementAmount(purchaseOrderOne.getSettlementAmount())
         .setPaymentContractAmount(purchaseOrderOne.getAmount())
         .setSignatoryId(project.getContractSignBodyId())
         .setBasicClass(purchaseOrderOne.getBasicClass())
         .setSignatoryName(this.branchCompanyService.getNameById(project.getContractSignBodyId()))
         .setContractAmount(purchaseOrderOne.getAmount());
   }

   @Override
   public Boolean update(Long id) {
      return this.baseMapper.update(id);
   }

   @Override
   public BigDecimal getAount(Long id) {
      return this.baseMapper.getAount(id);
   }
}
