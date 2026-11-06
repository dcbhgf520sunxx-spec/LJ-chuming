package com.hzchum.scim.scm.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("采购订单汇总类")
public class PurchaseOrderSummaryDTO {
   @ApiModelProperty(name = "materialType", value = "材料类型", notes = "材料类型")
   private Integer materialType;
   @ApiModelProperty(name = "materialTypeName", value = "材料类型", notes = "材料类型")
   private String materialTypeName;
   @ApiModelProperty(name = "numbers", value = "订单数量/供应商数量", notes = "订单数量/供应商数量")
   private Integer numbers;
   @ApiModelProperty(name = "amount", value = "订单金额", notes = "订单金额")
   private BigDecimal amount;

   public Integer getMaterialType() {
      return this.materialType;
   }

   public String getMaterialTypeName() {
      return this.materialTypeName;
   }

   public Integer getNumbers() {
      return this.numbers;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public void setMaterialType(final Integer materialType) {
      this.materialType = materialType;
   }

   public void setMaterialTypeName(final String materialTypeName) {
      this.materialTypeName = materialTypeName;
   }

   public void setNumbers(final Integer numbers) {
      this.numbers = numbers;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseOrderSummaryDTO)) {
         return false;
      }

      PurchaseOrderSummaryDTO other = (PurchaseOrderSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$materialType = this.getMaterialType();
      Object other$materialType = other.getMaterialType();
      if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
         Object this$numbers = this.getNumbers();
         Object other$numbers = other.getNumbers();
         if (this$numbers == null ? other$numbers == null : this$numbers.equals(other$numbers)) {
            Object this$materialTypeName = this.getMaterialTypeName();
            Object other$materialTypeName = other.getMaterialTypeName();
            if (this$materialTypeName == null ? other$materialTypeName == null : this$materialTypeName.equals(other$materialTypeName)) {
               Object this$amount = this.getAmount();
               Object other$amount = other.getAmount();
               return this$amount == null ? other$amount == null : this$amount.equals(other$amount);
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
      return other instanceof PurchaseOrderSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $numbers = this.getNumbers();
      result = result * 59 + ($numbers == null ? 43 : $numbers.hashCode());
      Object $materialTypeName = this.getMaterialTypeName();
      result = result * 59 + ($materialTypeName == null ? 43 : $materialTypeName.hashCode());
      Object $amount = this.getAmount();
      return result * 59 + ($amount == null ? 43 : $amount.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseOrderSummaryDTO(materialType="
         + this.getMaterialType()
         + ", materialTypeName="
         + this.getMaterialTypeName()
         + ", numbers="
         + this.getNumbers()
         + ", amount="
         + this.getAmount()
         + ")";
   }
}
