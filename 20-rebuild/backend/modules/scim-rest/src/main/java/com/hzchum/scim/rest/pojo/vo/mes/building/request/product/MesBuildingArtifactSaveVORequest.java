package com.hzchum.scim.rest.pojo.vo.mes.building.request.product;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.product.MesBuildingArtifactDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingArtifactDTOParam对象", description = "构件  ")
public class MesBuildingArtifactSaveVORequest extends MesBuildingArtifactDTOParam {
   @Override
   public String toString() {
      return "MesBuildingArtifactSaveVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactSaveVORequest)) {
         return false;
      }

      MesBuildingArtifactSaveVORequest other = (MesBuildingArtifactSaveVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingArtifactSaveVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
