package com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.get;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingMachinePartSchedulingDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingMachinePartSchedulingVORequest", description = "零件排产请求类")
public class MesBuildingMachinePartSchedulingVORequest extends MesBuildingMachinePartSchedulingDTOParam {
   @Override
   public String toString() {
      return "MesBuildingMachinePartSchedulingVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartSchedulingVORequest)) {
         return false;
      }

      MesBuildingMachinePartSchedulingVORequest other = (MesBuildingMachinePartSchedulingVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingMachinePartSchedulingVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
