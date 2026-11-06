package com.hzchum.scim.contract.core.api.pojo.dto.response;

import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.ProjectSaveDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel("项目详情返回类")
public class ProjectDetailsDTO extends ProjectSaveDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectDetailsDTO)) {
         return false;
      }

      ProjectDetailsDTO other = (ProjectDetailsDTO)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectDetailsDTO;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "ProjectDetailsDTO()";
   }
}
