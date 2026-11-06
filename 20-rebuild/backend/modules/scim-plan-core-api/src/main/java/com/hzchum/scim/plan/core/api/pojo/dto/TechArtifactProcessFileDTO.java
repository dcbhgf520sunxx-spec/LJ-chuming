package com.hzchum.scim.plan.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.common.core.api.pojo.dto.AttachmentDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDateTime;
import java.util.List;

@ApiModel(value = "TechArtifactProcessFile对象", description = "构件工艺文件表 ")
public class TechArtifactProcessFileDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "processType", value = "工艺类型 1焊接工艺 2装配工艺 4涂装工艺", notes = "工艺类型 1焊接工艺 2装配工艺 4涂装工艺")
   private Integer processType;
   @ApiModelProperty(name = "boolSingleProject", value = "是否项目专用 true专用 false通用", notes = "true专用 false通用")
   private Boolean boolSingleProject;
   @ApiModelProperty(name = "projectId", value = "项目id(专用时必填)", notes = "项目id(专用时必填)")
   private Long projectId;
   @ApiModelProperty(name = "projectList", value = "绑定文件项目列表", notes = "绑定文件项目列表")
   private List<ProjectInfo> projectList;
   @ApiModelProperty(name = "fileName", value = "文件名称", notes = "文件名称")
   private String fileName;
   @ApiModelProperty(name = "fileVersion", value = "文件版本", notes = "文件版本")
   private Integer fileVersion;
   @ApiModelProperty(name = "attachmentId", value = "附件id", notes = "附件id")
   private Long attachmentId;
   @ApiModelProperty(name = "attachmentId", value = "附件", notes = "附件")
   private AttachmentDTO attachmentDTO;
   @ApiModelProperty(name = "userId", value = "上传用户id", notes = "上传用户id")
   private Long userId;
   @ApiModelProperty(name = "userName", value = "上传用户", notes = "上传用户")
   private String userName;
   @ApiModelProperty(name = "remark", value = "备注", notes = "备注")
   private String remark;
   @ApiModelProperty(name = "uploadTime", value = "上传时间", notes = "上传时间")
   private LocalDateTime uploadTime;
   @ApiModelProperty(name = "bindQuantity", value = "绑定构件编号数量", notes = "绑定构件编号数量")
   private Integer bindQuantity;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "processFileRecordDTOList", value = "版本记录列表", notes = "版本记录列表")
   List<TechArtifactProcessFileRecordDTO> processFileRecordDTOList;

   public static TechArtifactProcessFileDTO.TechArtifactProcessFileDTOBuilder builder() {
      return new TechArtifactProcessFileDTO.TechArtifactProcessFileDTOBuilder();
   }

   public TechArtifactProcessFileDTO() {
   }

   public TechArtifactProcessFileDTO(
      final Long id,
      final Integer processType,
      final Boolean boolSingleProject,
      final Long projectId,
      final List<ProjectInfo> projectList,
      final String fileName,
      final Integer fileVersion,
      final Long attachmentId,
      final AttachmentDTO attachmentDTO,
      final Long userId,
      final String userName,
      final String remark,
      final LocalDateTime uploadTime,
      final Integer bindQuantity,
      final List<TechArtifactProcessFileRecordDTO> processFileRecordDTOList
   ) {
      this.id = id;
      this.processType = processType;
      this.boolSingleProject = boolSingleProject;
      this.projectId = projectId;
      this.projectList = projectList;
      this.fileName = fileName;
      this.fileVersion = fileVersion;
      this.attachmentId = attachmentId;
      this.attachmentDTO = attachmentDTO;
      this.userId = userId;
      this.userName = userName;
      this.remark = remark;
      this.uploadTime = uploadTime;
      this.bindQuantity = bindQuantity;
      this.processFileRecordDTOList = processFileRecordDTOList;
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

   public List<ProjectInfo> getProjectList() {
      return this.projectList;
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

   public AttachmentDTO getAttachmentDTO() {
      return this.attachmentDTO;
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

   public LocalDateTime getUploadTime() {
      return this.uploadTime;
   }

   public Integer getBindQuantity() {
      return this.bindQuantity;
   }

   public List<TechArtifactProcessFileRecordDTO> getProcessFileRecordDTOList() {
      return this.processFileRecordDTOList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProcessType(final Integer processType) {
      this.processType = processType;
   }

   public void setBoolSingleProject(final Boolean boolSingleProject) {
      this.boolSingleProject = boolSingleProject;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectList(final List<ProjectInfo> projectList) {
      this.projectList = projectList;
   }

   public void setFileName(final String fileName) {
      this.fileName = fileName;
   }

   public void setFileVersion(final Integer fileVersion) {
      this.fileVersion = fileVersion;
   }

   public void setAttachmentId(final Long attachmentId) {
      this.attachmentId = attachmentId;
   }

   public void setAttachmentDTO(final AttachmentDTO attachmentDTO) {
      this.attachmentDTO = attachmentDTO;
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

   public void setUploadTime(final LocalDateTime uploadTime) {
      this.uploadTime = uploadTime;
   }

   public void setBindQuantity(final Integer bindQuantity) {
      this.bindQuantity = bindQuantity;
   }

   public void setProcessFileRecordDTOList(final List<TechArtifactProcessFileRecordDTO> processFileRecordDTOList) {
      this.processFileRecordDTOList = processFileRecordDTOList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactProcessFileDTO)) {
         return false;
      }

      TechArtifactProcessFileDTO other = (TechArtifactProcessFileDTO)o;
      if (!other.canEqual(this)) {
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
                              Object this$projectList = this.getProjectList();
                              Object other$projectList = other.getProjectList();
                              if (this$projectList == null ? other$projectList == null : this$projectList.equals(other$projectList)) {
                                 Object this$fileName = this.getFileName();
                                 Object other$fileName = other.getFileName();
                                 if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
                                    Object this$attachmentDTO = this.getAttachmentDTO();
                                    Object other$attachmentDTO = other.getAttachmentDTO();
                                    if (this$attachmentDTO == null ? other$attachmentDTO == null : this$attachmentDTO.equals(other$attachmentDTO)) {
                                       Object this$userName = this.getUserName();
                                       Object other$userName = other.getUserName();
                                       if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                                          Object this$remark = this.getRemark();
                                          Object other$remark = other.getRemark();
                                          if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                             Object this$uploadTime = this.getUploadTime();
                                             Object other$uploadTime = other.getUploadTime();
                                             if (this$uploadTime == null ? other$uploadTime == null : this$uploadTime.equals(other$uploadTime)) {
                                                Object this$processFileRecordDTOList = this.getProcessFileRecordDTOList();
                                                Object other$processFileRecordDTOList = other.getProcessFileRecordDTOList();
                                                return this$processFileRecordDTOList == null
                                                   ? other$processFileRecordDTOList == null
                                                   : this$processFileRecordDTOList.equals(other$processFileRecordDTOList);
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
      return other instanceof TechArtifactProcessFileDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
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
      Object $projectList = this.getProjectList();
      result = result * 59 + ($projectList == null ? 43 : $projectList.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $attachmentDTO = this.getAttachmentDTO();
      result = result * 59 + ($attachmentDTO == null ? 43 : $attachmentDTO.hashCode());
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $uploadTime = this.getUploadTime();
      result = result * 59 + ($uploadTime == null ? 43 : $uploadTime.hashCode());
      Object $processFileRecordDTOList = this.getProcessFileRecordDTOList();
      return result * 59 + ($processFileRecordDTOList == null ? 43 : $processFileRecordDTOList.hashCode());
   }

   @Override
   public String toString() {
      return "TechArtifactProcessFileDTO(id="
         + this.getId()
         + ", processType="
         + this.getProcessType()
         + ", boolSingleProject="
         + this.getBoolSingleProject()
         + ", projectId="
         + this.getProjectId()
         + ", projectList="
         + this.getProjectList()
         + ", fileName="
         + this.getFileName()
         + ", fileVersion="
         + this.getFileVersion()
         + ", attachmentId="
         + this.getAttachmentId()
         + ", attachmentDTO="
         + this.getAttachmentDTO()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", remark="
         + this.getRemark()
         + ", uploadTime="
         + this.getUploadTime()
         + ", bindQuantity="
         + this.getBindQuantity()
         + ", processFileRecordDTOList="
         + this.getProcessFileRecordDTOList()
         + ")";
   }

   public static class TechArtifactProcessFileDTOBuilder {
      private Long id;
      private Integer processType;
      private Boolean boolSingleProject;
      private Long projectId;
      private List<ProjectInfo> projectList;
      private String fileName;
      private Integer fileVersion;
      private Long attachmentId;
      private AttachmentDTO attachmentDTO;
      private Long userId;
      private String userName;
      private String remark;
      private LocalDateTime uploadTime;
      private Integer bindQuantity;
      private List<TechArtifactProcessFileRecordDTO> processFileRecordDTOList;

      TechArtifactProcessFileDTOBuilder() {
      }

      public TechArtifactProcessFileDTO.TechArtifactProcessFileDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechArtifactProcessFileDTO.TechArtifactProcessFileDTOBuilder processType(final Integer processType) {
         this.processType = processType;
         return this;
      }

      public TechArtifactProcessFileDTO.TechArtifactProcessFileDTOBuilder boolSingleProject(final Boolean boolSingleProject) {
         this.boolSingleProject = boolSingleProject;
         return this;
      }

      public TechArtifactProcessFileDTO.TechArtifactProcessFileDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechArtifactProcessFileDTO.TechArtifactProcessFileDTOBuilder projectList(final List<ProjectInfo> projectList) {
         this.projectList = projectList;
         return this;
      }

      public TechArtifactProcessFileDTO.TechArtifactProcessFileDTOBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public TechArtifactProcessFileDTO.TechArtifactProcessFileDTOBuilder fileVersion(final Integer fileVersion) {
         this.fileVersion = fileVersion;
         return this;
      }

      public TechArtifactProcessFileDTO.TechArtifactProcessFileDTOBuilder attachmentId(final Long attachmentId) {
         this.attachmentId = attachmentId;
         return this;
      }

      public TechArtifactProcessFileDTO.TechArtifactProcessFileDTOBuilder attachmentDTO(final AttachmentDTO attachmentDTO) {
         this.attachmentDTO = attachmentDTO;
         return this;
      }

      public TechArtifactProcessFileDTO.TechArtifactProcessFileDTOBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public TechArtifactProcessFileDTO.TechArtifactProcessFileDTOBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public TechArtifactProcessFileDTO.TechArtifactProcessFileDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public TechArtifactProcessFileDTO.TechArtifactProcessFileDTOBuilder uploadTime(final LocalDateTime uploadTime) {
         this.uploadTime = uploadTime;
         return this;
      }

      public TechArtifactProcessFileDTO.TechArtifactProcessFileDTOBuilder bindQuantity(final Integer bindQuantity) {
         this.bindQuantity = bindQuantity;
         return this;
      }

      public TechArtifactProcessFileDTO.TechArtifactProcessFileDTOBuilder processFileRecordDTOList(
         final List<TechArtifactProcessFileRecordDTO> processFileRecordDTOList
      ) {
         this.processFileRecordDTOList = processFileRecordDTOList;
         return this;
      }

      public TechArtifactProcessFileDTO build() {
         return new TechArtifactProcessFileDTO(
            this.id,
            this.processType,
            this.boolSingleProject,
            this.projectId,
            this.projectList,
            this.fileName,
            this.fileVersion,
            this.attachmentId,
            this.attachmentDTO,
            this.userId,
            this.userName,
            this.remark,
            this.uploadTime,
            this.bindQuantity,
            this.processFileRecordDTOList
         );
      }

      @Override
      public String toString() {
         return "TechArtifactProcessFileDTO.TechArtifactProcessFileDTOBuilder(id="
            + this.id
            + ", processType="
            + this.processType
            + ", boolSingleProject="
            + this.boolSingleProject
            + ", projectId="
            + this.projectId
            + ", projectList="
            + this.projectList
            + ", fileName="
            + this.fileName
            + ", fileVersion="
            + this.fileVersion
            + ", attachmentId="
            + this.attachmentId
            + ", attachmentDTO="
            + this.attachmentDTO
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", remark="
            + this.remark
            + ", uploadTime="
            + this.uploadTime
            + ", bindQuantity="
            + this.bindQuantity
            + ", processFileRecordDTOList="
            + this.processFileRecordDTOList
            + ")";
      }
   }
}
