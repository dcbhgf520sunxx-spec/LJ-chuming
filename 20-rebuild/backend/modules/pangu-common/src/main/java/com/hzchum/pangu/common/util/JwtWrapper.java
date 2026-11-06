package com.hzchum.pangu.common.util;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Date;
import java.util.Map;

public class JwtWrapper {
   public static String generateToken(Map<String, Object> claims, String secret, Long expiration) {
      return Jwts.builder()
         .signWith(SignatureAlgorithm.HS512, secret)
         .setClaims(claims)
         .setIssuer("发行人")
         .setIssuedAt(new Date())
         .setExpiration(new Date(System.currentTimeMillis() + expiration * 1000L))
         .compact();
   }

   public static Claims parsePayload(String jwtToken, String secret) {
      try {
         return Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken).getBody();
      } catch (ExpiredJwtException e) {
         throw new BusinessException(ResultCodeEnum.TOKEN_EXPIRED);
      } catch (BusinessException e) {
         throw e;
      } catch (Exception e) {
         throw new BusinessException(ResultCodeEnum.TOKEN_PARSE_FAILED);
      }
   }
}
