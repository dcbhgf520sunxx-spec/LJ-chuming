package com.hzchum.scim.common.core.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "wechat.app")
public class WeChatAppConfigProperties {
   private String endpoint;
   private String appid;
   private String secret;

   public String getEndpoint() {
      return this.endpoint;
   }

   public String getAppid() {
      return this.appid;
   }

   public String getSecret() {
      return this.secret;
   }

   public void setEndpoint(final String endpoint) {
      this.endpoint = endpoint;
   }

   public void setAppid(final String appid) {
      this.appid = appid;
   }

   public void setSecret(final String secret) {
      this.secret = secret;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WeChatAppConfigProperties)) {
         return false;
      }

      WeChatAppConfigProperties other = (WeChatAppConfigProperties)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$endpoint = this.getEndpoint();
      Object other$endpoint = other.getEndpoint();
      if (this$endpoint == null ? other$endpoint == null : this$endpoint.equals(other$endpoint)) {
         Object this$appid = this.getAppid();
         Object other$appid = other.getAppid();
         if (this$appid == null ? other$appid == null : this$appid.equals(other$appid)) {
            Object this$secret = this.getSecret();
            Object other$secret = other.getSecret();
            return this$secret == null ? other$secret == null : this$secret.equals(other$secret);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WeChatAppConfigProperties;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $endpoint = this.getEndpoint();
      result = result * 59 + ($endpoint == null ? 43 : $endpoint.hashCode());
      Object $appid = this.getAppid();
      result = result * 59 + ($appid == null ? 43 : $appid.hashCode());
      Object $secret = this.getSecret();
      return result * 59 + ($secret == null ? 43 : $secret.hashCode());
   }

   @Override
   public String toString() {
      return "WeChatAppConfigProperties(endpoint=" + this.getEndpoint() + ", appid=" + this.getAppid() + ", secret=" + this.getSecret() + ")";
   }
}
