package com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config;

import com.hzchum.scim.mes.building.core.api.pojo._doModel.quota_config.MesQuotaConfigAuxiliaryMaterial;
import io.swagger.annotations.ApiModel;

@ApiModel("定额配置辅材DTO")
public class MesQuotaConfigAuxiliaryMaterialDTO extends MesQuotaConfigAuxiliaryMaterial {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQuotaConfigAuxiliaryMaterialDTO)) {
         return false;
      }

      MesQuotaConfigAuxiliaryMaterialDTO other = (MesQuotaConfigAuxiliaryMaterialDTO)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesQuotaConfigAuxiliaryMaterialDTO;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }

   @Override
   public String toString() {
      return "MesQuotaConfigAuxiliaryMaterialDTO()";
   }
}
