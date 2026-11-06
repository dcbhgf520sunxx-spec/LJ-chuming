package com.hzchum.scim.rest.pojo.vo.mes.building.request.product;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.product.MesBuildingEnclosureDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel("MesBuildingEnclosureSaveVORequest")
public class MesBuildingEnclosureSaveVORequest extends MesBuildingEnclosureDTOParam {
   @Override
   public String toString() {
      return "MesBuildingEnclosureSaveVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingEnclosureSaveVORequest)) {
         return false;
      }

      MesBuildingEnclosureSaveVORequest other = (MesBuildingEnclosureSaveVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingEnclosureSaveVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
