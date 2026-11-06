package com.hzchum.scim.plan.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "CAPP bim产品列表信息 响应参数")
public class CappCraftCardProductBimVO {
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "productSerialNumber", value = "产品编号", notes = "产品编号")
   private String productSerialNumber;
   @ApiModelProperty(name = "productCount", value = "产品数量", notes = "产品数量")
   private Integer productCount;
   @ApiModelProperty(name = "productNetWeight", value = "产品净重", notes = "产品净重")
   private BigDecimal productNetWeight;
   @ApiModelProperty(name = "productWeldCount", value = "产品焊缝数量", notes = "产品焊缝数量")
   private Integer productWeldCount;

   public static CappCraftCardProductBimVO.CappCraftCardProductBimVOBuilder builder() {
      return new CappCraftCardProductBimVO.CappCraftCardProductBimVOBuilder();
   }

   public Long getProductId() {
      return this.productId;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public Integer getProductCount() {
      return this.productCount;
   }

   public BigDecimal getProductNetWeight() {
      return this.productNetWeight;
   }

   public Integer getProductWeldCount() {
      return this.productWeldCount;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   public void setProductCount(final Integer productCount) {
      this.productCount = productCount;
   }

   public void setProductNetWeight(final BigDecimal productNetWeight) {
      this.productNetWeight = productNetWeight;
   }

   public void setProductWeldCount(final Integer productWeldCount) {
      this.productWeldCount = productWeldCount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardProductBimVO)) {
         return false;
      }

      CappCraftCardProductBimVO other = (CappCraftCardProductBimVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$productCount = this.getProductCount();
         Object other$productCount = other.getProductCount();
         if (this$productCount == null ? other$productCount == null : this$productCount.equals(other$productCount)) {
            Object this$productWeldCount = this.getProductWeldCount();
            Object other$productWeldCount = other.getProductWeldCount();
            if (this$productWeldCount == null ? other$productWeldCount == null : this$productWeldCount.equals(other$productWeldCount)) {
               Object this$productSerialNumber = this.getProductSerialNumber();
               Object other$productSerialNumber = other.getProductSerialNumber();
               if (this$productSerialNumber == null ? other$productSerialNumber == null : this$productSerialNumber.equals(other$productSerialNumber)) {
                  Object this$productNetWeight = this.getProductNetWeight();
                  Object other$productNetWeight = other.getProductNetWeight();
                  return this$productNetWeight == null ? other$productNetWeight == null : this$productNetWeight.equals(other$productNetWeight);
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
      return other instanceof CappCraftCardProductBimVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productCount = this.getProductCount();
      result = result * 59 + ($productCount == null ? 43 : $productCount.hashCode());
      Object $productWeldCount = this.getProductWeldCount();
      result = result * 59 + ($productWeldCount == null ? 43 : $productWeldCount.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $productNetWeight = this.getProductNetWeight();
      return result * 59 + ($productNetWeight == null ? 43 : $productNetWeight.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductBimVO(productId="
         + this.getProductId()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", productCount="
         + this.getProductCount()
         + ", productNetWeight="
         + this.getProductNetWeight()
         + ", productWeldCount="
         + this.getProductWeldCount()
         + ")";
   }

   public CappCraftCardProductBimVO(
      final Long productId, final String productSerialNumber, final Integer productCount, final BigDecimal productNetWeight, final Integer productWeldCount
   ) {
      this.productId = productId;
      this.productSerialNumber = productSerialNumber;
      this.productCount = productCount;
      this.productNetWeight = productNetWeight;
      this.productWeldCount = productWeldCount;
   }

   public CappCraftCardProductBimVO() {
   }

   public static class CappCraftCardProductBimVOBuilder {
      private Long productId;
      private String productSerialNumber;
      private Integer productCount;
      private BigDecimal productNetWeight;
      private Integer productWeldCount;

      CappCraftCardProductBimVOBuilder() {
      }

      public CappCraftCardProductBimVO.CappCraftCardProductBimVOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public CappCraftCardProductBimVO.CappCraftCardProductBimVOBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      public CappCraftCardProductBimVO.CappCraftCardProductBimVOBuilder productCount(final Integer productCount) {
         this.productCount = productCount;
         return this;
      }

      public CappCraftCardProductBimVO.CappCraftCardProductBimVOBuilder productNetWeight(final BigDecimal productNetWeight) {
         this.productNetWeight = productNetWeight;
         return this;
      }

      public CappCraftCardProductBimVO.CappCraftCardProductBimVOBuilder productWeldCount(final Integer productWeldCount) {
         this.productWeldCount = productWeldCount;
         return this;
      }

      public CappCraftCardProductBimVO build() {
         return new CappCraftCardProductBimVO(this.productId, this.productSerialNumber, this.productCount, this.productNetWeight, this.productWeldCount);
      }

      @Override
      public String toString() {
         return "CappCraftCardProductBimVO.CappCraftCardProductBimVOBuilder(productId="
            + this.productId
            + ", productSerialNumber="
            + this.productSerialNumber
            + ", productCount="
            + this.productCount
            + ", productNetWeight="
            + this.productNetWeight
            + ", productWeldCount="
            + this.productWeldCount
            + ")";
      }
   }
}
