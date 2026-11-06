package com.hzchum.scim.rest.pojo.vo.mes.building.request.task;

import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingTaskDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingTaskSaveVORequest", description = "")
public class MesBuildingTaskSaveVORequest extends MesBuildingTaskDTOParam {
   @Override
   public String toString() {
      return "MesBuildingTaskSaveVORequest()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskSaveVORequest)) {
         return false;
      }

      MesBuildingTaskSaveVORequest other = (MesBuildingTaskSaveVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTaskSaveVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
