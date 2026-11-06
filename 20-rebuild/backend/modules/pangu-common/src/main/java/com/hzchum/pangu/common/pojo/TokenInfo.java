package com.hzchum.pangu.common.pojo;

import java.io.Serializable;

public class TokenInfo implements Serializable {
   private static final long serialVersionUID = -3142317132556927073L;
   private Long accountId;
   private Long tenantId;
   private Long userId;
   private String username;
   private Integer tenantType;
   private Long companyId;
   private Long employeeId;
   private String rawToken;
   private Boolean isAdmin;

   public static TokenInfo.TokenInfoBuilder builder() {
      return new TokenInfo.TokenInfoBuilder();
   }

   public Long getAccountId() {
      return this.accountId;
   }

   public Long getTenantId() {
      return this.tenantId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUsername() {
      return this.username;
   }

   public Integer getTenantType() {
      return this.tenantType;
   }

   public Long getCompanyId() {
      return this.companyId;
   }

   public Long getEmployeeId() {
      return this.employeeId;
   }

   public String getRawToken() {
      return this.rawToken;
   }

   public Boolean getIsAdmin() {
      return this.isAdmin;
   }

   public void setAccountId(final Long accountId) {
      this.accountId = accountId;
   }

   public void setTenantId(final Long tenantId) {
      this.tenantId = tenantId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUsername(final String username) {
      this.username = username;
   }

   public void setTenantType(final Integer tenantType) {
      this.tenantType = tenantType;
   }

   public void setCompanyId(final Long companyId) {
      this.companyId = companyId;
   }

   public void setEmployeeId(final Long employeeId) {
      this.employeeId = employeeId;
   }

   public void setRawToken(final String rawToken) {
      this.rawToken = rawToken;
   }

   public void setIsAdmin(final Boolean isAdmin) {
      this.isAdmin = isAdmin;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TokenInfo)) {
         return false;
      }

      TokenInfo other = (TokenInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$accountId = this.getAccountId();
      Object other$accountId = other.getAccountId();
      if (this$accountId == null ? other$accountId == null : this$accountId.equals(other$accountId)) {
         Object this$tenantId = this.getTenantId();
         Object other$tenantId = other.getTenantId();
         if (this$tenantId == null ? other$tenantId == null : this$tenantId.equals(other$tenantId)) {
            Object this$userId = this.getUserId();
            Object other$userId = other.getUserId();
            if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
               Object this$tenantType = this.getTenantType();
               Object other$tenantType = other.getTenantType();
               if (this$tenantType == null ? other$tenantType == null : this$tenantType.equals(other$tenantType)) {
                  Object this$companyId = this.getCompanyId();
                  Object other$companyId = other.getCompanyId();
                  if (this$companyId == null ? other$companyId == null : this$companyId.equals(other$companyId)) {
                     Object this$employeeId = this.getEmployeeId();
                     Object other$employeeId = other.getEmployeeId();
                     if (this$employeeId == null ? other$employeeId == null : this$employeeId.equals(other$employeeId)) {
                        Object this$isAdmin = this.getIsAdmin();
                        Object other$isAdmin = other.getIsAdmin();
                        if (this$isAdmin == null ? other$isAdmin == null : this$isAdmin.equals(other$isAdmin)) {
                           Object this$username = this.getUsername();
                           Object other$username = other.getUsername();
                           if (this$username == null ? other$username == null : this$username.equals(other$username)) {
                              Object this$rawToken = this.getRawToken();
                              Object other$rawToken = other.getRawToken();
                              return this$rawToken == null ? other$rawToken == null : this$rawToken.equals(other$rawToken);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TokenInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $accountId = this.getAccountId();
      result = result * 59 + ($accountId == null ? 43 : $accountId.hashCode());
      Object $tenantId = this.getTenantId();
      result = result * 59 + ($tenantId == null ? 43 : $tenantId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $tenantType = this.getTenantType();
      result = result * 59 + ($tenantType == null ? 43 : $tenantType.hashCode());
      Object $companyId = this.getCompanyId();
      result = result * 59 + ($companyId == null ? 43 : $companyId.hashCode());
      Object $employeeId = this.getEmployeeId();
      result = result * 59 + ($employeeId == null ? 43 : $employeeId.hashCode());
      Object $isAdmin = this.getIsAdmin();
      result = result * 59 + ($isAdmin == null ? 43 : $isAdmin.hashCode());
      Object $username = this.getUsername();
      result = result * 59 + ($username == null ? 43 : $username.hashCode());
      Object $rawToken = this.getRawToken();
      return result * 59 + ($rawToken == null ? 43 : $rawToken.hashCode());
   }

   @Override
   public String toString() {
      return "TokenInfo(accountId="
         + this.getAccountId()
         + ", tenantId="
         + this.getTenantId()
         + ", userId="
         + this.getUserId()
         + ", username="
         + this.getUsername()
         + ", tenantType="
         + this.getTenantType()
         + ", companyId="
         + this.getCompanyId()
         + ", employeeId="
         + this.getEmployeeId()
         + ", rawToken="
         + this.getRawToken()
         + ", isAdmin="
         + this.getIsAdmin()
         + ")";
   }

   public TokenInfo(
      final Long accountId,
      final Long tenantId,
      final Long userId,
      final String username,
      final Integer tenantType,
      final Long companyId,
      final Long employeeId,
      final String rawToken,
      final Boolean isAdmin
   ) {
      this.accountId = accountId;
      this.tenantId = tenantId;
      this.userId = userId;
      this.username = username;
      this.tenantType = tenantType;
      this.companyId = companyId;
      this.employeeId = employeeId;
      this.rawToken = rawToken;
      this.isAdmin = isAdmin;
   }

   public static class TokenInfoBuilder {
      private Long accountId;
      private Long tenantId;
      private Long userId;
      private String username;
      private Integer tenantType;
      private Long companyId;
      private Long employeeId;
      private String rawToken;
      private Boolean isAdmin;

      TokenInfoBuilder() {
      }

      public TokenInfo.TokenInfoBuilder accountId(final Long accountId) {
         this.accountId = accountId;
         return this;
      }

      public TokenInfo.TokenInfoBuilder tenantId(final Long tenantId) {
         this.tenantId = tenantId;
         return this;
      }

      public TokenInfo.TokenInfoBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TokenInfo.TokenInfoBuilder username(final String username) {
         this.username = username;
         return this;
      }

      public TokenInfo.TokenInfoBuilder tenantType(final Integer tenantType) {
         this.tenantType = tenantType;
         return this;
      }

      public TokenInfo.TokenInfoBuilder companyId(final Long companyId) {
         this.companyId = companyId;
         return this;
      }

      public TokenInfo.TokenInfoBuilder employeeId(final Long employeeId) {
         this.employeeId = employeeId;
         return this;
      }

      public TokenInfo.TokenInfoBuilder rawToken(final String rawToken) {
         this.rawToken = rawToken;
         return this;
      }

      public TokenInfo.TokenInfoBuilder isAdmin(final Boolean isAdmin) {
         this.isAdmin = isAdmin;
         return this;
      }

      public TokenInfo build() {
         return new TokenInfo(
            this.accountId, this.tenantId, this.userId, this.username, this.tenantType, this.companyId, this.employeeId, this.rawToken, this.isAdmin
         );
      }

      @Override
      public String toString() {
         return "TokenInfo.TokenInfoBuilder(accountId="
            + this.accountId
            + ", tenantId="
            + this.tenantId
            + ", userId="
            + this.userId
            + ", username="
            + this.username
            + ", tenantType="
            + this.tenantType
            + ", companyId="
            + this.companyId
            + ", employeeId="
            + this.employeeId
            + ", rawToken="
            + this.rawToken
            + ", isAdmin="
            + this.isAdmin
            + ")";
      }
   }
}
