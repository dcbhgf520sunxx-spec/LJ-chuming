package com.hzchum.scim.project.core.api.pojo.dao;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("分包供应商账号类")
public class ProjectSupplierAccountDO {
   @ApiModelProperty(name = "supplierId", value = "供应(分包)商id", notes = "供应(分包)商id")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "供应(分包)商名称", notes = "供应(分包)商名称")
   private String supplierName;
   @ApiModelProperty(name = "username", value = "账号", notes = "账号")
   private String username;
   @ApiModelProperty(name = "password", value = "密码", notes = "密码")
   private String password;

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getUsername() {
      return this.username;
   }

   public String getPassword() {
      return this.password;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setUsername(final String username) {
      this.username = username;
   }

   public void setPassword(final String password) {
      this.password = password;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSupplierAccountDO)) {
         return false;
      }

      ProjectSupplierAccountDO other = (ProjectSupplierAccountDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$supplierId = this.getSupplierId();
      Object other$supplierId = other.getSupplierId();
      if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
         Object this$supplierName = this.getSupplierName();
         Object other$supplierName = other.getSupplierName();
         if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
            Object this$username = this.getUsername();
            Object other$username = other.getUsername();
            if (this$username == null ? other$username == null : this$username.equals(other$username)) {
               Object this$password = this.getPassword();
               Object other$password = other.getPassword();
               return this$password == null ? other$password == null : this$password.equals(other$password);
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
      return other instanceof ProjectSupplierAccountDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $username = this.getUsername();
      result = result * 59 + ($username == null ? 43 : $username.hashCode());
      Object $password = this.getPassword();
      return result * 59 + ($password == null ? 43 : $password.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSupplierAccountDO(supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", username="
         + this.getUsername()
         + ", password="
         + this.getPassword()
         + ")";
   }
}
