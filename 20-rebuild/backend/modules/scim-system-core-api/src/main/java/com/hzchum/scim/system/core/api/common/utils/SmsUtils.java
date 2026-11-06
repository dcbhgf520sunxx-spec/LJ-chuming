package com.hzchum.scim.system.core.api.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.exceptions.ServerException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class SmsUtils {
   private static final Logger LOGGER = LoggerFactory.getLogger(SmsUtils.class);
   @Autowired
   private IAcsClient client;

   private SmsUtils() {
   }

   @Bean
   public IAcsClient taobaoClient() {
      DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", System.getenv("LJAPS_SMS_ACCESS_KEY_ID"), System.getenv("LJAPS_SMS_ACCESS_KEY_SECRET"));
      return new DefaultAcsClient(profile);
   }

   public boolean sendSms(String phone, String message, String temCode) {
      CommonRequest request = new CommonRequest();
      request.setSysMethod(MethodType.POST);
      request.setSysDomain("dysmsapi.aliyuncs.com");
      request.setSysAction("SendSms");
      request.setSysVersion("2017-05-25");
      request.putQueryParameter("RegionId", "cn-hangzhou");
      request.putQueryParameter("PhoneNumbers", phone);
      request.putQueryParameter("SignName", "初鸣数智");
      request.putQueryParameter("TemplateCode", temCode);
      request.putQueryParameter("TemplateParam", message);
      boolean result = false;

      try {
         try {
            CommonResponse response = this.client.getCommonResponse(request);
            JSONObject json = JSON.parseObject(response.getData());
            result = "OK".equals(json.getString("Code"));
            if (!result) {
               LOGGER.error("短信发送失败，{}", json);
            }
         } catch (ServerException e) {
            LOGGER.error("服务器异常，短信发送失败，请联系管理员, {}", e);
         } catch (ClientException e) {
            LOGGER.error("客户端异常，短信发送失败，请联系管理员, {}", e);
         }

         return result;
      } finally {
         ;
      }
   }
}
