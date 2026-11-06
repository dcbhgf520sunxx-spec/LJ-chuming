package com.hzchum.scim.scm.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("采购订单物流公司费用信息类")
public class PurchaseOrderFreightDTO {
   @ApiModelProperty("采购订单id")
   private Long purchaseId;
   @ApiModelProperty("采购订单编号")
   private String serialNumber;
   @ApiModelProperty("物流公司id")
   private Long supplierId;
   @ApiModelProperty("物流公司名称")
   private String supplierName;
   @ApiModelProperty("发运物流费")
   private BigDecimal freight;

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public void setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setFreight(final BigDecimal freight) {
      this.freight = freight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseOrderFreightDTO)) {
         return false;
      }

      PurchaseOrderFreightDTO other = (PurchaseOrderFreightDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$purchaseId = this.getPurchaseId();
      Object other$purchaseId = other.getPurchaseId();
      if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$supplierName = this.getSupplierName();
               Object other$supplierName = other.getSupplierName();
               if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                  Object this$freight = this.getFreight();
                  Object other$freight = other.getFreight();
                  return this$freight == null ? other$freight == null : this$freight.equals(other$freight);
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
      return other instanceof PurchaseOrderFreightDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $freight = this.getFreight();
      return result * 59 + ($freight == null ? 43 : $freight.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseOrderFreightDTO(purchaseId="
         + this.getPurchaseId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", freight="
         + this.getFreight()
         + ")";
   }
}
