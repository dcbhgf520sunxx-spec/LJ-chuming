package com.ljaps.rebuild.business;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.nio.file.*;
import java.util.*;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

/** Read back the live Spring registry after successful startup, without calling business write APIs. */
@Component
public class RuntimeRegistration implements ApplicationListener<ApplicationReadyEvent> {
    public void onApplicationEvent(ApplicationReadyEvent event){
        ApplicationContext context=event.getApplicationContext();
        List<Map<String,Object>> routes=new ArrayList<>();
        RequestMappingHandlerMapping mapping=context.getBean("requestMappingHandlerMapping",RequestMappingHandlerMapping.class);
        for(Map.Entry<RequestMappingInfo,HandlerMethod> entry:mapping.getHandlerMethods().entrySet()){
            RequestMappingInfo info=entry.getKey();HandlerMethod method=entry.getValue();
            Map<String,Object> row=new LinkedHashMap<>();
            row.put("paths",info.getPatternsCondition().getPatterns());row.put("methods",info.getMethodsCondition().getMethods());
            row.put("params",info.getParamsCondition().toString());row.put("headers",info.getHeadersCondition().toString());
            row.put("consumes",info.getConsumesCondition().toString());row.put("produces",info.getProducesCondition().toString());
            row.put("controller",method.getBeanType().getName());row.put("java_method",method.getMethod().getName());
            PreAuthorize permission=AnnotatedElementUtils.findMergedAnnotation(method.getMethod(),PreAuthorize.class);
            row.put("pre_authorize",permission==null?null:permission.value());routes.add(row);
        }
        routes.sort(Comparator.comparing(row->row.get("paths").toString()));
        Map<String,Object> result=new LinkedHashMap<>();result.put("started_epoch_millis",event.getTimestamp());result.put("registered_mappings",routes.size());
        result.put("business_mappings",routes.stream().filter(r->r.get("controller").toString().startsWith("com.hzchum.")).count());
        result.put("mapper_statements",context.getBean(SqlSessionFactory.class).getConfiguration().getMappedStatementNames().size());
        result.put("spring_beans",context.getBeanDefinitionCount());result.put("routes",routes);
        result.put("command_line_runners",context.getBeanNamesForType(org.springframework.boot.CommandLineRunner.class));
        result.put("application_runners",context.getBeanNamesForType(org.springframework.boot.ApplicationRunner.class));
        result.put("scheduled_processor_present",context.containsBean("org.springframework.context.annotation.internalScheduledAnnotationProcessor"));
        com.hzchum.scim.common.core.api.config.ConfigProperties config=context.getBean(com.hzchum.scim.common.core.api.config.ConfigProperties.class);
        Map<String,Object> businessConfig=new LinkedHashMap<>();
        businessConfig.put("companyName",config.getCompanyName());businessConfig.put("companyNo",config.getCompanyNo());
        businessConfig.put("yuanDecimal",config.getYuanDecimal());businessConfig.put("projectNameShowMode",config.getProjectNameShowMode());
        businessConfig.put("showContractNo",config.getShowContractNo());businessConfig.put("showProjectFullName",config.getShowProjectFullName());
        businessConfig.put("backupsNumber",config.getBackupsNumber());businessConfig.put("weightTimeOut",config.getWeightTimeOut());
        result.put("business_configuration",businessConfig);
        result.put("local_business_lifecycle",context.getBean(LocalBusinessLifecycle.class).registry());
        result.put("configured_data_sources",java.util.Collections.singletonList("master"));result.put("strict_named_data_sources",true);
        try{
            Path path=Paths.get(System.getenv().getOrDefault("LJAPS_REGISTRATION_EVIDENCE","/evidence/runtime-registration.json"));
            Files.createDirectories(path.getParent());new ObjectMapper().writerWithDefaultPrettyPrinter().writeValue(path.toFile(),result);
        }catch(Exception error){throw new IllegalStateException("Cannot save runtime registration evidence",error);}
    }
}
