package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class NotificationServiceTriggerDTO {
   @ApiModelProperty(name = "projectId", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "projectId", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "dataId", notes = "数据id")
   private Long dataId;
   @ApiModelProperty(name = "dataId", notes = "创建人id")
   private Long createUserId;
   @ApiModelProperty(name = "contentDetails", notes = "消息推送内容详情")
   private StringBuffer contentDetails;
   @ApiModelProperty(name = "notificationTypeEnum", notes = "消息推送业务类型")
   private Integer notificationTypeEnum;
   @ApiModelProperty(name = "userList", notes = "人员id")
   private List<Long> userList;
   @ApiModelProperty(name = "userPhoneList", notes = "人员手机号")
   private List<String> userPhoneList;

   public static NotificationServiceTriggerDTO.NotificationServiceTriggerDTOBuilder builder() {
      return new NotificationServiceTriggerDTO.NotificationServiceTriggerDTOBuilder();
   }

   public NotificationServiceTriggerDTO() {
   }

   public NotificationServiceTriggerDTO(
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long dataId,
      final Long createUserId,
      final StringBuffer contentDetails,
      final Integer notificationTypeEnum,
      final List<Long> userList,
      final List<String> userPhoneList
   ) {
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.dataId = dataId;
      this.createUserId = createUserId;
      this.contentDetails = contentDetails;
      this.notificationTypeEnum = notificationTypeEnum;
      this.userList = userList;
      this.userPhoneList = userPhoneList;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getDataId() {
      return this.dataId;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public StringBuffer getContentDetails() {
      return this.contentDetails;
   }

   public Integer getNotificationTypeEnum() {
      return this.notificationTypeEnum;
   }

   public List<Long> getUserList() {
      return this.userList;
   }

   public List<String> getUserPhoneList() {
      return this.userPhoneList;
   }

   public NotificationServiceTriggerDTO setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public NotificationServiceTriggerDTO setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public NotificationServiceTriggerDTO setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public NotificationServiceTriggerDTO setDataId(final Long dataId) {
      this.dataId = dataId;
      return this;
   }

   public NotificationServiceTriggerDTO setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public NotificationServiceTriggerDTO setContentDetails(final StringBuffer contentDetails) {
      this.contentDetails = contentDetails;
      return this;
   }

   public NotificationServiceTriggerDTO setNotificationTypeEnum(final Integer notificationTypeEnum) {
      this.notificationTypeEnum = notificationTypeEnum;
      return this;
   }

   public NotificationServiceTriggerDTO setUserList(final List<Long> userList) {
      this.userList = userList;
      return this;
   }

   public NotificationServiceTriggerDTO setUserPhoneList(final List<String> userPhoneList) {
      this.userPhoneList = userPhoneList;
      return this;
   }

   @Override
   public String toString() {
      return "NotificationServiceTriggerDTO(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", dataId="
         + this.getDataId()
         + ", createUserId="
         + this.getCreateUserId()
         + ", contentDetails="
         + this.getContentDetails()
         + ", notificationTypeEnum="
         + this.getNotificationTypeEnum()
         + ", userList="
         + this.getUserList()
         + ", userPhoneList="
         + this.getUserPhoneList()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof NotificationServiceTriggerDTO)) {
         return false;
      }

      NotificationServiceTriggerDTO other = (NotificationServiceTriggerDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$dataId = this.getDataId();
               Object other$dataId = other.getDataId();
               if (this$dataId == null ? other$dataId == null : this$dataId.equals(other$dataId)) {
                  Object this$createUserId = this.getCreateUserId();
                  Object other$createUserId = other.getCreateUserId();
                  if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                     Object this$notificationTypeEnum = this.getNotificationTypeEnum();
                     Object other$notificationTypeEnum = other.getNotificationTypeEnum();
                     if (this$notificationTypeEnum == null ? other$notificationTypeEnum == null : this$notificationTypeEnum.equals(other$notificationTypeEnum)) {
                        Object this$contentDetails = this.getContentDetails();
                        Object other$contentDetails = other.getContentDetails();
                        if (this$contentDetails == null ? other$contentDetails == null : this$contentDetails.equals(other$contentDetails)) {
                           Object this$userList = this.getUserList();
                           Object other$userList = other.getUserList();
                           if (this$userList == null ? other$userList == null : this$userList.equals(other$userList)) {
                              Object this$userPhoneList = this.getUserPhoneList();
                              Object other$userPhoneList = other.getUserPhoneList();
                              return this$userPhoneList == null ? other$userPhoneList == null : this$userPhoneList.equals(other$userPhoneList);
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
      return other instanceof NotificationServiceTriggerDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $dataId = this.getDataId();
      result = result * 59 + ($dataId == null ? 43 : $dataId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $notificationTypeEnum = this.getNotificationTypeEnum();
      result = result * 59 + ($notificationTypeEnum == null ? 43 : $notificationTypeEnum.hashCode());
      Object $contentDetails = this.getContentDetails();
      result = result * 59 + ($contentDetails == null ? 43 : $contentDetails.hashCode());
      Object $userList = this.getUserList();
      result = result * 59 + ($userList == null ? 43 : $userList.hashCode());
      Object $userPhoneList = this.getUserPhoneList();
      return result * 59 + ($userPhoneList == null ? 43 : $userPhoneList.hashCode());
   }

   public static class NotificationServiceTriggerDTOBuilder {
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long dataId;
      private Long createUserId;
      private StringBuffer contentDetails;
      private Integer notificationTypeEnum;
      private List<Long> userList;
      private List<String> userPhoneList;

      NotificationServiceTriggerDTOBuilder() {
      }

      public NotificationServiceTriggerDTO.NotificationServiceTriggerDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public NotificationServiceTriggerDTO.NotificationServiceTriggerDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public NotificationServiceTriggerDTO.NotificationServiceTriggerDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public NotificationServiceTriggerDTO.NotificationServiceTriggerDTOBuilder dataId(final Long dataId) {
         this.dataId = dataId;
         return this;
      }

      public NotificationServiceTriggerDTO.NotificationServiceTriggerDTOBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public NotificationServiceTriggerDTO.NotificationServiceTriggerDTOBuilder contentDetails(final StringBuffer contentDetails) {
         this.contentDetails = contentDetails;
         return this;
      }

      public NotificationServiceTriggerDTO.NotificationServiceTriggerDTOBuilder notificationTypeEnum(final Integer notificationTypeEnum) {
         this.notificationTypeEnum = notificationTypeEnum;
         return this;
      }

      public NotificationServiceTriggerDTO.NotificationServiceTriggerDTOBuilder userList(final List<Long> userList) {
         this.userList = userList;
         return this;
      }

      public NotificationServiceTriggerDTO.NotificationServiceTriggerDTOBuilder userPhoneList(final List<String> userPhoneList) {
         this.userPhoneList = userPhoneList;
         return this;
      }

      public NotificationServiceTriggerDTO build() {
         return new NotificationServiceTriggerDTO(
            this.projectId,
            this.monomerId,
            this.areaId,
            this.dataId,
            this.createUserId,
            this.contentDetails,
            this.notificationTypeEnum,
            this.userList,
            this.userPhoneList
         );
      }

      @Override
      public String toString() {
         return "NotificationServiceTriggerDTO.NotificationServiceTriggerDTOBuilder(projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", dataId="
            + this.dataId
            + ", createUserId="
            + this.createUserId
            + ", contentDetails="
            + this.contentDetails
            + ", notificationTypeEnum="
            + this.notificationTypeEnum
            + ", userList="
            + this.userList
            + ", userPhoneList="
            + this.userPhoneList
            + ")";
      }
   }
}
