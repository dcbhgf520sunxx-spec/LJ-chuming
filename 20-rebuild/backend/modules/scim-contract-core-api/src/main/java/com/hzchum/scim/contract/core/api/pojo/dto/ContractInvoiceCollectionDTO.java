package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ContractInvoiceCollectionDTO {
   @ApiModelProperty(name = "invoiceAmount", value = "已开票额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty(name = "collectionAmount", value = "已收款额")
   private BigDecimal collectionAmount;

   public static ContractInvoiceCollectionDTO.ContractInvoiceCollectionDTOBuilder builder() {
      return new ContractInvoiceCollectionDTO.ContractInvoiceCollectionDTOBuilder();
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setCollectionAmount(final BigDecimal collectionAmount) {
      this.collectionAmount = collectionAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ContractInvoiceCollectionDTO)) {
         return false;
      } else {
         ContractInvoiceCollectionDTO other = (ContractInvoiceCollectionDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$invoiceAmount = this.getInvoiceAmount();
            Object other$invoiceAmount = other.getInvoiceAmount();
            if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
               Object this$collectionAmount = this.getCollectionAmount();
               Object other$collectionAmount = other.getCollectionAmount();
               return this$collectionAmount == null ? other$collectionAmount == null : this$collectionAmount.equals(other$collectionAmount);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractInvoiceCollectionDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      return result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ContractInvoiceCollectionDTO(invoiceAmount=" + this.getInvoiceAmount() + ", collectionAmount=" + this.getCollectionAmount() + ")";
   }

   public ContractInvoiceCollectionDTO(final BigDecimal invoiceAmount, final BigDecimal collectionAmount) {
      this.invoiceAmount = invoiceAmount;
      this.collectionAmount = collectionAmount;
   }

   public ContractInvoiceCollectionDTO() {
   }

   public static class ContractInvoiceCollectionDTOBuilder {
      private BigDecimal invoiceAmount;
      private BigDecimal collectionAmount;

      ContractInvoiceCollectionDTOBuilder() {
      }

      public ContractInvoiceCollectionDTO.ContractInvoiceCollectionDTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public ContractInvoiceCollectionDTO.ContractInvoiceCollectionDTOBuilder collectionAmount(final BigDecimal collectionAmount) {
         this.collectionAmount = collectionAmount;
         return this;
      }

      public ContractInvoiceCollectionDTO build() {
         return new ContractInvoiceCollectionDTO(this.invoiceAmount, this.collectionAmount);
      }

      @Override
      public String toString() {
         return "ContractInvoiceCollectionDTO.ContractInvoiceCollectionDTOBuilder(invoiceAmount="
            + this.invoiceAmount
            + ", collectionAmount="
            + this.collectionAmount
            + ")";
      }
   }
}
