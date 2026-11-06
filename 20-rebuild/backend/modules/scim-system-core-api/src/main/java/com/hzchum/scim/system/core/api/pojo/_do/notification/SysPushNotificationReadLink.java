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

@ApiModel(value = "SysPushNotificationReadLink对象", description = "")
@Entity
@TableName("sys_push_notification_read_link")
@Table(name = "sys_push_notification_read_link")
@org.hibernate.annotations.Table(appliesTo = "sys_push_notification_read_link")
public class SysPushNotificationReadLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "userId", value = "阅读人员id", notes = "阅读人员id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '阅读人员id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "sysPushNotificationRecordId", value = "推送消息id", notes = "推送消息id")
   @TableField("sys_push_notification_record_id")
   @Column(name = "sys_push_notification_record_id", columnDefinition = "bigint(20)  COMMENT '推送消息id'", nullable = false)
   private Long sysPushNotificationRecordId;
   @ApiModelProperty(name = "sysPushNotificationUserLinkId", value = "推送消息人员关联id", notes = "推送消息人员关联id")
   @TableField("sys_push_notification_user_link_id")
   @Column(name = "sys_push_notification_user_link_id", columnDefinition = "bigint(20)  COMMENT '推送消息人员关联id'", nullable = false)
   private Long sysPushNotificationUserLinkId;

   public static SysPushNotificationReadLink.SysPushNotificationReadLinkBuilder builder() {
      return new SysPushNotificationReadLink.SysPushNotificationReadLinkBuilder();
   }

   public SysPushNotificationReadLink() {
   }

   public SysPushNotificationReadLink(final Long id, final Long userId, final Long sysPushNotificationRecordId, final Long sysPushNotificationUserLinkId) {
      this.id = id;
      this.userId = userId;
      this.sysPushNotificationRecordId = sysPushNotificationRecordId;
      this.sysPushNotificationUserLinkId = sysPushNotificationUserLinkId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public Long getSysPushNotificationRecordId() {
      return this.sysPushNotificationRecordId;
   }

   public Long getSysPushNotificationUserLinkId() {
      return this.sysPushNotificationUserLinkId;
   }

   public SysPushNotificationReadLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysPushNotificationReadLink setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public SysPushNotificationReadLink setSysPushNotificationRecordId(final Long sysPushNotificationRecordId) {
      this.sysPushNotificationRecordId = sysPushNotificationRecordId;
      return this;
   }

   public SysPushNotificationReadLink setSysPushNotificationUserLinkId(final Long sysPushNotificationUserLinkId) {
      this.sysPushNotificationUserLinkId = sysPushNotificationUserLinkId;
      return this;
   }

   @Override
   public String toString() {
      return "SysPushNotificationReadLink(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", sysPushNotificationRecordId="
         + this.getSysPushNotificationRecordId()
         + ", sysPushNotificationUserLinkId="
         + this.getSysPushNotificationUserLinkId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushNotificationReadLink)) {
         return false;
      }

      SysPushNotificationReadLink other = (SysPushNotificationReadLink)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$sysPushNotificationRecordId = this.getSysPushNotificationRecordId();
            Object other$sysPushNotificationRecordId = other.getSysPushNotificationRecordId();
            if (this$sysPushNotificationRecordId == null
               ? other$sysPushNotificationRecordId == null
               : this$sysPushNotificationRecordId.equals(other$sysPushNotificationRecordId)) {
               Object this$sysPushNotificationUserLinkId = this.getSysPushNotificationUserLinkId();
               Object other$sysPushNotificationUserLinkId = other.getSysPushNotificationUserLinkId();
               return this$sysPushNotificationUserLinkId == null
                  ? other$sysPushNotificationUserLinkId == null
                  : this$sysPushNotificationUserLinkId.equals(other$sysPushNotificationUserLinkId);
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
      return other instanceof SysPushNotificationReadLink;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $sysPushNotificationRecordId = this.getSysPushNotificationRecordId();
      result = result * 59 + ($sysPushNotificationRecordId == null ? 43 : $sysPushNotificationRecordId.hashCode());
      Object $sysPushNotificationUserLinkId = this.getSysPushNotificationUserLinkId();
      return result * 59 + ($sysPushNotificationUserLinkId == null ? 43 : $sysPushNotificationUserLinkId.hashCode());
   }

   public static class SysPushNotificationReadLinkBuilder {
      private Long id;
      private Long userId;
      private Long sysPushNotificationRecordId;
      private Long sysPushNotificationUserLinkId;

      SysPushNotificationReadLinkBuilder() {
      }

      public SysPushNotificationReadLink.SysPushNotificationReadLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushNotificationReadLink.SysPushNotificationReadLinkBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public SysPushNotificationReadLink.SysPushNotificationReadLinkBuilder sysPushNotificationRecordId(final Long sysPushNotificationRecordId) {
         this.sysPushNotificationRecordId = sysPushNotificationRecordId;
         return this;
      }

      public SysPushNotificationReadLink.SysPushNotificationReadLinkBuilder sysPushNotificationUserLinkId(final Long sysPushNotificationUserLinkId) {
         this.sysPushNotificationUserLinkId = sysPushNotificationUserLinkId;
         return this;
      }

      public SysPushNotificationReadLink build() {
         return new SysPushNotificationReadLink(this.id, this.userId, this.sysPushNotificationRecordId, this.sysPushNotificationUserLinkId);
      }

      @Override
      public String toString() {
         return "SysPushNotificationReadLink.SysPushNotificationReadLinkBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", sysPushNotificationRecordId="
            + this.sysPushNotificationRecordId
            + ", sysPushNotificationUserLinkId="
            + this.sysPushNotificationUserLinkId
            + ")";
      }
   }
}
