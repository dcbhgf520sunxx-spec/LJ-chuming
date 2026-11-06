package com.hzchum.pangu.redis.config;

import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonTypeInfo.As;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper.DefaultTyping;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.apache.commons.lang.StringUtils;
import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext.SerializationPair;

@Configuration
@ConfigurationProperties(prefix = "spring.cache.redis")
public class RedisConfig {
   private static final Logger logger = LoggerFactory.getLogger(RedisConfig.class);
   @Resource
   private RedisProperties redisProperties;
   private Duration timeToLive = Duration.ofDays(7L);

   @Bean
   public RedisTemplate<String, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
      RedisTemplate<String, Object> template = new RedisTemplate<>();
      template.setConnectionFactory(connectionFactory);
      Jackson2JsonRedisSerializer<Object> j2jrs = new Jackson2JsonRedisSerializer<>(Object.class);
      ObjectMapper om = new ObjectMapper();
      om.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
      om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
      om.registerModule(new JavaTimeModule());
      om.enableDefaultTyping(DefaultTyping.NON_FINAL, As.PROPERTY);
      j2jrs.setObjectMapper(om);
      template.setValueSerializer(j2jrs);
      template.setHashValueSerializer(j2jrs);
      template.setKeySerializer(new StringRedisSerializer());
      template.setHashKeySerializer(new StringRedisSerializer());
      template.afterPropertiesSet();
      return template;
   }

   @Bean
   public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory connectionFactory) {
      StringRedisTemplate redisTemplate = new StringRedisTemplate();
      redisTemplate.setConnectionFactory(connectionFactory);
      return redisTemplate;
   }

   @Bean
   public RedissonClient redissonClient() {
      Config config = new Config();
      if (this.redisProperties.getLockWatchdogTimeout() != null) {
         config.setLockWatchdogTimeout(this.redisProperties.getLockWatchdogTimeout());
      }

      if (StringUtils.isNotBlank(this.redisProperties.getHost()) && StringUtils.isNotBlank(this.redisProperties.getPort())) {
         config.useSingleServer()
            .setAddress("redis://" + this.redisProperties.getHost() + ":" + this.redisProperties.getPort())
            .setPassword(this.redisProperties.getPassword())
            .setDatabase(this.redisProperties.getDatabase())
            .setTimeout(1000);
      } else {
         List<String> clusterNodes = new ArrayList<>();

         for (int i = 0; i < this.redisProperties.getCluster().getNodes().size(); i++) {
            clusterNodes.add("redis://" + this.redisProperties.getCluster().getNodes().get(i));
         }

         config.useClusterServers()
            .setScanInterval(1000)
            .addNodeAddress(clusterNodes.toArray(new String[clusterNodes.size()]))
            .setPassword(this.redisProperties.getPassword());
      }

      RedissonClient redissonClient = Redisson.create(config);

      try {
         logger.info("redisson配置为:" + redissonClient.getConfig().toYAML());
      } catch (Exception e) {
         e.printStackTrace();
      }

      return redissonClient;
   }

   @Bean
   public CacheManager cacheManager(RedisConnectionFactory connectionFactory) {
      RedisSerializer<String> redisSerializer = new StringRedisSerializer();
      Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
      ObjectMapper om = new ObjectMapper();
      om.setVisibility(PropertyAccessor.ALL, Visibility.ANY);
      om.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
      om.registerModule(new JavaTimeModule());
      om.enableDefaultTyping(DefaultTyping.NON_FINAL, As.PROPERTY);
      jackson2JsonRedisSerializer.setObjectMapper(om);
      RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig()
         .entryTtl(this.timeToLive)
         .serializeKeysWith(SerializationPair.fromSerializer(redisSerializer))
         .serializeValuesWith(SerializationPair.fromSerializer(jackson2JsonRedisSerializer))
         .disableCachingNullValues();
      return RedisCacheManager.builder(connectionFactory).cacheDefaults(config).build();
   }
}
