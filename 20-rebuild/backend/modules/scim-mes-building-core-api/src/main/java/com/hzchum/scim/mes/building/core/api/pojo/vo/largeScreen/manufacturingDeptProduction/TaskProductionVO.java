package com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.manufacturingDeptProduction;

import java.math.BigDecimal;

public class TaskProductionVO {
   private String taskId;
   private String askCompleteTime;
   private BigDecimal ton;

   public String getTaskId() {
      return this.taskId;
   }

   public String getAskCompleteTime() {
      return this.askCompleteTime;
   }

   public BigDecimal getTon() {
      return this.ton;
   }

   public void setTaskId(final String taskId) {
      this.taskId = taskId;
   }

   public void setAskCompleteTime(final String askCompleteTime) {
      this.askCompleteTime = askCompleteTime;
   }

   public void setTon(final BigDecimal ton) {
      this.ton = ton;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskProductionVO)) {
         return false;
      }

      TaskProductionVO other = (TaskProductionVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskId = this.getTaskId();
      Object other$taskId = other.getTaskId();
      if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
         Object this$askCompleteTime = this.getAskCompleteTime();
         Object other$askCompleteTime = other.getAskCompleteTime();
         if (this$askCompleteTime == null ? other$askCompleteTime == null : this$askCompleteTime.equals(other$askCompleteTime)) {
            Object this$ton = this.getTon();
            Object other$ton = other.getTon();
            return this$ton == null ? other$ton == null : this$ton.equals(other$ton);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TaskProductionVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $askCompleteTime = this.getAskCompleteTime();
      result = result * 59 + ($askCompleteTime == null ? 43 : $askCompleteTime.hashCode());
      Object $ton = this.getTon();
      return result * 59 + ($ton == null ? 43 : $ton.hashCode());
   }

   @Override
   public String toString() {
      return "TaskProductionVO(taskId=" + this.getTaskId() + ", askCompleteTime=" + this.getAskCompleteTime() + ", ton=" + this.getTon() + ")";
   }
}
