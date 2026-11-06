package com.hzchum.scim.rest.aspect;

import com.hzchum.scim.system.core.api.common.SecurityUser;
import com.hzchum.scim.system.core.api.common.utils.UserUtil;
import com.hzchum.scim.system.core.api.pojo._do.SysLog;
import com.hzchum.scim.system.core.api.service.SysLogService;
import java.util.Arrays;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
public class WebLogAspect {
   @Resource
   private SysLogService logService;
   public static final Logger LOGGER = LoggerFactory.getLogger(WebLogAspect.class);
   ThreadLocal<Long> startTime = new ThreadLocal<>();

   @Pointcut(
      "(execution(public * com.hzchum.scim.rest.controller..*.*(..)) && !execution(public * com.hzchum.scim.rest.controller.cut..*.*(..))&&!execution(public * com.hzchum.scim.rest.controller.system.UserApi.login(..))) &&!execution(public * com.hzchum.scim.rest.controller.wms.wmsUse.OutboundReviewControllerV2.getRemindNumbers(..)))"
   )
   public void webLog() {
   }

   @Around("webLog()")
   public Object process(ProceedingJoinPoint point) throws Throwable {
      ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
      assert attributes != null;
      HttpServletRequest request = attributes.getRequest();
      this.startTime.set(System.currentTimeMillis());

      try {
         SysLog sysLog = new SysLog();
         String ip = request.getHeader("x-real-ip");
         String url = request.getRequestURL().toString();
         String method = request.getMethod();
         String classMethod = point.getSignature().getDeclaringTypeName() + "." + point.getSignature().getName();
         String args = Arrays.toString(point.getArgs());
         LOGGER.info(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>");
         LOGGER.info("IP : {}", ip);
         LOGGER.info("URL : {}", url);
         if (!"anonymousUser".equals(SecurityContextHolder.getContext().getAuthentication().getPrincipal())) {
            SecurityUser user = UserUtil.getCurrentUser();
            LOGGER.info("USER : {}", user == null ? null : user.getName());
            if (user != null) {
               sysLog.setUserId(user.getId());
               sysLog.setUserName(user.getUsername());
            }
         }

         LOGGER.info("HTTP_METHOD : {}", method);
         LOGGER.info("CLASS_METHOD : {}", classMethod);
         LOGGER.info("ARGS : {}", args);
         Object ret = point.proceed();
         long spendTime = System.currentTimeMillis() - this.startTime.get();
         sysLog.setIp(ip);
         sysLog.setMethod(method);
         sysLog.setClassMethod(classMethod);
         sysLog.setUrl(url);
         sysLog.setSpendTime(spendTime);
         this.logService.save(sysLog);
         LOGGER.info("SPEND TIME : {}", spendTime + ">>>>>>" + classMethod);
         LOGGER.info("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
         return ret;
      } catch (Exception exp) {
         throw exp;
      } finally {
         ;
      }
   }
}
