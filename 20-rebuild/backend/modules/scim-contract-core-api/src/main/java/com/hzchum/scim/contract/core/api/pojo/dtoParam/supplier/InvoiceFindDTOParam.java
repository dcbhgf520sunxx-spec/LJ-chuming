package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel(description = "收票列表-查询类")
public class InvoiceFindDTOParam {
   @ApiModelProperty(notes = "分支机构(购方单位)")
   String branchCompanyName;
   @ApiModelProperty(notes = "供应商(销售单位)")
   String supplierName;
   @ApiModelProperty(notes = "项目id")
   Long projectId;
   @ApiModelProperty(notes = "订单号")
   String serialNumber;
   @ApiModelProperty(notes = "开始时间")
   LocalDate startDate;
   @ApiModelProperty(notes = "结束时间")
   LocalDate endDate;
   @ApiModelProperty("审核状态")
   Integer auditStatus;

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
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

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
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

      if (!(o instanceof InvoiceFindDTOParam)) {
         return false;
      }

      InvoiceFindDTOParam other = (InvoiceFindDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$auditStatus = this.getAuditStatus();
         Object other$auditStatus = other.getAuditStatus();
         if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
            Object this$branchCompanyName = this.getBranchCompanyName();
            Object other$branchCompanyName = other.getBranchCompanyName();
            if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
               Object this$supplierName = this.getSupplierName();
               Object other$supplierName = other.getSupplierName();
               if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
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
      return other instanceof InvoiceFindDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "InvoiceFindDTOParam(branchCompanyName="
         + this.getBranchCompanyName()
         + ", supplierName="
         + this.getSupplierName()
         + ", projectId="
         + this.getProjectId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }
}
