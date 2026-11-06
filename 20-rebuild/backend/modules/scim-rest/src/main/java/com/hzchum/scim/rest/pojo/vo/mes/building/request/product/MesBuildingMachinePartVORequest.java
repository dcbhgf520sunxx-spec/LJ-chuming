package com.hzchum.scim.rest.pojo.vo.mes.building.request.product;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.product.MesBuildingMachinePartDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingMachinePartVORequest", description = "零件  ")
public class MesBuildingMachinePartVORequest extends MesBuildingMachinePartDTOParam {
   @Override
   public String toString() {
      return "MesBuildingMachinePartVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartVORequest)) {
         return false;
      }

      MesBuildingMachinePartVORequest other = (MesBuildingMachinePartVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingMachinePartVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
