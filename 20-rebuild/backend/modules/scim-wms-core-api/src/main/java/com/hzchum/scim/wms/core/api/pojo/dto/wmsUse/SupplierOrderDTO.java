package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SupplierOrderDTO {
   @ApiModelProperty(name = "orderId", value = "订单id ")
   private Long id;
   @ApiModelProperty("采购单号")
   private String serialNumber;
   @ApiModelProperty("种类名称(基础物料分类) 1钢板 2型材 4钢卷 8....")
   private String basicClass;
   @ApiModelProperty("供应商名称")
   private String supplierName;
   @ApiModelProperty(name = "amount", value = "合同额")
   private BigDecimal amount;
   @ApiModelProperty("结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("入库额")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal inboundAmount;
   @ApiModelProperty("付款额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("未审核付款数")
   private Integer unCheckPaymentCount;
   @ApiModelProperty("收票额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("创建时间")
   private LocalDateTime createTime;

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getBasicClass() {
      return this.basicClass;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public BigDecimal getInboundAmount() {
      return this.inboundAmount;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public Integer getUnCheckPaymentCount() {
      return this.unCheckPaymentCount;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setBasicClass(final String basicClass) {
      this.basicClass = basicClass;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setInboundAmount(final BigDecimal inboundAmount) {
      this.inboundAmount = inboundAmount;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setUnCheckPaymentCount(final Integer unCheckPaymentCount) {
      this.unCheckPaymentCount = unCheckPaymentCount;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierOrderDTO)) {
         return false;
      }

      SupplierOrderDTO other = (SupplierOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$unCheckPaymentCount = this.getUnCheckPaymentCount();
         Object other$unCheckPaymentCount = other.getUnCheckPaymentCount();
         if (this$unCheckPaymentCount == null ? other$unCheckPaymentCount == null : this$unCheckPaymentCount.equals(other$unCheckPaymentCount)) {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$supplierName = this.getSupplierName();
                  Object other$supplierName = other.getSupplierName();
                  if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                     Object this$amount = this.getAmount();
                     Object other$amount = other.getAmount();
                     if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                        Object this$settlementAmount = this.getSettlementAmount();
                        Object other$settlementAmount = other.getSettlementAmount();
                        if (this$settlementAmount == null ? other$settlementAmount == null : this$settlementAmount.equals(other$settlementAmount)) {
                           Object this$inboundAmount = this.getInboundAmount();
                           Object other$inboundAmount = other.getInboundAmount();
                           if (this$inboundAmount == null ? other$inboundAmount == null : this$inboundAmount.equals(other$inboundAmount)) {
                              Object this$paymentAmount = this.getPaymentAmount();
                              Object other$paymentAmount = other.getPaymentAmount();
                              if (this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount)) {
                                 Object this$invoiceAmount = this.getInvoiceAmount();
                                 Object other$invoiceAmount = other.getInvoiceAmount();
                                 if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                                    Object this$createTime = this.getCreateTime();
                                    Object other$createTime = other.getCreateTime();
                                    return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      return other instanceof SupplierOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $unCheckPaymentCount = this.getUnCheckPaymentCount();
      result = result * 59 + ($unCheckPaymentCount == null ? 43 : $unCheckPaymentCount.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      result = result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
      Object $inboundAmount = this.getInboundAmount();
      result = result * 59 + ($inboundAmount == null ? 43 : $inboundAmount.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierOrderDTO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", basicClass="
         + this.getBasicClass()
         + ", supplierName="
         + this.getSupplierName()
         + ", amount="
         + this.getAmount()
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", inboundAmount="
         + this.getInboundAmount()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", unCheckPaymentCount="
         + this.getUnCheckPaymentCount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }
}
