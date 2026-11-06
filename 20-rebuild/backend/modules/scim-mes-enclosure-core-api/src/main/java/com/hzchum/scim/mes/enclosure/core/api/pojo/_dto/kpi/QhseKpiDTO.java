package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.kpi;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "QhseDTO", description = "问题上报汇总")
public class QhseKpiDTO {
   @ApiModelProperty(name = "quantity", value = "问题上报数量", notes = "问题上报数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "type", value = "问题类型", notes = "问题类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   private Integer type;
   @ApiModelProperty(name = "name", value = "问题名称", notes = "问题名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   private String name;

   public static QhseKpiDTO.QhseKpiDTOBuilder builder() {
      return new QhseKpiDTO.QhseKpiDTOBuilder();
   }

   public QhseKpiDTO(final Integer quantity, final Integer type, final String name) {
      this.quantity = quantity;
      this.type = type;
      this.name = name;
   }

   public QhseKpiDTO() {
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getType() {
      return this.type;
   }

   public String getName() {
      return this.name;
   }

   @JsonProperty("quantity")
   public QhseKpiDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("type")
   public QhseKpiDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("name")
   public QhseKpiDTO setName(final String name) {
      this.name = name;
      return this;
   }

   @Override
   public String toString() {
      return "QhseKpiDTO(quantity=" + this.getQuantity() + ", type=" + this.getType() + ", name=" + this.getName() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QhseKpiDTO)) {
         return false;
      }

      QhseKpiDTO other = (QhseKpiDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            return this$name == null ? other$name == null : this$name.equals(other$name);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QhseKpiDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      return result * 59 + ($name == null ? 43 : $name.hashCode());
   }

   public static class QhseKpiDTOBuilder {
      private Integer quantity;
      private Integer type;
      private String name;

      QhseKpiDTOBuilder() {
      }

      @JsonProperty("quantity")
      public QhseKpiDTO.QhseKpiDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("type")
      public QhseKpiDTO.QhseKpiDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("name")
      public QhseKpiDTO.QhseKpiDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public QhseKpiDTO build() {
         return new QhseKpiDTO(this.quantity, this.type, this.name);
      }

      @Override
      public String toString() {
         return "QhseKpiDTO.QhseKpiDTOBuilder(quantity=" + this.quantity + ", type=" + this.type + ", name=" + this.name + ")";
      }
   }
}
