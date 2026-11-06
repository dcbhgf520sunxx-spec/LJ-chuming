package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class PushNotificationConfigDetailDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "status", notes = "启用状态")
   private Boolean status;
   @ApiModelProperty(name = "notificationModeTypeEnum", notes = "通知方式")
   private Integer notificationModeTypeEnum;
   @ApiModelProperty(name = "suitableObjectTypeEnum", notes = "适用对象")
   private Integer suitableObjectTypeEnum;
   @ApiModelProperty(name = "duration", notes = "时长")
   private Integer duration;
   @ApiModelProperty(name = "number", value = "定时时的数量", notes = "定时时的数量")
   private Integer number;
   @ApiModelProperty(name = "timeTypeEnum", notes = "时间类型")
   private Integer timeTypeEnum;
   @ApiModelProperty(name = "pushNotificationTimingConfigDTO", notes = "定时类型的还需配置时间信息")
   private PushNotificationTimingConfigDTO pushNotificationTimingConfigDTO;
   @ApiModelProperty(name = "suitableObjectCommonDTOList", notes = "适用对象信息通用集合")
   private List<SuitableObjectCommonDTO> suitableObjectCommonDTOList;

   public Long getId() {
      return this.id;
   }

   public Boolean getStatus() {
      return this.status;
   }

   public Integer getNotificationModeTypeEnum() {
      return this.notificationModeTypeEnum;
   }

   public Integer getSuitableObjectTypeEnum() {
      return this.suitableObjectTypeEnum;
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

   public PushNotificationTimingConfigDTO getPushNotificationTimingConfigDTO() {
      return this.pushNotificationTimingConfigDTO;
   }

   public List<SuitableObjectCommonDTO> getSuitableObjectCommonDTOList() {
      return this.suitableObjectCommonDTOList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setStatus(final Boolean status) {
      this.status = status;
   }

   public void setNotificationModeTypeEnum(final Integer notificationModeTypeEnum) {
      this.notificationModeTypeEnum = notificationModeTypeEnum;
   }

   public void setSuitableObjectTypeEnum(final Integer suitableObjectTypeEnum) {
      this.suitableObjectTypeEnum = suitableObjectTypeEnum;
   }

   public void setDuration(final Integer duration) {
      this.duration = duration;
   }

   public void setNumber(final Integer number) {
      this.number = number;
   }

   public void setTimeTypeEnum(final Integer timeTypeEnum) {
      this.timeTypeEnum = timeTypeEnum;
   }

   public void setPushNotificationTimingConfigDTO(final PushNotificationTimingConfigDTO pushNotificationTimingConfigDTO) {
      this.pushNotificationTimingConfigDTO = pushNotificationTimingConfigDTO;
   }

   public void setSuitableObjectCommonDTOList(final List<SuitableObjectCommonDTO> suitableObjectCommonDTOList) {
      this.suitableObjectCommonDTOList = suitableObjectCommonDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PushNotificationConfigDetailDTO)) {
         return false;
      }

      PushNotificationConfigDetailDTO other = (PushNotificationConfigDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$notificationModeTypeEnum = this.getNotificationModeTypeEnum();
            Object other$notificationModeTypeEnum = other.getNotificationModeTypeEnum();
            if (this$notificationModeTypeEnum == null
               ? other$notificationModeTypeEnum == null
               : this$notificationModeTypeEnum.equals(other$notificationModeTypeEnum)) {
               Object this$suitableObjectTypeEnum = this.getSuitableObjectTypeEnum();
               Object other$suitableObjectTypeEnum = other.getSuitableObjectTypeEnum();
               if (this$suitableObjectTypeEnum == null
                  ? other$suitableObjectTypeEnum == null
                  : this$suitableObjectTypeEnum.equals(other$suitableObjectTypeEnum)) {
                  Object this$duration = this.getDuration();
                  Object other$duration = other.getDuration();
                  if (this$duration == null ? other$duration == null : this$duration.equals(other$duration)) {
                     Object this$number = this.getNumber();
                     Object other$number = other.getNumber();
                     if (this$number == null ? other$number == null : this$number.equals(other$number)) {
                        Object this$timeTypeEnum = this.getTimeTypeEnum();
                        Object other$timeTypeEnum = other.getTimeTypeEnum();
                        if (this$timeTypeEnum == null ? other$timeTypeEnum == null : this$timeTypeEnum.equals(other$timeTypeEnum)) {
                           Object this$pushNotificationTimingConfigDTO = this.getPushNotificationTimingConfigDTO();
                           Object other$pushNotificationTimingConfigDTO = other.getPushNotificationTimingConfigDTO();
                           if (this$pushNotificationTimingConfigDTO == null
                              ? other$pushNotificationTimingConfigDTO == null
                              : this$pushNotificationTimingConfigDTO.equals(other$pushNotificationTimingConfigDTO)) {
                              Object this$suitableObjectCommonDTOList = this.getSuitableObjectCommonDTOList();
                              Object other$suitableObjectCommonDTOList = other.getSuitableObjectCommonDTOList();
                              return this$suitableObjectCommonDTOList == null
                                 ? other$suitableObjectCommonDTOList == null
                                 : this$suitableObjectCommonDTOList.equals(other$suitableObjectCommonDTOList);
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
      return other instanceof PushNotificationConfigDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $notificationModeTypeEnum = this.getNotificationModeTypeEnum();
      result = result * 59 + ($notificationModeTypeEnum == null ? 43 : $notificationModeTypeEnum.hashCode());
      Object $suitableObjectTypeEnum = this.getSuitableObjectTypeEnum();
      result = result * 59 + ($suitableObjectTypeEnum == null ? 43 : $suitableObjectTypeEnum.hashCode());
      Object $duration = this.getDuration();
      result = result * 59 + ($duration == null ? 43 : $duration.hashCode());
      Object $number = this.getNumber();
      result = result * 59 + ($number == null ? 43 : $number.hashCode());
      Object $timeTypeEnum = this.getTimeTypeEnum();
      result = result * 59 + ($timeTypeEnum == null ? 43 : $timeTypeEnum.hashCode());
      Object $pushNotificationTimingConfigDTO = this.getPushNotificationTimingConfigDTO();
      result = result * 59 + ($pushNotificationTimingConfigDTO == null ? 43 : $pushNotificationTimingConfigDTO.hashCode());
      Object $suitableObjectCommonDTOList = this.getSuitableObjectCommonDTOList();
      return result * 59 + ($suitableObjectCommonDTOList == null ? 43 : $suitableObjectCommonDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "PushNotificationConfigDetailDTO(id="
         + this.getId()
         + ", status="
         + this.getStatus()
         + ", notificationModeTypeEnum="
         + this.getNotificationModeTypeEnum()
         + ", suitableObjectTypeEnum="
         + this.getSuitableObjectTypeEnum()
         + ", duration="
         + this.getDuration()
         + ", number="
         + this.getNumber()
         + ", timeTypeEnum="
         + this.getTimeTypeEnum()
         + ", pushNotificationTimingConfigDTO="
         + this.getPushNotificationTimingConfigDTO()
         + ", suitableObjectCommonDTOList="
         + this.getSuitableObjectCommonDTOList()
         + ")";
   }

   public PushNotificationConfigDetailDTO(
      final Long id,
      final Boolean status,
      final Integer notificationModeTypeEnum,
      final Integer suitableObjectTypeEnum,
      final Integer duration,
      final Integer number,
      final Integer timeTypeEnum,
      final PushNotificationTimingConfigDTO pushNotificationTimingConfigDTO,
      final List<SuitableObjectCommonDTO> suitableObjectCommonDTOList
   ) {
      this.id = id;
      this.status = status;
      this.notificationModeTypeEnum = notificationModeTypeEnum;
      this.suitableObjectTypeEnum = suitableObjectTypeEnum;
      this.duration = duration;
      this.number = number;
      this.timeTypeEnum = timeTypeEnum;
      this.pushNotificationTimingConfigDTO = pushNotificationTimingConfigDTO;
      this.suitableObjectCommonDTOList = suitableObjectCommonDTOList;
   }

   public PushNotificationConfigDetailDTO() {
   }
}
