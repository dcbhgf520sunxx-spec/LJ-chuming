package com.hzchum.scim.rest.pojo.vo.mes.building.request.process.productProcess.put;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.process.MesBuildingProductProcessDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "ProductProcessUpdateVORequest", description = "")
public class ProductProcessUpdateVORequest extends MesBuildingProductProcessDTOParam {
   @Override
   public String toString() {
      return "ProductProcessUpdateVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductProcessUpdateVORequest)) {
         return false;
      }

      ProductProcessUpdateVORequest other = (ProductProcessUpdateVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProductProcessUpdateVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
