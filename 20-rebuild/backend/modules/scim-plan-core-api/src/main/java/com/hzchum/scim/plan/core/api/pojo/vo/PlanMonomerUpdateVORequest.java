package com.hzchum.scim.plan.core.api.pojo.vo;

import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerUpdateDTOParam;

public class PlanMonomerUpdateVORequest extends PlanMonomerUpdateDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanMonomerUpdateVORequest)) {
         return false;
      }

      PlanMonomerUpdateVORequest other = (PlanMonomerUpdateVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof PlanMonomerUpdateVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "PlanMonomerUpdateVORequest()";
   }
}
