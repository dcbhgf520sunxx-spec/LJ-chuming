package com.hzchum.scim.mes.building.core.api.pojo._dto.team;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "批量打印DTO", description = "")
public class BatchPrintDTO {
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;
   @ApiModelProperty(name = "taskProcessId", value = "任务工序id", notes = "任务工序id")
   @JsonProperty("taskProcessId")
   @JSONField(name = "taskProcessId")
   private Long taskProcessId;
   @ApiModelProperty(name = "numberList", value = "码号列表", notes = "码号列表")
   @JsonProperty("numberList")
   @JSONField(name = "numberList")
   private List<Integer> numberList;

   public static BatchPrintDTO.BatchPrintDTOBuilder builder() {
      return new BatchPrintDTO.BatchPrintDTOBuilder();
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getTaskProcessId() {
      return this.taskProcessId;
   }

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   @JsonProperty("taskId")
   public BatchPrintDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @JsonProperty("taskProcessId")
   public BatchPrintDTO setTaskProcessId(final Long taskProcessId) {
      this.taskProcessId = taskProcessId;
      return this;
   }

   @JsonProperty("numberList")
   public BatchPrintDTO setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
      return this;
   }

   @Override
   public String toString() {
      return "BatchPrintDTO(taskId=" + this.getTaskId() + ", taskProcessId=" + this.getTaskProcessId() + ", numberList=" + this.getNumberList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BatchPrintDTO)) {
         return false;
      }

      BatchPrintDTO other = (BatchPrintDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskId = this.getTaskId();
      Object other$taskId = other.getTaskId();
      if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
         Object this$taskProcessId = this.getTaskProcessId();
         Object other$taskProcessId = other.getTaskProcessId();
         if (this$taskProcessId == null ? other$taskProcessId == null : this$taskProcessId.equals(other$taskProcessId)) {
            Object this$numberList = this.getNumberList();
            Object other$numberList = other.getNumberList();
            return this$numberList == null ? other$numberList == null : this$numberList.equals(other$numberList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BatchPrintDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $taskProcessId = this.getTaskProcessId();
      result = result * 59 + ($taskProcessId == null ? 43 : $taskProcessId.hashCode());
      Object $numberList = this.getNumberList();
      return result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
   }

   public BatchPrintDTO(final Long taskId, final Long taskProcessId, final List<Integer> numberList) {
      this.taskId = taskId;
      this.taskProcessId = taskProcessId;
      this.numberList = numberList;
   }

   public BatchPrintDTO() {
   }

   public static class BatchPrintDTOBuilder {
      private Long taskId;
      private Long taskProcessId;
      private List<Integer> numberList;

      BatchPrintDTOBuilder() {
      }

      @JsonProperty("taskId")
      public BatchPrintDTO.BatchPrintDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      @JsonProperty("taskProcessId")
      public BatchPrintDTO.BatchPrintDTOBuilder taskProcessId(final Long taskProcessId) {
         this.taskProcessId = taskProcessId;
         return this;
      }

      @JsonProperty("numberList")
      public BatchPrintDTO.BatchPrintDTOBuilder numberList(final List<Integer> numberList) {
         this.numberList = numberList;
         return this;
      }

      public BatchPrintDTO build() {
         return new BatchPrintDTO(this.taskId, this.taskProcessId, this.numberList);
      }

      @Override
      public String toString() {
         return "BatchPrintDTO.BatchPrintDTOBuilder(taskId=" + this.taskId + ", taskProcessId=" + this.taskProcessId + ", numberList=" + this.numberList + ")";
      }
   }
}
