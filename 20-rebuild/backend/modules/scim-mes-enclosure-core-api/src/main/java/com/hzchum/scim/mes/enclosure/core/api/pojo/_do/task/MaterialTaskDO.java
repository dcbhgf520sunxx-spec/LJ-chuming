package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MaterialTaskDO", description = "材质")
public class MaterialTaskDO {
   @ApiModelProperty(name = "material", notes = "材质")
   @JsonProperty("material")
   @JSONField(name = "material")
   private String material;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;

   public static MaterialTaskDO.MaterialTaskDOBuilder builder() {
      return new MaterialTaskDO.MaterialTaskDOBuilder();
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("material")
   public MaterialTaskDO setMaterial(final String material) {
      this.material = material;
      return this;
   }

   @JsonProperty("quantity")
   public MaterialTaskDO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MaterialTaskDO)) {
         return false;
      } else {
         MaterialTaskDO other = (MaterialTaskDO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$material = this.getMaterial();
               Object other$material = other.getMaterial();
               return this$material == null ? other$material == null : this$material.equals(other$material);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MaterialTaskDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialTaskDO(material=" + this.getMaterial() + ", quantity=" + this.getQuantity() + ")";
   }

   public MaterialTaskDO(final String material, final Integer quantity) {
      this.material = material;
      this.quantity = quantity;
   }

   public MaterialTaskDO() {
   }

   public static class MaterialTaskDOBuilder {
      private String material;
      private Integer quantity;

      MaterialTaskDOBuilder() {
      }

      @JsonProperty("material")
      public MaterialTaskDO.MaterialTaskDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      @JsonProperty("quantity")
      public MaterialTaskDO.MaterialTaskDOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MaterialTaskDO build() {
         return new MaterialTaskDO(this.material, this.quantity);
      }

      @Override
      public String toString() {
         return "MaterialTaskDO.MaterialTaskDOBuilder(material=" + this.material + ", quantity=" + this.quantity + ")";
      }
   }
}
