package com.hzchum.pangu.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "chum.qiniu")
@Component
public class QiniuProperties {
   private String accessKey;
   private String secretKey;
   private Long expiration;
   private String privateDomain;
   private String publicDomain;
   private String privateBucketName;
   private String publicBucketName;
   private String callBackUrl;

   public String getAccessKey() {
      return this.accessKey;
   }

   public String getSecretKey() {
      return this.secretKey;
   }

   public Long getExpiration() {
      return this.expiration;
   }

   public String getPrivateDomain() {
      return this.privateDomain;
   }

   public String getPublicDomain() {
      return this.publicDomain;
   }

   public String getPrivateBucketName() {
      return this.privateBucketName;
   }

   public String getPublicBucketName() {
      return this.publicBucketName;
   }

   public String getCallBackUrl() {
      return this.callBackUrl;
   }

   public void setAccessKey(final String accessKey) {
      this.accessKey = accessKey;
   }

   public void setSecretKey(final String secretKey) {
      this.secretKey = secretKey;
   }

   public void setExpiration(final Long expiration) {
      this.expiration = expiration;
   }

   public void setPrivateDomain(final String privateDomain) {
      this.privateDomain = privateDomain;
   }

   public void setPublicDomain(final String publicDomain) {
      this.publicDomain = publicDomain;
   }

   public void setPrivateBucketName(final String privateBucketName) {
      this.privateBucketName = privateBucketName;
   }

   public void setPublicBucketName(final String publicBucketName) {
      this.publicBucketName = publicBucketName;
   }

   public void setCallBackUrl(final String callBackUrl) {
      this.callBackUrl = callBackUrl;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QiniuProperties)) {
         return false;
      }

      QiniuProperties other = (QiniuProperties)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$expiration = this.getExpiration();
      Object other$expiration = other.getExpiration();
      if (this$expiration == null ? other$expiration == null : this$expiration.equals(other$expiration)) {
         Object this$accessKey = this.getAccessKey();
         Object other$accessKey = other.getAccessKey();
         if (this$accessKey == null ? other$accessKey == null : this$accessKey.equals(other$accessKey)) {
            Object this$secretKey = this.getSecretKey();
            Object other$secretKey = other.getSecretKey();
            if (this$secretKey == null ? other$secretKey == null : this$secretKey.equals(other$secretKey)) {
               Object this$privateDomain = this.getPrivateDomain();
               Object other$privateDomain = other.getPrivateDomain();
               if (this$privateDomain == null ? other$privateDomain == null : this$privateDomain.equals(other$privateDomain)) {
                  Object this$publicDomain = this.getPublicDomain();
                  Object other$publicDomain = other.getPublicDomain();
                  if (this$publicDomain == null ? other$publicDomain == null : this$publicDomain.equals(other$publicDomain)) {
                     Object this$privateBucketName = this.getPrivateBucketName();
                     Object other$privateBucketName = other.getPrivateBucketName();
                     if (this$privateBucketName == null ? other$privateBucketName == null : this$privateBucketName.equals(other$privateBucketName)) {
                        Object this$publicBucketName = this.getPublicBucketName();
                        Object other$publicBucketName = other.getPublicBucketName();
                        if (this$publicBucketName == null ? other$publicBucketName == null : this$publicBucketName.equals(other$publicBucketName)) {
                           Object this$callBackUrl = this.getCallBackUrl();
                           Object other$callBackUrl = other.getCallBackUrl();
                           return this$callBackUrl == null ? other$callBackUrl == null : this$callBackUrl.equals(other$callBackUrl);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QiniuProperties;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $expiration = this.getExpiration();
      result = result * 59 + ($expiration == null ? 43 : $expiration.hashCode());
      Object $accessKey = this.getAccessKey();
      result = result * 59 + ($accessKey == null ? 43 : $accessKey.hashCode());
      Object $secretKey = this.getSecretKey();
      result = result * 59 + ($secretKey == null ? 43 : $secretKey.hashCode());
      Object $privateDomain = this.getPrivateDomain();
      result = result * 59 + ($privateDomain == null ? 43 : $privateDomain.hashCode());
      Object $publicDomain = this.getPublicDomain();
      result = result * 59 + ($publicDomain == null ? 43 : $publicDomain.hashCode());
      Object $privateBucketName = this.getPrivateBucketName();
      result = result * 59 + ($privateBucketName == null ? 43 : $privateBucketName.hashCode());
      Object $publicBucketName = this.getPublicBucketName();
      result = result * 59 + ($publicBucketName == null ? 43 : $publicBucketName.hashCode());
      Object $callBackUrl = this.getCallBackUrl();
      return result * 59 + ($callBackUrl == null ? 43 : $callBackUrl.hashCode());
   }

   @Override
   public String toString() {
      return "QiniuProperties(accessKey="
         + this.getAccessKey()
         + ", secretKey="
         + this.getSecretKey()
         + ", expiration="
         + this.getExpiration()
         + ", privateDomain="
         + this.getPrivateDomain()
         + ", publicDomain="
         + this.getPublicDomain()
         + ", privateBucketName="
         + this.getPrivateBucketName()
         + ", publicBucketName="
         + this.getPublicBucketName()
         + ", callBackUrl="
         + this.getCallBackUrl()
         + ")";
   }
}
