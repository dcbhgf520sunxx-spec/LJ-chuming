package com.hzchum.scim.system.core.api.pojo.request;

public class MesContractProjectAssemblingWeldingConfig {
   private Long projectId;
   private Long artifactTypeId;
   private String artifactName;
   private Long processId;

   public static MesContractProjectAssemblingWeldingConfig.MesContractProjectAssemblingWeldingConfigBuilder builder() {
      return new MesContractProjectAssemblingWeldingConfig.MesContractProjectAssemblingWeldingConfigBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getArtifactTypeId() {
      return this.artifactTypeId;
   }

   public String getArtifactName() {
      return this.artifactName;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setArtifactTypeId(final Long artifactTypeId) {
      this.artifactTypeId = artifactTypeId;
   }

   public void setArtifactName(final String artifactName) {
      this.artifactName = artifactName;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectAssemblingWeldingConfig)) {
         return false;
      }

      MesContractProjectAssemblingWeldingConfig other = (MesContractProjectAssemblingWeldingConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$artifactTypeId = this.getArtifactTypeId();
         Object other$artifactTypeId = other.getArtifactTypeId();
         if (this$artifactTypeId == null ? other$artifactTypeId == null : this$artifactTypeId.equals(other$artifactTypeId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$artifactName = this.getArtifactName();
               Object other$artifactName = other.getArtifactName();
               return this$artifactName == null ? other$artifactName == null : this$artifactName.equals(other$artifactName);
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
      return other instanceof MesContractProjectAssemblingWeldingConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $artifactTypeId = this.getArtifactTypeId();
      result = result * 59 + ($artifactTypeId == null ? 43 : $artifactTypeId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $artifactName = this.getArtifactName();
      return result * 59 + ($artifactName == null ? 43 : $artifactName.hashCode());
   }

   @Override
   public String toString() {
      return "MesContractProjectAssemblingWeldingConfig(projectId="
         + this.getProjectId()
         + ", artifactTypeId="
         + this.getArtifactTypeId()
         + ", artifactName="
         + this.getArtifactName()
         + ", processId="
         + this.getProcessId()
         + ")";
   }

   public MesContractProjectAssemblingWeldingConfig() {
   }

   public MesContractProjectAssemblingWeldingConfig(final Long projectId, final Long artifactTypeId, final String artifactName, final Long processId) {
      this.projectId = projectId;
      this.artifactTypeId = artifactTypeId;
      this.artifactName = artifactName;
      this.processId = processId;
   }

   public static class MesContractProjectAssemblingWeldingConfigBuilder {
      private Long projectId;
      private Long artifactTypeId;
      private String artifactName;
      private Long processId;

      MesContractProjectAssemblingWeldingConfigBuilder() {
      }

      public MesContractProjectAssemblingWeldingConfig.MesContractProjectAssemblingWeldingConfigBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfig.MesContractProjectAssemblingWeldingConfigBuilder artifactTypeId(final Long artifactTypeId) {
         this.artifactTypeId = artifactTypeId;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfig.MesContractProjectAssemblingWeldingConfigBuilder artifactName(final String artifactName) {
         this.artifactName = artifactName;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfig.MesContractProjectAssemblingWeldingConfigBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesContractProjectAssemblingWeldingConfig build() {
         return new MesContractProjectAssemblingWeldingConfig(this.projectId, this.artifactTypeId, this.artifactName, this.processId);
      }

      @Override
      public String toString() {
         return "MesContractProjectAssemblingWeldingConfig.MesContractProjectAssemblingWeldingConfigBuilder(projectId="
            + this.projectId
            + ", artifactTypeId="
            + this.artifactTypeId
            + ", artifactName="
            + this.artifactName
            + ", processId="
            + this.processId
            + ")";
      }
   }
}
