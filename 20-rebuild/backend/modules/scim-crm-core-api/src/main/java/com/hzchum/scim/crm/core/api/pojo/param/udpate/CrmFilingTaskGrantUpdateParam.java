package com.hzchum.scim.crm.core.api.pojo.param.udpate;

import io.swagger.annotations.ApiModelProperty;

public class CrmFilingTaskGrantUpdateParam {
   @ApiModelProperty(name = "crmSupplierWarehousingUpdateParam", notes = "供应商")
   private CrmSupplierWarehousingUpdateParam crmSupplierWarehousingUpdateParam;
   @ApiModelProperty(name = "crmBiddingPlatformWarehousingUpdateParam", notes = "平台注册")
   private CrmBiddingPlatformWarehousingUpdateParam crmBiddingPlatformWarehousingUpdateParam;
   @ApiModelProperty(name = "crmGovernmentWarehousingUpdateParam", notes = "政府")
   private CrmGovernmentWarehousingUpdateParam crmGovernmentWarehousingUpdateParam;

   public static CrmFilingTaskGrantUpdateParam.CrmFilingTaskGrantUpdateParamBuilder builder() {
      return new CrmFilingTaskGrantUpdateParam.CrmFilingTaskGrantUpdateParamBuilder();
   }

   public CrmFilingTaskGrantUpdateParam() {
   }

   public CrmFilingTaskGrantUpdateParam(
      final CrmSupplierWarehousingUpdateParam crmSupplierWarehousingUpdateParam,
      final CrmBiddingPlatformWarehousingUpdateParam crmBiddingPlatformWarehousingUpdateParam,
      final CrmGovernmentWarehousingUpdateParam crmGovernmentWarehousingUpdateParam
   ) {
      this.crmSupplierWarehousingUpdateParam = crmSupplierWarehousingUpdateParam;
      this.crmBiddingPlatformWarehousingUpdateParam = crmBiddingPlatformWarehousingUpdateParam;
      this.crmGovernmentWarehousingUpdateParam = crmGovernmentWarehousingUpdateParam;
   }

   public CrmSupplierWarehousingUpdateParam getCrmSupplierWarehousingUpdateParam() {
      return this.crmSupplierWarehousingUpdateParam;
   }

   public CrmBiddingPlatformWarehousingUpdateParam getCrmBiddingPlatformWarehousingUpdateParam() {
      return this.crmBiddingPlatformWarehousingUpdateParam;
   }

   public CrmGovernmentWarehousingUpdateParam getCrmGovernmentWarehousingUpdateParam() {
      return this.crmGovernmentWarehousingUpdateParam;
   }

   public CrmFilingTaskGrantUpdateParam setCrmSupplierWarehousingUpdateParam(final CrmSupplierWarehousingUpdateParam crmSupplierWarehousingUpdateParam) {
      this.crmSupplierWarehousingUpdateParam = crmSupplierWarehousingUpdateParam;
      return this;
   }

   public CrmFilingTaskGrantUpdateParam setCrmBiddingPlatformWarehousingUpdateParam(
      final CrmBiddingPlatformWarehousingUpdateParam crmBiddingPlatformWarehousingUpdateParam
   ) {
      this.crmBiddingPlatformWarehousingUpdateParam = crmBiddingPlatformWarehousingUpdateParam;
      return this;
   }

   public CrmFilingTaskGrantUpdateParam setCrmGovernmentWarehousingUpdateParam(final CrmGovernmentWarehousingUpdateParam crmGovernmentWarehousingUpdateParam) {
      this.crmGovernmentWarehousingUpdateParam = crmGovernmentWarehousingUpdateParam;
      return this;
   }

   @Override
   public String toString() {
      return "CrmFilingTaskGrantUpdateParam(crmSupplierWarehousingUpdateParam="
         + this.getCrmSupplierWarehousingUpdateParam()
         + ", crmBiddingPlatformWarehousingUpdateParam="
         + this.getCrmBiddingPlatformWarehousingUpdateParam()
         + ", crmGovernmentWarehousingUpdateParam="
         + this.getCrmGovernmentWarehousingUpdateParam()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmFilingTaskGrantUpdateParam)) {
         return false;
      }

      CrmFilingTaskGrantUpdateParam other = (CrmFilingTaskGrantUpdateParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$crmSupplierWarehousingUpdateParam = this.getCrmSupplierWarehousingUpdateParam();
      Object other$crmSupplierWarehousingUpdateParam = other.getCrmSupplierWarehousingUpdateParam();
      if (this$crmSupplierWarehousingUpdateParam == null
         ? other$crmSupplierWarehousingUpdateParam == null
         : this$crmSupplierWarehousingUpdateParam.equals(other$crmSupplierWarehousingUpdateParam)) {
         Object this$crmBiddingPlatformWarehousingUpdateParam = this.getCrmBiddingPlatformWarehousingUpdateParam();
         Object other$crmBiddingPlatformWarehousingUpdateParam = other.getCrmBiddingPlatformWarehousingUpdateParam();
         if (this$crmBiddingPlatformWarehousingUpdateParam == null
            ? other$crmBiddingPlatformWarehousingUpdateParam == null
            : this$crmBiddingPlatformWarehousingUpdateParam.equals(other$crmBiddingPlatformWarehousingUpdateParam)) {
            Object this$crmGovernmentWarehousingUpdateParam = this.getCrmGovernmentWarehousingUpdateParam();
            Object other$crmGovernmentWarehousingUpdateParam = other.getCrmGovernmentWarehousingUpdateParam();
            return this$crmGovernmentWarehousingUpdateParam == null
               ? other$crmGovernmentWarehousingUpdateParam == null
               : this$crmGovernmentWarehousingUpdateParam.equals(other$crmGovernmentWarehousingUpdateParam);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmFilingTaskGrantUpdateParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $crmSupplierWarehousingUpdateParam = this.getCrmSupplierWarehousingUpdateParam();
      result = result * 59 + ($crmSupplierWarehousingUpdateParam == null ? 43 : $crmSupplierWarehousingUpdateParam.hashCode());
      Object $crmBiddingPlatformWarehousingUpdateParam = this.getCrmBiddingPlatformWarehousingUpdateParam();
      result = result * 59 + ($crmBiddingPlatformWarehousingUpdateParam == null ? 43 : $crmBiddingPlatformWarehousingUpdateParam.hashCode());
      Object $crmGovernmentWarehousingUpdateParam = this.getCrmGovernmentWarehousingUpdateParam();
      return result * 59 + ($crmGovernmentWarehousingUpdateParam == null ? 43 : $crmGovernmentWarehousingUpdateParam.hashCode());
   }

   public static class CrmFilingTaskGrantUpdateParamBuilder {
      private CrmSupplierWarehousingUpdateParam crmSupplierWarehousingUpdateParam;
      private CrmBiddingPlatformWarehousingUpdateParam crmBiddingPlatformWarehousingUpdateParam;
      private CrmGovernmentWarehousingUpdateParam crmGovernmentWarehousingUpdateParam;

      CrmFilingTaskGrantUpdateParamBuilder() {
      }

      public CrmFilingTaskGrantUpdateParam.CrmFilingTaskGrantUpdateParamBuilder crmSupplierWarehousingUpdateParam(
         final CrmSupplierWarehousingUpdateParam crmSupplierWarehousingUpdateParam
      ) {
         this.crmSupplierWarehousingUpdateParam = crmSupplierWarehousingUpdateParam;
         return this;
      }

      public CrmFilingTaskGrantUpdateParam.CrmFilingTaskGrantUpdateParamBuilder crmBiddingPlatformWarehousingUpdateParam(
         final CrmBiddingPlatformWarehousingUpdateParam crmBiddingPlatformWarehousingUpdateParam
      ) {
         this.crmBiddingPlatformWarehousingUpdateParam = crmBiddingPlatformWarehousingUpdateParam;
         return this;
      }

      public CrmFilingTaskGrantUpdateParam.CrmFilingTaskGrantUpdateParamBuilder crmGovernmentWarehousingUpdateParam(
         final CrmGovernmentWarehousingUpdateParam crmGovernmentWarehousingUpdateParam
      ) {
         this.crmGovernmentWarehousingUpdateParam = crmGovernmentWarehousingUpdateParam;
         return this;
      }

      public CrmFilingTaskGrantUpdateParam build() {
         return new CrmFilingTaskGrantUpdateParam(
            this.crmSupplierWarehousingUpdateParam, this.crmBiddingPlatformWarehousingUpdateParam, this.crmGovernmentWarehousingUpdateParam
         );
      }

      @Override
      public String toString() {
         return "CrmFilingTaskGrantUpdateParam.CrmFilingTaskGrantUpdateParamBuilder(crmSupplierWarehousingUpdateParam="
            + this.crmSupplierWarehousingUpdateParam
            + ", crmBiddingPlatformWarehousingUpdateParam="
            + this.crmBiddingPlatformWarehousingUpdateParam
            + ", crmGovernmentWarehousingUpdateParam="
            + this.crmGovernmentWarehousingUpdateParam
            + ")";
      }
   }
}
