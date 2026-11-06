package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.contract.core.api.enums.PayTypeEnum;
import com.hzchum.scim.contract.core.api.pojo.dto.AcceptanceDraftDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("新增-废品出售收款")
public class ScrapCollectionSaveParam {
   @ApiModelProperty(name = "contractWasteId", value = "废料合同id")
   private Long contractWasteId;
   @ApiModelProperty(name = "collectionUnitId", value = "收款单位id")
   @NotNull(message = "收款单位id不能为空")
   private Long collectionUnitId;
   @ApiModelProperty(name = "collectionBankAccountId", value = "收款开户行账号id")
   private Long collectionBankAccountId;
   @ApiModelProperty(name = "collectionDepositBank", value = "收款开户行")
   private String collectionDepositBank;
   @ApiModelProperty(name = "collectionDate", value = "收款日期")
   @NotNull(message = "收款日期不能为空")
   private LocalDate collectionDate;
   @ApiModelProperty(name = "collectionMode", value = "收款方式")
   @NotNull(message = "收款方式不能为空")
   @EnumValidator(value = PayTypeEnum.class, message = "收款方式有误!")
   private Integer collectionMode;
   @ApiModelProperty(name = "acceptanceDraftDTOList", value = "承兑汇票列表")
   private List<AcceptanceDraftDTO> acceptanceDraftDTOList;
   @ApiModelProperty(name = "collectionAmount", value = "收款金额")
   @NotNull(message = "本次收款金额不能为空")
   private BigDecimal collectionAmount;
   @ApiModelProperty(name = "collectionReason", value = "收款是由")
   @NotBlank(message = "收款是由不能为空")
   private String collectionReason;
   @ApiModelProperty(name = "paymentDepositBank", value = "付款方开户行")
   private String paymentDepositBank;
   @ApiModelProperty(name = "paymentBankAccount", value = "付款方银行账号")
   private String paymentBankAccount;
   @ApiModelProperty(name = "remark", value = "备注")
   @Size(max = 255, message = "备注字数超出限制!")
   private String remark;
   @ApiModelProperty(name = "attachmentId", value = "附件列表")
   private List<Long> attachmentId;

   public static ScrapCollectionSaveParam.ScrapCollectionSaveParamBuilder builder() {
      return new ScrapCollectionSaveParam.ScrapCollectionSaveParamBuilder();
   }

   public ScrapCollectionSaveParam() {
   }

   public ScrapCollectionSaveParam(
      final Long contractWasteId,
      final Long collectionUnitId,
      final Long collectionBankAccountId,
      final String collectionDepositBank,
      final LocalDate collectionDate,
      final Integer collectionMode,
      final List<AcceptanceDraftDTO> acceptanceDraftDTOList,
      final BigDecimal collectionAmount,
      final String collectionReason,
      final String paymentDepositBank,
      final String paymentBankAccount,
      final String remark,
      final List<Long> attachmentId
   ) {
      this.contractWasteId = contractWasteId;
      this.collectionUnitId = collectionUnitId;
      this.collectionBankAccountId = collectionBankAccountId;
      this.collectionDepositBank = collectionDepositBank;
      this.collectionDate = collectionDate;
      this.collectionMode = collectionMode;
      this.acceptanceDraftDTOList = acceptanceDraftDTOList;
      this.collectionAmount = collectionAmount;
      this.collectionReason = collectionReason;
      this.paymentDepositBank = paymentDepositBank;
      this.paymentBankAccount = paymentBankAccount;
      this.remark = remark;
      this.attachmentId = attachmentId;
   }

   public Long getContractWasteId() {
      return this.contractWasteId;
   }

   public Long getCollectionUnitId() {
      return this.collectionUnitId;
   }

   public Long getCollectionBankAccountId() {
      return this.collectionBankAccountId;
   }

   public String getCollectionDepositBank() {
      return this.collectionDepositBank;
   }

   public LocalDate getCollectionDate() {
      return this.collectionDate;
   }

   public Integer getCollectionMode() {
      return this.collectionMode;
   }

   public List<AcceptanceDraftDTO> getAcceptanceDraftDTOList() {
      return this.acceptanceDraftDTOList;
   }

   public BigDecimal getCollectionAmount() {
      return this.collectionAmount;
   }

   public String getCollectionReason() {
      return this.collectionReason;
   }

   public String getPaymentDepositBank() {
      return this.paymentDepositBank;
   }

   public String getPaymentBankAccount() {
      return this.paymentBankAccount;
   }

   public String getRemark() {
      return this.remark;
   }

   public List<Long> getAttachmentId() {
      return this.attachmentId;
   }

   public void setContractWasteId(final Long contractWasteId) {
      this.contractWasteId = contractWasteId;
   }

   public void setCollectionUnitId(final Long collectionUnitId) {
      this.collectionUnitId = collectionUnitId;
   }

   public void setCollectionBankAccountId(final Long collectionBankAccountId) {
      this.collectionBankAccountId = collectionBankAccountId;
   }

   public void setCollectionDepositBank(final String collectionDepositBank) {
      this.collectionDepositBank = collectionDepositBank;
   }

   public void setCollectionDate(final LocalDate collectionDate) {
      this.collectionDate = collectionDate;
   }

   public void setCollectionMode(final Integer collectionMode) {
      this.collectionMode = collectionMode;
   }

   public void setAcceptanceDraftDTOList(final List<AcceptanceDraftDTO> acceptanceDraftDTOList) {
      this.acceptanceDraftDTOList = acceptanceDraftDTOList;
   }

   public void setCollectionAmount(final BigDecimal collectionAmount) {
      this.collectionAmount = collectionAmount;
   }

   public void setCollectionReason(final String collectionReason) {
      this.collectionReason = collectionReason;
   }

   public void setPaymentDepositBank(final String paymentDepositBank) {
      this.paymentDepositBank = paymentDepositBank;
   }

   public void setPaymentBankAccount(final String paymentBankAccount) {
      this.paymentBankAccount = paymentBankAccount;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setAttachmentId(final List<Long> attachmentId) {
      this.attachmentId = attachmentId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScrapCollectionSaveParam)) {
         return false;
      }

      ScrapCollectionSaveParam other = (ScrapCollectionSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$contractWasteId = this.getContractWasteId();
      Object other$contractWasteId = other.getContractWasteId();
      if (this$contractWasteId == null ? other$contractWasteId == null : this$contractWasteId.equals(other$contractWasteId)) {
         Object this$collectionUnitId = this.getCollectionUnitId();
         Object other$collectionUnitId = other.getCollectionUnitId();
         if (this$collectionUnitId == null ? other$collectionUnitId == null : this$collectionUnitId.equals(other$collectionUnitId)) {
            Object this$collectionBankAccountId = this.getCollectionBankAccountId();
            Object other$collectionBankAccountId = other.getCollectionBankAccountId();
            if (this$collectionBankAccountId == null
               ? other$collectionBankAccountId == null
               : this$collectionBankAccountId.equals(other$collectionBankAccountId)) {
               Object this$collectionMode = this.getCollectionMode();
               Object other$collectionMode = other.getCollectionMode();
               if (this$collectionMode == null ? other$collectionMode == null : this$collectionMode.equals(other$collectionMode)) {
                  Object this$collectionDepositBank = this.getCollectionDepositBank();
                  Object other$collectionDepositBank = other.getCollectionDepositBank();
                  if (this$collectionDepositBank == null ? other$collectionDepositBank == null : this$collectionDepositBank.equals(other$collectionDepositBank)
                     )
                   {
                     Object this$collectionDate = this.getCollectionDate();
                     Object other$collectionDate = other.getCollectionDate();
                     if (this$collectionDate == null ? other$collectionDate == null : this$collectionDate.equals(other$collectionDate)) {
                        Object this$acceptanceDraftDTOList = this.getAcceptanceDraftDTOList();
                        Object other$acceptanceDraftDTOList = other.getAcceptanceDraftDTOList();
                        if (this$acceptanceDraftDTOList == null
                           ? other$acceptanceDraftDTOList == null
                           : this$acceptanceDraftDTOList.equals(other$acceptanceDraftDTOList)) {
                           Object this$collectionAmount = this.getCollectionAmount();
                           Object other$collectionAmount = other.getCollectionAmount();
                           if (this$collectionAmount == null ? other$collectionAmount == null : this$collectionAmount.equals(other$collectionAmount)) {
                              Object this$collectionReason = this.getCollectionReason();
                              Object other$collectionReason = other.getCollectionReason();
                              if (this$collectionReason == null ? other$collectionReason == null : this$collectionReason.equals(other$collectionReason)) {
                                 Object this$paymentDepositBank = this.getPaymentDepositBank();
                                 Object other$paymentDepositBank = other.getPaymentDepositBank();
                                 if (this$paymentDepositBank == null
                                    ? other$paymentDepositBank == null
                                    : this$paymentDepositBank.equals(other$paymentDepositBank)) {
                                    Object this$paymentBankAccount = this.getPaymentBankAccount();
                                    Object other$paymentBankAccount = other.getPaymentBankAccount();
                                    if (this$paymentBankAccount == null
                                       ? other$paymentBankAccount == null
                                       : this$paymentBankAccount.equals(other$paymentBankAccount)) {
                                       Object this$remark = this.getRemark();
                                       Object other$remark = other.getRemark();
                                       if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                          Object this$attachmentId = this.getAttachmentId();
                                          Object other$attachmentId = other.getAttachmentId();
                                          return this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId);
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
      return other instanceof ScrapCollectionSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $contractWasteId = this.getContractWasteId();
      result = result * 59 + ($contractWasteId == null ? 43 : $contractWasteId.hashCode());
      Object $collectionUnitId = this.getCollectionUnitId();
      result = result * 59 + ($collectionUnitId == null ? 43 : $collectionUnitId.hashCode());
      Object $collectionBankAccountId = this.getCollectionBankAccountId();
      result = result * 59 + ($collectionBankAccountId == null ? 43 : $collectionBankAccountId.hashCode());
      Object $collectionMode = this.getCollectionMode();
      result = result * 59 + ($collectionMode == null ? 43 : $collectionMode.hashCode());
      Object $collectionDepositBank = this.getCollectionDepositBank();
      result = result * 59 + ($collectionDepositBank == null ? 43 : $collectionDepositBank.hashCode());
      Object $collectionDate = this.getCollectionDate();
      result = result * 59 + ($collectionDate == null ? 43 : $collectionDate.hashCode());
      Object $acceptanceDraftDTOList = this.getAcceptanceDraftDTOList();
      result = result * 59 + ($acceptanceDraftDTOList == null ? 43 : $acceptanceDraftDTOList.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $collectionReason = this.getCollectionReason();
      result = result * 59 + ($collectionReason == null ? 43 : $collectionReason.hashCode());
      Object $paymentDepositBank = this.getPaymentDepositBank();
      result = result * 59 + ($paymentDepositBank == null ? 43 : $paymentDepositBank.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      result = result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $attachmentId = this.getAttachmentId();
      return result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
   }

   @Override
   public String toString() {
      return "ScrapCollectionSaveParam(contractWasteId="
         + this.getContractWasteId()
         + ", collectionUnitId="
         + this.getCollectionUnitId()
         + ", collectionBankAccountId="
         + this.getCollectionBankAccountId()
         + ", collectionDepositBank="
         + this.getCollectionDepositBank()
         + ", collectionDate="
         + this.getCollectionDate()
         + ", collectionMode="
         + this.getCollectionMode()
         + ", acceptanceDraftDTOList="
         + this.getAcceptanceDraftDTOList()
         + ", collectionAmount="
         + this.getCollectionAmount()
         + ", collectionReason="
         + this.getCollectionReason()
         + ", paymentDepositBank="
         + this.getPaymentDepositBank()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ", remark="
         + this.getRemark()
         + ", attachmentId="
         + this.getAttachmentId()
         + ")";
   }

   public static class ScrapCollectionSaveParamBuilder {
      private Long contractWasteId;
      private Long collectionUnitId;
      private Long collectionBankAccountId;
      private String collectionDepositBank;
      private LocalDate collectionDate;
      private Integer collectionMode;
      private List<AcceptanceDraftDTO> acceptanceDraftDTOList;
      private BigDecimal collectionAmount;
      private String collectionReason;
      private String paymentDepositBank;
      private String paymentBankAccount;
      private String remark;
      private List<Long> attachmentId;

      ScrapCollectionSaveParamBuilder() {
      }

      public ScrapCollectionSaveParam.ScrapCollectionSaveParamBuilder contractWasteId(final Long contractWasteId) {
         this.contractWasteId = contractWasteId;
         return this;
      }

      public ScrapCollectionSaveParam.ScrapCollectionSaveParamBuilder collectionUnitId(final Long collectionUnitId) {
         this.collectionUnitId = collectionUnitId;
         return this;
      }

      public ScrapCollectionSaveParam.ScrapCollectionSaveParamBuilder collectionBankAccountId(final Long collectionBankAccountId) {
         this.collectionBankAccountId = collectionBankAccountId;
         return this;
      }

      public ScrapCollectionSaveParam.ScrapCollectionSaveParamBuilder collectionDepositBank(final String collectionDepositBank) {
         this.collectionDepositBank = collectionDepositBank;
         return this;
      }

      public ScrapCollectionSaveParam.ScrapCollectionSaveParamBuilder collectionDate(final LocalDate collectionDate) {
         this.collectionDate = collectionDate;
         return this;
      }

      public ScrapCollectionSaveParam.ScrapCollectionSaveParamBuilder collectionMode(final Integer collectionMode) {
         this.collectionMode = collectionMode;
         return this;
      }

      public ScrapCollectionSaveParam.ScrapCollectionSaveParamBuilder acceptanceDraftDTOList(final List<AcceptanceDraftDTO> acceptanceDraftDTOList) {
         this.acceptanceDraftDTOList = acceptanceDraftDTOList;
         return this;
      }

      public ScrapCollectionSaveParam.ScrapCollectionSaveParamBuilder collectionAmount(final BigDecimal collectionAmount) {
         this.collectionAmount = collectionAmount;
         return this;
      }

      public ScrapCollectionSaveParam.ScrapCollectionSaveParamBuilder collectionReason(final String collectionReason) {
         this.collectionReason = collectionReason;
         return this;
      }

      public ScrapCollectionSaveParam.ScrapCollectionSaveParamBuilder paymentDepositBank(final String paymentDepositBank) {
         this.paymentDepositBank = paymentDepositBank;
         return this;
      }

      public ScrapCollectionSaveParam.ScrapCollectionSaveParamBuilder paymentBankAccount(final String paymentBankAccount) {
         this.paymentBankAccount = paymentBankAccount;
         return this;
      }

      public ScrapCollectionSaveParam.ScrapCollectionSaveParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ScrapCollectionSaveParam.ScrapCollectionSaveParamBuilder attachmentId(final List<Long> attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public ScrapCollectionSaveParam build() {
         return new ScrapCollectionSaveParam(
            this.contractWasteId,
            this.collectionUnitId,
            this.collectionBankAccountId,
            this.collectionDepositBank,
            this.collectionDate,
            this.collectionMode,
            this.acceptanceDraftDTOList,
            this.collectionAmount,
            this.collectionReason,
            this.paymentDepositBank,
            this.paymentBankAccount,
            this.remark,
            this.attachmentId
         );
      }

      @Override
      public String toString() {
         return "ScrapCollectionSaveParam.ScrapCollectionSaveParamBuilder(contractWasteId="
            + this.contractWasteId
            + ", collectionUnitId="
            + this.collectionUnitId
            + ", collectionBankAccountId="
            + this.collectionBankAccountId
            + ", collectionDepositBank="
            + this.collectionDepositBank
            + ", collectionDate="
            + this.collectionDate
            + ", collectionMode="
            + this.collectionMode
            + ", acceptanceDraftDTOList="
            + this.acceptanceDraftDTOList
            + ", collectionAmount="
            + this.collectionAmount
            + ", collectionReason="
            + this.collectionReason
            + ", paymentDepositBank="
            + this.paymentDepositBank
            + ", paymentBankAccount="
            + this.paymentBankAccount
            + ", remark="
            + this.remark
            + ", attachmentId="
            + this.attachmentId
            + ")";
      }
   }
}
