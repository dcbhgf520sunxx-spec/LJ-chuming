package com.hzchum.scim.system.core.api.pojo.dto.notification;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class SysPushWebhookConfigDTO {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "hookUrl", value = "hookUrl", notes = "hookUrl")
   private String hookUrl;
   @ApiModelProperty(name = "name", value = "name", notes = "name")
   private String name;
   @ApiModelProperty(name = "status", value = "status，状态，1开启，0禁用", notes = "status")
   private Integer status;
   @ApiModelProperty(name = "notificationType", value = "通知业务 NotificationModuleTypeEnum", notes = "通知业务")
   private List<Integer> notificationType;
   @ApiModelProperty(name = "notificationTypeName", value = "通知业务名称 NotificationModuleTypeEnum", notes = "通知业务名称")
   private List<String> notificationTypeName;

   public static SysPushWebhookConfigDTO.SysPushWebhookConfigDTOBuilder builder() {
      return new SysPushWebhookConfigDTO.SysPushWebhookConfigDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getHookUrl() {
      return this.hookUrl;
   }

   public String getName() {
      return this.name;
   }

   public Integer getStatus() {
      return this.status;
   }

   public List<Integer> getNotificationType() {
      return this.notificationType;
   }

   public List<String> getNotificationTypeName() {
      return this.notificationTypeName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setHookUrl(final String hookUrl) {
      this.hookUrl = hookUrl;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setNotificationType(final List<Integer> notificationType) {
      this.notificationType = notificationType;
   }

   public void setNotificationTypeName(final List<String> notificationTypeName) {
      this.notificationTypeName = notificationTypeName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushWebhookConfigDTO)) {
         return false;
      }

      SysPushWebhookConfigDTO other = (SysPushWebhookConfigDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$hookUrl = this.getHookUrl();
            Object other$hookUrl = other.getHookUrl();
            if (this$hookUrl == null ? other$hookUrl == null : this$hookUrl.equals(other$hookUrl)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$notificationType = this.getNotificationType();
                  Object other$notificationType = other.getNotificationType();
                  if (this$notificationType == null ? other$notificationType == null : this$notificationType.equals(other$notificationType)) {
                     Object this$notificationTypeName = this.getNotificationTypeName();
                     Object other$notificationTypeName = other.getNotificationTypeName();
                     return this$notificationTypeName == null
                        ? other$notificationTypeName == null
                        : this$notificationTypeName.equals(other$notificationTypeName);
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
      return other instanceof SysPushWebhookConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $hookUrl = this.getHookUrl();
      result = result * 59 + ($hookUrl == null ? 43 : $hookUrl.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $notificationType = this.getNotificationType();
      result = result * 59 + ($notificationType == null ? 43 : $notificationType.hashCode());
      Object $notificationTypeName = this.getNotificationTypeName();
      return result * 59 + ($notificationTypeName == null ? 43 : $notificationTypeName.hashCode());
   }

   @Override
   public String toString() {
      return "SysPushWebhookConfigDTO(id="
         + this.getId()
         + ", hookUrl="
         + this.getHookUrl()
         + ", name="
         + this.getName()
         + ", status="
         + this.getStatus()
         + ", notificationType="
         + this.getNotificationType()
         + ", notificationTypeName="
         + this.getNotificationTypeName()
         + ")";
   }

   public SysPushWebhookConfigDTO(
      final Long id,
      final String hookUrl,
      final String name,
      final Integer status,
      final List<Integer> notificationType,
      final List<String> notificationTypeName
   ) {
      this.id = id;
      this.hookUrl = hookUrl;
      this.name = name;
      this.status = status;
      this.notificationType = notificationType;
      this.notificationTypeName = notificationTypeName;
   }

   public SysPushWebhookConfigDTO() {
   }

   public static class SysPushWebhookConfigDTOBuilder {
      private Long id;
      private String hookUrl;
      private String name;
      private Integer status;
      private List<Integer> notificationType;
      private List<String> notificationTypeName;

      SysPushWebhookConfigDTOBuilder() {
      }

      public SysPushWebhookConfigDTO.SysPushWebhookConfigDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushWebhookConfigDTO.SysPushWebhookConfigDTOBuilder hookUrl(final String hookUrl) {
         this.hookUrl = hookUrl;
         return this;
      }

      public SysPushWebhookConfigDTO.SysPushWebhookConfigDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysPushWebhookConfigDTO.SysPushWebhookConfigDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public SysPushWebhookConfigDTO.SysPushWebhookConfigDTOBuilder notificationType(final List<Integer> notificationType) {
         this.notificationType = notificationType;
         return this;
      }

      public SysPushWebhookConfigDTO.SysPushWebhookConfigDTOBuilder notificationTypeName(final List<String> notificationTypeName) {
         this.notificationTypeName = notificationTypeName;
         return this;
      }

      public SysPushWebhookConfigDTO build() {
         return new SysPushWebhookConfigDTO(this.id, this.hookUrl, this.name, this.status, this.notificationType, this.notificationTypeName);
      }

      @Override
      public String toString() {
         return "SysPushWebhookConfigDTO.SysPushWebhookConfigDTOBuilder(id="
            + this.id
            + ", hookUrl="
            + this.hookUrl
            + ", name="
            + this.name
            + ", status="
            + this.status
            + ", notificationType="
            + this.notificationType
            + ", notificationTypeName="
            + this.notificationTypeName
            + ")";
      }
   }
}
