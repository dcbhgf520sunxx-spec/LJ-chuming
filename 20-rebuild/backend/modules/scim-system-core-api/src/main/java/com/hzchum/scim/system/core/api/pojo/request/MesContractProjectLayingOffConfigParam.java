package com.hzchum.scim.system.core.api.pojo.request;

public class MesContractProjectLayingOffConfigParam {
   private Long projectId;
   private Integer machinePartType;
   private Long steelClassificationId;
   private Boolean boolFixedPrice;

   public static MesContractProjectLayingOffConfigParam.MesContractProjectLayingOffConfigParamBuilder builder() {
      return new MesContractProjectLayingOffConfigParam.MesContractProjectLayingOffConfigParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getMachinePartType() {
      return this.machinePartType;
   }

   public Long getSteelClassificationId() {
      return this.steelClassificationId;
   }

   public Boolean getBoolFixedPrice() {
      return this.boolFixedPrice;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMachinePartType(final Integer machinePartType) {
      this.machinePartType = machinePartType;
   }

   public void setSteelClassificationId(final Long steelClassificationId) {
      this.steelClassificationId = steelClassificationId;
   }

   public void setBoolFixedPrice(final Boolean boolFixedPrice) {
      this.boolFixedPrice = boolFixedPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesContractProjectLayingOffConfigParam)) {
         return false;
      }

      MesContractProjectLayingOffConfigParam other = (MesContractProjectLayingOffConfigParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$machinePartType = this.getMachinePartType();
         Object other$machinePartType = other.getMachinePartType();
         if (this$machinePartType == null ? other$machinePartType == null : this$machinePartType.equals(other$machinePartType)) {
            Object this$steelClassificationId = this.getSteelClassificationId();
            Object other$steelClassificationId = other.getSteelClassificationId();
            if (this$steelClassificationId == null ? other$steelClassificationId == null : this$steelClassificationId.equals(other$steelClassificationId)) {
               Object this$boolFixedPrice = this.getBoolFixedPrice();
               Object other$boolFixedPrice = other.getBoolFixedPrice();
               return this$boolFixedPrice == null ? other$boolFixedPrice == null : this$boolFixedPrice.equals(other$boolFixedPrice);
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
      return other instanceof MesContractProjectLayingOffConfigParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $machinePartType = this.getMachinePartType();
      result = result * 59 + ($machinePartType == null ? 43 : $machinePartType.hashCode());
      Object $steelClassificationId = this.getSteelClassificationId();
      result = result * 59 + ($steelClassificationId == null ? 43 : $steelClassificationId.hashCode());
      Object $boolFixedPrice = this.getBoolFixedPrice();
      return result * 59 + ($boolFixedPrice == null ? 43 : $boolFixedPrice.hashCode());
   }

   @Override
   public String toString() {
      return "MesContractProjectLayingOffConfigParam(projectId="
         + this.getProjectId()
         + ", machinePartType="
         + this.getMachinePartType()
         + ", steelClassificationId="
         + this.getSteelClassificationId()
         + ", boolFixedPrice="
         + this.getBoolFixedPrice()
         + ")";
   }

   public MesContractProjectLayingOffConfigParam() {
   }

   public MesContractProjectLayingOffConfigParam(
      final Long projectId, final Integer machinePartType, final Long steelClassificationId, final Boolean boolFixedPrice
   ) {
      this.projectId = projectId;
      this.machinePartType = machinePartType;
      this.steelClassificationId = steelClassificationId;
      this.boolFixedPrice = boolFixedPrice;
   }

   public static class MesContractProjectLayingOffConfigParamBuilder {
      private Long projectId;
      private Integer machinePartType;
      private Long steelClassificationId;
      private Boolean boolFixedPrice;

      MesContractProjectLayingOffConfigParamBuilder() {
      }

      public MesContractProjectLayingOffConfigParam.MesContractProjectLayingOffConfigParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesContractProjectLayingOffConfigParam.MesContractProjectLayingOffConfigParamBuilder machinePartType(final Integer machinePartType) {
         this.machinePartType = machinePartType;
         return this;
      }

      public MesContractProjectLayingOffConfigParam.MesContractProjectLayingOffConfigParamBuilder steelClassificationId(final Long steelClassificationId) {
         this.steelClassificationId = steelClassificationId;
         return this;
      }

      public MesContractProjectLayingOffConfigParam.MesContractProjectLayingOffConfigParamBuilder boolFixedPrice(final Boolean boolFixedPrice) {
         this.boolFixedPrice = boolFixedPrice;
         return this;
      }

      public MesContractProjectLayingOffConfigParam build() {
         return new MesContractProjectLayingOffConfigParam(this.projectId, this.machinePartType, this.steelClassificationId, this.boolFixedPrice);
      }

      @Override
      public String toString() {
         return "MesContractProjectLayingOffConfigParam.MesContractProjectLayingOffConfigParamBuilder(projectId="
            + this.projectId
            + ", machinePartType="
            + this.machinePartType
            + ", steelClassificationId="
            + this.steelClassificationId
            + ", boolFixedPrice="
            + this.boolFixedPrice
            + ")";
      }
   }
}
