package com.hzchum.scim.mes.enclosure.core.api.pojo._doParam.record;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class ProductProductionSummaryTaskDTOParam {
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
   @ApiModelProperty("任务创建时间")
   private LocalDateTime dateTime;

   ProductProductionSummaryTaskDTOParam(
      final Long productId,
      final Integer productType,
      final int taskQuantity,
      final int inProductionQuantity,
      final int completeQuantity,
      final LocalDateTime dateTime
   ) {
      this.productId = productId;
      this.productType = productType;
      this.taskQuantity = taskQuantity;
      this.inProductionQuantity = inProductionQuantity;
      this.completeQuantity = completeQuantity;
      this.dateTime = dateTime;
   }

   public static ProductProductionSummaryTaskDTOParam.ProductProductionSummaryTaskDTOParamBuilder builder() {
      return new ProductProductionSummaryTaskDTOParam.ProductProductionSummaryTaskDTOParamBuilder();
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

   public LocalDateTime getDateTime() {
      return this.dateTime;
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

   public void setDateTime(final LocalDateTime dateTime) {
      this.dateTime = dateTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductProductionSummaryTaskDTOParam)) {
         return false;
      }

      ProductProductionSummaryTaskDTOParam other = (ProductProductionSummaryTaskDTOParam)o;
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

      Object this$productId = this.getProductId();
      Object other$productId = other.getProductId();
      if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
         Object this$productType = this.getProductType();
         Object other$productType = other.getProductType();
         if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
            Object this$dateTime = this.getDateTime();
            Object other$dateTime = other.getDateTime();
            return this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProductProductionSummaryTaskDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getTaskQuantity();
      result = result * 59 + this.getInProductionQuantity();
      result = result * 59 + this.getCompleteQuantity();
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $dateTime = this.getDateTime();
      return result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
   }

   @Override
   public String toString() {
      return "ProductProductionSummaryTaskDTOParam(productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", taskQuantity="
         + this.getTaskQuantity()
         + ", inProductionQuantity="
         + this.getInProductionQuantity()
         + ", completeQuantity="
         + this.getCompleteQuantity()
         + ", dateTime="
         + this.getDateTime()
         + ")";
   }

   public static class ProductProductionSummaryTaskDTOParamBuilder {
      private Long productId;
      private Integer productType;
      private int taskQuantity;
      private int inProductionQuantity;
      private int completeQuantity;
      private LocalDateTime dateTime;

      ProductProductionSummaryTaskDTOParamBuilder() {
      }

      public ProductProductionSummaryTaskDTOParam.ProductProductionSummaryTaskDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ProductProductionSummaryTaskDTOParam.ProductProductionSummaryTaskDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProductProductionSummaryTaskDTOParam.ProductProductionSummaryTaskDTOParamBuilder taskQuantity(final int taskQuantity) {
         this.taskQuantity = taskQuantity;
         return this;
      }

      public ProductProductionSummaryTaskDTOParam.ProductProductionSummaryTaskDTOParamBuilder inProductionQuantity(final int inProductionQuantity) {
         this.inProductionQuantity = inProductionQuantity;
         return this;
      }

      public ProductProductionSummaryTaskDTOParam.ProductProductionSummaryTaskDTOParamBuilder completeQuantity(final int completeQuantity) {
         this.completeQuantity = completeQuantity;
         return this;
      }

      public ProductProductionSummaryTaskDTOParam.ProductProductionSummaryTaskDTOParamBuilder dateTime(final LocalDateTime dateTime) {
         this.dateTime = dateTime;
         return this;
      }

      public ProductProductionSummaryTaskDTOParam build() {
         return new ProductProductionSummaryTaskDTOParam(
            this.productId, this.productType, this.taskQuantity, this.inProductionQuantity, this.completeQuantity, this.dateTime
         );
      }

      @Override
      public String toString() {
         return "ProductProductionSummaryTaskDTOParam.ProductProductionSummaryTaskDTOParamBuilder(productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", taskQuantity="
            + this.taskQuantity
            + ", inProductionQuantity="
            + this.inProductionQuantity
            + ", completeQuantity="
            + this.completeQuantity
            + ", dateTime="
            + this.dateTime
            + ")";
      }
   }
}
