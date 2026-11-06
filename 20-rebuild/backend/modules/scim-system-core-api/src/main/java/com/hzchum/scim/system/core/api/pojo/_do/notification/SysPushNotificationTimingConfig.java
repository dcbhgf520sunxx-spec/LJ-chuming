package com.hzchum.scim.system.core.api.pojo._do.notification;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SysPushNotificationTimingConfig对象", description = "")
@Entity
@TableName("sys_push_notification_timing_config")
@Table(name = "sys_push_notification_timing_config")
@org.hibernate.annotations.Table(appliesTo = "sys_push_notification_timing_config")
public class SysPushNotificationTimingConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "timingTypeEnum", value = "定时方式（前置或者是后置）", notes = "定时方式（前置或者是后置）")
   @TableField("timing_type_enum")
   @Column(name = "timing_type_enum", columnDefinition = "int(11)  COMMENT '定时方式（前置或者是后置）'", nullable = false)
   private Integer timingTypeEnum;
   @ApiModelProperty(name = "durationOrTimeTypeEnum", value = "配置时长或是时间", notes = "配置时长或是时间")
   @TableField("duration_or_time_type_enum")
   @Column(name = "duration_or_time_type_enum", columnDefinition = "int(11)  COMMENT '配置时长或是时间'", nullable = false)
   private Integer durationOrTimeTypeEnum;
   @ApiModelProperty(name = "duration", value = "时长", notes = "时长")
   @TableField("duration")
   @Column(name = "duration", columnDefinition = "int(11)  COMMENT '时长'", nullable = true)
   private Long duration;
   @ApiModelProperty(name = "duration_type", value = "", notes = "时长")
   @TableField("duration_type")
   @Column(name = "duration_type", columnDefinition = "int(11)  COMMENT '时长'", nullable = true)
   private Integer durationType;
   @ApiModelProperty(name = "time", value = "时间", notes = "时间")
   @TableField("time")
   @Column(name = "time", columnDefinition = "time  COMMENT '时间'", nullable = true)
   private LocalTime time;
   @ApiModelProperty(name = "sysPushNotificationConfigId", value = "配置表id", notes = "配置表id")
   @TableField("sys_push_notification_config_id")
   @Column(name = "sys_push_notification_config_id", columnDefinition = "bigint(20)  COMMENT '配置表id'", nullable = false)
   private Long sysPushNotificationConfigId;

   public static SysPushNotificationTimingConfig.SysPushNotificationTimingConfigBuilder builder() {
      return new SysPushNotificationTimingConfig.SysPushNotificationTimingConfigBuilder();
   }

   public SysPushNotificationTimingConfig() {
   }

   public SysPushNotificationTimingConfig(
      final Long id,
      final Integer timingTypeEnum,
      final Integer durationOrTimeTypeEnum,
      final Long duration,
      final Integer durationType,
      final LocalTime time,
      final Long sysPushNotificationConfigId
   ) {
      this.id = id;
      this.timingTypeEnum = timingTypeEnum;
      this.durationOrTimeTypeEnum = durationOrTimeTypeEnum;
      this.duration = duration;
      this.durationType = durationType;
      this.time = time;
      this.sysPushNotificationConfigId = sysPushNotificationConfigId;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getTimingTypeEnum() {
      return this.timingTypeEnum;
   }

   public Integer getDurationOrTimeTypeEnum() {
      return this.durationOrTimeTypeEnum;
   }

   public Long getDuration() {
      return this.duration;
   }

   public Integer getDurationType() {
      return this.durationType;
   }

   public LocalTime getTime() {
      return this.time;
   }

   public Long getSysPushNotificationConfigId() {
      return this.sysPushNotificationConfigId;
   }

   public SysPushNotificationTimingConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysPushNotificationTimingConfig setTimingTypeEnum(final Integer timingTypeEnum) {
      this.timingTypeEnum = timingTypeEnum;
      return this;
   }

   public SysPushNotificationTimingConfig setDurationOrTimeTypeEnum(final Integer durationOrTimeTypeEnum) {
      this.durationOrTimeTypeEnum = durationOrTimeTypeEnum;
      return this;
   }

   public SysPushNotificationTimingConfig setDuration(final Long duration) {
      this.duration = duration;
      return this;
   }

   public SysPushNotificationTimingConfig setDurationType(final Integer durationType) {
      this.durationType = durationType;
      return this;
   }

   public SysPushNotificationTimingConfig setTime(final LocalTime time) {
      this.time = time;
      return this;
   }

   public SysPushNotificationTimingConfig setSysPushNotificationConfigId(final Long sysPushNotificationConfigId) {
      this.sysPushNotificationConfigId = sysPushNotificationConfigId;
      return this;
   }

   @Override
   public String toString() {
      return "SysPushNotificationTimingConfig(id="
         + this.getId()
         + ", timingTypeEnum="
         + this.getTimingTypeEnum()
         + ", durationOrTimeTypeEnum="
         + this.getDurationOrTimeTypeEnum()
         + ", duration="
         + this.getDuration()
         + ", durationType="
         + this.getDurationType()
         + ", time="
         + this.getTime()
         + ", sysPushNotificationConfigId="
         + this.getSysPushNotificationConfigId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushNotificationTimingConfig)) {
         return false;
      }

      SysPushNotificationTimingConfig other = (SysPushNotificationTimingConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$timingTypeEnum = this.getTimingTypeEnum();
         Object other$timingTypeEnum = other.getTimingTypeEnum();
         if (this$timingTypeEnum == null ? other$timingTypeEnum == null : this$timingTypeEnum.equals(other$timingTypeEnum)) {
            Object this$durationOrTimeTypeEnum = this.getDurationOrTimeTypeEnum();
            Object other$durationOrTimeTypeEnum = other.getDurationOrTimeTypeEnum();
            if (this$durationOrTimeTypeEnum == null ? other$durationOrTimeTypeEnum == null : this$durationOrTimeTypeEnum.equals(other$durationOrTimeTypeEnum)) {
               Object this$duration = this.getDuration();
               Object other$duration = other.getDuration();
               if (this$duration == null ? other$duration == null : this$duration.equals(other$duration)) {
                  Object this$durationType = this.getDurationType();
                  Object other$durationType = other.getDurationType();
                  if (this$durationType == null ? other$durationType == null : this$durationType.equals(other$durationType)) {
                     Object this$sysPushNotificationConfigId = this.getSysPushNotificationConfigId();
                     Object other$sysPushNotificationConfigId = other.getSysPushNotificationConfigId();
                     if (this$sysPushNotificationConfigId == null
                        ? other$sysPushNotificationConfigId == null
                        : this$sysPushNotificationConfigId.equals(other$sysPushNotificationConfigId)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysPushNotificationTimingConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $timingTypeEnum = this.getTimingTypeEnum();
      result = result * 59 + ($timingTypeEnum == null ? 43 : $timingTypeEnum.hashCode());
      Object $durationOrTimeTypeEnum = this.getDurationOrTimeTypeEnum();
      result = result * 59 + ($durationOrTimeTypeEnum == null ? 43 : $durationOrTimeTypeEnum.hashCode());
      Object $duration = this.getDuration();
      result = result * 59 + ($duration == null ? 43 : $duration.hashCode());
      Object $durationType = this.getDurationType();
      result = result * 59 + ($durationType == null ? 43 : $durationType.hashCode());
      Object $sysPushNotificationConfigId = this.getSysPushNotificationConfigId();
      result = result * 59 + ($sysPushNotificationConfigId == null ? 43 : $sysPushNotificationConfigId.hashCode());
      Object $time = this.getTime();
      return result * 59 + ($time == null ? 43 : $time.hashCode());
   }

   public static class SysPushNotificationTimingConfigBuilder {
      private Long id;
      private Integer timingTypeEnum;
      private Integer durationOrTimeTypeEnum;
      private Long duration;
      private Integer durationType;
      private LocalTime time;
      private Long sysPushNotificationConfigId;

      SysPushNotificationTimingConfigBuilder() {
      }

      public SysPushNotificationTimingConfig.SysPushNotificationTimingConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushNotificationTimingConfig.SysPushNotificationTimingConfigBuilder timingTypeEnum(final Integer timingTypeEnum) {
         this.timingTypeEnum = timingTypeEnum;
         return this;
      }

      public SysPushNotificationTimingConfig.SysPushNotificationTimingConfigBuilder durationOrTimeTypeEnum(final Integer durationOrTimeTypeEnum) {
         this.durationOrTimeTypeEnum = durationOrTimeTypeEnum;
         return this;
      }

      public SysPushNotificationTimingConfig.SysPushNotificationTimingConfigBuilder duration(final Long duration) {
         this.duration = duration;
         return this;
      }

      public SysPushNotificationTimingConfig.SysPushNotificationTimingConfigBuilder durationType(final Integer durationType) {
         this.durationType = durationType;
         return this;
      }

      public SysPushNotificationTimingConfig.SysPushNotificationTimingConfigBuilder time(final LocalTime time) {
         this.time = time;
         return this;
      }

      public SysPushNotificationTimingConfig.SysPushNotificationTimingConfigBuilder sysPushNotificationConfigId(final Long sysPushNotificationConfigId) {
         this.sysPushNotificationConfigId = sysPushNotificationConfigId;
         return this;
      }

      public SysPushNotificationTimingConfig build() {
         return new SysPushNotificationTimingConfig(
            this.id, this.timingTypeEnum, this.durationOrTimeTypeEnum, this.duration, this.durationType, this.time, this.sysPushNotificationConfigId
         );
      }

      @Override
      public String toString() {
         return "SysPushNotificationTimingConfig.SysPushNotificationTimingConfigBuilder(id="
            + this.id
            + ", timingTypeEnum="
            + this.timingTypeEnum
            + ", durationOrTimeTypeEnum="
            + this.durationOrTimeTypeEnum
            + ", duration="
            + this.duration
            + ", durationType="
            + this.durationType
            + ", time="
            + this.time
            + ", sysPushNotificationConfigId="
            + this.sysPushNotificationConfigId
            + ")";
      }
   }
}
