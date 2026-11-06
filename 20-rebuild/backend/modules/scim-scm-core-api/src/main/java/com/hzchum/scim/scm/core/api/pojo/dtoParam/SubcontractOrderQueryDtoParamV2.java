package com.hzchum.scim.scm.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel("SubcontractOrderDTO对象列表查询类")
public class SubcontractOrderQueryDtoParamV2 {
   private LocalDateTime year;
   private Boolean boolSettlementStatus;
   private Integer auditTypeEnum;
   private String serialNumber;
   private Long projectId;
   private String projectName;
   private Long branchCompanyId;
   private String branchCompanyName;
   private Long supplierId;
   private String supplierName;
   private Long projectManagerId;
   private String projectManagerName;
   private String userName;
   private List<Integer> projectAttribute;
   private Integer level;

   public static SubcontractOrderQueryDtoParamV2.SubcontractOrderQueryDtoParamV2Builder builder() {
      return new SubcontractOrderQueryDtoParamV2.SubcontractOrderQueryDtoParamV2Builder();
   }

   public SubcontractOrderQueryDtoParamV2() {
   }

   public SubcontractOrderQueryDtoParamV2(
      final LocalDateTime year,
      final Boolean boolSettlementStatus,
      final Integer auditTypeEnum,
      final String serialNumber,
      final Long projectId,
      final String projectName,
      final Long branchCompanyId,
      final String branchCompanyName,
      final Long supplierId,
      final String supplierName,
      final Long projectManagerId,
      final String projectManagerName,
      final String userName,
      final List<Integer> projectAttribute,
      final Integer level
   ) {
      this.year = year;
      this.boolSettlementStatus = boolSettlementStatus;
      this.auditTypeEnum = auditTypeEnum;
      this.serialNumber = serialNumber;
      this.projectId = projectId;
      this.projectName = projectName;
      this.branchCompanyId = branchCompanyId;
      this.branchCompanyName = branchCompanyName;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.projectManagerId = projectManagerId;
      this.projectManagerName = projectManagerName;
      this.userName = userName;
      this.projectAttribute = projectAttribute;
      this.level = level;
   }

   public LocalDateTime getYear() {
      return this.year;
   }

   public Boolean getBoolSettlementStatus() {
      return this.boolSettlementStatus;
   }

   public Integer getAuditTypeEnum() {
      return this.auditTypeEnum;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public String getBranchCompanyName() {
      return this.branchCompanyName;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public String getUserName() {
      return this.userName;
   }

   public List<Integer> getProjectAttribute() {
      return this.projectAttribute;
   }

   public Integer getLevel() {
      return this.level;
   }

   public void setYear(final LocalDateTime year) {
      this.year = year;
   }

   public void setBoolSettlementStatus(final Boolean boolSettlementStatus) {
      this.boolSettlementStatus = boolSettlementStatus;
   }

   public void setAuditTypeEnum(final Integer auditTypeEnum) {
      this.auditTypeEnum = auditTypeEnum;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setBranchCompanyName(final String branchCompanyName) {
      this.branchCompanyName = branchCompanyName;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
   }

   public void setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setProjectAttribute(final List<Integer> projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setLevel(final Integer level) {
      this.level = level;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SubcontractOrderQueryDtoParamV2)) {
         return false;
      }

      SubcontractOrderQueryDtoParamV2 other = (SubcontractOrderQueryDtoParamV2)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolSettlementStatus = this.getBoolSettlementStatus();
      Object other$boolSettlementStatus = other.getBoolSettlementStatus();
      if (this$boolSettlementStatus == null ? other$boolSettlementStatus == null : this$boolSettlementStatus.equals(other$boolSettlementStatus)) {
         Object this$auditTypeEnum = this.getAuditTypeEnum();
         Object other$auditTypeEnum = other.getAuditTypeEnum();
         if (this$auditTypeEnum == null ? other$auditTypeEnum == null : this$auditTypeEnum.equals(other$auditTypeEnum)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$branchCompanyId = this.getBranchCompanyId();
               Object other$branchCompanyId = other.getBranchCompanyId();
               if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
                  Object this$supplierId = this.getSupplierId();
                  Object other$supplierId = other.getSupplierId();
                  if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                     Object this$projectManagerId = this.getProjectManagerId();
                     Object other$projectManagerId = other.getProjectManagerId();
                     if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                        Object this$level = this.getLevel();
                        Object other$level = other.getLevel();
                        if (this$level == null ? other$level == null : this$level.equals(other$level)) {
                           Object this$year = this.getYear();
                           Object other$year = other.getYear();
                           if (this$year == null ? other$year == null : this$year.equals(other$year)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$projectName = this.getProjectName();
                                 Object other$projectName = other.getProjectName();
                                 if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                    Object this$branchCompanyName = this.getBranchCompanyName();
                                    Object other$branchCompanyName = other.getBranchCompanyName();
                                    if (this$branchCompanyName == null
                                       ? other$branchCompanyName == null
                                       : this$branchCompanyName.equals(other$branchCompanyName)) {
                                       Object this$supplierName = this.getSupplierName();
                                       Object other$supplierName = other.getSupplierName();
                                       if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                          Object this$projectManagerName = this.getProjectManagerName();
                                          Object other$projectManagerName = other.getProjectManagerName();
                                          if (this$projectManagerName == null
                                             ? other$projectManagerName == null
                                             : this$projectManagerName.equals(other$projectManagerName)) {
                                             Object this$userName = this.getUserName();
                                             Object other$userName = other.getUserName();
                                             if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                                Object this$projectAttribute = this.getProjectAttribute();
                                                Object other$projectAttribute = other.getProjectAttribute();
                                                return this$projectAttribute == null
                                                   ? other$projectAttribute == null
                                                   : this$projectAttribute.equals(other$projectAttribute);
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
      return other instanceof SubcontractOrderQueryDtoParamV2;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolSettlementStatus = this.getBoolSettlementStatus();
      result = result * 59 + ($boolSettlementStatus == null ? 43 : $boolSettlementStatus.hashCode());
      Object $auditTypeEnum = this.getAuditTypeEnum();
      result = result * 59 + ($auditTypeEnum == null ? 43 : $auditTypeEnum.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $branchCompanyName = this.getBranchCompanyName();
      result = result * 59 + ($branchCompanyName == null ? 43 : $branchCompanyName.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      return result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
   }

   @Override
   public String toString() {
      return "SubcontractOrderQueryDtoParamV2(year="
         + this.getYear()
         + ", boolSettlementStatus="
         + this.getBoolSettlementStatus()
         + ", auditTypeEnum="
         + this.getAuditTypeEnum()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", branchCompanyName="
         + this.getBranchCompanyName()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", userName="
         + this.getUserName()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", level="
         + this.getLevel()
         + ")";
   }

   public static class SubcontractOrderQueryDtoParamV2Builder {
      private LocalDateTime year;
      private Boolean boolSettlementStatus;
      private Integer auditTypeEnum;
      private String serialNumber;
      private Long projectId;
      private String projectName;
      private Long branchCompanyId;
      private String branchCompanyName;
      private Long supplierId;
      private String supplierName;
      private Long projectManagerId;
      private String projectManagerName;
      private String userName;
      private List<Integer> projectAttribute;
      private Integer level;

      SubcontractOrderQueryDtoParamV2Builder() {
      }

      public SubcontractOrderQueryDtoParamV2.SubcontractOrderQueryDtoParamV2Builder year(final LocalDateTime year) {
         this.year = year;
         return this;
      }

      public SubcontractOrderQueryDtoParamV2.SubcontractOrderQueryDtoParamV2Builder boolSettlementStatus(final Boolean boolSettlementStatus) {
         this.boolSettlementStatus = boolSettlementStatus;
         return this;
      }

      public SubcontractOrderQueryDtoParamV2.SubcontractOrderQueryDtoParamV2Builder auditTypeEnum(final Integer auditTypeEnum) {
         this.auditTypeEnum = auditTypeEnum;
         return this;
      }

      public SubcontractOrderQueryDtoParamV2.SubcontractOrderQueryDtoParamV2Builder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SubcontractOrderQueryDtoParamV2.SubcontractOrderQueryDtoParamV2Builder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SubcontractOrderQueryDtoParamV2.SubcontractOrderQueryDtoParamV2Builder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public SubcontractOrderQueryDtoParamV2.SubcontractOrderQueryDtoParamV2Builder branchCompanyId(final Long branchCompanyId) {
         this.branchCompanyId = branchCompanyId;
         return this;
      }

      public SubcontractOrderQueryDtoParamV2.SubcontractOrderQueryDtoParamV2Builder branchCompanyName(final String branchCompanyName) {
         this.branchCompanyName = branchCompanyName;
         return this;
      }

      public SubcontractOrderQueryDtoParamV2.SubcontractOrderQueryDtoParamV2Builder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public SubcontractOrderQueryDtoParamV2.SubcontractOrderQueryDtoParamV2Builder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public SubcontractOrderQueryDtoParamV2.SubcontractOrderQueryDtoParamV2Builder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public SubcontractOrderQueryDtoParamV2.SubcontractOrderQueryDtoParamV2Builder projectManagerName(final String projectManagerName) {
         this.projectManagerName = projectManagerName;
         return this;
      }

      public SubcontractOrderQueryDtoParamV2.SubcontractOrderQueryDtoParamV2Builder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public SubcontractOrderQueryDtoParamV2.SubcontractOrderQueryDtoParamV2Builder projectAttribute(final List<Integer> projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public SubcontractOrderQueryDtoParamV2.SubcontractOrderQueryDtoParamV2Builder level(final Integer level) {
         this.level = level;
         return this;
      }

      public SubcontractOrderQueryDtoParamV2 build() {
         return new SubcontractOrderQueryDtoParamV2(
            this.year,
            this.boolSettlementStatus,
            this.auditTypeEnum,
            this.serialNumber,
            this.projectId,
            this.projectName,
            this.branchCompanyId,
            this.branchCompanyName,
            this.supplierId,
            this.supplierName,
            this.projectManagerId,
            this.projectManagerName,
            this.userName,
            this.projectAttribute,
            this.level
         );
      }

      @Override
      public String toString() {
         return "SubcontractOrderQueryDtoParamV2.SubcontractOrderQueryDtoParamV2Builder(year="
            + this.year
            + ", boolSettlementStatus="
            + this.boolSettlementStatus
            + ", auditTypeEnum="
            + this.auditTypeEnum
            + ", serialNumber="
            + this.serialNumber
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", branchCompanyId="
            + this.branchCompanyId
            + ", branchCompanyName="
            + this.branchCompanyName
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", projectManagerId="
            + this.projectManagerId
            + ", projectManagerName="
            + this.projectManagerName
            + ", userName="
            + this.userName
            + ", projectAttribute="
            + this.projectAttribute
            + ", level="
            + this.level
            + ")";
      }
   }
}
