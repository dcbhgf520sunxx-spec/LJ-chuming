package com.hzchum.scim.contract.core.api.pojo.voParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("项目台账-开票列表-查询类")
public class InvoiceProjectQueryVoParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "startDate", value = "开始日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "截止日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "auditStatus", value = "审核状态  1审核中 2审核通过 4已驳回")
   private Integer auditStatus;

   public static InvoiceProjectQueryVoParam.InvoiceProjectQueryVoParamBuilder builder() {
      return new InvoiceProjectQueryVoParam.InvoiceProjectQueryVoParamBuilder();
   }

   public InvoiceProjectQueryVoParam() {
   }

   public InvoiceProjectQueryVoParam(final Long projectId, final LocalDate startDate, final LocalDate endDate, final Integer auditStatus) {
      this.projectId = projectId;
      this.startDate = startDate;
      this.endDate = endDate;
      this.auditStatus = auditStatus;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InvoiceProjectQueryVoParam)) {
         return false;
      }

      InvoiceProjectQueryVoParam other = (InvoiceProjectQueryVoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$auditStatus = this.getAuditStatus();
         Object other$auditStatus = other.getAuditStatus();
         if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
            Object this$startDate = this.getStartDate();
            Object other$startDate = other.getStartDate();
            if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
               Object this$endDate = this.getEndDate();
               Object other$endDate = other.getEndDate();
               return this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate);
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
      return other instanceof InvoiceProjectQueryVoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "InvoiceProjectQueryVoParam(projectId="
         + this.getProjectId()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }

   public static class InvoiceProjectQueryVoParamBuilder {
      private Long projectId;
      private LocalDate startDate;
      private LocalDate endDate;
      private Integer auditStatus;

      InvoiceProjectQueryVoParamBuilder() {
      }

      public InvoiceProjectQueryVoParam.InvoiceProjectQueryVoParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public InvoiceProjectQueryVoParam.InvoiceProjectQueryVoParamBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public InvoiceProjectQueryVoParam.InvoiceProjectQueryVoParamBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public InvoiceProjectQueryVoParam.InvoiceProjectQueryVoParamBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public InvoiceProjectQueryVoParam build() {
         return new InvoiceProjectQueryVoParam(this.projectId, this.startDate, this.endDate, this.auditStatus);
      }

      @Override
      public String toString() {
         return "InvoiceProjectQueryVoParam.InvoiceProjectQueryVoParamBuilder(projectId="
            + this.projectId
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", auditStatus="
            + this.auditStatus
            + ")";
      }
   }
}
