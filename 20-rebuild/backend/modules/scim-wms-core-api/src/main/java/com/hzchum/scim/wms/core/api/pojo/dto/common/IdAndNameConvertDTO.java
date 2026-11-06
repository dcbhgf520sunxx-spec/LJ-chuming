package com.hzchum.scim.wms.core.api.pojo.dto.common;

public class IdAndNameConvertDTO {
   private Long id;
   private String name;

   public static IdAndNameConvertDTO.IdAndNameConvertDTOBuilder builder() {
      return new IdAndNameConvertDTO.IdAndNameConvertDTOBuilder();
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
      } else if (!(o instanceof IdAndNameConvertDTO)) {
         return false;
      } else {
         IdAndNameConvertDTO other = (IdAndNameConvertDTO)o;
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
      return other instanceof IdAndNameConvertDTO;
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
      return "IdAndNameConvertDTO(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   public IdAndNameConvertDTO(final Long id, final String name) {
      this.id = id;
      this.name = name;
   }

   public IdAndNameConvertDTO() {
   }

   public static class IdAndNameConvertDTOBuilder {
      private Long id;
      private String name;

      IdAndNameConvertDTOBuilder() {
      }

      public IdAndNameConvertDTO.IdAndNameConvertDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public IdAndNameConvertDTO.IdAndNameConvertDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public IdAndNameConvertDTO build() {
         return new IdAndNameConvertDTO(this.id, this.name);
      }

      @Override
      public String toString() {
         return "IdAndNameConvertDTO.IdAndNameConvertDTOBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
