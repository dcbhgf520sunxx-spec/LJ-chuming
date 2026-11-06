package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.kpi;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductionCompleteYieldKpiDO", description = "每月产量kpi")
public class ProductionCompleteYieldKpiDTO {
   @ApiModelProperty(name = "month", value = "月份", notes = "月份")
   @JsonProperty("month")
   @JSONField(name = "month")
   private String month;
   @ApiModelProperty(name = "yield", value = "产量", notes = "产量")
   @JsonProperty("yield")
   @JSONField(name = "yield")
   private BigDecimal yield;

   public static ProductionCompleteYieldKpiDTO.ProductionCompleteYieldKpiDTOBuilder builder() {
      return new ProductionCompleteYieldKpiDTO.ProductionCompleteYieldKpiDTOBuilder();
   }

   public ProductionCompleteYieldKpiDTO(final String month, final BigDecimal yield) {
      this.month = month;
      this.yield = yield;
   }

   public ProductionCompleteYieldKpiDTO() {
   }

   public String getMonth() {
      return this.month;
   }

   public BigDecimal getYield() {
      return this.yield;
   }

   @JsonProperty("month")
   public ProductionCompleteYieldKpiDTO setMonth(final String month) {
      this.month = month;
      return this;
   }

   @JsonProperty("yield")
   public ProductionCompleteYieldKpiDTO setYield(final BigDecimal yield) {
      this.yield = yield;
      return this;
   }

   @Override
   public String toString() {
      return "ProductionCompleteYieldKpiDTO(month=" + this.getMonth() + ", yield=" + this.getYield() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProductionCompleteYieldKpiDTO)) {
         return false;
      } else {
         ProductionCompleteYieldKpiDTO other = (ProductionCompleteYieldKpiDTO)o;
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
      return other instanceof ProductionCompleteYieldKpiDTO;
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

   public static class ProductionCompleteYieldKpiDTOBuilder {
      private String month;
      private BigDecimal yield;

      ProductionCompleteYieldKpiDTOBuilder() {
      }

      @JsonProperty("month")
      public ProductionCompleteYieldKpiDTO.ProductionCompleteYieldKpiDTOBuilder month(final String month) {
         this.month = month;
         return this;
      }

      @JsonProperty("yield")
      public ProductionCompleteYieldKpiDTO.ProductionCompleteYieldKpiDTOBuilder yield(final BigDecimal yield) {
         this.yield = yield;
         return this;
      }

      public ProductionCompleteYieldKpiDTO build() {
         return new ProductionCompleteYieldKpiDTO(this.month, this.yield);
      }

      @Override
      public String toString() {
         return "ProductionCompleteYieldKpiDTO.ProductionCompleteYieldKpiDTOBuilder(month=" + this.month + ", yield=" + this.yield + ")";
      }
   }
}
