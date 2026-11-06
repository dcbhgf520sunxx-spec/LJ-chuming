package com.hzchum.scim.system.core.security;

import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.util.ResponseUtil;
import java.io.IOException;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {
   @Override
   public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException authException) throws IOException {
      ResponseUtil.render(response, ResultCodeEnum.AUTHENTICATION_FAIL);
   }
}
