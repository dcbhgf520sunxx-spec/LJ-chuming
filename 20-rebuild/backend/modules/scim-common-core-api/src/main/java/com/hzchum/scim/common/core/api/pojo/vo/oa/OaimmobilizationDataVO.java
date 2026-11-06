package com.hzchum.scim.common.core.api.pojo.vo.oa;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("OaimmobilizationDataVO")
public class OaimmobilizationDataVO {
   @ApiModelProperty(name = "applicationDate", value = "申请日期")
   private String applicationDate;
   @ApiModelProperty(name = "applicant", value = "申请人")
   private String applicant;
   @ApiModelProperty(name = "applicationNumber", value = "申请编号")
   private String applicationNumber;
   @ApiModelProperty(name = "applicantDept", value = "申请人部门")
   private String applicantDept;
   @ApiModelProperty(name = "projectName", value = "项目名称")
   private String projectName;
   @ApiModelProperty(name = "contractSubject", value = "合同主体")
   private String contractSubject;
   @ApiModelProperty(name = "firstParty", value = "甲方")
   private String firstParty;
   @ApiModelProperty(name = "applyCode", value = "乙方")
   private String applyCode;
   @ApiModelProperty(name = "secondParty", value = "丙方")
   private String secondParty;
   @ApiModelProperty(name = "dingFang", value = "丁方")
   private String dingFang;

   public static OaimmobilizationDataVO.OaimmobilizationDataVOBuilder builder() {
      return new OaimmobilizationDataVO.OaimmobilizationDataVOBuilder();
   }

   public OaimmobilizationDataVO(
      final String applicationDate,
      final String applicant,
      final String applicationNumber,
      final String applicantDept,
      final String projectName,
      final String contractSubject,
      final String firstParty,
      final String applyCode,
      final String secondParty,
      final String dingFang
   ) {
      this.applicationDate = applicationDate;
      this.applicant = applicant;
      this.applicationNumber = applicationNumber;
      this.applicantDept = applicantDept;
      this.projectName = projectName;
      this.contractSubject = contractSubject;
      this.firstParty = firstParty;
      this.applyCode = applyCode;
      this.secondParty = secondParty;
      this.dingFang = dingFang;
   }

   public OaimmobilizationDataVO() {
   }

   public String getApplicationDate() {
      return this.applicationDate;
   }

   public String getApplicant() {
      return this.applicant;
   }

   public String getApplicationNumber() {
      return this.applicationNumber;
   }

   public String getApplicantDept() {
      return this.applicantDept;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getContractSubject() {
      return this.contractSubject;
   }

   public String getFirstParty() {
      return this.firstParty;
   }

   public String getApplyCode() {
      return this.applyCode;
   }

   public String getSecondParty() {
      return this.secondParty;
   }

   public String getDingFang() {
      return this.dingFang;
   }

   public OaimmobilizationDataVO setApplicationDate(final String applicationDate) {
      this.applicationDate = applicationDate;
      return this;
   }

   public OaimmobilizationDataVO setApplicant(final String applicant) {
      this.applicant = applicant;
      return this;
   }

   public OaimmobilizationDataVO setApplicationNumber(final String applicationNumber) {
      this.applicationNumber = applicationNumber;
      return this;
   }

   public OaimmobilizationDataVO setApplicantDept(final String applicantDept) {
      this.applicantDept = applicantDept;
      return this;
   }

   public OaimmobilizationDataVO setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public OaimmobilizationDataVO setContractSubject(final String contractSubject) {
      this.contractSubject = contractSubject;
      return this;
   }

   public OaimmobilizationDataVO setFirstParty(final String firstParty) {
      this.firstParty = firstParty;
      return this;
   }

   public OaimmobilizationDataVO setApplyCode(final String applyCode) {
      this.applyCode = applyCode;
      return this;
   }

   public OaimmobilizationDataVO setSecondParty(final String secondParty) {
      this.secondParty = secondParty;
      return this;
   }

   public OaimmobilizationDataVO setDingFang(final String dingFang) {
      this.dingFang = dingFang;
      return this;
   }

   @Override
   public String toString() {
      return "OaimmobilizationDataVO(applicationDate="
         + this.getApplicationDate()
         + ", applicant="
         + this.getApplicant()
         + ", applicationNumber="
         + this.getApplicationNumber()
         + ", applicantDept="
         + this.getApplicantDept()
         + ", projectName="
         + this.getProjectName()
         + ", contractSubject="
         + this.getContractSubject()
         + ", firstParty="
         + this.getFirstParty()
         + ", applyCode="
         + this.getApplyCode()
         + ", secondParty="
         + this.getSecondParty()
         + ", dingFang="
         + this.getDingFang()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OaimmobilizationDataVO)) {
         return false;
      }

      OaimmobilizationDataVO other = (OaimmobilizationDataVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$applicationDate = this.getApplicationDate();
      Object other$applicationDate = other.getApplicationDate();
      if (this$applicationDate == null ? other$applicationDate == null : this$applicationDate.equals(other$applicationDate)) {
         Object this$applicant = this.getApplicant();
         Object other$applicant = other.getApplicant();
         if (this$applicant == null ? other$applicant == null : this$applicant.equals(other$applicant)) {
            Object this$applicationNumber = this.getApplicationNumber();
            Object other$applicationNumber = other.getApplicationNumber();
            if (this$applicationNumber == null ? other$applicationNumber == null : this$applicationNumber.equals(other$applicationNumber)) {
               Object this$applicantDept = this.getApplicantDept();
               Object other$applicantDept = other.getApplicantDept();
               if (this$applicantDept == null ? other$applicantDept == null : this$applicantDept.equals(other$applicantDept)) {
                  Object this$projectName = this.getProjectName();
                  Object other$projectName = other.getProjectName();
                  if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                     Object this$contractSubject = this.getContractSubject();
                     Object other$contractSubject = other.getContractSubject();
                     if (this$contractSubject == null ? other$contractSubject == null : this$contractSubject.equals(other$contractSubject)) {
                        Object this$firstParty = this.getFirstParty();
                        Object other$firstParty = other.getFirstParty();
                        if (this$firstParty == null ? other$firstParty == null : this$firstParty.equals(other$firstParty)) {
                           Object this$applyCode = this.getApplyCode();
                           Object other$applyCode = other.getApplyCode();
                           if (this$applyCode == null ? other$applyCode == null : this$applyCode.equals(other$applyCode)) {
                              Object this$secondParty = this.getSecondParty();
                              Object other$secondParty = other.getSecondParty();
                              if (this$secondParty == null ? other$secondParty == null : this$secondParty.equals(other$secondParty)) {
                                 Object this$dingFang = this.getDingFang();
                                 Object other$dingFang = other.getDingFang();
                                 return this$dingFang == null ? other$dingFang == null : this$dingFang.equals(other$dingFang);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OaimmobilizationDataVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $applicationDate = this.getApplicationDate();
      result = result * 59 + ($applicationDate == null ? 43 : $applicationDate.hashCode());
      Object $applicant = this.getApplicant();
      result = result * 59 + ($applicant == null ? 43 : $applicant.hashCode());
      Object $applicationNumber = this.getApplicationNumber();
      result = result * 59 + ($applicationNumber == null ? 43 : $applicationNumber.hashCode());
      Object $applicantDept = this.getApplicantDept();
      result = result * 59 + ($applicantDept == null ? 43 : $applicantDept.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $contractSubject = this.getContractSubject();
      result = result * 59 + ($contractSubject == null ? 43 : $contractSubject.hashCode());
      Object $firstParty = this.getFirstParty();
      result = result * 59 + ($firstParty == null ? 43 : $firstParty.hashCode());
      Object $applyCode = this.getApplyCode();
      result = result * 59 + ($applyCode == null ? 43 : $applyCode.hashCode());
      Object $secondParty = this.getSecondParty();
      result = result * 59 + ($secondParty == null ? 43 : $secondParty.hashCode());
      Object $dingFang = this.getDingFang();
      return result * 59 + ($dingFang == null ? 43 : $dingFang.hashCode());
   }

   public static class OaimmobilizationDataVOBuilder {
      private String applicationDate;
      private String applicant;
      private String applicationNumber;
      private String applicantDept;
      private String projectName;
      private String contractSubject;
      private String firstParty;
      private String applyCode;
      private String secondParty;
      private String dingFang;

      OaimmobilizationDataVOBuilder() {
      }

      public OaimmobilizationDataVO.OaimmobilizationDataVOBuilder applicationDate(final String applicationDate) {
         this.applicationDate = applicationDate;
         return this;
      }

      public OaimmobilizationDataVO.OaimmobilizationDataVOBuilder applicant(final String applicant) {
         this.applicant = applicant;
         return this;
      }

      public OaimmobilizationDataVO.OaimmobilizationDataVOBuilder applicationNumber(final String applicationNumber) {
         this.applicationNumber = applicationNumber;
         return this;
      }

      public OaimmobilizationDataVO.OaimmobilizationDataVOBuilder applicantDept(final String applicantDept) {
         this.applicantDept = applicantDept;
         return this;
      }

      public OaimmobilizationDataVO.OaimmobilizationDataVOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public OaimmobilizationDataVO.OaimmobilizationDataVOBuilder contractSubject(final String contractSubject) {
         this.contractSubject = contractSubject;
         return this;
      }

      public OaimmobilizationDataVO.OaimmobilizationDataVOBuilder firstParty(final String firstParty) {
         this.firstParty = firstParty;
         return this;
      }

      public OaimmobilizationDataVO.OaimmobilizationDataVOBuilder applyCode(final String applyCode) {
         this.applyCode = applyCode;
         return this;
      }

      public OaimmobilizationDataVO.OaimmobilizationDataVOBuilder secondParty(final String secondParty) {
         this.secondParty = secondParty;
         return this;
      }

      public OaimmobilizationDataVO.OaimmobilizationDataVOBuilder dingFang(final String dingFang) {
         this.dingFang = dingFang;
         return this;
      }

      public OaimmobilizationDataVO build() {
         return new OaimmobilizationDataVO(
            this.applicationDate,
            this.applicant,
            this.applicationNumber,
            this.applicantDept,
            this.projectName,
            this.contractSubject,
            this.firstParty,
            this.applyCode,
            this.secondParty,
            this.dingFang
         );
      }

      @Override
      public String toString() {
         return "OaimmobilizationDataVO.OaimmobilizationDataVOBuilder(applicationDate="
            + this.applicationDate
            + ", applicant="
            + this.applicant
            + ", applicationNumber="
            + this.applicationNumber
            + ", applicantDept="
            + this.applicantDept
            + ", projectName="
            + this.projectName
            + ", contractSubject="
            + this.contractSubject
            + ", firstParty="
            + this.firstParty
            + ", applyCode="
            + this.applyCode
            + ", secondParty="
            + this.secondParty
            + ", dingFang="
            + this.dingFang
            + ")";
      }
   }
}
