package com.hzchum.scim.system.core.api.pojo._do;

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

@ApiModel(value = "SysHomeImportImage对象", description = "")
@Entity
@TableName("sys_home_import_image")
@Table(name = "sys_home_import_image")
@org.hibernate.annotations.Table(appliesTo = "sys_home_import_image")
public class SysHomeImportImage extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "attachmentIds", value = "文件id", notes = "文件id")
   @TableField("attachment_ids")
   @Column(name = "attachment_ids", columnDefinition = "varchar(255)  COMMENT '文件id'", nullable = true)
   private String attachmentIds;

   public static SysHomeImportImage.SysHomeImportImageBuilder builder() {
      return new SysHomeImportImage.SysHomeImportImageBuilder();
   }

   public SysHomeImportImage() {
   }

   public SysHomeImportImage(final Long id, final String attachmentIds) {
      this.id = id;
      this.attachmentIds = attachmentIds;
   }

   public Long getId() {
      return this.id;
   }

   public String getAttachmentIds() {
      return this.attachmentIds;
   }

   public SysHomeImportImage setId(final Long id) {
      this.id = id;
      return this;
   }

   public SysHomeImportImage setAttachmentIds(final String attachmentIds) {
      this.attachmentIds = attachmentIds;
      return this;
   }

   @Override
   public String toString() {
      return "SysHomeImportImage(id=" + this.getId() + ", attachmentIds=" + this.getAttachmentIds() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof SysHomeImportImage)) {
         return false;
      } else {
         SysHomeImportImage other = (SysHomeImportImage)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (!super.equals(o)) {
            return false;
         } else {
            Object this$id = this.getId();
            Object other$id = other.getId();
            if (this$id == null ? other$id == null : this$id.equals(other$id)) {
               Object this$attachmentIds = this.getAttachmentIds();
               Object other$attachmentIds = other.getAttachmentIds();
               return this$attachmentIds == null ? other$attachmentIds == null : this$attachmentIds.equals(other$attachmentIds);
            } else {
               return false;
            }
         }
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof SysHomeImportImage;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $attachmentIds = this.getAttachmentIds();
      return result * 59 + ($attachmentIds == null ? 43 : $attachmentIds.hashCode());
   }

   public static class SysHomeImportImageBuilder {
      private Long id;
      private String attachmentIds;

      SysHomeImportImageBuilder() {
      }

      public SysHomeImportImage.SysHomeImportImageBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public SysHomeImportImage.SysHomeImportImageBuilder attachmentIds(final String attachmentIds) {
         this.attachmentIds = attachmentIds;
         return this;
      }

      public SysHomeImportImage build() {
         return new SysHomeImportImage(this.id, this.attachmentIds);
      }

      @Override
      public String toString() {
         return "SysHomeImportImage.SysHomeImportImageBuilder(id=" + this.id + ", attachmentIds=" + this.attachmentIds + ")";
      }
   }
}
