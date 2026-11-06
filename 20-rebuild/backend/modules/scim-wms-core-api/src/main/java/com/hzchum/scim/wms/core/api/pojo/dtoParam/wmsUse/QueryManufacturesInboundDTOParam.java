package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.time.LocalDateTime;
import java.util.List;

public class QueryManufacturesInboundDTOParam {
   private Integer basicClass;
   private Integer reviewStatus;
   List<LocalDateTime> createTime;
   private Long supplierId;
   private String purchaseSN;
   private String serialNumber;
   private String operatorName;
   private Long projectId;
   private String licensePlate;
   private String shipmentNumber;
   private Long monomerId;
   private List<Long> areaIds;

   public static QueryManufacturesInboundDTOParam.QueryManufacturesInboundDTOParamBuilder builder() {
      return new QueryManufacturesInboundDTOParam.QueryManufacturesInboundDTOParamBuilder();
   }

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

   public Long getProjectId() {
      return this.projectId;
   }

   public String getLicensePlate() {
      return this.licensePlate;
   }

   public String getShipmentNumber() {
      return this.shipmentNumber;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public List<Long> getAreaIds() {
      return this.areaIds;
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

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setLicensePlate(final String licensePlate) {
      this.licensePlate = licensePlate;
   }

   public void setShipmentNumber(final String shipmentNumber) {
      this.shipmentNumber = shipmentNumber;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaIds(final List<Long> areaIds) {
      this.areaIds = areaIds;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryManufacturesInboundDTOParam)) {
         return false;
      }

      QueryManufacturesInboundDTOParam other = (QueryManufacturesInboundDTOParam)o;
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
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
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
                                    if (this$shipmentNumber == null ? other$shipmentNumber == null : this$shipmentNumber.equals(other$shipmentNumber)) {
                                       Object this$areaIds = this.getAreaIds();
                                       Object other$areaIds = other.getAreaIds();
                                       return this$areaIds == null ? other$areaIds == null : this$areaIds.equals(other$areaIds);
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
      return other instanceof QueryManufacturesInboundDTOParam;
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
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
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
      Object $areaIds = this.getAreaIds();
      return result * 59 + ($areaIds == null ? 43 : $areaIds.hashCode());
   }

   @Override
   public String toString() {
      return "QueryManufacturesInboundDTOParam(basicClass="
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
         + ", projectId="
         + this.getProjectId()
         + ", licensePlate="
         + this.getLicensePlate()
         + ", shipmentNumber="
         + this.getShipmentNumber()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaIds="
         + this.getAreaIds()
         + ")";
   }

   public QueryManufacturesInboundDTOParam(
      final Integer basicClass,
      final Integer reviewStatus,
      final List<LocalDateTime> createTime,
      final Long supplierId,
      final String purchaseSN,
      final String serialNumber,
      final String operatorName,
      final Long projectId,
      final String licensePlate,
      final String shipmentNumber,
      final Long monomerId,
      final List<Long> areaIds
   ) {
      this.basicClass = basicClass;
      this.reviewStatus = reviewStatus;
      this.createTime = createTime;
      this.supplierId = supplierId;
      this.purchaseSN = purchaseSN;
      this.serialNumber = serialNumber;
      this.operatorName = operatorName;
      this.projectId = projectId;
      this.licensePlate = licensePlate;
      this.shipmentNumber = shipmentNumber;
      this.monomerId = monomerId;
      this.areaIds = areaIds;
   }

   public QueryManufacturesInboundDTOParam() {
   }

   public static class QueryManufacturesInboundDTOParamBuilder {
      private Integer basicClass;
      private Integer reviewStatus;
      private List<LocalDateTime> createTime;
      private Long supplierId;
      private String purchaseSN;
      private String serialNumber;
      private String operatorName;
      private Long projectId;
      private String licensePlate;
      private String shipmentNumber;
      private Long monomerId;
      private List<Long> areaIds;

      QueryManufacturesInboundDTOParamBuilder() {
      }

      public QueryManufacturesInboundDTOParam.QueryManufacturesInboundDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryManufacturesInboundDTOParam.QueryManufacturesInboundDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public QueryManufacturesInboundDTOParam.QueryManufacturesInboundDTOParamBuilder createTime(final List<LocalDateTime> createTime) {
         this.createTime = createTime;
         return this;
      }

      public QueryManufacturesInboundDTOParam.QueryManufacturesInboundDTOParamBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public QueryManufacturesInboundDTOParam.QueryManufacturesInboundDTOParamBuilder purchaseSN(final String purchaseSN) {
         this.purchaseSN = purchaseSN;
         return this;
      }

      public QueryManufacturesInboundDTOParam.QueryManufacturesInboundDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public QueryManufacturesInboundDTOParam.QueryManufacturesInboundDTOParamBuilder operatorName(final String operatorName) {
         this.operatorName = operatorName;
         return this;
      }

      public QueryManufacturesInboundDTOParam.QueryManufacturesInboundDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryManufacturesInboundDTOParam.QueryManufacturesInboundDTOParamBuilder licensePlate(final String licensePlate) {
         this.licensePlate = licensePlate;
         return this;
      }

      public QueryManufacturesInboundDTOParam.QueryManufacturesInboundDTOParamBuilder shipmentNumber(final String shipmentNumber) {
         this.shipmentNumber = shipmentNumber;
         return this;
      }

      public QueryManufacturesInboundDTOParam.QueryManufacturesInboundDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public QueryManufacturesInboundDTOParam.QueryManufacturesInboundDTOParamBuilder areaIds(final List<Long> areaIds) {
         this.areaIds = areaIds;
         return this;
      }

      public QueryManufacturesInboundDTOParam build() {
         return new QueryManufacturesInboundDTOParam(
            this.basicClass,
            this.reviewStatus,
            this.createTime,
            this.supplierId,
            this.purchaseSN,
            this.serialNumber,
            this.operatorName,
            this.projectId,
            this.licensePlate,
            this.shipmentNumber,
            this.monomerId,
            this.areaIds
         );
      }

      @Override
      public String toString() {
         return "QueryManufacturesInboundDTOParam.QueryManufacturesInboundDTOParamBuilder(basicClass="
            + this.basicClass
            + ", reviewStatus="
            + this.reviewStatus
            + ", createTime="
            + this.createTime
            + ", supplierId="
            + this.supplierId
            + ", purchaseSN="
            + this.purchaseSN
            + ", serialNumber="
            + this.serialNumber
            + ", operatorName="
            + this.operatorName
            + ", projectId="
            + this.projectId
            + ", licensePlate="
            + this.licensePlate
            + ", shipmentNumber="
            + this.shipmentNumber
            + ", monomerId="
            + this.monomerId
            + ", areaIds="
            + this.areaIds
            + ")";
      }
   }
}
