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

@ApiModel(value = "SysHomeCompanyDynamics对象", description = "")
@Entity
@TableName("sys_home_company_dynamics")
@Table(name = "sys_home_company_dynamics")
@org.hibernate.annotations.Table(appliesTo = "sys_home_company_dynamics")
public class SysHomeCompanyDynamics extends BaseEntity<Long> {
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
   @ApiModelProperty(name = "attachmentIds", value = "文件id", notes = "文件id")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(4096)  COMMENT '文件id'", nullable = true)
   private String attachmentIds;
   @ApiModelProperty(name = "informantDateTime", value = "创建日期", notes = "创建日期")
   @TableField("informant_date_time")
   @Column(name = "informant_date_time", columnDefinition = "datetime  COMMENT '创建日期'", nullable = true)
   private LocalDateTime informantDateTime;

   public static SysHomeCompanyDynamics.SysHomeCompanyDynamicsBuilder builder() {
      return new SysHomeCompanyDynamics.SysHomeCompanyDynamicsBuilder();
   }

   public SysHomeCompanyDynamics() {
   }

   public SysHomeCompanyDynamics(
      final Long id,
      final Long createUserId,
      final String createUserName,
      final String title,
      final String attachmentIds,
      final LocalDateTime informantDateTime
   ) {
      this.id = id;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
      this.title = title;
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

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public LocalDateTime getInformantDateTime() {
      return this.informantDateTime;
   }

   public SysHomeCompanyDynamics setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysHomeCompanyDynamics setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public SysHomeCompanyDynamics setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   public SysHomeCompanyDynamics setTitle(final String title) {
      this.title = title;
      return this;
   }

   public SysHomeCompanyDynamics setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   public SysHomeCompanyDynamics setInformantDateTime(final LocalDateTime informantDateTime) {
      this.informantDateTime = informantDateTime;
      return this;
   }

   @Override
   public String toString() {
      return "SysHomeCompanyDynamics(id="
         + this.getId()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", title="
         + this.getTitle()
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

      if (!(o instanceof SysHomeCompanyDynamics)) {
         return false;
      }

      SysHomeCompanyDynamics other = (SysHomeCompanyDynamics)o;
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
            Object this$createUserName = this.getCreateUserName();
            Object other$createUserName = other.getCreateUserName();
            if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
               Object this$title = this.getTitle();
               Object other$title = other.getTitle();
               if (this$title == null ? other$title == null : this$title.equals(other$title)) {
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
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysHomeCompanyDynamics;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $title = this.getTitle();
      result = result * 59 + ($title == null ? 43 : $title.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      result = result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
      Object $informantDateTime = this.getInformantDateTime();
      return result * 59 + ($informantDateTime == null ? 43 : $informantDateTime.hashCode());
   }

   public static class SysHomeCompanyDynamicsBuilder {
      private Long id;
      private Long createUserId;
      private String createUserName;
      private String title;
      private String attachmentIds;
      private LocalDateTime informantDateTime;

      SysHomeCompanyDynamicsBuilder() {
      }

      public SysHomeCompanyDynamics.SysHomeCompanyDynamicsBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysHomeCompanyDynamics.SysHomeCompanyDynamicsBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public SysHomeCompanyDynamics.SysHomeCompanyDynamicsBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public SysHomeCompanyDynamics.SysHomeCompanyDynamicsBuilder title(final String title) {
         this.title = title;
         return this;
      }

      public SysHomeCompanyDynamics.SysHomeCompanyDynamicsBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public SysHomeCompanyDynamics.SysHomeCompanyDynamicsBuilder informantDateTime(final LocalDateTime informantDateTime) {
         this.informantDateTime = informantDateTime;
         return this;
      }

      public SysHomeCompanyDynamics build() {
         return new SysHomeCompanyDynamics(this.id, this.createUserId, this.createUserName, this.title, this.attachmentIds, this.informantDateTime);
      }

      @Override
      public String toString() {
         return "SysHomeCompanyDynamics.SysHomeCompanyDynamicsBuilder(id="
            + this.id
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ", title="
            + this.title
            + ", attachmentIds="
            + this.attachmentIds
            + ", informantDateTime="
            + this.informantDateTime
            + ")";
      }
   }
}
