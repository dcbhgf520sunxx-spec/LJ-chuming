package com.hzchum.scim.contract.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@ApiModel("报销表-确认类")
public class ReimbursementConfirmDTOParam {
   @ApiModelProperty(name = "id", value = "报销id")
   @NotNull(message = "项目id不能为空")
   private Long id;
   @ApiModelProperty(name = "actuallyPayAmount", value = "实付金额")
   private BigDecimal actuallyPayAmount;
   @ApiModelProperty(name = "confirmStatus", value = "确认状态 2确认 4退回")
   @NotNull(message = "确认状态不能为空")
   @Min(value = 2L, message = "确认状态不正确")
   @Max(value = 4L, message = "确认状态不正确")
   private Integer confirmStatus;
   @ApiModelProperty(name = "paymentUnitId", value = "付款单位id")
   private Long paymentUnitId;
   @ApiModelProperty(name = "paymentUnit", value = "付款单位")
   private String paymentUnit;
   @ApiModelProperty(name = "paymentDepositBank", value = "付款开户行")
   private String paymentDepositBank;
   @ApiModelProperty(name = "paymentBankAccount", value = "付款账号")
   private String paymentBankAccount;
   @ApiModelProperty("确认明细列表")
   private List<ReimbursementDetailConfirmDTOParam> detailConfirmDTOParamList;

   public static ReimbursementConfirmDTOParam.ReimbursementConfirmDTOParamBuilder builder() {
      return new ReimbursementConfirmDTOParam.ReimbursementConfirmDTOParamBuilder();
   }

   public ReimbursementConfirmDTOParam() {
   }

   public ReimbursementConfirmDTOParam(
      final Long id,
      final BigDecimal actuallyPayAmount,
      final Integer confirmStatus,
      final Long paymentUnitId,
      final String paymentUnit,
      final String paymentDepositBank,
      final String paymentBankAccount,
      final List<ReimbursementDetailConfirmDTOParam> detailConfirmDTOParamList
   ) {
      this.id = id;
      this.actuallyPayAmount = actuallyPayAmount;
      this.confirmStatus = confirmStatus;
      this.paymentUnitId = paymentUnitId;
      this.paymentUnit = paymentUnit;
      this.paymentDepositBank = paymentDepositBank;
      this.paymentBankAccount = paymentBankAccount;
      this.detailConfirmDTOParamList = detailConfirmDTOParamList;
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getActuallyPayAmount() {
      return this.actuallyPayAmount;
   }

   public Integer getConfirmStatus() {
      return this.confirmStatus;
   }

   public Long getPaymentUnitId() {
      return this.paymentUnitId;
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

   public List<ReimbursementDetailConfirmDTOParam> getDetailConfirmDTOParamList() {
      return this.detailConfirmDTOParamList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setActuallyPayAmount(final BigDecimal actuallyPayAmount) {
      this.actuallyPayAmount = actuallyPayAmount;
   }

   public void setConfirmStatus(final Integer confirmStatus) {
      this.confirmStatus = confirmStatus;
   }

   public void setPaymentUnitId(final Long paymentUnitId) {
      this.paymentUnitId = paymentUnitId;
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

   public void setDetailConfirmDTOParamList(final List<ReimbursementDetailConfirmDTOParam> detailConfirmDTOParamList) {
      this.detailConfirmDTOParamList = detailConfirmDTOParamList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReimbursementConfirmDTOParam)) {
         return false;
      }

      ReimbursementConfirmDTOParam other = (ReimbursementConfirmDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$confirmStatus = this.getConfirmStatus();
         Object other$confirmStatus = other.getConfirmStatus();
         if (this$confirmStatus == null ? other$confirmStatus == null : this$confirmStatus.equals(other$confirmStatus)) {
            Object this$paymentUnitId = this.getPaymentUnitId();
            Object other$paymentUnitId = other.getPaymentUnitId();
            if (this$paymentUnitId == null ? other$paymentUnitId == null : this$paymentUnitId.equals(other$paymentUnitId)) {
               Object this$actuallyPayAmount = this.getActuallyPayAmount();
               Object other$actuallyPayAmount = other.getActuallyPayAmount();
               if (this$actuallyPayAmount == null ? other$actuallyPayAmount == null : this$actuallyPayAmount.equals(other$actuallyPayAmount)) {
                  Object this$paymentUnit = this.getPaymentUnit();
                  Object other$paymentUnit = other.getPaymentUnit();
                  if (this$paymentUnit == null ? other$paymentUnit == null : this$paymentUnit.equals(other$paymentUnit)) {
                     Object this$paymentDepositBank = this.getPaymentDepositBank();
                     Object other$paymentDepositBank = other.getPaymentDepositBank();
                     if (this$paymentDepositBank == null ? other$paymentDepositBank == null : this$paymentDepositBank.equals(other$paymentDepositBank)) {
                        Object this$paymentBankAccount = this.getPaymentBankAccount();
                        Object other$paymentBankAccount = other.getPaymentBankAccount();
                        if (this$paymentBankAccount == null ? other$paymentBankAccount == null : this$paymentBankAccount.equals(other$paymentBankAccount)) {
                           Object this$detailConfirmDTOParamList = this.getDetailConfirmDTOParamList();
                           Object other$detailConfirmDTOParamList = other.getDetailConfirmDTOParamList();
                           return this$detailConfirmDTOParamList == null
                              ? other$detailConfirmDTOParamList == null
                              : this$detailConfirmDTOParamList.equals(other$detailConfirmDTOParamList);
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
      return other instanceof ReimbursementConfirmDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $confirmStatus = this.getConfirmStatus();
      result = result * 59 + ($confirmStatus == null ? 43 : $confirmStatus.hashCode());
      Object $paymentUnitId = this.getPaymentUnitId();
      result = result * 59 + ($paymentUnitId == null ? 43 : $paymentUnitId.hashCode());
      Object $actuallyPayAmount = this.getActuallyPayAmount();
      result = result * 59 + ($actuallyPayAmount == null ? 43 : $actuallyPayAmount.hashCode());
      Object $paymentUnit = this.getPaymentUnit();
      result = result * 59 + ($paymentUnit == null ? 43 : $paymentUnit.hashCode());
      Object $paymentDepositBank = this.getPaymentDepositBank();
      result = result * 59 + ($paymentDepositBank == null ? 43 : $paymentDepositBank.hashCode());
      Object $paymentBankAccount = this.getPaymentBankAccount();
      result = result * 59 + ($paymentBankAccount == null ? 43 : $paymentBankAccount.hashCode());
      Object $detailConfirmDTOParamList = this.getDetailConfirmDTOParamList();
      return result * 59 + ($detailConfirmDTOParamList == null ? 43 : $detailConfirmDTOParamList.hashCode());
   }

   @Override
   public String toString() {
      return "ReimbursementConfirmDTOParam(id="
         + this.getId()
         + ", actuallyPayAmount="
         + this.getActuallyPayAmount()
         + ", confirmStatus="
         + this.getConfirmStatus()
         + ", paymentUnitId="
         + this.getPaymentUnitId()
         + ", paymentUnit="
         + this.getPaymentUnit()
         + ", paymentDepositBank="
         + this.getPaymentDepositBank()
         + ", paymentBankAccount="
         + this.getPaymentBankAccount()
         + ", detailConfirmDTOParamList="
         + this.getDetailConfirmDTOParamList()
         + ")";
   }

   public static class ReimbursementConfirmDTOParamBuilder {
      private Long id;
      private BigDecimal actuallyPayAmount;
      private Integer confirmStatus;
      private Long paymentUnitId;
      private String paymentUnit;
      private String paymentDepositBank;
      private String paymentBankAccount;
      private List<ReimbursementDetailConfirmDTOParam> detailConfirmDTOParamList;

      ReimbursementConfirmDTOParamBuilder() {
      }

      public ReimbursementConfirmDTOParam.ReimbursementConfirmDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ReimbursementConfirmDTOParam.ReimbursementConfirmDTOParamBuilder actuallyPayAmount(final BigDecimal actuallyPayAmount) {
         this.actuallyPayAmount = actuallyPayAmount;
         return this;
      }

      public ReimbursementConfirmDTOParam.ReimbursementConfirmDTOParamBuilder confirmStatus(final Integer confirmStatus) {
         this.confirmStatus = confirmStatus;
         return this;
      }

      public ReimbursementConfirmDTOParam.ReimbursementConfirmDTOParamBuilder paymentUnitId(final Long paymentUnitId) {
         this.paymentUnitId = paymentUnitId;
         return this;
      }

      public ReimbursementConfirmDTOParam.ReimbursementConfirmDTOParamBuilder paymentUnit(final String paymentUnit) {
         this.paymentUnit = paymentUnit;
         return this;
      }

      public ReimbursementConfirmDTOParam.ReimbursementConfirmDTOParamBuilder paymentDepositBank(final String paymentDepositBank) {
         this.paymentDepositBank = paymentDepositBank;
         return this;
      }

      public ReimbursementConfirmDTOParam.ReimbursementConfirmDTOParamBuilder paymentBankAccount(final String paymentBankAccount) {
         this.paymentBankAccount = paymentBankAccount;
         return this;
      }

      public ReimbursementConfirmDTOParam.ReimbursementConfirmDTOParamBuilder detailConfirmDTOParamList(
         final List<ReimbursementDetailConfirmDTOParam> detailConfirmDTOParamList
      ) {
         this.detailConfirmDTOParamList = detailConfirmDTOParamList;
         return this;
      }

      public ReimbursementConfirmDTOParam build() {
         return new ReimbursementConfirmDTOParam(
            this.id,
            this.actuallyPayAmount,
            this.confirmStatus,
            this.paymentUnitId,
            this.paymentUnit,
            this.paymentDepositBank,
            this.paymentBankAccount,
            this.detailConfirmDTOParamList
         );
      }

      @Override
      public String toString() {
         return "ReimbursementConfirmDTOParam.ReimbursementConfirmDTOParamBuilder(id="
            + this.id
            + ", actuallyPayAmount="
            + this.actuallyPayAmount
            + ", confirmStatus="
            + this.confirmStatus
            + ", paymentUnitId="
            + this.paymentUnitId
            + ", paymentUnit="
            + this.paymentUnit
            + ", paymentDepositBank="
            + this.paymentDepositBank
            + ", paymentBankAccount="
            + this.paymentBankAccount
            + ", detailConfirmDTOParamList="
            + this.detailConfirmDTOParamList
            + ")";
      }
   }
}
