package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota;

import io.swagger.annotations.ApiModel;

@ApiModel("围护产品定额配置Query")
public class MesEnclosureProductQuotaConfigQuery {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProductQuotaConfigQuery)) {
         return false;
      }

      MesEnclosureProductQuotaConfigQuery other = (MesEnclosureProductQuotaConfigQuery)o;
      return other.canEqual(this);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureProductQuotaConfigQuery;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "MesEnclosureProductQuotaConfigQuery()";
   }
}
