package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class SubscribeProductWarehouseDTO {
   @ApiModelProperty(name = "id", notes = "产品Id")
   private Long id;
   @ApiModelProperty(name = "quantity", notes = "入库数量")
   private Integer quantity;
   @ApiModelProperty(name = "materialInventoryId", notes = "库存Id")
   private Long materialInventoryId;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型", notes = "物料基础类型")
   private Integer basicClass;

   public static SubscribeProductWarehouseDTO.SubscribeProductWarehouseDTOBuilder builder() {
      return new SubscribeProductWarehouseDTO.SubscribeProductWarehouseDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubscribeProductWarehouseDTO)) {
         return false;
      }

      SubscribeProductWarehouseDTO other = (SubscribeProductWarehouseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$materialInventoryId = this.getMaterialInventoryId();
            Object other$materialInventoryId = other.getMaterialInventoryId();
            if (this$materialInventoryId == null ? other$materialInventoryId == null : this$materialInventoryId.equals(other$materialInventoryId)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               return this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass);
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SubscribeProductWarehouseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $basicClass = this.getBasicClass();
      return result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
   }

   @Override
   public String toString() {
      return "SubscribeProductWarehouseDTO(id="
         + this.getId()
         + ", quantity="
         + this.getQuantity()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", basicClass="
         + this.getBasicClass()
         + ")";
   }

   public SubscribeProductWarehouseDTO(final Long id, final Integer quantity, final Long materialInventoryId, final Integer basicClass) {
      this.id = id;
      this.quantity = quantity;
      this.materialInventoryId = materialInventoryId;
      this.basicClass = basicClass;
   }

   public SubscribeProductWarehouseDTO() {
   }

   public static class SubscribeProductWarehouseDTOBuilder {
      private Long id;
      private Integer quantity;
      private Long materialInventoryId;
      private Integer basicClass;

      SubscribeProductWarehouseDTOBuilder() {
      }

      public SubscribeProductWarehouseDTO.SubscribeProductWarehouseDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SubscribeProductWarehouseDTO.SubscribeProductWarehouseDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public SubscribeProductWarehouseDTO.SubscribeProductWarehouseDTOBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      public SubscribeProductWarehouseDTO.SubscribeProductWarehouseDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public SubscribeProductWarehouseDTO build() {
         return new SubscribeProductWarehouseDTO(this.id, this.quantity, this.materialInventoryId, this.basicClass);
      }

      @Override
      public String toString() {
         return "SubscribeProductWarehouseDTO.SubscribeProductWarehouseDTOBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", basicClass="
            + this.basicClass
            + ")";
      }
   }
}
