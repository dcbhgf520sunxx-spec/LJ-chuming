package com.hzchum.scim.common.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("MesBuildingLinkCommonDTOParam")
public class MesBuildingLinkCommonDTOParam {
   @ApiModelProperty(name = "id", notes = "出入库id")
   private Long id;
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty(name = "quantity", value = "数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "numberList", value = "编号列表")
   private List<Integer> numberList;

   public static MesBuildingLinkCommonDTOParam.MesBuildingLinkCommonDTOParamBuilder builder() {
      return new MesBuildingLinkCommonDTOParam.MesBuildingLinkCommonDTOParamBuilder();
   }

   public MesBuildingLinkCommonDTOParam(final Long id, final Integer productType, final BigDecimal quantity, final List<Integer> numberList) {
      this.id = id;
      this.productType = productType;
      this.quantity = quantity;
      this.numberList = numberList;
   }

   public MesBuildingLinkCommonDTOParam() {
   }

   public Long getId() {
      return this.id;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   public MesBuildingLinkCommonDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingLinkCommonDTOParam setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public MesBuildingLinkCommonDTOParam setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   public MesBuildingLinkCommonDTOParam setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingLinkCommonDTOParam(id="
         + this.getId()
         + ", productType="
         + this.getProductType()
         + ", quantity="
         + this.getQuantity()
         + ", numberList="
         + this.getNumberList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingLinkCommonDTOParam)) {
         return false;
      }

      MesBuildingLinkCommonDTOParam other = (MesBuildingLinkCommonDTOParam)o;
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
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$numberList = this.getNumberList();
               Object other$numberList = other.getNumberList();
               return this$numberList == null ? other$numberList == null : this$numberList.equals(other$numberList);
            } else {
               return false;
            }
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingLinkCommonDTOParam;
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
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $numberList = this.getNumberList();
      return result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
   }

   public static class MesBuildingLinkCommonDTOParamBuilder {
      private Long id;
      private Integer productType;
      private BigDecimal quantity;
      private List<Integer> numberList;

      MesBuildingLinkCommonDTOParamBuilder() {
      }

      public MesBuildingLinkCommonDTOParam.MesBuildingLinkCommonDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingLinkCommonDTOParam.MesBuildingLinkCommonDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public MesBuildingLinkCommonDTOParam.MesBuildingLinkCommonDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingLinkCommonDTOParam.MesBuildingLinkCommonDTOParamBuilder numberList(final List<Integer> numberList) {
         this.numberList = numberList;
         return this;
      }

      public MesBuildingLinkCommonDTOParam build() {
         return new MesBuildingLinkCommonDTOParam(this.id, this.productType, this.quantity, this.numberList);
      }

      @Override
      public String toString() {
         return "MesBuildingLinkCommonDTOParam.MesBuildingLinkCommonDTOParamBuilder(id="
            + this.id
            + ", productType="
            + this.productType
            + ", quantity="
            + this.quantity
            + ", numberList="
            + this.numberList
            + ")";
      }
   }
}
