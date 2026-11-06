package com.hzchum.scim.bim.core.api.enums;

import java.util.Arrays;
import java.util.Optional;

public enum BimTeklaEditionEnum {
   SIXTEEN(16),
   SEVENTEEN(17),
   EIGHTEEN(18),
   NINETEEN(19),
   TWENTY(20),
   TWENTY_ONE(21),
   TWENTY_TWO(22);

   private Integer type;

   BimTeklaEditionEnum(Integer type) {
      this.type = type;
   }

   public static boolean isExist(Integer type) {
      Optional<BimTeklaEditionEnum> optional = Arrays.stream(values()).filter(typeEnum -> typeEnum.getType() == type).findFirst();
      return optional.isPresent();
   }

   public Integer getType() {
      return this.type;
   }
}
