package com.hzchum.scim.rest.runner;

import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(103)
@Component
public class MesBuildingAssistSunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesBuildingAssistSunner.class);
   @Resource
   private InitializationService service;

   @Override
   public void run(String... args) throws Exception {
      List<String> updateSqlList = new ArrayList<>();
      String datasource = this.service.selectSql("SELECT DATABASE()").get(0);
      List<String> resultSqlOne = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='mes_building_assist' AND TABLE_SCHEMA ='" + datasource + "'");
      if (resultSqlOne.contains("groups_id")) {
         updateSqlList.add("ALTER TABLE mes_building_assist MODIFY column groups_id bigint(20) DEFAULT NULL;");
      }

      List<String> resultSqlTwo = this.service
         .selectSql(
            "SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='mes_building_artifact_scheduling' AND TABLE_SCHEMA ='" + datasource + "'"
         );
      if (resultSqlTwo.contains("groups_id")) {
         updateSqlList.add("ALTER TABLE mes_building_artifact_scheduling MODIFY column groups_id bigint(20) DEFAULT NULL;");
      }

      List<String> resultSqlThree = this.service
         .selectSql(
            "SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='mes_building_produce_inspection_team_report' AND TABLE_SCHEMA ='"
               + datasource
               + "'"
         );
      if (resultSqlThree.contains("group_id")) {
         updateSqlList.add("ALTER TABLE mes_building_produce_inspection_team_report MODIFY column group_id bigint(20) DEFAULT NULL;");
      }

      List<String> resultSqlFour = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='mes_building_task' AND TABLE_SCHEMA ='" + datasource + "'");
      if (resultSqlFour.contains("groups_id")) {
         updateSqlList.add("ALTER TABLE mes_building_task MODIFY column groups_id bigint(20) DEFAULT NULL;");
      }

      List<String> resultSqlFive = this.service
         .selectSql(
            "SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='mes_building_produce_team_report_summary' AND TABLE_SCHEMA ='"
               + datasource
               + "'"
         );
      if (resultSqlFive.contains("groups_id")) {
         updateSqlList.add("ALTER TABLE mes_building_produce_team_report_summary MODIFY column groups_id bigint(20) DEFAULT NULL;");
      }

      List<String> resultSqlSix = this.service
         .selectSql(
            "SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='mes_building_produce_inspection_team_report' AND TABLE_SCHEMA ='"
               + datasource
               + "'"
         );
      if (resultSqlSix.contains("inspection_team_id")) {
         updateSqlList.add("ALTER TABLE mes_building_produce_inspection_team_report MODIFY column inspection_team_id bigint(20) DEFAULT NULL;");
      }

      List<String> resultSql7 = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='contract_tech_temp' AND TABLE_SCHEMA ='" + datasource + "'");
      if (resultSql7.contains("new_json_list")) {
         updateSqlList.add("ALTER TABLE contract_tech_temp MODIFY column new_json_list text DEFAULT NULL;");
      }

      List<String> resultSql8 = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='contract_tech' AND TABLE_SCHEMA ='" + datasource + "'");
      if (resultSql8.contains("detail_json")) {
         updateSqlList.add("ALTER TABLE contract_tech MODIFY column detail_json text DEFAULT NULL;");
      }

      List<String> resultSql9 = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='tech_enclosure' AND TABLE_SCHEMA ='" + datasource + "'");
      if (resultSql9.contains("plate")) {
         updateSqlList.add("ALTER TABLE tech_enclosure MODIFY column plate varchar(526) DEFAULT NULL;");
      }

      if (resultSql9.contains("width")) {
         updateSqlList.add("ALTER TABLE tech_enclosure MODIFY column width decimal(32,4) DEFAULT NULL;");
      }

      if (resultSql9.contains("unfolded_width")) {
         updateSqlList.add("ALTER TABLE tech_enclosure MODIFY column unfolded_width decimal(32,4) DEFAULT NULL;");
      }

      if (resultSql9.contains("category")) {
         updateSqlList.add("ALTER TABLE tech_enclosure MODIFY column category bigint DEFAULT NULL  COMMENT '品类 2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件' ;");
      }

      if (resultSql9.contains("length")) {
         updateSqlList.add("ALTER TABLE tech_enclosure MODIFY column length decimal(32,4) DEFAULT NULL;");
      }

      if (resultSql9.contains("total_length")) {
         updateSqlList.add("ALTER TABLE tech_enclosure MODIFY column total_length decimal(32,4) DEFAULT NULL;");
      }

      if (resultSql9.contains("total_area")) {
         updateSqlList.add("ALTER TABLE tech_enclosure MODIFY column total_area decimal(32,4) DEFAULT NULL;");
      }

      if (resultSql9.contains("weight")) {
         updateSqlList.add("ALTER TABLE tech_enclosure MODIFY column weight decimal(32,4) DEFAULT NULL;");
      }

      if (resultSql9.contains("total_weight")) {
         updateSqlList.add("ALTER TABLE tech_enclosure MODIFY column total_weight decimal(32,4) DEFAULT NULL;");
      }

      if (resultSql9.contains("business_id")) {
         updateSqlList.add("ALTER TABLE tech_enclosure MODIFY column business_id decimal(32,4) DEFAULT NULL;");
      }

      if (resultSql9.contains("bend_times")) {
         updateSqlList.add("ALTER TABLE tech_enclosure MODIFY column bend_times int(11) DEFAULT NULL;");
      }

      List<String> resultSql10 = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='sys_branch_company' AND TABLE_SCHEMA ='" + datasource + "'");
      if (resultSql10.contains("level")) {
         updateSqlList.add("ALTER TABLE sys_branch_company MODIFY column level bigint(20) DEFAULT 2;");
      }

      List<String> resultSql11 = this.service
         .selectSql(
            "SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='mes_building_assist_number_detail' AND TABLE_SCHEMA ='" + datasource + "'"
         );
      if (resultSql11.contains("groups_id")) {
         updateSqlList.add("ALTER TABLE mes_building_assist_number_detail MODIFY column groups_id bigint(20) DEFAULT NULL;");
      }

      List<String> resultSql12 = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='mes_building_assist' AND TABLE_SCHEMA ='" + datasource + "'");
      if (resultSql12.contains("groups_id")) {
         updateSqlList.add("ALTER TABLE mes_building_assist MODIFY column groups_id bigint(20) DEFAULT NULL;");
      }

      List<String> resultSql13 = this.service
         .selectSql(
            "SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='mes_building_produce_team_report' AND TABLE_SCHEMA ='" + datasource + "'"
         );
      if (resultSql13.contains("groups_id")) {
         updateSqlList.add("ALTER TABLE mes_building_produce_team_report MODIFY column groups_id bigint(20) DEFAULT NULL;");
      }

      if (updateSqlList.size() > 1) {
         updateSqlList.forEach(this.service::updateSql);
      }
   }

   public MesBuildingAssistSunner(final InitializationService service) {
      this.service = service;
   }
}
