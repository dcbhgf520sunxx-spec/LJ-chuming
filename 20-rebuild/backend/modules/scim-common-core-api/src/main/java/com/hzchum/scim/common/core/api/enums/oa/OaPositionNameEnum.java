package com.hzchum.scim.common.core.api.enums.oa;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum OaPositionNameEnum {
   CONTRACT_SETTLE(1, "工程总监"),
   ENGINEERING_DIRECTOR(2, "运营副总"),
   GENERAL_MANAGER(3, "总经理"),
   PRESIDENT(4, "董事长"),
   VICE_PRESIDENT(5, "副总裁"),
   GROUP_PRESIDENT(6, "集团总裁");

   private Integer type;
   private String name;

   OaPositionNameEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static String isNUll(String name) {
      for (OaPositionNameEnum approveEnum : values()) {
         if (approveEnum.getName().equals(name)) {
            return approveEnum.getName();
         }
      }

      return null;
   }

   public static List<Map<String, String>> getAll() {
      List<Map<String, String>> maps = new ArrayList<>();

      for (OaPositionNameEnum approveTemplateVersionsFlowEnum : EnumSet.allOf(OaPositionNameEnum.class)) {
         Map<String, String> integerStringHashMap = new HashMap<>();
         integerStringHashMap.put("type", approveTemplateVersionsFlowEnum.type.toString());
         integerStringHashMap.put("name", approveTemplateVersionsFlowEnum.name);
         maps.add(integerStringHashMap);
      }

      return maps;
   }

   public static OaPositionNameEnum selectType(Integer type) {
      for (OaPositionNameEnum value : values()) {
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
