package com.hzchum.scim.contract.core.api.pojo._doParam;

public class ContractRegistrationQueryDTOParam {
   private Integer registrationType;
   private Integer reviewStatus;
   private String registrationNo;
   private String projectName;

   public static ContractRegistrationQueryDTOParam.ContractRegistrationQueryDTOParamBuilder builder() {
      return new ContractRegistrationQueryDTOParam.ContractRegistrationQueryDTOParamBuilder();
   }

   public ContractRegistrationQueryDTOParam() {
   }

   public ContractRegistrationQueryDTOParam(final Integer registrationType, final Integer reviewStatus, final String registrationNo, final String projectName) {
      this.registrationType = registrationType;
      this.reviewStatus = reviewStatus;
      this.registrationNo = registrationNo;
      this.projectName = projectName;
   }

   public Integer getRegistrationType() {
      return this.registrationType;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public String getRegistrationNo() {
      return this.registrationNo;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public void setRegistrationType(final Integer registrationType) {
      this.registrationType = registrationType;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setRegistrationNo(final String registrationNo) {
      this.registrationNo = registrationNo;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractRegistrationQueryDTOParam)) {
         return false;
      }

      ContractRegistrationQueryDTOParam other = (ContractRegistrationQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$registrationType = this.getRegistrationType();
      Object other$registrationType = other.getRegistrationType();
      if (this$registrationType == null ? other$registrationType == null : this$registrationType.equals(other$registrationType)) {
         Object this$reviewStatus = this.getReviewStatus();
         Object other$reviewStatus = other.getReviewStatus();
         if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
            Object this$registrationNo = this.getRegistrationNo();
            Object other$registrationNo = other.getRegistrationNo();
            if (this$registrationNo == null ? other$registrationNo == null : this$registrationNo.equals(other$registrationNo)) {
               Object this$projectName = this.getProjectName();
               Object other$projectName = other.getProjectName();
               return this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName);
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
      return other instanceof ContractRegistrationQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $registrationType = this.getRegistrationType();
      result = result * 59 + ($registrationType == null ? 43 : $registrationType.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $registrationNo = this.getRegistrationNo();
      result = result * 59 + ($registrationNo == null ? 43 : $registrationNo.hashCode());
      Object $projectName = this.getProjectName();
      return result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
   }

   @Override
   public String toString() {
      return "ContractRegistrationQueryDTOParam(registrationType="
         + this.getRegistrationType()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", registrationNo="
         + this.getRegistrationNo()
         + ", projectName="
         + this.getProjectName()
         + ")";
   }

   public static class ContractRegistrationQueryDTOParamBuilder {
      private Integer registrationType;
      private Integer reviewStatus;
      private String registrationNo;
      private String projectName;

      ContractRegistrationQueryDTOParamBuilder() {
      }

      public ContractRegistrationQueryDTOParam.ContractRegistrationQueryDTOParamBuilder registrationType(final Integer registrationType) {
         this.registrationType = registrationType;
         return this;
      }

      public ContractRegistrationQueryDTOParam.ContractRegistrationQueryDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public ContractRegistrationQueryDTOParam.ContractRegistrationQueryDTOParamBuilder registrationNo(final String registrationNo) {
         this.registrationNo = registrationNo;
         return this;
      }

      public ContractRegistrationQueryDTOParam.ContractRegistrationQueryDTOParamBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ContractRegistrationQueryDTOParam build() {
         return new ContractRegistrationQueryDTOParam(this.registrationType, this.reviewStatus, this.registrationNo, this.projectName);
      }

      @Override
      public String toString() {
         return "ContractRegistrationQueryDTOParam.ContractRegistrationQueryDTOParamBuilder(registrationType="
            + this.registrationType
            + ", reviewStatus="
            + this.reviewStatus
            + ", registrationNo="
            + this.registrationNo
            + ", projectName="
            + this.projectName
            + ")";
      }
   }
}
