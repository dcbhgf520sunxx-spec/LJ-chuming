package com.hzchum.scim.common.core.api.enums.oa;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum OaUserStatusEnum {
   PRACTICE(0, "试用"),
   OFFICIAL(1, "正式"),
   A_SIGN(2, "临时"),
   PROBATION_EXTENSION(3, "试用延期"),
   DISMISS(4, "解聘"),
   DIMISSION(5, "离职"),
   RETIRE(6, "退休"),
   IN_VAIN(7, "无效");

   private Integer type;
   private String name;

   OaUserStatusEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static String getName(Integer type) {
      for (OaUserStatusEnum approveTemplateVersionsFlowEnum : values()) {
         if (approveTemplateVersionsFlowEnum.getType().equals(type)) {
            return approveTemplateVersionsFlowEnum.getName();
         }
      }

      return null;
   }

   public static List<Map<String, String>> getAll() {
      List<Map<String, String>> maps = new ArrayList<>();

      for (OaUserStatusEnum approveTemplateVersionsFlowEnum : EnumSet.allOf(OaUserStatusEnum.class)) {
         Map<String, String> integerStringHashMap = new HashMap<>();
         integerStringHashMap.put("type", approveTemplateVersionsFlowEnum.type.toString());
         integerStringHashMap.put("name", approveTemplateVersionsFlowEnum.name);
         maps.add(integerStringHashMap);
      }

      return maps;
   }

   public static OaUserStatusEnum selectType(Integer type) {
      for (OaUserStatusEnum value : values()) {
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
