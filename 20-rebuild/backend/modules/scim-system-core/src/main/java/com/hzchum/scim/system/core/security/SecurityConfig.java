package com.hzchum.scim.system.core.security;

import com.google.common.collect.ImmutableList;
import javax.annotation.Resource;
import javax.servlet.Filter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Order(1002)
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
   @Resource
   private JwtAuthenticationEntryPoint unauthorizedHandler;
   @Resource
   private GeneratorUserDetailService userDetailService;
   private static final String ENVIRONMENT_LOCAL = "local";
   private static final String ENVIRONMENT_COMPANY = "company";
   @Value("${spring.profiles.active}")
   private String env;

   @Bean
   public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
   }

   @Bean
   @Override
   protected AuthenticationManager authenticationManager() throws Exception {
      return super.authenticationManager();
   }

   @Autowired
   public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
      auth.userDetailsService(this.userDetailService).passwordEncoder(this.passwordEncoder());
   }

   @Override
   protected void configure(HttpSecurity http) throws Exception {
      http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
      if (!"company".equals(this.env)) {
         http.cors().and().authorizeRequests().antMatchers("**").permitAll();
      } else {
         ((HttpSecurity)http.cors()
               .and()
               .exceptionHandling()
               .authenticationEntryPoint(this.unauthorizedHandler)
               .and()
               .authorizeRequests()
               .antMatchers(
                  "/",
                  "/static/",
                  "/api/user/login",
                  "/api/user/login/sub",
                  "/api/structures/structure-stat/actions/list",
                  "/files/**",
                  "/bim/ws/**",
                  "/api/user/verifyCode",
                  "/api/user/app/verifyCode",
                  "/api/user/reset",
                  "/api/user/app/reset",
                  "/api/user/resetEmail",
                  "/api/user/app/resetEmail",
                  "/api/**/translate/status/callback",
                  "/api/**/integrate/status/callback",
                  "/api/plan/qr/info/**",
                  "/api/largeScreen/**",
                  "/api/large-screen/**",
                  "/api/plan/monomer/getTreeByProjectId/**",
                  "/api/config/saveOrUpdateExpireDate",
                  "/api/config/getServerExpireDate",
                  "/api/config/saveOrUpdateBimModelConfig",
                  "/api/config/getBimModelConvertRestrict",
                  "/api/config/saveOrUpdateSystemChargingMethod",
                  "/api/config/getSystemChargingMethod",
                  "/api/config/sendProgressPaymentSms",
                  "/api/foreign/role/menu/**",
                  "/api/common/token/**",
                  "/api/mes/building/machine_part/nesting/scheduling/updateMachinePartNestingJobStatus",
                  "/api/mes/building/scheduling/cloudcut_result/updateStatus",
                  "/api/user/logout",
                  "/api/we_chat/login",
                  "/api/we_chat/binding",
                  "/api/we_chat/sendCode",
                  "/api/user/logout",
                  "/api/wms/device/**",
                  "/api/contract/project/qualifications/get/project/list",
                  "/api/wms/device/**",
                  "/api/plan/drawing/product",
                  "/api/wms/device/**",
                  "/api/oa/flow/syncApprovalFlowStatus",
                  "/api/plan/drawing/product",
                  "/api/wms/report/data/dashboard/**",
                  "/api/complete/largeScreen/**",
                  "/api/app/mes/building/factory/simple/new",
                  "/api/v2/wms/config/material/warehouse/workshop/getAll/new",
                  "/api/mes/building/team/find",
                  "/api/app/mes/building/factory/simple",
                  "/api/system/product-traceability-config/getByProjectId/public",
                  "/api/system/product-traceability-config/getDefault",
                  "/api/v2/wms/config/material/warehouse/workshop/getAll",
                  "/api/config/passwordPolicy/get",
                  "/api/user/send/verificationCode",
                  "/api/user/check/verificationCode"
               )
               .permitAll()
               .antMatchers("/auth/**")
               .permitAll()
               .anyRequest()
               .authenticated()
               .and())
            .formLogin()
            .loginPage("/login")
            .permitAll()
            .defaultSuccessUrl("/hello")
            .permitAll()
            .and()
            .logout()
            .logoutSuccessUrl("/home")
            .permitAll();
      }

      http.headers().cacheControl();
      http.addFilterBefore(this.authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
      http.addFilterBefore(this.serverExpireFilterBean(), (Class<? extends Filter>)this.authenticationTokenFilterBean().getClass());
   }

   @Bean
   public CorsConfigurationSource corsConfigurationSource() {
      CorsConfiguration configuration = new CorsConfiguration();
      configuration.setAllowedOrigins(ImmutableList.of("*"));
      configuration.setAllowedMethods(ImmutableList.of("HEAD", "GET", "POST", "PUT", "DELETE", "PATCH"));
      configuration.setAllowCredentials(true);
      configuration.setAllowedHeaders(ImmutableList.of("Authorization", "Cache-Control", "Content-Type"));
      UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
      source.registerCorsConfiguration("/**", configuration);
      return source;
   }

   @Bean
   public JwtAuthenticationTokenFilter authenticationTokenFilterBean() {
      return new JwtAuthenticationTokenFilter();
   }

   @Bean
   public ServerExpireFilter serverExpireFilterBean() {
      return new ServerExpireFilter();
   }
}
