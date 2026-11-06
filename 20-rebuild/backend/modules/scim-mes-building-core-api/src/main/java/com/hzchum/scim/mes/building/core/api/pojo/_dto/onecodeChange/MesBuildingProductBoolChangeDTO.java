package com.hzchum.scim.mes.building.core.api.pojo._dto.onecodeChange;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesBuildingProductBoolChangeDTO对象", description = "产品是否可以变更返回类")
public class MesBuildingProductBoolChangeDTO {
   @ApiModelProperty("产品id")
   private Long productId;
   @ApiModelProperty("一物一码号")
   private Integer sortNumber;
   @ApiModelProperty("产品类型")
   private Integer taskType;
   @ApiModelProperty("是否可以变更")
   private Boolean boolCanCange;
   @ApiModelProperty("包id")
   private Long packageId;
   @ApiModelProperty("装车id")
   private Long cargoId;
   @ApiModelProperty("出库记录id(发运id)")
   private Long wareHouseRecordId;

   public static MesBuildingProductBoolChangeDTO.MesBuildingProductBoolChangeDTOBuilder builder() {
      return new MesBuildingProductBoolChangeDTO.MesBuildingProductBoolChangeDTOBuilder();
   }

   public MesBuildingProductBoolChangeDTO() {
   }

   public MesBuildingProductBoolChangeDTO(
      final Long productId,
      final Integer sortNumber,
      final Integer taskType,
      final Boolean boolCanCange,
      final Long packageId,
      final Long cargoId,
      final Long wareHouseRecordId
   ) {
      this.productId = productId;
      this.sortNumber = sortNumber;
      this.taskType = taskType;
      this.boolCanCange = boolCanCange;
      this.packageId = packageId;
      this.cargoId = cargoId;
      this.wareHouseRecordId = wareHouseRecordId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getSortNumber() {
      return this.sortNumber;
   }

   public Integer getTaskType() {
      return this.taskType;
   }

   public Boolean getBoolCanCange() {
      return this.boolCanCange;
   }

   public Long getPackageId() {
      return this.packageId;
   }

   public Long getCargoId() {
      return this.cargoId;
   }

   public Long getWareHouseRecordId() {
      return this.wareHouseRecordId;
   }

   public MesBuildingProductBoolChangeDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public MesBuildingProductBoolChangeDTO setSortNumber(final Integer sortNumber) {
      this.sortNumber = sortNumber;
      return this;
   }

   public MesBuildingProductBoolChangeDTO setTaskType(final Integer taskType) {
      this.taskType = taskType;
      return this;
   }

   public MesBuildingProductBoolChangeDTO setBoolCanCange(final Boolean boolCanCange) {
      this.boolCanCange = boolCanCange;
      return this;
   }

   public MesBuildingProductBoolChangeDTO setPackageId(final Long packageId) {
      this.packageId = packageId;
      return this;
   }

   public MesBuildingProductBoolChangeDTO setCargoId(final Long cargoId) {
      this.cargoId = cargoId;
      return this;
   }

   public MesBuildingProductBoolChangeDTO setWareHouseRecordId(final Long wareHouseRecordId) {
      this.wareHouseRecordId = wareHouseRecordId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingProductBoolChangeDTO(productId="
         + this.getProductId()
         + ", sortNumber="
         + this.getSortNumber()
         + ", taskType="
         + this.getTaskType()
         + ", boolCanCange="
         + this.getBoolCanCange()
         + ", packageId="
         + this.getPackageId()
         + ", cargoId="
         + this.getCargoId()
         + ", wareHouseRecordId="
         + this.getWareHouseRecordId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingProductBoolChangeDTO)) {
         return false;
      }

      MesBuildingProductBoolChangeDTO other = (MesBuildingProductBoolChangeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$sortNumber = this.getSortNumber();
         Object other$sortNumber = other.getSortNumber();
         if (this$sortNumber == null ? other$sortNumber == null : this$sortNumber.equals(other$sortNumber)) {
            Object this$taskType = this.getTaskType();
            Object other$taskType = other.getTaskType();
            if (this$taskType == null ? other$taskType == null : this$taskType.equals(other$taskType)) {
               Object this$boolCanCange = this.getBoolCanCange();
               Object other$boolCanCange = other.getBoolCanCange();
               if (this$boolCanCange == null ? other$boolCanCange == null : this$boolCanCange.equals(other$boolCanCange)) {
                  Object this$packageId = this.getPackageId();
                  Object other$packageId = other.getPackageId();
                  if (this$packageId == null ? other$packageId == null : this$packageId.equals(other$packageId)) {
                     Object this$cargoId = this.getCargoId();
                     Object other$cargoId = other.getCargoId();
                     if (this$cargoId == null ? other$cargoId == null : this$cargoId.equals(other$cargoId)) {
                        Object this$wareHouseRecordId = this.getWareHouseRecordId();
                        Object other$wareHouseRecordId = other.getWareHouseRecordId();
                        return this$wareHouseRecordId == null ? other$wareHouseRecordId == null : this$wareHouseRecordId.equals(other$wareHouseRecordId);
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
      return other instanceof MesBuildingProductBoolChangeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $sortNumber = this.getSortNumber();
      result = result * 59 + ($sortNumber == null ? 43 : $sortNumber.hashCode());
      Object $taskType = this.getTaskType();
      result = result * 59 + ($taskType == null ? 43 : $taskType.hashCode());
      Object $boolCanCange = this.getBoolCanCange();
      result = result * 59 + ($boolCanCange == null ? 43 : $boolCanCange.hashCode());
      Object $packageId = this.getPackageId();
      result = result * 59 + ($packageId == null ? 43 : $packageId.hashCode());
      Object $cargoId = this.getCargoId();
      result = result * 59 + ($cargoId == null ? 43 : $cargoId.hashCode());
      Object $wareHouseRecordId = this.getWareHouseRecordId();
      return result * 59 + ($wareHouseRecordId == null ? 43 : $wareHouseRecordId.hashCode());
   }

   public static class MesBuildingProductBoolChangeDTOBuilder {
      private Long productId;
      private Integer sortNumber;
      private Integer taskType;
      private Boolean boolCanCange;
      private Long packageId;
      private Long cargoId;
      private Long wareHouseRecordId;

      MesBuildingProductBoolChangeDTOBuilder() {
      }

      public MesBuildingProductBoolChangeDTO.MesBuildingProductBoolChangeDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesBuildingProductBoolChangeDTO.MesBuildingProductBoolChangeDTOBuilder sortNumber(final Integer sortNumber) {
         this.sortNumber = sortNumber;
         return this;
      }

      public MesBuildingProductBoolChangeDTO.MesBuildingProductBoolChangeDTOBuilder taskType(final Integer taskType) {
         this.taskType = taskType;
         return this;
      }

      public MesBuildingProductBoolChangeDTO.MesBuildingProductBoolChangeDTOBuilder boolCanCange(final Boolean boolCanCange) {
         this.boolCanCange = boolCanCange;
         return this;
      }

      public MesBuildingProductBoolChangeDTO.MesBuildingProductBoolChangeDTOBuilder packageId(final Long packageId) {
         this.packageId = packageId;
         return this;
      }

      public MesBuildingProductBoolChangeDTO.MesBuildingProductBoolChangeDTOBuilder cargoId(final Long cargoId) {
         this.cargoId = cargoId;
         return this;
      }

      public MesBuildingProductBoolChangeDTO.MesBuildingProductBoolChangeDTOBuilder wareHouseRecordId(final Long wareHouseRecordId) {
         this.wareHouseRecordId = wareHouseRecordId;
         return this;
      }

      public MesBuildingProductBoolChangeDTO build() {
         return new MesBuildingProductBoolChangeDTO(
            this.productId, this.sortNumber, this.taskType, this.boolCanCange, this.packageId, this.cargoId, this.wareHouseRecordId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingProductBoolChangeDTO.MesBuildingProductBoolChangeDTOBuilder(productId="
            + this.productId
            + ", sortNumber="
            + this.sortNumber
            + ", taskType="
            + this.taskType
            + ", boolCanCange="
            + this.boolCanCange
            + ", packageId="
            + this.packageId
            + ", cargoId="
            + this.cargoId
            + ", wareHouseRecordId="
            + this.wareHouseRecordId
            + ")";
      }
   }
}
