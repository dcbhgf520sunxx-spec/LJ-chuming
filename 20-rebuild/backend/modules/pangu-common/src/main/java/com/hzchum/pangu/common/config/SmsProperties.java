package com.hzchum.pangu.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "chum.sms")
@Component
public class SmsProperties {
   private String accessKeyId = System.getenv("LJAPS_SMS_ACCESS_KEY_ID");
   private String accessKeySecret = System.getenv("LJAPS_SMS_ACCESS_KEY_SECRET");
   public String signName = "初鸣智建";
   public String signTitle = "初鸣筑迈汇";

   public String getAccessKeyId() {
      return this.accessKeyId;
   }

   public String getAccessKeySecret() {
      return this.accessKeySecret;
   }

   public String getSignName() {
      return this.signName;
   }

   public String getSignTitle() {
      return this.signTitle;
   }

   public void setAccessKeyId(final String accessKeyId) {
      this.accessKeyId = accessKeyId;
   }

   public void setAccessKeySecret(final String accessKeySecret) {
      this.accessKeySecret = accessKeySecret;
   }

   public void setSignName(final String signName) {
      this.signName = signName;
   }

   public void setSignTitle(final String signTitle) {
      this.signTitle = signTitle;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SmsProperties)) {
         return false;
      }

      SmsProperties other = (SmsProperties)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$accessKeyId = this.getAccessKeyId();
      Object other$accessKeyId = other.getAccessKeyId();
      if (this$accessKeyId == null ? other$accessKeyId == null : this$accessKeyId.equals(other$accessKeyId)) {
         Object this$accessKeySecret = this.getAccessKeySecret();
         Object other$accessKeySecret = other.getAccessKeySecret();
         if (this$accessKeySecret == null ? other$accessKeySecret == null : this$accessKeySecret.equals(other$accessKeySecret)) {
            Object this$signName = this.getSignName();
            Object other$signName = other.getSignName();
            if (this$signName == null ? other$signName == null : this$signName.equals(other$signName)) {
               Object this$signTitle = this.getSignTitle();
               Object other$signTitle = other.getSignTitle();
               return this$signTitle == null ? other$signTitle == null : this$signTitle.equals(other$signTitle);
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
      return other instanceof SmsProperties;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $accessKeyId = this.getAccessKeyId();
      result = result * 59 + ($accessKeyId == null ? 43 : $accessKeyId.hashCode());
      Object $accessKeySecret = this.getAccessKeySecret();
      result = result * 59 + ($accessKeySecret == null ? 43 : $accessKeySecret.hashCode());
      Object $signName = this.getSignName();
      result = result * 59 + ($signName == null ? 43 : $signName.hashCode());
      Object $signTitle = this.getSignTitle();
      return result * 59 + ($signTitle == null ? 43 : $signTitle.hashCode());
   }

   @Override
   public String toString() {
      return "SmsProperties(accessKeyId="
         + this.getAccessKeyId()
         + ", accessKeySecret="
         + this.getAccessKeySecret()
         + ", signName="
         + this.getSignName()
         + ", signTitle="
         + this.getSignTitle()
         + ")";
   }
}
