package com.hzchum.scim.rest.runner.contract;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProject;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectTemp;
import com.hzchum.scim.contract.core.api.service.ContractProjectService;
import com.hzchum.scim.contract.core.api.service.ContractProjectTempService;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class ProjectRunner implements CommandLineRunner {
   private final ContractProjectService projectService;
   private final ContractProjectTempService projectTempService;
   private final UserService userService;
   private final InitializationService service;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      List<String> sql = new ArrayList<>(16);
      sql.add("ALTER TABLE contract_project MODIFY COLUMN name VARCHAR(128) COMMENT '项目名称';");
      sql.add("ALTER TABLE contract_project MODIFY COLUMN short_name VARCHAR(64) COMMENT '项目简称';");
      sql.add("ALTER TABLE contract_project MODIFY COLUMN serial_number VARCHAR(64) COMMENT '项目编号';");
      sql.add("ALTER TABLE contract_project MODIFY COLUMN country_name VARCHAR(16) COMMENT '国家名称';");
      sql.add("ALTER TABLE contract_project MODIFY COLUMN province_name VARCHAR(16) COMMENT '省名';");
      sql.add("ALTER TABLE contract_project MODIFY COLUMN city_name VARCHAR(16) COMMENT '市名';");
      sql.add("ALTER TABLE contract_project MODIFY COLUMN region_name VARCHAR(16) COMMENT '区县名';");
      sql.add("ALTER TABLE contract_project MODIFY COLUMN margin_type VARCHAR(16) COMMENT '保证金类型';");
      sql.add("ALTER TABLE contract_project MODIFY COLUMN currency_type VARCHAR(16) COMMENT '合同币种类型';");
      sql.add("ALTER TABLE contract_project MODIFY COLUMN customer_country_name VARCHAR(16) COMMENT '客户单位国家名称';");
      sql.add("ALTER TABLE contract_project MODIFY COLUMN customer_province_name VARCHAR(16) COMMENT '客户单位省名称';");
      sql.add("ALTER TABLE contract_project MODIFY COLUMN customer_city_name VARCHAR(16) COMMENT '客户单位城市名称';");
      sql.add("ALTER TABLE contract_project MODIFY COLUMN customer_region_name VARCHAR(16) COMMENT '客户单位国家名称';");
      sql.add("ALTER TABLE contract_project_temp MODIFY COLUMN name VARCHAR(128) COMMENT '项目名称';");
      sql.add("ALTER TABLE contract_project_temp MODIFY COLUMN short_name VARCHAR(64) COMMENT '项目简称';");
      sql.add("ALTER TABLE contract_project_temp MODIFY COLUMN serial_number VARCHAR(64) COMMENT '项目编号';");
      sql.add("ALTER TABLE contract_project_temp MODIFY COLUMN country_name VARCHAR(16) COMMENT '国家名称';");
      sql.add("ALTER TABLE contract_project_temp MODIFY COLUMN province_name VARCHAR(16) COMMENT '省名';");
      sql.add("ALTER TABLE contract_project_temp MODIFY COLUMN city_name VARCHAR(16) COMMENT '市名';");
      sql.add("ALTER TABLE contract_project_temp MODIFY COLUMN region_name VARCHAR(16) COMMENT '区县名';");
      sql.add("ALTER TABLE contract_project_temp MODIFY COLUMN margin_type VARCHAR(16) COMMENT '保证金类型';");
      sql.add("ALTER TABLE contract_project_temp MODIFY COLUMN currency_type VARCHAR(16) COMMENT '合同币种类型';");
      sql.add("ALTER TABLE contract_project_temp MODIFY COLUMN customer_country_name VARCHAR(16) COMMENT '客户单位国家名称';");
      sql.add("ALTER TABLE contract_project_temp MODIFY COLUMN customer_province_name VARCHAR(16) COMMENT '客户单位省名称';");
      sql.add("ALTER TABLE contract_project_temp MODIFY COLUMN customer_city_name VARCHAR(16) COMMENT '客户单位城市名称';");
      sql.add("ALTER TABLE contract_project_temp MODIFY COLUMN customer_region_name VARCHAR(16) COMMENT '客户单位国家名称';");
      sql.forEach(this.service::updateSql);
      String datasource = this.service.selectSql("SELECT DATABASE()").get(0);
      List<String> columnList = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='contract_project' AND TABLE_SCHEMA ='" + datasource + "'");
      if (!columnList.contains("signer_phone")) {
         this.service.updateSql("ALTER TABLE contract_project add COLUMN signer_phone VARCHAR(16) COMMENT '签约人(销售负责人)电话';");
      }

      if (!columnList.contains("project_manager_name")) {
         this.service.updateSql("ALTER TABLE contract_project add COLUMN project_manager_name VARCHAR(16) COMMENT '项目经理名称';");
      }

      if (!columnList.contains("project_manager_phone")) {
         this.service.updateSql("ALTER TABLE contract_project add COLUMN project_manager_phone VARCHAR(16) COMMENT '项目经理电话';");
      }

      columnList = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='contract_project_temp' AND TABLE_SCHEMA ='" + datasource + "'");
      if (columnList.contains("signer_phone")) {
         this.service.updateSql("ALTER TABLE contract_project_temp MODIFY COLUMN signer_phone VARCHAR(16) COMMENT '签约人(销售负责人)电话';");
      } else {
         this.service.updateSql("ALTER TABLE contract_project_temp add COLUMN signer_phone VARCHAR(16) COMMENT '签约人(销售负责人)电话';");
      }

      if (!columnList.contains("project_manager_name")) {
         this.service.updateSql("ALTER TABLE contract_project_temp add COLUMN project_manager_name VARCHAR(16) COMMENT '项目经理名称';");
      }

      if (!columnList.contains("project_manager_phone")) {
         this.service.updateSql("ALTER TABLE contract_project_temp add COLUMN project_manager_phone VARCHAR(16) COMMENT '项目经理电话';");
      }

      this.service.updateSql("ALTER TABLE contract_project_temp MODIFY COLUMN contract_amount DECIMAL(18,8) DEFAULT 0.0 COMMENT '合同额';");
      Map<Long, User> userMap = this.userService.list().stream().collect(Collectors.toMap(User::getId, Function.identity()));
      List<ContractProject> projectList = this.projectService.list();
      Map<Long, ContractProject> updateContractMap = new HashMap<>(projectList.size());
      projectList.forEach(project -> {
         if (project.getSignerId() != null) {
            User user = userMap.get(project.getSignerId());
            if (user != null) {
               project.setSignerPhone(user.getPhone());
               updateContractMap.put(project.getId(), project);
            }
         }

         if (project.getProjectManagerId() != null) {
            User user = userMap.get(project.getProjectManagerId());
            if (user != null) {
               project.setProjectManagerName(user.getName());
               project.setProjectManagerPhone(user.getPhone());
               updateContractMap.put(project.getId(), project);
            }
         }
      });
      if (CollectionUtils.isNotEmpty(updateContractMap)) {
         this.projectService.updateBatchById(updateContractMap.values());
      }

      List<ContractProjectTemp> projectTempList = this.projectTempService.list();
      Map<Long, ContractProjectTemp> updateContractTempMap = new HashMap<>(projectTempList.size());
      projectTempList.forEach(projectTemp -> {
         if (projectTemp.getSignerId() != null) {
            User user = userMap.get(projectTemp.getSignerId());
            if (user != null) {
               projectTemp.setSignerName(user.getName());
               projectTemp.setSignerPhone(user.getPhone());
               updateContractTempMap.put(projectTemp.getId(), projectTemp);
            }
         }

         if (projectTemp.getProjectManagerId() != null) {
            User user = userMap.get(projectTemp.getProjectManagerId());
            if (user != null) {
               projectTemp.setProjectManagerName(user.getName());
               projectTemp.setProjectManagerPhone(user.getPhone());
               updateContractTempMap.put(projectTemp.getId(), projectTemp);
            }
         }
      });
      if (CollectionUtils.isNotEmpty(updateContractTempMap)) {
         this.projectTempService.updateBatchById(updateContractTempMap.values());
      }
   }

   public ProjectRunner(
      final ContractProjectService projectService,
      final ContractProjectTempService projectTempService,
      final UserService userService,
      final InitializationService service
   ) {
      this.projectService = projectService;
      this.projectTempService = projectTempService;
      this.userService = userService;
      this.service = service;
   }
}
