package com.hzchum.scim.system.core.security;

import com.hzchum.pangu.common.config.JwtProperties;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.util.JwtTokenUtil;
import com.hzchum.pangu.common.util.ResponseUtil;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import java.io.IOException;
import java.util.Objects;
import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.filter.OncePerRequestFilter;

public class JwtAuthenticationTokenFilter extends OncePerRequestFilter {
   public static final Logger LOGGER = LoggerFactory.getLogger(JwtAuthenticationTokenFilter.class);
   @Resource
   private UserDetailsService userDetailsService;
   @Autowired
   private JwtTokenUtil jwtTokenUtil;
   @Autowired
   private JwtProperties jwtProperties;

   @Override
   protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
      String authHeader = request.getHeader(this.jwtProperties.getHeader());
      if (Objects.nonNull(authHeader) && authHeader.startsWith(this.jwtProperties.getSalt())) {
         String authToken = authHeader.substring(this.jwtProperties.getSalt().length());

         String username;
         try {
            username = this.jwtTokenUtil.getUsername(authToken);
         } catch (Exception e) {
            ResponseUtil.render(response, ResultCodeEnum.TOKEN_DIRTY);
            this.logger.info("token解析失败或过期");
            return;
         }

         LOGGER.info("checking authentication {}", username);
         SecurityUser securityUser = (SecurityUser)this.userDetailsService.loadUserByUsername(username);
         if (!securityUser.getIsEnabled()) {
            ResponseUtil.render(response, ResultCodeEnum.ACCOUNT_DISABLED_ERROR.getMessage());
         }

         if (Objects.nonNull(username) && SecurityContextHolder.getContext().getAuthentication() == null && !this.jwtTokenUtil.isTokenExpired(authToken)) {
            UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(securityUser, null, securityUser.getAuthorities());
            authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authentication);
         }

         request.setAttribute("user", securityUser);
      }

      chain.doFilter(request, response);
   }

   @Override
   protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {
      return new AntPathMatcher().match("/", request.getServletPath())
         || new AntPathMatcher().match("/static/", request.getServletPath())
         || new AntPathMatcher().match("/api/user/login", request.getServletPath())
         || new AntPathMatcher().match("/api/user/login/sub", request.getServletPath())
         || new AntPathMatcher().match("/api/structures/structure-stat/actions/list", request.getServletPath())
         || new AntPathMatcher().match("/files/**", request.getServletPath())
         || new AntPathMatcher().match("/bim/ws/**", request.getServletPath())
         || new AntPathMatcher().match("/api/user/verifyCode", request.getServletPath())
         || new AntPathMatcher().match("/api/user/app/verifyCode", request.getServletPath())
         || new AntPathMatcher().match("/api/user/reset", request.getServletPath())
         || new AntPathMatcher().match("/api/user/app/reset", request.getServletPath())
         || new AntPathMatcher().match("/api/user/resetEmail", request.getServletPath())
         || new AntPathMatcher().match("/api/user/app/resetEmail", request.getServletPath())
         || new AntPathMatcher().match("/api/**/translate/status/callback", request.getServletPath())
         || new AntPathMatcher().match("/api/**/integrate/status/callback", request.getServletPath())
         || new AntPathMatcher().match("/api/plan/qr/info/**", request.getServletPath())
         || new AntPathMatcher().match("/api/largeScreen/**", request.getServletPath())
         || new AntPathMatcher().match("/api/large-screen/**", request.getServletPath())
         || new AntPathMatcher().match("/api/common/token/**", request.getServletPath())
         || new AntPathMatcher().match("/api/mes/building/machine_part/nesting/scheduling/updateMachinePartNestingJobStatus", request.getServletPath())
         || new AntPathMatcher().match("/api/mes/building/scheduling/cloudcut_result/updateStatus", request.getServletPath())
         || new AntPathMatcher().match("/api/wms/device/**", request.getServletPath())
         || new AntPathMatcher().match("/api/wms/report/data/dashboard/**", request.getServletPath())
         || new AntPathMatcher().match("/api/complete/largeScreen/**", request.getServletPath())
         || new AntPathMatcher().match("/api/app/mes/building/factory/simple/new", request.getServletPath())
         || new AntPathMatcher().match("/api/v2/wms/config/material/warehouse/workshop/getAll/new", request.getServletPath())
         || new AntPathMatcher().match("/api/mes/building/team/find", request.getServletPath())
         || new AntPathMatcher().match("/api/app/mes/building/factory/simple", request.getServletPath())
         || new AntPathMatcher().match("/api/v2/wms/config/material/warehouse/workshop/getAll", request.getServletPath())
         || new AntPathMatcher().match("/api/system/product-traceability-config/getByProjectId/public", request.getServletPath())
         || new AntPathMatcher().match("/api/system/product-traceability-config/getDefault", request.getServletPath());
   }
}
