package com.hzchum.scim.wms.core.api.pojo.dtoParam.wmsUse;

import java.time.LocalDateTime;

public class QueryRequisitionsDTOParam {
   private Boolean status;
   private Long projectId;
   private Integer basicClass;
   private String serialNumber;
   private String userName;
   private LocalDateTime startDate;
   private LocalDateTime endingDate;

   public Boolean getStatus() {
      return this.status;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public LocalDateTime getEndingDate() {
      return this.endingDate;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
   }

   public void setEndingDate(final LocalDateTime endingDate) {
      this.endingDate = endingDate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryRequisitionsDTOParam)) {
         return false;
      }

      QueryRequisitionsDTOParam other = (QueryRequisitionsDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$status = this.getStatus();
      Object other$status = other.getStatus();
      if (this$status == null ? other$status == null : this$status.equals(other$status)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$basicClass = this.getBasicClass();
            Object other$basicClass = other.getBasicClass();
            if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$userName = this.getUserName();
                  Object other$userName = other.getUserName();
                  if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                     Object this$startDate = this.getStartDate();
                     Object other$startDate = other.getStartDate();
                     if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                        Object this$endingDate = this.getEndingDate();
                        Object other$endingDate = other.getEndingDate();
                        return this$endingDate == null ? other$endingDate == null : this$endingDate.equals(other$endingDate);
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
      return other instanceof QueryRequisitionsDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endingDate = this.getEndingDate();
      return result * 59 + ($endingDate == null ? 43 : $endingDate.hashCode());
   }

   @Override
   public String toString() {
      return "QueryRequisitionsDTOParam(status="
         + this.getStatus()
         + ", projectId="
         + this.getProjectId()
         + ", basicClass="
         + this.getBasicClass()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", userName="
         + this.getUserName()
         + ", startDate="
         + this.getStartDate()
         + ", endingDate="
         + this.getEndingDate()
         + ")";
   }
}
