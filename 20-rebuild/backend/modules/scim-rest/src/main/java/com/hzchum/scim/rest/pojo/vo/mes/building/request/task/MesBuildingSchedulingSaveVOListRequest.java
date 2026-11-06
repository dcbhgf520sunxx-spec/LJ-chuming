package com.hzchum.scim.rest.pojo.vo.mes.building.request.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.building.core.api.pojo._dtoParam.task.MesBuildingSchedulingDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesBuildingSchedulingSaveVOListRequest对象", description = "")
public class MesBuildingSchedulingSaveVOListRequest {
   @ApiModelProperty(name = "schedulingList", notes = "schedulingList")
   @JsonProperty("schedulingList")
   @JSONField(name = "schedulingList")
   @Valid
   private List<MesBuildingSchedulingDTOParam> schedulingList;
   @ApiModelProperty(name = "booleanSaveTask", notes = "booleanSaveTask")
   @JsonProperty("booleanSaveTask")
   @JSONField(name = "booleanSaveTask")
   @NotNull(message = "是否保存任务不能为空")
   private Boolean booleanSaveTask;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;

   public static MesBuildingSchedulingSaveVOListRequest.MesBuildingSchedulingSaveVOListRequestBuilder builder() {
      return new MesBuildingSchedulingSaveVOListRequest.MesBuildingSchedulingSaveVOListRequestBuilder();
   }

   public MesBuildingSchedulingSaveVOListRequest() {
   }

   public MesBuildingSchedulingSaveVOListRequest(
      final List<MesBuildingSchedulingDTOParam> schedulingList, final Boolean booleanSaveTask, final LocalDateTime askCompleteTime
   ) {
      this.schedulingList = schedulingList;
      this.booleanSaveTask = booleanSaveTask;
      this.askCompleteTime = askCompleteTime;
   }

   public List<MesBuildingSchedulingDTOParam> getSchedulingList() {
      return this.schedulingList;
   }

   public Boolean getBooleanSaveTask() {
      return this.booleanSaveTask;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   @JsonProperty("schedulingList")
   public MesBuildingSchedulingSaveVOListRequest setSchedulingList(final List<MesBuildingSchedulingDTOParam> schedulingList) {
      this.schedulingList = schedulingList;
      return this;
   }

   @JsonProperty("booleanSaveTask")
   public MesBuildingSchedulingSaveVOListRequest setBooleanSaveTask(final Boolean booleanSaveTask) {
      this.booleanSaveTask = booleanSaveTask;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesBuildingSchedulingSaveVOListRequest setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingSchedulingSaveVOListRequest(schedulingList="
         + this.getSchedulingList()
         + ", booleanSaveTask="
         + this.getBooleanSaveTask()
         + ", askCompleteTime="
         + this.getAskCompleteTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingSchedulingSaveVOListRequest)) {
         return false;
      }

      MesBuildingSchedulingSaveVOListRequest other = (MesBuildingSchedulingSaveVOListRequest)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$booleanSaveTask = this.getBooleanSaveTask();
      Object other$booleanSaveTask = other.getBooleanSaveTask();
      if (this$booleanSaveTask == null ? other$booleanSaveTask == null : this$booleanSaveTask.equals(other$booleanSaveTask)) {
         Object this$schedulingList = this.getSchedulingList();
         Object other$schedulingList = other.getSchedulingList();
         if (this$schedulingList == null ? other$schedulingList == null : this$schedulingList.equals(other$schedulingList)) {
            Object this$askCompleteTime = this.getAskCompleteTime();
            Object other$askCompleteTime = other.getAskCompleteTime();
            return this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingSchedulingSaveVOListRequest;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $booleanSaveTask = this.getBooleanSaveTask();
      result = result * 59 + ($booleanSaveTask == null ? 43 : $booleanSaveTask.hashCode());
      Object $schedulingList = this.getSchedulingList();
      result = result * 59 + ($schedulingList == null ? 43 : $schedulingList.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      return result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
   }

   public static class MesBuildingSchedulingSaveVOListRequestBuilder {
      private List<MesBuildingSchedulingDTOParam> schedulingList;
      private Boolean booleanSaveTask;
      private LocalDateTime askCompleteTime;

      MesBuildingSchedulingSaveVOListRequestBuilder() {
      }

      @JsonProperty("schedulingList")
      public MesBuildingSchedulingSaveVOListRequest.MesBuildingSchedulingSaveVOListRequestBuilder schedulingList(
         final List<MesBuildingSchedulingDTOParam> schedulingList
      ) {
         this.schedulingList = schedulingList;
         return this;
      }

      @JsonProperty("booleanSaveTask")
      public MesBuildingSchedulingSaveVOListRequest.MesBuildingSchedulingSaveVOListRequestBuilder booleanSaveTask(final Boolean booleanSaveTask) {
         this.booleanSaveTask = booleanSaveTask;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesBuildingSchedulingSaveVOListRequest.MesBuildingSchedulingSaveVOListRequestBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      public MesBuildingSchedulingSaveVOListRequest build() {
         return new MesBuildingSchedulingSaveVOListRequest(this.schedulingList, this.booleanSaveTask, this.askCompleteTime);
      }

      @Override
      public String toString() {
         return "MesBuildingSchedulingSaveVOListRequest.MesBuildingSchedulingSaveVOListRequestBuilder(schedulingList="
            + this.schedulingList
            + ", booleanSaveTask="
            + this.booleanSaveTask
            + ", askCompleteTime="
            + this.askCompleteTime
            + ")";
      }
   }
}
