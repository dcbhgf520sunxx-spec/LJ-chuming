package com.hzchum.scim.scm.core.api.pojo.dtoParam;

public class ArtifactAndAssembleDTOParam {
   private String serialNumber;
   private Integer destination;
   private Long factoryId;
   private Integer issuedQuantity;

   public static ArtifactAndAssembleDTOParam.ArtifactAndAssembleDTOParamBuilder builder() {
      return new ArtifactAndAssembleDTOParam.ArtifactAndAssembleDTOParamBuilder();
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getDestination() {
      return this.destination;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Integer getIssuedQuantity() {
      return this.issuedQuantity;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setDestination(final Integer destination) {
      this.destination = destination;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setIssuedQuantity(final Integer issuedQuantity) {
      this.issuedQuantity = issuedQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactAndAssembleDTOParam)) {
         return false;
      }

      ArtifactAndAssembleDTOParam other = (ArtifactAndAssembleDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$destination = this.getDestination();
      Object other$destination = other.getDestination();
      if (this$destination == null ? other$destination == null : this$destination.equals(other$destination)) {
         Object this$factoryId = this.getFactoryId();
         Object other$factoryId = other.getFactoryId();
         if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
            Object this$issuedQuantity = this.getIssuedQuantity();
            Object other$issuedQuantity = other.getIssuedQuantity();
            if (this$issuedQuantity == null ? other$issuedQuantity == null : this$issuedQuantity.equals(other$issuedQuantity)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof ArtifactAndAssembleDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $destination = this.getDestination();
      result = result * 59 + ($destination == null ? 43 : $destination.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $issuedQuantity = this.getIssuedQuantity();
      result = result * 59 + ($issuedQuantity == null ? 43 : $issuedQuantity.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactAndAssembleDTOParam(serialNumber="
         + this.getSerialNumber()
         + ", destination="
         + this.getDestination()
         + ", factoryId="
         + this.getFactoryId()
         + ", issuedQuantity="
         + this.getIssuedQuantity()
         + ")";
   }

   public ArtifactAndAssembleDTOParam(final String serialNumber, final Integer destination, final Long factoryId, final Integer issuedQuantity) {
      this.serialNumber = serialNumber;
      this.destination = destination;
      this.factoryId = factoryId;
      this.issuedQuantity = issuedQuantity;
   }

   public ArtifactAndAssembleDTOParam() {
   }

   public static class ArtifactAndAssembleDTOParamBuilder {
      private String serialNumber;
      private Integer destination;
      private Long factoryId;
      private Integer issuedQuantity;

      ArtifactAndAssembleDTOParamBuilder() {
      }

      public ArtifactAndAssembleDTOParam.ArtifactAndAssembleDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ArtifactAndAssembleDTOParam.ArtifactAndAssembleDTOParamBuilder destination(final Integer destination) {
         this.destination = destination;
         return this;
      }

      public ArtifactAndAssembleDTOParam.ArtifactAndAssembleDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public ArtifactAndAssembleDTOParam.ArtifactAndAssembleDTOParamBuilder issuedQuantity(final Integer issuedQuantity) {
         this.issuedQuantity = issuedQuantity;
         return this;
      }

      public ArtifactAndAssembleDTOParam build() {
         return new ArtifactAndAssembleDTOParam(this.serialNumber, this.destination, this.factoryId, this.issuedQuantity);
      }

      @Override
      public String toString() {
         return "ArtifactAndAssembleDTOParam.ArtifactAndAssembleDTOParamBuilder(serialNumber="
            + this.serialNumber
            + ", destination="
            + this.destination
            + ", factoryId="
            + this.factoryId
            + ", issuedQuantity="
            + this.issuedQuantity
            + ")";
      }
   }
}
