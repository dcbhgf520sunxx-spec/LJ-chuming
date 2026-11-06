package com.hzchum.scim.wms.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum QualityTestingEnum {
   UN_REVIEWED(1, "待审核"),
   ALL_PASS(2, "全部通过"),
   PART_PASS(4, "部分通过"),
   ALL_RETURN(8, "全部退回"),
   NO(16, "无质检");

   private Integer type;
   private String name;

   QualityTestingEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<QualityTestingEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
