package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.task;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class OrderTaskAndCompleteLengthDTO {
   @ApiModelProperty(name = "id", value = "区域id")
   private Long id;
   @ApiModelProperty(name = "taskLength", value = "任务量")
   private BigDecimal taskLength;
   @ApiModelProperty(name = "competeLength", value = "完成量")
   private BigDecimal competeLength;

   public static OrderTaskAndCompleteLengthDTO.OrderTaskAndCompleteLengthDTOBuilder builder() {
      return new OrderTaskAndCompleteLengthDTO.OrderTaskAndCompleteLengthDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getTaskLength() {
      return this.taskLength;
   }

   public BigDecimal getCompeteLength() {
      return this.competeLength;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setTaskLength(final BigDecimal taskLength) {
      this.taskLength = taskLength;
   }

   public void setCompeteLength(final BigDecimal competeLength) {
      this.competeLength = competeLength;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OrderTaskAndCompleteLengthDTO)) {
         return false;
      }

      OrderTaskAndCompleteLengthDTO other = (OrderTaskAndCompleteLengthDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$taskLength = this.getTaskLength();
         Object other$taskLength = other.getTaskLength();
         if (this$taskLength == null ? other$taskLength == null : this$taskLength.equals(other$taskLength)) {
            Object this$competeLength = this.getCompeteLength();
            Object other$competeLength = other.getCompeteLength();
            return this$competeLength == null ? other$competeLength == null : this$competeLength.equals(other$competeLength);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OrderTaskAndCompleteLengthDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $taskLength = this.getTaskLength();
      result = result * 59 + ($taskLength == null ? 43 : $taskLength.hashCode());
      Object $competeLength = this.getCompeteLength();
      return result * 59 + ($competeLength == null ? 43 : $competeLength.hashCode());
   }

   @Override
   public String toString() {
      return "OrderTaskAndCompleteLengthDTO(id=" + this.getId() + ", taskLength=" + this.getTaskLength() + ", competeLength=" + this.getCompeteLength() + ")";
   }

   public OrderTaskAndCompleteLengthDTO(final Long id, final BigDecimal taskLength, final BigDecimal competeLength) {
      this.id = id;
      this.taskLength = taskLength;
      this.competeLength = competeLength;
   }

   public OrderTaskAndCompleteLengthDTO() {
   }

   public static class OrderTaskAndCompleteLengthDTOBuilder {
      private Long id;
      private BigDecimal taskLength;
      private BigDecimal competeLength;

      OrderTaskAndCompleteLengthDTOBuilder() {
      }

      public OrderTaskAndCompleteLengthDTO.OrderTaskAndCompleteLengthDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public OrderTaskAndCompleteLengthDTO.OrderTaskAndCompleteLengthDTOBuilder taskLength(final BigDecimal taskLength) {
         this.taskLength = taskLength;
         return this;
      }

      public OrderTaskAndCompleteLengthDTO.OrderTaskAndCompleteLengthDTOBuilder competeLength(final BigDecimal competeLength) {
         this.competeLength = competeLength;
         return this;
      }

      public OrderTaskAndCompleteLengthDTO build() {
         return new OrderTaskAndCompleteLengthDTO(this.id, this.taskLength, this.competeLength);
      }

      @Override
      public String toString() {
         return "OrderTaskAndCompleteLengthDTO.OrderTaskAndCompleteLengthDTOBuilder(id="
            + this.id
            + ", taskLength="
            + this.taskLength
            + ", competeLength="
            + this.competeLength
            + ")";
      }
   }
}
