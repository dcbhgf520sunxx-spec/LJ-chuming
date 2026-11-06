package com.hzchum.scim.system.core.api.common.enums;

import com.hzchum.pangu.common.exception.BusinessException;
import java.util.Arrays;
import java.util.Optional;

public enum EnclosureDictionaryTypeEnum {
   PROFILED_PLATE(2, "压型彩板", "PROFILED_PLATE"),
   SANDWICH_BOARD(4, "夹芯板", "SANDWICH_BOARD"),
   TRUSS_FLOOR_PLATE(8, "桁架楼承板", "TRUSS_FLOOR_PLATE"),
   PRESSURE_BEARING_PLATE(16, "压型楼承板", "PRESSURE_BEARING_PLATE"),
   EDGEFOLD(32, "折边件", "EDGEFOLD");

   private Integer type;
   private String name;
   private String desc;

   public static boolean isExist(Integer type) {
      Optional<EnclosureDictionaryTypeEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.isPresent();
   }

   public static String getDesByType(Integer type) {
      for (EnclosureDictionaryTypeEnum value : values()) {
         if (value.type.equals(type)) {
            return value.getDesc();
         }
      }

      throw new BusinessException("围护类型错误!");
   }

   public static String getNameByType(Integer type) {
      for (EnclosureDictionaryTypeEnum value : values()) {
         if (value.type.equals(type)) {
            return value.getName();
         }
      }

      throw new BusinessException("围护类型错误!");
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public String getDesc() {
      return this.desc;
   }

   EnclosureDictionaryTypeEnum(final Integer type, final String name, final String desc) {
      this.type = type;
      this.name = name;
      this.desc = desc;
   }
}
