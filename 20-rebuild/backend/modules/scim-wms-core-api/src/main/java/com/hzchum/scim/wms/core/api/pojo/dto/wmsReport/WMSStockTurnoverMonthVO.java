package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class WMSStockTurnoverMonthVO {
   private String dateStr;
   private LocalDateTime dateTime;
   private BigDecimal inAmount;
   private BigDecimal inMete;
   private BigDecimal outAmount;
   private BigDecimal outMete;
   private BigDecimal stockTurnover;

   public static WMSStockTurnoverMonthVO.WMSStockTurnoverMonthVOBuilder builder() {
      return new WMSStockTurnoverMonthVO.WMSStockTurnoverMonthVOBuilder();
   }

   public String getDateStr() {
      return this.dateStr;
   }

   public LocalDateTime getDateTime() {
      return this.dateTime;
   }

   public BigDecimal getInAmount() {
      return this.inAmount;
   }

   public BigDecimal getInMete() {
      return this.inMete;
   }

   public BigDecimal getOutAmount() {
      return this.outAmount;
   }

   public BigDecimal getOutMete() {
      return this.outMete;
   }

   public BigDecimal getStockTurnover() {
      return this.stockTurnover;
   }

   public void setDateStr(final String dateStr) {
      this.dateStr = dateStr;
   }

   public void setDateTime(final LocalDateTime dateTime) {
      this.dateTime = dateTime;
   }

   public void setInAmount(final BigDecimal inAmount) {
      this.inAmount = inAmount;
   }

   public void setInMete(final BigDecimal inMete) {
      this.inMete = inMete;
   }

   public void setOutAmount(final BigDecimal outAmount) {
      this.outAmount = outAmount;
   }

   public void setOutMete(final BigDecimal outMete) {
      this.outMete = outMete;
   }

   public void setStockTurnover(final BigDecimal stockTurnover) {
      this.stockTurnover = stockTurnover;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WMSStockTurnoverMonthVO)) {
         return false;
      }

      WMSStockTurnoverMonthVO other = (WMSStockTurnoverMonthVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$dateStr = this.getDateStr();
      Object other$dateStr = other.getDateStr();
      if (this$dateStr == null ? other$dateStr == null : this$dateStr.equals(other$dateStr)) {
         Object this$dateTime = this.getDateTime();
         Object other$dateTime = other.getDateTime();
         if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
            Object this$inAmount = this.getInAmount();
            Object other$inAmount = other.getInAmount();
            if (this$inAmount == null ? other$inAmount == null : this$inAmount.equals(other$inAmount)) {
               Object this$inMete = this.getInMete();
               Object other$inMete = other.getInMete();
               if (this$inMete == null ? other$inMete == null : this$inMete.equals(other$inMete)) {
                  Object this$outAmount = this.getOutAmount();
                  Object other$outAmount = other.getOutAmount();
                  if (this$outAmount == null ? other$outAmount == null : this$outAmount.equals(other$outAmount)) {
                     Object this$outMete = this.getOutMete();
                     Object other$outMete = other.getOutMete();
                     if (this$outMete == null ? other$outMete == null : this$outMete.equals(other$outMete)) {
                        Object this$stockTurnover = this.getStockTurnover();
                        Object other$stockTurnover = other.getStockTurnover();
                        return this$stockTurnover == null ? other$stockTurnover == null : this$stockTurnover.equals(other$stockTurnover);
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
      return other instanceof WMSStockTurnoverMonthVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dateStr = this.getDateStr();
      result = result * 59 + ($dateStr == null ? 43 : $dateStr.hashCode());
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $inAmount = this.getInAmount();
      result = result * 59 + ($inAmount == null ? 43 : $inAmount.hashCode());
      Object $inMete = this.getInMete();
      result = result * 59 + ($inMete == null ? 43 : $inMete.hashCode());
      Object $outAmount = this.getOutAmount();
      result = result * 59 + ($outAmount == null ? 43 : $outAmount.hashCode());
      Object $outMete = this.getOutMete();
      result = result * 59 + ($outMete == null ? 43 : $outMete.hashCode());
      Object $stockTurnover = this.getStockTurnover();
      return result * 59 + ($stockTurnover == null ? 43 : $stockTurnover.hashCode());
   }

   @Override
   public String toString() {
      return "WMSStockTurnoverMonthVO(dateStr="
         + this.getDateStr()
         + ", dateTime="
         + this.getDateTime()
         + ", inAmount="
         + this.getInAmount()
         + ", inMete="
         + this.getInMete()
         + ", outAmount="
         + this.getOutAmount()
         + ", outMete="
         + this.getOutMete()
         + ", stockTurnover="
         + this.getStockTurnover()
         + ")";
   }

   public WMSStockTurnoverMonthVO(
      final String dateStr,
      final LocalDateTime dateTime,
      final BigDecimal inAmount,
      final BigDecimal inMete,
      final BigDecimal outAmount,
      final BigDecimal outMete,
      final BigDecimal stockTurnover
   ) {
      this.dateStr = dateStr;
      this.dateTime = dateTime;
      this.inAmount = inAmount;
      this.inMete = inMete;
      this.outAmount = outAmount;
      this.outMete = outMete;
      this.stockTurnover = stockTurnover;
   }

   public WMSStockTurnoverMonthVO() {
   }

   public static class WMSStockTurnoverMonthVOBuilder {
      private String dateStr;
      private LocalDateTime dateTime;
      private BigDecimal inAmount;
      private BigDecimal inMete;
      private BigDecimal outAmount;
      private BigDecimal outMete;
      private BigDecimal stockTurnover;

      WMSStockTurnoverMonthVOBuilder() {
      }

      public WMSStockTurnoverMonthVO.WMSStockTurnoverMonthVOBuilder dateStr(final String dateStr) {
         this.dateStr = dateStr;
         return this;
      }

      public WMSStockTurnoverMonthVO.WMSStockTurnoverMonthVOBuilder dateTime(final LocalDateTime dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      public WMSStockTurnoverMonthVO.WMSStockTurnoverMonthVOBuilder inAmount(final BigDecimal inAmount) {
         this.inAmount = inAmount;
         return this;
      }

      public WMSStockTurnoverMonthVO.WMSStockTurnoverMonthVOBuilder inMete(final BigDecimal inMete) {
         this.inMete = inMete;
         return this;
      }

      public WMSStockTurnoverMonthVO.WMSStockTurnoverMonthVOBuilder outAmount(final BigDecimal outAmount) {
         this.outAmount = outAmount;
         return this;
      }

      public WMSStockTurnoverMonthVO.WMSStockTurnoverMonthVOBuilder outMete(final BigDecimal outMete) {
         this.outMete = outMete;
         return this;
      }

      public WMSStockTurnoverMonthVO.WMSStockTurnoverMonthVOBuilder stockTurnover(final BigDecimal stockTurnover) {
         this.stockTurnover = stockTurnover;
         return this;
      }

      public WMSStockTurnoverMonthVO build() {
         return new WMSStockTurnoverMonthVO(this.dateStr, this.dateTime, this.inAmount, this.inMete, this.outAmount, this.outMete, this.stockTurnover);
      }

      @Override
      public String toString() {
         return "WMSStockTurnoverMonthVO.WMSStockTurnoverMonthVOBuilder(dateStr="
            + this.dateStr
            + ", dateTime="
            + this.dateTime
            + ", inAmount="
            + this.inAmount
            + ", inMete="
            + this.inMete
            + ", outAmount="
            + this.outAmount
            + ", outMete="
            + this.outMete
            + ", stockTurnover="
            + this.stockTurnover
            + ")";
      }
   }
}
