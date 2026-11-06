package com.hzchum.scim.project.core.api.pojo.dtoParam.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("质安问题列表查询类")
public class QhseProblemQueryDTOParam {
   @ApiModelProperty("开始日期")
   private LocalDate startDate;
   @ApiModelProperty("结束日期")
   private LocalDate endDate;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "problemTypeId", value = "问题类型ID", notes = "问题类型ID")
   private Long problemTypeId;
   @ApiModelProperty(name = "boolChangeStatus", value = "整改状态 false未整改 true已整改", notes = "整改状态 false未整改 true已整改")
   private Boolean boolChangeStatus;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty(name = "supplierId", value = "分包单位id", notes = "分包单位id")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "分包单位", notes = "分包单位")
   private String supplierName;
   @ApiModelProperty(name = "promoterName", value = "发起人", notes = "发起人")
   private String promoterName;

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getProblemTypeId() {
      return this.problemTypeId;
   }

   public Boolean getBoolChangeStatus() {
      return this.boolChangeStatus;
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

   public String getPromoterName() {
      return this.promoterName;
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

   public void setProblemTypeId(final Long problemTypeId) {
      this.problemTypeId = problemTypeId;
   }

   public void setBoolChangeStatus(final Boolean boolChangeStatus) {
      this.boolChangeStatus = boolChangeStatus;
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

   public void setPromoterName(final String promoterName) {
      this.promoterName = promoterName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QhseProblemQueryDTOParam)) {
         return false;
      }

      QhseProblemQueryDTOParam other = (QhseProblemQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$problemTypeId = this.getProblemTypeId();
         Object other$problemTypeId = other.getProblemTypeId();
         if (this$problemTypeId == null ? other$problemTypeId == null : this$problemTypeId.equals(other$problemTypeId)) {
            Object this$boolChangeStatus = this.getBoolChangeStatus();
            Object other$boolChangeStatus = other.getBoolChangeStatus();
            if (this$boolChangeStatus == null ? other$boolChangeStatus == null : this$boolChangeStatus.equals(other$boolChangeStatus)) {
               Object this$supplierId = this.getSupplierId();
               Object other$supplierId = other.getSupplierId();
               if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
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
                              Object this$promoterName = this.getPromoterName();
                              Object other$promoterName = other.getPromoterName();
                              return this$promoterName == null ? other$promoterName == null : this$promoterName.equals(other$promoterName);
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
      return other instanceof QhseProblemQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $problemTypeId = this.getProblemTypeId();
      result = result * 59 + ($problemTypeId == null ? 43 : $problemTypeId.hashCode());
      Object $boolChangeStatus = this.getBoolChangeStatus();
      result = result * 59 + ($boolChangeStatus == null ? 43 : $boolChangeStatus.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $promoterName = this.getPromoterName();
      return result * 59 + ($promoterName == null ? 43 : $promoterName.hashCode());
   }

   @Override
   public String toString() {
      return "QhseProblemQueryDTOParam(startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", projectId="
         + this.getProjectId()
         + ", problemTypeId="
         + this.getProblemTypeId()
         + ", boolChangeStatus="
         + this.getBoolChangeStatus()
         + ", projectName="
         + this.getProjectName()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", promoterName="
         + this.getPromoterName()
         + ")";
   }
}
