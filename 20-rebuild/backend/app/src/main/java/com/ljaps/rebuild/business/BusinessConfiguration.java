package com.ljaps.rebuild.business;

import java.io.IOException;
import java.lang.reflect.Method;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcRegistrations;
import org.springframework.context.annotation.*;
import org.springframework.core.type.classreading.*;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;
import com.hzchum.scim.system.core.security.GeneratorUserDetailService;

/** Register recovered business code without its historical migrations, schedulers or login filter. */
@Configuration
@org.springframework.cache.annotation.EnableCaching
@org.springframework.cloud.openfeign.EnableFeignClients(basePackages="com.hzchum")
@EnableGlobalMethodSecurity(prePostEnabled=true)
@MapperScan("com.hzchum.scim.**.mapper")
@ComponentScan(basePackages="com.hzchum", excludeFilters=@ComponentScan.Filter(type=FilterType.CUSTOM,classes=BusinessConfiguration.Excluded.class))
public class BusinessConfiguration {
    public static class Excluded implements TypeFilter {
        public boolean match(MetadataReader reader,MetadataReaderFactory factory) throws IOException {
            String name=reader.getClassMetadata().getClassName();
            return name.equals("com.hzchum.scim.rest.ScimApplication")
                || name.contains(".rest.runner.") || name.contains(".rest.initialize.") || name.contains(".rest.schedule.")
                || name.endsWith(".SecurityConfig") || name.endsWith(".PermissionCheck")
                || name.endsWith(".Knife4jConfig") || name.endsWith(".SchedulingConfig")
                || name.endsWith(".WebMvcConfig") || name.endsWith(".BimFaceConfig")
                || name.endsWith(".WebLogAspect");
        }
    }
    @Bean public com.bimface.sdk.BimfaceClient bimfaceClient(
            @org.springframework.beans.factory.annotation.Value("${ljaps.integrations.bim.enabled:false}") boolean enabled,
            @org.springframework.beans.factory.annotation.Value("${engine.appKey:}") String appKey,
            @org.springframework.beans.factory.annotation.Value("${engine.appSecret:}") String appSecret,
            @org.springframework.beans.factory.annotation.Value("${engine.apiHost:}") String apiHost,
            @org.springframework.beans.factory.annotation.Value("${engine.fileHost:}") String fileHost,
            @org.springframework.beans.factory.annotation.Value("${engine.bdfsHost:}") String bdfsHost){
        com.bimface.sdk.config.Endpoint endpoint=new com.bimface.sdk.config.Endpoint();
        if(!enabled){
            endpoint.setApiHost("http://127.0.0.1:9");endpoint.setFileHost("http://127.0.0.1:9/file/");endpoint.setBdfsHost("http://127.0.0.1:9/bdfs/");
            return new com.bimface.sdk.BimfaceClient("offline","offline",endpoint,new com.bimface.sdk.config.Config());
        }
        if(appKey==null || appKey.trim().isEmpty() || appSecret==null || appSecret.trim().isEmpty())
            throw new IllegalArgumentException("Enabled BIM integration requires engine.appKey and engine.appSecret");
        if(apiHost!=null && !apiHost.trim().isEmpty())endpoint.setApiHost(apiHost);
        if(fileHost!=null && !fileHost.trim().isEmpty())endpoint.setFileHost(fileHost);
        if(bdfsHost!=null && !bdfsHost.trim().isEmpty())endpoint.setBdfsHost(bdfsHost);
        return new com.bimface.sdk.BimfaceClient(appKey,appSecret,endpoint,new com.bimface.sdk.config.Config());
    }
    @Bean public PasswordEncoder passwordEncoder(){return new BCryptPasswordEncoder();}
    @Bean public AuthenticationManager authenticationManager(GeneratorUserDetailService users,PasswordEncoder encoder){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();provider.setUserDetailsService(users);provider.setPasswordEncoder(encoder);
        return new ProviderManager(java.util.Collections.singletonList(provider));
    }
    @Bean public WebMvcRegistrations businessMappings(){
        return new WebMvcRegistrations(){
            public RequestMappingHandlerMapping getRequestMappingHandlerMapping(){
                return new RequestMappingHandlerMapping(){
                    @Override protected RequestMappingInfo getMappingForMethod(Method method,Class<?> type){
                        RequestMappingInfo info=super.getMappingForMethod(method,type);
                        if(info!=null && type.getName().equals("com.hzchum.scim.rest.controller.system.UserApi")){
                            for(String path:info.getPatternsCondition().getPatterns())
                                if(path.equals("/api/user/login") || path.equals("/api/user/menu") || path.equals("/api/user/logout")
                                    || (path.equals("/api/user/info") && info.getMethodsCondition().getMethods().contains(org.springframework.web.bind.annotation.RequestMethod.GET)))return null;
                        }
                        return info;
                    }
                };
            }
        };
    }
}
