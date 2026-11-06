package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import io.swagger.annotations.ApiModel;

@ApiModel(description = "问题提醒对象")
public class QhseAlertDTO {
   private String qhseNumber;
   private String projectName;
   private String serialNumber;
   private String inspectUser;
   private String processName;
   private String teamName;
   private String levelOneName;
   private String levelTwoName;
   private Integer status;
   private String statusName;

   public static QhseAlertDTO.QhseAlertDTOBuilder builder() {
      return new QhseAlertDTO.QhseAlertDTOBuilder();
   }

   public String getQhseNumber() {
      return this.qhseNumber;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getInspectUser() {
      return this.inspectUser;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public String getLevelOneName() {
      return this.levelOneName;
   }

   public String getLevelTwoName() {
      return this.levelTwoName;
   }

   public Integer getStatus() {
      return this.status;
   }

   public String getStatusName() {
      return this.statusName;
   }

   public void setQhseNumber(final String qhseNumber) {
      this.qhseNumber = qhseNumber;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setInspectUser(final String inspectUser) {
      this.inspectUser = inspectUser;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setTeamName(final String teamName) {
      this.teamName = teamName;
   }

   public void setLevelOneName(final String levelOneName) {
      this.levelOneName = levelOneName;
   }

   public void setLevelTwoName(final String levelTwoName) {
      this.levelTwoName = levelTwoName;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setStatusName(final String statusName) {
      this.statusName = statusName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QhseAlertDTO)) {
         return false;
      }

      QhseAlertDTO other = (QhseAlertDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$status = this.getStatus();
      Object other$status = other.getStatus();
      if (this$status == null ? other$status == null : this$status.equals(other$status)) {
         Object this$qhseNumber = this.getQhseNumber();
         Object other$qhseNumber = other.getQhseNumber();
         if (this$qhseNumber == null ? other$qhseNumber == null : this$qhseNumber.equals(other$qhseNumber)) {
            Object this$projectName = this.getProjectName();
            Object other$projectName = other.getProjectName();
            if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
               Object this$serialNumber = this.getSerialNumber();
               Object other$serialNumber = other.getSerialNumber();
               if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                  Object this$inspectUser = this.getInspectUser();
                  Object other$inspectUser = other.getInspectUser();
                  if (this$inspectUser == null ? other$inspectUser == null : this$inspectUser.equals(other$inspectUser)) {
                     Object this$processName = this.getProcessName();
                     Object other$processName = other.getProcessName();
                     if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                        Object this$teamName = this.getTeamName();
                        Object other$teamName = other.getTeamName();
                        if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
                           Object this$levelOneName = this.getLevelOneName();
                           Object other$levelOneName = other.getLevelOneName();
                           if (this$levelOneName == null ? other$levelOneName == null : this$levelOneName.equals(other$levelOneName)) {
                              Object this$levelTwoName = this.getLevelTwoName();
                              Object other$levelTwoName = other.getLevelTwoName();
                              if (this$levelTwoName == null ? other$levelTwoName == null : this$levelTwoName.equals(other$levelTwoName)) {
                                 Object this$statusName = this.getStatusName();
                                 Object other$statusName = other.getStatusName();
                                 return this$statusName == null ? other$statusName == null : this$statusName.equals(other$statusName);
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
      return other instanceof QhseAlertDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $qhseNumber = this.getQhseNumber();
      result = result * 59 + ($qhseNumber == null ? 43 : $qhseNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $inspectUser = this.getInspectUser();
      result = result * 59 + ($inspectUser == null ? 43 : $inspectUser.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $levelOneName = this.getLevelOneName();
      result = result * 59 + ($levelOneName == null ? 43 : $levelOneName.hashCode());
      Object $levelTwoName = this.getLevelTwoName();
      result = result * 59 + ($levelTwoName == null ? 43 : $levelTwoName.hashCode());
      Object $statusName = this.getStatusName();
      return result * 59 + ($statusName == null ? 43 : $statusName.hashCode());
   }

   @Override
   public String toString() {
      return "QhseAlertDTO(super="
         + super.toString()
         + ", qhseNumber="
         + this.getQhseNumber()
         + ", projectName="
         + this.getProjectName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", inspectUser="
         + this.getInspectUser()
         + ", processName="
         + this.getProcessName()
         + ", teamName="
         + this.getTeamName()
         + ", levelOneName="
         + this.getLevelOneName()
         + ", levelTwoName="
         + this.getLevelTwoName()
         + ", status="
         + this.getStatus()
         + ", statusName="
         + this.getStatusName()
         + ")";
   }

   public QhseAlertDTO(
      final String qhseNumber,
      final String projectName,
      final String serialNumber,
      final String inspectUser,
      final String processName,
      final String teamName,
      final String levelOneName,
      final String levelTwoName,
      final Integer status,
      final String statusName
   ) {
      this.qhseNumber = qhseNumber;
      this.projectName = projectName;
      this.serialNumber = serialNumber;
      this.inspectUser = inspectUser;
      this.processName = processName;
      this.teamName = teamName;
      this.levelOneName = levelOneName;
      this.levelTwoName = levelTwoName;
      this.status = status;
      this.statusName = statusName;
   }

   public QhseAlertDTO() {
   }

   public static class QhseAlertDTOBuilder {
      private String qhseNumber;
      private String projectName;
      private String serialNumber;
      private String inspectUser;
      private String processName;
      private String teamName;
      private String levelOneName;
      private String levelTwoName;
      private Integer status;
      private String statusName;

      QhseAlertDTOBuilder() {
      }

      public QhseAlertDTO.QhseAlertDTOBuilder qhseNumber(final String qhseNumber) {
         this.qhseNumber = qhseNumber;
         return this;
      }

      public QhseAlertDTO.QhseAlertDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public QhseAlertDTO.QhseAlertDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public QhseAlertDTO.QhseAlertDTOBuilder inspectUser(final String inspectUser) {
         this.inspectUser = inspectUser;
         return this;
      }

      public QhseAlertDTO.QhseAlertDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public QhseAlertDTO.QhseAlertDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      public QhseAlertDTO.QhseAlertDTOBuilder levelOneName(final String levelOneName) {
         this.levelOneName = levelOneName;
         return this;
      }

      public QhseAlertDTO.QhseAlertDTOBuilder levelTwoName(final String levelTwoName) {
         this.levelTwoName = levelTwoName;
         return this;
      }

      public QhseAlertDTO.QhseAlertDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public QhseAlertDTO.QhseAlertDTOBuilder statusName(final String statusName) {
         this.statusName = statusName;
         return this;
      }

      public QhseAlertDTO build() {
         return new QhseAlertDTO(
            this.qhseNumber,
            this.projectName,
            this.serialNumber,
            this.inspectUser,
            this.processName,
            this.teamName,
            this.levelOneName,
            this.levelTwoName,
            this.status,
            this.statusName
         );
      }

      @Override
      public String toString() {
         return "QhseAlertDTO.QhseAlertDTOBuilder(qhseNumber="
            + this.qhseNumber
            + ", projectName="
            + this.projectName
            + ", serialNumber="
            + this.serialNumber
            + ", inspectUser="
            + this.inspectUser
            + ", processName="
            + this.processName
            + ", teamName="
            + this.teamName
            + ", levelOneName="
            + this.levelOneName
            + ", levelTwoName="
            + this.levelTwoName
            + ", status="
            + this.status
            + ", statusName="
            + this.statusName
            + ")";
      }
   }
}
