package com.hzchum.scim.rest.runner;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.pangu.common.util.AESUtils;
import com.hzchum.scim.system.core.api.pojo._do.Config;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(1)
@Component
public class ExpireConfigRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(ExpireConfigRunner.class);
   private final ConfigService configService;

   @Override
   public void run(String... args) throws Exception {
      log.info("服务过期时间配置信息初始化开始............................................");
      Config config = this.configService.getOne((Wrapper<Config>)new LambdaQueryWrapper<Config>().eq(Config::getCode, "SERVER_EXPIRE_DATE"));
      if (Objects.isNull(config)) {
         Config saveConfig = new Config();
         saveConfig.setCode("SERVER_EXPIRE_DATE");
         saveConfig.setName("系统时间配置");
         saveConfig.setValue(AESUtils.encrypt(System.getenv("LJAPS_SERVER_CONFIG_AES_KEY"), "2200-01-01 00:00:00"));
         this.configService.save(saveConfig);
      } else if (StrUtil.isBlank(config.getValue())) {
         config.setValue(AESUtils.encrypt(System.getenv("LJAPS_SERVER_CONFIG_AES_KEY"), "2200-01-01 00:00:00"));
         this.configService.updateById(config);
      }

      log.info("服务过期时间配置信息初始化结束............................................");
   }

   public ExpireConfigRunner(final ConfigService configService) {
      this.configService = configService;
   }
}
