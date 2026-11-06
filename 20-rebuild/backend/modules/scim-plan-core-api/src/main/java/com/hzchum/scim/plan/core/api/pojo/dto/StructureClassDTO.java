package com.hzchum.scim.plan.core.api.pojo.dto;

import java.math.BigDecimal;

public class StructureClassDTO {
   private Long id;
   private String name;
   private Integer quantity;
   private BigDecimal mete;

   StructureClassDTO(final Long id, final String name, final Integer quantity, final BigDecimal mete) {
      this.id = id;
      this.name = name;
      this.quantity = quantity;
      this.mete = mete;
   }

   public static StructureClassDTO.StructureClassDTOBuilder builder() {
      return new StructureClassDTO.StructureClassDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StructureClassDTO)) {
         return false;
      }

      StructureClassDTO other = (StructureClassDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
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
      return other instanceof StructureClassDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "StructureClassDTO(id=" + this.getId() + ", name=" + this.getName() + ", quantity=" + this.getQuantity() + ", mete=" + this.getMete() + ")";
   }

   public static class StructureClassDTOBuilder {
      private Long id;
      private String name;
      private Integer quantity;
      private BigDecimal mete;

      StructureClassDTOBuilder() {
      }

      public StructureClassDTO.StructureClassDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public StructureClassDTO.StructureClassDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public StructureClassDTO.StructureClassDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public StructureClassDTO.StructureClassDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public StructureClassDTO build() {
         return new StructureClassDTO(this.id, this.name, this.quantity, this.mete);
      }

      @Override
      public String toString() {
         return "StructureClassDTO.StructureClassDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", quantity="
            + this.quantity
            + ", mete="
            + this.mete
            + ")";
      }
   }
}
