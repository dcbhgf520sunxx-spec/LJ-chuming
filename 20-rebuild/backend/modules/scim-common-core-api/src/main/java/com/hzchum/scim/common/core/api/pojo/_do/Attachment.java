package com.hzchum.scim.common.core.api.pojo._do;

import com.baomidou.mybatisplus.annotation.IdType;
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

@ApiModel(value = "Attachment对象", description = "")
@Entity
@TableName("attachment")
@Table(name = "attachment")
public class Attachment extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "文件名")
   @Column
   private String name;
   @ApiModelProperty(name = "thumbnail_path", value = "文件缩略图相对路径")
   @Column
   private String thumbnailPath;
   @ApiModelProperty(name = "relative_path", value = "文件的相对路径(相对于所有的文件路径映射)")
   @Column
   private String relativePath;
   @ApiModelProperty(name = "type", value = "文件分类")
   @Column
   private Integer type;
   @ApiModelProperty(name = "media_type", value = "文件格式")
   @Column
   private String mediaType;
   @ApiModelProperty(name = "createUserId", value = "上传用户id")
   @Column
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "上传用户名称")
   @Column
   private String createUserName;

   public static Attachment.AttachmentBuilder builder() {
      return new Attachment.AttachmentBuilder();
   }

   public Attachment() {
   }

   public Attachment(
      final Long id,
      final String name,
      final String thumbnailPath,
      final String relativePath,
      final Integer type,
      final String mediaType,
      final Long createUserId,
      final String createUserName
   ) {
      this.id = id;
      this.name = name;
      this.thumbnailPath = thumbnailPath;
      this.relativePath = relativePath;
      this.type = type;
      this.mediaType = mediaType;
      this.createUserId = createUserId;
      this.createUserName = createUserName;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getThumbnailPath() {
      return this.thumbnailPath;
   }

   public String getRelativePath() {
      return this.relativePath;
   }

   public Integer getType() {
      return this.type;
   }

   public String getMediaType() {
      return this.mediaType;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Attachment setId(final Long id) {
      this.id = id;
      return this;
   }

   public Attachment setName(final String name) {
      this.name = name;
      return this;
   }

   public Attachment setThumbnailPath(final String thumbnailPath) {
      this.thumbnailPath = thumbnailPath;
      return this;
   }

   public Attachment setRelativePath(final String relativePath) {
      this.relativePath = relativePath;
      return this;
   }

   public Attachment setType(final Integer type) {
      this.type = type;
      return this;
   }

   public Attachment setMediaType(final String mediaType) {
      this.mediaType = mediaType;
      return this;
   }

   public Attachment setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
      return this;
   }

   public Attachment setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
      return this;
   }

   @Override
   public String toString() {
      return "Attachment(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", thumbnailPath="
         + this.getThumbnailPath()
         + ", relativePath="
         + this.getRelativePath()
         + ", type="
         + this.getType()
         + ", mediaType="
         + this.getMediaType()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Attachment)) {
         return false;
      }

      Attachment other = (Attachment)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$createUserId = this.getCreateUserId();
            Object other$createUserId = other.getCreateUserId();
            if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$thumbnailPath = this.getThumbnailPath();
                  Object other$thumbnailPath = other.getThumbnailPath();
                  if (this$thumbnailPath == null ? other$thumbnailPath == null : this$thumbnailPath.equals(other$thumbnailPath)) {
                     Object this$relativePath = this.getRelativePath();
                     Object other$relativePath = other.getRelativePath();
                     if (this$relativePath == null ? other$relativePath == null : this$relativePath.equals(other$relativePath)) {
                        Object this$mediaType = this.getMediaType();
                        Object other$mediaType = other.getMediaType();
                        if (this$mediaType == null ? other$mediaType == null : this$mediaType.equals(other$mediaType)) {
                           Object this$createUserName = this.getCreateUserName();
                           Object other$createUserName = other.getCreateUserName();
                           return this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName);
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
      return other instanceof Attachment;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $thumbnailPath = this.getThumbnailPath();
      result = result * 59 + ($thumbnailPath == null ? 43 : $thumbnailPath.hashCode());
      Object $relativePath = this.getRelativePath();
      result = result * 59 + ($relativePath == null ? 43 : $relativePath.hashCode());
      Object $mediaType = this.getMediaType();
      result = result * 59 + ($mediaType == null ? 43 : $mediaType.hashCode());
      Object $createUserName = this.getCreateUserName();
      return result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
   }

   public static class AttachmentBuilder {
      private Long id;
      private String name;
      private String thumbnailPath;
      private String relativePath;
      private Integer type;
      private String mediaType;
      private Long createUserId;
      private String createUserName;

      AttachmentBuilder() {
      }

      public Attachment.AttachmentBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public Attachment.AttachmentBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public Attachment.AttachmentBuilder thumbnailPath(final String thumbnailPath) {
         this.thumbnailPath = thumbnailPath;
         return this;
      }

      public Attachment.AttachmentBuilder relativePath(final String relativePath) {
         this.relativePath = relativePath;
         return this;
      }

      public Attachment.AttachmentBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public Attachment.AttachmentBuilder mediaType(final String mediaType) {
         this.mediaType = mediaType;
         return this;
      }

      public Attachment.AttachmentBuilder createUserId(final Long createUserId) {
         this.createUserId = createUserId;
         return this;
      }

      public Attachment.AttachmentBuilder createUserName(final String createUserName) {
         this.createUserName = createUserName;
         return this;
      }

      public Attachment build() {
         return new Attachment(this.id, this.name, this.thumbnailPath, this.relativePath, this.type, this.mediaType, this.createUserId, this.createUserName);
      }

      @Override
      public String toString() {
         return "Attachment.AttachmentBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", thumbnailPath="
            + this.thumbnailPath
            + ", relativePath="
            + this.relativePath
            + ", type="
            + this.type
            + ", mediaType="
            + this.mediaType
            + ", createUserId="
            + this.createUserId
            + ", createUserName="
            + this.createUserName
            + ")";
      }
   }
}
