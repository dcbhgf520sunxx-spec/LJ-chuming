package com.hzchum.scim.contract.core.api.pojo.dtoParam.supplier;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("采购订单新增付款-请求类(内包制)")
public class PurchaseSupplierPaymentInsourcingAddDTOParam {
   @NotNull(message = "采购id不能为空")
   @ApiModelProperty("采购id")
   private Long orderId;
   @ApiModelProperty("付款id")
   private Long paymentId;
   @NotNull(message = "付款日期不能为空")
   @ApiModelProperty("付款日期")
   private LocalDateTime applyDate;
   @ApiModelProperty("申请人id")
   private Long applicantId;
   @NotNull(message = "项目id不能为空")
   @ApiModelProperty("项目id")
   private Long projectId;
   @NotNull(message = "项目经理id不能为空")
   @ApiModelProperty("项目经理id")
   private Long projectManagerId;
   @NotNull(message = "供应商id不能为空")
   @ApiModelProperty("供应商id")
   private Long supplierId;
   @NotNull(message = "采购合同号不能为空")
   @ApiModelProperty("采购合同号")
   private String purchaseContractNumber;
   @NotNull(message = "本次付款额不能为空")
   @DecimalMin(value = "0.01", message = "付款额不能小于0.01")
   @ApiModelProperty("本次付款额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("付款事由id")
   @NotBlank(message = "付款事由不能为空")
   private String paymentReasonId;
   @ApiModelProperty("付款银行")
   private String paymentBank;
   @ApiModelProperty("付款账号")
   private String paymentBankAccount;
   @ApiModelProperty("附件id")
   private Long attachmentId;
   @ApiModelProperty("付款类型")
   private Integer paymentEnum;
   @ApiModelProperty("备注")
   @Size(max = 1000, message = "备注不能超过1000个字符")
   private String remark;

   PurchaseSupplierPaymentInsourcingAddDTOParam(
      final Long orderId,
      final Long paymentId,
      final LocalDateTime applyDate,
      final Long applicantId,
      final Long projectId,
      final Long projectManagerId,
      final Long supplierId,
      final String purchaseContractNumber,
      final BigDecimal paymentAmount,
      final String paymentReasonId,
      final String paymentBank,
      final String paymentBankAccount,
      final Long attachmentId,
      final Integer paymentEnum,
      final String remark
   ) {
      this.orderId = orderId;
      this.paymentId = paymentId;
      this.applyDate = applyDate;
      this.applicantId = applicantId;
      this.projectId = projectId;
      this.projectManagerId = projectManagerId;
      this.supplierId = supplierId;
      this.purchaseContractNumber = purchaseContractNumber;
      this.paymentAmount = paymentAmount;
      this.paymentReasonId = paymentReasonId;
      this.paymentBank = paymentBank;
      this.paymentBankAccount = paymentBankAccount;
      this.attachmentId = attachmentId;
      this.paymentEnum = paymentEnum;
      this.remark = remark;
   }

   public static PurchaseSupplierPaymentInsourcingAddDTOParam.PurchaseSupplierPaymentInsourcingAddDTOParamBuilder builder() {
      return new PurchaseSupplierPaymentInsourcingAddDTOParam.PurchaseSupplierPaymentInsourcingAddDTOParamBuilder();
   }

   public Long getOrderId() {
      return this.orderId;
   }

   public Long getPaymentId() {
      return this.paymentId;
   }

   public LocalDateTime getApplyDate() {
      return this.applyDate;
   }

   public Long getApplicantId() {
      return this.applicantId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getPurchaseContractNumber() {
      return this.purchaseContractNumber;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public String getPaymentReasonId() {
      return this.paymentReasonId;
   }

   public String getPaymentBank() {
      return this.paymentBank;
   }

   public String getPaymentBankAccount() {
      return this.paymentBankAccount;
   }

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public Integer getPaymentEnum() {
      return this.paymentEnum;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setOrderId(final Long orderId) {
      this.orderId = orderId;
   }

   public void setPaymentId(final Long paymentId) {
      this.paymentId = paymentId;
   }

   public void setApplyDate(final LocalDateTime applyDate) {
      this.applyDate = applyDate;
   }

   public void setApplicantId(final Long applicantId) {
      this.applicantId = applicantId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setPurchaseContractNumber(final String purchaseContractNumber) {
      this.purchaseContractNumber = purchaseContractNumber;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setPaymentReasonId(final String paymentReasonId) {
      this.paymentReasonId = paymentReasonId;
   }

   public void setPaymentBank(final String paymentBank) {
      this.paymentBank = paymentBank;
   }

   public void setPaymentBankAccount(final String paymentBankAccount) {
      this.paymentBankAccount = paymentBankAccount;
   }

   public void setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
   }

   public void setPaymentEnum(final Integer paymentEnum) {
      this.paymentEnum = paymentEnum;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PurchaseSupplierPaymentInsourcingAddDTOParam)) {
         return false;
      }

      PurchaseSupplierPaymentInsourcingAddDTOParam other = (PurchaseSupplierPaymentInsourcingAddDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderId = this.getOrderId();
      Object other$orderId = other.getOrderId();
      if (this$orderId == null ? other$orderId == null : this$orderId.equals(other$orderId)) {
         Object this$paymentId = this.getPaymentId();
         Object other$paymentId = other.getPaymentId();
         if (this$paymentId == null ? other$paymentId == null : this$paymentId.equals(other$paymentId)) {
            Object this$applicantId = this.getApplicantId();
            Object other$applicantId = other.getApplicantId();
            if (this$applicantId == null ? other$applicantId == null : this$applicantId.equals(other$applicantId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$projectManagerId = this.getProjectManagerId();
                  Object other$projectManagerId = other.getProjectManagerId();
                  if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                     Object this$supplierId = this.getSupplierId();
                     Object other$supplierId = other.getSupplierId();
                     if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                        Object this$attachmentId = this.getAttachmentId();
                        Object other$attachmentId = other.getAttachmentId();
                        if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
                           Object this$paymentEnum = this.getPaymentEnum();
                           Object other$paymentEnum = other.getPaymentEnum();
                           if (this$paymentEnum == null ? other$paymentEnum == null : this$paymentEnum.equals(other$paymentEnum)) {
                              Object this$applyDate = this.getApplyDate();
                              Object other$applyDate = other.getApplyDate();
                              if (this$applyDate == null ? other$applyDate == null : this$applyDate.equals(other$applyDate)) {
                                 Object this$purchaseContractNumber = this.getPurchaseContractNumber();
                                 Object other$purchaseContractNumber = other.getPurchaseContractNumber();
                                 if (this$purchaseContractNumber == null
                                    ? other$purchaseContractNumber == null
                                    : this$purchaseContractNumber.equals(other$purchaseContractNumber)) {
                                    Object this$paymentAmount = this.getPaymentAmount();
                                    Object other$paymentAmount = other.getPaymentAmount();
                                    if (this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount)) {
                                       Object this$paymentReasonId = this.getPaymentReasonId();
                                       Object other$paymentReasonId = other.getPaymentReasonId();
                                       if (this$paymentReasonId == null ? other$paymentReasonId == null : this$paymentReasonId.equals(other$paymentReasonId)) {
                                          Object this$paymentBank = this.getPaymentBank();
                                          Object other$paymentBank = other.getPaymentBank();
                                          if (this$paymentBank == null ? other$paymentBank == null : this$paymentBank.equals(other$paymentBank)) {
                                             Object this$paymentBankAccount = this.getPaymentBankAccount();
                                             Object other$paymentBankAccount = other.getPaymentBankAccount();
                                             if (this$paymentBankAccount == null
                                                ? other$paymentBankAccount == null
                                                : this$paymentBankAccount.equals(other$paymentBankAccount)) {
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
      return other instanceof PurchaseSupplierPaymentInsourcingAddDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderId = this.getOrderId();
      result = result * 59 + ($orderId == null ? 43 : $orderId.hashCode());
      Object $paymentId = this.getPaymentId();
      result = result * 59 + ($paymentId == null ? 43 : $paymentId.hashCode());
      Object $applicantId = this.getApplicantId();
      result = result * 59 + ($applicantId == null ? 43 : $applicantId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $paymentEnum = this.getPaymentEnum();
      result = result * 59 + ($paymentEnum == null ? 43 : $paymentEnum.hashCode());
      Object $applyDate = this.getApplyDate();
      result = result * 59 + ($applyDate == null ? 43 : $applyDate.hashCode());
      Object $purchaseContractNumber = this.getPurchaseContractNumber();
      result = result * 59 + ($purchaseContractNumber == null ? 43 : $purchaseContractNumber.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $paymentReasonId = this.getPaymentReasonId();
      result = result * 59 + ($paymentReasonId == null ? 43 : $paymentReasonId.hashCode());
      Object $paymentBank = this.getPaymentBank();
      result = result * 59 + ($paymentBank == null ? 43 : $paymentBank.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      result = result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "PurchaseSupplierPaymentInsourcingAddDTOParam(orderId="
         + this.getOrderId()
         + ", paymentId="
         + this.getPaymentId()
         + ", applyDate="
         + this.getApplyDate()
         + ", applicantId="
         + this.getApplicantId()
         + ", projectId="
         + this.getProjectId()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", supplierId="
         + this.getSupplierId()
         + ", purchaseContractNumber="
         + this.getPurchaseContractNumber()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", paymentReasonId="
         + this.getPaymentReasonId()
         + ", paymentBank="
         + this.getPaymentBank()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", paymentEnum="
         + this.getPaymentEnum()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class PurchaseSupplierPaymentInsourcingAddDTOParamBuilder {
      private Long orderId;
      private Long paymentId;
      private LocalDateTime applyDate;
      private Long applicantId;
      private Long projectId;
      private Long projectManagerId;
      private Long supplierId;
      private String purchaseContractNumber;
      private BigDecimal paymentAmount;
      private String paymentReasonId;
      private String paymentBank;
      private String paymentBankAccount;
      private Long attachmentId;
      private Integer paymentEnum;
      private String remark;

      PurchaseSupplierPaymentInsourcingAddDTOParamBuilder() {
      }

      public PurchaseSupplierPaymentInsourcingAddDTOParam.PurchaseSupplierPaymentInsourcingAddDTOParamBuilder orderId(final Long orderId) {
         this.orderId = orderId;
         return this;
      }

      public PurchaseSupplierPaymentInsourcingAddDTOParam.PurchaseSupplierPaymentInsourcingAddDTOParamBuilder paymentId(final Long paymentId) {
         this.paymentId = paymentId;
         return this;
      }

      public PurchaseSupplierPaymentInsourcingAddDTOParam.PurchaseSupplierPaymentInsourcingAddDTOParamBuilder applyDate(final LocalDateTime applyDate) {
         this.applyDate = applyDate;
         return this;
      }

      public PurchaseSupplierPaymentInsourcingAddDTOParam.PurchaseSupplierPaymentInsourcingAddDTOParamBuilder applicantId(final Long applicantId) {
         this.applicantId = applicantId;
         return this;
      }

      public PurchaseSupplierPaymentInsourcingAddDTOParam.PurchaseSupplierPaymentInsourcingAddDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public PurchaseSupplierPaymentInsourcingAddDTOParam.PurchaseSupplierPaymentInsourcingAddDTOParamBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public PurchaseSupplierPaymentInsourcingAddDTOParam.PurchaseSupplierPaymentInsourcingAddDTOParamBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public PurchaseSupplierPaymentInsourcingAddDTOParam.PurchaseSupplierPaymentInsourcingAddDTOParamBuilder purchaseContractNumber(
         final String purchaseContractNumber
      ) {
         this.purchaseContractNumber = purchaseContractNumber;
         return this;
      }

      public PurchaseSupplierPaymentInsourcingAddDTOParam.PurchaseSupplierPaymentInsourcingAddDTOParamBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public PurchaseSupplierPaymentInsourcingAddDTOParam.PurchaseSupplierPaymentInsourcingAddDTOParamBuilder paymentReasonId(final String paymentReasonId) {
         this.paymentReasonId = paymentReasonId;
         return this;
      }

      public PurchaseSupplierPaymentInsourcingAddDTOParam.PurchaseSupplierPaymentInsourcingAddDTOParamBuilder paymentBank(final String paymentBank) {
         this.paymentBank = paymentBank;
         return this;
      }

      public PurchaseSupplierPaymentInsourcingAddDTOParam.PurchaseSupplierPaymentInsourcingAddDTOParamBuilder paymentBankAccount(
         final String paymentBankAccount
      ) {
         this.paymentBankAccount = paymentBankAccount;
         return this;
      }

      public PurchaseSupplierPaymentInsourcingAddDTOParam.PurchaseSupplierPaymentInsourcingAddDTOParamBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public PurchaseSupplierPaymentInsourcingAddDTOParam.PurchaseSupplierPaymentInsourcingAddDTOParamBuilder paymentEnum(final Integer paymentEnum) {
         this.paymentEnum = paymentEnum;
         return this;
      }

      public PurchaseSupplierPaymentInsourcingAddDTOParam.PurchaseSupplierPaymentInsourcingAddDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public PurchaseSupplierPaymentInsourcingAddDTOParam build() {
         return new PurchaseSupplierPaymentInsourcingAddDTOParam(
            this.orderId,
            this.paymentId,
            this.applyDate,
            this.applicantId,
            this.projectId,
            this.projectManagerId,
            this.supplierId,
            this.purchaseContractNumber,
            this.paymentAmount,
            this.paymentReasonId,
            this.paymentBank,
            this.paymentBankAccount,
            this.attachmentId,
            this.paymentEnum,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "PurchaseSupplierPaymentInsourcingAddDTOParam.PurchaseSupplierPaymentInsourcingAddDTOParamBuilder(orderId="
            + this.orderId
            + ", paymentId="
            + this.paymentId
            + ", applyDate="
            + this.applyDate
            + ", applicantId="
            + this.applicantId
            + ", projectId="
            + this.projectId
            + ", projectManagerId="
            + this.projectManagerId
            + ", supplierId="
            + this.supplierId
            + ", purchaseContractNumber="
            + this.purchaseContractNumber
            + ", paymentAmount="
            + this.paymentAmount
            + ", paymentReasonId="
            + this.paymentReasonId
            + ", paymentBank="
            + this.paymentBank
            + ", paymentBankAccount="
            + this.paymentBankAccount
            + ", attachmentId="
            + this.attachmentId
            + ", paymentEnum="
            + this.paymentEnum
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
