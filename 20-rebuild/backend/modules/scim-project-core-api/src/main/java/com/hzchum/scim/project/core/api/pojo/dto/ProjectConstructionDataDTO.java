package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel("施工资料表dto")
public class ProjectConstructionDataDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "constructionStageType", value = "施工阶段 1 开工前 2 施工中 4 完工后")
   private Integer constructionStageType;
   @ApiModelProperty(name = "attachmentId", value = "附件id")
   private Long attachmentId;
   @ApiModelProperty(name = "fileName", value = "文件名称")
   private String fileName;
   @ApiModelProperty(name = "fileFormatType", value = "文件格式类型")
   private Integer fileFormatType;
   @ApiModelProperty(name = "userId", value = "上传人id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "上传人")
   private String userName;
   @ApiModelProperty(name = "createTime", value = "上传时间")
   private LocalDateTime createTime;

   public static ProjectConstructionDataDTO.ProjectConstructionDataDTOBuilder builder() {
      return new ProjectConstructionDataDTO.ProjectConstructionDataDTOBuilder();
   }

   public ProjectConstructionDataDTO() {
   }

   public ProjectConstructionDataDTO(
      final Long id,
      final Long projectId,
      final Integer constructionStageType,
      final Long attachmentId,
      final String fileName,
      final Integer fileFormatType,
      final Long userId,
      final String userName,
      final LocalDateTime createTime
   ) {
      this.id = id;
      this.projectId = projectId;
      this.constructionStageType = constructionStageType;
      this.attachmentId = attachmentId;
      this.fileName = fileName;
      this.fileFormatType = fileFormatType;
      this.userId = userId;
      this.userName = userName;
      this.createTime = createTime;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getConstructionStageType() {
      return this.constructionStageType;
   }

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public String getFileName() {
      return this.fileName;
   }

   public Integer getFileFormatType() {
      return this.fileFormatType;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setConstructionStageType(final Integer constructionStageType) {
      this.constructionStageType = constructionStageType;
   }

   public void setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
   }

   public void setFileName(final String fileName) {
      this.fileName = fileName;
   }

   public void setFileFormatType(final Integer fileFormatType) {
      this.fileFormatType = fileFormatType;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectConstructionDataDTO)) {
         return false;
      }

      ProjectConstructionDataDTO other = (ProjectConstructionDataDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$constructionStageType = this.getConstructionStageType();
            Object other$constructionStageType = other.getConstructionStageType();
            if (this$constructionStageType == null ? other$constructionStageType == null : this$constructionStageType.equals(other$constructionStageType)) {
               Object this$attachmentId = this.getAttachmentId();
               Object other$attachmentId = other.getAttachmentId();
               if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
                  Object this$fileFormatType = this.getFileFormatType();
                  Object other$fileFormatType = other.getFileFormatType();
                  if (this$fileFormatType == null ? other$fileFormatType == null : this$fileFormatType.equals(other$fileFormatType)) {
                     Object this$userId = this.getUserId();
                     Object other$userId = other.getUserId();
                     if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                        Object this$fileName = this.getFileName();
                        Object other$fileName = other.getFileName();
                        if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
                           Object this$userName = this.getUserName();
                           Object other$userName = other.getUserName();
                           if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectConstructionDataDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $constructionStageType = this.getConstructionStageType();
      result = result * 59 + ($constructionStageType == null ? 43 : $constructionStageType.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $fileFormatType = this.getFileFormatType();
      result = result * 59 + ($fileFormatType == null ? 43 : $fileFormatType.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectConstructionDataDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", constructionStageType="
         + this.getConstructionStageType()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", fileName="
         + this.getFileName()
         + ", fileFormatType="
         + this.getFileFormatType()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public static class ProjectConstructionDataDTOBuilder {
      private Long id;
      private Long projectId;
      private Integer constructionStageType;
      private Long attachmentId;
      private String fileName;
      private Integer fileFormatType;
      private Long userId;
      private String userName;
      private LocalDateTime createTime;

      ProjectConstructionDataDTOBuilder() {
      }

      public ProjectConstructionDataDTO.ProjectConstructionDataDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectConstructionDataDTO.ProjectConstructionDataDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectConstructionDataDTO.ProjectConstructionDataDTOBuilder constructionStageType(final Integer constructionStageType) {
         this.constructionStageType = constructionStageType;
         return this;
      }

      public ProjectConstructionDataDTO.ProjectConstructionDataDTOBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public ProjectConstructionDataDTO.ProjectConstructionDataDTOBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public ProjectConstructionDataDTO.ProjectConstructionDataDTOBuilder fileFormatType(final Integer fileFormatType) {
         this.fileFormatType = fileFormatType;
         return this;
      }

      public ProjectConstructionDataDTO.ProjectConstructionDataDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ProjectConstructionDataDTO.ProjectConstructionDataDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectConstructionDataDTO.ProjectConstructionDataDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ProjectConstructionDataDTO build() {
         return new ProjectConstructionDataDTO(
            this.id,
            this.projectId,
            this.constructionStageType,
            this.attachmentId,
            this.fileName,
            this.fileFormatType,
            this.userId,
            this.userName,
            this.createTime
         );
      }

      @Override
      public String toString() {
         return "ProjectConstructionDataDTO.ProjectConstructionDataDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", constructionStageType="
            + this.constructionStageType
            + ", attachmentId="
            + this.attachmentId
            + ", fileName="
            + this.fileName
            + ", fileFormatType="
            + this.fileFormatType
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
