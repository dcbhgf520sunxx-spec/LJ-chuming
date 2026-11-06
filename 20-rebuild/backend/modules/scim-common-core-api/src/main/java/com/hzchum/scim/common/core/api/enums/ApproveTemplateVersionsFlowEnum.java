package com.hzchum.scim.common.core.api.enums;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum ApproveTemplateVersionsFlowEnum {
   ALL_SIGN(1, "会签"),
   OR_SIGN(2, "或签"),
   A_SIGN(3, "单签"),
   COPY_SEND(4, "抄送"),
   LAUNCH_APPLICATION(5, "发起申请"),
   QUALITY_TESTING(6, "质检");

   private Integer type;
   private String name;

   ApproveTemplateVersionsFlowEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static String getName(Integer type) {
      for (ApproveTemplateVersionsFlowEnum approveTemplateVersionsFlowEnum : values()) {
         if (approveTemplateVersionsFlowEnum.getType().equals(type)) {
            return approveTemplateVersionsFlowEnum.getName();
         }
      }

      return null;
   }

   public static List<Map<String, String>> getAll() {
      List<Map<String, String>> maps = new ArrayList<>();

      for (ApproveTemplateVersionsFlowEnum approveTemplateVersionsFlowEnum : EnumSet.allOf(ApproveTemplateVersionsFlowEnum.class)) {
         Map<String, String> integerStringHashMap = new HashMap<>();
         integerStringHashMap.put("type", approveTemplateVersionsFlowEnum.type.toString());
         integerStringHashMap.put("name", approveTemplateVersionsFlowEnum.name);
         maps.add(integerStringHashMap);
      }

      return maps;
   }

   public static ApproveTemplateVersionsFlowEnum selectType(Integer type) {
      for (ApproveTemplateVersionsFlowEnum value : values()) {
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
