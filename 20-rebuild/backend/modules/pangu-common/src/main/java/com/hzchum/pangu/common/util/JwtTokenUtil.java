package com.hzchum.pangu.common.util;

import com.hzchum.pangu.common.config.JwtProperties;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import com.hzchum.pangu.common.pojo.TokenInfo;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class JwtTokenUtil {
   private static final Logger log = LoggerFactory.getLogger(JwtTokenUtil.class);
   public static final String ACCOUNT_ID = "account_id";
   public static final String USER_ID = "user_id";
   public static final String TENANT_ID = "tenant_id";
   public static final String TENANT_TYPE = "tenant_type";
   public static final String COMPANY_ID = "company_id";
   public static final String EMPLOYEE_ID = "employee_id";
   public static final String LOCAL_CONTEXT_KEY = "token_info";
   public static final String CLAIM_KEY_USERNAME = "sub";
   public static final String IS_ADMIN = "is_admin";
   private JwtProperties jwtProperties;

   public JwtTokenUtil(JwtProperties jwtProperties) {
      this.jwtProperties = jwtProperties;
   }

   public String generateToken(TokenInfo tokenInfo) {
      Map<String, Object> claims = new HashMap<>();
      claims.put("account_id", tokenInfo.getAccountId());
      claims.put("user_id", tokenInfo.getUserId());
      claims.put("tenant_id", tokenInfo.getTenantId());
      claims.put("tenant_type", tokenInfo.getTenantType());
      claims.put("company_id", tokenInfo.getCompanyId());
      claims.put("employee_id", tokenInfo.getEmployeeId());
      claims.put("sub", tokenInfo.getUsername());
      claims.put("is_admin", tokenInfo.getIsAdmin());
      return this.jwtProperties.getSalt() + JwtWrapper.generateToken(claims, this.jwtProperties.getSecret(), this.jwtProperties.getExpiration());
   }

   public TokenInfo parseToken(String token) {
      try {
         Claims claims = JwtWrapper.parsePayload(token, this.jwtProperties.getSecret());
         if (claims == null) {
            return null;
         }

         String username = (String)claims.get("sub");
         Long accountId = (Long)claims.get("account_id");
         Long userId = (Long)claims.get("user_id");
         Long tenantId = (Long)claims.get("tenant_id");
         Integer tenantType = (Integer)claims.get("tenant_type");
         Long companyId = (Long)claims.get("company_id");
         Long employeeId = (Long)claims.get("employee_id");
         Boolean isAdmin = (Boolean)claims.get("is_admin");
         return TokenInfo.builder()
            .username(username)
            .accountId(accountId)
            .userId(userId)
            .tenantId(tenantId)
            .tenantType(tenantType)
            .companyId(companyId)
            .employeeId(employeeId)
            .rawToken(token)
            .isAdmin(isAdmin)
            .build();
      } catch (ExpiredJwtException e) {
         throw new BusinessException(ResultCodeEnum.TOKEN_EXPIRED);
      } catch (BusinessException e) {
         throw e;
      } catch (Exception e) {
         throw new BusinessException(ResultCodeEnum.TOKEN_PARSE_FAILED);
      }
   }

   public String getUsername(String token) {
      return JwtWrapper.parsePayload(token, this.jwtProperties.getSecret()).getSubject();
   }

   public Date getExpiration(String token) {
      return JwtWrapper.parsePayload(token, this.jwtProperties.getSecret()).getExpiration();
   }

   public boolean isTokenExpired(String token) {
      Date expiredDate = this.getExpiration(token);
      return expiredDate.before(new Date());
   }

   public JwtProperties getJwtProperties() {
      return this.jwtProperties;
   }

   public void setJwtProperties(final JwtProperties jwtProperties) {
      this.jwtProperties = jwtProperties;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof JwtTokenUtil)) {
         return false;
      }

      JwtTokenUtil other = (JwtTokenUtil)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$jwtProperties = this.getJwtProperties();
      Object other$jwtProperties = other.getJwtProperties();
      return this$jwtProperties == null ? other$jwtProperties == null : this$jwtProperties.equals(other$jwtProperties);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof JwtTokenUtil;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $jwtProperties = this.getJwtProperties();
      return result * 59 + ($jwtProperties == null ? 43 : $jwtProperties.hashCode());
   }

   @Override
   public String toString() {
      return "JwtTokenUtil(jwtProperties=" + this.getJwtProperties() + ")";
   }
}
