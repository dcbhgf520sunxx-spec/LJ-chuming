package com.hzchum.scim.mes.building.core.api.pojo._dtoParam._package;

import com.hzchum.scim.common.core.api.pojo.dto.MesBuildingLinkCommonDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingLinkDTOParam", description = "包 ")
public class MesBuildingLinkDTOParam extends MesBuildingLinkCommonDTOParam {
   @Override
   public String toString() {
      return "MesBuildingLinkDTOParam()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingLinkDTOParam)) {
         return false;
      }

      MesBuildingLinkDTOParam other = (MesBuildingLinkDTOParam)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingLinkDTOParam;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
