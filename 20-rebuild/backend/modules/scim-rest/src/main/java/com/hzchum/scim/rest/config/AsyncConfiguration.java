package com.hzchum.scim.rest.config;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor.CallerRunsPolicy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfiguration implements AsyncConfigurer {
   private static final Logger log = LoggerFactory.getLogger(AsyncConfiguration.class);

   @Bean(name = "asyncPoolTaskExecutor")
   public ThreadPoolTaskExecutor executor() {
      ThreadPoolTaskExecutor taskExecutor = new ThreadPoolTaskExecutor();
      taskExecutor.setCorePoolSize(5);
      taskExecutor.setMaxPoolSize(20);
      taskExecutor.setQueueCapacity(50);
      taskExecutor.setKeepAliveSeconds(200);
      taskExecutor.setThreadNamePrefix("async-");
      taskExecutor.setRejectedExecutionHandler(new CallerRunsPolicy());
      taskExecutor.initialize();
      return taskExecutor;
   }

   @Override
   public Executor getAsyncExecutor() {
      return this.executor();
   }

   @Override
   public AsyncUncaughtExceptionHandler getAsyncUncaughtExceptionHandler() {
      return (ex, method, params) -> log.error("线程池执行任务发送未知错误,执行方法：{}", method.getName(), ex);
   }
}
