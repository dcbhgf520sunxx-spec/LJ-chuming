package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InboundAndOutboundDataDTO {
   private String dateStr;
   private LocalDateTime dateTime;
   private BigDecimal inboundAmount;
   private BigDecimal inboundMete;
   private BigDecimal outboundAmount;
   private BigDecimal outboundMete;

   public static InboundAndOutboundDataDTO.InboundAndOutboundDataDTOBuilder builder() {
      return new InboundAndOutboundDataDTO.InboundAndOutboundDataDTOBuilder();
   }

   public String getDateStr() {
      return this.dateStr;
   }

   public LocalDateTime getDateTime() {
      return this.dateTime;
   }

   public BigDecimal getInboundAmount() {
      return this.inboundAmount;
   }

   public BigDecimal getInboundMete() {
      return this.inboundMete;
   }

   public BigDecimal getOutboundAmount() {
      return this.outboundAmount;
   }

   public BigDecimal getOutboundMete() {
      return this.outboundMete;
   }

   public void setDateStr(final String dateStr) {
      this.dateStr = dateStr;
   }

   public void setDateTime(final LocalDateTime dateTime) {
      this.dateTime = dateTime;
   }

   public void setInboundAmount(final BigDecimal inboundAmount) {
      this.inboundAmount = inboundAmount;
   }

   public void setInboundMete(final BigDecimal inboundMete) {
      this.inboundMete = inboundMete;
   }

   public void setOutboundAmount(final BigDecimal outboundAmount) {
      this.outboundAmount = outboundAmount;
   }

   public void setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundAndOutboundDataDTO)) {
         return false;
      }

      InboundAndOutboundDataDTO other = (InboundAndOutboundDataDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$dateStr = this.getDateStr();
      Object other$dateStr = other.getDateStr();
      if (this$dateStr == null ? other$dateStr == null : this$dateStr.equals(other$dateStr)) {
         Object this$dateTime = this.getDateTime();
         Object other$dateTime = other.getDateTime();
         if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
            Object this$inboundAmount = this.getInboundAmount();
            Object other$inboundAmount = other.getInboundAmount();
            if (this$inboundAmount == null ? other$inboundAmount == null : this$inboundAmount.equals(other$inboundAmount)) {
               Object this$inboundMete = this.getInboundMete();
               Object other$inboundMete = other.getInboundMete();
               if (this$inboundMete == null ? other$inboundMete == null : this$inboundMete.equals(other$inboundMete)) {
                  Object this$outboundAmount = this.getOutboundAmount();
                  Object other$outboundAmount = other.getOutboundAmount();
                  if (this$outboundAmount == null ? other$outboundAmount == null : this$outboundAmount.equals(other$outboundAmount)) {
                     Object this$outboundMete = this.getOutboundMete();
                     Object other$outboundMete = other.getOutboundMete();
                     return this$outboundMete == null ? other$outboundMete == null : this$outboundMete.equals(other$outboundMete);
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
      return other instanceof InboundAndOutboundDataDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dateStr = this.getDateStr();
      result = result * 59 + ($dateStr == null ? 43 : $dateStr.hashCode());
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $inboundAmount = this.getInboundAmount();
      result = result * 59 + ($inboundAmount == null ? 43 : $inboundAmount.hashCode());
      Object $inboundMete = this.getInboundMete();
      result = result * 59 + ($inboundMete == null ? 43 : $inboundMete.hashCode());
      Object $outboundAmount = this.getOutboundAmount();
      result = result * 59 + ($outboundAmount == null ? 43 : $outboundAmount.hashCode());
      Object $outboundMete = this.getOutboundMete();
      return result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
   }

   @Override
   public String toString() {
      return "InboundAndOutboundDataDTO(dateStr="
         + this.getDateStr()
         + ", dateTime="
         + this.getDateTime()
         + ", inboundAmount="
         + this.getInboundAmount()
         + ", inboundMete="
         + this.getInboundMete()
         + ", outboundAmount="
         + this.getOutboundAmount()
         + ", outboundMete="
         + this.getOutboundMete()
         + ")";
   }

   public InboundAndOutboundDataDTO(
      final String dateStr,
      final LocalDateTime dateTime,
      final BigDecimal inboundAmount,
      final BigDecimal inboundMete,
      final BigDecimal outboundAmount,
      final BigDecimal outboundMete
   ) {
      this.dateStr = dateStr;
      this.dateTime = dateTime;
      this.inboundAmount = inboundAmount;
      this.inboundMete = inboundMete;
      this.outboundAmount = outboundAmount;
      this.outboundMete = outboundMete;
   }

   public InboundAndOutboundDataDTO() {
   }

   public static class InboundAndOutboundDataDTOBuilder {
      private String dateStr;
      private LocalDateTime dateTime;
      private BigDecimal inboundAmount;
      private BigDecimal inboundMete;
      private BigDecimal outboundAmount;
      private BigDecimal outboundMete;

      InboundAndOutboundDataDTOBuilder() {
      }

      public InboundAndOutboundDataDTO.InboundAndOutboundDataDTOBuilder dateStr(final String dateStr) {
         this.dateStr = dateStr;
         return this;
      }

      public InboundAndOutboundDataDTO.InboundAndOutboundDataDTOBuilder dateTime(final LocalDateTime dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      public InboundAndOutboundDataDTO.InboundAndOutboundDataDTOBuilder inboundAmount(final BigDecimal inboundAmount) {
         this.inboundAmount = inboundAmount;
         return this;
      }

      public InboundAndOutboundDataDTO.InboundAndOutboundDataDTOBuilder inboundMete(final BigDecimal inboundMete) {
         this.inboundMete = inboundMete;
         return this;
      }

      public InboundAndOutboundDataDTO.InboundAndOutboundDataDTOBuilder outboundAmount(final BigDecimal outboundAmount) {
         this.outboundAmount = outboundAmount;
         return this;
      }

      public InboundAndOutboundDataDTO.InboundAndOutboundDataDTOBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      public InboundAndOutboundDataDTO build() {
         return new InboundAndOutboundDataDTO(this.dateStr, this.dateTime, this.inboundAmount, this.inboundMete, this.outboundAmount, this.outboundMete);
      }

      @Override
      public String toString() {
         return "InboundAndOutboundDataDTO.InboundAndOutboundDataDTOBuilder(dateStr="
            + this.dateStr
            + ", dateTime="
            + this.dateTime
            + ", inboundAmount="
            + this.inboundAmount
            + ", inboundMete="
            + this.inboundMete
            + ", outboundAmount="
            + this.outboundAmount
            + ", outboundMete="
            + this.outboundMete
            + ")";
      }
   }
}
