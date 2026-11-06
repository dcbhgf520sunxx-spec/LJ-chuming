package com.hzchum.scim.mes.building.core.api.pojo._do.scheduling;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "SpecificationMaterialKey", description = "型材根据规格材质类型分组 ")
public class SpecificationMaterialKey {
   private String specification;
   private String material;
   private String partType;

   public static SpecificationMaterialKey.SpecificationMaterialKeyBuilder builder() {
      return new SpecificationMaterialKey.SpecificationMaterialKeyBuilder();
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SpecificationMaterialKey)) {
         return false;
      }

      SpecificationMaterialKey other = (SpecificationMaterialKey)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$specification = this.getSpecification();
      Object other$specification = other.getSpecification();
      if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
         Object this$material = this.getMaterial();
         Object other$material = other.getMaterial();
         if (this$material == null ? other$material == null : this$material.equals(other$material)) {
            Object this$partType = this.getPartType();
            Object other$partType = other.getPartType();
            return this$partType == null ? other$partType == null : this$partType.equals(other$partType);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SpecificationMaterialKey;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $partType = this.getPartType();
      return result * 59 + ($partType == null ? 43 : $partType.hashCode());
   }

   public SpecificationMaterialKey() {
   }

   public SpecificationMaterialKey(final String specification, final String material, final String partType) {
      this.specification = specification;
      this.material = material;
      this.partType = partType;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getPartType() {
      return this.partType;
   }

   public SpecificationMaterialKey setSpecification(final String specification) {
      this.specification = specification;
      return this;
   }

   public SpecificationMaterialKey setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public SpecificationMaterialKey setPartType(final String partType) {
      this.partType = partType;
      return this;
   }

   @Override
   public String toString() {
      return "SpecificationMaterialKey(specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", partType="
         + this.getPartType()
         + ")";
   }

   public static class SpecificationMaterialKeyBuilder {
      private String specification;
      private String material;
      private String partType;

      SpecificationMaterialKeyBuilder() {
      }

      public SpecificationMaterialKey.SpecificationMaterialKeyBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public SpecificationMaterialKey.SpecificationMaterialKeyBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public SpecificationMaterialKey.SpecificationMaterialKeyBuilder partType(final String partType) {
         this.partType = partType;
         return this;
      }

      public SpecificationMaterialKey build() {
         return new SpecificationMaterialKey(this.specification, this.material, this.partType);
      }

      @Override
      public String toString() {
         return "SpecificationMaterialKey.SpecificationMaterialKeyBuilder(specification="
            + this.specification
            + ", material="
            + this.material
            + ", partType="
            + this.partType
            + ")";
      }
   }
}
