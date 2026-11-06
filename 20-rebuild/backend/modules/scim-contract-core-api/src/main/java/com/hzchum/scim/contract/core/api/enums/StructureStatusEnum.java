package com.hzchum.scim.contract.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum StructureStatusEnum {
   WORKSHOP(1, "厂房"),
   FRAME(2, "框架类"),
   SPACE(4, "空间结构"),
   BEAM_TYPE(8, "梁式"),
   ARCH_TYPE(16, "拱式"),
   STEEL_FRAME(32, "钢架");

   private final Integer type;
   private final String name;

   public static String getNameByType(Integer type) {
      Optional<StructureStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.map(StructureStatusEnum::getName).orElse(null);
   }

   public static StructureStatusEnum getByType(Integer type) {
      return Arrays.stream(values()).filter(e -> e.getType().equals(type)).findFirst().orElse(null);
   }

   public static Boolean isExist(String name) {
      return Arrays.stream(values()).anyMatch(e -> e.getName().equals(name));
   }

   StructureStatusEnum(final Integer type, final String name) {
      this.type = type;
      this.name = name;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
