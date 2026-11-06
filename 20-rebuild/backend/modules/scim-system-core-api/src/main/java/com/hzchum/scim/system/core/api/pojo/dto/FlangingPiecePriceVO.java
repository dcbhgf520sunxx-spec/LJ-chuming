package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class FlangingPiecePriceVO {
   @ApiModelProperty("折边件计价方式: true 米*单价 false 米*单价*折弯次数")
   @NotNull(message = "配置不能为空")
   private Boolean priceType;

   public static FlangingPiecePriceVO.FlangingPiecePriceVOBuilder builder() {
      return new FlangingPiecePriceVO.FlangingPiecePriceVOBuilder();
   }

   public Boolean getPriceType() {
      return this.priceType;
   }

   public void setPriceType(final Boolean priceType) {
      this.priceType = priceType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FlangingPiecePriceVO)) {
         return false;
      }

      FlangingPiecePriceVO other = (FlangingPiecePriceVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$priceType = this.getPriceType();
      Object other$priceType = other.getPriceType();
      return this$priceType == null ? other$priceType == null : this$priceType.equals(other$priceType);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof FlangingPiecePriceVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $priceType = this.getPriceType();
      return result * 59 + ($priceType == null ? 43 : $priceType.hashCode());
   }

   @Override
   public String toString() {
      return "FlangingPiecePriceVO(priceType=" + this.getPriceType() + ")";
   }

   public FlangingPiecePriceVO(final Boolean priceType) {
      this.priceType = priceType;
   }

   public FlangingPiecePriceVO() {
   }

   public static class FlangingPiecePriceVOBuilder {
      private Boolean priceType;

      FlangingPiecePriceVOBuilder() {
      }

      public FlangingPiecePriceVO.FlangingPiecePriceVOBuilder priceType(final Boolean priceType) {
         this.priceType = priceType;
         return this;
      }

      public FlangingPiecePriceVO build() {
         return new FlangingPiecePriceVO(this.priceType);
      }

      @Override
      public String toString() {
         return "FlangingPiecePriceVO.FlangingPiecePriceVOBuilder(priceType=" + this.priceType + ")";
      }
   }
}
