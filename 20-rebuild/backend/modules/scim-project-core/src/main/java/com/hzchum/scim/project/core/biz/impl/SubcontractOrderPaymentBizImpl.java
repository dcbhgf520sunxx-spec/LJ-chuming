package com.hzchum.scim.project.core.biz.impl;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.github.pagehelper.PageHelper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.pojo.vo.PageVO;
import com.hzchum.pangu.common.util.BeanUtil;
import com.hzchum.scim.common.core.api.pojo.common.SupplierInfo;
import com.hzchum.scim.common.core.api.service.AttachmentService;
import com.hzchum.scim.common.core.api.utils.PageUtils;
import com.hzchum.scim.contract.core.api.enums.payment.OrderClassEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierPayment;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierSettlement;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierPaymentService;
import com.hzchum.scim.contract.core.api.service.SupplierSettlementService;
import com.hzchum.scim.project.core.api.biz.ProjectSupplierAccountBiz;
import com.hzchum.scim.project.core.api.biz.SubcontractOrderPaymentBiz;
import com.hzchum.scim.project.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.project.core.api.pojo._do.ProjectPaymentProblemLink;
import com.hzchum.scim.project.core.api.pojo._do.ProjectQhseProblem;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSubVisa;
import com.hzchum.scim.project.core.api.pojo._do.ProjectSupplierAreaLink;
import com.hzchum.scim.project.core.api.pojo.dto.sub.SubcontractOrderPayInvoiceDTO;
import com.hzchum.scim.project.core.api.pojo.dto.sub.SupplierSettlementInfo;
import com.hzchum.scim.project.core.api.pojo.dtoParam.query.SubOrderPaymentQueryDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.sub.SubOrderPaymentCheckDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.sub.SubOrderPaymentDTOParam;
import com.hzchum.scim.project.core.api.pojo.dtoParam.sub.SubOrderSettlementDTOParam;
import com.hzchum.scim.project.core.api.service.ProjectPaymentProblemLinkService;
import com.hzchum.scim.project.core.api.service.ProjectQhseProblemService;
import com.hzchum.scim.project.core.api.service.ProjectSubVisaService;
import com.hzchum.scim.project.core.api.service.ProjectSupplierAreaLinkService;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractMonomerLink;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.pojo._do.Supplier;
import com.hzchum.scim.scm.core.api.pojo.dto.SubcontractOrderDTO;
import com.hzchum.scim.scm.core.api.pojo.dtoParam.SubcontractOrderQueryDTOParam;
import com.hzchum.scim.scm.core.api.service.SubcontractMonomerLinkService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.common.enums.DictionaryEnum;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.pojo._do.SysDictionary;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.SysDictionaryService;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;
import javax.annotation.Resource;
import javax.transaction.TransactionalException;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class SubcontractOrderPaymentBizImpl implements SubcontractOrderPaymentBiz {
   private static final Logger log = LoggerFactory.getLogger(SubcontractOrderPaymentBizImpl.class);
   @Resource
   private SubcontractOrderService subcontractOrderService;
   @Resource
   private SubcontractMonomerLinkService subcontractMonomerLinkService;
   @Resource
   private SupplierPaymentService supplierPaymentService;
   @Resource
   private SupplierInvoiceService supplierInvoiceService;
   @Resource
   private SysDictionaryService dictionaryService;
   @Resource
   private ContractProjectService projectService;
   @Resource
   private BranchCompanyService branchCompanyService;
   @Resource
   private SupplierService supplierService;
   @Resource
   private AttachmentService attachmentService;
   @Resource
   private ProjectQhseProblemService qhseProblemService;
   @Resource
   private ProjectSubVisaService projectSubVisaService;
   @Resource
   private SupplierSettlementService supplierSettlementService;
   @Resource
   ProjectSupplierAccountBiz supplierAccountBiz;
   @Resource
   private ProjectSupplierAreaLinkService supplierAreaLinkService;
   @Resource
   ProjectPaymentProblemLinkService paymentProblemLinkService;

   @Override
   public PageVO<SubcontractOrderPayInvoiceDTO> listSubOrderPayment(SubOrderPaymentQueryDTOParam param, Integer pageNumber, Integer pageSize) {
      SubcontractOrderQueryDTOParam queryDTOParam = BeanUtil.copy(param, SubcontractOrderQueryDTOParam.class);
      PageHelper.startPage(pageNumber, pageSize);
      List<SubcontractOrderDTO> orderDTOList = this.subcontractOrderService.listSubcontractOrder(queryDTOParam);
      List<SubcontractOrderPayInvoiceDTO> payInvoiceDTOList = orderDTOList.stream()
         .map(
            o -> {
               SubcontractOrderPayInvoiceDTO orderPayInvoiceDTO = BeanUtil.copy(o, SubcontractOrderPayInvoiceDTO.class);
               orderPayInvoiceDTO.setPaymentAmount(this.supplierPaymentService.getOrderPaymentSum(o.getId(), SupplierPropertyTypeEnum.SUB_FEE.getType()));
               orderPayInvoiceDTO.setInvoiceAmount(this.supplierInvoiceService.getOrderInvoiceSum(o.getId(), SupplierPropertyTypeEnum.SUB_FEE.getType()));
               SupplierPayment lastPayment = this.supplierPaymentService.getLastPayment(o.getId(), SupplierPropertyTypeEnum.SUB_FEE.getType(), null, null);
               if (lastPayment != null) {
                  orderPayInvoiceDTO.setLastPaymentTime(lastPayment.getPaymentDate());
                  orderPayInvoiceDTO.setLastPaymentAmount(lastPayment.getActuallyPaymentAmount());
               }

               Supplier supplier = this.supplierService.getById(o.getSupplierId());
               SupplierInfo supplierInfo = BeanUtil.copy(supplier, SupplierInfo.class);
               supplierInfo.setSupplierId(supplier.getId());
               supplierInfo.setSupplierName(supplier.getName());
               orderPayInvoiceDTO.setSupplier(supplierInfo);
               ContractProject project = this.projectService.getById(o.getProjectId());
               BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
               orderPayInvoiceDTO.setBranchCompanyId(project.getContractSignBodyId());
               orderPayInvoiceDTO.setBranchCompanyName(branchCompany != null ? branchCompany.getName() : null);
               orderPayInvoiceDTO.setPenalty(this.qhseProblemService.getPenaltySum(o.getId(), false));
               orderPayInvoiceDTO.setVisaAmount(this.projectSubVisaService.getSumVisaAmount(o.getId()));
               int unCheckPaymentCount = this.supplierPaymentService
                  .count(
                     Wrappers.lambdaQuery(SupplierPayment.class)
                        .eq(SupplierPayment::getOrderId, o.getId())
                        .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                        .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType())
                  );
               orderPayInvoiceDTO.setUnCheckPaymentCount(unCheckPaymentCount);
               int unCheckInvoiceCount = this.supplierInvoiceService
                  .count(
                     Wrappers.lambdaQuery(SupplierInvoice.class)
                        .eq(SupplierInvoice::getOrderId, o.getId())
                        .eq(SupplierInvoice::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
                        .eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.AUDITING.getType())
                  );
               orderPayInvoiceDTO.setUnCheckInvoiceCount(unCheckInvoiceCount);
               SupplierSettlement settlement = this.supplierSettlementService
                  .getOne(
                     Wrappers.lambdaQuery(SupplierSettlement.class)
                        .eq(SupplierSettlement::getOrderId, o.getId())
                        .eq(SupplierSettlement::getOrderClass, OrderClassEnum.SUB_ORDER.getType())
                  );
               if (settlement != null) {
                  orderPayInvoiceDTO.setUnCheckSettlementCount(settlement.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) ? 1 : 0);
                  SupplierSettlementInfo settlementInfo = BeanUtil.copy(settlement, SupplierSettlementInfo.class);
                  settlementInfo.setAttachments(this.attachmentService.listByIds(settlement.getAttachmentIds()));
                  orderPayInvoiceDTO.setSettlementInfo(settlementInfo);
               }

               return orderPayInvoiceDTO;
            }
         )
         .collect(Collectors.toList());
      return new PageVO<>(PageUtils.getPageInfo(payInvoiceDTOList, orderDTOList));
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean saveSubOrderPayment(SubOrderPaymentDTOParam param) {
      int count = this.supplierPaymentService
         .count(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, param.getOrderId())
               .eq(SupplierPayment::getPropertyType, SupplierPropertyTypeEnum.SUB_FEE.getType())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(count == 0, "新增失败,存在付款申请未审核");
      SupplierPayment payment = this.buildPayment(param);
      payment.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
      payment.setId(null);
      this.supplierPaymentService.save(payment);
      if (payment.getBoolDeduct()) {
         this.savePaymentQhseProblemLink(payment.getId(), param.getOrderId());
      }

      return true;
   }

   private SupplierPayment buildPayment(SubOrderPaymentDTOParam param) {
      SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(param.getOrderId());
      Preconditions.checkArgument(subcontractOrder != null, "分包订单不存在");
      ContractProject project = this.projectService.getById(subcontractOrder.getProjectId());
      Preconditions.checkArgument(project != null, "项目不存在");
      BranchCompany branchCompany = this.branchCompanyService.getById(project.getContractSignBodyId());
      SysDictionary dictionary = this.dictionaryService.getByNameAndValueFromCache(DictionaryEnum.PAYMENT_REASON.getName(), param.getPaymentReasonId());
      Preconditions.checkArgument(dictionary != null, "付款事由不存在");
      Supplier supplier = this.supplierService.getById(subcontractOrder.getSupplierId());
      SupplierPayment payment = SupplierPayment.builder()
         .propertyType(SupplierPropertyTypeEnum.SUB_FEE.getType())
         .paymentUnitId(project.getContractSignBodyId())
         .paymentUnit(branchCompany.getName())
         .receivingUnitId(subcontractOrder.getSupplierId())
         .receivingUnit(subcontractOrder.getSupplierName())
         .serialNumber(subcontractOrder.getSerialNumber())
         .paymentReasonName(dictionary.getLabel())
         .receiveBank(supplier != null ? supplier.getBankName() : null)
         .receiveBankAccount(supplier != null ? supplier.getBankAccount() : null)
         .applyUserId(UserUtil.getCurrentUserId())
         .applyUserName(UserUtil.getCurrentName())
         .auditStatus(AuditStatusEnum.AUDITING.getType())
         .build();
      BeanUtil.copy(param, payment);
      BigDecimal penaltySum = this.qhseProblemService.getPenaltySum(param.getOrderId(), false);
      if (payment.getBoolDeduct().equals(true) && penaltySum.compareTo(BigDecimal.ZERO) > 0) {
         payment.setBreachAmount(penaltySum);
      } else {
         payment.setBoolDeduct(false);
         payment.setBreachAmount(BigDecimal.ZERO);
      }

      payment.setApplyAmount(param.getInputAmount().subtract(payment.getBreachAmount()));
      return payment;
   }

   private void savePaymentQhseProblemLink(Long paymentId, Long orderId) {
      List<ProjectQhseProblem> problemList = this.qhseProblemService
         .list(
            Wrappers.lambdaQuery(ProjectQhseProblem.class)
               .eq(ProjectQhseProblem::getSubcontractOrderId, orderId)
               .eq(ProjectQhseProblem::getBoolChangeStatus, true)
               .eq(ProjectQhseProblem::getBoolDeductStatus, false)
         );
      if (CollectionUtils.isNotEmpty(problemList)) {
         this.paymentProblemLinkService.saveLink(paymentId, problemList);
      }
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean updateSubOrderPayment(SubOrderPaymentDTOParam param) {
      Preconditions.checkArgument(param.getId() != null, "付款表ID不能为空");
      SupplierPayment supplierPayment = this.supplierPaymentService.getById(param.getId());
      Preconditions.checkArgument(supplierPayment != null, "付款记录不存在");
      Preconditions.checkArgument(supplierPayment.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "付款记录已审核");
      SupplierPayment payment = this.buildPayment(param);
      this.attachmentService.replaceAttachment(supplierPayment.getAttachmentIds(), param.getAttachmentIds());
      payment.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
      this.supplierPaymentService.updateById(payment);
      if (payment.getBoolDeduct() && param.isBoolUpdateBreachAmount()) {
         this.paymentProblemLinkService
            .remove(Wrappers.lambdaQuery(ProjectPaymentProblemLink.class).eq(ProjectPaymentProblemLink::getPaymentId, param.getId()));
         this.savePaymentQhseProblemLink(param.getId(), param.getOrderId());
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean saveSubOrderSettle(SubOrderSettlementDTOParam param) {
      SubcontractOrder order = this.subcontractOrderService.getById(param.getOrderId());
      Preconditions.checkArgument(order != null, "分包订单不存在");
      Preconditions.checkArgument(!order.getBoolSettlementStatus().equals(true), "分包订单已结算");
      int count = this.supplierSettlementService
         .count(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, param.getOrderId())
               .eq(SupplierSettlement::getOrderClass, OrderClassEnum.SUB_ORDER.getType())
         );
      Preconditions.checkArgument(count == 0, "订单已提交结算");
      count = this.projectSubVisaService
         .count(
            Wrappers.lambdaQuery(ProjectSubVisa.class)
               .eq(ProjectSubVisa::getSubcontractOrderId, param.getOrderId())
               .eq(ProjectSubVisa::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(count == 0, "该订单存在签证未审核");
      count = this.qhseProblemService
         .count(
            Wrappers.lambdaQuery(ProjectQhseProblem.class)
               .eq(ProjectQhseProblem::getSubcontractOrderId, param.getOrderId())
               .eq(ProjectQhseProblem::getBoolChangeStatus, false)
         );
      Preconditions.checkArgument(count == 0, "该订单存在质安问题未整改");
      count = this.supplierPaymentService
         .count(
            Wrappers.lambdaQuery(SupplierPayment.class)
               .eq(SupplierPayment::getOrderId, param.getOrderId())
               .eq(SupplierPayment::getAuditStatus, AuditStatusEnum.AUDITING.getType())
         );
      Preconditions.checkArgument(count == 0, "该订单存在付款未审核");
      SupplierSettlement settlement = BeanUtil.copy(param, SupplierSettlement.class);
      settlement.setOrderClass(OrderClassEnum.SUB_ORDER.getType());
      settlement.setSupplierId(order.getSupplierId());
      settlement.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
      settlement.setApplyUserId(UserUtil.getCurrentUserId());
      settlement.setApplyUserName(UserUtil.getCurrentName());
      settlement.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      this.supplierSettlementService.save(settlement);
      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean updateSubOrderSettle(SubOrderSettlementDTOParam param) {
      SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(param.getOrderId());
      Preconditions.checkArgument(subcontractOrder != null, "分包订单不存在");
      Preconditions.checkArgument(subcontractOrder.getBoolSettlementStatus().equals(false), "订单已结算");
      SupplierSettlement settlement = this.supplierSettlementService
         .getOne(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getOrderId, param.getOrderId())
               .eq(SupplierSettlement::getOrderClass, OrderClassEnum.SUB_ORDER.getType())
         );
      Preconditions.checkArgument(settlement != null, "结算记录不存在");
      Preconditions.checkArgument(!settlement.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()), "结算记录已审核通过");
      BeanUtil.copy(param, settlement);
      this.attachmentService.replaceAttachment(settlement.getAttachmentIds(), param.getAttachmentIds());
      settlement.setAttachmentIds(StringUtils.join(param.getAttachmentIds(), ","));
      settlement.setAuditStatus(AuditStatusEnum.AUDITING.getType());
      this.supplierSettlementService.updateById(settlement);
      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean checkSubOrderPayment(SubOrderPaymentCheckDTOParam param) {
      SupplierPayment supplierPayment = this.supplierPaymentService.getById(param.getId());
      Preconditions.checkArgument(supplierPayment != null, "付款记录不存在");
      Preconditions.checkArgument(supplierPayment.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "付款记录已审核");
      supplierPayment.setAuditStatus(param.getAuditStatus());
      supplierPayment.setAuditUserId(UserUtil.getCurrentUserId());
      supplierPayment.setAuditUserName(UserUtil.getCurrentName());
      supplierPayment.setAuditTime(LocalDateTime.now());
      BeanUtil.copy(param, supplierPayment);
      this.supplierPaymentService.updateById(supplierPayment);
      if (supplierPayment.getBoolDeduct()) {
         List<ProjectPaymentProblemLink> paymentProblemLinks = this.paymentProblemLinkService
            .list(Wrappers.lambdaQuery(ProjectPaymentProblemLink.class).eq(ProjectPaymentProblemLink::getPaymentId, param.getId()));
         paymentProblemLinks.forEach(link -> {
            link.setAuditStatus(param.getAuditStatus());
            this.paymentProblemLinkService.updateById(link);
         });
         if (param.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType())) {
            paymentProblemLinks.forEach(link -> {
               ProjectQhseProblem problem = this.qhseProblemService.getById(link.getProblemId());
               problem.setBoolDeductStatus(true);
               this.qhseProblemService.updateById(problem);
            });
         }
      }

      return true;
   }

   @Transactional(rollbackFor = TransactionalException.class)
   @Override
   public Boolean checkSubOrderSettle(Long id, Integer auditStatus) {
      Preconditions.checkArgument(auditStatus.equals(AuditStatusEnum.SUCCEED.getType()) || auditStatus.equals(AuditStatusEnum.FAILED.getType()), "审核状态有误");
      SupplierSettlement supplierSettlement = this.supplierSettlementService.getById(id);
      Preconditions.checkArgument(supplierSettlement != null, "结算申请记录不存在");
      Preconditions.checkArgument(supplierSettlement.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()), "结算申请已审核");
      Preconditions.checkArgument(supplierSettlement.getOrderClass().equals(OrderClassEnum.SUB_ORDER.getType()), "订单类别不是分包订单");
      SubcontractOrder subcontractOrder = this.subcontractOrderService.getById(supplierSettlement.getOrderId());
      Preconditions.checkArgument(subcontractOrder != null, "提交结算的分包订单不存在");
      Preconditions.checkArgument(subcontractOrder.getBoolSettlementStatus().equals(false), "提交结算申请的分包订单已结算");
      supplierSettlement.setAuditStatus(auditStatus);
      supplierSettlement.setAuditUserId(UserUtil.getCurrentUserId());
      supplierSettlement.setAuditUserName(UserUtil.getCurrentName());
      supplierSettlement.setAuditTime(LocalDateTime.now());
      this.supplierSettlementService.updateById(supplierSettlement);
      if (auditStatus.equals(AuditStatusEnum.SUCCEED.getType())) {
         subcontractOrder.setBoolSettlementStatus(true);
         subcontractOrder.setSettlementAmount(supplierSettlement.getAmount());
         this.subcontractOrderService.updateById(subcontractOrder);
         List<SubcontractMonomerLink> subcontractMonomerLinkList = this.subcontractMonomerLinkService
            .list(Wrappers.lambdaQuery(SubcontractMonomerLink.class).eq(SubcontractMonomerLink::getSubcontractOrderId, subcontractOrder.getId()));
         subcontractMonomerLinkList.forEach(link -> {
            link.setBoolSettlementStatus(true);
            this.subcontractMonomerLinkService.updateById(link);
         });
         List<ProjectSupplierAreaLink> links = this.supplierAreaLinkService
            .list(Wrappers.lambdaQuery(ProjectSupplierAreaLink.class).eq(ProjectSupplierAreaLink::getSubcontractOrderId, subcontractOrder.getId()));
         links.forEach(link -> {
            link.setBoolSettlementStatus(true);
            this.supplierAreaLinkService.updateById(link);
         });
         this.supplierAccountBiz.shutDownAccount(subcontractOrder.getSupplierId());
      }

      return true;
   }
}
