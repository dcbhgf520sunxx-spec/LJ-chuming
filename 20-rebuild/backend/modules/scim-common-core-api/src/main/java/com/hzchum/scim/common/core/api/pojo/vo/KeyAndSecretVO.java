package com.hzchum.scim.common.core.api.pojo.vo;

public class KeyAndSecretVO {
   private String key;
   private String secret;

   KeyAndSecretVO(final String key, final String secret) {
      this.key = key;
      this.secret = secret;
   }

   public static KeyAndSecretVO.KeyAndSecretVOBuilder builder() {
      return new KeyAndSecretVO.KeyAndSecretVOBuilder();
   }

   public String getKey() {
      return this.key;
   }

   public String getSecret() {
      return this.secret;
   }

   public void setKey(final String key) {
      this.key = key;
   }

   public void setSecret(final String secret) {
      this.secret = secret;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof KeyAndSecretVO)) {
         return false;
      } else {
         KeyAndSecretVO other = (KeyAndSecretVO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$key = this.getKey();
            Object other$key = other.getKey();
            if (this$key == null ? other$key == null : this$key.equals(other$key)) {
               Object this$secret = this.getSecret();
               Object other$secret = other.getSecret();
               return this$secret == null ? other$secret == null : this$secret.equals(other$secret);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof KeyAndSecretVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $key = this.getKey();
      result = result * 59 + ($key == null ? 43 : $key.hashCode());
      Object $secret = this.getSecret();
      return result * 59 + ($secret == null ? 43 : $secret.hashCode());
   }

   @Override
   public String toString() {
      return "KeyAndSecretVO(key=" + this.getKey() + ", secret=" + this.getSecret() + ")";
   }

   public static class KeyAndSecretVOBuilder {
      private String key;
      private String secret;

      KeyAndSecretVOBuilder() {
      }

      public KeyAndSecretVO.KeyAndSecretVOBuilder key(final String key) {
         this.key = key;
         return this;
      }

      public KeyAndSecretVO.KeyAndSecretVOBuilder secret(final String secret) {
         this.secret = secret;
         return this;
      }

      public KeyAndSecretVO build() {
         return new KeyAndSecretVO(this.key, this.secret);
      }

      @Override
      public String toString() {
         return "KeyAndSecretVO.KeyAndSecretVOBuilder(key=" + this.key + ", secret=" + this.secret + ")";
      }
   }
}
