package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.scheduling.post;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureMachinePartNestCutTaskSaveVORequest", description = "零件套料完成任务下发请求类")
public class MesEnclosureMachinePartNestCutTaskSaveVORequest {
   @ApiModelProperty(name = "schedulingId", value = "追加的排产id", notes = "追加的排产id")
   @JsonProperty("schedulingId")
   @JSONField(name = "schedulingId")
   @NotNull(message = "排产id不能为空")
   private Long schedulingId;
   @ApiModelProperty(name = "groupsId", value = "生产组id", notes = "生产组id")
   @JsonProperty("groupsId")
   @JSONField(name = "groupsId")
   @NotNull(message = "生产组id不能为空")
   private Long groupsId;
   @ApiModelProperty(name = "drillGroupsId", value = "钻孔生产组id", notes = "钻孔生产组id")
   @JsonProperty("drillGroupsId")
   @JSONField(name = "drillGroupsId")
   private Long drillGroupsId;
   @ApiModelProperty(name = "drillAskCompleteTime", value = "钻孔要求完成日期", notes = "钻孔要求完成日期")
   @JsonProperty("drillAskCompleteTime")
   @JSONField(name = "drillAskCompleteTime")
   private LocalDateTime drillAskCompleteTime;

   public static MesEnclosureMachinePartNestCutTaskSaveVORequest.MesEnclosureMachinePartNestCutTaskSaveVORequestBuilder builder() {
      return new MesEnclosureMachinePartNestCutTaskSaveVORequest.MesEnclosureMachinePartNestCutTaskSaveVORequestBuilder();
   }

   public MesEnclosureMachinePartNestCutTaskSaveVORequest(
      final Long schedulingId, final Long groupsId, final Long drillGroupsId, final LocalDateTime drillAskCompleteTime
   ) {
      this.schedulingId = schedulingId;
      this.groupsId = groupsId;
      this.drillGroupsId = drillGroupsId;
      this.drillAskCompleteTime = drillAskCompleteTime;
   }

   public MesEnclosureMachinePartNestCutTaskSaveVORequest() {
   }

   public Long getSchedulingId() {
      return this.schedulingId;
   }

   public Long getGroupsId() {
      return this.groupsId;
   }

   public Long getDrillGroupsId() {
      return this.drillGroupsId;
   }

   public LocalDateTime getDrillAskCompleteTime() {
      return this.drillAskCompleteTime;
   }

   @JsonProperty("schedulingId")
   public MesEnclosureMachinePartNestCutTaskSaveVORequest setSchedulingId(final Long schedulingId) {
      this.schedulingId = schedulingId;
      return this;
   }

   @JsonProperty("groupsId")
   public MesEnclosureMachinePartNestCutTaskSaveVORequest setGroupsId(final Long groupsId) {
      this.groupsId = groupsId;
      return this;
   }

   @JsonProperty("drillGroupsId")
   public MesEnclosureMachinePartNestCutTaskSaveVORequest setDrillGroupsId(final Long drillGroupsId) {
      this.drillGroupsId = drillGroupsId;
      return this;
   }

   @JsonProperty("drillAskCompleteTime")
   public MesEnclosureMachinePartNestCutTaskSaveVORequest setDrillAskCompleteTime(final LocalDateTime drillAskCompleteTime) {
      this.drillAskCompleteTime = drillAskCompleteTime;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureMachinePartNestCutTaskSaveVORequest)) {
         return false;
      }

      MesEnclosureMachinePartNestCutTaskSaveVORequest other = (MesEnclosureMachinePartNestCutTaskSaveVORequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$schedulingId = this.getSchedulingId();
      Object other$schedulingId = other.getSchedulingId();
      if (this$schedulingId == null ? other$schedulingId == null : this$schedulingId.equals(other$schedulingId)) {
         Object this$groupsId = this.getGroupsId();
         Object other$groupsId = other.getGroupsId();
         if (this$groupsId == null ? other$groupsId == null : this$groupsId.equals(other$groupsId)) {
            Object this$drillGroupsId = this.getDrillGroupsId();
            Object other$drillGroupsId = other.getDrillGroupsId();
            if (this$drillGroupsId == null ? other$drillGroupsId == null : this$drillGroupsId.equals(other$drillGroupsId)) {
               Object this$drillAskCompleteTime = this.getDrillAskCompleteTime();
               Object other$drillAskCompleteTime = other.getDrillAskCompleteTime();
               return this$drillAskCompleteTime == null ? other$drillAskCompleteTime == null : this$drillAskCompleteTime.equals(other$drillAskCompleteTime);
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
      return other instanceof MesEnclosureMachinePartNestCutTaskSaveVORequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $schedulingId = this.getSchedulingId();
      result = result * 59 + ($schedulingId == null ? 43 : $schedulingId.hashCode());
      Object $groupsId = this.getGroupsId();
      result = result * 59 + ($groupsId == null ? 43 : $groupsId.hashCode());
      Object $drillGroupsId = this.getDrillGroupsId();
      result = result * 59 + ($drillGroupsId == null ? 43 : $drillGroupsId.hashCode());
      Object $drillAskCompleteTime = this.getDrillAskCompleteTime();
      return result * 59 + ($drillAskCompleteTime == null ? 43 : $drillAskCompleteTime.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureMachinePartNestCutTaskSaveVORequest(schedulingId="
         + this.getSchedulingId()
         + ", groupsId="
         + this.getGroupsId()
         + ", drillGroupsId="
         + this.getDrillGroupsId()
         + ", drillAskCompleteTime="
         + this.getDrillAskCompleteTime()
         + ")";
   }

   public static class MesEnclosureMachinePartNestCutTaskSaveVORequestBuilder {
      private Long schedulingId;
      private Long groupsId;
      private Long drillGroupsId;
      private LocalDateTime drillAskCompleteTime;

      MesEnclosureMachinePartNestCutTaskSaveVORequestBuilder() {
      }

      @JsonProperty("schedulingId")
      public MesEnclosureMachinePartNestCutTaskSaveVORequest.MesEnclosureMachinePartNestCutTaskSaveVORequestBuilder schedulingId(final Long schedulingId) {
         this.schedulingId = schedulingId;
         return this;
      }

      @JsonProperty("groupsId")
      public MesEnclosureMachinePartNestCutTaskSaveVORequest.MesEnclosureMachinePartNestCutTaskSaveVORequestBuilder groupsId(final Long groupsId) {
         this.groupsId = groupsId;
         return this;
      }

      @JsonProperty("drillGroupsId")
      public MesEnclosureMachinePartNestCutTaskSaveVORequest.MesEnclosureMachinePartNestCutTaskSaveVORequestBuilder drillGroupsId(final Long drillGroupsId) {
         this.drillGroupsId = drillGroupsId;
         return this;
      }

      @JsonProperty("drillAskCompleteTime")
      public MesEnclosureMachinePartNestCutTaskSaveVORequest.MesEnclosureMachinePartNestCutTaskSaveVORequestBuilder drillAskCompleteTime(
         final LocalDateTime drillAskCompleteTime
      ) {
         this.drillAskCompleteTime = drillAskCompleteTime;
         return this;
      }

      public MesEnclosureMachinePartNestCutTaskSaveVORequest build() {
         return new MesEnclosureMachinePartNestCutTaskSaveVORequest(this.schedulingId, this.groupsId, this.drillGroupsId, this.drillAskCompleteTime);
      }

      @Override
      public String toString() {
         return "MesEnclosureMachinePartNestCutTaskSaveVORequest.MesEnclosureMachinePartNestCutTaskSaveVORequestBuilder(schedulingId="
            + this.schedulingId
            + ", groupsId="
            + this.groupsId
            + ", drillGroupsId="
            + this.drillGroupsId
            + ", drillAskCompleteTime="
            + this.drillAskCompleteTime
            + ")";
      }
   }
}
