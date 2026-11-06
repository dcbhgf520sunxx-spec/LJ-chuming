package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import com.hzchum.scim.mes.enclosure.core.api.pojo._do.cargoList.CargoListDO;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "发运列表")
public class CargoListRecordDTO extends CargoListDO {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListRecordDTO)) {
         return false;
      }

      CargoListRecordDTO other = (CargoListRecordDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof CargoListRecordDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "CargoListRecordDTO()";
   }
}
