package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.plan.core.api.enums.ArtifactProcessTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@ApiModel(value = "TechArtifactProcessFile对象", description = "构件工艺文件表 ")
public class TechArtifactProcessFileSaveDTOParam {
   @ApiModelProperty(name = "processType", value = "工艺类型 1焊接工艺 2装配工艺 4涂装工艺", notes = "工艺类型 1焊接工艺 2装配工艺 4涂装工艺")
   @NotNull(message = "工艺类型不能为空")
   @EnumValidator(value = ArtifactProcessTypeEnum.class, message = "工艺类型错误!")
   private Integer processType;
   @ApiModelProperty(name = "boolSingleProject", value = "是否项目专用 true专用 false通用", notes = "true专用 false通用")
   @NotNull(message = "请填写该文件是否项目专用!")
   private Boolean boolSingleProject;
   @ApiModelProperty(name = "projectId", value = "项目id 专用时必填", notes = "项目id 专用时必填")
   private Long projectId;
   @Valid
   @ApiModelProperty(name = "attachmentId", value = "附件id", notes = "附件id")
   @NotEmpty(message = "上传工艺文件不能为空!")
   private List<ProcessFileAttachmentDTOParam> fileList;

   public static TechArtifactProcessFileSaveDTOParam.TechArtifactProcessFileSaveDTOParamBuilder builder() {
      return new TechArtifactProcessFileSaveDTOParam.TechArtifactProcessFileSaveDTOParamBuilder();
   }

   public TechArtifactProcessFileSaveDTOParam() {
   }

   public TechArtifactProcessFileSaveDTOParam(
      final Integer processType, final Boolean boolSingleProject, final Long projectId, final List<ProcessFileAttachmentDTOParam> fileList
   ) {
      this.processType = processType;
      this.boolSingleProject = boolSingleProject;
      this.projectId = projectId;
      this.fileList = fileList;
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

   public List<ProcessFileAttachmentDTOParam> getFileList() {
      return this.fileList;
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

   public void setFileList(final List<ProcessFileAttachmentDTOParam> fileList) {
      this.fileList = fileList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactProcessFileSaveDTOParam)) {
         return false;
      }

      TechArtifactProcessFileSaveDTOParam other = (TechArtifactProcessFileSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$processType = this.getProcessType();
      Object other$processType = other.getProcessType();
      if (this$processType == null ? other$processType == null : this$processType.equals(other$processType)) {
         Object this$boolSingleProject = this.getBoolSingleProject();
         Object other$boolSingleProject = other.getBoolSingleProject();
         if (this$boolSingleProject == null ? other$boolSingleProject == null : this$boolSingleProject.equals(other$boolSingleProject)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$fileList = this.getFileList();
               Object other$fileList = other.getFileList();
               return this$fileList == null ? other$fileList == null : this$fileList.equals(other$fileList);
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
      return other instanceof TechArtifactProcessFileSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $processType = this.getProcessType();
      result = result * 59 + ($processType == null ? 43 : $processType.hashCode());
      Object $boolSingleProject = this.getBoolSingleProject();
      result = result * 59 + ($boolSingleProject == null ? 43 : $boolSingleProject.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $fileList = this.getFileList();
      return result * 59 + ($fileList == null ? 43 : $fileList.hashCode());
   }

   @Override
   public String toString() {
      return "TechArtifactProcessFileSaveDTOParam(processType="
         + this.getProcessType()
         + ", boolSingleProject="
         + this.getBoolSingleProject()
         + ", projectId="
         + this.getProjectId()
         + ", fileList="
         + this.getFileList()
         + ")";
   }

   public static class TechArtifactProcessFileSaveDTOParamBuilder {
      private Integer processType;
      private Boolean boolSingleProject;
      private Long projectId;
      private List<ProcessFileAttachmentDTOParam> fileList;

      TechArtifactProcessFileSaveDTOParamBuilder() {
      }

      public TechArtifactProcessFileSaveDTOParam.TechArtifactProcessFileSaveDTOParamBuilder processType(final Integer processType) {
         this.processType = processType;
         return this;
      }

      public TechArtifactProcessFileSaveDTOParam.TechArtifactProcessFileSaveDTOParamBuilder boolSingleProject(final Boolean boolSingleProject) {
         this.boolSingleProject = boolSingleProject;
         return this;
      }

      public TechArtifactProcessFileSaveDTOParam.TechArtifactProcessFileSaveDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechArtifactProcessFileSaveDTOParam.TechArtifactProcessFileSaveDTOParamBuilder fileList(final List<ProcessFileAttachmentDTOParam> fileList) {
         this.fileList = fileList;
         return this;
      }

      public TechArtifactProcessFileSaveDTOParam build() {
         return new TechArtifactProcessFileSaveDTOParam(this.processType, this.boolSingleProject, this.projectId, this.fileList);
      }

      @Override
      public String toString() {
         return "TechArtifactProcessFileSaveDTOParam.TechArtifactProcessFileSaveDTOParamBuilder(processType="
            + this.processType
            + ", boolSingleProject="
            + this.boolSingleProject
            + ", projectId="
            + this.projectId
            + ", fileList="
            + this.fileList
            + ")";
      }
   }
}
