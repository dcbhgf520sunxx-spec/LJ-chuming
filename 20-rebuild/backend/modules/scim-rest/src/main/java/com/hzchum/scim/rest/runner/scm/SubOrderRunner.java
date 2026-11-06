package com.hzchum.scim.rest.runner.scm;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
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
import com.hzchum.scim.scm.core.api.pojo._do.PurchaseOrder;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractOrder;
import com.hzchum.scim.scm.core.api.service.PurchaseOrderService;
import com.hzchum.scim.scm.core.api.service.SubcontractOrderService;
import com.hzchum.scim.scm.core.api.service.SupplierService;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.BranchCompanyService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SubOrderRunner implements CommandLineRunner {
   private final ContractProjectService projectService;
   private final UserService userService;
   private final BranchCompanyService branchCompanyService;
   private final SupplierService supplierService;
   private final PurchaseOrderService purchaseOrderService;
   private final SubcontractOrderService subcontractOrderService;
   private final SupplierPaymentService supplierPaymentService;
   private final SupplierInvoiceService supplierInvoiceService;
   private final SupplierSettlementService supplierSettlementService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      List<SubcontractOrder> orderList = this.subcontractOrderService.list();
      if (CollectionUtils.isNotEmpty(orderList)) {
         Map<Long, ContractProject> projectMap = this.projectService
            .listByIds(orderList.stream().map(SubcontractOrder::getProjectId).collect(Collectors.toSet()))
            .stream()
            .collect(Collectors.toMap(ContractProject::getId, Function.identity()));
         orderList.forEach(order -> {
            ContractProject project = projectMap.get(order.getProjectId());
            if (order.getBranchCompanyId() == null || order.getBranchCompanyId().equals(0L)) {
               order.setBranchCompanyId(project != null ? project.getContractSignBodyId() : null);
            }

            if (order.getAuditTypeEnum() == null) {
               order.setAuditTypeEnum(AuditStatusEnum.SUCCEED.getType());
            }
         });
         this.subcontractOrderService.updateBatchById(orderList);
      }

      Map<Long, PurchaseOrder> purchaseOrderMap = this.purchaseOrderService
         .list()
         .stream()
         .collect(Collectors.toMap(PurchaseOrder::getId, Function.identity()));
      Map<Long, SubcontractOrder> subcontractOrderMap = orderList.stream().collect(Collectors.toMap(SubcontractOrder::getId, Function.identity()));
      Map<Long, String> userIdNameMap = this.userService.list().stream().filter(u -> u.getName() != null).collect(Collectors.toMap(User::getId, User::getName));
      this.setPaymentList(userIdNameMap, purchaseOrderMap, subcontractOrderMap);
      this.setInvoiceList(userIdNameMap);
      this.setSettleList(purchaseOrderMap, subcontractOrderMap);
   }

   private void setPaymentList(Map<Long, String> userIdNameMap, Map<Long, PurchaseOrder> purchaseOrderMap, Map<Long, SubcontractOrder> subcontractOrderMap) {
      List<SupplierPayment> supplierPaymentList = this.supplierPaymentService.list();
      supplierPaymentList.forEach(
         sp -> {
            if (StringUtils.isNotBlank(sp.getApplyUserName())) {
               sp.setApplyUserName(userIdNameMap.get(sp.getApplyUserId()));
            }

            if (!sp.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) && StringUtils.isNotBlank(sp.getAuditUserName())) {
               sp.setAuditUserName(userIdNameMap.get(sp.getAuditUserId()));
            }

            if (sp.getSupplierId() == null) {
               sp.setSupplierId(sp.getReceivingUnitId());
            }

            if (sp.getPaymentAmount() == null) {
               sp.setPaymentAmount(sp.getApplyAmount());
            }

            if (sp.getPaymentUnitId() == null || sp.getBranchCompanyId().equals(0L)) {
               if (sp.getPropertyType().equals(SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType())
                  || sp.getPropertyType().equals(SupplierPropertyTypeEnum.PURCHASE_FEE.getType())) {
                  PurchaseOrder purchaseOrder = purchaseOrderMap.get(sp.getOrderId());
                  if (purchaseOrder != null) {
                     sp.setBranchCompanyId(sp.getBranchCompanyId().equals(0L) ? purchaseOrder.getBranchCompanyId() : sp.getBranchCompanyId());
                     sp.setPaymentUnitId(sp.getPaymentUnitId() == null ? purchaseOrder.getBranchCompanyId() : sp.getPaymentUnitId());
                  }
               }

               if (sp.getPropertyType().equals(SupplierPropertyTypeEnum.SUB_FEE.getType())) {
                  SubcontractOrder subcontractOrder = subcontractOrderMap.get(sp.getOrderId());
                  if (subcontractOrder != null) {
                     sp.setBranchCompanyId(subcontractOrder.getBranchCompanyId());
                     sp.setPaymentUnitId(subcontractOrder.getBranchCompanyId());
                  }
               }
            }
         }
      );
      this.supplierPaymentService.updateBatchById(supplierPaymentList);
   }

   private void setInvoiceList(Map<Long, String> userIdNameMap) {
      List<SupplierInvoice> supplierInvoiceList = this.supplierInvoiceService.list();
      supplierInvoiceList.forEach(sp -> {
         if (StringUtils.isNotBlank(sp.getApplyUserName())) {
            sp.setApplyUserName(userIdNameMap.get(sp.getApplyUserId()));
         }

         if (!sp.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) && StringUtils.isNotBlank(sp.getAuditUserName())) {
            sp.setAuditUserName(userIdNameMap.get(sp.getAuditUserId()));
         }
      });
      this.supplierInvoiceService.updateBatchById(supplierInvoiceList);
   }

   private void setSettleList(Map<Long, PurchaseOrder> purchaseOrderMap, Map<Long, SubcontractOrder> subcontractOrderMap) {
      List<SupplierSettlement> settlementList = this.supplierSettlementService
         .list(
            Wrappers.lambdaQuery(SupplierSettlement.class)
               .eq(SupplierSettlement::getAuditStatus, AuditStatusEnum.SUCCEED.getType())
               .isNull(SupplierSettlement::getAmount)
         );
      if (!settlementList.isEmpty()) {
         settlementList.forEach(
            settlement -> {
               if (settlement.getOrderClass().equals(OrderClassEnum.MATERIAL_ORDER.getType())
                  || settlement.getOrderClass().equals(OrderClassEnum.MANUFACTURE_ORDER.getType())) {
                  PurchaseOrder purchaseOrder = purchaseOrderMap.get(settlement.getOrderId());
                  if (purchaseOrder != null) {
                     settlement.setAmount(purchaseOrder.getSettlementAmount());
                  }
               }

               if (settlement.getOrderClass().equals(OrderClassEnum.SUB_ORDER.getType())) {
                  SubcontractOrder subcontractOrder = subcontractOrderMap.get(settlement.getOrderId());
                  if (subcontractOrder != null) {
                     settlement.setAmount(subcontractOrder.getSettlementAmount());
                  }
               }
            }
         );
         this.supplierSettlementService.updateBatchById(settlementList);
      }
   }

   public SubOrderRunner(
      final ContractProjectService projectService,
      final UserService userService,
      final BranchCompanyService branchCompanyService,
      final SupplierService supplierService,
      final PurchaseOrderService purchaseOrderService,
      final SubcontractOrderService subcontractOrderService,
      final SupplierPaymentService supplierPaymentService,
      final SupplierInvoiceService supplierInvoiceService,
      final SupplierSettlementService supplierSettlementService
   ) {
      this.projectService = projectService;
      this.userService = userService;
      this.branchCompanyService = branchCompanyService;
      this.supplierService = supplierService;
      this.purchaseOrderService = purchaseOrderService;
      this.subcontractOrderService = subcontractOrderService;
      this.supplierPaymentService = supplierPaymentService;
      this.supplierInvoiceService = supplierInvoiceService;
      this.supplierSettlementService = supplierSettlementService;
   }
}
