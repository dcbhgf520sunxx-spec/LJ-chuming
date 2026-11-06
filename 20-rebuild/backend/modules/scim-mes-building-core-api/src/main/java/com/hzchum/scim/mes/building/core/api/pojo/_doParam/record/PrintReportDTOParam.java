package com.hzchum.scim.mes.building.core.api.pojo._doParam.record;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotNull;

public class PrintReportDTOParam {
   @ApiModelProperty("任务分配id")
   private Long taskId;
   @ApiModelProperty("库存Id")
   private Long warehouseId;
   @ApiModelProperty("材料id")
   private Long materialId;
   @ApiModelProperty("包id")
   private Long packId;
   @ApiModelProperty("打印数量")
   @NotNull(message = "打印数量不能为空")
   private BigDecimal quantity;
   @ApiModelProperty("开始时间")
   @NotNull(message = "开始时间不能为空")
   private LocalDateTime startTime;
   @ApiModelProperty("结束时间")
   @NotNull(message = "结束时间不能为空")
   private LocalDateTime endTime;
   @ApiModelProperty("码号列表")
   private List<Integer> numberList;

   public Long getTaskId() {
      return this.taskId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getMaterialId() {
      return this.materialId;
   }

   public Long getPackId() {
      return this.packId;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   public void setTaskId(final Long taskId) {
      this.taskId = taskId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setMaterialId(final Long materialId) {
      this.materialId = materialId;
   }

   public void setPackId(final Long packId) {
      this.packId = packId;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
   }

   public void setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
   }

   public void setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
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
         Object this$warehouseId = this.getWarehouseId();
         Object other$warehouseId = other.getWarehouseId();
         if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
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
                        if (this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime)) {
                           Object this$numberList = this.getNumberList();
                           Object other$numberList = other.getNumberList();
                           return this$numberList == null ? other$numberList == null : this$numberList.equals(other$numberList);
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
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $materialId = this.getMaterialId();
      result = result * 59 + ($materialId == null ? 43 : $materialId.hashCode());
      Object $packId = this.getPackId();
      result = result * 59 + ($packId == null ? 43 : $packId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
      Object $numberList = this.getNumberList();
      return result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
   }

   @Override
   public String toString() {
      return "PrintReportDTOParam(taskId="
         + this.getTaskId()
         + ", warehouseId="
         + this.getWarehouseId()
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
         + ", numberList="
         + this.getNumberList()
         + ")";
   }
}
