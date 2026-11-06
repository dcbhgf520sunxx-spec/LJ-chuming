package com.hzchum.scim.system.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "BankAccount对象", description = "")
@Entity
@TableName("sys_bank_account")
@Table(name = "sys_bank_account")
public class BankAccount extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "account", value = "账号")
   @JsonProperty("account")
   @JSONField(name = "account")
   @TableField("account")
   @Column(name = "account")
   private String account;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id")
   @JsonProperty("branchCompanyId")
   @JSONField(name = "branchCompanyId")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id")
   private Long branchCompanyId;
   @ApiModelProperty(name = "depositBank", value = "开户行")
   @JsonProperty("depositBank")
   @JSONField(name = "depositBank")
   @TableField("deposit_bank")
   @Column(name = "deposit_bank")
   private String depositBank;

   public static BankAccount.BankAccountBuilder builder() {
      return new BankAccount.BankAccountBuilder();
   }

   public BankAccount() {
   }

   public BankAccount(final Long id, final String account, final Long branchCompanyId, final String depositBank) {
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

   @JsonProperty("id")
   public BankAccount setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("account")
   public BankAccount setAccount(final String account) {
      this.account = account;
      return this;
   }

   @JsonProperty("branchCompanyId")
   public BankAccount setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   @JsonProperty("depositBank")
   public BankAccount setDepositBank(final String depositBank) {
      this.depositBank = depositBank;
      return this;
   }

   @Override
   public String toString() {
      return "BankAccount(id="
         + this.getId()
         + ", account="
         + this.getAccount()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", depositBank="
         + this.getDepositBank()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BankAccount)) {
         return false;
      }

      BankAccount other = (BankAccount)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof BankAccount;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $account = this.getAccount();
      result = result * 59 + ($account == null ? 43 : $account.hashCode());
      Object $depositBank = this.getDepositBank();
      return result * 59 + ($depositBank == null ? 43 : $depositBank.hashCode());
   }

   public static class BankAccountBuilder {
      private Long id;
      private String account;
      private Long branchCompanyId;
      private String depositBank;

      BankAccountBuilder() {
      }

      @JsonProperty("id")
      public BankAccount.BankAccountBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("account")
      public BankAccount.BankAccountBuilder account(final String account) {
         this.account = account;
         return this;
      }

      @JsonProperty("branchCompanyId")
      public BankAccount.BankAccountBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      @JsonProperty("depositBank")
      public BankAccount.BankAccountBuilder depositBank(final String depositBank) {
         this.depositBank = depositBank;
         return this;
      }

      public BankAccount build() {
         return new BankAccount(this.id, this.account, this.branchCompanyId, this.depositBank);
      }

      @Override
      public String toString() {
         return "BankAccount.BankAccountBuilder(id="
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
