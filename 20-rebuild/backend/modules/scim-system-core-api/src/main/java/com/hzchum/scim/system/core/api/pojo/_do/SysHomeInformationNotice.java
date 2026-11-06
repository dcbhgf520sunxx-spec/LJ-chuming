package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "SysHomeInformationNotice对象", description = "")
@Entity
@TableName("sys_home_information_notice")
@Table(name = "sys_home_information_notice")
@org.hibernate.annotations.Table(appliesTo = "sys_home_information_notice")
public class SysHomeInformationNotice extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "createUserId", value = "创建人", notes = "创建人")
   @TableField("create_user_id")
   @Column(name = "create_user_id", columnDefinition = "int  COMMENT '创建人'", nullable = false)
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "创建人姓名", notes = "创建人姓名")
   @TableField("create_user_name")
   @Column(name = "create_user_name", columnDefinition = "varchar(255)  COMMENT '创建人姓名'", nullable = false)
   private String createUserName;
   @ApiModelProperty(name = "title", value = "标题", notes = "标题")
   @TableField("title")
   @Column(name = "title", columnDefinition = "varchar(4096)  COMMENT '标题'", nullable = false)
   private String title;
   @ApiModelProperty(name = "sysHomeContentType", value = "内容类型", notes = "内容类型")
   @TableField("sys_home_content_type")
   @Column(name = "sys_home_content_type", columnDefinition = "int  COMMENT '内容类型'", nullable = false)
   private Integer sysHomeContentType;
   @ApiModelProperty(name = "content", value = "内容", notes = "内容")
   @TableField("content")
   @Column(name = "content", columnDefinition = "varchar(11000)  COMMENT '内容'", nullable = true)
   private String content;
   @ApiModelProperty(name = "attachmentIds", value = "文件id", notes = "文件id")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(255)  COMMENT '文件id'", nullable = true)
   private String attachmentIds;
   @ApiModelProperty(name = "informantDateTime", value = "创建日期", notes = "创建日期")
   @TableField("informant_date_time")
   @Column(name = "informant_date_time", columnDefinition = "datetime  COMMENT '创建日期'", nullable = true)
   private LocalDateTime informantDateTime;

   public static SysHomeInformationNotice.SysHomeInformationNoticeBuilder builder() {
      return new SysHomeInformationNotice.SysHomeInformationNoticeBuilder();
   }

   public SysHomeInformationNotice() {
   }

   public SysHomeInformationNotice(
      final Long id,
      final Long createUserId,
      final String createUserName,
      final String title,
      final Integer sysHomeContentType,
      final String content,
      final String attachmentIds,
      final LocalDateTime informantDateTime
   ) {
      this.id = id;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.title = title;
      this.sysHomeContentType = sysHomeContentType;
      this.content = content;
      this.attachmentIds = attachmentIds;
      this.informantDateTime = informantDateTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public String getTitle() {
      return this.title;
   }

   public Integer getSysHomeContentType() {
      return this.sysHomeContentType;
   }

   public String getContent() {
      return this.content;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public SysHomeInformationNotice setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysHomeInformationNotice setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public SysHomeInformationNotice setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public SysHomeInformationNotice setTitle(final String title) {
      this.title = title;
      return this;
   }

   public SysHomeInformationNotice setSysHomeContentType(final Integer sysHomeContentType) {
      this.sysHomeContentType = sysHomeContentType;
      return this;
   }

   public SysHomeInformationNotice setContent(final String content) {
      this.content = content;
      return this;
   }

   public SysHomeInformationNotice setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public SysHomeInformationNotice setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   @Override
   public String toString() {
      return "SysHomeInformationNotice(id="
         + this.getId()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", title="
         + this.getTitle()
         + ", sysHomeContentType="
         + this.getSysHomeContentType()
         + ", content="
         + this.getContent()
         + ", attachmentIds="
         + this.getAttachmentIds()
         + ", informantDateTime="
         + this.getInformantDateTime()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SysHomeInformationNotice)) {
         return false;
      }

      SysHomeInformationNotice other = (SysHomeInformationNotice)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$createUserId = this.getCreateUserId();
         Object other$createUserId = other.getCreateUserId();
         if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
            Object this$sysHomeContentType = this.getSysHomeContentType();
            Object other$sysHomeContentType = other.getSysHomeContentType();
            if (this$sysHomeContentType == null ? other$sysHomeContentType == null : this$sysHomeContentType.equals(other$sysHomeContentType)) {
               Object this$createUserName = this.getCreateUserName();
               Object other$createUserName = other.getCreateUserName();
               if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                  Object this$title = this.getTitle();
                  Object other$title = other.getTitle();
                  if (this$title == null ? other$title == null : this$title.equals(other$title)) {
                     Object this$content = this.getContent();
                     Object other$content = other.getContent();
                     if (this$content == null ? other$content == null : this$content.equals(other$content)) {
                        Object this$attachmentIds = this.getAttachmentIds();
                        Object other$attachmentIds = other.getAttachmentIds();
                        if (this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds)) {
                           Object this$informantDateTime = this.getInformantDateTime();
                           Object other$informantDateTime = other.getInformantDateTime();
                           return this$informantDateTime == null ? other$informantDateTime == null : this$informantDateTime.equals(other$informantDateTime);
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
      return other instanceof SysHomeInformationNotice;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $sysHomeContentType = this.getSysHomeContentType();
      result = result * 59 + ($sysHomeContentType == null ? 43 : $sysHomeContentType.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $content = this.getContent();
      result = result * 59 + ($content == null ? 43 : $content.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      return result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
   }

   public static class SysHomeInformationNoticeBuilder {
      private Long id;
      private Long createUserId;
      private String createUserName;
      private String title;
      private Integer sysHomeContentType;
      private String content;
      private String attachmentIds;
      private LocalDateTime informantDateTime;

      SysHomeInformationNoticeBuilder() {
      }

      public SysHomeInformationNotice.SysHomeInformationNoticeBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysHomeInformationNotice.SysHomeInformationNoticeBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public SysHomeInformationNotice.SysHomeInformationNoticeBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public SysHomeInformationNotice.SysHomeInformationNoticeBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public SysHomeInformationNotice.SysHomeInformationNoticeBuilder sysHomeContentType(final Integer sysHomeContentType) {
         this.sysHomeContentType = sysHomeContentType;
         return this;
      }

      public SysHomeInformationNotice.SysHomeInformationNoticeBuilder content(final String content) {
         this.content = content;
         return this;
      }

      public SysHomeInformationNotice.SysHomeInformationNoticeBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public SysHomeInformationNotice.SysHomeInformationNoticeBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public SysHomeInformationNotice build() {
         return new SysHomeInformationNotice(
            this.id, this.createUserId, this.createUserName, this.title, this.sysHomeContentType, this.content, this.attachmentIds, this.informantDateTime
         );
      }

      @Override
      public String toString() {
         return "SysHomeInformationNotice.SysHomeInformationNoticeBuilder(id="
            + this.id
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", title="
            + this.title
            + ", sysHomeContentType="
            + this.sysHomeContentType
            + ", content="
            + this.content
            + ", attachmentIds="
            + this.attachmentIds
            + ", informantDateTime="
            + this.informantDateTime
            + ")";
      }
   }
}
