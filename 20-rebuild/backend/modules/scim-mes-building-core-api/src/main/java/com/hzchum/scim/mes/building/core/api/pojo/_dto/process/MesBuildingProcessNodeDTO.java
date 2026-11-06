package com.hzchum.scim.mes.building.core.api.pojo._dto.process;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "MesBuildingProcessNode对象", description = "")
public class MesBuildingProcessNodeDTO {
   private Long id;
   private String name;

   public static MesBuildingProcessNodeDTO.MesBuildingProcessNodeDTOBuilder builder() {
      return new MesBuildingProcessNodeDTO.MesBuildingProcessNodeDTOBuilder();
   }

   public MesBuildingProcessNodeDTO() {
   }

   public MesBuildingProcessNodeDTO(final Long id, final String name) {
      this.id = id;
      this.name = name;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public MesBuildingProcessNodeDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingProcessNodeDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProcessNodeDTO(id=" + this.getId() + ", name=" + this.getName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingProcessNodeDTO)) {
         return false;
      } else {
         MesBuildingProcessNodeDTO other = (MesBuildingProcessNodeDTO)o;
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
      return other instanceof MesBuildingProcessNodeDTO;
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

   public static class MesBuildingProcessNodeDTOBuilder {
      private Long id;
      private String name;

      MesBuildingProcessNodeDTOBuilder() {
      }

      public MesBuildingProcessNodeDTO.MesBuildingProcessNodeDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingProcessNodeDTO.MesBuildingProcessNodeDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public MesBuildingProcessNodeDTO build() {
         return new MesBuildingProcessNodeDTO(this.id, this.name);
      }

      @Override
      public String toString() {
         return "MesBuildingProcessNodeDTO.MesBuildingProcessNodeDTOBuilder(id=" + this.id + ", name=" + this.name + ")";
      }
   }
}
