package com.hzchum.scim.mes.building.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum ProductCategoryTypeEnum {
   SHEET_PART(1, "板材零件"),
   PROFILE_PART(2, "型材零件"),
   WELDED_PROFILE(3, "焊接型材"),
   PRIMARY_SECONDARY(4, "主次构件"),
   ENCLOSURE(5, "围护");

   private int type;
   private String name;

   ProductCategoryTypeEnum(int type, String name) {
      this.type = type;
      this.name = name;
   }

   public static boolean isExist(int type) {
      Optional<QhseTypeEnum> optional = Arrays.stream(QhseTypeEnum.values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public int getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }
}
