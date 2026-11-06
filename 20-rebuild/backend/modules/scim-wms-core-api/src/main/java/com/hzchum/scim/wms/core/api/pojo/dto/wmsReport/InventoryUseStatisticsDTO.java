package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InventoryUseStatisticsDTO {
   private Long id;
   private Integer basicClass;
   private Long classifyId;
   private String classifyName;
   private String classifySerialNumber;
   private String specification;
   private String model;
   private Long projectId;
   private Boolean boolPartyA;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal thickness;
   private BigDecimal theoryThickness;
   private String brand;
   private String heatNoAndBatchNo;
   private String color;
   private BigDecimal unitNet;
   private BigDecimal beginStageTotalQuantity;
   private BigDecimal beginStageTotalMete;
   private BigDecimal inboundStageTotalQuantity;
   private BigDecimal inboundStageTotalMete;
   private BigDecimal outboundStageTotalQuantity;
   private BigDecimal outboundStageTotalMete;
   private BigDecimal endStageTotalQuantity;
   private BigDecimal endStageTotalMete;
   private Long standardId;
   private String standardName;
   private String serialNumber;
   private Long workshopId;
   private Long warehouseId;
   private LocalDateTime startTime;
   private LocalDateTime endTime;
   private ProjectInfo project;
   private Measure measure;
   private BriefIdAndNameDTO workshop;
   private BriefIdAndNameDTO warehouse;
   private Integer materialIsWhole;
   private String materialSnNew;

   public static InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder builder() {
      return new InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Integer getBasicClass() {
      return this.basicClass;
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

   public String getSpecification() {
      return this.specification;
   }

   public String getModel() {
      return this.model;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
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

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public BigDecimal getBeginStageTotalQuantity() {
      return this.beginStageTotalQuantity;
   }

   public BigDecimal getBeginStageTotalMete() {
      return this.beginStageTotalMete;
   }

   public BigDecimal getInboundStageTotalQuantity() {
      return this.inboundStageTotalQuantity;
   }

   public BigDecimal getInboundStageTotalMete() {
      return this.inboundStageTotalMete;
   }

   public BigDecimal getOutboundStageTotalQuantity() {
      return this.outboundStageTotalQuantity;
   }

   public BigDecimal getOutboundStageTotalMete() {
      return this.outboundStageTotalMete;
   }

   public BigDecimal getEndStageTotalQuantity() {
      return this.endStageTotalQuantity;
   }

   public BigDecimal getEndStageTotalMete() {
      return this.endStageTotalMete;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getStandardName() {
      return this.standardName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Measure getMeasure() {
      return this.measure;
   }

   public BriefIdAndNameDTO getWorkshop() {
      return this.workshop;
   }

   public BriefIdAndNameDTO getWarehouse() {
      return this.warehouse;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public String getMaterialSnNew() {
      return this.materialSnNew;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
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

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setModel(final String model) {
      this.model = model;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
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

   public void setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
   }

   public void setBeginStageTotalQuantity(final BigDecimal beginStageTotalQuantity) {
      this.beginStageTotalQuantity = beginStageTotalQuantity;
   }

   public void setBeginStageTotalMete(final BigDecimal beginStageTotalMete) {
      this.beginStageTotalMete = beginStageTotalMete;
   }

   public void setInboundStageTotalQuantity(final BigDecimal inboundStageTotalQuantity) {
      this.inboundStageTotalQuantity = inboundStageTotalQuantity;
   }

   public void setInboundStageTotalMete(final BigDecimal inboundStageTotalMete) {
      this.inboundStageTotalMete = inboundStageTotalMete;
   }

   public void setOutboundStageTotalQuantity(final BigDecimal outboundStageTotalQuantity) {
      this.outboundStageTotalQuantity = outboundStageTotalQuantity;
   }

   public void setOutboundStageTotalMete(final BigDecimal outboundStageTotalMete) {
      this.outboundStageTotalMete = outboundStageTotalMete;
   }

   public void setEndStageTotalQuantity(final BigDecimal endStageTotalQuantity) {
      this.endStageTotalQuantity = endStageTotalQuantity;
   }

   public void setEndStageTotalMete(final BigDecimal endStageTotalMete) {
      this.endStageTotalMete = endStageTotalMete;
   }

   public void setStandardId(final Long standardId) {
      this.standardId = standardId;
   }

   public void setStandardName(final String standardName) {
      this.standardName = standardName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
   }

   public void setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMeasure(final Measure measure) {
      this.measure = measure;
   }

   public void setWorkshop(final BriefIdAndNameDTO workshop) {
      this.workshop = workshop;
   }

   public void setWarehouse(final BriefIdAndNameDTO warehouse) {
      this.warehouse = warehouse;
   }

   public void setMaterialIsWhole(final Integer materialIsWhole) {
      this.materialIsWhole = materialIsWhole;
   }

   public void setMaterialSnNew(final String materialSnNew) {
      this.materialSnNew = materialSnNew;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryUseStatisticsDTO)) {
         return false;
      }

      InventoryUseStatisticsDTO other = (InventoryUseStatisticsDTO)o;
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
                  Object this$boolPartyA = this.getBoolPartyA();
                  Object other$boolPartyA = other.getBoolPartyA();
                  if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
                     Object this$standardId = this.getStandardId();
                     Object other$standardId = other.getStandardId();
                     if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                        Object this$workshopId = this.getWorkshopId();
                        Object other$workshopId = other.getWorkshopId();
                        if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                           Object this$warehouseId = this.getWarehouseId();
                           Object other$warehouseId = other.getWarehouseId();
                           if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                              Object this$materialIsWhole = this.getMaterialIsWhole();
                              Object other$materialIsWhole = other.getMaterialIsWhole();
                              if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
                                 Object this$classifyName = this.getClassifyName();
                                 Object other$classifyName = other.getClassifyName();
                                 if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                    Object this$classifySerialNumber = this.getClassifySerialNumber();
                                    Object other$classifySerialNumber = other.getClassifySerialNumber();
                                    if (this$classifySerialNumber == null
                                       ? other$classifySerialNumber == null
                                       : this$classifySerialNumber.equals(other$classifySerialNumber)) {
                                       Object this$specification = this.getSpecification();
                                       Object other$specification = other.getSpecification();
                                       if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                          Object this$model = this.getModel();
                                          Object other$model = other.getModel();
                                          if (this$model == null ? other$model == null : this$model.equals(other$model)) {
                                             Object this$length = this.getLength();
                                             Object other$length = other.getLength();
                                             if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                Object this$width = this.getWidth();
                                                Object other$width = other.getWidth();
                                                if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                   Object this$thickness = this.getThickness();
                                                   Object other$thickness = other.getThickness();
                                                   if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                      Object this$theoryThickness = this.getTheoryThickness();
                                                      Object other$theoryThickness = other.getTheoryThickness();
                                                      if (this$theoryThickness == null
                                                         ? other$theoryThickness == null
                                                         : this$theoryThickness.equals(other$theoryThickness)) {
                                                         Object this$brand = this.getBrand();
                                                         Object other$brand = other.getBrand();
                                                         if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                            Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                            Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                            if (this$heatNoAndBatchNo == null
                                                               ? other$heatNoAndBatchNo == null
                                                               : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                               Object this$color = this.getColor();
                                                               Object other$color = other.getColor();
                                                               if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                  Object this$unitNet = this.getUnitNet();
                                                                  Object other$unitNet = other.getUnitNet();
                                                                  if (this$unitNet == null ? other$unitNet == null : this$unitNet.equals(other$unitNet)) {
                                                                     Object this$beginStageTotalQuantity = this.getBeginStageTotalQuantity();
                                                                     Object other$beginStageTotalQuantity = other.getBeginStageTotalQuantity();
                                                                     if (this$beginStageTotalQuantity == null
                                                                        ? other$beginStageTotalQuantity == null
                                                                        : this$beginStageTotalQuantity.equals(other$beginStageTotalQuantity)) {
                                                                        Object this$beginStageTotalMete = this.getBeginStageTotalMete();
                                                                        Object other$beginStageTotalMete = other.getBeginStageTotalMete();
                                                                        if (this$beginStageTotalMete == null
                                                                           ? other$beginStageTotalMete == null
                                                                           : this$beginStageTotalMete.equals(other$beginStageTotalMete)) {
                                                                           Object this$inboundStageTotalQuantity = this.getInboundStageTotalQuantity();
                                                                           Object other$inboundStageTotalQuantity = other.getInboundStageTotalQuantity();
                                                                           if (this$inboundStageTotalQuantity == null
                                                                              ? other$inboundStageTotalQuantity == null
                                                                              : this$inboundStageTotalQuantity.equals(other$inboundStageTotalQuantity)) {
                                                                              Object this$inboundStageTotalMete = this.getInboundStageTotalMete();
                                                                              Object other$inboundStageTotalMete = other.getInboundStageTotalMete();
                                                                              if (this$inboundStageTotalMete == null
                                                                                 ? other$inboundStageTotalMete == null
                                                                                 : this$inboundStageTotalMete.equals(other$inboundStageTotalMete)) {
                                                                                 Object this$outboundStageTotalQuantity = this.getOutboundStageTotalQuantity();
                                                                                 Object other$outboundStageTotalQuantity = other.getOutboundStageTotalQuantity();
                                                                                 if (this$outboundStageTotalQuantity == null
                                                                                    ? other$outboundStageTotalQuantity == null
                                                                                    : this$outboundStageTotalQuantity.equals(other$outboundStageTotalQuantity)) {
                                                                                    Object this$outboundStageTotalMete = this.getOutboundStageTotalMete();
                                                                                    Object other$outboundStageTotalMete = other.getOutboundStageTotalMete();
                                                                                    if (this$outboundStageTotalMete == null
                                                                                       ? other$outboundStageTotalMete == null
                                                                                       : this$outboundStageTotalMete.equals(other$outboundStageTotalMete)) {
                                                                                       Object this$endStageTotalQuantity = this.getEndStageTotalQuantity();
                                                                                       Object other$endStageTotalQuantity = other.getEndStageTotalQuantity();
                                                                                       if (this$endStageTotalQuantity == null
                                                                                          ? other$endStageTotalQuantity == null
                                                                                          : this$endStageTotalQuantity.equals(other$endStageTotalQuantity)) {
                                                                                          Object this$endStageTotalMete = this.getEndStageTotalMete();
                                                                                          Object other$endStageTotalMete = other.getEndStageTotalMete();
                                                                                          if (this$endStageTotalMete == null
                                                                                             ? other$endStageTotalMete == null
                                                                                             : this$endStageTotalMete.equals(other$endStageTotalMete)) {
                                                                                             Object this$standardName = this.getStandardName();
                                                                                             Object other$standardName = other.getStandardName();
                                                                                             if (this$standardName == null
                                                                                                ? other$standardName == null
                                                                                                : this$standardName.equals(other$standardName)) {
                                                                                                Object this$serialNumber = this.getSerialNumber();
                                                                                                Object other$serialNumber = other.getSerialNumber();
                                                                                                if (this$serialNumber == null
                                                                                                   ? other$serialNumber == null
                                                                                                   : this$serialNumber.equals(other$serialNumber)) {
                                                                                                   Object this$startTime = this.getStartTime();
                                                                                                   Object other$startTime = other.getStartTime();
                                                                                                   if (this$startTime == null
                                                                                                      ? other$startTime == null
                                                                                                      : this$startTime.equals(other$startTime)) {
                                                                                                      Object this$endTime = this.getEndTime();
                                                                                                      Object other$endTime = other.getEndTime();
                                                                                                      if (this$endTime == null
                                                                                                         ? other$endTime == null
                                                                                                         : this$endTime.equals(other$endTime)) {
                                                                                                         Object this$project = this.getProject();
                                                                                                         Object other$project = other.getProject();
                                                                                                         if (this$project == null
                                                                                                            ? other$project == null
                                                                                                            : this$project.equals(other$project)) {
                                                                                                            Object this$measure = this.getMeasure();
                                                                                                            Object other$measure = other.getMeasure();
                                                                                                            if (this$measure == null
                                                                                                               ? other$measure == null
                                                                                                               : this$measure.equals(other$measure)) {
                                                                                                               Object this$workshop = this.getWorkshop();
                                                                                                               Object other$workshop = other.getWorkshop();
                                                                                                               if (this$workshop == null
                                                                                                                  ? other$workshop == null
                                                                                                                  : this$workshop.equals(other$workshop)) {
                                                                                                                  Object this$warehouse = this.getWarehouse();
                                                                                                                  Object other$warehouse = other.getWarehouse();
                                                                                                                  if (this$warehouse == null
                                                                                                                     ? other$warehouse == null
                                                                                                                     : this$warehouse.equals(other$warehouse)) {
                                                                                                                     Object this$materialSnNew = this.getMaterialSnNew();
                                                                                                                     Object other$materialSnNew = other.getMaterialSnNew();
                                                                                                                     return this$materialSnNew == null
                                                                                                                        ? other$materialSnNew == null
                                                                                                                        : this$materialSnNew.equals(
                                                                                                                           other$materialSnNew
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InventoryUseStatisticsDTO;
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
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $classifySerialNumber = this.getClassifySerialNumber();
      result = result * 59 + ($classifySerialNumber == null ? 43 : $classifySerialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $model = this.getModel();
      result = result * 59 + ($model == null ? 43 : $model.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $beginStageTotalQuantity = this.getBeginStageTotalQuantity();
      result = result * 59 + ($beginStageTotalQuantity == null ? 43 : $beginStageTotalQuantity.hashCode());
      Object $beginStageTotalMete = this.getBeginStageTotalMete();
      result = result * 59 + ($beginStageTotalMete == null ? 43 : $beginStageTotalMete.hashCode());
      Object $inboundStageTotalQuantity = this.getInboundStageTotalQuantity();
      result = result * 59 + ($inboundStageTotalQuantity == null ? 43 : $inboundStageTotalQuantity.hashCode());
      Object $inboundStageTotalMete = this.getInboundStageTotalMete();
      result = result * 59 + ($inboundStageTotalMete == null ? 43 : $inboundStageTotalMete.hashCode());
      Object $outboundStageTotalQuantity = this.getOutboundStageTotalQuantity();
      result = result * 59 + ($outboundStageTotalQuantity == null ? 43 : $outboundStageTotalQuantity.hashCode());
      Object $outboundStageTotalMete = this.getOutboundStageTotalMete();
      result = result * 59 + ($outboundStageTotalMete == null ? 43 : $outboundStageTotalMete.hashCode());
      Object $endStageTotalQuantity = this.getEndStageTotalQuantity();
      result = result * 59 + ($endStageTotalQuantity == null ? 43 : $endStageTotalQuantity.hashCode());
      Object $endStageTotalMete = this.getEndStageTotalMete();
      result = result * 59 + ($endStageTotalMete == null ? 43 : $endStageTotalMete.hashCode());
      Object $standardName = this.getStandardName();
      result = result * 59 + ($standardName == null ? 43 : $standardName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $measure = this.getMeasure();
      result = result * 59 + ($measure == null ? 43 : $measure.hashCode());
      Object $workshop = this.getWorkshop();
      result = result * 59 + ($workshop == null ? 43 : $workshop.hashCode());
      Object $warehouse = this.getWarehouse();
      result = result * 59 + ($warehouse == null ? 43 : $warehouse.hashCode());
      Object $materialSnNew = this.getMaterialSnNew();
      return result * 59 + ($materialSnNew == null ? 43 : $materialSnNew.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryUseStatisticsDTO(id="
         + this.getId()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", classifySerialNumber="
         + this.getClassifySerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", model="
         + this.getModel()
         + ", projectId="
         + this.getProjectId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", unitNet="
         + this.getUnitNet()
         + ", beginStageTotalQuantity="
         + this.getBeginStageTotalQuantity()
         + ", beginStageTotalMete="
         + this.getBeginStageTotalMete()
         + ", inboundStageTotalQuantity="
         + this.getInboundStageTotalQuantity()
         + ", inboundStageTotalMete="
         + this.getInboundStageTotalMete()
         + ", outboundStageTotalQuantity="
         + this.getOutboundStageTotalQuantity()
         + ", outboundStageTotalMete="
         + this.getOutboundStageTotalMete()
         + ", endStageTotalQuantity="
         + this.getEndStageTotalQuantity()
         + ", endStageTotalMete="
         + this.getEndStageTotalMete()
         + ", standardId="
         + this.getStandardId()
         + ", standardName="
         + this.getStandardName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", workshopId="
         + this.getWorkshopId()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ", project="
         + this.getProject()
         + ", measure="
         + this.getMeasure()
         + ", workshop="
         + this.getWorkshop()
         + ", warehouse="
         + this.getWarehouse()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", materialSnNew="
         + this.getMaterialSnNew()
         + ")";
   }

   public InventoryUseStatisticsDTO(
      final Long id,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final String classifySerialNumber,
      final String specification,
      final String model,
      final Long projectId,
      final Boolean boolPartyA,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final BigDecimal unitNet,
      final BigDecimal beginStageTotalQuantity,
      final BigDecimal beginStageTotalMete,
      final BigDecimal inboundStageTotalQuantity,
      final BigDecimal inboundStageTotalMete,
      final BigDecimal outboundStageTotalQuantity,
      final BigDecimal outboundStageTotalMete,
      final BigDecimal endStageTotalQuantity,
      final BigDecimal endStageTotalMete,
      final Long standardId,
      final String standardName,
      final String serialNumber,
      final Long workshopId,
      final Long warehouseId,
      final LocalDateTime startTime,
      final LocalDateTime endTime,
      final ProjectInfo project,
      final Measure measure,
      final BriefIdAndNameDTO workshop,
      final BriefIdAndNameDTO warehouse,
      final Integer materialIsWhole,
      final String materialSnNew
   ) {
      this.id = id;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.classifySerialNumber = classifySerialNumber;
      this.specification = specification;
      this.model = model;
      this.projectId = projectId;
      this.boolPartyA = boolPartyA;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.unitNet = unitNet;
      this.beginStageTotalQuantity = beginStageTotalQuantity;
      this.beginStageTotalMete = beginStageTotalMete;
      this.inboundStageTotalQuantity = inboundStageTotalQuantity;
      this.inboundStageTotalMete = inboundStageTotalMete;
      this.outboundStageTotalQuantity = outboundStageTotalQuantity;
      this.outboundStageTotalMete = outboundStageTotalMete;
      this.endStageTotalQuantity = endStageTotalQuantity;
      this.endStageTotalMete = endStageTotalMete;
      this.standardId = standardId;
      this.standardName = standardName;
      this.serialNumber = serialNumber;
      this.workshopId = workshopId;
      this.warehouseId = warehouseId;
      this.startTime = startTime;
      this.endTime = endTime;
      this.project = project;
      this.measure = measure;
      this.workshop = workshop;
      this.warehouse = warehouse;
      this.materialIsWhole = materialIsWhole;
      this.materialSnNew = materialSnNew;
   }

   public InventoryUseStatisticsDTO() {
   }

   public static class InventoryUseStatisticsDTOBuilder {
      private Long id;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private String classifySerialNumber;
      private String specification;
      private String model;
      private Long projectId;
      private Boolean boolPartyA;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private BigDecimal unitNet;
      private BigDecimal beginStageTotalQuantity;
      private BigDecimal beginStageTotalMete;
      private BigDecimal inboundStageTotalQuantity;
      private BigDecimal inboundStageTotalMete;
      private BigDecimal outboundStageTotalQuantity;
      private BigDecimal outboundStageTotalMete;
      private BigDecimal endStageTotalQuantity;
      private BigDecimal endStageTotalMete;
      private Long standardId;
      private String standardName;
      private String serialNumber;
      private Long workshopId;
      private Long warehouseId;
      private LocalDateTime startTime;
      private LocalDateTime endTime;
      private ProjectInfo project;
      private Measure measure;
      private BriefIdAndNameDTO workshop;
      private BriefIdAndNameDTO warehouse;
      private Integer materialIsWhole;
      private String materialSnNew;

      InventoryUseStatisticsDTOBuilder() {
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder classifySerialNumber(final String classifySerialNumber) {
         this.classifySerialNumber = classifySerialNumber;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder model(final String model) {
         this.model = model;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder beginStageTotalQuantity(final BigDecimal beginStageTotalQuantity) {
         this.beginStageTotalQuantity = beginStageTotalQuantity;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder beginStageTotalMete(final BigDecimal beginStageTotalMete) {
         this.beginStageTotalMete = beginStageTotalMete;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder inboundStageTotalQuantity(final BigDecimal inboundStageTotalQuantity) {
         this.inboundStageTotalQuantity = inboundStageTotalQuantity;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder inboundStageTotalMete(final BigDecimal inboundStageTotalMete) {
         this.inboundStageTotalMete = inboundStageTotalMete;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder outboundStageTotalQuantity(final BigDecimal outboundStageTotalQuantity) {
         this.outboundStageTotalQuantity = outboundStageTotalQuantity;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder outboundStageTotalMete(final BigDecimal outboundStageTotalMete) {
         this.outboundStageTotalMete = outboundStageTotalMete;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder endStageTotalQuantity(final BigDecimal endStageTotalQuantity) {
         this.endStageTotalQuantity = endStageTotalQuantity;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder endStageTotalMete(final BigDecimal endStageTotalMete) {
         this.endStageTotalMete = endStageTotalMete;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder measure(final Measure measure) {
         this.measure = measure;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder workshop(final BriefIdAndNameDTO workshop) {
         this.workshop = workshop;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder warehouse(final BriefIdAndNameDTO warehouse) {
         this.warehouse = warehouse;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      public InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder materialSnNew(final String materialSnNew) {
         this.materialSnNew = materialSnNew;
         return this;
      }

      public InventoryUseStatisticsDTO build() {
         return new InventoryUseStatisticsDTO(
            this.id,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.classifySerialNumber,
            this.specification,
            this.model,
            this.projectId,
            this.boolPartyA,
            this.length,
            this.width,
            this.thickness,
            this.theoryThickness,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.unitNet,
            this.beginStageTotalQuantity,
            this.beginStageTotalMete,
            this.inboundStageTotalQuantity,
            this.inboundStageTotalMete,
            this.outboundStageTotalQuantity,
            this.outboundStageTotalMete,
            this.endStageTotalQuantity,
            this.endStageTotalMete,
            this.standardId,
            this.standardName,
            this.serialNumber,
            this.workshopId,
            this.warehouseId,
            this.startTime,
            this.endTime,
            this.project,
            this.measure,
            this.workshop,
            this.warehouse,
            this.materialIsWhole,
            this.materialSnNew
         );
      }

      @Override
      public String toString() {
         return "InventoryUseStatisticsDTO.InventoryUseStatisticsDTOBuilder(id="
            + this.id
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", classifySerialNumber="
            + this.classifySerialNumber
            + ", specification="
            + this.specification
            + ", model="
            + this.model
            + ", projectId="
            + this.projectId
            + ", boolPartyA="
            + this.boolPartyA
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", theoryThickness="
            + this.theoryThickness
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", unitNet="
            + this.unitNet
            + ", beginStageTotalQuantity="
            + this.beginStageTotalQuantity
            + ", beginStageTotalMete="
            + this.beginStageTotalMete
            + ", inboundStageTotalQuantity="
            + this.inboundStageTotalQuantity
            + ", inboundStageTotalMete="
            + this.inboundStageTotalMete
            + ", outboundStageTotalQuantity="
            + this.outboundStageTotalQuantity
            + ", outboundStageTotalMete="
            + this.outboundStageTotalMete
            + ", endStageTotalQuantity="
            + this.endStageTotalQuantity
            + ", endStageTotalMete="
            + this.endStageTotalMete
            + ", standardId="
            + this.standardId
            + ", standardName="
            + this.standardName
            + ", serialNumber="
            + this.serialNumber
            + ", workshopId="
            + this.workshopId
            + ", warehouseId="
            + this.warehouseId
            + ", startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ", project="
            + this.project
            + ", measure="
            + this.measure
            + ", workshop="
            + this.workshop
            + ", warehouse="
            + this.warehouse
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", materialSnNew="
            + this.materialSnNew
            + ")";
      }
   }
}
