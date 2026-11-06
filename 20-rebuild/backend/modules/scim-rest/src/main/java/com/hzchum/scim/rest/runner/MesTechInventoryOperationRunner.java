package com.hzchum.scim.rest.runner;

import com.hzchum.scim.plan.core.api.enums.InventoryTypeEnum;
import com.hzchum.scim.plan.core.api.pojo._do.check.MesTechInventoryOperation;
import com.hzchum.scim.plan.core.api.service.check.MesTechInventoryOperationService;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(99)
@Component
public class MesTechInventoryOperationRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesTechInventoryOperationRunner.class);
   @Autowired
   private MesTechInventoryOperationService mesTechInventoryOperationService;

   @Override
   public void run(String... args) throws Exception {
      List<MesTechInventoryOperation> operationList = this.mesTechInventoryOperationService.list();
      operationList.forEach(item -> {
         if (item.getBuildingType().equals(InventoryTypeEnum.ENCLOSURE.getType())) {
            item.setType(2);
         } else {
            item.setType(1);
         }
      });
      this.mesTechInventoryOperationService.updateBatchById(operationList);
   }

   public MesTechInventoryOperationRunner(final MesTechInventoryOperationService mesTechInventoryOperationService) {
      this.mesTechInventoryOperationService = mesTechInventoryOperationService;
   }
}
