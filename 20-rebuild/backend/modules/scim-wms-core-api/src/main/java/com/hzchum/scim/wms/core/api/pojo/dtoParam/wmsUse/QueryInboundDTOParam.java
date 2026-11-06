package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class QueryInboundDTOParam {
   private Integer basicClass;
   private Integer reviewStatus;
   List<LocalDateTime> createTime;
   private Long supplierId;
   private String purchaseSN;
   private String serialNumber;
   private String operatorName;
   private Integer orderSupplyType;
   private Long projectId;
   private String licensePlate;
   private String shipmentNumber;
   private Integer projectWarehouseType;
   private Integer qualityTestingEnum;
   private List<Integer> rejectStatus;
   private Integer inboundWay;
   @ApiModelProperty(name = "boolPartA", value = "是否甲购 0非甲购  1甲购")
   private Boolean boolPartA;
   @ApiModelProperty(name = "boolNestSurplus", value = "柏楚余料(只有来柏楚拍照的余料和套料剩下的余料此属性才有true)", notes = "柏楚余料")
   private Boolean boolNestSurplus;

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public List<LocalDateTime> getCreateTime() {
      return this.createTime;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getPurchaseSN() {
      return this.purchaseSN;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public Integer getOrderSupplyType() {
      return this.orderSupplyType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public Integer getProjectWarehouseType() {
      return this.projectWarehouseType;
   }

   public Integer getQualityTestingEnum() {
      return this.qualityTestingEnum;
   }

   public List<Integer> getRejectStatus() {
      return this.rejectStatus;
   }

   public Integer getInboundWay() {
      return this.inboundWay;
   }

   public Boolean getBoolPartA() {
      return this.boolPartA;
   }

   public Boolean getBoolNestSurplus() {
      return this.boolNestSurplus;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setCreateTime(final List<LocalDateTime> createTime) {
      this.createTime = createTime;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setPurchaseSN(final String purchaseSN) {
      this.purchaseSN = purchaseSN;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
   }

   public void setOrderSupplyType(final Integer orderSupplyType) {
      this.orderSupplyType = orderSupplyType;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
   }

   public void setProjectWarehouseType(final Integer projectWarehouseType) {
      this.projectWarehouseType = projectWarehouseType;
   }

   public void setQualityTestingEnum(final Integer qualityTestingEnum) {
      this.qualityTestingEnum = qualityTestingEnum;
   }

   public void setRejectStatus(final List<Integer> rejectStatus) {
      this.rejectStatus = rejectStatus;
   }

   public void setInboundWay(final Integer inboundWay) {
      this.inboundWay = inboundWay;
   }

   public void setBoolPartA(final Boolean boolPartA) {
      this.boolPartA = boolPartA;
   }

   public void setBoolNestSurplus(final Boolean boolNestSurplus) {
      this.boolNestSurplus = boolNestSurplus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryInboundDTOParam)) {
         return false;
      }

      QueryInboundDTOParam other = (QueryInboundDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$reviewStatus = this.getReviewStatus();
         Object other$reviewStatus = other.getReviewStatus();
         if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
               Object this$orderSupplyType = this.getOrderSupplyType();
               Object other$orderSupplyType = other.getOrderSupplyType();
               if (this$orderSupplyType == null ? other$orderSupplyType == null : this$orderSupplyType.equals(other$orderSupplyType)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$projectWarehouseType = this.getProjectWarehouseType();
                     Object other$projectWarehouseType = other.getProjectWarehouseType();
                     if (this$projectWarehouseType == null ? other$projectWarehouseType == null : this$projectWarehouseType.equals(other$projectWarehouseType)) {
                        Object this$qualityTestingEnum = this.getQualityTestingEnum();
                        Object other$qualityTestingEnum = other.getQualityTestingEnum();
                        if (this$qualityTestingEnum == null ? other$qualityTestingEnum == null : this$qualityTestingEnum.equals(other$qualityTestingEnum)) {
                           Object this$inboundWay = this.getInboundWay();
                           Object other$inboundWay = other.getInboundWay();
                           if (this$inboundWay == null ? other$inboundWay == null : this$inboundWay.equals(other$inboundWay)) {
                              Object this$boolPartA = this.getBoolPartA();
                              Object other$boolPartA = other.getBoolPartA();
                              if (this$boolPartA == null ? other$boolPartA == null : this$boolPartA.equals(other$boolPartA)) {
                                 Object this$boolNestSurplus = this.getBoolNestSurplus();
                                 Object other$boolNestSurplus = other.getBoolNestSurplus();
                                 if (this$boolNestSurplus == null ? other$boolNestSurplus == null : this$boolNestSurplus.equals(other$boolNestSurplus)) {
                                    Object this$createTime = this.getCreateTime();
                                    Object other$createTime = other.getCreateTime();
                                    if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                       Object this$purchaseSN = this.getPurchaseSN();
                                       Object other$purchaseSN = other.getPurchaseSN();
                                       if (this$purchaseSN == null ? other$purchaseSN == null : this$purchaseSN.equals(other$purchaseSN)) {
                                          Object this$serialNumber = this.getSerialNumber();
                                          Object other$serialNumber = other.getSerialNumber();
                                          if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                             Object this$operatorName = this.getOperatorName();
                                             Object other$operatorName = other.getOperatorName();
                                             if (this$operatorName == null ? other$operatorName == null : this$operatorName.equals(other$operatorName)) {
                                                Object this$licensePlate = this.getLicensePlate();
                                                Object other$licensePlate = other.getLicensePlate();
                                                if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                                   Object this$shipmentNumber = this.getShipmentNumber();
                                                   Object other$shipmentNumber = other.getShipmentNumber();
                                                   if (this$shipmentNumber == null
                                                      ? other$shipmentNumber == null
                                                      : this$shipmentNumber.equals(other$shipmentNumber)) {
                                                      Object this$rejectStatus = this.getRejectStatus();
                                                      Object other$rejectStatus = other.getRejectStatus();
                                                      return this$rejectStatus == null
                                                         ? other$rejectStatus == null
                                                         : this$rejectStatus.equals(other$rejectStatus);
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
      return other instanceof QueryInboundDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $orderSupplyType = this.getOrderSupplyType();
      result = result * 59 + ($orderSupplyType == null ? 43 : $orderSupplyType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $projectWarehouseType = this.getProjectWarehouseType();
      result = result * 59 + ($projectWarehouseType == null ? 43 : $projectWarehouseType.hashCode());
      Object $qualityTestingEnum = this.getQualityTestingEnum();
      result = result * 59 + ($qualityTestingEnum == null ? 43 : $qualityTestingEnum.hashCode());
      Object $inboundWay = this.getInboundWay();
      result = result * 59 + ($inboundWay == null ? 43 : $inboundWay.hashCode());
      Object $boolPartA = this.getBoolPartA();
      result = result * 59 + ($boolPartA == null ? 43 : $boolPartA.hashCode());
      Object $boolNestSurplus = this.getBoolNestSurplus();
      result = result * 59 + ($boolNestSurplus == null ? 43 : $boolNestSurplus.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $purchaseSN = this.getPurchaseSN();
      result = result * 59 + ($purchaseSN == null ? 43 : $purchaseSN.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $operatorName = this.getOperatorName();
      result = result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $rejectStatus = this.getRejectStatus();
      return result * 59 + ($rejectStatus == null ? 43 : $rejectStatus.hashCode());
   }

   @Override
   public String toString() {
      return "QueryInboundDTOParam(basicClass="
         + this.getBasicClass()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", createTime="
         + this.getCreateTime()
         + ", supplierId="
         + this.getSupplierId()
         + ", purchaseSN="
         + this.getPurchaseSN()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", operatorName="
         + this.getOperatorName()
         + ", orderSupplyType="
         + this.getOrderSupplyType()
         + ", projectId="
         + this.getProjectId()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", projectWarehouseType="
         + this.getProjectWarehouseType()
         + ", qualityTestingEnum="
         + this.getQualityTestingEnum()
         + ", rejectStatus="
         + this.getRejectStatus()
         + ", inboundWay="
         + this.getInboundWay()
         + ", boolPartA="
         + this.getBoolPartA()
         + ", boolNestSurplus="
         + this.getBoolNestSurplus()
         + ")";
   }
}
