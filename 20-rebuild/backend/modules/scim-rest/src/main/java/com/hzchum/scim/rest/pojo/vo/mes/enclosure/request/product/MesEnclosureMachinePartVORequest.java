package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.product;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.product.MesEnclosureMachinePartDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesEnclosureMachinePartVORequest", description = "零件  ")
public class MesEnclosureMachinePartVORequest extends MesEnclosureMachinePartDTOParam {
   @Override
   public String toString() {
      return "MesEnclosureMachinePartVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureMachinePartVORequest)) {
         return false;
      }

      MesEnclosureMachinePartVORequest other = (MesEnclosureMachinePartVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureMachinePartVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
