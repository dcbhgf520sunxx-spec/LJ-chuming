package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("添加开票数据请求")
public class LogisticsInvoiceSaveDTOParam {
   @ApiModelProperty("物流id")
   private Long supplierId;
   @ApiModelProperty("物流公司")
   private String supplierName;
   @ApiModelProperty("发票面额")
   private BigDecimal invoiceAmount;
   @ApiModelProperty("发票号码")
   private String invoiceSerialNumber;
   @ApiModelProperty("收款银行")
   private String receiveBank;
   @ApiModelProperty("收款账号")
   private String receiveBankAccount;
   @ApiModelProperty("申请人id")
   private Long applyUserId;
   @ApiModelProperty("申请人名称")
   private String applyUserName;
   @ApiModelProperty("开票时间")
   private LocalDateTime invoiceDate;
   @ApiModelProperty("已付款额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("已开发票金额")
   private BigDecimal openInvoiceAmount;
   @ApiModelProperty("付款id")
   private Long paymentId;
   @ApiModelProperty("附件ids")
   private List<Long> attachmentIds;

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public String getInvoiceSerialNumber() {
      return this.invoiceSerialNumber;
   }

   public String getReceiveBank() {
      return this.receiveBank;
   }

   public String getReceiveBankAccount() {
      return this.receiveBankAccount;
   }

   public Long getApplyUserId() {
      return this.applyUserId;
   }

   public String getApplyUserName() {
      return this.applyUserName;
   }

   public LocalDateTime getInvoiceDate() {
      return this.invoiceDate;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public BigDecimal getOpenInvoiceAmount() {
      return this.openInvoiceAmount;
   }

   public Long getPaymentId() {
      return this.paymentId;
   }

   public List<Long> getAttachmentIds() {
      return this.attachmentIds;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   public void setInvoiceSerialNumber(final String invoiceSerialNumber) {
      this.invoiceSerialNumber = invoiceSerialNumber;
   }

   public void setReceiveBank(final String receiveBank) {
      this.receiveBank = receiveBank;
   }

   public void setReceiveBankAccount(final String receiveBankAccount) {
      this.receiveBankAccount = receiveBankAccount;
   }

   public void setApplyUserId(final Long applyUserId) {
      this.applyUserId = applyUserId;
   }

   public void setApplyUserName(final String applyUserName) {
      this.applyUserName = applyUserName;
   }

   public void setInvoiceDate(final LocalDateTime invoiceDate) {
      this.invoiceDate = invoiceDate;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setOpenInvoiceAmount(final BigDecimal openInvoiceAmount) {
      this.openInvoiceAmount = openInvoiceAmount;
   }

   public void setPaymentId(final Long paymentId) {
      this.paymentId = paymentId;
   }

   public void setAttachmentIds(final List<Long> attachmentIds) {
      this.attachmentIds = attachmentIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsInvoiceSaveDTOParam)) {
         return false;
      }

      LogisticsInvoiceSaveDTOParam other = (LogisticsInvoiceSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplierId = this.getSupplierId();
      Object other$supplierId = other.getSupplierId();
      if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
         Object this$applyUserId = this.getApplyUserId();
         Object other$applyUserId = other.getApplyUserId();
         if (this$applyUserId == null ? other$applyUserId == null : this$applyUserId.equals(other$applyUserId)) {
            Object this$paymentId = this.getPaymentId();
            Object other$paymentId = other.getPaymentId();
            if (this$paymentId == null ? other$paymentId == null : this$paymentId.equals(other$paymentId)) {
               Object this$supplierName = this.getSupplierName();
               Object other$supplierName = other.getSupplierName();
               if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                  Object this$invoiceAmount = this.getInvoiceAmount();
                  Object other$invoiceAmount = other.getInvoiceAmount();
                  if (this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount)) {
                     Object this$invoiceSerialNumber = this.getInvoiceSerialNumber();
                     Object other$invoiceSerialNumber = other.getInvoiceSerialNumber();
                     if (this$invoiceSerialNumber == null ? other$invoiceSerialNumber == null : this$invoiceSerialNumber.equals(other$invoiceSerialNumber)) {
                        Object this$receiveBank = this.getReceiveBank();
                        Object other$receiveBank = other.getReceiveBank();
                        if (this$receiveBank == null ? other$receiveBank == null : this$receiveBank.equals(other$receiveBank)) {
                           Object this$receiveBankAccount = this.getReceiveBankAccount();
                           Object other$receiveBankAccount = other.getReceiveBankAccount();
                           if (this$receiveBankAccount == null ? other$receiveBankAccount == null : this$receiveBankAccount.equals(other$receiveBankAccount)) {
                              Object this$applyUserName = this.getApplyUserName();
                              Object other$applyUserName = other.getApplyUserName();
                              if (this$applyUserName == null ? other$applyUserName == null : this$applyUserName.equals(other$applyUserName)) {
                                 Object this$invoiceDate = this.getInvoiceDate();
                                 Object other$invoiceDate = other.getInvoiceDate();
                                 if (this$invoiceDate == null ? other$invoiceDate == null : this$invoiceDate.equals(other$invoiceDate)) {
                                    Object this$paymentAmount = this.getPaymentAmount();
                                    Object other$paymentAmount = other.getPaymentAmount();
                                    if (this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount)) {
                                       Object this$openInvoiceAmount = this.getOpenInvoiceAmount();
                                       Object other$openInvoiceAmount = other.getOpenInvoiceAmount();
                                       if (this$openInvoiceAmount == null
                                          ? other$openInvoiceAmount == null
                                          : this$openInvoiceAmount.equals(other$openInvoiceAmount)) {
                                          Object this$attachmentIds = this.getAttachmentIds();
                                          Object other$attachmentIds = other.getAttachmentIds();
                                          return this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds);
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
      return other instanceof LogisticsInvoiceSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $applyUserId = this.getApplyUserId();
      result = result * 59 + ($applyUserId == null ? 43 : $applyUserId.hashCode());
      Object $paymentId = this.getPaymentId();
      result = result * 59 + ($paymentId == null ? 43 : $paymentId.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      result = result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
      Object $invoiceSerialNumber = this.getInvoiceSerialNumber();
      result = result * 59 + ($invoiceSerialNumber == null ? 43 : $invoiceSerialNumber.hashCode());
      Object $receiveBank = this.getReceiveBank();
      result = result * 59 + ($receiveBank == null ? 43 : $receiveBank.hashCode());
      Object $receiveBankAccount = this.getReceiveBankAccount();
      result = result * 59 + ($receiveBankAccount == null ? 43 : $receiveBankAccount.hashCode());
      Object $applyUserName = this.getApplyUserName();
      result = result * 59 + ($applyUserName == null ? 43 : $applyUserName.hashCode());
      Object $invoiceDate = this.getInvoiceDate();
      result = result * 59 + ($invoiceDate == null ? 43 : $invoiceDate.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $openInvoiceAmount = this.getOpenInvoiceAmount();
      result = result * 59 + ($openInvoiceAmount == null ? 43 : $openInvoiceAmount.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   @Override
   public String toString() {
      return "LogisticsInvoiceSaveDTOParam(supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ", invoiceSerialNumber="
         + this.getInvoiceSerialNumber()
         + ", receiveBank="
         + this.getReceiveBank()
         + ", receiveBankAccount="
         + this.getReceiveBankAccount()
         + ", applyUserId="
         + this.getApplyUserId()
         + ", applyUserName="
         + this.getApplyUserName()
         + ", invoiceDate="
         + this.getInvoiceDate()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", openInvoiceAmount="
         + this.getOpenInvoiceAmount()
         + ", paymentId="
         + this.getPaymentId()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ")";
   }
}
