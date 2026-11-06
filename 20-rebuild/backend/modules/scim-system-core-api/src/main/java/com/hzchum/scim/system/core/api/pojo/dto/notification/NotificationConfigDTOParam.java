package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "NotificationConfigDTOParam", description = "推送配置")
public class NotificationConfigDTOParam {
   @ApiModelProperty(name = "suitableObjectTypeEnum", notes = "适用对象（个人 部门 岗位 ）")
   private Integer suitableObjectTypeEnum;
   @ApiModelProperty(name = "suitableObjectIdList", notes = "适用对象id列表")
   private List<Long> suitableObjectIdList;
   @ApiModelProperty(name = "notificationModeTypeEnum", notes = "通知方式")
   private Integer notificationModeTypeEnum;
   @ApiModelProperty(name = "duration", notes = "通知方式为定时时设置的时间")
   private Integer duration;
   @ApiModelProperty(name = "number", notes = "通知方式为定数时设置的数量")
   private Integer number;
   @ApiModelProperty(name = "timeTypeEnum", notes = "时间类型")
   private Integer timeTypeEnum;

   public static NotificationConfigDTOParam.NotificationConfigDTOParamBuilder builder() {
      return new NotificationConfigDTOParam.NotificationConfigDTOParamBuilder();
   }

   public NotificationConfigDTOParam() {
   }

   public NotificationConfigDTOParam(
      final Integer suitableObjectTypeEnum,
      final List<Long> suitableObjectIdList,
      final Integer notificationModeTypeEnum,
      final Integer duration,
      final Integer number,
      final Integer timeTypeEnum
   ) {
      this.suitableObjectTypeEnum = suitableObjectTypeEnum;
      this.suitableObjectIdList = suitableObjectIdList;
      this.notificationModeTypeEnum = notificationModeTypeEnum;
      this.duration = duration;
      this.number = number;
      this.timeTypeEnum = timeTypeEnum;
   }

   public Integer getSuitableObjectTypeEnum() {
      return this.suitableObjectTypeEnum;
   }

   public List<Long> getSuitableObjectIdList() {
      return this.suitableObjectIdList;
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

   public NotificationConfigDTOParam setSuitableObjectTypeEnum(final Integer suitableObjectTypeEnum) {
      this.suitableObjectTypeEnum = suitableObjectTypeEnum;
      return this;
   }

   public NotificationConfigDTOParam setSuitableObjectIdList(final List<Long> suitableObjectIdList) {
      this.suitableObjectIdList = suitableObjectIdList;
      return this;
   }

   public NotificationConfigDTOParam setNotificationModeTypeEnum(final Integer notificationModeTypeEnum) {
      this.notificationModeTypeEnum = notificationModeTypeEnum;
      return this;
   }

   public NotificationConfigDTOParam setDuration(final Integer duration) {
      this.duration = duration;
      return this;
   }

   public NotificationConfigDTOParam setNumber(final Integer number) {
      this.number = number;
      return this;
   }

   public NotificationConfigDTOParam setTimeTypeEnum(final Integer timeTypeEnum) {
      this.timeTypeEnum = timeTypeEnum;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NotificationConfigDTOParam)) {
         return false;
      }

      NotificationConfigDTOParam other = (NotificationConfigDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$suitableObjectTypeEnum = this.getSuitableObjectTypeEnum();
      Object other$suitableObjectTypeEnum = other.getSuitableObjectTypeEnum();
      if (this$suitableObjectTypeEnum == null ? other$suitableObjectTypeEnum == null : this$suitableObjectTypeEnum.equals(other$suitableObjectTypeEnum)) {
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
                  if (this$timeTypeEnum == null ? other$timeTypeEnum == null : this$timeTypeEnum.equals(other$timeTypeEnum)) {
                     Object this$suitableObjectIdList = this.getSuitableObjectIdList();
                     Object other$suitableObjectIdList = other.getSuitableObjectIdList();
                     return this$suitableObjectIdList == null
                        ? other$suitableObjectIdList == null
                        : this$suitableObjectIdList.equals(other$suitableObjectIdList);
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
      return other instanceof NotificationConfigDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $suitableObjectTypeEnum = this.getSuitableObjectTypeEnum();
      result = result * 59 + ($suitableObjectTypeEnum == null ? 43 : $suitableObjectTypeEnum.hashCode());
      Object $notificationModeTypeEnum = this.getNotificationModeTypeEnum();
      result = result * 59 + ($notificationModeTypeEnum == null ? 43 : $notificationModeTypeEnum.hashCode());
      Object $duration = this.getDuration();
      result = result * 59 + ($duration == null ? 43 : $duration.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $timeTypeEnum = this.getTimeTypeEnum();
      result = result * 59 + ($timeTypeEnum == null ? 43 : $timeTypeEnum.hashCode());
      Object $suitableObjectIdList = this.getSuitableObjectIdList();
      return result * 59 + ($suitableObjectIdList == null ? 43 : $suitableObjectIdList.hashCode());
   }

   @Override
   public String toString() {
      return "NotificationConfigDTOParam(suitableObjectTypeEnum="
         + this.getSuitableObjectTypeEnum()
         + ", suitableObjectIdList="
         + this.getSuitableObjectIdList()
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

   public static class NotificationConfigDTOParamBuilder {
      private Integer suitableObjectTypeEnum;
      private List<Long> suitableObjectIdList;
      private Integer notificationModeTypeEnum;
      private Integer duration;
      private Integer number;
      private Integer timeTypeEnum;

      NotificationConfigDTOParamBuilder() {
      }

      public NotificationConfigDTOParam.NotificationConfigDTOParamBuilder suitableObjectTypeEnum(final Integer suitableObjectTypeEnum) {
         this.suitableObjectTypeEnum = suitableObjectTypeEnum;
         return this;
      }

      public NotificationConfigDTOParam.NotificationConfigDTOParamBuilder suitableObjectIdList(final List<Long> suitableObjectIdList) {
         this.suitableObjectIdList = suitableObjectIdList;
         return this;
      }

      public NotificationConfigDTOParam.NotificationConfigDTOParamBuilder notificationModeTypeEnum(final Integer notificationModeTypeEnum) {
         this.notificationModeTypeEnum = notificationModeTypeEnum;
         return this;
      }

      public NotificationConfigDTOParam.NotificationConfigDTOParamBuilder duration(final Integer duration) {
         this.duration = duration;
         return this;
      }

      public NotificationConfigDTOParam.NotificationConfigDTOParamBuilder number(final Integer number) {
         this.number = number;
         return this;
      }

      public NotificationConfigDTOParam.NotificationConfigDTOParamBuilder timeTypeEnum(final Integer timeTypeEnum) {
         this.timeTypeEnum = timeTypeEnum;
         return this;
      }

      public NotificationConfigDTOParam build() {
         return new NotificationConfigDTOParam(
            this.suitableObjectTypeEnum, this.suitableObjectIdList, this.notificationModeTypeEnum, this.duration, this.number, this.timeTypeEnum
         );
      }

      @Override
      public String toString() {
         return "NotificationConfigDTOParam.NotificationConfigDTOParamBuilder(suitableObjectTypeEnum="
            + this.suitableObjectTypeEnum
            + ", suitableObjectIdList="
            + this.suitableObjectIdList
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
