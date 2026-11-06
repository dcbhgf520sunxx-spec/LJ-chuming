package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Map;

public class SurplusDetailDTOParam {
   private Long id;
   private Integer basicClass;
   private String classifyFullName;
   private Long classifyId;
   private String classifyName;
   private String classifySerialNumber;
   private Long projectId;
   private Long monomerId;
   private Long areaId;
   private Long purchaseOrderDetailId;
   private Long purchaseDetailId;
   private String specification;
   private String specificationLabels;
   private Map<String, String> specificationMap;
   private BigDecimal unitPrice;
   private BigDecimal amount;
   private BigDecimal length;
   private BigDecimal quantity;
   private BigDecimal thickness;
   private BigDecimal weight;
   private BigDecimal width;
   private BigDecimal mete;
   private Long workshopId;
   private Long warehouseId;
   private String brand;
   private String heatNoAndBatchNo;
   private String color;
   private String remark;
   private Long mergeId;
   private Long applyPurchaseId;
   private BigDecimal amountExcludingVatFreight;
   private BigDecimal unitPriceExcludingVatFreight;
   private BigDecimal freight;
   private Long standardId;
   private String sectionSteelSpec;
   private String doNotSectionSteelSpec;
   @ApiModelProperty(name = "weightMeasurementMode", value = "重量计量方式[参考枚举 MeasureEnum]")
   private Integer weightMeasurementMode;
   private Long factoryId;
   @ApiModelProperty("供应商id")
   private Long supplierId;
   @ApiModelProperty("物料是否完整[1 整料,2 余料]")
   private Integer materialIsWhole;
   @ApiModelProperty(name = "serialNumber")
   private String serialNumber;

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getClassifyFullName() {
      return this.classifyFullName;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getClassifySerialNumber() {
      return this.classifySerialNumber;
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

   public Long getPurchaseOrderDetailId() {
      return this.purchaseOrderDetailId;
   }

   public Long getPurchaseDetailId() {
      return this.purchaseDetailId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getSpecificationLabels() {
      return this.specificationLabels;
   }

   public Map<String, String> getSpecificationMap() {
      return this.specificationMap;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public String getRemark() {
      return this.remark;
   }

   public Long getMergeId() {
      return this.mergeId;
   }

   public Long getApplyPurchaseId() {
      return this.applyPurchaseId;
   }

   public BigDecimal getAmountExcludingVatFreight() {
      return this.amountExcludingVatFreight;
   }

   public BigDecimal getUnitPriceExcludingVatFreight() {
      return this.unitPriceExcludingVatFreight;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getSectionSteelSpec() {
      return this.sectionSteelSpec;
   }

   public String getDoNotSectionSteelSpec() {
      return this.doNotSectionSteelSpec;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setClassifyFullName(final String classifyFullName) {
      this.classifyFullName = classifyFullName;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setClassifySerialNumber(final String classifySerialNumber) {
      this.classifySerialNumber = classifySerialNumber;
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

   public void setPurchaseOrderDetailId(final Long purchaseOrderDetailId) {
      this.purchaseOrderDetailId = purchaseOrderDetailId;
   }

   public void setPurchaseDetailId(final Long purchaseDetailId) {
      this.purchaseDetailId = purchaseDetailId;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setSpecificationLabels(final String specificationLabels) {
      this.specificationLabels = specificationLabels;
   }

   public void setSpecificationMap(final Map<String, String> specificationMap) {
      this.specificationMap = specificationMap;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setMergeId(final Long mergeId) {
      this.mergeId = mergeId;
   }

   public void setApplyPurchaseId(final Long applyPurchaseId) {
      this.applyPurchaseId = applyPurchaseId;
   }

   public void setAmountExcludingVatFreight(final BigDecimal amountExcludingVatFreight) {
      this.amountExcludingVatFreight = amountExcludingVatFreight;
   }

   public void setUnitPriceExcludingVatFreight(final BigDecimal unitPriceExcludingVatFreight) {
      this.unitPriceExcludingVatFreight = unitPriceExcludingVatFreight;
   }

   public void setFreight(final BigDecimal freight) {
      this.freight = freight;
   }

   public void setStandardId(final Long standardId) {
      this.standardId = standardId;
   }

   public void setSectionSteelSpec(final String sectionSteelSpec) {
      this.sectionSteelSpec = sectionSteelSpec;
   }

   public void setDoNotSectionSteelSpec(final String doNotSectionSteelSpec) {
      this.doNotSectionSteelSpec = doNotSectionSteelSpec;
   }

   public void setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SurplusDetailDTOParam)) {
         return false;
      }

      SurplusDetailDTOParam other = (SurplusDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$basicClass = this.getBasicClass();
         Object other$basicClass = other.getBasicClass();
         if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$areaId = this.getAreaId();
                     Object other$areaId = other.getAreaId();
                     if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                        Object this$purchaseOrderDetailId = this.getPurchaseOrderDetailId();
                        Object other$purchaseOrderDetailId = other.getPurchaseOrderDetailId();
                        if (this$purchaseOrderDetailId == null
                           ? other$purchaseOrderDetailId == null
                           : this$purchaseOrderDetailId.equals(other$purchaseOrderDetailId)) {
                           Object this$purchaseDetailId = this.getPurchaseDetailId();
                           Object other$purchaseDetailId = other.getPurchaseDetailId();
                           if (this$purchaseDetailId == null ? other$purchaseDetailId == null : this$purchaseDetailId.equals(other$purchaseDetailId)) {
                              Object this$workshopId = this.getWorkshopId();
                              Object other$workshopId = other.getWorkshopId();
                              if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                 Object this$warehouseId = this.getWarehouseId();
                                 Object other$warehouseId = other.getWarehouseId();
                                 if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                    Object this$mergeId = this.getMergeId();
                                    Object other$mergeId = other.getMergeId();
                                    if (this$mergeId == null ? other$mergeId == null : this$mergeId.equals(other$mergeId)) {
                                       Object this$applyPurchaseId = this.getApplyPurchaseId();
                                       Object other$applyPurchaseId = other.getApplyPurchaseId();
                                       if (this$applyPurchaseId == null ? other$applyPurchaseId == null : this$applyPurchaseId.equals(other$applyPurchaseId)) {
                                          Object this$standardId = this.getStandardId();
                                          Object other$standardId = other.getStandardId();
                                          if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                                             Object this$weightMeasurementMode = this.getWeightMeasurementMode();
                                             Object other$weightMeasurementMode = other.getWeightMeasurementMode();
                                             if (this$weightMeasurementMode == null
                                                ? other$weightMeasurementMode == null
                                                : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
                                                Object this$factoryId = this.getFactoryId();
                                                Object other$factoryId = other.getFactoryId();
                                                if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                                                   Object this$supplierId = this.getSupplierId();
                                                   Object other$supplierId = other.getSupplierId();
                                                   if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                                                      Object this$materialIsWhole = this.getMaterialIsWhole();
                                                      Object other$materialIsWhole = other.getMaterialIsWhole();
                                                      if (this$materialIsWhole == null
                                                         ? other$materialIsWhole == null
                                                         : this$materialIsWhole.equals(other$materialIsWhole)) {
                                                         Object this$classifyFullName = this.getClassifyFullName();
                                                         Object other$classifyFullName = other.getClassifyFullName();
                                                         if (this$classifyFullName == null
                                                            ? other$classifyFullName == null
                                                            : this$classifyFullName.equals(other$classifyFullName)) {
                                                            Object this$classifyName = this.getClassifyName();
                                                            Object other$classifyName = other.getClassifyName();
                                                            if (this$classifyName == null
                                                               ? other$classifyName == null
                                                               : this$classifyName.equals(other$classifyName)) {
                                                               Object this$classifySerialNumber = this.getClassifySerialNumber();
                                                               Object other$classifySerialNumber = other.getClassifySerialNumber();
                                                               if (this$classifySerialNumber == null
                                                                  ? other$classifySerialNumber == null
                                                                  : this$classifySerialNumber.equals(other$classifySerialNumber)) {
                                                                  Object this$specification = this.getSpecification();
                                                                  Object other$specification = other.getSpecification();
                                                                  if (this$specification == null
                                                                     ? other$specification == null
                                                                     : this$specification.equals(other$specification)) {
                                                                     Object this$specificationLabels = this.getSpecificationLabels();
                                                                     Object other$specificationLabels = other.getSpecificationLabels();
                                                                     if (this$specificationLabels == null
                                                                        ? other$specificationLabels == null
                                                                        : this$specificationLabels.equals(other$specificationLabels)) {
                                                                        Object this$specificationMap = this.getSpecificationMap();
                                                                        Object other$specificationMap = other.getSpecificationMap();
                                                                        if (this$specificationMap == null
                                                                           ? other$specificationMap == null
                                                                           : this$specificationMap.equals(other$specificationMap)) {
                                                                           Object this$unitPrice = this.getUnitPrice();
                                                                           Object other$unitPrice = other.getUnitPrice();
                                                                           if (this$unitPrice == null
                                                                              ? other$unitPrice == null
                                                                              : this$unitPrice.equals(other$unitPrice)) {
                                                                              Object this$amount = this.getAmount();
                                                                              Object other$amount = other.getAmount();
                                                                              if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)
                                                                                 )
                                                                               {
                                                                                 Object this$length = this.getLength();
                                                                                 Object other$length = other.getLength();
                                                                                 if (this$length == null
                                                                                    ? other$length == null
                                                                                    : this$length.equals(other$length)) {
                                                                                    Object this$quantity = this.getQuantity();
                                                                                    Object other$quantity = other.getQuantity();
                                                                                    if (this$quantity == null
                                                                                       ? other$quantity == null
                                                                                       : this$quantity.equals(other$quantity)) {
                                                                                       Object this$thickness = this.getThickness();
                                                                                       Object other$thickness = other.getThickness();
                                                                                       if (this$thickness == null
                                                                                          ? other$thickness == null
                                                                                          : this$thickness.equals(other$thickness)) {
                                                                                          Object this$weight = this.getWeight();
                                                                                          Object other$weight = other.getWeight();
                                                                                          if (this$weight == null
                                                                                             ? other$weight == null
                                                                                             : this$weight.equals(other$weight)) {
                                                                                             Object this$width = this.getWidth();
                                                                                             Object other$width = other.getWidth();
                                                                                             if (this$width == null
                                                                                                ? other$width == null
                                                                                                : this$width.equals(other$width)) {
                                                                                                Object this$mete = this.getMete();
                                                                                                Object other$mete = other.getMete();
                                                                                                if (this$mete == null
                                                                                                   ? other$mete == null
                                                                                                   : this$mete.equals(other$mete)) {
                                                                                                   Object this$brand = this.getBrand();
                                                                                                   Object other$brand = other.getBrand();
                                                                                                   if (this$brand == null
                                                                                                      ? other$brand == null
                                                                                                      : this$brand.equals(other$brand)) {
                                                                                                      Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                                      Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                                      if (this$heatNoAndBatchNo == null
                                                                                                         ? other$heatNoAndBatchNo == null
                                                                                                         : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)
                                                                                                         )
                                                                                                       {
                                                                                                         Object this$color = this.getColor();
                                                                                                         Object other$color = other.getColor();
                                                                                                         if (this$color == null
                                                                                                            ? other$color == null
                                                                                                            : this$color.equals(other$color)) {
                                                                                                            Object this$remark = this.getRemark();
                                                                                                            Object other$remark = other.getRemark();
                                                                                                            if (this$remark == null
                                                                                                               ? other$remark == null
                                                                                                               : this$remark.equals(other$remark)) {
                                                                                                               Object this$amountExcludingVatFreight = this.getAmountExcludingVatFreight();
                                                                                                               Object other$amountExcludingVatFreight = other.getAmountExcludingVatFreight();
                                                                                                               if (this$amountExcludingVatFreight == null
                                                                                                                  ? other$amountExcludingVatFreight == null
                                                                                                                  : this$amountExcludingVatFreight.equals(
                                                                                                                     other$amountExcludingVatFreight
                                                                                                                  )) {
                                                                                                                  Object this$unitPriceExcludingVatFreight = this.getUnitPriceExcludingVatFreight();
                                                                                                                  Object other$unitPriceExcludingVatFreight = other.getUnitPriceExcludingVatFreight();
                                                                                                                  if (this$unitPriceExcludingVatFreight == null
                                                                                                                     ? other$unitPriceExcludingVatFreight
                                                                                                                        == null
                                                                                                                     : this$unitPriceExcludingVatFreight.equals(
                                                                                                                        other$unitPriceExcludingVatFreight
                                                                                                                     )) {
                                                                                                                     Object this$freight = this.getFreight();
                                                                                                                     Object other$freight = other.getFreight();
                                                                                                                     if (this$freight == null
                                                                                                                        ? other$freight == null
                                                                                                                        : this$freight.equals(other$freight)) {
                                                                                                                        Object this$sectionSteelSpec = this.getSectionSteelSpec();
                                                                                                                        Object other$sectionSteelSpec = other.getSectionSteelSpec();
                                                                                                                        if (this$sectionSteelSpec == null
                                                                                                                           ? other$sectionSteelSpec == null
                                                                                                                           : this$sectionSteelSpec.equals(
                                                                                                                              other$sectionSteelSpec
                                                                                                                           )) {
                                                                                                                           Object this$doNotSectionSteelSpec = this.getDoNotSectionSteelSpec();
                                                                                                                           Object other$doNotSectionSteelSpec = other.getDoNotSectionSteelSpec();
                                                                                                                           if (this$doNotSectionSteelSpec
                                                                                                                                 == null
                                                                                                                              ? other$doNotSectionSteelSpec
                                                                                                                                 == null
                                                                                                                              : this$doNotSectionSteelSpec.equals(
                                                                                                                                 other$doNotSectionSteelSpec
                                                                                                                              )) {
                                                                                                                              Object this$serialNumber = this.getSerialNumber();
                                                                                                                              Object other$serialNumber = other.getSerialNumber();
                                                                                                                              return this$serialNumber == null
                                                                                                                                 ? other$serialNumber == null
                                                                                                                                 : this$serialNumber.equals(
                                                                                                                                    other$serialNumber
                                                                                                                                 );
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
      return other instanceof SurplusDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $purchaseOrderDetailId = this.getPurchaseOrderDetailId();
      result = result * 59 + ($purchaseOrderDetailId == null ? 43 : $purchaseOrderDetailId.hashCode());
      Object $purchaseDetailId = this.getPurchaseDetailId();
      result = result * 59 + ($purchaseDetailId == null ? 43 : $purchaseDetailId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $mergeId = this.getMergeId();
      result = result * 59 + ($mergeId == null ? 43 : $mergeId.hashCode());
      Object $applyPurchaseId = this.getApplyPurchaseId();
      result = result * 59 + ($applyPurchaseId == null ? 43 : $applyPurchaseId.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $classifyFullName = this.getClassifyFullName();
      result = result * 59 + ($classifyFullName == null ? 43 : $classifyFullName.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $classifySerialNumber = this.getClassifySerialNumber();
      result = result * 59 + ($classifySerialNumber == null ? 43 : $classifySerialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $specificationLabels = this.getSpecificationLabels();
      result = result * 59 + ($specificationLabels == null ? 43 : $specificationLabels.hashCode());
      Object $specificationMap = this.getSpecificationMap();
      result = result * 59 + ($specificationMap == null ? 43 : $specificationMap.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $amountExcludingVatFreight = this.getAmountExcludingVatFreight();
      result = result * 59 + ($amountExcludingVatFreight == null ? 43 : $amountExcludingVatFreight.hashCode());
      Object $unitPriceExcludingVatFreight = this.getUnitPriceExcludingVatFreight();
      result = result * 59 + ($unitPriceExcludingVatFreight == null ? 43 : $unitPriceExcludingVatFreight.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $sectionSteelSpec = this.getSectionSteelSpec();
      result = result * 59 + ($sectionSteelSpec == null ? 43 : $sectionSteelSpec.hashCode());
      Object $doNotSectionSteelSpec = this.getDoNotSectionSteelSpec();
      result = result * 59 + ($doNotSectionSteelSpec == null ? 43 : $doNotSectionSteelSpec.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "SurplusDetailDTOParam(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyFullName="
         + this.getClassifyFullName()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", classifySerialNumber="
         + this.getClassifySerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", purchaseOrderDetailId="
         + this.getPurchaseOrderDetailId()
         + ", purchaseDetailId="
         + this.getPurchaseDetailId()
         + ", specification="
         + this.getSpecification()
         + ", specificationLabels="
         + this.getSpecificationLabels()
         + ", specificationMap="
         + this.getSpecificationMap()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", amount="
         + this.getAmount()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", thickness="
         + this.getThickness()
         + ", weight="
         + this.getWeight()
         + ", width="
         + this.getWidth()
         + ", mete="
         + this.getMete()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", remark="
         + this.getRemark()
         + ", mergeId="
         + this.getMergeId()
         + ", applyPurchaseId="
         + this.getApplyPurchaseId()
         + ", amountExcludingVatFreight="
         + this.getAmountExcludingVatFreight()
         + ", unitPriceExcludingVatFreight="
         + this.getUnitPriceExcludingVatFreight()
         + ", freight="
         + this.getFreight()
         + ", standardId="
         + this.getStandardId()
         + ", sectionSteelSpec="
         + this.getSectionSteelSpec()
         + ", doNotSectionSteelSpec="
         + this.getDoNotSectionSteelSpec()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", factoryId="
         + this.getFactoryId()
         + ", supplierId="
         + this.getSupplierId()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", serialNumber="
         + this.getSerialNumber()
         + ")";
   }
}
