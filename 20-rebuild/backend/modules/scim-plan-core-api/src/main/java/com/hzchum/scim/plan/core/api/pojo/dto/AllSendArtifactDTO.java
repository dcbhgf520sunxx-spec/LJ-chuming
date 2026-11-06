package com.hzchum.scim.plan.core.api.pojo.dto;

public class AllSendArtifactDTO {
   private Long artifactId;
   private Long assOrPartId;
   private Boolean boolProcess;

   public static AllSendArtifactDTO.AllSendArtifactDTOBuilder builder() {
      return new AllSendArtifactDTO.AllSendArtifactDTOBuilder();
   }

   public AllSendArtifactDTO(final Long artifactId, final Long assOrPartId, final Boolean boolProcess) {
      this.artifactId = artifactId;
      this.assOrPartId = assOrPartId;
      this.boolProcess = boolProcess;
   }

   public AllSendArtifactDTO() {
   }

   public Long getArtifactId() {
      return this.artifactId;
   }

   public Long getAssOrPartId() {
      return this.assOrPartId;
   }

   public Boolean getBoolProcess() {
      return this.boolProcess;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
   }

   public void setAssOrPartId(final Long assOrPartId) {
      this.assOrPartId = assOrPartId;
   }

   public void setBoolProcess(final Boolean boolProcess) {
      this.boolProcess = boolProcess;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AllSendArtifactDTO)) {
         return false;
      }

      AllSendArtifactDTO other = (AllSendArtifactDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactId = this.getArtifactId();
      Object other$artifactId = other.getArtifactId();
      if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
         Object this$assOrPartId = this.getAssOrPartId();
         Object other$assOrPartId = other.getAssOrPartId();
         if (this$assOrPartId == null ? other$assOrPartId == null : this$assOrPartId.equals(other$assOrPartId)) {
            Object this$boolProcess = this.getBoolProcess();
            Object other$boolProcess = other.getBoolProcess();
            return this$boolProcess == null ? other$boolProcess == null : this$boolProcess.equals(other$boolProcess);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AllSendArtifactDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $assOrPartId = this.getAssOrPartId();
      result = result * 59 + ($assOrPartId == null ? 43 : $assOrPartId.hashCode());
      Object $boolProcess = this.getBoolProcess();
      return result * 59 + ($boolProcess == null ? 43 : $boolProcess.hashCode());
   }

   @Override
   public String toString() {
      return "AllSendArtifactDTO(artifactId="
         + this.getArtifactId()
         + ", assOrPartId="
         + this.getAssOrPartId()
         + ", boolProcess="
         + this.getBoolProcess()
         + ")";
   }

   public static class AllSendArtifactDTOBuilder {
      private Long artifactId;
      private Long assOrPartId;
      private Boolean boolProcess;

      AllSendArtifactDTOBuilder() {
      }

      public AllSendArtifactDTO.AllSendArtifactDTOBuilder artifactId(final Long artifactId) {
         this.artifactId = artifactId;
         return this;
      }

      public AllSendArtifactDTO.AllSendArtifactDTOBuilder assOrPartId(final Long assOrPartId) {
         this.assOrPartId = assOrPartId;
         return this;
      }

      public AllSendArtifactDTO.AllSendArtifactDTOBuilder boolProcess(final Boolean boolProcess) {
         this.boolProcess = boolProcess;
         return this;
      }

      public AllSendArtifactDTO build() {
         return new AllSendArtifactDTO(this.artifactId, this.assOrPartId, this.boolProcess);
      }

      @Override
      public String toString() {
         return "AllSendArtifactDTO.AllSendArtifactDTOBuilder(artifactId="
            + this.artifactId
            + ", assOrPartId="
            + this.assOrPartId
            + ", boolProcess="
            + this.boolProcess
            + ")";
      }
   }
}
