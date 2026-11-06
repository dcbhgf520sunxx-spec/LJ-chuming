package com.hzchum.scim.rest.runner.test;

import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

@Order(165)
public class MesBuildingWarehouseRecordDateV5Runner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingWarehouseRecordDateV5Runner.class);
   @Resource
   private InitializationService service;

   @Override
   public void run(String... args) throws Exception {
      this.service
         .updateSql(
            "UPDATE mes_building_warehouse_record SET in_year_month_day_date = date(create_time), in_year_month_date = date_format(create_time, '%Y-%m') WHERE in_year_month_date IS NULL"
         );
   }
}
