package com.hzchum.scim.rest.pojo.vo.mes.building.request.task;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingTaskVORequest", description = "")
public class MesBuildingTaskVORequest extends MesBuildingTaskDTOParam {
   @Override
   public String toString() {
      return "MesBuildingTaskVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskVORequest)) {
         return false;
      }

      MesBuildingTaskVORequest other = (MesBuildingTaskVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTaskVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
