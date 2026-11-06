package com.hzchum.scim.plan.core.api.pojo.vo;

import com.hzchum.scim.plan.core.api.pojo.dto.AreaSaveDTOParam;

public class AreaSaveVORequest extends AreaSaveDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AreaSaveVORequest)) {
         return false;
      }

      AreaSaveVORequest other = (AreaSaveVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof AreaSaveVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "AreaSaveVORequest()";
   }
}
