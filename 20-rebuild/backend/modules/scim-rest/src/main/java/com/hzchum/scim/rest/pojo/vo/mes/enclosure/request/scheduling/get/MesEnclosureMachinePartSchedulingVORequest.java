package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.scheduling.get;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.scheduling.MesEnclosureMachinePartSchedulingDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesEnclosureMachinePartSchedulingVORequest", description = "零件排产请求类")
public class MesEnclosureMachinePartSchedulingVORequest extends MesEnclosureMachinePartSchedulingDTOParam {
   @Override
   public String toString() {
      return "MesEnclosureMachinePartSchedulingVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureMachinePartSchedulingVORequest)) {
         return false;
      }

      MesEnclosureMachinePartSchedulingVORequest other = (MesEnclosureMachinePartSchedulingVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureMachinePartSchedulingVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }
}
