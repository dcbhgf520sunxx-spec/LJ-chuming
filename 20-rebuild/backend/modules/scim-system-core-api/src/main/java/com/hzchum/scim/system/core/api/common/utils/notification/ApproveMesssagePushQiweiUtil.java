package com.hzchum.scim.system.core.api.common.utils.notification;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import java.io.IOException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ApproveMesssagePushQiweiUtil {
   private static final Logger log = LoggerFactory.getLogger(ApproveMesssagePushQiweiUtil.class);
   private static final String CORP_ID = System.getenv("LJAPS_QIWEI_CORP_ID");
   private static final String CORP_SECRET = System.getenv("LJAPS_QIWEI_CORP_SECRET");

   private String getAccessToken() throws IOException {
      String url = "https://qyapi.weixin.qq.com/cgi-bin/gettoken?corpid=" + CORP_ID + "&corpsecret=" + CORP_SECRET;
      HttpPost httpPost = new HttpPost(url);

      try (
         CloseableHttpClient httpClient = HttpClients.createDefault();
         CloseableHttpResponse response = httpClient.execute(httpPost);
      ) {
         HttpEntity entity = response.getEntity();
         String responseBody = EntityUtils.toString(entity);
         JSONObject jsonObject = JSON.parseObject(responseBody);
         return jsonObject.getString("access_token");
      }
   }

   private void sendMessage(String accessToken, String messageContent) throws IOException {
      log.info("Message sentContent: " + messageContent);
      String url = "https://qyapi.weixin.qq.com/cgi-bin/message/send?access_token=" + accessToken;
      HttpPost httpPost = new HttpPost(url);
      httpPost.setEntity(new StringEntity(messageContent, "utf-8"));
      httpPost.setHeader("Content-Type", "application/json");

      try (
         CloseableHttpClient httpClient = HttpClients.createDefault();
         CloseableHttpResponse response = httpClient.execute(httpPost);
      ) {
         HttpEntity entity = response.getEntity();
         String responseBody = EntityUtils.toString(entity);
         log.info("Message sent: " + responseBody);
      }
   }
}
