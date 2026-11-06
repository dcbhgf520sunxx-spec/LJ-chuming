package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "SysPushAppDetailsDTO", description = "app显示详情")
public class SysPushAppDetailsDTO {
   @ApiModelProperty(name = "recordId", value = "主表id", notes = "主表id")
   private Long recordId;
   @ApiModelProperty(name = "userLinkId", value = "userLinkId", notes = "userLinkId")
   private Long userLinkId;
   @ApiModelProperty(name = "operationalModuleTypeEnum", value = "业务模块", notes = "业务模块")
   private Integer operationalModuleTypeEnum;
   @ApiModelProperty(name = "notificationTypeEnum", value = "通知业务", notes = "通知业务")
   private Integer notificationTypeEnum;
   @ApiModelProperty(name = "contentDetails", notes = "消息推送内容详情")
   private String contentDetails;
   @ApiModelProperty(name = "pushTime", notes = "推送时间")
   private LocalDateTime pushTime;
   @ApiModelProperty(name = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "userId", notes = "用户id")
   private Long userId;
   @ApiModelProperty(name = "serialNumber", notes = "编码")
   private String serialNumber;

   public static SysPushAppDetailsDTO.SysPushAppDetailsDTOBuilder builder() {
      return new SysPushAppDetailsDTO.SysPushAppDetailsDTOBuilder();
   }

   public SysPushAppDetailsDTO() {
   }

   public SysPushAppDetailsDTO(
      final Long recordId,
      final Long userLinkId,
      final Integer operationalModuleTypeEnum,
      final Integer notificationTypeEnum,
      final String contentDetails,
      final LocalDateTime pushTime,
      final Long projectId,
      final Long userId,
      final String serialNumber
   ) {
      this.recordId = recordId;
      this.userLinkId = userLinkId;
      this.operationalModuleTypeEnum = operationalModuleTypeEnum;
      this.notificationTypeEnum = notificationTypeEnum;
      this.contentDetails = contentDetails;
      this.pushTime = pushTime;
      this.projectId = projectId;
      this.userId = userId;
      this.serialNumber = serialNumber;
   }

   public Long getRecordId() {
      return this.recordId;
   }

   public Long getUserLinkId() {
      return this.userLinkId;
   }

   public Integer getOperationalModuleTypeEnum() {
      return this.operationalModuleTypeEnum;
   }

   public Integer getNotificationTypeEnum() {
      return this.notificationTypeEnum;
   }

   public String getContentDetails() {
      return this.contentDetails;
   }

   public LocalDateTime getPushTime() {
      return this.pushTime;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public SysPushAppDetailsDTO setRecordId(final Long recordId) {
      this.recordId = recordId;
      return this;
   }

   public SysPushAppDetailsDTO setUserLinkId(final Long userLinkId) {
      this.userLinkId = userLinkId;
      return this;
   }

   public SysPushAppDetailsDTO setOperationalModuleTypeEnum(final Integer operationalModuleTypeEnum) {
      this.operationalModuleTypeEnum = operationalModuleTypeEnum;
      return this;
   }

   public SysPushAppDetailsDTO setNotificationTypeEnum(final Integer notificationTypeEnum) {
      this.notificationTypeEnum = notificationTypeEnum;
      return this;
   }

   public SysPushAppDetailsDTO setContentDetails(final String contentDetails) {
      this.contentDetails = contentDetails;
      return this;
   }

   public SysPushAppDetailsDTO setPushTime(final LocalDateTime pushTime) {
      this.pushTime = pushTime;
      return this;
   }

   public SysPushAppDetailsDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public SysPushAppDetailsDTO setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public SysPushAppDetailsDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushAppDetailsDTO)) {
         return false;
      }

      SysPushAppDetailsDTO other = (SysPushAppDetailsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$recordId = this.getRecordId();
      Object other$recordId = other.getRecordId();
      if (this$recordId == null ? other$recordId == null : this$recordId.equals(other$recordId)) {
         Object this$userLinkId = this.getUserLinkId();
         Object other$userLinkId = other.getUserLinkId();
         if (this$userLinkId == null ? other$userLinkId == null : this$userLinkId.equals(other$userLinkId)) {
            Object this$operationalModuleTypeEnum = this.getOperationalModuleTypeEnum();
            Object other$operationalModuleTypeEnum = other.getOperationalModuleTypeEnum();
            if (this$operationalModuleTypeEnum == null
               ? other$operationalModuleTypeEnum == null
               : this$operationalModuleTypeEnum.equals(other$operationalModuleTypeEnum)) {
               Object this$notificationTypeEnum = this.getNotificationTypeEnum();
               Object other$notificationTypeEnum = other.getNotificationTypeEnum();
               if (this$notificationTypeEnum == null ? other$notificationTypeEnum == null : this$notificationTypeEnum.equals(other$notificationTypeEnum)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$contentDetails = this.getContentDetails();
                        Object other$contentDetails = other.getContentDetails();
                        if (this$contentDetails == null ? other$contentDetails == null : this$contentDetails.equals(other$contentDetails)) {
                           Object this$pushTime = this.getPushTime();
                           Object other$pushTime = other.getPushTime();
                           if (this$pushTime == null ? other$pushTime == null : this$pushTime.equals(other$pushTime)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              return this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof SysPushAppDetailsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $recordId = this.getRecordId();
      result = result * 59 + ($recordId == null ? 43 : $recordId.hashCode());
      Object $userLinkId = this.getUserLinkId();
      result = result * 59 + ($userLinkId == null ? 43 : $userLinkId.hashCode());
      Object $operationalModuleTypeEnum = this.getOperationalModuleTypeEnum();
      result = result * 59 + ($operationalModuleTypeEnum == null ? 43 : $operationalModuleTypeEnum.hashCode());
      Object $notificationTypeEnum = this.getNotificationTypeEnum();
      result = result * 59 + ($notificationTypeEnum == null ? 43 : $notificationTypeEnum.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $contentDetails = this.getContentDetails();
      result = result * 59 + ($contentDetails == null ? 43 : $contentDetails.hashCode());
      Object $pushTime = this.getPushTime();
      result = result * 59 + ($pushTime == null ? 43 : $pushTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "SysPushAppDetailsDTO(recordId="
         + this.getRecordId()
         + ", userLinkId="
         + this.getUserLinkId()
         + ", operationalModuleTypeEnum="
         + this.getOperationalModuleTypeEnum()
         + ", notificationTypeEnum="
         + this.getNotificationTypeEnum()
         + ", contentDetails="
         + this.getContentDetails()
         + ", pushTime="
         + this.getPushTime()
         + ", projectId="
         + this.getProjectId()
         + ", userId="
         + this.getUserId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ")";
   }

   public static class SysPushAppDetailsDTOBuilder {
      private Long recordId;
      private Long userLinkId;
      private Integer operationalModuleTypeEnum;
      private Integer notificationTypeEnum;
      private String contentDetails;
      private LocalDateTime pushTime;
      private Long projectId;
      private Long userId;
      private String serialNumber;

      SysPushAppDetailsDTOBuilder() {
      }

      public SysPushAppDetailsDTO.SysPushAppDetailsDTOBuilder recordId(final Long recordId) {
         this.recordId = recordId;
         return this;
      }

      public SysPushAppDetailsDTO.SysPushAppDetailsDTOBuilder userLinkId(final Long userLinkId) {
         this.userLinkId = userLinkId;
         return this;
      }

      public SysPushAppDetailsDTO.SysPushAppDetailsDTOBuilder operationalModuleTypeEnum(final Integer operationalModuleTypeEnum) {
         this.operationalModuleTypeEnum = operationalModuleTypeEnum;
         return this;
      }

      public SysPushAppDetailsDTO.SysPushAppDetailsDTOBuilder notificationTypeEnum(final Integer notificationTypeEnum) {
         this.notificationTypeEnum = notificationTypeEnum;
         return this;
      }

      public SysPushAppDetailsDTO.SysPushAppDetailsDTOBuilder contentDetails(final String contentDetails) {
         this.contentDetails = contentDetails;
         return this;
      }

      public SysPushAppDetailsDTO.SysPushAppDetailsDTOBuilder pushTime(final LocalDateTime pushTime) {
         this.pushTime = pushTime;
         return this;
      }

      public SysPushAppDetailsDTO.SysPushAppDetailsDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SysPushAppDetailsDTO.SysPushAppDetailsDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public SysPushAppDetailsDTO.SysPushAppDetailsDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SysPushAppDetailsDTO build() {
         return new SysPushAppDetailsDTO(
            this.recordId,
            this.userLinkId,
            this.operationalModuleTypeEnum,
            this.notificationTypeEnum,
            this.contentDetails,
            this.pushTime,
            this.projectId,
            this.userId,
            this.serialNumber
         );
      }

      @Override
      public String toString() {
         return "SysPushAppDetailsDTO.SysPushAppDetailsDTOBuilder(recordId="
            + this.recordId
            + ", userLinkId="
            + this.userLinkId
            + ", operationalModuleTypeEnum="
            + this.operationalModuleTypeEnum
            + ", notificationTypeEnum="
            + this.notificationTypeEnum
            + ", contentDetails="
            + this.contentDetails
            + ", pushTime="
            + this.pushTime
            + ", projectId="
            + this.projectId
            + ", userId="
            + this.userId
            + ", serialNumber="
            + this.serialNumber
            + ")";
      }
   }
}
