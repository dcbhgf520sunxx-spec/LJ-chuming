package com.hzchum.scim.rest.pojo.vo.mes.building.request.product;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.product.MesBuildingArtifactDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingArtifactDTOParam对象", description = "构件  ")
public class MesBuildingArtifactVORequest extends MesBuildingArtifactDTOParam {
   @Override
   public String toString() {
      return "MesBuildingArtifactVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactVORequest)) {
         return false;
      }

      MesBuildingArtifactVORequest other = (MesBuildingArtifactVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingArtifactVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
