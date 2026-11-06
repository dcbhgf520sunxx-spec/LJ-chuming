package com.hzchum.scim.contract.core.api.pojo.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目统计类")
public class ProjectAnalysisOpenUpDTO {
   @ApiModelProperty("时间")
   @JsonInclude(Include.NON_NULL)
   private String dateTime;
   @ApiModelProperty("收款金额")
   private BigDecimal collectionAmount;
   @ApiModelProperty("开票金额")
   private BigDecimal invoiceAmount;

   public static ProjectAnalysisOpenUpDTO.ProjectAnalysisOpenUpDTOBuilder builder() {
      return new ProjectAnalysisOpenUpDTO.ProjectAnalysisOpenUpDTOBuilder();
   }

   public ProjectAnalysisOpenUpDTO() {
   }

   public ProjectAnalysisOpenUpDTO(final String dateTime, final BigDecimal collectionAmount, final BigDecimal invoiceAmount) {
      this.dateTime = dateTime;
      this.collectionAmount = collectionAmount;
      this.invoiceAmount = invoiceAmount;
   }

   public String getDateTime() {
      return this.dateTime;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public void setDateTime(final String dateTime) {
      this.dateTime = dateTime;
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

      if (!(o instanceof ProjectAnalysisOpenUpDTO)) {
         return false;
      }

      ProjectAnalysisOpenUpDTO other = (ProjectAnalysisOpenUpDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$dateTime = this.getDateTime();
      Object other$dateTime = other.getDateTime();
      if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectAnalysisOpenUpDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      return result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectAnalysisOpenUpDTO(dateTime="
         + this.getDateTime()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ")";
   }

   public static class ProjectAnalysisOpenUpDTOBuilder {
      private String dateTime;
      private BigDecimal collectionAmount;
      private BigDecimal invoiceAmount;

      ProjectAnalysisOpenUpDTOBuilder() {
      }

      public ProjectAnalysisOpenUpDTO.ProjectAnalysisOpenUpDTOBuilder dateTime(final String dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      public ProjectAnalysisOpenUpDTO.ProjectAnalysisOpenUpDTOBuilder collectionAmount(final BigDecimal collectionAmount) {
         this.collectionAmount = collectionAmount;
         return this;
      }

      public ProjectAnalysisOpenUpDTO.ProjectAnalysisOpenUpDTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ProjectAnalysisOpenUpDTO build() {
         return new ProjectAnalysisOpenUpDTO(this.dateTime, this.collectionAmount, this.invoiceAmount);
      }

      @Override
      public String toString() {
         return "ProjectAnalysisOpenUpDTO.ProjectAnalysisOpenUpDTOBuilder(dateTime="
            + this.dateTime
            + ", collectionAmount="
            + this.collectionAmount
            + ", invoiceAmount="
            + this.invoiceAmount
            + ")";
      }
   }
}
