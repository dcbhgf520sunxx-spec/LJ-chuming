package com.hzchum.scim.plan.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP 焊接产品码号列表 响应参数")
public class CappCraftCardProductCodeNumberVO {
   private Long id;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "productCodeNumber", value = "产品码号", notes = "产品码号")
   private Integer productCodeNumber;

   CappCraftCardProductCodeNumberVO(final Long id, final Long productId, final Integer productCodeNumber) {
      this.id = id;
      this.productId = productId;
      this.productCodeNumber = productCodeNumber;
   }

   public static CappCraftCardProductCodeNumberVO.CappCraftCardProductCodeNumberVOBuilder builder() {
      return new CappCraftCardProductCodeNumberVO.CappCraftCardProductCodeNumberVOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductCodeNumber() {
      return this.productCodeNumber;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductCodeNumber(final Integer productCodeNumber) {
      this.productCodeNumber = productCodeNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardProductCodeNumberVO)) {
         return false;
      }

      CappCraftCardProductCodeNumberVO other = (CappCraftCardProductCodeNumberVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$productCodeNumber = this.getProductCodeNumber();
            Object other$productCodeNumber = other.getProductCodeNumber();
            return this$productCodeNumber == null ? other$productCodeNumber == null : this$productCodeNumber.equals(other$productCodeNumber);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CappCraftCardProductCodeNumberVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productCodeNumber = this.getProductCodeNumber();
      return result * 59 + ($productCodeNumber == null ? 43 : $productCodeNumber.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductCodeNumberVO(id="
         + this.getId()
         + ", productId="
         + this.getProductId()
         + ", productCodeNumber="
         + this.getProductCodeNumber()
         + ")";
   }

   public static class CappCraftCardProductCodeNumberVOBuilder {
      private Long id;
      private Long productId;
      private Integer productCodeNumber;

      CappCraftCardProductCodeNumberVOBuilder() {
      }

      public CappCraftCardProductCodeNumberVO.CappCraftCardProductCodeNumberVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CappCraftCardProductCodeNumberVO.CappCraftCardProductCodeNumberVOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public CappCraftCardProductCodeNumberVO.CappCraftCardProductCodeNumberVOBuilder productCodeNumber(final Integer productCodeNumber) {
         this.productCodeNumber = productCodeNumber;
         return this;
      }

      public CappCraftCardProductCodeNumberVO build() {
         return new CappCraftCardProductCodeNumberVO(this.id, this.productId, this.productCodeNumber);
      }

      @Override
      public String toString() {
         return "CappCraftCardProductCodeNumberVO.CappCraftCardProductCodeNumberVOBuilder(id="
            + this.id
            + ", productId="
            + this.productId
            + ", productCodeNumber="
            + this.productCodeNumber
            + ")";
      }
   }
}
