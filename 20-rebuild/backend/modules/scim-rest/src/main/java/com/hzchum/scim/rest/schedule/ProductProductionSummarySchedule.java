package com.hzchum.scim.rest.schedule;

import com.hzchum.scim.mes.building.core.api.service.record.MesBuildingProductProductionSummaryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

public class ProductProductionSummarySchedule {
   private static final Logger log = LoggerFactory.getLogger(ProductProductionSummarySchedule.class);
   @Autowired
   private MesBuildingProductProductionSummaryService productionSummaryService;

   @Scheduled(cron = "0 10 0 1 1/1 *")
   public void task1() {
      log.info("----------------- 生产统计 start -----------------");
      this.productionSummaryService.statLastMonthProductionSummary();
      log.info("----------------- 生产统计 end -----------------");
   }
}
