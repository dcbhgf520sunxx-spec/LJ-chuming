package com.hzchum.scim.common.core.api.enums.oa;

import com.google.common.base.Preconditions;
import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public enum OaWorkflowNameEnum {
   PROCESS_PAYMENT(5120, "外委加工合同审批/结算流程（初鸣）"),
   CONTRACT_SETTLE(5119, "材料合同审批流程（初鸣）"),
   CONTRACT_APPROVE(5117, "材料合同结算资料盖章申请流程（初鸣）"),
   CONTRACT_PAYMENT(5118, "材料合同款项支付审批流程（初鸣）"),
   DEEPEN_DRAWINGS(5121, "深化图纸文件盖章审批流程（初鸣）");

   private Integer type;
   private String name;

   OaWorkflowNameEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static String getName(Integer type) {
      for (OaWorkflowNameEnum approveTemplateVersionsFlowEnum : values()) {
         if (approveTemplateVersionsFlowEnum.getType().equals(type)) {
            return approveTemplateVersionsFlowEnum.getName();
         }
      }

      return null;
   }

   public static Boolean isExist(String name) {
      for (OaWorkflowNameEnum approveTemplateVersionsFlowEnum : values()) {
         if (approveTemplateVersionsFlowEnum.getName().equals(name)) {
            return Boolean.TRUE;
         }
      }

      return Boolean.FALSE;
   }

   public static List<Map<String, String>> getAll() {
      List<Map<String, String>> maps = new ArrayList<>();

      for (OaWorkflowNameEnum approveTemplateVersionsFlowEnum : EnumSet.allOf(OaWorkflowNameEnum.class)) {
         Map<String, String> integerStringHashMap = new HashMap<>();
         integerStringHashMap.put("type", approveTemplateVersionsFlowEnum.type.toString());
         integerStringHashMap.put("name", approveTemplateVersionsFlowEnum.name);
         maps.add(integerStringHashMap);
      }

      return maps;
   }

   public static OaWorkflowNameEnum selectType(Integer type) {
      for (OaWorkflowNameEnum value : values()) {
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
