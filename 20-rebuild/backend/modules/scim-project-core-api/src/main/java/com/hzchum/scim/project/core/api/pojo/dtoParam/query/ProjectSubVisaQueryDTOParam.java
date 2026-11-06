package com.hzchum.scim.project.core.api.pojo.dtoParam.query;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

public class ProjectSubVisaQueryDTOParam {
   @ApiModelProperty("开始日期")
   private LocalDate startDate;
   @ApiModelProperty("结束日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "supplierId", value = "分包单位id", notes = "分包单位id")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "分包单位", notes = "分包单位")
   private String supplierName;
   @ApiModelProperty(name = "auditUserName", value = "审核人", notes = "审核人")
   private String auditUserName;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1待审核2通过4驳回", notes = "审核状态 1待审核2通过4驳回")
   private Integer auditStatus;
   @ApiModelProperty(name = "approverName", value = "审批人", notes = "审批人")
   private String approverName;

   public static ProjectSubVisaQueryDTOParam.ProjectSubVisaQueryDTOParamBuilder builder() {
      return new ProjectSubVisaQueryDTOParam.ProjectSubVisaQueryDTOParamBuilder();
   }

   public ProjectSubVisaQueryDTOParam() {
   }

   public ProjectSubVisaQueryDTOParam(
      final LocalDate startDate,
      final LocalDate endDate,
      final Long projectId,
      final String projectName,
      final Long supplierId,
      final String supplierName,
      final String auditUserName,
      final Integer auditStatus,
      final String approverName
   ) {
      this.startDate = startDate;
      this.endDate = endDate;
      this.projectId = projectId;
      this.projectName = projectName;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.auditUserName = auditUserName;
      this.auditStatus = auditStatus;
      this.approverName = approverName;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public String getApproverName() {
      return this.approverName;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setApproverName(final String approverName) {
      this.approverName = approverName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSubVisaQueryDTOParam)) {
         return false;
      }

      ProjectSubVisaQueryDTOParam other = (ProjectSubVisaQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$auditStatus = this.getAuditStatus();
            Object other$auditStatus = other.getAuditStatus();
            if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
               Object this$startDate = this.getStartDate();
               Object other$startDate = other.getStartDate();
               if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                  Object this$endDate = this.getEndDate();
                  Object other$endDate = other.getEndDate();
                  if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                     Object this$projectName = this.getProjectName();
                     Object other$projectName = other.getProjectName();
                     if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                        Object this$supplierName = this.getSupplierName();
                        Object other$supplierName = other.getSupplierName();
                        if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                           Object this$auditUserName = this.getAuditUserName();
                           Object other$auditUserName = other.getAuditUserName();
                           if (this$auditUserName == null ? other$auditUserName == null : this$auditUserName.equals(other$auditUserName)) {
                              Object this$approverName = this.getApproverName();
                              Object other$approverName = other.getApproverName();
                              return this$approverName == null ? other$approverName == null : this$approverName.equals(other$approverName);
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
      return other instanceof ProjectSubVisaQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $auditUserName = this.getAuditUserName();
      result = result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
      Object $approverName = this.getApproverName();
      return result * 59 + ($approverName == null ? 43 : $approverName.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSubVisaQueryDTOParam(startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", auditUserName="
         + this.getAuditUserName()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", approverName="
         + this.getApproverName()
         + ")";
   }

   public static class ProjectSubVisaQueryDTOParamBuilder {
      private LocalDate startDate;
      private LocalDate endDate;
      private Long projectId;
      private String projectName;
      private Long supplierId;
      private String supplierName;
      private String auditUserName;
      private Integer auditStatus;
      private String approverName;

      ProjectSubVisaQueryDTOParamBuilder() {
      }

      public ProjectSubVisaQueryDTOParam.ProjectSubVisaQueryDTOParamBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public ProjectSubVisaQueryDTOParam.ProjectSubVisaQueryDTOParamBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public ProjectSubVisaQueryDTOParam.ProjectSubVisaQueryDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectSubVisaQueryDTOParam.ProjectSubVisaQueryDTOParamBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ProjectSubVisaQueryDTOParam.ProjectSubVisaQueryDTOParamBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectSubVisaQueryDTOParam.ProjectSubVisaQueryDTOParamBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectSubVisaQueryDTOParam.ProjectSubVisaQueryDTOParamBuilder auditUserName(final String auditUserName) {
         this.auditUserName = auditUserName;
         return this;
      }

      public ProjectSubVisaQueryDTOParam.ProjectSubVisaQueryDTOParamBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ProjectSubVisaQueryDTOParam.ProjectSubVisaQueryDTOParamBuilder approverName(final String approverName) {
         this.approverName = approverName;
         return this;
      }

      public ProjectSubVisaQueryDTOParam build() {
         return new ProjectSubVisaQueryDTOParam(
            this.startDate,
            this.endDate,
            this.projectId,
            this.projectName,
            this.supplierId,
            this.supplierName,
            this.auditUserName,
            this.auditStatus,
            this.approverName
         );
      }

      @Override
      public String toString() {
         return "ProjectSubVisaQueryDTOParam.ProjectSubVisaQueryDTOParamBuilder(startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", auditUserName="
            + this.auditUserName
            + ", auditStatus="
            + this.auditStatus
            + ", approverName="
            + this.approverName
            + ")";
      }
   }
}
