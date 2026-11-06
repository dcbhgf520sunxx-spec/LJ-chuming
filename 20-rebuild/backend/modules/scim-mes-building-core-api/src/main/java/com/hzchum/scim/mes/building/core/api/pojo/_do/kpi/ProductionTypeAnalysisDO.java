package com.hzchum.scim.mes.building.core.api.pojo._do.kpi;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductionTypeAnalysisDO", description = "项目生产信息")
public class ProductionTypeAnalysisDO {
   @ApiModelProperty(name = "typeName", value = "年份", notes = "年份")
   @JsonProperty("typeName")
   @JSONField(name = "typeName")
   private String typeName;
   @ApiModelProperty(name = "yield", value = "产量", notes = "产量")
   @JsonProperty("yield")
   @JSONField(name = "yield")
   private BigDecimal yield;
   @ApiModelProperty("构件分类 1主构件 2次构件")
   @JsonProperty("artifactType")
   @JSONField(name = "artifactType")
   private Integer artifactType;

   public static ProductionTypeAnalysisDO.ProductionTypeAnalysisDOBuilder builder() {
      return new ProductionTypeAnalysisDO.ProductionTypeAnalysisDOBuilder();
   }

   public ProductionTypeAnalysisDO(final String typeName, final BigDecimal yield, final Integer artifactType) {
      this.typeName = typeName;
      this.yield = yield;
      this.artifactType = artifactType;
   }

   public ProductionTypeAnalysisDO() {
   }

   public String getTypeName() {
      return this.typeName;
   }

   public BigDecimal getYield() {
      return this.yield;
   }

   public Integer getArtifactType() {
      return this.artifactType;
   }

   @JsonProperty("typeName")
   public ProductionTypeAnalysisDO setTypeName(final String typeName) {
      this.typeName = typeName;
      return this;
   }

   @JsonProperty("yield")
   public ProductionTypeAnalysisDO setYield(final BigDecimal yield) {
      this.yield = yield;
      return this;
   }

   @JsonProperty("artifactType")
   public ProductionTypeAnalysisDO setArtifactType(final Integer artifactType) {
      this.artifactType = artifactType;
      return this;
   }

   @Override
   public String toString() {
      return "ProductionTypeAnalysisDO(typeName=" + this.getTypeName() + ", yield=" + this.getYield() + ", artifactType=" + this.getArtifactType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionTypeAnalysisDO)) {
         return false;
      }

      ProductionTypeAnalysisDO other = (ProductionTypeAnalysisDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactType = this.getArtifactType();
      Object other$artifactType = other.getArtifactType();
      if (this$artifactType == null ? other$artifactType == null : this$artifactType.equals(other$artifactType)) {
         Object this$typeName = this.getTypeName();
         Object other$typeName = other.getTypeName();
         if (this$typeName == null ? other$typeName == null : this$typeName.equals(other$typeName)) {
            Object this$yield = this.getYield();
            Object other$yield = other.getYield();
            return this$yield == null ? other$yield == null : this$yield.equals(other$yield);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductionTypeAnalysisDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactType = this.getArtifactType();
      result = result * 59 + ($artifactType == null ? 43 : $artifactType.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $yield = this.getYield();
      return result * 59 + ($yield == null ? 43 : $yield.hashCode());
   }

   public static class ProductionTypeAnalysisDOBuilder {
      private String typeName;
      private BigDecimal yield;
      private Integer artifactType;

      ProductionTypeAnalysisDOBuilder() {
      }

      @JsonProperty("typeName")
      public ProductionTypeAnalysisDO.ProductionTypeAnalysisDOBuilder typeName(final String typeName) {
         this.typeName = typeName;
         return this;
      }

      @JsonProperty("yield")
      public ProductionTypeAnalysisDO.ProductionTypeAnalysisDOBuilder yield(final BigDecimal yield) {
         this.yield = yield;
         return this;
      }

      @JsonProperty("artifactType")
      public ProductionTypeAnalysisDO.ProductionTypeAnalysisDOBuilder artifactType(final Integer artifactType) {
         this.artifactType = artifactType;
         return this;
      }

      public ProductionTypeAnalysisDO build() {
         return new ProductionTypeAnalysisDO(this.typeName, this.yield, this.artifactType);
      }

      @Override
      public String toString() {
         return "ProductionTypeAnalysisDO.ProductionTypeAnalysisDOBuilder(typeName="
            + this.typeName
            + ", yield="
            + this.yield
            + ", artifactType="
            + this.artifactType
            + ")";
      }
   }
}
