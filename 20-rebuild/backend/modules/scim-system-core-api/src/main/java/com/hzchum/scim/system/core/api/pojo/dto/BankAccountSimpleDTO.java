package com.hzchum.scim.system.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class BankAccountSimpleDTO {
   @ApiModelProperty(name = "id", value = "银行账号id")
   private Long id;
   @ApiModelProperty(name = "depositBank", value = "开户行")
   private String depositBank;
   @ApiModelProperty(name = "account", value = "账号")
   private String account;

   public static BankAccountSimpleDTO.BankAccountSimpleDTOBuilder builder() {
      return new BankAccountSimpleDTO.BankAccountSimpleDTOBuilder();
   }

   public BankAccountSimpleDTO() {
   }

   public BankAccountSimpleDTO(final Long id, final String depositBank, final String account) {
      this.id = id;
      this.depositBank = depositBank;
      this.account = account;
   }

   public Long getId() {
      return this.id;
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

      if (!(o instanceof BankAccountSimpleDTO)) {
         return false;
      }

      BankAccountSimpleDTO other = (BankAccountSimpleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof BankAccountSimpleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $depositBank = this.getDepositBank();
      result = result * 59 + ($depositBank == null ? 43 : $depositBank.hashCode());
      Object $account = this.getAccount();
      return result * 59 + ($account == null ? 43 : $account.hashCode());
   }

   @Override
   public String toString() {
      return "BankAccountSimpleDTO(id=" + this.getId() + ", depositBank=" + this.getDepositBank() + ", account=" + this.getAccount() + ")";
   }

   public static class BankAccountSimpleDTOBuilder {
      private Long id;
      private String depositBank;
      private String account;

      BankAccountSimpleDTOBuilder() {
      }

      public BankAccountSimpleDTO.BankAccountSimpleDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public BankAccountSimpleDTO.BankAccountSimpleDTOBuilder depositBank(final String depositBank) {
         this.depositBank = depositBank;
         return this;
      }

      public BankAccountSimpleDTO.BankAccountSimpleDTOBuilder account(final String account) {
         this.account = account;
         return this;
      }

      public BankAccountSimpleDTO build() {
         return new BankAccountSimpleDTO(this.id, this.depositBank, this.account);
      }

      @Override
      public String toString() {
         return "BankAccountSimpleDTO.BankAccountSimpleDTOBuilder(id=" + this.id + ", depositBank=" + this.depositBank + ", account=" + this.account + ")";
      }
   }
}
