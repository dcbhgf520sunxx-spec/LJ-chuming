package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

import com.hzchum.scim.mes.building.core.api.pojo._do.scheduling.ProjectSchedulingTreeDO;
import io.swagger.annotations.ApiModel;

@ApiModel(value = "ProjectSchedulingDetailDTO", description = "项目信息 ")
public class ProjectSchedulingTreeDTO extends ProjectSchedulingTreeDO {
   @Override
   public String toString() {
      return "ProjectSchedulingTreeDTO()";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSchedulingTreeDTO)) {
         return false;
      }

      ProjectSchedulingTreeDTO other = (ProjectSchedulingTreeDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectSchedulingTreeDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }
}
