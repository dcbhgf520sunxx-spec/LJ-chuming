package com.hzchum.scim.crm.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

public class CrmprojectInformationWarehousingFollowUpTimesAndDateDTO {
   @ApiModelProperty(name = "effectiveRemainingTime", value = "项目有效剩余时间", notes = "项目有效剩余时间")
   private Integer effectiveRemainingTime;
   @ApiModelProperty(name = "FollowUpTimes", value = "项目跟进次数", notes = "项目跟进次数")
   private Integer followUpTimes;
   @ApiModelProperty(name = "lastFollowUpDate", value = "项目上次跟进日期", notes = "项目上次跟进日期")
   private LocalDate lastFollowUpDate;

   public static CrmprojectInformationWarehousingFollowUpTimesAndDateDTO.CrmprojectInformationWarehousingFollowUpTimesAndDateDTOBuilder builder() {
      return new CrmprojectInformationWarehousingFollowUpTimesAndDateDTO.CrmprojectInformationWarehousingFollowUpTimesAndDateDTOBuilder();
   }

   public CrmprojectInformationWarehousingFollowUpTimesAndDateDTO() {
   }

   public CrmprojectInformationWarehousingFollowUpTimesAndDateDTO(
      final Integer effectiveRemainingTime, final Integer followUpTimes, final LocalDate lastFollowUpDate
   ) {
      this.effectiveRemainingTime = effectiveRemainingTime;
      this.followUpTimes = followUpTimes;
      this.lastFollowUpDate = lastFollowUpDate;
   }

   public Integer getEffectiveRemainingTime() {
      return this.effectiveRemainingTime;
   }

   public Integer getFollowUpTimes() {
      return this.followUpTimes;
   }

   public LocalDate getLastFollowUpDate() {
      return this.lastFollowUpDate;
   }

   public CrmprojectInformationWarehousingFollowUpTimesAndDateDTO setEffectiveRemainingTime(final Integer effectiveRemainingTime) {
      this.effectiveRemainingTime = effectiveRemainingTime;
      return this;
   }

   public CrmprojectInformationWarehousingFollowUpTimesAndDateDTO setFollowUpTimes(final Integer followUpTimes) {
      this.followUpTimes = followUpTimes;
      return this;
   }

   public CrmprojectInformationWarehousingFollowUpTimesAndDateDTO setLastFollowUpDate(final LocalDate lastFollowUpDate) {
      this.lastFollowUpDate = lastFollowUpDate;
      return this;
   }

   @Override
   public String toString() {
      return "CrmprojectInformationWarehousingFollowUpTimesAndDateDTO(effectiveRemainingTime="
         + this.getEffectiveRemainingTime()
         + ", followUpTimes="
         + this.getFollowUpTimes()
         + ", lastFollowUpDate="
         + this.getLastFollowUpDate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CrmprojectInformationWarehousingFollowUpTimesAndDateDTO)) {
         return false;
      }

      CrmprojectInformationWarehousingFollowUpTimesAndDateDTO other = (CrmprojectInformationWarehousingFollowUpTimesAndDateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$effectiveRemainingTime = this.getEffectiveRemainingTime();
      Object other$effectiveRemainingTime = other.getEffectiveRemainingTime();
      if (this$effectiveRemainingTime == null ? other$effectiveRemainingTime == null : this$effectiveRemainingTime.equals(other$effectiveRemainingTime)) {
         Object this$followUpTimes = this.getFollowUpTimes();
         Object other$followUpTimes = other.getFollowUpTimes();
         if (this$followUpTimes == null ? other$followUpTimes == null : this$followUpTimes.equals(other$followUpTimes)) {
            Object this$lastFollowUpDate = this.getLastFollowUpDate();
            Object other$lastFollowUpDate = other.getLastFollowUpDate();
            return this$lastFollowUpDate == null ? other$lastFollowUpDate == null : this$lastFollowUpDate.equals(other$lastFollowUpDate);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CrmprojectInformationWarehousingFollowUpTimesAndDateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $effectiveRemainingTime = this.getEffectiveRemainingTime();
      result = result * 59 + ($effectiveRemainingTime == null ? 43 : $effectiveRemainingTime.hashCode());
      Object $followUpTimes = this.getFollowUpTimes();
      result = result * 59 + ($followUpTimes == null ? 43 : $followUpTimes.hashCode());
      Object $lastFollowUpDate = this.getLastFollowUpDate();
      return result * 59 + ($lastFollowUpDate == null ? 43 : $lastFollowUpDate.hashCode());
   }

   public static class CrmprojectInformationWarehousingFollowUpTimesAndDateDTOBuilder {
      private Integer effectiveRemainingTime;
      private Integer followUpTimes;
      private LocalDate lastFollowUpDate;

      CrmprojectInformationWarehousingFollowUpTimesAndDateDTOBuilder() {
      }

      public CrmprojectInformationWarehousingFollowUpTimesAndDateDTO.CrmprojectInformationWarehousingFollowUpTimesAndDateDTOBuilder effectiveRemainingTime(
         final Integer effectiveRemainingTime
      ) {
         this.effectiveRemainingTime = effectiveRemainingTime;
         return this;
      }

      public CrmprojectInformationWarehousingFollowUpTimesAndDateDTO.CrmprojectInformationWarehousingFollowUpTimesAndDateDTOBuilder followUpTimes(
         final Integer followUpTimes
      ) {
         this.followUpTimes = followUpTimes;
         return this;
      }

      public CrmprojectInformationWarehousingFollowUpTimesAndDateDTO.CrmprojectInformationWarehousingFollowUpTimesAndDateDTOBuilder lastFollowUpDate(
         final LocalDate lastFollowUpDate
      ) {
         this.lastFollowUpDate = lastFollowUpDate;
         return this;
      }

      public CrmprojectInformationWarehousingFollowUpTimesAndDateDTO build() {
         return new CrmprojectInformationWarehousingFollowUpTimesAndDateDTO(this.effectiveRemainingTime, this.followUpTimes, this.lastFollowUpDate);
      }

      @Override
      public String toString() {
         return "CrmprojectInformationWarehousingFollowUpTimesAndDateDTO.CrmprojectInformationWarehousingFollowUpTimesAndDateDTOBuilder(effectiveRemainingTime="
            + this.effectiveRemainingTime
            + ", followUpTimes="
            + this.followUpTimes
            + ", lastFollowUpDate="
            + this.lastFollowUpDate
            + ")";
      }
   }
}
