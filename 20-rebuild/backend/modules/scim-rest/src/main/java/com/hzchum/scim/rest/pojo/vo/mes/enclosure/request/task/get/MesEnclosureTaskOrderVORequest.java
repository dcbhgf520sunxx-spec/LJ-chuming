package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesEnclosureTaskOrderVORequest", description = "工单")
public class MesEnclosureTaskOrderVORequest {
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;

   MesEnclosureTaskOrderVORequest(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
   }

   public static MesEnclosureTaskOrderVORequest.MesEnclosureTaskOrderVORequestBuilder builder() {
      return new MesEnclosureTaskOrderVORequest.MesEnclosureTaskOrderVORequestBuilder();
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   @JsonProperty("taskTypeEnum")
   public MesEnclosureTaskOrderVORequest setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureTaskOrderVORequest)) {
         return false;
      }

      MesEnclosureTaskOrderVORequest other = (MesEnclosureTaskOrderVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskTypeEnum = this.getTaskTypeEnum();
      Object other$taskTypeEnum = other.getTaskTypeEnum();
      return this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureTaskOrderVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskTypeEnum = this.getTaskTypeEnum();
      return result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureTaskOrderVORequest(taskTypeEnum=" + this.getTaskTypeEnum() + ")";
   }

   public static class MesEnclosureTaskOrderVORequestBuilder {
      private Integer taskTypeEnum;

      MesEnclosureTaskOrderVORequestBuilder() {
      }

      @JsonProperty("taskTypeEnum")
      public MesEnclosureTaskOrderVORequest.MesEnclosureTaskOrderVORequestBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public MesEnclosureTaskOrderVORequest build() {
         return new MesEnclosureTaskOrderVORequest(this.taskTypeEnum);
      }

      @Override
      public String toString() {
         return "MesEnclosureTaskOrderVORequest.MesEnclosureTaskOrderVORequestBuilder(taskTypeEnum=" + this.taskTypeEnum + ")";
      }
   }
}
