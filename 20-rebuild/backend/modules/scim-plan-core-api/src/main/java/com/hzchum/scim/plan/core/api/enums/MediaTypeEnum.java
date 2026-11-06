package com.hzchum.scim.plan.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum MediaTypeEnum {
   STEEL_PLATE(1, "钢板", "S"),
   PROXIMATE_MATTER(2, "型材", "S"),
   COIL(4, "钢卷", "SC"),
   AUXILIARY_MATERIAL(8, "辅材", "AM");

   private Integer type;
   private String name;
   private String code;

   MediaTypeEnum(int type, String name, String code) {
      this.type = type;
      this.name = name;
      this.code = code;
   }

   public static boolean isExist(int type) {
      Optional<MediaTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      Optional<MediaTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getName() : null;
   }

   public static String getCodeByType(Integer type) {
      Optional<MediaTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent() ? optional.get().getCode() : null;
   }

   public static Boolean checkMediaTy(Integer value) {
      return (STEEL_PLATE.getType() & value | PROXIMATE_MATTER.getType() & value) != 0;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public String getCode() {
      return this.code;
   }
}
