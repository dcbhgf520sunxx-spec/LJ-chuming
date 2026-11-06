package com.hzchum.scim.bid.core.api.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "文件 ")
public class FilesVO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("主键ID")
   private Long id;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("路径")
   private String path;
   @ApiModelProperty("hash")
   private String hash;
   @ApiModelProperty("大小")
   private Long size;
   @ApiModelProperty("文件类型")
   private String mimeType;
   @ApiModelProperty("类型")
   private Integer type;
   @ApiModelProperty("类型")
   private String url;

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

   public String getUrl() {
      return this.url;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPath(final String path) {
      this.path = path;
   }

   public void setHash(final String hash) {
      this.hash = hash;
   }

   public void setSize(final Long size) {
      this.size = size;
   }

   public void setMimeType(final String mimeType) {
      this.mimeType = mimeType;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setUrl(final String url) {
      this.url = url;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FilesVO)) {
         return false;
      }

      FilesVO other = (FilesVO)o;
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
                           Object this$url = this.getUrl();
                           Object other$url = other.getUrl();
                           return this$url == null ? other$url == null : this$url.equals(other$url);
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
      return other instanceof FilesVO;
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
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $path = this.getPath();
      result = result * 59 + ($path == null ? 43 : $path.hashCode());
      Object $hash = this.getHash();
      result = result * 59 + ($hash == null ? 43 : $hash.hashCode());
      Object $mimeType = this.getMimeType();
      result = result * 59 + ($mimeType == null ? 43 : $mimeType.hashCode());
      Object $url = this.getUrl();
      return result * 59 + ($url == null ? 43 : $url.hashCode());
   }

   @Override
   public String toString() {
      return "FilesVO(id="
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
         + ", url="
         + this.getUrl()
         + ")";
   }
}
