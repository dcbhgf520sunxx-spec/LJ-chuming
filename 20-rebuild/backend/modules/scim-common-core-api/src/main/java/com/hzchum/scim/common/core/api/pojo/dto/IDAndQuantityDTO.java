package com.hzchum.scim.common.core.api.pojo.dto;

public class IDAndQuantityDTO {
   private Long id;
   private Integer quantity;

   public static IDAndQuantityDTO.IDAndQuantityDTOBuilder builder() {
      return new IDAndQuantityDTO.IDAndQuantityDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof IDAndQuantityDTO)) {
         return false;
      } else {
         IDAndQuantityDTO other = (IDAndQuantityDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
      return other instanceof IDAndQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "IDAndQuantityDTO(id=" + this.getId() + ", quantity=" + this.getQuantity() + ")";
   }

   public IDAndQuantityDTO(final Long id, final Integer quantity) {
      this.id = id;
      this.quantity = quantity;
   }

   public IDAndQuantityDTO() {
   }

   public static class IDAndQuantityDTOBuilder {
      private Long id;
      private Integer quantity;

      IDAndQuantityDTOBuilder() {
      }

      public IDAndQuantityDTO.IDAndQuantityDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public IDAndQuantityDTO.IDAndQuantityDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public IDAndQuantityDTO build() {
         return new IDAndQuantityDTO(this.id, this.quantity);
      }

      @Override
      public String toString() {
         return "IDAndQuantityDTO.IDAndQuantityDTOBuilder(id=" + this.id + ", quantity=" + this.quantity + ")";
      }
   }
}
