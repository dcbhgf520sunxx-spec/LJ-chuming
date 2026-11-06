package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

public class ProductionLoadDTO {
   @ApiModelProperty(name = "targetSummary", value = "目标量", notes = "目标量")
   @JsonProperty("targetSummary")
   @JSONField(name = "targetSummary")
   private BigDecimal targetSummary;
   @ApiModelProperty(name = "completeSummary", value = "完成量", notes = "完成量")
   @JsonProperty("completeSummary")
   @JSONField(name = "completeSummary")
   private BigDecimal completeSummary;
   @ApiModelProperty(name = "avgLoadRatio", value = "平均负荷率", notes = "平均负荷率")
   @JsonProperty("avgLoadRatio")
   @JSONField(name = "avgLoadRatio")
   private BigDecimal avgLoadRatio;
   @ApiModelProperty(name = "details", value = "每月详情", notes = "每月详情")
   @JsonProperty("details")
   @JSONField(name = "details")
   private List<ProductionLoadDetailsDTO> details;

   public static ProductionLoadDTO.ProductionLoadDTOBuilder builder() {
      return new ProductionLoadDTO.ProductionLoadDTOBuilder();
   }

   public BigDecimal getTargetSummary() {
      return this.targetSummary;
   }

   public BigDecimal getCompleteSummary() {
      return this.completeSummary;
   }

   public BigDecimal getAvgLoadRatio() {
      return this.avgLoadRatio;
   }

   public List<ProductionLoadDetailsDTO> getDetails() {
      return this.details;
   }

   @JsonProperty("targetSummary")
   public void setTargetSummary(final BigDecimal targetSummary) {
      this.targetSummary = targetSummary;
   }

   @JsonProperty("completeSummary")
   public void setCompleteSummary(final BigDecimal completeSummary) {
      this.completeSummary = completeSummary;
   }

   @JsonProperty("avgLoadRatio")
   public void setAvgLoadRatio(final BigDecimal avgLoadRatio) {
      this.avgLoadRatio = avgLoadRatio;
   }

   @JsonProperty("details")
   public void setDetails(final List<ProductionLoadDetailsDTO> details) {
      this.details = details;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionLoadDTO)) {
         return false;
      }

      ProductionLoadDTO other = (ProductionLoadDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$targetSummary = this.getTargetSummary();
      Object other$targetSummary = other.getTargetSummary();
      if (this$targetSummary == null ? other$targetSummary == null : this$targetSummary.equals(other$targetSummary)) {
         Object this$completeSummary = this.getCompleteSummary();
         Object other$completeSummary = other.getCompleteSummary();
         if (this$completeSummary == null ? other$completeSummary == null : this$completeSummary.equals(other$completeSummary)) {
            Object this$avgLoadRatio = this.getAvgLoadRatio();
            Object other$avgLoadRatio = other.getAvgLoadRatio();
            if (this$avgLoadRatio == null ? other$avgLoadRatio == null : this$avgLoadRatio.equals(other$avgLoadRatio)) {
               Object this$details = this.getDetails();
               Object other$details = other.getDetails();
               return this$details == null ? other$details == null : this$details.equals(other$details);
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
      return other instanceof ProductionLoadDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $targetSummary = this.getTargetSummary();
      result = result * 59 + ($targetSummary == null ? 43 : $targetSummary.hashCode());
      Object $completeSummary = this.getCompleteSummary();
      result = result * 59 + ($completeSummary == null ? 43 : $completeSummary.hashCode());
      Object $avgLoadRatio = this.getAvgLoadRatio();
      result = result * 59 + ($avgLoadRatio == null ? 43 : $avgLoadRatio.hashCode());
      Object $details = this.getDetails();
      return result * 59 + ($details == null ? 43 : $details.hashCode());
   }

   @Override
   public String toString() {
      return "ProductionLoadDTO(targetSummary="
         + this.getTargetSummary()
         + ", completeSummary="
         + this.getCompleteSummary()
         + ", avgLoadRatio="
         + this.getAvgLoadRatio()
         + ", details="
         + this.getDetails()
         + ")";
   }

   public ProductionLoadDTO(
      final BigDecimal targetSummary, final BigDecimal completeSummary, final BigDecimal avgLoadRatio, final List<ProductionLoadDetailsDTO> details
   ) {
      this.targetSummary = targetSummary;
      this.completeSummary = completeSummary;
      this.avgLoadRatio = avgLoadRatio;
      this.details = details;
   }

   public ProductionLoadDTO() {
   }

   public static class ProductionLoadDTOBuilder {
      private BigDecimal targetSummary;
      private BigDecimal completeSummary;
      private BigDecimal avgLoadRatio;
      private List<ProductionLoadDetailsDTO> details;

      ProductionLoadDTOBuilder() {
      }

      @JsonProperty("targetSummary")
      public ProductionLoadDTO.ProductionLoadDTOBuilder targetSummary(final BigDecimal targetSummary) {
         this.targetSummary = targetSummary;
         return this;
      }

      @JsonProperty("completeSummary")
      public ProductionLoadDTO.ProductionLoadDTOBuilder completeSummary(final BigDecimal completeSummary) {
         this.completeSummary = completeSummary;
         return this;
      }

      @JsonProperty("avgLoadRatio")
      public ProductionLoadDTO.ProductionLoadDTOBuilder avgLoadRatio(final BigDecimal avgLoadRatio) {
         this.avgLoadRatio = avgLoadRatio;
         return this;
      }

      @JsonProperty("details")
      public ProductionLoadDTO.ProductionLoadDTOBuilder details(final List<ProductionLoadDetailsDTO> details) {
         this.details = details;
         return this;
      }

      public ProductionLoadDTO build() {
         return new ProductionLoadDTO(this.targetSummary, this.completeSummary, this.avgLoadRatio, this.details);
      }

      @Override
      public String toString() {
         return "ProductionLoadDTO.ProductionLoadDTOBuilder(targetSummary="
            + this.targetSummary
            + ", completeSummary="
            + this.completeSummary
            + ", avgLoadRatio="
            + this.avgLoadRatio
            + ", details="
            + this.details
            + ")";
      }
   }
}
