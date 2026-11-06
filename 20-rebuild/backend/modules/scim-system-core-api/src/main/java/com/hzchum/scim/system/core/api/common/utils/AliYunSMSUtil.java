package com.hzchum.scim.system.core.api.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.hzchum.scim.system.core.api.pojo.dto.SmsSendResult;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AliYunSMSUtil {
   private static final String ACCESS_KEY_ID = System.getenv("LJAPS_SMS_ACCESS_KEY_ID");
   private static final String ACCESS_KEY_SECRET = System.getenv("LJAPS_SMS_ACCESS_KEY_SECRET");
   private static final String SIGN_NAME = "初鸣数智";
   private static final String REGION_ID = "cn-hangzhou";
   private static final String SYS_DOMAIN = "dysmsapi.aliyuncs.com";
   private static final String SYS_VERSION = "2017-05-25";
   private static final Pattern PATTERN = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
   private static final Logger log = LoggerFactory.getLogger(AliYunSMSUtil.class);
   private static final IAcsClient client;
   private static final CommonRequest request = new CommonRequest();

   public static boolean isPhoneNumber(String phoneNumber) {
      Matcher m = PATTERN.matcher(phoneNumber);
      return m.matches();
   }

   public static SmsSendResult sendMessage(String phoneNumber, String templateCode, Map<String, String> templateParam) {
      SmsSendResult sendResult = new SmsSendResult();
      if (!isPhoneNumber(phoneNumber)) {
         log.info("手机号码不合法！");
         sendResult.setBoolSuccess(false);
         sendResult.setErrorMessage("手机号码不合法");
         return sendResult;
      }

      request.putQueryParameter("PhoneNumbers", phoneNumber);
      String templateParamJson = JSON.toJSONString(templateParam);
      request.putQueryParameter("TemplateParam", templateParamJson);
      request.putQueryParameter("TemplateCode", templateCode);

      try {
         CommonResponse commonResponse = client.getCommonResponse(request);
         log.info("查看发送结果信息：" + commonResponse.getData());
         JSONObject json = JSON.parseObject(commonResponse.getData());
         boolean result = "OK".equals(json.getString("Code"));
         if (!result) {
            log.error("短信发送失败，{}", json);
            sendResult.setBoolSuccess(false);
            sendResult.setErrorMessage(String.valueOf(json));
            return sendResult;
         }
      } catch (Exception e) {
         log.error("本次发送失败，请查看错误信息：" + e.getMessage());
         e.printStackTrace();
         sendResult.setBoolSuccess(false);
         sendResult.setErrorMessage(e.getMessage());
         return sendResult;
      }

      log.info("短信发送成功！");
      sendResult.setBoolSuccess(true);
      sendResult.setErrorMessage("");
      return sendResult;
   }

   static {
      DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", ACCESS_KEY_ID, ACCESS_KEY_SECRET);
      client = new DefaultAcsClient(profile);
      request.setSysMethod(MethodType.POST);
      request.setSysDomain("dysmsapi.aliyuncs.com");
      request.setSysVersion("2017-05-25");
      request.setSysAction("SendSms");
      request.putQueryParameter("RegionId", "cn-hangzhou");
      request.putQueryParameter("SignName", "初鸣数智");
   }
}
