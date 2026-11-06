package com.hzchum.scim.rest.runner;

import cn.hutool.json.JSONUtil;
import com.hzchum.scim.system.core.api.enums.CappWeldingCraftUsageModeEnum;
import com.hzchum.scim.system.core.api.pojo._do.Config;
import com.hzchum.scim.system.core.api.pojo.dto.config.CappWeldingCraftConfigDTO;
import com.hzchum.scim.system.core.api.service.ConfigService;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CappConfigRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(CappConfigRunner.class);
   @Resource
   private ConfigService configService;

   @Override
   public void run(String... args) throws Exception {
      Config byCode = this.configService.getByCode("CAPP_WELDING_CRAFT");
      if (byCode == null) {
         CappWeldingCraftConfigDTO dto = new CappWeldingCraftConfigDTO();
         dto.setUsageMode(CappWeldingCraftUsageModeEnum.INDEPENDENT_MANIFESTATION.getUsageMode());
         dto.setAcquisitionFrequency(30L);
         byCode = Config.builder().code("CAPP_WELDING_CRAFT").name("焊接工艺配置").value(JSONUtil.toJsonStr(dto)).build();
         this.configService.save(byCode);
      }
   }
}
