package com.hzchum.scim.bid.core.api.pojo._do;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.Version;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hzchum.pangu.common.config.JacksonCustomizerConfig.LocalDateTimeDeserializer;
import com.hzchum.pangu.common.config.JacksonCustomizerConfig.LocalDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "qiniu文件", description = "")
@TableName("files")
@Table(name = "files")
public class Files implements Serializable {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键id")
   @JsonProperty("id")
   @JSONField(name = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "name", value = "名称")
   @JsonProperty("name")
   @JSONField(name = "name")
   @TableField("name")
   @Column(name = "name")
   private String name;
   @ApiModelProperty(name = "path", value = "路径")
   @JsonProperty("path")
   @JSONField(name = "path")
   @TableField("path")
   @Column(name = "path")
   private String path;
   @ApiModelProperty(name = "hash", value = "hash")
   @JsonProperty("hash")
   @JSONField(name = "hash")
   @TableField("hash")
   @Column(name = "hash")
   private String hash;
   @ApiModelProperty(name = "size", value = "大小")
   @JsonProperty("size")
   @JSONField(name = "size")
   @TableField("size")
   @Column(name = "size")
   private Long size;
   @ApiModelProperty(name = "mimeType", value = "文件类型")
   @JsonProperty("mimeType")
   @JSONField(name = "mimeType")
   @TableField("mime_type")
   @Column(name = "mime_type")
   private String mimeType;
   @ApiModelProperty(name = "type", value = "类型")
   @JsonProperty("type")
   @JSONField(name = "type")
   @TableField("type")
   @Column(name = "type")
   private Integer type;
   @ApiModelProperty(hidden = true)
   @TableField(fill = FieldFill.INSERT)
   @Column
   @JsonInclude(Include.NON_NULL)
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   @JsonSerialize(using = LocalDateTimeSerializer.class)
   private LocalDateTime createTime;
   @ApiModelProperty(hidden = true)
   @TableField(fill = FieldFill.INSERT_UPDATE)
   @Column
   @JsonIgnore
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   @JsonSerialize(using = LocalDateTimeSerializer.class)
   private LocalDateTime updateTime;
   @ApiModelProperty(hidden = true)
   @Version
   @Column
   @JsonIgnore
   private Integer version;

   public static Files.FilesBuilder builder() {
      return new Files.FilesBuilder();
   }

   public Files() {
   }

   public Files(
      final Long id,
      final String name,
      final String path,
      final String hash,
      final Long size,
      final String mimeType,
      final Integer type,
      final LocalDateTime createTime,
      final LocalDateTime updateTime,
      final Integer version
   ) {
      this.id = id;
      this.name = name;
      this.path = path;
      this.hash = hash;
      this.size = size;
      this.mimeType = mimeType;
      this.type = type;
      this.createTime = createTime;
      this.updateTime = updateTime;
      this.version = version;
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getPath() {
      return this.path;
   }

   public String getHash() {
      return this.hash;
   }

   public Long getSize() {
      return this.size;
   }

   public String getMimeType() {
      return this.mimeType;
   }

   public Integer getType() {
      return this.type;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getUpdateTime() {
      return this.updateTime;
   }

   public Integer getVersion() {
      return this.version;
   }

   @JsonProperty("id")
   public Files setId(final Long id) {
      this.id = id;
      return this;
   }

   @JsonProperty("name")
   public Files setName(final String name) {
      this.name = name;
      return this;
   }

   @JsonProperty("path")
   public Files setPath(final String path) {
      this.path = path;
      return this;
   }

   @JsonProperty("hash")
   public Files setHash(final String hash) {
      this.hash = hash;
      return this;
   }

   @JsonProperty("size")
   public Files setSize(final Long size) {
      this.size = size;
      return this;
   }

   @JsonProperty("mimeType")
   public Files setMimeType(final String mimeType) {
      this.mimeType = mimeType;
      return this;
   }

   @JsonProperty("type")
   public Files setType(final Integer type) {
      this.type = type;
      return this;
   }

   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   public Files setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   @JsonIgnore
   @JsonDeserialize(using = LocalDateTimeDeserializer.class)
   public Files setUpdateTime(final LocalDateTime updateTime) {
      this.updateTime = updateTime;
      return this;
   }

   @JsonIgnore
   public Files setVersion(final Integer version) {
      this.version = version;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof Files)) {
         return false;
      }

      Files other = (Files)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$size = this.getSize();
         Object other$size = other.getSize();
         if (this$size == null ? other$size == null : this$size.equals(other$size)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$version = this.getVersion();
               Object other$version = other.getVersion();
               if (this$version == null ? other$version == null : this$version.equals(other$version)) {
                  Object this$name = this.getName();
                  Object other$name = other.getName();
                  if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                     Object this$path = this.getPath();
                     Object other$path = other.getPath();
                     if (this$path == null ? other$path == null : this$path.equals(other$path)) {
                        Object this$hash = this.getHash();
                        Object other$hash = other.getHash();
                        if (this$hash == null ? other$hash == null : this$hash.equals(other$hash)) {
                           Object this$mimeType = this.getMimeType();
                           Object other$mimeType = other.getMimeType();
                           if (this$mimeType == null ? other$mimeType == null : this$mimeType.equals(other$mimeType)) {
                              Object this$createTime = this.getCreateTime();
                              Object other$createTime = other.getCreateTime();
                              if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                                 Object this$updateTime = this.getUpdateTime();
                                 Object other$updateTime = other.getUpdateTime();
                                 return this$updateTime == null ? other$updateTime == null : this$updateTime.equals(other$updateTime);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof Files;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $size = this.getSize();
      result = result * 59 + ($size == null ? 43 : $size.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $version = this.getVersion();
      result = result * 59 + ($version == null ? 43 : $version.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $path = this.getPath();
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $hash = this.getHash();
      result = result * 59 + ($hash == null ? 43 : $hash.hashCode());
      Object $mimeType = this.getMimeType();
      result = result * 59 + ($mimeType == null ? 43 : $mimeType.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $updateTime = this.getUpdateTime();
      return result * 59 + ($updateTime == null ? 43 : $updateTime.hashCode());
   }

   @Override
   public String toString() {
      return "Files(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", path="
         + this.getPath()
         + ", hash="
         + this.getHash()
         + ", size="
         + this.getSize()
         + ", mimeType="
         + this.getMimeType()
         + ", type="
         + this.getType()
         + ", createTime="
         + this.getCreateTime()
         + ", updateTime="
         + this.getUpdateTime()
         + ", version="
         + this.getVersion()
         + ")";
   }

   public static class FilesBuilder {
      private Long id;
      private String name;
      private String path;
      private String hash;
      private Long size;
      private String mimeType;
      private Integer type;
      private LocalDateTime createTime;
      private LocalDateTime updateTime;
      private Integer version;

      FilesBuilder() {
      }

      @JsonProperty("id")
      public Files.FilesBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      @JsonProperty("name")
      public Files.FilesBuilder name(final String name) {
         this.name = name;
         return this;
      }

      @JsonProperty("path")
      public Files.FilesBuilder path(final String path) {
         this.path = path;
         return this;
      }

      @JsonProperty("hash")
      public Files.FilesBuilder hash(final String hash) {
         this.hash = hash;
         return this;
      }

      @JsonProperty("size")
      public Files.FilesBuilder size(final Long size) {
         this.size = size;
         return this;
      }

      @JsonProperty("mimeType")
      public Files.FilesBuilder mimeType(final String mimeType) {
         this.mimeType = mimeType;
         return this;
      }

      @JsonProperty("type")
      public Files.FilesBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      public Files.FilesBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      @JsonIgnore
      @JsonDeserialize(using = LocalDateTimeDeserializer.class)
      public Files.FilesBuilder updateTime(final LocalDateTime updateTime) {
         this.updateTime = updateTime;
         return this;
      }

      @JsonIgnore
      public Files.FilesBuilder version(final Integer version) {
         this.version = version;
         return this;
      }

      public Files build() {
         return new Files(this.id, this.name, this.path, this.hash, this.size, this.mimeType, this.type, this.createTime, this.updateTime, this.version);
      }

      @Override
      public String toString() {
         return "Files.FilesBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", path="
            + this.path
            + ", hash="
            + this.hash
            + ", size="
            + this.size
            + ", mimeType="
            + this.mimeType
            + ", type="
            + this.type
            + ", createTime="
            + this.createTime
            + ", updateTime="
            + this.updateTime
            + ", version="
            + this.version
            + ")";
      }
   }
}
