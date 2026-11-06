package com.hzchum.scim.mes.building.core.api.pojo._dto.report;

import io.swagger.annotations.ApiModel;

@ApiModel(value = "ProductProduceCargoDTO", description = "产品生产发运状态")
public class ProductProduceCargoDTO {
   private Long productId;
   private Long taskId;
   private Integer productType;
   private Long areaId;
   private Long monomerId;
   private Long projectId;

   public static ProductProduceCargoDTO.ProductProduceCargoDTOBuilder builder() {
      return new ProductProduceCargoDTO.ProductProduceCargoDTOBuilder();
   }

   public ProductProduceCargoDTO() {
   }

   public ProductProduceCargoDTO(
      final Long productId, final Long taskId, final Integer productType, final Long areaId, final Long monomerId, final Long projectId
   ) {
      this.productId = productId;
      this.taskId = taskId;
      this.productType = productType;
      this.areaId = areaId;
      this.monomerId = monomerId;
      this.projectId = projectId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Long getTaskId() {
      return this.taskId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public ProductProduceCargoDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public ProductProduceCargoDTO setTaskId(final Long taskId) {
      this.taskId = taskId;
      return this;
   }

   public ProductProduceCargoDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public ProductProduceCargoDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public ProductProduceCargoDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public ProductProduceCargoDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @Override
   public String toString() {
      return "ProductProduceCargoDTO(productId="
         + this.getProductId()
         + ", taskId="
         + this.getTaskId()
         + ", productType="
         + this.getProductType()
         + ", areaId="
         + this.getAreaId()
         + ", monomerId="
         + this.getMonomerId()
         + ", projectId="
         + this.getProjectId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductProduceCargoDTO)) {
         return false;
      }

      ProductProduceCargoDTO other = (ProductProduceCargoDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$taskId = this.getTaskId();
         Object other$taskId = other.getTaskId();
         if (this$taskId == null ? other$taskId == null : this$taskId.equals(other$taskId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     return this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId);
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
      return other instanceof ProductProduceCargoDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $taskId = this.getTaskId();
      result = result * 59 + ($taskId == null ? 43 : $taskId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $projectId = this.getProjectId();
      return result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
   }

   public static class ProductProduceCargoDTOBuilder {
      private Long productId;
      private Long taskId;
      private Integer productType;
      private Long areaId;
      private Long monomerId;
      private Long projectId;

      ProductProduceCargoDTOBuilder() {
      }

      public ProductProduceCargoDTO.ProductProduceCargoDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ProductProduceCargoDTO.ProductProduceCargoDTOBuilder taskId(final Long taskId) {
         this.taskId = taskId;
         return this;
      }

      public ProductProduceCargoDTO.ProductProduceCargoDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProductProduceCargoDTO.ProductProduceCargoDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProductProduceCargoDTO.ProductProduceCargoDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProductProduceCargoDTO.ProductProduceCargoDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProductProduceCargoDTO build() {
         return new ProductProduceCargoDTO(this.productId, this.taskId, this.productType, this.areaId, this.monomerId, this.projectId);
      }

      @Override
      public String toString() {
         return "ProductProduceCargoDTO.ProductProduceCargoDTOBuilder(productId="
            + this.productId
            + ", taskId="
            + this.taskId
            + ", productType="
            + this.productType
            + ", areaId="
            + this.areaId
            + ", monomerId="
            + this.monomerId
            + ", projectId="
            + this.projectId
            + ")";
      }
   }
}
