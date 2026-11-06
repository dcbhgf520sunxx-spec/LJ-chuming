package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import java.time.LocalDateTime;
import java.util.List;

public class QueryLogisticsOrderDTOParam {
   private Integer purchaseType;
   private List<LocalDateTime> createTime;
   private Long supplierId;
   private String purchaseSN;
   private String inboundSN;
   private String serialNumber;
   private String licensePlate;
   private String shipmentNumber;
   private Long projectId;
   private String operatorName;
   private Integer logisticsTransportType;
   private Integer projectWarehouseType;

   public Integer getPurchaseType() {
      return this.purchaseType;
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

   public String getInboundSN() {
      return this.inboundSN;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public Integer getLogisticsTransportType() {
      return this.logisticsTransportType;
   }

   public Integer getProjectWarehouseType() {
      return this.projectWarehouseType;
   }

   public void setPurchaseType(final Integer purchaseType) {
      this.purchaseType = purchaseType;
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

   public void setInboundSN(final String inboundSN) {
      this.inboundSN = inboundSN;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
   }

   public void setLogisticsTransportType(final Integer logisticsTransportType) {
      this.logisticsTransportType = logisticsTransportType;
   }

   public void setProjectWarehouseType(final Integer projectWarehouseType) {
      this.projectWarehouseType = projectWarehouseType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryLogisticsOrderDTOParam)) {
         return false;
      }

      QueryLogisticsOrderDTOParam other = (QueryLogisticsOrderDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$purchaseType = this.getPurchaseType();
      Object other$purchaseType = other.getPurchaseType();
      if (this$purchaseType == null ? other$purchaseType == null : this$purchaseType.equals(other$purchaseType)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$logisticsTransportType = this.getLogisticsTransportType();
               Object other$logisticsTransportType = other.getLogisticsTransportType();
               if (this$logisticsTransportType == null
                  ? other$logisticsTransportType == null
                  : this$logisticsTransportType.equals(other$logisticsTransportType)) {
                  Object this$projectWarehouseType = this.getProjectWarehouseType();
                  Object other$projectWarehouseType = other.getProjectWarehouseType();
                  if (this$projectWarehouseType == null ? other$projectWarehouseType == null : this$projectWarehouseType.equals(other$projectWarehouseType)) {
                     Object this$createTime = this.getCreateTime();
                     Object other$createTime = other.getCreateTime();
                     if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                        Object this$purchaseSN = this.getPurchaseSN();
                        Object other$purchaseSN = other.getPurchaseSN();
                        if (this$purchaseSN == null ? other$purchaseSN == null : this$purchaseSN.equals(other$purchaseSN)) {
                           Object this$inboundSN = this.getInboundSN();
                           Object other$inboundSN = other.getInboundSN();
                           if (this$inboundSN == null ? other$inboundSN == null : this$inboundSN.equals(other$inboundSN)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$licensePlate = this.getLicensePlate();
                                 Object other$licensePlate = other.getLicensePlate();
                                 if (this$licensePlate == null ? other$licensePlate == null : this$licensePlate.equals(other$licensePlate)) {
                                    Object this$shipmentNumber = this.getShipmentNumber();
                                    Object other$shipmentNumber = other.getShipmentNumber();
                                    if (this$shipmentNumber == null ? other$shipmentNumber == null : this$shipmentNumber.equals(other$shipmentNumber)) {
                                       Object this$operatorName = this.getOperatorName();
                                       Object other$operatorName = other.getOperatorName();
                                       return this$operatorName == null ? other$operatorName == null : this$operatorName.equals(other$operatorName);
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
      return other instanceof QueryLogisticsOrderDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $purchaseType = this.getPurchaseType();
      result = result * 59 + ($purchaseType == null ? 43 : $purchaseType.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $logisticsTransportType = this.getLogisticsTransportType();
      result = result * 59 + ($logisticsTransportType == null ? 43 : $logisticsTransportType.hashCode());
      Object $projectWarehouseType = this.getProjectWarehouseType();
      result = result * 59 + ($projectWarehouseType == null ? 43 : $projectWarehouseType.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $purchaseSN = this.getPurchaseSN();
      result = result * 59 + ($purchaseSN == null ? 43 : $purchaseSN.hashCode());
      Object $inboundSN = this.getInboundSN();
      result = result * 59 + ($inboundSN == null ? 43 : $inboundSN.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $licensePlate = this.getLicensePlate();
      result = result * 59 + ($licensePlate == null ? 43 : $licensePlate.hashCode());
      Object $shipmentNumber = this.getShipmentNumber();
      result = result * 59 + ($shipmentNumber == null ? 43 : $shipmentNumber.hashCode());
      Object $operatorName = this.getOperatorName();
      return result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
   }

   @Override
   public String toString() {
      return "QueryLogisticsOrderDTOParam(purchaseType="
         + this.getPurchaseType()
         + ", createTime="
         + this.getCreateTime()
         + ", supplierId="
         + this.getSupplierId()
         + ", purchaseSN="
         + this.getPurchaseSN()
         + ", inboundSN="
         + this.getInboundSN()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", projectId="
         + this.getProjectId()
         + ", operatorName="
         + this.getOperatorName()
         + ", logisticsTransportType="
         + this.getLogisticsTransportType()
         + ", projectWarehouseType="
         + this.getProjectWarehouseType()
         + ")";
   }

   public QueryLogisticsOrderDTOParam(
      final Integer purchaseType,
      final List<LocalDateTime> createTime,
      final Long supplierId,
      final String purchaseSN,
      final String inboundSN,
      final String serialNumber,
      final String licensePlate,
      final String shipmentNumber,
      final Long projectId,
      final String operatorName,
      final Integer logisticsTransportType,
      final Integer projectWarehouseType
   ) {
      this.purchaseType = purchaseType;
      this.createTime = createTime;
      this.supplierId = supplierId;
      this.purchaseSN = purchaseSN;
      this.inboundSN = inboundSN;
      this.serialNumber = serialNumber;
      this.licensePlate = licensePlate;
      this.shipmentNumber = shipmentNumber;
      this.projectId = projectId;
      this.operatorName = operatorName;
      this.logisticsTransportType = logisticsTransportType;
      this.projectWarehouseType = projectWarehouseType;
   }

   public QueryLogisticsOrderDTOParam() {
   }
}
