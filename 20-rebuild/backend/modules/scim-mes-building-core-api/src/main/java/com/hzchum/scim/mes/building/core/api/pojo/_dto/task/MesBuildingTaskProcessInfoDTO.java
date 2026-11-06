package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.hzchum.scim.common.core.api.pojo.common.ShowInfo;
import com.hzchum.scim.mes.building.core.api.pojo._doModel.task.MesBuildingTaskProcess;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("任务工序InfoDTO")
public class MesBuildingTaskProcessInfoDTO extends MesBuildingTaskProcess {
   @ApiModelProperty("项目")
   private ShowInfo project;
   @ApiModelProperty("任务工单")
   private ShowInfo taskOrder;
   @ApiModelProperty("工序")
   private ShowInfo process;
   @ApiModelProperty("班组")
   private ShowInfo team;

   public ShowInfo getProject() {
      return this.project;
   }

   public ShowInfo getTaskOrder() {
      return this.taskOrder;
   }

   public ShowInfo getProcess() {
      return this.process;
   }

   public ShowInfo getTeam() {
      return this.team;
   }

   public void setProject(final ShowInfo project) {
      this.project = project;
   }

   public void setTaskOrder(final ShowInfo taskOrder) {
      this.taskOrder = taskOrder;
   }

   public void setProcess(final ShowInfo process) {
      this.process = process;
   }

   public void setTeam(final ShowInfo team) {
      this.team = team;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskProcessInfoDTO)) {
         return false;
      }

      MesBuildingTaskProcessInfoDTO other = (MesBuildingTaskProcessInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
         Object this$taskOrder = this.getTaskOrder();
         Object other$taskOrder = other.getTaskOrder();
         if (this$taskOrder == null ? other$taskOrder == null : this$taskOrder.equals(other$taskOrder)) {
            Object this$process = this.getProcess();
            Object other$process = other.getProcess();
            if (this$process == null ? other$process == null : this$process.equals(other$process)) {
               Object this$team = this.getTeam();
               Object other$team = other.getTeam();
               return this$team == null ? other$team == null : this$team.equals(other$team);
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
      return other instanceof MesBuildingTaskProcessInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $taskOrder = this.getTaskOrder();
      result = result * 59 + ($taskOrder == null ? 43 : $taskOrder.hashCode());
      Object $process = this.getProcess();
      result = result * 59 + ($process == null ? 43 : $process.hashCode());
      Object $team = this.getTeam();
      return result * 59 + ($team == null ? 43 : $team.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingTaskProcessInfoDTO(super="
         + super.toString()
         + ", project="
         + this.getProject()
         + ", taskOrder="
         + this.getTaskOrder()
         + ", process="
         + this.getProcess()
         + ", team="
         + this.getTeam()
         + ")";
   }
}
