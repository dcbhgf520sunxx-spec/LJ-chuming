package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.qhse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QhseDetailsDTO", description = "问题上报详情")
public class QhseDetailsDTO {
   @ApiModelProperty(name = "month", value = "月份", notes = "月份")
   @JsonProperty("month")
   @JSONField(name = "month")
   private String month;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;

   public static QhseDetailsDTO.QhseDetailsDTOBuilder builder() {
      return new QhseDetailsDTO.QhseDetailsDTOBuilder();
   }

   public QhseDetailsDTO(final String month, final Integer quantity) {
      this.month = month;
      this.quantity = quantity;
   }

   public QhseDetailsDTO() {
   }

   public String getMonth() {
      return this.month;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("month")
   public QhseDetailsDTO setMonth(final String month) {
      this.month = month;
      return this;
   }

   @JsonProperty("quantity")
   public QhseDetailsDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "QhseDetailsDTO(month=" + this.getMonth() + ", quantity=" + this.getQuantity() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof QhseDetailsDTO)) {
         return false;
      } else {
         QhseDetailsDTO other = (QhseDetailsDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$month = this.getMonth();
               Object other$month = other.getMonth();
               return this$month == null ? other$month == null : this$month.equals(other$month);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QhseDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $month = this.getMonth();
      return result * 59 + ($month == null ? 43 : $month.hashCode());
   }

   public static class QhseDetailsDTOBuilder {
      private String month;
      private Integer quantity;

      QhseDetailsDTOBuilder() {
      }

      @JsonProperty("month")
      public QhseDetailsDTO.QhseDetailsDTOBuilder month(final String month) {
         this.month = month;
         return this;
      }

      @JsonProperty("quantity")
      public QhseDetailsDTO.QhseDetailsDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public QhseDetailsDTO build() {
         return new QhseDetailsDTO(this.month, this.quantity);
      }

      @Override
      public String toString() {
         return "QhseDetailsDTO.QhseDetailsDTOBuilder(month=" + this.month + ", quantity=" + this.quantity + ")";
      }
   }
}
