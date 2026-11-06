package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.time.LocalDateTime;
import java.util.List;

public class QueryRejectDTOParam {
   private List<LocalDateTime> createTime;
   private Integer basicClass;
   private Integer reviewStatus;
   private Integer projectId;
   private String purchaseSN;
   private String inboundSN;
   private String serialNumber;
   private Long supplierId;
   private String operatorName;
   private Integer projectWarehouseType;

   public List<LocalDateTime> getCreateTime() {
      return this.createTime;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Integer getProjectId() {
      return this.projectId;
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

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public Integer getProjectWarehouseType() {
      return this.projectWarehouseType;
   }

   public void setCreateTime(final List<LocalDateTime> createTime) {
      this.createTime = createTime;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setProjectId(final Integer projectId) {
      this.projectId = projectId;
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

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
   }

   public void setProjectWarehouseType(final Integer projectWarehouseType) {
      this.projectWarehouseType = projectWarehouseType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryRejectDTOParam)) {
         return false;
      }

      QueryRejectDTOParam other = (QueryRejectDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$reviewStatus = this.getReviewStatus();
         Object other$reviewStatus = other.getReviewStatus();
         if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$supplierId = this.getSupplierId();
               Object other$supplierId = other.getSupplierId();
               if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QueryRejectDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
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
      Object $operatorName = this.getOperatorName();
      return result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
   }

   @Override
   public String toString() {
      return "QueryRejectDTOParam(createTime="
         + this.getCreateTime()
         + ", basicClass="
         + this.getBasicClass()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", projectId="
         + this.getProjectId()
         + ", purchaseSN="
         + this.getPurchaseSN()
         + ", inboundSN="
         + this.getInboundSN()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", supplierId="
         + this.getSupplierId()
         + ", operatorName="
         + this.getOperatorName()
         + ", projectWarehouseType="
         + this.getProjectWarehouseType()
         + ")";
   }

   public QueryRejectDTOParam(
      final List<LocalDateTime> createTime,
      final Integer basicClass,
      final Integer reviewStatus,
      final Integer projectId,
      final String purchaseSN,
      final String inboundSN,
      final String serialNumber,
      final Long supplierId,
      final String operatorName,
      final Integer projectWarehouseType
   ) {
      this.createTime = createTime;
      this.basicClass = basicClass;
      this.reviewStatus = reviewStatus;
      this.projectId = projectId;
      this.purchaseSN = purchaseSN;
      this.inboundSN = inboundSN;
      this.serialNumber = serialNumber;
      this.supplierId = supplierId;
      this.operatorName = operatorName;
      this.projectWarehouseType = projectWarehouseType;
   }

   public QueryRejectDTOParam() {
   }
}
