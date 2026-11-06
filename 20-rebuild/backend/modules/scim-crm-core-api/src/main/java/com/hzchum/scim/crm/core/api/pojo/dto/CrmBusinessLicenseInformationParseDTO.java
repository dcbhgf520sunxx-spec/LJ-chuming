package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

public class CrmBusinessLicenseInformationParseDTO {
   @ApiModelProperty(name = "companyCode", value = "唯一码号", notes = "唯一码号")
   private String companyCode;
   @ApiModelProperty(name = "companyName", value = "唯一名称", notes = "唯一名称")
   private String companyName;
   @ApiModelProperty(name = "legalPersonName", value = "法人名称", notes = "法人名称")
   private String legalPersonName;
   @ApiModelProperty(name = "crediNo", value = "信用代码", notes = "信用代码")
   private String creditNo;
   @ApiModelProperty(name = "establishDate", value = "创立日期", notes = "创立日期")
   private LocalDate establishDate;

   public CrmBusinessLicenseInformationParseDTO(
      final String companyCode, final String companyName, final String legalPersonName, final String creditNo, final LocalDate establishDate
   ) {
      this.companyCode = companyCode;
      this.companyName = companyName;
      this.legalPersonName = legalPersonName;
      this.creditNo = creditNo;
      this.establishDate = establishDate;
   }

   public CrmBusinessLicenseInformationParseDTO() {
   }

   public String getCompanyCode() {
      return this.companyCode;
   }

   public String getCompanyName() {
      return this.companyName;
   }

   public String getLegalPersonName() {
      return this.legalPersonName;
   }

   public String getCreditNo() {
      return this.creditNo;
   }

   public LocalDate getEstablishDate() {
      return this.establishDate;
   }

   public void setCompanyCode(final String companyCode) {
      this.companyCode = companyCode;
   }

   public void setCompanyName(final String companyName) {
      this.companyName = companyName;
   }

   public void setLegalPersonName(final String legalPersonName) {
      this.legalPersonName = legalPersonName;
   }

   public void setCreditNo(final String creditNo) {
      this.creditNo = creditNo;
   }

   public void setEstablishDate(final LocalDate establishDate) {
      this.establishDate = establishDate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmBusinessLicenseInformationParseDTO)) {
         return false;
      }

      CrmBusinessLicenseInformationParseDTO other = (CrmBusinessLicenseInformationParseDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$companyCode = this.getCompanyCode();
      Object other$companyCode = other.getCompanyCode();
      if (this$companyCode == null ? other$companyCode == null : this$companyCode.equals(other$companyCode)) {
         Object this$companyName = this.getCompanyName();
         Object other$companyName = other.getCompanyName();
         if (this$companyName == null ? other$companyName == null : this$companyName.equals(other$companyName)) {
            Object this$legalPersonName = this.getLegalPersonName();
            Object other$legalPersonName = other.getLegalPersonName();
            if (this$legalPersonName == null ? other$legalPersonName == null : this$legalPersonName.equals(other$legalPersonName)) {
               Object this$creditNo = this.getCreditNo();
               Object other$creditNo = other.getCreditNo();
               if (this$creditNo == null ? other$creditNo == null : this$creditNo.equals(other$creditNo)) {
                  Object this$establishDate = this.getEstablishDate();
                  Object other$establishDate = other.getEstablishDate();
                  return this$establishDate == null ? other$establishDate == null : this$establishDate.equals(other$establishDate);
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
      return other instanceof CrmBusinessLicenseInformationParseDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $companyCode = this.getCompanyCode();
      result = result * 59 + ($companyCode == null ? 43 : $companyCode.hashCode());
      Object $companyName = this.getCompanyName();
      result = result * 59 + ($companyName == null ? 43 : $companyName.hashCode());
      Object $legalPersonName = this.getLegalPersonName();
      result = result * 59 + ($legalPersonName == null ? 43 : $legalPersonName.hashCode());
      Object $creditNo = this.getCreditNo();
      result = result * 59 + ($creditNo == null ? 43 : $creditNo.hashCode());
      Object $establishDate = this.getEstablishDate();
      return result * 59 + ($establishDate == null ? 43 : $establishDate.hashCode());
   }

   @Override
   public String toString() {
      return "CrmBusinessLicenseInformationParseDTO(companyCode="
         + this.getCompanyCode()
         + ", companyName="
         + this.getCompanyName()
         + ", legalPersonName="
         + this.getLegalPersonName()
         + ", creditNo="
         + this.getCreditNo()
         + ", establishDate="
         + this.getEstablishDate()
         + ")";
   }
}
