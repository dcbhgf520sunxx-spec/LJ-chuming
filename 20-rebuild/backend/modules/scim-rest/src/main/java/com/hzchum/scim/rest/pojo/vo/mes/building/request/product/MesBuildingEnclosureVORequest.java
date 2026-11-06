package com.hzchum.scim.rest.pojo.vo.mes.building.request.product;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.product.MesBuildingEnclosureDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel("MesBuildingEnclosureVORequest")
public class MesBuildingEnclosureVORequest extends MesBuildingEnclosureDTOParam {
   @Override
   public String toString() {
      return "MesBuildingEnclosureVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingEnclosureVORequest)) {
         return false;
      }

      MesBuildingEnclosureVORequest other = (MesBuildingEnclosureVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingEnclosureVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
