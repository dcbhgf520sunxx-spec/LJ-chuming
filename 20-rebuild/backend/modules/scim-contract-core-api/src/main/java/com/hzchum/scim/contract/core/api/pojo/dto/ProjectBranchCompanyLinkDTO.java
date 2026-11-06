package com.hzchum.scim.contract.core.api.pojo.dto;

public class ProjectBranchCompanyLinkDTO {
   private Long branchCompanyId;
   private Long projectId;
   private Integer branchCompanyLevel;

   public static ProjectBranchCompanyLinkDTO.ProjectBranchCompanyLinkDTOBuilder builder() {
      return new ProjectBranchCompanyLinkDTO.ProjectBranchCompanyLinkDTOBuilder();
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getBranchCompanyLevel() {
      return this.branchCompanyLevel;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setBranchCompanyLevel(final Integer branchCompanyLevel) {
      this.branchCompanyLevel = branchCompanyLevel;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectBranchCompanyLinkDTO)) {
         return false;
      }

      ProjectBranchCompanyLinkDTO other = (ProjectBranchCompanyLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$branchCompanyId = this.getBranchCompanyId();
      Object other$branchCompanyId = other.getBranchCompanyId();
      if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$branchCompanyLevel = this.getBranchCompanyLevel();
            Object other$branchCompanyLevel = other.getBranchCompanyLevel();
            return this$branchCompanyLevel == null ? other$branchCompanyLevel == null : this$branchCompanyLevel.equals(other$branchCompanyLevel);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectBranchCompanyLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $branchCompanyLevel = this.getBranchCompanyLevel();
      return result * 59 + ($branchCompanyLevel == null ? 43 : $branchCompanyLevel.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectBranchCompanyLinkDTO(branchCompanyId="
         + this.getBranchCompanyId()
         + ", projectId="
         + this.getProjectId()
         + ", branchCompanyLevel="
         + this.getBranchCompanyLevel()
         + ")";
   }

   public ProjectBranchCompanyLinkDTO(final Long branchCompanyId, final Long projectId, final Integer branchCompanyLevel) {
      this.branchCompanyId = branchCompanyId;
      this.projectId = projectId;
      this.branchCompanyLevel = branchCompanyLevel;
   }

   public ProjectBranchCompanyLinkDTO() {
   }

   public static class ProjectBranchCompanyLinkDTOBuilder {
      private Long branchCompanyId;
      private Long projectId;
      private Integer branchCompanyLevel;

      ProjectBranchCompanyLinkDTOBuilder() {
      }

      public ProjectBranchCompanyLinkDTO.ProjectBranchCompanyLinkDTOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ProjectBranchCompanyLinkDTO.ProjectBranchCompanyLinkDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectBranchCompanyLinkDTO.ProjectBranchCompanyLinkDTOBuilder branchCompanyLevel(final Integer branchCompanyLevel) {
         this.branchCompanyLevel = branchCompanyLevel;
         return this;
      }

      public ProjectBranchCompanyLinkDTO build() {
         return new ProjectBranchCompanyLinkDTO(this.branchCompanyId, this.projectId, this.branchCompanyLevel);
      }

      @Override
      public String toString() {
         return "ProjectBranchCompanyLinkDTO.ProjectBranchCompanyLinkDTOBuilder(branchCompanyId="
            + this.branchCompanyId
            + ", projectId="
            + this.projectId
            + ", branchCompanyLevel="
            + this.branchCompanyLevel
            + ")";
      }
   }
}
