package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class AdjustDetailDTOParam {
   private Long inboundId;
   private Long inboundDetailId;
   @ApiModelProperty(name = "amount", value = "总价")
   private BigDecimal amount;
   @ApiModelProperty(name = "amountExcludingVat", value = "不含税总价")
   private BigDecimal amountExcludingVat;
   @ApiModelProperty(name = "inputVat", value = "进项税")
   private BigDecimal inputVat;

   public static AdjustDetailDTOParam.AdjustDetailDTOParamBuilder builder() {
      return new AdjustDetailDTOParam.AdjustDetailDTOParamBuilder();
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public Long getInboundDetailId() {
      return this.inboundDetailId;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public void setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
   }

   public void setInboundDetailId(final Long inboundDetailId) {
      this.inboundDetailId = inboundDetailId;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   public void setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AdjustDetailDTOParam)) {
         return false;
      }

      AdjustDetailDTOParam other = (AdjustDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$inboundId = this.getInboundId();
      Object other$inboundId = other.getInboundId();
      if (this$inboundId == null ? other$inboundId == null : this$inboundId.equals(other$inboundId)) {
         Object this$inboundDetailId = this.getInboundDetailId();
         Object other$inboundDetailId = other.getInboundDetailId();
         if (this$inboundDetailId == null ? other$inboundDetailId == null : this$inboundDetailId.equals(other$inboundDetailId)) {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
               Object this$amountExcludingVat = this.getAmountExcludingVat();
               Object other$amountExcludingVat = other.getAmountExcludingVat();
               if (this$amountExcludingVat == null ? other$amountExcludingVat == null : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                  Object this$inputVat = this.getInputVat();
                  Object other$inputVat = other.getInputVat();
                  return this$inputVat == null ? other$inputVat == null : this$inputVat.equals(other$inputVat);
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
      return other instanceof AdjustDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $inboundDetailId = this.getInboundDetailId();
      result = result * 59 + ($inboundDetailId == null ? 43 : $inboundDetailId.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      return result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
   }

   @Override
   public String toString() {
      return "AdjustDetailDTOParam(inboundId="
         + this.getInboundId()
         + ", inboundDetailId="
         + this.getInboundDetailId()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ")";
   }

   public AdjustDetailDTOParam(
      final Long inboundId, final Long inboundDetailId, final BigDecimal amount, final BigDecimal amountExcludingVat, final BigDecimal inputVat
   ) {
      this.inboundId = inboundId;
      this.inboundDetailId = inboundDetailId;
      this.amount = amount;
      this.amountExcludingVat = amountExcludingVat;
      this.inputVat = inputVat;
   }

   public AdjustDetailDTOParam() {
   }

   public static class AdjustDetailDTOParamBuilder {
      private Long inboundId;
      private Long inboundDetailId;
      private BigDecimal amount;
      private BigDecimal amountExcludingVat;
      private BigDecimal inputVat;

      AdjustDetailDTOParamBuilder() {
      }

      public AdjustDetailDTOParam.AdjustDetailDTOParamBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      public AdjustDetailDTOParam.AdjustDetailDTOParamBuilder inboundDetailId(final Long inboundDetailId) {
         this.inboundDetailId = inboundDetailId;
         return this;
      }

      public AdjustDetailDTOParam.AdjustDetailDTOParamBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public AdjustDetailDTOParam.AdjustDetailDTOParamBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public AdjustDetailDTOParam.AdjustDetailDTOParamBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      public AdjustDetailDTOParam build() {
         return new AdjustDetailDTOParam(this.inboundId, this.inboundDetailId, this.amount, this.amountExcludingVat, this.inputVat);
      }

      @Override
      public String toString() {
         return "AdjustDetailDTOParam.AdjustDetailDTOParamBuilder(inboundId="
            + this.inboundId
            + ", inboundDetailId="
            + this.inboundDetailId
            + ", amount="
            + this.amount
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", inputVat="
            + this.inputVat
            + ")";
      }
   }
}
