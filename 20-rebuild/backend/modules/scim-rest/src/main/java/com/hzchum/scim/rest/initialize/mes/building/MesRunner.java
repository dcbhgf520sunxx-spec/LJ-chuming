package com.hzchum.scim.rest.initialize.mes.building;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcess;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.process.MesBuildingProductProcessLink;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProcessService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessLinkService;
import com.hzchum.scim.mes.building.core.api.service.process.MesBuildingProductProcessService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Order(51)
@Component
public class MesRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesRunner.class);
   private final InitializationService service;
   private final MesBuildingProductProcessService productProcessService;
   private final MesBuildingProductProcessLinkService productProcessLinkService;
   private final MesBuildingProcessService processService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) {
      String datasource = this.service.selectSql("SELECT DATABASE()").get(0);
      log.info("初始化发运表和修改表结构开始............................................");
      List<String> resultSql = this.service
         .selectSql(
            "SELECT COLUMN_NAME FROM information_schema.columns\nwhere TABLE_NAME ='mes_building_supplier_price' AND  TABLE_SCHEMA ='" + datasource + "'"
         );
      List<String> updateSqlList = new ArrayList<>();
      if (resultSql.stream().anyMatch("bool_contain_tax_enum"::equals)) {
         updateSqlList.clear();
         updateSqlList.add("UPDATE mes_building_supplier_price SET invoice_type_enum=2 WHERE bool_contain_tax_enum=1;");
         updateSqlList.add("UPDATE mes_building_supplier_price SET invoice_type_enum=1 WHERE bool_contain_tax_enum=0;");
         updateSqlList.add("ALTER TABLE mes_building_supplier_price DROP COLUMN bool_contain_tax_enum;");
         updateSqlList.forEach(this.service::updateSql);
         updateSqlList.clear();
         List<String> selectSqlList = new ArrayList<>();
         selectSqlList.add(
            "SELECT concat('UPDATE mes_building_cargo_list set price_type=',b.price_type,', price=',b.price,', total_price=',a.total_net_weight/1000*b.price,' WHERE id=',a.id,';')\nFROM mes_building_cargo_list a \nLEFT JOIN mes_building_supplier_price b ON a.supplier_price_id=b.id and a.project_id=b.project_id\nWHERE a.transport_mode=1 AND a.structure_measure_mode =1 AND b.price_type=1;"
         );
         selectSqlList.add(
            "SELECT concat('UPDATE mes_building_cargo_list set price_type=',b.price_type,', price=',b.price,', total_price=',a.actual_weight/1000*b.price,' WHERE id=',a.id,';')\nFROM mes_building_cargo_list a \nLEFT JOIN mes_building_supplier_price b ON a.supplier_price_id=b.id and a.project_id=b.project_id\nWHERE a.transport_mode=1 AND a.structure_measure_mode =2 AND b.price_type=1;"
         );
         selectSqlList.add(
            "SELECT concat('UPDATE mes_building_cargo_list set price_type=',b.price_type,', price=',b.price,', total_price=',b.price,' WHERE id=',a.id,';')\nFROM mes_building_cargo_list a \nLEFT JOIN mes_building_supplier_price b ON a.supplier_price_id=b.id and a.project_id=b.project_id\nWHERE a.transport_mode=1  AND b.price_type=2;\n"
         );
         selectSqlList.forEach(e -> updateSqlList.addAll(this.service.selectSql(e)));
         updateSqlList.forEach(this.service::updateSql);
      }

      log.info("初始化发运表和修改表结构结束............................................");
      log.info("5.0升级5.1  处理操作开始----------------------------------------");
      resultSql = this.service
         .selectSql(
            "SELECT COLUMN_NAME FROM information_schema.columns\nwhere TABLE_NAME ='mes_building_product_process' AND  TABLE_SCHEMA ='" + datasource + "'"
         );
      if (resultSql.stream().anyMatch("sequence_type"::equals)) {
         List<MesBuildingProductProcess> ProductProcessList = this.productProcessService
            .selectByType(ProductTypeEnum.ENCLOSURE.getType() | ProductTypeEnum.MACHINE_PART.getType());
         this.productProcessService.removeByIds(ProductProcessList.stream().map(MesBuildingProductProcess::getId).collect(Collectors.toList()));
         if (CollectionUtils.isNotEmpty(ProductProcessList)) {
            List<MesBuildingProductProcessLink> links = this.productProcessLinkService
               .list(
                  (Wrapper<MesBuildingProductProcessLink>)Wrappers.<MesBuildingProductProcessLink>lambdaQuery()
                     .in(
                        MesBuildingProductProcessLink::getProductProcessId,
                        ProductProcessList.stream().map(MesBuildingProductProcess::getId).collect(Collectors.toList())
                     )
               );
            this.productProcessLinkService.removeByIds(links.stream().map(MesBuildingProductProcessLink::getId).collect(Collectors.toList()));
            if (CollectionUtils.isNotEmpty(links)) {
               this.processService.removeByIds(links.stream().map(MesBuildingProductProcessLink::getProcessId).collect(Collectors.toList()));
            }
         }

         this.processService
            .remove((Wrapper<MesBuildingProcess>)Wrappers.<MesBuildingProcess>lambdaQuery().eq(MesBuildingProcess::getProductType, ProductTypeEnum.MACHINE_PART.getType()));
         updateSqlList.clear();
         updateSqlList.add("ALTER TABLE mes_building_process DROP COLUMN type;");
         updateSqlList.add("ALTER TABLE mes_building_process DROP COLUMN sequence_type;");
         updateSqlList.add("ALTER TABLE mes_building_process DROP COLUMN wage_quota_type;");
         updateSqlList.add("ALTER TABLE mes_building_product_process DROP COLUMN sequence_type;");
         updateSqlList.add("ALTER TABLE mes_building_product_process DROP COLUMN alias;");
         updateSqlList.add("ALTER TABLE mes_building_product_process DROP COLUMN name;");
         updateSqlList.add("ALTER TABLE mes_building_product_process DROP COLUMN process_type;");
         updateSqlList.add("ALTER TABLE mes_building_product_process DROP COLUMN bool_enabled_enum;");
         updateSqlList.add("ALTER TABLE mes_building_product_process DROP COLUMN sort;");
         updateSqlList.add("ALTER TABLE mes_building_task DROP COLUMN process_type;");
         updateSqlList.add("ALTER TABLE mes_building_task_process DROP COLUMN process_type;");
         updateSqlList.add("ALTER TABLE mes_building_scheduling DROP COLUMN process_type;");
         updateSqlList.add("ALTER TABLE mes_quality_class_config MODIFY `status` tinyint(1) DEFAULT '1' COMMENT '状态  0未启用 1启用'");
         updateSqlList.add("ALTER TABLE mes_safety_class_config MODIFY `status` tinyint(1) DEFAULT '1' COMMENT '状态  0未启用 1启用'");
         updateSqlList.add("UPDATE mes_building_product_process SET bool_delete_enum=1;");
         updateSqlList.add("UPDATE mes_building_product_process_link SET bool_delete_enum=1;");
         updateSqlList.add("UPDATE mes_building_process SET bool_delete_enum=1 where product_type=1;");
         updateSqlList.add("UPDATE mes_building_process SET bool_delete_enum=1 where product_type=4;");
         updateSqlList.forEach(this.service::updateSql);
      }

      log.info("5.0升级5.1  处理操作结束----------------------------------------");
   }

   public MesRunner(
      final InitializationService service,
      final MesBuildingProductProcessService productProcessService,
      final MesBuildingProductProcessLinkService productProcessLinkService,
      final MesBuildingProcessService processService
   ) {
      this.service = service;
      this.productProcessService = productProcessService;
      this.productProcessLinkService = productProcessLinkService;
      this.processService = processService;
   }
}
