package com.hzchum.scim.plan.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "CAPP app焊接工艺码号 响应参数")
public class CappCraftCardProductAppCodeNumberVO {
   private Long id;
   @ApiModelProperty(name = "productCodeNumber", value = "产品码号", notes = "产品码号")
   private String productCodeNumber;
   @ApiModelProperty(
      name = "techCappProductTaskWorkType",
      value = "capp做工状态 1未开始 2进行中 4已完成 枚举TechCappProductTaskWorkTypeEnum",
      notes = "capp做工状态 1未开始 2进行中 4已完成 枚举TechCappProductTaskWorkTypeEnum"
   )
   private Integer techCappProductTaskWorkType;

   public Long getId() {
      return this.id;
   }

   public String getProductCodeNumber() {
      return this.productCodeNumber;
   }

   public Integer getTechCappProductTaskWorkType() {
      return this.techCappProductTaskWorkType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProductCodeNumber(final String productCodeNumber) {
      this.productCodeNumber = productCodeNumber;
   }

   public void setTechCappProductTaskWorkType(final Integer techCappProductTaskWorkType) {
      this.techCappProductTaskWorkType = techCappProductTaskWorkType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CappCraftCardProductAppCodeNumberVO)) {
         return false;
      }

      CappCraftCardProductAppCodeNumberVO other = (CappCraftCardProductAppCodeNumberVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$techCappProductTaskWorkType = this.getTechCappProductTaskWorkType();
         Object other$techCappProductTaskWorkType = other.getTechCappProductTaskWorkType();
         if (this$techCappProductTaskWorkType == null
            ? other$techCappProductTaskWorkType == null
            : this$techCappProductTaskWorkType.equals(other$techCappProductTaskWorkType)) {
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
      return other instanceof CappCraftCardProductAppCodeNumberVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $techCappProductTaskWorkType = this.getTechCappProductTaskWorkType();
      result = result * 59 + ($techCappProductTaskWorkType == null ? 43 : $techCappProductTaskWorkType.hashCode());
      Object $productCodeNumber = this.getProductCodeNumber();
      return result * 59 + ($productCodeNumber == null ? 43 : $productCodeNumber.hashCode());
   }

   @Override
   public String toString() {
      return "CappCraftCardProductAppCodeNumberVO(id="
         + this.getId()
         + ", productCodeNumber="
         + this.getProductCodeNumber()
         + ", techCappProductTaskWorkType="
         + this.getTechCappProductTaskWorkType()
         + ")";
   }
}
