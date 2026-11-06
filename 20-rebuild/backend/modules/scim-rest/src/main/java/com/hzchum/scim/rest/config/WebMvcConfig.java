package com.hzchum.scim.rest.config;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.hzchum.scim.common.core.api.config.ConfigProperties;
import com.hzchum.scim.rest.interceptor.WMSInterceptor;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.filter.FormContentFilter;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
   @Autowired
   private ConfigProperties configProperties;

   @Override
   public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
      FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
      List<MediaType> supportedMediaTypes = new ArrayList<>();
      supportedMediaTypes.add(MediaType.APPLICATION_JSON);
      supportedMediaTypes.add(MediaType.APPLICATION_ATOM_XML);
      supportedMediaTypes.add(MediaType.APPLICATION_FORM_URLENCODED);
      supportedMediaTypes.add(MediaType.APPLICATION_OCTET_STREAM);
      supportedMediaTypes.add(MediaType.APPLICATION_PDF);
      supportedMediaTypes.add(MediaType.APPLICATION_RSS_XML);
      supportedMediaTypes.add(MediaType.APPLICATION_XHTML_XML);
      supportedMediaTypes.add(MediaType.APPLICATION_XML);
      supportedMediaTypes.add(MediaType.IMAGE_GIF);
      supportedMediaTypes.add(MediaType.IMAGE_JPEG);
      supportedMediaTypes.add(MediaType.IMAGE_PNG);
      supportedMediaTypes.add(MediaType.TEXT_EVENT_STREAM);
      supportedMediaTypes.add(MediaType.TEXT_HTML);
      supportedMediaTypes.add(MediaType.TEXT_MARKDOWN);
      supportedMediaTypes.add(MediaType.TEXT_PLAIN);
      supportedMediaTypes.add(MediaType.TEXT_XML);
      supportedMediaTypes.add(MediaType.ALL);
      converter.setSupportedMediaTypes(supportedMediaTypes);
      FastJsonConfig config = new FastJsonConfig();
      config.setSerializerFeatures(
         SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.DisableCircularReferenceDetect
      );
      converter.setFastJsonConfig(config);
      converter.setDefaultCharset(StandardCharsets.UTF_8);
      converters.add(converter);
   }

   @Bean
   public WMSInterceptor getWmsInterceptor() {
      return new WMSInterceptor();
   }

   @Bean
   public CorsFilter corsFilter() {
      CorsConfiguration config = new CorsConfiguration();
      config.addAllowedOriginPattern("*");
      config.addAllowedHeader("*");
      config.addAllowedMethod("*");
      config.setAllowCredentials(true);
      config.setMaxAge(3600L);
      UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
      configSource.registerCorsConfiguration("/**", config);
      return new CorsFilter(configSource);
   }

   @Override
   public void addInterceptors(InterceptorRegistry registry) {
      registry.addInterceptor(this.getWmsInterceptor()).addPathPatterns("/api/wms/**", "/api/app/wms/**", "/api/v2/wms/**", "/api/v2/app/wms/**");
   }

   @Override
   public void addResourceHandlers(ResourceHandlerRegistry registry) {
      registry.addResourceHandler("/files/**").addResourceLocations("file:" + this.configProperties.getFilePath());
      registry.addResourceHandler("/**").addResourceLocations("classpath:/static/");
      registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
      registry.addResourceHandler("doc.html").addResourceLocations("classpath:/META-INF/resources/");
      registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
   }

   @Override
   public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
      configurer.enable();
   }

   @Bean
   public ServletWebServerFactory webServerFactory() {
      TomcatServletWebServerFactory fa = new TomcatServletWebServerFactory();
      fa.addConnectorCustomizers(connector -> {
         connector.setProperty("relaxedQueryChars", "(),/:;<=>?@[\\]{}");
         connector.setProperty("rejectIllegalHeader", "false");
      });
      return fa;
   }

   @Bean
   WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> enableDefaultServlet() {
      return factory -> factory.setRegisterDefaultServlet(true);
   }

   @Bean
   public FormContentFilter httpPutFormContentFilter() {
      return new FormContentFilter();
   }
}
