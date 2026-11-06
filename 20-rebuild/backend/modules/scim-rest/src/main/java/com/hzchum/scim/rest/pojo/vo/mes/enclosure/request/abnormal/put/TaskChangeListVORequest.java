package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.abnormal.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "TaskChangeListVORequest", description = "")
public class TaskChangeListVORequest {
   @ApiModelProperty(name = "taskChange", notes = "修改信息", value = "修改信息")
   @JsonProperty("taskChange")
   @JSONField(name = "taskChange")
   private List<TaskChangeVORequest> taskChange;
   @ApiModelProperty(name = "abnormalId", notes = "异常id", value = "异常id")
   @JsonProperty("abnormalId")
   @JSONField(name = "abnormalId")
   private Long abnormalId;

   public static TaskChangeListVORequest.TaskChangeListVORequestBuilder builder() {
      return new TaskChangeListVORequest.TaskChangeListVORequestBuilder();
   }

   public TaskChangeListVORequest(final List<TaskChangeVORequest> taskChange, final Long abnormalId) {
      this.taskChange = taskChange;
      this.abnormalId = abnormalId;
   }

   public TaskChangeListVORequest() {
   }

   public List<TaskChangeVORequest> getTaskChange() {
      return this.taskChange;
   }

   public Long getAbnormalId() {
      return this.abnormalId;
   }

   @JsonProperty("taskChange")
   public TaskChangeListVORequest setTaskChange(final List<TaskChangeVORequest> taskChange) {
      this.taskChange = taskChange;
      return this;
   }

   @JsonProperty("abnormalId")
   public TaskChangeListVORequest setAbnormalId(final Long abnormalId) {
      this.abnormalId = abnormalId;
      return this;
   }

   @Override
   public String toString() {
      return "TaskChangeListVORequest(taskChange=" + this.getTaskChange() + ", abnormalId=" + this.getAbnormalId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof TaskChangeListVORequest)) {
         return false;
      } else {
         TaskChangeListVORequest other = (TaskChangeListVORequest)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$abnormalId = this.getAbnormalId();
            Object other$abnormalId = other.getAbnormalId();
            if (this$abnormalId == null ? other$abnormalId == null : this$abnormalId.equals(other$abnormalId)) {
               Object this$taskChange = this.getTaskChange();
               Object other$taskChange = other.getTaskChange();
               return this$taskChange == null ? other$taskChange == null : this$taskChange.equals(other$taskChange);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TaskChangeListVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $abnormalId = this.getAbnormalId();
      result = result * 59 + ($abnormalId == null ? 43 : $abnormalId.hashCode());
      Object $taskChange = this.getTaskChange();
      return result * 59 + ($taskChange == null ? 43 : $taskChange.hashCode());
   }

   public static class TaskChangeListVORequestBuilder {
      private List<TaskChangeVORequest> taskChange;
      private Long abnormalId;

      TaskChangeListVORequestBuilder() {
      }

      @JsonProperty("taskChange")
      public TaskChangeListVORequest.TaskChangeListVORequestBuilder taskChange(final List<TaskChangeVORequest> taskChange) {
         this.taskChange = taskChange;
         return this;
      }

      @JsonProperty("abnormalId")
      public TaskChangeListVORequest.TaskChangeListVORequestBuilder abnormalId(final Long abnormalId) {
         this.abnormalId = abnormalId;
         return this;
      }

      public TaskChangeListVORequest build() {
         return new TaskChangeListVORequest(this.taskChange, this.abnormalId);
      }

      @Override
      public String toString() {
         return "TaskChangeListVORequest.TaskChangeListVORequestBuilder(taskChange=" + this.taskChange + ", abnormalId=" + this.abnormalId + ")";
      }
   }
}
