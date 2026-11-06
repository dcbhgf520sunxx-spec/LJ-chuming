package com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

public class PrintDTO {
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "printQuantity", value = "打印数量", notes = "打印数量")
   @NotNull(message = "打印数量不能为空")
   private Integer printQuantity;
   @ApiModelProperty(name = "number", value = "一物一码号", notes = "一物一码号")
   private List<Integer> numberList;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   private Long workshopId;
   @ApiModelProperty(name = "taskId", value = "任务id", notes = "任务id")
   private Long taskId;

   public static PrintDTO.PrintDTOBuilder builder() {
      return new PrintDTO.PrintDTOBuilder();
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getPrintQuantity() {
      return this.printQuantity;
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

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PrintDTO)) {
         return false;
      }

      PrintDTO other = (PrintDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$printQuantity = this.getPrintQuantity();
         Object other$printQuantity = other.getPrintQuantity();
         if (this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$taskId = this.getTaskId();
               Object other$taskId = other.getTaskId();
               if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PrintDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $numberList = this.getNumberList();
      return result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
   }

   @Override
   public String toString() {
      return "PrintDTO(productId="
         + this.getProductId()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", numberList="
         + this.getNumberList()
         + ", workshopId="
         + this.getWorkshopId()
         + ", taskId="
         + this.getTaskId()
         + ")";
   }

   public PrintDTO(final Long productId, final Integer printQuantity, final List<Integer> numberList, final Long workshopId, final Long taskId) {
      this.productId = productId;
      this.printQuantity = printQuantity;
      this.numberList = numberList;
      this.workshopId = workshopId;
      this.taskId = taskId;
   }

   public PrintDTO() {
   }

   public static class PrintDTOBuilder {
      private Long productId;
      private Integer printQuantity;
      private List<Integer> numberList;
      private Long workshopId;
      private Long taskId;

      PrintDTOBuilder() {
      }

      public PrintDTO.PrintDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public PrintDTO.PrintDTOBuilder printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      public PrintDTO.PrintDTOBuilder numberList(final List<Integer> numberList) {
         this.numberList = numberList;
         return this;
      }

      public PrintDTO.PrintDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public PrintDTO.PrintDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public PrintDTO build() {
         return new PrintDTO(this.productId, this.printQuantity, this.numberList, this.workshopId, this.taskId);
      }

      @Override
      public String toString() {
         return "PrintDTO.PrintDTOBuilder(productId="
            + this.productId
            + ", printQuantity="
            + this.printQuantity
            + ", numberList="
            + this.numberList
            + ", workshopId="
            + this.workshopId
            + ", taskId="
            + this.taskId
            + ")";
      }
   }
}
