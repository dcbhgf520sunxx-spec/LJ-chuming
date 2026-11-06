package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.hzchum.scim.mes.building.core.api.pojo._do.task.MesBuildingMachinePartSchedulingSummaryDO;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingMachinePartSchedulingSummaryDTO", description = "")
public class MesBuildingMachinePartSchedulingSummaryDTO extends MesBuildingMachinePartSchedulingSummaryDO {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingMachinePartSchedulingSummaryDTO)) {
         return false;
      }

      MesBuildingMachinePartSchedulingSummaryDTO other = (MesBuildingMachinePartSchedulingSummaryDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingMachinePartSchedulingSummaryDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "MesBuildingMachinePartSchedulingSummaryDTO()";
   }
}
