package com.hzchum.scim.mes.building.core.api.pojo._dto.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("构件任务基本信息")
public class ArtifactTaskDetailBaseInfo {
   @ApiModelProperty("码号列表")
   private List<Integer> numberList;
   @ApiModelProperty("任务Id")
   private Long taskId;
   @ApiModelProperty(name = "orderNumber", value = "任务工单号", notes = "任务工单号")
   private String orderNumber;
   @ApiModelProperty(name = "schedulingTime", value = "排产时间", notes = "排产时间")
   private LocalDateTime schedulingTime;

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public String getOrderNumber() {
      return this.orderNumber;
   }

   public LocalDateTime getSchedulingTime() {
      return this.schedulingTime;
   }

   public void setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
   }

   public void setTaskId(final Long taskId) {
      this.taskId = taskId;
   }

   public void setOrderNumber(final String orderNumber) {
      this.orderNumber = orderNumber;
   }

   public void setSchedulingTime(final LocalDateTime schedulingTime) {
      this.schedulingTime = schedulingTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactTaskDetailBaseInfo)) {
         return false;
      }

      ArtifactTaskDetailBaseInfo other = (ArtifactTaskDetailBaseInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskId = this.getTaskId();
      Object other$taskId = other.getTaskId();
      if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
         Object this$numberList = this.getNumberList();
         Object other$numberList = other.getNumberList();
         if (this$numberList == null ? other$numberList == null : this$numberList.equals(other$numberList)) {
            Object this$orderNumber = this.getOrderNumber();
            Object other$orderNumber = other.getOrderNumber();
            if (this$orderNumber == null ? other$orderNumber == null : this$orderNumber.equals(other$orderNumber)) {
               Object this$schedulingTime = this.getSchedulingTime();
               Object other$schedulingTime = other.getSchedulingTime();
               return this$schedulingTime == null ? other$schedulingTime == null : this$schedulingTime.equals(other$schedulingTime);
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
      return other instanceof ArtifactTaskDetailBaseInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $numberList = this.getNumberList();
      result = result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
      Object $orderNumber = this.getOrderNumber();
      result = result * 59 + ($orderNumber == null ? 43 : $orderNumber.hashCode());
      Object $schedulingTime = this.getSchedulingTime();
      return result * 59 + ($schedulingTime == null ? 43 : $schedulingTime.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactTaskDetailBaseInfo(numberList="
         + this.getNumberList()
         + ", taskId="
         + this.getTaskId()
         + ", orderNumber="
         + this.getOrderNumber()
         + ", schedulingTime="
         + this.getSchedulingTime()
         + ")";
   }
}
