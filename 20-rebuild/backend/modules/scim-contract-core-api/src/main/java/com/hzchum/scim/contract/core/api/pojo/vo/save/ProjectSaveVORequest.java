package com.hzchum.scim.contract.core.api.pojo.vo.save;

import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.ProjectSaveDTOParam;

public class ProjectSaveVORequest extends ProjectSaveDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSaveVORequest)) {
         return false;
      }

      ProjectSaveVORequest other = (ProjectSaveVORequest)o;
      return other.canEqual(this);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectSaveVORequest;
   }

   @Override
   public int hashCode() {
      int result = 1;
      return 1;
   }

   @Override
   public String toString() {
      return "ProjectSaveVORequest()";
   }
}
