package com.hzchum.scim.contract.core.api.pojo.dto.logistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("物流首页")
public class LogisticsHomeDTO {
   @ApiModelProperty("物流公司(供应商id)")
   private String supplierId;
   @ApiModelProperty("物流公司(供应商)")
   private String supplierName;
   @ApiModelProperty("签约公司主体id")
   private Long branchCompanyId;
   @ApiModelProperty("签约公司主体名称")
   private String branchCompanyName;
   @ApiModelProperty("累计运费")
   private BigDecimal freight;
   @ApiModelProperty("上年度累计运费")
   private BigDecimal lastFreight;
   @ApiModelProperty("本年度累计运费")
   private BigDecimal thisFreight;
   @ApiModelProperty("累计开票")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("累计付款")
   private BigDecimal paymentAmount;
   @ApiModelProperty("历史记录")
   private String historicalRecord;
   @ApiModelProperty("创建时间")
   private LocalDateTime createTime;

   public String getSupplierId() {
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

   public BigDecimal getLastFreight() {
      return this.lastFreight;
   }

   public BigDecimal getThisFreight() {
      return this.thisFreight;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public String getHistoricalRecord() {
      return this.historicalRecord;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setSupplierId(final String supplierId) {
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

   public void setLastFreight(final BigDecimal lastFreight) {
      this.lastFreight = lastFreight;
   }

   public void setThisFreight(final BigDecimal thisFreight) {
      this.thisFreight = thisFreight;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setHistoricalRecord(final String historicalRecord) {
      this.historicalRecord = historicalRecord;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsHomeDTO)) {
         return false;
      }

      LogisticsHomeDTO other = (LogisticsHomeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$branchCompanyId = this.getBranchCompanyId();
      Object other$branchCompanyId = other.getBranchCompanyId();
      if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$supplierName = this.getSupplierName();
            Object other$supplierName = other.getSupplierName();
            if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
               Object this$branchCompanyName = this.getBranchCompanyName();
               Object other$branchCompanyName = other.getBranchCompanyName();
               if (this$branchCompanyName == null ? other$branchCompanyName == null : this$branchCompanyName.equals(other$branchCompanyName)) {
                  Object this$freight = this.getFreight();
                  Object other$freight = other.getFreight();
                  if (this$freight == null ? other$freight == null : this$freight.equals(other$freight)) {
                     Object this$lastFreight = this.getLastFreight();
                     Object other$lastFreight = other.getLastFreight();
                     if (this$lastFreight == null ? other$lastFreight == null : this$lastFreight.equals(other$lastFreight)) {
                        Object this$thisFreight = this.getThisFreight();
                        Object other$thisFreight = other.getThisFreight();
                        if (this$thisFreight == null ? other$thisFreight == null : this$thisFreight.equals(other$thisFreight)) {
                           Object this$invoiceAmount = this.getInvoiceAmount();
                           Object other$invoiceAmount = other.getInvoiceAmount();
                           if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                              Object this$paymentAmount = this.getPaymentAmount();
                              Object other$paymentAmount = other.getPaymentAmount();
                              if (this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount)) {
                                 Object this$historicalRecord = this.getHistoricalRecord();
                                 Object other$historicalRecord = other.getHistoricalRecord();
                                 if (this$historicalRecord == null ? other$historicalRecord == null : this$historicalRecord.equals(other$historicalRecord)) {
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
      return other instanceof LogisticsHomeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $lastFreight = this.getLastFreight();
      result = result * 59 + ($lastFreight == null ? 43 : $lastFreight.hashCode());
      Object $thisFreight = this.getThisFreight();
      result = result * 59 + ($thisFreight == null ? 43 : $thisFreight.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $historicalRecord = this.getHistoricalRecord();
      result = result * 59 + ($historicalRecord == null ? 43 : $historicalRecord.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "LogisticsHomeDTO(supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", freight="
         + this.getFreight()
         + ", lastFreight="
         + this.getLastFreight()
         + ", thisFreight="
         + this.getThisFreight()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", historicalRecord="
         + this.getHistoricalRecord()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }
}
