package com.hzchum.pangu.common.enums;

import java.util.Arrays;
import java.util.Optional;

public enum DataPermissionTypeEnum {
   SECONDARY_UNIT(1, "二级单位", "secondary_unit_id"),
   FACTORY(2, "工厂", "factory_id");

   private final Integer type;
   private final String name;
   private final String field;

   public static String getFieldByType(Integer type) {
      for (DataPermissionTypeEnum value : values()) {
         if (value.getType().equals(type)) {
            return value.getField();
         }
      }

      return "";
   }

   public static boolean isExist(int type) {
      Optional<DataPermissionTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   DataPermissionTypeEnum(final Integer type, final String name, final String field) {
      this.type = type;
      this.name = name;
      this.field = field;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public String getField() {
      return this.field;
   }
}
