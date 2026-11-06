package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "GroupDetailDTO", description = "切割分类")
public class CutSubTypeDTO {
   private Long id;
   private String name;

   public static CutSubTypeDTO.CutSubTypeDTOBuilder builder() {
      return new CutSubTypeDTO.CutSubTypeDTOBuilder();
   }

   public CutSubTypeDTO() {
   }

   public CutSubTypeDTO(final Long id, final String name) {
      this.id = id;
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public CutSubTypeDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CutSubTypeDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "CutSubTypeDTO(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof CutSubTypeDTO)) {
         return false;
      } else {
         CutSubTypeDTO other = (CutSubTypeDTO)o;
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
      return other instanceof CutSubTypeDTO;
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

   public static class CutSubTypeDTOBuilder {
      private Long id;
      private String name;

      CutSubTypeDTOBuilder() {
      }

      public CutSubTypeDTO.CutSubTypeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CutSubTypeDTO.CutSubTypeDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public CutSubTypeDTO build() {
         return new CutSubTypeDTO(this.id, this.name);
      }

      @Override
      public String toString() {
         return "CutSubTypeDTO.CutSubTypeDTOBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
