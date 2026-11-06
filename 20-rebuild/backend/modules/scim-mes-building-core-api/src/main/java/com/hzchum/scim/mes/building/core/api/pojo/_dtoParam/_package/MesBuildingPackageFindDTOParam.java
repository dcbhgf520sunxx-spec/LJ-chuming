package com.hzchum.scim.mes.building.core.api.pojo._dtoParam._package;

import com.hzchum.scim.mes.building.core.api.pojo._doParam._package.MesBuildingPackageDOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingPackage对象", description = "包 ")
public class MesBuildingPackageFindDTOParam extends MesBuildingPackageDOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPackageFindDTOParam)) {
         return false;
      }

      MesBuildingPackageFindDTOParam other = (MesBuildingPackageFindDTOParam)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingPackageFindDTOParam;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "MesBuildingPackageFindDTOParam()";
   }
}
