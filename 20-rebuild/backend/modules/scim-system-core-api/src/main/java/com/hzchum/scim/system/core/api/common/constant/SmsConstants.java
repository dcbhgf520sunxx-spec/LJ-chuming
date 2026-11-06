package com.hzchum.scim.system.core.api.common.constant;

public class SmsConstants {
   public static final String SERVER_URL = "dysmsapi.aliyuncs.com";
   public static final String REGION_ID = "cn-hangzhou";
   public static final String ACCESS_KEY_ID = System.getenv("LJAPS_SMS_ACCESS_KEY_ID");
   public static final String ACCESS_KEY_SECRET = System.getenv("LJAPS_SMS_ACCESS_KEY_SECRET");
   public static final String SMS_TYPE = "normal";
   public static final String SMS_SIGN_NAME = "初鸣数智";
   public static final String RESET_PASSWORD_VERIFY_CODE_TEMPLATE = "SMS_170116425";
   public static final String OVERWEIGHT_VERIFY_CODE_TEMPLATE = "SMS_170181398";
   public static final String MODIFY_CARGO_LIST_DRIVER_INFORMATION = "SMS_176911592";
   public static final String RECEIVE_LOGISTICS_INFORMATION_VERIFY_CODE_TEMPLATE = "SMS_195585812";
   public static final String MAINTENANCE_FEE_TEMPLATE1 = "SMS_472985039";
   public static final String MAINTENANCE_FEE_TEMPLATE2 = "SMS_473045044";
   public static final String RENTAL_FEE_TEMPLATE = "SMS_473045027";
   public static final String PROGRESS_PAYMENT_TEMPLATE = "SMS_473190026";
   public static final String WECHAT_BIND_OPENID_LOGIN_TEMPLATE = "SMS_483780039";

   private SmsConstants() {
   }
}
