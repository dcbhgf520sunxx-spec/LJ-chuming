package com.hzchum.scim.common.core.api.config;

import com.hzchum.scim.common.core.api.utils.GdMapUtils;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "gdmap.keys")
public class GdMapConfigProperties {
   private String webMapKey;
   private String webJsMapKey;
   private String webJsMapKeySecret;
   private String androidMapKey;
   private String iosMapKey;
   private String weChatMapKey;

   @Bean
   public GdMapUtils creatGdMapUtils() {
      return new GdMapUtils(this.webMapKey, this.webJsMapKey, this.webJsMapKeySecret, this.androidMapKey, this.iosMapKey, this.weChatMapKey);
   }

   public String getWebMapKey() {
      return this.webMapKey;
   }

   public String getWebJsMapKey() {
      return this.webJsMapKey;
   }

   public String getWebJsMapKeySecret() {
      return this.webJsMapKeySecret;
   }

   public String getAndroidMapKey() {
      return this.androidMapKey;
   }

   public String getIosMapKey() {
      return this.iosMapKey;
   }

   public String getWeChatMapKey() {
      return this.weChatMapKey;
   }

   public void setWebMapKey(final String webMapKey) {
      this.webMapKey = webMapKey;
   }

   public void setWebJsMapKey(final String webJsMapKey) {
      this.webJsMapKey = webJsMapKey;
   }

   public void setWebJsMapKeySecret(final String webJsMapKeySecret) {
      this.webJsMapKeySecret = webJsMapKeySecret;
   }

   public void setAndroidMapKey(final String androidMapKey) {
      this.androidMapKey = androidMapKey;
   }

   public void setIosMapKey(final String iosMapKey) {
      this.iosMapKey = iosMapKey;
   }

   public void setWeChatMapKey(final String weChatMapKey) {
      this.weChatMapKey = weChatMapKey;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof GdMapConfigProperties)) {
         return false;
      }

      GdMapConfigProperties other = (GdMapConfigProperties)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$webMapKey = this.getWebMapKey();
      Object other$webMapKey = other.getWebMapKey();
      if (this$webMapKey == null ? other$webMapKey == null : this$webMapKey.equals(other$webMapKey)) {
         Object this$webJsMapKey = this.getWebJsMapKey();
         Object other$webJsMapKey = other.getWebJsMapKey();
         if (this$webJsMapKey == null ? other$webJsMapKey == null : this$webJsMapKey.equals(other$webJsMapKey)) {
            Object this$webJsMapKeySecret = this.getWebJsMapKeySecret();
            Object other$webJsMapKeySecret = other.getWebJsMapKeySecret();
            if (this$webJsMapKeySecret == null ? other$webJsMapKeySecret == null : this$webJsMapKeySecret.equals(other$webJsMapKeySecret)) {
               Object this$androidMapKey = this.getAndroidMapKey();
               Object other$androidMapKey = other.getAndroidMapKey();
               if (this$androidMapKey == null ? other$androidMapKey == null : this$androidMapKey.equals(other$androidMapKey)) {
                  Object this$iosMapKey = this.getIosMapKey();
                  Object other$iosMapKey = other.getIosMapKey();
                  if (this$iosMapKey == null ? other$iosMapKey == null : this$iosMapKey.equals(other$iosMapKey)) {
                     Object this$weChatMapKey = this.getWeChatMapKey();
                     Object other$weChatMapKey = other.getWeChatMapKey();
                     return this$weChatMapKey == null ? other$weChatMapKey == null : this$weChatMapKey.equals(other$weChatMapKey);
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof GdMapConfigProperties;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $webMapKey = this.getWebMapKey();
      result = result * 59 + ($webMapKey == null ? 43 : $webMapKey.hashCode());
      Object $webJsMapKey = this.getWebJsMapKey();
      result = result * 59 + ($webJsMapKey == null ? 43 : $webJsMapKey.hashCode());
      Object $webJsMapKeySecret = this.getWebJsMapKeySecret();
      result = result * 59 + ($webJsMapKeySecret == null ? 43 : $webJsMapKeySecret.hashCode());
      Object $androidMapKey = this.getAndroidMapKey();
      result = result * 59 + ($androidMapKey == null ? 43 : $androidMapKey.hashCode());
      Object $iosMapKey = this.getIosMapKey();
      result = result * 59 + ($iosMapKey == null ? 43 : $iosMapKey.hashCode());
      Object $weChatMapKey = this.getWeChatMapKey();
      return result * 59 + ($weChatMapKey == null ? 43 : $weChatMapKey.hashCode());
   }

   @Override
   public String toString() {
      return "GdMapConfigProperties(webMapKey="
         + this.getWebMapKey()
         + ", webJsMapKey="
         + this.getWebJsMapKey()
         + ", webJsMapKeySecret="
         + this.getWebJsMapKeySecret()
         + ", androidMapKey="
         + this.getAndroidMapKey()
         + ", iosMapKey="
         + this.getIosMapKey()
         + ", weChatMapKey="
         + this.getWeChatMapKey()
         + ")";
   }
}
