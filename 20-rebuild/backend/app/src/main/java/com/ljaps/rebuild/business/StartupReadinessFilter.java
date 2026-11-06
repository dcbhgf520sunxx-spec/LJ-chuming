package com.ljaps.rebuild.business;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/** Do not serve login or business requests until the verified local initializers finish. */
@Component
@Order(0)
public class StartupReadinessFilter extends OncePerRequestFilter {
    private final LocalBusinessLifecycle lifecycle;
    public StartupReadinessFilter(LocalBusinessLifecycle lifecycle){this.lifecycle=lifecycle;}
    @Override protected void doFilterInternal(HttpServletRequest request,HttpServletResponse response,FilterChain chain) throws ServletException,IOException {
        String path=request.getServletPath();
        if(!lifecycle.isReady() && (path.startsWith("/api/") || path.equals("/actuator/health"))){
            response.setStatus(503);response.setContentType("application/json;charset=UTF-8");response.getWriter().write("{\"status\":\"STARTING\"}");return;
        }
        chain.doFilter(request,response);
    }
}
