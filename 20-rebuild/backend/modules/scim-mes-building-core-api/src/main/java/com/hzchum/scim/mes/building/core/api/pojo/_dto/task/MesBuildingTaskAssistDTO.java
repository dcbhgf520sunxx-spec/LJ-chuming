package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingTaskAssistDTO", description = "任务协同详情返回类")
public class MesBuildingTaskAssistDTO {
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   private Long taskId;
   @ApiModelProperty(name = "assistId", value = "协同id", notes = "协同id")
   private Long assistId;
   @ApiModelProperty(name = "taskProcessId", value = "任务工序id", notes = "任务工序id")
   private Long taskProcessId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   private Long groupsId;
   @ApiModelProperty(name = "quantity", value = "协同数量", notes = "协同数量")
   private Integer quantity;
   @ApiModelProperty(name = "produceQuantity", value = "完成数量", notes = "完成数量")
   private Integer produceQuantity;

   public static MesBuildingTaskAssistDTO.MesBuildingTaskAssistDTOBuilder builder() {
      return new MesBuildingTaskAssistDTO.MesBuildingTaskAssistDTOBuilder();
   }

   public MesBuildingTaskAssistDTO() {
   }

   public MesBuildingTaskAssistDTO(
      final Long taskId, final Long assistId, final Long taskProcessId, final Long groupsId, final Integer quantity, final Integer produceQuantity
   ) {
      this.taskId = taskId;
      this.assistId = assistId;
      this.taskProcessId = taskProcessId;
      this.groupsId = groupsId;
      this.quantity = quantity;
      this.produceQuantity = produceQuantity;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getAssistId() {
      return this.assistId;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getProduceQuantity() {
      return this.produceQuantity;
   }

   public MesBuildingTaskAssistDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   public MesBuildingTaskAssistDTO setAssistId(final Long assistId) {
      this.assistId = assistId;
      return this;
   }

   public MesBuildingTaskAssistDTO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   public MesBuildingTaskAssistDTO setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   public MesBuildingTaskAssistDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public MesBuildingTaskAssistDTO setProduceQuantity(final Integer produceQuantity) {
      this.produceQuantity = produceQuantity;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskAssistDTO)) {
         return false;
      }

      MesBuildingTaskAssistDTO other = (MesBuildingTaskAssistDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskId = this.getTaskId();
      Object other$taskId = other.getTaskId();
      if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
         Object this$assistId = this.getAssistId();
         Object other$assistId = other.getAssistId();
         if (this$assistId == null ? other$assistId == null : this$assistId.equals(other$assistId)) {
            Object this$taskProcessId = this.getTaskProcessId();
            Object other$taskProcessId = other.getTaskProcessId();
            if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
               Object this$groupsId = this.getGroupsId();
               Object other$groupsId = other.getGroupsId();
               if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$produceQuantity = this.getProduceQuantity();
                     Object other$produceQuantity = other.getProduceQuantity();
                     return this$produceQuantity == null ? other$produceQuantity == null : this$produceQuantity.equals(other$produceQuantity);
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
      return other instanceof MesBuildingTaskAssistDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $assistId = this.getAssistId();
      result = result * 59 + ($assistId == null ? 43 : $assistId.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $produceQuantity = this.getProduceQuantity();
      return result * 59 + ($produceQuantity == null ? 43 : $produceQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "MesBuildingTaskAssistDTO(taskId="
         + this.getTaskId()
         + ", assistId="
         + this.getAssistId()
         + ", taskProcessId="
         + this.getTaskProcessId()
         + ", groupsId="
         + this.getGroupsId()
         + ", quantity="
         + this.getQuantity()
         + ", produceQuantity="
         + this.getProduceQuantity()
         + ")";
   }

   public static class MesBuildingTaskAssistDTOBuilder {
      private Long taskId;
      private Long assistId;
      private Long taskProcessId;
      private Long groupsId;
      private Integer quantity;
      private Integer produceQuantity;

      MesBuildingTaskAssistDTOBuilder() {
      }

      public MesBuildingTaskAssistDTO.MesBuildingTaskAssistDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public MesBuildingTaskAssistDTO.MesBuildingTaskAssistDTOBuilder assistId(final Long assistId) {
         this.assistId = assistId;
         return this;
      }

      public MesBuildingTaskAssistDTO.MesBuildingTaskAssistDTOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      public MesBuildingTaskAssistDTO.MesBuildingTaskAssistDTOBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      public MesBuildingTaskAssistDTO.MesBuildingTaskAssistDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingTaskAssistDTO.MesBuildingTaskAssistDTOBuilder produceQuantity(final Integer produceQuantity) {
         this.produceQuantity = produceQuantity;
         return this;
      }

      public MesBuildingTaskAssistDTO build() {
         return new MesBuildingTaskAssistDTO(this.taskId, this.assistId, this.taskProcessId, this.groupsId, this.quantity, this.produceQuantity);
      }

      @Override
      public String toString() {
         return "MesBuildingTaskAssistDTO.MesBuildingTaskAssistDTOBuilder(taskId="
            + this.taskId
            + ", assistId="
            + this.assistId
            + ", taskProcessId="
            + this.taskProcessId
            + ", groupsId="
            + this.groupsId
            + ", quantity="
            + this.quantity
            + ", produceQuantity="
            + this.produceQuantity
            + ")";
      }
   }
}
