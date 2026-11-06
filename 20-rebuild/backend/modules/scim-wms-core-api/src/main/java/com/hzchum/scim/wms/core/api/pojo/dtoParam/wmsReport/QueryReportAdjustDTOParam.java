package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class QueryReportAdjustDTOParam {
   private List<LocalDateTime> inboundTime;
   private Integer basicClass;
   private Integer orderSupplyType;
   private Integer rejectStatus;
   private String inboundSN;
   private Long projectId;
   private String shipmentNumber;
   private String licensePlate;
   private String purchaseSN;
   private String serialNumber;
   private Long supplierId;
   private String operatorName;
   private Integer projectWarehouseType;
   private Long factoryId;
   private Long branchCompanyId;
   private String brand;
   private String specification;
   private Long classifyId;
   private List<Long> classifyIds;
   private Long warehouseId;
   private String heatNoAndBatchNo;
   private String color;
   private BigDecimal minLength;
   private BigDecimal maxLength;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal theoryThickness;
   private BigDecimal thickness;
   private Integer reviewStatus;
   private String adjustSerialNumber;
   private List<Long> workshopIds;
   private Integer inboundWay;

   public static QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder builder() {
      return new QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder();
   }

   public List<LocalDateTime> getInboundTime() {
      return this.inboundTime;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getOrderSupplyType() {
      return this.orderSupplyType;
   }

   public Integer getRejectStatus() {
      return this.rejectStatus;
   }

   public String getInboundSN() {
      return this.inboundSN;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getPurchaseSN() {
      return this.purchaseSN;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public Integer getProjectWarehouseType() {
      return this.projectWarehouseType;
   }

   public Long getFactoryId() {
      return this.factoryId;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public List<Long> getClassifyIds() {
      return this.classifyIds;
   }

   public Long getWarehouseId() {
      return this.warehouseId;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
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

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public String getAdjustSerialNumber() {
      return this.adjustSerialNumber;
   }

   public List<Long> getWorkshopIds() {
      return this.workshopIds;
   }

   public Integer getInboundWay() {
      return this.inboundWay;
   }

   public void setInboundTime(final List<LocalDateTime> inboundTime) {
      this.inboundTime = inboundTime;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setOrderSupplyType(final Integer orderSupplyType) {
      this.orderSupplyType = orderSupplyType;
   }

   public void setRejectStatus(final Integer rejectStatus) {
      this.rejectStatus = rejectStatus;
   }

   public void setInboundSN(final String inboundSN) {
      this.inboundSN = inboundSN;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setPurchaseSN(final String purchaseSN) {
      this.purchaseSN = purchaseSN;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
   }

   public void setProjectWarehouseType(final Integer projectWarehouseType) {
      this.projectWarehouseType = projectWarehouseType;
   }

   public void setFactoryId(final Long factoryId) {
      this.factoryId = factoryId;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyIds(final List<Long> classifyIds) {
      this.classifyIds = classifyIds;
   }

   public void setWarehouseId(final Long warehouseId) {
      this.warehouseId = warehouseId;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setColor(final String color) {
      this.color = color;
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

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setAdjustSerialNumber(final String adjustSerialNumber) {
      this.adjustSerialNumber = adjustSerialNumber;
   }

   public void setWorkshopIds(final List<Long> workshopIds) {
      this.workshopIds = workshopIds;
   }

   public void setInboundWay(final Integer inboundWay) {
      this.inboundWay = inboundWay;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryReportAdjustDTOParam)) {
         return false;
      }

      QueryReportAdjustDTOParam other = (QueryReportAdjustDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$orderSupplyType = this.getOrderSupplyType();
         Object other$orderSupplyType = other.getOrderSupplyType();
         if (this$orderSupplyType == null ? other$orderSupplyType == null : this$orderSupplyType.equals(other$orderSupplyType)) {
            Object this$rejectStatus = this.getRejectStatus();
            Object other$rejectStatus = other.getRejectStatus();
            if (this$rejectStatus == null ? other$rejectStatus == null : this$rejectStatus.equals(other$rejectStatus)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$projectWarehouseType = this.getProjectWarehouseType();
                     Object other$projectWarehouseType = other.getProjectWarehouseType();
                     if (this$projectWarehouseType == null ? other$projectWarehouseType == null : this$projectWarehouseType.equals(other$projectWarehouseType)) {
                        Object this$factoryId = this.getFactoryId();
                        Object other$factoryId = other.getFactoryId();
                        if (this$factoryId == null ? other$factoryId == null : this$factoryId.equals(other$factoryId)) {
                           Object this$branchCompanyId = this.getBranchCompanyId();
                           Object other$branchCompanyId = other.getBranchCompanyId();
                           if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                              Object this$classifyId = this.getClassifyId();
                              Object other$classifyId = other.getClassifyId();
                              if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                                 Object this$warehouseId = this.getWarehouseId();
                                 Object other$warehouseId = other.getWarehouseId();
                                 if (this$warehouseId == null ? other$warehouseId == null : this$warehouseId.equals(other$warehouseId)) {
                                    Object this$reviewStatus = this.getReviewStatus();
                                    Object other$reviewStatus = other.getReviewStatus();
                                    if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                                       Object this$inboundWay = this.getInboundWay();
                                       Object other$inboundWay = other.getInboundWay();
                                       if (this$inboundWay == null ? other$inboundWay == null : this$inboundWay.equals(other$inboundWay)) {
                                          Object this$inboundTime = this.getInboundTime();
                                          Object other$inboundTime = other.getInboundTime();
                                          if (this$inboundTime == null ? other$inboundTime == null : this$inboundTime.equals(other$inboundTime)) {
                                             Object this$inboundSN = this.getInboundSN();
                                             Object other$inboundSN = other.getInboundSN();
                                             if (this$inboundSN == null ? other$inboundSN == null : this$inboundSN.equals(other$inboundSN)) {
                                                Object this$shipmentNumber = this.getShipmentNumber();
                                                Object other$shipmentNumber = other.getShipmentNumber();
                                                if (this$shipmentNumber == null
                                                   ? other$shipmentNumber == null
                                                   : this$shipmentNumber.equals(other$shipmentNumber)) {
                                                   Object this$licensePlate = this.getLicensePlate();
                                                   Object other$licensePlate = other.getLicensePlate();
                                                   if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                                      Object this$purchaseSN = this.getPurchaseSN();
                                                      Object other$purchaseSN = other.getPurchaseSN();
                                                      if (this$purchaseSN == null ? other$purchaseSN == null : this$purchaseSN.equals(other$purchaseSN)) {
                                                         Object this$serialNumber = this.getSerialNumber();
                                                         Object other$serialNumber = other.getSerialNumber();
                                                         if (this$serialNumber == null
                                                            ? other$serialNumber == null
                                                            : this$serialNumber.equals(other$serialNumber)) {
                                                            Object this$operatorName = this.getOperatorName();
                                                            Object other$operatorName = other.getOperatorName();
                                                            if (this$operatorName == null
                                                               ? other$operatorName == null
                                                               : this$operatorName.equals(other$operatorName)) {
                                                               Object this$brand = this.getBrand();
                                                               Object other$brand = other.getBrand();
                                                               if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                  Object this$specification = this.getSpecification();
                                                                  Object other$specification = other.getSpecification();
                                                                  if (this$specification == null
                                                                     ? other$specification == null
                                                                     : this$specification.equals(other$specification)) {
                                                                     Object this$classifyIds = this.getClassifyIds();
                                                                     Object other$classifyIds = other.getClassifyIds();
                                                                     if (this$classifyIds == null
                                                                        ? other$classifyIds == null
                                                                        : this$classifyIds.equals(other$classifyIds)) {
                                                                        Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                                        Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                                        if (this$heatNoAndBatchNo == null
                                                                           ? other$heatNoAndBatchNo == null
                                                                           : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                                           Object this$color = this.getColor();
                                                                           Object other$color = other.getColor();
                                                                           if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                              Object this$minLength = this.getMinLength();
                                                                              Object other$minLength = other.getMinLength();
                                                                              if (this$minLength == null
                                                                                 ? other$minLength == null
                                                                                 : this$minLength.equals(other$minLength)) {
                                                                                 Object this$maxLength = this.getMaxLength();
                                                                                 Object other$maxLength = other.getMaxLength();
                                                                                 if (this$maxLength == null
                                                                                    ? other$maxLength == null
                                                                                    : this$maxLength.equals(other$maxLength)) {
                                                                                    Object this$length = this.getLength();
                                                                                    Object other$length = other.getLength();
                                                                                    if (this$length == null
                                                                                       ? other$length == null
                                                                                       : this$length.equals(other$length)) {
                                                                                       Object this$width = this.getWidth();
                                                                                       Object other$width = other.getWidth();
                                                                                       if (this$width == null
                                                                                          ? other$width == null
                                                                                          : this$width.equals(other$width)) {
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
                                                                                                Object this$adjustSerialNumber = this.getAdjustSerialNumber();
                                                                                                Object other$adjustSerialNumber = other.getAdjustSerialNumber();
                                                                                                if (this$adjustSerialNumber == null
                                                                                                   ? other$adjustSerialNumber == null
                                                                                                   : this$adjustSerialNumber.equals(other$adjustSerialNumber)) {
                                                                                                   Object this$workshopIds = this.getWorkshopIds();
                                                                                                   Object other$workshopIds = other.getWorkshopIds();
                                                                                                   return this$workshopIds == null
                                                                                                      ? other$workshopIds == null
                                                                                                      : this$workshopIds.equals(other$workshopIds);
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
      return other instanceof QueryReportAdjustDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $orderSupplyType = this.getOrderSupplyType();
      result = result * 59 + ($orderSupplyType == null ? 43 : $orderSupplyType.hashCode());
      Object $rejectStatus = this.getRejectStatus();
      result = result * 59 + ($rejectStatus == null ? 43 : $rejectStatus.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $projectWarehouseType = this.getProjectWarehouseType();
      result = result * 59 + ($projectWarehouseType == null ? 43 : $projectWarehouseType.hashCode());
      Object $factoryId = this.getFactoryId();
      result = result * 59 + ($factoryId == null ? 43 : $factoryId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $warehouseId = this.getWarehouseId();
      result = result * 59 + ($warehouseId == null ? 43 : $warehouseId.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $inboundWay = this.getInboundWay();
      result = result * 59 + ($inboundWay == null ? 43 : $inboundWay.hashCode());
      Object $inboundTime = this.getInboundTime();
      result = result * 59 + ($inboundTime == null ? 43 : $inboundTime.hashCode());
      Object $inboundSN = this.getInboundSN();
      result = result * 59 + ($inboundSN == null ? 43 : $inboundSN.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $purchaseSN = this.getPurchaseSN();
      result = result * 59 + ($purchaseSN == null ? 43 : $purchaseSN.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $operatorName = this.getOperatorName();
      result = result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $classifyIds = this.getClassifyIds();
      result = result * 59 + ($classifyIds == null ? 43 : $classifyIds.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
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
      Object $adjustSerialNumber = this.getAdjustSerialNumber();
      result = result * 59 + ($adjustSerialNumber == null ? 43 : $adjustSerialNumber.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      return result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
   }

   @Override
   public String toString() {
      return "QueryReportAdjustDTOParam(inboundTime="
         + this.getInboundTime()
         + ", basicClass="
         + this.getBasicClass()
         + ", orderSupplyType="
         + this.getOrderSupplyType()
         + ", rejectStatus="
         + this.getRejectStatus()
         + ", inboundSN="
         + this.getInboundSN()
         + ", projectId="
         + this.getProjectId()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", purchaseSN="
         + this.getPurchaseSN()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", supplierId="
         + this.getSupplierId()
         + ", operatorName="
         + this.getOperatorName()
         + ", projectWarehouseType="
         + this.getProjectWarehouseType()
         + ", factoryId="
         + this.getFactoryId()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", brand="
         + this.getBrand()
         + ", specification="
         + this.getSpecification()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyIds="
         + this.getClassifyIds()
         + ", warehouseId="
         + this.getWarehouseId()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
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
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", adjustSerialNumber="
         + this.getAdjustSerialNumber()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ", inboundWay="
         + this.getInboundWay()
         + ")";
   }

   public QueryReportAdjustDTOParam(
      final List<LocalDateTime> inboundTime,
      final Integer basicClass,
      final Integer orderSupplyType,
      final Integer rejectStatus,
      final String inboundSN,
      final Long projectId,
      final String shipmentNumber,
      final String licensePlate,
      final String purchaseSN,
      final String serialNumber,
      final Long supplierId,
      final String operatorName,
      final Integer projectWarehouseType,
      final Long factoryId,
      final Long branchCompanyId,
      final String brand,
      final String specification,
      final Long classifyId,
      final List<Long> classifyIds,
      final Long warehouseId,
      final String heatNoAndBatchNo,
      final String color,
      final BigDecimal minLength,
      final BigDecimal maxLength,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal theoryThickness,
      final BigDecimal thickness,
      final Integer reviewStatus,
      final String adjustSerialNumber,
      final List<Long> workshopIds,
      final Integer inboundWay
   ) {
      this.inboundTime = inboundTime;
      this.basicClass = basicClass;
      this.orderSupplyType = orderSupplyType;
      this.rejectStatus = rejectStatus;
      this.inboundSN = inboundSN;
      this.projectId = projectId;
      this.shipmentNumber = shipmentNumber;
      this.licensePlate = licensePlate;
      this.purchaseSN = purchaseSN;
      this.serialNumber = serialNumber;
      this.supplierId = supplierId;
      this.operatorName = operatorName;
      this.projectWarehouseType = projectWarehouseType;
      this.factoryId = factoryId;
      this.branchCompanyId = branchCompanyId;
      this.brand = brand;
      this.specification = specification;
      this.classifyId = classifyId;
      this.classifyIds = classifyIds;
      this.warehouseId = warehouseId;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.minLength = minLength;
      this.maxLength = maxLength;
      this.length = length;
      this.width = width;
      this.theoryThickness = theoryThickness;
      this.thickness = thickness;
      this.reviewStatus = reviewStatus;
      this.adjustSerialNumber = adjustSerialNumber;
      this.workshopIds = workshopIds;
      this.inboundWay = inboundWay;
   }

   public QueryReportAdjustDTOParam() {
   }

   public static class QueryReportAdjustDTOParamBuilder {
      private List<LocalDateTime> inboundTime;
      private Integer basicClass;
      private Integer orderSupplyType;
      private Integer rejectStatus;
      private String inboundSN;
      private Long projectId;
      private String shipmentNumber;
      private String licensePlate;
      private String purchaseSN;
      private String serialNumber;
      private Long supplierId;
      private String operatorName;
      private Integer projectWarehouseType;
      private Long factoryId;
      private Long branchCompanyId;
      private String brand;
      private String specification;
      private Long classifyId;
      private List<Long> classifyIds;
      private Long warehouseId;
      private String heatNoAndBatchNo;
      private String color;
      private BigDecimal minLength;
      private BigDecimal maxLength;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal theoryThickness;
      private BigDecimal thickness;
      private Integer reviewStatus;
      private String adjustSerialNumber;
      private List<Long> workshopIds;
      private Integer inboundWay;

      QueryReportAdjustDTOParamBuilder() {
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder inboundTime(final List<LocalDateTime> inboundTime) {
         this.inboundTime = inboundTime;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder orderSupplyType(final Integer orderSupplyType) {
         this.orderSupplyType = orderSupplyType;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder rejectStatus(final Integer rejectStatus) {
         this.rejectStatus = rejectStatus;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder inboundSN(final String inboundSN) {
         this.inboundSN = inboundSN;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder shipmentNumber(final String shipmentNumber) {
         this.shipmentNumber = shipmentNumber;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder purchaseSN(final String purchaseSN) {
         this.purchaseSN = purchaseSN;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder operatorName(final String operatorName) {
         this.operatorName = operatorName;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder projectWarehouseType(final Integer projectWarehouseType) {
         this.projectWarehouseType = projectWarehouseType;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder factoryId(final Long factoryId) {
         this.factoryId = factoryId;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder classifyIds(final List<Long> classifyIds) {
         this.classifyIds = classifyIds;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder warehouseId(final Long warehouseId) {
         this.warehouseId = warehouseId;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder minLength(final BigDecimal minLength) {
         this.minLength = minLength;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder maxLength(final BigDecimal maxLength) {
         this.maxLength = maxLength;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder adjustSerialNumber(final String adjustSerialNumber) {
         this.adjustSerialNumber = adjustSerialNumber;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder workshopIds(final List<Long> workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder inboundWay(final Integer inboundWay) {
         this.inboundWay = inboundWay;
         return this;
      }

      public QueryReportAdjustDTOParam build() {
         return new QueryReportAdjustDTOParam(
            this.inboundTime,
            this.basicClass,
            this.orderSupplyType,
            this.rejectStatus,
            this.inboundSN,
            this.projectId,
            this.shipmentNumber,
            this.licensePlate,
            this.purchaseSN,
            this.serialNumber,
            this.supplierId,
            this.operatorName,
            this.projectWarehouseType,
            this.factoryId,
            this.branchCompanyId,
            this.brand,
            this.specification,
            this.classifyId,
            this.classifyIds,
            this.warehouseId,
            this.heatNoAndBatchNo,
            this.color,
            this.minLength,
            this.maxLength,
            this.length,
            this.width,
            this.theoryThickness,
            this.thickness,
            this.reviewStatus,
            this.adjustSerialNumber,
            this.workshopIds,
            this.inboundWay
         );
      }

      @Override
      public String toString() {
         return "QueryReportAdjustDTOParam.QueryReportAdjustDTOParamBuilder(inboundTime="
            + this.inboundTime
            + ", basicClass="
            + this.basicClass
            + ", orderSupplyType="
            + this.orderSupplyType
            + ", rejectStatus="
            + this.rejectStatus
            + ", inboundSN="
            + this.inboundSN
            + ", projectId="
            + this.projectId
            + ", shipmentNumber="
            + this.shipmentNumber
            + ", licensePlate="
            + this.licensePlate
            + ", purchaseSN="
            + this.purchaseSN
            + ", serialNumber="
            + this.serialNumber
            + ", supplierId="
            + this.supplierId
            + ", operatorName="
            + this.operatorName
            + ", projectWarehouseType="
            + this.projectWarehouseType
            + ", factoryId="
            + this.factoryId
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", brand="
            + this.brand
            + ", specification="
            + this.specification
            + ", classifyId="
            + this.classifyId
            + ", classifyIds="
            + this.classifyIds
            + ", warehouseId="
            + this.warehouseId
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
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
            + ", reviewStatus="
            + this.reviewStatus
            + ", adjustSerialNumber="
            + this.adjustSerialNumber
            + ", workshopIds="
            + this.workshopIds
            + ", inboundWay="
            + this.inboundWay
            + ")";
      }
   }
}
