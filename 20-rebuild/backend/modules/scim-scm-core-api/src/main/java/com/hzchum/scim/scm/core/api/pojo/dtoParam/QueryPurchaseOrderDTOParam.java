package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class QueryPurchaseOrderDTOParam {
   private List<LocalDateTime> createTime;
   private Integer basicClass;
   private String applicantName;
   private String serialNumber;
   private Integer purchaseStatus;
   private Integer purchaseType;
   private Integer materialType;
   private Integer settlementStatus;
   private Long projectId;
   private Long supplierId;
   private String supplierName;
   private String operatorName;
   private Long branchCompanyId;
   private Integer level;
   private Integer reviewStatus;
   private Boolean boolAnnual;
   private Integer dataStatus;
   private String projectAttribute;
   private List<String> projectAttributes;
   private Long projectManagerId;
   @ApiModelProperty("目的属性 1直发工地 2直发工厂")
   private Integer orderPlace;
   private String projectManagerName;
   private Long workshopId;
   private Boolean boolDetail;
   private List<BigDecimal> purchaseAmount;

   public List<LocalDateTime> getCreateTime() {
      return this.createTime;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getPurchaseStatus() {
      return this.purchaseStatus;
   }

   public Integer getPurchaseType() {
      return this.purchaseType;
   }

   public Integer getMaterialType() {
      return this.materialType;
   }

   public Integer getSettlementStatus() {
      return this.settlementStatus;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public String getOperatorName() {
      return this.operatorName;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Integer getLevel() {
      return this.level;
   }

   public Integer getReviewStatus() {
      return this.reviewStatus;
   }

   public Boolean getBoolAnnual() {
      return this.boolAnnual;
   }

   public Integer getDataStatus() {
      return this.dataStatus;
   }

   public String getProjectAttribute() {
      return this.projectAttribute;
   }

   public List<String> getProjectAttributes() {
      return this.projectAttributes;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public Integer getOrderPlace() {
      return this.orderPlace;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Boolean getBoolDetail() {
      return this.boolDetail;
   }

   public List<BigDecimal> getPurchaseAmount() {
      return this.purchaseAmount;
   }

   public void setCreateTime(final List<LocalDateTime> createTime) {
      this.createTime = createTime;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPurchaseStatus(final Integer purchaseStatus) {
      this.purchaseStatus = purchaseStatus;
   }

   public void setPurchaseType(final Integer purchaseType) {
      this.purchaseType = purchaseType;
   }

   public void setMaterialType(final Integer materialType) {
      this.materialType = materialType;
   }

   public void setSettlementStatus(final Integer settlementStatus) {
      this.settlementStatus = settlementStatus;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setOperatorName(final String operatorName) {
      this.operatorName = operatorName;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   public void setReviewStatus(final Integer reviewStatus) {
      this.reviewStatus = reviewStatus;
   }

   public void setBoolAnnual(final Boolean boolAnnual) {
      this.boolAnnual = boolAnnual;
   }

   public void setDataStatus(final Integer dataStatus) {
      this.dataStatus = dataStatus;
   }

   public void setProjectAttribute(final String projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setProjectAttributes(final List<String> projectAttributes) {
      this.projectAttributes = projectAttributes;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setOrderPlace(final Integer orderPlace) {
      this.orderPlace = orderPlace;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setBoolDetail(final Boolean boolDetail) {
      this.boolDetail = boolDetail;
   }

   public void setPurchaseAmount(final List<BigDecimal> purchaseAmount) {
      this.purchaseAmount = purchaseAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryPurchaseOrderDTOParam)) {
         return false;
      }

      QueryPurchaseOrderDTOParam other = (QueryPurchaseOrderDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$purchaseStatus = this.getPurchaseStatus();
         Object other$purchaseStatus = other.getPurchaseStatus();
         if (this$purchaseStatus == null ? other$purchaseStatus == null : this$purchaseStatus.equals(other$purchaseStatus)) {
            Object this$purchaseType = this.getPurchaseType();
            Object other$purchaseType = other.getPurchaseType();
            if (this$purchaseType == null ? other$purchaseType == null : this$purchaseType.equals(other$purchaseType)) {
               Object this$materialType = this.getMaterialType();
               Object other$materialType = other.getMaterialType();
               if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
                  Object this$settlementStatus = this.getSettlementStatus();
                  Object other$settlementStatus = other.getSettlementStatus();
                  if (this$settlementStatus == null ? other$settlementStatus == null : this$settlementStatus.equals(other$settlementStatus)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$supplierId = this.getSupplierId();
                        Object other$supplierId = other.getSupplierId();
                        if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                           Object this$branchCompanyId = this.getBranchCompanyId();
                           Object other$branchCompanyId = other.getBranchCompanyId();
                           if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                              Object this$level = this.getLevel();
                              Object other$level = other.getLevel();
                              if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                                 Object this$reviewStatus = this.getReviewStatus();
                                 Object other$reviewStatus = other.getReviewStatus();
                                 if (this$reviewStatus == null ? other$reviewStatus == null : this$reviewStatus.equals(other$reviewStatus)) {
                                    Object this$boolAnnual = this.getBoolAnnual();
                                    Object other$boolAnnual = other.getBoolAnnual();
                                    if (this$boolAnnual == null ? other$boolAnnual == null : this$boolAnnual.equals(other$boolAnnual)) {
                                       Object this$dataStatus = this.getDataStatus();
                                       Object other$dataStatus = other.getDataStatus();
                                       if (this$dataStatus == null ? other$dataStatus == null : this$dataStatus.equals(other$dataStatus)) {
                                          Object this$projectManagerId = this.getProjectManagerId();
                                          Object other$projectManagerId = other.getProjectManagerId();
                                          if (this$projectManagerId == null
                                             ? other$projectManagerId == null
                                             : this$projectManagerId.equals(other$projectManagerId)) {
                                             Object this$orderPlace = this.getOrderPlace();
                                             Object other$orderPlace = other.getOrderPlace();
                                             if (this$orderPlace == null ? other$orderPlace == null : this$orderPlace.equals(other$orderPlace)) {
                                                Object this$workshopId = this.getWorkshopId();
                                                Object other$workshopId = other.getWorkshopId();
                                                if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
                                                   Object this$boolDetail = this.getBoolDetail();
                                                   Object other$boolDetail = other.getBoolDetail();
                                                   if (this$boolDetail == null ? other$boolDetail == null : this$boolDetail.equals(other$boolDetail)) {
                                                      Object this$createTime = this.getCreateTime();
                                                      Object other$createTime = other.getCreateTime();
                                                      if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                                         Object this$applicantName = this.getApplicantName();
                                                         Object other$applicantName = other.getApplicantName();
                                                         if (this$applicantName == null
                                                            ? other$applicantName == null
                                                            : this$applicantName.equals(other$applicantName)) {
                                                            Object this$serialNumber = this.getSerialNumber();
                                                            Object other$serialNumber = other.getSerialNumber();
                                                            if (this$serialNumber == null
                                                               ? other$serialNumber == null
                                                               : this$serialNumber.equals(other$serialNumber)) {
                                                               Object this$supplierName = this.getSupplierName();
                                                               Object other$supplierName = other.getSupplierName();
                                                               if (this$supplierName == null
                                                                  ? other$supplierName == null
                                                                  : this$supplierName.equals(other$supplierName)) {
                                                                  Object this$operatorName = this.getOperatorName();
                                                                  Object other$operatorName = other.getOperatorName();
                                                                  if (this$operatorName == null
                                                                     ? other$operatorName == null
                                                                     : this$operatorName.equals(other$operatorName)) {
                                                                     Object this$projectAttribute = this.getProjectAttribute();
                                                                     Object other$projectAttribute = other.getProjectAttribute();
                                                                     if (this$projectAttribute == null
                                                                        ? other$projectAttribute == null
                                                                        : this$projectAttribute.equals(other$projectAttribute)) {
                                                                        Object this$projectAttributes = this.getProjectAttributes();
                                                                        Object other$projectAttributes = other.getProjectAttributes();
                                                                        if (this$projectAttributes == null
                                                                           ? other$projectAttributes == null
                                                                           : this$projectAttributes.equals(other$projectAttributes)) {
                                                                           Object this$projectManagerName = this.getProjectManagerName();
                                                                           Object other$projectManagerName = other.getProjectManagerName();
                                                                           if (this$projectManagerName == null
                                                                              ? other$projectManagerName == null
                                                                              : this$projectManagerName.equals(other$projectManagerName)) {
                                                                              Object this$purchaseAmount = this.getPurchaseAmount();
                                                                              Object other$purchaseAmount = other.getPurchaseAmount();
                                                                              return this$purchaseAmount == null
                                                                                 ? other$purchaseAmount == null
                                                                                 : this$purchaseAmount.equals(other$purchaseAmount);
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
      return other instanceof QueryPurchaseOrderDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $purchaseStatus = this.getPurchaseStatus();
      result = result * 59 + ($purchaseStatus == null ? 43 : $purchaseStatus.hashCode());
      Object $purchaseType = this.getPurchaseType();
      result = result * 59 + ($purchaseType == null ? 43 : $purchaseType.hashCode());
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $settlementStatus = this.getSettlementStatus();
      result = result * 59 + ($settlementStatus == null ? 43 : $settlementStatus.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $reviewStatus = this.getReviewStatus();
      result = result * 59 + ($reviewStatus == null ? 43 : $reviewStatus.hashCode());
      Object $boolAnnual = this.getBoolAnnual();
      result = result * 59 + ($boolAnnual == null ? 43 : $boolAnnual.hashCode());
      Object $dataStatus = this.getDataStatus();
      result = result * 59 + ($dataStatus == null ? 43 : $dataStatus.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $orderPlace = this.getOrderPlace();
      result = result * 59 + ($orderPlace == null ? 43 : $orderPlace.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $boolDetail = this.getBoolDetail();
      result = result * 59 + ($boolDetail == null ? 43 : $boolDetail.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $operatorName = this.getOperatorName();
      result = result * 59 + ($operatorName == null ? 43 : $operatorName.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $projectAttributes = this.getProjectAttributes();
      result = result * 59 + ($projectAttributes == null ? 43 : $projectAttributes.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $purchaseAmount = this.getPurchaseAmount();
      return result * 59 + ($purchaseAmount == null ? 43 : $purchaseAmount.hashCode());
   }

   @Override
   public String toString() {
      return "QueryPurchaseOrderDTOParam(createTime="
         + this.getCreateTime()
         + ", basicClass="
         + this.getBasicClass()
         + ", applicantName="
         + this.getApplicantName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", purchaseStatus="
         + this.getPurchaseStatus()
         + ", purchaseType="
         + this.getPurchaseType()
         + ", materialType="
         + this.getMaterialType()
         + ", settlementStatus="
         + this.getSettlementStatus()
         + ", projectId="
         + this.getProjectId()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", operatorName="
         + this.getOperatorName()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", level="
         + this.getLevel()
         + ", reviewStatus="
         + this.getReviewStatus()
         + ", boolAnnual="
         + this.getBoolAnnual()
         + ", dataStatus="
         + this.getDataStatus()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", projectAttributes="
         + this.getProjectAttributes()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", orderPlace="
         + this.getOrderPlace()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", workshopId="
         + this.getWorkshopId()
         + ", boolDetail="
         + this.getBoolDetail()
         + ", purchaseAmount="
         + this.getPurchaseAmount()
         + ")";
   }
}
