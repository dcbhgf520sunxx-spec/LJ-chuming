package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.warehouse;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class PrintDTO {
   @ApiModelProperty(name = "singId", value = "上报数据id", notes = "上报数据id")
   @NotNull(message = "上报数据id不能为空")
   private Long singId;
   @ApiModelProperty(name = "printQuantity", value = "打印数量", notes = "打印数量")
   @NotNull(message = "打印数量不能为空")
   private Integer printQuantity;

   public static PrintDTO.PrintDTOBuilder builder() {
      return new PrintDTO.PrintDTOBuilder();
   }

   public Long getSingId() {
      return this.singId;
   }

   public Integer getPrintQuantity() {
      return this.printQuantity;
   }

   public void setSingId(final Long singId) {
      this.singId = singId;
   }

   public void setPrintQuantity(final Integer printQuantity) {
      this.printQuantity = printQuantity;
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
            Object this$singId = this.getSingId();
            Object other$singId = other.getSingId();
            if (this$singId == null ? other$singId == null : this$singId.equals(other$singId)) {
               Object this$printQuantity = this.getPrintQuantity();
               Object other$printQuantity = other.getPrintQuantity();
               return this$printQuantity == null ? other$printQuantity == null : this$printQuantity.equals(other$printQuantity);
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
      Object $singId = this.getSingId();
      result = result * 59 + ($singId == null ? 43 : $singId.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      return result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
   }

   @Override
   public String toString() {
      return "PrintDTO(singId=" + this.getSingId() + ", printQuantity=" + this.getPrintQuantity() + ")";
   }

   public PrintDTO(final Long singId, final Integer printQuantity) {
      this.singId = singId;
      this.printQuantity = printQuantity;
   }

   public PrintDTO() {
   }

   public static class PrintDTOBuilder {
      private Long singId;
      private Integer printQuantity;

      PrintDTOBuilder() {
      }

      public PrintDTO.PrintDTOBuilder singId(final Long singId) {
         this.singId = singId;
         return this;
      }

      public PrintDTO.PrintDTOBuilder printQuantity(final Integer printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      public PrintDTO build() {
         return new PrintDTO(this.singId, this.printQuantity);
      }

      @Override
      public String toString() {
         return "PrintDTO.PrintDTOBuilder(singId=" + this.singId + ", printQuantity=" + this.printQuantity + ")";
      }
   }
}
