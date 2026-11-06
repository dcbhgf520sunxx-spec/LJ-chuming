package com.hzchum.scim.bid.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum DocumentTemplateEnum {
   MATERIAL_PURCHASE(1, "材料采购模板"),
   EQUIPMENT_PROCUREMENT(2, "设备采购模板"),
   TECHNICAL_TENDER(3, "技术招标模板");

   private Integer type;
   private String name;

   DocumentTemplateEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(Integer type) {
      Optional<DocumentTemplateEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getCode(Integer code) {
      for (DocumentTemplateEnum value : values()) {
         if (value.type.equals(code)) {
            return value.name();
         }
      }

      return null;
   }

   public static String getNameByType(Integer type) {
      Optional<DocumentTemplateEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
