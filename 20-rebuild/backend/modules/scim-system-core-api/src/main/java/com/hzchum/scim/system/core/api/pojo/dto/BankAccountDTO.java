package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class BankAccountDTO {
   private Long id;
   @ApiModelProperty(name = "companyId", value = "公司id")
   private Long companyId;
   @ApiModelProperty(name = "companyName", value = "公司名称")
   private String companyName;
   @ApiModelProperty(name = "depositBank", value = "开户行")
   private String depositBank;
   @ApiModelProperty(name = "account", value = "银行账号")
   private String account;

   public Long getId() {
      return this.id;
   }

   public Long getCompanyId() {
      return this.companyId;
   }

   public String getCompanyName() {
      return this.companyName;
   }

   public String getDepositBank() {
      return this.depositBank;
   }

   public String getAccount() {
      return this.account;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setCompanyId(final Long companyId) {
      this.companyId = companyId;
   }

   public void setCompanyName(final String companyName) {
      this.companyName = companyName;
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
      }

      if (!(o instanceof BankAccountDTO)) {
         return false;
      }

      BankAccountDTO other = (BankAccountDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$companyId = this.getCompanyId();
         Object other$companyId = other.getCompanyId();
         if (this$companyId == null ? other$companyId == null : this$companyId.equals(other$companyId)) {
            Object this$companyName = this.getCompanyName();
            Object other$companyName = other.getCompanyName();
            if (this$companyName == null ? other$companyName == null : this$companyName.equals(other$companyName)) {
               Object this$depositBank = this.getDepositBank();
               Object other$depositBank = other.getDepositBank();
               if (this$depositBank == null ? other$depositBank == null : this$depositBank.equals(other$depositBank)) {
                  Object this$account = this.getAccount();
                  Object other$account = other.getAccount();
                  return this$account == null ? other$account == null : this$account.equals(other$account);
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
      return other instanceof BankAccountDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $companyId = this.getCompanyId();
      result = result * 59 + ($companyId == null ? 43 : $companyId.hashCode());
      Object $companyName = this.getCompanyName();
      result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
      Object $depositBank = this.getDepositBank();
      result = result * 59 + ($depositBank == null ? 43 : $depositBank.hashCode());
      Object $account = this.getAccount();
      return result * 59 + ($account == null ? 43 : $account.hashCode());
   }

   @Override
   public String toString() {
      return "BankAccountDTO(id="
         + this.getId()
         + ", companyId="
         + this.getCompanyId()
         + ", companyName="
         + this.getCompanyName()
         + ", depositBank="
         + this.getDepositBank()
         + ", account="
         + this.getAccount()
         + ")";
   }
}
