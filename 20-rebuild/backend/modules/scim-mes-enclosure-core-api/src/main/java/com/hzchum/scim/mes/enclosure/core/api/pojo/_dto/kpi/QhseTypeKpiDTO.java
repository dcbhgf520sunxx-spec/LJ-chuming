package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.kpi;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QhseTypeKpiDTO", description = "问题上报汇总")
public class QhseTypeKpiDTO {
   @ApiModelProperty(name = "quantity", value = "问题上报数量", notes = "问题上报数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "type", value = "问题原因", notes = "问题原因")
   @JsonProperty("type")
   @JSONField(name = "type")
   private String type;

   public static QhseTypeKpiDTO.QhseTypeKpiDTOBuilder builder() {
      return new QhseTypeKpiDTO.QhseTypeKpiDTOBuilder();
   }

   public QhseTypeKpiDTO(final Integer quantity, final String type) {
      this.quantity = quantity;
      this.type = type;
   }

   public QhseTypeKpiDTO() {
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getType() {
      return this.type;
   }

   @JsonProperty("quantity")
   public QhseTypeKpiDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("type")
   public QhseTypeKpiDTO setType(final String type) {
      this.type = type;
      return this;
   }

   @Override
   public String toString() {
      return "QhseTypeKpiDTO(quantity=" + this.getQuantity() + ", type=" + this.getType() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof QhseTypeKpiDTO)) {
         return false;
      } else {
         QhseTypeKpiDTO other = (QhseTypeKpiDTO)o;
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
      return other instanceof QhseTypeKpiDTO;
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

   public static class QhseTypeKpiDTOBuilder {
      private Integer quantity;
      private String type;

      QhseTypeKpiDTOBuilder() {
      }

      @JsonProperty("quantity")
      public QhseTypeKpiDTO.QhseTypeKpiDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("type")
      public QhseTypeKpiDTO.QhseTypeKpiDTOBuilder type(final String type) {
         this.type = type;
         return this;
      }

      public QhseTypeKpiDTO build() {
         return new QhseTypeKpiDTO(this.quantity, this.type);
      }

      @Override
      public String toString() {
         return "QhseTypeKpiDTO.QhseTypeKpiDTOBuilder(quantity=" + this.quantity + ", type=" + this.type + ")";
      }
   }
}
