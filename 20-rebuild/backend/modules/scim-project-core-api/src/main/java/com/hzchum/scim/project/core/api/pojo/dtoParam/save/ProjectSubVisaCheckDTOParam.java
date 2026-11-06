package com.hzchum.scim.project.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

@ApiModel("分包签证审核类")
public class ProjectSubVisaCheckDTOParam {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @NotNull(message = "签证ID不能为空")
   private Long id;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 2通过 4驳回", notes = "审核状态 2通过 4驳回")
   @NotNull(message = "审核状态不能为空")
   private Integer auditStatus;
   @ApiModelProperty(name = "approverId", value = "审批人ID", notes = "审批人ID")
   private Long approverId;
   @ApiModelProperty(name = "approveTime", value = "审批时间", notes = "审批时间")
   private LocalDate approveTime;

   public static ProjectSubVisaCheckDTOParam.ProjectSubVisaCheckDTOParamBuilder builder() {
      return new ProjectSubVisaCheckDTOParam.ProjectSubVisaCheckDTOParamBuilder();
   }

   public ProjectSubVisaCheckDTOParam() {
   }

   public ProjectSubVisaCheckDTOParam(final Long id, final Integer auditStatus, final Long approverId, final LocalDate approveTime) {
      this.id = id;
      this.auditStatus = auditStatus;
      this.approverId = approverId;
      this.approveTime = approveTime;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public Long getApproverId() {
      return this.approverId;
   }

   public LocalDate getApproveTime() {
      return this.approveTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setApproverId(final Long approverId) {
      this.approverId = approverId;
   }

   public void setApproveTime(final LocalDate approveTime) {
      this.approveTime = approveTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSubVisaCheckDTOParam)) {
         return false;
      }

      ProjectSubVisaCheckDTOParam other = (ProjectSubVisaCheckDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$auditStatus = this.getAuditStatus();
         Object other$auditStatus = other.getAuditStatus();
         if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
            Object this$approverId = this.getApproverId();
            Object other$approverId = other.getApproverId();
            if (this$approverId == null ? other$approverId == null : this$approverId.equals(other$approverId)) {
               Object this$approveTime = this.getApproveTime();
               Object other$approveTime = other.getApproveTime();
               return this$approveTime == null ? other$approveTime == null : this$approveTime.equals(other$approveTime);
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
      return other instanceof ProjectSubVisaCheckDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $approverId = this.getApproverId();
      result = result * 59 + ($approverId == null ? 43 : $approverId.hashCode());
      Object $approveTime = this.getApproveTime();
      return result * 59 + ($approveTime == null ? 43 : $approveTime.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSubVisaCheckDTOParam(id="
         + this.getId()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", approverId="
         + this.getApproverId()
         + ", approveTime="
         + this.getApproveTime()
         + ")";
   }

   public static class ProjectSubVisaCheckDTOParamBuilder {
      private Long id;
      private Integer auditStatus;
      private Long approverId;
      private LocalDate approveTime;

      ProjectSubVisaCheckDTOParamBuilder() {
      }

      public ProjectSubVisaCheckDTOParam.ProjectSubVisaCheckDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectSubVisaCheckDTOParam.ProjectSubVisaCheckDTOParamBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ProjectSubVisaCheckDTOParam.ProjectSubVisaCheckDTOParamBuilder approverId(final Long approverId) {
         this.approverId = approverId;
         return this;
      }

      public ProjectSubVisaCheckDTOParam.ProjectSubVisaCheckDTOParamBuilder approveTime(final LocalDate approveTime) {
         this.approveTime = approveTime;
         return this;
      }

      public ProjectSubVisaCheckDTOParam build() {
         return new ProjectSubVisaCheckDTOParam(this.id, this.auditStatus, this.approverId, this.approveTime);
      }

      @Override
      public String toString() {
         return "ProjectSubVisaCheckDTOParam.ProjectSubVisaCheckDTOParamBuilder(id="
            + this.id
            + ", auditStatus="
            + this.auditStatus
            + ", approverId="
            + this.approverId
            + ", approveTime="
            + this.approveTime
            + ")";
      }
   }
}
