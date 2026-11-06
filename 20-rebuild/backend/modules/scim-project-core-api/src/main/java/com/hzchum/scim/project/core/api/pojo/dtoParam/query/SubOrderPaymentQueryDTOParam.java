package com.hzchum.scim.project.core.api.pojo.dtoParam.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("分包订单付款信息查询类")
public class SubOrderPaymentQueryDTOParam {
   @ApiModelProperty(name = "startDate", value = "开始日期")
   private LocalDate startDate;
   @ApiModelProperty(name = "endDate", value = "结束日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "projectName", value = "项目名称", notes = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "supplierName", value = "分包单位(供应商)", notes = "分包单位(供应商)")
   private String supplierName;
   @ApiModelProperty(name = "subcontractClassId", value = "分包类别id", notes = "分包类别id")
   private Long subcontractClassId;
   @ApiModelProperty(name = "boolSettlementStatus", value = "结算状态 1已结算0未结算", notes = "结算状态 1已结算0未结算")
   private Boolean boolSettlementStatus;

   public static SubOrderPaymentQueryDTOParam.SubOrderPaymentQueryDTOParamBuilder builder() {
      return new SubOrderPaymentQueryDTOParam.SubOrderPaymentQueryDTOParamBuilder();
   }

   public SubOrderPaymentQueryDTOParam() {
   }

   public SubOrderPaymentQueryDTOParam(
      final LocalDate startDate,
      final LocalDate endDate,
      final Long projectId,
      final String projectName,
      final String supplierName,
      final Long subcontractClassId,
      final Boolean boolSettlementStatus
   ) {
      this.startDate = startDate;
      this.endDate = endDate;
      this.projectId = projectId;
      this.projectName = projectName;
      this.supplierName = supplierName;
      this.subcontractClassId = subcontractClassId;
      this.boolSettlementStatus = boolSettlementStatus;
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

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getSubcontractClassId() {
      return this.subcontractClassId;
   }

   public Boolean getBoolSettlementStatus() {
      return this.boolSettlementStatus;
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

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setSubcontractClassId(final Long subcontractClassId) {
      this.subcontractClassId = subcontractClassId;
   }

   public void setBoolSettlementStatus(final Boolean boolSettlementStatus) {
      this.boolSettlementStatus = boolSettlementStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubOrderPaymentQueryDTOParam)) {
         return false;
      }

      SubOrderPaymentQueryDTOParam other = (SubOrderPaymentQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$subcontractClassId = this.getSubcontractClassId();
         Object other$subcontractClassId = other.getSubcontractClassId();
         if (this$subcontractClassId == null ? other$subcontractClassId == null : this$subcontractClassId.equals(other$subcontractClassId)) {
            Object this$boolSettlementStatus = this.getBoolSettlementStatus();
            Object other$boolSettlementStatus = other.getBoolSettlementStatus();
            if (this$boolSettlementStatus == null ? other$boolSettlementStatus == null : this$boolSettlementStatus.equals(other$boolSettlementStatus)) {
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
                        return this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName);
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
      return other instanceof SubOrderPaymentQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $subcontractClassId = this.getSubcontractClassId();
      result = result * 59 + ($subcontractClassId == null ? 43 : $subcontractClassId.hashCode());
      Object $boolSettlementStatus = this.getBoolSettlementStatus();
      result = result * 59 + ($boolSettlementStatus == null ? 43 : $boolSettlementStatus.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $supplierName = this.getSupplierName();
      return result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
   }

   @Override
   public String toString() {
      return "SubOrderPaymentQueryDTOParam(startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", supplierName="
         + this.getSupplierName()
         + ", subcontractClassId="
         + this.getSubcontractClassId()
         + ", boolSettlementStatus="
         + this.getBoolSettlementStatus()
         + ")";
   }

   public static class SubOrderPaymentQueryDTOParamBuilder {
      private LocalDate startDate;
      private LocalDate endDate;
      private Long projectId;
      private String projectName;
      private String supplierName;
      private Long subcontractClassId;
      private Boolean boolSettlementStatus;

      SubOrderPaymentQueryDTOParamBuilder() {
      }

      public SubOrderPaymentQueryDTOParam.SubOrderPaymentQueryDTOParamBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public SubOrderPaymentQueryDTOParam.SubOrderPaymentQueryDTOParamBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public SubOrderPaymentQueryDTOParam.SubOrderPaymentQueryDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SubOrderPaymentQueryDTOParam.SubOrderPaymentQueryDTOParamBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public SubOrderPaymentQueryDTOParam.SubOrderPaymentQueryDTOParamBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SubOrderPaymentQueryDTOParam.SubOrderPaymentQueryDTOParamBuilder subcontractClassId(final Long subcontractClassId) {
         this.subcontractClassId = subcontractClassId;
         return this;
      }

      public SubOrderPaymentQueryDTOParam.SubOrderPaymentQueryDTOParamBuilder boolSettlementStatus(final Boolean boolSettlementStatus) {
         this.boolSettlementStatus = boolSettlementStatus;
         return this;
      }

      public SubOrderPaymentQueryDTOParam build() {
         return new SubOrderPaymentQueryDTOParam(
            this.startDate, this.endDate, this.projectId, this.projectName, this.supplierName, this.subcontractClassId, this.boolSettlementStatus
         );
      }

      @Override
      public String toString() {
         return "SubOrderPaymentQueryDTOParam.SubOrderPaymentQueryDTOParamBuilder(startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", supplierName="
            + this.supplierName
            + ", subcontractClassId="
            + this.subcontractClassId
            + ", boolSettlementStatus="
            + this.boolSettlementStatus
            + ")";
      }
   }
}
