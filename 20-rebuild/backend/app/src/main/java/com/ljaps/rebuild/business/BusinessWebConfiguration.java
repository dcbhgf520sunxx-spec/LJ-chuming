package com.ljaps.rebuild.business;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.List;

@Configuration
public class BusinessWebConfiguration implements WebMvcConfigurer {
    @org.springframework.context.annotation.Bean
    public org.springframework.boot.web.server.WebServerFactoryCustomizer<org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory> originalQueryCharacters(){
        return factory->factory.addConnectorCustomizers(connector->{
            connector.setProperty("relaxedQueryChars","(),/:;<=>?@[\\]{}");
            connector.setProperty("rejectIllegalHeader","false");
        });
    }
    private final com.hzchum.scim.rest.interceptor.WMSInterceptor wms;
    public BusinessWebConfiguration(com.hzchum.scim.rest.interceptor.WMSInterceptor wms){this.wms=wms;}
    @Override public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(wms).addPathPatterns("/api/wms/**","/api/app/wms/**","/api/v2/wms/**","/api/v2/app/wms/**");
    }
    @Override public void addResourceHandlers(ResourceHandlerRegistry registry){
        registry.addResourceHandler("/files/**").addResourceLocations("file:/data/files/");
    }
    @Override public void extendMessageConverters(List<HttpMessageConverter<?>> converters){
        for(HttpMessageConverter<?> converter:converters)if(converter instanceof MappingJackson2HttpMessageConverter)
            ((MappingJackson2HttpMessageConverter)converter).getObjectMapper().disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        // Original MVC supports ResultVO after an already-written Excel response; keep this fallback after Jackson.
        com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter fallback=new com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter();
        com.alibaba.fastjson.support.config.FastJsonConfig config=new com.alibaba.fastjson.support.config.FastJsonConfig();
        config.setSerializerFeatures(com.alibaba.fastjson.serializer.SerializerFeature.WriteMapNullValue,
            com.alibaba.fastjson.serializer.SerializerFeature.WriteNullStringAsEmpty,
            com.alibaba.fastjson.serializer.SerializerFeature.DisableCircularReferenceDetect);
        fallback.setFastJsonConfig(config);fallback.setDefaultCharset(java.nio.charset.StandardCharsets.UTF_8);
        fallback.setSupportedMediaTypes(java.util.Collections.singletonList(org.springframework.http.MediaType.ALL));
        converters.add(fallback);
    }
}
