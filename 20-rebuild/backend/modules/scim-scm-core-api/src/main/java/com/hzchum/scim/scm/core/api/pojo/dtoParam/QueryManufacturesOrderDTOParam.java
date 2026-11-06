package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import java.time.LocalDateTime;
import java.util.List;

public class QueryManufacturesOrderDTOParam {
   private Integer purchaseStatus;
   private Integer settlementStatus;
   private List<LocalDateTime> createTime;
   private String operatorName;
   private Long branchCompanyId;
   private Long supplierId;
   private String serialNumber;

   public Integer getPurchaseStatus() {
      return this.purchaseStatus;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public List<LocalDateTime> getCreateTime() {
      return this.createTime;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public void setPurchaseStatus(final Integer purchaseStatus) {
      this.purchaseStatus = purchaseStatus;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setCreateTime(final List<LocalDateTime> createTime) {
      this.createTime = createTime;
   }

   public void setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryManufacturesOrderDTOParam)) {
         return false;
      }

      QueryManufacturesOrderDTOParam other = (QueryManufacturesOrderDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$purchaseStatus = this.getPurchaseStatus();
      Object other$purchaseStatus = other.getPurchaseStatus();
      if (this$purchaseStatus == null ? other$purchaseStatus == null : this$purchaseStatus.equals(other$purchaseStatus)) {
         Object this$settlementStatus = this.getSettlementStatus();
         Object other$settlementStatus = other.getSettlementStatus();
         if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
            Object this$branchCompanyId = this.getBranchCompanyId();
            Object other$branchCompanyId = other.getBranchCompanyId();
            if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
               Object this$supplierId = this.getSupplierId();
               Object other$supplierId = other.getSupplierId();
               if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                  Object this$createTime = this.getCreateTime();
                  Object other$createTime = other.getCreateTime();
                  if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                     Object this$operatorName = this.getOperatorName();
                     Object other$operatorName = other.getOperatorName();
                     if (this$operatorName == null ? other$operatorName == null : this$operatorName.equals(other$operatorName)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof QueryManufacturesOrderDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $purchaseStatus = this.getPurchaseStatus();
      result = result * 59 + ($purchaseStatus == null ? 43 : $purchaseStatus.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $operatorName = this.getOperatorName();
      result = result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "QueryManufacturesOrderDTOParam(purchaseStatus="
         + this.getPurchaseStatus()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", createTime="
         + this.getCreateTime()
         + ", operatorName="
         + this.getOperatorName()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", supplierId="
         + this.getSupplierId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ")";
   }
}
