package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;

public class QueryPurchaseInboundDetailDTOParam {
   @NotNull(message = "请选择材料类型")
   private Integer materialType;
   private Integer basicClassBit;
   private Integer basicClass;
   private String createUser;
   private String className;
   private LocalDateTime startTime;
   private LocalDateTime endTime;
   private Long projectId;
   private String purchaseSerialNumber;
   private Long supplierId;
   private String specification;
   private Long branchCompanyId;

   public Integer getMaterialType() {
      return this.materialType;
   }

   public Integer getBasicClassBit() {
      return this.basicClassBit;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getCreateUser() {
      return this.createUser;
   }

   public String getClassName() {
      return this.className;
   }

   public LocalDateTime getStartTime() {
      return this.startTime;
   }

   public LocalDateTime getEndTime() {
      return this.endTime;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getPurchaseSerialNumber() {
      return this.purchaseSerialNumber;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSpecification() {
      return this.specification;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public void setMaterialType(final Integer materialType) {
      this.materialType = materialType;
   }

   public void setBasicClassBit(final Integer basicClassBit) {
      this.basicClassBit = basicClassBit;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setCreateUser(final String createUser) {
      this.createUser = createUser;
   }

   public void setClassName(final String className) {
      this.className = className;
   }

   public void setStartTime(final LocalDateTime startTime) {
      this.startTime = startTime;
   }

   public void setEndTime(final LocalDateTime endTime) {
      this.endTime = endTime;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setPurchaseSerialNumber(final String purchaseSerialNumber) {
      this.purchaseSerialNumber = purchaseSerialNumber;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryPurchaseInboundDetailDTOParam)) {
         return false;
      }

      QueryPurchaseInboundDetailDTOParam other = (QueryPurchaseInboundDetailDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$materialType = this.getMaterialType();
      Object other$materialType = other.getMaterialType();
      if (this$materialType == null ? other$materialType == null : this$materialType.equals(other$materialType)) {
         Object this$basicClassBit = this.getBasicClassBit();
         Object other$basicClassBit = other.getBasicClassBit();
         if (this$basicClassBit == null ? other$basicClassBit == null : this$basicClassBit.equals(other$basicClassBit)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$branchCompanyId = this.getBranchCompanyId();
                     Object other$branchCompanyId = other.getBranchCompanyId();
                     if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                        Object this$createUser = this.getCreateUser();
                        Object other$createUser = other.getCreateUser();
                        if (this$createUser == null ? other$createUser == null : this$createUser.equals(other$createUser)) {
                           Object this$className = this.getClassName();
                           Object other$className = other.getClassName();
                           if (this$className == null ? other$className == null : this$className.equals(other$className)) {
                              Object this$startTime = this.getStartTime();
                              Object other$startTime = other.getStartTime();
                              if (this$startTime == null ? other$startTime == null : this$startTime.equals(other$startTime)) {
                                 Object this$endTime = this.getEndTime();
                                 Object other$endTime = other.getEndTime();
                                 if (this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime)) {
                                    Object this$purchaseSerialNumber = this.getPurchaseSerialNumber();
                                    Object other$purchaseSerialNumber = other.getPurchaseSerialNumber();
                                    if (this$purchaseSerialNumber == null
                                       ? other$purchaseSerialNumber == null
                                       : this$purchaseSerialNumber.equals(other$purchaseSerialNumber)) {
                                       Object this$specification = this.getSpecification();
                                       Object other$specification = other.getSpecification();
                                       return this$specification == null ? other$specification == null : this$specification.equals(other$specification);
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
      return other instanceof QueryPurchaseInboundDetailDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $materialType = this.getMaterialType();
      result = result * 59 + ($materialType == null ? 43 : $materialType.hashCode());
      Object $basicClassBit = this.getBasicClassBit();
      result = result * 59 + ($basicClassBit == null ? 43 : $basicClassBit.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $createUser = this.getCreateUser();
      result = result * 59 + ($createUser == null ? 43 : $createUser.hashCode());
      Object $className = this.getClassName();
      result = result * 59 + ($className == null ? 43 : $className.hashCode());
      Object $startTime = this.getStartTime();
      result = result * 59 + ($startTime == null ? 43 : $startTime.hashCode());
      Object $endTime = this.getEndTime();
      result = result * 59 + ($endTime == null ? 43 : $endTime.hashCode());
      Object $purchaseSerialNumber = this.getPurchaseSerialNumber();
      result = result * 59 + ($purchaseSerialNumber == null ? 43 : $purchaseSerialNumber.hashCode());
      Object $specification = this.getSpecification();
      return result * 59 + ($specification == null ? 43 : $specification.hashCode());
   }

   @Override
   public String toString() {
      return "QueryPurchaseInboundDetailDTOParam(materialType="
         + this.getMaterialType()
         + ", basicClassBit="
         + this.getBasicClassBit()
         + ", basicClass="
         + this.getBasicClass()
         + ", createUser="
         + this.getCreateUser()
         + ", className="
         + this.getClassName()
         + ", startTime="
         + this.getStartTime()
         + ", endTime="
         + this.getEndTime()
         + ", projectId="
         + this.getProjectId()
         + ", purchaseSerialNumber="
         + this.getPurchaseSerialNumber()
         + ", supplierId="
         + this.getSupplierId()
         + ", specification="
         + this.getSpecification()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ")";
   }

   public QueryPurchaseInboundDetailDTOParam(
      final Integer materialType,
      final Integer basicClassBit,
      final Integer basicClass,
      final String createUser,
      final String className,
      final LocalDateTime startTime,
      final LocalDateTime endTime,
      final Long projectId,
      final String purchaseSerialNumber,
      final Long supplierId,
      final String specification,
      final Long branchCompanyId
   ) {
      this.materialType = materialType;
      this.basicClassBit = basicClassBit;
      this.basicClass = basicClass;
      this.createUser = createUser;
      this.className = className;
      this.startTime = startTime;
      this.endTime = endTime;
      this.projectId = projectId;
      this.purchaseSerialNumber = purchaseSerialNumber;
      this.supplierId = supplierId;
      this.specification = specification;
      this.branchCompanyId = branchCompanyId;
   }

   public QueryPurchaseInboundDetailDTOParam() {
   }
}
