package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.scheduling;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesEnclosurePartCheckDrillDTOParam", description = "零件验证排产请求类")
public class MesEnclosurePartCheckDrillDTOParam {
   @ApiModelProperty(name = "id", value = "零件id", notes = "零件id")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;

   public static MesEnclosurePartCheckDrillDTOParam.MesEnclosurePartCheckDrillDTOParamBuilder builder() {
      return new MesEnclosurePartCheckDrillDTOParam.MesEnclosurePartCheckDrillDTOParamBuilder();
   }

   public MesEnclosurePartCheckDrillDTOParam(final Long id, final Integer quantity) {
      this.id = id;
      this.quantity = quantity;
   }

   public MesEnclosurePartCheckDrillDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   @JsonProperty("id")
   public MesEnclosurePartCheckDrillDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("quantity")
   public MesEnclosurePartCheckDrillDTOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesEnclosurePartCheckDrillDTOParam)) {
         return false;
      } else {
         MesEnclosurePartCheckDrillDTOParam other = (MesEnclosurePartCheckDrillDTOParam)o;
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
      return other instanceof MesEnclosurePartCheckDrillDTOParam;
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
      return "MesEnclosurePartCheckDrillDTOParam(id=" + this.getId() + ", quantity=" + this.getQuantity() + ")";
   }

   public static class MesEnclosurePartCheckDrillDTOParamBuilder {
      private Long id;
      private Integer quantity;

      MesEnclosurePartCheckDrillDTOParamBuilder() {
      }

      @JsonProperty("id")
      public MesEnclosurePartCheckDrillDTOParam.MesEnclosurePartCheckDrillDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("quantity")
      public MesEnclosurePartCheckDrillDTOParam.MesEnclosurePartCheckDrillDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesEnclosurePartCheckDrillDTOParam build() {
         return new MesEnclosurePartCheckDrillDTOParam(this.id, this.quantity);
      }

      @Override
      public String toString() {
         return "MesEnclosurePartCheckDrillDTOParam.MesEnclosurePartCheckDrillDTOParamBuilder(id=" + this.id + ", quantity=" + this.quantity + ")";
      }
   }
}
