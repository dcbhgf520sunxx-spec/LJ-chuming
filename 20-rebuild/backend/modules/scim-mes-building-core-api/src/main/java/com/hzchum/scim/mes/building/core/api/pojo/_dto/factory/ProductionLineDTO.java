package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.hzchum.scim.mes.building.core.api.pojo._do.factory.ProductionLineDO;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "ProductionLineDTO", description = "")
public class ProductionLineDTO extends ProductionLineDO {
   @Override
   public String toString() {
      return "ProductionLineDTO()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionLineDTO)) {
         return false;
      }

      ProductionLineDTO other = (ProductionLineDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProductionLineDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
