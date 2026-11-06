package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class QueryByMaterialDTOParam {
   private Integer projectWarehouseType;
   private Integer materialIsWhole;
   private Long projectId;
   private Long monomerId;
   private Long areaId;
   private Integer basicClass;
   private List<Long> classifyId;
   private List<Long> classifyIds;
   private BigDecimal minLength;
   private BigDecimal maxLength;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal theoryThickness;
   private BigDecimal thickness;
   private BigDecimal minThickness;
   private String heatNoAndBatchNo;
   private String specification;
   private Long workshopId;
   private Long warehouseId;
   private List<Long> warehouseIds;
   private List<Long> workshopIds;
   private String color;
   private String brand;
   private Boolean boolPartyA;
   @ApiModelProperty(name = "objectType", value = "object查询 1：仓库->重量  2：存储位置->重量  3：项目->重量")
   private Integer objectType;
   private Integer freezeType;
   private List<Integer> freezeTypes;
   private Long freezeDetailId;
   private List<String> split;
   private String classifyName;
   private Boolean boolCross;
   private Long warehouseConfigId;
   private String specNumber;
   private List<Long> ids;
   private String shipmentName;
   @ApiModelProperty(name = "deficitType", value = "盘亏成本归属 1公司 2项目")
   private Integer deficitType = 1;
   LocalDate yearDate;
   Long branchCompanyId;
   String material;
   String sectionSteelSpec;

   public static QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder builder() {
      return new QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder();
   }

   public Integer getProjectWarehouseType() {
      return this.projectWarehouseType;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
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

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public List<Long> getClassifyId() {
      return this.classifyId;
   }

   public List<Long> getClassifyIds() {
      return this.classifyIds;
   }

   public BigDecimal getMinLength() {
      return this.minLength;
   }

   public BigDecimal getMaxLength() {
      return this.maxLength;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getMinThickness() {
      return this.minThickness;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public List<Long> getWarehouseIds() {
      return this.warehouseIds;
   }

   public List<Long> getWorkshopIds() {
      return this.workshopIds;
   }

   public String getColor() {
      return this.color;
   }

   public String getBrand() {
      return this.brand;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Integer getObjectType() {
      return this.objectType;
   }

   public Integer getFreezeType() {
      return this.freezeType;
   }

   public List<Integer> getFreezeTypes() {
      return this.freezeTypes;
   }

   public Long getFreezeDetailId() {
      return this.freezeDetailId;
   }

   public List<String> getSplit() {
      return this.split;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Boolean getBoolCross() {
      return this.boolCross;
   }

   public Long getWarehouseConfigId() {
      return this.warehouseConfigId;
   }

   public String getSpecNumber() {
      return this.specNumber;
   }

   public List<Long> getIds() {
      return this.ids;
   }

   public String getShipmentName() {
      return this.shipmentName;
   }

   public Integer getDeficitType() {
      return this.deficitType;
   }

   public LocalDate getYearDate() {
      return this.yearDate;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getSectionSteelSpec() {
      return this.sectionSteelSpec;
   }

   public void setProjectWarehouseType(final Integer projectWarehouseType) {
      this.projectWarehouseType = projectWarehouseType;
   }

   public void setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
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

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setClassifyId(final List<Long> classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyIds(final List<Long> classifyIds) {
      this.classifyIds = classifyIds;
   }

   public void setMinLength(final BigDecimal minLength) {
      this.minLength = minLength;
   }

   public void setMaxLength(final BigDecimal maxLength) {
      this.maxLength = maxLength;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setMinThickness(final BigDecimal minThickness) {
      this.minThickness = minThickness;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setWarehouseIds(final List<Long> warehouseIds) {
      this.warehouseIds = warehouseIds;
   }

   public void setWorkshopIds(final List<Long> workshopIds) {
      this.workshopIds = workshopIds;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setObjectType(final Integer objectType) {
      this.objectType = objectType;
   }

   public void setFreezeType(final Integer freezeType) {
      this.freezeType = freezeType;
   }

   public void setFreezeTypes(final List<Integer> freezeTypes) {
      this.freezeTypes = freezeTypes;
   }

   public void setFreezeDetailId(final Long freezeDetailId) {
      this.freezeDetailId = freezeDetailId;
   }

   public void setSplit(final List<String> split) {
      this.split = split;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setBoolCross(final Boolean boolCross) {
      this.boolCross = boolCross;
   }

   public void setWarehouseConfigId(final Long warehouseConfigId) {
      this.warehouseConfigId = warehouseConfigId;
   }

   public void setSpecNumber(final String specNumber) {
      this.specNumber = specNumber;
   }

   public void setIds(final List<Long> ids) {
      this.ids = ids;
   }

   public void setShipmentName(final String shipmentName) {
      this.shipmentName = shipmentName;
   }

   public void setDeficitType(final Integer deficitType) {
      this.deficitType = deficitType;
   }

   public void setYearDate(final LocalDate yearDate) {
      this.yearDate = yearDate;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setSectionSteelSpec(final String sectionSteelSpec) {
      this.sectionSteelSpec = sectionSteelSpec;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryByMaterialDTOParam)) {
         return false;
      }

      QueryByMaterialDTOParam other = (QueryByMaterialDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectWarehouseType = this.getProjectWarehouseType();
      Object other$projectWarehouseType = other.getProjectWarehouseType();
      if (this$projectWarehouseType == null ? other$projectWarehouseType == null : this$projectWarehouseType.equals(other$projectWarehouseType)) {
         Object this$materialIsWhole = this.getMaterialIsWhole();
         Object other$materialIsWhole = other.getMaterialIsWhole();
         if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$monomerId = this.getMonomerId();
               Object other$monomerId = other.getMonomerId();
               if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                  Object this$areaId = this.getAreaId();
                  Object other$areaId = other.getAreaId();
                  if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                     Object this$basicClass = this.getBasicClass();
                     Object other$basicClass = other.getBasicClass();
                     if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                        Object this$workshopId = this.getWorkshopId();
                        Object other$workshopId = other.getWorkshopId();
                        if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                           Object this$warehouseId = this.getWarehouseId();
                           Object other$warehouseId = other.getWarehouseId();
                           if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                              Object this$boolPartyA = this.getBoolPartyA();
                              Object other$boolPartyA = other.getBoolPartyA();
                              if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                                 Object this$objectType = this.getObjectType();
                                 Object other$objectType = other.getObjectType();
                                 if (this$objectType == null ? other$objectType == null : this$objectType.equals(other$objectType)) {
                                    Object this$freezeType = this.getFreezeType();
                                    Object other$freezeType = other.getFreezeType();
                                    if (this$freezeType == null ? other$freezeType == null : this$freezeType.equals(other$freezeType)) {
                                       Object this$freezeDetailId = this.getFreezeDetailId();
                                       Object other$freezeDetailId = other.getFreezeDetailId();
                                       if (this$freezeDetailId == null ? other$freezeDetailId == null : this$freezeDetailId.equals(other$freezeDetailId)) {
                                          Object this$boolCross = this.getBoolCross();
                                          Object other$boolCross = other.getBoolCross();
                                          if (this$boolCross == null ? other$boolCross == null : this$boolCross.equals(other$boolCross)) {
                                             Object this$warehouseConfigId = this.getWarehouseConfigId();
                                             Object other$warehouseConfigId = other.getWarehouseConfigId();
                                             if (this$warehouseConfigId == null
                                                ? other$warehouseConfigId == null
                                                : this$warehouseConfigId.equals(other$warehouseConfigId)) {
                                                Object this$deficitType = this.getDeficitType();
                                                Object other$deficitType = other.getDeficitType();
                                                if (this$deficitType == null ? other$deficitType == null : this$deficitType.equals(other$deficitType)) {
                                                   Object this$branchCompanyId = this.getBranchCompanyId();
                                                   Object other$branchCompanyId = other.getBranchCompanyId();
                                                   if (this$branchCompanyId == null
                                                      ? other$branchCompanyId == null
                                                      : this$branchCompanyId.equals(other$branchCompanyId)) {
                                                      Object this$classifyId = this.getClassifyId();
                                                      Object other$classifyId = other.getClassifyId();
                                                      if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                                                         Object this$classifyIds = this.getClassifyIds();
                                                         Object other$classifyIds = other.getClassifyIds();
                                                         if (this$classifyIds == null ? other$classifyIds == null : this$classifyIds.equals(other$classifyIds)) {
                                                            Object this$minLength = this.getMinLength();
                                                            Object other$minLength = other.getMinLength();
                                                            if (this$minLength == null ? other$minLength == null : this$minLength.equals(other$minLength)) {
                                                               Object this$maxLength = this.getMaxLength();
                                                               Object other$maxLength = other.getMaxLength();
                                                               if (this$maxLength == null ? other$maxLength == null : this$maxLength.equals(other$maxLength)) {
                                                                  Object this$length = this.getLength();
                                                                  Object other$length = other.getLength();
                                                                  if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                     Object this$width = this.getWidth();
                                                                     Object other$width = other.getWidth();
                                                                     if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                        Object this$theoryThickness = this.getTheoryThickness();
                                                                        Object other$theoryThickness = other.getTheoryThickness();
                                                                        if (this$theoryThickness == null
                                                                           ? other$theoryThickness == null
                                                                           : this$theoryThickness.equals(other$theoryThickness)) {
                                                                           Object this$thickness = this.getThickness();
                                                                           Object other$thickness = other.getThickness();
                                                                           if (this$thickness == null
                                                                              ? other$thickness == null
                                                                              : this$thickness.equals(other$thickness)) {
                                                                              Object this$minThickness = this.getMinThickness();
                                                                              Object other$minThickness = other.getMinThickness();
                                                                              if (this$minThickness == null
                                                                                 ? other$minThickness == null
                                                                                 : this$minThickness.equals(other$minThickness)) {
                                                                                 Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                                 Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                                 if (this$heatNoAndBatchNo == null
                                                                                    ? other$heatNoAndBatchNo == null
                                                                                    : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                                    Object this$specification = this.getSpecification();
                                                                                    Object other$specification = other.getSpecification();
                                                                                    if (this$specification == null
                                                                                       ? other$specification == null
                                                                                       : this$specification.equals(other$specification)) {
                                                                                       Object this$warehouseIds = this.getWarehouseIds();
                                                                                       Object other$warehouseIds = other.getWarehouseIds();
                                                                                       if (this$warehouseIds == null
                                                                                          ? other$warehouseIds == null
                                                                                          : this$warehouseIds.equals(other$warehouseIds)) {
                                                                                          Object this$workshopIds = this.getWorkshopIds();
                                                                                          Object other$workshopIds = other.getWorkshopIds();
                                                                                          if (this$workshopIds == null
                                                                                             ? other$workshopIds == null
                                                                                             : this$workshopIds.equals(other$workshopIds)) {
                                                                                             Object this$color = this.getColor();
                                                                                             Object other$color = other.getColor();
                                                                                             if (this$color == null
                                                                                                ? other$color == null
                                                                                                : this$color.equals(other$color)) {
                                                                                                Object this$brand = this.getBrand();
                                                                                                Object other$brand = other.getBrand();
                                                                                                if (this$brand == null
                                                                                                   ? other$brand == null
                                                                                                   : this$brand.equals(other$brand)) {
                                                                                                   Object this$freezeTypes = this.getFreezeTypes();
                                                                                                   Object other$freezeTypes = other.getFreezeTypes();
                                                                                                   if (this$freezeTypes == null
                                                                                                      ? other$freezeTypes == null
                                                                                                      : this$freezeTypes.equals(other$freezeTypes)) {
                                                                                                      Object this$split = this.getSplit();
                                                                                                      Object other$split = other.getSplit();
                                                                                                      if (this$split == null
                                                                                                         ? other$split == null
                                                                                                         : this$split.equals(other$split)) {
                                                                                                         Object this$classifyName = this.getClassifyName();
                                                                                                         Object other$classifyName = other.getClassifyName();
                                                                                                         if (this$classifyName == null
                                                                                                            ? other$classifyName == null
                                                                                                            : this$classifyName.equals(other$classifyName)) {
                                                                                                            Object this$specNumber = this.getSpecNumber();
                                                                                                            Object other$specNumber = other.getSpecNumber();
                                                                                                            if (this$specNumber == null
                                                                                                               ? other$specNumber == null
                                                                                                               : this$specNumber.equals(other$specNumber)) {
                                                                                                               Object this$ids = this.getIds();
                                                                                                               Object other$ids = other.getIds();
                                                                                                               if (this$ids == null
                                                                                                                  ? other$ids == null
                                                                                                                  : this$ids.equals(other$ids)) {
                                                                                                                  Object this$shipmentName = this.getShipmentName();
                                                                                                                  Object other$shipmentName = other.getShipmentName();
                                                                                                                  if (this$shipmentName == null
                                                                                                                     ? other$shipmentName == null
                                                                                                                     : this$shipmentName.equals(
                                                                                                                        other$shipmentName
                                                                                                                     )) {
                                                                                                                     Object this$yearDate = this.getYearDate();
                                                                                                                     Object other$yearDate = other.getYearDate();
                                                                                                                     if (this$yearDate == null
                                                                                                                        ? other$yearDate == null
                                                                                                                        : this$yearDate.equals(other$yearDate)) {
                                                                                                                        Object this$material = this.getMaterial();
                                                                                                                        Object other$material = other.getMaterial();
                                                                                                                        if (this$material == null
                                                                                                                           ? other$material == null
                                                                                                                           : this$material.equals(
                                                                                                                              other$material
                                                                                                                           )) {
                                                                                                                           Object this$sectionSteelSpec = this.getSectionSteelSpec();
                                                                                                                           Object other$sectionSteelSpec = other.getSectionSteelSpec();
                                                                                                                           return this$sectionSteelSpec == null
                                                                                                                              ? other$sectionSteelSpec == null
                                                                                                                              : this$sectionSteelSpec.equals(
                                                                                                                                 other$sectionSteelSpec
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QueryByMaterialDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectWarehouseType = this.getProjectWarehouseType();
      result = result * 59 + ($projectWarehouseType == null ? 43 : $projectWarehouseType.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $objectType = this.getObjectType();
      result = result * 59 + ($objectType == null ? 43 : $objectType.hashCode());
      Object $freezeType = this.getFreezeType();
      result = result * 59 + ($freezeType == null ? 43 : $freezeType.hashCode());
      Object $freezeDetailId = this.getFreezeDetailId();
      result = result * 59 + ($freezeDetailId == null ? 43 : $freezeDetailId.hashCode());
      Object $boolCross = this.getBoolCross();
      result = result * 59 + ($boolCross == null ? 43 : $boolCross.hashCode());
      Object $warehouseConfigId = this.getWarehouseConfigId();
      result = result * 59 + ($warehouseConfigId == null ? 43 : $warehouseConfigId.hashCode());
      Object $deficitType = this.getDeficitType();
      result = result * 59 + ($deficitType == null ? 43 : $deficitType.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $classifyIds = this.getClassifyIds();
      result = result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
      Object $minLength = this.getMinLength();
      result = result * 59 + ($minLength == null ? 43 : $minLength.hashCode());
      Object $maxLength = this.getMaxLength();
      result = result * 59 + ($maxLength == null ? 43 : $maxLength.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $minThickness = this.getMinThickness();
      result = result * 59 + ($minThickness == null ? 43 : $minThickness.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $warehouseIds = this.getWarehouseIds();
      result = result * 59 + ($warehouseIds == null ? 43 : $warehouseIds.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      result = result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $freezeTypes = this.getFreezeTypes();
      result = result * 59 + ($freezeTypes == null ? 43 : $freezeTypes.hashCode());
      Object $split = this.getSplit();
      result = result * 59 + ($split == null ? 43 : $split.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $specNumber = this.getSpecNumber();
      result = result * 59 + ($specNumber == null ? 43 : $specNumber.hashCode());
      Object $ids = this.getIds();
      result = result * 59 + ($ids == null ? 43 : $ids.hashCode());
      Object $shipmentName = this.getShipmentName();
      result = result * 59 + ($shipmentName == null ? 43 : $shipmentName.hashCode());
      Object $yearDate = this.getYearDate();
      result = result * 59 + ($yearDate == null ? 43 : $yearDate.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $sectionSteelSpec = this.getSectionSteelSpec();
      return result * 59 + ($sectionSteelSpec == null ? 43 : $sectionSteelSpec.hashCode());
   }

   @Override
   public String toString() {
      return "QueryByMaterialDTOParam(projectWarehouseType="
         + this.getProjectWarehouseType()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyIds="
         + this.getClassifyIds()
         + ", minLength="
         + this.getMinLength()
         + ", maxLength="
         + this.getMaxLength()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", thickness="
         + this.getThickness()
         + ", minThickness="
         + this.getMinThickness()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", specification="
         + this.getSpecification()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", warehouseIds="
         + this.getWarehouseIds()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ", color="
         + this.getColor()
         + ", brand="
         + this.getBrand()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", objectType="
         + this.getObjectType()
         + ", freezeType="
         + this.getFreezeType()
         + ", freezeTypes="
         + this.getFreezeTypes()
         + ", freezeDetailId="
         + this.getFreezeDetailId()
         + ", split="
         + this.getSplit()
         + ", classifyName="
         + this.getClassifyName()
         + ", boolCross="
         + this.getBoolCross()
         + ", warehouseConfigId="
         + this.getWarehouseConfigId()
         + ", specNumber="
         + this.getSpecNumber()
         + ", ids="
         + this.getIds()
         + ", shipmentName="
         + this.getShipmentName()
         + ", deficitType="
         + this.getDeficitType()
         + ", yearDate="
         + this.getYearDate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", material="
         + this.getMaterial()
         + ", sectionSteelSpec="
         + this.getSectionSteelSpec()
         + ")";
   }

   public QueryByMaterialDTOParam(
      final Integer projectWarehouseType,
      final Integer materialIsWhole,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Integer basicClass,
      final List<Long> classifyId,
      final List<Long> classifyIds,
      final BigDecimal minLength,
      final BigDecimal maxLength,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal theoryThickness,
      final BigDecimal thickness,
      final BigDecimal minThickness,
      final String heatNoAndBatchNo,
      final String specification,
      final Long workshopId,
      final Long warehouseId,
      final List<Long> warehouseIds,
      final List<Long> workshopIds,
      final String color,
      final String brand,
      final Boolean boolPartyA,
      final Integer objectType,
      final Integer freezeType,
      final List<Integer> freezeTypes,
      final Long freezeDetailId,
      final List<String> split,
      final String classifyName,
      final Boolean boolCross,
      final Long warehouseConfigId,
      final String specNumber,
      final List<Long> ids,
      final String shipmentName,
      final Integer deficitType,
      final LocalDate yearDate,
      final Long branchCompanyId,
      final String material,
      final String sectionSteelSpec
   ) {
      this.projectWarehouseType = projectWarehouseType;
      this.materialIsWhole = materialIsWhole;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyIds = classifyIds;
      this.minLength = minLength;
      this.maxLength = maxLength;
      this.length = length;
      this.width = width;
      this.theoryThickness = theoryThickness;
      this.thickness = thickness;
      this.minThickness = minThickness;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.specification = specification;
      this.workshopId = workshopId;
      this.warehouseId = warehouseId;
      this.warehouseIds = warehouseIds;
      this.workshopIds = workshopIds;
      this.color = color;
      this.brand = brand;
      this.boolPartyA = boolPartyA;
      this.objectType = objectType;
      this.freezeType = freezeType;
      this.freezeTypes = freezeTypes;
      this.freezeDetailId = freezeDetailId;
      this.split = split;
      this.classifyName = classifyName;
      this.boolCross = boolCross;
      this.warehouseConfigId = warehouseConfigId;
      this.specNumber = specNumber;
      this.ids = ids;
      this.shipmentName = shipmentName;
      this.deficitType = deficitType;
      this.yearDate = yearDate;
      this.branchCompanyId = branchCompanyId;
      this.material = material;
      this.sectionSteelSpec = sectionSteelSpec;
   }

   public QueryByMaterialDTOParam() {
   }

   public static class QueryByMaterialDTOParamBuilder {
      private Integer projectWarehouseType;
      private Integer materialIsWhole;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Integer basicClass;
      private List<Long> classifyId;
      private List<Long> classifyIds;
      private BigDecimal minLength;
      private BigDecimal maxLength;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal theoryThickness;
      private BigDecimal thickness;
      private BigDecimal minThickness;
      private String heatNoAndBatchNo;
      private String specification;
      private Long workshopId;
      private Long warehouseId;
      private List<Long> warehouseIds;
      private List<Long> workshopIds;
      private String color;
      private String brand;
      private Boolean boolPartyA;
      private Integer objectType;
      private Integer freezeType;
      private List<Integer> freezeTypes;
      private Long freezeDetailId;
      private List<String> split;
      private String classifyName;
      private Boolean boolCross;
      private Long warehouseConfigId;
      private String specNumber;
      private List<Long> ids;
      private String shipmentName;
      private Integer deficitType;
      private LocalDate yearDate;
      private Long branchCompanyId;
      private String material;
      private String sectionSteelSpec;

      QueryByMaterialDTOParamBuilder() {
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder projectWarehouseType(final Integer projectWarehouseType) {
         this.projectWarehouseType = projectWarehouseType;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder classifyId(final List<Long> classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder classifyIds(final List<Long> classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder minLength(final BigDecimal minLength) {
         this.minLength = minLength;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder maxLength(final BigDecimal maxLength) {
         this.maxLength = maxLength;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder minThickness(final BigDecimal minThickness) {
         this.minThickness = minThickness;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder warehouseIds(final List<Long> warehouseIds) {
         this.warehouseIds = warehouseIds;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder workshopIds(final List<Long> workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder objectType(final Integer objectType) {
         this.objectType = objectType;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder freezeType(final Integer freezeType) {
         this.freezeType = freezeType;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder freezeTypes(final List<Integer> freezeTypes) {
         this.freezeTypes = freezeTypes;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder freezeDetailId(final Long freezeDetailId) {
         this.freezeDetailId = freezeDetailId;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder split(final List<String> split) {
         this.split = split;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder boolCross(final Boolean boolCross) {
         this.boolCross = boolCross;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder warehouseConfigId(final Long warehouseConfigId) {
         this.warehouseConfigId = warehouseConfigId;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder specNumber(final String specNumber) {
         this.specNumber = specNumber;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder ids(final List<Long> ids) {
         this.ids = ids;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder shipmentName(final String shipmentName) {
         this.shipmentName = shipmentName;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder deficitType(final Integer deficitType) {
         this.deficitType = deficitType;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder yearDate(final LocalDate yearDate) {
         this.yearDate = yearDate;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder sectionSteelSpec(final String sectionSteelSpec) {
         this.sectionSteelSpec = sectionSteelSpec;
         return this;
      }

      public QueryByMaterialDTOParam build() {
         return new QueryByMaterialDTOParam(
            this.projectWarehouseType,
            this.materialIsWhole,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.basicClass,
            this.classifyId,
            this.classifyIds,
            this.minLength,
            this.maxLength,
            this.length,
            this.width,
            this.theoryThickness,
            this.thickness,
            this.minThickness,
            this.heatNoAndBatchNo,
            this.specification,
            this.workshopId,
            this.warehouseId,
            this.warehouseIds,
            this.workshopIds,
            this.color,
            this.brand,
            this.boolPartyA,
            this.objectType,
            this.freezeType,
            this.freezeTypes,
            this.freezeDetailId,
            this.split,
            this.classifyName,
            this.boolCross,
            this.warehouseConfigId,
            this.specNumber,
            this.ids,
            this.shipmentName,
            this.deficitType,
            this.yearDate,
            this.branchCompanyId,
            this.material,
            this.sectionSteelSpec
         );
      }

      @Override
      public String toString() {
         return "QueryByMaterialDTOParam.QueryByMaterialDTOParamBuilder(projectWarehouseType="
            + this.projectWarehouseType
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", classifyIds="
            + this.classifyIds
            + ", minLength="
            + this.minLength
            + ", maxLength="
            + this.maxLength
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", theoryThickness="
            + this.theoryThickness
            + ", thickness="
            + this.thickness
            + ", minThickness="
            + this.minThickness
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", specification="
            + this.specification
            + ", workshopId="
            + this.workshopId
            + ", warehouseId="
            + this.warehouseId
            + ", warehouseIds="
            + this.warehouseIds
            + ", workshopIds="
            + this.workshopIds
            + ", color="
            + this.color
            + ", brand="
            + this.brand
            + ", boolPartyA="
            + this.boolPartyA
            + ", objectType="
            + this.objectType
            + ", freezeType="
            + this.freezeType
            + ", freezeTypes="
            + this.freezeTypes
            + ", freezeDetailId="
            + this.freezeDetailId
            + ", split="
            + this.split
            + ", classifyName="
            + this.classifyName
            + ", boolCross="
            + this.boolCross
            + ", warehouseConfigId="
            + this.warehouseConfigId
            + ", specNumber="
            + this.specNumber
            + ", ids="
            + this.ids
            + ", shipmentName="
            + this.shipmentName
            + ", deficitType="
            + this.deficitType
            + ", yearDate="
            + this.yearDate
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", material="
            + this.material
            + ", sectionSteelSpec="
            + this.sectionSteelSpec
            + ")";
      }
   }
}
