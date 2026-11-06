package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;

public class CrmCheckProjectHaveRecordingDTO {
   @ApiModelProperty(name = "haveFollowUp", notes = "是否拥有跟进记录")
   private Boolean haveFollowUp;
   @ApiModelProperty(name = "havePreQualification", notes = "是否拥有预审记录")
   private Boolean havePreQualification;
   @ApiModelProperty(name = "haveApplyForBidRecord", notes = "是否拥有投标记录")
   private Boolean haveApplyForBidRecord;

   public CrmCheckProjectHaveRecordingDTO(final Boolean haveFollowUp, final Boolean havePreQualification, final Boolean haveApplyForBidRecord) {
      this.haveFollowUp = haveFollowUp;
      this.havePreQualification = havePreQualification;
      this.haveApplyForBidRecord = haveApplyForBidRecord;
   }

   public CrmCheckProjectHaveRecordingDTO() {
   }

   public Boolean getHaveFollowUp() {
      return this.haveFollowUp;
   }

   public Boolean getHavePreQualification() {
      return this.havePreQualification;
   }

   public Boolean getHaveApplyForBidRecord() {
      return this.haveApplyForBidRecord;
   }

   public void setHaveFollowUp(final Boolean haveFollowUp) {
      this.haveFollowUp = haveFollowUp;
   }

   public void setHavePreQualification(final Boolean havePreQualification) {
      this.havePreQualification = havePreQualification;
   }

   public void setHaveApplyForBidRecord(final Boolean haveApplyForBidRecord) {
      this.haveApplyForBidRecord = haveApplyForBidRecord;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmCheckProjectHaveRecordingDTO)) {
         return false;
      }

      CrmCheckProjectHaveRecordingDTO other = (CrmCheckProjectHaveRecordingDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$haveFollowUp = this.getHaveFollowUp();
      Object other$haveFollowUp = other.getHaveFollowUp();
      if (this$haveFollowUp == null ? other$haveFollowUp == null : this$haveFollowUp.equals(other$haveFollowUp)) {
         Object this$havePreQualification = this.getHavePreQualification();
         Object other$havePreQualification = other.getHavePreQualification();
         if (this$havePreQualification == null ? other$havePreQualification == null : this$havePreQualification.equals(other$havePreQualification)) {
            Object this$haveApplyForBidRecord = this.getHaveApplyForBidRecord();
            Object other$haveApplyForBidRecord = other.getHaveApplyForBidRecord();
            return this$haveApplyForBidRecord == null ? other$haveApplyForBidRecord == null : this$haveApplyForBidRecord.equals(other$haveApplyForBidRecord);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmCheckProjectHaveRecordingDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $haveFollowUp = this.getHaveFollowUp();
      result = result * 59 + ($haveFollowUp == null ? 43 : $haveFollowUp.hashCode());
      Object $havePreQualification = this.getHavePreQualification();
      result = result * 59 + ($havePreQualification == null ? 43 : $havePreQualification.hashCode());
      Object $haveApplyForBidRecord = this.getHaveApplyForBidRecord();
      return result * 59 + ($haveApplyForBidRecord == null ? 43 : $haveApplyForBidRecord.hashCode());
   }

   @Override
   public String toString() {
      return "CrmCheckProjectHaveRecordingDTO(haveFollowUp="
         + this.getHaveFollowUp()
         + ", havePreQualification="
         + this.getHavePreQualification()
         + ", haveApplyForBidRecord="
         + this.getHaveApplyForBidRecord()
         + ")";
   }
}
