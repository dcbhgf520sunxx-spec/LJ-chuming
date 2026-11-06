package com.hzchum.scim.rest.runner.contract;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.contract.core.api.pojo._do.finance.ContractReimbursementFee;
import com.hzchum.scim.contract.core.api.service.finance.ContractReimbursementFeeService;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ReimbursementFeeRunner implements CommandLineRunner {
   private final ContractReimbursementFeeService reimbursementFeeService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      List<ContractReimbursementFee> reimbursementFeeList = this.reimbursementFeeService
         .list(Wrappers.lambdaQuery(ContractReimbursementFee.class).eq(ContractReimbursementFee::getAttachmentIds, "[]"));
      if (CollectionUtils.isNotEmpty(reimbursementFeeList)) {
         reimbursementFeeList.forEach(r -> r.setAttachmentIds(null));
         this.reimbursementFeeService.updateBatchById(reimbursementFeeList);
      }
   }

   public ReimbursementFeeRunner(final ContractReimbursementFeeService reimbursementFeeService) {
      this.reimbursementFeeService = reimbursementFeeService;
   }
}
