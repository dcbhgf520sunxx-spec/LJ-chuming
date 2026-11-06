package com.hzchum.scim.mes.building.core.api.pojo._dto.craft;

import com.hzchum.scim.mes.building.core.api.pojo._doModel.craft.MesPaintConfig;
import io.swagger.annotations.ApiModel;

@ApiModel("油漆配置DTO")
public class MesPaintConfigDTO extends MesPaintConfig {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPaintConfigDTO)) {
         return false;
      }

      MesPaintConfigDTO other = (MesPaintConfigDTO)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesPaintConfigDTO;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }

   @Override
   public String toString() {
      return "MesPaintConfigDTO(super=" + super.toString() + ")";
   }
}
