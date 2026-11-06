package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.product;

import com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.product.MesEnclosureMachinePartDOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesEnclosureMachinePartDTOParam", description = "")
public class MesEnclosureMachinePartDTOParam extends MesEnclosureMachinePartDOParam {
   @Override
   public String toString() {
      return "MesEnclosureMachinePartDTOParam()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureMachinePartDTOParam)) {
         return false;
      }

      MesEnclosureMachinePartDTOParam other = (MesEnclosureMachinePartDTOParam)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureMachinePartDTOParam;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
