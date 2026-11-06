package com.hzchum.scim.rest.runner.common;

import com.hzchum.scim.wms.core.api.service.wmsConfig.SteelDensityService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(89)
@Component
public class SteelDensityRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(SteelDensityRunner.class);
   @Resource
   private SteelDensityService steelDensityService;

   @Override
   public void run(String... args) throws Exception {
      log.info("初始化钢材密度信息............................................开始");
      this.steelDensityService.refreshRedisSteelDensity();
      log.info("初始化钢材密度信息............................................结束");
   }

   public SteelDensityRunner(final SteelDensityService steelDensityService) {
      this.steelDensityService = steelDensityService;
   }
}
