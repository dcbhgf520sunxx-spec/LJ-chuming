package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota;

import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota.MesTempWorkQuotaConfig;

public class MesTempWorkQuotaConfigDTO extends MesTempWorkQuotaConfig {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesTempWorkQuotaConfigDTO)) {
         return false;
      }

      MesTempWorkQuotaConfigDTO other = (MesTempWorkQuotaConfigDTO)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesTempWorkQuotaConfigDTO;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }

   @Override
   public String toString() {
      return "MesTempWorkQuotaConfigDTO(super=" + super.toString() + ")";
   }
}
