package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesSignageProcessLinkDTO", description = " ")
public class MesSignageProcessLinkDTO {
   @ApiModelProperty(name = "taskProcessId", value = "任务工序Id")
   private Long taskProcessId;
   @ApiModelProperty(name = "taskId", value = "任务Id")
   private Long taskId;
   @ApiModelProperty(name = "teamId", value = "班组Id")
   private Long teamId;
   @ApiModelProperty(name = "classId", value = "产品种类Id")
   private Long classId;
   @ApiModelProperty(name = "processId", value = "工序Id")
   private Long processId;
   @ApiModelProperty(name = "taskQuantity", value = "任务数")
   private Integer taskQuantity;
   @ApiModelProperty(name = "inspectionQuantity", value = "质检数")
   private Integer inspectionQuantity;

   public static MesSignageProcessLinkDTO.MesSignageProcessLinkDTOBuilder builder() {
      return new MesSignageProcessLinkDTO.MesSignageProcessLinkDTOBuilder();
   }

   public MesSignageProcessLinkDTO() {
   }

   public MesSignageProcessLinkDTO(
      final Long taskProcessId,
      final Long taskId,
      final Long teamId,
      final Long classId,
      final Long processId,
      final Integer taskQuantity,
      final Integer inspectionQuantity
   ) {
      this.taskProcessId = taskProcessId;
      this.taskId = taskId;
      this.teamId = teamId;
      this.classId = classId;
      this.processId = processId;
      this.taskQuantity = taskQuantity;
      this.inspectionQuantity = inspectionQuantity;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public Long getClassId() {
      return this.classId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public Integer getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public MesSignageProcessLinkDTO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   public MesSignageProcessLinkDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   public MesSignageProcessLinkDTO setTeamId(final Long teamId) {
      this.teamId = teamId;
      return this;
   }

   public MesSignageProcessLinkDTO setClassId(final Long classId) {
      this.classId = classId;
      return this;
   }

   public MesSignageProcessLinkDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   public MesSignageProcessLinkDTO setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
      return this;
   }

   public MesSignageProcessLinkDTO setInspectionQuantity(final Integer inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesSignageProcessLinkDTO(taskProcessId="
         + this.getTaskProcessId()
         + ", taskId="
         + this.getTaskId()
         + ", teamId="
         + this.getTeamId()
         + ", classId="
         + this.getClassId()
         + ", processId="
         + this.getProcessId()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesSignageProcessLinkDTO)) {
         return false;
      }

      MesSignageProcessLinkDTO other = (MesSignageProcessLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskProcessId = this.getTaskProcessId();
      Object other$taskProcessId = other.getTaskProcessId();
      if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
         Object this$taskId = this.getTaskId();
         Object other$taskId = other.getTaskId();
         if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
            Object this$teamId = this.getTeamId();
            Object other$teamId = other.getTeamId();
            if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
               Object this$classId = this.getClassId();
               Object other$classId = other.getClassId();
               if (this$classId == null ? other$classId == null : this$classId.equals(other$classId)) {
                  Object this$processId = this.getProcessId();
                  Object other$processId = other.getProcessId();
                  if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                     Object this$taskQuantity = this.getTaskQuantity();
                     Object other$taskQuantity = other.getTaskQuantity();
                     if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
                        Object this$inspectionQuantity = this.getInspectionQuantity();
                        Object other$inspectionQuantity = other.getInspectionQuantity();
                        return this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesSignageProcessLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $classId = this.getClassId();
      result = result * 59 + ($classId == null ? 43 : $classId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      return result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
   }

   public static class MesSignageProcessLinkDTOBuilder {
      private Long taskProcessId;
      private Long taskId;
      private Long teamId;
      private Long classId;
      private Long processId;
      private Integer taskQuantity;
      private Integer inspectionQuantity;

      MesSignageProcessLinkDTOBuilder() {
      }

      public MesSignageProcessLinkDTO.MesSignageProcessLinkDTOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      public MesSignageProcessLinkDTO.MesSignageProcessLinkDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public MesSignageProcessLinkDTO.MesSignageProcessLinkDTOBuilder teamId(final Long teamId) {
         this.teamId = teamId;
         return this;
      }

      public MesSignageProcessLinkDTO.MesSignageProcessLinkDTOBuilder classId(final Long classId) {
         this.classId = classId;
         return this;
      }

      public MesSignageProcessLinkDTO.MesSignageProcessLinkDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesSignageProcessLinkDTO.MesSignageProcessLinkDTOBuilder taskQuantity(final Integer taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      public MesSignageProcessLinkDTO.MesSignageProcessLinkDTOBuilder inspectionQuantity(final Integer inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      public MesSignageProcessLinkDTO build() {
         return new MesSignageProcessLinkDTO(
            this.taskProcessId, this.taskId, this.teamId, this.classId, this.processId, this.taskQuantity, this.inspectionQuantity
         );
      }

      @Override
      public String toString() {
         return "MesSignageProcessLinkDTO.MesSignageProcessLinkDTOBuilder(taskProcessId="
            + this.taskProcessId
            + ", taskId="
            + this.taskId
            + ", teamId="
            + this.teamId
            + ", classId="
            + this.classId
            + ", processId="
            + this.processId
            + ", taskQuantity="
            + this.taskQuantity
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ")";
      }
   }
}
