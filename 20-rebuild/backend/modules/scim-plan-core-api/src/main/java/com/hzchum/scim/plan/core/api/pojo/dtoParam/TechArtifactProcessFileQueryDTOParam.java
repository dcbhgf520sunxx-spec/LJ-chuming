package com.hzchum.scim.plan.core.api.pojo.dtoParam;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("TechArtifactProcessFile查询对象")
public class TechArtifactProcessFileQueryDTOParam {
   @ApiModelProperty(name = "processType", value = "工艺类型 1焊接工艺 2装配工艺 4涂装工艺", notes = "工艺类型 1焊接工艺 2装配工艺 4涂装工艺")
   private Integer processType;
   @ApiModelProperty(name = "boolSingleProject", value = "是否项目专用 true专用 false通用", notes = "true专用 false通用")
   private Boolean boolSingleProject;
   @ApiModelProperty(name = "projectId", value = "项目id 专用时必填", notes = "项目id 专用时必填")
   private Long projectId;
   @ApiModelProperty(name = "fileName", value = "文件名称", notes = "文件名称")
   private String fileName;
   @ApiModelProperty("构件种类表id")
   private Long structureClassId;
   @ApiModelProperty(name = "name", value = "构件名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "构件编号", notes = "构件编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "构件规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;

   public static TechArtifactProcessFileQueryDTOParam.TechArtifactProcessFileQueryDTOParamBuilder builder() {
      return new TechArtifactProcessFileQueryDTOParam.TechArtifactProcessFileQueryDTOParamBuilder();
   }

   public TechArtifactProcessFileQueryDTOParam() {
   }

   public TechArtifactProcessFileQueryDTOParam(
      final Integer processType,
      final Boolean boolSingleProject,
      final Long projectId,
      final String fileName,
      final Long structureClassId,
      final String name,
      final String serialNumber,
      final String specification,
      final String material
   ) {
      this.processType = processType;
      this.boolSingleProject = boolSingleProject;
      this.projectId = projectId;
      this.fileName = fileName;
      this.structureClassId = structureClassId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
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

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
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

   public void setFileName(final String fileName) {
      this.fileName = fileName;
   }

   public void setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactProcessFileQueryDTOParam)) {
         return false;
      }

      TechArtifactProcessFileQueryDTOParam other = (TechArtifactProcessFileQueryDTOParam)o;
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
               Object this$structureClassId = this.getStructureClassId();
               Object other$structureClassId = other.getStructureClassId();
               if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
                  Object this$fileName = this.getFileName();
                  Object other$fileName = other.getFileName();
                  if (this$fileName == null ? other$fileName == null : this$fileName.equals(other$fileName)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$specification = this.getSpecification();
                           Object other$specification = other.getSpecification();
                           if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                              Object this$material = this.getMaterial();
                              Object other$material = other.getMaterial();
                              return this$material == null ? other$material == null : this$material.equals(other$material);
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
      return other instanceof TechArtifactProcessFileQueryDTOParam;
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
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $fileName = this.getFileName();
      result = result * 59 + ($fileName == null ? 43 : $fileName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   @Override
   public String toString() {
      return "TechArtifactProcessFileQueryDTOParam(processType="
         + this.getProcessType()
         + ", boolSingleProject="
         + this.getBoolSingleProject()
         + ", projectId="
         + this.getProjectId()
         + ", fileName="
         + this.getFileName()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ")";
   }

   public static class TechArtifactProcessFileQueryDTOParamBuilder {
      private Integer processType;
      private Boolean boolSingleProject;
      private Long projectId;
      private String fileName;
      private Long structureClassId;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;

      TechArtifactProcessFileQueryDTOParamBuilder() {
      }

      public TechArtifactProcessFileQueryDTOParam.TechArtifactProcessFileQueryDTOParamBuilder processType(final Integer processType) {
         this.processType = processType;
         return this;
      }

      public TechArtifactProcessFileQueryDTOParam.TechArtifactProcessFileQueryDTOParamBuilder boolSingleProject(final Boolean boolSingleProject) {
         this.boolSingleProject = boolSingleProject;
         return this;
      }

      public TechArtifactProcessFileQueryDTOParam.TechArtifactProcessFileQueryDTOParamBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechArtifactProcessFileQueryDTOParam.TechArtifactProcessFileQueryDTOParamBuilder fileName(final String fileName) {
         this.fileName = fileName;
         return this;
      }

      public TechArtifactProcessFileQueryDTOParam.TechArtifactProcessFileQueryDTOParamBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      public TechArtifactProcessFileQueryDTOParam.TechArtifactProcessFileQueryDTOParamBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechArtifactProcessFileQueryDTOParam.TechArtifactProcessFileQueryDTOParamBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechArtifactProcessFileQueryDTOParam.TechArtifactProcessFileQueryDTOParamBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechArtifactProcessFileQueryDTOParam.TechArtifactProcessFileQueryDTOParamBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechArtifactProcessFileQueryDTOParam build() {
         return new TechArtifactProcessFileQueryDTOParam(
            this.processType,
            this.boolSingleProject,
            this.projectId,
            this.fileName,
            this.structureClassId,
            this.name,
            this.serialNumber,
            this.specification,
            this.material
         );
      }

      @Override
      public String toString() {
         return "TechArtifactProcessFileQueryDTOParam.TechArtifactProcessFileQueryDTOParamBuilder(processType="
            + this.processType
            + ", boolSingleProject="
            + this.boolSingleProject
            + ", projectId="
            + this.projectId
            + ", fileName="
            + this.fileName
            + ", structureClassId="
            + this.structureClassId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ")";
      }
   }
}
