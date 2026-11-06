package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("日期任务完成量")
public class TaskMeteDO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("日期")
   private Integer date;
   @ApiModelProperty("任务量")
   private BigDecimal taskMete;
   @ApiModelProperty("任务数")
   private BigDecimal taskQuantity;
   @ApiModelProperty("完成量")
   private BigDecimal completeMete;
   @ApiModelProperty("完成数")
   private BigDecimal completeQuantity;

   public Integer getDate() {
      return this.date;
   }

   public BigDecimal getTaskMete() {
      return this.taskMete;
   }

   public BigDecimal getTaskQuantity() {
      return this.taskQuantity;
   }

   public BigDecimal getCompleteMete() {
      return this.completeMete;
   }

   public BigDecimal getCompleteQuantity() {
      return this.completeQuantity;
   }

   public void setDate(final Integer date) {
      this.date = date;
   }

   public void setTaskMete(final BigDecimal taskMete) {
      this.taskMete = taskMete;
   }

   public void setTaskQuantity(final BigDecimal taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   public void setCompleteMete(final BigDecimal completeMete) {
      this.completeMete = completeMete;
   }

   public void setCompleteQuantity(final BigDecimal completeQuantity) {
      this.completeQuantity = completeQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TaskMeteDO)) {
         return false;
      }

      TaskMeteDO other = (TaskMeteDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$date = this.getDate();
      Object other$date = other.getDate();
      if (this$date == null ? other$date == null : this$date.equals(other$date)) {
         Object this$taskMete = this.getTaskMete();
         Object other$taskMete = other.getTaskMete();
         if (this$taskMete == null ? other$taskMete == null : this$taskMete.equals(other$taskMete)) {
            Object this$taskQuantity = this.getTaskQuantity();
            Object other$taskQuantity = other.getTaskQuantity();
            if (this$taskQuantity == null ? other$taskQuantity == null : this$taskQuantity.equals(other$taskQuantity)) {
               Object this$completeMete = this.getCompleteMete();
               Object other$completeMete = other.getCompleteMete();
               if (this$completeMete == null ? other$completeMete == null : this$completeMete.equals(other$completeMete)) {
                  Object this$completeQuantity = this.getCompleteQuantity();
                  Object other$completeQuantity = other.getCompleteQuantity();
                  return this$completeQuantity == null ? other$completeQuantity == null : this$completeQuantity.equals(other$completeQuantity);
               } else {
                  return false;
               }
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
      return other instanceof TaskMeteDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $taskMete = this.getTaskMete();
      result = result * 59 + ($taskMete == null ? 43 : $taskMete.hashCode());
      Object $taskQuantity = this.getTaskQuantity();
      result = result * 59 + ($taskQuantity == null ? 43 : $taskQuantity.hashCode());
      Object $completeMete = this.getCompleteMete();
      result = result * 59 + ($completeMete == null ? 43 : $completeMete.hashCode());
      Object $completeQuantity = this.getCompleteQuantity();
      return result * 59 + ($completeQuantity == null ? 43 : $completeQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "TaskMeteDO(date="
         + this.getDate()
         + ", taskMete="
         + this.getTaskMete()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", completeMete="
         + this.getCompleteMete()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ")";
   }
}
