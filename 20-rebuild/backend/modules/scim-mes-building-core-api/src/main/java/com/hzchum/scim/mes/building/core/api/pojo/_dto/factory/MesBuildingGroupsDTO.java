package com.hzchum.scim.mes.building.core.api.pojo._dto.factory;

import com.hzchum.scim.mes.building.core.api.pojo._do.factory.MesBuildingGroupsDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingGroupsDTO", description = "生产组 ")
public class MesBuildingGroupsDTO extends MesBuildingGroupsDO {
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   private Long taskId;
   @ApiModelProperty(name = "processId", value = "工序id", notes = "工序id")
   private Long processId;
   @ApiModelProperty(name = "teamId", value = "班组id", notes = "班组id")
   private Long teamId;
   @ApiModelProperty(name = "teamName", value = "班组名称", notes = "班组名称")
   private String teamName;

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public MesBuildingGroupsDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   public MesBuildingGroupsDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesBuildingGroupsDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   public MesBuildingGroupsDTO setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingGroupsDTO(taskId="
         + this.getTaskId()
         + ", processId="
         + this.getProcessId()
         + ", teamId="
         + this.getTeamId()
         + ", teamName="
         + this.getTeamName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingGroupsDTO)) {
         return false;
      }

      MesBuildingGroupsDTO other = (MesBuildingGroupsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$taskId = this.getTaskId();
      Object other$taskId = other.getTaskId();
      if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
               Object this$teamName = this.getTeamName();
               Object other$teamName = other.getTeamName();
               return this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingGroupsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $teamName = this.getTeamName();
      return result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
   }
}
