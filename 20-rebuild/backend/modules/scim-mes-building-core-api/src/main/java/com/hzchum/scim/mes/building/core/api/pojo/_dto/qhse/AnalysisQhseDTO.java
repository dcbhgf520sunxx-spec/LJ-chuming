package com.hzchum.scim.mes.building.core.api.pojo._dto.qhse;

import io.swagger.annotations.ApiModelProperty;

public class AnalysisQhseDTO {
   @ApiModelProperty(name = "quantity", value = "问题上报数量", notes = "问题上报数量")
   private Integer quantity;
   @ApiModelProperty(name = "type", value = "问题原因", notes = "问题原因")
   private String type;

   public static AnalysisQhseDTO.AnalysisQhseDTOBuilder builder() {
      return new AnalysisQhseDTO.AnalysisQhseDTOBuilder();
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getType() {
      return this.type;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setType(final String type) {
      this.type = type;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AnalysisQhseDTO)) {
         return false;
      } else {
         AnalysisQhseDTO other = (AnalysisQhseDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               return this$type == null ? other$type == null : this$type.equals(other$type);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AnalysisQhseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $type = this.getType();
      return result * 59 + ($type == null ? 43 : $type.hashCode());
   }

   @Override
   public String toString() {
      return "AnalysisQhseDTO(quantity=" + this.getQuantity() + ", type=" + this.getType() + ")";
   }

   public AnalysisQhseDTO(final Integer quantity, final String type) {
      this.quantity = quantity;
      this.type = type;
   }

   public AnalysisQhseDTO() {
   }

   public static class AnalysisQhseDTOBuilder {
      private Integer quantity;
      private String type;

      AnalysisQhseDTOBuilder() {
      }

      public AnalysisQhseDTO.AnalysisQhseDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public AnalysisQhseDTO.AnalysisQhseDTOBuilder type(final String type) {
         this.type = type;
         return this;
      }

      public AnalysisQhseDTO build() {
         return new AnalysisQhseDTO(this.quantity, this.type);
      }

      @Override
      public String toString() {
         return "AnalysisQhseDTO.AnalysisQhseDTOBuilder(quantity=" + this.quantity + ", type=" + this.type + ")";
      }
   }
}
