package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

public class PrintDTO {
   private Long taskId;
   private Integer quantity;

   public static PrintDTO.PrintDTOBuilder builder() {
      return new PrintDTO.PrintDTOBuilder();
   }

   public PrintDTO(final Long taskId, final Integer quantity) {
      this.taskId = taskId;
      this.quantity = quantity;
   }

   public PrintDTO() {
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setTaskId(final Long taskId) {
      this.taskId = taskId;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof PrintDTO)) {
         return false;
      } else {
         PrintDTO other = (PrintDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$taskId = this.getTaskId();
            Object other$taskId = other.getTaskId();
            if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof PrintDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "PrintDTO(taskId=" + this.getTaskId() + ", quantity=" + this.getQuantity() + ")";
   }

   public static class PrintDTOBuilder {
      private Long taskId;
      private Integer quantity;

      PrintDTOBuilder() {
      }

      public PrintDTO.PrintDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public PrintDTO.PrintDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public PrintDTO build() {
         return new PrintDTO(this.taskId, this.quantity);
      }

      @Override
      public String toString() {
         return "PrintDTO.PrintDTOBuilder(taskId=" + this.taskId + ", quantity=" + this.quantity + ")";
      }
   }
}
