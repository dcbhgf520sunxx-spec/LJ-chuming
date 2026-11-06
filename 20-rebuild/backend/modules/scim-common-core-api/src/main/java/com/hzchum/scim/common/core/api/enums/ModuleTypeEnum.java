package com.hzchum.scim.common.core.api.enums;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum ModuleTypeEnum {
   WMS(1, "WMS"),
   SUPPLY_CHAIN(2, "供应链"),
   CONTRACT(3, "合同管理"),
   SHIP_MODULE(4, "发运管理"),
   PLAN_MODULE(5, "计划管理"),
   MES(6, "MES"),
   BRIDGE_MES(7, "桥梁MES"),
   PROJECT(8, "项目管理"),
   BIM(9, "bim"),
   OPERATION(10, "运营分析"),
   ENCLOSURE_MES(11, "围护MES"),
   CRM(12, "CRM");

   private Integer type;
   private String name;

   ModuleTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static Boolean exist(String name) {
      for (ModuleTypeEnum moduleTypeEnum : values()) {
         if (moduleTypeEnum.name.equals(name)) {
            return true;
         }
      }

      return false;
   }

   public static String getName(Integer type) {
      for (ModuleTypeEnum moduleTypeEnum : values()) {
         if (moduleTypeEnum.getType().equals(type)) {
            return moduleTypeEnum.getName();
         }
      }

      return null;
   }

   public static List<Map<String, String>> getAll() {
      List<Map<String, String>> maps = new ArrayList<>();

      for (ModuleTypeEnum moduleTypeEnum : EnumSet.allOf(ModuleTypeEnum.class)) {
         Map<String, String> integerStringHashMap = new HashMap<>();
         integerStringHashMap.put("type", moduleTypeEnum.type.toString());
         integerStringHashMap.put("name", moduleTypeEnum.name);
         maps.add(integerStringHashMap);
      }

      return maps;
   }

   public static ModuleTypeEnum selectType(Integer type) {
      for (ModuleTypeEnum value : values()) {
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
