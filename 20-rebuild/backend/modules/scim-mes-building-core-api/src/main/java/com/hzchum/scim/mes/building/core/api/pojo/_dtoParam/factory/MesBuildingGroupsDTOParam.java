package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.factory;

import com.hzchum.scim.mes.building.core.api.pojo._doParam.factory.MesBuildingGroupsDOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingGroupsDOParam", description = "生产组 ")
public class MesBuildingGroupsDTOParam extends MesBuildingGroupsDOParam {
   @Override
   public String toString() {
      return "MesBuildingGroupsDTOParam()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingGroupsDTOParam)) {
         return false;
      }

      MesBuildingGroupsDTOParam other = (MesBuildingGroupsDTOParam)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingGroupsDTOParam;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
