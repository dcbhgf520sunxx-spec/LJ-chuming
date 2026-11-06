package com.hzchum.scim.mes.building.core.api.pojo._dto.nesting;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.scim.common.core.api.pojo.common.MonomerAndArea;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "WorkshopTeamDTO", description = "车间班组对象")
public class TaskOrderDTO {
   @ApiModelProperty(name = "taskOrderId", value = "任务工单号", notes = "任务工单号")
   @JsonProperty("taskOrderId")
   @JSONField(name = "taskOrderId")
   private String taskOrderId;
   @ApiModelProperty(name = "orderNumber", value = "任务工单号", notes = "任务工单号")
   @JsonProperty("orderNumber")
   @JSONField(name = "orderNumber")
   private String orderNumber;
   @ApiModelProperty(name = "单体区域List")
   private List<MonomerAndArea> monomerAndAreaList;

   public static TaskOrderDTO.TaskOrderDTOBuilder builder() {
      return new TaskOrderDTO.TaskOrderDTOBuilder();
   }

   public TaskOrderDTO(final String taskOrderId, final String orderNumber, final List<MonomerAndArea> monomerAndAreaList) {
      this.taskOrderId = taskOrderId;
      this.orderNumber = orderNumber;
      this.monomerAndAreaList = monomerAndAreaList;
   }

   public TaskOrderDTO() {
   }

   public String getTaskOrderId() {
      return this.taskOrderId;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public List<MonomerAndArea> getMonomerAndAreaList() {
      return this.monomerAndAreaList;
   }

   @JsonProperty("taskOrderId")
   public TaskOrderDTO setTaskOrderId(final String taskOrderId) {
      this.taskOrderId = taskOrderId;
      return this;
   }

   @JsonProperty("orderNumber")
   public TaskOrderDTO setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
      return this;
   }

   public TaskOrderDTO setMonomerAndAreaList(final List<MonomerAndArea> monomerAndAreaList) {
      this.monomerAndAreaList = monomerAndAreaList;
      return this;
   }

   @Override
   public String toString() {
      return "TaskOrderDTO(taskOrderId="
         + this.getTaskOrderId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", monomerAndAreaList="
         + this.getMonomerAndAreaList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskOrderDTO)) {
         return false;
      }

      TaskOrderDTO other = (TaskOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskOrderId = this.getTaskOrderId();
      Object other$taskOrderId = other.getTaskOrderId();
      if (this$taskOrderId == null ? other$taskOrderId == null : this$taskOrderId.equals(other$taskOrderId)) {
         Object this$orderNumber = this.getOrderNumber();
         Object other$orderNumber = other.getOrderNumber();
         if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
            Object this$monomerAndAreaList = this.getMonomerAndAreaList();
            Object other$monomerAndAreaList = other.getMonomerAndAreaList();
            return this$monomerAndAreaList == null ? other$monomerAndAreaList == null : this$monomerAndAreaList.equals(other$monomerAndAreaList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TaskOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskOrderId = this.getTaskOrderId();
      result = result * 59 + ($taskOrderId == null ? 43 : $taskOrderId.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $monomerAndAreaList = this.getMonomerAndAreaList();
      return result * 59 + ($monomerAndAreaList == null ? 43 : $monomerAndAreaList.hashCode());
   }

   public static class TaskOrderDTOBuilder {
      private String taskOrderId;
      private String orderNumber;
      private List<MonomerAndArea> monomerAndAreaList;

      TaskOrderDTOBuilder() {
      }

      @JsonProperty("taskOrderId")
      public TaskOrderDTO.TaskOrderDTOBuilder taskOrderId(final String taskOrderId) {
         this.taskOrderId = taskOrderId;
         return this;
      }

      @JsonProperty("orderNumber")
      public TaskOrderDTO.TaskOrderDTOBuilder orderNumber(final String orderNumber) {
         this.orderNumber = orderNumber;
         return this;
      }

      public TaskOrderDTO.TaskOrderDTOBuilder monomerAndAreaList(final List<MonomerAndArea> monomerAndAreaList) {
         this.monomerAndAreaList = monomerAndAreaList;
         return this;
      }

      public TaskOrderDTO build() {
         return new TaskOrderDTO(this.taskOrderId, this.orderNumber, this.monomerAndAreaList);
      }

      @Override
      public String toString() {
         return "TaskOrderDTO.TaskOrderDTOBuilder(taskOrderId="
            + this.taskOrderId
            + ", orderNumber="
            + this.orderNumber
            + ", monomerAndAreaList="
            + this.monomerAndAreaList
            + ")";
      }
   }
}
