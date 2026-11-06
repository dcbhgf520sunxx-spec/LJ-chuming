package com.hzchum.scim.common.core.api.utils;

import com.hzchum.scim.common.core.api.enums.GdKeyTypeMapEnum;
import com.hzchum.scim.common.core.api.pojo.vo.KeyAndSecretVO;

public class GdMapUtils {
   private static String WEB_MAP_KEY;
   private static String WEB_JS_MAP_KEY;
   private static String WEB_JS_MAP_KEY_SECRET;
   private static String ANDROID_MAP_KEY;
   private static String IOS_MAP_KEY;
   private static String WE_CHAT_KEY;

   public GdMapUtils(String webMapKey, String webJsMapKey, String webJsMapKeySecret, String androidMapKey, String iosMapKey, String weChatMapKey) {
      WEB_MAP_KEY = webMapKey;
      WEB_JS_MAP_KEY = webJsMapKey;
      WEB_JS_MAP_KEY_SECRET = webJsMapKeySecret;
      ANDROID_MAP_KEY = androidMapKey;
      IOS_MAP_KEY = androidMapKey;
      WE_CHAT_KEY = weChatMapKey;
   }

   public static KeyAndSecretVO getKeyByType(Integer type) {
      if (type.equals(GdKeyTypeMapEnum.WEB.getType())) {
         return KeyAndSecretVO.builder().key(WEB_MAP_KEY).build();
      } else if (type.equals(GdKeyTypeMapEnum.JS.getType())) {
         return KeyAndSecretVO.builder().key(WEB_JS_MAP_KEY).secret(WEB_JS_MAP_KEY_SECRET).build();
      } else if (type.equals(GdKeyTypeMapEnum.ANDROID.getType())) {
         return KeyAndSecretVO.builder().key(ANDROID_MAP_KEY).build();
      } else if (type.equals(GdKeyTypeMapEnum.IOS.getType())) {
         return KeyAndSecretVO.builder().key(IOS_MAP_KEY).build();
      } else {
         return type.equals(GdKeyTypeMapEnum.WE_CHAT.getType()) ? KeyAndSecretVO.builder().key(WE_CHAT_KEY).build() : null;
      }
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof GdMapUtils)) {
         return false;
      }

      GdMapUtils other = (GdMapUtils)o;
      return other.canEqual(this);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof GdMapUtils;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "GdMapUtils()";
   }
}
