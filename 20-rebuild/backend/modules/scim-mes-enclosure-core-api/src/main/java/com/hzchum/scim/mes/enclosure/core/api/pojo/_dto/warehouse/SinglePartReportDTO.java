package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.warehouse;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class SinglePartReportDTO {
   @ApiModelProperty(name = "id", value = "上报数据id", notes = "上报数据id")
   @NotNull(message = "上报数据id不能为空")
   private Long id;
   @ApiModelProperty(name = "quantity", value = "上报数量", notes = "上报数量")
   @NotNull(message = "上报数量不能为空")
   private Integer quantity;

   public static SinglePartReportDTO.SinglePartReportDTOBuilder builder() {
      return new SinglePartReportDTO.SinglePartReportDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SinglePartReportDTO)) {
         return false;
      } else {
         SinglePartReportDTO other = (SinglePartReportDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
      return other instanceof SinglePartReportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "SinglePartReportDTO(id=" + this.getId() + ", quantity=" + this.getQuantity() + ")";
   }

   public SinglePartReportDTO(final Long id, final Integer quantity) {
      this.id = id;
      this.quantity = quantity;
   }

   public SinglePartReportDTO() {
   }

   public static class SinglePartReportDTOBuilder {
      private Long id;
      private Integer quantity;

      SinglePartReportDTOBuilder() {
      }

      public SinglePartReportDTO.SinglePartReportDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SinglePartReportDTO.SinglePartReportDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public SinglePartReportDTO build() {
         return new SinglePartReportDTO(this.id, this.quantity);
      }

      @Override
      public String toString() {
         return "SinglePartReportDTO.SinglePartReportDTOBuilder(id=" + this.id + ", quantity=" + this.quantity + ")";
      }
   }
}
