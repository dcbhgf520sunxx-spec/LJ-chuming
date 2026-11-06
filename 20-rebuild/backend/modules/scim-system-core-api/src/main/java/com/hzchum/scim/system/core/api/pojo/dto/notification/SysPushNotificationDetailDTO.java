package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

public class SysPushNotificationDetailDTO {
   @ApiModelProperty(name = "id", notes = "")
   private Long id;
   @ApiModelProperty(name = "recordId", notes = "")
   private Long recordId;
   @ApiModelProperty(name = "operationalModuleTypeEnum", value = "业务所属模块", notes = "业务所属模块")
   private Integer operationalModuleTypeEnum;
   @ApiModelProperty(name = "notificationTypeEnum", value = "通知业务", notes = "通知业务")
   private Integer notificationTypeEnum;
   @ApiModelProperty(name = "notificationTypeEnumName", notes = "通知业务名称")
   private String notificationTypeEnumName;
   @ApiModelProperty(name = "operationalModuleTypeEnumName", notes = "通知所属模块名称")
   private String operationalModuleTypeEnumName;
   @ApiModelProperty(name = "pushTime", notes = "推送时间")
   private LocalDateTime pushTime;
   @ApiModelProperty(name = "triggerModeTypeEnum", notes = "触发条件(到达 完成 超时 超期)")
   private Integer triggerModeTypeEnum;
   @ApiModelProperty(name = "departmentAndUserInfoDTOS", notes = "推送人员信息")
   private List<DepartmentAndUserInfoDTO> departmentAndUserInfoDTOS;
   @ApiModelProperty(name = "projectId", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "projectShortName", notes = "项目名称")
   private String projectShortName;
   @ApiModelProperty(name = "isRead", notes = "是否阅读")
   private Boolean isRead;
   @ApiModelProperty(name = "contentDetails", notes = "消息推送内容详情")
   private String contentDetails;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   private LocalDateTime createTime;

   public static SysPushNotificationDetailDTO.SysPushNotificationDetailDTOBuilder builder() {
      return new SysPushNotificationDetailDTO.SysPushNotificationDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getRecordId() {
      return this.recordId;
   }

   public Integer getOperationalModuleTypeEnum() {
      return this.operationalModuleTypeEnum;
   }

   public Integer getNotificationTypeEnum() {
      return this.notificationTypeEnum;
   }

   public String getNotificationTypeEnumName() {
      return this.notificationTypeEnumName;
   }

   public String getOperationalModuleTypeEnumName() {
      return this.operationalModuleTypeEnumName;
   }

   public LocalDateTime getPushTime() {
      return this.pushTime;
   }

   public Integer getTriggerModeTypeEnum() {
      return this.triggerModeTypeEnum;
   }

   public List<DepartmentAndUserInfoDTO> getDepartmentAndUserInfoDTOS() {
      return this.departmentAndUserInfoDTOS;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectShortName() {
      return this.projectShortName;
   }

   public Boolean getIsRead() {
      return this.isRead;
   }

   public String getContentDetails() {
      return this.contentDetails;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setRecordId(final Long recordId) {
      this.recordId = recordId;
   }

   public void setOperationalModuleTypeEnum(final Integer operationalModuleTypeEnum) {
      this.operationalModuleTypeEnum = operationalModuleTypeEnum;
   }

   public void setNotificationTypeEnum(final Integer notificationTypeEnum) {
      this.notificationTypeEnum = notificationTypeEnum;
   }

   public void setNotificationTypeEnumName(final String notificationTypeEnumName) {
      this.notificationTypeEnumName = notificationTypeEnumName;
   }

   public void setOperationalModuleTypeEnumName(final String operationalModuleTypeEnumName) {
      this.operationalModuleTypeEnumName = operationalModuleTypeEnumName;
   }

   public void setPushTime(final LocalDateTime pushTime) {
      this.pushTime = pushTime;
   }

   public void setTriggerModeTypeEnum(final Integer triggerModeTypeEnum) {
      this.triggerModeTypeEnum = triggerModeTypeEnum;
   }

   public void setDepartmentAndUserInfoDTOS(final List<DepartmentAndUserInfoDTO> departmentAndUserInfoDTOS) {
      this.departmentAndUserInfoDTOS = departmentAndUserInfoDTOS;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectShortName(final String projectShortName) {
      this.projectShortName = projectShortName;
   }

   public void setIsRead(final Boolean isRead) {
      this.isRead = isRead;
   }

   public void setContentDetails(final String contentDetails) {
      this.contentDetails = contentDetails;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushNotificationDetailDTO)) {
         return false;
      }

      SysPushNotificationDetailDTO other = (SysPushNotificationDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$recordId = this.getRecordId();
         Object other$recordId = other.getRecordId();
         if (this$recordId == null ? other$recordId == null : this$recordId.equals(other$recordId)) {
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
                     Object this$projectId = this.getProjectId();
                     Object other$projectId = other.getProjectId();
                     if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                        Object this$isRead = this.getIsRead();
                        Object other$isRead = other.getIsRead();
                        if (this$isRead == null ? other$isRead == null : this$isRead.equals(other$isRead)) {
                           Object this$notificationTypeEnumName = this.getNotificationTypeEnumName();
                           Object other$notificationTypeEnumName = other.getNotificationTypeEnumName();
                           if (this$notificationTypeEnumName == null
                              ? other$notificationTypeEnumName == null
                              : this$notificationTypeEnumName.equals(other$notificationTypeEnumName)) {
                              Object this$operationalModuleTypeEnumName = this.getOperationalModuleTypeEnumName();
                              Object other$operationalModuleTypeEnumName = other.getOperationalModuleTypeEnumName();
                              if (this$operationalModuleTypeEnumName == null
                                 ? other$operationalModuleTypeEnumName == null
                                 : this$operationalModuleTypeEnumName.equals(other$operationalModuleTypeEnumName)) {
                                 Object this$pushTime = this.getPushTime();
                                 Object other$pushTime = other.getPushTime();
                                 if (this$pushTime == null ? other$pushTime == null : this$pushTime.equals(other$pushTime)) {
                                    Object this$departmentAndUserInfoDTOS = this.getDepartmentAndUserInfoDTOS();
                                    Object other$departmentAndUserInfoDTOS = other.getDepartmentAndUserInfoDTOS();
                                    if (this$departmentAndUserInfoDTOS == null
                                       ? other$departmentAndUserInfoDTOS == null
                                       : this$departmentAndUserInfoDTOS.equals(other$departmentAndUserInfoDTOS)) {
                                       Object this$projectShortName = this.getProjectShortName();
                                       Object other$projectShortName = other.getProjectShortName();
                                       if (this$projectShortName == null
                                          ? other$projectShortName == null
                                          : this$projectShortName.equals(other$projectShortName)) {
                                          Object this$contentDetails = this.getContentDetails();
                                          Object other$contentDetails = other.getContentDetails();
                                          if (this$contentDetails == null ? other$contentDetails == null : this$contentDetails.equals(other$contentDetails)) {
                                             Object this$createTime = this.getCreateTime();
                                             Object other$createTime = other.getCreateTime();
                                             return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SysPushNotificationDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $recordId = this.getRecordId();
      result = result * 59 + ($recordId == null ? 43 : $recordId.hashCode());
      Object $operationalModuleTypeEnum = this.getOperationalModuleTypeEnum();
      result = result * 59 + ($operationalModuleTypeEnum == null ? 43 : $operationalModuleTypeEnum.hashCode());
      Object $notificationTypeEnum = this.getNotificationTypeEnum();
      result = result * 59 + ($notificationTypeEnum == null ? 43 : $notificationTypeEnum.hashCode());
      Object $triggerModeTypeEnum = this.getTriggerModeTypeEnum();
      result = result * 59 + ($triggerModeTypeEnum == null ? 43 : $triggerModeTypeEnum.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $isRead = this.getIsRead();
      result = result * 59 + ($isRead == null ? 43 : $isRead.hashCode());
      Object $notificationTypeEnumName = this.getNotificationTypeEnumName();
      result = result * 59 + ($notificationTypeEnumName == null ? 43 : $notificationTypeEnumName.hashCode());
      Object $operationalModuleTypeEnumName = this.getOperationalModuleTypeEnumName();
      result = result * 59 + ($operationalModuleTypeEnumName == null ? 43 : $operationalModuleTypeEnumName.hashCode());
      Object $pushTime = this.getPushTime();
      result = result * 59 + ($pushTime == null ? 43 : $pushTime.hashCode());
      Object $departmentAndUserInfoDTOS = this.getDepartmentAndUserInfoDTOS();
      result = result * 59 + ($departmentAndUserInfoDTOS == null ? 43 : $departmentAndUserInfoDTOS.hashCode());
      Object $projectShortName = this.getProjectShortName();
      result = result * 59 + ($projectShortName == null ? 43 : $projectShortName.hashCode());
      Object $contentDetails = this.getContentDetails();
      result = result * 59 + ($contentDetails == null ? 43 : $contentDetails.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "SysPushNotificationDetailDTO(id="
         + this.getId()
         + ", recordId="
         + this.getRecordId()
         + ", operationalModuleTypeEnum="
         + this.getOperationalModuleTypeEnum()
         + ", notificationTypeEnum="
         + this.getNotificationTypeEnum()
         + ", notificationTypeEnumName="
         + this.getNotificationTypeEnumName()
         + ", operationalModuleTypeEnumName="
         + this.getOperationalModuleTypeEnumName()
         + ", pushTime="
         + this.getPushTime()
         + ", triggerModeTypeEnum="
         + this.getTriggerModeTypeEnum()
         + ", departmentAndUserInfoDTOS="
         + this.getDepartmentAndUserInfoDTOS()
         + ", projectId="
         + this.getProjectId()
         + ", projectShortName="
         + this.getProjectShortName()
         + ", isRead="
         + this.getIsRead()
         + ", contentDetails="
         + this.getContentDetails()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public SysPushNotificationDetailDTO(
      final Long id,
      final Long recordId,
      final Integer operationalModuleTypeEnum,
      final Integer notificationTypeEnum,
      final String notificationTypeEnumName,
      final String operationalModuleTypeEnumName,
      final LocalDateTime pushTime,
      final Integer triggerModeTypeEnum,
      final List<DepartmentAndUserInfoDTO> departmentAndUserInfoDTOS,
      final Long projectId,
      final String projectShortName,
      final Boolean isRead,
      final String contentDetails,
      final LocalDateTime createTime
   ) {
      this.id = id;
      this.recordId = recordId;
      this.operationalModuleTypeEnum = operationalModuleTypeEnum;
      this.notificationTypeEnum = notificationTypeEnum;
      this.notificationTypeEnumName = notificationTypeEnumName;
      this.operationalModuleTypeEnumName = operationalModuleTypeEnumName;
      this.pushTime = pushTime;
      this.triggerModeTypeEnum = triggerModeTypeEnum;
      this.departmentAndUserInfoDTOS = departmentAndUserInfoDTOS;
      this.projectId = projectId;
      this.projectShortName = projectShortName;
      this.isRead = isRead;
      this.contentDetails = contentDetails;
      this.createTime = createTime;
   }

   public SysPushNotificationDetailDTO() {
   }

   public static class SysPushNotificationDetailDTOBuilder {
      private Long id;
      private Long recordId;
      private Integer operationalModuleTypeEnum;
      private Integer notificationTypeEnum;
      private String notificationTypeEnumName;
      private String operationalModuleTypeEnumName;
      private LocalDateTime pushTime;
      private Integer triggerModeTypeEnum;
      private List<DepartmentAndUserInfoDTO> departmentAndUserInfoDTOS;
      private Long projectId;
      private String projectShortName;
      private Boolean isRead;
      private String contentDetails;
      private LocalDateTime createTime;

      SysPushNotificationDetailDTOBuilder() {
      }

      public SysPushNotificationDetailDTO.SysPushNotificationDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushNotificationDetailDTO.SysPushNotificationDetailDTOBuilder recordId(final Long recordId) {
         this.recordId = recordId;
         return this;
      }

      public SysPushNotificationDetailDTO.SysPushNotificationDetailDTOBuilder operationalModuleTypeEnum(final Integer operationalModuleTypeEnum) {
         this.operationalModuleTypeEnum = operationalModuleTypeEnum;
         return this;
      }

      public SysPushNotificationDetailDTO.SysPushNotificationDetailDTOBuilder notificationTypeEnum(final Integer notificationTypeEnum) {
         this.notificationTypeEnum = notificationTypeEnum;
         return this;
      }

      public SysPushNotificationDetailDTO.SysPushNotificationDetailDTOBuilder notificationTypeEnumName(final String notificationTypeEnumName) {
         this.notificationTypeEnumName = notificationTypeEnumName;
         return this;
      }

      public SysPushNotificationDetailDTO.SysPushNotificationDetailDTOBuilder operationalModuleTypeEnumName(final String operationalModuleTypeEnumName) {
         this.operationalModuleTypeEnumName = operationalModuleTypeEnumName;
         return this;
      }

      public SysPushNotificationDetailDTO.SysPushNotificationDetailDTOBuilder pushTime(final LocalDateTime pushTime) {
         this.pushTime = pushTime;
         return this;
      }

      public SysPushNotificationDetailDTO.SysPushNotificationDetailDTOBuilder triggerModeTypeEnum(final Integer triggerModeTypeEnum) {
         this.triggerModeTypeEnum = triggerModeTypeEnum;
         return this;
      }

      public SysPushNotificationDetailDTO.SysPushNotificationDetailDTOBuilder departmentAndUserInfoDTOS(
         final List<DepartmentAndUserInfoDTO> departmentAndUserInfoDTOS
      ) {
         this.departmentAndUserInfoDTOS = departmentAndUserInfoDTOS;
         return this;
      }

      public SysPushNotificationDetailDTO.SysPushNotificationDetailDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public SysPushNotificationDetailDTO.SysPushNotificationDetailDTOBuilder projectShortName(final String projectShortName) {
         this.projectShortName = projectShortName;
         return this;
      }

      public SysPushNotificationDetailDTO.SysPushNotificationDetailDTOBuilder isRead(final Boolean isRead) {
         this.isRead = isRead;
         return this;
      }

      public SysPushNotificationDetailDTO.SysPushNotificationDetailDTOBuilder contentDetails(final String contentDetails) {
         this.contentDetails = contentDetails;
         return this;
      }

      public SysPushNotificationDetailDTO.SysPushNotificationDetailDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public SysPushNotificationDetailDTO build() {
         return new SysPushNotificationDetailDTO(
            this.id,
            this.recordId,
            this.operationalModuleTypeEnum,
            this.notificationTypeEnum,
            this.notificationTypeEnumName,
            this.operationalModuleTypeEnumName,
            this.pushTime,
            this.triggerModeTypeEnum,
            this.departmentAndUserInfoDTOS,
            this.projectId,
            this.projectShortName,
            this.isRead,
            this.contentDetails,
            this.createTime
         );
      }

      @Override
      public String toString() {
         return "SysPushNotificationDetailDTO.SysPushNotificationDetailDTOBuilder(id="
            + this.id
            + ", recordId="
            + this.recordId
            + ", operationalModuleTypeEnum="
            + this.operationalModuleTypeEnum
            + ", notificationTypeEnum="
            + this.notificationTypeEnum
            + ", notificationTypeEnumName="
            + this.notificationTypeEnumName
            + ", operationalModuleTypeEnumName="
            + this.operationalModuleTypeEnumName
            + ", pushTime="
            + this.pushTime
            + ", triggerModeTypeEnum="
            + this.triggerModeTypeEnum
            + ", departmentAndUserInfoDTOS="
            + this.departmentAndUserInfoDTOS
            + ", projectId="
            + this.projectId
            + ", projectShortName="
            + this.projectShortName
            + ", isRead="
            + this.isRead
            + ", contentDetails="
            + this.contentDetails
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
