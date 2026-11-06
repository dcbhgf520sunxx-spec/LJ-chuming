package com.hzchum.scim.mes.building.core.api.pojo._dto.statistica;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Set;

@ApiModel(value = "MesBuildingArtifactTypeConfigVO", description = "构件种类配置DTO ")
public class MesBuildingArtifactTypeConfigDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "typeName", value = "构件种类名称")
   private String typeName;
   @ApiModelProperty(name = "typeName", value = "清单构件编号")
   private Set<String> inventoryNames;

   public static MesBuildingArtifactTypeConfigDTO.MesBuildingArtifactTypeConfigDTOBuilder builder() {
      return new MesBuildingArtifactTypeConfigDTO.MesBuildingArtifactTypeConfigDTOBuilder();
   }

   public MesBuildingArtifactTypeConfigDTO() {
   }

   public MesBuildingArtifactTypeConfigDTO(final Long id, final String typeName, final Set<String> inventoryNames) {
      this.id = id;
      this.typeName = typeName;
      this.inventoryNames = inventoryNames;
   }

   public Long getId() {
      return this.id;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public Set<String> getInventoryNames() {
      return this.inventoryNames;
   }

   public MesBuildingArtifactTypeConfigDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingArtifactTypeConfigDTO setTypeName(final String typeName) {
      this.typeName = typeName;
      return this;
   }

   public MesBuildingArtifactTypeConfigDTO setInventoryNames(final Set<String> inventoryNames) {
      this.inventoryNames = inventoryNames;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingArtifactTypeConfigDTO(id=" + this.getId() + ", typeName=" + this.getTypeName() + ", inventoryNames=" + this.getInventoryNames() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingArtifactTypeConfigDTO)) {
         return false;
      }

      MesBuildingArtifactTypeConfigDTO other = (MesBuildingArtifactTypeConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$typeName = this.getTypeName();
         Object other$typeName = other.getTypeName();
         if (this$typeName == null ? other$typeName == null : this$typeName.equals(other$typeName)) {
            Object this$inventoryNames = this.getInventoryNames();
            Object other$inventoryNames = other.getInventoryNames();
            return this$inventoryNames == null ? other$inventoryNames == null : this$inventoryNames.equals(other$inventoryNames);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingArtifactTypeConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $inventoryNames = this.getInventoryNames();
      return result * 59 + ($inventoryNames == null ? 43 : $inventoryNames.hashCode());
   }

   public static class MesBuildingArtifactTypeConfigDTOBuilder {
      private Long id;
      private String typeName;
      private Set<String> inventoryNames;

      MesBuildingArtifactTypeConfigDTOBuilder() {
      }

      public MesBuildingArtifactTypeConfigDTO.MesBuildingArtifactTypeConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingArtifactTypeConfigDTO.MesBuildingArtifactTypeConfigDTOBuilder typeName(final String typeName) {
         this.typeName = typeName;
         return this;
      }

      public MesBuildingArtifactTypeConfigDTO.MesBuildingArtifactTypeConfigDTOBuilder inventoryNames(final Set<String> inventoryNames) {
         this.inventoryNames = inventoryNames;
         return this;
      }

      public MesBuildingArtifactTypeConfigDTO build() {
         return new MesBuildingArtifactTypeConfigDTO(this.id, this.typeName, this.inventoryNames);
      }

      @Override
      public String toString() {
         return "MesBuildingArtifactTypeConfigDTO.MesBuildingArtifactTypeConfigDTOBuilder(id="
            + this.id
            + ", typeName="
            + this.typeName
            + ", inventoryNames="
            + this.inventoryNames
            + ")";
      }
   }
}
