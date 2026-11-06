package com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingWarehouseStorageProduct对象", description = "仓库存储产品记录表")
@Entity
@TableName("mes_building_warehouse_storage_product")
@Table(
   name = "mes_building_warehouse_storage_product",
   indexes = {
         @Index(name = "product_id_type_index", columnList = "product_type, product_id, number"),
         @Index(name = "warehouse_record_id_index", columnList = "warehouse_record_id"),
         @Index(name = "warehouse_summary_id_index", columnList = "warehouse_summary_id"),
         @Index(name = "project_monomer_area_id_index", columnList = "project_id, monomer_id, area_id"),
         @Index(name = "warehouse_workshop_id_index", columnList = "warehouse_workshop_id"),
         @Index(name = "warehouse_id", columnList = "warehouse_id")
   }
)
@org.hibernate.annotations.Table(appliesTo = "mes_building_warehouse_storage_product", comment = "仓库存储产品记录表 ")
public class MesBuildingWarehouseStorageProduct extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "warehouseRecordId", value = "入库记录id", notes = "入库记录id")
   @TableField("warehouse_record_id")
   @Column(name = "warehouse_record_id", columnDefinition = "bigint(20)  COMMENT '入库记录id'", nullable = false)
   private Long warehouseRecordId;
   @ApiModelProperty(name = "warehouseSummaryId", value = "入库汇总id", notes = "入库汇总id")
   @TableField("warehouse_summary_id")
   @Column(name = "warehouse_summary_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '入库汇总id'", nullable = false)
   private Long warehouseSummaryId;
   @ApiModelProperty(name = "factoryId", value = "生产工厂id", notes = "生产工厂id")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '生产工厂id'", nullable = false)
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "生产车间id", notes = "生产车间id")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '生产车间id'", nullable = false)
   private Long workshopId;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20) default '0' COMMENT '单体id'", nullable = false)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id", notes = "区域id")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20) default '0' COMMENT '区域id'", nullable = false)
   private Long areaId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11) default '0' COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20) default '0' COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "int(11)  COMMENT '数量'", nullable = false)
   private Integer quantity;
   @ApiModelProperty(name = "number", value = "码号", notes = "码号")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(11)  COMMENT '码号'", nullable = true)
   private Integer number;
   @ApiModelProperty(name = "warehouseType")
   @TableField("warehouse_type")
   @Column(name = "warehouse_type", columnDefinition = "int(11) DEFAULT 0 COMMENT '出入库类型 0普通出入库 1回厂返修出入库 2申购出入库'", nullable = false)
   private Integer warehouseType;
   @ApiModelProperty(name = "warehouseId", value = "仓库id", notes = "仓库id")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint(20)  COMMENT '仓库id'", nullable = false)
   private Long warehouseId;
   @ApiModelProperty(name = "warehouseWorkshopId", value = "仓库车间id", notes = "仓库车间id")
   @TableField("warehouse_workshop_id")
   @Column(name = "warehouse_workshop_id", columnDefinition = "bigint(20)  COMMENT '仓库车间id'", nullable = false)
   private Long warehouseWorkshopId;
   @ApiModelProperty(name = "warehouseFactoryId", value = "仓库工厂id", notes = "仓库工厂id")
   @TableField("warehouse_factory_id")
   @Column(name = "warehouse_factory_id", columnDefinition = "bigint(20)  COMMENT '仓库工厂id'", nullable = false)
   private Long warehouseFactoryId;
   @ApiModelProperty(name = "userId", value = "操作人id", notes = "操作人id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20) default '0' COMMENT '操作人id'", nullable = false)
   private Long userId;

   public static MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder builder() {
      return new MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder();
   }

   public MesBuildingWarehouseStorageProduct() {
   }

   public MesBuildingWarehouseStorageProduct(
      final Long id,
      final Long warehouseRecordId,
      final Long warehouseSummaryId,
      final Long factoryId,
      final Long workshopId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer productType,
      final Long productId,
      final Integer quantity,
      final Integer number,
      final Integer warehouseType,
      final Long warehouseId,
      final Long warehouseWorkshopId,
      final Long warehouseFactoryId,
      final Long userId
   ) {
      this.id = id;
      this.warehouseRecordId = warehouseRecordId;
      this.warehouseSummaryId = warehouseSummaryId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.productType = productType;
      this.productId = productId;
      this.quantity = quantity;
      this.number = number;
      this.warehouseType = warehouseType;
      this.warehouseId = warehouseId;
      this.warehouseWorkshopId = warehouseWorkshopId;
      this.warehouseFactoryId = warehouseFactoryId;
      this.userId = userId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getWarehouseRecordId() {
      return this.warehouseRecordId;
   }

   public Long getWarehouseSummaryId() {
      return this.warehouseSummaryId;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
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

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Long getWarehouseWorkshopId() {
      return this.warehouseWorkshopId;
   }

   public Long getWarehouseFactoryId() {
      return this.warehouseFactoryId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public MesBuildingWarehouseStorageProduct setId(final Long id) {
      this.id = id;
      return this;
   }

   public MesBuildingWarehouseStorageProduct setWarehouseRecordId(final Long warehouseRecordId) {
      this.warehouseRecordId = warehouseRecordId;
      return this;
   }

   public MesBuildingWarehouseStorageProduct setWarehouseSummaryId(final Long warehouseSummaryId) {
      this.warehouseSummaryId = warehouseSummaryId;
      return this;
   }

   public MesBuildingWarehouseStorageProduct setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   public MesBuildingWarehouseStorageProduct setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public MesBuildingWarehouseStorageProduct setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public MesBuildingWarehouseStorageProduct setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public MesBuildingWarehouseStorageProduct setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public MesBuildingWarehouseStorageProduct setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public MesBuildingWarehouseStorageProduct setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public MesBuildingWarehouseStorageProduct setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   public MesBuildingWarehouseStorageProduct setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   public MesBuildingWarehouseStorageProduct setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   public MesBuildingWarehouseStorageProduct setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   public MesBuildingWarehouseStorageProduct setWarehouseWorkshopId(final Long warehouseWorkshopId) {
      this.warehouseWorkshopId = warehouseWorkshopId;
      return this;
   }

   public MesBuildingWarehouseStorageProduct setWarehouseFactoryId(final Long warehouseFactoryId) {
      this.warehouseFactoryId = warehouseFactoryId;
      return this;
   }

   public MesBuildingWarehouseStorageProduct setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingWarehouseStorageProduct(id="
         + this.getId()
         + ", warehouseRecordId="
         + this.getWarehouseRecordId()
         + ", warehouseSummaryId="
         + this.getWarehouseSummaryId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", quantity="
         + this.getQuantity()
         + ", number="
         + this.getNumber()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", warehouseWorkshopId="
         + this.getWarehouseWorkshopId()
         + ", warehouseFactoryId="
         + this.getWarehouseFactoryId()
         + ", userId="
         + this.getUserId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWarehouseStorageProduct)) {
         return false;
      }

      MesBuildingWarehouseStorageProduct other = (MesBuildingWarehouseStorageProduct)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$warehouseRecordId = this.getWarehouseRecordId();
         Object other$warehouseRecordId = other.getWarehouseRecordId();
         if (this$warehouseRecordId == null ? other$warehouseRecordId == null : this$warehouseRecordId.equals(other$warehouseRecordId)) {
            Object this$warehouseSummaryId = this.getWarehouseSummaryId();
            Object other$warehouseSummaryId = other.getWarehouseSummaryId();
            if (this$warehouseSummaryId == null ? other$warehouseSummaryId == null : this$warehouseSummaryId.equals(other$warehouseSummaryId)) {
               Object this$factoryId = this.getFactoryId();
               Object other$factoryId = other.getFactoryId();
               if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                  Object this$workshopId = this.getWorkshopId();
                  Object other$workshopId = other.getWorkshopId();
                  if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$monomerId = this.getMonomerId();
                        Object other$monomerId = other.getMonomerId();
                        if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                           Object this$areaId = this.getAreaId();
                           Object other$areaId = other.getAreaId();
                           if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                              Object this$productType = this.getProductType();
                              Object other$productType = other.getProductType();
                              if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                 Object this$productId = this.getProductId();
                                 Object other$productId = other.getProductId();
                                 if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                    Object this$quantity = this.getQuantity();
                                    Object other$quantity = other.getQuantity();
                                    if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                       Object this$number = this.getNumber();
                                       Object other$number = other.getNumber();
                                       if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                          Object this$warehouseType = this.getWarehouseType();
                                          Object other$warehouseType = other.getWarehouseType();
                                          if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
                                             Object this$warehouseId = this.getWarehouseId();
                                             Object other$warehouseId = other.getWarehouseId();
                                             if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                                Object this$warehouseWorkshopId = this.getWarehouseWorkshopId();
                                                Object other$warehouseWorkshopId = other.getWarehouseWorkshopId();
                                                if (this$warehouseWorkshopId == null
                                                   ? other$warehouseWorkshopId == null
                                                   : this$warehouseWorkshopId.equals(other$warehouseWorkshopId)) {
                                                   Object this$warehouseFactoryId = this.getWarehouseFactoryId();
                                                   Object other$warehouseFactoryId = other.getWarehouseFactoryId();
                                                   if (this$warehouseFactoryId == null
                                                      ? other$warehouseFactoryId == null
                                                      : this$warehouseFactoryId.equals(other$warehouseFactoryId)) {
                                                      Object this$userId = this.getUserId();
                                                      Object other$userId = other.getUserId();
                                                      return this$userId == null ? other$userId == null : this$userId.equals(other$userId);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof MesBuildingWarehouseStorageProduct;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $warehouseRecordId = this.getWarehouseRecordId();
      result = result * 59 + ($warehouseRecordId == null ? 43 : $warehouseRecordId.hashCode());
      Object $warehouseSummaryId = this.getWarehouseSummaryId();
      result = result * 59 + ($warehouseSummaryId == null ? 43 : $warehouseSummaryId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $warehouseWorkshopId = this.getWarehouseWorkshopId();
      result = result * 59 + ($warehouseWorkshopId == null ? 43 : $warehouseWorkshopId.hashCode());
      Object $warehouseFactoryId = this.getWarehouseFactoryId();
      result = result * 59 + ($warehouseFactoryId == null ? 43 : $warehouseFactoryId.hashCode());
      Object $userId = this.getUserId();
      return result * 59 + ($userId == null ? 43 : $userId.hashCode());
   }

   public static class MesBuildingWarehouseStorageProductBuilder {
      private Long id;
      private Long warehouseRecordId;
      private Long warehouseSummaryId;
      private Long factoryId;
      private Long workshopId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer productType;
      private Long productId;
      private Integer quantity;
      private Integer number;
      private Integer warehouseType;
      private Long warehouseId;
      private Long warehouseWorkshopId;
      private Long warehouseFactoryId;
      private Long userId;

      MesBuildingWarehouseStorageProductBuilder() {
      }

      public MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder warehouseRecordId(final Long warehouseRecordId) {
         this.warehouseRecordId = warehouseRecordId;
         return this;
      }

      public MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder warehouseSummaryId(final Long warehouseSummaryId) {
         this.warehouseSummaryId = warehouseSummaryId;
         return this;
      }

      public MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      public MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder warehouseWorkshopId(final Long warehouseWorkshopId) {
         this.warehouseWorkshopId = warehouseWorkshopId;
         return this;
      }

      public MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder warehouseFactoryId(final Long warehouseFactoryId) {
         this.warehouseFactoryId = warehouseFactoryId;
         return this;
      }

      public MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public MesBuildingWarehouseStorageProduct build() {
         return new MesBuildingWarehouseStorageProduct(
            this.id,
            this.warehouseRecordId,
            this.warehouseSummaryId,
            this.factoryId,
            this.workshopId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.productType,
            this.productId,
            this.quantity,
            this.number,
            this.warehouseType,
            this.warehouseId,
            this.warehouseWorkshopId,
            this.warehouseFactoryId,
            this.userId
         );
      }

      @Override
      public String toString() {
         return "MesBuildingWarehouseStorageProduct.MesBuildingWarehouseStorageProductBuilder(id="
            + this.id
            + ", warehouseRecordId="
            + this.warehouseRecordId
            + ", warehouseSummaryId="
            + this.warehouseSummaryId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
            + ", quantity="
            + this.quantity
            + ", number="
            + this.number
            + ", warehouseType="
            + this.warehouseType
            + ", warehouseId="
            + this.warehouseId
            + ", warehouseWorkshopId="
            + this.warehouseWorkshopId
            + ", warehouseFactoryId="
            + this.warehouseFactoryId
            + ", userId="
            + this.userId
            + ")";
      }
   }
}
