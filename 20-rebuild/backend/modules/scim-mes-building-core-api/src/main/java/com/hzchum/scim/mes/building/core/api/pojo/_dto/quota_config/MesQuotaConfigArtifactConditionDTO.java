package com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config;

import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigArtifactCondition;
import io.swagger.annotations.ApiModel;

@ApiModel("定额配置构件条件DTO")
public class MesQuotaConfigArtifactConditionDTO extends MesQuotaConfigArtifactCondition {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQuotaConfigArtifactConditionDTO)) {
         return false;
      }

      MesQuotaConfigArtifactConditionDTO other = (MesQuotaConfigArtifactConditionDTO)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesQuotaConfigArtifactConditionDTO;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }

   @Override
   public String toString() {
      return "MesQuotaConfigArtifactConditionDTO()";
   }
}
