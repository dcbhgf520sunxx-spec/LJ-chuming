package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam._package;

import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam._package.MesEnclosurePackageDOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesEnclosurePackage对象", description = "包 ")
public class MesEnclosurePackageFindDTOParam extends MesEnclosurePackageDOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosurePackageFindDTOParam)) {
         return false;
      }

      MesEnclosurePackageFindDTOParam other = (MesEnclosurePackageFindDTOParam)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosurePackageFindDTOParam;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "MesEnclosurePackageFindDTOParam()";
   }
}
