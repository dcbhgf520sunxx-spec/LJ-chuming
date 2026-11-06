package com.hzchum.pangu.redis.config;

import java.util.List;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "spring.redis")
public class RedisProperties {
   private String password;
   private RedisProperties.cluster cluster;
   private String host;
   private String port;
   private Integer database;
   private Long lockWatchdogTimeout;

   public String getPassword() {
      return this.password;
   }

   public void setPassword(String password) {
      this.password = password;
   }

   public String getHost() {
      return this.host;
   }

   public void setHost(String host) {
      this.host = host;
   }

   public String getPort() {
      return this.port;
   }

   public void setPort(String port) {
      this.port = port;
   }

   public RedisProperties.cluster getCluster() {
      return this.cluster;
   }

   public void setCluster(RedisProperties.cluster cluster) {
      this.cluster = cluster;
   }

   public Integer getDatabase() {
      return this.database;
   }

   public void setDatabase(Integer database) {
      this.database = database;
   }

   public Long getLockWatchdogTimeout() {
      return this.lockWatchdogTimeout;
   }

   public void setLockWatchdogTimeout(Long lockWatchdogTimeout) {
      this.lockWatchdogTimeout = lockWatchdogTimeout;
   }

   public static class cluster {
      private List<String> nodes;

      public List<String> getNodes() {
         return this.nodes;
      }

      public void setNodes(List<String> nodes) {
         this.nodes = nodes;
      }
   }
}
