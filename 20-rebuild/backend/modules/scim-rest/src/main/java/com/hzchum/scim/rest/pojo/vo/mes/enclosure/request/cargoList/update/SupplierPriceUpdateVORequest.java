package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.cargoList.update;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.cargoList.update.SupplierPriceUpdateDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "供应商修改")
public class SupplierPriceUpdateVORequest extends SupplierPriceUpdateDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierPriceUpdateVORequest)) {
         return false;
      }

      SupplierPriceUpdateVORequest other = (SupplierPriceUpdateVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SupplierPriceUpdateVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "SupplierPriceUpdateVORequest()";
   }
}
