package com.hzchum.scim.rest.runner;

import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class StandardPartQuantityUpdateRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(StandardPartQuantityUpdateRunner.class);
   @Resource
   private InitializationService service;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      List<String> updateSqlList = new ArrayList<>();
      updateSqlList.add("ALTER TABLE tech_standard_part MODIFY column quantity decimal(18,4) default '0.0000' COMMENT '数量';");
      updateSqlList.add("ALTER TABLE business_price_detail MODIFY column quantity decimal(18,4) COMMENT '数量' NOT NULL;");
      updateSqlList.add("ALTER TABLE mes_building_warehouse_summary MODIFY column quantity decimal(18,4) DEFAULT 0.0 COMMENT '数量' NOT NULL;");
      updateSqlList.add("ALTER TABLE mes_building_warehouse_summary MODIFY column package_quantity decimal(18,4) DEFAULT 0.0 COMMENT '打包数量' NOT NULL;");
      updateSqlList.add("ALTER TABLE mes_building_warehouse_summary MODIFY column cargo_quantity decimal(18,4) DEFAULT 0.0 COMMENT '已装车数量' NOT NULL;");
      updateSqlList.add("ALTER TABLE mes_building_warehouse_summary MODIFY column print_quantity decimal(18,4) DEFAULT 0.0 COMMENT '打印数量' NOT NULL;");
      updateSqlList.add("ALTER TABLE mes_building_warehouse_record MODIFY column quantity decimal(18,4) DEFAULT 0.0 COMMENT '数量' NOT NULL;");
      updateSqlList.add("ALTER TABLE mes_building_package MODIFY column print_quantity decimal(18,4) DEFAULT 0 COMMENT '打印数量' NOT NULL;");
      updateSqlList.add("ALTER TABLE mes_building_package_link MODIFY column quantity decimal(18,4) DEFAULT 0 COMMENT '数量' NOT NULL;");
      updateSqlList.add("ALTER TABLE mes_building_cargo_list MODIFY column quantity decimal(18,4) DEFAULT 0 COMMENT '总数' NOT NULL;");
      updateSqlList.add("ALTER TABLE mes_building_cargo_list_product_link MODIFY column quantity decimal(18,4) DEFAULT 0 COMMENT '装车数量' NOT NULL;");
      updateSqlList.add("ALTER TABLE project_receiving_record MODIFY column quantity decimal(18,4) DEFAULT 0 COMMENT '收货数量' NOT NULL;");
      updateSqlList.add("ALTER TABLE project_receiving_summary MODIFY column quantity decimal(18,4) DEFAULT 0 COMMENT '收货总数量' NOT NULL;");
      updateSqlList.add("ALTER TABLE project_receiving_summary MODIFY column install_quantity decimal(18,4) DEFAULT 0 COMMENT '已安装总数量' NOT NULL;");
      updateSqlList.add("ALTER TABLE project_install_report MODIFY column report_quantity decimal(18,4) COMMENT '填报数量' NOT NULL;");
      updateSqlList.add("ALTER TABLE project_install_report MODIFY column actual_quantity decimal(18,4) COMMENT '实际数量';");
      updateSqlList.add("ALTER TABLE project_install_summary MODIFY column actual_quantity decimal(18,4) COMMENT '实际数量' NOT NULL;");
      updateSqlList.add("ALTER TABLE project_labor_subsupplier_order_product_link MODIFY column quantity decimal(18,4) COMMENT '数量';");
      updateSqlList.add(
         "ALTER TABLE project_labor_subsupplier_order_product_link MODIFY column actual_quantity decimal(18,4) DEFAULT 0 COMMENT '实际安装数量' NOT NULL;"
      );
      updateSqlList.add("ALTER TABLE mes_building_wip_daily_snapshot MODIFY COLUMN process_list LONGTEXT DEFAULT NULL COMMENT '工序列表';");
      updateSqlList.add("ALTER TABLE mes_building_wip_daily_snapshot MODIFY COLUMN task_details LONGTEXT DEFAULT NULL COMMENT '在制品任务详情列表';");
      updateSqlList.add("ALTER TABLE mes_building_wip_daily_snapshot MODIFY COLUMN task_lists LONGTEXT DEFAULT NULL COMMENT '在制品任务汇总列表';");
      updateSqlList.forEach(this.service::updateSql);
   }
}
