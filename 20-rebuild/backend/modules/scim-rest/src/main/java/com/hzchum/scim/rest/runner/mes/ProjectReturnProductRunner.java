package com.hzchum.scim.rest.runner.mes;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.common.core.api.enums.AuditStatusEnum;
import com.hzchum.scim.common.core.api.enums.WasteHandleMethodEnum;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReturnProductChild;
import com.hzchum.scim.project.core.api.pojo._do.ProjectReturnProductMain;
import com.hzchum.scim.project.core.api.pojo._do.ProjectWasteProductChild;
import com.hzchum.scim.project.core.api.pojo._do.ProjectWasteProductMain;
import com.hzchum.scim.project.core.api.service.ProjectReturnProductChildService;
import com.hzchum.scim.project.core.api.service.ProjectReturnProductMainService;
import com.hzchum.scim.project.core.api.service.ProjectWasteProductChildService;
import com.hzchum.scim.project.core.api.service.ProjectWasteProductMainService;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProjectReturnProductRunner implements CommandLineRunner {
   private final ProjectReturnProductChildService projectReturnProductChildService;
   private final ProjectReturnProductMainService projectReturnProductMainService;
   private final ProjectWasteProductChildService projectWasteProductChildService;
   private final ProjectWasteProductMainService projectWasteProductMainService;
   private final InitializationService service;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      String datasource = this.service.selectSql("SELECT DATABASE()").get(0);
      List<String> columnNameList = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='project_waste_product_child' AND TABLE_SCHEMA ='" + datasource + "'");
      if (columnNameList.contains("serial_number")) {
         String sql = "ALTER TABLE project_waste_product_child MODIFY COLUMN serial_number VARCHAR (128) COMMENT '编号'  DEFAULT NULL;";
         this.service.updateSql(sql);
      }

      if (columnNameList.contains("unit_price")) {
         String sql = "ALTER TABLE project_waste_product_child MODIFY COLUMN unit_price decimal (32,8) COMMENT '单价'  DEFAULT NULL;";
         this.service.updateSql(sql);
      }

      if (columnNameList.contains("monomer_id")) {
         String sql = "ALTER TABLE project_waste_product_child MODIFY COLUMN monomer_id bigint (20) COMMENT '单体id'  DEFAULT NULL;";
         this.service.updateSql(sql);
      }

      if (columnNameList.contains("area_id")) {
         String sql = "ALTER TABLE project_waste_product_child MODIFY COLUMN area_id bigint (20) COMMENT '区域id'  DEFAULT NULL;";
         this.service.updateSql(sql);
      }

      if (columnNameList.contains("quantity")) {
         String sql = "ALTER TABLE project_waste_product_child MODIFY COLUMN quantity decimal (18,4) COMMENT '数量' NOT NULL;";
         this.service.updateSql(sql);
      }

      columnNameList = this.service
         .selectSql(
            "SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='project_return_product_child' AND TABLE_SCHEMA ='" + datasource + "'"
         );
      if (columnNameList.contains("serial_number")) {
         String sql = "ALTER TABLE project_return_product_child MODIFY COLUMN serial_number VARCHAR (128) COMMENT '编号'  DEFAULT NULL;";
         this.service.updateSql(sql);
      }

      if (columnNameList.contains("unit_price")) {
         String sql = "ALTER TABLE project_return_product_child MODIFY COLUMN unit_price decimal (32,8) COMMENT '单价'  DEFAULT NULL;";
         this.service.updateSql(sql);
      }

      if (columnNameList.contains("monomer_id")) {
         String sql = "ALTER TABLE project_return_product_child MODIFY COLUMN monomer_id bigint (20) COMMENT '单体id'  DEFAULT NULL;";
         this.service.updateSql(sql);
      }

      if (columnNameList.contains("area_id")) {
         String sql = "ALTER TABLE project_return_product_child MODIFY COLUMN area_id bigint (20) COMMENT '区域id'  DEFAULT NULL;";
         this.service.updateSql(sql);
      }

      if (columnNameList.contains("product_name")) {
         String sql = "ALTER TABLE project_return_product_child MODIFY COLUMN product_name varchar (128) COMMENT '产品名称'  DEFAULT NULL;";
         this.service.updateSql(sql);
      }

      if (columnNameList.contains("specification")) {
         String sql = "ALTER TABLE project_return_product_child MODIFY COLUMN specification varchar (128) COMMENT '规格'  DEFAULT NULL;";
         this.service.updateSql(sql);
      }

      if (columnNameList.contains("quantity")) {
         String sql = "ALTER TABLE project_return_product_child MODIFY COLUMN quantity decimal (18,4) COMMENT '数量' NOT NULL;";
         this.service.updateSql(sql);
      }

      if (columnNameList.contains("reuse_quantity")) {
         String sql = "ALTER TABLE project_return_product_child MODIFY COLUMN reuse_quantity decimal (18,4) default 0 COMMENT '二次利用数量' NOT NULL;";
         this.service.updateSql(sql);
      }

      if (columnNameList.contains("waste_sale_quantity")) {
         String sql = "ALTER TABLE project_return_product_child MODIFY COLUMN waste_sale_quantity decimal (18,4) default 0 COMMENT '废品出售数量' NOT NULL;";
         this.service.updateSql(sql);
      }

      columnNameList = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='project_return_product_main' AND TABLE_SCHEMA ='" + datasource + "'");
      if (columnNameList.contains("quantity")) {
         String sql = "ALTER TABLE project_return_product_main MODIFY COLUMN quantity decimal (18,4) COMMENT '数量' NOT NULL;";
         this.service.updateSql(sql);
      }

      columnNameList = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='project_waste_product_main' AND TABLE_SCHEMA ='" + datasource + "'");
      if (columnNameList.contains("quantity")) {
         String sql = "ALTER TABLE project_waste_product_main MODIFY COLUMN quantity decimal (18,4) COMMENT '数量' NOT NULL;";
         this.service.updateSql(sql);
      }

      List<ProjectReturnProductChild> productChildList = this.projectReturnProductChildService
         .list(Wrappers.lambdaQuery(ProjectReturnProductChild.class).eq(ProjectReturnProductChild::getHandleMethod, 0));
      if (CollectionUtils.isNotEmpty(productChildList)) {
         List<ProjectWasteProductMain> wasteProductMainList = this.projectWasteProductMainService
            .list(Wrappers.lambdaQuery(ProjectWasteProductMain.class).eq(ProjectWasteProductMain::getWasteHandleMethod, 0));
         wasteProductMainList.forEach(
            wasteProductMain -> wasteProductMain.setWasteHandleMethod(
               wasteProductMain.getHandleMethod().equals(2) ? WasteHandleMethodEnum.REUSE.getType() : WasteHandleMethodEnum.WASTE_SALE.getType()
            )
         );
         this.projectWasteProductMainService.updateBatchById(wasteProductMainList);
         Map<Long, ProjectWasteProductMain> projectWasteProductMainMap = wasteProductMainList.stream()
            .collect(Collectors.toMap(ProjectWasteProductMain::getId, Function.identity()));
         List<ProjectWasteProductChild> wasteProductChildList = this.projectWasteProductChildService
            .list(
               Wrappers.lambdaQuery(ProjectWasteProductChild.class)
                  .eq(
                     ProjectWasteProductChild::getMesBuildingReturnWarehouseRecordId,
                     productChildList.stream().map(ProjectReturnProductChild::getId).collect(Collectors.toList())
                  )
            );
         wasteProductChildList.forEach(wasteProductChild -> {
            ProjectWasteProductMain wasteProductMain = projectWasteProductMainMap.get(wasteProductChild.getMainId());
            wasteProductChild.setAuditStatus(wasteProductMain.getAuditStatus());
            wasteProductChild.setAuditTime(wasteProductMain.getAuditTime());
            wasteProductChild.setWasteHandleMethod(wasteProductMain.getWasteHandleMethod());
         });
         this.projectWasteProductChildService.updateBatchById(wasteProductChildList);
         List<ProjectReturnProductMain> productMainList = this.projectReturnProductMainService
            .listByIds(productChildList.stream().map(ProjectReturnProductChild::getMainId).collect(Collectors.toSet()));
         Map<Long, ProjectReturnProductMain> productMainMap = productMainList.stream()
            .collect(Collectors.toMap(ProjectReturnProductMain::getId, Function.identity()));
         Map<Long, Map<Integer, BigDecimal>> returnChildIdWasteHandleMethodQuantityMap = wasteProductChildList.stream()
            .filter(s -> s.getAuditStatus().equals(AuditStatusEnum.AUDITING.getType()) || s.getAuditStatus().equals(AuditStatusEnum.SUCCEED.getType()))
            .collect(
               Collectors.groupingBy(
                  ProjectWasteProductChild::getMesBuildingReturnWarehouseRecordId,
                  Collectors.groupingBy(
                     ProjectWasteProductChild::getWasteHandleMethod,
                     Collectors.reducing(BigDecimal.ZERO, ProjectWasteProductChild::getQuantity, BigDecimal::add)
                  )
               )
            );
         productChildList.forEach(
            child -> {
               BigDecimal reuseQuantity = returnChildIdWasteHandleMethodQuantityMap.getOrDefault(child.getId(), Collections.emptyMap())
                  .getOrDefault(WasteHandleMethodEnum.REUSE.getType(), BigDecimal.ZERO);
               BigDecimal wasteSaleQuantity = returnChildIdWasteHandleMethodQuantityMap.getOrDefault(child.getId(), Collections.emptyMap())
                  .getOrDefault(WasteHandleMethodEnum.WASTE_SALE.getType(), BigDecimal.ZERO);
               ProjectReturnProductMain productMain = productMainMap.get(child.getMainId());
               child.setHandleMethod(productMain != null ? productMain.getHandleMethod() : null);
               child.setAuditStatus(productMain != null ? productMain.getAuditStatus() : null);
               child.setAuditTime(productMain != null ? productMain.getAuditTime() : null);
               child.setReuseQuantity(reuseQuantity);
               child.setWasteSaleQuantity(wasteSaleQuantity);
            }
         );
         this.projectReturnProductChildService.updateBatchById(productChildList);
      }
   }

   public ProjectReturnProductRunner(
      final ProjectReturnProductChildService projectReturnProductChildService,
      final ProjectReturnProductMainService projectReturnProductMainService,
      final ProjectWasteProductChildService projectWasteProductChildService,
      final ProjectWasteProductMainService projectWasteProductMainService,
      final InitializationService service
   ) {
      this.projectReturnProductChildService = projectReturnProductChildService;
      this.projectReturnProductMainService = projectReturnProductMainService;
      this.projectWasteProductChildService = projectWasteProductChildService;
      this.projectWasteProductMainService = projectWasteProductMainService;
      this.service = service;
   }
}
