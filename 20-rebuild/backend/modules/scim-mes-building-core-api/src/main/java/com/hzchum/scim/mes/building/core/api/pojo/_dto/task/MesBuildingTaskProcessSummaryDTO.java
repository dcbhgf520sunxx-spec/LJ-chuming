package com.hzchum.scim.mes.building.core.api.pojo._dto.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingTaskProcessSummaryDTO", description = "任务分配工序详情 ")
public class MesBuildingTaskProcessSummaryDTO {
   @ApiModelProperty(name = "sequence", notes = "工序顺序")
   @JsonProperty("sequence")
   @JSONField(name = "sequence")
   private Integer sequence;
   @ApiModelProperty(name = "taskId", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;
   @ApiModelProperty(name = "processId", notes = "工序id")
   @JsonProperty("processId")
   @JSONField(name = "processId")
   private Long processId;
   @ApiModelProperty(name = "quantity", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;

   public static MesBuildingTaskProcessSummaryDTO.MesBuildingTaskProcessSummaryDTOBuilder builder() {
      return new MesBuildingTaskProcessSummaryDTO.MesBuildingTaskProcessSummaryDTOBuilder();
   }

   public MesBuildingTaskProcessSummaryDTO(final Integer sequence, final Long taskId, final Long processId, final Integer quantity) {
      this.sequence = sequence;
      this.taskId = taskId;
      this.processId = processId;
      this.quantity = quantity;
   }

   public MesBuildingTaskProcessSummaryDTO() {
   }

   public Integer getSequence() {
      return this.sequence;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("sequence")
   public MesBuildingTaskProcessSummaryDTO setSequence(final Integer sequence) {
      this.sequence = sequence;
      return this;
   }

   @JsonProperty("taskId")
   public MesBuildingTaskProcessSummaryDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("processId")
   public MesBuildingTaskProcessSummaryDTO setProcessId(final Long processId) {
      this.processId = processId;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingTaskProcessSummaryDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingTaskProcessSummaryDTO(sequence="
         + this.getSequence()
         + ", taskId="
         + this.getTaskId()
         + ", processId="
         + this.getProcessId()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskProcessSummaryDTO)) {
         return false;
      }

      MesBuildingTaskProcessSummaryDTO other = (MesBuildingTaskProcessSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sequence = this.getSequence();
      Object other$sequence = other.getSequence();
      if (this$sequence == null ? other$sequence == null : this$sequence.equals(other$sequence)) {
         Object this$taskId = this.getTaskId();
         Object other$taskId = other.getTaskId();
         if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
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
      return other instanceof MesBuildingTaskProcessSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sequence = this.getSequence();
      result = result * 59 + ($sequence == null ? 43 : $sequence.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   public static class MesBuildingTaskProcessSummaryDTOBuilder {
      private Integer sequence;
      private Long taskId;
      private Long processId;
      private Integer quantity;

      MesBuildingTaskProcessSummaryDTOBuilder() {
      }

      @JsonProperty("sequence")
      public MesBuildingTaskProcessSummaryDTO.MesBuildingTaskProcessSummaryDTOBuilder sequence(final Integer sequence) {
         this.sequence = sequence;
         return this;
      }

      @JsonProperty("taskId")
      public MesBuildingTaskProcessSummaryDTO.MesBuildingTaskProcessSummaryDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("processId")
      public MesBuildingTaskProcessSummaryDTO.MesBuildingTaskProcessSummaryDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingTaskProcessSummaryDTO.MesBuildingTaskProcessSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingTaskProcessSummaryDTO build() {
         return new MesBuildingTaskProcessSummaryDTO(this.sequence, this.taskId, this.processId, this.quantity);
      }

      @Override
      public String toString() {
         return "MesBuildingTaskProcessSummaryDTO.MesBuildingTaskProcessSummaryDTOBuilder(sequence="
            + this.sequence
            + ", taskId="
            + this.taskId
            + ", processId="
            + this.processId
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
