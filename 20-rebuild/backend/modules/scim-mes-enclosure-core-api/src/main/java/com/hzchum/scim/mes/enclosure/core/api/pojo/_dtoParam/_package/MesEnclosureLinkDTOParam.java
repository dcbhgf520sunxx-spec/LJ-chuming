package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam._package;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "MesEnclosureLinkDTOParam", description = "包 ")
public class MesEnclosureLinkDTOParam {
   @ApiModelProperty(name = "id", notes = "出入库id")
   @NotNull(message = "出入库记录id不能为空")
   private Long id;
   @ApiModelProperty("产品类型")
   @NotNull(message = "产品类型不能为空")
   private Integer productType;
   @ApiModelProperty(name = "quantity", value = "数量")
   @NotNull(message = "数量不能为空")
   private Integer quantity;

   public static MesEnclosureLinkDTOParam.MesEnclosureLinkDTOParamBuilder builder() {
      return new MesEnclosureLinkDTOParam.MesEnclosureLinkDTOParamBuilder();
   }

   public MesEnclosureLinkDTOParam(final Long id, final Integer productType, final Integer quantity) {
      this.id = id;
      this.productType = productType;
      this.quantity = quantity;
   }

   public MesEnclosureLinkDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public MesEnclosureLinkDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesEnclosureLinkDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public MesEnclosureLinkDTOParam setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureLinkDTOParam(id=" + this.getId() + ", productType=" + this.getProductType() + ", quantity=" + this.getQuantity() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureLinkDTOParam)) {
         return false;
      }

      MesEnclosureLinkDTOParam other = (MesEnclosureLinkDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureLinkDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   public static class MesEnclosureLinkDTOParamBuilder {
      private Long id;
      private Integer productType;
      private Integer quantity;

      MesEnclosureLinkDTOParamBuilder() {
      }

      public MesEnclosureLinkDTOParam.MesEnclosureLinkDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureLinkDTOParam.MesEnclosureLinkDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public MesEnclosureLinkDTOParam.MesEnclosureLinkDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesEnclosureLinkDTOParam build() {
         return new MesEnclosureLinkDTOParam(this.id, this.productType, this.quantity);
      }

      @Override
      public String toString() {
         return "MesEnclosureLinkDTOParam.MesEnclosureLinkDTOParamBuilder(id="
            + this.id
            + ", productType="
            + this.productType
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
