package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.factory;

import com.hzchum.scim.mes.enclosure.core.api.pojo._do.factory.MesEnclosureFactoryDO;

public class MesEnclosureFactoryDTO extends MesEnclosureFactoryDO {
   @Override
   public String toString() {
      return "MesEnclosureFactoryDTO()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureFactoryDTO)) {
         return false;
      }

      MesEnclosureFactoryDTO other = (MesEnclosureFactoryDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureFactoryDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
