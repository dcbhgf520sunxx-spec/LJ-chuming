package com.hzchum.scim.rest.pojo.vo.mes.enclosure.request.task;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.task.MesEnclosureSchedulingDTOParam;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureSchedulingSaveVOListRequest对象", description = "")
public class MesEnclosureSchedulingSaveVOListRequest {
   @ApiModelProperty(name = "schedulingList", notes = "schedulingList")
   @JsonProperty("schedulingList")
   @JSONField(name = "schedulingList")
   @Valid
   private List<MesEnclosureSchedulingDTOParam> schedulingList;
   @ApiModelProperty(name = "booleanSaveTask", notes = "booleanSaveTask")
   @JsonProperty("booleanSaveTask")
   @JSONField(name = "booleanSaveTask")
   @NotNull(message = "是否保存任务不能为空")
   private Boolean booleanSaveTask;
   @ApiModelProperty(name = "askCompleteTime", notes = "要求完成日期")
   @JsonProperty("askCompleteTime")
   @JSONField(name = "askCompleteTime")
   private LocalDateTime askCompleteTime;

   public static MesEnclosureSchedulingSaveVOListRequest.MesEnclosureSchedulingSaveVOListRequestBuilder builder() {
      return new MesEnclosureSchedulingSaveVOListRequest.MesEnclosureSchedulingSaveVOListRequestBuilder();
   }

   public MesEnclosureSchedulingSaveVOListRequest() {
   }

   public MesEnclosureSchedulingSaveVOListRequest(
      final List<MesEnclosureSchedulingDTOParam> schedulingList, final Boolean booleanSaveTask, final LocalDateTime askCompleteTime
   ) {
      this.schedulingList = schedulingList;
      this.booleanSaveTask = booleanSaveTask;
      this.askCompleteTime = askCompleteTime;
   }

   public List<MesEnclosureSchedulingDTOParam> getSchedulingList() {
      return this.schedulingList;
   }

   public Boolean getBooleanSaveTask() {
      return this.booleanSaveTask;
   }

   public LocalDateTime getAskCompleteTime() {
      return this.askCompleteTime;
   }

   @JsonProperty("schedulingList")
   public MesEnclosureSchedulingSaveVOListRequest setSchedulingList(final List<MesEnclosureSchedulingDTOParam> schedulingList) {
      this.schedulingList = schedulingList;
      return this;
   }

   @JsonProperty("booleanSaveTask")
   public MesEnclosureSchedulingSaveVOListRequest setBooleanSaveTask(final Boolean booleanSaveTask) {
      this.booleanSaveTask = booleanSaveTask;
      return this;
   }

   @JsonProperty("askCompleteTime")
   public MesEnclosureSchedulingSaveVOListRequest setAskCompleteTime(final LocalDateTime askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureSchedulingSaveVOListRequest(schedulingList="
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

      if (!(o instanceof MesEnclosureSchedulingSaveVOListRequest)) {
         return false;
      }

      MesEnclosureSchedulingSaveVOListRequest other = (MesEnclosureSchedulingSaveVOListRequest)o;
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
      return other instanceof MesEnclosureSchedulingSaveVOListRequest;
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

   public static class MesEnclosureSchedulingSaveVOListRequestBuilder {
      private List<MesEnclosureSchedulingDTOParam> schedulingList;
      private Boolean booleanSaveTask;
      private LocalDateTime askCompleteTime;

      MesEnclosureSchedulingSaveVOListRequestBuilder() {
      }

      @JsonProperty("schedulingList")
      public MesEnclosureSchedulingSaveVOListRequest.MesEnclosureSchedulingSaveVOListRequestBuilder schedulingList(
         final List<MesEnclosureSchedulingDTOParam> schedulingList
      ) {
         this.schedulingList = schedulingList;
         return this;
      }

      @JsonProperty("booleanSaveTask")
      public MesEnclosureSchedulingSaveVOListRequest.MesEnclosureSchedulingSaveVOListRequestBuilder booleanSaveTask(final Boolean booleanSaveTask) {
         this.booleanSaveTask = booleanSaveTask;
         return this;
      }

      @JsonProperty("askCompleteTime")
      public MesEnclosureSchedulingSaveVOListRequest.MesEnclosureSchedulingSaveVOListRequestBuilder askCompleteTime(final LocalDateTime askCompleteTime) {
         this.askCompleteTime = askCompleteTime;
         return this;
      }

      public MesEnclosureSchedulingSaveVOListRequest build() {
         return new MesEnclosureSchedulingSaveVOListRequest(this.schedulingList, this.booleanSaveTask, this.askCompleteTime);
      }

      @Override
      public String toString() {
         return "MesEnclosureSchedulingSaveVOListRequest.MesEnclosureSchedulingSaveVOListRequestBuilder(schedulingList="
            + this.schedulingList
            + ", booleanSaveTask="
            + this.booleanSaveTask
            + ", askCompleteTime="
            + this.askCompleteTime
            + ")";
      }
   }
}
