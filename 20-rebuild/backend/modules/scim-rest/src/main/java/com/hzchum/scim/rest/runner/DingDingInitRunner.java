package com.hzchum.scim.rest.runner;

import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.contract.core.api.common.MapConstants;
import com.hzchum.scim.system.core.api.common.enums.ApproveProcessTypeEnum;
import com.hzchum.scim.system.core.api.common.utils.DingDingUtils;
import com.hzchum.scim.system.core.api.service.ApproveProcessService;
import com.hzchum.scim.system.core.api.service.UserService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.annotation.Transactional;

@Order(6)
public class DingDingInitRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(DingDingInitRunner.class);
   private final ConfigProperties configProperties;
   private final ApproveProcessService approveProcessService;
   private final UserService userService;

   @Transactional(rollbackFor = TransactionException.class)
   @Override
   public void run(String... args) {
      if (this.configProperties.getEnable() != null && this.configProperties.getEnable()) {
         this.dingDingInit();
      }
   }

   private void dingDingInit() {
      log.info("钉钉token初始化开始............................................");
      if (StringUtils.isNotBlank(this.configProperties.getDdAppKey()) && StringUtils.isNotBlank(this.configProperties.getDdAppSecret())) {
         String token = DingDingUtils.getAccessToken(this.configProperties.getDdAppKey(), this.configProperties.getDdAppSecret());
         if (token != null) {
            log.info("钉钉token:" + token);
            MapConstants.getStringConstantsMap().put("ddAccessToken", token);
         }
      } else {
         log.info("token初始化失败，密钥缺失");
      }

      log.info("钉钉token初始化结束............................................");
      log.info("钉钉审批初始化开始............................................");
      if (this.configProperties.getEnable() != null) {
         if (this.configProperties.getEnable()) {
            if (DingDingUtils.getCallBack()) {
               DingDingUtils.deleteCallBack();
            }

            DingDingUtils.callBackRegisterCallBack(this.configProperties);

            for (ApproveProcessTypeEnum value : ApproveProcessTypeEnum.values()) {
               this.approveProcessService.create(value);
            }
         }

         this.userService.initDDUser();
         log.info("钉钉审批初始化结束............................................");
      }
   }

   public DingDingInitRunner(final ConfigProperties configProperties, final ApproveProcessService approveProcessService, final UserService userService) {
      this.configProperties = configProperties;
      this.approveProcessService = approveProcessService;
      this.userService = userService;
   }
}
