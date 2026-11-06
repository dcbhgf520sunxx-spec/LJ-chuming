package com.hzchum.scim.project.core.api.pojo.dtoParam.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel("施工资料表查询类")
public class ConstructionDataQueryDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "constructionStageType", value = "施工阶段 1 开工前 2 施工中 4 完工后")
   private Integer constructionStageType;
   @ApiModelProperty(name = "fileName", value = "文件名称")
   private String fileName;
   @ApiModelProperty(name = "fileFormatType", value = "文件格式类型")
   private Integer fileFormatType;
   @ApiModelProperty(name = "userName", value = "上传人")
   private String userName;
   @ApiModelProperty(name = "createTime", value = "上传时间")
   private LocalDateTime createTime;

   public static ConstructionDataQueryDTOParam.ConstructionDataQueryDTOParamBuilder builder() {
      return new ConstructionDataQueryDTOParam.ConstructionDataQueryDTOParamBuilder();
   }

   public ConstructionDataQueryDTOParam() {
   }

   public ConstructionDataQueryDTOParam(
      final Long projectId,
      final Integer constructionStageType,
      final String fileName,
      final Integer fileFormatType,
      final String userName,
      final LocalDateTime createTime
   ) {
      this.projectId = projectId;
      this.constructionStageType = constructionStageType;
      this.fileName = fileName;
      this.fileFormatType = fileFormatType;
      this.userName = userName;
      this.createTime = createTime;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Integer getConstructionStageType() {
      return this.constructionStageType;
   }

   public String getFileName() {
      return this.fileName;
   }

   public Integer getFileFormatType() {
      return this.fileFormatType;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setConstructionStageType(final Integer constructionStageType) {
      this.constructionStageType = constructionStageType;
   }

   public void setFileName(final String fileName) {
      this.fileName = fileName;
   }

   public void setFileFormatType(final Integer fileFormatType) {
      this.fileFormatType = fileFormatType;
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

      if (!(o instanceof ConstructionDataQueryDTOParam)) {
         return false;
      }

      ConstructionDataQueryDTOParam other = (ConstructionDataQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$constructionStageType = this.getConstructionStageType();
         Object other$constructionStageType = other.getConstructionStageType();
         if (this$constructionStageType == null ? other$constructionStageType == null : this$constructionStageType.equals(other$constructionStageType)) {
            Object this$fileFormatType = this.getFileFormatType();
            Object other$fileFormatType = other.getFileFormatType();
            if (this$fileFormatType == null ? other$fileFormatType == null : this$fileFormatType.equals(other$fileFormatType)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ConstructionDataQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $constructionStageType = this.getConstructionStageType();
      result = result * 59 + ($constructionStageType == null ? 43 : $constructionStageType.hashCode());
      Object $fileFormatType = this.getFileFormatType();
      result = result * 59 + ($fileFormatType == null ? 43 : $fileFormatType.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $createTime = this.getCreateTime();
      return result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
   }

   @Override
   public String toString() {
      return "ConstructionDataQueryDTOParam(projectId="
         + this.getProjectId()
         + ", constructionStageType="
         + this.getConstructionStageType()
         + ", fileName="
         + this.getFileName()
         + ", fileFormatType="
         + this.getFileFormatType()
         + ", userName="
         + this.getUserName()
         + ", createTime="
         + this.getCreateTime()
         + ")";
   }

   public static class ConstructionDataQueryDTOParamBuilder {
      private Long projectId;
      private Integer constructionStageType;
      private String fileName;
      private Integer fileFormatType;
      private String userName;
      private LocalDateTime createTime;

      ConstructionDataQueryDTOParamBuilder() {
      }

      public ConstructionDataQueryDTOParam.ConstructionDataQueryDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ConstructionDataQueryDTOParam.ConstructionDataQueryDTOParamBuilder constructionStageType(final Integer constructionStageType) {
         this.constructionStageType = constructionStageType;
         return this;
      }

      public ConstructionDataQueryDTOParam.ConstructionDataQueryDTOParamBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public ConstructionDataQueryDTOParam.ConstructionDataQueryDTOParamBuilder fileFormatType(final Integer fileFormatType) {
         this.fileFormatType = fileFormatType;
         return this;
      }

      public ConstructionDataQueryDTOParam.ConstructionDataQueryDTOParamBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ConstructionDataQueryDTOParam.ConstructionDataQueryDTOParamBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ConstructionDataQueryDTOParam build() {
         return new ConstructionDataQueryDTOParam(
            this.projectId, this.constructionStageType, this.fileName, this.fileFormatType, this.userName, this.createTime
         );
      }

      @Override
      public String toString() {
         return "ConstructionDataQueryDTOParam.ConstructionDataQueryDTOParamBuilder(projectId="
            + this.projectId
            + ", constructionStageType="
            + this.constructionStageType
            + ", fileName="
            + this.fileName
            + ", fileFormatType="
            + this.fileFormatType
            + ", userName="
            + this.userName
            + ", createTime="
            + this.createTime
            + ")";
      }
   }
}
