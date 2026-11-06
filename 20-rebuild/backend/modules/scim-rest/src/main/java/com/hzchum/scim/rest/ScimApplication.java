package com.hzchum.scim.rest;

import java.time.Duration;
import java.time.LocalDateTime;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableCaching
@EnableScheduling
@ComponentScan("com.hzchum")
@MapperScan("com.hzchum.scim.**.mapper")
@EnableJpaRepositories("com.hzchum")
@EntityScan("com.hzchum")
@EnableAsync
@EnableFeignClients(basePackages = "com.hzchum.**")
public class ScimApplication {
   public static void main(String[] args) {
      LocalDateTime startTime = LocalDateTime.now();
      SpringApplication.run(ScimApplication.class, args);
      LocalDateTime endTime = LocalDateTime.now();
      Duration duration = Duration.between(startTime, endTime);
      long minutes = duration.toMinutes() % 60L;
      long seconds = duration.getSeconds() % 60L;
      System.out.println("========================================================================");
      System.out.println("========================================================================");
      System.out.println("========================================================================");
      System.out.println("==============================项目运行时长：【" + minutes + "】分钟，【" + seconds + "】秒");
   }
}
