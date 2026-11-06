package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "SteelSpecTaskDO", description = "零件板厚规格")
public class SteelSpecTaskDO {
   @ApiModelProperty(name = "steelSpec", notes = "板厚/规格")
   @JsonProperty("steelSpec")
   @JSONField(name = "steelSpec")
   private String steelSpec;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;

   public static SteelSpecTaskDO.SteelSpecTaskDOBuilder builder() {
      return new SteelSpecTaskDO.SteelSpecTaskDOBuilder();
   }

   public String getSteelSpec() {
      return this.steelSpec;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("steelSpec")
   public SteelSpecTaskDO setSteelSpec(final String steelSpec) {
      this.steelSpec = steelSpec;
      return this;
   }

   @JsonProperty("quantity")
   public SteelSpecTaskDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SteelSpecTaskDO)) {
         return false;
      } else {
         SteelSpecTaskDO other = (SteelSpecTaskDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$steelSpec = this.getSteelSpec();
               Object other$steelSpec = other.getSteelSpec();
               return this$steelSpec == null ? other$steelSpec == null : this$steelSpec.equals(other$steelSpec);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SteelSpecTaskDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $steelSpec = this.getSteelSpec();
      return result * 59 + ($steelSpec == null ? 43 : $steelSpec.hashCode());
   }

   @Override
   public String toString() {
      return "SteelSpecTaskDO(steelSpec=" + this.getSteelSpec() + ", quantity=" + this.getQuantity() + ")";
   }

   public SteelSpecTaskDO(final String steelSpec, final Integer quantity) {
      this.steelSpec = steelSpec;
      this.quantity = quantity;
   }

   public SteelSpecTaskDO() {
   }

   public static class SteelSpecTaskDOBuilder {
      private String steelSpec;
      private Integer quantity;

      SteelSpecTaskDOBuilder() {
      }

      @JsonProperty("steelSpec")
      public SteelSpecTaskDO.SteelSpecTaskDOBuilder steelSpec(final String steelSpec) {
         this.steelSpec = steelSpec;
         return this;
      }

      @JsonProperty("quantity")
      public SteelSpecTaskDO.SteelSpecTaskDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public SteelSpecTaskDO build() {
         return new SteelSpecTaskDO(this.steelSpec, this.quantity);
      }

      @Override
      public String toString() {
         return "SteelSpecTaskDO.SteelSpecTaskDOBuilder(steelSpec=" + this.steelSpec + ", quantity=" + this.quantity + ")";
      }
   }
}
