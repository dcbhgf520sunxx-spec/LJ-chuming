package com.hzchum.scim.business.core.api.pojo.dto;

import com.hzchum.scim.business.core.api.pojo._do.CheckInfoDO;

public class CheckInfoDTO extends CheckInfoDO {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CheckInfoDTO)) {
         return false;
      }

      CheckInfoDTO other = (CheckInfoDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CheckInfoDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "CheckInfoDTO()";
   }
}
