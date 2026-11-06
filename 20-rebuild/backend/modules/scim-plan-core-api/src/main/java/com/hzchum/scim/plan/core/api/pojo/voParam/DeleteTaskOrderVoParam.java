package com.hzchum.scim.plan.core.api.pojo.voParam;

import java.util.List;

public class DeleteTaskOrderVoParam {
   private Long orderId;
   private List<Long> taskIds;

   public Long getOrderId() {
      return this.orderId;
   }

   public List<Long> getTaskIds() {
      return this.taskIds;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setTaskIds(final List<Long> taskIds) {
      this.taskIds = taskIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof DeleteTaskOrderVoParam)) {
         return false;
      } else {
         DeleteTaskOrderVoParam other = (DeleteTaskOrderVoParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$orderId = this.getOrderId();
            Object other$orderId = other.getOrderId();
            if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
               Object this$taskIds = this.getTaskIds();
               Object other$taskIds = other.getTaskIds();
               return this$taskIds == null ? other$taskIds == null : this$taskIds.equals(other$taskIds);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof DeleteTaskOrderVoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $taskIds = this.getTaskIds();
      return result * 59 + ($taskIds == null ? 43 : $taskIds.hashCode());
   }

   @Override
   public String toString() {
      return "DeleteTaskOrderVoParam(orderId=" + this.getOrderId() + ", taskIds=" + this.getTaskIds() + ")";
   }
}
