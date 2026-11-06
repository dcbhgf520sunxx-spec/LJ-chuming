package com.hzchum.scim.system.core.api.common.utils;

import com.alibaba.fastjson.JSONObject;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RequestUtils {
   private static final Logger log = LoggerFactory.getLogger(RequestUtils.class);

   public static String sendHttpsGetRequest(String url) {
      RestTemplate restTemplate = new RestTemplate();
      return restTemplate.getForObject(url, String.class);
   }

   public static String sendHttpsPostRequest(String url, JSONObject data) {
      return sendHttpsPostRequest(url, data, String.class);
   }

   public static <T> T sendHttpsPostRequest(String url, JSONObject data, Class<T> clazz) {
      try {
         RestTemplate restTemplate = new RestTemplate();
         HttpHeaders headers = new HttpHeaders();
         MediaType type = MediaType.parseMediaType("application/json; charset=UTF-8");
         headers.setContentType(type);
         headers.add("Accept", MediaType.APPLICATION_JSON.toString());
         HttpEntity<String> formEntity;
         if (Objects.nonNull(data)) {
            formEntity = new HttpEntity<>(data.toString(), headers);
         } else {
            formEntity = new HttpEntity<>(headers);
         }

         return restTemplate.postForObject(url, formEntity, clazz);
      } catch (Exception e) {
         log.error("调用第三方接口错误----------> url：{}，date：{}", url, data);
         log.error("调用第三方接口错误----------> {}", e);
         return null;
      }
   }
}
