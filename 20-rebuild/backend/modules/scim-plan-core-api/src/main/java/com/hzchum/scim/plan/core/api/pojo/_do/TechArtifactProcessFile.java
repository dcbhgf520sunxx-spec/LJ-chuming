package com.hzchum.scim.plan.core.api.pojo._do;

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

@ApiModel(value = "TechArtifactProcessFile对象", description = "构件工艺文件表 ")
@Entity
@TableName("tech_artifact_process_file")
@Table(name = "tech_artifact_process_file")
@org.hibernate.annotations.Table(appliesTo = "tech_artifact_process_file", comment = "构件工艺文件表 ")
public class TechArtifactProcessFile extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "processType", value = "工艺类型 1焊接工艺 2装配工艺 4涂装工艺", notes = "工艺类型 1焊接工艺 2装配工艺 4涂装工艺")
   @TableField("process_type")
   @Column(name = "process_type", columnDefinition = "int(11)  COMMENT '工艺类型 1焊接工艺 2装配工艺 4涂装工艺'", nullable = false)
   private Integer processType;
   @ApiModelProperty(name = "boolSingleProject", value = "是否项目专用 true专用 false通用", notes = "true专用 false通用")
   @TableField("bool_single_project")
   @Column(name = "bool_single_project", columnDefinition = "tinyint(1)  COMMENT '是否项目专用 true专用 false通用'", nullable = false)
   private Boolean boolSingleProject;
   @ApiModelProperty(name = "projectId", value = "项目id 专用时必填", notes = "项目id 专用时必填")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id 专用时必填'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "fileName", value = "文件名称", notes = "文件名称")
   @TableField("file_name")
   @Column(name = "file_name", columnDefinition = "varchar(255)  COMMENT '文件名称'", nullable = false)
   private String fileName;
   @ApiModelProperty(name = "fileVersion", value = "文件版本", notes = "文件版本")
   @TableField("file_version")
   @Column(name = "file_version", columnDefinition = "int(11) default '1' COMMENT '文件版本'", nullable = false)
   private Integer fileVersion;
   @ApiModelProperty(name = "attachmentId", value = "附件id", notes = "附件id")
   @TableField("attachment_id")
   @Column(name = "attachment_id", columnDefinition = "bigint(20)  COMMENT '附件id'", nullable = false)
   private Long attachmentId;
   @ApiModelProperty(name = "userId", value = "上传用户id", notes = "上传用户id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '上传用户id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'", nullable = true)
   private String remark;
   @ApiModelProperty(name = "uploadTime", value = "上传时间", notes = "上传时间")
   @TableField("upload_time")
   @Column(name = "upload_time", columnDefinition = "datetime(6) COMMENT '上传时间'", nullable = false)
   private LocalDateTime uploadTime;
   @ApiModelProperty(name = "bindQuantity", value = "绑定构件编号数量", notes = "绑定构件编号数量")
   @TableField("bind_quantity")
   @Column(name = "bind_quantity", columnDefinition = "int(11) default '0' COMMENT '绑定构件编号数量'", nullable = false)
   private Integer bindQuantity;

   public static TechArtifactProcessFile.TechArtifactProcessFileBuilder builder() {
      return new TechArtifactProcessFile.TechArtifactProcessFileBuilder();
   }

   public TechArtifactProcessFile() {
   }

   public TechArtifactProcessFile(
      final Long id,
      final Integer processType,
      final Boolean boolSingleProject,
      final Long projectId,
      final String fileName,
      final Integer fileVersion,
      final Long attachmentId,
      final Long userId,
      final String remark,
      final LocalDateTime uploadTime,
      final Integer bindQuantity
   ) {
      this.id = id;
      this.processType = processType;
      this.boolSingleProject = boolSingleProject;
      this.projectId = projectId;
      this.fileName = fileName;
      this.fileVersion = fileVersion;
      this.attachmentId = attachmentId;
      this.userId = userId;
      this.remark = remark;
      this.uploadTime = uploadTime;
      this.bindQuantity = bindQuantity;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getProcessType() {
      return this.processType;
   }

   public Boolean getBoolSingleProject() {
      return this.boolSingleProject;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getFileName() {
      return this.fileName;
   }

   public Integer getFileVersion() {
      return this.fileVersion;
   }

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getRemark() {
      return this.remark;
   }

   public LocalDateTime getUploadTime() {
      return this.uploadTime;
   }

   public Integer getBindQuantity() {
      return this.bindQuantity;
   }

   public TechArtifactProcessFile setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechArtifactProcessFile setProcessType(final Integer processType) {
      this.processType = processType;
      return this;
   }

   public TechArtifactProcessFile setBoolSingleProject(final Boolean boolSingleProject) {
      this.boolSingleProject = boolSingleProject;
      return this;
   }

   public TechArtifactProcessFile setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public TechArtifactProcessFile setFileName(final String fileName) {
      this.fileName = fileName;
      return this;
   }

   public TechArtifactProcessFile setFileVersion(final Integer fileVersion) {
      this.fileVersion = fileVersion;
      return this;
   }

   public TechArtifactProcessFile setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
      return this;
   }

   public TechArtifactProcessFile setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public TechArtifactProcessFile setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public TechArtifactProcessFile setUploadTime(final LocalDateTime uploadTime) {
      this.uploadTime = uploadTime;
      return this;
   }

   public TechArtifactProcessFile setBindQuantity(final Integer bindQuantity) {
      this.bindQuantity = bindQuantity;
      return this;
   }

   @Override
   public String toString() {
      return "TechArtifactProcessFile(id="
         + this.getId()
         + ", processType="
         + this.getProcessType()
         + ", boolSingleProject="
         + this.getBoolSingleProject()
         + ", projectId="
         + this.getProjectId()
         + ", fileName="
         + this.getFileName()
         + ", fileVersion="
         + this.getFileVersion()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", userId="
         + this.getUserId()
         + ", remark="
         + this.getRemark()
         + ", uploadTime="
         + this.getUploadTime()
         + ", bindQuantity="
         + this.getBindQuantity()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactProcessFile)) {
         return false;
      }

      TechArtifactProcessFile other = (TechArtifactProcessFile)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processType = this.getProcessType();
         Object other$processType = other.getProcessType();
         if (this$processType == null ? other$processType == null : this$processType.equals(other$processType)) {
            Object this$boolSingleProject = this.getBoolSingleProject();
            Object other$boolSingleProject = other.getBoolSingleProject();
            if (this$boolSingleProject == null ? other$boolSingleProject == null : this$boolSingleProject.equals(other$boolSingleProject)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$fileVersion = this.getFileVersion();
                  Object other$fileVersion = other.getFileVersion();
                  if (this$fileVersion == null ? other$fileVersion == null : this$fileVersion.equals(other$fileVersion)) {
                     Object this$attachmentId = this.getAttachmentId();
                     Object other$attachmentId = other.getAttachmentId();
                     if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
                        Object this$userId = this.getUserId();
                        Object other$userId = other.getUserId();
                        if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                           Object this$bindQuantity = this.getBindQuantity();
                           Object other$bindQuantity = other.getBindQuantity();
                           if (this$bindQuantity == null ? other$bindQuantity == null : this$bindQuantity.equals(other$bindQuantity)) {
                              Object this$fileName = this.getFileName();
                              Object other$fileName = other.getFileName();
                              if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                    Object this$uploadTime = this.getUploadTime();
                                    Object other$uploadTime = other.getUploadTime();
                                    return this$uploadTime == null ? other$uploadTime == null : this$uploadTime.equals(other$uploadTime);
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
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof TechArtifactProcessFile;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processType = this.getProcessType();
      result = result * 59 + ($processType == null ? 43 : $processType.hashCode());
      Object $boolSingleProject = this.getBoolSingleProject();
      result = result * 59 + ($boolSingleProject == null ? 43 : $boolSingleProject.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $fileVersion = this.getFileVersion();
      result = result * 59 + ($fileVersion == null ? 43 : $fileVersion.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $bindQuantity = this.getBindQuantity();
      result = result * 59 + ($bindQuantity == null ? 43 : $bindQuantity.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $uploadTime = this.getUploadTime();
      return result * 59 + ($uploadTime == null ? 43 : $uploadTime.hashCode());
   }

   public static class TechArtifactProcessFileBuilder {
      private Long id;
      private Integer processType;
      private Boolean boolSingleProject;
      private Long projectId;
      private String fileName;
      private Integer fileVersion;
      private Long attachmentId;
      private Long userId;
      private String remark;
      private LocalDateTime uploadTime;
      private Integer bindQuantity;

      TechArtifactProcessFileBuilder() {
      }

      public TechArtifactProcessFile.TechArtifactProcessFileBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechArtifactProcessFile.TechArtifactProcessFileBuilder processType(final Integer processType) {
         this.processType = processType;
         return this;
      }

      public TechArtifactProcessFile.TechArtifactProcessFileBuilder boolSingleProject(final Boolean boolSingleProject) {
         this.boolSingleProject = boolSingleProject;
         return this;
      }

      public TechArtifactProcessFile.TechArtifactProcessFileBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechArtifactProcessFile.TechArtifactProcessFileBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public TechArtifactProcessFile.TechArtifactProcessFileBuilder fileVersion(final Integer fileVersion) {
         this.fileVersion = fileVersion;
         return this;
      }

      public TechArtifactProcessFile.TechArtifactProcessFileBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public TechArtifactProcessFile.TechArtifactProcessFileBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechArtifactProcessFile.TechArtifactProcessFileBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechArtifactProcessFile.TechArtifactProcessFileBuilder uploadTime(final LocalDateTime uploadTime) {
         this.uploadTime = uploadTime;
         return this;
      }

      public TechArtifactProcessFile.TechArtifactProcessFileBuilder bindQuantity(final Integer bindQuantity) {
         this.bindQuantity = bindQuantity;
         return this;
      }

      public TechArtifactProcessFile build() {
         return new TechArtifactProcessFile(
            this.id,
            this.processType,
            this.boolSingleProject,
            this.projectId,
            this.fileName,
            this.fileVersion,
            this.attachmentId,
            this.userId,
            this.remark,
            this.uploadTime,
            this.bindQuantity
         );
      }

      @Override
      public String toString() {
         return "TechArtifactProcessFile.TechArtifactProcessFileBuilder(id="
            + this.id
            + ", processType="
            + this.processType
            + ", boolSingleProject="
            + this.boolSingleProject
            + ", projectId="
            + this.projectId
            + ", fileName="
            + this.fileName
            + ", fileVersion="
            + this.fileVersion
            + ", attachmentId="
            + this.attachmentId
            + ", userId="
            + this.userId
            + ", remark="
            + this.remark
            + ", uploadTime="
            + this.uploadTime
            + ", bindQuantity="
            + this.bindQuantity
            + ")";
      }
   }
}
