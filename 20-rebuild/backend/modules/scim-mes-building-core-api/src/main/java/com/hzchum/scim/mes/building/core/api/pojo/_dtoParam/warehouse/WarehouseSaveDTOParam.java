package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.warehouse;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(description = "保存库存记录")
public class WarehouseSaveDTOParam {
   @ApiModelProperty("配套件id")
   private Long id;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "unitNet", value = "单位净量(针对辅材,计量/核算量=单位净量)", notes = "单位净量(针对辅材,计量/核算量=单位净量)")
   @JsonProperty("unitNet")
   @JSONField(name = "unitNet")
   private BigDecimal unitNet;
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("区域id")
   private Long areaId;
   @ApiModelProperty("批次id")
   private Long areaBatchId;
   @ApiModelProperty("批次id")
   private Long planId;
   @ApiModelProperty("完成详情id")
   private Long completeId;
   @ApiModelProperty("工厂id")
   private Long factoryId;
   @ApiModelProperty("车间id")
   private Long workshopId;
   @ApiModelProperty(name = "productionLineId", value = "生产线id", notes = "生产线id")
   private Long productionLineId;
   @ApiModelProperty("产品id")
   private Long productId;
   @ApiModelProperty("产品类型 2结构4围护8配套件")
   private Integer productType;
   @ApiModelProperty("出入库类型 1入库2出库")
   private Integer type;
   @ApiModelProperty("出入库数量")
   private BigDecimal quantity;
   @ApiModelProperty("编号")
   private Integer number;
   @ApiModelProperty("编号")
   private List<Integer> numberList;
   @ApiModelProperty("入库类型 0普通入库 1回厂返修")
   private Integer warehouseType;
   @ApiModelProperty(name = "materialInventoryId", notes = "库存Id")
   private Long materialInventoryId;
   @ApiModelProperty(name = "category")
   private Integer category;
   @ApiModelProperty(name = "outboundDetailId", value = "wms出库详情Id", notes = "wms出库详情Id")
   private Long outboundDetailId;

   public static WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder builder() {
      return new WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
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

   public Long getAreaBatchId() {
      return this.areaBatchId;
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

   public Long getProductionLineId() {
      return this.productionLineId;
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

   public Integer getNumber() {
      return this.number;
   }

   public List<Integer> getNumberList() {
      return this.numberList;
   }

   public Integer getWarehouseType() {
      return this.warehouseType;
   }

   public Long getMaterialInventoryId() {
      return this.materialInventoryId;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getOutboundDetailId() {
      return this.outboundDetailId;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   @JsonProperty("unitNet")
   public void setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
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

   public void setAreaBatchId(final Long areaBatchId) {
      this.areaBatchId = areaBatchId;
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

   public void setProductionLineId(final Long productionLineId) {
      this.productionLineId = productionLineId;
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

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   public void setNumberList(final List<Integer> numberList) {
      this.numberList = numberList;
   }

   public void setWarehouseType(final Integer warehouseType) {
      this.warehouseType = warehouseType;
   }

   public void setMaterialInventoryId(final Long materialInventoryId) {
      this.materialInventoryId = materialInventoryId;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setOutboundDetailId(final Long outboundDetailId) {
      this.outboundDetailId = outboundDetailId;
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

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$areaBatchId = this.getAreaBatchId();
                  Object other$areaBatchId = other.getAreaBatchId();
                  if (this$areaBatchId == null ? other$areaBatchId == null : this$areaBatchId.equals(other$areaBatchId)) {
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
                                 Object this$productionLineId = this.getProductionLineId();
                                 Object other$productionLineId = other.getProductionLineId();
                                 if (this$productionLineId == null ? other$productionLineId == null : this$productionLineId.equals(other$productionLineId)) {
                                    Object this$productId = this.getProductId();
                                    Object other$productId = other.getProductId();
                                    if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                                       Object this$productType = this.getProductType();
                                       Object other$productType = other.getProductType();
                                       if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                                          Object this$type = this.getType();
                                          Object other$type = other.getType();
                                          if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                             Object this$number = this.getNumber();
                                             Object other$number = other.getNumber();
                                             if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                                                Object this$warehouseType = this.getWarehouseType();
                                                Object other$warehouseType = other.getWarehouseType();
                                                if (this$warehouseType == null ? other$warehouseType == null : this$warehouseType.equals(other$warehouseType)) {
                                                   Object this$materialInventoryId = this.getMaterialInventoryId();
                                                   Object other$materialInventoryId = other.getMaterialInventoryId();
                                                   if (this$materialInventoryId == null
                                                      ? other$materialInventoryId == null
                                                      : this$materialInventoryId.equals(other$materialInventoryId)) {
                                                      Object this$category = this.getCategory();
                                                      Object other$category = other.getCategory();
                                                      if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                                                         Object this$outboundDetailId = this.getOutboundDetailId();
                                                         Object other$outboundDetailId = other.getOutboundDetailId();
                                                         if (this$outboundDetailId == null
                                                            ? other$outboundDetailId == null
                                                            : this$outboundDetailId.equals(other$outboundDetailId)) {
                                                            Object this$mete = this.getMete();
                                                            Object other$mete = other.getMete();
                                                            if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                               Object this$accountingUnit = this.getAccountingUnit();
                                                               Object other$accountingUnit = other.getAccountingUnit();
                                                               if (this$accountingUnit == null
                                                                  ? other$accountingUnit == null
                                                                  : this$accountingUnit.equals(other$accountingUnit)) {
                                                                  Object this$measureUnit = this.getMeasureUnit();
                                                                  Object other$measureUnit = other.getMeasureUnit();
                                                                  if (this$measureUnit == null
                                                                     ? other$measureUnit == null
                                                                     : this$measureUnit.equals(other$measureUnit)) {
                                                                     Object this$unitNet = this.getUnitNet();
                                                                     Object other$unitNet = other.getUnitNet();
                                                                     if (this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet)) {
                                                                        Object this$quantity = this.getQuantity();
                                                                        Object other$quantity = other.getQuantity();
                                                                        if (this$quantity == null
                                                                           ? other$quantity == null
                                                                           : this$quantity.equals(other$quantity)) {
                                                                           Object this$numberList = this.getNumberList();
                                                                           Object other$numberList = other.getNumberList();
                                                                           return this$numberList == null
                                                                              ? other$numberList == null
                                                                              : this$numberList.equals(other$numberList);
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

   protected boolean canEqual(final Object other) {
      return other instanceof WarehouseSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $areaBatchId = this.getAreaBatchId();
      result = result * 59 + ($areaBatchId == null ? 43 : $areaBatchId.hashCode());
      Object $planId = this.getPlanId();
      result = result * 59 + ($planId == null ? 43 : $planId.hashCode());
      Object $completeId = this.getCompleteId();
      result = result * 59 + ($completeId == null ? 43 : $completeId.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productionLineId = this.getProductionLineId();
      result = result * 59 + ($productionLineId == null ? 43 : $productionLineId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $warehouseType = this.getWarehouseType();
      result = result * 59 + ($warehouseType == null ? 43 : $warehouseType.hashCode());
      Object $materialInventoryId = this.getMaterialInventoryId();
      result = result * 59 + ($materialInventoryId == null ? 43 : $materialInventoryId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $outboundDetailId = this.getOutboundDetailId();
      result = result * 59 + ($outboundDetailId == null ? 43 : $outboundDetailId.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $numberList = this.getNumberList();
      return result * 59 + ($numberList == null ? 43 : $numberList.hashCode());
   }

   @Override
   public String toString() {
      return "WarehouseSaveDTOParam(id="
         + this.getId()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", unitNet="
         + this.getUnitNet()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", areaBatchId="
         + this.getAreaBatchId()
         + ", planId="
         + this.getPlanId()
         + ", completeId="
         + this.getCompleteId()
         + ", factoryId="
         + this.getFactoryId()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productionLineId="
         + this.getProductionLineId()
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
         + ", numberList="
         + this.getNumberList()
         + ", warehouseType="
         + this.getWarehouseType()
         + ", materialInventoryId="
         + this.getMaterialInventoryId()
         + ", category="
         + this.getCategory()
         + ", outboundDetailId="
         + this.getOutboundDetailId()
         + ")";
   }

   public WarehouseSaveDTOParam() {
   }

   public WarehouseSaveDTOParam(
      final Long id,
      final BigDecimal mete,
      final String accountingUnit,
      final String measureUnit,
      final BigDecimal unitNet,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long areaBatchId,
      final Long planId,
      final Long completeId,
      final Long factoryId,
      final Long workshopId,
      final Long productionLineId,
      final Long productId,
      final Integer productType,
      final Integer type,
      final BigDecimal quantity,
      final Integer number,
      final List<Integer> numberList,
      final Integer warehouseType,
      final Long materialInventoryId,
      final Integer category,
      final Long outboundDetailId
   ) {
      this.id = id;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.measureUnit = measureUnit;
      this.unitNet = unitNet;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.areaBatchId = areaBatchId;
      this.planId = planId;
      this.completeId = completeId;
      this.factoryId = factoryId;
      this.workshopId = workshopId;
      this.productionLineId = productionLineId;
      this.productId = productId;
      this.productType = productType;
      this.type = type;
      this.quantity = quantity;
      this.number = number;
      this.numberList = numberList;
      this.warehouseType = warehouseType;
      this.materialInventoryId = materialInventoryId;
      this.category = category;
      this.outboundDetailId = outboundDetailId;
   }

   public static class WarehouseSaveDTOParamBuilder {
      private Long id;
      private BigDecimal mete;
      private String accountingUnit;
      private String measureUnit;
      private BigDecimal unitNet;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long areaBatchId;
      private Long planId;
      private Long completeId;
      private Long factoryId;
      private Long workshopId;
      private Long productionLineId;
      private Long productId;
      private Integer productType;
      private Integer type;
      private BigDecimal quantity;
      private Integer number;
      private List<Integer> numberList;
      private Integer warehouseType;
      private Long materialInventoryId;
      private Integer category;
      private Long outboundDetailId;

      WarehouseSaveDTOParamBuilder() {
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      @JsonProperty("unitNet")
      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder areaBatchId(final Long areaBatchId) {
         this.areaBatchId = areaBatchId;
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

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder productionLineId(final Long productionLineId) {
         this.productionLineId = productionLineId;
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

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder numberList(final List<Integer> numberList) {
         this.numberList = numberList;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder warehouseType(final Integer warehouseType) {
         this.warehouseType = warehouseType;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder materialInventoryId(final Long materialInventoryId) {
         this.materialInventoryId = materialInventoryId;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder outboundDetailId(final Long outboundDetailId) {
         this.outboundDetailId = outboundDetailId;
         return this;
      }

      public WarehouseSaveDTOParam build() {
         return new WarehouseSaveDTOParam(
            this.id,
            this.mete,
            this.accountingUnit,
            this.measureUnit,
            this.unitNet,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.areaBatchId,
            this.planId,
            this.completeId,
            this.factoryId,
            this.workshopId,
            this.productionLineId,
            this.productId,
            this.productType,
            this.type,
            this.quantity,
            this.number,
            this.numberList,
            this.warehouseType,
            this.materialInventoryId,
            this.category,
            this.outboundDetailId
         );
      }

      @Override
      public String toString() {
         return "WarehouseSaveDTOParam.WarehouseSaveDTOParamBuilder(id="
            + this.id
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", measureUnit="
            + this.measureUnit
            + ", unitNet="
            + this.unitNet
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", areaBatchId="
            + this.areaBatchId
            + ", planId="
            + this.planId
            + ", completeId="
            + this.completeId
            + ", factoryId="
            + this.factoryId
            + ", workshopId="
            + this.workshopId
            + ", productionLineId="
            + this.productionLineId
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
            + ", numberList="
            + this.numberList
            + ", warehouseType="
            + this.warehouseType
            + ", materialInventoryId="
            + this.materialInventoryId
            + ", category="
            + this.category
            + ", outboundDetailId="
            + this.outboundDetailId
            + ")";
      }
   }
}
