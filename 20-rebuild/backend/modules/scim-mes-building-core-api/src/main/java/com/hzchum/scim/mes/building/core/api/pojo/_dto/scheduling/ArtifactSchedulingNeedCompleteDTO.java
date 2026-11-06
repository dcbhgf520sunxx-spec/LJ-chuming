package com.hzchum.scim.mes.building.core.api.pojo._dto.scheduling;

public class ArtifactSchedulingNeedCompleteDTO {
   private Long artifactTaskId;
   private Long numberLinkId;
   private Integer completeType;
   private Integer number;
   private Long productId;
   private Integer taskTypeEnum;
   private Integer quantity;
   private Long projectId;
   private Long monomerId;
   private Long areaId;
   private Long areaBatchId;
   private Long workshopId;
   private Long factoryId;
   private Long lineId;
   private Boolean boolSendDirectly;

   public static ArtifactSchedulingNeedCompleteDTO.ArtifactSchedulingNeedCompleteDTOBuilder builder() {
      return new ArtifactSchedulingNeedCompleteDTO.ArtifactSchedulingNeedCompleteDTOBuilder();
   }

   public Long getArtifactTaskId() {
      return this.artifactTaskId;
   }

   public Long getNumberLinkId() {
      return this.numberLinkId;
   }

   public Integer getCompleteType() {
      return this.completeType;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getLineId() {
      return this.lineId;
   }

   public Boolean getBoolSendDirectly() {
      return this.boolSendDirectly;
   }

   public void setArtifactTaskId(final Long artifactTaskId) {
      this.artifactTaskId = artifactTaskId;
   }

   public void setNumberLinkId(final Long numberLinkId) {
      this.numberLinkId = numberLinkId;
   }

   public void setCompleteType(final Integer completeType) {
      this.completeType = completeType;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setLineId(final Long lineId) {
      this.lineId = lineId;
   }

   public void setBoolSendDirectly(final Boolean boolSendDirectly) {
      this.boolSendDirectly = boolSendDirectly;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactSchedulingNeedCompleteDTO)) {
         return false;
      }

      ArtifactSchedulingNeedCompleteDTO other = (ArtifactSchedulingNeedCompleteDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$artifactTaskId = this.getArtifactTaskId();
      Object other$artifactTaskId = other.getArtifactTaskId();
      if (this$artifactTaskId == null ? other$artifactTaskId == null : this$artifactTaskId.equals(other$artifactTaskId)) {
         Object this$numberLinkId = this.getNumberLinkId();
         Object other$numberLinkId = other.getNumberLinkId();
         if (this$numberLinkId == null ? other$numberLinkId == null : this$numberLinkId.equals(other$numberLinkId)) {
            Object this$completeType = this.getCompleteType();
            Object other$completeType = other.getCompleteType();
            if (this$completeType == null ? other$completeType == null : this$completeType.equals(other$completeType)) {
               Object this$number = this.getNumber();
               Object other$number = other.getNumber();
               if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                  Object this$productId = this.getProductId();
                  Object other$productId = other.getProductId();
                  if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                     Object this$taskTypeEnum = this.getTaskTypeEnum();
                     Object other$taskTypeEnum = other.getTaskTypeEnum();
                     if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                        Object this$quantity = this.getQuantity();
                        Object other$quantity = other.getQuantity();
                        if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                           Object this$projectId = this.getProjectId();
                           Object other$projectId = other.getProjectId();
                           if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                              Object this$monomerId = this.getMonomerId();
                              Object other$monomerId = other.getMonomerId();
                              if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                                 Object this$areaId = this.getAreaId();
                                 Object other$areaId = other.getAreaId();
                                 if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                                    Object this$areaBatchId = this.getAreaBatchId();
                                    Object other$areaBatchId = other.getAreaBatchId();
                                    if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                                       Object this$workshopId = this.getWorkshopId();
                                       Object other$workshopId = other.getWorkshopId();
                                       if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                          Object this$factoryId = this.getFactoryId();
                                          Object other$factoryId = other.getFactoryId();
                                          if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                                             Object this$lineId = this.getLineId();
                                             Object other$lineId = other.getLineId();
                                             if (this$lineId == null ? other$lineId == null : this$lineId.equals(other$lineId)) {
                                                Object this$boolSendDirectly = this.getBoolSendDirectly();
                                                Object other$boolSendDirectly = other.getBoolSendDirectly();
                                                return this$boolSendDirectly == null
                                                   ? other$boolSendDirectly == null
                                                   : this$boolSendDirectly.equals(other$boolSendDirectly);
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
      return other instanceof ArtifactSchedulingNeedCompleteDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $artifactTaskId = this.getArtifactTaskId();
      result = result * 59 + ($artifactTaskId == null ? 43 : $artifactTaskId.hashCode());
      Object $numberLinkId = this.getNumberLinkId();
      result = result * 59 + ($numberLinkId == null ? 43 : $numberLinkId.hashCode());
      Object $completeType = this.getCompleteType();
      result = result * 59 + ($completeType == null ? 43 : $completeType.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $lineId = this.getLineId();
      result = result * 59 + ($lineId == null ? 43 : $lineId.hashCode());
      Object $boolSendDirectly = this.getBoolSendDirectly();
      return result * 59 + ($boolSendDirectly == null ? 43 : $boolSendDirectly.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactSchedulingNeedCompleteDTO(artifactTaskId="
         + this.getArtifactTaskId()
         + ", numberLinkId="
         + this.getNumberLinkId()
         + ", completeType="
         + this.getCompleteType()
         + ", number="
         + this.getNumber()
         + ", productId="
         + this.getProductId()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ", quantity="
         + this.getQuantity()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", factoryId="
         + this.getFactoryId()
         + ", lineId="
         + this.getLineId()
         + ", boolSendDirectly="
         + this.getBoolSendDirectly()
         + ")";
   }

   public ArtifactSchedulingNeedCompleteDTO(
      final Long artifactTaskId,
      final Long numberLinkId,
      final Integer completeType,
      final Integer number,
      final Long productId,
      final Integer taskTypeEnum,
      final Integer quantity,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final Long workshopId,
      final Long factoryId,
      final Long lineId,
      final Boolean boolSendDirectly
   ) {
      this.artifactTaskId = artifactTaskId;
      this.numberLinkId = numberLinkId;
      this.completeType = completeType;
      this.number = number;
      this.productId = productId;
      this.taskTypeEnum = taskTypeEnum;
      this.quantity = quantity;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.workshopId = workshopId;
      this.factoryId = factoryId;
      this.lineId = lineId;
      this.boolSendDirectly = boolSendDirectly;
   }

   public ArtifactSchedulingNeedCompleteDTO() {
   }

   public static class ArtifactSchedulingNeedCompleteDTOBuilder {
      private Long artifactTaskId;
      private Long numberLinkId;
      private Integer completeType;
      private Integer number;
      private Long productId;
      private Integer taskTypeEnum;
      private Integer quantity;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private Long workshopId;
      private Long factoryId;
      private Long lineId;
      private Boolean boolSendDirectly;

      ArtifactSchedulingNeedCompleteDTOBuilder() {
      }

      public ArtifactSchedulingNeedCompleteDTO.ArtifactSchedulingNeedCompleteDTOBuilder artifactTaskId(final Long artifactTaskId) {
         this.artifactTaskId = artifactTaskId;
         return this;
      }

      public ArtifactSchedulingNeedCompleteDTO.ArtifactSchedulingNeedCompleteDTOBuilder numberLinkId(final Long numberLinkId) {
         this.numberLinkId = numberLinkId;
         return this;
      }

      public ArtifactSchedulingNeedCompleteDTO.ArtifactSchedulingNeedCompleteDTOBuilder completeType(final Integer completeType) {
         this.completeType = completeType;
         return this;
      }

      public ArtifactSchedulingNeedCompleteDTO.ArtifactSchedulingNeedCompleteDTOBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public ArtifactSchedulingNeedCompleteDTO.ArtifactSchedulingNeedCompleteDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ArtifactSchedulingNeedCompleteDTO.ArtifactSchedulingNeedCompleteDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public ArtifactSchedulingNeedCompleteDTO.ArtifactSchedulingNeedCompleteDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public ArtifactSchedulingNeedCompleteDTO.ArtifactSchedulingNeedCompleteDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ArtifactSchedulingNeedCompleteDTO.ArtifactSchedulingNeedCompleteDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ArtifactSchedulingNeedCompleteDTO.ArtifactSchedulingNeedCompleteDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ArtifactSchedulingNeedCompleteDTO.ArtifactSchedulingNeedCompleteDTOBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      public ArtifactSchedulingNeedCompleteDTO.ArtifactSchedulingNeedCompleteDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public ArtifactSchedulingNeedCompleteDTO.ArtifactSchedulingNeedCompleteDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public ArtifactSchedulingNeedCompleteDTO.ArtifactSchedulingNeedCompleteDTOBuilder lineId(final Long lineId) {
         this.lineId = lineId;
         return this;
      }

      public ArtifactSchedulingNeedCompleteDTO.ArtifactSchedulingNeedCompleteDTOBuilder boolSendDirectly(final Boolean boolSendDirectly) {
         this.boolSendDirectly = boolSendDirectly;
         return this;
      }

      public ArtifactSchedulingNeedCompleteDTO build() {
         return new ArtifactSchedulingNeedCompleteDTO(
            this.artifactTaskId,
            this.numberLinkId,
            this.completeType,
            this.number,
            this.productId,
            this.taskTypeEnum,
            this.quantity,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.workshopId,
            this.factoryId,
            this.lineId,
            this.boolSendDirectly
         );
      }

      @Override
      public String toString() {
         return "ArtifactSchedulingNeedCompleteDTO.ArtifactSchedulingNeedCompleteDTOBuilder(artifactTaskId="
            + this.artifactTaskId
            + ", numberLinkId="
            + this.numberLinkId
            + ", completeType="
            + this.completeType
            + ", number="
            + this.number
            + ", productId="
            + this.productId
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ", quantity="
            + this.quantity
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", workshopId="
            + this.workshopId
            + ", factoryId="
            + this.factoryId
            + ", lineId="
            + this.lineId
            + ", boolSendDirectly="
            + this.boolSendDirectly
            + ")";
      }
   }
}
