package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiOperation("付款台账审批记录")
public class SupplierListDto {
   @ApiModelProperty("提交日期")
   private LocalDateTime submitDate;
   @ApiModelProperty("提交人")
   private String submitUserName;
   @ApiModelProperty("项目经理")
   private String projectManagerName;
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("供应商")
   private String supplier;
   @ApiModelProperty("发票额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("税率")
   private BigDecimal taxRate;
   @ApiModelProperty("发票编号")
   private String invoiceNumber;
   @ApiModelProperty("OA编号")
   private String oaNumber;
   @ApiModelProperty("审核状态")
   private Integer auditStatus;

   public LocalDateTime getSubmitDate() {
      return this.submitDate;
   }

   public String getSubmitUserName() {
      return this.submitUserName;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getSupplier() {
      return this.supplier;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public String getInvoiceNumber() {
      return this.invoiceNumber;
   }

   public String getOaNumber() {
      return this.oaNumber;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public void setSubmitDate(final LocalDateTime submitDate) {
      this.submitDate = submitDate;
   }

   public void setSubmitUserName(final String submitUserName) {
      this.submitUserName = submitUserName;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setSupplier(final String supplier) {
      this.supplier = supplier;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setInvoiceNumber(final String invoiceNumber) {
      this.invoiceNumber = invoiceNumber;
   }

   public void setOaNumber(final String oaNumber) {
      this.oaNumber = oaNumber;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierListDto)) {
         return false;
      }

      SupplierListDto other = (SupplierListDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$auditStatus = this.getAuditStatus();
      Object other$auditStatus = other.getAuditStatus();
      if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
         Object this$submitDate = this.getSubmitDate();
         Object other$submitDate = other.getSubmitDate();
         if (this$submitDate == null ? other$submitDate == null : this$submitDate.equals(other$submitDate)) {
            Object this$submitUserName = this.getSubmitUserName();
            Object other$submitUserName = other.getSubmitUserName();
            if (this$submitUserName == null ? other$submitUserName == null : this$submitUserName.equals(other$submitUserName)) {
               Object this$projectManagerName = this.getProjectManagerName();
               Object other$projectManagerName = other.getProjectManagerName();
               if (this$projectManagerName == null ? other$projectManagerName == null : this$projectManagerName.equals(other$projectManagerName)) {
                  Object this$project = this.getProject();
                  Object other$project = other.getProject();
                  if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                     Object this$supplier = this.getSupplier();
                     Object other$supplier = other.getSupplier();
                     if (this$supplier == null ? other$supplier == null : this$supplier.equals(other$supplier)) {
                        Object this$invoiceAmount = this.getInvoiceAmount();
                        Object other$invoiceAmount = other.getInvoiceAmount();
                        if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                           Object this$taxRate = this.getTaxRate();
                           Object other$taxRate = other.getTaxRate();
                           if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                              Object this$invoiceNumber = this.getInvoiceNumber();
                              Object other$invoiceNumber = other.getInvoiceNumber();
                              if (this$invoiceNumber == null ? other$invoiceNumber == null : this$invoiceNumber.equals(other$invoiceNumber)) {
                                 Object this$oaNumber = this.getOaNumber();
                                 Object other$oaNumber = other.getOaNumber();
                                 return this$oaNumber == null ? other$oaNumber == null : this$oaNumber.equals(other$oaNumber);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SupplierListDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $submitDate = this.getSubmitDate();
      result = result * 59 + ($submitDate == null ? 43 : $submitDate.hashCode());
      Object $submitUserName = this.getSubmitUserName();
      result = result * 59 + ($submitUserName == null ? 43 : $submitUserName.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $supplier = this.getSupplier();
      result = result * 59 + ($supplier == null ? 43 : $supplier.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $invoiceNumber = this.getInvoiceNumber();
      result = result * 59 + ($invoiceNumber == null ? 43 : $invoiceNumber.hashCode());
      Object $oaNumber = this.getOaNumber();
      return result * 59 + ($oaNumber == null ? 43 : $oaNumber.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierListDto(submitDate="
         + this.getSubmitDate()
         + ", submitUserName="
         + this.getSubmitUserName()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", project="
         + this.getProject()
         + ", supplier="
         + this.getSupplier()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", taxRate="
         + this.getTaxRate()
         + ", invoiceNumber="
         + this.getInvoiceNumber()
         + ", oaNumber="
         + this.getOaNumber()
         + ", auditStatus="
         + this.getAuditStatus()
         + ")";
   }
}
