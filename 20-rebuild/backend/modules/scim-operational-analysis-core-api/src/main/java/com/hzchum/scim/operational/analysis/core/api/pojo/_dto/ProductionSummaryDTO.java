package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ProductionSummaryDTO {
   @ApiModelProperty(name = "totalMete", value = "累计产量", notes = "累计产量")
   @JsonProperty("totalMete")
   @JSONField(name = "totalMete")
   private BigDecimal totalMete;
   @ApiModelProperty(name = "lastYearTotalMete", value = "去年同期", notes = "去年同期")
   @JsonProperty("lastYearTotalMete")
   @JSONField(name = "lastYearTotalMete")
   private BigDecimal lastYearTotalMete;
   @ApiModelProperty(name = "ratio", value = "同比增长", notes = "同比增长")
   @JsonProperty("ratio")
   @JSONField(name = "ratio")
   private BigDecimal ratio;

   public static ProductionSummaryDTO.ProductionSummaryDTOBuilder builder() {
      return new ProductionSummaryDTO.ProductionSummaryDTOBuilder();
   }

   public BigDecimal getTotalMete() {
      return this.totalMete;
   }

   public BigDecimal getLastYearTotalMete() {
      return this.lastYearTotalMete;
   }

   public BigDecimal getRatio() {
      return this.ratio;
   }

   @JsonProperty("totalMete")
   public void setTotalMete(final BigDecimal totalMete) {
      this.totalMete = totalMete;
   }

   @JsonProperty("lastYearTotalMete")
   public void setLastYearTotalMete(final BigDecimal lastYearTotalMete) {
      this.lastYearTotalMete = lastYearTotalMete;
   }

   @JsonProperty("ratio")
   public void setRatio(final BigDecimal ratio) {
      this.ratio = ratio;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionSummaryDTO)) {
         return false;
      }

      ProductionSummaryDTO other = (ProductionSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalMete = this.getTotalMete();
      Object other$totalMete = other.getTotalMete();
      if (this$totalMete == null ? other$totalMete == null : this$totalMete.equals(other$totalMete)) {
         Object this$lastYearTotalMete = this.getLastYearTotalMete();
         Object other$lastYearTotalMete = other.getLastYearTotalMete();
         if (this$lastYearTotalMete == null ? other$lastYearTotalMete == null : this$lastYearTotalMete.equals(other$lastYearTotalMete)) {
            Object this$ratio = this.getRatio();
            Object other$ratio = other.getRatio();
            return this$ratio == null ? other$ratio == null : this$ratio.equals(other$ratio);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductionSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalMete = this.getTotalMete();
      result = result * 59 + ($totalMete == null ? 43 : $totalMete.hashCode());
      Object $lastYearTotalMete = this.getLastYearTotalMete();
      result = result * 59 + ($lastYearTotalMete == null ? 43 : $lastYearTotalMete.hashCode());
      Object $ratio = this.getRatio();
      return result * 59 + ($ratio == null ? 43 : $ratio.hashCode());
   }

   @Override
   public String toString() {
      return "ProductionSummaryDTO(totalMete="
         + this.getTotalMete()
         + ", lastYearTotalMete="
         + this.getLastYearTotalMete()
         + ", ratio="
         + this.getRatio()
         + ")";
   }

   public ProductionSummaryDTO(final BigDecimal totalMete, final BigDecimal lastYearTotalMete, final BigDecimal ratio) {
      this.totalMete = totalMete;
      this.lastYearTotalMete = lastYearTotalMete;
      this.ratio = ratio;
   }

   public ProductionSummaryDTO() {
   }

   public static class ProductionSummaryDTOBuilder {
      private BigDecimal totalMete;
      private BigDecimal lastYearTotalMete;
      private BigDecimal ratio;

      ProductionSummaryDTOBuilder() {
      }

      @JsonProperty("totalMete")
      public ProductionSummaryDTO.ProductionSummaryDTOBuilder totalMete(final BigDecimal totalMete) {
         this.totalMete = totalMete;
         return this;
      }

      @JsonProperty("lastYearTotalMete")
      public ProductionSummaryDTO.ProductionSummaryDTOBuilder lastYearTotalMete(final BigDecimal lastYearTotalMete) {
         this.lastYearTotalMete = lastYearTotalMete;
         return this;
      }

      @JsonProperty("ratio")
      public ProductionSummaryDTO.ProductionSummaryDTOBuilder ratio(final BigDecimal ratio) {
         this.ratio = ratio;
         return this;
      }

      public ProductionSummaryDTO build() {
         return new ProductionSummaryDTO(this.totalMete, this.lastYearTotalMete, this.ratio);
      }

      @Override
      public String toString() {
         return "ProductionSummaryDTO.ProductionSummaryDTOBuilder(totalMete="
            + this.totalMete
            + ", lastYearTotalMete="
            + this.lastYearTotalMete
            + ", ratio="
            + this.ratio
            + ")";
      }
   }
}
