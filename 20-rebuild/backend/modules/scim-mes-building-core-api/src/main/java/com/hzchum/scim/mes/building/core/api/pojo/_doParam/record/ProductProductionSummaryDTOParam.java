package com.hzchum.scim.mes.building.core.api.pojo._doParam.record;

import io.swagger.annotations.ApiModelProperty;

public class ProductProductionSummaryDTOParam {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("产品id")
   private Long productId;
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty("任务数量")
   private int taskQuantity;
   @ApiModelProperty("进入生产数量")
   private int inProductionQuantity;
   @ApiModelProperty("完成数量")
   private int completeQuantity;

   ProductProductionSummaryDTOParam(
      final Long projectId,
      final Long monomerId,
      final Long productId,
      final Integer productType,
      final int taskQuantity,
      final int inProductionQuantity,
      final int completeQuantity
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.productId = productId;
      this.productType = productType;
      this.taskQuantity = taskQuantity;
      this.inProductionQuantity = inProductionQuantity;
      this.completeQuantity = completeQuantity;
   }

   public static ProductProductionSummaryDTOParam.ProductProductionSummaryDTOParamBuilder builder() {
      return new ProductProductionSummaryDTOParam.ProductProductionSummaryDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public int getTaskQuantity() {
      return this.taskQuantity;
   }

   public int getInProductionQuantity() {
      return this.inProductionQuantity;
   }

   public int getCompleteQuantity() {
      return this.completeQuantity;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setTaskQuantity(final int taskQuantity) {
      this.taskQuantity = taskQuantity;
   }

   public void setInProductionQuantity(final int inProductionQuantity) {
      this.inProductionQuantity = inProductionQuantity;
   }

   public void setCompleteQuantity(final int completeQuantity) {
      this.completeQuantity = completeQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductProductionSummaryDTOParam)) {
         return false;
      }

      ProductProductionSummaryDTOParam other = (ProductProductionSummaryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getTaskQuantity() != other.getTaskQuantity()) {
         return false;
      }

      if (this.getInProductionQuantity() != other.getInProductionQuantity()) {
         return false;
      }

      if (this.getCompleteQuantity() != other.getCompleteQuantity()) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$productId = this.getProductId();
            Object other$productId = other.getProductId();
            if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               return this$productType == null ? other$productType == null : this$productType.equals(other$productType);
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
      return other instanceof ProductProductionSummaryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getTaskQuantity();
      result = result * 59 + this.getInProductionQuantity();
      result = result * 59 + this.getCompleteQuantity();
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      return result * 59 + ($productType == null ? 43 : $productType.hashCode());
   }

   @Override
   public String toString() {
      return "ProductProductionSummaryDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ")";
   }

   public static class ProductProductionSummaryDTOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Long productId;
      private Integer productType;
      private int taskQuantity;
      private int inProductionQuantity;
      private int completeQuantity;

      ProductProductionSummaryDTOParamBuilder() {
      }

      public ProductProductionSummaryDTOParam.ProductProductionSummaryDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProductProductionSummaryDTOParam.ProductProductionSummaryDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProductProductionSummaryDTOParam.ProductProductionSummaryDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ProductProductionSummaryDTOParam.ProductProductionSummaryDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProductProductionSummaryDTOParam.ProductProductionSummaryDTOParamBuilder taskQuantity(final int taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      public ProductProductionSummaryDTOParam.ProductProductionSummaryDTOParamBuilder inProductionQuantity(final int inProductionQuantity) {
         this.inProductionQuantity = inProductionQuantity;
         return this;
      }

      public ProductProductionSummaryDTOParam.ProductProductionSummaryDTOParamBuilder completeQuantity(final int completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      public ProductProductionSummaryDTOParam build() {
         return new ProductProductionSummaryDTOParam(
            this.projectId, this.monomerId, this.productId, this.productType, this.taskQuantity, this.inProductionQuantity, this.completeQuantity
         );
      }

      @Override
      public String toString() {
         return "ProductProductionSummaryDTOParam.ProductProductionSummaryDTOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", taskQuantity="
            + this.taskQuantity
            + ", inProductionQuantity="
            + this.inProductionQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ")";
      }
   }
}
