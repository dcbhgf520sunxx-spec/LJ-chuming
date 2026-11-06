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

@ApiModel(value = "SysPushNotificationSuitableObjectLink对象", description = "")
@Entity
@TableName("sys_push_notification_suitable_object_link")
@Table(name = "sys_push_notification_suitable_object_link")
@org.hibernate.annotations.Table(appliesTo = "sys_push_notification_suitable_object_link")
public class SysPushNotificationSuitableObjectLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "suitableObjectId", value = "所属id（部门 岗位  或者 人员 ）", notes = "所属id（部门 岗位  或者 人员 ）")
   @TableField("suitable_object_id")
   @Column(name = "suitable_object_id", columnDefinition = "bigint(20)  COMMENT '所属id（部门 岗位  或者 人员 ）'", nullable = false)
   private Long suitableObjectId;
   @ApiModelProperty(name = "sysPushNotificationConfigId", value = "配置表id", notes = "配置表id")
   @TableField("sys_push_notification_config_id")
   @Column(name = "sys_push_notification_config_id", columnDefinition = "bigint(20)  COMMENT '配置表id'", nullable = false)
   private Long sysPushNotificationConfigId;

   public static SysPushNotificationSuitableObjectLink.SysPushNotificationSuitableObjectLinkBuilder builder() {
      return new SysPushNotificationSuitableObjectLink.SysPushNotificationSuitableObjectLinkBuilder();
   }

   public SysPushNotificationSuitableObjectLink() {
   }

   public SysPushNotificationSuitableObjectLink(final Long id, final Long suitableObjectId, final Long sysPushNotificationConfigId) {
      this.id = id;
      this.suitableObjectId = suitableObjectId;
      this.sysPushNotificationConfigId = sysPushNotificationConfigId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getSuitableObjectId() {
      return this.suitableObjectId;
   }

   public Long getSysPushNotificationConfigId() {
      return this.sysPushNotificationConfigId;
   }

   public SysPushNotificationSuitableObjectLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysPushNotificationSuitableObjectLink setSuitableObjectId(final Long suitableObjectId) {
      this.suitableObjectId = suitableObjectId;
      return this;
   }

   public SysPushNotificationSuitableObjectLink setSysPushNotificationConfigId(final Long sysPushNotificationConfigId) {
      this.sysPushNotificationConfigId = sysPushNotificationConfigId;
      return this;
   }

   @Override
   public String toString() {
      return "SysPushNotificationSuitableObjectLink(id="
         + this.getId()
         + ", suitableObjectId="
         + this.getSuitableObjectId()
         + ", sysPushNotificationConfigId="
         + this.getSysPushNotificationConfigId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushNotificationSuitableObjectLink)) {
         return false;
      }

      SysPushNotificationSuitableObjectLink other = (SysPushNotificationSuitableObjectLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$suitableObjectId = this.getSuitableObjectId();
         Object other$suitableObjectId = other.getSuitableObjectId();
         if (this$suitableObjectId == null ? other$suitableObjectId == null : this$suitableObjectId.equals(other$suitableObjectId)) {
            Object this$sysPushNotificationConfigId = this.getSysPushNotificationConfigId();
            Object other$sysPushNotificationConfigId = other.getSysPushNotificationConfigId();
            return this$sysPushNotificationConfigId == null
               ? other$sysPushNotificationConfigId == null
               : this$sysPushNotificationConfigId.equals(other$sysPushNotificationConfigId);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysPushNotificationSuitableObjectLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $suitableObjectId = this.getSuitableObjectId();
      result = result * 59 + ($suitableObjectId == null ? 43 : $suitableObjectId.hashCode());
      Object $sysPushNotificationConfigId = this.getSysPushNotificationConfigId();
      return result * 59 + ($sysPushNotificationConfigId == null ? 43 : $sysPushNotificationConfigId.hashCode());
   }

   public static class SysPushNotificationSuitableObjectLinkBuilder {
      private Long id;
      private Long suitableObjectId;
      private Long sysPushNotificationConfigId;

      SysPushNotificationSuitableObjectLinkBuilder() {
      }

      public SysPushNotificationSuitableObjectLink.SysPushNotificationSuitableObjectLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushNotificationSuitableObjectLink.SysPushNotificationSuitableObjectLinkBuilder suitableObjectId(final Long suitableObjectId) {
         this.suitableObjectId = suitableObjectId;
         return this;
      }

      public SysPushNotificationSuitableObjectLink.SysPushNotificationSuitableObjectLinkBuilder sysPushNotificationConfigId(
         final Long sysPushNotificationConfigId
      ) {
         this.sysPushNotificationConfigId = sysPushNotificationConfigId;
         return this;
      }

      public SysPushNotificationSuitableObjectLink build() {
         return new SysPushNotificationSuitableObjectLink(this.id, this.suitableObjectId, this.sysPushNotificationConfigId);
      }

      @Override
      public String toString() {
         return "SysPushNotificationSuitableObjectLink.SysPushNotificationSuitableObjectLinkBuilder(id="
            + this.id
            + ", suitableObjectId="
            + this.suitableObjectId
            + ", sysPushNotificationConfigId="
            + this.sysPushNotificationConfigId
            + ")";
      }
   }
}
