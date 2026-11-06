package com.hzchum.scim.mes.building.core.api.pojo._do.kpi;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductionCompleteYieldKpiDO", description = "每月产量kpi")
public class ProductionCompleteYieldKpiDO {
   @ApiModelProperty(name = "month", value = "月份", notes = "月份")
   @JsonProperty("month")
   @JSONField(name = "month")
   private String month;
   @ApiModelProperty(name = "yield", value = "产量", notes = "产量")
   @JsonProperty("yield")
   @JSONField(name = "yield")
   private BigDecimal yield;

   public static ProductionCompleteYieldKpiDO.ProductionCompleteYieldKpiDOBuilder builder() {
      return new ProductionCompleteYieldKpiDO.ProductionCompleteYieldKpiDOBuilder();
   }

   public ProductionCompleteYieldKpiDO(final String month, final BigDecimal yield) {
      this.month = month;
      this.yield = yield;
   }

   public ProductionCompleteYieldKpiDO() {
   }

   public String getMonth() {
      return this.month;
   }

   public BigDecimal getYield() {
      return this.yield;
   }

   @JsonProperty("month")
   public ProductionCompleteYieldKpiDO setMonth(final String month) {
      this.month = month;
      return this;
   }

   @JsonProperty("yield")
   public ProductionCompleteYieldKpiDO setYield(final BigDecimal yield) {
      this.yield = yield;
      return this;
   }

   @Override
   public String toString() {
      return "ProductionCompleteYieldKpiDO(month=" + this.getMonth() + ", yield=" + this.getYield() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProductionCompleteYieldKpiDO)) {
         return false;
      } else {
         ProductionCompleteYieldKpiDO other = (ProductionCompleteYieldKpiDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$month = this.getMonth();
            Object other$month = other.getMonth();
            if (this$month == null ? other$month == null : this$month.equals(other$month)) {
               Object this$yield = this.getYield();
               Object other$yield = other.getYield();
               return this$yield == null ? other$yield == null : this$yield.equals(other$yield);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductionCompleteYieldKpiDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $yield = this.getYield();
      return result * 59 + ($yield == null ? 43 : $yield.hashCode());
   }

   public static class ProductionCompleteYieldKpiDOBuilder {
      private String month;
      private BigDecimal yield;

      ProductionCompleteYieldKpiDOBuilder() {
      }

      @JsonProperty("month")
      public ProductionCompleteYieldKpiDO.ProductionCompleteYieldKpiDOBuilder month(final String month) {
         this.month = month;
         return this;
      }

      @JsonProperty("yield")
      public ProductionCompleteYieldKpiDO.ProductionCompleteYieldKpiDOBuilder yield(final BigDecimal yield) {
         this.yield = yield;
         return this;
      }

      public ProductionCompleteYieldKpiDO build() {
         return new ProductionCompleteYieldKpiDO(this.month, this.yield);
      }

      @Override
      public String toString() {
         return "ProductionCompleteYieldKpiDO.ProductionCompleteYieldKpiDOBuilder(month=" + this.month + ", yield=" + this.yield + ")";
      }
   }
}
