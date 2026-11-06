package com.hzchum.scim.rest.pojo.vo.mes.building.request._package;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam._package.MesBuildingPackageDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingPackage对象", description = "包 ")
public class MesBuildingPackageSaveVORequest extends MesBuildingPackageDTOParam {
   @Override
   public String toString() {
      return "MesBuildingPackageSaveVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPackageSaveVORequest)) {
         return false;
      }

      MesBuildingPackageSaveVORequest other = (MesBuildingPackageSaveVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingPackageSaveVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
