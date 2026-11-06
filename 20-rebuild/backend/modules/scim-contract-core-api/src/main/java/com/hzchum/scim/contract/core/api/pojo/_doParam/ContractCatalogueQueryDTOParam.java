package com.hzchum.scim.contract.core.api.pojo._doParam;

public class ContractCatalogueQueryDTOParam {
   private Boolean boolContractNumber;
   private Integer createSource;
   private String contractNumber;
   private String projectName;
   private Boolean boolSupplement;
   private Integer reviewStatus;

   public static ContractCatalogueQueryDTOParam.ContractCatalogueQueryDTOParamBuilder builder() {
      return new ContractCatalogueQueryDTOParam.ContractCatalogueQueryDTOParamBuilder();
   }

   public ContractCatalogueQueryDTOParam() {
   }

   public ContractCatalogueQueryDTOParam(
      final Boolean boolContractNumber,
      final Integer createSource,
      final String contractNumber,
      final String projectName,
      final Boolean boolSupplement,
      final Integer reviewStatus
   ) {
      this.boolContractNumber = boolContractNumber;
      this.createSource = createSource;
      this.contractNumber = contractNumber;
      this.projectName = projectName;
      this.boolSupplement = boolSupplement;
      this.reviewStatus = reviewStatus;
   }

   public Boolean getBoolContractNumber() {
      return this.boolContractNumber;
   }

   public Integer getCreateSource() {
      return this.createSource;
   }

   public String getContractNumber() {
      return this.contractNumber;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Boolean getBoolSupplement() {
      return this.boolSupplement;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public void setBoolContractNumber(final Boolean boolContractNumber) {
      this.boolContractNumber = boolContractNumber;
   }

   public void setCreateSource(final Integer createSource) {
      this.createSource = createSource;
   }

   public void setContractNumber(final String contractNumber) {
      this.contractNumber = contractNumber;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setBoolSupplement(final Boolean boolSupplement) {
      this.boolSupplement = boolSupplement;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractCatalogueQueryDTOParam)) {
         return false;
      }

      ContractCatalogueQueryDTOParam other = (ContractCatalogueQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolContractNumber = this.getBoolContractNumber();
      Object other$boolContractNumber = other.getBoolContractNumber();
      if (this$boolContractNumber == null ? other$boolContractNumber == null : this$boolContractNumber.equals(other$boolContractNumber)) {
         Object this$createSource = this.getCreateSource();
         Object other$createSource = other.getCreateSource();
         if (this$createSource == null ? other$createSource == null : this$createSource.equals(other$createSource)) {
            Object this$boolSupplement = this.getBoolSupplement();
            Object other$boolSupplement = other.getBoolSupplement();
            if (this$boolSupplement == null ? other$boolSupplement == null : this$boolSupplement.equals(other$boolSupplement)) {
               Object this$reviewStatus = this.getReviewStatus();
               Object other$reviewStatus = other.getReviewStatus();
               if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                  Object this$contractNumber = this.getContractNumber();
                  Object other$contractNumber = other.getContractNumber();
                  if (this$contractNumber == null ? other$contractNumber == null : this$contractNumber.equals(other$contractNumber)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractCatalogueQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolContractNumber = this.getBoolContractNumber();
      result = result * 59 + ($boolContractNumber == null ? 43 : $boolContractNumber.hashCode());
      Object $createSource = this.getCreateSource();
      result = result * 59 + ($createSource == null ? 43 : $createSource.hashCode());
      Object $boolSupplement = this.getBoolSupplement();
      result = result * 59 + ($boolSupplement == null ? 43 : $boolSupplement.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $contractNumber = this.getContractNumber();
      result = result * 59 + ($contractNumber == null ? 43 : $contractNumber.hashCode());
      Object $projectName = this.getProjectName();
      return result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
   }

   @Override
   public String toString() {
      return "ContractCatalogueQueryDTOParam(boolContractNumber="
         + this.getBoolContractNumber()
         + ", createSource="
         + this.getCreateSource()
         + ", contractNumber="
         + this.getContractNumber()
         + ", projectName="
         + this.getProjectName()
         + ", boolSupplement="
         + this.getBoolSupplement()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ")";
   }

   public static class ContractCatalogueQueryDTOParamBuilder {
      private Boolean boolContractNumber;
      private Integer createSource;
      private String contractNumber;
      private String projectName;
      private Boolean boolSupplement;
      private Integer reviewStatus;

      ContractCatalogueQueryDTOParamBuilder() {
      }

      public ContractCatalogueQueryDTOParam.ContractCatalogueQueryDTOParamBuilder boolContractNumber(final Boolean boolContractNumber) {
         this.boolContractNumber = boolContractNumber;
         return this;
      }

      public ContractCatalogueQueryDTOParam.ContractCatalogueQueryDTOParamBuilder createSource(final Integer createSource) {
         this.createSource = createSource;
         return this;
      }

      public ContractCatalogueQueryDTOParam.ContractCatalogueQueryDTOParamBuilder contractNumber(final String contractNumber) {
         this.contractNumber = contractNumber;
         return this;
      }

      public ContractCatalogueQueryDTOParam.ContractCatalogueQueryDTOParamBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ContractCatalogueQueryDTOParam.ContractCatalogueQueryDTOParamBuilder boolSupplement(final Boolean boolSupplement) {
         this.boolSupplement = boolSupplement;
         return this;
      }

      public ContractCatalogueQueryDTOParam.ContractCatalogueQueryDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public ContractCatalogueQueryDTOParam build() {
         return new ContractCatalogueQueryDTOParam(
            this.boolContractNumber, this.createSource, this.contractNumber, this.projectName, this.boolSupplement, this.reviewStatus
         );
      }

      @Override
      public String toString() {
         return "ContractCatalogueQueryDTOParam.ContractCatalogueQueryDTOParamBuilder(boolContractNumber="
            + this.boolContractNumber
            + ", createSource="
            + this.createSource
            + ", contractNumber="
            + this.contractNumber
            + ", projectName="
            + this.projectName
            + ", boolSupplement="
            + this.boolSupplement
            + ", reviewStatus="
            + this.reviewStatus
            + ")";
      }
   }
}
