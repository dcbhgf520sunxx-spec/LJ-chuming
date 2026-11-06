package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "SysPushNotificationRecordDTOParam", description = "推送记录")
public class SysPushNotificationRecordDTOParam {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "operationalModuleTypeEnum", value = "业务所属模块", notes = "业务所属模块")
   private Integer operationalModuleTypeEnum;
   @ApiModelProperty(name = "notificationTypeEnum", value = "通知业务", notes = "通知业务")
   private Integer notificationTypeEnum;
   @ApiModelProperty(name = "triggerModeTypeEnum", value = "触发方式", notes = "触发方式")
   private Integer triggerModeTypeEnum;
   @ApiModelProperty(name = "pushDateTime", value = "推送日期", notes = "推送日期")
   private LocalDateTime pushDateTime;
   @ApiModelProperty(name = "boolPush", value = "是否推送，关系到定时操作", notes = "是否推送，关系到定时操作")
   private Boolean boolPush;
   @ApiModelProperty(name = "projectId", value = "所属项目", notes = "所属项目")
   private Long projectId;
   @ApiModelProperty(name = "areaId", notes = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "monomerId", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "dataId", notes = "数据id")
   private Long dataId;
   @ApiModelProperty(name = "dataId", notes = "创建人id")
   private Long createUserId;
   @ApiModelProperty(name = "contentDetails", notes = "消息推送内容详情")
   private StringBuffer contentDetails;
   @ApiModelProperty(name = "userPhoneList", notes = "用户手机号")
   private List<String> userPhoneList;

   public static SysPushNotificationRecordDTOParam.SysPushNotificationRecordDTOParamBuilder builder() {
      return new SysPushNotificationRecordDTOParam.SysPushNotificationRecordDTOParamBuilder();
   }

   public SysPushNotificationRecordDTOParam() {
   }

   public SysPushNotificationRecordDTOParam(
      final Long id,
      final Integer operationalModuleTypeEnum,
      final Integer notificationTypeEnum,
      final Integer triggerModeTypeEnum,
      final LocalDateTime pushDateTime,
      final Boolean boolPush,
      final Long projectId,
      final Long areaId,
      final Long monomerId,
      final Long dataId,
      final Long createUserId,
      final StringBuffer contentDetails,
      final List<String> userPhoneList
   ) {
      this.id = id;
      this.operationalModuleTypeEnum = operationalModuleTypeEnum;
      this.notificationTypeEnum = notificationTypeEnum;
      this.triggerModeTypeEnum = triggerModeTypeEnum;
      this.pushDateTime = pushDateTime;
      this.boolPush = boolPush;
      this.projectId = projectId;
      this.areaId = areaId;
      this.monomerId = monomerId;
      this.dataId = dataId;
      this.createUserId = createUserId;
      this.contentDetails = contentDetails;
      this.userPhoneList = userPhoneList;
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

   public Integer getTriggerModeTypeEnum() {
      return this.triggerModeTypeEnum;
   }

   public LocalDateTime getPushDateTime() {
      return this.pushDateTime;
   }

   public Boolean getBoolPush() {
      return this.boolPush;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public Long getMonomerId() {
      return this.monomerId;
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

   public List<String> getUserPhoneList() {
      return this.userPhoneList;
   }

   public SysPushNotificationRecordDTOParam setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysPushNotificationRecordDTOParam setOperationalModuleTypeEnum(final Integer operationalModuleTypeEnum) {
      this.operationalModuleTypeEnum = operationalModuleTypeEnum;
      return this;
   }

   public SysPushNotificationRecordDTOParam setNotificationTypeEnum(final Integer notificationTypeEnum) {
      this.notificationTypeEnum = notificationTypeEnum;
      return this;
   }

   public SysPushNotificationRecordDTOParam setTriggerModeTypeEnum(final Integer triggerModeTypeEnum) {
      this.triggerModeTypeEnum = triggerModeTypeEnum;
      return this;
   }

   public SysPushNotificationRecordDTOParam setPushDateTime(final LocalDateTime pushDateTime) {
      this.pushDateTime = pushDateTime;
      return this;
   }

   public SysPushNotificationRecordDTOParam setBoolPush(final Boolean boolPush) {
      this.boolPush = boolPush;
      return this;
   }

   public SysPushNotificationRecordDTOParam setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public SysPushNotificationRecordDTOParam setAreaId(final Long areaId) {
      this.areaId = areaId;
      return this;
   }

   public SysPushNotificationRecordDTOParam setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
      return this;
   }

   public SysPushNotificationRecordDTOParam setDataId(final Long dataId) {
      this.dataId = dataId;
      return this;
   }

   public SysPushNotificationRecordDTOParam setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public SysPushNotificationRecordDTOParam setContentDetails(final StringBuffer contentDetails) {
      this.contentDetails = contentDetails;
      return this;
   }

   public SysPushNotificationRecordDTOParam setUserPhoneList(final List<String> userPhoneList) {
      this.userPhoneList = userPhoneList;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushNotificationRecordDTOParam)) {
         return false;
      }

      SysPushNotificationRecordDTOParam other = (SysPushNotificationRecordDTOParam)o;
      if (!other.canEqual(this)) {
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
               Object this$triggerModeTypeEnum = this.getTriggerModeTypeEnum();
               Object other$triggerModeTypeEnum = other.getTriggerModeTypeEnum();
               if (this$triggerModeTypeEnum == null ? other$triggerModeTypeEnum == null : this$triggerModeTypeEnum.equals(other$triggerModeTypeEnum)) {
                  Object this$boolPush = this.getBoolPush();
                  Object other$boolPush = other.getBoolPush();
                  if (this$boolPush == null ? other$boolPush == null : this$boolPush.equals(other$boolPush)) {
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$areaId = this.getAreaId();
                        Object other$areaId = other.getAreaId();
                        if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                           Object this$monomerId = this.getMonomerId();
                           Object other$monomerId = other.getMonomerId();
                           if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                              Object this$dataId = this.getDataId();
                              Object other$dataId = other.getDataId();
                              if (this$dataId == null ? other$dataId == null : this$dataId.equals(other$dataId)) {
                                 Object this$createUserId = this.getCreateUserId();
                                 Object other$createUserId = other.getCreateUserId();
                                 if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                                    Object this$pushDateTime = this.getPushDateTime();
                                    Object other$pushDateTime = other.getPushDateTime();
                                    if (this$pushDateTime == null ? other$pushDateTime == null : this$pushDateTime.equals(other$pushDateTime)) {
                                       Object this$contentDetails = this.getContentDetails();
                                       Object other$contentDetails = other.getContentDetails();
                                       if (this$contentDetails == null ? other$contentDetails == null : this$contentDetails.equals(other$contentDetails)) {
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
      return other instanceof SysPushNotificationRecordDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $operationalModuleTypeEnum = this.getOperationalModuleTypeEnum();
      result = result * 59 + ($operationalModuleTypeEnum == null ? 43 : $operationalModuleTypeEnum.hashCode());
      Object $notificationTypeEnum = this.getNotificationTypeEnum();
      result = result * 59 + ($notificationTypeEnum == null ? 43 : $notificationTypeEnum.hashCode());
      Object $triggerModeTypeEnum = this.getTriggerModeTypeEnum();
      result = result * 59 + ($triggerModeTypeEnum == null ? 43 : $triggerModeTypeEnum.hashCode());
      Object $boolPush = this.getBoolPush();
      result = result * 59 + ($boolPush == null ? 43 : $boolPush.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $dataId = this.getDataId();
      result = result * 59 + ($dataId == null ? 43 : $dataId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $pushDateTime = this.getPushDateTime();
      result = result * 59 + ($pushDateTime == null ? 43 : $pushDateTime.hashCode());
      Object $contentDetails = this.getContentDetails();
      result = result * 59 + ($contentDetails == null ? 43 : $contentDetails.hashCode());
      Object $userPhoneList = this.getUserPhoneList();
      return result * 59 + ($userPhoneList == null ? 43 : $userPhoneList.hashCode());
   }

   @Override
   public String toString() {
      return "SysPushNotificationRecordDTOParam(id="
         + this.getId()
         + ", operationalModuleTypeEnum="
         + this.getOperationalModuleTypeEnum()
         + ", notificationTypeEnum="
         + this.getNotificationTypeEnum()
         + ", triggerModeTypeEnum="
         + this.getTriggerModeTypeEnum()
         + ", pushDateTime="
         + this.getPushDateTime()
         + ", boolPush="
         + this.getBoolPush()
         + ", projectId="
         + this.getProjectId()
         + ", areaId="
         + this.getAreaId()
         + ", monomerId="
         + this.getMonomerId()
         + ", dataId="
         + this.getDataId()
         + ", createUserId="
         + this.getCreateUserId()
         + ", contentDetails="
         + this.getContentDetails()
         + ", userPhoneList="
         + this.getUserPhoneList()
         + ")";
   }

   public static class SysPushNotificationRecordDTOParamBuilder {
      private Long id;
      private Integer operationalModuleTypeEnum;
      private Integer notificationTypeEnum;
      private Integer triggerModeTypeEnum;
      private LocalDateTime pushDateTime;
      private Boolean boolPush;
      private Long projectId;
      private Long areaId;
      private Long monomerId;
      private Long dataId;
      private Long createUserId;
      private StringBuffer contentDetails;
      private List<String> userPhoneList;

      SysPushNotificationRecordDTOParamBuilder() {
      }

      public SysPushNotificationRecordDTOParam.SysPushNotificationRecordDTOParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushNotificationRecordDTOParam.SysPushNotificationRecordDTOParamBuilder operationalModuleTypeEnum(final Integer operationalModuleTypeEnum) {
         this.operationalModuleTypeEnum = operationalModuleTypeEnum;
         return this;
      }

      public SysPushNotificationRecordDTOParam.SysPushNotificationRecordDTOParamBuilder notificationTypeEnum(final Integer notificationTypeEnum) {
         this.notificationTypeEnum = notificationTypeEnum;
         return this;
      }

      public SysPushNotificationRecordDTOParam.SysPushNotificationRecordDTOParamBuilder triggerModeTypeEnum(final Integer triggerModeTypeEnum) {
         this.triggerModeTypeEnum = triggerModeTypeEnum;
         return this;
      }

      public SysPushNotificationRecordDTOParam.SysPushNotificationRecordDTOParamBuilder pushDateTime(final LocalDateTime pushDateTime) {
         this.pushDateTime = pushDateTime;
         return this;
      }

      public SysPushNotificationRecordDTOParam.SysPushNotificationRecordDTOParamBuilder boolPush(final Boolean boolPush) {
         this.boolPush = boolPush;
         return this;
      }

      public SysPushNotificationRecordDTOParam.SysPushNotificationRecordDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SysPushNotificationRecordDTOParam.SysPushNotificationRecordDTOParamBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public SysPushNotificationRecordDTOParam.SysPushNotificationRecordDTOParamBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public SysPushNotificationRecordDTOParam.SysPushNotificationRecordDTOParamBuilder dataId(final Long dataId) {
         this.dataId = dataId;
         return this;
      }

      public SysPushNotificationRecordDTOParam.SysPushNotificationRecordDTOParamBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public SysPushNotificationRecordDTOParam.SysPushNotificationRecordDTOParamBuilder contentDetails(final StringBuffer contentDetails) {
         this.contentDetails = contentDetails;
         return this;
      }

      public SysPushNotificationRecordDTOParam.SysPushNotificationRecordDTOParamBuilder userPhoneList(final List<String> userPhoneList) {
         this.userPhoneList = userPhoneList;
         return this;
      }

      public SysPushNotificationRecordDTOParam build() {
         return new SysPushNotificationRecordDTOParam(
            this.id,
            this.operationalModuleTypeEnum,
            this.notificationTypeEnum,
            this.triggerModeTypeEnum,
            this.pushDateTime,
            this.boolPush,
            this.projectId,
            this.areaId,
            this.monomerId,
            this.dataId,
            this.createUserId,
            this.contentDetails,
            this.userPhoneList
         );
      }

      @Override
      public String toString() {
         return "SysPushNotificationRecordDTOParam.SysPushNotificationRecordDTOParamBuilder(id="
            + this.id
            + ", operationalModuleTypeEnum="
            + this.operationalModuleTypeEnum
            + ", notificationTypeEnum="
            + this.notificationTypeEnum
            + ", triggerModeTypeEnum="
            + this.triggerModeTypeEnum
            + ", pushDateTime="
            + this.pushDateTime
            + ", boolPush="
            + this.boolPush
            + ", projectId="
            + this.projectId
            + ", areaId="
            + this.areaId
            + ", monomerId="
            + this.monomerId
            + ", dataId="
            + this.dataId
            + ", createUserId="
            + this.createUserId
            + ", contentDetails="
            + this.contentDetails
            + ", userPhoneList="
            + this.userPhoneList
            + ")";
      }
   }
}
