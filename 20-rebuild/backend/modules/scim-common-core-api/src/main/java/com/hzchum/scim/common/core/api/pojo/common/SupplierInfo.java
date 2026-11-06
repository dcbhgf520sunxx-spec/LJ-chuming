package com.hzchum.scim.common.core.api.pojo.common;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("供应商info类")
public class SupplierInfo {
   @ApiModelProperty(name = "supplierId", value = "分包单位(供应商)id", notes = "分包单位(供应商)id")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "分包单位(供应商)", notes = "分包单位(供应商)")
   private String supplierName;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "supplierNumber", notes = "供应商编号")
   private String supplierNumber;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "socialCode", notes = "社会统一代码")
   private String socialCode;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "bankName", notes = "开户行名称")
   private String bankName;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "bankAccount", notes = "银行账户")
   private String bankAccount;

   public static SupplierInfo.SupplierInfoBuilder builder() {
      return new SupplierInfo.SupplierInfoBuilder();
   }

   public SupplierInfo() {
   }

   public SupplierInfo(
      final Long supplierId, final String supplierName, final String supplierNumber, final String socialCode, final String bankName, final String bankAccount
   ) {
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.supplierNumber = supplierNumber;
      this.socialCode = socialCode;
      this.bankName = bankName;
      this.bankAccount = bankAccount;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getSupplierNumber() {
      return this.supplierNumber;
   }

   public String getSocialCode() {
      return this.socialCode;
   }

   public String getBankName() {
      return this.bankName;
   }

   public String getBankAccount() {
      return this.bankAccount;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setSupplierNumber(final String supplierNumber) {
      this.supplierNumber = supplierNumber;
   }

   public void setSocialCode(final String socialCode) {
      this.socialCode = socialCode;
   }

   public void setBankName(final String bankName) {
      this.bankName = bankName;
   }

   public void setBankAccount(final String bankAccount) {
      this.bankAccount = bankAccount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SupplierInfo)) {
         return false;
      }

      SupplierInfo other = (SupplierInfo)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplierId = this.getSupplierId();
      Object other$supplierId = other.getSupplierId();
      if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
         Object this$supplierName = this.getSupplierName();
         Object other$supplierName = other.getSupplierName();
         if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
            Object this$supplierNumber = this.getSupplierNumber();
            Object other$supplierNumber = other.getSupplierNumber();
            if (this$supplierNumber == null ? other$supplierNumber == null : this$supplierNumber.equals(other$supplierNumber)) {
               Object this$socialCode = this.getSocialCode();
               Object other$socialCode = other.getSocialCode();
               if (this$socialCode == null ? other$socialCode == null : this$socialCode.equals(other$socialCode)) {
                  Object this$bankName = this.getBankName();
                  Object other$bankName = other.getBankName();
                  if (this$bankName == null ? other$bankName == null : this$bankName.equals(other$bankName)) {
                     Object this$bankAccount = this.getBankAccount();
                     Object other$bankAccount = other.getBankAccount();
                     return this$bankAccount == null ? other$bankAccount == null : this$bankAccount.equals(other$bankAccount);
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
      return other instanceof SupplierInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $supplierNumber = this.getSupplierNumber();
      result = result * 59 + ($supplierNumber == null ? 43 : $supplierNumber.hashCode());
      Object $socialCode = this.getSocialCode();
      result = result * 59 + ($socialCode == null ? 43 : $socialCode.hashCode());
      Object $bankName = this.getBankName();
      result = result * 59 + ($bankName == null ? 43 : $bankName.hashCode());
      Object $bankAccount = this.getBankAccount();
      return result * 59 + ($bankAccount == null ? 43 : $bankAccount.hashCode());
   }

   @Override
   public String toString() {
      return "SupplierInfo(supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", supplierNumber="
         + this.getSupplierNumber()
         + ", socialCode="
         + this.getSocialCode()
         + ", bankName="
         + this.getBankName()
         + ", bankAccount="
         + this.getBankAccount()
         + ")";
   }

   public static class SupplierInfoBuilder {
      private Long supplierId;
      private String supplierName;
      private String supplierNumber;
      private String socialCode;
      private String bankName;
      private String bankAccount;

      SupplierInfoBuilder() {
      }

      public SupplierInfo.SupplierInfoBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SupplierInfo.SupplierInfoBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SupplierInfo.SupplierInfoBuilder supplierNumber(final String supplierNumber) {
         this.supplierNumber = supplierNumber;
         return this;
      }

      public SupplierInfo.SupplierInfoBuilder socialCode(final String socialCode) {
         this.socialCode = socialCode;
         return this;
      }

      public SupplierInfo.SupplierInfoBuilder bankName(final String bankName) {
         this.bankName = bankName;
         return this;
      }

      public SupplierInfo.SupplierInfoBuilder bankAccount(final String bankAccount) {
         this.bankAccount = bankAccount;
         return this;
      }

      public SupplierInfo build() {
         return new SupplierInfo(this.supplierId, this.supplierName, this.supplierNumber, this.socialCode, this.bankName, this.bankAccount);
      }

      @Override
      public String toString() {
         return "SupplierInfo.SupplierInfoBuilder(supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", supplierNumber="
            + this.supplierNumber
            + ", socialCode="
            + this.socialCode
            + ", bankName="
            + this.bankName
            + ", bankAccount="
            + this.bankAccount
            + ")";
      }
   }
}
