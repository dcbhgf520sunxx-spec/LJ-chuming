package com.hzchum.scim.rest.runner.contract;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.contract.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.contract.core.api.pojo._do.ContractInvoice;
import com.hzchum.scim.contract.core.api.pojo._do.SupplierInvoice;
import com.hzchum.scim.contract.core.api.service.ContractInvoiceService;
import com.hzchum.scim.contract.core.api.service.SupplierInvoiceService;
import java.math.BigDecimal;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class FinanceRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(FinanceRunner.class);
   private final ContractInvoiceService contractInvoiceService;
   private final SupplierInvoiceService supplierInvoiceService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      List<ContractInvoice> contractInvoiceList = this.contractInvoiceService
         .list(Wrappers.lambdaQuery(ContractInvoice.class).eq(ContractInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType()));
      if (CollectionUtils.isNotEmpty(contractInvoiceList)) {
         contractInvoiceList.forEach(co -> {
            if (co.getActualInvoiceAmount() == null || co.getActualInvoiceAmount().compareTo(BigDecimal.ZERO) == 0) {
               co.setActualInvoiceAmount(co.getInvoiceAmount());
            }
         });
         this.contractInvoiceService.updateBatchById(contractInvoiceList);
      }

      List<SupplierInvoice> supplierInvoiceList = this.supplierInvoiceService
         .list(Wrappers.lambdaQuery(SupplierInvoice.class).eq(SupplierInvoice::getAuditStatus, AuditStatusEnum.SUCCEED.getType()));
      if (CollectionUtils.isNotEmpty(supplierInvoiceList)) {
         supplierInvoiceList.forEach(co -> {
            if (co.getActualInvoiceAmount() == null || co.getActualInvoiceAmount().compareTo(BigDecimal.ZERO) == 0) {
               co.setActualInvoiceAmount(co.getInvoiceAmount());
            }
         });
         this.supplierInvoiceService.updateBatchById(supplierInvoiceList);
      }
   }

   public FinanceRunner(final ContractInvoiceService contractInvoiceService, final SupplierInvoiceService supplierInvoiceService) {
      this.contractInvoiceService = contractInvoiceService;
      this.supplierInvoiceService = supplierInvoiceService;
   }
}
