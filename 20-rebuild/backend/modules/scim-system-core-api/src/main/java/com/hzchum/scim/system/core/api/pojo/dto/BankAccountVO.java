package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("BankAccount对象")
public class BankAccountVO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "account", value = "账号")
   private String account;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id")
   private Long branchCompanyId;
   @ApiModelProperty(name = "depositBank", value = "开户行")
   private String depositBank;

   public static BankAccountVO.BankAccountVOBuilder builder() {
      return new BankAccountVO.BankAccountVOBuilder();
   }

   public BankAccountVO() {
   }

   public BankAccountVO(final Long id, final String account, final Long branchCompanyId, final String depositBank) {
      this.id = id;
      this.account = account;
      this.branchCompanyId = branchCompanyId;
      this.depositBank = depositBank;
   }

   public Long getId() {
      return this.id;
   }

   public String getAccount() {
      return this.account;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getDepositBank() {
      return this.depositBank;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setAccount(final String account) {
      this.account = account;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setDepositBank(final String depositBank) {
      this.depositBank = depositBank;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BankAccountVO)) {
         return false;
      }

      BankAccountVO other = (BankAccountVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$account = this.getAccount();
            Object other$account = other.getAccount();
            if (this$account == null ? other$account == null : this$account.equals(other$account)) {
               Object this$depositBank = this.getDepositBank();
               Object other$depositBank = other.getDepositBank();
               return this$depositBank == null ? other$depositBank == null : this$depositBank.equals(other$depositBank);
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
      return other instanceof BankAccountVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $account = this.getAccount();
      result = result * 59 + ($account == null ? 43 : $account.hashCode());
      Object $depositBank = this.getDepositBank();
      return result * 59 + ($depositBank == null ? 43 : $depositBank.hashCode());
   }

   @Override
   public String toString() {
      return "BankAccountVO(id="
         + this.getId()
         + ", account="
         + this.getAccount()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", depositBank="
         + this.getDepositBank()
         + ")";
   }

   public static class BankAccountVOBuilder {
      private Long id;
      private String account;
      private Long branchCompanyId;
      private String depositBank;

      BankAccountVOBuilder() {
      }

      public BankAccountVO.BankAccountVOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BankAccountVO.BankAccountVOBuilder account(final String account) {
         this.account = account;
         return this;
      }

      public BankAccountVO.BankAccountVOBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public BankAccountVO.BankAccountVOBuilder depositBank(final String depositBank) {
         this.depositBank = depositBank;
         return this;
      }

      public BankAccountVO build() {
         return new BankAccountVO(this.id, this.account, this.branchCompanyId, this.depositBank);
      }

      @Override
      public String toString() {
         return "BankAccountVO.BankAccountVOBuilder(id="
            + this.id
            + ", account="
            + this.account
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", depositBank="
            + this.depositBank
            + ")";
      }
   }
}
