package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class StatisticsMonthManufacturedCountDTO {
   @ApiModelProperty("期初金额")
   private BigDecimal beginMonthAmount;
   @ApiModelProperty("入库金额")
   private BigDecimal inboundAmount;
   @ApiModelProperty("出库金额")
   private BigDecimal outboundAmount;
   @ApiModelProperty("退库金额")
   private BigDecimal returnAmount;
   @ApiModelProperty("期末金额")
   private BigDecimal endMonthAmount;

   public static StatisticsMonthManufacturedCountDTO.StatisticsMonthManufacturedCountDTOBuilder builder() {
      return new StatisticsMonthManufacturedCountDTO.StatisticsMonthManufacturedCountDTOBuilder();
   }

   public BigDecimal getBeginMonthAmount() {
      return this.beginMonthAmount;
   }

   public BigDecimal getInboundAmount() {
      return this.inboundAmount;
   }

   public BigDecimal getOutboundAmount() {
      return this.outboundAmount;
   }

   public BigDecimal getReturnAmount() {
      return this.returnAmount;
   }

   public BigDecimal getEndMonthAmount() {
      return this.endMonthAmount;
   }

   public void setBeginMonthAmount(final BigDecimal beginMonthAmount) {
      this.beginMonthAmount = beginMonthAmount;
   }

   public void setInboundAmount(final BigDecimal inboundAmount) {
      this.inboundAmount = inboundAmount;
   }

   public void setOutboundAmount(final BigDecimal outboundAmount) {
      this.outboundAmount = outboundAmount;
   }

   public void setReturnAmount(final BigDecimal returnAmount) {
      this.returnAmount = returnAmount;
   }

   public void setEndMonthAmount(final BigDecimal endMonthAmount) {
      this.endMonthAmount = endMonthAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StatisticsMonthManufacturedCountDTO)) {
         return false;
      }

      StatisticsMonthManufacturedCountDTO other = (StatisticsMonthManufacturedCountDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$beginMonthAmount = this.getBeginMonthAmount();
      Object other$beginMonthAmount = other.getBeginMonthAmount();
      if (this$beginMonthAmount == null ? other$beginMonthAmount == null : this$beginMonthAmount.equals(other$beginMonthAmount)) {
         Object this$inboundAmount = this.getInboundAmount();
         Object other$inboundAmount = other.getInboundAmount();
         if (this$inboundAmount == null ? other$inboundAmount == null : this$inboundAmount.equals(other$inboundAmount)) {
            Object this$outboundAmount = this.getOutboundAmount();
            Object other$outboundAmount = other.getOutboundAmount();
            if (this$outboundAmount == null ? other$outboundAmount == null : this$outboundAmount.equals(other$outboundAmount)) {
               Object this$returnAmount = this.getReturnAmount();
               Object other$returnAmount = other.getReturnAmount();
               if (this$returnAmount == null ? other$returnAmount == null : this$returnAmount.equals(other$returnAmount)) {
                  Object this$endMonthAmount = this.getEndMonthAmount();
                  Object other$endMonthAmount = other.getEndMonthAmount();
                  return this$endMonthAmount == null ? other$endMonthAmount == null : this$endMonthAmount.equals(other$endMonthAmount);
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
      return other instanceof StatisticsMonthManufacturedCountDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $beginMonthAmount = this.getBeginMonthAmount();
      result = result * 59 + ($beginMonthAmount == null ? 43 : $beginMonthAmount.hashCode());
      Object $inboundAmount = this.getInboundAmount();
      result = result * 59 + ($inboundAmount == null ? 43 : $inboundAmount.hashCode());
      Object $outboundAmount = this.getOutboundAmount();
      result = result * 59 + ($outboundAmount == null ? 43 : $outboundAmount.hashCode());
      Object $returnAmount = this.getReturnAmount();
      result = result * 59 + ($returnAmount == null ? 43 : $returnAmount.hashCode());
      Object $endMonthAmount = this.getEndMonthAmount();
      return result * 59 + ($endMonthAmount == null ? 43 : $endMonthAmount.hashCode());
   }

   @Override
   public String toString() {
      return "StatisticsMonthManufacturedCountDTO(beginMonthAmount="
         + this.getBeginMonthAmount()
         + ", inboundAmount="
         + this.getInboundAmount()
         + ", outboundAmount="
         + this.getOutboundAmount()
         + ", returnAmount="
         + this.getReturnAmount()
         + ", endMonthAmount="
         + this.getEndMonthAmount()
         + ")";
   }

   public StatisticsMonthManufacturedCountDTO(
      final BigDecimal beginMonthAmount,
      final BigDecimal inboundAmount,
      final BigDecimal outboundAmount,
      final BigDecimal returnAmount,
      final BigDecimal endMonthAmount
   ) {
      this.beginMonthAmount = beginMonthAmount;
      this.inboundAmount = inboundAmount;
      this.outboundAmount = outboundAmount;
      this.returnAmount = returnAmount;
      this.endMonthAmount = endMonthAmount;
   }

   public StatisticsMonthManufacturedCountDTO() {
   }

   public static class StatisticsMonthManufacturedCountDTOBuilder {
      private BigDecimal beginMonthAmount;
      private BigDecimal inboundAmount;
      private BigDecimal outboundAmount;
      private BigDecimal returnAmount;
      private BigDecimal endMonthAmount;

      StatisticsMonthManufacturedCountDTOBuilder() {
      }

      public StatisticsMonthManufacturedCountDTO.StatisticsMonthManufacturedCountDTOBuilder beginMonthAmount(final BigDecimal beginMonthAmount) {
         this.beginMonthAmount = beginMonthAmount;
         return this;
      }

      public StatisticsMonthManufacturedCountDTO.StatisticsMonthManufacturedCountDTOBuilder inboundAmount(final BigDecimal inboundAmount) {
         this.inboundAmount = inboundAmount;
         return this;
      }

      public StatisticsMonthManufacturedCountDTO.StatisticsMonthManufacturedCountDTOBuilder outboundAmount(final BigDecimal outboundAmount) {
         this.outboundAmount = outboundAmount;
         return this;
      }

      public StatisticsMonthManufacturedCountDTO.StatisticsMonthManufacturedCountDTOBuilder returnAmount(final BigDecimal returnAmount) {
         this.returnAmount = returnAmount;
         return this;
      }

      public StatisticsMonthManufacturedCountDTO.StatisticsMonthManufacturedCountDTOBuilder endMonthAmount(final BigDecimal endMonthAmount) {
         this.endMonthAmount = endMonthAmount;
         return this;
      }

      public StatisticsMonthManufacturedCountDTO build() {
         return new StatisticsMonthManufacturedCountDTO(this.beginMonthAmount, this.inboundAmount, this.outboundAmount, this.returnAmount, this.endMonthAmount);
      }

      @Override
      public String toString() {
         return "StatisticsMonthManufacturedCountDTO.StatisticsMonthManufacturedCountDTOBuilder(beginMonthAmount="
            + this.beginMonthAmount
            + ", inboundAmount="
            + this.inboundAmount
            + ", outboundAmount="
            + this.outboundAmount
            + ", returnAmount="
            + this.returnAmount
            + ", endMonthAmount="
            + this.endMonthAmount
            + ")";
      }
   }
}
