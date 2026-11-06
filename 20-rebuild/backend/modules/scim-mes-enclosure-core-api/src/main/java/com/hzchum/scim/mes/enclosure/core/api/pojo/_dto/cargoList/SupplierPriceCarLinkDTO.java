package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.cargoList;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "物流管理")
public class SupplierPriceCarLinkDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   private Long id;
   @ApiModelProperty(name = "supplierPriceId", value = "物流单位id", notes = "物流单位id")
   @JsonProperty("supplierPriceId")
   @JSONField(name = "supplierPriceId")
   private Long supplierPriceId;
   @ApiModelProperty(name = "carModel", value = "车型", notes = "车型")
   @JsonProperty("carModel")
   @JSONField(name = "carModel")
   private String carModel;
   @ApiModelProperty(name = "priceType", value = "计价方式 1重量, 2 车次]", notes = "计价方式 1重量, 2 车次]")
   @JsonProperty("priceType")
   @JSONField(name = "priceType")
   private Integer priceType;
   @ApiModelProperty(name = "price", value = "价格", notes = "价格")
   @JsonProperty("price")
   @JSONField(name = "price")
   private BigDecimal price;

   public Long getId() {
      return this.id;
   }

   public Long getSupplierPriceId() {
      return this.supplierPriceId;
   }

   public String getCarModel() {
      return this.carModel;
   }

   public Integer getPriceType() {
      return this.priceType;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   @JsonProperty("id")
   public void setId(final Long id) {
      this.id = id;
   }

   @JsonProperty("supplierPriceId")
   public void setSupplierPriceId(final Long supplierPriceId) {
      this.supplierPriceId = supplierPriceId;
   }

   @JsonProperty("carModel")
   public void setCarModel(final String carModel) {
      this.carModel = carModel;
   }

   @JsonProperty("priceType")
   public void setPriceType(final Integer priceType) {
      this.priceType = priceType;
   }

   @JsonProperty("price")
   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierPriceCarLinkDTO)) {
         return false;
      }

      SupplierPriceCarLinkDTO other = (SupplierPriceCarLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$supplierPriceId = this.getSupplierPriceId();
         Object other$supplierPriceId = other.getSupplierPriceId();
         if (this$supplierPriceId == null ? other$supplierPriceId == null : this$supplierPriceId.equals(other$supplierPriceId)) {
            Object this$priceType = this.getPriceType();
            Object other$priceType = other.getPriceType();
            if (this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType)) {
               Object this$carModel = this.getCarModel();
               Object other$carModel = other.getCarModel();
               if (this$carModel == null ? other$carModel == null : this$carModel.equals(other$carModel)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SupplierPriceCarLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $supplierPriceId = this.getSupplierPriceId();
      result = result * 59 + ($supplierPriceId == null ? 43 : $supplierPriceId.hashCode());
      Object $priceType = this.getPriceType();
      result = result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
      Object $carModel = this.getCarModel();
      result = result * 59 + ($carModel == null ? 43 : $carModel.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierPriceCarLinkDTO(id="
         + this.getId()
         + ", supplierPriceId="
         + this.getSupplierPriceId()
         + ", carModel="
         + this.getCarModel()
         + ", priceType="
         + this.getPriceType()
         + ", price="
         + this.getPrice()
         + ")";
   }
}
