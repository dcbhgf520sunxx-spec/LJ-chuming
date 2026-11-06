package com.hzchum.scim.plan.core.api.enums;

import java.util.Arrays;
import org.apache.commons.lang3.StringUtils;

public enum AuxiliaryUsePropertyEnum {
   SITE_USE(1, "工地"),
   FACTORY_USE(2, "工厂");

   private final Integer type;
   private final String desc;

   public static Boolean isExist(Integer type) {
      return Arrays.stream(values()).anyMatch(s -> s.getType().equals(type));
   }

   public static Boolean isNameExist(String name) {
      return StringUtils.isBlank(name) ? Boolean.FALSE : Arrays.stream(values()).anyMatch(e -> e.getDesc().contains(name));
   }

   public static Integer getTypeByName(String name) {
      AuxiliaryUsePropertyEnum[] enums = values();

      for (AuxiliaryUsePropertyEnum anEnum : enums) {
         if (anEnum.getDesc().equals(name)) {
            return anEnum.getType();
         }
      }

      return null;
   }

   AuxiliaryUsePropertyEnum(final Integer type, final String desc) {
      this.type = type;
      this.desc = desc;
   }

   public Integer getType() {
      return this.type;
   }

   public String getDesc() {
      return this.desc;
   }
}
