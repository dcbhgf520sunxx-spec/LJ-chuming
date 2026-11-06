package com.hzchum.scim.rest.runner;

import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import java.util.Set;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;

@Order(1)
public class RedisDelRunner implements CommandLineRunner {
   private static final Logger log = LoggerFactory.getLogger(RedisDelRunner.class);
   @Autowired
   private RedisTemplate<String, Object> redisTemplate;

   @Override
   public void run(String... args) throws Exception {
      log.info("删除redis开始............................................");
      Set<String> keys = this.redisTemplate.keys("*");
      if (CollectionUtils.isNotEmpty(keys)) {
         this.redisTemplate.delete(keys);
      }

      log.info("删除redis结束............................................");
   }

   public RedisDelRunner(final RedisTemplate<String, Object> redisTemplate) {
      this.redisTemplate = redisTemplate;
   }
}
