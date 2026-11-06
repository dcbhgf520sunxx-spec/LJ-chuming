package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.wms.core.api.pojo._do.wmsConfig.Measure;
import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class InventoryUseStatisticsMergeDTO {
   private List<Long> idList;
   private List<String> specificationList;
   private List<String> brandList;
   private List<ProjectInfo> projectInfoList;
   private List<BriefIdAndNameDTO> workshopInfoList;
   private List<BriefIdAndNameDTO> warehouseInfoList;
   private List<String> warehouseNameList;
   private List<String> colorList;
   private List<String> heatNoAndBatchNoList;
   private List<String> classSerialNumber;
   private Integer basicClass;
   private Long classifyId;
   private String classifyName;
   private String classifySerialNumber;
   private Boolean boolPartyA;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal thickness;
   private BigDecimal theoryThickness;
   private BigDecimal unitNet;
   private BigDecimal beginStageTotalQuantity;
   private BigDecimal beginStageTotalMete;
   private BigDecimal inboundStageTotalQuantity;
   private BigDecimal inboundStageTotalMete;
   private BigDecimal transferStageTotalQuantity;
   private BigDecimal transferStageTotalMete;
   private BigDecimal outboundStageTotalQuantity;
   private BigDecimal outboundStageTotalMete;
   private BigDecimal endStageTotalQuantity;
   private BigDecimal endStageTotalMete;
   private Long standardId;
   private String standardName;
   private String serialNumber;
   private LocalDateTime startTime;
   private LocalDateTime endTime;
   private Measure measure;
   private Integer materialIsWhole;
   private String materialSnNew;

   public static InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder builder() {
      return new InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder();
   }

   public List<Long> getIdList() {
      return this.idList;
   }

   public List<String> getSpecificationList() {
      return this.specificationList;
   }

   public List<String> getBrandList() {
      return this.brandList;
   }

   public List<ProjectInfo> getProjectInfoList() {
      return this.projectInfoList;
   }

   public List<BriefIdAndNameDTO> getWorkshopInfoList() {
      return this.workshopInfoList;
   }

   public List<BriefIdAndNameDTO> getWarehouseInfoList() {
      return this.warehouseInfoList;
   }

   public List<String> getWarehouseNameList() {
      return this.warehouseNameList;
   }

   public List<String> getColorList() {
      return this.colorList;
   }

   public List<String> getHeatNoAndBatchNoList() {
      return this.heatNoAndBatchNoList;
   }

   public List<String> getClassSerialNumber() {
      return this.classSerialNumber;
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

   public BigDecimal getTransferStageTotalQuantity() {
      return this.transferStageTotalQuantity;
   }

   public BigDecimal getTransferStageTotalMete() {
      return this.transferStageTotalMete;
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

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public Measure getMeasure() {
      return this.measure;
   }

   public Integer getMaterialIsWhole() {
      return this.materialIsWhole;
   }

   public String getMaterialSnNew() {
      return this.materialSnNew;
   }

   public void setIdList(final List<Long> idList) {
      this.idList = idList;
   }

   public void setSpecificationList(final List<String> specificationList) {
      this.specificationList = specificationList;
   }

   public void setBrandList(final List<String> brandList) {
      this.brandList = brandList;
   }

   public void setProjectInfoList(final List<ProjectInfo> projectInfoList) {
      this.projectInfoList = projectInfoList;
   }

   public void setWorkshopInfoList(final List<BriefIdAndNameDTO> workshopInfoList) {
      this.workshopInfoList = workshopInfoList;
   }

   public void setWarehouseInfoList(final List<BriefIdAndNameDTO> warehouseInfoList) {
      this.warehouseInfoList = warehouseInfoList;
   }

   public void setWarehouseNameList(final List<String> warehouseNameList) {
      this.warehouseNameList = warehouseNameList;
   }

   public void setColorList(final List<String> colorList) {
      this.colorList = colorList;
   }

   public void setHeatNoAndBatchNoList(final List<String> heatNoAndBatchNoList) {
      this.heatNoAndBatchNoList = heatNoAndBatchNoList;
   }

   public void setClassSerialNumber(final List<String> classSerialNumber) {
      this.classSerialNumber = classSerialNumber;
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

   public void setTransferStageTotalQuantity(final BigDecimal transferStageTotalQuantity) {
      this.transferStageTotalQuantity = transferStageTotalQuantity;
   }

   public void setTransferStageTotalMete(final BigDecimal transferStageTotalMete) {
      this.transferStageTotalMete = transferStageTotalMete;
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

   public void setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
   }

   public void setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
   }

   public void setMeasure(final Measure measure) {
      this.measure = measure;
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

      if (!(o instanceof InventoryUseStatisticsMergeDTO)) {
         return false;
      }

      InventoryUseStatisticsMergeDTO other = (InventoryUseStatisticsMergeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$boolPartyA = this.getBoolPartyA();
            Object other$boolPartyA = other.getBoolPartyA();
            if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
               Object this$standardId = this.getStandardId();
               Object other$standardId = other.getStandardId();
               if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                  Object this$materialIsWhole = this.getMaterialIsWhole();
                  Object other$materialIsWhole = other.getMaterialIsWhole();
                  if (this$materialIsWhole == null ? other$materialIsWhole == null : this$materialIsWhole.equals(other$materialIsWhole)) {
                     Object this$idList = this.getIdList();
                     Object other$idList = other.getIdList();
                     if (this$idList == null ? other$idList == null : this$idList.equals(other$idList)) {
                        Object this$specificationList = this.getSpecificationList();
                        Object other$specificationList = other.getSpecificationList();
                        if (this$specificationList == null ? other$specificationList == null : this$specificationList.equals(other$specificationList)) {
                           Object this$brandList = this.getBrandList();
                           Object other$brandList = other.getBrandList();
                           if (this$brandList == null ? other$brandList == null : this$brandList.equals(other$brandList)) {
                              Object this$projectInfoList = this.getProjectInfoList();
                              Object other$projectInfoList = other.getProjectInfoList();
                              if (this$projectInfoList == null ? other$projectInfoList == null : this$projectInfoList.equals(other$projectInfoList)) {
                                 Object this$workshopInfoList = this.getWorkshopInfoList();
                                 Object other$workshopInfoList = other.getWorkshopInfoList();
                                 if (this$workshopInfoList == null ? other$workshopInfoList == null : this$workshopInfoList.equals(other$workshopInfoList)) {
                                    Object this$warehouseInfoList = this.getWarehouseInfoList();
                                    Object other$warehouseInfoList = other.getWarehouseInfoList();
                                    if (this$warehouseInfoList == null
                                       ? other$warehouseInfoList == null
                                       : this$warehouseInfoList.equals(other$warehouseInfoList)) {
                                       Object this$warehouseNameList = this.getWarehouseNameList();
                                       Object other$warehouseNameList = other.getWarehouseNameList();
                                       if (this$warehouseNameList == null
                                          ? other$warehouseNameList == null
                                          : this$warehouseNameList.equals(other$warehouseNameList)) {
                                          Object this$colorList = this.getColorList();
                                          Object other$colorList = other.getColorList();
                                          if (this$colorList == null ? other$colorList == null : this$colorList.equals(other$colorList)) {
                                             Object this$heatNoAndBatchNoList = this.getHeatNoAndBatchNoList();
                                             Object other$heatNoAndBatchNoList = other.getHeatNoAndBatchNoList();
                                             if (this$heatNoAndBatchNoList == null
                                                ? other$heatNoAndBatchNoList == null
                                                : this$heatNoAndBatchNoList.equals(other$heatNoAndBatchNoList)) {
                                                Object this$classSerialNumber = this.getClassSerialNumber();
                                                Object other$classSerialNumber = other.getClassSerialNumber();
                                                if (this$classSerialNumber == null
                                                   ? other$classSerialNumber == null
                                                   : this$classSerialNumber.equals(other$classSerialNumber)) {
                                                   Object this$classifyName = this.getClassifyName();
                                                   Object other$classifyName = other.getClassifyName();
                                                   if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                                                      Object this$classifySerialNumber = this.getClassifySerialNumber();
                                                      Object other$classifySerialNumber = other.getClassifySerialNumber();
                                                      if (this$classifySerialNumber == null
                                                         ? other$classifySerialNumber == null
                                                         : this$classifySerialNumber.equals(other$classifySerialNumber)) {
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
                                                                                    Object this$transferStageTotalQuantity = this.getTransferStageTotalQuantity();
                                                                                    Object other$transferStageTotalQuantity = other.getTransferStageTotalQuantity();
                                                                                    if (this$transferStageTotalQuantity == null
                                                                                       ? other$transferStageTotalQuantity == null
                                                                                       : this$transferStageTotalQuantity.equals(
                                                                                          other$transferStageTotalQuantity
                                                                                       )) {
                                                                                       Object this$transferStageTotalMete = this.getTransferStageTotalMete();
                                                                                       Object other$transferStageTotalMete = other.getTransferStageTotalMete();
                                                                                       if (this$transferStageTotalMete == null
                                                                                          ? other$transferStageTotalMete == null
                                                                                          : this$transferStageTotalMete.equals(other$transferStageTotalMete)) {
                                                                                          Object this$outboundStageTotalQuantity = this.getOutboundStageTotalQuantity();
                                                                                          Object other$outboundStageTotalQuantity = other.getOutboundStageTotalQuantity();
                                                                                          if (this$outboundStageTotalQuantity == null
                                                                                             ? other$outboundStageTotalQuantity == null
                                                                                             : this$outboundStageTotalQuantity.equals(
                                                                                                other$outboundStageTotalQuantity
                                                                                             )) {
                                                                                             Object this$outboundStageTotalMete = this.getOutboundStageTotalMete();
                                                                                             Object other$outboundStageTotalMete = other.getOutboundStageTotalMete();
                                                                                             if (this$outboundStageTotalMete == null
                                                                                                ? other$outboundStageTotalMete == null
                                                                                                : this$outboundStageTotalMete.equals(
                                                                                                   other$outboundStageTotalMete
                                                                                                )) {
                                                                                                Object this$endStageTotalQuantity = this.getEndStageTotalQuantity();
                                                                                                Object other$endStageTotalQuantity = other.getEndStageTotalQuantity();
                                                                                                if (this$endStageTotalQuantity == null
                                                                                                   ? other$endStageTotalQuantity == null
                                                                                                   : this$endStageTotalQuantity.equals(
                                                                                                      other$endStageTotalQuantity
                                                                                                   )) {
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
                                                                                                                  Object this$measure = this.getMeasure();
                                                                                                                  Object other$measure = other.getMeasure();
                                                                                                                  if (this$measure == null
                                                                                                                     ? other$measure == null
                                                                                                                     : this$measure.equals(other$measure)) {
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
      return other instanceof InventoryUseStatisticsMergeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $materialIsWhole = this.getMaterialIsWhole();
      result = result * 59 + ($materialIsWhole == null ? 43 : $materialIsWhole.hashCode());
      Object $idList = this.getIdList();
      result = result * 59 + ($idList == null ? 43 : $idList.hashCode());
      Object $specificationList = this.getSpecificationList();
      result = result * 59 + ($specificationList == null ? 43 : $specificationList.hashCode());
      Object $brandList = this.getBrandList();
      result = result * 59 + ($brandList == null ? 43 : $brandList.hashCode());
      Object $projectInfoList = this.getProjectInfoList();
      result = result * 59 + ($projectInfoList == null ? 43 : $projectInfoList.hashCode());
      Object $workshopInfoList = this.getWorkshopInfoList();
      result = result * 59 + ($workshopInfoList == null ? 43 : $workshopInfoList.hashCode());
      Object $warehouseInfoList = this.getWarehouseInfoList();
      result = result * 59 + ($warehouseInfoList == null ? 43 : $warehouseInfoList.hashCode());
      Object $warehouseNameList = this.getWarehouseNameList();
      result = result * 59 + ($warehouseNameList == null ? 43 : $warehouseNameList.hashCode());
      Object $colorList = this.getColorList();
      result = result * 59 + ($colorList == null ? 43 : $colorList.hashCode());
      Object $heatNoAndBatchNoList = this.getHeatNoAndBatchNoList();
      result = result * 59 + ($heatNoAndBatchNoList == null ? 43 : $heatNoAndBatchNoList.hashCode());
      Object $classSerialNumber = this.getClassSerialNumber();
      result = result * 59 + ($classSerialNumber == null ? 43 : $classSerialNumber.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $classifySerialNumber = this.getClassifySerialNumber();
      result = result * 59 + ($classifySerialNumber == null ? 43 : $classifySerialNumber.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
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
      Object $transferStageTotalQuantity = this.getTransferStageTotalQuantity();
      result = result * 59 + ($transferStageTotalQuantity == null ? 43 : $transferStageTotalQuantity.hashCode());
      Object $transferStageTotalMete = this.getTransferStageTotalMete();
      result = result * 59 + ($transferStageTotalMete == null ? 43 : $transferStageTotalMete.hashCode());
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
      Object $measure = this.getMeasure();
      result = result * 59 + ($measure == null ? 43 : $measure.hashCode());
      Object $materialSnNew = this.getMaterialSnNew();
      return result * 59 + ($materialSnNew == null ? 43 : $materialSnNew.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryUseStatisticsMergeDTO(idList="
         + this.getIdList()
         + ", specificationList="
         + this.getSpecificationList()
         + ", brandList="
         + this.getBrandList()
         + ", projectInfoList="
         + this.getProjectInfoList()
         + ", workshopInfoList="
         + this.getWorkshopInfoList()
         + ", warehouseInfoList="
         + this.getWarehouseInfoList()
         + ", warehouseNameList="
         + this.getWarehouseNameList()
         + ", colorList="
         + this.getColorList()
         + ", heatNoAndBatchNoList="
         + this.getHeatNoAndBatchNoList()
         + ", classSerialNumber="
         + this.getClassSerialNumber()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", classifySerialNumber="
         + this.getClassifySerialNumber()
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
         + ", transferStageTotalQuantity="
         + this.getTransferStageTotalQuantity()
         + ", transferStageTotalMete="
         + this.getTransferStageTotalMete()
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
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ", measure="
         + this.getMeasure()
         + ", materialIsWhole="
         + this.getMaterialIsWhole()
         + ", materialSnNew="
         + this.getMaterialSnNew()
         + ")";
   }

   public InventoryUseStatisticsMergeDTO(
      final List<Long> idList,
      final List<String> specificationList,
      final List<String> brandList,
      final List<ProjectInfo> projectInfoList,
      final List<BriefIdAndNameDTO> workshopInfoList,
      final List<BriefIdAndNameDTO> warehouseInfoList,
      final List<String> warehouseNameList,
      final List<String> colorList,
      final List<String> heatNoAndBatchNoList,
      final List<String> classSerialNumber,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final String classifySerialNumber,
      final Boolean boolPartyA,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final BigDecimal unitNet,
      final BigDecimal beginStageTotalQuantity,
      final BigDecimal beginStageTotalMete,
      final BigDecimal inboundStageTotalQuantity,
      final BigDecimal inboundStageTotalMete,
      final BigDecimal transferStageTotalQuantity,
      final BigDecimal transferStageTotalMete,
      final BigDecimal outboundStageTotalQuantity,
      final BigDecimal outboundStageTotalMete,
      final BigDecimal endStageTotalQuantity,
      final BigDecimal endStageTotalMete,
      final Long standardId,
      final String standardName,
      final String serialNumber,
      final LocalDateTime startTime,
      final LocalDateTime endTime,
      final Measure measure,
      final Integer materialIsWhole,
      final String materialSnNew
   ) {
      this.idList = idList;
      this.specificationList = specificationList;
      this.brandList = brandList;
      this.projectInfoList = projectInfoList;
      this.workshopInfoList = workshopInfoList;
      this.warehouseInfoList = warehouseInfoList;
      this.warehouseNameList = warehouseNameList;
      this.colorList = colorList;
      this.heatNoAndBatchNoList = heatNoAndBatchNoList;
      this.classSerialNumber = classSerialNumber;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.classifySerialNumber = classifySerialNumber;
      this.boolPartyA = boolPartyA;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.unitNet = unitNet;
      this.beginStageTotalQuantity = beginStageTotalQuantity;
      this.beginStageTotalMete = beginStageTotalMete;
      this.inboundStageTotalQuantity = inboundStageTotalQuantity;
      this.inboundStageTotalMete = inboundStageTotalMete;
      this.transferStageTotalQuantity = transferStageTotalQuantity;
      this.transferStageTotalMete = transferStageTotalMete;
      this.outboundStageTotalQuantity = outboundStageTotalQuantity;
      this.outboundStageTotalMete = outboundStageTotalMete;
      this.endStageTotalQuantity = endStageTotalQuantity;
      this.endStageTotalMete = endStageTotalMete;
      this.standardId = standardId;
      this.standardName = standardName;
      this.serialNumber = serialNumber;
      this.startTime = startTime;
      this.endTime = endTime;
      this.measure = measure;
      this.materialIsWhole = materialIsWhole;
      this.materialSnNew = materialSnNew;
   }

   public InventoryUseStatisticsMergeDTO() {
   }

   public static class InventoryUseStatisticsMergeDTOBuilder {
      private List<Long> idList;
      private List<String> specificationList;
      private List<String> brandList;
      private List<ProjectInfo> projectInfoList;
      private List<BriefIdAndNameDTO> workshopInfoList;
      private List<BriefIdAndNameDTO> warehouseInfoList;
      private List<String> warehouseNameList;
      private List<String> colorList;
      private List<String> heatNoAndBatchNoList;
      private List<String> classSerialNumber;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private String classifySerialNumber;
      private Boolean boolPartyA;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private BigDecimal unitNet;
      private BigDecimal beginStageTotalQuantity;
      private BigDecimal beginStageTotalMete;
      private BigDecimal inboundStageTotalQuantity;
      private BigDecimal inboundStageTotalMete;
      private BigDecimal transferStageTotalQuantity;
      private BigDecimal transferStageTotalMete;
      private BigDecimal outboundStageTotalQuantity;
      private BigDecimal outboundStageTotalMete;
      private BigDecimal endStageTotalQuantity;
      private BigDecimal endStageTotalMete;
      private Long standardId;
      private String standardName;
      private String serialNumber;
      private LocalDateTime startTime;
      private LocalDateTime endTime;
      private Measure measure;
      private Integer materialIsWhole;
      private String materialSnNew;

      InventoryUseStatisticsMergeDTOBuilder() {
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder idList(final List<Long> idList) {
         this.idList = idList;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder specificationList(final List<String> specificationList) {
         this.specificationList = specificationList;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder brandList(final List<String> brandList) {
         this.brandList = brandList;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder projectInfoList(final List<ProjectInfo> projectInfoList) {
         this.projectInfoList = projectInfoList;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder workshopInfoList(final List<BriefIdAndNameDTO> workshopInfoList) {
         this.workshopInfoList = workshopInfoList;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder warehouseInfoList(final List<BriefIdAndNameDTO> warehouseInfoList) {
         this.warehouseInfoList = warehouseInfoList;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder warehouseNameList(final List<String> warehouseNameList) {
         this.warehouseNameList = warehouseNameList;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder colorList(final List<String> colorList) {
         this.colorList = colorList;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder heatNoAndBatchNoList(final List<String> heatNoAndBatchNoList) {
         this.heatNoAndBatchNoList = heatNoAndBatchNoList;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder classSerialNumber(final List<String> classSerialNumber) {
         this.classSerialNumber = classSerialNumber;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder classifySerialNumber(final String classifySerialNumber) {
         this.classifySerialNumber = classifySerialNumber;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder beginStageTotalQuantity(final BigDecimal beginStageTotalQuantity) {
         this.beginStageTotalQuantity = beginStageTotalQuantity;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder beginStageTotalMete(final BigDecimal beginStageTotalMete) {
         this.beginStageTotalMete = beginStageTotalMete;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder inboundStageTotalQuantity(final BigDecimal inboundStageTotalQuantity) {
         this.inboundStageTotalQuantity = inboundStageTotalQuantity;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder inboundStageTotalMete(final BigDecimal inboundStageTotalMete) {
         this.inboundStageTotalMete = inboundStageTotalMete;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder transferStageTotalQuantity(final BigDecimal transferStageTotalQuantity) {
         this.transferStageTotalQuantity = transferStageTotalQuantity;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder transferStageTotalMete(final BigDecimal transferStageTotalMete) {
         this.transferStageTotalMete = transferStageTotalMete;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder outboundStageTotalQuantity(final BigDecimal outboundStageTotalQuantity) {
         this.outboundStageTotalQuantity = outboundStageTotalQuantity;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder outboundStageTotalMete(final BigDecimal outboundStageTotalMete) {
         this.outboundStageTotalMete = outboundStageTotalMete;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder endStageTotalQuantity(final BigDecimal endStageTotalQuantity) {
         this.endStageTotalQuantity = endStageTotalQuantity;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder endStageTotalMete(final BigDecimal endStageTotalMete) {
         this.endStageTotalMete = endStageTotalMete;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder standardName(final String standardName) {
         this.standardName = standardName;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder startTime(final LocalDateTime startTime) {
         this.startTime = startTime;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder endTime(final LocalDateTime endTime) {
         this.endTime = endTime;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder measure(final Measure measure) {
         this.measure = measure;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder materialIsWhole(final Integer materialIsWhole) {
         this.materialIsWhole = materialIsWhole;
         return this;
      }

      public InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder materialSnNew(final String materialSnNew) {
         this.materialSnNew = materialSnNew;
         return this;
      }

      public InventoryUseStatisticsMergeDTO build() {
         return new InventoryUseStatisticsMergeDTO(
            this.idList,
            this.specificationList,
            this.brandList,
            this.projectInfoList,
            this.workshopInfoList,
            this.warehouseInfoList,
            this.warehouseNameList,
            this.colorList,
            this.heatNoAndBatchNoList,
            this.classSerialNumber,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.classifySerialNumber,
            this.boolPartyA,
            this.length,
            this.width,
            this.thickness,
            this.theoryThickness,
            this.unitNet,
            this.beginStageTotalQuantity,
            this.beginStageTotalMete,
            this.inboundStageTotalQuantity,
            this.inboundStageTotalMete,
            this.transferStageTotalQuantity,
            this.transferStageTotalMete,
            this.outboundStageTotalQuantity,
            this.outboundStageTotalMete,
            this.endStageTotalQuantity,
            this.endStageTotalMete,
            this.standardId,
            this.standardName,
            this.serialNumber,
            this.startTime,
            this.endTime,
            this.measure,
            this.materialIsWhole,
            this.materialSnNew
         );
      }

      @Override
      public String toString() {
         return "InventoryUseStatisticsMergeDTO.InventoryUseStatisticsMergeDTOBuilder(idList="
            + this.idList
            + ", specificationList="
            + this.specificationList
            + ", brandList="
            + this.brandList
            + ", projectInfoList="
            + this.projectInfoList
            + ", workshopInfoList="
            + this.workshopInfoList
            + ", warehouseInfoList="
            + this.warehouseInfoList
            + ", warehouseNameList="
            + this.warehouseNameList
            + ", colorList="
            + this.colorList
            + ", heatNoAndBatchNoList="
            + this.heatNoAndBatchNoList
            + ", classSerialNumber="
            + this.classSerialNumber
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", classifySerialNumber="
            + this.classifySerialNumber
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
            + ", transferStageTotalQuantity="
            + this.transferStageTotalQuantity
            + ", transferStageTotalMete="
            + this.transferStageTotalMete
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
            + ", startTime="
            + this.startTime
            + ", endTime="
            + this.endTime
            + ", measure="
            + this.measure
            + ", materialIsWhole="
            + this.materialIsWhole
            + ", materialSnNew="
            + this.materialSnNew
            + ")";
      }
   }
}
