package com.hzchum.scim.contract.core.api.pojo._doParam;

public class ContractPreRegistrationQueryDTOParam {
   private Integer reviewStatus;
   private Boolean boolQuote;
   private String preRegistrationNo;
   private String projectName;

   public static ContractPreRegistrationQueryDTOParam.ContractPreRegistrationQueryDTOParamBuilder builder() {
      return new ContractPreRegistrationQueryDTOParam.ContractPreRegistrationQueryDTOParamBuilder();
   }

   public ContractPreRegistrationQueryDTOParam() {
   }

   public ContractPreRegistrationQueryDTOParam(final Integer reviewStatus, final Boolean boolQuote, final String preRegistrationNo, final String projectName) {
      this.reviewStatus = reviewStatus;
      this.boolQuote = boolQuote;
      this.preRegistrationNo = preRegistrationNo;
      this.projectName = projectName;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Boolean getBoolQuote() {
      return this.boolQuote;
   }

   public String getPreRegistrationNo() {
      return this.preRegistrationNo;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setBoolQuote(final Boolean boolQuote) {
      this.boolQuote = boolQuote;
   }

   public void setPreRegistrationNo(final String preRegistrationNo) {
      this.preRegistrationNo = preRegistrationNo;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractPreRegistrationQueryDTOParam)) {
         return false;
      }

      ContractPreRegistrationQueryDTOParam other = (ContractPreRegistrationQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$reviewStatus = this.getReviewStatus();
      Object other$reviewStatus = other.getReviewStatus();
      if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
         Object this$boolQuote = this.getBoolQuote();
         Object other$boolQuote = other.getBoolQuote();
         if (this$boolQuote == null ? other$boolQuote == null : this$boolQuote.equals(other$boolQuote)) {
            Object this$preRegistrationNo = this.getPreRegistrationNo();
            Object other$preRegistrationNo = other.getPreRegistrationNo();
            if (this$preRegistrationNo == null ? other$preRegistrationNo == null : this$preRegistrationNo.equals(other$preRegistrationNo)) {
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
      return other instanceof ContractPreRegistrationQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $boolQuote = this.getBoolQuote();
      result = result * 59 + ($boolQuote == null ? 43 : $boolQuote.hashCode());
      Object $preRegistrationNo = this.getPreRegistrationNo();
      result = result * 59 + ($preRegistrationNo == null ? 43 : $preRegistrationNo.hashCode());
      Object $projectName = this.getProjectName();
      return result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
   }

   @Override
   public String toString() {
      return "ContractPreRegistrationQueryDTOParam(reviewStatus="
         + this.getReviewStatus()
         + ", boolQuote="
         + this.getBoolQuote()
         + ", preRegistrationNo="
         + this.getPreRegistrationNo()
         + ", projectName="
         + this.getProjectName()
         + ")";
   }

   public static class ContractPreRegistrationQueryDTOParamBuilder {
      private Integer reviewStatus;
      private Boolean boolQuote;
      private String preRegistrationNo;
      private String projectName;

      ContractPreRegistrationQueryDTOParamBuilder() {
      }

      public ContractPreRegistrationQueryDTOParam.ContractPreRegistrationQueryDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public ContractPreRegistrationQueryDTOParam.ContractPreRegistrationQueryDTOParamBuilder boolQuote(final Boolean boolQuote) {
         this.boolQuote = boolQuote;
         return this;
      }

      public ContractPreRegistrationQueryDTOParam.ContractPreRegistrationQueryDTOParamBuilder preRegistrationNo(final String preRegistrationNo) {
         this.preRegistrationNo = preRegistrationNo;
         return this;
      }

      public ContractPreRegistrationQueryDTOParam.ContractPreRegistrationQueryDTOParamBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ContractPreRegistrationQueryDTOParam build() {
         return new ContractPreRegistrationQueryDTOParam(this.reviewStatus, this.boolQuote, this.preRegistrationNo, this.projectName);
      }

      @Override
      public String toString() {
         return "ContractPreRegistrationQueryDTOParam.ContractPreRegistrationQueryDTOParamBuilder(reviewStatus="
            + this.reviewStatus
            + ", boolQuote="
            + this.boolQuote
            + ", preRegistrationNo="
            + this.preRegistrationNo
            + ", projectName="
            + this.projectName
            + ")";
      }
   }
}
