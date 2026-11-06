package com.hzchum.scim.common.core.api.biz;

import java.util.Map;

public interface CommonTokenBiz {
   Map<String, Object> getToken(String appKey, String appSecret);

   Map<String, Object> refreshToken(String code);

   void checkToken(String token);
}
