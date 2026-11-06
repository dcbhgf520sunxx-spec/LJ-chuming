package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.constraints.NotNull;

@ApiModel("组立或零件规格首字母配置类")
public class ProductConfigVO {
   @ApiModelProperty("产品类型：1零件 16组立")
   @NotNull(message = "产品类型不能为空！")
   private Integer productType;
   @ApiModelProperty("规格首字母列表")
   private List<String> SpecificationLetters;

   public static ProductConfigVO.ProductConfigVOBuilder builder() {
      return new ProductConfigVO.ProductConfigVOBuilder();
   }

   public Integer getProductType() {
      return this.productType;
   }

   public List<String> getSpecificationLetters() {
      return this.SpecificationLetters;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setSpecificationLetters(final List<String> SpecificationLetters) {
      this.SpecificationLetters = SpecificationLetters;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ProductConfigVO)) {
         return false;
      } else {
         ProductConfigVO other = (ProductConfigVO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$SpecificationLetters = this.getSpecificationLetters();
               Object other$SpecificationLetters = other.getSpecificationLetters();
               return this$SpecificationLetters == null ? other$SpecificationLetters == null : this$SpecificationLetters.equals(other$SpecificationLetters);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductConfigVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $SpecificationLetters = this.getSpecificationLetters();
      return result * 59 + ($SpecificationLetters == null ? 43 : $SpecificationLetters.hashCode());
   }

   @Override
   public String toString() {
      return "ProductConfigVO(productType=" + this.getProductType() + ", SpecificationLetters=" + this.getSpecificationLetters() + ")";
   }

   public ProductConfigVO(final Integer productType, final List<String> SpecificationLetters) {
      this.productType = productType;
      this.SpecificationLetters = SpecificationLetters;
   }

   public ProductConfigVO() {
   }

   public static class ProductConfigVOBuilder {
      private Integer productType;
      private List<String> SpecificationLetters;

      ProductConfigVOBuilder() {
      }

      public ProductConfigVO.ProductConfigVOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProductConfigVO.ProductConfigVOBuilder SpecificationLetters(final List<String> SpecificationLetters) {
         this.SpecificationLetters = SpecificationLetters;
         return this;
      }

      public ProductConfigVO build() {
         return new ProductConfigVO(this.productType, this.SpecificationLetters);
      }

      @Override
      public String toString() {
         return "ProductConfigVO.ProductConfigVOBuilder(productType=" + this.productType + ", SpecificationLetters=" + this.SpecificationLetters + ")";
      }
   }
}
