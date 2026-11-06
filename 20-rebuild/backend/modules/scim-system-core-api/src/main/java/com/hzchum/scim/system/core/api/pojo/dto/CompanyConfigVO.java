package com.hzchum.scim.system.core.api.pojo.dto;

import javax.validation.constraints.NotBlank;

public class CompanyConfigVO {
   @NotBlank(message = "公司名称不能为空")
   private String companyName;
   @NotBlank(message = "公司编号不能为空")
   private String companyNo;
   @NotBlank(message = "系统唯一id不能为空")
   private String UUID;
   private String website;
   private String telephone;

   public String getCompanyName() {
      return this.companyName;
   }

   public String getCompanyNo() {
      return this.companyNo;
   }

   public String getUUID() {
      return this.UUID;
   }

   public String getWebsite() {
      return this.website;
   }

   public String getTelephone() {
      return this.telephone;
   }

   public void setCompanyName(final String companyName) {
      this.companyName = companyName;
   }

   public void setCompanyNo(final String companyNo) {
      this.companyNo = companyNo;
   }

   public void setUUID(final String UUID) {
      this.UUID = UUID;
   }

   public void setWebsite(final String website) {
      this.website = website;
   }

   public void setTelephone(final String telephone) {
      this.telephone = telephone;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CompanyConfigVO)) {
         return false;
      }

      CompanyConfigVO other = (CompanyConfigVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$companyName = this.getCompanyName();
      Object other$companyName = other.getCompanyName();
      if (this$companyName == null ? other$companyName == null : this$companyName.equals(other$companyName)) {
         Object this$companyNo = this.getCompanyNo();
         Object other$companyNo = other.getCompanyNo();
         if (this$companyNo == null ? other$companyNo == null : this$companyNo.equals(other$companyNo)) {
            Object this$UUID = this.getUUID();
            Object other$UUID = other.getUUID();
            if (this$UUID == null ? other$UUID == null : this$UUID.equals(other$UUID)) {
               Object this$website = this.getWebsite();
               Object other$website = other.getWebsite();
               if (this$website == null ? other$website == null : this$website.equals(other$website)) {
                  Object this$telephone = this.getTelephone();
                  Object other$telephone = other.getTelephone();
                  return this$telephone == null ? other$telephone == null : this$telephone.equals(other$telephone);
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
      return other instanceof CompanyConfigVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $companyName = this.getCompanyName();
      result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
      Object $companyNo = this.getCompanyNo();
      result = result * 59 + ($companyNo == null ? 43 : $companyNo.hashCode());
      Object $UUID = this.getUUID();
      result = result * 59 + ($UUID == null ? 43 : $UUID.hashCode());
      Object $website = this.getWebsite();
      result = result * 59 + ($website == null ? 43 : $website.hashCode());
      Object $telephone = this.getTelephone();
      return result * 59 + ($telephone == null ? 43 : $telephone.hashCode());
   }

   @Override
   public String toString() {
      return "CompanyConfigVO(companyName="
         + this.getCompanyName()
         + ", companyNo="
         + this.getCompanyNo()
         + ", UUID="
         + this.getUUID()
         + ", website="
         + this.getWebsite()
         + ", telephone="
         + this.getTelephone()
         + ")";
   }
}
