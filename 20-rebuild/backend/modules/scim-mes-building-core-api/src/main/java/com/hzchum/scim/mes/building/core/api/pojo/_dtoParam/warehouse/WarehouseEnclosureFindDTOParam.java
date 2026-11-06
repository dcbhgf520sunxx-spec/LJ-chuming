package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse;

import com.hzchum.scim.mes.building.core.api.pojo._doParam.warehouse.WarehouseEnclosureFindDOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingWarehouseRecordArtifactDO", description = "构件出入库 ")
public class WarehouseEnclosureFindDTOParam extends WarehouseEnclosureFindDOParam {
   @Override
   public String toString() {
      return "WarehouseEnclosureFindDTOParam()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarehouseEnclosureFindDTOParam)) {
         return false;
      }

      WarehouseEnclosureFindDTOParam other = (WarehouseEnclosureFindDTOParam)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof WarehouseEnclosureFindDTOParam;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
