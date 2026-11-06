package com.hzchum.scim.common.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

public class AttachmentDTO {
   @ApiModelProperty(name = "id", value = "附件id")
   private Long id;
   @ApiModelProperty(name = "name", value = "附件名称")
   private String name;
   @JsonInclude(Include.NON_EMPTY)
   @ApiModelProperty(name = "imageUrl", value = "图片路径")
   private String imageUrl;
   @JsonInclude(Include.NON_EMPTY)
   @ApiModelProperty(name = "tinyImageUrl", value = "图片缩略图")
   private String tinyImageUrl;
   @ApiModelProperty(name = "createUserId", value = "上传用户id")
   private Long createUserId;
   @ApiModelProperty(name = "createUserName", value = "上传用户名称")
   private String createUserName;
   @ApiModelProperty(name = "type", value = "文件类型")
   private Integer type;
   @ApiModelProperty(name = "createTime", value = "创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty(name = "relative_path", value = "文件的相对路径(相对于所有的文件路径映射)")
   private String relativePath;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getImageUrl() {
      return this.imageUrl;
   }

   public String getTinyImageUrl() {
      return this.tinyImageUrl;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public Integer getType() {
      return this.type;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getRelativePath() {
      return this.relativePath;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setImageUrl(final String imageUrl) {
      this.imageUrl = imageUrl;
   }

   public void setTinyImageUrl(final String tinyImageUrl) {
      this.tinyImageUrl = tinyImageUrl;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setRelativePath(final String relativePath) {
      this.relativePath = relativePath;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AttachmentDTO)) {
         return false;
      }

      AttachmentDTO other = (AttachmentDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$createUserId = this.getCreateUserId();
         Object other$createUserId = other.getCreateUserId();
         if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
            Object this$type = this.getType();
            Object other$type = other.getType();
            if (this$type == null ? other$type == null : this$type.equals(other$type)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$imageUrl = this.getImageUrl();
                  Object other$imageUrl = other.getImageUrl();
                  if (this$imageUrl == null ? other$imageUrl == null : this$imageUrl.equals(other$imageUrl)) {
                     Object this$tinyImageUrl = this.getTinyImageUrl();
                     Object other$tinyImageUrl = other.getTinyImageUrl();
                     if (this$tinyImageUrl == null ? other$tinyImageUrl == null : this$tinyImageUrl.equals(other$tinyImageUrl)) {
                        Object this$createUserName = this.getCreateUserName();
                        Object other$createUserName = other.getCreateUserName();
                        if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                           Object this$createTime = this.getCreateTime();
                           Object other$createTime = other.getCreateTime();
                           if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
                              Object this$relativePath = this.getRelativePath();
                              Object other$relativePath = other.getRelativePath();
                              return this$relativePath == null ? other$relativePath == null : this$relativePath.equals(other$relativePath);
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
      return other instanceof AttachmentDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $imageUrl = this.getImageUrl();
      result = result * 59 + ($imageUrl == null ? 43 : $imageUrl.hashCode());
      Object $tinyImageUrl = this.getTinyImageUrl();
      result = result * 59 + ($tinyImageUrl == null ? 43 : $tinyImageUrl.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $relativePath = this.getRelativePath();
      return result * 59 + ($relativePath == null ? 43 : $relativePath.hashCode());
   }

   @Override
   public String toString() {
      return "AttachmentDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", imageUrl="
         + this.getImageUrl()
         + ", tinyImageUrl="
         + this.getTinyImageUrl()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", type="
         + this.getType()
         + ", createTime="
         + this.getCreateTime()
         + ", relativePath="
         + this.getRelativePath()
         + ")";
   }
}
