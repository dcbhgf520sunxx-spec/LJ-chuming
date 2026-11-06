package com.hzchum.scim.mes.building.core.api.pojo._doParam.record;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class WareSubscribePrintDTO {
   @ApiModelProperty("库存Id")
   private Long warehouseId;
   @ApiModelProperty("打印数量")
   private BigDecimal quantity;

   public static WareSubscribePrintDTO.WareSubscribePrintDTOBuilder builder() {
      return new WareSubscribePrintDTO.WareSubscribePrintDTOBuilder();
   }

   public WareSubscribePrintDTO(final Long warehouseId, final BigDecimal quantity) {
      this.warehouseId = warehouseId;
      this.quantity = quantity;
   }

   public WareSubscribePrintDTO() {
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof WareSubscribePrintDTO)) {
         return false;
      } else {
         WareSubscribePrintDTO other = (WareSubscribePrintDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$warehouseId = this.getWarehouseId();
            Object other$warehouseId = other.getWarehouseId();
            if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
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
      return other instanceof WareSubscribePrintDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "WareSubscribePrintDTO(warehouseId=" + this.getWarehouseId() + ", quantity=" + this.getQuantity() + ")";
   }

   public static class WareSubscribePrintDTOBuilder {
      private Long warehouseId;
      private BigDecimal quantity;

      WareSubscribePrintDTOBuilder() {
      }

      public WareSubscribePrintDTO.WareSubscribePrintDTOBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public WareSubscribePrintDTO.WareSubscribePrintDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public WareSubscribePrintDTO build() {
         return new WareSubscribePrintDTO(this.warehouseId, this.quantity);
      }

      @Override
      public String toString() {
         return "WareSubscribePrintDTO.WareSubscribePrintDTOBuilder(warehouseId=" + this.warehouseId + ", quantity=" + this.quantity + ")";
      }
   }
}
