package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.mes.building.core.api.service.initialization.InitializationService;
import com.hzchum.scim.system.core.api.pojo._do.SysProductTraceabilityConfig;
import com.hzchum.scim.system.core.api.pojo._do.User;
import com.hzchum.scim.system.core.api.service.SysProductTraceabilityConfigService;
import com.hzchum.scim.system.core.api.service.UserService;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class SysProductTraceabilityConfigRunner implements CommandLineRunner {
   private final InitializationService initializationService;
   private final SysProductTraceabilityConfigService productTraceabilityConfigService;
   private final UserService userService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      this.initializationService.updateSql("DELETE FROM sys_product_traceability_config WHERE bool_delete_enum = 1;");
      this.initializationService.updateSql("DELETE FROM sys_product_traceability_config_detail WHERE bool_delete_enum = 1;");
      List<SysProductTraceabilityConfig> configs = this.productTraceabilityConfigService
         .list(Wrappers.lambdaQuery(SysProductTraceabilityConfig.builder().boolDefault(true).build()));
      if (configs.isEmpty()) {
         User adminUser = this.userService.getByUsername("admin");
         SysProductTraceabilityConfig config = SysProductTraceabilityConfig.builder()
            .systemName("初呜智造")
            .companyName("杭州初呜建筑科技有限公司")
            .productionBaseName("杭州初呜建筑科技有限公司")
            .boolDefault(true)
            .createUserId(adminUser != null ? adminUser.getId() : 0L)
            .build();
         this.productTraceabilityConfigService.save(config);
      }
   }

   public SysProductTraceabilityConfigRunner(
      final InitializationService initializationService,
      final SysProductTraceabilityConfigService productTraceabilityConfigService,
      final UserService userService
   ) {
      this.initializationService = initializationService;
      this.productTraceabilityConfigService = productTraceabilityConfigService;
      this.userService = userService;
   }
}
