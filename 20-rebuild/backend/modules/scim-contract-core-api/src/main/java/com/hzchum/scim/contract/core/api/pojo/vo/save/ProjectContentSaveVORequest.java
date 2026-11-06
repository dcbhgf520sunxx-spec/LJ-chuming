package com.hzchum.scim.contract.core.api.pojo.vo.save;

import com.hzchum.scim.contract.core.api.pojo.dtoParam.save.ProjectContentSaveDTOParam;

public class ProjectContentSaveVORequest extends ProjectContentSaveDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectContentSaveVORequest)) {
         return false;
      }

      ProjectContentSaveVORequest other = (ProjectContentSaveVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectContentSaveVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }

   @Override
   public String toString() {
      return "ProjectContentSaveVORequest()";
   }
}
