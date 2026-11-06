package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;

@ApiModel(value = "TechArtifactProcessFileRecord对象", description = "工艺文件上传记录表 ")
public class TechArtifactProcessFileRecordDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "processFileId", value = "工艺文件表id", notes = "工艺文件表id")
   private Long processFileId;
   @ApiModelProperty(name = "attachmentDTO", value = "附件", notes = "附件")
   private AttachmentDTO attachmentDTO;
   @ApiModelProperty(name = "fileName", value = "文件名", notes = "文件名")
   private String fileName;
   @ApiModelProperty(name = "uploadTime", value = "上传时间", notes = "上传时间")
   private LocalDateTime uploadTime;
   @ApiModelProperty(name = "fileVersion", value = "文件版本", notes = "文件版本")
   private Integer fileVersion;
   @ApiModelProperty(name = "userId", value = "上传用户id", notes = "上传用户id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "上传用户", notes = "上传用户")
   private String userName;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;

   public static TechArtifactProcessFileRecordDTO.TechArtifactProcessFileRecordDTOBuilder builder() {
      return new TechArtifactProcessFileRecordDTO.TechArtifactProcessFileRecordDTOBuilder();
   }

   public TechArtifactProcessFileRecordDTO() {
   }

   public TechArtifactProcessFileRecordDTO(
      final Long id,
      final Long processFileId,
      final AttachmentDTO attachmentDTO,
      final String fileName,
      final LocalDateTime uploadTime,
      final Integer fileVersion,
      final Long userId,
      final String userName,
      final String remark
   ) {
      this.id = id;
      this.processFileId = processFileId;
      this.attachmentDTO = attachmentDTO;
      this.fileName = fileName;
      this.uploadTime = uploadTime;
      this.fileVersion = fileVersion;
      this.userId = userId;
      this.userName = userName;
      this.remark = remark;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProcessFileId() {
      return this.processFileId;
   }

   public AttachmentDTO getAttachmentDTO() {
      return this.attachmentDTO;
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

   public String getUserName() {
      return this.userName;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProcessFileId(final Long processFileId) {
      this.processFileId = processFileId;
   }

   public void setAttachmentDTO(final AttachmentDTO attachmentDTO) {
      this.attachmentDTO = attachmentDTO;
   }

   public void setFileName(final String fileName) {
      this.fileName = fileName;
   }

   public void setUploadTime(final LocalDateTime uploadTime) {
      this.uploadTime = uploadTime;
   }

   public void setFileVersion(final Integer fileVersion) {
      this.fileVersion = fileVersion;
   }

   public void setUserId(final Long userId) {
      this.userId = userId;
   }

   public void setUserName(final String userName) {
      this.userName = userName;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactProcessFileRecordDTO)) {
         return false;
      }

      TechArtifactProcessFileRecordDTO other = (TechArtifactProcessFileRecordDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$processFileId = this.getProcessFileId();
         Object other$processFileId = other.getProcessFileId();
         if (this$processFileId == null ? other$processFileId == null : this$processFileId.equals(other$processFileId)) {
            Object this$fileVersion = this.getFileVersion();
            Object other$fileVersion = other.getFileVersion();
            if (this$fileVersion == null ? other$fileVersion == null : this$fileVersion.equals(other$fileVersion)) {
               Object this$userId = this.getUserId();
               Object other$userId = other.getUserId();
               if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
                  Object this$attachmentDTO = this.getAttachmentDTO();
                  Object other$attachmentDTO = other.getAttachmentDTO();
                  if (this$attachmentDTO == null ? other$attachmentDTO == null : this$attachmentDTO.equals(other$attachmentDTO)) {
                     Object this$fileName = this.getFileName();
                     Object other$fileName = other.getFileName();
                     if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
                        Object this$uploadTime = this.getUploadTime();
                        Object other$uploadTime = other.getUploadTime();
                        if (this$uploadTime == null ? other$uploadTime == null : this$uploadTime.equals(other$uploadTime)) {
                           Object this$userName = this.getUserName();
                           Object other$userName = other.getUserName();
                           if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TechArtifactProcessFileRecordDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $processFileId = this.getProcessFileId();
      result = result * 59 + ($processFileId == null ? 43 : $processFileId.hashCode());
      Object $fileVersion = this.getFileVersion();
      result = result * 59 + ($fileVersion == null ? 43 : $fileVersion.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $attachmentDTO = this.getAttachmentDTO();
      result = result * 59 + ($attachmentDTO == null ? 43 : $attachmentDTO.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $uploadTime = this.getUploadTime();
      result = result * 59 + ($uploadTime == null ? 43 : $uploadTime.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "TechArtifactProcessFileRecordDTO(id="
         + this.getId()
         + ", processFileId="
         + this.getProcessFileId()
         + ", attachmentDTO="
         + this.getAttachmentDTO()
         + ", fileName="
         + this.getFileName()
         + ", uploadTime="
         + this.getUploadTime()
         + ", fileVersion="
         + this.getFileVersion()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", remark="
         + this.getRemark()
         + ")";
   }

   public static class TechArtifactProcessFileRecordDTOBuilder {
      private Long id;
      private Long processFileId;
      private AttachmentDTO attachmentDTO;
      private String fileName;
      private LocalDateTime uploadTime;
      private Integer fileVersion;
      private Long userId;
      private String userName;
      private String remark;

      TechArtifactProcessFileRecordDTOBuilder() {
      }

      public TechArtifactProcessFileRecordDTO.TechArtifactProcessFileRecordDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechArtifactProcessFileRecordDTO.TechArtifactProcessFileRecordDTOBuilder processFileId(final Long processFileId) {
         this.processFileId = processFileId;
         return this;
      }

      public TechArtifactProcessFileRecordDTO.TechArtifactProcessFileRecordDTOBuilder attachmentDTO(final AttachmentDTO attachmentDTO) {
         this.attachmentDTO = attachmentDTO;
         return this;
      }

      public TechArtifactProcessFileRecordDTO.TechArtifactProcessFileRecordDTOBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public TechArtifactProcessFileRecordDTO.TechArtifactProcessFileRecordDTOBuilder uploadTime(final LocalDateTime uploadTime) {
         this.uploadTime = uploadTime;
         return this;
      }

      public TechArtifactProcessFileRecordDTO.TechArtifactProcessFileRecordDTOBuilder fileVersion(final Integer fileVersion) {
         this.fileVersion = fileVersion;
         return this;
      }

      public TechArtifactProcessFileRecordDTO.TechArtifactProcessFileRecordDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechArtifactProcessFileRecordDTO.TechArtifactProcessFileRecordDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public TechArtifactProcessFileRecordDTO.TechArtifactProcessFileRecordDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechArtifactProcessFileRecordDTO build() {
         return new TechArtifactProcessFileRecordDTO(
            this.id, this.processFileId, this.attachmentDTO, this.fileName, this.uploadTime, this.fileVersion, this.userId, this.userName, this.remark
         );
      }

      @Override
      public String toString() {
         return "TechArtifactProcessFileRecordDTO.TechArtifactProcessFileRecordDTOBuilder(id="
            + this.id
            + ", processFileId="
            + this.processFileId
            + ", attachmentDTO="
            + this.attachmentDTO
            + ", fileName="
            + this.fileName
            + ", uploadTime="
            + this.uploadTime
            + ", fileVersion="
            + this.fileVersion
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", remark="
            + this.remark
            + ")";
      }
   }
}
