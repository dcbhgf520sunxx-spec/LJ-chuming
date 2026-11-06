package com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class SinglePartReportDTO {
   @ApiModelProperty(name = "productId", value = "上报构件id", notes = "上报构件id")
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "上报数量", notes = "上报数量")
   private Integer quantity;
   @ApiModelProperty(name = "numberList", value = "一物一码编号集合", notes = "一物一码编号集合")
   private List<Integer> numberList;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   private Long workshopId;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   private Long taskId;
   @ApiModelProperty(name = "number", value = "一物一码编号", notes = "一物一码编号")
   private Integer number;

   public static SinglePartReportDTO.SinglePartReportDTOBuilder builder() {
      return new SinglePartReportDTO.SinglePartReportDTOBuilder();
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Integer getNumber() {
      return this.number;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setTaskId(final Long taskId) {
      this.taskId = taskId;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SinglePartReportDTO)) {
         return false;
      }

      SinglePartReportDTO other = (SinglePartReportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$taskId = this.getTaskId();
               Object other$taskId = other.getTaskId();
               if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
                  Object this$number = this.getNumber();
                  Object other$number = other.getNumber();
                  if (this$number == null ? other$number == null : this$number.equals(other$number)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SinglePartReportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $numberList = this.getNumberList();
      return result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
   }

   @Override
   public String toString() {
      return "SinglePartReportDTO(productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", numberList="
         + this.getNumberList()
         + ", workshopId="
         + this.getWorkshopId()
         + ", taskId="
         + this.getTaskId()
         + ", number="
         + this.getNumber()
         + ")";
   }

   public SinglePartReportDTO(
      final Long productId, final Integer quantity, final List<Integer> numberList, final Long workshopId, final Long taskId, final Integer number
   ) {
      this.productId = productId;
      this.quantity = quantity;
      this.numberList = numberList;
      this.workshopId = workshopId;
      this.taskId = taskId;
      this.number = number;
   }

   public SinglePartReportDTO() {
   }

   public static class SinglePartReportDTOBuilder {
      private Long productId;
      private Integer quantity;
      private List<Integer> numberList;
      private Long workshopId;
      private Long taskId;
      private Integer number;

      SinglePartReportDTOBuilder() {
      }

      public SinglePartReportDTO.SinglePartReportDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public SinglePartReportDTO.SinglePartReportDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public SinglePartReportDTO.SinglePartReportDTOBuilder numberList(final List<Integer> numberList) {
         this.numberList = numberList;
         return this;
      }

      public SinglePartReportDTO.SinglePartReportDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public SinglePartReportDTO.SinglePartReportDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public SinglePartReportDTO.SinglePartReportDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public SinglePartReportDTO build() {
         return new SinglePartReportDTO(this.productId, this.quantity, this.numberList, this.workshopId, this.taskId, this.number);
      }

      @Override
      public String toString() {
         return "SinglePartReportDTO.SinglePartReportDTOBuilder(productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", numberList="
            + this.numberList
            + ", workshopId="
            + this.workshopId
            + ", taskId="
            + this.taskId
            + ", number="
            + this.number
            + ")";
      }
   }
}
