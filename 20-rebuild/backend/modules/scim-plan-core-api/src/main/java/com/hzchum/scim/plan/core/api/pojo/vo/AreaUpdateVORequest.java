package com.hzchum.scim.plan.core.api.pojo.vo;

import com.hzchum.scim.plan.core.api.pojo.dto.AreaUpdateDTOParam;

public class AreaUpdateVORequest extends AreaUpdateDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AreaUpdateVORequest)) {
         return false;
      }

      AreaUpdateVORequest other = (AreaUpdateVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof AreaUpdateVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "AreaUpdateVORequest()";
   }
}
