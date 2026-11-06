package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;

public class MaterialDTOParam {
   private Long materialId;
   private BigDecimal quantity;

   public static MaterialDTOParam.MaterialDTOParamBuilder builder() {
      return new MaterialDTOParam.MaterialDTOParamBuilder();
   }

   public Long getMaterialId() {
      return this.materialId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public void setMaterialId(final Long materialId) {
      this.materialId = materialId;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MaterialDTOParam)) {
         return false;
      } else {
         MaterialDTOParam other = (MaterialDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$materialId = this.getMaterialId();
            Object other$materialId = other.getMaterialId();
            if (this$materialId == null ? other$materialId == null : this$materialId.equals(other$materialId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MaterialDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $materialId = this.getMaterialId();
      result = result * 59 + ($materialId == null ? 43 : $materialId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "MaterialDTOParam(materialId=" + this.getMaterialId() + ", quantity=" + this.getQuantity() + ")";
   }

   public MaterialDTOParam(final Long materialId, final BigDecimal quantity) {
      this.materialId = materialId;
      this.quantity = quantity;
   }

   public MaterialDTOParam() {
   }

   public static class MaterialDTOParamBuilder {
      private Long materialId;
      private BigDecimal quantity;

      MaterialDTOParamBuilder() {
      }

      public MaterialDTOParam.MaterialDTOParamBuilder materialId(final Long materialId) {
         this.materialId = materialId;
         return this;
      }

      public MaterialDTOParam.MaterialDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public MaterialDTOParam build() {
         return new MaterialDTOParam(this.materialId, this.quantity);
      }

      @Override
      public String toString() {
         return "MaterialDTOParam.MaterialDTOParamBuilder(materialId=" + this.materialId + ", quantity=" + this.quantity + ")";
      }
   }
}
