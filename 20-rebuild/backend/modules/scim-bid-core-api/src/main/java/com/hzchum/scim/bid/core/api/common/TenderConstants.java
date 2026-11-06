package com.hzchum.scim.bid.core.api.common;

public class TenderConstants {
   public static final String TITLE = "XXX公司采购公告";
   public static final String REASONS = "经XXX公司确认，项目资金为自筹。项目已具备招标条件，现对该项目进行采购公告。特邀请供应商前来投标，现将有关事项公告如下";
   public static final String PURCHASING = "自主招标";
   public static final String QUALIFICATIONS_BIDDER = "1. 合法存续、具有独立运作能力（包括运营、财务、组织、管理、市场等状况）并能够承担法律责任的企事业单位；\n2. 遵守国家法律法规，具有良好的商业信誉和健全的财务会计制度，过去三年内经营活动中未出现违规违法等不良记录；\n3. 愿意且有能力为我司提供产品或服务，并接受我司的监督管理；\n4. 应具有履行合同所必需的设备、人员和专业技术能力；\n5. 具有签订及履行合同的能力和信誉；\n6. 应符合法律、行政法规规定的其他条件；\n7. 不得将本项目以任何方式进行转包；\n8. 承包（投标）人必须为施工承包商库内企业，库外企业无参与资格（本条内容视是否允许未审核供应商而定）；\n9. 投标人未被列入招标投标失信黑名单，未被列入失信被执行人名单，未被工商行政管理部门列入企业经营异常名录；\n10. 法定代表人为同一个人的两个及两个以上法人，母公司与全资子公司/由其控股的子公司，不得同时报名参加本项目。第一次报价不得高于标书价；每次报价不得高于上一次报价，否则作废标处理";
   public static final String APPLY = "1. 报名：本项目实行网上报名，报名单位需要在投标截止日前完成保证金的递交；\n2.本项目招标文件和补充（答疑、澄清）、修改文件以网上下载方式发放;\n3.招标文件网上下载时间：2021-08-05 00:00:00至2021-08-10 10:30:00\n4.报名网址：www.jushi.com";
   public static final String CASH_DEPOSIT = System.getenv().getOrDefault("LJAPS_BIDDING_DEPOSIT_TEXT", "");
   public static final String PAYMENT_METHOD = "1.预付款：15%(在本合同生效后15天内支付)\n2.进度款：35%(收到货物及全额发票后30天内支付)\n3.验收款：40%(双方共同签署验收合格单后30天内支付)\n4.质保金：10%(质保12个月且双方无异议的情况下)";
   public static final String QUOTATION_DELIVERY = "1.交货时间：2021-5-30；\n2.交货地点：本部；\n3.含税价：13%增值税专票\n4.交货方式：卖方送货上门；\n5.如中标方延迟交货，则按合同总额2%/天计算处罚。起止日期以双方签订交货日期为准，巨石原因造成延期不做处罚。";
   public static final String CONTACT_WAY = System.getenv().getOrDefault("LJAPS_BIDDING_CONTACT_TEXT", "");
   public static final String REPORT = System.getenv().getOrDefault("LJAPS_BIDDING_REPORT_CONTACT_TEXT", "");

   private TenderConstants() {
   }
}
