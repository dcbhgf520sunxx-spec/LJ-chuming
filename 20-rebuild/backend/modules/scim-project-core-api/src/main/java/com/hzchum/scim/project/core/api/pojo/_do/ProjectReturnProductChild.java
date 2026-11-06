package com.hzchum.scim.project.core.api.pojo._do;

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
import org.hibernate.annotations.Table;

@ApiModel(value = "ProjectReturnProductChild对象", description = "制成品退货子表 ")
@Entity
@TableName("project_return_product_child")
@Table(appliesTo = "project_return_product_child", comment = "制成品退货子表 ")
public class ProjectReturnProductChild extends BaseEntity<Long> {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "mainId", value = "主表id", notes = "主表id")
   @TableField("main_id")
   @Column(name = "main_id", columnDefinition = "bigint(20)  COMMENT '主表id'", nullable = false)
   private Long mainId;
   @ApiModelProperty(name = "mesBuildingWarehouseRecordId", value = "出库记录id(或任务id)", notes = "出库记录id(或任务id)")
   @TableField("mes_building_warehouse_record_id")
   @Column(name = "mes_building_warehouse_record_id", columnDefinition = "bigint(20) DEFAULT 0 COMMENT '出库记录id(或任务id)'", nullable = false)
   private Long mesBuildingWarehouseRecordId;
   @ApiModelProperty(name = "cargoLinkId", value = "发运详情id", notes = "发运详情id")
   @TableField("cargo_link_id")
   @Column(name = "cargo_link_id", columnDefinition = "bigint(20)  COMMENT '发运详情id'", nullable = true)
   private Long cargoLinkId;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   @TableField("monomer_id")
   @Column(name = "monomer_id", columnDefinition = "bigint(20)  COMMENT '单体ID'", nullable = true)
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   @TableField("area_id")
   @Column(name = "area_id", columnDefinition = "bigint(20)  COMMENT '区域ID'", nullable = true)
   private Long areaId;
   @ApiModelProperty(name = "planId", value = "计划id", notes = "计划id")
   @TableField("plan_id")
   @Column(name = "plan_id", columnDefinition = "bigint(20)  COMMENT '计划id'", nullable = true)
   private Long planId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   @TableField("product_id")
   @Column(name = "product_id", columnDefinition = "bigint(20)  COMMENT '产品id'", nullable = false)
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型")
   @TableField("product_type")
   @Column(name = "product_type", columnDefinition = "int(11)  COMMENT '产品类型'", nullable = false)
   private Integer productType;
   @ApiModelProperty(name = "quantity", value = "数量", notes = "数量")
   @TableField("quantity")
   @Column(name = "quantity", columnDefinition = "decimal(18,4)  COMMENT '数量'", nullable = false)
   private BigDecimal quantity;
   @ApiModelProperty(name = "unitPrice", value = "单价", notes = "单价")
   @TableField("unit_price")
   @Column(name = "unit_price", columnDefinition = "decimal(32,8)  COMMENT '单价'", nullable = true)
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "totalArea", value = "总面积（㎡）", notes = "总面积（㎡）")
   @TableField("total_area")
   @Column(name = "total_area", columnDefinition = "decimal(18,8)  COMMENT '总面积（㎡）'", nullable = true)
   private BigDecimal totalArea;
   @ApiModelProperty(name = "totalAmount", value = "总金额", notes = "总金额")
   @TableField("total_amount")
   @Column(name = "total_amount", columnDefinition = "decimal(32,8)  COMMENT '总金额' ", nullable = true)
   private BigDecimal totalAmount;
   @ApiModelProperty(name = "pricingManner", value = "计价方式  0重量 1长度 2面积", notes = "计价方式  0重量 1长度 2面积")
   @TableField("pricing_manner")
   @Column(name = "pricing_manner", columnDefinition = "int(1) COMMENT '计价方式 0重量 1长度 2面积'", nullable = true)
   private Integer pricingManner;
   @ApiModelProperty(name = "handleMethod", value = "处理方式", notes = "处理方式")
   @TableField("handle_method")
   @Column(name = "handle_method", columnDefinition = "tinyint(1) default 0 COMMENT '处理方式'", nullable = false)
   private Integer handleMethod;
   @ApiModelProperty(name = "branchCompanyId", value = "分支机构id(购买方)", notes = "分支机构id(购买方)")
   @TableField("branch_company_id")
   @Column(name = "branch_company_id", columnDefinition = "bigint(20)  COMMENT '分支机构id(购买方)'", nullable = true)
   private Long branchCompanyId;
   @ApiModelProperty(name = "customerUnit", value = "客户单位(出售方)", notes = "客户单位(出售方)")
   @TableField("customer_unit")
   @Column(name = "customer_unit", columnDefinition = "varchar(64)  COMMENT '客户单位(出售方)'", nullable = true)
   private String customerUnit;
   @ApiModelProperty(name = "factoryId", value = "工厂id", notes = "工厂id")
   @TableField("factory_id")
   @Column(name = "factory_id", columnDefinition = "bigint(20)  COMMENT '工厂id'", nullable = true)
   private Long factoryId;
   @ApiModelProperty("车间id")
   @TableField("workshop_id")
   @Column(name = "workshop_id", columnDefinition = "bigint(20)  COMMENT '车间id'", nullable = true)
   private Long workshopId;
   @ApiModelProperty(name = "status", value = "产品状态 1已发运 2已入库 4已排产", notes = "产品状态 1已发运 2已入库 4已排产")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(11) default 1 COMMENT '产品状态 1已发运 2已入库 4已排产'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "warehouseId", value = "存放仓库id", notes = "存放仓库id")
   @TableField("warehouse_id")
   @Column(name = "warehouse_id", columnDefinition = "bigint(20) COMMENT '存放仓库id'", nullable = true)
   private Long warehouseId;
   @ApiModelProperty(name = "auditStatus", value = "审核状态 1未审核 2审核通过 4驳回", notes = "审核状态 1未审核 2审核通过 4驳回")
   @TableField("audit_status")
   @Column(name = "audit_status", columnDefinition = "int(11) default 1 COMMENT '审核状态 1未审核 2审核通过 4驳回'", nullable = false)
   private Integer auditStatus;
   @ApiModelProperty(name = "auditTime", value = "审核时间", notes = "审核时间")
   @TableField("audit_time")
   @Column(name = "audit_time", columnDefinition = "datetime  COMMENT '审核时间'", nullable = true)
   private LocalDateTime auditTime;
   @ApiModelProperty(name = "reuseQuantity", value = "二次利用数量", notes = "二次利用数量")
   @TableField("reuse_quantity")
   @Column(name = "reuse_quantity", columnDefinition = "DECIMAL(18,4)  default 0 COMMENT '二次利用数量'", nullable = false)
   private BigDecimal reuseQuantity;
   @ApiModelProperty(name = "wasteSaleQuantity", value = "废品出售数量", notes = "废品出售数量")
   @TableField("waste_sale_quantity")
   @Column(name = "waste_sale_quantity", columnDefinition = "DECIMAL(18,4) default 0 COMMENT '废品出售数量'", nullable = false)
   private BigDecimal wasteSaleQuantity;

   public static ProjectReturnProductChild.ProjectReturnProductChildBuilder builder() {
      return new ProjectReturnProductChild.ProjectReturnProductChildBuilder();
   }

   public ProjectReturnProductChild() {
   }

   public ProjectReturnProductChild(
      final Long id,
      final Long mainId,
      final Long mesBuildingWarehouseRecordId,
      final Long cargoLinkId,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long planId,
      final Long productId,
      final Integer productType,
      final BigDecimal quantity,
      final BigDecimal unitPrice,
      final BigDecimal totalArea,
      final BigDecimal totalAmount,
      final Integer pricingManner,
      final Integer handleMethod,
      final Long branchCompanyId,
      final String customerUnit,
      final Long factoryId,
      final Long workshopId,
      final Integer status,
      final Long warehouseId,
      final Integer auditStatus,
      final LocalDateTime auditTime,
      final BigDecimal reuseQuantity,
      final BigDecimal wasteSaleQuantity
   ) {
      this.id = id;
      this.mainId = mainId;
      this.mesBuildingWarehouseRecordId = mesBuildingWarehouseRecordId;
      this.cargoLinkId = cargoLinkId;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.planId = planId;
      this.productId = productId;
      this.productType = productType;
      this.quantity = quantity;
      this.unitPrice = unitPrice;
      this.totalArea = totalArea;
      this.totalAmount = totalAmount;
      this.pricingManner = pricingManner;
      this.handleMethod = handleMethod;
      this.branchCompanyId = branchCompanyId;
      this.customerUnit = customerUnit;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.status = status;
      this.warehouseId = warehouseId;
      this.auditStatus = auditStatus;
      this.auditTime = auditTime;
      this.reuseQuantity = reuseQuantity;
      this.wasteSaleQuantity = wasteSaleQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReturnProductChild)) {
         return false;
      }

      ProjectReturnProductChild other = (ProjectReturnProductChild)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$mainId = this.getMainId();
         Object other$mainId = other.getMainId();
         if (this$mainId == null ? other$mainId == null : this$mainId.equals(other$mainId)) {
            Object this$mesBuildingWarehouseRecordId = this.getMesBuildingWarehouseRecordId();
            Object other$mesBuildingWarehouseRecordId = other.getMesBuildingWarehouseRecordId();
            if (this$mesBuildingWarehouseRecordId == null
               ? other$mesBuildingWarehouseRecordId == null
               : this$mesBuildingWarehouseRecordId.equals(other$mesBuildingWarehouseRecordId)) {
               Object this$cargoLinkId = this.getCargoLinkId();
               Object other$cargoLinkId = other.getCargoLinkId();
               if (this$cargoLinkId == null ? other$cargoLinkId == null : this$cargoLinkId.equals(other$cargoLinkId)) {
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
                              Object this$productId = this.getProductId();
                              Object other$productId = other.getProductId();
                              if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                 Object this$productType = this.getProductType();
                                 Object other$productType = other.getProductType();
                                 if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                    Object this$pricingManner = this.getPricingManner();
                                    Object other$pricingManner = other.getPricingManner();
                                    if (this$pricingManner == null ? other$pricingManner == null : this$pricingManner.equals(other$pricingManner)) {
                                       Object this$handleMethod = this.getHandleMethod();
                                       Object other$handleMethod = other.getHandleMethod();
                                       if (this$handleMethod == null ? other$handleMethod == null : this$handleMethod.equals(other$handleMethod)) {
                                          Object this$branchCompanyId = this.getBranchCompanyId();
                                          Object other$branchCompanyId = other.getBranchCompanyId();
                                          if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)
                                             )
                                           {
                                             Object this$factoryId = this.getFactoryId();
                                             Object other$factoryId = other.getFactoryId();
                                             if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                                                Object this$workshopId = this.getWorkshopId();
                                                Object other$workshopId = other.getWorkshopId();
                                                if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                   Object this$status = this.getStatus();
                                                   Object other$status = other.getStatus();
                                                   if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                                                      Object this$warehouseId = this.getWarehouseId();
                                                      Object other$warehouseId = other.getWarehouseId();
                                                      if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                                         Object this$auditStatus = this.getAuditStatus();
                                                         Object other$auditStatus = other.getAuditStatus();
                                                         if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                                                            Object this$quantity = this.getQuantity();
                                                            Object other$quantity = other.getQuantity();
                                                            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                               Object this$unitPrice = this.getUnitPrice();
                                                               Object other$unitPrice = other.getUnitPrice();
                                                               if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                                                  Object this$totalArea = this.getTotalArea();
                                                                  Object other$totalArea = other.getTotalArea();
                                                                  if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)
                                                                     )
                                                                   {
                                                                     Object this$totalAmount = this.getTotalAmount();
                                                                     Object other$totalAmount = other.getTotalAmount();
                                                                     if (this$totalAmount == null
                                                                        ? other$totalAmount == null
                                                                        : this$totalAmount.equals(other$totalAmount)) {
                                                                        Object this$customerUnit = this.getCustomerUnit();
                                                                        Object other$customerUnit = other.getCustomerUnit();
                                                                        if (this$customerUnit == null
                                                                           ? other$customerUnit == null
                                                                           : this$customerUnit.equals(other$customerUnit)) {
                                                                           Object this$auditTime = this.getAuditTime();
                                                                           Object other$auditTime = other.getAuditTime();
                                                                           if (this$auditTime == null
                                                                              ? other$auditTime == null
                                                                              : this$auditTime.equals(other$auditTime)) {
                                                                              Object this$reuseQuantity = this.getReuseQuantity();
                                                                              Object other$reuseQuantity = other.getReuseQuantity();
                                                                              if (this$reuseQuantity == null
                                                                                 ? other$reuseQuantity == null
                                                                                 : this$reuseQuantity.equals(other$reuseQuantity)) {
                                                                                 Object this$wasteSaleQuantity = this.getWasteSaleQuantity();
                                                                                 Object other$wasteSaleQuantity = other.getWasteSaleQuantity();
                                                                                 return this$wasteSaleQuantity == null
                                                                                    ? other$wasteSaleQuantity == null
                                                                                    : this$wasteSaleQuantity.equals(other$wasteSaleQuantity);
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
      return other instanceof ProjectReturnProductChild;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $mainId = this.getMainId();
      result = result * 59 + ($mainId == null ? 43 : $mainId.hashCode());
      Object $mesBuildingWarehouseRecordId = this.getMesBuildingWarehouseRecordId();
      result = result * 59 + ($mesBuildingWarehouseRecordId == null ? 43 : $mesBuildingWarehouseRecordId.hashCode());
      Object $cargoLinkId = this.getCargoLinkId();
      result = result * 59 + ($cargoLinkId == null ? 43 : $cargoLinkId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $pricingManner = this.getPricingManner();
      result = result * 59 + ($pricingManner == null ? 43 : $pricingManner.hashCode());
      Object $handleMethod = this.getHandleMethod();
      result = result * 59 + ($handleMethod == null ? 43 : $handleMethod.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $customerUnit = this.getCustomerUnit();
      result = result * 59 + ($customerUnit == null ? 43 : $customerUnit.hashCode());
      Object $auditTime = this.getAuditTime();
      result = result * 59 + ($auditTime == null ? 43 : $auditTime.hashCode());
      Object $reuseQuantity = this.getReuseQuantity();
      result = result * 59 + ($reuseQuantity == null ? 43 : $reuseQuantity.hashCode());
      Object $wasteSaleQuantity = this.getWasteSaleQuantity();
      return result * 59 + ($wasteSaleQuantity == null ? 43 : $wasteSaleQuantity.hashCode());
   }

   public Long getId() {
      return this.id;
   }

   public Long getMainId() {
      return this.mainId;
   }

   public Long getMesBuildingWarehouseRecordId() {
      return this.mesBuildingWarehouseRecordId;
   }

   public Long getCargoLinkId() {
      return this.cargoLinkId;
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

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public Integer getPricingManner() {
      return this.pricingManner;
   }

   public Integer getHandleMethod() {
      return this.handleMethod;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getCustomerUnit() {
      return this.customerUnit;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Integer getStatus() {
      return this.status;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public LocalDateTime getAuditTime() {
      return this.auditTime;
   }

   public BigDecimal getReuseQuantity() {
      return this.reuseQuantity;
   }

   public BigDecimal getWasteSaleQuantity() {
      return this.wasteSaleQuantity;
   }

   @JsonProperty("id")
   public ProjectReturnProductChild setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectReturnProductChild setMainId(final Long mainId) {
      this.mainId = mainId;
      return this;
   }

   public ProjectReturnProductChild setMesBuildingWarehouseRecordId(final Long mesBuildingWarehouseRecordId) {
      this.mesBuildingWarehouseRecordId = mesBuildingWarehouseRecordId;
      return this;
   }

   public ProjectReturnProductChild setCargoLinkId(final Long cargoLinkId) {
      this.cargoLinkId = cargoLinkId;
      return this;
   }

   public ProjectReturnProductChild setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectReturnProductChild setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public ProjectReturnProductChild setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public ProjectReturnProductChild setPlanId(final Long planId) {
      this.planId = planId;
      return this;
   }

   public ProjectReturnProductChild setProductId(final Long productId) {
      this.productId = productId;
      return this;
   }

   public ProjectReturnProductChild setProductType(final Integer productType) {
      this.productType = productType;
      return this;
   }

   public ProjectReturnProductChild setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
      return this;
   }

   public ProjectReturnProductChild setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
      return this;
   }

   public ProjectReturnProductChild setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
      return this;
   }

   public ProjectReturnProductChild setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
      return this;
   }

   public ProjectReturnProductChild setPricingManner(final Integer pricingManner) {
      this.pricingManner = pricingManner;
      return this;
   }

   public ProjectReturnProductChild setHandleMethod(final Integer handleMethod) {
      this.handleMethod = handleMethod;
      return this;
   }

   public ProjectReturnProductChild setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
      return this;
   }

   public ProjectReturnProductChild setCustomerUnit(final String customerUnit) {
      this.customerUnit = customerUnit;
      return this;
   }

   public ProjectReturnProductChild setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
      return this;
   }

   public ProjectReturnProductChild setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
      return this;
   }

   public ProjectReturnProductChild setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public ProjectReturnProductChild setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
      return this;
   }

   public ProjectReturnProductChild setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
      return this;
   }

   public ProjectReturnProductChild setAuditTime(final LocalDateTime auditTime) {
      this.auditTime = auditTime;
      return this;
   }

   public ProjectReturnProductChild setReuseQuantity(final BigDecimal reuseQuantity) {
      this.reuseQuantity = reuseQuantity;
      return this;
   }

   public ProjectReturnProductChild setWasteSaleQuantity(final BigDecimal wasteSaleQuantity) {
      this.wasteSaleQuantity = wasteSaleQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectReturnProductChild(id="
         + this.getId()
         + ", mainId="
         + this.getMainId()
         + ", mesBuildingWarehouseRecordId="
         + this.getMesBuildingWarehouseRecordId()
         + ", cargoLinkId="
         + this.getCargoLinkId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", planId="
         + this.getPlanId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", quantity="
         + this.getQuantity()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", totalArea="
         + this.getTotalArea()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", pricingManner="
         + this.getPricingManner()
         + ", handleMethod="
         + this.getHandleMethod()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", customerUnit="
         + this.getCustomerUnit()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", status="
         + this.getStatus()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", auditTime="
         + this.getAuditTime()
         + ", reuseQuantity="
         + this.getReuseQuantity()
         + ", wasteSaleQuantity="
         + this.getWasteSaleQuantity()
         + ")";
   }

   public static class ProjectReturnProductChildBuilder {
      private Long id;
      private Long mainId;
      private Long mesBuildingWarehouseRecordId;
      private Long cargoLinkId;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long planId;
      private Long productId;
      private Integer productType;
      private BigDecimal quantity;
      private BigDecimal unitPrice;
      private BigDecimal totalArea;
      private BigDecimal totalAmount;
      private Integer pricingManner;
      private Integer handleMethod;
      private Long branchCompanyId;
      private String customerUnit;
      private Long factoryId;
      private Long workshopId;
      private Integer status;
      private Long warehouseId;
      private Integer auditStatus;
      private LocalDateTime auditTime;
      private BigDecimal reuseQuantity;
      private BigDecimal wasteSaleQuantity;

      ProjectReturnProductChildBuilder() {
      }

      @JsonProperty("id")
      public ProjectReturnProductChild.ProjectReturnProductChildBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder mainId(final Long mainId) {
         this.mainId = mainId;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder mesBuildingWarehouseRecordId(final Long mesBuildingWarehouseRecordId) {
         this.mesBuildingWarehouseRecordId = mesBuildingWarehouseRecordId;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder cargoLinkId(final Long cargoLinkId) {
         this.cargoLinkId = cargoLinkId;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder planId(final Long planId) {
         this.planId = planId;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder totalAmount(final BigDecimal totalAmount) {
         this.totalAmount = totalAmount;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder pricingManner(final Integer pricingManner) {
         this.pricingManner = pricingManner;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder handleMethod(final Integer handleMethod) {
         this.handleMethod = handleMethod;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder customerUnit(final String customerUnit) {
         this.customerUnit = customerUnit;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder auditStatus(final Integer auditStatus) {
         this.auditStatus = auditStatus;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder auditTime(final LocalDateTime auditTime) {
         this.auditTime = auditTime;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder reuseQuantity(final BigDecimal reuseQuantity) {
         this.reuseQuantity = reuseQuantity;
         return this;
      }

      public ProjectReturnProductChild.ProjectReturnProductChildBuilder wasteSaleQuantity(final BigDecimal wasteSaleQuantity) {
         this.wasteSaleQuantity = wasteSaleQuantity;
         return this;
      }

      public ProjectReturnProductChild build() {
         return new ProjectReturnProductChild(
            this.id,
            this.mainId,
            this.mesBuildingWarehouseRecordId,
            this.cargoLinkId,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.planId,
            this.productId,
            this.productType,
            this.quantity,
            this.unitPrice,
            this.totalArea,
            this.totalAmount,
            this.pricingManner,
            this.handleMethod,
            this.branchCompanyId,
            this.customerUnit,
            this.factoryId,
            this.workshopId,
            this.status,
            this.warehouseId,
            this.auditStatus,
            this.auditTime,
            this.reuseQuantity,
            this.wasteSaleQuantity
         );
      }

      @Override
      public String toString() {
         return "ProjectReturnProductChild.ProjectReturnProductChildBuilder(id="
            + this.id
            + ", mainId="
            + this.mainId
            + ", mesBuildingWarehouseRecordId="
            + this.mesBuildingWarehouseRecordId
            + ", cargoLinkId="
            + this.cargoLinkId
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", planId="
            + this.planId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", quantity="
            + this.quantity
            + ", unitPrice="
            + this.unitPrice
            + ", totalArea="
            + this.totalArea
            + ", totalAmount="
            + this.totalAmount
            + ", pricingManner="
            + this.pricingManner
            + ", handleMethod="
            + this.handleMethod
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", customerUnit="
            + this.customerUnit
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", status="
            + this.status
            + ", warehouseId="
            + this.warehouseId
            + ", auditStatus="
            + this.auditStatus
            + ", auditTime="
            + this.auditTime
            + ", reuseQuantity="
            + this.reuseQuantity
            + ", wasteSaleQuantity="
            + this.wasteSaleQuantity
            + ")";
      }
   }
}
