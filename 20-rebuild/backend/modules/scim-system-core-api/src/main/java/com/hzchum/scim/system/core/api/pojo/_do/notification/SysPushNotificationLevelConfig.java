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

@ApiModel(value = "SysPushNotificationLevelConfig对象", description = "")
@Entity
@TableName("sys_push_notification_level_config")
@Table(name = "sys_push_notification_level_config")
@org.hibernate.annotations.Table(appliesTo = "sys_push_notification_level_config")
public class SysPushNotificationLevelConfig extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "level", value = "等级", notes = "等级")
   @TableField("level")
   @Column(name = "level", columnDefinition = "int(11)  COMMENT '等级'", nullable = false)
   private Integer level;
   @ApiModelProperty(name = "color", value = "颜色", notes = "颜色")
   @TableField("color")
   @Column(name = "color", columnDefinition = "varchar(255)  COMMENT '颜色'", nullable = false)
   private String color;

   public static SysPushNotificationLevelConfig.SysPushNotificationLevelConfigBuilder builder() {
      return new SysPushNotificationLevelConfig.SysPushNotificationLevelConfigBuilder();
   }

   public SysPushNotificationLevelConfig() {
   }

   public SysPushNotificationLevelConfig(final Long id, final Integer level, final String color) {
      this.id = id;
      this.level = level;
      this.color = color;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getLevel() {
      return this.level;
   }

   public String getColor() {
      return this.color;
   }

   public SysPushNotificationLevelConfig setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysPushNotificationLevelConfig setLevel(final Integer level) {
      this.level = level;
      return this;
   }

   public SysPushNotificationLevelConfig setColor(final String color) {
      this.color = color;
      return this;
   }

   @Override
   public String toString() {
      return "SysPushNotificationLevelConfig(id=" + this.getId() + ", level=" + this.getLevel() + ", color=" + this.getColor() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushNotificationLevelConfig)) {
         return false;
      }

      SysPushNotificationLevelConfig other = (SysPushNotificationLevelConfig)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$level = this.getLevel();
         Object other$level = other.getLevel();
         if (this$level == null ? other$level == null : this$level.equals(other$level)) {
            Object this$color = this.getColor();
            Object other$color = other.getColor();
            return this$color == null ? other$color == null : this$color.equals(other$color);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysPushNotificationLevelConfig;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $level = this.getLevel();
      result = result * 59 + ($level == null ? 43 : $level.hashCode());
      Object $color = this.getColor();
      return result * 59 + ($color == null ? 43 : $color.hashCode());
   }

   public static class SysPushNotificationLevelConfigBuilder {
      private Long id;
      private Integer level;
      private String color;

      SysPushNotificationLevelConfigBuilder() {
      }

      public SysPushNotificationLevelConfig.SysPushNotificationLevelConfigBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushNotificationLevelConfig.SysPushNotificationLevelConfigBuilder level(final Integer level) {
         this.level = level;
         return this;
      }

      public SysPushNotificationLevelConfig.SysPushNotificationLevelConfigBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public SysPushNotificationLevelConfig build() {
         return new SysPushNotificationLevelConfig(this.id, this.level, this.color);
      }

      @Override
      public String toString() {
         return "SysPushNotificationLevelConfig.SysPushNotificationLevelConfigBuilder(id=" + this.id + ", level=" + this.level + ", color=" + this.color + ")";
      }
   }
}
