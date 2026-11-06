package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductionAnalysisDetailsDO", description = "产量分析")
public class ProductionAnalysisDetailsDO {
   @ApiModelProperty(name = "month", value = "时间", notes = "时间")
   @JsonProperty("month")
   @JSONField(name = "month")
   private String month;
   @ApiModelProperty(name = "production", value = "产量", notes = "产量")
   @JsonProperty("production")
   @JSONField(name = "production")
   private BigDecimal production;

   public static ProductionAnalysisDetailsDO.ProductionAnalysisDetailsDOBuilder builder() {
      return new ProductionAnalysisDetailsDO.ProductionAnalysisDetailsDOBuilder();
   }

   public ProductionAnalysisDetailsDO(final String month, final BigDecimal production) {
      this.month = month;
      this.production = production;
   }

   public ProductionAnalysisDetailsDO() {
   }

   public String getMonth() {
      return this.month;
   }

   public BigDecimal getProduction() {
      return this.production;
   }

   @JsonProperty("month")
   public ProductionAnalysisDetailsDO setMonth(final String month) {
      this.month = month;
      return this;
   }

   @JsonProperty("production")
   public ProductionAnalysisDetailsDO setProduction(final BigDecimal production) {
      this.production = production;
      return this;
   }

   @Override
   public String toString() {
      return "ProductionAnalysisDetailsDO(month=" + this.getMonth() + ", production=" + this.getProduction() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProductionAnalysisDetailsDO)) {
         return false;
      } else {
         ProductionAnalysisDetailsDO other = (ProductionAnalysisDetailsDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$month = this.getMonth();
            Object other$month = other.getMonth();
            if (this$month == null ? other$month == null : this$month.equals(other$month)) {
               Object this$production = this.getProduction();
               Object other$production = other.getProduction();
               return this$production == null ? other$production == null : this$production.equals(other$production);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductionAnalysisDetailsDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $production = this.getProduction();
      return result * 59 + ($production == null ? 43 : $production.hashCode());
   }

   public static class ProductionAnalysisDetailsDOBuilder {
      private String month;
      private BigDecimal production;

      ProductionAnalysisDetailsDOBuilder() {
      }

      @JsonProperty("month")
      public ProductionAnalysisDetailsDO.ProductionAnalysisDetailsDOBuilder month(final String month) {
         this.month = month;
         return this;
      }

      @JsonProperty("production")
      public ProductionAnalysisDetailsDO.ProductionAnalysisDetailsDOBuilder production(final BigDecimal production) {
         this.production = production;
         return this;
      }

      public ProductionAnalysisDetailsDO build() {
         return new ProductionAnalysisDetailsDO(this.month, this.production);
      }

      @Override
      public String toString() {
         return "ProductionAnalysisDetailsDO.ProductionAnalysisDetailsDOBuilder(month=" + this.month + ", production=" + this.production + ")";
      }
   }
}
