package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalTime;

public class PushNotificationTimingConfigDTO {
   @ApiModelProperty(name = "timingTypeEnum", notes = "定时类型（前置 后置）")
   private Integer timingTypeEnum;
   @ApiModelProperty(name = "durationOrTimeTypeEnum", notes = "时间/时长")
   private Integer durationOrTimeTypeEnum;
   @ApiModelProperty(name = "durationTypeEnum", notes = "时间单位")
   private Integer durationTypeEnum;
   @ApiModelProperty(name = "duration", notes = "时长")
   private Long duration;
   @ApiModelProperty(name = "time", notes = "时间")
   private LocalTime time;

   public Integer getTimingTypeEnum() {
      return this.timingTypeEnum;
   }

   public Integer getDurationOrTimeTypeEnum() {
      return this.durationOrTimeTypeEnum;
   }

   public Integer getDurationTypeEnum() {
      return this.durationTypeEnum;
   }

   public Long getDuration() {
      return this.duration;
   }

   public LocalTime getTime() {
      return this.time;
   }

   public void setTimingTypeEnum(final Integer timingTypeEnum) {
      this.timingTypeEnum = timingTypeEnum;
   }

   public void setDurationOrTimeTypeEnum(final Integer durationOrTimeTypeEnum) {
      this.durationOrTimeTypeEnum = durationOrTimeTypeEnum;
   }

   public void setDurationTypeEnum(final Integer durationTypeEnum) {
      this.durationTypeEnum = durationTypeEnum;
   }

   public void setDuration(final Long duration) {
      this.duration = duration;
   }

   public void setTime(final LocalTime time) {
      this.time = time;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PushNotificationTimingConfigDTO)) {
         return false;
      }

      PushNotificationTimingConfigDTO other = (PushNotificationTimingConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$timingTypeEnum = this.getTimingTypeEnum();
      Object other$timingTypeEnum = other.getTimingTypeEnum();
      if (this$timingTypeEnum == null ? other$timingTypeEnum == null : this$timingTypeEnum.equals(other$timingTypeEnum)) {
         Object this$durationOrTimeTypeEnum = this.getDurationOrTimeTypeEnum();
         Object other$durationOrTimeTypeEnum = other.getDurationOrTimeTypeEnum();
         if (this$durationOrTimeTypeEnum == null ? other$durationOrTimeTypeEnum == null : this$durationOrTimeTypeEnum.equals(other$durationOrTimeTypeEnum)) {
            Object this$durationTypeEnum = this.getDurationTypeEnum();
            Object other$durationTypeEnum = other.getDurationTypeEnum();
            if (this$durationTypeEnum == null ? other$durationTypeEnum == null : this$durationTypeEnum.equals(other$durationTypeEnum)) {
               Object this$duration = this.getDuration();
               Object other$duration = other.getDuration();
               if (this$duration == null ? other$duration == null : this$duration.equals(other$duration)) {
                  Object this$time = this.getTime();
                  Object other$time = other.getTime();
                  return this$time == null ? other$time == null : this$time.equals(other$time);
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
      return other instanceof PushNotificationTimingConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $timingTypeEnum = this.getTimingTypeEnum();
      result = result * 59 + ($timingTypeEnum == null ? 43 : $timingTypeEnum.hashCode());
      Object $durationOrTimeTypeEnum = this.getDurationOrTimeTypeEnum();
      result = result * 59 + ($durationOrTimeTypeEnum == null ? 43 : $durationOrTimeTypeEnum.hashCode());
      Object $durationTypeEnum = this.getDurationTypeEnum();
      result = result * 59 + ($durationTypeEnum == null ? 43 : $durationTypeEnum.hashCode());
      Object $duration = this.getDuration();
      result = result * 59 + ($duration == null ? 43 : $duration.hashCode());
      Object $time = this.getTime();
      return result * 59 + ($time == null ? 43 : $time.hashCode());
   }

   @Override
   public String toString() {
      return "PushNotificationTimingConfigDTO(timingTypeEnum="
         + this.getTimingTypeEnum()
         + ", durationOrTimeTypeEnum="
         + this.getDurationOrTimeTypeEnum()
         + ", durationTypeEnum="
         + this.getDurationTypeEnum()
         + ", duration="
         + this.getDuration()
         + ", time="
         + this.getTime()
         + ")";
   }
}
