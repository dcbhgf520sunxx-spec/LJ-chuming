package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("MesBuildingCalcuDTOParam")
public class MesBuildingCalcuDTOParam {
   @ApiModelProperty(name = "id", notes = "出入库id")
   @NotNull(message = "出入库记录id不能为空")
   private Long id;
   @ApiModelProperty(name = "quantity", value = "数量")
   @NotNull(message = "数量不能为空")
   private Integer quantity;

   public static MesBuildingCalcuDTOParam.MesBuildingCalcuDTOParamBuilder builder() {
      return new MesBuildingCalcuDTOParam.MesBuildingCalcuDTOParamBuilder();
   }

   public MesBuildingCalcuDTOParam(final Long id, final Integer quantity) {
      this.id = id;
      this.quantity = quantity;
   }

   public MesBuildingCalcuDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public MesBuildingCalcuDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingCalcuDTOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingCalcuDTOParam(id=" + this.getId() + ", quantity=" + this.getQuantity() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MesBuildingCalcuDTOParam)) {
         return false;
      } else {
         MesBuildingCalcuDTOParam other = (MesBuildingCalcuDTOParam)o;
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
      return other instanceof MesBuildingCalcuDTOParam;
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

   public static class MesBuildingCalcuDTOParamBuilder {
      private Long id;
      private Integer quantity;

      MesBuildingCalcuDTOParamBuilder() {
      }

      public MesBuildingCalcuDTOParam.MesBuildingCalcuDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingCalcuDTOParam.MesBuildingCalcuDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingCalcuDTOParam build() {
         return new MesBuildingCalcuDTOParam(this.id, this.quantity);
      }

      @Override
      public String toString() {
         return "MesBuildingCalcuDTOParam.MesBuildingCalcuDTOParamBuilder(id=" + this.id + ", quantity=" + this.quantity + ")";
      }
   }
}
