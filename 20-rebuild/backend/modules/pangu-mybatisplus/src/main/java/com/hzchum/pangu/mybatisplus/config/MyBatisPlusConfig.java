package com.hzchum.pangu.mybatisplus.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.OptimisticLockerInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.hzchum.pangu.mybatisplus.interceptor.DefaultSelectInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBatisPlusConfig {
   @Bean
   public MybatisPlusInterceptor paginationInterceptor() {
      MybatisPlusInterceptor mybatisPlusInterceptor = new MybatisPlusInterceptor();
      mybatisPlusInterceptor.addInnerInterceptor(new DefaultSelectInterceptor());
      mybatisPlusInterceptor.addInnerInterceptor(new PaginationInnerInterceptor(DbType.MYSQL));
      mybatisPlusInterceptor.addInnerInterceptor(new OptimisticLockerInnerInterceptor());
      return mybatisPlusInterceptor;
   }
}
