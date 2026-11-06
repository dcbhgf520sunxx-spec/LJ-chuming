package com.hzchum.scim.plan.core.api.pojo.vo;

import com.hzchum.scim.plan.core.api.pojo.dto.PlanMonomerSaveDTOParam;

public class PlanMonomerSaveVORequest extends PlanMonomerSaveDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PlanMonomerSaveVORequest)) {
         return false;
      }

      PlanMonomerSaveVORequest other = (PlanMonomerSaveVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof PlanMonomerSaveVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }

   @Override
   public String toString() {
      return "PlanMonomerSaveVORequest()";
   }
}
