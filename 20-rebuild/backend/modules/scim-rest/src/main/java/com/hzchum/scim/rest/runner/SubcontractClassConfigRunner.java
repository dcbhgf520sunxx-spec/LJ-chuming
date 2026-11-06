package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.scm.core.api.pojo._do.SubcontractClassConfig;
import com.hzchum.scim.scm.core.api.service.SubcontractClassConfigService;
import javax.annotation.Resource;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
@Order(120)
public class SubcontractClassConfigRunner implements CommandLineRunner {
   @Resource
   private SubcontractClassConfigService subcontractClassConfigService;

   @Transactional(rollbackFor = Exception.class)
   @Override
   public void run(String... args) throws Exception {
      SubcontractClassConfig subcontractClassConfig = this.subcontractClassConfigService
         .getOne(Wrappers.lambdaQuery(SubcontractClassConfig.class).eq(SubcontractClassConfig::getName, "劳务分包"));
      if (subcontractClassConfig == null) {
         subcontractClassConfig = SubcontractClassConfig.builder().name("劳务分包").build();
         this.subcontractClassConfigService.save(subcontractClassConfig);
      }
   }
}
