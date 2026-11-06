package com.hzchum.scim.system.core.api.pojo._do.notification;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SysPushNotificationConfig对象", description = "")
@Entity
@TableName("sys_push_notification_config")
@Table(name = "sys_push_notification_config")
@org.hibernate.annotations.Table(appliesTo = "sys_push_notification_config")
public class SysPushNotificationConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "operationalModuleTypeEnum", value = "业务所属模块", notes = "业务所属模块")
   @TableField("operational_module_type_enum")
   @Column(name = "operational_module_type_enum", columnDefinition = "int(11)  COMMENT '业务所属模块'", nullable = false)
   private Integer operationalModuleTypeEnum;
   @ApiModelProperty(name = "notificationTypeEnum", value = "通知业务", notes = "通知业务")
   @TableField("notification_type_enum")
   @Column(name = "notification_type_enum", columnDefinition = "int(11)  COMMENT '通知业务'", nullable = false)
   private Integer notificationTypeEnum;
   @ApiModelProperty(name = "status", value = "启用状态", notes = "启用状态")
   @TableField("status")
   @Column(name = "status", columnDefinition = "tinyint(1) default '1' COMMENT '启用状态'", nullable = false)
   private Boolean status;
   @ApiModelProperty(name = "suitableObjectTypeEnum", value = "适用对象 使用枚举 0为系统固定", notes = "适用对象 使用枚举 0为系统固定")
   @TableField("suitable_object_type_enum")
   @Column(name = "suitable_object_type_enum", columnDefinition = "int(11)  COMMENT '适用对象 使用枚举 0为系统固定'")
   private Integer suitableObjectTypeEnum;
   @ApiModelProperty(name = "notificationModeTypeEnum", value = "通知方式", notes = "通知方式")
   @TableField("notification_mode_type_enum")
   @Column(name = "notification_mode_type_enum", columnDefinition = "int(11)  COMMENT '通知方式'")
   private Integer notificationModeTypeEnum;
   @ApiModelProperty(name = "duration", notes = "时长")
   @TableField("duration")
   @Column(name = "duration", columnDefinition = "int(11) default 0 COMMENT '时长'")
   private Integer duration;
   @ApiModelProperty(name = "number", value = "定数时的数量", notes = "定数时的数量")
   @TableField("number")
   @Column(name = "number", columnDefinition = "int(11) default 0 COMMENT '定数时的数量'")
   private Integer number;
   @ApiModelProperty(name = "timeTypeEnum", notes = "时间类型")
   @TableField("time_type_Enum")
   @Column(name = "time_type_Enum", columnDefinition = "tinyint(1) COMMENT '时间类型'")
   private Integer timeTypeEnum;

   public static SysPushNotificationConfig.SysPushNotificationConfigBuilder builder() {
      return new SysPushNotificationConfig.SysPushNotificationConfigBuilder();
   }

   public SysPushNotificationConfig() {
   }

   public SysPushNotificationConfig(
      final Long id,
      final Integer operationalModuleTypeEnum,
      final Integer notificationTypeEnum,
      final Boolean status,
      final Integer suitableObjectTypeEnum,
      final Integer notificationModeTypeEnum,
      final Integer duration,
      final Integer number,
      final Integer timeTypeEnum
   ) {
      this.id = id;
      this.operationalModuleTypeEnum = operationalModuleTypeEnum;
      this.notificationTypeEnum = notificationTypeEnum;
      this.status = status;
      this.suitableObjectTypeEnum = suitableObjectTypeEnum;
      this.notificationModeTypeEnum = notificationModeTypeEnum;
      this.duration = duration;
      this.number = number;
      this.timeTypeEnum = timeTypeEnum;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getOperationalModuleTypeEnum() {
      return this.operationalModuleTypeEnum;
   }

   public Integer getNotificationTypeEnum() {
      return this.notificationTypeEnum;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Integer getSuitableObjectTypeEnum() {
      return this.suitableObjectTypeEnum;
   }

   public Integer getNotificationModeTypeEnum() {
      return this.notificationModeTypeEnum;
   }

   public Integer getDuration() {
      return this.duration;
   }

   public Integer getNumber() {
      return this.number;
   }

   public Integer getTimeTypeEnum() {
      return this.timeTypeEnum;
   }

   public SysPushNotificationConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysPushNotificationConfig setOperationalModuleTypeEnum(final Integer operationalModuleTypeEnum) {
      this.operationalModuleTypeEnum = operationalModuleTypeEnum;
      return this;
   }

   public SysPushNotificationConfig setNotificationTypeEnum(final Integer notificationTypeEnum) {
      this.notificationTypeEnum = notificationTypeEnum;
      return this;
   }

   public SysPushNotificationConfig setStatus(final Boolean status) {
      this.status = status;
      return this;
   }

   public SysPushNotificationConfig setSuitableObjectTypeEnum(final Integer suitableObjectTypeEnum) {
      this.suitableObjectTypeEnum = suitableObjectTypeEnum;
      return this;
   }

   public SysPushNotificationConfig setNotificationModeTypeEnum(final Integer notificationModeTypeEnum) {
      this.notificationModeTypeEnum = notificationModeTypeEnum;
      return this;
   }

   public SysPushNotificationConfig setDuration(final Integer duration) {
      this.duration = duration;
      return this;
   }

   public SysPushNotificationConfig setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   public SysPushNotificationConfig setTimeTypeEnum(final Integer timeTypeEnum) {
      this.timeTypeEnum = timeTypeEnum;
      return this;
   }

   @Override
   public String toString() {
      return "SysPushNotificationConfig(id="
         + this.getId()
         + ", operationalModuleTypeEnum="
         + this.getOperationalModuleTypeEnum()
         + ", notificationTypeEnum="
         + this.getNotificationTypeEnum()
         + ", status="
         + this.getStatus()
         + ", suitableObjectTypeEnum="
         + this.getSuitableObjectTypeEnum()
         + ", notificationModeTypeEnum="
         + this.getNotificationModeTypeEnum()
         + ", duration="
         + this.getDuration()
         + ", number="
         + this.getNumber()
         + ", timeTypeEnum="
         + this.getTimeTypeEnum()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushNotificationConfig)) {
         return false;
      }

      SysPushNotificationConfig other = (SysPushNotificationConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$operationalModuleTypeEnum = this.getOperationalModuleTypeEnum();
         Object other$operationalModuleTypeEnum = other.getOperationalModuleTypeEnum();
         if (this$operationalModuleTypeEnum == null
            ? other$operationalModuleTypeEnum == null
            : this$operationalModuleTypeEnum.equals(other$operationalModuleTypeEnum)) {
            Object this$notificationTypeEnum = this.getNotificationTypeEnum();
            Object other$notificationTypeEnum = other.getNotificationTypeEnum();
            if (this$notificationTypeEnum == null ? other$notificationTypeEnum == null : this$notificationTypeEnum.equals(other$notificationTypeEnum)) {
               Object this$status = this.getStatus();
               Object other$status = other.getStatus();
               if (this$status == null ? other$status == null : this$status.equals(other$status)) {
                  Object this$suitableObjectTypeEnum = this.getSuitableObjectTypeEnum();
                  Object other$suitableObjectTypeEnum = other.getSuitableObjectTypeEnum();
                  if (this$suitableObjectTypeEnum == null
                     ? other$suitableObjectTypeEnum == null
                     : this$suitableObjectTypeEnum.equals(other$suitableObjectTypeEnum)) {
                     Object this$notificationModeTypeEnum = this.getNotificationModeTypeEnum();
                     Object other$notificationModeTypeEnum = other.getNotificationModeTypeEnum();
                     if (this$notificationModeTypeEnum == null
                        ? other$notificationModeTypeEnum == null
                        : this$notificationModeTypeEnum.equals(other$notificationModeTypeEnum)) {
                        Object this$duration = this.getDuration();
                        Object other$duration = other.getDuration();
                        if (this$duration == null ? other$duration == null : this$duration.equals(other$duration)) {
                           Object this$number = this.getNumber();
                           Object other$number = other.getNumber();
                           if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                              Object this$timeTypeEnum = this.getTimeTypeEnum();
                              Object other$timeTypeEnum = other.getTimeTypeEnum();
                              return this$timeTypeEnum == null ? other$timeTypeEnum == null : this$timeTypeEnum.equals(other$timeTypeEnum);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysPushNotificationConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $operationalModuleTypeEnum = this.getOperationalModuleTypeEnum();
      result = result * 59 + ($operationalModuleTypeEnum == null ? 43 : $operationalModuleTypeEnum.hashCode());
      Object $notificationTypeEnum = this.getNotificationTypeEnum();
      result = result * 59 + ($notificationTypeEnum == null ? 43 : $notificationTypeEnum.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $suitableObjectTypeEnum = this.getSuitableObjectTypeEnum();
      result = result * 59 + ($suitableObjectTypeEnum == null ? 43 : $suitableObjectTypeEnum.hashCode());
      Object $notificationModeTypeEnum = this.getNotificationModeTypeEnum();
      result = result * 59 + ($notificationModeTypeEnum == null ? 43 : $notificationModeTypeEnum.hashCode());
      Object $duration = this.getDuration();
      result = result * 59 + ($duration == null ? 43 : $duration.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $timeTypeEnum = this.getTimeTypeEnum();
      return result * 59 + ($timeTypeEnum == null ? 43 : $timeTypeEnum.hashCode());
   }

   public static class SysPushNotificationConfigBuilder {
      private Long id;
      private Integer operationalModuleTypeEnum;
      private Integer notificationTypeEnum;
      private Boolean status;
      private Integer suitableObjectTypeEnum;
      private Integer notificationModeTypeEnum;
      private Integer duration;
      private Integer number;
      private Integer timeTypeEnum;

      SysPushNotificationConfigBuilder() {
      }

      public SysPushNotificationConfig.SysPushNotificationConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushNotificationConfig.SysPushNotificationConfigBuilder operationalModuleTypeEnum(final Integer operationalModuleTypeEnum) {
         this.operationalModuleTypeEnum = operationalModuleTypeEnum;
         return this;
      }

      public SysPushNotificationConfig.SysPushNotificationConfigBuilder notificationTypeEnum(final Integer notificationTypeEnum) {
         this.notificationTypeEnum = notificationTypeEnum;
         return this;
      }

      public SysPushNotificationConfig.SysPushNotificationConfigBuilder status(final Boolean status) {
         this.status = status;
         return this;
      }

      public SysPushNotificationConfig.SysPushNotificationConfigBuilder suitableObjectTypeEnum(final Integer suitableObjectTypeEnum) {
         this.suitableObjectTypeEnum = suitableObjectTypeEnum;
         return this;
      }

      public SysPushNotificationConfig.SysPushNotificationConfigBuilder notificationModeTypeEnum(final Integer notificationModeTypeEnum) {
         this.notificationModeTypeEnum = notificationModeTypeEnum;
         return this;
      }

      public SysPushNotificationConfig.SysPushNotificationConfigBuilder duration(final Integer duration) {
         this.duration = duration;
         return this;
      }

      public SysPushNotificationConfig.SysPushNotificationConfigBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public SysPushNotificationConfig.SysPushNotificationConfigBuilder timeTypeEnum(final Integer timeTypeEnum) {
         this.timeTypeEnum = timeTypeEnum;
         return this;
      }

      public SysPushNotificationConfig build() {
         return new SysPushNotificationConfig(
            this.id,
            this.operationalModuleTypeEnum,
            this.notificationTypeEnum,
            this.status,
            this.suitableObjectTypeEnum,
            this.notificationModeTypeEnum,
            this.duration,
            this.number,
            this.timeTypeEnum
         );
      }

      @Override
      public String toString() {
         return "SysPushNotificationConfig.SysPushNotificationConfigBuilder(id="
            + this.id
            + ", operationalModuleTypeEnum="
            + this.operationalModuleTypeEnum
            + ", notificationTypeEnum="
            + this.notificationTypeEnum
            + ", status="
            + this.status
            + ", suitableObjectTypeEnum="
            + this.suitableObjectTypeEnum
            + ", notificationModeTypeEnum="
            + this.notificationModeTypeEnum
            + ", duration="
            + this.duration
            + ", number="
            + this.number
            + ", timeTypeEnum="
            + this.timeTypeEnum
            + ")";
      }
   }
}
