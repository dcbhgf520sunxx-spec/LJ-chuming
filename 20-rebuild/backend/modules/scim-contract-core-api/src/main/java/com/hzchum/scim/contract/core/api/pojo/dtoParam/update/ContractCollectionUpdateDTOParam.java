package com.hzchum.scim.contract.core.api.pojo.dtoParam.update;

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

@ApiModel("重新编辑 收款填报")
public class ContractCollectionUpdateDTOParam {
   @ApiModelProperty(name = "id", value = "收款id")
   @NotNull(message = "收款填报id不能为空")
   private Long id;
   @ApiModelProperty(name = "collectionBankAccountId", value = "收款行账号id")
   private Long collectionBankAccountId;
   @ApiModelProperty(name = "collectionDate", value = "收款日期")
   @NotNull(message = "收款日期不能为空")
   private LocalDate collectionDate;
   @ApiModelProperty(name = "collectionMode", value = "收款方式")
   @NotNull(message = "收款方式不能为空")
   @EnumValidator(value = PayTypeEnum.class, message = "收款方式有误!")
   private Integer collectionMode;
   @ApiModelProperty(name = "acceptanceDraftDTOList", value = "承兑汇票列表")
   private List<AcceptanceDraftDTO> acceptanceDraftDTOList;
   @ApiModelProperty(name = "collectionAmount", value = "本次收款金额")
   @NotNull(message = "本次收款金额不能为空")
   private BigDecimal collectionAmount;
   @ApiModelProperty(name = "collectionReason", value = "收款是由")
   @NotBlank(message = "收款是由不能为空")
   private String collectionReason;
   @ApiModelProperty(name = "paymentUnit", value = "付款单位")
   @NotBlank(message = "付款单位不能为空")
   private String paymentUnit;
   @ApiModelProperty(name = "paymentDepositBank", value = "付款方开户行")
   private String paymentDepositBank;
   @ApiModelProperty(name = "paymentBankAccount", value = "付款方银行账号")
   private String paymentBankAccount;
   @ApiModelProperty(name = "remark", value = "备注")
   @Size(max = 255, message = "备注字数超出限制!")
   private String remark;

   public static ContractCollectionUpdateDTOParam.ContractCollectionUpdateDTOParamBuilder builder() {
      return new ContractCollectionUpdateDTOParam.ContractCollectionUpdateDTOParamBuilder();
   }

   public ContractCollectionUpdateDTOParam() {
   }

   public ContractCollectionUpdateDTOParam(
      final Long id,
      final Long collectionBankAccountId,
      final LocalDate collectionDate,
      final Integer collectionMode,
      final List<AcceptanceDraftDTO> acceptanceDraftDTOList,
      final BigDecimal collectionAmount,
      final String collectionReason,
      final String paymentUnit,
      final String paymentDepositBank,
      final String paymentBankAccount,
      final String remark
   ) {
      this.id = id;
      this.collectionBankAccountId = collectionBankAccountId;
      this.collectionDate = collectionDate;
      this.collectionMode = collectionMode;
      this.acceptanceDraftDTOList = acceptanceDraftDTOList;
      this.collectionAmount = collectionAmount;
      this.collectionReason = collectionReason;
      this.paymentUnit = paymentUnit;
      this.paymentDepositBank = paymentDepositBank;
      this.paymentBankAccount = paymentBankAccount;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCollectionBankAccountId() {
      return this.collectionBankAccountId;
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

   public String getPaymentUnit() {
      return this.paymentUnit;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCollectionBankAccountId(final Long collectionBankAccountId) {
      this.collectionBankAccountId = collectionBankAccountId;
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

   public void setPaymentUnit(final String paymentUnit) {
      this.paymentUnit = paymentUnit;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractCollectionUpdateDTOParam)) {
         return false;
      }

      ContractCollectionUpdateDTOParam other = (ContractCollectionUpdateDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$collectionBankAccountId = this.getCollectionBankAccountId();
         Object other$collectionBankAccountId = other.getCollectionBankAccountId();
         if (this$collectionBankAccountId == null ? other$collectionBankAccountId == null : this$collectionBankAccountId.equals(other$collectionBankAccountId)) {
            Object this$collectionMode = this.getCollectionMode();
            Object other$collectionMode = other.getCollectionMode();
            if (this$collectionMode == null ? other$collectionMode == null : this$collectionMode.equals(other$collectionMode)) {
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
                           Object this$paymentUnit = this.getPaymentUnit();
                           Object other$paymentUnit = other.getPaymentUnit();
                           if (this$paymentUnit == null ? other$paymentUnit == null : this$paymentUnit.equals(other$paymentUnit)) {
                              Object this$paymentDepositBank = this.getPaymentDepositBank();
                              Object other$paymentDepositBank = other.getPaymentDepositBank();
                              if (this$paymentDepositBank == null ? other$paymentDepositBank == null : this$paymentDepositBank.equals(other$paymentDepositBank)
                                 )
                               {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractCollectionUpdateDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $collectionBankAccountId = this.getCollectionBankAccountId();
      result = result * 59 + ($collectionBankAccountId == null ? 43 : $collectionBankAccountId.hashCode());
      Object $collectionMode = this.getCollectionMode();
      result = result * 59 + ($collectionMode == null ? 43 : $collectionMode.hashCode());
      Object $collectionDate = this.getCollectionDate();
      result = result * 59 + ($collectionDate == null ? 43 : $collectionDate.hashCode());
      Object $acceptanceDraftDTOList = this.getAcceptanceDraftDTOList();
      result = result * 59 + ($acceptanceDraftDTOList == null ? 43 : $acceptanceDraftDTOList.hashCode());
      Object $collectionAmount = this.getCollectionAmount();
      result = result * 59 + ($collectionAmount == null ? 43 : $collectionAmount.hashCode());
      Object $collectionReason = this.getCollectionReason();
      result = result * 59 + ($collectionReason == null ? 43 : $collectionReason.hashCode());
      Object $paymentUnit = this.getPaymentUnit();
      result = result * 59 + ($paymentUnit == null ? 43 : $paymentUnit.hashCode());
      Object $paymentDepositBank = this.getPaymentDepositBank();
      result = result * 59 + ($paymentDepositBank == null ? 43 : $paymentDepositBank.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      result = result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "ContractCollectionUpdateDTOParam(id="
         + this.getId()
         + ", collectionBankAccountId="
         + this.getCollectionBankAccountId()
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
         + ", paymentUnit="
         + this.getPaymentUnit()
         + ", paymentDepositBank="
         + this.getPaymentDepositBank()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class ContractCollectionUpdateDTOParamBuilder {
      private Long id;
      private Long collectionBankAccountId;
      private LocalDate collectionDate;
      private Integer collectionMode;
      private List<AcceptanceDraftDTO> acceptanceDraftDTOList;
      private BigDecimal collectionAmount;
      private String collectionReason;
      private String paymentUnit;
      private String paymentDepositBank;
      private String paymentBankAccount;
      private String remark;

      ContractCollectionUpdateDTOParamBuilder() {
      }

      public ContractCollectionUpdateDTOParam.ContractCollectionUpdateDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractCollectionUpdateDTOParam.ContractCollectionUpdateDTOParamBuilder collectionBankAccountId(final Long collectionBankAccountId) {
         this.collectionBankAccountId = collectionBankAccountId;
         return this;
      }

      public ContractCollectionUpdateDTOParam.ContractCollectionUpdateDTOParamBuilder collectionDate(final LocalDate collectionDate) {
         this.collectionDate = collectionDate;
         return this;
      }

      public ContractCollectionUpdateDTOParam.ContractCollectionUpdateDTOParamBuilder collectionMode(final Integer collectionMode) {
         this.collectionMode = collectionMode;
         return this;
      }

      public ContractCollectionUpdateDTOParam.ContractCollectionUpdateDTOParamBuilder acceptanceDraftDTOList(
         final List<AcceptanceDraftDTO> acceptanceDraftDTOList
      ) {
         this.acceptanceDraftDTOList = acceptanceDraftDTOList;
         return this;
      }

      public ContractCollectionUpdateDTOParam.ContractCollectionUpdateDTOParamBuilder collectionAmount(final BigDecimal collectionAmount) {
         this.collectionAmount = collectionAmount;
         return this;
      }

      public ContractCollectionUpdateDTOParam.ContractCollectionUpdateDTOParamBuilder collectionReason(final String collectionReason) {
         this.collectionReason = collectionReason;
         return this;
      }

      public ContractCollectionUpdateDTOParam.ContractCollectionUpdateDTOParamBuilder paymentUnit(final String paymentUnit) {
         this.paymentUnit = paymentUnit;
         return this;
      }

      public ContractCollectionUpdateDTOParam.ContractCollectionUpdateDTOParamBuilder paymentDepositBank(final String paymentDepositBank) {
         this.paymentDepositBank = paymentDepositBank;
         return this;
      }

      public ContractCollectionUpdateDTOParam.ContractCollectionUpdateDTOParamBuilder paymentBankAccount(final String paymentBankAccount) {
         this.paymentBankAccount = paymentBankAccount;
         return this;
      }

      public ContractCollectionUpdateDTOParam.ContractCollectionUpdateDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractCollectionUpdateDTOParam build() {
         return new ContractCollectionUpdateDTOParam(
            this.id,
            this.collectionBankAccountId,
            this.collectionDate,
            this.collectionMode,
            this.acceptanceDraftDTOList,
            this.collectionAmount,
            this.collectionReason,
            this.paymentUnit,
            this.paymentDepositBank,
            this.paymentBankAccount,
            this.remark
         );
      }

      @Override
      public String toString() {
         return "ContractCollectionUpdateDTOParam.ContractCollectionUpdateDTOParamBuilder(id="
            + this.id
            + ", collectionBankAccountId="
            + this.collectionBankAccountId
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
            + ", paymentUnit="
            + this.paymentUnit
            + ", paymentDepositBank="
            + this.paymentDepositBank
            + ", paymentBankAccount="
            + this.paymentBankAccount
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
