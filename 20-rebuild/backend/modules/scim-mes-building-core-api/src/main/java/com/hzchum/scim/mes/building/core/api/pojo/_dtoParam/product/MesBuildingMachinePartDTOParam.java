package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.product;

import com.hzchum.scim.mes.building.core.api.pojo._doParam.product.MesBuildingMachinePartDOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingMachinePartDTOParam", description = "")
public class MesBuildingMachinePartDTOParam extends MesBuildingMachinePartDOParam {
   @Override
   public String toString() {
      return "MesBuildingMachinePartDTOParam()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartDTOParam)) {
         return false;
      }

      MesBuildingMachinePartDTOParam other = (MesBuildingMachinePartDTOParam)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingMachinePartDTOParam;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
