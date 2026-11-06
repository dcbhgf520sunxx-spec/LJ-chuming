package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("入发存报表汇总")
public class WarehouseReportSumDTO {
   @ApiModelProperty("期初库存")
   private BigDecimal beginMete;
   @ApiModelProperty("入库数量")
   private BigDecimal inboundMete;
   @ApiModelProperty("出库数量")
   private BigDecimal outboundMete;
   @ApiModelProperty("期末库存")
   private BigDecimal endMete;

   WarehouseReportSumDTO(final BigDecimal beginMete, final BigDecimal inboundMete, final BigDecimal outboundMete, final BigDecimal endMete) {
      this.beginMete = beginMete;
      this.inboundMete = inboundMete;
      this.outboundMete = outboundMete;
      this.endMete = endMete;
   }

   public static WarehouseReportSumDTO.WarehouseReportSumDTOBuilder builder() {
      return new WarehouseReportSumDTO.WarehouseReportSumDTOBuilder();
   }

   public BigDecimal getBeginMete() {
      return this.beginMete;
   }

   public BigDecimal getInboundMete() {
      return this.inboundMete;
   }

   public BigDecimal getOutboundMete() {
      return this.outboundMete;
   }

   public BigDecimal getEndMete() {
      return this.endMete;
   }

   public void setBeginMete(final BigDecimal beginMete) {
      this.beginMete = beginMete;
   }

   public void setInboundMete(final BigDecimal inboundMete) {
      this.inboundMete = inboundMete;
   }

   public void setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
   }

   public void setEndMete(final BigDecimal endMete) {
      this.endMete = endMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarehouseReportSumDTO)) {
         return false;
      }

      WarehouseReportSumDTO other = (WarehouseReportSumDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$beginMete = this.getBeginMete();
      Object other$beginMete = other.getBeginMete();
      if (this$beginMete == null ? other$beginMete == null : this$beginMete.equals(other$beginMete)) {
         Object this$inboundMete = this.getInboundMete();
         Object other$inboundMete = other.getInboundMete();
         if (this$inboundMete == null ? other$inboundMete == null : this$inboundMete.equals(other$inboundMete)) {
            Object this$outboundMete = this.getOutboundMete();
            Object other$outboundMete = other.getOutboundMete();
            if (this$outboundMete == null ? other$outboundMete == null : this$outboundMete.equals(other$outboundMete)) {
               Object this$endMete = this.getEndMete();
               Object other$endMete = other.getEndMete();
               return this$endMete == null ? other$endMete == null : this$endMete.equals(other$endMete);
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
      return other instanceof WarehouseReportSumDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $beginMete = this.getBeginMete();
      result = result * 59 + ($beginMete == null ? 43 : $beginMete.hashCode());
      Object $inboundMete = this.getInboundMete();
      result = result * 59 + ($inboundMete == null ? 43 : $inboundMete.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $endMete = this.getEndMete();
      return result * 59 + ($endMete == null ? 43 : $endMete.hashCode());
   }

   @Override
   public String toString() {
      return "WarehouseReportSumDTO(beginMete="
         + this.getBeginMete()
         + ", inboundMete="
         + this.getInboundMete()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", endMete="
         + this.getEndMete()
         + ")";
   }

   public static class WarehouseReportSumDTOBuilder {
      private BigDecimal beginMete;
      private BigDecimal inboundMete;
      private BigDecimal outboundMete;
      private BigDecimal endMete;

      WarehouseReportSumDTOBuilder() {
      }

      public WarehouseReportSumDTO.WarehouseReportSumDTOBuilder beginMete(final BigDecimal beginMete) {
         this.beginMete = beginMete;
         return this;
      }

      public WarehouseReportSumDTO.WarehouseReportSumDTOBuilder inboundMete(final BigDecimal inboundMete) {
         this.inboundMete = inboundMete;
         return this;
      }

      public WarehouseReportSumDTO.WarehouseReportSumDTOBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      public WarehouseReportSumDTO.WarehouseReportSumDTOBuilder endMete(final BigDecimal endMete) {
         this.endMete = endMete;
         return this;
      }

      public WarehouseReportSumDTO build() {
         return new WarehouseReportSumDTO(this.beginMete, this.inboundMete, this.outboundMete, this.endMete);
      }

      @Override
      public String toString() {
         return "WarehouseReportSumDTO.WarehouseReportSumDTOBuilder(beginMete="
            + this.beginMete
            + ", inboundMete="
            + this.inboundMete
            + ", outboundMete="
            + this.outboundMete
            + ", endMete="
            + this.endMete
            + ")";
      }
   }
}
