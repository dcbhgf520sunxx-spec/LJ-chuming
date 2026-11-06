package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsReport;

import java.time.LocalDateTime;
import java.util.List;

public class QueryRejectDTOParam {
   private List<LocalDateTime> createTime;
   private Integer basicClass;
   private Integer reviewStatus;
   private String purchaseSN;
   private String inboundSN;
   private String serialNumber;
   private Long supplierId;
   private String operatorName;
   private Long projectId;
   private Integer projectWarehouseType;
   private List<Long> workshopIds;

   public static QueryRejectDTOParam.QueryRejectDTOParamBuilder builder() {
      return new QueryRejectDTOParam.QueryRejectDTOParamBuilder();
   }

   public List<LocalDateTime> getCreateTime() {
      return this.createTime;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
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

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getProjectWarehouseType() {
      return this.projectWarehouseType;
   }

   public List<Long> getWorkshopIds() {
      return this.workshopIds;
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

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectWarehouseType(final Integer projectWarehouseType) {
      this.projectWarehouseType = projectWarehouseType;
   }

   public void setWorkshopIds(final List<Long> workshopIds) {
      this.workshopIds = workshopIds;
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
            Object this$supplierId = this.getSupplierId();
            Object other$supplierId = other.getSupplierId();
            if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
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
                                 if (this$operatorName == null ? other$operatorName == null : this$operatorName.equals(other$operatorName)) {
                                    Object this$workshopIds = this.getWorkshopIds();
                                    Object other$workshopIds = other.getWorkshopIds();
                                    return this$workshopIds == null ? other$workshopIds == null : this$workshopIds.equals(other$workshopIds);
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
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
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
      result = result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
      Object $workshopIds = this.getWorkshopIds();
      return result * 59 + ($workshopIds == null ? 43 : $workshopIds.hashCode());
   }

   @Override
   public String toString() {
      return "QueryRejectDTOParam(createTime="
         + this.getCreateTime()
         + ", basicClass="
         + this.getBasicClass()
         + ", reviewStatus="
         + this.getReviewStatus()
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
         + ", projectId="
         + this.getProjectId()
         + ", projectWarehouseType="
         + this.getProjectWarehouseType()
         + ", workshopIds="
         + this.getWorkshopIds()
         + ")";
   }

   public QueryRejectDTOParam(
      final List<LocalDateTime> createTime,
      final Integer basicClass,
      final Integer reviewStatus,
      final String purchaseSN,
      final String inboundSN,
      final String serialNumber,
      final Long supplierId,
      final String operatorName,
      final Long projectId,
      final Integer projectWarehouseType,
      final List<Long> workshopIds
   ) {
      this.createTime = createTime;
      this.basicClass = basicClass;
      this.reviewStatus = reviewStatus;
      this.purchaseSN = purchaseSN;
      this.inboundSN = inboundSN;
      this.serialNumber = serialNumber;
      this.supplierId = supplierId;
      this.operatorName = operatorName;
      this.projectId = projectId;
      this.projectWarehouseType = projectWarehouseType;
      this.workshopIds = workshopIds;
   }

   public QueryRejectDTOParam() {
   }

   public static class QueryRejectDTOParamBuilder {
      private List<LocalDateTime> createTime;
      private Integer basicClass;
      private Integer reviewStatus;
      private String purchaseSN;
      private String inboundSN;
      private String serialNumber;
      private Long supplierId;
      private String operatorName;
      private Long projectId;
      private Integer projectWarehouseType;
      private List<Long> workshopIds;

      QueryRejectDTOParamBuilder() {
      }

      public QueryRejectDTOParam.QueryRejectDTOParamBuilder createTime(final List<LocalDateTime> createTime) {
         this.createTime = createTime;
         return this;
      }

      public QueryRejectDTOParam.QueryRejectDTOParamBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public QueryRejectDTOParam.QueryRejectDTOParamBuilder reviewStatus(final Integer reviewStatus) {
         this.reviewStatus = reviewStatus;
         return this;
      }

      public QueryRejectDTOParam.QueryRejectDTOParamBuilder purchaseSN(final String purchaseSN) {
         this.purchaseSN = purchaseSN;
         return this;
      }

      public QueryRejectDTOParam.QueryRejectDTOParamBuilder inboundSN(final String inboundSN) {
         this.inboundSN = inboundSN;
         return this;
      }

      public QueryRejectDTOParam.QueryRejectDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public QueryRejectDTOParam.QueryRejectDTOParamBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public QueryRejectDTOParam.QueryRejectDTOParamBuilder operatorName(final String operatorName) {
         this.operatorName = operatorName;
         return this;
      }

      public QueryRejectDTOParam.QueryRejectDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public QueryRejectDTOParam.QueryRejectDTOParamBuilder projectWarehouseType(final Integer projectWarehouseType) {
         this.projectWarehouseType = projectWarehouseType;
         return this;
      }

      public QueryRejectDTOParam.QueryRejectDTOParamBuilder workshopIds(final List<Long> workshopIds) {
         this.workshopIds = workshopIds;
         return this;
      }

      public QueryRejectDTOParam build() {
         return new QueryRejectDTOParam(
            this.createTime,
            this.basicClass,
            this.reviewStatus,
            this.purchaseSN,
            this.inboundSN,
            this.serialNumber,
            this.supplierId,
            this.operatorName,
            this.projectId,
            this.projectWarehouseType,
            this.workshopIds
         );
      }

      @Override
      public String toString() {
         return "QueryRejectDTOParam.QueryRejectDTOParamBuilder(createTime="
            + this.createTime
            + ", basicClass="
            + this.basicClass
            + ", reviewStatus="
            + this.reviewStatus
            + ", purchaseSN="
            + this.purchaseSN
            + ", inboundSN="
            + this.inboundSN
            + ", serialNumber="
            + this.serialNumber
            + ", supplierId="
            + this.supplierId
            + ", operatorName="
            + this.operatorName
            + ", projectId="
            + this.projectId
            + ", projectWarehouseType="
            + this.projectWarehouseType
            + ", workshopIds="
            + this.workshopIds
            + ")";
      }
   }
}
