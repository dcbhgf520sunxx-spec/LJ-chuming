package com.hzchum.scim.project.core.api.pojo.dtoParam;

import java.time.LocalDate;

public class ProjectReturnProductMainQueryParam {
   private Integer productType;
   private Integer relationType;
   private Long projectId;
   private String projectName;
   private Integer auditStatus;
   private String serialNumber;
   private LocalDate createTimeStartDate;
   private LocalDate createTimeEndDate;
   private String createUserName;
   private String auditUserName;

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getRelationType() {
      return this.relationType;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public LocalDate getCreateTimeStartDate() {
      return this.createTimeStartDate;
   }

   public LocalDate getCreateTimeEndDate() {
      return this.createTimeEndDate;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public String getAuditUserName() {
      return this.auditUserName;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setRelationType(final Integer relationType) {
      this.relationType = relationType;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setCreateTimeStartDate(final LocalDate createTimeStartDate) {
      this.createTimeStartDate = createTimeStartDate;
   }

   public void setCreateTimeEndDate(final LocalDate createTimeEndDate) {
      this.createTimeEndDate = createTimeEndDate;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setAuditUserName(final String auditUserName) {
      this.auditUserName = auditUserName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectReturnProductMainQueryParam)) {
         return false;
      }

      ProjectReturnProductMainQueryParam other = (ProjectReturnProductMainQueryParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$relationType = this.getRelationType();
         Object other$relationType = other.getRelationType();
         if (this$relationType == null ? other$relationType == null : this$relationType.equals(other$relationType)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$auditStatus = this.getAuditStatus();
               Object other$auditStatus = other.getAuditStatus();
               if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                  Object this$projectName = this.getProjectName();
                  Object other$projectName = other.getProjectName();
                  if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$createTimeStartDate = this.getCreateTimeStartDate();
                        Object other$createTimeStartDate = other.getCreateTimeStartDate();
                        if (this$createTimeStartDate == null ? other$createTimeStartDate == null : this$createTimeStartDate.equals(other$createTimeStartDate)) {
                           Object this$createTimeEndDate = this.getCreateTimeEndDate();
                           Object other$createTimeEndDate = other.getCreateTimeEndDate();
                           if (this$createTimeEndDate == null ? other$createTimeEndDate == null : this$createTimeEndDate.equals(other$createTimeEndDate)) {
                              Object this$createUserName = this.getCreateUserName();
                              Object other$createUserName = other.getCreateUserName();
                              if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                                 Object this$auditUserName = this.getAuditUserName();
                                 Object other$auditUserName = other.getAuditUserName();
                                 return this$auditUserName == null ? other$auditUserName == null : this$auditUserName.equals(other$auditUserName);
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
      return other instanceof ProjectReturnProductMainQueryParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $relationType = this.getRelationType();
      result = result * 59 + ($relationType == null ? 43 : $relationType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $createTimeStartDate = this.getCreateTimeStartDate();
      result = result * 59 + ($createTimeStartDate == null ? 43 : $createTimeStartDate.hashCode());
      Object $createTimeEndDate = this.getCreateTimeEndDate();
      result = result * 59 + ($createTimeEndDate == null ? 43 : $createTimeEndDate.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $auditUserName = this.getAuditUserName();
      return result * 59 + ($auditUserName == null ? 43 : $auditUserName.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectReturnProductMainQueryParam(productType="
         + this.getProductType()
         + ", relationType="
         + this.getRelationType()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", createTimeStartDate="
         + this.getCreateTimeStartDate()
         + ", createTimeEndDate="
         + this.getCreateTimeEndDate()
         + ", createUserName="
         + this.getCreateUserName()
         + ", auditUserName="
         + this.getAuditUserName()
         + ")";
   }
}
