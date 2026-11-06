package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;

@ApiModel("自合营台账详情台账 返回类")
public class ProjectLedgerDetailDTO {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "collectionDate", value = "收款（开票）时间")
   private LocalDate date;
   @ApiModelProperty(name = "remark", value = "备注")
   private String remark;
   @ApiModelProperty(name = "accumulatedCollection", notes = "收款金额")
   private BigDecimal collectionAmount;
   @ApiModelProperty(name = "accumulatedInvoice", notes = "开票金额")
   private BigDecimal invoiceAmount;

   public Long getProjectId() {
      return this.projectId;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public String getRemark() {
      return this.remark;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setDate(final LocalDate date) {
      this.date = date;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setCollectionAmount(final BigDecimal collectionAmount) {
      this.collectionAmount = collectionAmount;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectLedgerDetailDTO)) {
         return false;
      }

      ProjectLedgerDetailDTO other = (ProjectLedgerDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$date = this.getDate();
         Object other$date = other.getDate();
         if (this$date == null ? other$date == null : this$date.equals(other$date)) {
            Object this$remark = this.getRemark();
            Object other$remark = other.getRemark();
            if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
               Object this$collectionAmount = this.getCollectionAmount();
               Object other$collectionAmount = other.getCollectionAmount();
               if (this$collectionAmount == null ? other$collectionAmount == null : this$collectionAmount.equals(other$collectionAmount)) {
                  Object this$invoiceAmount = this.getInvoiceAmount();
                  Object other$invoiceAmount = other.getInvoiceAmount();
                  return this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount);
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
      return other instanceof ProjectLedgerDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      return result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectLedgerDetailDTO(projectId="
         + this.getProjectId()
         + ", date="
         + this.getDate()
         + ", remark="
         + this.getRemark()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ")";
   }
}
