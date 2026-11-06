package com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config;

import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigAssembleCondition;
import io.swagger.annotations.ApiModel;

@ApiModel("定额配置部件条件DTO")
public class MesQuotaConfigAssembleConditionDTO extends MesQuotaConfigAssembleCondition {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQuotaConfigAssembleConditionDTO)) {
         return false;
      }

      MesQuotaConfigAssembleConditionDTO other = (MesQuotaConfigAssembleConditionDTO)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesQuotaConfigAssembleConditionDTO;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }

   @Override
   public String toString() {
      return "MesQuotaConfigAssembleConditionDTO()";
   }
}
