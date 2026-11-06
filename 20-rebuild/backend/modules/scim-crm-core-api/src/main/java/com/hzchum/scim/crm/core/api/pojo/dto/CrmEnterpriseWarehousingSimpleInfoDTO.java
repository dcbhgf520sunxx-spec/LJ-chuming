package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmEnterpriseWarehousingSimpleInfoDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "creditCode", value = "社会统一信用代码", notes = "社会统一信用代码")
   private String creditCode;
   @ApiModelProperty(name = "businessName", value = "企业名称", notes = "企业名称")
   private String businessName;
   @ApiModelProperty(name = "businessEmail", value = "单位邮箱", notes = "单位邮箱")
   private String businessEmail;
   @ApiModelProperty(name = "businessPhone", value = "单位电话", notes = "单位电话")
   private String businessPhone;
   @ApiModelProperty(name = "haveCrmGovernment", notes = "是否拥有政府备案")
   private Boolean haveCrmGovernment;
   @ApiModelProperty(name = "haveCrmBiddingPlatform", notes = "是否拥有平台备案")
   private Boolean haveCrmBiddingPlatform;
   @ApiModelProperty(name = "haveCrmSupplier", notes = "是否拥有供应商备案")
   private Boolean haveCrmSupplier;

   public static CrmEnterpriseWarehousingSimpleInfoDTO.CrmEnterpriseWarehousingSimpleInfoDTOBuilder builder() {
      return new CrmEnterpriseWarehousingSimpleInfoDTO.CrmEnterpriseWarehousingSimpleInfoDTOBuilder();
   }

   public CrmEnterpriseWarehousingSimpleInfoDTO() {
   }

   public CrmEnterpriseWarehousingSimpleInfoDTO(
      final Long id,
      final String creditCode,
      final String businessName,
      final String businessEmail,
      final String businessPhone,
      final Boolean haveCrmGovernment,
      final Boolean haveCrmBiddingPlatform,
      final Boolean haveCrmSupplier
   ) {
      this.id = id;
      this.creditCode = creditCode;
      this.businessName = businessName;
      this.businessEmail = businessEmail;
      this.businessPhone = businessPhone;
      this.haveCrmGovernment = haveCrmGovernment;
      this.haveCrmBiddingPlatform = haveCrmBiddingPlatform;
      this.haveCrmSupplier = haveCrmSupplier;
   }

   public Long getId() {
      return this.id;
   }

   public String getCreditCode() {
      return this.creditCode;
   }

   public String getBusinessName() {
      return this.businessName;
   }

   public String getBusinessEmail() {
      return this.businessEmail;
   }

   public String getBusinessPhone() {
      return this.businessPhone;
   }

   public Boolean getHaveCrmGovernment() {
      return this.haveCrmGovernment;
   }

   public Boolean getHaveCrmBiddingPlatform() {
      return this.haveCrmBiddingPlatform;
   }

   public Boolean getHaveCrmSupplier() {
      return this.haveCrmSupplier;
   }

   public CrmEnterpriseWarehousingSimpleInfoDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public CrmEnterpriseWarehousingSimpleInfoDTO setCreditCode(final String creditCode) {
      this.creditCode = creditCode;
      return this;
   }

   public CrmEnterpriseWarehousingSimpleInfoDTO setBusinessName(final String businessName) {
      this.businessName = businessName;
      return this;
   }

   public CrmEnterpriseWarehousingSimpleInfoDTO setBusinessEmail(final String businessEmail) {
      this.businessEmail = businessEmail;
      return this;
   }

   public CrmEnterpriseWarehousingSimpleInfoDTO setBusinessPhone(final String businessPhone) {
      this.businessPhone = businessPhone;
      return this;
   }

   public CrmEnterpriseWarehousingSimpleInfoDTO setHaveCrmGovernment(final Boolean haveCrmGovernment) {
      this.haveCrmGovernment = haveCrmGovernment;
      return this;
   }

   public CrmEnterpriseWarehousingSimpleInfoDTO setHaveCrmBiddingPlatform(final Boolean haveCrmBiddingPlatform) {
      this.haveCrmBiddingPlatform = haveCrmBiddingPlatform;
      return this;
   }

   public CrmEnterpriseWarehousingSimpleInfoDTO setHaveCrmSupplier(final Boolean haveCrmSupplier) {
      this.haveCrmSupplier = haveCrmSupplier;
      return this;
   }

   @Override
   public String toString() {
      return "CrmEnterpriseWarehousingSimpleInfoDTO(id="
         + this.getId()
         + ", creditCode="
         + this.getCreditCode()
         + ", businessName="
         + this.getBusinessName()
         + ", businessEmail="
         + this.getBusinessEmail()
         + ", businessPhone="
         + this.getBusinessPhone()
         + ", haveCrmGovernment="
         + this.getHaveCrmGovernment()
         + ", haveCrmBiddingPlatform="
         + this.getHaveCrmBiddingPlatform()
         + ", haveCrmSupplier="
         + this.getHaveCrmSupplier()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmEnterpriseWarehousingSimpleInfoDTO)) {
         return false;
      }

      CrmEnterpriseWarehousingSimpleInfoDTO other = (CrmEnterpriseWarehousingSimpleInfoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$haveCrmGovernment = this.getHaveCrmGovernment();
         Object other$haveCrmGovernment = other.getHaveCrmGovernment();
         if (this$haveCrmGovernment == null ? other$haveCrmGovernment == null : this$haveCrmGovernment.equals(other$haveCrmGovernment)) {
            Object this$haveCrmBiddingPlatform = this.getHaveCrmBiddingPlatform();
            Object other$haveCrmBiddingPlatform = other.getHaveCrmBiddingPlatform();
            if (this$haveCrmBiddingPlatform == null ? other$haveCrmBiddingPlatform == null : this$haveCrmBiddingPlatform.equals(other$haveCrmBiddingPlatform)) {
               Object this$haveCrmSupplier = this.getHaveCrmSupplier();
               Object other$haveCrmSupplier = other.getHaveCrmSupplier();
               if (this$haveCrmSupplier == null ? other$haveCrmSupplier == null : this$haveCrmSupplier.equals(other$haveCrmSupplier)) {
                  Object this$creditCode = this.getCreditCode();
                  Object other$creditCode = other.getCreditCode();
                  if (this$creditCode == null ? other$creditCode == null : this$creditCode.equals(other$creditCode)) {
                     Object this$businessName = this.getBusinessName();
                     Object other$businessName = other.getBusinessName();
                     if (this$businessName == null ? other$businessName == null : this$businessName.equals(other$businessName)) {
                        Object this$businessEmail = this.getBusinessEmail();
                        Object other$businessEmail = other.getBusinessEmail();
                        if (this$businessEmail == null ? other$businessEmail == null : this$businessEmail.equals(other$businessEmail)) {
                           Object this$businessPhone = this.getBusinessPhone();
                           Object other$businessPhone = other.getBusinessPhone();
                           return this$businessPhone == null ? other$businessPhone == null : this$businessPhone.equals(other$businessPhone);
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
      return other instanceof CrmEnterpriseWarehousingSimpleInfoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $haveCrmGovernment = this.getHaveCrmGovernment();
      result = result * 59 + ($haveCrmGovernment == null ? 43 : $haveCrmGovernment.hashCode());
      Object $haveCrmBiddingPlatform = this.getHaveCrmBiddingPlatform();
      result = result * 59 + ($haveCrmBiddingPlatform == null ? 43 : $haveCrmBiddingPlatform.hashCode());
      Object $haveCrmSupplier = this.getHaveCrmSupplier();
      result = result * 59 + ($haveCrmSupplier == null ? 43 : $haveCrmSupplier.hashCode());
      Object $creditCode = this.getCreditCode();
      result = result * 59 + ($creditCode == null ? 43 : $creditCode.hashCode());
      Object $businessName = this.getBusinessName();
      result = result * 59 + ($businessName == null ? 43 : $businessName.hashCode());
      Object $businessEmail = this.getBusinessEmail();
      result = result * 59 + ($businessEmail == null ? 43 : $businessEmail.hashCode());
      Object $businessPhone = this.getBusinessPhone();
      return result * 59 + ($businessPhone == null ? 43 : $businessPhone.hashCode());
   }

   public static class CrmEnterpriseWarehousingSimpleInfoDTOBuilder {
      private Long id;
      private String creditCode;
      private String businessName;
      private String businessEmail;
      private String businessPhone;
      private Boolean haveCrmGovernment;
      private Boolean haveCrmBiddingPlatform;
      private Boolean haveCrmSupplier;

      CrmEnterpriseWarehousingSimpleInfoDTOBuilder() {
      }

      public CrmEnterpriseWarehousingSimpleInfoDTO.CrmEnterpriseWarehousingSimpleInfoDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public CrmEnterpriseWarehousingSimpleInfoDTO.CrmEnterpriseWarehousingSimpleInfoDTOBuilder creditCode(final String creditCode) {
         this.creditCode = creditCode;
         return this;
      }

      public CrmEnterpriseWarehousingSimpleInfoDTO.CrmEnterpriseWarehousingSimpleInfoDTOBuilder businessName(final String businessName) {
         this.businessName = businessName;
         return this;
      }

      public CrmEnterpriseWarehousingSimpleInfoDTO.CrmEnterpriseWarehousingSimpleInfoDTOBuilder businessEmail(final String businessEmail) {
         this.businessEmail = businessEmail;
         return this;
      }

      public CrmEnterpriseWarehousingSimpleInfoDTO.CrmEnterpriseWarehousingSimpleInfoDTOBuilder businessPhone(final String businessPhone) {
         this.businessPhone = businessPhone;
         return this;
      }

      public CrmEnterpriseWarehousingSimpleInfoDTO.CrmEnterpriseWarehousingSimpleInfoDTOBuilder haveCrmGovernment(final Boolean haveCrmGovernment) {
         this.haveCrmGovernment = haveCrmGovernment;
         return this;
      }

      public CrmEnterpriseWarehousingSimpleInfoDTO.CrmEnterpriseWarehousingSimpleInfoDTOBuilder haveCrmBiddingPlatform(final Boolean haveCrmBiddingPlatform) {
         this.haveCrmBiddingPlatform = haveCrmBiddingPlatform;
         return this;
      }

      public CrmEnterpriseWarehousingSimpleInfoDTO.CrmEnterpriseWarehousingSimpleInfoDTOBuilder haveCrmSupplier(final Boolean haveCrmSupplier) {
         this.haveCrmSupplier = haveCrmSupplier;
         return this;
      }

      public CrmEnterpriseWarehousingSimpleInfoDTO build() {
         return new CrmEnterpriseWarehousingSimpleInfoDTO(
            this.id,
            this.creditCode,
            this.businessName,
            this.businessEmail,
            this.businessPhone,
            this.haveCrmGovernment,
            this.haveCrmBiddingPlatform,
            this.haveCrmSupplier
         );
      }

      @Override
      public String toString() {
         return "CrmEnterpriseWarehousingSimpleInfoDTO.CrmEnterpriseWarehousingSimpleInfoDTOBuilder(id="
            + this.id
            + ", creditCode="
            + this.creditCode
            + ", businessName="
            + this.businessName
            + ", businessEmail="
            + this.businessEmail
            + ", businessPhone="
            + this.businessPhone
            + ", haveCrmGovernment="
            + this.haveCrmGovernment
            + ", haveCrmBiddingPlatform="
            + this.haveCrmBiddingPlatform
            + ", haveCrmSupplier="
            + this.haveCrmSupplier
            + ")";
      }
   }
}
