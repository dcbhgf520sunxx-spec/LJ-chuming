package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.cargoList.update;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.mes.enclosure.core.api.enums.cargoList.ChangeFreightEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel(description = "取消收货修改类")
public class CargoListReceiptUpdateDTOParam {
   @ApiModelProperty("发货清单id")
   @NotNull(message = "发货清单id不能为空")
   private Long id;
   @ApiModelProperty("运费变更类型")
   @EnumValidator(value = ChangeFreightEnum.class, message = "运费变更类型不支持")
   @NotNull(message = "运费变更类型不能为空")
   private Integer changeFreight;
   @ApiModelProperty("取消送货原因")
   private String cancelDeliveryReason;
   @ApiModelProperty("计价方式")
   private Integer priceType;
   @ApiModelProperty("单价")
   private BigDecimal price;
   @ApiModelProperty("运费变更原因")
   private String changeFreightReason;

   public Long getId() {
      return this.id;
   }

   public Integer getChangeFreight() {
      return this.changeFreight;
   }

   public String getCancelDeliveryReason() {
      return this.cancelDeliveryReason;
   }

   public Integer getPriceType() {
      return this.priceType;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public String getChangeFreightReason() {
      return this.changeFreightReason;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setChangeFreight(final Integer changeFreight) {
      this.changeFreight = changeFreight;
   }

   public void setCancelDeliveryReason(final String cancelDeliveryReason) {
      this.cancelDeliveryReason = cancelDeliveryReason;
   }

   public void setPriceType(final Integer priceType) {
      this.priceType = priceType;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setChangeFreightReason(final String changeFreightReason) {
      this.changeFreightReason = changeFreightReason;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListReceiptUpdateDTOParam)) {
         return false;
      }

      CargoListReceiptUpdateDTOParam other = (CargoListReceiptUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$changeFreight = this.getChangeFreight();
         Object other$changeFreight = other.getChangeFreight();
         if (this$changeFreight == null ? other$changeFreight == null : this$changeFreight.equals(other$changeFreight)) {
            Object this$priceType = this.getPriceType();
            Object other$priceType = other.getPriceType();
            if (this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType)) {
               Object this$cancelDeliveryReason = this.getCancelDeliveryReason();
               Object other$cancelDeliveryReason = other.getCancelDeliveryReason();
               if (this$cancelDeliveryReason == null ? other$cancelDeliveryReason == null : this$cancelDeliveryReason.equals(other$cancelDeliveryReason)) {
                  Object this$price = this.getPrice();
                  Object other$price = other.getPrice();
                  if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                     Object this$changeFreightReason = this.getChangeFreightReason();
                     Object other$changeFreightReason = other.getChangeFreightReason();
                     return this$changeFreightReason == null ? other$changeFreightReason == null : this$changeFreightReason.equals(other$changeFreightReason);
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
      return other instanceof CargoListReceiptUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $changeFreight = this.getChangeFreight();
      result = result * 59 + ($changeFreight == null ? 43 : $changeFreight.hashCode());
      Object $priceType = this.getPriceType();
      result = result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
      Object $cancelDeliveryReason = this.getCancelDeliveryReason();
      result = result * 59 + ($cancelDeliveryReason == null ? 43 : $cancelDeliveryReason.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $changeFreightReason = this.getChangeFreightReason();
      return result * 59 + ($changeFreightReason == null ? 43 : $changeFreightReason.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListReceiptUpdateDTOParam(id="
         + this.getId()
         + ", changeFreight="
         + this.getChangeFreight()
         + ", cancelDeliveryReason="
         + this.getCancelDeliveryReason()
         + ", priceType="
         + this.getPriceType()
         + ", price="
         + this.getPrice()
         + ", changeFreightReason="
         + this.getChangeFreightReason()
         + ")";
   }
}
