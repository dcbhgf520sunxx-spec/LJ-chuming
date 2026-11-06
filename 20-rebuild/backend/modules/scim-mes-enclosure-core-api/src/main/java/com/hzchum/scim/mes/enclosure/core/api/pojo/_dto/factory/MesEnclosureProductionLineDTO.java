package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory;

import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureProductionLineDO;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesEnclosureProductionLineDTO", description = "")
public class MesEnclosureProductionLineDTO extends MesEnclosureProductionLineDO {
   @Override
   public String toString() {
      return "MesEnclosureProductionLineDTO()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProductionLineDTO)) {
         return false;
      }

      MesEnclosureProductionLineDTO other = (MesEnclosureProductionLineDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureProductionLineDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
