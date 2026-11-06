package com.hzchum.scim.business.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class BusinessArtifactSimpleDTO {
   @ApiModelProperty("商务id")
   private Long id;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("材质")
   private String material;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessArtifactSimpleDTO)) {
         return false;
      }

      BusinessArtifactSimpleDTO other = (BusinessArtifactSimpleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$material = this.getMaterial();
            Object other$material = other.getMaterial();
            return this$material == null ? other$material == null : this$material.equals(other$material);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BusinessArtifactSimpleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessArtifactSimpleDTO(id=" + this.getId() + ", name=" + this.getName() + ", material=" + this.getMaterial() + ")";
   }
}
