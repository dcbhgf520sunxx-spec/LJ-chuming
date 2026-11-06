package com.hzchum.scim.rest.runner.common;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.ObjectUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.hzchum.scim.common.core.api.pojo._do.CommonApp;
import com.hzchum.scim.common.core.api.pojo._do.CommonAppKey;
import com.hzchum.scim.common.core.api.service.CommonAppKeyService;
import com.hzchum.scim.common.core.api.service.CommonAppService;
import java.util.List;
import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Order(150)
@Component
public class CommonAppRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(CommonAppRunner.class);
   @Resource
   private CommonAppService commonAppService;
   @Resource
   private CommonAppKeyService commonAppKeyService;

   @Override
   public void run(String... args) throws Exception {
      List<CommonApp> commonApps = this.commonAppService.list();
      List<CommonAppKey> appKeyList = this.commonAppKeyService.list();
      if (CollectionUtils.isEmpty(commonApps)) {
         CommonApp commonApp = CommonApp.builder().name("物联").remark("物联使用").build();
         this.commonAppService.save(commonApp);
      }

      if (CollectionUtils.isEmpty(appKeyList)) {
         CommonAppKey commonAppKey = CommonAppKey.builder()
            .appId(1L)
            .appKey(requiredEnvironment("LJAPS_COMMON_IOT_APP_KEY"))
            .appSecret(requiredEnvironment("LJAPS_COMMON_IOT_APP_SECRET"))
            .build();
         this.commonAppKeyService.save(commonAppKey);
      }

      CommonApp commonApp = this.commonAppService.getOne(Wrappers.lambdaQuery(CommonApp.class).eq(CommonApp::getName, "中南OA"));
      if (ObjectUtils.isEmpty(commonApp)) {
         CommonApp zhongNanCommonApp = CommonApp.builder().name("中南OA").remark("中南OA回调使用").build();
         this.commonAppService.save(zhongNanCommonApp);
      }

      CommonAppKey zhongNnaAppKey = this.commonAppKeyService.getOne(Wrappers.lambdaQuery(CommonAppKey.class).eq(CommonAppKey::getAppId, 2L));
      if (ObjectUtils.isEmpty(zhongNnaAppKey)) {
         CommonAppKey commonAppKey = CommonAppKey.builder()
            .appId(2L)
            .appKey(requiredEnvironment("LJAPS_COMMON_OA_APP_KEY"))
            .appSecret(requiredEnvironment("LJAPS_COMMON_OA_APP_SECRET"))
            .build();
         this.commonAppKeyService.save(commonAppKey);
      }
   }

   private static String requiredEnvironment(String name) {
      String value = System.getenv(name);
      if (value == null || value.trim().isEmpty()) throw new IllegalStateException(name + " is required for explicit legacy initialization");
      return value;
   }

   public CommonAppRunner(final CommonAppService commonAppService, final CommonAppKeyService commonAppKeyService) {
      this.commonAppService = commonAppService;
      this.commonAppKeyService = commonAppKeyService;
   }
}
