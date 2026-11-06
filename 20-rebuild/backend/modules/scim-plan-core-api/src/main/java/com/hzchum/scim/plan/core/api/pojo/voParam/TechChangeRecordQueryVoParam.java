package com.hzchum.scim.plan.core.api.pojo.voParam;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class TechChangeRecordQueryVoParam {
   @ApiModelProperty("年份")
   private LocalDateTime year;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("变更发起人")
   private String userName;
   @ApiModelProperty("变更原因id")
   private Long changeReasonId;
   @ApiModelProperty(name = "checkStatus", value = "审核状态", notes = "审核状态")
   private Integer checkStatus;

   public LocalDateTime getYear() {
      return this.year;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getUserName() {
      return this.userName;
   }

   public Long getChangeReasonId() {
      return this.changeReasonId;
   }

   public Integer getCheckStatus() {
      return this.checkStatus;
   }

   public void setYear(final LocalDateTime year) {
      this.year = year;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setChangeReasonId(final Long changeReasonId) {
      this.changeReasonId = changeReasonId;
   }

   public void setCheckStatus(final Integer checkStatus) {
      this.checkStatus = checkStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechChangeRecordQueryVoParam)) {
         return false;
      }

      TechChangeRecordQueryVoParam other = (TechChangeRecordQueryVoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$changeReasonId = this.getChangeReasonId();
      Object other$changeReasonId = other.getChangeReasonId();
      if (this$changeReasonId == null ? other$changeReasonId == null : this$changeReasonId.equals(other$changeReasonId)) {
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
                  return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
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
      return other instanceof TechChangeRecordQueryVoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $changeReasonId = this.getChangeReasonId();
      result = result * 59 + ($changeReasonId == null ? 43 : $changeReasonId.hashCode());
      Object $checkStatus = this.getCheckStatus();
      result = result * 59 + ($checkStatus == null ? 43 : $checkStatus.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   @Override
   public String toString() {
      return "TechChangeRecordQueryVoParam(year="
         + this.getYear()
         + ", projectName="
         + this.getProjectName()
         + ", userName="
         + this.getUserName()
         + ", changeReasonId="
         + this.getChangeReasonId()
         + ", checkStatus="
         + this.getCheckStatus()
         + ")";
   }
}
