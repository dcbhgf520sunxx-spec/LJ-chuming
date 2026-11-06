package com.hzchum.scim.common.core.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "dd")
public class DDProperties {
   private Boolean enable;
   private String appKey;
   private String appSecret;
   private String corpId;
   private String token;
   private String aesKey;

   public Boolean getEnable() {
      return this.enable;
   }

   public String getAppKey() {
      return this.appKey;
   }

   public String getAppSecret() {
      return this.appSecret;
   }

   public String getCorpId() {
      return this.corpId;
   }

   public String getToken() {
      return this.token;
   }

   public String getAesKey() {
      return this.aesKey;
   }

   public void setEnable(final Boolean enable) {
      this.enable = enable;
   }

   public void setAppKey(final String appKey) {
      this.appKey = appKey;
   }

   public void setAppSecret(final String appSecret) {
      this.appSecret = appSecret;
   }

   public void setCorpId(final String corpId) {
      this.corpId = corpId;
   }

   public void setToken(final String token) {
      this.token = token;
   }

   public void setAesKey(final String aesKey) {
      this.aesKey = aesKey;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof DDProperties)) {
         return false;
      }

      DDProperties other = (DDProperties)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$enable = this.getEnable();
      Object other$enable = other.getEnable();
      if (this$enable == null ? other$enable == null : this$enable.equals(other$enable)) {
         Object this$appKey = this.getAppKey();
         Object other$appKey = other.getAppKey();
         if (this$appKey == null ? other$appKey == null : this$appKey.equals(other$appKey)) {
            Object this$appSecret = this.getAppSecret();
            Object other$appSecret = other.getAppSecret();
            if (this$appSecret == null ? other$appSecret == null : this$appSecret.equals(other$appSecret)) {
               Object this$corpId = this.getCorpId();
               Object other$corpId = other.getCorpId();
               if (this$corpId == null ? other$corpId == null : this$corpId.equals(other$corpId)) {
                  Object this$token = this.getToken();
                  Object other$token = other.getToken();
                  if (this$token == null ? other$token == null : this$token.equals(other$token)) {
                     Object this$aesKey = this.getAesKey();
                     Object other$aesKey = other.getAesKey();
                     return this$aesKey == null ? other$aesKey == null : this$aesKey.equals(other$aesKey);
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
      return other instanceof DDProperties;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $enable = this.getEnable();
      result = result * 59 + ($enable == null ? 43 : $enable.hashCode());
      Object $appKey = this.getAppKey();
      result = result * 59 + ($appKey == null ? 43 : $appKey.hashCode());
      Object $appSecret = this.getAppSecret();
      result = result * 59 + ($appSecret == null ? 43 : $appSecret.hashCode());
      Object $corpId = this.getCorpId();
      result = result * 59 + ($corpId == null ? 43 : $corpId.hashCode());
      Object $token = this.getToken();
      result = result * 59 + ($token == null ? 43 : $token.hashCode());
      Object $aesKey = this.getAesKey();
      return result * 59 + ($aesKey == null ? 43 : $aesKey.hashCode());
   }

   @Override
   public String toString() {
      return "DDProperties(enable="
         + this.getEnable()
         + ", appKey="
         + this.getAppKey()
         + ", appSecret="
         + this.getAppSecret()
         + ", corpId="
         + this.getCorpId()
         + ", token="
         + this.getToken()
         + ", aesKey="
         + this.getAesKey()
         + ")";
   }
}
