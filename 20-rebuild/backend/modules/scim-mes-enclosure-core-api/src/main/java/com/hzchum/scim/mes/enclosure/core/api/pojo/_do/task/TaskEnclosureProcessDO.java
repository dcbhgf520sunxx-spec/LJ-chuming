package com.hzchum.scim.mes.enclosure.core.api.pojo._do.task;

import com.hzchum.scim.common.core.api.pojo.common.EnclosureBaseInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel("任务围护工序完成类")
public class TaskEnclosureProcessDO extends EnclosureBaseInfo {
   @ApiModelProperty("任务数量")
   private Integer taskQuantity;
   @ApiModelProperty("完成时间")
   private LocalDateTime completeTime;
   @ApiModelProperty("完成数量")
   private Integer completeQuantity;

   public Integer getTaskQuantity() {
      return this.taskQuantity;
   }

   public LocalDateTime getCompleteTime() {
      return this.completeTime;
   }

   public Integer getCompleteQuantity() {
      return this.completeQuantity;
   }

   public void setTaskQuantity(final Integer taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   public void setCompleteTime(final LocalDateTime completeTime) {
      this.completeTime = completeTime;
   }

   public void setCompleteQuantity(final Integer completeQuantity) {
      this.completeQuantity = completeQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskEnclosureProcessDO)) {
         return false;
      }

      TaskEnclosureProcessDO other = (TaskEnclosureProcessDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskQuantity = this.getTaskQuantity();
      Object other$taskQuantity = other.getTaskQuantity();
      if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
         Object this$completeQuantity = this.getCompleteQuantity();
         Object other$completeQuantity = other.getCompleteQuantity();
         if (this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity)) {
            Object this$completeTime = this.getCompleteTime();
            Object other$completeTime = other.getCompleteTime();
            return this$completeTime == null ? other$completeTime == null : this$completeTime.equals(other$completeTime);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TaskEnclosureProcessDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      result = result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
      Object $completeTime = this.getCompleteTime();
      return result * 59 + ($completeTime == null ? 43 : $completeTime.hashCode());
   }

   @Override
   public String toString() {
      return "TaskEnclosureProcessDO(taskQuantity="
         + this.getTaskQuantity()
         + ", completeTime="
         + this.getCompleteTime()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ")";
   }
}
