package com.hzchum.scim.mes.building.core.api.pojo._dto.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "app工序看板-质量事件分析")
public class ProcessKanBanQhseDTO {
   @ApiModelProperty("问题类型名称")
   private String qhseTypeName;
   @ApiModelProperty("问题数量")
   private Integer quantity;

   public static ProcessKanBanQhseDTO.ProcessKanBanQhseDTOBuilder builder() {
      return new ProcessKanBanQhseDTO.ProcessKanBanQhseDTOBuilder();
   }

   public ProcessKanBanQhseDTO(final String qhseTypeName, final Integer quantity) {
      this.qhseTypeName = qhseTypeName;
      this.quantity = quantity;
   }

   public ProcessKanBanQhseDTO() {
   }

   public String getQhseTypeName() {
      return this.qhseTypeName;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public ProcessKanBanQhseDTO setQhseTypeName(final String qhseTypeName) {
      this.qhseTypeName = qhseTypeName;
      return this;
   }

   public ProcessKanBanQhseDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessKanBanQhseDTO(qhseTypeName=" + this.getQhseTypeName() + ", quantity=" + this.getQuantity() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProcessKanBanQhseDTO)) {
         return false;
      } else {
         ProcessKanBanQhseDTO other = (ProcessKanBanQhseDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$qhseTypeName = this.getQhseTypeName();
               Object other$qhseTypeName = other.getQhseTypeName();
               return this$qhseTypeName == null ? other$qhseTypeName == null : this$qhseTypeName.equals(other$qhseTypeName);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProcessKanBanQhseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $qhseTypeName = this.getQhseTypeName();
      return result * 59 + ($qhseTypeName == null ? 43 : $qhseTypeName.hashCode());
   }

   public static class ProcessKanBanQhseDTOBuilder {
      private String qhseTypeName;
      private Integer quantity;

      ProcessKanBanQhseDTOBuilder() {
      }

      public ProcessKanBanQhseDTO.ProcessKanBanQhseDTOBuilder qhseTypeName(final String qhseTypeName) {
         this.qhseTypeName = qhseTypeName;
         return this;
      }

      public ProcessKanBanQhseDTO.ProcessKanBanQhseDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProcessKanBanQhseDTO build() {
         return new ProcessKanBanQhseDTO(this.qhseTypeName, this.quantity);
      }

      @Override
      public String toString() {
         return "ProcessKanBanQhseDTO.ProcessKanBanQhseDTOBuilder(qhseTypeName=" + this.qhseTypeName + ", quantity=" + this.quantity + ")";
      }
   }
}
