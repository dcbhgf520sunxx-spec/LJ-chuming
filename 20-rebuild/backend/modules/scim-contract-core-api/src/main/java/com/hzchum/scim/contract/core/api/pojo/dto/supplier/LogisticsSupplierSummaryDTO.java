package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("物流公司原材料运费")
public class LogisticsSupplierSummaryDTO {
   @ApiModelProperty("物流供应商id")
   private Long supplierId;
   @ApiModelProperty("物流供应商名称")
   private String supplierName;
   @ApiModelProperty("物流供应商银行名称")
   private String supplierBankName;
   @ApiModelProperty("物流供应商银行账号")
   private String supplierBankAccount;
   @ApiModelProperty("签约公司主体id")
   private Long branchCompanyId;
   @ApiModelProperty("签约公司主体名称")
   private String branchCompanyName;
   @ApiModelProperty("运费总额")
   private BigDecimal freight;
   @ApiModelProperty("付款总额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("收票总额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("未审核付款数")
   private Integer unCheckPaymentCount;
   @ApiModelProperty("未审核收票数")
   private Integer unCheckInvoiceCount;
   @ApiModelProperty("最后一次付款金额")
   private BigDecimal lastPaymentAmount;
   @ApiModelProperty("是否个人")
   private Integer boolPersonalEnum;

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getSupplierBankName() {
      return this.supplierBankName;
   }

   public String getSupplierBankAccount() {
      return this.supplierBankAccount;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public Integer getUnCheckPaymentCount() {
      return this.unCheckPaymentCount;
   }

   public Integer getUnCheckInvoiceCount() {
      return this.unCheckInvoiceCount;
   }

   public BigDecimal getLastPaymentAmount() {
      return this.lastPaymentAmount;
   }

   public Integer getBoolPersonalEnum() {
      return this.boolPersonalEnum;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setSupplierBankName(final String supplierBankName) {
      this.supplierBankName = supplierBankName;
   }

   public void setSupplierBankAccount(final String supplierBankAccount) {
      this.supplierBankAccount = supplierBankAccount;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setFreight(final BigDecimal freight) {
      this.freight = freight;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setUnCheckPaymentCount(final Integer unCheckPaymentCount) {
      this.unCheckPaymentCount = unCheckPaymentCount;
   }

   public void setUnCheckInvoiceCount(final Integer unCheckInvoiceCount) {
      this.unCheckInvoiceCount = unCheckInvoiceCount;
   }

   public void setLastPaymentAmount(final BigDecimal lastPaymentAmount) {
      this.lastPaymentAmount = lastPaymentAmount;
   }

   public void setBoolPersonalEnum(final Integer boolPersonalEnum) {
      this.boolPersonalEnum = boolPersonalEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsSupplierSummaryDTO)) {
         return false;
      }

      LogisticsSupplierSummaryDTO other = (LogisticsSupplierSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplierId = this.getSupplierId();
      Object other$supplierId = other.getSupplierId();
      if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$unCheckPaymentCount = this.getUnCheckPaymentCount();
            Object other$unCheckPaymentCount = other.getUnCheckPaymentCount();
            if (this$unCheckPaymentCount == null ? other$unCheckPaymentCount == null : this$unCheckPaymentCount.equals(other$unCheckPaymentCount)) {
               Object this$unCheckInvoiceCount = this.getUnCheckInvoiceCount();
               Object other$unCheckInvoiceCount = other.getUnCheckInvoiceCount();
               if (this$unCheckInvoiceCount == null ? other$unCheckInvoiceCount == null : this$unCheckInvoiceCount.equals(other$unCheckInvoiceCount)) {
                  Object this$boolPersonalEnum = this.getBoolPersonalEnum();
                  Object other$boolPersonalEnum = other.getBoolPersonalEnum();
                  if (this$boolPersonalEnum == null ? other$boolPersonalEnum == null : this$boolPersonalEnum.equals(other$boolPersonalEnum)) {
                     Object this$supplierName = this.getSupplierName();
                     Object other$supplierName = other.getSupplierName();
                     if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                        Object this$supplierBankName = this.getSupplierBankName();
                        Object other$supplierBankName = other.getSupplierBankName();
                        if (this$supplierBankName == null ? other$supplierBankName == null : this$supplierBankName.equals(other$supplierBankName)) {
                           Object this$supplierBankAccount = this.getSupplierBankAccount();
                           Object other$supplierBankAccount = other.getSupplierBankAccount();
                           if (this$supplierBankAccount == null
                              ? other$supplierBankAccount == null
                              : this$supplierBankAccount.equals(other$supplierBankAccount)) {
                              Object this$branchCompanyName = this.getBranchCompanyName();
                              Object other$branchCompanyName = other.getBranchCompanyName();
                              if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
                                 Object this$freight = this.getFreight();
                                 Object other$freight = other.getFreight();
                                 if (this$freight == null ? other$freight == null : this$freight.equals(other$freight)) {
                                    Object this$paymentAmount = this.getPaymentAmount();
                                    Object other$paymentAmount = other.getPaymentAmount();
                                    if (this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount)) {
                                       Object this$invoiceAmount = this.getInvoiceAmount();
                                       Object other$invoiceAmount = other.getInvoiceAmount();
                                       if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                                          Object this$lastPaymentAmount = this.getLastPaymentAmount();
                                          Object other$lastPaymentAmount = other.getLastPaymentAmount();
                                          return this$lastPaymentAmount == null
                                             ? other$lastPaymentAmount == null
                                             : this$lastPaymentAmount.equals(other$lastPaymentAmount);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof LogisticsSupplierSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $unCheckPaymentCount = this.getUnCheckPaymentCount();
      result = result * 59 + ($unCheckPaymentCount == null ? 43 : $unCheckPaymentCount.hashCode());
      Object $unCheckInvoiceCount = this.getUnCheckInvoiceCount();
      result = result * 59 + ($unCheckInvoiceCount == null ? 43 : $unCheckInvoiceCount.hashCode());
      Object $boolPersonalEnum = this.getBoolPersonalEnum();
      result = result * 59 + ($boolPersonalEnum == null ? 43 : $boolPersonalEnum.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $supplierBankName = this.getSupplierBankName();
      result = result * 59 + ($supplierBankName == null ? 43 : $supplierBankName.hashCode());
      Object $supplierBankAccount = this.getSupplierBankAccount();
      result = result * 59 + ($supplierBankAccount == null ? 43 : $supplierBankAccount.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $lastPaymentAmount = this.getLastPaymentAmount();
      return result * 59 + ($lastPaymentAmount == null ? 43 : $lastPaymentAmount.hashCode());
   }

   @Override
   public String toString() {
      return "LogisticsSupplierSummaryDTO(supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", supplierBankName="
         + this.getSupplierBankName()
         + ", supplierBankAccount="
         + this.getSupplierBankAccount()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", freight="
         + this.getFreight()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", unCheckPaymentCount="
         + this.getUnCheckPaymentCount()
         + ", unCheckInvoiceCount="
         + this.getUnCheckInvoiceCount()
         + ", lastPaymentAmount="
         + this.getLastPaymentAmount()
         + ", boolPersonalEnum="
         + this.getBoolPersonalEnum()
         + ")";
   }
}
