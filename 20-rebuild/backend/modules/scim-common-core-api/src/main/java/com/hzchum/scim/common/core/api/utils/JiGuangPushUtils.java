package com.hzchum.scim.common.core.api.utils;

import cn.hutool.json.JSONUtil;
import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpResponse;

public class JiGuangPushUtils {
   public static void main(String[] args) {
      pushMessage("!11", Arrays.asList("13065ffa4f05b68ddfe"));
   }

   public static String getAuthHeader() {
      String appKey = java.util.Objects.requireNonNull(System.getenv("LJAPS_JIGUANG_APP_KEY"), "LJAPS_JIGUANG_APP_KEY is required");
      String masterSecret = java.util.Objects.requireNonNull(System.getenv("LJAPS_JIGUANG_MASTER_SECRET"), "LJAPS_JIGUANG_MASTER_SECRET is required");
      String combined = appKey + ":" + masterSecret;
      String base64AuthString = Base64.getEncoder().encodeToString(combined.getBytes());
      Preconditions.checkArgument(StringUtils.isNotBlank(base64AuthString), "极光获取请求头失败!!!!");
      return " Basic " + base64AuthString;
   }

   public static void pushMessage(String message, List<String> registrationIdList) {
      String authHeader = getAuthHeader();
      Map<String, String> headers = new HashMap<>();
      headers.put("Authorization", authHeader);
      Map<String, Object> body = new HashMap<>();
      body.put("platform", "all");
      Map<String, Object> audience = new HashMap<>();
      audience.put("registration_id", registrationIdList);
      body.put("audience", audience);
      Map<String, Object> notification = new HashMap<>();
      notification.put("alert", message);
      Map<String, String> android = new HashMap<>();
      android.put("title", "初鸣数智-消息提醒");
      notification.put("android", android);
      Map<String, String> voip = new HashMap<>();
      voip.put("key", "value");
      notification.put("voip", voip);
      Map<String, String> ios = new HashMap<>();
      ios.put("badge", "+1");
      ios.put("sound", "default");
      ios.put("thread-id", "default");
      notification.put("ios", ios);
      body.put("notification", notification);
      Map<String, Object> options = new HashMap<>();
      Map<String, Object> thirdPartyChannel = new HashMap<>();
      Map<String, Object> xiaomi = new HashMap<>();
      xiaomi.put("distribution", "secondary_push");
      xiaomi.put("channel_id", "132339");
      xiaomi.put("style", 1);
      xiaomi.put("distribution_fcm", "fcm");
      xiaomi.put("skip_quota", true);
      thirdPartyChannel.put("xiaomi", xiaomi);
      thirdPartyChannel.put("oppo", xiaomi);
      options.put("third_party_channel", thirdPartyChannel);
      options.put("classification", 1);
      options.put("apns_production", true);
      body.put("options", options);
      System.out.println(body.toString());

      try {
         HttpResponse e = HttpUtils.doPost("https://api.jpush.cn", "/v3/push", "POST", headers, null, JSONUtil.parse(body).toString());
      } catch (Exception e) {
         e.printStackTrace();
      }
   }
}
