package com.hzchum.scim.rest.runner;

import com.hzchum.scim.contract.core.api.biz.ContractProjectBiz;
import com.hzchum.scim.contract.core.api.pojo._do.ContractProjectContent;
import com.hzchum.scim.contract.core.api.pojo.dto.response.ProjectSimpleInfoDTO;
import com.hzchum.scim.contract.core.api.service.ContractProjectContentService;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Order(101)
public class ProjectSimpleInfoRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ProjectSimpleInfoRunner.class);
   @Resource
   private ContractProjectBiz projectBiz;
   @Resource
   private RedisUtils redisUtils;
   @Resource
   private ContractProjectContentService projectContentService;
   @Resource
   private InitializationService service;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      log.info("初始化项目列表开始............................................");
      this.redisUtils.del("project_content_list");
      List<ContractProjectContent> projectContentList = this.projectContentService.list();
      this.redisUtils.set("project_content_list", projectContentList);
      this.redisUtils.del("simpleProjectList");
      List<ProjectSimpleInfoDTO> projectSimpleInfoDTOS = this.projectBiz.listAllProjectSimple();
      this.redisUtils.set("simpleProjectList", projectSimpleInfoDTOS);
      log.info("初始化项目列表结束............................................");
      log.info("修改联营板项目表开始............................................");
      List<String> updateSqlList = new ArrayList<>();
      updateSqlList.add("UPDATE contract_project cp SET cp.contract_sign_body_scale = 100, cp.project_manager_scale = 0 WHERE cp.project_attribute = 1;");
      updateSqlList.add("UPDATE contract_project cp SET cp.contract_sign_body_scale = 0, cp.project_manager_scale = 100 WHERE cp.project_attribute = 3;");
      updateSqlList.add("UPDATE contract_project cp SET cp.contract_sign_body_amount = 0 WHERE cp.contract_sign_body_amount IS NULL;");
      updateSqlList.add("UPDATE contract_project cp SET cp.project_manager_amount = 0 WHERE cp.project_manager_amount IS NULL;");
      updateSqlList.add("UPDATE contract_project cp SET cp.collection_summary = 0 WHERE cp.collection_summary IS NULL;");
      updateSqlList.add(
         "UPDATE contract_project cp SET cp.project_manager_id = cp.sales_leader_id WHERE cp.project_attribute = 2 AND cp.project_manager_id IS NULL;"
      );
      updateSqlList.add("ALTER TABLE contract_project MODIFY COLUMN contract_sign_body_amount DECIMAL(32,4) DEFAULT 0.0 NOT NULL COMMENT '签订主体结余'");
      updateSqlList.add("ALTER TABLE contract_project MODIFY COLUMN project_manager_amount DECIMAL(32,4) DEFAULT 0.0 NOT NULL COMMENT '项目经理结余'");
      updateSqlList.add("ALTER TABLE contract_project MODIFY COLUMN collection_summary DECIMAL(32,4) DEFAULT 0.0 NOT NULL COMMENT '项目总结余'");
      updateSqlList.add("ALTER TABLE contract_supplier_payment MODIFY COLUMN approval_serial_number VARCHAR(255) COMMENT '审批流水号'");
      updateSqlList.forEach(this.service::updateSql);
      log.info("修改联营板项目表结束............................................");
   }
}
