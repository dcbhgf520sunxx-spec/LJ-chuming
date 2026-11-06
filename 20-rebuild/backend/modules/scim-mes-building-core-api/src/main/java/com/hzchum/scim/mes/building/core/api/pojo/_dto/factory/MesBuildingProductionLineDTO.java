package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingProductionLineDO;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingProductionLineDTO", description = "")
public class MesBuildingProductionLineDTO extends MesBuildingProductionLineDO {
   @Override
   public String toString() {
      return "MesBuildingProductionLineDTO()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductionLineDTO)) {
         return false;
      }

      MesBuildingProductionLineDTO other = (MesBuildingProductionLineDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingProductionLineDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
