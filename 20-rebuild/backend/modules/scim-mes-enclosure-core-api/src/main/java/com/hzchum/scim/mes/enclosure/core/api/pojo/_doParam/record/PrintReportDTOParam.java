package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.record;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

public class PrintReportDTOParam {
   @ApiModelProperty("任务分配id")
   private Long taskId;
   @ApiModelProperty("材料id")
   private Long materialId;
   @ApiModelProperty("包id")
   private Long packId;
   @ApiModelProperty("打印数量")
   @NotNull(message = "打印数量不能为空")
   @Min(value = 1L, message = "打印数量必须大于0")
   private Integer quantity;
   @ApiModelProperty("开始时间")
   @NotNull(message = "开始时间不能为空")
   private LocalDateTime startTime;
   @ApiModelProperty("结束时间")
   @NotNull(message = "结束时间不能为空")
   private LocalDateTime endTime;

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getMaterialId() {
      return this.materialId;
   }

   public Long getPackId() {
      return this.packId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public void setTaskId(final Long taskId) {
      this.taskId = taskId;
   }

   public void setMaterialId(final Long materialId) {
      this.materialId = materialId;
   }

   public void setPackId(final Long packId) {
      this.packId = packId;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
   }

   public void setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PrintReportDTOParam)) {
         return false;
      }

      PrintReportDTOParam other = (PrintReportDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$taskId = this.getTaskId();
      Object other$taskId = other.getTaskId();
      if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
         Object this$materialId = this.getMaterialId();
         Object other$materialId = other.getMaterialId();
         if (this$materialId == null ? other$materialId == null : this$materialId.equals(other$materialId)) {
            Object this$packId = this.getPackId();
            Object other$packId = other.getPackId();
            if (this$packId == null ? other$packId == null : this$packId.equals(other$packId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$startTime = this.getStartTime();
                  Object other$startTime = other.getStartTime();
                  if (this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime)) {
                     Object this$endTime = this.getEndTime();
                     Object other$endTime = other.getEndTime();
                     return this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PrintReportDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $materialId = this.getMaterialId();
      result = result * 59 + ($materialId == null ? 43 : $materialId.hashCode());
      Object $packId = this.getPackId();
      result = result * 59 + ($packId == null ? 43 : $packId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      return result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
   }

   @Override
   public String toString() {
      return "PrintReportDTOParam(taskId="
         + this.getTaskId()
         + ", materialId="
         + this.getMaterialId()
         + ", packId="
         + this.getPackId()
         + ", quantity="
         + this.getQuantity()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ")";
   }
}
