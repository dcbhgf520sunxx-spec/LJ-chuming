package com.hzchum.scim.rest.runner;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.scim.system.core.api.pojo._do.KitWmsCommonConfigDTO;
import com.hzchum.scim.system.core.api.pojo._do.KitWmsConfigurationDetailDTO;
import com.hzchum.scim.system.core.api.pojo._do.SysKitWmsCommonConfig;
import com.hzchum.scim.system.core.api.service.SysKitWmsCommonConfigService;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(100)
@Component
public class SysKitWmsCommonConfigRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(SysKitWmsCommonConfigRunner.class);
   private final SysKitWmsCommonConfigService kitWmsAssociationsConfigurationService;

   @Override
   public void run(String... args) throws Exception {
      SysKitWmsCommonConfig associationsConfiguration = this.kitWmsAssociationsConfigurationService
         .getOne((Wrapper<SysKitWmsCommonConfig>)new LambdaQueryWrapper<SysKitWmsCommonConfig>().eq(SysKitWmsCommonConfig::getBoolGeneralConfig, Boolean.TRUE));
      if (associationsConfiguration == null) {
         SysKitWmsCommonConfig inventoryConfig = SysKitWmsCommonConfig.builder().boolGeneralConfig(Boolean.TRUE).value(null).build();
         List<KitWmsConfigurationDetailDTO> inventoryConfigurationDetailDTOS = new ArrayList<>();
         KitWmsCommonConfigDTO configurationDTO = KitWmsCommonConfigDTO.builder().boolGeneralConfig(Boolean.TRUE).build();
         KitWmsConfigurationDetailDTO configurationDetailDTO = new KitWmsConfigurationDetailDTO();
         inventoryConfigurationDetailDTOS.add(configurationDetailDTO);
         configurationDTO.setDetailList(inventoryConfigurationDetailDTOS);
         inventoryConfig.setValue(JSON.toJSONString(configurationDTO));
         this.kitWmsAssociationsConfigurationService.save(inventoryConfig);
      }
   }

   public SysKitWmsCommonConfigRunner(final SysKitWmsCommonConfigService kitWmsAssociationsConfigurationService) {
      this.kitWmsAssociationsConfigurationService = kitWmsAssociationsConfigurationService;
   }
}
