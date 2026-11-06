package com.hzchum.scim.rest.runner.test;

import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;

@Order(162)
public class MesBuildingWarehouseRecordDateV2Runner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingWarehouseRecordDateV2Runner.class);
   @Resource
   private InitializationService service;

   @Override
   public void run(String... args) throws Exception {
      this.service
         .updateSql("UPDATE mes_building_complete SET in_year_month_day_date = date(create_time), in_year_month_date = date_format(create_time, '%Y-%m') ");
      this.service
         .updateSql(
            "UPDATE mes_building_warehouse_record SET in_year_month_day_date = date(create_time), in_year_month_date = date_format(create_time, '%Y-%m') "
         );
   }
}
