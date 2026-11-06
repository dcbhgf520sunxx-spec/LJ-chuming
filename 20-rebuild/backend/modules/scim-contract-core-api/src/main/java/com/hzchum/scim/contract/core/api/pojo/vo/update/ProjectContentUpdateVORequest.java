package com.hzchum.scim.contract.core.api.pojo.vo.update;

import com.hzchum.scim.contract.core.api.pojo.dtoParam.update.ProjectContentUpdateDTOParam;

public class ProjectContentUpdateVORequest extends ProjectContentUpdateDTOParam {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectContentUpdateVORequest)) {
         return false;
      }

      ProjectContentUpdateVORequest other = (ProjectContentUpdateVORequest)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectContentUpdateVORequest;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }

   @Override
   public String toString() {
      return "ProjectContentUpdateVORequest()";
   }
}
