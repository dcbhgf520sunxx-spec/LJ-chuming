package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.time.LocalDateTime;
import java.util.List;

public class QueryRejectInboundDTOParam {
   private List<LocalDateTime> createTime;
   private Integer basicClass;
   private String purchaseSN;
   private String serialNumber;
   private Long supplierId;
   private Long projectId;
   private String operatorName;
   private Integer projectWarehouseType;

   public List<LocalDateTime> getCreateTime() {
      return this.createTime;
   }

   public Integer getBasicClass() {
      return this.basicClass;
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

   public Long getProjectId() {
      return this.projectId;
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

   public void setPurchaseSN(final String purchaseSN) {
      this.purchaseSN = purchaseSN;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
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

      if (!(o instanceof QueryRejectInboundDTOParam)) {
         return false;
      }

      QueryRejectInboundDTOParam other = (QueryRejectInboundDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof QueryRejectInboundDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
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
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $operatorName = this.getOperatorName();
      return result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
   }

   @Override
   public String toString() {
      return "QueryRejectInboundDTOParam(createTime="
         + this.getCreateTime()
         + ", basicClass="
         + this.getBasicClass()
         + ", purchaseSN="
         + this.getPurchaseSN()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", supplierId="
         + this.getSupplierId()
         + ", projectId="
         + this.getProjectId()
         + ", operatorName="
         + this.getOperatorName()
         + ", projectWarehouseType="
         + this.getProjectWarehouseType()
         + ")";
   }

   public QueryRejectInboundDTOParam(
      final List<LocalDateTime> createTime,
      final Integer basicClass,
      final String purchaseSN,
      final String serialNumber,
      final Long supplierId,
      final Long projectId,
      final String operatorName,
      final Integer projectWarehouseType
   ) {
      this.createTime = createTime;
      this.basicClass = basicClass;
      this.purchaseSN = purchaseSN;
      this.serialNumber = serialNumber;
      this.supplierId = supplierId;
      this.projectId = projectId;
      this.operatorName = operatorName;
      this.projectWarehouseType = projectWarehouseType;
   }

   public QueryRejectInboundDTOParam() {
   }
}
