package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("工价调整Query")
public class MesWageAdjustQuery {
   @ApiModelProperty("年份")
   private Integer year;
   @ApiModelProperty("工序")
   private Long processId;
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("创建人id")
   private Long createUserId;
   @ApiModelProperty("审批人id")
   private Long approveUserId;

   public Integer getYear() {
      return this.year;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public Long getApproveUserId() {
      return this.approveUserId;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setApproveUserId(final Long approveUserId) {
      this.approveUserId = approveUserId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesWageAdjustQuery)) {
         return false;
      }

      MesWageAdjustQuery other = (MesWageAdjustQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$year = this.getYear();
      Object other$year = other.getYear();
      if (this$year == null ? other$year == null : this$year.equals(other$year)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$createUserId = this.getCreateUserId();
               Object other$createUserId = other.getCreateUserId();
               if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                  Object this$approveUserId = this.getApproveUserId();
                  Object other$approveUserId = other.getApproveUserId();
                  return this$approveUserId == null ? other$approveUserId == null : this$approveUserId.equals(other$approveUserId);
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
      return other instanceof MesWageAdjustQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $approveUserId = this.getApproveUserId();
      return result * 59 + ($approveUserId == null ? 43 : $approveUserId.hashCode());
   }

   @Override
   public String toString() {
      return "MesWageAdjustQuery(year="
         + this.getYear()
         + ", processId="
         + this.getProcessId()
         + ", projectId="
         + this.getProjectId()
         + ", createUserId="
         + this.getCreateUserId()
         + ", approveUserId="
         + this.getApproveUserId()
         + ")";
   }
}
