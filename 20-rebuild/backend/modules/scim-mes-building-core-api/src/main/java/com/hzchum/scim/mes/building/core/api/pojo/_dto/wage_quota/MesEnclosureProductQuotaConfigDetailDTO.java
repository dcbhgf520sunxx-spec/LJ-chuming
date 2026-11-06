package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_quota;

import com.hzchum.scim.mes.building.core.api.pojo._doModel.wage_quota.MesEnclosureProductQuotaConfigDetail;
import io.swagger.annotations.ApiModel;

@ApiModel("围护产品定额配置详情DTO")
public class MesEnclosureProductQuotaConfigDetailDTO extends MesEnclosureProductQuotaConfigDetail {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProductQuotaConfigDetailDTO)) {
         return false;
      }

      MesEnclosureProductQuotaConfigDetailDTO other = (MesEnclosureProductQuotaConfigDetailDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureProductQuotaConfigDetailDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "MesEnclosureProductQuotaConfigDetailDTO()";
   }
}
