package com.hzchum.scim.rest.pojo.vo.mes.building.request.warehouse;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse.WarehouseEnclosureFindDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel("构件出入库")
public class WarehouseEnclosureFindRequest extends WarehouseEnclosureFindDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarehouseEnclosureFindRequest)) {
         return false;
      }

      WarehouseEnclosureFindRequest other = (WarehouseEnclosureFindRequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WarehouseEnclosureFindRequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "WarehouseEnclosureFindRequest()";
   }
}
