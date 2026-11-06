package com.hzchum.scim.system.core.api.pojo.dto;

import javax.validation.constraints.NotNull;

public class CompanyInfoVO {
   @NotNull(message = "公司名称不能为空")
   private String companyName;
   @NotNull(message = "公司编号不能为空")
   private String companyNo;
   private String website;
   private String telephone;
   private String logo;

   public String getCompanyName() {
      return this.companyName;
   }

   public String getCompanyNo() {
      return this.companyNo;
   }

   public String getWebsite() {
      return this.website;
   }

   public String getTelephone() {
      return this.telephone;
   }

   public String getLogo() {
      return this.logo;
   }

   public void setCompanyName(final String companyName) {
      this.companyName = companyName;
   }

   public void setCompanyNo(final String companyNo) {
      this.companyNo = companyNo;
   }

   public void setWebsite(final String website) {
      this.website = website;
   }

   public void setTelephone(final String telephone) {
      this.telephone = telephone;
   }

   public void setLogo(final String logo) {
      this.logo = logo;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CompanyInfoVO)) {
         return false;
      }

      CompanyInfoVO other = (CompanyInfoVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$companyName = this.getCompanyName();
      Object other$companyName = other.getCompanyName();
      if (this$companyName == null ? other$companyName == null : this$companyName.equals(other$companyName)) {
         Object this$companyNo = this.getCompanyNo();
         Object other$companyNo = other.getCompanyNo();
         if (this$companyNo == null ? other$companyNo == null : this$companyNo.equals(other$companyNo)) {
            Object this$website = this.getWebsite();
            Object other$website = other.getWebsite();
            if (this$website == null ? other$website == null : this$website.equals(other$website)) {
               Object this$telephone = this.getTelephone();
               Object other$telephone = other.getTelephone();
               if (this$telephone == null ? other$telephone == null : this$telephone.equals(other$telephone)) {
                  Object this$logo = this.getLogo();
                  Object other$logo = other.getLogo();
                  return this$logo == null ? other$logo == null : this$logo.equals(other$logo);
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
      return other instanceof CompanyInfoVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $companyName = this.getCompanyName();
      result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
      Object $companyNo = this.getCompanyNo();
      result = result * 59 + ($companyNo == null ? 43 : $companyNo.hashCode());
      Object $website = this.getWebsite();
      result = result * 59 + ($website == null ? 43 : $website.hashCode());
      Object $telephone = this.getTelephone();
      result = result * 59 + ($telephone == null ? 43 : $telephone.hashCode());
      Object $logo = this.getLogo();
      return result * 59 + ($logo == null ? 43 : $logo.hashCode());
   }

   @Override
   public String toString() {
      return "CompanyInfoVO(companyName="
         + this.getCompanyName()
         + ", companyNo="
         + this.getCompanyNo()
         + ", website="
         + this.getWebsite()
         + ", telephone="
         + this.getTelephone()
         + ", logo="
         + this.getLogo()
         + ")";
   }
}
