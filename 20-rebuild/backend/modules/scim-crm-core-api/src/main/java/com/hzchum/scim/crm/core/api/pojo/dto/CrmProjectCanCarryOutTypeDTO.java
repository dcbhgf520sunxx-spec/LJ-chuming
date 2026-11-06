package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmProjectCanCarryOutTypeDTO {
   @ApiModelProperty(name = "canFollowUpStatus", notes = "能否跟进")
   private Boolean canFollowUpStatus;
   @ApiModelProperty(name = "canPrequalificationStatus", notes = "能否预审")
   private Boolean canPrequalificationStatus;
   @ApiModelProperty(name = "canBidApplicationStatus", notes = "能否投标申请")
   private Boolean canBidApplicationStatus;
   @ApiModelProperty(name = "canAbandonProjectTrackingStatus", notes = "能否放弃项目")
   private Boolean canAbandonProjectTrackingStatus;

   public CrmProjectCanCarryOutTypeDTO(
      final Boolean canFollowUpStatus,
      final Boolean canPrequalificationStatus,
      final Boolean canBidApplicationStatus,
      final Boolean canAbandonProjectTrackingStatus
   ) {
      this.canFollowUpStatus = canFollowUpStatus;
      this.canPrequalificationStatus = canPrequalificationStatus;
      this.canBidApplicationStatus = canBidApplicationStatus;
      this.canAbandonProjectTrackingStatus = canAbandonProjectTrackingStatus;
   }

   public CrmProjectCanCarryOutTypeDTO() {
   }

   public Boolean getCanFollowUpStatus() {
      return this.canFollowUpStatus;
   }

   public Boolean getCanPrequalificationStatus() {
      return this.canPrequalificationStatus;
   }

   public Boolean getCanBidApplicationStatus() {
      return this.canBidApplicationStatus;
   }

   public Boolean getCanAbandonProjectTrackingStatus() {
      return this.canAbandonProjectTrackingStatus;
   }

   public void setCanFollowUpStatus(final Boolean canFollowUpStatus) {
      this.canFollowUpStatus = canFollowUpStatus;
   }

   public void setCanPrequalificationStatus(final Boolean canPrequalificationStatus) {
      this.canPrequalificationStatus = canPrequalificationStatus;
   }

   public void setCanBidApplicationStatus(final Boolean canBidApplicationStatus) {
      this.canBidApplicationStatus = canBidApplicationStatus;
   }

   public void setCanAbandonProjectTrackingStatus(final Boolean canAbandonProjectTrackingStatus) {
      this.canAbandonProjectTrackingStatus = canAbandonProjectTrackingStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmProjectCanCarryOutTypeDTO)) {
         return false;
      }

      CrmProjectCanCarryOutTypeDTO other = (CrmProjectCanCarryOutTypeDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$canFollowUpStatus = this.getCanFollowUpStatus();
      Object other$canFollowUpStatus = other.getCanFollowUpStatus();
      if (this$canFollowUpStatus == null ? other$canFollowUpStatus == null : this$canFollowUpStatus.equals(other$canFollowUpStatus)) {
         Object this$canPrequalificationStatus = this.getCanPrequalificationStatus();
         Object other$canPrequalificationStatus = other.getCanPrequalificationStatus();
         if (this$canPrequalificationStatus == null
            ? other$canPrequalificationStatus == null
            : this$canPrequalificationStatus.equals(other$canPrequalificationStatus)) {
            Object this$canBidApplicationStatus = this.getCanBidApplicationStatus();
            Object other$canBidApplicationStatus = other.getCanBidApplicationStatus();
            if (this$canBidApplicationStatus == null
               ? other$canBidApplicationStatus == null
               : this$canBidApplicationStatus.equals(other$canBidApplicationStatus)) {
               Object this$canAbandonProjectTrackingStatus = this.getCanAbandonProjectTrackingStatus();
               Object other$canAbandonProjectTrackingStatus = other.getCanAbandonProjectTrackingStatus();
               return this$canAbandonProjectTrackingStatus == null
                  ? other$canAbandonProjectTrackingStatus == null
                  : this$canAbandonProjectTrackingStatus.equals(other$canAbandonProjectTrackingStatus);
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
      return other instanceof CrmProjectCanCarryOutTypeDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $canFollowUpStatus = this.getCanFollowUpStatus();
      result = result * 59 + ($canFollowUpStatus == null ? 43 : $canFollowUpStatus.hashCode());
      Object $canPrequalificationStatus = this.getCanPrequalificationStatus();
      result = result * 59 + ($canPrequalificationStatus == null ? 43 : $canPrequalificationStatus.hashCode());
      Object $canBidApplicationStatus = this.getCanBidApplicationStatus();
      result = result * 59 + ($canBidApplicationStatus == null ? 43 : $canBidApplicationStatus.hashCode());
      Object $canAbandonProjectTrackingStatus = this.getCanAbandonProjectTrackingStatus();
      return result * 59 + ($canAbandonProjectTrackingStatus == null ? 43 : $canAbandonProjectTrackingStatus.hashCode());
   }

   @Override
   public String toString() {
      return "CrmProjectCanCarryOutTypeDTO(canFollowUpStatus="
         + this.getCanFollowUpStatus()
         + ", canPrequalificationStatus="
         + this.getCanPrequalificationStatus()
         + ", canBidApplicationStatus="
         + this.getCanBidApplicationStatus()
         + ", canAbandonProjectTrackingStatus="
         + this.getCanAbandonProjectTrackingStatus()
         + ")";
   }
}
