package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.math.BigDecimal;

public class MoveMaterialDetailDTOParam {
   private Long materialId;
   private BigDecimal quantity;
   private String remark;

   public static MoveMaterialDetailDTOParam.MoveMaterialDetailDTOParamBuilder builder() {
      return new MoveMaterialDetailDTOParam.MoveMaterialDetailDTOParamBuilder();
   }

   public Long getMaterialId() {
      return this.materialId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setMaterialId(final Long materialId) {
      this.materialId = materialId;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MoveMaterialDetailDTOParam)) {
         return false;
      }

      MoveMaterialDetailDTOParam other = (MoveMaterialDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$materialId = this.getMaterialId();
      Object other$materialId = other.getMaterialId();
      if (this$materialId == null ? other$materialId == null : this$materialId.equals(other$materialId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$remark = this.getRemark();
            Object other$remark = other.getRemark();
            return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MoveMaterialDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $materialId = this.getMaterialId();
      result = result * 59 + ($materialId == null ? 43 : $materialId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "MoveMaterialDetailDTOParam(materialId=" + this.getMaterialId() + ", quantity=" + this.getQuantity() + ", remark=" + this.getRemark() + ")";
   }

   public MoveMaterialDetailDTOParam(final Long materialId, final BigDecimal quantity, final String remark) {
      this.materialId = materialId;
      this.quantity = quantity;
      this.remark = remark;
   }

   public MoveMaterialDetailDTOParam() {
   }

   public static class MoveMaterialDetailDTOParamBuilder {
      private Long materialId;
      private BigDecimal quantity;
      private String remark;

      MoveMaterialDetailDTOParamBuilder() {
      }

      public MoveMaterialDetailDTOParam.MoveMaterialDetailDTOParamBuilder materialId(final Long materialId) {
         this.materialId = materialId;
         return this;
      }

      public MoveMaterialDetailDTOParam.MoveMaterialDetailDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public MoveMaterialDetailDTOParam.MoveMaterialDetailDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public MoveMaterialDetailDTOParam build() {
         return new MoveMaterialDetailDTOParam(this.materialId, this.quantity, this.remark);
      }

      @Override
      public String toString() {
         return "MoveMaterialDetailDTOParam.MoveMaterialDetailDTOParamBuilder(materialId="
            + this.materialId
            + ", quantity="
            + this.quantity
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
