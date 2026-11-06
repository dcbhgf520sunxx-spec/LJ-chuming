package com.hzchum.scim.rest.pojo.vo.mes.building.request._package;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam._package.MesBuildingPackageAddDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingPackage对象", description = "包 ")
public class MesBuildingPackageAddVORequest extends MesBuildingPackageAddDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPackageAddVORequest)) {
         return false;
      }

      MesBuildingPackageAddVORequest other = (MesBuildingPackageAddVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingPackageAddVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "MesBuildingPackageAddVORequest()";
   }
}
