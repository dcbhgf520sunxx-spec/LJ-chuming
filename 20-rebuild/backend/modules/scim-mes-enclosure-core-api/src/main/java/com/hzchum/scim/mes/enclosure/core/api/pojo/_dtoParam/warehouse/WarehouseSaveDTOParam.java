package com.hzchum.scim.mes.enclosure.core.api.pojo._dtoParam.warehouse;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "保存库存记录")
public class WarehouseSaveDTOParam {
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("区域id")
   private Long planId;
   @ApiModelProperty("完成详情id")
   private Long completeId;
   @ApiModelProperty("工厂id")
   private Long factoryId;
   @ApiModelProperty("车间id")
   private Long workshopId;
   @ApiModelProperty("产品id")
   private Long productId;
   @ApiModelProperty("产品类型 2结构4围护8配套件")
   private Integer productType;
   @ApiModelProperty("出入库类型 1入库2出库")
   private Integer type;
   @ApiModelProperty("出入库数量")
   private Integer quantity;
   @ApiModelProperty("编号")
   private Integer number;

   public static WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder builder() {
      return new WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getPlanId() {
      return this.planId;
   }

   public Long getCompleteId() {
      return this.completeId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
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

   public Integer getNumber() {
      return this.number;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setPlanId(final Long planId) {
      this.planId = planId;
   }

   public void setCompleteId(final Long completeId) {
      this.completeId = completeId;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
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

   public void setNumber(final Integer number) {
      this.number = number;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WarehouseSaveDTOParam)) {
         return false;
      }

      WarehouseSaveDTOParam other = (WarehouseSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$planId = this.getPlanId();
            Object other$planId = other.getPlanId();
            if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
               Object this$completeId = this.getCompleteId();
               Object other$completeId = other.getCompleteId();
               if (this$completeId == null ? other$completeId == null : this$completeId.equals(other$completeId)) {
                  Object this$factoryId = this.getFactoryId();
                  Object other$factoryId = other.getFactoryId();
                  if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                     Object this$workshopId = this.getWorkshopId();
                     Object other$workshopId = other.getWorkshopId();
                     if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
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
                                 if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                    Object this$number = this.getNumber();
                                    Object other$number = other.getNumber();
                                    return this$number == null ? other$number == null : this$number.equals(other$number);
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
      return other instanceof WarehouseSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $completeId = this.getCompleteId();
      result = result * 59 + ($completeId == null ? 43 : $completeId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $number = this.getNumber();
      return result * 59 + ($number == null ? 43 : $number.hashCode());
   }

   @Override
   public String toString() {
      return "WarehouseSaveDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", planId="
         + this.getPlanId()
         + ", completeId="
         + this.getCompleteId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", type="
         + this.getType()
         + ", quantity="
         + this.getQuantity()
         + ", number="
         + this.getNumber()
         + ")";
   }

   public WarehouseSaveDTOParam() {
   }

   public WarehouseSaveDTOParam(
      final Long projectId,
      final Long monomerId,
      final Long planId,
      final Long completeId,
      final Long factoryId,
      final Long workshopId,
      final Long productId,
      final Integer productType,
      final Integer type,
      final Integer quantity,
      final Integer number
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.planId = planId;
      this.completeId = completeId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productId = productId;
      this.productType = productType;
      this.type = type;
      this.quantity = quantity;
      this.number = number;
   }

   public static class WarehouseSaveDTOParamBuilder {
      private Long projectId;
      private Long monomerId;
      private Long planId;
      private Long completeId;
      private Long factoryId;
      private Long workshopId;
      private Long productId;
      private Integer productType;
      private Integer type;
      private Integer quantity;
      private Integer number;

      WarehouseSaveDTOParamBuilder() {
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder completeId(final Long completeId) {
         this.completeId = completeId;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public WarehouseSaveDTOParam build() {
         return new WarehouseSaveDTOParam(
            this.projectId,
            this.monomerId,
            this.planId,
            this.completeId,
            this.factoryId,
            this.workshopId,
            this.productId,
            this.productType,
            this.type,
            this.quantity,
            this.number
         );
      }

      @Override
      public String toString() {
         return "WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", planId="
            + this.planId
            + ", completeId="
            + this.completeId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", type="
            + this.type
            + ", quantity="
            + this.quantity
            + ", number="
            + this.number
            + ")";
      }
   }
}
