package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import com.hzchum.scim.contract.core.api.pojo.dto.supplier.saveSupplierPaymentDto;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("采购订单新增付款-请求类(自合营)")
public class PurchasePaymentSaveParam {
   @NotNull(message = "付款日期不能为空")
   @ApiModelProperty("付款日期")
   private LocalDateTime applyDate;
   @ApiModelProperty("创建人id")
   private Long applicantId;
   @NotNull(message = "供应商id不能为空")
   @ApiModelProperty("供应商id")
   private Long supplierId;
   @NotEmpty(message = "采购订单列表不能为空")
   @ApiModelProperty("采购订单列表")
   private List<saveSupplierPaymentDto> supplierPayment;
   @ApiModelProperty("付款事由id")
   private String paymentReasonId;
   @ApiModelProperty(name = "paymentType", value = "付款类型", notes = "付款类型")
   private Integer paymentType;
   @ApiModelProperty("付款银行")
   private String paymentBank;
   @ApiModelProperty("付款账号")
   private String paymentBankAccount;
   @ApiModelProperty("附件id")
   @Size(max = 10, message = "附件数量超出限制!")
   private List<Long> attachmentId;
   @ApiModelProperty("备注")
   private String remark;

   public LocalDateTime getApplyDate() {
      return this.applyDate;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public List<saveSupplierPaymentDto> getSupplierPayment() {
      return this.supplierPayment;
   }

   public String getPaymentReasonId() {
      return this.paymentReasonId;
   }

   public Integer getPaymentType() {
      return this.paymentType;
   }

   public String getPaymentBank() {
      return this.paymentBank;
   }

   public String getPaymentBankAccount() {
      return this.paymentBankAccount;
   }

   public List<Long> getAttachmentId() {
      return this.attachmentId;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setApplyDate(final LocalDateTime applyDate) {
      this.applyDate = applyDate;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierPayment(final List<saveSupplierPaymentDto> supplierPayment) {
      this.supplierPayment = supplierPayment;
   }

   public void setPaymentReasonId(final String paymentReasonId) {
      this.paymentReasonId = paymentReasonId;
   }

   public void setPaymentType(final Integer paymentType) {
      this.paymentType = paymentType;
   }

   public void setPaymentBank(final String paymentBank) {
      this.paymentBank = paymentBank;
   }

   public void setPaymentBankAccount(final String paymentBankAccount) {
      this.paymentBankAccount = paymentBankAccount;
   }

   public void setAttachmentId(final List<Long> attachmentId) {
      this.attachmentId = attachmentId;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchasePaymentSaveParam)) {
         return false;
      }

      PurchasePaymentSaveParam other = (PurchasePaymentSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$applicantId = this.getApplicantId();
      Object other$applicantId = other.getApplicantId();
      if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$paymentType = this.getPaymentType();
            Object other$paymentType = other.getPaymentType();
            if (this$paymentType == null ? other$paymentType == null : this$paymentType.equals(other$paymentType)) {
               Object this$applyDate = this.getApplyDate();
               Object other$applyDate = other.getApplyDate();
               if (this$applyDate == null ? other$applyDate == null : this$applyDate.equals(other$applyDate)) {
                  Object this$supplierPayment = this.getSupplierPayment();
                  Object other$supplierPayment = other.getSupplierPayment();
                  if (this$supplierPayment == null ? other$supplierPayment == null : this$supplierPayment.equals(other$supplierPayment)) {
                     Object this$paymentReasonId = this.getPaymentReasonId();
                     Object other$paymentReasonId = other.getPaymentReasonId();
                     if (this$paymentReasonId == null ? other$paymentReasonId == null : this$paymentReasonId.equals(other$paymentReasonId)) {
                        Object this$paymentBank = this.getPaymentBank();
                        Object other$paymentBank = other.getPaymentBank();
                        if (this$paymentBank == null ? other$paymentBank == null : this$paymentBank.equals(other$paymentBank)) {
                           Object this$paymentBankAccount = this.getPaymentBankAccount();
                           Object other$paymentBankAccount = other.getPaymentBankAccount();
                           if (this$paymentBankAccount == null ? other$paymentBankAccount == null : this$paymentBankAccount.equals(other$paymentBankAccount)) {
                              Object this$attachmentId = this.getAttachmentId();
                              Object other$attachmentId = other.getAttachmentId();
                              if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof PurchasePaymentSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $paymentType = this.getPaymentType();
      result = result * 59 + ($paymentType == null ? 43 : $paymentType.hashCode());
      Object $applyDate = this.getApplyDate();
      result = result * 59 + ($applyDate == null ? 43 : $applyDate.hashCode());
      Object $supplierPayment = this.getSupplierPayment();
      result = result * 59 + ($supplierPayment == null ? 43 : $supplierPayment.hashCode());
      Object $paymentReasonId = this.getPaymentReasonId();
      result = result * 59 + ($paymentReasonId == null ? 43 : $paymentReasonId.hashCode());
      Object $paymentBank = this.getPaymentBank();
      result = result * 59 + ($paymentBank == null ? 43 : $paymentBank.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      result = result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "PurchasePaymentSaveParam(applyDate="
         + this.getApplyDate()
         + ", applicantId="
         + this.getApplicantId()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierPayment="
         + this.getSupplierPayment()
         + ", paymentReasonId="
         + this.getPaymentReasonId()
         + ", paymentType="
         + this.getPaymentType()
         + ", paymentBank="
         + this.getPaymentBank()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
