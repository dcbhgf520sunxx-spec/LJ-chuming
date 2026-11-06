package com.hzchum.scim.rest.pojo.vo.mes.building.request._package;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam._package.MesBuildingPackageUpdateDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "包修改")
public class MesBuildingPackageUpdateVORequest extends MesBuildingPackageUpdateDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingPackageUpdateVORequest)) {
         return false;
      }

      MesBuildingPackageUpdateVORequest other = (MesBuildingPackageUpdateVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingPackageUpdateVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "MesBuildingPackageUpdateVORequest()";
   }
}
