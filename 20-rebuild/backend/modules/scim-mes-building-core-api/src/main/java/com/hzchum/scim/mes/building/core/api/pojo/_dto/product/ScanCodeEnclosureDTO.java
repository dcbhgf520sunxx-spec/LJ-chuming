package com.hzchum.scim.mes.building.core.api.pojo._dto.product;

import com.hzchum.scim.common.core.api.pojo.common.EnclosureBaseInfo;

public class ScanCodeEnclosureDTO extends EnclosureBaseInfo {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScanCodeEnclosureDTO)) {
         return false;
      }

      ScanCodeEnclosureDTO other = (ScanCodeEnclosureDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ScanCodeEnclosureDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "ScanCodeEnclosureDTO()";
   }
}
