package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.MesBuildingArtifactSchedulingDO;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "SchedulingArtifactDetailDTO", description = "排产详情信息")
public class SchedulingArtifactDetailDTO extends MesBuildingArtifactSchedulingDO {
   @Override
   public String toString() {
      return "SchedulingArtifactDetailDTO()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SchedulingArtifactDetailDTO)) {
         return false;
      }

      SchedulingArtifactDetailDTO other = (SchedulingArtifactDetailDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SchedulingArtifactDetailDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
