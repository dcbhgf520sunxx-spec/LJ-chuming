package com.hzchum.scim.rest.pojo.vo.mes.building.request.scheduling.get;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.scheduling.MesBuildingArtifactSchedulingDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingArtifactSchedulingVORequest", description = "构件排产请求类")
public class MesBuildingArtifactSchedulingVORequest extends MesBuildingArtifactSchedulingDTOParam {
   @Override
   public String toString() {
      return "MesBuildingArtifactSchedulingVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactSchedulingVORequest)) {
         return false;
      }

      MesBuildingArtifactSchedulingVORequest other = (MesBuildingArtifactSchedulingVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingArtifactSchedulingVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
