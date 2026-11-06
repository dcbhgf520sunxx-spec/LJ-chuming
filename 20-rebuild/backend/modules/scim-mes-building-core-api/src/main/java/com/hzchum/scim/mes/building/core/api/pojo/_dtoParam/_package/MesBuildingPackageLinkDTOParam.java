package com.hzchum.scim.mes.building.core.api.pojo._dtoParam._package;

import com.hzchum.scim.mes.building.core.api.pojo._doParam._package.MesBuildingPackageLinkDOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingPackageLink对象", description = "包的产品关联表 ")
public class MesBuildingPackageLinkDTOParam extends MesBuildingPackageLinkDOParam {
   @Override
   public String toString() {
      return "MesBuildingPackageLinkDTOParam()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPackageLinkDTOParam)) {
         return false;
      }

      MesBuildingPackageLinkDTOParam other = (MesBuildingPackageLinkDTOParam)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingPackageLinkDTOParam;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
