package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactTypeDO;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingArtifactSchedulingDTO", description = "构件排产信息")
public class MesBuildingArtifactTypeDTO extends MesBuildingArtifactTypeDO {
   @Override
   public String toString() {
      return "MesBuildingArtifactTypeDTO()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactTypeDTO)) {
         return false;
      }

      MesBuildingArtifactTypeDTO other = (MesBuildingArtifactTypeDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingArtifactTypeDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
