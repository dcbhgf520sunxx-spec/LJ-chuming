package com.hzchum.scim.mes.building.core.api.pojo._doModel.warehouse;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.Table;

@ApiModel(value = "MesBuildingWarehouseSummary对象", description = "出入库汇总表")
@Entity
@TableName("mes_building_warehouse_summary")
@Table(
   name = "mes_building_warehouse_summary",
   indexes = {
         @Index(name = "productId_index", columnList = "product_id"),
         @Index(name = "projectId_index", columnList = "project_id, monomer_id, area_id"),
         @Index(name = "factoryAndProduct_index", columnList = "factory_id, product_id, product_type,workshop_id,type")
   }
)
public class MesBuildingWarehouseSummary extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @JsonProperty("projectId")
   @JSONField(name = "projectId")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   @JsonProperty("monomerId")
   @JSONField(name = "monomerId")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体id'")
   private Long monomerId;
   @ApiModelProperty(name = "areaBatchId", value = "批次Id", notes = "批次Id")
   @JsonProperty("areaBatchId")
   @JSONField(name = "areaBatchId")
   @TableField("area_batch_id")
   @Column(name = "area_batch_id", columnDefinition = "bigint(20)  COMMENT '批次Id'")
   private Long areaBatchId;
   @ApiModelProperty(name = "areaId", value = "区域Id", notes = "区域Id")
   @JsonProperty("areaId")
   @JSONField(name = "areaId")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域Id'")
   private Long areaId;
   @ApiModelProperty(name = "planId", value = "计划id", notes = "计划id")
   @JsonProperty("planId")
   @JSONField(name = "planId")
   @TableField("plan_id")
   @Column(name = "plan_id", columnDefinition = "bigint(20)  COMMENT '计划id'")
   private Long planId;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @JsonProperty("factoryId")
   @JSONField(name = "factoryId")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'", nullable = false)
   private Long factoryId;
   @ApiModelProperty(name = "workshopId", value = "车间id", notes = "车间id")
   @JsonProperty("workshopId")
   @JSONField(name = "workshopId")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = false)
   private Long workshopId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @JsonProperty("productId")
   @JSONField(name = "productId")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型 2结构4围护8配套件", notes = "产品类型 2结构4围护8配套件")
   @JsonProperty("productType")
   @JSONField(name = "productType")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型 2结构4围护8配套件'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "type", value = "出入库类型 1入库2出库", notes = "出入库类型 1入库2出库")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type", columnDefinition = "int(11) default '0' COMMENT '出入库类型 1入库2出库'", nullable = false)
   private Integer type;
   @ApiModelProperty(name = "quantity", value = "出入库数量", notes = "出入库数量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(18,4) default '0' COMMENT '出入库数量'")
   private BigDecimal quantity;
   @ApiModelProperty(name = "packageQuantity", value = "已打包数量", notes = "已打包数量")
   @JsonProperty("packageQuantity")
   @JSONField(name = "packageQuantity")
   @TableField("package_quantity")
   @Column(name = "package_quantity", columnDefinition = "decimal(18,4) default '0.0000' COMMENT '已打包数量'")
   private BigDecimal packageQuantity;
   @ApiModelProperty(name = "cargoQuantity", value = "已装车数量", notes = "已装车数量")
   @JsonProperty("cargoQuantity")
   @JSONField(name = "cargoQuantity")
   @TableField("cargo_quantity")
   @Column(name = "cargo_quantity", columnDefinition = "decimal(18,4) default '0.0000' COMMENT '已装车数量'")
   private BigDecimal cargoQuantity;
   @ApiModelProperty(name = "category")
   @JsonProperty("category")
   @JSONField(name = "category")
   @TableField("category")
   @Column(name = "category", columnDefinition = "int(11)  COMMENT ''", nullable = true)
   private Integer category;
   @ApiModelProperty(name = "dictionaryId")
   @JsonProperty("dictionaryId")
   @JSONField(name = "dictionaryId")
   @TableField("dictionary_id")
   @Column(name = "dictionary_id", columnDefinition = "bigint(11)  COMMENT '字典类型id'", nullable = true)
   private Long dictionaryId;
   @ApiModelProperty(name = "warehouseType")
   @JsonProperty("warehouseType")
   @JSONField(name = "warehouseType")
   @TableField("warehouse_type")
   @Column(name = "warehouse_type", columnDefinition = "int(11) default '0' COMMENT ''", nullable = false)
   private Integer warehouseType;
   @ApiModelProperty(name = "materialInventoryId", value = "WMS库存Id", notes = "WMS库存Id")
   @JsonProperty("materialInventoryId")
   @JSONField(name = "materialInventoryId")
   @TableField("material_inventory_id")
   @Column(name = "material_inventory_id", columnDefinition = "bigint(20)  COMMENT 'WMS库存Id'")
   private Long materialInventoryId;
   @ApiModelProperty(name = "outboundDetailId", value = "wms出库详情Id", notes = "wms出库详情Id")
   @TableField("outbound_detail_id")
   @Column(name = "outbound_detail_id", columnDefinition = "bigint(20)  COMMENT 'wms出库详情Id'")
   private Long outboundDetailId;
   @ApiModelProperty(name = "printQuantity")
   @JsonProperty("printQuantity")
   @JSONField(name = "printQuantity")
   @TableField("print_quantity")
   @Column(name = "print_quantity", columnDefinition = "decimal(18,4) default '0' COMMENT ''", nullable = true)
   private BigDecimal printQuantity;
   @ApiModelProperty(name = "printTime")
   @JsonProperty("printTime")
   @JSONField(name = "printTime")
   @TableField("print_time")
   @Column(name = "print_time", columnDefinition = "datetime(6)  COMMENT ''", nullable = true)
   private LocalDateTime printTime;
   @ApiModelProperty(name = "boolPrinted", value = "是否打印")
   @JsonProperty("boolPrinted")
   @JSONField(name = "boolPrinted")
   @TableField("bool_printed")
   @Column(name = "bool_printed", nullable = false, columnDefinition = "tinyint(1) default 0 COMMENT '是否打印: 0 未打印,1 打印'")
   private Boolean boolPrinted;
   @ApiModelProperty(name = "userName", value = "创建人", notes = "创建人")
   @JsonProperty("userName")
   @JSONField(name = "userName")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(500)  COMMENT '创建人'")
   private String userName;

   public static MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder builder() {
      return new MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder();
   }

   public MesBuildingWarehouseSummary() {
   }

   public MesBuildingWarehouseSummary(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final Long areaBatchId,
      final Long areaId,
      final Long planId,
      final Long factoryId,
      final Long workshopId,
      final Long productId,
      final Integer productType,
      final Integer type,
      final BigDecimal quantity,
      final BigDecimal packageQuantity,
      final BigDecimal cargoQuantity,
      final Integer category,
      final Long dictionaryId,
      final Integer warehouseType,
      final Long materialInventoryId,
      final Long outboundDetailId,
      final BigDecimal printQuantity,
      final LocalDateTime printTime,
      final Boolean boolPrinted,
      final String userName
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaBatchId = areaBatchId;
      this.areaId = areaId;
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
      this.dictionaryId = dictionaryId;
      this.warehouseType = warehouseType;
      this.materialInventoryId = materialInventoryId;
      this.outboundDetailId = outboundDetailId;
      this.printQuantity = printQuantity;
      this.printTime = printTime;
      this.boolPrinted = boolPrinted;
      this.userName = userName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaBatchId() {
      return this.areaBatchId;
   }

   public Long getAreaId() {
      return this.areaId;
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

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getPackageQuantity() {
      return this.packageQuantity;
   }

   public BigDecimal getCargoQuantity() {
      return this.cargoQuantity;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public Long getOutboundDetailId() {
      return this.outboundDetailId;
   }

   public BigDecimal getPrintQuantity() {
      return this.printQuantity;
   }

   public LocalDateTime getPrintTime() {
      return this.printTime;
   }

   public Boolean getBoolPrinted() {
      return this.boolPrinted;
   }

   public String getUserName() {
      return this.userName;
   }

   @JsonProperty("id")
   public MesBuildingWarehouseSummary setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("projectId")
   public MesBuildingWarehouseSummary setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   @JsonProperty("monomerId")
   public MesBuildingWarehouseSummary setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   @JsonProperty("areaBatchId")
   public MesBuildingWarehouseSummary setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
      return this;
   }

   @JsonProperty("areaId")
   public MesBuildingWarehouseSummary setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   @JsonProperty("planId")
   public MesBuildingWarehouseSummary setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   @JsonProperty("factoryId")
   public MesBuildingWarehouseSummary setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   @JsonProperty("workshopId")
   public MesBuildingWarehouseSummary setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   @JsonProperty("productId")
   public MesBuildingWarehouseSummary setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   @JsonProperty("productType")
   public MesBuildingWarehouseSummary setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   @JsonProperty("type")
   public MesBuildingWarehouseSummary setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonProperty("quantity")
   public MesBuildingWarehouseSummary setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("packageQuantity")
   public MesBuildingWarehouseSummary setPackageQuantity(final BigDecimal packageQuantity) {
      this.packageQuantity = packageQuantity;
      return this;
   }

   @JsonProperty("cargoQuantity")
   public MesBuildingWarehouseSummary setCargoQuantity(final BigDecimal cargoQuantity) {
      this.cargoQuantity = cargoQuantity;
      return this;
   }

   @JsonProperty("category")
   public MesBuildingWarehouseSummary setCategory(final Integer category) {
      this.category = category;
      return this;
   }

   @JsonProperty("dictionaryId")
   public MesBuildingWarehouseSummary setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
      return this;
   }

   @JsonProperty("warehouseType")
   public MesBuildingWarehouseSummary setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
      return this;
   }

   @JsonProperty("materialInventoryId")
   public MesBuildingWarehouseSummary setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
      return this;
   }

   public MesBuildingWarehouseSummary setOutboundDetailId(final Long outboundDetailId) {
      this.outboundDetailId = outboundDetailId;
      return this;
   }

   @JsonProperty("printQuantity")
   public MesBuildingWarehouseSummary setPrintQuantity(final BigDecimal printQuantity) {
      this.printQuantity = printQuantity;
      return this;
   }

   @JsonProperty("printTime")
   public MesBuildingWarehouseSummary setPrintTime(final LocalDateTime printTime) {
      this.printTime = printTime;
      return this;
   }

   @JsonProperty("boolPrinted")
   public MesBuildingWarehouseSummary setBoolPrinted(final Boolean boolPrinted) {
      this.boolPrinted = boolPrinted;
      return this;
   }

   @JsonProperty("userName")
   public MesBuildingWarehouseSummary setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @Override
   public String toString() {
      return "MesBuildingWarehouseSummary(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", areaId="
         + this.getAreaId()
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
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", outboundDetailId="
         + this.getOutboundDetailId()
         + ", printQuantity="
         + this.getPrintQuantity()
         + ", printTime="
         + this.getPrintTime()
         + ", boolPrinted="
         + this.getBoolPrinted()
         + ", userName="
         + this.getUserName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesBuildingWarehouseSummary)) {
         return false;
      }

      MesBuildingWarehouseSummary other = (MesBuildingWarehouseSummary)o;
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
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaBatchId = this.getAreaBatchId();
               Object other$areaBatchId = other.getAreaBatchId();
               if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
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
                                       Object this$category = this.getCategory();
                                       Object other$category = other.getCategory();
                                       if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                                          Object this$dictionaryId = this.getDictionaryId();
                                          Object other$dictionaryId = other.getDictionaryId();
                                          if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
                                             Object this$warehouseType = this.getWarehouseType();
                                             Object other$warehouseType = other.getWarehouseType();
                                             if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
                                                Object this$materialInventoryId = this.getMaterialInventoryId();
                                                Object other$materialInventoryId = other.getMaterialInventoryId();
                                                if (this$materialInventoryId == null
                                                   ? other$materialInventoryId == null
                                                   : this$materialInventoryId.equals(other$materialInventoryId)) {
                                                   Object this$outboundDetailId = this.getOutboundDetailId();
                                                   Object other$outboundDetailId = other.getOutboundDetailId();
                                                   if (this$outboundDetailId == null
                                                      ? other$outboundDetailId == null
                                                      : this$outboundDetailId.equals(other$outboundDetailId)) {
                                                      Object this$boolPrinted = this.getBoolPrinted();
                                                      Object other$boolPrinted = other.getBoolPrinted();
                                                      if (this$boolPrinted == null ? other$boolPrinted == null : this$boolPrinted.equals(other$boolPrinted)) {
                                                         Object this$quantity = this.getQuantity();
                                                         Object other$quantity = other.getQuantity();
                                                         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                            Object this$packageQuantity = this.getPackageQuantity();
                                                            Object other$packageQuantity = other.getPackageQuantity();
                                                            if (this$packageQuantity == null
                                                               ? other$packageQuantity == null
                                                               : this$packageQuantity.equals(other$packageQuantity)) {
                                                               Object this$cargoQuantity = this.getCargoQuantity();
                                                               Object other$cargoQuantity = other.getCargoQuantity();
                                                               if (this$cargoQuantity == null
                                                                  ? other$cargoQuantity == null
                                                                  : this$cargoQuantity.equals(other$cargoQuantity)) {
                                                                  Object this$printQuantity = this.getPrintQuantity();
                                                                  Object other$printQuantity = other.getPrintQuantity();
                                                                  if (this$printQuantity == null
                                                                     ? other$printQuantity == null
                                                                     : this$printQuantity.equals(other$printQuantity)) {
                                                                     Object this$printTime = this.getPrintTime();
                                                                     Object other$printTime = other.getPrintTime();
                                                                     if (this$printTime == null
                                                                        ? other$printTime == null
                                                                        : this$printTime.equals(other$printTime)) {
                                                                        Object this$userName = this.getUserName();
                                                                        Object other$userName = other.getUserName();
                                                                        return this$userName == null
                                                                           ? other$userName == null
                                                                           : this$userName.equals(other$userName);
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
      return other instanceof MesBuildingWarehouseSummary;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
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
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $outboundDetailId = this.getOutboundDetailId();
      result = result * 59 + ($outboundDetailId == null ? 43 : $outboundDetailId.hashCode());
      Object $boolPrinted = this.getBoolPrinted();
      result = result * 59 + ($boolPrinted == null ? 43 : $boolPrinted.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $packageQuantity = this.getPackageQuantity();
      result = result * 59 + ($packageQuantity == null ? 43 : $packageQuantity.hashCode());
      Object $cargoQuantity = this.getCargoQuantity();
      result = result * 59 + ($cargoQuantity == null ? 43 : $cargoQuantity.hashCode());
      Object $printQuantity = this.getPrintQuantity();
      result = result * 59 + ($printQuantity == null ? 43 : $printQuantity.hashCode());
      Object $printTime = this.getPrintTime();
      result = result * 59 + ($printTime == null ? 43 : $printTime.hashCode());
      Object $userName = this.getUserName();
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   public static class MesBuildingWarehouseSummaryBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private Long areaBatchId;
      private Long areaId;
      private Long planId;
      private Long factoryId;
      private Long workshopId;
      private Long productId;
      private Integer productType;
      private Integer type;
      private BigDecimal quantity;
      private BigDecimal packageQuantity;
      private BigDecimal cargoQuantity;
      private Integer category;
      private Long dictionaryId;
      private Integer warehouseType;
      private Long materialInventoryId;
      private Long outboundDetailId;
      private BigDecimal printQuantity;
      private LocalDateTime printTime;
      private Boolean boolPrinted;
      private String userName;

      MesBuildingWarehouseSummaryBuilder() {
      }

      @JsonProperty("id")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("projectId")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      @JsonProperty("monomerId")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      @JsonProperty("areaBatchId")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
         return this;
      }

      @JsonProperty("areaId")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      @JsonProperty("planId")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      @JsonProperty("factoryId")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      @JsonProperty("workshopId")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      @JsonProperty("productId")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      @JsonProperty("productType")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      @JsonProperty("type")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonProperty("quantity")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("packageQuantity")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder packageQuantity(final BigDecimal packageQuantity) {
         this.packageQuantity = packageQuantity;
         return this;
      }

      @JsonProperty("cargoQuantity")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder cargoQuantity(final BigDecimal cargoQuantity) {
         this.cargoQuantity = cargoQuantity;
         return this;
      }

      @JsonProperty("category")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      @JsonProperty("dictionaryId")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder dictionaryId(final Long dictionaryId) {
         this.dictionaryId = dictionaryId;
         return this;
      }

      @JsonProperty("warehouseType")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      @JsonProperty("materialInventoryId")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder outboundDetailId(final Long outboundDetailId) {
         this.outboundDetailId = outboundDetailId;
         return this;
      }

      @JsonProperty("printQuantity")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder printQuantity(final BigDecimal printQuantity) {
         this.printQuantity = printQuantity;
         return this;
      }

      @JsonProperty("printTime")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder printTime(final LocalDateTime printTime) {
         this.printTime = printTime;
         return this;
      }

      @JsonProperty("boolPrinted")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder boolPrinted(final Boolean boolPrinted) {
         this.boolPrinted = boolPrinted;
         return this;
      }

      @JsonProperty("userName")
      public MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public MesBuildingWarehouseSummary build() {
         return new MesBuildingWarehouseSummary(
            this.id,
            this.projectId,
            this.monomerId,
            this.areaBatchId,
            this.areaId,
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
            this.dictionaryId,
            this.warehouseType,
            this.materialInventoryId,
            this.outboundDetailId,
            this.printQuantity,
            this.printTime,
            this.boolPrinted,
            this.userName
         );
      }

      @Override
      public String toString() {
         return "MesBuildingWarehouseSummary.MesBuildingWarehouseSummaryBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaBatchId="
            + this.areaBatchId
            + ", areaId="
            + this.areaId
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
            + ", dictionaryId="
            + this.dictionaryId
            + ", warehouseType="
            + this.warehouseType
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", outboundDetailId="
            + this.outboundDetailId
            + ", printQuantity="
            + this.printQuantity
            + ", printTime="
            + this.printTime
            + ", boolPrinted="
            + this.boolPrinted
            + ", userName="
            + this.userName
            + ")";
      }
   }
}
