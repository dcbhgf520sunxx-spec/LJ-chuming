package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingWipDailySnapshotProcessDTO", description = "每日在制品快照进程DTO ")
public class MesBuildingWipDailySnapshotProcessDTO {
   @ApiModelProperty("工序id")
   private Long processId;
   @ApiModelProperty("工序名称")
   private String processName;

   public static MesBuildingWipDailySnapshotProcessDTO.MesBuildingWipDailySnapshotProcessDTOBuilder builder() {
      return new MesBuildingWipDailySnapshotProcessDTO.MesBuildingWipDailySnapshotProcessDTOBuilder();
   }

   public MesBuildingWipDailySnapshotProcessDTO(final Long processId, final String processName) {
      this.processId = processId;
      this.processName = processName;
   }

   public MesBuildingWipDailySnapshotProcessDTO() {
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public MesBuildingWipDailySnapshotProcessDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesBuildingWipDailySnapshotProcessDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingWipDailySnapshotProcessDTO(processId=" + this.getProcessId() + ", processName=" + this.getProcessName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingWipDailySnapshotProcessDTO)) {
         return false;
      } else {
         MesBuildingWipDailySnapshotProcessDTO other = (MesBuildingWipDailySnapshotProcessDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$processName = this.getProcessName();
               Object other$processName = other.getProcessName();
               return this$processName == null ? other$processName == null : this$processName.equals(other$processName);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingWipDailySnapshotProcessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $processName = this.getProcessName();
      return result * 59 + ($processName == null ? 43 : $processName.hashCode());
   }

   public static class MesBuildingWipDailySnapshotProcessDTOBuilder {
      private Long processId;
      private String processName;

      MesBuildingWipDailySnapshotProcessDTOBuilder() {
      }

      public MesBuildingWipDailySnapshotProcessDTO.MesBuildingWipDailySnapshotProcessDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesBuildingWipDailySnapshotProcessDTO.MesBuildingWipDailySnapshotProcessDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public MesBuildingWipDailySnapshotProcessDTO build() {
         return new MesBuildingWipDailySnapshotProcessDTO(this.processId, this.processName);
      }

      @Override
      public String toString() {
         return "MesBuildingWipDailySnapshotProcessDTO.MesBuildingWipDailySnapshotProcessDTOBuilder(processId="
            + this.processId
            + ", processName="
            + this.processName
            + ")";
      }
   }
}
