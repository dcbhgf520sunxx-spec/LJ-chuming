package com.hzchum.scim.rest.runner.contract;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.contract.core.api.enums.AuditTypeEnum;
import com.hzchum.scim.contract.core.api.enums.finance.AuditPaymentEnum;
import com.hzchum.scim.contract.core.api.enums.payment.SupplierPropertyTypeEnum;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.audit.ContractAuditLedger;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import com.hzchum.scim.contract.core.api.service.audit.ContractAuditLedgerService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ContractAuditLedgerRunner implements CommandLineRunner {
   private final ContractAuditLedgerService contractAuditLedgerService;
   private final SupplierInvoiceService supplierInvoiceService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      List<ContractAuditLedger> contractAuditLedgerList = this.contractAuditLedgerService
         .list(Wrappers.lambdaQuery(ContractAuditLedger.class).isNull(ContractAuditLedger::getAuditType));
      if (!contractAuditLedgerList.isEmpty()) {
         List<ContractAuditLedger> supplierInvoiceAuditList = contractAuditLedgerList.stream()
            .filter(contractAuditLedger -> contractAuditLedger.getPaymentEnum().equals(AuditPaymentEnum.INCOMING_INVOICES.getType()))
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(supplierInvoiceAuditList)) {
            List<Long> supplierInvoiceIds = supplierInvoiceAuditList.stream().map(audit -> Long.valueOf(audit.getPaymentId())).collect(Collectors.toList());
            Map<String, Integer> invoiceIdPropertyTypeMap = this.supplierInvoiceService
               .listByIds(supplierInvoiceIds)
               .stream()
               .collect(Collectors.toMap(s -> String.valueOf(s.getId()), SupplierInvoice::getPropertyType));
            supplierInvoiceAuditList.forEach(
               audit -> {
                  Integer propertyType = invoiceIdPropertyTypeMap.get(audit.getPaymentId());
                  if (SupplierPropertyTypeEnum.MATERIAL_PURCHASE_FEE.getType().equals(propertyType)
                     || SupplierPropertyTypeEnum.PURCHASE_FEE.getType().equals(propertyType)) {
                     audit.setAuditType(AuditTypeEnum.PAYMENT_APPROVE.getType());
                  }

                  if (SupplierPropertyTypeEnum.SUB_FEE.getType().equals(propertyType)) {
                     audit.setAuditType(AuditTypeEnum.SUB_CONTRACT_APPROVE.getType());
                  }
               }
            );
         }

         List<ContractAuditLedger> otherAuditList = contractAuditLedgerList.stream()
            .filter(contractAuditLedger -> !contractAuditLedger.getPaymentEnum().equals(AuditPaymentEnum.INCOMING_INVOICES.getType()))
            .collect(Collectors.toList());
         if (CollectionUtils.isNotEmpty(otherAuditList)) {
            otherAuditList.forEach(
               auditLedger -> {
                  Integer paymentEnum = auditLedger.getPaymentEnum();
                  if (paymentEnum.equals(AuditPaymentEnum.PROCUREMENT_PAYMENT.getType()) || paymentEnum.equals(AuditPaymentEnum.PURCHASE_SETTLEMENT.getType())) {
                     auditLedger.setAuditType(AuditTypeEnum.PAYMENT_APPROVE.getType());
                  }

                  if (paymentEnum.equals(AuditPaymentEnum.OUTGOING_INVOICES.getType()) || paymentEnum.equals(AuditPaymentEnum.PROJECT_SETTLEMENT.getType())) {
                     auditLedger.setAuditType(AuditTypeEnum.CONTRACT_APPROVE.getType());
                  }

                  if (paymentEnum.equals(AuditPaymentEnum.SUBCONTRACT_PAYMENT.getType())
                     || paymentEnum.equals(AuditPaymentEnum.SUBCONTRACT_SETTLEMENT.getType())) {
                     auditLedger.setAuditType(AuditTypeEnum.SUB_CONTRACT_APPROVE.getType());
                  }
               }
            );
         }

         this.contractAuditLedgerService.updateBatchById(contractAuditLedgerList);
      }
   }

   public ContractAuditLedgerRunner(final ContractAuditLedgerService contractAuditLedgerService, final SupplierInvoiceService supplierInvoiceService) {
      this.contractAuditLedgerService = contractAuditLedgerService;
      this.supplierInvoiceService = supplierInvoiceService;
   }
}
