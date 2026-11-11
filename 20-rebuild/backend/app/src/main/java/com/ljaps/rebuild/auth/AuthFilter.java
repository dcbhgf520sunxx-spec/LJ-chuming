package com.ljaps.rebuild.auth;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import com.hzchum.scim.system.core.security.GeneratorUserDetailService;
import com.hzchum.scim.system.core.api.common.SecurityUser;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import java.util.Map;

/** API paths use platform authentication or the explicitly delegated endpoint authentication. */
@Component
@Order(10)
public class AuthFilter extends OncePerRequestFilter {
    private static final String BIM_TRANSLATE_CALLBACK="/api/model/3DModel/translate/status/callback";
    private final AuthService auth;
    private final ObjectMapper json=new ObjectMapper();
    private final GeneratorUserDetailService users;
    private final boolean bimEnabled;
    public AuthFilter(AuthService auth,@Lazy GeneratorUserDetailService users,
                      @Value("${ljaps.integrations.bim.enabled:false}") boolean bimEnabled) {
        this.auth=auth;
        this.users=users;
        this.bimEnabled=bimEnabled;
    }
    @Override protected boolean shouldNotFilter(HttpServletRequest request) {
        String path=request.getServletPath();
        return !path.startsWith("/api/") || path.equals("/api/user/login") || path.equals("/api/user/public-key") || path.equals("/api/health")
            || (bimEnabled && "GET".equals(request.getMethod()) && BIM_TRANSLATE_CALLBACK.equals(path));
    }
    @Override protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain chain) throws ServletException,IOException {
        try {
            Map<String,Object> user=auth.authenticate(request.getHeader("Authorization"));
            request.setAttribute("rebuildUser",user);
            request.getServletContext().setAttribute("boolAllowLogin",true);
            GeneratorUserDetailService.USER_MAP.remove(((Number)user.get("id")).longValue());
            SecurityUser principal=(SecurityUser)users.loadUserByUsername(String.valueOf(user.get("phone")!=null?user.get("phone"):user.get("username")));
            SecurityContextHolder.getContext().setAuthentication(new UsernamePasswordAuthenticationToken(principal,null,principal.getAuthorities()));
        }
        catch(AuthService.AuthFailure failure) {
            response.setContentType("application/json;charset=UTF-8");
            json.writeValue(response.getOutputStream(),AuthService.map("code",failure.code,"message",failure.getMessage(),"data",null)); return;
        }
        try { chain.doFilter(request,response); }
        finally { SecurityContextHolder.clearContext(); }
    }
}
