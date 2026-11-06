package com.hzchum.scim.scm.core.api.pojo.dto;

import java.util.List;

public class MonomerDTO {
   private Long id;
   private String name;
   private List<AreaDTO> areas;

   public static MonomerDTO.MonomerDTOBuilder builder() {
      return new MonomerDTO.MonomerDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public List<AreaDTO> getAreas() {
      return this.areas;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setAreas(final List<AreaDTO> areas) {
      this.areas = areas;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonomerDTO)) {
         return false;
      }

      MonomerDTO other = (MonomerDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$areas = this.getAreas();
            Object other$areas = other.getAreas();
            return this$areas == null ? other$areas == null : this$areas.equals(other$areas);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MonomerDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $areas = this.getAreas();
      return result * 59 + ($areas == null ? 43 : $areas.hashCode());
   }

   @Override
   public String toString() {
      return "MonomerDTO(id=" + this.getId() + ", name=" + this.getName() + ", areas=" + this.getAreas() + ")";
   }

   public MonomerDTO(final Long id, final String name, final List<AreaDTO> areas) {
      this.id = id;
      this.name = name;
      this.areas = areas;
   }

   public MonomerDTO() {
   }

   public static class MonomerDTOBuilder {
      private Long id;
      private String name;
      private List<AreaDTO> areas;

      MonomerDTOBuilder() {
      }

      public MonomerDTO.MonomerDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MonomerDTO.MonomerDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MonomerDTO.MonomerDTOBuilder areas(final List<AreaDTO> areas) {
         this.areas = areas;
         return this;
      }

      public MonomerDTO build() {
         return new MonomerDTO(this.id, this.name, this.areas);
      }

      @Override
      public String toString() {
         return "MonomerDTO.MonomerDTOBuilder(id=" + this.id + ", name=" + this.name + ", areas=" + this.areas + ")";
      }
   }
}
