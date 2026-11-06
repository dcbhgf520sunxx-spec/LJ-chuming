package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save;

import com.hzchum.scim.common.core.api.pojo.dto.MesBuildingLinkCommonDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "库存信息")
public class CargoListProductDTOParam extends MesBuildingLinkCommonDTOParam {
   @Override
   public String toString() {
      return "CargoListProductDTOParam()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListProductDTOParam)) {
         return false;
      }

      CargoListProductDTOParam other = (CargoListProductDTOParam)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CargoListProductDTOParam;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
