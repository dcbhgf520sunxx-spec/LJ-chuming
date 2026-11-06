package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task;

import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task.MesEnclosureTaskDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesEnclosureTaskSaveVORequest", description = "")
public class MesEnclosureTaskSaveVORequest extends MesEnclosureTaskDTOParam {
   @Override
   public String toString() {
      return "MesEnclosureTaskSaveVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTaskSaveVORequest)) {
         return false;
      }

      MesEnclosureTaskSaveVORequest other = (MesEnclosureTaskSaveVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureTaskSaveVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
