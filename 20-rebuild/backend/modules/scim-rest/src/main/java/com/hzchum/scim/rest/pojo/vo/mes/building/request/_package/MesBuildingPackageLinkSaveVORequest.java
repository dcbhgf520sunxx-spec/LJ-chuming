package com.hzchum.scim.rest.pojo.vo.mes.building.request._package;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam._package.MesBuildingPackageLinkDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingPackageLink对象", description = "包的产品关联表 ")
public class MesBuildingPackageLinkSaveVORequest extends MesBuildingPackageLinkDTOParam {
   @Override
   public String toString() {
      return "MesBuildingPackageLinkSaveVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPackageLinkSaveVORequest)) {
         return false;
      }

      MesBuildingPackageLinkSaveVORequest other = (MesBuildingPackageLinkSaveVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingPackageLinkSaveVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
