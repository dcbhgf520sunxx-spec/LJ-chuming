package com.hzchum.scim.mes.building.core.api.pojo._do.kpi;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "CarModleKpiDTO", description = "车型使用量")
public class CarModleKpiDO {
   @ApiModelProperty(name = "model", notes = "车型", value = "车型")
   @JsonProperty("model")
   @JSONField(name = "model")
   private String model;
   @ApiModelProperty(name = "quantity", notes = "车次量", value = "车次量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;

   public static CarModleKpiDO.CarModleKpiDOBuilder builder() {
      return new CarModleKpiDO.CarModleKpiDOBuilder();
   }

   public CarModleKpiDO(final String model, final Integer quantity) {
      this.model = model;
      this.quantity = quantity;
   }

   public CarModleKpiDO() {
   }

   public String getModel() {
      return this.model;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("model")
   public CarModleKpiDO setModel(final String model) {
      this.model = model;
      return this;
   }

   @JsonProperty("quantity")
   public CarModleKpiDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "CarModleKpiDO(model=" + this.getModel() + ", quantity=" + this.getQuantity() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CarModleKpiDO)) {
         return false;
      } else {
         CarModleKpiDO other = (CarModleKpiDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$model = this.getModel();
               Object other$model = other.getModel();
               return this$model == null ? other$model == null : this$model.equals(other$model);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CarModleKpiDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $model = this.getModel();
      return result * 59 + ($model == null ? 43 : $model.hashCode());
   }

   public static class CarModleKpiDOBuilder {
      private String model;
      private Integer quantity;

      CarModleKpiDOBuilder() {
      }

      @JsonProperty("model")
      public CarModleKpiDO.CarModleKpiDOBuilder model(final String model) {
         this.model = model;
         return this;
      }

      @JsonProperty("quantity")
      public CarModleKpiDO.CarModleKpiDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public CarModleKpiDO build() {
         return new CarModleKpiDO(this.model, this.quantity);
      }

      @Override
      public String toString() {
         return "CarModleKpiDO.CarModleKpiDOBuilder(model=" + this.model + ", quantity=" + this.quantity + ")";
      }
   }
}
