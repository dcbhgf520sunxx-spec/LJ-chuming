package com.hzchum.scim.common.core.api.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "zhongnan.oa")
public class ZhongNanOaProperties {
   private String appId;
   private String host;
   private String secret;
   private String spk;

   public String getAppId() {
      return this.appId;
   }

   public String getHost() {
      return this.host;
   }

   public String getSecret() {
      return this.secret;
   }

   public String getSpk() {
      return this.spk;
   }

   public void setAppId(final String appId) {
      this.appId = appId;
   }

   public void setHost(final String host) {
      this.host = host;
   }

   public void setSecret(final String secret) {
      this.secret = secret;
   }

   public void setSpk(final String spk) {
      this.spk = spk;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ZhongNanOaProperties)) {
         return false;
      }

      ZhongNanOaProperties other = (ZhongNanOaProperties)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$appId = this.getAppId();
      Object other$appId = other.getAppId();
      if (this$appId == null ? other$appId == null : this$appId.equals(other$appId)) {
         Object this$host = this.getHost();
         Object other$host = other.getHost();
         if (this$host == null ? other$host == null : this$host.equals(other$host)) {
            Object this$secret = this.getSecret();
            Object other$secret = other.getSecret();
            if (this$secret == null ? other$secret == null : this$secret.equals(other$secret)) {
               Object this$spk = this.getSpk();
               Object other$spk = other.getSpk();
               return this$spk == null ? other$spk == null : this$spk.equals(other$spk);
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
      return other instanceof ZhongNanOaProperties;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $appId = this.getAppId();
      result = result * 59 + ($appId == null ? 43 : $appId.hashCode());
      Object $host = this.getHost();
      result = result * 59 + ($host == null ? 43 : $host.hashCode());
      Object $secret = this.getSecret();
      result = result * 59 + ($secret == null ? 43 : $secret.hashCode());
      Object $spk = this.getSpk();
      return result * 59 + ($spk == null ? 43 : $spk.hashCode());
   }

   @Override
   public String toString() {
      return "ZhongNanOaProperties(appId=" + this.getAppId() + ", host=" + this.getHost() + ", secret=" + this.getSecret() + ", spk=" + this.getSpk() + ")";
   }
}
