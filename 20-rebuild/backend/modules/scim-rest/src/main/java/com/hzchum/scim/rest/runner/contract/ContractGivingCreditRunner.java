package com.hzchum.scim.rest.runner.contract;

import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ContractGivingCreditRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ContractGivingCreditRunner.class);
   private final InitializationService service;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      List<String> updateSqlList = new ArrayList<>();
      updateSqlList.add("ALTER TABLE contract_giving_credit MODIFY column annual_interest decimal(32,8) DEFAULT 0 NOT NULL COMMENT '年息(%)'");
      updateSqlList.add("ALTER TABLE contract_giving_credit MODIFY column monthly_interest decimal(32,8) DEFAULT 0 NOT NULL COMMENT '月息(%)'");
      updateSqlList.add("ALTER TABLE contract_giving_credit MODIFY column day_interest decimal(32,8) DEFAULT 0 NOT NULL COMMENT '日息(%)'");
      updateSqlList.add("ALTER TABLE contract_giving_credit MODIFY column used_credit decimal(32,4) DEFAULT 0 NOT NULL COMMENT '已使用'");
      updateSqlList.forEach(this.service::updateSql);
   }

   public ContractGivingCreditRunner(final InitializationService service) {
      this.service = service;
   }
}
