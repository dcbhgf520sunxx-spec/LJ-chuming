package com.hzchum.scim.project.core.api.pojo.dto.labor;

import com.hzchum.scim.project.core.api.pojo._do.ProjectManageRosterCert;
import io.swagger.annotations.ApiModel;

@ApiModel(description = "花名册证书信息DTO")
public class ProjectManageRosterCertDTO extends ProjectManageRosterCert {
   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectManageRosterCertDTO)) {
         return false;
      }

      ProjectManageRosterCertDTO other = (ProjectManageRosterCertDTO)o;
      return !other.canEqual(this) ? false : super.equals(o);
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ProjectManageRosterCertDTO;
   }

   @Override
   public int hashCode() {
      return super.hashCode();
   }

   @Override
   public String toString() {
      return "ProjectManageRosterCertDTO(super=" + super.toString() + ")";
   }
}
