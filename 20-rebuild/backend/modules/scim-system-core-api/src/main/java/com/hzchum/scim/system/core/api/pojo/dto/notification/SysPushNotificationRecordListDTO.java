package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class SysPushNotificationRecordListDTO {
   @ApiModelProperty(name = "id")
   private Long id;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "serialNumber", value = "流水号", notes = "流水号")
   private String serialNumber;
   @ApiModelProperty(name = "operationalModuleTypeEnum", value = "业务所属模块", notes = "业务所属模块")
   private Integer operationalModuleTypeEnum;
   @ApiModelProperty(name = "operationalModuleTypeEnumName", value = "业务所属模块名称", notes = "业务所属模块名称")
   private String operationalModuleTypeEnumName;
   @ApiModelProperty(name = "notificationTypeEnum", value = "通知业务", notes = "通知业务")
   private Integer notificationTypeEnum;
   @ApiModelProperty(name = "notificationTypeEnumName", value = "通知业务名称", notes = "通知业务名称")
   private String notificationTypeEnumName;
   @ApiModelProperty(name = "triggerModeTypeEnum", value = "触发方式", notes = "触发方式")
   private Integer triggerModeTypeEnum;
   @ApiModelProperty(name = "pushDateTime", value = "推送日期", notes = "推送日期")
   private LocalDateTime pushDateTime;
   @ApiModelProperty(name = "isRead", notes = "是否已读")
   private Boolean isRead;
   @ApiModelProperty(name = "sysPushNotificationLevel", value = "推送等级", notes = "推送等级")
   private Integer sysPushNotificationLevel;
   @ApiModelProperty(name = "projectShortName", notes = "项目简称")
   private String projectShortName;
   @ApiModelProperty(name = "suitableObjectCommonDTOList", notes = "适用对象信息通用集合")
   private List<SuitableObjectCommonDTO> suitableObjectCommonDTOList;

   public static SysPushNotificationRecordListDTO.SysPushNotificationRecordListDTOBuilder builder() {
      return new SysPushNotificationRecordListDTO.SysPushNotificationRecordListDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getOperationalModuleTypeEnum() {
      return this.operationalModuleTypeEnum;
   }

   public String getOperationalModuleTypeEnumName() {
      return this.operationalModuleTypeEnumName;
   }

   public Integer getNotificationTypeEnum() {
      return this.notificationTypeEnum;
   }

   public String getNotificationTypeEnumName() {
      return this.notificationTypeEnumName;
   }

   public Integer getTriggerModeTypeEnum() {
      return this.triggerModeTypeEnum;
   }

   public LocalDateTime getPushDateTime() {
      return this.pushDateTime;
   }

   public Boolean getIsRead() {
      return this.isRead;
   }

   public Integer getSysPushNotificationLevel() {
      return this.sysPushNotificationLevel;
   }

   public String getProjectShortName() {
      return this.projectShortName;
   }

   public List<SuitableObjectCommonDTO> getSuitableObjectCommonDTOList() {
      return this.suitableObjectCommonDTOList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setOperationalModuleTypeEnum(final Integer operationalModuleTypeEnum) {
      this.operationalModuleTypeEnum = operationalModuleTypeEnum;
   }

   public void setOperationalModuleTypeEnumName(final String operationalModuleTypeEnumName) {
      this.operationalModuleTypeEnumName = operationalModuleTypeEnumName;
   }

   public void setNotificationTypeEnum(final Integer notificationTypeEnum) {
      this.notificationTypeEnum = notificationTypeEnum;
   }

   public void setNotificationTypeEnumName(final String notificationTypeEnumName) {
      this.notificationTypeEnumName = notificationTypeEnumName;
   }

   public void setTriggerModeTypeEnum(final Integer triggerModeTypeEnum) {
      this.triggerModeTypeEnum = triggerModeTypeEnum;
   }

   public void setPushDateTime(final LocalDateTime pushDateTime) {
      this.pushDateTime = pushDateTime;
   }

   public void setIsRead(final Boolean isRead) {
      this.isRead = isRead;
   }

   public void setSysPushNotificationLevel(final Integer sysPushNotificationLevel) {
      this.sysPushNotificationLevel = sysPushNotificationLevel;
   }

   public void setProjectShortName(final String projectShortName) {
      this.projectShortName = projectShortName;
   }

   public void setSuitableObjectCommonDTOList(final List<SuitableObjectCommonDTO> suitableObjectCommonDTOList) {
      this.suitableObjectCommonDTOList = suitableObjectCommonDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushNotificationRecordListDTO)) {
         return false;
      }

      SysPushNotificationRecordListDTO other = (SysPushNotificationRecordListDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
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
                     Object this$isRead = this.getIsRead();
                     Object other$isRead = other.getIsRead();
                     if (this$isRead == null ? other$isRead == null : this$isRead.equals(other$isRead)) {
                        Object this$sysPushNotificationLevel = this.getSysPushNotificationLevel();
                        Object other$sysPushNotificationLevel = other.getSysPushNotificationLevel();
                        if (this$sysPushNotificationLevel == null
                           ? other$sysPushNotificationLevel == null
                           : this$sysPushNotificationLevel.equals(other$sysPushNotificationLevel)) {
                           Object this$serialNumber = this.getSerialNumber();
                           Object other$serialNumber = other.getSerialNumber();
                           if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                              Object this$operationalModuleTypeEnumName = this.getOperationalModuleTypeEnumName();
                              Object other$operationalModuleTypeEnumName = other.getOperationalModuleTypeEnumName();
                              if (this$operationalModuleTypeEnumName == null
                                 ? other$operationalModuleTypeEnumName == null
                                 : this$operationalModuleTypeEnumName.equals(other$operationalModuleTypeEnumName)) {
                                 Object this$notificationTypeEnumName = this.getNotificationTypeEnumName();
                                 Object other$notificationTypeEnumName = other.getNotificationTypeEnumName();
                                 if (this$notificationTypeEnumName == null
                                    ? other$notificationTypeEnumName == null
                                    : this$notificationTypeEnumName.equals(other$notificationTypeEnumName)) {
                                    Object this$pushDateTime = this.getPushDateTime();
                                    Object other$pushDateTime = other.getPushDateTime();
                                    if (this$pushDateTime == null ? other$pushDateTime == null : this$pushDateTime.equals(other$pushDateTime)) {
                                       Object this$projectShortName = this.getProjectShortName();
                                       Object other$projectShortName = other.getProjectShortName();
                                       if (this$projectShortName == null
                                          ? other$projectShortName == null
                                          : this$projectShortName.equals(other$projectShortName)) {
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
      return other instanceof SysPushNotificationRecordListDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $operationalModuleTypeEnum = this.getOperationalModuleTypeEnum();
      result = result * 59 + ($operationalModuleTypeEnum == null ? 43 : $operationalModuleTypeEnum.hashCode());
      Object $notificationTypeEnum = this.getNotificationTypeEnum();
      result = result * 59 + ($notificationTypeEnum == null ? 43 : $notificationTypeEnum.hashCode());
      Object $triggerModeTypeEnum = this.getTriggerModeTypeEnum();
      result = result * 59 + ($triggerModeTypeEnum == null ? 43 : $triggerModeTypeEnum.hashCode());
      Object $isRead = this.getIsRead();
      result = result * 59 + ($isRead == null ? 43 : $isRead.hashCode());
      Object $sysPushNotificationLevel = this.getSysPushNotificationLevel();
      result = result * 59 + ($sysPushNotificationLevel == null ? 43 : $sysPushNotificationLevel.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $operationalModuleTypeEnumName = this.getOperationalModuleTypeEnumName();
      result = result * 59 + ($operationalModuleTypeEnumName == null ? 43 : $operationalModuleTypeEnumName.hashCode());
      Object $notificationTypeEnumName = this.getNotificationTypeEnumName();
      result = result * 59 + ($notificationTypeEnumName == null ? 43 : $notificationTypeEnumName.hashCode());
      Object $pushDateTime = this.getPushDateTime();
      result = result * 59 + ($pushDateTime == null ? 43 : $pushDateTime.hashCode());
      Object $projectShortName = this.getProjectShortName();
      result = result * 59 + ($projectShortName == null ? 43 : $projectShortName.hashCode());
      Object $suitableObjectCommonDTOList = this.getSuitableObjectCommonDTOList();
      return result * 59 + ($suitableObjectCommonDTOList == null ? 43 : $suitableObjectCommonDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "SysPushNotificationRecordListDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", operationalModuleTypeEnum="
         + this.getOperationalModuleTypeEnum()
         + ", operationalModuleTypeEnumName="
         + this.getOperationalModuleTypeEnumName()
         + ", notificationTypeEnum="
         + this.getNotificationTypeEnum()
         + ", notificationTypeEnumName="
         + this.getNotificationTypeEnumName()
         + ", triggerModeTypeEnum="
         + this.getTriggerModeTypeEnum()
         + ", pushDateTime="
         + this.getPushDateTime()
         + ", isRead="
         + this.getIsRead()
         + ", sysPushNotificationLevel="
         + this.getSysPushNotificationLevel()
         + ", projectShortName="
         + this.getProjectShortName()
         + ", suitableObjectCommonDTOList="
         + this.getSuitableObjectCommonDTOList()
         + ")";
   }

   public SysPushNotificationRecordListDTO(
      final Long id,
      final Long projectId,
      final String serialNumber,
      final Integer operationalModuleTypeEnum,
      final String operationalModuleTypeEnumName,
      final Integer notificationTypeEnum,
      final String notificationTypeEnumName,
      final Integer triggerModeTypeEnum,
      final LocalDateTime pushDateTime,
      final Boolean isRead,
      final Integer sysPushNotificationLevel,
      final String projectShortName,
      final List<SuitableObjectCommonDTO> suitableObjectCommonDTOList
   ) {
      this.id = id;
      this.projectId = projectId;
      this.serialNumber = serialNumber;
      this.operationalModuleTypeEnum = operationalModuleTypeEnum;
      this.operationalModuleTypeEnumName = operationalModuleTypeEnumName;
      this.notificationTypeEnum = notificationTypeEnum;
      this.notificationTypeEnumName = notificationTypeEnumName;
      this.triggerModeTypeEnum = triggerModeTypeEnum;
      this.pushDateTime = pushDateTime;
      this.isRead = isRead;
      this.sysPushNotificationLevel = sysPushNotificationLevel;
      this.projectShortName = projectShortName;
      this.suitableObjectCommonDTOList = suitableObjectCommonDTOList;
   }

   public SysPushNotificationRecordListDTO() {
   }

   public static class SysPushNotificationRecordListDTOBuilder {
      private Long id;
      private Long projectId;
      private String serialNumber;
      private Integer operationalModuleTypeEnum;
      private String operationalModuleTypeEnumName;
      private Integer notificationTypeEnum;
      private String notificationTypeEnumName;
      private Integer triggerModeTypeEnum;
      private LocalDateTime pushDateTime;
      private Boolean isRead;
      private Integer sysPushNotificationLevel;
      private String projectShortName;
      private List<SuitableObjectCommonDTO> suitableObjectCommonDTOList;

      SysPushNotificationRecordListDTOBuilder() {
      }

      public SysPushNotificationRecordListDTO.SysPushNotificationRecordListDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushNotificationRecordListDTO.SysPushNotificationRecordListDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SysPushNotificationRecordListDTO.SysPushNotificationRecordListDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SysPushNotificationRecordListDTO.SysPushNotificationRecordListDTOBuilder operationalModuleTypeEnum(final Integer operationalModuleTypeEnum) {
         this.operationalModuleTypeEnum = operationalModuleTypeEnum;
         return this;
      }

      public SysPushNotificationRecordListDTO.SysPushNotificationRecordListDTOBuilder operationalModuleTypeEnumName(final String operationalModuleTypeEnumName) {
         this.operationalModuleTypeEnumName = operationalModuleTypeEnumName;
         return this;
      }

      public SysPushNotificationRecordListDTO.SysPushNotificationRecordListDTOBuilder notificationTypeEnum(final Integer notificationTypeEnum) {
         this.notificationTypeEnum = notificationTypeEnum;
         return this;
      }

      public SysPushNotificationRecordListDTO.SysPushNotificationRecordListDTOBuilder notificationTypeEnumName(final String notificationTypeEnumName) {
         this.notificationTypeEnumName = notificationTypeEnumName;
         return this;
      }

      public SysPushNotificationRecordListDTO.SysPushNotificationRecordListDTOBuilder triggerModeTypeEnum(final Integer triggerModeTypeEnum) {
         this.triggerModeTypeEnum = triggerModeTypeEnum;
         return this;
      }

      public SysPushNotificationRecordListDTO.SysPushNotificationRecordListDTOBuilder pushDateTime(final LocalDateTime pushDateTime) {
         this.pushDateTime = pushDateTime;
         return this;
      }

      public SysPushNotificationRecordListDTO.SysPushNotificationRecordListDTOBuilder isRead(final Boolean isRead) {
         this.isRead = isRead;
         return this;
      }

      public SysPushNotificationRecordListDTO.SysPushNotificationRecordListDTOBuilder sysPushNotificationLevel(final Integer sysPushNotificationLevel) {
         this.sysPushNotificationLevel = sysPushNotificationLevel;
         return this;
      }

      public SysPushNotificationRecordListDTO.SysPushNotificationRecordListDTOBuilder projectShortName(final String projectShortName) {
         this.projectShortName = projectShortName;
         return this;
      }

      public SysPushNotificationRecordListDTO.SysPushNotificationRecordListDTOBuilder suitableObjectCommonDTOList(
         final List<SuitableObjectCommonDTO> suitableObjectCommonDTOList
      ) {
         this.suitableObjectCommonDTOList = suitableObjectCommonDTOList;
         return this;
      }

      public SysPushNotificationRecordListDTO build() {
         return new SysPushNotificationRecordListDTO(
            this.id,
            this.projectId,
            this.serialNumber,
            this.operationalModuleTypeEnum,
            this.operationalModuleTypeEnumName,
            this.notificationTypeEnum,
            this.notificationTypeEnumName,
            this.triggerModeTypeEnum,
            this.pushDateTime,
            this.isRead,
            this.sysPushNotificationLevel,
            this.projectShortName,
            this.suitableObjectCommonDTOList
         );
      }

      @Override
      public String toString() {
         return "SysPushNotificationRecordListDTO.SysPushNotificationRecordListDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", serialNumber="
            + this.serialNumber
            + ", operationalModuleTypeEnum="
            + this.operationalModuleTypeEnum
            + ", operationalModuleTypeEnumName="
            + this.operationalModuleTypeEnumName
            + ", notificationTypeEnum="
            + this.notificationTypeEnum
            + ", notificationTypeEnumName="
            + this.notificationTypeEnumName
            + ", triggerModeTypeEnum="
            + this.triggerModeTypeEnum
            + ", pushDateTime="
            + this.pushDateTime
            + ", isRead="
            + this.isRead
            + ", sysPushNotificationLevel="
            + this.sysPushNotificationLevel
            + ", projectShortName="
            + this.projectShortName
            + ", suitableObjectCommonDTOList="
            + this.suitableObjectCommonDTOList
            + ")";
      }
   }
}
