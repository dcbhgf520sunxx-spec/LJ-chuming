package com.hzchum.scim.system.core.security;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.google.common.base.Preconditions;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.util.AESUtils;
import com.hzchum.pangu.common.util.ResponseUtil;
import com.hzchum.scim.system.core.api.common.enums.SystemChargingMethodEnum;
import com.hzchum.scim.system.core.api.common.utils.RedisUtils;
import com.hzchum.scim.system.core.api.pojo._do.Config;
import com.hzchum.scim.system.core.api.service.ConfigService;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import javax.annotation.Resource;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.filter.OncePerRequestFilter;

public class ServerExpireFilter extends OncePerRequestFilter {
   @Autowired
   private ConfigService configService;
   @Resource
   private RedisUtils redisUtils;

   @Override
   protected void doFilterInternal(HttpServletRequest request, @NotNull HttpServletResponse response, @NotNull FilterChain filterChain) throws ServletException, IOException {
      if (!request.getRequestURI().startsWith("/api/config/saveOrUpdateExpireDate")
         && !request.getRequestURI().startsWith("/api/config/getServerExpireDate")
         && !request.getRequestURI().startsWith("/api/config/updateBimModelConfigRestrictedMode")
         && !request.getRequestURI().startsWith("/api/config/updateBimModelConfigStatus")
         && !request.getRequestURI().startsWith("/api/config/updateBimModelConfigTotalValue")
         && !request.getRequestURI().startsWith("/api/config/getSystemChargingMethod")
         && !request.getRequestURI().startsWith("/api/config/sendProgressPaymentSms")
         && !request.getRequestURI().endsWith("html")
         && !request.getRequestURI().endsWith("css")
         && !request.getRequestURI().endsWith("js")
         && !request.getRequestURI().contains("webjars")
         && !request.getRequestURI().contains("actuator")
         && !request.getRequestURI().contains("swagger")
         && !request.getRequestURI().contains("api-docs")) {
         Config config = this.configService.getOne((Wrapper<Config>)new LambdaQueryWrapper<Config>().eq(Config::getCode, "SERVER_EXPIRE_DATE"));
         Config systemChargingMethod = this.configService.getOne((Wrapper<Config>)new LambdaQueryWrapper<Config>().eq(Config::getCode, "SYSTEM_CHARGING_METHOD"));
         Boolean expireFlag = (Boolean)this.redisUtils.get("SERVER_EXPIRE_DATE");
         if (Objects.nonNull(expireFlag)) {
            if (!SystemChargingMethodEnum.MAINTENANCE_FEE.getType().equals(systemChargingMethod.getValue()) && !expireFlag) {
               ResponseUtil.render(response, ResultCodeEnum.SERVER_EXPIRE_ERROR);
               return;
            }
         } else {
            if (Objects.isNull(config) || StrUtil.isBlank(config.getValue())) {
               ResponseUtil.render(response, ResultCodeEnum.SERVER_EXPIRE_ERROR);
               return;
            }

            String expireDateStr;
            try {
               expireDateStr = AESUtils.decrypt(System.getenv("LJAPS_SERVER_CONFIG_AES_KEY"), config.getValue());
            } catch (Exception e) {
               e.printStackTrace();
               throw new IllegalArgumentException(e.getMessage());
            }

            if (StrUtil.isNotBlank(expireDateStr)) {
               DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
               LocalDateTime expireDate = LocalDateTime.parse(expireDateStr, df);
               boolean after = expireDate.isAfter(LocalDateTime.now());
               this.redisUtils.set("SERVER_EXPIRE_DATE", after, 300L);
               Preconditions.checkArgument(Objects.nonNull(systemChargingMethod), "请检查系统收费方式");
               Preconditions.checkArgument(SystemChargingMethodEnum.isExist(systemChargingMethod.getValue()), "已存在的系统收费方式与实际定义不匹配");
               if (!SystemChargingMethodEnum.MAINTENANCE_FEE.getType().equals(systemChargingMethod.getValue()) && !after) {
                  ResponseUtil.render(response, ResultCodeEnum.SERVER_EXPIRE_ERROR);
                  return;
               }
            }
         }
      }

      if (request.getRequestURI().startsWith("/api/config/saveOrUpdateExpireDate") || request.getRequestURI().startsWith("/api/config/getServerExpireDate")) {
         String expireSalt = request.getHeader("expireSalt");
         Preconditions.checkArgument(System.getenv("LJAPS_SERVER_CONFIG_AES_KEY").equals(expireSalt), "参数不正确");
      }

      filterChain.doFilter(request, response);
   }
}
