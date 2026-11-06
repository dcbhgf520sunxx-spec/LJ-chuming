package com.hzchum.scim.business.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class BusinessPriceSummaryInfoDTO {
   @ApiModelProperty("已计价数量")
   private BigDecimal pricingQuantity;
   @ApiModelProperty("已计价金额")
   private BigDecimal pricingAmount;
   @ApiModelProperty("未计价数量")
   private BigDecimal unPricingQuantity;

   public static BusinessPriceSummaryInfoDTO.BusinessPriceSummaryInfoDTOBuilder builder() {
      return new BusinessPriceSummaryInfoDTO.BusinessPriceSummaryInfoDTOBuilder();
   }

   public BusinessPriceSummaryInfoDTO() {
   }

   public BusinessPriceSummaryInfoDTO(final BigDecimal pricingQuantity, final BigDecimal pricingAmount, final BigDecimal unPricingQuantity) {
      this.pricingQuantity = pricingQuantity;
      this.pricingAmount = pricingAmount;
      this.unPricingQuantity = unPricingQuantity;
   }

   public BigDecimal getPricingQuantity() {
      return this.pricingQuantity;
   }

   public BigDecimal getPricingAmount() {
      return this.pricingAmount;
   }

   public BigDecimal getUnPricingQuantity() {
      return this.unPricingQuantity;
   }

   public void setPricingQuantity(final BigDecimal pricingQuantity) {
      this.pricingQuantity = pricingQuantity;
   }

   public void setPricingAmount(final BigDecimal pricingAmount) {
      this.pricingAmount = pricingAmount;
   }

   public void setUnPricingQuantity(final BigDecimal unPricingQuantity) {
      this.unPricingQuantity = unPricingQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessPriceSummaryInfoDTO)) {
         return false;
      }

      BusinessPriceSummaryInfoDTO other = (BusinessPriceSummaryInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$pricingQuantity = this.getPricingQuantity();
      Object other$pricingQuantity = other.getPricingQuantity();
      if (this$pricingQuantity == null ? other$pricingQuantity == null : this$pricingQuantity.equals(other$pricingQuantity)) {
         Object this$pricingAmount = this.getPricingAmount();
         Object other$pricingAmount = other.getPricingAmount();
         if (this$pricingAmount == null ? other$pricingAmount == null : this$pricingAmount.equals(other$pricingAmount)) {
            Object this$unPricingQuantity = this.getUnPricingQuantity();
            Object other$unPricingQuantity = other.getUnPricingQuantity();
            return this$unPricingQuantity == null ? other$unPricingQuantity == null : this$unPricingQuantity.equals(other$unPricingQuantity);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BusinessPriceSummaryInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $pricingQuantity = this.getPricingQuantity();
      result = result * 59 + ($pricingQuantity == null ? 43 : $pricingQuantity.hashCode());
      Object $pricingAmount = this.getPricingAmount();
      result = result * 59 + ($pricingAmount == null ? 43 : $pricingAmount.hashCode());
      Object $unPricingQuantity = this.getUnPricingQuantity();
      return result * 59 + ($unPricingQuantity == null ? 43 : $unPricingQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessPriceSummaryInfoDTO(pricingQuantity="
         + this.getPricingQuantity()
         + ", pricingAmount="
         + this.getPricingAmount()
         + ", unPricingQuantity="
         + this.getUnPricingQuantity()
         + ")";
   }

   public static class BusinessPriceSummaryInfoDTOBuilder {
      private BigDecimal pricingQuantity;
      private BigDecimal pricingAmount;
      private BigDecimal unPricingQuantity;

      BusinessPriceSummaryInfoDTOBuilder() {
      }

      public BusinessPriceSummaryInfoDTO.BusinessPriceSummaryInfoDTOBuilder pricingQuantity(final BigDecimal pricingQuantity) {
         this.pricingQuantity = pricingQuantity;
         return this;
      }

      public BusinessPriceSummaryInfoDTO.BusinessPriceSummaryInfoDTOBuilder pricingAmount(final BigDecimal pricingAmount) {
         this.pricingAmount = pricingAmount;
         return this;
      }

      public BusinessPriceSummaryInfoDTO.BusinessPriceSummaryInfoDTOBuilder unPricingQuantity(final BigDecimal unPricingQuantity) {
         this.unPricingQuantity = unPricingQuantity;
         return this;
      }

      public BusinessPriceSummaryInfoDTO build() {
         return new BusinessPriceSummaryInfoDTO(this.pricingQuantity, this.pricingAmount, this.unPricingQuantity);
      }

      @Override
      public String toString() {
         return "BusinessPriceSummaryInfoDTO.BusinessPriceSummaryInfoDTOBuilder(pricingQuantity="
            + this.pricingQuantity
            + ", pricingAmount="
            + this.pricingAmount
            + ", unPricingQuantity="
            + this.unPricingQuantity
            + ")";
      }
   }
}
