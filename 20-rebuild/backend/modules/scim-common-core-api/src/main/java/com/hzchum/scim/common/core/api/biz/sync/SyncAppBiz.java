package com.hzchum.scim.common.core.api.biz.sync;

import java.util.Map;

public interface SyncAppBiz {
   Map<String, Object> getToken(String appKey, String appSecret);

   Map<String, Object> refreshToken(String code);

   Object checkToken(String token);
}
