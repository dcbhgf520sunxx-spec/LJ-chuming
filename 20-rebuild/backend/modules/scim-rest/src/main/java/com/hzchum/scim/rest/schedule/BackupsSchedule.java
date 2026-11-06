package com.hzchum.scim.rest.schedule;

import com.baomidou.dynamic.datasource.spring.boot.autoconfigure.DynamicDataSourceProperties;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.common.core.api.service.BackupsService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class BackupsSchedule {
   private static final Logger log = LoggerFactory.getLogger(BackupsSchedule.class);
   @Resource
   BackupsService backupsService;
   private final DynamicDataSourceProperties properties;
   @Resource
   private ConfigProperties configProperties;

   @Scheduled(cron = "0 0 1 * * ?")
   public void task() {
      if (this.configProperties.getBackupsData()) {
         log.info("-----------------  Mysql数据备份  start -----------------");
         this.backupsService.mysqlBackups(this.configProperties.getBackupsNumber(), this.configProperties.getFilePath(), this.properties.getDatasource());
         log.info("----------------- Mysql数据备份 end -----------------");
      }
   }

   public BackupsSchedule(final BackupsService backupsService, final DynamicDataSourceProperties properties, final ConfigProperties configProperties) {
      this.backupsService = backupsService;
      this.properties = properties;
      this.configProperties = configProperties;
   }
}
