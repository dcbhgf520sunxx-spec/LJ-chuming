package com.hzchum.scim.project.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ProjectAuxiliaryMaterialClass对象dto", description = "配套件分类配置表 ")
public class ProjectAuxiliaryMaterialClassDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "classifyId", value = "配套件科目ID", notes = "配套件科目ID")
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "科目名称", notes = "科目名称")
   private String classifyName;
   @ApiModelProperty(name = "boolNoReport", value = "是否即入即安 1是 0否", notes = "是否即入即安 1是 0否")
   private Boolean boolNoReport;

   public static ProjectAuxiliaryMaterialClassDTO.ProjectAuxiliaryMaterialClassDTOBuilder builder() {
      return new ProjectAuxiliaryMaterialClassDTO.ProjectAuxiliaryMaterialClassDTOBuilder();
   }

   public ProjectAuxiliaryMaterialClassDTO() {
   }

   public ProjectAuxiliaryMaterialClassDTO(final Long id, final Long projectId, final Long classifyId, final String classifyName, final Boolean boolNoReport) {
      this.id = id;
      this.projectId = projectId;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.boolNoReport = boolNoReport;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public Boolean getBoolNoReport() {
      return this.boolNoReport;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setBoolNoReport(final Boolean boolNoReport) {
      this.boolNoReport = boolNoReport;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectAuxiliaryMaterialClassDTO)) {
         return false;
      }

      ProjectAuxiliaryMaterialClassDTO other = (ProjectAuxiliaryMaterialClassDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$boolNoReport = this.getBoolNoReport();
               Object other$boolNoReport = other.getBoolNoReport();
               if (this$boolNoReport == null ? other$boolNoReport == null : this$boolNoReport.equals(other$boolNoReport)) {
                  Object this$classifyName = this.getClassifyName();
                  Object other$classifyName = other.getClassifyName();
                  return this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName);
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
      return other instanceof ProjectAuxiliaryMaterialClassDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $boolNoReport = this.getBoolNoReport();
      result = result * 59 + ($boolNoReport == null ? 43 : $boolNoReport.hashCode());
      Object $classifyName = this.getClassifyName();
      return result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectAuxiliaryMaterialClassDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", boolNoReport="
         + this.getBoolNoReport()
         + ")";
   }

   public static class ProjectAuxiliaryMaterialClassDTOBuilder {
      private Long id;
      private Long projectId;
      private Long classifyId;
      private String classifyName;
      private Boolean boolNoReport;

      ProjectAuxiliaryMaterialClassDTOBuilder() {
      }

      public ProjectAuxiliaryMaterialClassDTO.ProjectAuxiliaryMaterialClassDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectAuxiliaryMaterialClassDTO.ProjectAuxiliaryMaterialClassDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectAuxiliaryMaterialClassDTO.ProjectAuxiliaryMaterialClassDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public ProjectAuxiliaryMaterialClassDTO.ProjectAuxiliaryMaterialClassDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public ProjectAuxiliaryMaterialClassDTO.ProjectAuxiliaryMaterialClassDTOBuilder boolNoReport(final Boolean boolNoReport) {
         this.boolNoReport = boolNoReport;
         return this;
      }

      public ProjectAuxiliaryMaterialClassDTO build() {
         return new ProjectAuxiliaryMaterialClassDTO(this.id, this.projectId, this.classifyId, this.classifyName, this.boolNoReport);
      }

      @Override
      public String toString() {
         return "ProjectAuxiliaryMaterialClassDTO.ProjectAuxiliaryMaterialClassDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", boolNoReport="
            + this.boolNoReport
            + ")";
      }
   }
}
