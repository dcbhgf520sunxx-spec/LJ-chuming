package com.hzchum.scim.system.core.api.pojo.dto;

import javax.validation.constraints.NotNull;

public class InstallationAuditVO {
   @NotNull(message = "安装审核值不能为空")
   private Boolean installationAudit;

   public Boolean getInstallationAudit() {
      return this.installationAudit;
   }

   public void setInstallationAudit(final Boolean installationAudit) {
      this.installationAudit = installationAudit;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InstallationAuditVO)) {
         return false;
      }

      InstallationAuditVO other = (InstallationAuditVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$installationAudit = this.getInstallationAudit();
      Object other$installationAudit = other.getInstallationAudit();
      return this$installationAudit == null ? other$installationAudit == null : this$installationAudit.equals(other$installationAudit);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InstallationAuditVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $installationAudit = this.getInstallationAudit();
      return result * 59 + ($installationAudit == null ? 43 : $installationAudit.hashCode());
   }

   @Override
   public String toString() {
      return "InstallationAuditVO(installationAudit=" + this.getInstallationAudit() + ")";
   }
}
