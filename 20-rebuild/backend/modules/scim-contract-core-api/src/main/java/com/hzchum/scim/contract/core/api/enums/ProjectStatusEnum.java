package com.hzchum.scim.contract.core.api.enums;

import com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Optional;

public enum ProjectStatusEnum {
   PROCESSING(1, "进行中"),
   PAUSE(2, "暂停"),
   COMPLETED(4, "已完工"),
   SETTLED(8, "已结算"),
   TRUSTEESHIP(16, "已托管");

   private final Integer type;
   private final String name;

   ProjectStatusEnum(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static String getNameByType(Integer type) {
      Optional<ProjectStatusEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType().equals(type)).findFirst();
      return optional.map(ProjectStatusEnum::getName).orElse(null);
   }

   public static Boolean isExist(Integer type) {
      Preconditions.checkArgument(type != null, "type不能为空!");

      for (ProjectStatusEnum value : values()) {
         if (value.getType().equals(type)) {
            return Boolean.TRUE;
         }
      }

      return Boolean.FALSE;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
