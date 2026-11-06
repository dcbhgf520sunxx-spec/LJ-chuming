package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ProcessAndQuantityDTO", description = "每道工序可操作数量详情")
public class TaskProcessAndQuantityDTO {
   @ApiModelProperty(name = "processAndQuantitys", value = "工序处理数量详情")
   @JsonProperty("processAndQuantitys")
   @JSONField(name = "processAndQuantitys")
   private List<ProcessAndQuantityDTO> processAndQuantitys;
   @ApiModelProperty(name = "taskId", notes = "taskId")
   @JsonProperty("taskId")
   @JSONField(name = "taskId")
   private Long taskId;

   public static TaskProcessAndQuantityDTO.TaskProcessAndQuantityDTOBuilder builder() {
      return new TaskProcessAndQuantityDTO.TaskProcessAndQuantityDTOBuilder();
   }

   public TaskProcessAndQuantityDTO() {
   }

   public TaskProcessAndQuantityDTO(final List<ProcessAndQuantityDTO> processAndQuantitys, final Long taskId) {
      this.processAndQuantitys = processAndQuantitys;
      this.taskId = taskId;
   }

   public List<ProcessAndQuantityDTO> getProcessAndQuantitys() {
      return this.processAndQuantitys;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   @JsonProperty("processAndQuantitys")
   public TaskProcessAndQuantityDTO setProcessAndQuantitys(final List<ProcessAndQuantityDTO> processAndQuantitys) {
      this.processAndQuantitys = processAndQuantitys;
      return this;
   }

   @JsonProperty("taskId")
   public TaskProcessAndQuantityDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   @Override
   public String toString() {
      return "TaskProcessAndQuantityDTO(processAndQuantitys=" + this.getProcessAndQuantitys() + ", taskId=" + this.getTaskId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TaskProcessAndQuantityDTO)) {
         return false;
      } else {
         TaskProcessAndQuantityDTO other = (TaskProcessAndQuantityDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$taskId = this.getTaskId();
            Object other$taskId = other.getTaskId();
            if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
               Object this$processAndQuantitys = this.getProcessAndQuantitys();
               Object other$processAndQuantitys = other.getProcessAndQuantitys();
               return this$processAndQuantitys == null ? other$processAndQuantitys == null : this$processAndQuantitys.equals(other$processAndQuantitys);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TaskProcessAndQuantityDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $processAndQuantitys = this.getProcessAndQuantitys();
      return result * 59 + ($processAndQuantitys == null ? 43 : $processAndQuantitys.hashCode());
   }

   public static class TaskProcessAndQuantityDTOBuilder {
      private List<ProcessAndQuantityDTO> processAndQuantitys;
      private Long taskId;

      TaskProcessAndQuantityDTOBuilder() {
      }

      @JsonProperty("processAndQuantitys")
      public TaskProcessAndQuantityDTO.TaskProcessAndQuantityDTOBuilder processAndQuantitys(final List<ProcessAndQuantityDTO> processAndQuantitys) {
         this.processAndQuantitys = processAndQuantitys;
         return this;
      }

      @JsonProperty("taskId")
      public TaskProcessAndQuantityDTO.TaskProcessAndQuantityDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public TaskProcessAndQuantityDTO build() {
         return new TaskProcessAndQuantityDTO(this.processAndQuantitys, this.taskId);
      }

      @Override
      public String toString() {
         return "TaskProcessAndQuantityDTO.TaskProcessAndQuantityDTOBuilder(processAndQuantitys=" + this.processAndQuantitys + ", taskId=" + this.taskId + ")";
      }
   }
}
