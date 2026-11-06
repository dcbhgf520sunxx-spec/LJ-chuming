package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "ProductProcessQuantityDTO", description = "")
public class ProductProcessQuantityDTO {
   private Long id;
   private Integer quantity;
   private Integer inspectionQuantity;

   public static ProductProcessQuantityDTO.ProductProcessQuantityDTOBuilder builder() {
      return new ProductProcessQuantityDTO.ProductProcessQuantityDTOBuilder();
   }

   public ProductProcessQuantityDTO() {
   }

   public ProductProcessQuantityDTO(final Long id, final Integer quantity, final Integer inspectionQuantity) {
      this.id = id;
      this.quantity = quantity;
      this.inspectionQuantity = inspectionQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public ProductProcessQuantityDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProductProcessQuantityDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public ProductProcessQuantityDTO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductProcessQuantityDTO)) {
         return false;
      }

      ProductProcessQuantityDTO other = (ProductProcessQuantityDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$inspectionQuantity = this.getInspectionQuantity();
            Object other$inspectionQuantity = other.getInspectionQuantity();
            return this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductProcessQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      return result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "ProductProcessQuantityDTO(id=" + this.getId() + ", quantity=" + this.getQuantity() + ", inspectionQuantity=" + this.getInspectionQuantity() + ")";
   }

   public static class ProductProcessQuantityDTOBuilder {
      private Long id;
      private Integer quantity;
      private Integer inspectionQuantity;

      ProductProcessQuantityDTOBuilder() {
      }

      public ProductProcessQuantityDTO.ProductProcessQuantityDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProductProcessQuantityDTO.ProductProcessQuantityDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProductProcessQuantityDTO.ProductProcessQuantityDTOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      public ProductProcessQuantityDTO build() {
         return new ProductProcessQuantityDTO(this.id, this.quantity, this.inspectionQuantity);
      }

      @Override
      public String toString() {
         return "ProductProcessQuantityDTO.ProductProcessQuantityDTOBuilder(id="
            + this.id
            + ", quantity="
            + this.quantity
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ")";
      }
   }
}
