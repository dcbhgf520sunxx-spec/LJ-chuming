package com.hzchum.scim.wms.core.api.pojo.dto.wmsConfig;

public class StandardDTO {
   private Long id;
   private String name;
   private Boolean deletable;

   StandardDTO(final Long id, final String name, final Boolean deletable) {
      this.id = id;
      this.name = name;
      this.deletable = deletable;
   }

   public static StandardDTO.StandardDTOBuilder builder() {
      return new StandardDTO.StandardDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public Boolean getDeletable() {
      return this.deletable;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setDeletable(final Boolean deletable) {
      this.deletable = deletable;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof StandardDTO)) {
         return false;
      }

      StandardDTO other = (StandardDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$deletable = this.getDeletable();
         Object other$deletable = other.getDeletable();
         if (this$deletable == null ? other$deletable == null : this$deletable.equals(other$deletable)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof StandardDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $deletable = this.getDeletable();
      result = result * 59 + ($deletable == null ? 43 : $deletable.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   @Override
   public String toString() {
      return "StandardDTO(id=" + this.getId() + ", name=" + this.getName() + ", deletable=" + this.getDeletable() + ")";
   }

   public static class StandardDTOBuilder {
      private Long id;
      private String name;
      private Boolean deletable;

      StandardDTOBuilder() {
      }

      public StandardDTO.StandardDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public StandardDTO.StandardDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public StandardDTO.StandardDTOBuilder deletable(final Boolean deletable) {
         this.deletable = deletable;
         return this;
      }

      public StandardDTO build() {
         return new StandardDTO(this.id, this.name, this.deletable);
      }

      @Override
      public String toString() {
         return "StandardDTO.StandardDTOBuilder(id=" + this.id + ", name=" + this.name + ", deletable=" + this.deletable + ")";
      }
   }
}
