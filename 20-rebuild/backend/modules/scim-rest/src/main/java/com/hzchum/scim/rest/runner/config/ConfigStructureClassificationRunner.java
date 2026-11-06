package com.hzchum.scim.rest.runner.config;

import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(60)
@Component
public class ConfigStructureClassificationRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ConfigStructureClassificationRunner.class);
   private final InitializationService service;

   @Override
   public void run(String... args) throws Exception {
      String datasource = this.service.selectSql("SELECT DATABASE()").get(0);
      List<String> updateSqlList = new ArrayList<>();
      List<String> resultStructureClassificationSql = this.service
         .selectSql(
            "SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='sys_structure_classification' AND  TABLE_SCHEMA ='" + datasource + "'"
         );
      if (resultStructureClassificationSql.contains("parent_type")) {
         updateSqlList.add("ALTER TABLE sys_structure_classification DROP COLUMN parent_type;");
      }

      if (resultStructureClassificationSql.contains("definition_word")) {
         updateSqlList.add("ALTER TABLE sys_structure_classification DROP COLUMN definition_word;");
      }

      List<String> resultStructureSpecSql = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='sys_structure_spec' AND  TABLE_SCHEMA ='" + datasource + "'");
      if (resultStructureSpecSql.contains("definition_word")) {
         updateSqlList.add("ALTER TABLE sys_structure_spec DROP COLUMN definition_word;");
      }

      if (resultStructureClassificationSql.contains("parent_type")) {
         updateSqlList.add("ALTER TABLE sys_structure_spec DROP COLUMN parent_type;");
      }

      List<String> resultStructureNumberPrefixSql = this.service
         .selectSql(
            "SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='sys_structure_serial_number_prefix' AND  TABLE_SCHEMA ='" + datasource + "'"
         );
      updateSqlList.forEach(this.service::updateSql);
   }

   public ConfigStructureClassificationRunner(final InitializationService service) {
      this.service = service;
   }
}
