package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.bim.core.api.enums.BimImportModeEnum;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelCommonDO;
import com.hzchum.scim.bim.core.api.pojo._do.BimModelConfigurationDO;
import com.hzchum.scim.bim.core.api.service.BimModelCommonService;
import com.hzchum.scim.bim.core.api.service.BimModelConfigurationService;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Order(103)
public class BimConfigInitRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(BimConfigInitRunner.class);
   private final BimModelConfigurationService bimModelConfigurationService;
   private final BimModelCommonService bimModelCommonService;
   private final InitializationService service;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void run(String... strings) {
      log.info("bim模型配置初始化开始............................................");
      List<BimModelCommonDO> bimModelCommonDOList = this.bimModelCommonService.list();
      if (CollectionUtils.isNotEmpty(bimModelCommonDOList)) {
         bimModelCommonDOList.forEach(
            bimModelCommonDO -> {
               BimModelConfigurationDO configurationDO = this.bimModelConfigurationService
                  .getOne((Wrapper<BimModelConfigurationDO>)new LambdaQueryWrapper<BimModelConfigurationDO>().eq(BimModelConfigurationDO::getMonomerId, bimModelCommonDO.getMonomerId()));
               if (configurationDO == null) {
                  BimModelConfigurationDO build = BimModelConfigurationDO.builder()
                     .projectId(bimModelCommonDO.getProjectId())
                     .monomerId(bimModelCommonDO.getMonomerId())
                     .edition(bimModelCommonDO.getEdition())
                     .importMode(BimImportModeEnum.MONOMER_MODE.getType())
                     .build();
                  this.bimModelConfigurationService.save(build);
               }
            }
         );
      }

      String datasource = this.service.selectSql("SELECT DATABASE()").get(0);
      log.info("修改bim表结构开始............................................");
      List<String> updateSqlList = new ArrayList<>();
      List<String> resultSql = this.service
         .selectSql("SELECT COLUMN_NAME FROM information_schema.columns where TABLE_NAME ='bim_model' AND  TABLE_SCHEMA ='" + datasource + "'");
      if (resultSql.contains("file_name")) {
         updateSqlList.add("ALTER TABLE bim_model MODIFY column file_name VARCHAR(64)  DEFAULT NULL;");
      }

      if (resultSql.contains("path")) {
         updateSqlList.add("ALTER TABLE bim_model MODIFY column path VARCHAR(255)  DEFAULT NULL;");
      }

      if (resultSql.contains("create_user_id")) {
         updateSqlList.add("ALTER TABLE bim_model MODIFY column create_user_id bigint(20) DEFAULT NULL;");
      }

      if (resultSql.contains("translate_status")) {
         updateSqlList.add("ALTER TABLE bim_model MODIFY column translate_status char(32) DEFAULT NULL;");
      }

      if (resultSql.contains("edition")) {
         updateSqlList.add("ALTER TABLE bim_model MODIFY column edition bigint(2) DEFAULT NULL;");
      }

      if (resultSql.contains("file_size")) {
         updateSqlList.add("ALTER TABLE bim_model MODIFY column file_size DECIMAL(20,4) DEFAULT '0';");
      }

      updateSqlList.forEach(this.service::updateSql);
      List<BimModelCommonDO> list = this.bimModelCommonService.list(Wrappers.lambdaQuery(BimModelCommonDO.class).isNull(BimModelCommonDO::getFileSize));
      if (CollectionUtils.isNotEmpty(list)) {
         list.forEach(bimModelCommonDO -> {
            bimModelCommonDO.setFileSize(0.0);
            this.bimModelCommonService.updateById(bimModelCommonDO);
         });
      }

      log.info("bim模型配置初始化完成............................................");
   }

   public BimConfigInitRunner(
      final BimModelConfigurationService bimModelConfigurationService, final BimModelCommonService bimModelCommonService, final InitializationService service
   ) {
      this.bimModelConfigurationService = bimModelConfigurationService;
      this.bimModelCommonService = bimModelCommonService;
      this.service = service;
   }
}
