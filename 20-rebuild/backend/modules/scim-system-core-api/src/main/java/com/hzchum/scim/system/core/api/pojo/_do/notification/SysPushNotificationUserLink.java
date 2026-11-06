package com.hzchum.scim.system.core.api.pojo._do.notification;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "SysPushNotificationUserLink对象", description = "")
@Entity
@TableName("sys_push_notification_user_link")
@Table(name = "sys_push_notification_user_link")
@org.hibernate.annotations.Table(appliesTo = "sys_push_notification_user_link")
public class SysPushNotificationUserLink extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "userId", value = "推送人员id", notes = "推送人员id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '推送人员id'")
   private Long userId;
   @ApiModelProperty(name = "sysPush   NotificationRecordId", value = "推送记录表", notes = "推送记录表")
   @TableField("sys_push_notification_record_id")
   @Column(name = "sys_push_notification_record_id", columnDefinition = "bigint(20)  COMMENT '推送记录表'")
   private Long sysPushNotificationRecordId;
   @ApiModelProperty(name = "serialNumber", value = "流水号", notes = "流水号")
   @TableField("serial_number")
   @Column(name = "serial_number", columnDefinition = "varchar(255)  COMMENT '流水号'")
   private String serialNumber;
   @ApiModelProperty(name = "push_time", notes = "推送时间")
   @TableField("push_time")
   @Column(name = "push_time", columnDefinition = "datetime  COMMENT '推送时间'")
   private LocalDateTime pushTime;
   @ApiModelProperty(name = "dataId", notes = "数据id")
   @TableField("data_id")
   @Column(name = "data_id", columnDefinition = "bigint(20)  COMMENT '数据id'")
   private Long dataId;
   @ApiModelProperty(name = "createUserId", notes = "创建人id")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "bigint(20)  COMMENT '创建人id'")
   private Long createUserId;
   @ApiModelProperty(name = "contentDetails", notes = "消息推送内容详情")
   @TableField("content_details")
   @Column(name = "content_details", columnDefinition = "varchar(1000)  COMMENT '消息推送内容详情'")
   private String contentDetails;

   public static SysPushNotificationUserLink.SysPushNotificationUserLinkBuilder builder() {
      return new SysPushNotificationUserLink.SysPushNotificationUserLinkBuilder();
   }

   public SysPushNotificationUserLink() {
   }

   public SysPushNotificationUserLink(
      final Long id,
      final Long userId,
      final Long sysPushNotificationRecordId,
      final String serialNumber,
      final LocalDateTime pushTime,
      final Long dataId,
      final Long createUserId,
      final String contentDetails
   ) {
      this.id = id;
      this.userId = userId;
      this.sysPushNotificationRecordId = sysPushNotificationRecordId;
      this.serialNumber = serialNumber;
      this.pushTime = pushTime;
      this.dataId = dataId;
      this.createUserId = createUserId;
      this.contentDetails = contentDetails;
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

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public LocalDateTime getPushTime() {
      return this.pushTime;
   }

   public Long getDataId() {
      return this.dataId;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getContentDetails() {
      return this.contentDetails;
   }

   public SysPushNotificationUserLink setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysPushNotificationUserLink setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public SysPushNotificationUserLink setSysPushNotificationRecordId(final Long sysPushNotificationRecordId) {
      this.sysPushNotificationRecordId = sysPushNotificationRecordId;
      return this;
   }

   public SysPushNotificationUserLink setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public SysPushNotificationUserLink setPushTime(final LocalDateTime pushTime) {
      this.pushTime = pushTime;
      return this;
   }

   public SysPushNotificationUserLink setDataId(final Long dataId) {
      this.dataId = dataId;
      return this;
   }

   public SysPushNotificationUserLink setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public SysPushNotificationUserLink setContentDetails(final String contentDetails) {
      this.contentDetails = contentDetails;
      return this;
   }

   @Override
   public String toString() {
      return "SysPushNotificationUserLink(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", sysPushNotificationRecordId="
         + this.getSysPushNotificationRecordId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", pushTime="
         + this.getPushTime()
         + ", dataId="
         + this.getDataId()
         + ", createUserId="
         + this.getCreateUserId()
         + ", contentDetails="
         + this.getContentDetails()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysPushNotificationUserLink)) {
         return false;
      }

      SysPushNotificationUserLink other = (SysPushNotificationUserLink)o;
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
               Object this$dataId = this.getDataId();
               Object other$dataId = other.getDataId();
               if (this$dataId == null ? other$dataId == null : this$dataId.equals(other$dataId)) {
                  Object this$createUserId = this.getCreateUserId();
                  Object other$createUserId = other.getCreateUserId();
                  if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
                     Object this$serialNumber = this.getSerialNumber();
                     Object other$serialNumber = other.getSerialNumber();
                     if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                        Object this$pushTime = this.getPushTime();
                        Object other$pushTime = other.getPushTime();
                        if (this$pushTime == null ? other$pushTime == null : this$pushTime.equals(other$pushTime)) {
                           Object this$contentDetails = this.getContentDetails();
                           Object other$contentDetails = other.getContentDetails();
                           return this$contentDetails == null ? other$contentDetails == null : this$contentDetails.equals(other$contentDetails);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysPushNotificationUserLink;
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
      Object $dataId = this.getDataId();
      result = result * 59 + ($dataId == null ? 43 : $dataId.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $pushTime = this.getPushTime();
      result = result * 59 + ($pushTime == null ? 43 : $pushTime.hashCode());
      Object $contentDetails = this.getContentDetails();
      return result * 59 + ($contentDetails == null ? 43 : $contentDetails.hashCode());
   }

   public static class SysPushNotificationUserLinkBuilder {
      private Long id;
      private Long userId;
      private Long sysPushNotificationRecordId;
      private String serialNumber;
      private LocalDateTime pushTime;
      private Long dataId;
      private Long createUserId;
      private String contentDetails;

      SysPushNotificationUserLinkBuilder() {
      }

      public SysPushNotificationUserLink.SysPushNotificationUserLinkBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysPushNotificationUserLink.SysPushNotificationUserLinkBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public SysPushNotificationUserLink.SysPushNotificationUserLinkBuilder sysPushNotificationRecordId(final Long sysPushNotificationRecordId) {
         this.sysPushNotificationRecordId = sysPushNotificationRecordId;
         return this;
      }

      public SysPushNotificationUserLink.SysPushNotificationUserLinkBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public SysPushNotificationUserLink.SysPushNotificationUserLinkBuilder pushTime(final LocalDateTime pushTime) {
         this.pushTime = pushTime;
         return this;
      }

      public SysPushNotificationUserLink.SysPushNotificationUserLinkBuilder dataId(final Long dataId) {
         this.dataId = dataId;
         return this;
      }

      public SysPushNotificationUserLink.SysPushNotificationUserLinkBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public SysPushNotificationUserLink.SysPushNotificationUserLinkBuilder contentDetails(final String contentDetails) {
         this.contentDetails = contentDetails;
         return this;
      }

      public SysPushNotificationUserLink build() {
         return new SysPushNotificationUserLink(
            this.id, this.userId, this.sysPushNotificationRecordId, this.serialNumber, this.pushTime, this.dataId, this.createUserId, this.contentDetails
         );
      }

      @Override
      public String toString() {
         return "SysPushNotificationUserLink.SysPushNotificationUserLinkBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", sysPushNotificationRecordId="
            + this.sysPushNotificationRecordId
            + ", serialNumber="
            + this.serialNumber
            + ", pushTime="
            + this.pushTime
            + ", dataId="
            + this.dataId
            + ", createUserId="
            + this.createUserId
            + ", contentDetails="
            + this.contentDetails
            + ")";
      }
   }
}
