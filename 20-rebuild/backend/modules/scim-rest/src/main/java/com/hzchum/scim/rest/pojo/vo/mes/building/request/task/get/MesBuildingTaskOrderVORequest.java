package com.hzchum.scim.rest.pojo.vo.mes.building.request.task.get;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingTaskOrderVORequest", description = "工单")
public class MesBuildingTaskOrderVORequest {
   @ApiModelProperty(name = "taskTypeEnum", value = "任务类型", notes = "任务类型")
   @JsonProperty("taskTypeEnum")
   @JSONField(name = "taskTypeEnum")
   private Integer taskTypeEnum;

   MesBuildingTaskOrderVORequest(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
   }

   public static MesBuildingTaskOrderVORequest.MesBuildingTaskOrderVORequestBuilder builder() {
      return new MesBuildingTaskOrderVORequest.MesBuildingTaskOrderVORequestBuilder();
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   @JsonProperty("taskTypeEnum")
   public MesBuildingTaskOrderVORequest setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingTaskOrderVORequest)) {
         return false;
      }

      MesBuildingTaskOrderVORequest other = (MesBuildingTaskOrderVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskTypeEnum = this.getTaskTypeEnum();
      Object other$taskTypeEnum = other.getTaskTypeEnum();
      return this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingTaskOrderVORequest;
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
      return "MesBuildingTaskOrderVORequest(taskTypeEnum=" + this.getTaskTypeEnum() + ")";
   }

   public static class MesBuildingTaskOrderVORequestBuilder {
      private Integer taskTypeEnum;

      MesBuildingTaskOrderVORequestBuilder() {
      }

      @JsonProperty("taskTypeEnum")
      public MesBuildingTaskOrderVORequest.MesBuildingTaskOrderVORequestBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public MesBuildingTaskOrderVORequest build() {
         return new MesBuildingTaskOrderVORequest(this.taskTypeEnum);
      }

      @Override
      public String toString() {
         return "MesBuildingTaskOrderVORequest.MesBuildingTaskOrderVORequestBuilder(taskTypeEnum=" + this.taskTypeEnum + ")";
      }
   }
}
