package com.hzchum.scim.rest.runner.crm;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.hzchum.scim.crm.core.api.pojo._do.CrmBusinessLicenseQueryConfig;
import com.hzchum.scim.crm.core.api.service.CrmBusinessLicenseQueryConfigService;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(99)
@Component
public class CrmBusinessLicenseQueryConfigRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(CrmBusinessLicenseQueryConfigRunner.class);
   @Resource
   private CrmBusinessLicenseQueryConfigService crmBusinessLicenseQueryConfigService;

   @Override
   public void run(String... args) throws Exception {
      log.info("crm生成默认查询配置次数开始--------------------");
      List<CrmBusinessLicenseQueryConfig> crmBusinessLicenseQueryConfigs = this.crmBusinessLicenseQueryConfigService.list();
      if (CollectionUtils.isEmpty(crmBusinessLicenseQueryConfigs)) {
         CrmBusinessLicenseQueryConfig crmBusinessLicenseQueryConfig = CrmBusinessLicenseQueryConfig.builder().id(1L).times(10).build();
         this.crmBusinessLicenseQueryConfigService.save(crmBusinessLicenseQueryConfig);
      }

      log.info("crm生成默认查询配置次数结束--------------------");
   }

   public CrmBusinessLicenseQueryConfigRunner(final CrmBusinessLicenseQueryConfigService crmBusinessLicenseQueryConfigService) {
      this.crmBusinessLicenseQueryConfigService = crmBusinessLicenseQueryConfigService;
   }
}
