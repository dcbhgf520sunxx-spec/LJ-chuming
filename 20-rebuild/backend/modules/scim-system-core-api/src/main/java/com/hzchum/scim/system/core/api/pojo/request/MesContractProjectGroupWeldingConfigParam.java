package com.hzchum.scim.system.core.api.pojo.request;

public class MesContractProjectGroupWeldingConfigParam {
   private Long projectId;
   private Long assembleConfigId;
   private Long processId;

   public static MesContractProjectGroupWeldingConfigParam.MesContractProjectGroupWeldingConfigParamBuilder builder() {
      return new MesContractProjectGroupWeldingConfigParam.MesContractProjectGroupWeldingConfigParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getAssembleConfigId() {
      return this.assembleConfigId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setAssembleConfigId(final Long assembleConfigId) {
      this.assembleConfigId = assembleConfigId;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectGroupWeldingConfigParam)) {
         return false;
      }

      MesContractProjectGroupWeldingConfigParam other = (MesContractProjectGroupWeldingConfigParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$assembleConfigId = this.getAssembleConfigId();
         Object other$assembleConfigId = other.getAssembleConfigId();
         if (this$assembleConfigId == null ? other$assembleConfigId == null : this$assembleConfigId.equals(other$assembleConfigId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            return this$processId == null ? other$processId == null : this$processId.equals(other$processId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesContractProjectGroupWeldingConfigParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $assembleConfigId = this.getAssembleConfigId();
      result = result * 59 + ($assembleConfigId == null ? 43 : $assembleConfigId.hashCode());
      Object $processId = this.getProcessId();
      return result * 59 + ($processId == null ? 43 : $processId.hashCode());
   }

   @Override
   public String toString() {
      return "MesContractProjectGroupWeldingConfigParam(projectId="
         + this.getProjectId()
         + ", assembleConfigId="
         + this.getAssembleConfigId()
         + ", processId="
         + this.getProcessId()
         + ")";
   }

   public MesContractProjectGroupWeldingConfigParam() {
   }

   public MesContractProjectGroupWeldingConfigParam(final Long projectId, final Long assembleConfigId, final Long processId) {
      this.projectId = projectId;
      this.assembleConfigId = assembleConfigId;
      this.processId = processId;
   }

   public static class MesContractProjectGroupWeldingConfigParamBuilder {
      private Long projectId;
      private Long assembleConfigId;
      private Long processId;

      MesContractProjectGroupWeldingConfigParamBuilder() {
      }

      public MesContractProjectGroupWeldingConfigParam.MesContractProjectGroupWeldingConfigParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesContractProjectGroupWeldingConfigParam.MesContractProjectGroupWeldingConfigParamBuilder assembleConfigId(final Long assembleConfigId) {
         this.assembleConfigId = assembleConfigId;
         return this;
      }

      public MesContractProjectGroupWeldingConfigParam.MesContractProjectGroupWeldingConfigParamBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesContractProjectGroupWeldingConfigParam build() {
         return new MesContractProjectGroupWeldingConfigParam(this.projectId, this.assembleConfigId, this.processId);
      }

      @Override
      public String toString() {
         return "MesContractProjectGroupWeldingConfigParam.MesContractProjectGroupWeldingConfigParamBuilder(projectId="
            + this.projectId
            + ", assembleConfigId="
            + this.assembleConfigId
            + ", processId="
            + this.processId
            + ")";
      }
   }
}
