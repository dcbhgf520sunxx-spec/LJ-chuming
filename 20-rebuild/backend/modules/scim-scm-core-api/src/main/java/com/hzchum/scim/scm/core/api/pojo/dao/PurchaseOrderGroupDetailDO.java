package com.hzchum.scim.scm.core.api.pojo.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("采购月度详情")
public class PurchaseOrderGroupDetailDO {
   @ApiModelProperty(name = "dateTime", value = "日期", notes = "日期")
   private String dateTime;
   @ApiModelProperty(name = "materialType", value = "物料类型", notes = "物料类型")
   private Integer materialType;
   @ApiModelProperty(name = "supplierId", value = "分包商", notes = "分包商")
   private Long supplierId;
   @ApiModelProperty(name = "amount", value = "订单金额", notes = "订单金额")
   private BigDecimal amount;

   public String getDateTime() {
      return this.dateTime;
   }

   public Integer getMaterialType() {
      return this.materialType;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public void setDateTime(final String dateTime) {
      this.dateTime = dateTime;
   }

   public void setMaterialType(final Integer materialType) {
      this.materialType = materialType;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseOrderGroupDetailDO)) {
         return false;
      }

      PurchaseOrderGroupDetailDO other = (PurchaseOrderGroupDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$materialType = this.getMaterialType();
      Object other$materialType = other.getMaterialType();
      if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$dateTime = this.getDateTime();
            Object other$dateTime = other.getDateTime();
            if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
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
      return other instanceof PurchaseOrderGroupDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $amount = this.getAmount();
      return result * 59 + ($amount == null ? 43 : $amount.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseOrderGroupDetailDO(dateTime="
         + this.getDateTime()
         + ", materialType="
         + this.getMaterialType()
         + ", supplierId="
         + this.getSupplierId()
         + ", amount="
         + this.getAmount()
         + ")";
   }
}
