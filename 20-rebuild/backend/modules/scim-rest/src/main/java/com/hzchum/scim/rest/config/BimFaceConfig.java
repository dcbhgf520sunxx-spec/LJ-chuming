package com.hzchum.scim.rest.config;

import com.bimface.sdk.BimfaceClient;
import com.bimface.sdk.config.Config;
import com.bimface.sdk.config.Endpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BimFaceConfig {
   private static final Logger LOGGER = LoggerFactory.getLogger(BimFaceConfig.class);
   @Value("${engine.appKey}")
   private String appKey;
   @Value("${engine.appSecret}")
   private String appSecret;

   @Bean(name = "bimfaceClient")
   public BimfaceClient getBimfaceClient() {
      LOGGER.info("初始化BIM文件配置开始...");
      Config config = new Config();
      config.setConnectTimeout(3600000);
      config.setReadTimeout(3600000);
      config.setWriteTimeout(3600000);
      Endpoint endpoint = new Endpoint();
      endpoint.setApiHost("http://172.16.0.177");
      endpoint.setFileHost("http://172.16.0.177/file/");
      endpoint.setBdfsHost("http://172.16.0.177/bdfs/");
      BimfaceClient bimfaceClient = new BimfaceClient(this.appKey, this.appSecret, endpoint, config);
      LOGGER.info("初始化BIM文件配置结束...");
      return bimfaceClient;
   }
}
