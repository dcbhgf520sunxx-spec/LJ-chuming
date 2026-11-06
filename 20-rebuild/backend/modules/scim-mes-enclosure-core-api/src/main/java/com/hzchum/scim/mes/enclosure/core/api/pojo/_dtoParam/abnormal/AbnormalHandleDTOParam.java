package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.abnormal;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "AbnormalHandleVORequest", description = "")
public class AbnormalHandleDTOParam {
   @ApiModelProperty(name = "quantity", notes = "任务数量", value = "任务数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "id", notes = "上报id", value = "上报id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;

   public static AbnormalHandleDTOParam.AbnormalHandleDTOParamBuilder builder() {
      return new AbnormalHandleDTOParam.AbnormalHandleDTOParamBuilder();
   }

   public AbnormalHandleDTOParam(final Integer quantity, final Long id) {
      this.quantity = quantity;
      this.id = id;
   }

   public AbnormalHandleDTOParam() {
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getId() {
      return this.id;
   }

   @JsonProperty("quantity")
   public AbnormalHandleDTOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("id")
   public AbnormalHandleDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @Override
   public String toString() {
      return "AbnormalHandleDTOParam(quantity=" + this.getQuantity() + ", id=" + this.getId() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof AbnormalHandleDTOParam)) {
         return false;
      } else {
         AbnormalHandleDTOParam other = (AbnormalHandleDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$id = this.getId();
               Object other$id = other.getId();
               return this$id == null ? other$id == null : this$id.equals(other$id);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AbnormalHandleDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $id = this.getId();
      return result * 59 + ($id == null ? 43 : $id.hashCode());
   }

   public static class AbnormalHandleDTOParamBuilder {
      private Integer quantity;
      private Long id;

      AbnormalHandleDTOParamBuilder() {
      }

      @JsonProperty("quantity")
      public AbnormalHandleDTOParam.AbnormalHandleDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("id")
      public AbnormalHandleDTOParam.AbnormalHandleDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public AbnormalHandleDTOParam build() {
         return new AbnormalHandleDTOParam(this.quantity, this.id);
      }

      @Override
      public String toString() {
         return "AbnormalHandleDTOParam.AbnormalHandleDTOParamBuilder(quantity=" + this.quantity + ", id=" + this.id + ")";
      }
   }
}
