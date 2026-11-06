package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.Set;

@ApiModel("型材套料属性DTO")
public class AssembleSpecificationDTO {
   @ApiModelProperty(name = "specPrefix", value = "规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   private Set<String> material;

   public static AssembleSpecificationDTO.AssembleSpecificationDTOBuilder builder() {
      return new AssembleSpecificationDTO.AssembleSpecificationDTOBuilder();
   }

   public AssembleSpecificationDTO() {
   }

   public AssembleSpecificationDTO(final String specification, final Set<String> material) {
      this.specification = specification;
      this.material = material;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Set<String> getMaterial() {
      return this.material;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final Set<String> material) {
      this.material = material;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AssembleSpecificationDTO)) {
         return false;
      } else {
         AssembleSpecificationDTO other = (AssembleSpecificationDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$specification = this.getSpecification();
            Object other$specification = other.getSpecification();
            if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
               Object this$material = this.getMaterial();
               Object other$material = other.getMaterial();
               return this$material == null ? other$material == null : this$material.equals(other$material);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AssembleSpecificationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   @Override
   public String toString() {
      return "AssembleSpecificationDTO(specification=" + this.getSpecification() + ", material=" + this.getMaterial() + ")";
   }

   public static class AssembleSpecificationDTOBuilder {
      private String specification;
      private Set<String> material;

      AssembleSpecificationDTOBuilder() {
      }

      public AssembleSpecificationDTO.AssembleSpecificationDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public AssembleSpecificationDTO.AssembleSpecificationDTOBuilder material(final Set<String> material) {
         this.material = material;
         return this;
      }

      public AssembleSpecificationDTO build() {
         return new AssembleSpecificationDTO(this.specification, this.material);
      }

      @Override
      public String toString() {
         return "AssembleSpecificationDTO.AssembleSpecificationDTOBuilder(specification=" + this.specification + ", material=" + this.material + ")";
      }
   }
}
