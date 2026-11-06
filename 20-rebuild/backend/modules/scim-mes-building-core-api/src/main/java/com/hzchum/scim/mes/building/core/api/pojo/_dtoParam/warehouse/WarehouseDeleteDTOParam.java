package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "删除库存记录")
public class WarehouseDeleteDTOParam {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("区域id")
   private Long areaId;
   @ApiModelProperty("完成详情id")
   private Long completeId;
   @ApiModelProperty("工厂id")
   private Long factoryId;
   @ApiModelProperty("产品id")
   private Long productId;
   @ApiModelProperty("产品类型 2结构4围护8配套件")
   private Integer productType;
   @ApiModelProperty("出入库类型 1入库2出库")
   private Integer type;
   @ApiModelProperty("出入库数量")
   private Integer quantity;

   public static WarehouseDeleteDTOParam.WarehouseDeleteDTOParamBuilder builder() {
      return new WarehouseDeleteDTOParam.WarehouseDeleteDTOParamBuilder();
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

   public Long getCompleteId() {
      return this.completeId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getQuantity() {
      return this.quantity;
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

   public void setCompleteId(final Long completeId) {
      this.completeId = completeId;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarehouseDeleteDTOParam)) {
         return false;
      }

      WarehouseDeleteDTOParam other = (WarehouseDeleteDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$completeId = this.getCompleteId();
               Object other$completeId = other.getCompleteId();
               if (this$completeId == null ? other$completeId == null : this$completeId.equals(other$completeId)) {
                  Object this$factoryId = this.getFactoryId();
                  Object other$factoryId = other.getFactoryId();
                  if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                     Object this$productId = this.getProductId();
                     Object other$productId = other.getProductId();
                     if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                        Object this$productType = this.getProductType();
                        Object other$productType = other.getProductType();
                        if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                           Object this$type = this.getType();
                           Object other$type = other.getType();
                           if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                              Object this$quantity = this.getQuantity();
                              Object other$quantity = other.getQuantity();
                              return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
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
      return other instanceof WarehouseDeleteDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $completeId = this.getCompleteId();
      result = result * 59 + ($completeId == null ? 43 : $completeId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "WarehouseDeleteDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", completeId="
         + this.getCompleteId()
         + ", factoryId="
         + this.getFactoryId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", type="
         + this.getType()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }

   public WarehouseDeleteDTOParam() {
   }

   public WarehouseDeleteDTOParam(
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long completeId,
      final Long factoryId,
      final Long productId,
      final Integer productType,
      final Integer type,
      final Integer quantity
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.completeId = completeId;
      this.factoryId = factoryId;
      this.productId = productId;
      this.productType = productType;
      this.type = type;
      this.quantity = quantity;
   }

   public static class WarehouseDeleteDTOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long completeId;
      private Long factoryId;
      private Long productId;
      private Integer productType;
      private Integer type;
      private Integer quantity;

      WarehouseDeleteDTOParamBuilder() {
      }

      public WarehouseDeleteDTOParam.WarehouseDeleteDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public WarehouseDeleteDTOParam.WarehouseDeleteDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public WarehouseDeleteDTOParam.WarehouseDeleteDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public WarehouseDeleteDTOParam.WarehouseDeleteDTOParamBuilder completeId(final Long completeId) {
         this.completeId = completeId;
         return this;
      }

      public WarehouseDeleteDTOParam.WarehouseDeleteDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public WarehouseDeleteDTOParam.WarehouseDeleteDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public WarehouseDeleteDTOParam.WarehouseDeleteDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public WarehouseDeleteDTOParam.WarehouseDeleteDTOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public WarehouseDeleteDTOParam.WarehouseDeleteDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public WarehouseDeleteDTOParam build() {
         return new WarehouseDeleteDTOParam(
            this.projectId, this.monomerId, this.areaId, this.completeId, this.factoryId, this.productId, this.productType, this.type, this.quantity
         );
      }

      @Override
      public String toString() {
         return "WarehouseDeleteDTOParam.WarehouseDeleteDTOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", completeId="
            + this.completeId
            + ", factoryId="
            + this.factoryId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", type="
            + this.type
            + ", quantity="
            + this.quantity
            + ")";
      }
   }
}
