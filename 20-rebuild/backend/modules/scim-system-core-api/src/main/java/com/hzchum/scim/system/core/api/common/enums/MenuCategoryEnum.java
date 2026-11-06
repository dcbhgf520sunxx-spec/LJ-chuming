package com.hzchum.scim.system.core.api.common.enums;

import java.util.ArrayList;
import java.util.List;

public enum MenuCategoryEnum {
   PC(0, "PC", 1),
   APP(1, "APP", 1),
   IOT_PC(2, "IOT_PC", 2),
   IOT_APP(4, "IOT_APP", 2);

   private int value;
   private String name;
   private int type;

   MenuCategoryEnum(int value, String name, int type) {
      this.value = value;
      this.name = name;
      this.type = type;
   }

   public int getValue() {
      return this.value;
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   public static Integer getMenuSystemEnum(Integer value) {
      if (PC.value == value || APP.value == value) {
         return MenuSystemEnum.CONTAINS.getType();
      } else {
         return IOT_PC.value != value && IOT_APP.value != value ? null : MenuSystemEnum.NOT_CONTAINS.getType();
      }
   }

   public static List<Integer> getValuesByType(Integer type) {
      List<Integer> valueList = new ArrayList<>();
      if (type != null) {
         for (MenuCategoryEnum categoryEnum : values()) {
            if (categoryEnum.getType() == type) {
               valueList.add(categoryEnum.getValue());
            }
         }
      }

      return valueList;
   }
}
