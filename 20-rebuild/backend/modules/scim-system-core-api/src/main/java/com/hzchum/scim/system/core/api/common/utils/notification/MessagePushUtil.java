package com.hzchum.scim.system.core.api.common.utils.notification;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hzchum.scim.common.core.api.enums.EnableEnum;
import com.hzchum.scim.system.core.api.common.enums.notification.NotificationModuleTypeEnum;
import com.hzchum.scim.system.core.api.pojo.dto.notification.SysPushWebhookConfigDTO;
import com.hzchum.scim.system.core.api.service.notification.SysPushWebhookConfigService;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;
import java.util.LinkedHashMap;
import java.nio.charset.StandardCharsets;
import javax.annotation.Resource;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MessagePushUtil {
   private static final Logger log = LoggerFactory.getLogger(MessagePushUtil.class);
   @Resource
   private SysPushWebhookConfigService sysPushWebhookConfigService;
   @Value("${spring.profiles.active}")
   private String active;
   @Value("${ljaps.integrations.webhook.enabled:false}")
   private boolean webhookEnabled;

   public void sendDingTalkMessage(String message, Integer notificationType, List<String> userPhoneList) {
      List<SysPushWebhookConfigDTO> webhookList = this.sysPushWebhookConfigService.getWebhookList(null, null, EnableEnum.ENABLE.getType(), notificationType);
      if (CollectionUtils.isNotEmpty(webhookList) && (ObjectUtil.equals("company", this.active) || this.webhookEnabled)) {
         webhookList.forEach(
            item -> {
               if (!notificationType.equals(NotificationModuleTypeEnum.WMS_MATERIAL_OUTBOUND.getNotificationType())
                  && !notificationType.equals(NotificationModuleTypeEnum.WMS_MATERIAL_PARTY_A_INBOUND.getNotificationType())
                  && !notificationType.equals(NotificationModuleTypeEnum.WMS_MATERIAL_SELF_PURCHASE_INBOUND.getNotificationType())) {
                  try {
                     URL url = new URL(item.getHookUrl());
                     HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                     connection.setRequestMethod("POST");
                     connection.setRequestProperty("Content-Type", "application/json");
                     connection.setDoOutput(true);
                     String jsonPayload = this.textMessageBody(message, userPhoneList, false);

                     try (OutputStream os = connection.getOutputStream()) {
                        os.write(jsonPayload.getBytes(StandardCharsets.UTF_8));
                        os.flush();
                     }

                     int responseCode = connection.getResponseCode();
                     if (responseCode == 200) {
                        log.info("Webhook配置ID={} 消息发送成功", item.getId());
                     }
                  } catch (Exception e) {
                     log.warn("Webhook配置ID={} 消息发送失败，异常类型={}", item.getId(), e.getClass().getSimpleName());
                  }
               } else {
                  try {
                     URL url = new URL(item.getHookUrl());
                     String jsonBody = this.textMessageBody(message, userPhoneList, true);
                     HttpClient httpClient = HttpClients.createDefault();
                     HttpPost httpPost = new HttpPost(url.toString());
                     httpPost.setHeader("Content-Type", "application/json");
                     StringEntity entity = new StringEntity(jsonBody, "UTF-8");
                     httpPost.setEntity(entity);
                     HttpResponse response = httpClient.execute(httpPost);
                     HttpEntity responseEntity = response.getEntity();
                     if (responseEntity != null) {
                        EntityUtils.consume(responseEntity);
                        log.info("Webhook配置ID={} 响应状态={}", item.getId(), response.getStatusLine().getStatusCode());
                     }
                  } catch (Exception e) {
                     log.warn("Webhook配置ID={} 消息发送失败，异常类型={}", item.getId(), e.getClass().getSimpleName());
                  }
               }
            }
         );
      }
   }

   private String textMessageBody(String message, List<String> userPhoneList, boolean wms) throws java.io.IOException {
      Map<String, Object> body = new LinkedHashMap<>();
      body.put("msgtype", "text");
      Map<String, Object> text = new LinkedHashMap<>();
      text.put("content", message);
      if (wms) {
         // Preserve the original payload until the receiver protocol and test audience are supplied.
         body.put("touser", "@all");
         body.put("agentid", 1000002);
         text.put("mentioned_mobile_list", userPhoneList);
         body.put("safe", 0);
         body.put("enable_id_trans", 0);
         body.put("enable_duplicate_check", 0);
         body.put("duplicate_check_interval", 1800);
      }
      body.put("text", text);
      return new ObjectMapper().writeValueAsString(body);
   }
}
