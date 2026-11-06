package com.hzchum.scim.rest.runner;

import com.hzchum.scim.system.core.api.pojo._doModel.system.SysHomeEnableConfig;
import com.hzchum.scim.system.core.api.service.SysHomeEnableConfigService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(100)
@Component
public class SysHomeEnableConfigRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(SysHomeEnableConfigRunner.class);
   @Resource
   private SysHomeEnableConfigService sysHomeEnableConfigService;

   @Override
   public void run(String... args) throws Exception {
      log.info("门户是否开启正在配置中-----------");
      SysHomeEnableConfig sysHomeEnableConfig = this.sysHomeEnableConfigService.getById(1L);
      if (sysHomeEnableConfig == null) {
         this.sysHomeEnableConfigService.save(SysHomeEnableConfig.builder().id(1L).isEnable(Boolean.FALSE).build());
      }

      log.info("门户是否开启配置结束-----------");
   }

   public SysHomeEnableConfigRunner(final SysHomeEnableConfigService sysHomeEnableConfigService) {
      this.sysHomeEnableConfigService = sysHomeEnableConfigService;
   }
}
