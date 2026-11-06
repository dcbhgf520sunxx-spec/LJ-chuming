package com.hzchum.scim.rest.runner.test;

import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TechArtifactTestRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(TechArtifactTestRunner.class);
   @Resource
   private InitializationService service;

   @Override
   public void run(String... args) throws Exception {
      String datasource = this.service.selectSql("SELECT DATABASE()").get(0);
      List<String> updateSqlList = new ArrayList<>();
      List<String> resultSql = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='tech_artifact' AND  TABLE_SCHEMA ='" + datasource + "'");
      if (resultSql.contains("subscription_quantity")) {
         updateSqlList.add("ALTER TABLE tech_artifact MODIFY column subscription_quantity int(11) DEFAULT 0 COMMENT '申购数量'");
      }

      updateSqlList.forEach(this.service::updateSql);
   }
}
