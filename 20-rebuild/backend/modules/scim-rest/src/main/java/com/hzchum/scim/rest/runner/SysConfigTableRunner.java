package com.hzchum.scim.rest.runner;

import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SysConfigTableRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(SysConfigTableRunner.class);
   @Resource
   private InitializationService service;

   @Override
   public void run(String... args) throws Exception {
      String datasource = this.service.selectSql("SELECT DATABASE()").get(0);
      log.info("修改配置表结构开始............................................");
      List<String> updateSqlList = new ArrayList<>();
      List<String> resultSql = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='sys_config' AND  TABLE_SCHEMA ='" + datasource + "'");
      if (resultSql.contains("value")) {
         updateSqlList.add("ALTER TABLE sys_config MODIFY column value varchar(3000) COMMENT '配置值'");
      }

      List<String> resultSqlWmsBasicConfig = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='wms_basic_config' AND  TABLE_SCHEMA ='" + datasource + "'");
      if (resultSqlWmsBasicConfig.contains("value")) {
         updateSqlList.add("ALTER TABLE wms_basic_config MODIFY column value varchar(3000) COMMENT '配置值'");
      }

      updateSqlList.forEach(this.service::updateSql);
      log.info("修改配置表结构完成............................................");
   }
}
