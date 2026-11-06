package com.hzchum.pangu.swagger.config;

import io.swagger.annotations.ApiOperation;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

@Configuration
@EnableSwagger2WebMvc
public class Knife4jConfig {
   @Value("${chum.swagger.title}")
   private String title;
   @Value("${chum.swagger.version}")
   private String version;

   @Bean
   public Docket defaultApi2() {
      ParameterBuilder parameterBuilder = new ParameterBuilder();
      List<Parameter> parameters = new ArrayList<>();
      parameterBuilder.name("Authorization").description("令牌").modelRef(new ModelRef("string")).parameterType("header").required(false).build();
      parameters.add(parameterBuilder.build());
      return new Docket(DocumentationType.SWAGGER_2)
         .apiInfo(new ApiInfoBuilder().title(this.title).version(this.version).build())
         .select()
         .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class))
         .paths(PathSelectors.any())
         .build()
         .globalOperationParameters(parameters);
   }
}
