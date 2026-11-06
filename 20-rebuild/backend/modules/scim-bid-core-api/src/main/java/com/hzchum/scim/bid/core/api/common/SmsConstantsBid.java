package com.hzchum.scim.bid.core.api.common;

public class SmsConstantsBid {
   public static final String SMS_SIGN_TITLE = "初鸣筑迈汇";
   public static final String DRAFT_SMS_TEMPLATE = "SMS_227255874";
   public static final String THE_SMS_TEMPLATE_CONTENT = "尊敬的供应商 您好！您参与的由${companyName}发布的《${name}》招标项目已结束,编号《${contractNo}》。恭喜您，已被列为拟中标单位，请做好相关后续工作准备。";
   public static final String NEXT_SMS_TEMPLATE_DISPLAYED = "SMS_257830206";
   public static final String THE_NEXT_ROUND_SMS_TEMPLATE_CONTENT_DISPLAYED = "尊敬的供应商 您好！您投标的${companyName}招标项目:《${name}》,已进入下一轮投标，编号:《${contractNo}》,请继续报价，投标截止时间：${bidDeadline}，请及时登陆：https://cmiiot.hzchum.com/查看";
   public static final String THE_SMS_TEMPLATE_NOT_SELECTED = "SMS_228116820";
   public static final String THE_SMS_TEMPLATE_CONTENT_NOT_MARKED = "尊敬的供应商 您好！您参与的由${companyName}发布的《${name}》招标项目已结束,编号《${contractNo}》。很遗憾！您此次未能中标，感谢您对我司工作的配合和支持！";
   public static final String INVITED_TENDERING = "尊敬的供应商 您好！${companyName}发布招标项目:《${name}》，编号《${contractNo}》,已正式生效，投标截止时间：${bidDeadline}，请及时登陆：https://cmiiot.hzchum.com/查看";
   public static final String INVITED_TENDERING_CODE = "SMS_257810184";
   public static final String INFORMATION_UPDATE = "尊敬的供应商 您好！您投标的${companyName}招标项目:《${name}》,编号:《${contractNo}》，评标信息已更新，请及时登陆：https://cmiiot.hzchum.com/查看。";
   public static final String INFORMATION_UPDATE_CODE = "SMS_257830208";
   public static final String SMS_USE = "用于发送招标短信通知";

   private SmsConstantsBid() {
   }
}
