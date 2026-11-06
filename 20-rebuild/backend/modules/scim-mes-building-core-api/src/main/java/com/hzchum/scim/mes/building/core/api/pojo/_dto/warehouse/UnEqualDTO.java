package com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse;

public class UnEqualDTO {
   private Long factoryId;
   private Long shopId;
   private Long projectId;
   private Long monomerId;
   private Long areaId;
   private Long planId;
   private Long summaryId;
   private Integer taskType;
   private Long productId;
   private Integer rquantity;
   private Integer type;
   private Integer squantity;

   public static UnEqualDTO.UnEqualDTOBuilder builder() {
      return new UnEqualDTO.UnEqualDTOBuilder();
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getShopId() {
      return this.shopId;
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

   public Long getPlanId() {
      return this.planId;
   }

   public Long getSummaryId() {
      return this.summaryId;
   }

   public Integer getTaskType() {
      return this.taskType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getRquantity() {
      return this.rquantity;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getSquantity() {
      return this.squantity;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setShopId(final Long shopId) {
      this.shopId = shopId;
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

   public void setPlanId(final Long planId) {
      this.planId = planId;
   }

   public void setSummaryId(final Long summaryId) {
      this.summaryId = summaryId;
   }

   public void setTaskType(final Integer taskType) {
      this.taskType = taskType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setRquantity(final Integer rquantity) {
      this.rquantity = rquantity;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setSquantity(final Integer squantity) {
      this.squantity = squantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof UnEqualDTO)) {
         return false;
      }

      UnEqualDTO other = (UnEqualDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$factoryId = this.getFactoryId();
      Object other$factoryId = other.getFactoryId();
      if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
         Object this$shopId = this.getShopId();
         Object other$shopId = other.getShopId();
         if (this$shopId == null ? other$shopId == null : this$shopId.equals(other$shopId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$planId = this.getPlanId();
                     Object other$planId = other.getPlanId();
                     if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
                        Object this$summaryId = this.getSummaryId();
                        Object other$summaryId = other.getSummaryId();
                        if (this$summaryId == null ? other$summaryId == null : this$summaryId.equals(other$summaryId)) {
                           Object this$taskType = this.getTaskType();
                           Object other$taskType = other.getTaskType();
                           if (this$taskType == null ? other$taskType == null : this$taskType.equals(other$taskType)) {
                              Object this$productId = this.getProductId();
                              Object other$productId = other.getProductId();
                              if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                 Object this$rquantity = this.getRquantity();
                                 Object other$rquantity = other.getRquantity();
                                 if (this$rquantity == null ? other$rquantity == null : this$rquantity.equals(other$rquantity)) {
                                    Object this$type = this.getType();
                                    Object other$type = other.getType();
                                    if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                       Object this$squantity = this.getSquantity();
                                       Object other$squantity = other.getSquantity();
                                       return this$squantity == null ? other$squantity == null : this$squantity.equals(other$squantity);
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
      return other instanceof UnEqualDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $shopId = this.getShopId();
      result = result * 59 + ($shopId == null ? 43 : $shopId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $summaryId = this.getSummaryId();
      result = result * 59 + ($summaryId == null ? 43 : $summaryId.hashCode());
      Object $taskType = this.getTaskType();
      result = result * 59 + ($taskType == null ? 43 : $taskType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $rquantity = this.getRquantity();
      result = result * 59 + ($rquantity == null ? 43 : $rquantity.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $squantity = this.getSquantity();
      return result * 59 + ($squantity == null ? 43 : $squantity.hashCode());
   }

   @Override
   public String toString() {
      return "UnEqualDTO(factoryId="
         + this.getFactoryId()
         + ", shopId="
         + this.getShopId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", planId="
         + this.getPlanId()
         + ", summaryId="
         + this.getSummaryId()
         + ", taskType="
         + this.getTaskType()
         + ", productId="
         + this.getProductId()
         + ", rquantity="
         + this.getRquantity()
         + ", type="
         + this.getType()
         + ", squantity="
         + this.getSquantity()
         + ")";
   }

   public UnEqualDTO(
      final Long factoryId,
      final Long shopId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long planId,
      final Long summaryId,
      final Integer taskType,
      final Long productId,
      final Integer rquantity,
      final Integer type,
      final Integer squantity
   ) {
      this.factoryId = factoryId;
      this.shopId = shopId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.planId = planId;
      this.summaryId = summaryId;
      this.taskType = taskType;
      this.productId = productId;
      this.rquantity = rquantity;
      this.type = type;
      this.squantity = squantity;
   }

   public UnEqualDTO() {
   }

   public static class UnEqualDTOBuilder {
      private Long factoryId;
      private Long shopId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long planId;
      private Long summaryId;
      private Integer taskType;
      private Long productId;
      private Integer rquantity;
      private Integer type;
      private Integer squantity;

      UnEqualDTOBuilder() {
      }

      public UnEqualDTO.UnEqualDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public UnEqualDTO.UnEqualDTOBuilder shopId(final Long shopId) {
         this.shopId = shopId;
         return this;
      }

      public UnEqualDTO.UnEqualDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public UnEqualDTO.UnEqualDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public UnEqualDTO.UnEqualDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public UnEqualDTO.UnEqualDTOBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      public UnEqualDTO.UnEqualDTOBuilder summaryId(final Long summaryId) {
         this.summaryId = summaryId;
         return this;
      }

      public UnEqualDTO.UnEqualDTOBuilder taskType(final Integer taskType) {
         this.taskType = taskType;
         return this;
      }

      public UnEqualDTO.UnEqualDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public UnEqualDTO.UnEqualDTOBuilder rquantity(final Integer rquantity) {
         this.rquantity = rquantity;
         return this;
      }

      public UnEqualDTO.UnEqualDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public UnEqualDTO.UnEqualDTOBuilder squantity(final Integer squantity) {
         this.squantity = squantity;
         return this;
      }

      public UnEqualDTO build() {
         return new UnEqualDTO(
            this.factoryId,
            this.shopId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.planId,
            this.summaryId,
            this.taskType,
            this.productId,
            this.rquantity,
            this.type,
            this.squantity
         );
      }

      @Override
      public String toString() {
         return "UnEqualDTO.UnEqualDTOBuilder(factoryId="
            + this.factoryId
            + ", shopId="
            + this.shopId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", planId="
            + this.planId
            + ", summaryId="
            + this.summaryId
            + ", taskType="
            + this.taskType
            + ", productId="
            + this.productId
            + ", rquantity="
            + this.rquantity
            + ", type="
            + this.type
            + ", squantity="
            + this.squantity
            + ")";
      }
   }
}
