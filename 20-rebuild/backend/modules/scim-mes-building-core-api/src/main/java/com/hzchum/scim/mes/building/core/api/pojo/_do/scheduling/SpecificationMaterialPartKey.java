package com.hzchum.scim.mes.building.core.api.pojo._do.scheduling;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "SpecificationMaterialKey", description = "零件根据材质厚度类型分组 ")
public class SpecificationMaterialPartKey {
   private String material;
   private String thick;

   public static SpecificationMaterialPartKey.SpecificationMaterialPartKeyBuilder builder() {
      return new SpecificationMaterialPartKey.SpecificationMaterialPartKeyBuilder();
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SpecificationMaterialPartKey)) {
         return false;
      } else {
         SpecificationMaterialPartKey other = (SpecificationMaterialPartKey)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$material = this.getMaterial();
            Object other$material = other.getMaterial();
            if (this$material == null ? other$material == null : this$material.equals(other$material)) {
               Object this$thick = this.getThick();
               Object other$thick = other.getThick();
               return this$thick == null ? other$thick == null : this$thick.equals(other$thick);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SpecificationMaterialPartKey;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thick = this.getThick();
      return result * 59 + ($thick == null ? 43 : $thick.hashCode());
   }

   public SpecificationMaterialPartKey() {
   }

   public SpecificationMaterialPartKey(final String material, final String thick) {
      this.material = material;
      this.thick = thick;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getThick() {
      return this.thick;
   }

   public SpecificationMaterialPartKey setMaterial(final String material) {
      this.material = material;
      return this;
   }

   public SpecificationMaterialPartKey setThick(final String thick) {
      this.thick = thick;
      return this;
   }

   @Override
   public String toString() {
      return "SpecificationMaterialPartKey(material=" + this.getMaterial() + ", thick=" + this.getThick() + ")";
   }

   public static class SpecificationMaterialPartKeyBuilder {
      private String material;
      private String thick;

      SpecificationMaterialPartKeyBuilder() {
      }

      public SpecificationMaterialPartKey.SpecificationMaterialPartKeyBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public SpecificationMaterialPartKey.SpecificationMaterialPartKeyBuilder thick(final String thick) {
         this.thick = thick;
         return this;
      }

      public SpecificationMaterialPartKey build() {
         return new SpecificationMaterialPartKey(this.material, this.thick);
      }

      @Override
      public String toString() {
         return "SpecificationMaterialPartKey.SpecificationMaterialPartKeyBuilder(material=" + this.material + ", thick=" + this.thick + ")";
      }
   }
}
