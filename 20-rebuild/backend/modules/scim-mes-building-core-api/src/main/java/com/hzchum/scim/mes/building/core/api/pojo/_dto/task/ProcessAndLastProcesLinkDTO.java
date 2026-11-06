package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "ProcessAndLastProcesLinkDTO", description = " ")
public class ProcessAndLastProcesLinkDTO {
   private Long processId;
   private Long lastProcessId;

   public static ProcessAndLastProcesLinkDTO.ProcessAndLastProcesLinkDTOBuilder builder() {
      return new ProcessAndLastProcesLinkDTO.ProcessAndLastProcesLinkDTOBuilder();
   }

   public ProcessAndLastProcesLinkDTO() {
   }

   public ProcessAndLastProcesLinkDTO(final Long processId, final Long lastProcessId) {
      this.processId = processId;
      this.lastProcessId = lastProcessId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getLastProcessId() {
      return this.lastProcessId;
   }

   public ProcessAndLastProcesLinkDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public ProcessAndLastProcesLinkDTO setLastProcessId(final Long lastProcessId) {
      this.lastProcessId = lastProcessId;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessAndLastProcesLinkDTO(processId=" + this.getProcessId() + ", lastProcessId=" + this.getLastProcessId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProcessAndLastProcesLinkDTO)) {
         return false;
      } else {
         ProcessAndLastProcesLinkDTO other = (ProcessAndLastProcesLinkDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$lastProcessId = this.getLastProcessId();
               Object other$lastProcessId = other.getLastProcessId();
               return this$lastProcessId == null ? other$lastProcessId == null : this$lastProcessId.equals(other$lastProcessId);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessAndLastProcesLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $lastProcessId = this.getLastProcessId();
      return result * 59 + ($lastProcessId == null ? 43 : $lastProcessId.hashCode());
   }

   public static class ProcessAndLastProcesLinkDTOBuilder {
      private Long processId;
      private Long lastProcessId;

      ProcessAndLastProcesLinkDTOBuilder() {
      }

      public ProcessAndLastProcesLinkDTO.ProcessAndLastProcesLinkDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public ProcessAndLastProcesLinkDTO.ProcessAndLastProcesLinkDTOBuilder lastProcessId(final Long lastProcessId) {
         this.lastProcessId = lastProcessId;
         return this;
      }

      public ProcessAndLastProcesLinkDTO build() {
         return new ProcessAndLastProcesLinkDTO(this.processId, this.lastProcessId);
      }

      @Override
      public String toString() {
         return "ProcessAndLastProcesLinkDTO.ProcessAndLastProcesLinkDTOBuilder(processId=" + this.processId + ", lastProcessId=" + this.lastProcessId + ")";
      }
   }
}
