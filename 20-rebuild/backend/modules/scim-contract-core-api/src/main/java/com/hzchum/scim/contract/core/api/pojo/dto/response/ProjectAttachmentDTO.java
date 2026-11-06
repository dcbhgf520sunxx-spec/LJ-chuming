package com.hzchum.scim.contract.core.api.pojo.dto.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel("项目档案详情 响应类")
public class ProjectAttachmentDTO {
   @ApiModelProperty("附件id")
   private Long id;
   @ApiModelProperty("附件名称")
   private String name;
   @ApiModelProperty("文件源")
   private String sourceName;
   @ApiModelProperty("操作人id")
   private Long createUserId;
   @ApiModelProperty("操作人名")
   private String createUserName;
   @ApiModelProperty("文件路径")
   private String filePath;
   @ApiModelProperty("上传时间")
   private LocalDateTime createTime;

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getSourceName() {
      return this.sourceName;
   }

   public Long getCreateUserId() {
      return this.createUserId;
   }

   public String getCreateUserName() {
      return this.createUserName;
   }

   public String getFilePath() {
      return this.filePath;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSourceName(final String sourceName) {
      this.sourceName = sourceName;
   }

   public void setCreateUserId(final Long createUserId) {
      this.createUserId = createUserId;
   }

   public void setCreateUserName(final String createUserName) {
      this.createUserName = createUserName;
   }

   public void setFilePath(final String filePath) {
      this.filePath = filePath;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectAttachmentDTO)) {
         return false;
      }

      ProjectAttachmentDTO other = (ProjectAttachmentDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$createUserId = this.getCreateUserId();
         Object other$createUserId = other.getCreateUserId();
         if (this$createUserId == null ? other$createUserId == null : this$createUserId.equals(other$createUserId)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$sourceName = this.getSourceName();
               Object other$sourceName = other.getSourceName();
               if (this$sourceName == null ? other$sourceName == null : this$sourceName.equals(other$sourceName)) {
                  Object this$createUserName = this.getCreateUserName();
                  Object other$createUserName = other.getCreateUserName();
                  if (this$createUserName == null ? other$createUserName == null : this$createUserName.equals(other$createUserName)) {
                     Object this$filePath = this.getFilePath();
                     Object other$filePath = other.getFilePath();
                     if (this$filePath == null ? other$filePath == null : this$filePath.equals(other$filePath)) {
                        Object this$createTime = this.getCreateTime();
                        Object other$createTime = other.getCreateTime();
                        return this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime);
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
      return other instanceof ProjectAttachmentDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $createUserId = this.getCreateUserId();
      result = result * 59 + ($createUserId == null ? 43 : $createUserId.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $sourceName = this.getSourceName();
      result = result * 59 + ($sourceName == null ? 43 : $sourceName.hashCode());
      Object $createUserName = this.getCreateUserName();
      result = result * 59 + ($createUserName == null ? 43 : $createUserName.hashCode());
      Object $filePath = this.getFilePath();
      result = result * 59 + ($filePath == null ? 43 : $filePath.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectAttachmentDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", sourceName="
         + this.getSourceName()
         + ", createUserId="
         + this.getCreateUserId()
         + ", createUserName="
         + this.getCreateUserName()
         + ", filePath="
         + this.getFilePath()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }
}
