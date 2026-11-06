package com.hzchum.scim.business.core.api.pojo.dtoParam.bridge;

public class BridgeBoxFindVOParam {
   private Long projectId;
   private Long monomerId;
   private String material;
   private String specification;

   public static BridgeBoxFindVOParam.BridgeBoxFindVOParamBuilder builder() {
      return new BridgeBoxFindVOParam.BridgeBoxFindVOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getSpecification() {
      return this.specification;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
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

      if (!(o instanceof BridgeBoxFindVOParam)) {
         return false;
      }

      BridgeBoxFindVOParam other = (BridgeBoxFindVOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
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
      return other instanceof BridgeBoxFindVOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $specification = this.getSpecification();
      return result * 59 + ($specification == null ? 43 : $specification.hashCode());
   }

   @Override
   public String toString() {
      return "BridgeBoxFindVOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", material="
         + this.getMaterial()
         + ", specification="
         + this.getSpecification()
         + ")";
   }

   public BridgeBoxFindVOParam(final Long projectId, final Long monomerId, final String material, final String specification) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.material = material;
      this.specification = specification;
   }

   public BridgeBoxFindVOParam() {
   }

   public static class BridgeBoxFindVOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private String material;
      private String specification;

      BridgeBoxFindVOParamBuilder() {
      }

      public BridgeBoxFindVOParam.BridgeBoxFindVOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public BridgeBoxFindVOParam.BridgeBoxFindVOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public BridgeBoxFindVOParam.BridgeBoxFindVOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public BridgeBoxFindVOParam.BridgeBoxFindVOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public BridgeBoxFindVOParam build() {
         return new BridgeBoxFindVOParam(this.projectId, this.monomerId, this.material, this.specification);
      }

      @Override
      public String toString() {
         return "BridgeBoxFindVOParam.BridgeBoxFindVOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", material="
            + this.material
            + ", specification="
            + this.specification
            + ")";
      }
   }
}
