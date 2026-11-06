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

@ApiModel(value = "SysPushWebhookConfig对象", description = "")
@Entity
@TableName("sys_push_webhook_config")
@Table(name = "sys_push_webhook_config")
@org.hibernate.annotations.Table(appliesTo = "sys_push_webhook_config")
public class SysPushWebhookConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "hook_url", value = "Webhooklu路径", notes = "Webhooklu路径")
   @TableField("hook_url")
   @Column(name = "hook_url", columnDefinition = "varchar(255)  COMMENT 'Webhooklu路径'", nullable = false)
   private String hookUrl;
   @ApiModelProperty(name = "name", value = "类型", notes = "名称")
   @TableField("name")
   @Column(name = "name", columnDefinition = "varchar(20)  COMMENT '名称'", nullable = false)
   private String name;
   @ApiModelProperty(name = "status", value = "状态", notes = "状态")
   @TableField("status")
   @Column(name = "status", columnDefinition = "int(2) default 1 comment '开启状态 1启用 0禁用'", nullable = false)
   private Integer status;
   @ApiModelProperty(name = "notification_type", value = "通知业务 NotificationModuleTypeEnum", notes = "通知业务")
   @TableField("notification_type")
   @Column(name = "notification_type", columnDefinition = "varchar(100)  COMMENT '通知业务'")
   private String notificationType;

   public static SysPushWebhookConfig.SysPushWebhookConfigBuilder builder() {
      return new SysPushWebhookConfig.SysPushWebhookConfigBuilder();
   }

   public SysPushWebhookConfig() {
   }

   public SysPushWebhookConfig(final Long id, final String hookUrl, final String name, final Integer status, final String notificationType) {
      this.id = id;
      this.hookUrl = hookUrl;
      this.name = name;
      this.status = status;
      this.notificationType = notificationType;
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

   public String getNotificationType() {
      return this.notificationType;
   }

   public SysPushWebhookConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysPushWebhookConfig setHookUrl(final String hookUrl) {
      this.hookUrl = hookUrl;
      return this;
   }

   public SysPushWebhookConfig setName(final String name) {
      this.name = name;
      return this;
   }

   public SysPushWebhookConfig setStatus(final Integer status) {
      this.status = status;
      return this;
   }

   public SysPushWebhookConfig setNotificationType(final String notificationType) {
      this.notificationType = notificationType;
      return this;
   }

   @Override
   public String toString() {
      return "SysPushWebhookConfig(id="
         + this.getId()
         + ", hookUrl="
         + this.getHookUrl()
         + ", name="
         + this.getName()
         + ", status="
         + this.getStatus()
         + ", notificationType="
         + this.getNotificationType()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushWebhookConfig)) {
         return false;
      }

      SysPushWebhookConfig other = (SysPushWebhookConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
                  return this$notificationType == null ? other$notificationType == null : this$notificationType.equals(other$notificationType);
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
      return other instanceof SysPushWebhookConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $hookUrl = this.getHookUrl();
      result = result * 59 + ($hookUrl == null ? 43 : $hookUrl.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $notificationType = this.getNotificationType();
      return result * 59 + ($notificationType == null ? 43 : $notificationType.hashCode());
   }

   public static class SysPushWebhookConfigBuilder {
      private Long id;
      private String hookUrl;
      private String name;
      private Integer status;
      private String notificationType;

      SysPushWebhookConfigBuilder() {
      }

      public SysPushWebhookConfig.SysPushWebhookConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushWebhookConfig.SysPushWebhookConfigBuilder hookUrl(final String hookUrl) {
         this.hookUrl = hookUrl;
         return this;
      }

      public SysPushWebhookConfig.SysPushWebhookConfigBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public SysPushWebhookConfig.SysPushWebhookConfigBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public SysPushWebhookConfig.SysPushWebhookConfigBuilder notificationType(final String notificationType) {
         this.notificationType = notificationType;
         return this;
      }

      public SysPushWebhookConfig build() {
         return new SysPushWebhookConfig(this.id, this.hookUrl, this.name, this.status, this.notificationType);
      }

      @Override
      public String toString() {
         return "SysPushWebhookConfig.SysPushWebhookConfigBuilder(id="
            + this.id
            + ", hookUrl="
            + this.hookUrl
            + ", name="
            + this.name
            + ", status="
            + this.status
            + ", notificationType="
            + this.notificationType
            + ")";
      }
   }
}
