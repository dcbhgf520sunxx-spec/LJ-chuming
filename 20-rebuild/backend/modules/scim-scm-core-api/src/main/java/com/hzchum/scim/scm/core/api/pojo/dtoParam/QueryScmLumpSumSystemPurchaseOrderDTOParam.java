package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import java.time.LocalDateTime;
import java.util.List;

public class QueryScmLumpSumSystemPurchaseOrderDTOParam {
   private List<LocalDateTime> createTime;
   private Integer settlementStatus;
   private Integer purchaseStatus;
   private Integer basicClass;
   private String serialNumber;
   private Long projectId;
   private Long supplierId;
   private String projectManagerName;
   private String branchCompanyId;
   private String applicantName;
   private Integer dataStatus;
   private Long projectManagerId;

   public List<LocalDateTime> getCreateTime() {
      return this.createTime;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public Integer getPurchaseStatus() {
      return this.purchaseStatus;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public String getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public Integer getDataStatus() {
      return this.dataStatus;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public void setCreateTime(final List<LocalDateTime> createTime) {
      this.createTime = createTime;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setPurchaseStatus(final Integer purchaseStatus) {
      this.purchaseStatus = purchaseStatus;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setBranchCompanyId(final String branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setDataStatus(final Integer dataStatus) {
      this.dataStatus = dataStatus;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryScmLumpSumSystemPurchaseOrderDTOParam)) {
         return false;
      }

      QueryScmLumpSumSystemPurchaseOrderDTOParam other = (QueryScmLumpSumSystemPurchaseOrderDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$settlementStatus = this.getSettlementStatus();
      Object other$settlementStatus = other.getSettlementStatus();
      if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
         Object this$purchaseStatus = this.getPurchaseStatus();
         Object other$purchaseStatus = other.getPurchaseStatus();
         if (this$purchaseStatus == null ? other$purchaseStatus == null : this$purchaseStatus.equals(other$purchaseStatus)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$dataStatus = this.getDataStatus();
                     Object other$dataStatus = other.getDataStatus();
                     if (this$dataStatus == null ? other$dataStatus == null : this$dataStatus.equals(other$dataStatus)) {
                        Object this$projectManagerId = this.getProjectManagerId();
                        Object other$projectManagerId = other.getProjectManagerId();
                        if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                           Object this$createTime = this.getCreateTime();
                           Object other$createTime = other.getCreateTime();
                           if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$projectManagerName = this.getProjectManagerName();
                                 Object other$projectManagerName = other.getProjectManagerName();
                                 if (this$projectManagerName == null
                                    ? other$projectManagerName == null
                                    : this$projectManagerName.equals(other$projectManagerName)) {
                                    Object this$branchCompanyId = this.getBranchCompanyId();
                                    Object other$branchCompanyId = other.getBranchCompanyId();
                                    if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                                       Object this$applicantName = this.getApplicantName();
                                       Object other$applicantName = other.getApplicantName();
                                       return this$applicantName == null ? other$applicantName == null : this$applicantName.equals(other$applicantName);
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
      return other instanceof QueryScmLumpSumSystemPurchaseOrderDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $purchaseStatus = this.getPurchaseStatus();
      result = result * 59 + ($purchaseStatus == null ? 43 : $purchaseStatus.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $dataStatus = this.getDataStatus();
      result = result * 59 + ($dataStatus == null ? 43 : $dataStatus.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $applicantName = this.getApplicantName();
      return result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
   }

   @Override
   public String toString() {
      return "QueryScmLumpSumSystemPurchaseOrderDTOParam(createTime="
         + this.getCreateTime()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", purchaseStatus="
         + this.getPurchaseStatus()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", supplierId="
         + this.getSupplierId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", applicantName="
         + this.getApplicantName()
         + ", dataStatus="
         + this.getDataStatus()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ")";
   }
}
