package com.hzchum.scim.rest.runner.crm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Order(99)
@Component
public class CrmProjectAlterTableRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(CrmProjectAlterTableRunner.class);
   @Autowired
   private JdbcTemplate jdbcTemplate;

   @Override
   public void run(String... args) throws Exception {
      String sql1 = "ALTER TABLE crm_project_information_warehousing MODIFY COLUMN business_project_bid_manager_user_id VARCHAR(255)";
      String sql2 = "ALTER TABLE crm_project_information_warehousing MODIFY COLUMN devise_project_bid_manager_user_id VARCHAR(255)";
      String sql3 = "ALTER TABLE crm_project_information_warehousing MODIFY COLUMN technology_project_bid_manager_user_id VARCHAR(255)";
      this.jdbcTemplate.execute(sql1);
      this.jdbcTemplate.execute(sql2);
      this.jdbcTemplate.execute(sql3);
      System.out.println("Columns modified successfully.");
   }

   public CrmProjectAlterTableRunner(final JdbcTemplate jdbcTemplate) {
      this.jdbcTemplate = jdbcTemplate;
   }
}
