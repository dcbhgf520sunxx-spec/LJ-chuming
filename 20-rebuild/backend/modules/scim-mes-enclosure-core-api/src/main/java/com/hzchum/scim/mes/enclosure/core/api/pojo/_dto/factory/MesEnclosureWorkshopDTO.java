package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory;

import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureWorkshopDO;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesEnclosureWorkshopDTO", description = "")
public class MesEnclosureWorkshopDTO extends MesEnclosureWorkshopDO {
   @Override
   public String toString() {
      return "MesEnclosureWorkshopDTO()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureWorkshopDTO)) {
         return false;
      }

      MesEnclosureWorkshopDTO other = (MesEnclosureWorkshopDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureWorkshopDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
