package com.hzchum.scim.plan.core.api.pojo.voParam;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class TechEnclosureChangeRecordQueryVoParam {
   @ApiModelProperty("年份")
   private LocalDateTime year;
   @ApiModelProperty(name = "checkStatus", value = "审核状态", notes = "审核状态")
   private Integer checkStatus;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("变更创建人")
   private String userName;
   @ApiModelProperty("变更审核人")
   private String auditName;

   public LocalDateTime getYear() {
      return this.year;
   }

   public Integer getCheckStatus() {
      return this.checkStatus;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getUserName() {
      return this.userName;
   }

   public String getAuditName() {
      return this.auditName;
   }

   public void setYear(final LocalDateTime year) {
      this.year = year;
   }

   public void setCheckStatus(final Integer checkStatus) {
      this.checkStatus = checkStatus;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setAuditName(final String auditName) {
      this.auditName = auditName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechEnclosureChangeRecordQueryVoParam)) {
         return false;
      }

      TechEnclosureChangeRecordQueryVoParam other = (TechEnclosureChangeRecordQueryVoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$checkStatus = this.getCheckStatus();
      Object other$checkStatus = other.getCheckStatus();
      if (this$checkStatus == null ? other$checkStatus == null : this$checkStatus.equals(other$checkStatus)) {
         Object this$year = this.getYear();
         Object other$year = other.getYear();
         if (this$year == null ? other$year == null : this$year.equals(other$year)) {
            Object this$projectName = this.getProjectName();
            Object other$projectName = other.getProjectName();
            if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
               Object this$userName = this.getUserName();
               Object other$userName = other.getUserName();
               if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                  Object this$auditName = this.getAuditName();
                  Object other$auditName = other.getAuditName();
                  return this$auditName == null ? other$auditName == null : this$auditName.equals(other$auditName);
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechEnclosureChangeRecordQueryVoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $checkStatus = this.getCheckStatus();
      result = result * 59 + ($checkStatus == null ? 43 : $checkStatus.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $auditName = this.getAuditName();
      return result * 59 + ($auditName == null ? 43 : $auditName.hashCode());
   }

   @Override
   public String toString() {
      return "TechEnclosureChangeRecordQueryVoParam(year="
         + this.getYear()
         + ", checkStatus="
         + this.getCheckStatus()
         + ", projectName="
         + this.getProjectName()
         + ", userName="
         + this.getUserName()
         + ", auditName="
         + this.getAuditName()
         + ")";
   }
}
