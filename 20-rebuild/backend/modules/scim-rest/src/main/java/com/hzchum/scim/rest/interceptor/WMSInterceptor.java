package com.hzchum.scim.rest.interceptor;

import cn.hutool.core.util.StrUtil;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Component
public class WMSInterceptor implements HandlerInterceptor {
   @Resource
   private RedisUtils redisUtils;

   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
      String s = (String)this.redisUtils.get("calculatePrice");
      if (!"GET".equals(request.getMethod()) && StrUtil.isNotBlank(s)) {
         throw new IllegalArgumentException("WMS-系统正在进行月末金额计算,请稍后操作.");
      } else {
         String s1 = (String)this.redisUtils.get("manufacturedStatistics");
         if (!"GET".equals(request.getMethod()) && StrUtil.isNotBlank(s1)) {
            throw new IllegalArgumentException("WMS-系统正在进行月末金额计算,请稍后操作.");
         } else {
            return true;
         }
      }
   }

   @Override
   public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
   }

   @Override
   public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
   }
}
