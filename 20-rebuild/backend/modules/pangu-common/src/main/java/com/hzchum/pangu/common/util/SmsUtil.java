package com.hzchum.pangu.common.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.hzchum.pangu.common.config.SmsProperties;
import com.hzchum.pangu.common.enums.ResultCodeEnum;
import com.hzchum.pangu.common.exception.BusinessException;
import javax.annotation.Resource;
import org.springframework.stereotype.Component;

@Component
public class SmsUtil {
   private final String ENDPOINT = "dysmsapi.aliyuncs.com";
   @Resource
   private SmsProperties smsProperties;

   public JSONObject sendSms(String phone, String templateCode, String templateParam) {
      CommonRequest request = new CommonRequest();
      request.setSysAction("SendSms");
      request.putQueryParameter("PhoneNumbers", phone);
      request.putQueryParameter("SignName", this.smsProperties.getSignName());
      request.putQueryParameter("TemplateCode", templateCode);
      request.putQueryParameter("TemplateParam", templateParam);
      return this.getCommonResponse(request);
   }

   public JSONObject sendSmsBid(String phone, String templateCode, String templateParam) {
      CommonRequest request = new CommonRequest();
      request.setSysAction("SendSms");
      request.putQueryParameter("PhoneNumbers", phone);
      request.putQueryParameter("SignName", this.smsProperties.getSignTitle());
      request.putQueryParameter("TemplateCode", templateCode);
      request.putQueryParameter("TemplateParam", templateParam);
      return this.getCommonResponse(request);
   }

   public JSONObject deleteSmsTemplate(String templateCode) {
      CommonRequest request = new CommonRequest();
      request.setSysAction("DeleteSmsTemplate");
      request.putQueryParameter("TemplateCode", templateCode);
      return this.getCommonResponse(request);
   }

   public JSONObject addSmsTemplate(String templateType, String templateName, String templateContent, String remark) {
      CommonRequest request = new CommonRequest();
      request.setSysAction("AddSmsTemplate");
      request.putQueryParameter("TemplateType", templateType);
      request.putQueryParameter("TemplateName", templateName);
      request.putQueryParameter("TemplateContent", templateContent);
      request.putQueryParameter("Remark", remark);
      return this.getCommonResponse(request);
   }

   public JSONObject modifySmsTemplate(String templateType, String templateName, String templateCode, String templateContent, String remark) {
      CommonRequest request = new CommonRequest();
      request.setSysAction("ModifySmsTemplate");
      request.putQueryParameter("TemplateType", templateType);
      request.putQueryParameter("TemplateName", templateName);
      request.putQueryParameter("TemplateCode", templateCode);
      request.putQueryParameter("TemplateContent", templateContent);
      request.putQueryParameter("Remark", remark);
      return this.getCommonResponse(request);
   }

   public JSONObject querySmsTemplate(String templateCode) {
      CommonRequest request = new CommonRequest();
      request.setSysAction("QuerySmsTemplate");
      request.putQueryParameter("TemplateCode", templateCode);
      return this.getCommonResponse(request);
   }

   private JSONObject getCommonResponse(CommonRequest request) {
      DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", this.smsProperties.getAccessKeyId(), this.smsProperties.getAccessKeySecret());
      DefaultAcsClient client = new DefaultAcsClient(profile);
      request.setSysMethod(MethodType.POST);
      request.setSysDomain("dysmsapi.aliyuncs.com");
      request.setSysVersion("2017-05-25");

      CommonResponse response;
      try {
         response = client.getCommonResponse(request);
      } catch (Exception e) {
         throw new BusinessException(ResultCodeEnum.SMS_REQUEST_FAIL);
      }

      JSONObject json = JSON.parseObject(response.getData());
      if ("OK".equals(json.getString("Code"))) {
         return json;
      } else {
         throw new BusinessException(ResultCodeEnum.SMS_ERROR, json.getString("Message"));
      }
   }
}
