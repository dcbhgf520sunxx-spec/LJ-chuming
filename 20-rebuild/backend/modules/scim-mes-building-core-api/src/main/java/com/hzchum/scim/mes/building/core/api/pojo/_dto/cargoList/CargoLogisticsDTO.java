package com.hzchum.scim.mes.building.core.api.pojo._dto.cargoList;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "物流信息")
public class CargoLogisticsDTO {
   @ApiModelProperty("发货清单id")
   private Long id;
   @ApiModelProperty("计价方式 [1重量, 2 车次]")
   private Integer priceType;
   @ApiModelProperty("运输单价")
   private BigDecimal price;
   @ApiModelProperty("运输总价")
   private BigDecimal totalPrice;
   @ApiModelProperty("过磅重量")
   private BigDecimal actualWeight;
   @ApiModelProperty("车型")
   private String carModel;

   public Long getId() {
      return this.id;
   }

   public Integer getPriceType() {
      return this.priceType;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public BigDecimal getActualWeight() {
      return this.actualWeight;
   }

   public String getCarModel() {
      return this.carModel;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setPriceType(final Integer priceType) {
      this.priceType = priceType;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   public void setActualWeight(final BigDecimal actualWeight) {
      this.actualWeight = actualWeight;
   }

   public void setCarModel(final String carModel) {
      this.carModel = carModel;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoLogisticsDTO)) {
         return false;
      }

      CargoLogisticsDTO other = (CargoLogisticsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$priceType = this.getPriceType();
         Object other$priceType = other.getPriceType();
         if (this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType)) {
            Object this$price = this.getPrice();
            Object other$price = other.getPrice();
            if (this$price == null ? other$price == null : this$price.equals(other$price)) {
               Object this$totalPrice = this.getTotalPrice();
               Object other$totalPrice = other.getTotalPrice();
               if (this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice)) {
                  Object this$actualWeight = this.getActualWeight();
                  Object other$actualWeight = other.getActualWeight();
                  if (this$actualWeight == null ? other$actualWeight == null : this$actualWeight.equals(other$actualWeight)) {
                     Object this$carModel = this.getCarModel();
                     Object other$carModel = other.getCarModel();
                     return this$carModel == null ? other$carModel == null : this$carModel.equals(other$carModel);
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
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
      return other instanceof CargoLogisticsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $priceType = this.getPriceType();
      result = result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $totalPrice = this.getTotalPrice();
      result = result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
      Object $actualWeight = this.getActualWeight();
      result = result * 59 + ($actualWeight == null ? 43 : $actualWeight.hashCode());
      Object $carModel = this.getCarModel();
      return result * 59 + ($carModel == null ? 43 : $carModel.hashCode());
   }

   @Override
   public String toString() {
      return "CargoLogisticsDTO(id="
         + this.getId()
         + ", priceType="
         + this.getPriceType()
         + ", price="
         + this.getPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ", actualWeight="
         + this.getActualWeight()
         + ", carModel="
         + this.getCarModel()
         + ")";
   }
}
