package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.scim.system.core.api.common.enums.SystemChargingMethodEnum;
import com.hzchum.scim.system.core.api.pojo._do.Config;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SystemChargingMethodConfigRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(SystemChargingMethodConfigRunner.class);
   private final ConfigService configService;

   @Override
   public void run(String... args) throws Exception {
      log.info("系统收费方式配置初始化开始............................................");
      Config config = this.configService.getOne((Wrapper<Config>)new LambdaQueryWrapper<Config>().eq(Config::getCode, "SYSTEM_CHARGING_METHOD"));
      if (Objects.isNull(config)) {
         Config saveConfig = new Config();
         saveConfig.setCode("SYSTEM_CHARGING_METHOD");
         saveConfig.setName("系统收费方式");
         saveConfig.setValue(SystemChargingMethodEnum.MAINTENANCE_FEE.getType());
         this.configService.save(saveConfig);
      }

      log.info("系统收费方式配置初始化结束............................................");
   }

   public SystemChargingMethodConfigRunner(final ConfigService configService) {
      this.configService = configService;
   }
}
