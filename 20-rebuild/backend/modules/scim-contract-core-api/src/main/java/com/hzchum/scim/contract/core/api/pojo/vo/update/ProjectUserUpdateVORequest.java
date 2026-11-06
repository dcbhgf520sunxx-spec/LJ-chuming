package com.hzchum.scim.contract.core.api.pojo.vo.update;

import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ProjectUserUpdateDTOParam;
import io.swagger.annotations.ApiModel;

@ApiModel("项目关联用户请求类")
public class ProjectUserUpdateVORequest extends ProjectUserUpdateDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectUserUpdateVORequest)) {
         return false;
      }

      ProjectUserUpdateVORequest other = (ProjectUserUpdateVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectUserUpdateVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "ProjectUserUpdateVORequest()";
   }
}
