package com.hzchum.scim.project.core.api.pojo._do;

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

@ApiModel(value = "ProjectConstructionData对象", description = "施工资料表")
@Entity
@TableName("project_construction_data")
@Table(name = "project_construction_data")
@org.hibernate.annotations.Table(appliesTo = "project_construction_data", comment = "施工资料表 ")
public class ProjectConstructionData extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目ID'", nullable = false)
   private Long projectId;
   @ApiModelProperty(name = "constructionStageType", value = "施工阶段 1 开工前 2 施工中 4 完工后")
   @TableField("construction_stage_type")
   @Column(name = "construction_stage_type", columnDefinition = "int(11)  COMMENT '工程阶段,枚举 ConstructionStageTypeEnum'", nullable = false)
   private Integer constructionStageType;
   @ApiModelProperty(name = "attachmentId", value = "附件id")
   @TableField("attachment_id")
   @Column(name = "attachment_id", columnDefinition = "bigint(20)  COMMENT '附件id'", nullable = false)
   private Long attachmentId;
   @ApiModelProperty(name = "fileName", value = "文件名称")
   @TableField("file_name")
   @Column(name = "file_name", columnDefinition = "varchar(64)  COMMENT '文件名称'", nullable = false)
   private String fileName;
   @ApiModelProperty(name = "fileFormatType", value = "文件格式类型")
   @TableField("file_format_type")
   @Column(name = "file_format_type", columnDefinition = "int(11)  COMMENT '文件格式,枚举 FileFormatTypeEnum'")
   private Integer fileFormatType;
   @ApiModelProperty(name = "userId", value = "上传人id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '上传人id'")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "上传人")
   @TableField("user_name")
   @Column(name = "user_name", columnDefinition = "varchar(64)  COMMENT '上传人'")
   private String userName;

   public static ProjectConstructionData.ProjectConstructionDataBuilder builder() {
      return new ProjectConstructionData.ProjectConstructionDataBuilder();
   }

   public ProjectConstructionData() {
   }

   public ProjectConstructionData(
      final Long id,
      final Long projectId,
      final Integer constructionStageType,
      final Long attachmentId,
      final String fileName,
      final Integer fileFormatType,
      final Long userId,
      final String userName
   ) {
      this.id = id;
      this.projectId = projectId;
      this.constructionStageType = constructionStageType;
      this.attachmentId = attachmentId;
      this.fileName = fileName;
      this.fileFormatType = fileFormatType;
      this.userId = userId;
      this.userName = userName;
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

   public ProjectConstructionData setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectConstructionData setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ProjectConstructionData setConstructionStageType(final Integer constructionStageType) {
      this.constructionStageType = constructionStageType;
      return this;
   }

   public ProjectConstructionData setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
      return this;
   }

   public ProjectConstructionData setFileName(final String fileName) {
      this.fileName = fileName;
      return this;
   }

   public ProjectConstructionData setFileFormatType(final Integer fileFormatType) {
      this.fileFormatType = fileFormatType;
      return this;
   }

   public ProjectConstructionData setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ProjectConstructionData setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   @Override
   public String toString() {
      return "ProjectConstructionData(id="
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
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectConstructionData)) {
         return false;
      }

      ProjectConstructionData other = (ProjectConstructionData)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
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
                           return this$userName == null ? other$userName == null : this$userName.equals(other$userName);
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
      return other instanceof ProjectConstructionData;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
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
      return result * 59 + ($userName == null ? 43 : $userName.hashCode());
   }

   public static class ProjectConstructionDataBuilder {
      private Long id;
      private Long projectId;
      private Integer constructionStageType;
      private Long attachmentId;
      private String fileName;
      private Integer fileFormatType;
      private Long userId;
      private String userName;

      ProjectConstructionDataBuilder() {
      }

      public ProjectConstructionData.ProjectConstructionDataBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectConstructionData.ProjectConstructionDataBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectConstructionData.ProjectConstructionDataBuilder constructionStageType(final Integer constructionStageType) {
         this.constructionStageType = constructionStageType;
         return this;
      }

      public ProjectConstructionData.ProjectConstructionDataBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public ProjectConstructionData.ProjectConstructionDataBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public ProjectConstructionData.ProjectConstructionDataBuilder fileFormatType(final Integer fileFormatType) {
         this.fileFormatType = fileFormatType;
         return this;
      }

      public ProjectConstructionData.ProjectConstructionDataBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ProjectConstructionData.ProjectConstructionDataBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ProjectConstructionData build() {
         return new ProjectConstructionData(
            this.id, this.projectId, this.constructionStageType, this.attachmentId, this.fileName, this.fileFormatType, this.userId, this.userName
         );
      }

      @Override
      public String toString() {
         return "ProjectConstructionData.ProjectConstructionDataBuilder(id="
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
            + ")";
      }
   }
}
