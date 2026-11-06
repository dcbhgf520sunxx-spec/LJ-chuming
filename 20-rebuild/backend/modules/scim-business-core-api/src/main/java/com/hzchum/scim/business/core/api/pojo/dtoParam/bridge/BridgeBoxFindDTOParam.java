package com.hzchum.scim.business.core.api.pojo.dtoParam.bridge;

public class BridgeBoxFindDTOParam {
   private Long monomerId;
   private String name;
   private String material;
   private String specification;

   public static BridgeBoxFindDTOParam.BridgeBoxFindDTOParamBuilder builder() {
      return new BridgeBoxFindDTOParam.BridgeBoxFindDTOParamBuilder();
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getSpecification() {
      return this.specification;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BridgeBoxFindDTOParam)) {
         return false;
      }

      BridgeBoxFindDTOParam other = (BridgeBoxFindDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerId = this.getMonomerId();
      Object other$monomerId = other.getMonomerId();
      if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
         Object this$name = this.getName();
         Object other$name = other.getName();
         if (this$name == null ? other$name == null : this$name.equals(other$name)) {
            Object this$material = this.getMaterial();
            Object other$material = other.getMaterial();
            if (this$material == null ? other$material == null : this$material.equals(other$material)) {
               Object this$specification = this.getSpecification();
               Object other$specification = other.getSpecification();
               return this$specification == null ? other$specification == null : this$specification.equals(other$specification);
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BridgeBoxFindDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $specification = this.getSpecification();
      return result * 59 + ($specification == null ? 43 : $specification.hashCode());
   }

   @Override
   public String toString() {
      return "BridgeBoxFindDTOParam(monomerId="
         + this.getMonomerId()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", specification="
         + this.getSpecification()
         + ")";
   }

   public BridgeBoxFindDTOParam(final Long monomerId, final String name, final String material, final String specification) {
      this.monomerId = monomerId;
      this.name = name;
      this.material = material;
      this.specification = specification;
   }

   public BridgeBoxFindDTOParam() {
   }

   public static class BridgeBoxFindDTOParamBuilder {
      private Long monomerId;
      private String name;
      private String material;
      private String specification;

      BridgeBoxFindDTOParamBuilder() {
      }

      public BridgeBoxFindDTOParam.BridgeBoxFindDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BridgeBoxFindDTOParam.BridgeBoxFindDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BridgeBoxFindDTOParam.BridgeBoxFindDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public BridgeBoxFindDTOParam.BridgeBoxFindDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public BridgeBoxFindDTOParam build() {
         return new BridgeBoxFindDTOParam(this.monomerId, this.name, this.material, this.specification);
      }

      @Override
      public String toString() {
         return "BridgeBoxFindDTOParam.BridgeBoxFindDTOParamBuilder(monomerId="
            + this.monomerId
            + ", name="
            + this.name
            + ", material="
            + this.material
            + ", specification="
            + this.specification
            + ")";
      }
   }
}
