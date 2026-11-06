package com.hzchum.scim.rest.controller.contract;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.contract.core.api.enums.ProjectAttributeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ProjectBranchCompanyLink;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ProjectBranchCompanyLinkService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import java.util.Objects;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.SubOrderPaymentAddDtoParam;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchasePaymentSaveParam;
import com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier.PurchaseInvoiceSaveParam;
import com.hzchum.scim.common.core.api.enums.ApproveProcessTypeEnumV2;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecord;
import com.hzchum.scim.common.core.api.pojo._do.WmsApproveRecordDetail;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordService;
import com.hzchum.scim.common.core.api.service.WmsApproveRecordDetailService;
import com.hzchum.scim.contract.core.api.enums.finance.AuditPaymentEnum;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import com.hzchum.scim.system.core.api.pojo._do.BranchCompany;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

/** The current V2 collection form and and invoice record drawers belong to the two self-operated unit menus. */
@Component("contractCollectionAccess")
public class ContractCollectionAccess {
   @Resource private ContractProjectService projects;
   @Resource private ProjectBranchCompanyLinkService links;
   @Resource private ContractAuditLedgerService ledgers;
   @Resource private WmsApproveRecordService records;
   @Resource private WmsApproveRecordDetailService details;
   @Resource private BranchCompanyService companies;
   @Resource private PurchaseOrderService purchaseOrders;
   @Resource private SubcontractOrderService subcontractOrders;
   @Resource private com.hzchum.scim.contract.core.api.service.ContractCollectionService collections;
   @Resource private com.hzchum.scim.contract.core.api.service.ContractInvoiceService invoices;

   public boolean selfLedgerRead(Long projectId, Integer level) {
      Long branchId = requestFinanceBranch();
      if (branchId != null) {
         BranchCompany company = companies.getById(branchId);
         if (company == null || level != null && !Objects.equals(level, company.getLevel())) return false;
         level = company.getLevel();
      }
      ContractProject project = projectId == null ? null : projects.getById(projectId);
      if (projectId != null && (project == null || !Objects.equals(project.getProjectAttribute(), ProjectAttributeEnum.SELF_SUPPORT.getType()))) return false;
      if (level == null && project != null) {
         BranchCompany company = companies.getById(project.getContractSignBodyId());
         level = company == null ? null : company.getLevel();
      }
      if (!Objects.equals(level, 1) && !Objects.equals(level, 2)) return false;
      if (!ledgerHas(level == 1 ? "self:get" : "second-unit-self:get")) return false;
      return projectId == null || links.count(Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
         .eq(ProjectBranchCompanyLink::getProjectId, projectId)
         .eq(ProjectBranchCompanyLink::getBranchCompanyLevel, level)
         .eq(branchId != null, ProjectBranchCompanyLink::getBranchCompanyId, branchId)) > 0;
   }

   public boolean projectFinancialRead(Long projectId, boolean print) {
      ContractProject project = projectId == null ? null : projects.getById(projectId);
      if (project == null) return false;
      if (Objects.equals(project.getProjectAttribute(), ProjectAttributeEnum.SELF_SUPPORT.getType())) return selfLedgerRead(projectId, null);
      return interiorProjectRead(projectId, print);
   }

   private Long requestFinanceBranch() {
      org.springframework.web.context.request.RequestAttributes attributes = org.springframework.web.context.request.RequestContextHolder.getRequestAttributes();
      if (!(attributes instanceof org.springframework.web.context.request.ServletRequestAttributes)) return null;
      String value = ((org.springframework.web.context.request.ServletRequestAttributes) attributes).getRequest().getHeader("financeBranchId");
      if (value == null) return null;
      if (!value.matches("[1-9][0-9]{0,18}")) return -1L;
      try { return Long.valueOf(value); } catch (NumberFormatException invalid) { return -1L; }
   }

   public boolean productWasteRecord(Long id, boolean invoice) {
      if (id == null) return false;
      if (invoice) {
         com.hzchum.scim.contract.core.api.pojo._do.ContractInvoice record = invoices.getById(id);
         return record != null && Objects.equals(record.getType(), com.hzchum.scim.contract.core.api.enums.CreateInvoiceTypeEnum.SCRAP_COLLECTION.getType());
      }
      com.hzchum.scim.contract.core.api.pojo._do.ContractCollection record = collections.getById(id);
      return record != null && Objects.equals(record.getType(), com.hzchum.scim.contract.core.api.enums.CollectionTypeEnum.SCRAP_COLLECTION.getType());
   }

   public boolean auditApprovalRecordRead(Long approveRecordId) {
      WmsApproveRecord record = approveRecordId == null ? null : records.getById(approveRecordId);
      ContractAuditLedger ledger = record == null || record.getDataId() == null ? null : ledgers.getById(record.getDataId());
      return ledger != null && Objects.equals(ledger.getApproveRecordId(), record.getId())
         && Objects.equals(record.getDataId(), ledger.getId()) && auditRecordRead(ledger.getId(), "detail");
   }

   public boolean auditRecordRead(Long auditId, String action) {
      if (!"detail".equals(action) && !"download".equals(action)) return false;
      SecurityUser user = UserUtil.getCurrentUser();
      ContractAuditLedger ledger = auditId == null ? null : ledgers.getById(auditId);
      if (user == null || ledger == null) return false;
      if (ledgerHas("examine-manage:" + action)) return true;
      Long userId = UserUtil.getCurrentUserId();
      if (Objects.equals(ledger.getInitiatorId(), userId)) return true;
      WmsApproveRecord record = ledger.getApproveRecordId() == null ? null : records.getById(ledger.getApproveRecordId());
      if (record == null || !Objects.equals(record.getDataId(), ledger.getId())) return false;
      if (Objects.equals(record.getApplicantId(), userId)) return true;
      return details.count(Wrappers.lambdaQuery(WmsApproveRecordDetail.class)
         .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, record.getSerialNumber())
         .eq(WmsApproveRecordDetail::getCheckUserId, userId)) > 0;
   }

   public Integer supplierLedgerLevel(Integer requestedLevel, Long branchCompanyId) {
      if (branchCompanyId == null) return requestedLevel == null ? 1 : requestedLevel;
      BranchCompany company = companies.getById(branchCompanyId);
      return company == null ? null : company.getLevel();
   }

   public boolean supplierLedgerRead(Long projectId, Integer level, Long branchCompanyId) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user == null) return false;
      Integer actualLevel = supplierLedgerLevel(level, branchCompanyId);
      if (!Objects.equals(actualLevel, 1) && !Objects.equals(actualLevel, 2)) return false;
      if (!ledgerHas(actualLevel == 1 ? "self-supplier:get" : "second-unit-supplier:get")) return false;
      if (projectId == null) return true;
      ContractProject project = projects.getById(projectId);
      return project != null && Objects.equals(project.getProjectAttribute(), ProjectAttributeEnum.SELF_SUPPORT.getType())
         && links.count(Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
            .eq(ProjectBranchCompanyLink::getProjectId, projectId)
            .eq(ProjectBranchCompanyLink::getBranchCompanyLevel, actualLevel)
            .eq(branchCompanyId != null, ProjectBranchCompanyLink::getBranchCompanyId, branchCompanyId)) > 0;
   }

   public List<com.hzchum.scim.common.core.api.pojo.common.ProjectInfo> supplierLedgerProjects(
         List<com.hzchum.scim.common.core.api.pojo.common.ProjectInfo> candidates, Integer level, Long branchCompanyId) {
      Integer actualLevel = supplierLedgerLevel(level, branchCompanyId);
      Set<Long> projectIds = links.list(Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
         .eq(ProjectBranchCompanyLink::getBranchCompanyLevel, actualLevel)
         .eq(branchCompanyId != null, ProjectBranchCompanyLink::getBranchCompanyId, branchCompanyId)).stream()
         .map(ProjectBranchCompanyLink::getProjectId).collect(Collectors.toSet());
      return candidates.stream().filter(project -> projectIds.contains(project.getId())).collect(Collectors.toList());
   }

   public boolean purchaseInboundRead(Long orderId, boolean print) {
      PurchaseOrder order = orderId == null ? null : purchaseOrders.getById(orderId);
      SecurityUser user = UserUtil.getCurrentUser();
      if (order == null || Boolean.TRUE.equals(order.getBoolDeleteEnum()) || user == null) return false;
      Long branchId = requestFinanceBranch();
      if (branchId != null && !Objects.equals(branchId, order.getBranchCompanyId())) return false;
      Integer attribute = order.getProjectAttribute();
      if (!Objects.equals(attribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
         && !Objects.equals(attribute, ProjectAttributeEnum.JOINT_VENTURE.getType())
         && !Objects.equals(attribute, ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) return false;
      if (user.isAdmin() || !print && ledgerHas("order_statistics:detail")) return true;
      return Objects.equals(attribute, ProjectAttributeEnum.SELF_SUPPORT.getType())
         ? ledgerHas("scm_purchaseOrder_self_v2:get") : ledgerHas("scm_purchaseOrder_v2:get");
   }

   public boolean supplierOrderRead(Long orderId, Integer purchaseType) {
      Integer attribute; Integer level; Long companyId; Long projectId = null;
      if (Objects.equals(purchaseType, 8)) {
         SubcontractOrder order = orderId == null ? null : subcontractOrders.getById(orderId);
         if (order == null) return false;
         attribute = order.getProjectAttribute(); level = order.getLevel(); companyId = order.getBranchCompanyId(); projectId = order.getProjectId();
      } else {
         if (purchaseType != null && !Objects.equals(purchaseType, 1) && !Objects.equals(purchaseType, 2)) return false;
         PurchaseOrder order = orderId == null ? null : purchaseOrders.getById(orderId);
         if (order == null || purchaseType != null && !Objects.equals(purchaseType, order.getPurchaseType())) return false;
         attribute = order.getProjectAttribute(); level = order.getLevel(); companyId = order.getBranchCompanyId();
      }
      if (Objects.equals(attribute, ProjectAttributeEnum.JOINT_VENTURE.getType())
            || Objects.equals(attribute, ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) return ledgerHas("inter_account:detail");
      if (!Objects.equals(attribute, ProjectAttributeEnum.SELF_SUPPORT.getType())) return false;
      if (companyId != null) {
         BranchCompany company = companies.getById(companyId);
         if (company == null || level != null && !Objects.equals(level, company.getLevel())) return false;
         level = company.getLevel();
      } else if (level == null && projectId != null) {
         ContractProject project = projects.getById(projectId);
         BranchCompany company = project == null ? null : companies.getById(project.getContractSignBodyId());
         level = company == null ? null : company.getLevel();
      }
      return Objects.equals(level, 1) ? ledgerHas("self-supplier:get")
         : Objects.equals(level, 2) && ledgerHas("second-unit-supplier:get");
   }

   public boolean interiorProjectRead(Long projectId, boolean print) {
      ContractProject project = projectId == null ? null : projects.getById(projectId);
      return project != null && (Objects.equals(project.getProjectAttribute(), ProjectAttributeEnum.JOINT_VENTURE.getType())
         || Objects.equals(project.getProjectAttribute(), ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType()))
         && ledgerHas(print ? "inter_account:print" : "inter_account:detail");
   }

   private boolean ledgerHas(String permission) {
      SecurityUser user = UserUtil.getCurrentUser();
      return user != null && (user.isAdmin() || user.getPermissions() != null && user.getPermissions().contains(permission));
   }

   public boolean read(Long projectId, Integer level) {
      return interiorProjectRead(projectId, false) || allowed(projectId, level, null, null);
   }

   public boolean readPrint(Long projectId, Integer level) {
      return interiorProjectRead(projectId, true) || allowed(projectId, level, null, null);
   }

   public boolean write(Long projectId, Integer level, Long collectionUnitId) {
      return allowed(projectId, level, collectionUnitId, "collection");
   }

   public boolean invoiceWrite(Long projectId, Integer level, Long invoiceUnitId) {
      return allowed(projectId, level, invoiceUnitId, "billing");
   }

   public boolean subcontractCreate(Long orderId, String action) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user == null || (!"payment".equals(action) && !"invoice_entry".equals(action))) return false;
      SubcontractOrder order = orderId == null ? null : subcontractOrders.getById(orderId);
      if (order == null) return false;
      Integer attribute = order.getProjectAttribute();
      boolean self = Objects.equals(attribute, ProjectAttributeEnum.SELF_SUPPORT.getType());
      if (!self && !Objects.equals(attribute, ProjectAttributeEnum.JOINT_VENTURE.getType())
            && !Objects.equals(attribute, ProjectAttributeEnum.LUMP_SUM_SYSTEM.getType())) return false;
      String permission = (self ? "self_sub_supplier:" : "interior_sub_supplier:") + action;
      return user.isAdmin() || user.getPermissions() != null && user.getPermissions().contains(permission);
   }

   public boolean subcontractPaymentCreate(SubOrderPaymentAddDtoParam param) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user == null || param == null || param.getSupplierPayment() == null || param.getSupplierPayment().size() != 1) return false;
      if (!user.isAdmin() && (user.getPermissions() == null || !user.getPermissions().contains("self_sub_supplier:payment"))) return false;
      SubcontractOrder order = subcontractOrders.getById(param.getSupplierPayment().get(0).getSupplierPaymentId());
      return order != null && Objects.equals(order.getProjectAttribute(), ProjectAttributeEnum.SELF_SUPPORT.getType())
         && Objects.equals(order.getSupplierId(), param.getSupplierId());
   }

   public boolean purchaseSettlementCreate(Long orderId) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user == null || (!user.isAdmin() && (user.getPermissions() == null
            || !user.getPermissions().contains("scm_purchaseOrder_self_v2:pay_application")))) return false;
      PurchaseOrder order = orderId == null ? null : purchaseOrders.getById(orderId);
      return order != null && Objects.equals(order.getProjectAttribute(), ProjectAttributeEnum.SELF_SUPPORT.getType());
   }

   public boolean purchaseInvoiceCreate(PurchaseInvoiceSaveParam param) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user == null || param == null || param.getOrderInvoiceList() == null || param.getOrderInvoiceList().isEmpty()) return false;
      if (!user.isAdmin() && (user.getPermissions() == null
            || !user.getPermissions().contains("scm_purchaseOrder_self_v2:invoice_entry"))) return false;
      Set<Long> ids = param.getOrderInvoiceList().stream().map(row -> row.getOrderId()).collect(Collectors.toSet());
      List<PurchaseOrder> orders = purchaseOrders.listByIds(ids);
      return orders.size() == ids.size() && orders.stream().allMatch(order ->
         Objects.equals(order.getProjectAttribute(), ProjectAttributeEnum.SELF_SUPPORT.getType()));
   }

   public boolean purchasePaymentCreate(PurchasePaymentSaveParam param) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user == null || param == null || param.getSupplierPayment() == null || param.getSupplierPayment().isEmpty()) return false;
      if (!user.isAdmin() && (user.getPermissions() == null
            || !user.getPermissions().contains("scm_purchaseOrder_self_v2:pay_application"))) return false;
      Set<Long> orderIds = param.getSupplierPayment().stream().map(row -> row.getSupplierPaymentId()).collect(Collectors.toSet());
      List<PurchaseOrder> orders = purchaseOrders.listByIds(orderIds);
      return orders.size() == orderIds.size() && orders.stream().allMatch(order ->
         Objects.equals(order.getProjectAttribute(), ProjectAttributeEnum.SELF_SUPPORT.getType())
            && Objects.equals(order.getSupplierId(), param.getSupplierId()));
   }

   public boolean settlementWrite(Long projectId, Integer level, boolean pre) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user == null) return false;
      if (user.isAdmin()) return true;
      ContractProject project = projectId == null ? null : projects.getById(projectId);
      if (project == null || user.getPermissions() == null) return false;
      if (!Objects.equals(project.getProjectAttribute(), ProjectAttributeEnum.SELF_SUPPORT.getType())) {
         return !pre && user.getPermissions().contains("inter_account:settle");
      }
      if (level == null || (level != 1 && level != 2)) return false;
      String permission = level == 1 ? (pre ? "self-presettle:add" : "self-settle:add")
         : (pre ? "second-unit-self:presettle" : "second-unit-self:settle");
      return user.getPermissions().contains(permission) && links.count(Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
         .eq(ProjectBranchCompanyLink::getProjectId, projectId)
         .eq(ProjectBranchCompanyLink::getBranchCompanyLevel, level)) > 0;
   }

   public boolean settlementRead(Long projectId, Integer level) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user == null) return false;
      if (user.isAdmin()) return true;
      ContractProject project = projectId == null ? null : projects.getById(projectId);
      if (project == null || user.getPermissions() == null) return false;
      if (Objects.equals(project.getProjectAttribute(), ProjectAttributeEnum.SELF_SUPPORT.getType())) return read(projectId, level);
      return user.getPermissions().contains("inter_account:get") || user.getPermissions().contains("inter_account:detail");
   }

   public boolean settlementDetail(Long auditId, Long projectId, Integer level) {
      if (auditId == null) {
         if (level == null && projectId != null) {
            ContractProject project = projects.getById(projectId);
            BranchCompany company = project == null ? null : companies.getById(project.getContractSignBodyId());
            level = company == null ? null : company.getLevel();
         }
         return settlementRead(projectId, level) || settlementWrite(projectId, level, false)
            || settlementWrite(projectId, level, true);
      }
      SecurityUser user = UserUtil.getCurrentUser();
      ContractAuditLedger ledger = ledgers.getById(auditId);
      if (user == null || ledger == null || (projectId != null && !projectId.toString().equals(ledger.getProjectId()))) return false;
      boolean pre = Objects.equals(ledger.getPaymentEnum(), AuditPaymentEnum.PROJECT_PRE_SETTLEMENT.getType());
      if (!pre && !Objects.equals(ledger.getPaymentEnum(), AuditPaymentEnum.PROJECT_SETTLEMENT.getType())) return false;
      WmsApproveRecord record = ledger.getApproveRecordId() == null ? null : records.getById(ledger.getApproveRecordId());
      int process = pre ? ApproveProcessTypeEnumV2.CONTRACT_PRE_SETTLEMENT_AUDIT.getType()
         : ApproveProcessTypeEnumV2.CONTRACT_SETTLEMENT_AUDIT.getType();
      if (record == null || !Objects.equals(record.getDataId(), ledger.getId())
            || !Objects.equals(record.getApproveProcessType(), process)) return false;
      ContractProject project = projects.getById(ledger.getProjectId());
      if (project == null) return false;
      if (user.isAdmin()) return true;
      BranchCompany company = companies.getById(project.getContractSignBodyId());
      if (company != null && settlementRead(project.getId(), company.getLevel())) return true;
      if (user.getPermissions() != null && (user.getPermissions().contains("examine-manage:get")
            || user.getPermissions().contains("examine-manage:detail"))) return true;
      Long userId = UserUtil.getCurrentUserId();
      if (Objects.equals(ledger.getInitiatorId(), userId) || Objects.equals(record.getApplicantId(), userId)) return true;
      return details.count(Wrappers.lambdaQuery(WmsApproveRecordDetail.class)
         .eq(WmsApproveRecordDetail::getApproveRecordSerialNumber, record.getSerialNumber())
         .eq(WmsApproveRecordDetail::getCheckUserId, userId)) > 0;
   }

   private boolean allowed(Long projectId, Integer level, Long collectionUnitId, String action) {
      SecurityUser user = UserUtil.getCurrentUser();
      if (user == null) return false;
      if (user.isAdmin()) return true;
      if (projectId == null || (level == null || (level != 1 && level != 2)) || user.getPermissions() == null) return false;
      ContractProject project = projects.getById(projectId);
      if (project == null || !Objects.equals(project.getProjectAttribute(), ProjectAttributeEnum.SELF_SUPPORT.getType())) return false;
      String permission = action != null
         ? (level == 1 ? "self-" + action + ":add" : "second-unit-self:" + action)
         : (level == 1 ? "self:get" : "second-unit-self:get");
      if (!user.getPermissions().contains(permission)) return false;
      return links.count(Wrappers.lambdaQuery(ProjectBranchCompanyLink.class)
         .eq(ProjectBranchCompanyLink::getProjectId, projectId)
         .eq(ProjectBranchCompanyLink::getBranchCompanyLevel, level)
         .eq(collectionUnitId != null, ProjectBranchCompanyLink::getBranchCompanyId, collectionUnitId)) > 0;
   }
}
