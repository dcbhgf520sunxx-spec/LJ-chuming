package com.hzchum.scim.crm.core.api.pojo.param;

import io.swagger.annotations.ApiModelProperty;

public class ProjectAssignmentParam {
   @ApiModelProperty(name = "crmProjectInformationWarehousingId", notes = "项目信息备案")
   private Long crmProjectInformationWarehousingId;
   @ApiModelProperty(name = "userId", notes = "分配人员id")
   private Long userId;

   public ProjectAssignmentParam(final Long crmProjectInformationWarehousingId, final Long userId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
      this.userId = userId;
   }

   public ProjectAssignmentParam() {
   }

   public Long getCrmProjectInformationWarehousingId() {
      return this.crmProjectInformationWarehousingId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public void setCrmProjectInformationWarehousingId(final Long crmProjectInformationWarehousingId) {
      this.crmProjectInformationWarehousingId = crmProjectInformationWarehousingId;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProjectAssignmentParam)) {
         return false;
      } else {
         ProjectAssignmentParam other = (ProjectAssignmentParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
            Object other$crmProjectInformationWarehousingId = other.getCrmProjectInformationWarehousingId();
            if (this$crmProjectInformationWarehousingId == null
               ? other$crmProjectInformationWarehousingId == null
               : this$crmProjectInformationWarehousingId.equals(other$crmProjectInformationWarehousingId)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               return this$userId == null ? other$userId == null : this$userId.equals(other$userId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectAssignmentParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmProjectInformationWarehousingId = this.getCrmProjectInformationWarehousingId();
      result = result * 59 + ($crmProjectInformationWarehousingId == null ? 43 : $crmProjectInformationWarehousingId.hashCode());
      Object $userId = this.getUserId();
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectAssignmentParam(crmProjectInformationWarehousingId=" + this.getCrmProjectInformationWarehousingId() + ", userId=" + this.getUserId() + ")";
   }
}
