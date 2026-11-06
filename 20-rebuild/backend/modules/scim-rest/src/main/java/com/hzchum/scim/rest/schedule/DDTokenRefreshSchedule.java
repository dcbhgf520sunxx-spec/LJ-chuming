package com.hzchum.scim.rest.schedule;

import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.contract.core.api.common.MapConstants;
import com.hzchum.scim.system.core.api.common.utils.DingDingUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class DDTokenRefreshSchedule {
   private static final Logger LOGGER = LoggerFactory.getLogger(DDTokenRefreshSchedule.class);
   private final ConfigProperties configProperties;

   @Scheduled(cron = "0 0 0/1 * * ?")
   public void sendMsg() {
      LOGGER.info("Ding Ding Token Refresh Start !!!!!");
      if (StringUtils.isNotBlank(this.configProperties.getDdAppKey()) && StringUtils.isNotBlank(this.configProperties.getDdAppSecret())) {
         String token = DingDingUtils.getToken(this.configProperties.getDdAppKey(), this.configProperties.getDdAppSecret());
         MapConstants.getStringConstantsMap().put("ddAccessToken", token);
         LOGGER.info("钉钉token:" + token);
      } else {
         LOGGER.info("token初始化失败，密钥缺失");
      }

      LOGGER.info("Ding Ding Token Refresh End !!!!!");
   }

   public DDTokenRefreshSchedule(final ConfigProperties configProperties) {
      this.configProperties = configProperties;
   }
}
