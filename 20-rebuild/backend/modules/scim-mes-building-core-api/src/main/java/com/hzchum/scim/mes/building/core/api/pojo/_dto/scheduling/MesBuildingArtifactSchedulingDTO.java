package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactSchedulingDO;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingArtifactSchedulingDTO", description = "构件排产信息")
public class MesBuildingArtifactSchedulingDTO extends MesBuildingArtifactSchedulingDO {
   @Override
   public String toString() {
      return "MesBuildingArtifactSchedulingDTO()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactSchedulingDTO)) {
         return false;
      }

      MesBuildingArtifactSchedulingDTO other = (MesBuildingArtifactSchedulingDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingArtifactSchedulingDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
