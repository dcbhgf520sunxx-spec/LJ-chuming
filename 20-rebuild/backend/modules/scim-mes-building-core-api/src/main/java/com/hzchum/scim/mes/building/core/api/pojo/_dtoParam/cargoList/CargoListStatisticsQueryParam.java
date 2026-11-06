package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.cargoList;

import java.time.LocalDateTime;

public class CargoListStatisticsQueryParam {
   private LocalDateTime dateTime;
   private Integer sendStatus;
   private String projectName;
   private Integer weightStatus;
   private Long workshopId;
   private Integer projectStatus;

   public LocalDateTime getDateTime() {
      return this.dateTime;
   }

   public Integer getSendStatus() {
      return this.sendStatus;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Integer getWeightStatus() {
      return this.weightStatus;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Integer getProjectStatus() {
      return this.projectStatus;
   }

   public void setDateTime(final LocalDateTime dateTime) {
      this.dateTime = dateTime;
   }

   public void setSendStatus(final Integer sendStatus) {
      this.sendStatus = sendStatus;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setWeightStatus(final Integer weightStatus) {
      this.weightStatus = weightStatus;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setProjectStatus(final Integer projectStatus) {
      this.projectStatus = projectStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListStatisticsQueryParam)) {
         return false;
      }

      CargoListStatisticsQueryParam other = (CargoListStatisticsQueryParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sendStatus = this.getSendStatus();
      Object other$sendStatus = other.getSendStatus();
      if (this$sendStatus == null ? other$sendStatus == null : this$sendStatus.equals(other$sendStatus)) {
         Object this$weightStatus = this.getWeightStatus();
         Object other$weightStatus = other.getWeightStatus();
         if (this$weightStatus == null ? other$weightStatus == null : this$weightStatus.equals(other$weightStatus)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$projectStatus = this.getProjectStatus();
               Object other$projectStatus = other.getProjectStatus();
               if (this$projectStatus == null ? other$projectStatus == null : this$projectStatus.equals(other$projectStatus)) {
                  Object this$dateTime = this.getDateTime();
                  Object other$dateTime = other.getDateTime();
                  if (this$dateTime == null ? other$dateTime == null : this$dateTime.equals(other$dateTime)) {
                     Object this$projectName = this.getProjectName();
                     Object other$projectName = other.getProjectName();
                     return this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName);
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
      return other instanceof CargoListStatisticsQueryParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sendStatus = this.getSendStatus();
      result = result * 59 + ($sendStatus == null ? 43 : $sendStatus.hashCode());
      Object $weightStatus = this.getWeightStatus();
      result = result * 59 + ($weightStatus == null ? 43 : $weightStatus.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $projectStatus = this.getProjectStatus();
      result = result * 59 + ($projectStatus == null ? 43 : $projectStatus.hashCode());
      Object $dateTime = this.getDateTime();
      result = result * 59 + ($dateTime == null ? 43 : $dateTime.hashCode());
      Object $projectName = this.getProjectName();
      return result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
   }

   @Override
   public String toString() {
      return "CargoListStatisticsQueryParam(dateTime="
         + this.getDateTime()
         + ", sendStatus="
         + this.getSendStatus()
         + ", projectName="
         + this.getProjectName()
         + ", weightStatus="
         + this.getWeightStatus()
         + ", workshopId="
         + this.getWorkshopId()
         + ", projectStatus="
         + this.getProjectStatus()
         + ")";
   }
}
