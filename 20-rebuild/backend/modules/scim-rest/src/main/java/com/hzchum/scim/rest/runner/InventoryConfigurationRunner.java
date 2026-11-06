package com.hzchum.scim.rest.runner;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.hzchum.scim.mes.building.core.api.enums.ProductTypeEnum;
import com.hzchum.scim.system.core.api.pojo._do.SysInventoryConfiguration;
import com.hzchum.scim.system.core.api.pojo.dto.InventoryConfigurationDTO;
import com.hzchum.scim.system.core.api.pojo.dto.InventoryConfigurationDetailDTO;
import com.hzchum.scim.system.core.api.service.SysInventoryConfigurationService;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(99)
@Component
public class InventoryConfigurationRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(InventoryConfigurationRunner.class);
   private final SysInventoryConfigurationService inventoryConfigurationService;

   @Override
   public void run(String... args) throws Exception {
      SysInventoryConfiguration inventoryConfiguration = this.inventoryConfigurationService
         .getOne((Wrapper<SysInventoryConfiguration>)new LambdaQueryWrapper<SysInventoryConfiguration>().eq(SysInventoryConfiguration::getBoolGeneralConfig, Boolean.TRUE));
      if (inventoryConfiguration == null) {
         SysInventoryConfiguration inventoryConfig = SysInventoryConfiguration.builder().boolGeneralConfig(Boolean.TRUE).value(null).build();
         List<Integer> productTypeList = Arrays.asList(
            ProductTypeEnum.ARTIFACT.getType(), ProductTypeEnum.ASSEMBLE.getType(), ProductTypeEnum.MACHINE_PART.getType()
         );
         List<InventoryConfigurationDetailDTO> inventoryConfigurationDetailDTOS = new ArrayList<>();
         InventoryConfigurationDTO configurationDTO = InventoryConfigurationDTO.builder().boolGeneralConfig(Boolean.TRUE).build();

         for (Integer productType : productTypeList) {
            InventoryConfigurationDetailDTO configurationDetailDTO = InventoryConfigurationDetailDTO.builder()
               .productType(productType)
               .width(BigDecimal.ZERO)
               .length(BigDecimal.ZERO)
               .grossWeight(BigDecimal.ZERO)
               .thickness(BigDecimal.ZERO)
               .surfaceArea(BigDecimal.ZERO)
               .netWeight(BigDecimal.ZERO)
               .build();
            inventoryConfigurationDetailDTOS.add(configurationDetailDTO);
         }

         configurationDTO.setDetailDTOList(inventoryConfigurationDetailDTOS);
         inventoryConfig.setValue(JSON.toJSONString(configurationDTO));
         this.inventoryConfigurationService.save(inventoryConfig);
      }
   }

   public InventoryConfigurationRunner(final SysInventoryConfigurationService inventoryConfigurationService) {
      this.inventoryConfigurationService = inventoryConfigurationService;
   }
}
