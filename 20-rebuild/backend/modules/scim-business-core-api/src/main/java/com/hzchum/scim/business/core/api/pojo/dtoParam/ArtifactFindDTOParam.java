package com.hzchum.scim.business.core.api.pojo.dtoParam;

public class ArtifactFindDTOParam {
   private Long projectId;
   private Long monomerId;
   private Long areaId;
   private String name;
   private String material;
   private String specification;

   public static ArtifactFindDTOParam.ArtifactFindDTOParamBuilder builder() {
      return new ArtifactFindDTOParam.ArtifactFindDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
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

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
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

      if (!(o instanceof ArtifactFindDTOParam)) {
         return false;
      }

      ArtifactFindDTOParam other = (ArtifactFindDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactFindDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $specification = this.getSpecification();
      return result * 59 + ($specification == null ? 43 : $specification.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactFindDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", specification="
         + this.getSpecification()
         + ")";
   }

   public ArtifactFindDTOParam(
      final Long projectId, final Long monomerId, final Long areaId, final String name, final String material, final String specification
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.name = name;
      this.material = material;
      this.specification = specification;
   }

   public ArtifactFindDTOParam() {
   }

   public static class ArtifactFindDTOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private String name;
      private String material;
      private String specification;

      ArtifactFindDTOParamBuilder() {
      }

      public ArtifactFindDTOParam.ArtifactFindDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ArtifactFindDTOParam.ArtifactFindDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ArtifactFindDTOParam.ArtifactFindDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ArtifactFindDTOParam.ArtifactFindDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ArtifactFindDTOParam.ArtifactFindDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public ArtifactFindDTOParam.ArtifactFindDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ArtifactFindDTOParam build() {
         return new ArtifactFindDTOParam(this.projectId, this.monomerId, this.areaId, this.name, this.material, this.specification);
      }

      @Override
      public String toString() {
         return "ArtifactFindDTOParam.ArtifactFindDTOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
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
