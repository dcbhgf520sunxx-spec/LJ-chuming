package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task.MesEnclosureTaskDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;

@ApiModel(value = "TaskSaveVORequest", description = "")
public class TaskSaveVORequest {
   @ApiModelProperty(name = "taskList", notes = "任务列表")
   @JsonProperty("taskList")
   @JSONField(name = "taskList")
   @Valid
   private List<MesEnclosureTaskDTOParam> taskList;

   public List<MesEnclosureTaskDTOParam> getTaskList() {
      return this.taskList;
   }

   @JsonProperty("taskList")
   public TaskSaveVORequest setTaskList(final List<MesEnclosureTaskDTOParam> taskList) {
      this.taskList = taskList;
      return this;
   }

   @Override
   public String toString() {
      return "TaskSaveVORequest(taskList=" + this.getTaskList() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskSaveVORequest)) {
         return false;
      }

      TaskSaveVORequest other = (TaskSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskList = this.getTaskList();
      Object other$taskList = other.getTaskList();
      return this$taskList == null ? other$taskList == null : this$taskList.equals(other$taskList);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TaskSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskList = this.getTaskList();
      return result * 59 + ($taskList == null ? 43 : $taskList.hashCode());
   }
}
