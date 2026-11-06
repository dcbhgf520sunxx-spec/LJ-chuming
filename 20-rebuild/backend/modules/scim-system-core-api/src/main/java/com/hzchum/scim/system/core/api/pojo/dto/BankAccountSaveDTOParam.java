package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("开户行和银行账户 请求类")
public class BankAccountSaveDTOParam {
   @NotNull(message = "开户行不能为空")
   @ApiModelProperty("开户行")
   private String depositBank;
   @NotNull(message = "银行账户不能为空")
   @ApiModelProperty("银行账户")
   private String account;

   public String getDepositBank() {
      return this.depositBank;
   }

   public String getAccount() {
      return this.account;
   }

   public void setDepositBank(final String depositBank) {
      this.depositBank = depositBank;
   }

   public void setAccount(final String account) {
      this.account = account;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof BankAccountSaveDTOParam)) {
         return false;
      } else {
         BankAccountSaveDTOParam other = (BankAccountSaveDTOParam)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$depositBank = this.getDepositBank();
            Object other$depositBank = other.getDepositBank();
            if (this$depositBank == null ? other$depositBank == null : this$depositBank.equals(other$depositBank)) {
               Object this$account = this.getAccount();
               Object other$account = other.getAccount();
               return this$account == null ? other$account == null : this$account.equals(other$account);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BankAccountSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $depositBank = this.getDepositBank();
      result = result * 59 + ($depositBank == null ? 43 : $depositBank.hashCode());
      Object $account = this.getAccount();
      return result * 59 + ($account == null ? 43 : $account.hashCode());
   }

   @Override
   public String toString() {
      return "BankAccountSaveDTOParam(depositBank=" + this.getDepositBank() + ", account=" + this.getAccount() + ")";
   }
}
