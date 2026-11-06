package com.hzchum.scim.common.core.api.enums.oa;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum OaBusinessTypeEnum {
   CONTRACT(1, "创建合同"),
   PAYMENT(2, "合同付款"),
   SETTLE(3, "合同结算");

   private Integer type;
   private String name;

   OaBusinessTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static String getName(Integer type) {
      for (OaBusinessTypeEnum approveTemplateVersionsFlowEnum : values()) {
         if (approveTemplateVersionsFlowEnum.getType().equals(type)) {
            return approveTemplateVersionsFlowEnum.getName();
         }
      }

      return null;
   }

   public static List<Map<String, String>> getAll() {
      List<Map<String, String>> maps = new ArrayList<>();

      for (OaBusinessTypeEnum approveTemplateVersionsFlowEnum : EnumSet.allOf(OaBusinessTypeEnum.class)) {
         Map<String, String> integerStringHashMap = new HashMap<>();
         integerStringHashMap.put("type", approveTemplateVersionsFlowEnum.type.toString());
         integerStringHashMap.put("name", approveTemplateVersionsFlowEnum.name);
         maps.add(integerStringHashMap);
      }

      return maps;
   }

   public static OaBusinessTypeEnum selectType(Integer type) {
      for (OaBusinessTypeEnum value : values()) {
         if (value.type.equals(type)) {
            return value;
         }
      }

      Preconditions.checkArgument(false, "枚举类未查询到!!");
      return null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
