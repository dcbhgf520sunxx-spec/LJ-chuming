package com.hzchum.scim.scm.core.api.pojo.dto;

public class SimpleListDTO {
   private Long id;
   private String name;

   SimpleListDTO(final Long id, final String name) {
      this.id = id;
      this.name = name;
   }

   public static SimpleListDTO.SimpleListDTOBuilder builder() {
      return new SimpleListDTO.SimpleListDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SimpleListDTO)) {
         return false;
      } else {
         SimpleListDTO other = (SimpleListDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               return this$name == null ? other$name == null : this$name.equals(other$name);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SimpleListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "SimpleListDTO(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   public static class SimpleListDTOBuilder {
      private Long id;
      private String name;

      SimpleListDTOBuilder() {
      }

      public SimpleListDTO.SimpleListDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SimpleListDTO.SimpleListDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SimpleListDTO build() {
         return new SimpleListDTO(this.id, this.name);
      }

      @Override
      public String toString() {
         return "SimpleListDTO.SimpleListDTOBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
