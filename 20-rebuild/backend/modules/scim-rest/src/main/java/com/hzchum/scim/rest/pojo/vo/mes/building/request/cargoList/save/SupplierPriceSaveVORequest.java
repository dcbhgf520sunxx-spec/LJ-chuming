package com.hzchum.scim.rest.pojo.vo.mes.building.request.cargoList.save;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList.save.SupplierPriceSaveDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "物流管理")
public class SupplierPriceSaveVORequest extends SupplierPriceSaveDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierPriceSaveVORequest)) {
         return false;
      }

      SupplierPriceSaveVORequest other = (SupplierPriceSaveVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SupplierPriceSaveVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "SupplierPriceSaveVORequest()";
   }
}
