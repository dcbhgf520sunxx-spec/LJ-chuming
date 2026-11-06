package com.hzchum.scim.business.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public class CheckDetailDTOParam {
   @NotNull(message = "id不能为空")
   @ApiModelProperty(name = "id", value = "商务id")
   private Long id;
   @NotNull(message = "单价不能为空")
   @ApiModelProperty(name = "unitPrice", value = "单价")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "pricingManner", value = "计价方式")
   private Integer pricingManner;

   public Long getId() {
      return this.id;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CheckDetailDTOParam)) {
         return false;
      }

      CheckDetailDTOParam other = (CheckDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$pricingManner = this.getPricingManner();
         Object other$pricingManner = other.getPricingManner();
         if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
            Object this$unitPrice = this.getUnitPrice();
            Object other$unitPrice = other.getUnitPrice();
            return this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CheckDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $unitPrice = this.getUnitPrice();
      return result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
   }

   @Override
   public String toString() {
      return "CheckDetailDTOParam(id=" + this.getId() + ", unitPrice=" + this.getUnitPrice() + ", pricingManner=" + this.getPricingManner() + ")";
   }
}
