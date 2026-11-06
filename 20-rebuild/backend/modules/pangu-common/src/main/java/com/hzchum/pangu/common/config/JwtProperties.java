package com.hzchum.pangu.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "chum.jwt")
@Component
public class JwtProperties {
   private String header = "Authorization";
   private String secret = System.getenv("LJAPS_JWT_SECRET");
   private Long expiration = 86400L;
   private String salt = System.getenv("LJAPS_JWT_SALT");

   public String getHeader() {
      return this.header;
   }

   public String getSecret() {
      return this.secret;
   }

   public Long getExpiration() {
      return this.expiration;
   }

   public String getSalt() {
      return this.salt;
   }

   public void setHeader(final String header) {
      this.header = header;
   }

   public void setSecret(final String secret) {
      this.secret = secret;
   }

   public void setExpiration(final Long expiration) {
      this.expiration = expiration;
   }

   public void setSalt(final String salt) {
      this.salt = salt;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof JwtProperties)) {
         return false;
      }

      JwtProperties other = (JwtProperties)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$expiration = this.getExpiration();
      Object other$expiration = other.getExpiration();
      if (this$expiration == null ? other$expiration == null : this$expiration.equals(other$expiration)) {
         Object this$header = this.getHeader();
         Object other$header = other.getHeader();
         if (this$header == null ? other$header == null : this$header.equals(other$header)) {
            Object this$secret = this.getSecret();
            Object other$secret = other.getSecret();
            if (this$secret == null ? other$secret == null : this$secret.equals(other$secret)) {
               Object this$salt = this.getSalt();
               Object other$salt = other.getSalt();
               return this$salt == null ? other$salt == null : this$salt.equals(other$salt);
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
      return other instanceof JwtProperties;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $expiration = this.getExpiration();
      result = result * 59 + ($expiration == null ? 43 : $expiration.hashCode());
      Object $header = this.getHeader();
      result = result * 59 + ($header == null ? 43 : $header.hashCode());
      Object $secret = this.getSecret();
      result = result * 59 + ($secret == null ? 43 : $secret.hashCode());
      Object $salt = this.getSalt();
      return result * 59 + ($salt == null ? 43 : $salt.hashCode());
   }

   @Override
   public String toString() {
      return "JwtProperties(header="
         + this.getHeader()
         + ", secret="
         + this.getSecret()
         + ", expiration="
         + this.getExpiration()
         + ", salt="
         + this.getSalt()
         + ")";
   }
}
