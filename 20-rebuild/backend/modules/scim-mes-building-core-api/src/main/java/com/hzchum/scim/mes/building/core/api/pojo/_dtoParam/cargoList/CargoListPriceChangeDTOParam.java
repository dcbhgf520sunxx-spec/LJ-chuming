package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("物流价格修改")
public class CargoListPriceChangeDTOParam {
   @ApiModelProperty("id")
   private Long id;
   @ApiModelProperty("remark")
   private String remark;
   @ApiModelProperty("priceType")
   private Integer priceType;
   @ApiModelProperty("price")
   private BigDecimal price;

   public Long getId() {
      return this.id;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getPriceType() {
      return this.priceType;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setPriceType(final Integer priceType) {
      this.priceType = priceType;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListPriceChangeDTOParam)) {
         return false;
      }

      CargoListPriceChangeDTOParam other = (CargoListPriceChangeDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$priceType = this.getPriceType();
         Object other$priceType = other.getPriceType();
         if (this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType)) {
            Object this$remark = this.getRemark();
            Object other$remark = other.getRemark();
            if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
               Object this$price = this.getPrice();
               Object other$price = other.getPrice();
               return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof CargoListPriceChangeDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $priceType = this.getPriceType();
      result = result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListPriceChangeDTOParam(id="
         + this.getId()
         + ", remark="
         + this.getRemark()
         + ", priceType="
         + this.getPriceType()
         + ", price="
         + this.getPrice()
         + ")";
   }
}
