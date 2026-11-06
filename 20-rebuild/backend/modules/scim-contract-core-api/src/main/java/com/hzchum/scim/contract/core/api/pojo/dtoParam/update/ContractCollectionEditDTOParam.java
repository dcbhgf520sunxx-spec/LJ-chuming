package com.hzchum.scim.contract.core.api.pojo.dtoParam.update;

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
public class ContractCollectionEditDTOParam {
   @ApiModelProperty(name = "id", value = "收款id")
   @NotNull(message = "收款填报id不能为空")
   private Long id;
   @ApiModelProperty(name = "collectionUnitId", value = "收款单位id")
   @NotNull(message = "收款单位id不能为空")
   private Long collectionUnitId;
   @ApiModelProperty(name = "collectionUnit", value = "收款单位")
   @NotBlank(message = "收款单位不能为空")
   private String collectionUnit;
   @ApiModelProperty(name = "collectionDepositBank", value = "收款行")
   private String collectionDepositBank;
   @ApiModelProperty(name = "collectionBankAccountId", value = "收款行账号id")
   private Long collectionBankAccountId;
   @ApiModelProperty(name = "collectionBankAccount", value = "收款行账号")
   private String collectionBankAccount;
   @ApiModelProperty(name = "collectionDate", value = "收款日期")
   @NotNull(message = "收款日期不能为空")
   private LocalDate collectionDate;
   @ApiModelProperty(name = "collectionMode", value = "收款方式")
   @NotNull(message = "收款方式不能为空")
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

   public static ContractCollectionEditDTOParam.ContractCollectionEditDTOParamBuilder builder() {
      return new ContractCollectionEditDTOParam.ContractCollectionEditDTOParamBuilder();
   }

   public ContractCollectionEditDTOParam() {
   }

   public ContractCollectionEditDTOParam(
      final Long id,
      final Long collectionUnitId,
      final String collectionUnit,
      final String collectionDepositBank,
      final Long collectionBankAccountId,
      final String collectionBankAccount,
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
      this.collectionUnitId = collectionUnitId;
      this.collectionUnit = collectionUnit;
      this.collectionDepositBank = collectionDepositBank;
      this.collectionBankAccountId = collectionBankAccountId;
      this.collectionBankAccount = collectionBankAccount;
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

   public Long getCollectionUnitId() {
      return this.collectionUnitId;
   }

   public String getCollectionUnit() {
      return this.collectionUnit;
   }

   public String getCollectionDepositBank() {
      return this.collectionDepositBank;
   }

   public Long getCollectionBankAccountId() {
      return this.collectionBankAccountId;
   }

   public String getCollectionBankAccount() {
      return this.collectionBankAccount;
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

   public void setCollectionUnitId(final Long collectionUnitId) {
      this.collectionUnitId = collectionUnitId;
   }

   public void setCollectionUnit(final String collectionUnit) {
      this.collectionUnit = collectionUnit;
   }

   public void setCollectionDepositBank(final String collectionDepositBank) {
      this.collectionDepositBank = collectionDepositBank;
   }

   public void setCollectionBankAccountId(final Long collectionBankAccountId) {
      this.collectionBankAccountId = collectionBankAccountId;
   }

   public void setCollectionBankAccount(final String collectionBankAccount) {
      this.collectionBankAccount = collectionBankAccount;
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

      if (!(o instanceof ContractCollectionEditDTOParam)) {
         return false;
      }

      ContractCollectionEditDTOParam other = (ContractCollectionEditDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
                  Object this$collectionUnit = this.getCollectionUnit();
                  Object other$collectionUnit = other.getCollectionUnit();
                  if (this$collectionUnit == null ? other$collectionUnit == null : this$collectionUnit.equals(other$collectionUnit)) {
                     Object this$collectionDepositBank = this.getCollectionDepositBank();
                     Object other$collectionDepositBank = other.getCollectionDepositBank();
                     if (this$collectionDepositBank == null
                        ? other$collectionDepositBank == null
                        : this$collectionDepositBank.equals(other$collectionDepositBank)) {
                        Object this$collectionBankAccount = this.getCollectionBankAccount();
                        Object other$collectionBankAccount = other.getCollectionBankAccount();
                        if (this$collectionBankAccount == null
                           ? other$collectionBankAccount == null
                           : this$collectionBankAccount.equals(other$collectionBankAccount)) {
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
      return other instanceof ContractCollectionEditDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $collectionUnitId = this.getCollectionUnitId();
      result = result * 59 + ($collectionUnitId == null ? 43 : $collectionUnitId.hashCode());
      Object $collectionBankAccountId = this.getCollectionBankAccountId();
      result = result * 59 + ($collectionBankAccountId == null ? 43 : $collectionBankAccountId.hashCode());
      Object $collectionMode = this.getCollectionMode();
      result = result * 59 + ($collectionMode == null ? 43 : $collectionMode.hashCode());
      Object $collectionUnit = this.getCollectionUnit();
      result = result * 59 + ($collectionUnit == null ? 43 : $collectionUnit.hashCode());
      Object $collectionDepositBank = this.getCollectionDepositBank();
      result = result * 59 + ($collectionDepositBank == null ? 43 : $collectionDepositBank.hashCode());
      Object $collectionBankAccount = this.getCollectionBankAccount();
      result = result * 59 + ($collectionBankAccount == null ? 43 : $collectionBankAccount.hashCode());
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
      return "ContractCollectionEditDTOParam(id="
         + this.getId()
         + ", collectionUnitId="
         + this.getCollectionUnitId()
         + ", collectionUnit="
         + this.getCollectionUnit()
         + ", collectionDepositBank="
         + this.getCollectionDepositBank()
         + ", collectionBankAccountId="
         + this.getCollectionBankAccountId()
         + ", collectionBankAccount="
         + this.getCollectionBankAccount()
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

   public static class ContractCollectionEditDTOParamBuilder {
      private Long id;
      private Long collectionUnitId;
      private String collectionUnit;
      private String collectionDepositBank;
      private Long collectionBankAccountId;
      private String collectionBankAccount;
      private LocalDate collectionDate;
      private Integer collectionMode;
      private List<AcceptanceDraftDTO> acceptanceDraftDTOList;
      private BigDecimal collectionAmount;
      private String collectionReason;
      private String paymentUnit;
      private String paymentDepositBank;
      private String paymentBankAccount;
      private String remark;

      ContractCollectionEditDTOParamBuilder() {
      }

      public ContractCollectionEditDTOParam.ContractCollectionEditDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractCollectionEditDTOParam.ContractCollectionEditDTOParamBuilder collectionUnitId(final Long collectionUnitId) {
         this.collectionUnitId = collectionUnitId;
         return this;
      }

      public ContractCollectionEditDTOParam.ContractCollectionEditDTOParamBuilder collectionUnit(final String collectionUnit) {
         this.collectionUnit = collectionUnit;
         return this;
      }

      public ContractCollectionEditDTOParam.ContractCollectionEditDTOParamBuilder collectionDepositBank(final String collectionDepositBank) {
         this.collectionDepositBank = collectionDepositBank;
         return this;
      }

      public ContractCollectionEditDTOParam.ContractCollectionEditDTOParamBuilder collectionBankAccountId(final Long collectionBankAccountId) {
         this.collectionBankAccountId = collectionBankAccountId;
         return this;
      }

      public ContractCollectionEditDTOParam.ContractCollectionEditDTOParamBuilder collectionBankAccount(final String collectionBankAccount) {
         this.collectionBankAccount = collectionBankAccount;
         return this;
      }

      public ContractCollectionEditDTOParam.ContractCollectionEditDTOParamBuilder collectionDate(final LocalDate collectionDate) {
         this.collectionDate = collectionDate;
         return this;
      }

      public ContractCollectionEditDTOParam.ContractCollectionEditDTOParamBuilder collectionMode(final Integer collectionMode) {
         this.collectionMode = collectionMode;
         return this;
      }

      public ContractCollectionEditDTOParam.ContractCollectionEditDTOParamBuilder acceptanceDraftDTOList(final List<AcceptanceDraftDTO> acceptanceDraftDTOList) {
         this.acceptanceDraftDTOList = acceptanceDraftDTOList;
         return this;
      }

      public ContractCollectionEditDTOParam.ContractCollectionEditDTOParamBuilder collectionAmount(final BigDecimal collectionAmount) {
         this.collectionAmount = collectionAmount;
         return this;
      }

      public ContractCollectionEditDTOParam.ContractCollectionEditDTOParamBuilder collectionReason(final String collectionReason) {
         this.collectionReason = collectionReason;
         return this;
      }

      public ContractCollectionEditDTOParam.ContractCollectionEditDTOParamBuilder paymentUnit(final String paymentUnit) {
         this.paymentUnit = paymentUnit;
         return this;
      }

      public ContractCollectionEditDTOParam.ContractCollectionEditDTOParamBuilder paymentDepositBank(final String paymentDepositBank) {
         this.paymentDepositBank = paymentDepositBank;
         return this;
      }

      public ContractCollectionEditDTOParam.ContractCollectionEditDTOParamBuilder paymentBankAccount(final String paymentBankAccount) {
         this.paymentBankAccount = paymentBankAccount;
         return this;
      }

      public ContractCollectionEditDTOParam.ContractCollectionEditDTOParamBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public ContractCollectionEditDTOParam build() {
         return new ContractCollectionEditDTOParam(
            this.id,
            this.collectionUnitId,
            this.collectionUnit,
            this.collectionDepositBank,
            this.collectionBankAccountId,
            this.collectionBankAccount,
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
         return "ContractCollectionEditDTOParam.ContractCollectionEditDTOParamBuilder(id="
            + this.id
            + ", collectionUnitId="
            + this.collectionUnitId
            + ", collectionUnit="
            + this.collectionUnit
            + ", collectionDepositBank="
            + this.collectionDepositBank
            + ", collectionBankAccountId="
            + this.collectionBankAccountId
            + ", collectionBankAccount="
            + this.collectionBankAccount
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
