package com.hzchum.scim.common.core.api.enums;

import java.util.stream.Stream;

public enum NationEnum {
   HAN("汉族"),
   ZHUANG("壮族"),
   HUI("回族"),
   MAN("满族"),
   WEI_WU_ER("维吾尔族"),
   MIAO("苗族"),
   YI("彝族"),
   TU_JIA("土家族"),
   ZHANG("藏族"),
   MENG_GU("蒙古族"),
   DONG("侗族"),
   BU_YI("布依族"),
   YAO("瑶族"),
   BAI("白族"),
   CHAO_XIAN("朝鲜族"),
   HA_NE("哈尼族"),
   LI("黎族"),
   HA_SA_KE("哈萨克族"),
   DAI("傣族"),
   SHE("畲族"),
   LI_SU("傈僳族"),
   DONG_XIANG("东乡族"),
   GE_LAO("仡佬族"),
   LA_HU("拉祜族"),
   WA("佤族"),
   SHUI("水族"),
   NA_XI("纳西族"),
   QIANG("羌族"),
   TU("土族"),
   MU_LAO("仫佬族"),
   XI_BO("锡伯族"),
   KE_ER_KE_ZI("柯尔克孜族"),
   JING_PO("景颇族"),
   DA_WO_ER("达斡尔族"),
   SA_LA("撒拉族"),
   BU_LANG("布朗族"),
   MAO_MAN("毛南族"),
   TA_JI_KE("塔吉克族"),
   PU_MI("普米族"),
   A_CHANG("阿昌族"),
   NU("怒族"),
   E_WEN_KE("鄂温克族"),
   JING("京族"),
   JI_NUO("基诺族"),
   DE_ANG("德昂族"),
   BAO_AN("保安族"),
   E_LOU_SI("俄罗斯族"),
   YU_GU("裕固族"),
   WU_ZI_BIE_KE("乌孜别克族"),
   MEN_BA("门巴族"),
   E_LUN_CHUN("鄂伦春族"),
   DU_LONG("独龙族"),
   HE_ZHE("赫哲族"),
   GAO_SHAN("高山族"),
   LUO_BA("珞巴族"),
   TA_TA_ER("塔塔尔族"),
   OTHER("其他民族");

   private final String name;

   public static boolean exists(String name) {
      return Stream.of(values()).anyMatch(e -> e.name.equals(name));
   }

   public String getName() {
      return this.name;
   }

   NationEnum(final String name) {
      this.name = name;
   }
}
