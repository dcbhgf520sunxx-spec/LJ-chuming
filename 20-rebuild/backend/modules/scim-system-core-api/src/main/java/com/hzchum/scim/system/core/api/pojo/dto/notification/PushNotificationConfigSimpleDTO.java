package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class PushNotificationConfigSimpleDTO {
   @ApiModelProperty(name = "operationalModuleType", notes = "业务模块")
   private Integer operationalModuleType;
   @ApiModelProperty(name = "operationalModuleTypeName", notes = "业务模块名称")
   private String operationalModuleTypeName;
   @ApiModelProperty(name = "ownershipConfiguration", notes = "拥有的业务类型枚举集合")
   private List<Integer> ownershipConfiguration;
   @ApiModelProperty(name = "notificationType", notes = "通知业务")
   private Integer notificationType;
   @ApiModelProperty(name = "notificationTypeName", notes = "通知业务名称")
   private String notificationTypeName;
   @ApiModelProperty(name = "pushNotificationConfigDetailDTOList", notes = "配置详情")
   private List<PushNotificationConfigDetailDTO> pushNotificationConfigDetailDTOList;

   public Integer getOperationalModuleType() {
      return this.operationalModuleType;
   }

   public String getOperationalModuleTypeName() {
      return this.operationalModuleTypeName;
   }

   public List<Integer> getOwnershipConfiguration() {
      return this.ownershipConfiguration;
   }

   public Integer getNotificationType() {
      return this.notificationType;
   }

   public String getNotificationTypeName() {
      return this.notificationTypeName;
   }

   public List<PushNotificationConfigDetailDTO> getPushNotificationConfigDetailDTOList() {
      return this.pushNotificationConfigDetailDTOList;
   }

   public void setOperationalModuleType(final Integer operationalModuleType) {
      this.operationalModuleType = operationalModuleType;
   }

   public void setOperationalModuleTypeName(final String operationalModuleTypeName) {
      this.operationalModuleTypeName = operationalModuleTypeName;
   }

   public void setOwnershipConfiguration(final List<Integer> ownershipConfiguration) {
      this.ownershipConfiguration = ownershipConfiguration;
   }

   public void setNotificationType(final Integer notificationType) {
      this.notificationType = notificationType;
   }

   public void setNotificationTypeName(final String notificationTypeName) {
      this.notificationTypeName = notificationTypeName;
   }

   public void setPushNotificationConfigDetailDTOList(final List<PushNotificationConfigDetailDTO> pushNotificationConfigDetailDTOList) {
      this.pushNotificationConfigDetailDTOList = pushNotificationConfigDetailDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PushNotificationConfigSimpleDTO)) {
         return false;
      }

      PushNotificationConfigSimpleDTO other = (PushNotificationConfigSimpleDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$operationalModuleType = this.getOperationalModuleType();
      Object other$operationalModuleType = other.getOperationalModuleType();
      if (this$operationalModuleType == null ? other$operationalModuleType == null : this$operationalModuleType.equals(other$operationalModuleType)) {
         Object this$notificationType = this.getNotificationType();
         Object other$notificationType = other.getNotificationType();
         if (this$notificationType == null ? other$notificationType == null : this$notificationType.equals(other$notificationType)) {
            Object this$operationalModuleTypeName = this.getOperationalModuleTypeName();
            Object other$operationalModuleTypeName = other.getOperationalModuleTypeName();
            if (this$operationalModuleTypeName == null
               ? other$operationalModuleTypeName == null
               : this$operationalModuleTypeName.equals(other$operationalModuleTypeName)) {
               Object this$ownershipConfiguration = this.getOwnershipConfiguration();
               Object other$ownershipConfiguration = other.getOwnershipConfiguration();
               if (this$ownershipConfiguration == null
                  ? other$ownershipConfiguration == null
                  : this$ownershipConfiguration.equals(other$ownershipConfiguration)) {
                  Object this$notificationTypeName = this.getNotificationTypeName();
                  Object other$notificationTypeName = other.getNotificationTypeName();
                  if (this$notificationTypeName == null ? other$notificationTypeName == null : this$notificationTypeName.equals(other$notificationTypeName)) {
                     Object this$pushNotificationConfigDetailDTOList = this.getPushNotificationConfigDetailDTOList();
                     Object other$pushNotificationConfigDetailDTOList = other.getPushNotificationConfigDetailDTOList();
                     return this$pushNotificationConfigDetailDTOList == null
                        ? other$pushNotificationConfigDetailDTOList == null
                        : this$pushNotificationConfigDetailDTOList.equals(other$pushNotificationConfigDetailDTOList);
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
      return other instanceof PushNotificationConfigSimpleDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $operationalModuleType = this.getOperationalModuleType();
      result = result * 59 + ($operationalModuleType == null ? 43 : $operationalModuleType.hashCode());
      Object $notificationType = this.getNotificationType();
      result = result * 59 + ($notificationType == null ? 43 : $notificationType.hashCode());
      Object $operationalModuleTypeName = this.getOperationalModuleTypeName();
      result = result * 59 + ($operationalModuleTypeName == null ? 43 : $operationalModuleTypeName.hashCode());
      Object $ownershipConfiguration = this.getOwnershipConfiguration();
      result = result * 59 + ($ownershipConfiguration == null ? 43 : $ownershipConfiguration.hashCode());
      Object $notificationTypeName = this.getNotificationTypeName();
      result = result * 59 + ($notificationTypeName == null ? 43 : $notificationTypeName.hashCode());
      Object $pushNotificationConfigDetailDTOList = this.getPushNotificationConfigDetailDTOList();
      return result * 59 + ($pushNotificationConfigDetailDTOList == null ? 43 : $pushNotificationConfigDetailDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "PushNotificationConfigSimpleDTO(operationalModuleType="
         + this.getOperationalModuleType()
         + ", operationalModuleTypeName="
         + this.getOperationalModuleTypeName()
         + ", ownershipConfiguration="
         + this.getOwnershipConfiguration()
         + ", notificationType="
         + this.getNotificationType()
         + ", notificationTypeName="
         + this.getNotificationTypeName()
         + ", pushNotificationConfigDetailDTOList="
         + this.getPushNotificationConfigDetailDTOList()
         + ")";
   }

   public PushNotificationConfigSimpleDTO(
      final Integer operationalModuleType,
      final String operationalModuleTypeName,
      final List<Integer> ownershipConfiguration,
      final Integer notificationType,
      final String notificationTypeName,
      final List<PushNotificationConfigDetailDTO> pushNotificationConfigDetailDTOList
   ) {
      this.operationalModuleType = operationalModuleType;
      this.operationalModuleTypeName = operationalModuleTypeName;
      this.ownershipConfiguration = ownershipConfiguration;
      this.notificationType = notificationType;
      this.notificationTypeName = notificationTypeName;
      this.pushNotificationConfigDetailDTOList = pushNotificationConfigDetailDTOList;
   }

   public PushNotificationConfigSimpleDTO() {
   }
}
