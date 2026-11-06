package com.hzchum.scim.system.core.api.common.enums;

import java.util.Arrays;
import java.util.Optional;

public enum SysDrawingRecognitionRulesEnums {
   ARTIFACTS(1, "构件号"),
   DRAWING__ARTIFACTS(2, "图号+构件号");

   private Integer type;
   private String name;

   SysDrawingRecognitionRulesEnums(Integer type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<SysDrawingRecognitionRulesEnums> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public static String getNameByType(Integer type) {
      for (SysDrawingRecognitionRulesEnums ele : values()) {
         if (ele.getType().equals(type)) {
            return ele.getName();
         }
      }

      return null;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
