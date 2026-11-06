package com.hzchum.scim.contract.core.api.pojo.dto.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("物流台账汇总")
public class LogisticsStandingBookDTO {
   @ApiModelProperty("物流供应商id")
   private Long supplierId;
   @ApiModelProperty("物流供应商名称")
   private String supplierName;
   @ApiModelProperty("签约公司主体id")
   private Long branchCompanyId;
   @ApiModelProperty("签约公司主体名称")
   private String branchCompanyName;
   @ApiModelProperty("运费总额(累计金额)")
   private BigDecimal freight;
   @ApiModelProperty("付款总额（累计付款）")
   private BigDecimal paymentAmount;
   @ApiModelProperty("收票总额（累计开票）")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("结算额")
   private BigDecimal settlementAmount;
   @ApiModelProperty("执行状态")
   private Integer executeStatus;
   @ApiModelProperty("累计车次")
   private Integer trainNumber;
   @ApiModelProperty("是否个人")
   private Integer boolPersonalEnum;

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
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

   public BigDecimal getSettlementAmount() {
      return this.settlementAmount;
   }

   public Integer getExecuteStatus() {
      return this.executeStatus;
   }

   public Integer getTrainNumber() {
      return this.trainNumber;
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

   public void setSettlementAmount(final BigDecimal settlementAmount) {
      this.settlementAmount = settlementAmount;
   }

   public void setExecuteStatus(final Integer executeStatus) {
      this.executeStatus = executeStatus;
   }

   public void setTrainNumber(final Integer trainNumber) {
      this.trainNumber = trainNumber;
   }

   public void setBoolPersonalEnum(final Integer boolPersonalEnum) {
      this.boolPersonalEnum = boolPersonalEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsStandingBookDTO)) {
         return false;
      }

      LogisticsStandingBookDTO other = (LogisticsStandingBookDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplierId = this.getSupplierId();
      Object other$supplierId = other.getSupplierId();
      if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$executeStatus = this.getExecuteStatus();
            Object other$executeStatus = other.getExecuteStatus();
            if (this$executeStatus == null ? other$executeStatus == null : this$executeStatus.equals(other$executeStatus)) {
               Object this$trainNumber = this.getTrainNumber();
               Object other$trainNumber = other.getTrainNumber();
               if (this$trainNumber == null ? other$trainNumber == null : this$trainNumber.equals(other$trainNumber)) {
                  Object this$boolPersonalEnum = this.getBoolPersonalEnum();
                  Object other$boolPersonalEnum = other.getBoolPersonalEnum();
                  if (this$boolPersonalEnum == null ? other$boolPersonalEnum == null : this$boolPersonalEnum.equals(other$boolPersonalEnum)) {
                     Object this$supplierName = this.getSupplierName();
                     Object other$supplierName = other.getSupplierName();
                     if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
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
                                    Object this$settlementAmount = this.getSettlementAmount();
                                    Object other$settlementAmount = other.getSettlementAmount();
                                    return this$settlementAmount == null
                                       ? other$settlementAmount == null
                                       : this$settlementAmount.equals(other$settlementAmount);
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
      return other instanceof LogisticsStandingBookDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $executeStatus = this.getExecuteStatus();
      result = result * 59 + ($executeStatus == null ? 43 : $executeStatus.hashCode());
      Object $trainNumber = this.getTrainNumber();
      result = result * 59 + ($trainNumber == null ? 43 : $trainNumber.hashCode());
      Object $boolPersonalEnum = this.getBoolPersonalEnum();
      result = result * 59 + ($boolPersonalEnum == null ? 43 : $boolPersonalEnum.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $settlementAmount = this.getSettlementAmount();
      return result * 59 + ($settlementAmount == null ? 43 : $settlementAmount.hashCode());
   }

   @Override
   public String toString() {
      return "LogisticsStandingBookDTO(supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
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
         + ", settlementAmount="
         + this.getSettlementAmount()
         + ", executeStatus="
         + this.getExecuteStatus()
         + ", trainNumber="
         + this.getTrainNumber()
         + ", boolPersonalEnum="
         + this.getBoolPersonalEnum()
         + ")";
   }
}
