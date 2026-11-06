package com.hzchum.scim.project.core.api.pojo.dtoParam;

public class SubBusinessConditionDTOParam {
   private Long projectId;
   private Long monomerId;
   private Long supplierId;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubBusinessConditionDTOParam)) {
         return false;
      }

      SubBusinessConditionDTOParam other = (SubBusinessConditionDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            return this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SubBusinessConditionDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $supplierId = this.getSupplierId();
      return result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
   }

   @Override
   public String toString() {
      return "SubBusinessConditionDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", supplierId="
         + this.getSupplierId()
         + ")";
   }
}
