package com.hzchum.scim.rest.runner;

import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProjectQhseInitRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ProjectQhseInitRunner.class);
   private final InitializationService service;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void run(String... strings) {
      String datasource = this.service.selectSql("SELECT DATABASE()").get(0);
      List<String> updateSqlList = new ArrayList<>();
      List<String> resultSql = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='project_qhse_problem' AND  TABLE_SCHEMA ='" + datasource + "'");
      if (resultSql.contains("monomer_id")) {
         updateSqlList.add("ALTER TABLE project_qhse_problem MODIFY COLUMN monomer_id bigint(20) NULL;");
      }

      if (resultSql.contains("subcontract_order_id")) {
         updateSqlList.add("ALTER TABLE project_qhse_problem MODIFY COLUMN subcontract_order_id bigint(20) NULL;");
      }

      if (resultSql.contains("supplier_id")) {
         updateSqlList.add("ALTER TABLE project_qhse_problem MODIFY COLUMN supplier_id bigint(20) NULL;");
      }

      if (resultSql.contains("subcontract_class_id")) {
         updateSqlList.add("ALTER TABLE project_qhse_problem MODIFY COLUMN subcontract_class_id bigint(20) NULL;");
      }

      if (resultSql.contains("problem_type_id")) {
         updateSqlList.add("ALTER TABLE project_qhse_problem MODIFY COLUMN problem_type_id bigint(20) NULL;");
      }

      if (resultSql.contains("number")) {
         updateSqlList.add("ALTER TABLE project_qhse_problem MODIFY COLUMN number VARCHAR(64);");
      }

      if (resultSql.contains("type")) {
         updateSqlList.add("ALTER TABLE project_qhse_problem MODIFY COLUMN type int(5) NULL;");
      }

      if (resultSql.contains("problem_id")) {
         updateSqlList.add("ALTER TABLE project_qhse_problem MODIFY COLUMN problem_id bigint(20) NULL;");
      }

      if (resultSql.contains("user_id")) {
         updateSqlList.add("ALTER TABLE project_qhse_problem MODIFY COLUMN user_id bigint(20) NULL;");
      }

      updateSqlList.forEach(this.service::updateSql);
   }

   public ProjectQhseInitRunner(final InitializationService service) {
      this.service = service;
   }
}
