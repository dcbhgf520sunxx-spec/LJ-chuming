package com.hzchum.scim.scm.core.api.pojo.dto;

public class BuildingFactoryDTO {
   private Long id;
   private String name;
   private String shortName;

   public static BuildingFactoryDTO.BuildingFactoryDTOBuilder builder() {
      return new BuildingFactoryDTO.BuildingFactoryDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getShortName() {
      return this.shortName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setShortName(final String shortName) {
      this.shortName = shortName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BuildingFactoryDTO)) {
         return false;
      }

      BuildingFactoryDTO other = (BuildingFactoryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$shortName = this.getShortName();
            Object other$shortName = other.getShortName();
            return this$shortName == null ? other$shortName == null : this$shortName.equals(other$shortName);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BuildingFactoryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $shortName = this.getShortName();
      return result * 59 + ($shortName == null ? 43 : $shortName.hashCode());
   }

   @Override
   public String toString() {
      return "BuildingFactoryDTO(id=" + this.getId() + ", name=" + this.getName() + ", shortName=" + this.getShortName() + ")";
   }

   public BuildingFactoryDTO(final Long id, final String name, final String shortName) {
      this.id = id;
      this.name = name;
      this.shortName = shortName;
   }

   public BuildingFactoryDTO() {
   }

   public static class BuildingFactoryDTOBuilder {
      private Long id;
      private String name;
      private String shortName;

      BuildingFactoryDTOBuilder() {
      }

      public BuildingFactoryDTO.BuildingFactoryDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BuildingFactoryDTO.BuildingFactoryDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BuildingFactoryDTO.BuildingFactoryDTOBuilder shortName(final String shortName) {
         this.shortName = shortName;
         return this;
      }

      public BuildingFactoryDTO build() {
         return new BuildingFactoryDTO(this.id, this.name, this.shortName);
      }

      @Override
      public String toString() {
         return "BuildingFactoryDTO.BuildingFactoryDTOBuilder(id=" + this.id + ", name=" + this.name + ", shortName=" + this.shortName + ")";
      }
   }
}
