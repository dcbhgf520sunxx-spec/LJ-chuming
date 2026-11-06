package com.hzchum.scim.mes.building.core.api.pojo._do.kpi;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ProductionLineCompleteYieldKpiDO", description = "每月产量kpi")
public class ProductionLineCompleteYieldKpiDO {
   @ApiModelProperty(name = "id", notes = "主键ID", value = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "yield", notes = "产量", value = "产量")
   @JsonProperty("yield")
   @JSONField(name = "yield")
   private BigDecimal yield;

   public static ProductionLineCompleteYieldKpiDO.ProductionLineCompleteYieldKpiDOBuilder builder() {
      return new ProductionLineCompleteYieldKpiDO.ProductionLineCompleteYieldKpiDOBuilder();
   }

   public ProductionLineCompleteYieldKpiDO(final Long id, final BigDecimal yield) {
      this.id = id;
      this.yield = yield;
   }

   public ProductionLineCompleteYieldKpiDO() {
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getYield() {
      return this.yield;
   }

   @JsonProperty("id")
   public ProductionLineCompleteYieldKpiDO setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("yield")
   public ProductionLineCompleteYieldKpiDO setYield(final BigDecimal yield) {
      this.yield = yield;
      return this;
   }

   @Override
   public String toString() {
      return "ProductionLineCompleteYieldKpiDO(id=" + this.getId() + ", yield=" + this.getYield() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProductionLineCompleteYieldKpiDO)) {
         return false;
      } else {
         ProductionLineCompleteYieldKpiDO other = (ProductionLineCompleteYieldKpiDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
      return other instanceof ProductionLineCompleteYieldKpiDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $yield = this.getYield();
      return result * 59 + ($yield == null ? 43 : $yield.hashCode());
   }

   public static class ProductionLineCompleteYieldKpiDOBuilder {
      private Long id;
      private BigDecimal yield;

      ProductionLineCompleteYieldKpiDOBuilder() {
      }

      @JsonProperty("id")
      public ProductionLineCompleteYieldKpiDO.ProductionLineCompleteYieldKpiDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("yield")
      public ProductionLineCompleteYieldKpiDO.ProductionLineCompleteYieldKpiDOBuilder yield(final BigDecimal yield) {
         this.yield = yield;
         return this;
      }

      public ProductionLineCompleteYieldKpiDO build() {
         return new ProductionLineCompleteYieldKpiDO(this.id, this.yield);
      }

      @Override
      public String toString() {
         return "ProductionLineCompleteYieldKpiDO.ProductionLineCompleteYieldKpiDOBuilder(id=" + this.id + ", yield=" + this.yield + ")";
      }
   }
}
