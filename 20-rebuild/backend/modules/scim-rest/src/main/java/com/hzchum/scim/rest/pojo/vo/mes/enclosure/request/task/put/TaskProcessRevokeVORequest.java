package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task.put;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TaskProcessRevokeVORequest", description = "")
public class TaskProcessRevokeVORequest {
   @ApiModelProperty(name = "id", notes = "任务列表")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;

   public Long getId() {
      return this.id;
   }

   @JsonProperty("id")
   public TaskProcessRevokeVORequest setId(final Long id) {
      this.id = id;
      return this;
   }

   @Override
   public String toString() {
      return "TaskProcessRevokeVORequest(id=" + this.getId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskProcessRevokeVORequest)) {
         return false;
      }

      TaskProcessRevokeVORequest other = (TaskProcessRevokeVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      return this$id == null ? other$id == null : this$id.equals(other$id);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TaskProcessRevokeVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      return result * 59 + ($id == null ? 43 : $id.hashCode());
   }
}
