package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.system.core.api.common.enums.StatisticsConfigStatisticsModeEnum;
import com.hzchum.scim.system.core.api.pojo._do.MesStatisticsModeConfig;
import com.hzchum.scim.system.core.api.service.MesStatisticsModeConfigService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(101)
@Component
public class MesContractProjectWageConfigRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(MesContractProjectWageConfigRunner.class);
   @Resource
   private MesStatisticsModeConfigService statisticsModeConfigService;

   @Override
   public void run(String... args) throws Exception {
      log.info("项目工价配置开始...........................................");
      int count = this.statisticsModeConfigService.count(Wrappers.emptyWrapper());
      if (count == 0) {
         MesStatisticsModeConfig statisticsModeConfig = MesStatisticsModeConfig.builder()
            .mode(StatisticsConfigStatisticsModeEnum.STORAGE_RETRODICT_MODE.getType())
            .build();
         this.statisticsModeConfigService.save(statisticsModeConfig);
      }

      log.info("项目工价配置完毕...........................................");
   }
}
