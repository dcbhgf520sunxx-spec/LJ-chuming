package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task.MesEnclosureTaskDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesEnclosureTaskVORequest", description = "")
public class MesEnclosureTaskVORequest extends MesEnclosureTaskDTOParam {
   @Override
   public String toString() {
      return "MesEnclosureTaskVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTaskVORequest)) {
         return false;
      }

      MesEnclosureTaskVORequest other = (MesEnclosureTaskVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureTaskVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
