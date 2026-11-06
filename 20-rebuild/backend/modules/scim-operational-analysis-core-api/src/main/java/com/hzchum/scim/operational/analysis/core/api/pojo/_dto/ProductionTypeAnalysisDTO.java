package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProdcutionTypeDTO", description = "生产品占比")
public class ProductionTypeAnalysisDTO {
   @ApiModelProperty(name = "typeName", value = "年份", notes = "年份")
   @JsonProperty("typeName")
   @JSONField(name = "typeName")
   private String typeName;
   @ApiModelProperty(name = "yield", value = "产量（kg|mm）", notes = "产量（kg|mm）")
   @JsonProperty("yield")
   @JSONField(name = "yield")
   private BigDecimal yield;
   @ApiModelProperty(name = "ratio", value = "占比（%）", notes = "占比（%）")
   @JsonProperty("ratio")
   @JSONField(name = "ratio")
   private BigDecimal ratio;

   public static ProductionTypeAnalysisDTO.ProductionTypeAnalysisDTOBuilder builder() {
      return new ProductionTypeAnalysisDTO.ProductionTypeAnalysisDTOBuilder();
   }

   public ProductionTypeAnalysisDTO(final String typeName, final BigDecimal yield, final BigDecimal ratio) {
      this.typeName = typeName;
      this.yield = yield;
      this.ratio = ratio;
   }

   public ProductionTypeAnalysisDTO() {
   }

   public String getTypeName() {
      return this.typeName;
   }

   public BigDecimal getYield() {
      return this.yield;
   }

   public BigDecimal getRatio() {
      return this.ratio;
   }

   @JsonProperty("typeName")
   public ProductionTypeAnalysisDTO setTypeName(final String typeName) {
      this.typeName = typeName;
      return this;
   }

   @JsonProperty("yield")
   public ProductionTypeAnalysisDTO setYield(final BigDecimal yield) {
      this.yield = yield;
      return this;
   }

   @JsonProperty("ratio")
   public ProductionTypeAnalysisDTO setRatio(final BigDecimal ratio) {
      this.ratio = ratio;
      return this;
   }

   @Override
   public String toString() {
      return "ProductionTypeAnalysisDTO(typeName=" + this.getTypeName() + ", yield=" + this.getYield() + ", ratio=" + this.getRatio() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionTypeAnalysisDTO)) {
         return false;
      }

      ProductionTypeAnalysisDTO other = (ProductionTypeAnalysisDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$typeName = this.getTypeName();
      Object other$typeName = other.getTypeName();
      if (this$typeName == null ? other$typeName == null : this$typeName.equals(other$typeName)) {
         Object this$yield = this.getYield();
         Object other$yield = other.getYield();
         if (this$yield == null ? other$yield == null : this$yield.equals(other$yield)) {
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
      return other instanceof ProductionTypeAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $yield = this.getYield();
      result = result * 59 + ($yield == null ? 43 : $yield.hashCode());
      Object $ratio = this.getRatio();
      return result * 59 + ($ratio == null ? 43 : $ratio.hashCode());
   }

   public static class ProductionTypeAnalysisDTOBuilder {
      private String typeName;
      private BigDecimal yield;
      private BigDecimal ratio;

      ProductionTypeAnalysisDTOBuilder() {
      }

      @JsonProperty("typeName")
      public ProductionTypeAnalysisDTO.ProductionTypeAnalysisDTOBuilder typeName(final String typeName) {
         this.typeName = typeName;
         return this;
      }

      @JsonProperty("yield")
      public ProductionTypeAnalysisDTO.ProductionTypeAnalysisDTOBuilder yield(final BigDecimal yield) {
         this.yield = yield;
         return this;
      }

      @JsonProperty("ratio")
      public ProductionTypeAnalysisDTO.ProductionTypeAnalysisDTOBuilder ratio(final BigDecimal ratio) {
         this.ratio = ratio;
         return this;
      }

      public ProductionTypeAnalysisDTO build() {
         return new ProductionTypeAnalysisDTO(this.typeName, this.yield, this.ratio);
      }

      @Override
      public String toString() {
         return "ProductionTypeAnalysisDTO.ProductionTypeAnalysisDTOBuilder(typeName="
            + this.typeName
            + ", yield="
            + this.yield
            + ", ratio="
            + this.ratio
            + ")";
      }
   }
}
