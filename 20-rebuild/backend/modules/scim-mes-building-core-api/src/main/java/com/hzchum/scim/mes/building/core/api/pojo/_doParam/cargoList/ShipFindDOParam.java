package com.hzchum.scim.mes.building.core.api.pojo._doParam.cargoList;

public class ShipFindDOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ShipFindDOParam)) {
         return false;
      }

      ShipFindDOParam other = (ShipFindDOParam)o;
      return other.canEqual(this);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ShipFindDOParam;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "ShipFindDOParam()";
   }
}
