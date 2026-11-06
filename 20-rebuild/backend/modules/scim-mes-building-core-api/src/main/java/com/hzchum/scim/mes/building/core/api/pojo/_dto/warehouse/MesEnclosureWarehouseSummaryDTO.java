package com.hzchum.scim.mes.building.core.api.pojo._dto.warehouse;

import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "MesEnclosureWarehouseSummaryDTO", description = "围护出入库汇总表")
public class MesEnclosureWarehouseSummaryDTO extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "planId", value = "计划id", notes = "计划id")
   private Long planId;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   private Long workshopId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型 2结构4围护8配套件", notes = "产品类型 2结构4围护8配套件")
   private Integer productType;
   @ApiModelProperty(name = "type", value = "出入库类型 1入库2出库", notes = "出入库类型 1入库2出库")
   private Integer type;
   @ApiModelProperty(name = "quantity", value = "出入库数量", notes = "出入库数量")
   private Integer quantity;
   @ApiModelProperty(name = "packageQuantity", value = "已打包数量", notes = "已打包数量")
   private Integer packageQuantity;
   @ApiModelProperty(name = "cargoQuantity", value = "已装车数量", notes = "已装车数量")
   private Integer cargoQuantity;
   @ApiModelProperty(name = "category")
   private Integer category;
   @ApiModelProperty(name = "enclosureName", value = "围护名称")
   private Integer enclosureName;

   public static MesEnclosureWarehouseSummaryDTO.MesEnclosureWarehouseSummaryDTOBuilder builder() {
      return new MesEnclosureWarehouseSummaryDTO.MesEnclosureWarehouseSummaryDTOBuilder();
   }

   public MesEnclosureWarehouseSummaryDTO() {
   }

   public MesEnclosureWarehouseSummaryDTO(
      final Long id,
      final Long projectId,
      final Long planId,
      final Long factoryId,
      final Long workshopId,
      final Long productId,
      final Integer productType,
      final Integer type,
      final Integer quantity,
      final Integer packageQuantity,
      final Integer cargoQuantity,
      final Integer category,
      final Integer enclosureName
   ) {
      this.id = id;
      this.projectId = projectId;
      this.planId = planId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productId = productId;
      this.productType = productType;
      this.type = type;
      this.quantity = quantity;
      this.packageQuantity = packageQuantity;
      this.cargoQuantity = cargoQuantity;
      this.category = category;
      this.enclosureName = enclosureName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getPlanId() {
      return this.planId;
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

   public Integer getPackageQuantity() {
      return this.packageQuantity;
   }

   public Integer getCargoQuantity() {
      return this.cargoQuantity;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Integer getEnclosureName() {
      return this.enclosureName;
   }

   public MesEnclosureWarehouseSummaryDTO setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesEnclosureWarehouseSummaryDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesEnclosureWarehouseSummaryDTO setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   public MesEnclosureWarehouseSummaryDTO setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   public MesEnclosureWarehouseSummaryDTO setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public MesEnclosureWarehouseSummaryDTO setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public MesEnclosureWarehouseSummaryDTO setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public MesEnclosureWarehouseSummaryDTO setType(final Integer type) {
      this.type = type;
      return this;
   }

   public MesEnclosureWarehouseSummaryDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public MesEnclosureWarehouseSummaryDTO setPackageQuantity(final Integer packageQuantity) {
      this.packageQuantity = packageQuantity;
      return this;
   }

   public MesEnclosureWarehouseSummaryDTO setCargoQuantity(final Integer cargoQuantity) {
      this.cargoQuantity = cargoQuantity;
      return this;
   }

   public MesEnclosureWarehouseSummaryDTO setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   public MesEnclosureWarehouseSummaryDTO setEnclosureName(final Integer enclosureName) {
      this.enclosureName = enclosureName;
      return this;
   }

   @Override
   public String toString() {
      return "MesEnclosureWarehouseSummaryDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", planId="
         + this.getPlanId()
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
         + ", packageQuantity="
         + this.getPackageQuantity()
         + ", cargoQuantity="
         + this.getCargoQuantity()
         + ", category="
         + this.getCategory()
         + ", enclosureName="
         + this.getEnclosureName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureWarehouseSummaryDTO)) {
         return false;
      }

      MesEnclosureWarehouseSummaryDTO other = (MesEnclosureWarehouseSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$planId = this.getPlanId();
            Object other$planId = other.getPlanId();
            if (this$planId == null ? other$planId == null : this$planId.equals(other$planId)) {
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
                                 Object this$packageQuantity = this.getPackageQuantity();
                                 Object other$packageQuantity = other.getPackageQuantity();
                                 if (this$packageQuantity == null ? other$packageQuantity == null : this$packageQuantity.equals(other$packageQuantity)) {
                                    Object this$cargoQuantity = this.getCargoQuantity();
                                    Object other$cargoQuantity = other.getCargoQuantity();
                                    if (this$cargoQuantity == null ? other$cargoQuantity == null : this$cargoQuantity.equals(other$cargoQuantity)) {
                                       Object this$category = this.getCategory();
                                       Object other$category = other.getCategory();
                                       if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                                          Object this$enclosureName = this.getEnclosureName();
                                          Object other$enclosureName = other.getEnclosureName();
                                          return this$enclosureName == null ? other$enclosureName == null : this$enclosureName.equals(other$enclosureName);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesEnclosureWarehouseSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
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
      Object $packageQuantity = this.getPackageQuantity();
      result = result * 59 + ($packageQuantity == null ? 43 : $packageQuantity.hashCode());
      Object $cargoQuantity = this.getCargoQuantity();
      result = result * 59 + ($cargoQuantity == null ? 43 : $cargoQuantity.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $enclosureName = this.getEnclosureName();
      return result * 59 + ($enclosureName == null ? 43 : $enclosureName.hashCode());
   }

   public static class MesEnclosureWarehouseSummaryDTOBuilder {
      private Long id;
      private Long projectId;
      private Long planId;
      private Long factoryId;
      private Long workshopId;
      private Long productId;
      private Integer productType;
      private Integer type;
      private Integer quantity;
      private Integer packageQuantity;
      private Integer cargoQuantity;
      private Integer category;
      private Integer enclosureName;

      MesEnclosureWarehouseSummaryDTOBuilder() {
      }

      public MesEnclosureWarehouseSummaryDTO.MesEnclosureWarehouseSummaryDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesEnclosureWarehouseSummaryDTO.MesEnclosureWarehouseSummaryDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesEnclosureWarehouseSummaryDTO.MesEnclosureWarehouseSummaryDTOBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      public MesEnclosureWarehouseSummaryDTO.MesEnclosureWarehouseSummaryDTOBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public MesEnclosureWarehouseSummaryDTO.MesEnclosureWarehouseSummaryDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesEnclosureWarehouseSummaryDTO.MesEnclosureWarehouseSummaryDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesEnclosureWarehouseSummaryDTO.MesEnclosureWarehouseSummaryDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public MesEnclosureWarehouseSummaryDTO.MesEnclosureWarehouseSummaryDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public MesEnclosureWarehouseSummaryDTO.MesEnclosureWarehouseSummaryDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesEnclosureWarehouseSummaryDTO.MesEnclosureWarehouseSummaryDTOBuilder packageQuantity(final Integer packageQuantity) {
         this.packageQuantity = packageQuantity;
         return this;
      }

      public MesEnclosureWarehouseSummaryDTO.MesEnclosureWarehouseSummaryDTOBuilder cargoQuantity(final Integer cargoQuantity) {
         this.cargoQuantity = cargoQuantity;
         return this;
      }

      public MesEnclosureWarehouseSummaryDTO.MesEnclosureWarehouseSummaryDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public MesEnclosureWarehouseSummaryDTO.MesEnclosureWarehouseSummaryDTOBuilder enclosureName(final Integer enclosureName) {
         this.enclosureName = enclosureName;
         return this;
      }

      public MesEnclosureWarehouseSummaryDTO build() {
         return new MesEnclosureWarehouseSummaryDTO(
            this.id,
            this.projectId,
            this.planId,
            this.factoryId,
            this.workshopId,
            this.productId,
            this.productType,
            this.type,
            this.quantity,
            this.packageQuantity,
            this.cargoQuantity,
            this.category,
            this.enclosureName
         );
      }

      @Override
      public String toString() {
         return "MesEnclosureWarehouseSummaryDTO.MesEnclosureWarehouseSummaryDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", planId="
            + this.planId
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
            + ", packageQuantity="
            + this.packageQuantity
            + ", cargoQuantity="
            + this.cargoQuantity
            + ", category="
            + this.category
            + ", enclosureName="
            + this.enclosureName
            + ")";
      }
   }
}
