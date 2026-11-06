package com.hzchum.scim.crm.core.api.pojo.param.udpate;

import io.swagger.annotations.ApiModelProperty;

public class CrmEnterpriseinquiriesConfigUpdateParam {
   @ApiModelProperty(name = "appCode", notes = "密钥")
   private String appCode;

   public CrmEnterpriseinquiriesConfigUpdateParam(final String appCode) {
      this.appCode = appCode;
   }

   public CrmEnterpriseinquiriesConfigUpdateParam() {
   }

   public String getAppCode() {
      return this.appCode;
   }

   public void setAppCode(final String appCode) {
      this.appCode = appCode;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmEnterpriseinquiriesConfigUpdateParam)) {
         return false;
      }

      CrmEnterpriseinquiriesConfigUpdateParam other = (CrmEnterpriseinquiriesConfigUpdateParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$appCode = this.getAppCode();
      Object other$appCode = other.getAppCode();
      return this$appCode == null ? other$appCode == null : this$appCode.equals(other$appCode);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmEnterpriseinquiriesConfigUpdateParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $appCode = this.getAppCode();
      return result * 59 + ($appCode == null ? 43 : $appCode.hashCode());
   }

   @Override
   public String toString() {
      return "CrmEnterpriseinquiriesConfigUpdateParam(appCode=" + this.getAppCode() + ")";
   }
}
