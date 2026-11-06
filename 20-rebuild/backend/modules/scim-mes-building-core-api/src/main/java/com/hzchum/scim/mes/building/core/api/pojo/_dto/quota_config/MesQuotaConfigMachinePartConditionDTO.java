package com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config;

import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigMachinePartCondition;
import io.swagger.annotations.ApiModel;

@ApiModel("定额配置零件条件DTO")
public class MesQuotaConfigMachinePartConditionDTO extends MesQuotaConfigMachinePartCondition {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQuotaConfigMachinePartConditionDTO)) {
         return false;
      }

      MesQuotaConfigMachinePartConditionDTO other = (MesQuotaConfigMachinePartConditionDTO)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesQuotaConfigMachinePartConditionDTO;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }

   @Override
   public String toString() {
      return "MesQuotaConfigMachinePartConditionDTO()";
   }
}
