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

@ApiModel(value = "TechArtifactProcessFileRecord对象", description = "工艺文件上传记录表 ")
@Entity
@TableName("tech_artifact_process_file_record")
@Table(name = "tech_artifact_process_file_record")
@org.hibernate.annotations.Table(appliesTo = "tech_artifact_process_file_record", comment = "工艺文件上传记录表 ")
public class TechArtifactProcessFileRecord extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "processFileId", value = "工艺文件表id", notes = "工艺文件表id")
   @TableField("process_file_id")
   @Column(name = "process_file_id", columnDefinition = "bigint(20)  COMMENT '工艺文件表id'", nullable = false)
   private Long processFileId;
   @ApiModelProperty(name = "attachmentId", value = "附件id", notes = "附件id")
   @TableField("attachment_id")
   @Column(name = "attachment_id", columnDefinition = "bigint(20)  COMMENT '附件id'", nullable = false)
   private Long attachmentId;
   @ApiModelProperty(name = "fileName", value = "文件名", notes = "文件名")
   @TableField("file_name")
   @Column(name = "file_name", columnDefinition = "varchar(255)  COMMENT '文件名'", nullable = false)
   private String fileName;
   @ApiModelProperty(name = "uploadTime", value = "上传时间", notes = "上传时间")
   @TableField("upload_time")
   @Column(name = "upload_time", columnDefinition = "datetime(6)  COMMENT '上传时间'", nullable = false)
   private LocalDateTime uploadTime;
   @ApiModelProperty(name = "fileVersion", value = "文件版本", notes = "文件版本")
   @TableField("file_version")
   @Column(name = "file_version", columnDefinition = "int(11) DEFAULT '1' COMMENT '文件版本'", nullable = false)
   private Integer fileVersion;
   @ApiModelProperty(name = "userId", value = "上传用户id", notes = "上传用户id")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '上传用户id'", nullable = false)
   private Long userId;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   @TableField("remark")
   @Column(name = "remark", columnDefinition = "varchar(255)  COMMENT '备注'")
   private String remark;

   public static TechArtifactProcessFileRecord.TechArtifactProcessFileRecordBuilder builder() {
      return new TechArtifactProcessFileRecord.TechArtifactProcessFileRecordBuilder();
   }

   public TechArtifactProcessFileRecord() {
   }

   public TechArtifactProcessFileRecord(
      final Long id,
      final Long processFileId,
      final Long attachmentId,
      final String fileName,
      final LocalDateTime uploadTime,
      final Integer fileVersion,
      final Long userId,
      final String remark
   ) {
      this.id = id;
      this.processFileId = processFileId;
      this.attachmentId = attachmentId;
      this.fileName = fileName;
      this.uploadTime = uploadTime;
      this.fileVersion = fileVersion;
      this.userId = userId;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessFileId() {
      return this.processFileId;
   }

   public Long getAttachmentId() {
      return this.attachmentId;
   }

   public String getFileName() {
      return this.fileName;
   }

   public LocalDateTime getUploadTime() {
      return this.uploadTime;
   }

   public Integer getFileVersion() {
      return this.fileVersion;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getRemark() {
      return this.remark;
   }

   public TechArtifactProcessFileRecord setId(final Long id) {
      this.id = id;
      return this;
   }

   public TechArtifactProcessFileRecord setProcessFileId(final Long processFileId) {
      this.processFileId = processFileId;
      return this;
   }

   public TechArtifactProcessFileRecord setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
      return this;
   }

   public TechArtifactProcessFileRecord setFileName(final String fileName) {
      this.fileName = fileName;
      return this;
   }

   public TechArtifactProcessFileRecord setUploadTime(final LocalDateTime uploadTime) {
      this.uploadTime = uploadTime;
      return this;
   }

   public TechArtifactProcessFileRecord setFileVersion(final Integer fileVersion) {
      this.fileVersion = fileVersion;
      return this;
   }

   public TechArtifactProcessFileRecord setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public TechArtifactProcessFileRecord setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   @Override
   public String toString() {
      return "TechArtifactProcessFileRecord(id="
         + this.getId()
         + ", processFileId="
         + this.getProcessFileId()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", fileName="
         + this.getFileName()
         + ", uploadTime="
         + this.getUploadTime()
         + ", fileVersion="
         + this.getFileVersion()
         + ", userId="
         + this.getUserId()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactProcessFileRecord)) {
         return false;
      }

      TechArtifactProcessFileRecord other = (TechArtifactProcessFileRecord)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processFileId = this.getProcessFileId();
         Object other$processFileId = other.getProcessFileId();
         if (this$processFileId == null ? other$processFileId == null : this$processFileId.equals(other$processFileId)) {
            Object this$attachmentId = this.getAttachmentId();
            Object other$attachmentId = other.getAttachmentId();
            if (this$attachmentId == null ? other$attachmentId == null : this$attachmentId.equals(other$attachmentId)) {
               Object this$fileVersion = this.getFileVersion();
               Object other$fileVersion = other.getFileVersion();
               if (this$fileVersion == null ? other$fileVersion == null : this$fileVersion.equals(other$fileVersion)) {
                  Object this$userId = this.getUserId();
                  Object other$userId = other.getUserId();
                  if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                     Object this$fileName = this.getFileName();
                     Object other$fileName = other.getFileName();
                     if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
                        Object this$uploadTime = this.getUploadTime();
                        Object other$uploadTime = other.getUploadTime();
                        if (this$uploadTime == null ? other$uploadTime == null : this$uploadTime.equals(other$uploadTime)) {
                           Object this$remark = this.getRemark();
                           Object other$remark = other.getRemark();
                           return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof TechArtifactProcessFileRecord;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processFileId = this.getProcessFileId();
      result = result * 59 + ($processFileId == null ? 43 : $processFileId.hashCode());
      Object $attachmentId = this.getAttachmentId();
      result = result * 59 + ($attachmentId == null ? 43 : $attachmentId.hashCode());
      Object $fileVersion = this.getFileVersion();
      result = result * 59 + ($fileVersion == null ? 43 : $fileVersion.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $uploadTime = this.getUploadTime();
      result = result * 59 + ($uploadTime == null ? 43 : $uploadTime.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   public static class TechArtifactProcessFileRecordBuilder {
      private Long id;
      private Long processFileId;
      private Long attachmentId;
      private String fileName;
      private LocalDateTime uploadTime;
      private Integer fileVersion;
      private Long userId;
      private String remark;

      TechArtifactProcessFileRecordBuilder() {
      }

      public TechArtifactProcessFileRecord.TechArtifactProcessFileRecordBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechArtifactProcessFileRecord.TechArtifactProcessFileRecordBuilder processFileId(final Long processFileId) {
         this.processFileId = processFileId;
         return this;
      }

      public TechArtifactProcessFileRecord.TechArtifactProcessFileRecordBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public TechArtifactProcessFileRecord.TechArtifactProcessFileRecordBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public TechArtifactProcessFileRecord.TechArtifactProcessFileRecordBuilder uploadTime(final LocalDateTime uploadTime) {
         this.uploadTime = uploadTime;
         return this;
      }

      public TechArtifactProcessFileRecord.TechArtifactProcessFileRecordBuilder fileVersion(final Integer fileVersion) {
         this.fileVersion = fileVersion;
         return this;
      }

      public TechArtifactProcessFileRecord.TechArtifactProcessFileRecordBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechArtifactProcessFileRecord.TechArtifactProcessFileRecordBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechArtifactProcessFileRecord build() {
         return new TechArtifactProcessFileRecord(
            this.id, this.processFileId, this.attachmentId, this.fileName, this.uploadTime, this.fileVersion, this.userId, this.remark
         );
      }

      @Override
      public String toString() {
         return "TechArtifactProcessFileRecord.TechArtifactProcessFileRecordBuilder(id="
            + this.id
            + ", processFileId="
            + this.processFileId
            + ", attachmentId="
            + this.attachmentId
            + ", fileName="
            + this.fileName
            + ", uploadTime="
            + this.uploadTime
            + ", fileVersion="
            + this.fileVersion
            + ", userId="
            + this.userId
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
