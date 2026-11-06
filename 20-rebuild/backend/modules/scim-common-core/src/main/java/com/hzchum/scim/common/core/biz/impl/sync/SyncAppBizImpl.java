package com.hzchum.scim.common.core.biz.impl.sync;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.util.UUIDUtil;
import com.hzchum.scim.common.core.api.biz.sync.SyncAppBiz;
import com.hzchum.scim.common.core.api.pojo._do.CommonAppKey;
import com.hzchum.scim.common.core.api.service.sync.SyncAppKeyService;
import com.hzchum.scim.common.core.api.service.sync.SyncAppService;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SyncAppBizImpl implements SyncAppBiz {
   @Autowired
   private SyncAppService appService;
   @Autowired
   private SyncAppKeyService appKeyService;
   @Autowired
   private RedisUtils redisUtils;
   private final long TOKEN_EXPIRED_TIME = 7200L;
   private final long CODE_EXPIRED_TIME = 86400L;

   @Override
   public Map<String, Object> getToken(String appKey, String appSecret) {
      CommonAppKey sysAppKey = this.appKeyService.getOne((Wrapper<CommonAppKey>)Wrappers.<CommonAppKey>lambdaQuery().eq(CommonAppKey::getAppKey, appKey));
      Preconditions.checkArgument(sysAppKey != null, "密钥不正确");
      Preconditions.checkArgument(sysAppKey.getAppSecret().equals(appSecret), "密钥不正确");
      return this.getNewToken();
   }

   private Map<String, Object> getNewToken() {
      String refreshToken = UUIDUtil.getUUID();
      String token = UUIDUtil.getUUID();
      Map<String, Object> result = new HashMap<>();
      this.redisUtils.set("sync:common:token" + token, true, 7200L);
      this.redisUtils.set("sync:common:refresh:token" + refreshToken, token, 86400L);
      LocalDateTime now = LocalDateTime.now();
      result.put("token", token);
      result.put("tokenExpired", now.plusSeconds(7200L));
      result.put("refreshToken", refreshToken);
      result.put("refreshTokenExpired", now.plusSeconds(86400L));
      return result;
   }

   @Override
   public Map<String, Object> refreshToken(String code) {
      Object token = this.redisUtils.get("sync:common:refresh:token" + code);
      if (token == null) {
         throw new BusinessException("refreshToken已失效");
      }

      this.redisUtils.del("sync:common:token" + token);
      this.redisUtils.del("sync:common:refresh:token" + code);
      return this.getNewToken();
   }

   @Override
   public Object checkToken(String token) {
      Object value = this.redisUtils.get("sync:common:token" + token);
      if (value == null) {
         throw new BusinessException("token缓存已过期");
      } else {
         return value;
      }
   }
}
