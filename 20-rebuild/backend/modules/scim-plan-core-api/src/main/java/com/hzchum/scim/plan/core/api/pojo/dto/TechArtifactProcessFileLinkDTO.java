package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "TechArtifactProcessFileLink对象", description = "构件和工艺文件关联表 ")
public class TechArtifactProcessFileLinkDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   private Long id;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomerId", value = "单体id", notes = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "monomerName", value = "单体名称", notes = "单体名称")
   private String monomerName;
   @ApiModelProperty("构件种类表id")
   private Long structureClassId;
   @ApiModelProperty("构件种类")
   private String structureClassName;
   @ApiModelProperty(name = "name", value = "构件名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "构件编号", notes = "构件编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "构件规格")
   private String specification;
   @ApiModelProperty(name = "material", value = "构件材质")
   private String material;
   @ApiModelProperty(name = "processFileId", value = "工艺文件表id", notes = "工艺文件表id")
   private Long processFileId;
   @ApiModelProperty(name = "processType", value = "工艺类型 1焊接工艺 2装配工艺 4涂装工艺", notes = "工艺类型 1焊接工艺 2装配工艺 4涂装工艺")
   private Integer processType;

   public static TechArtifactProcessFileLinkDTO.TechArtifactProcessFileLinkDTOBuilder builder() {
      return new TechArtifactProcessFileLinkDTO.TechArtifactProcessFileLinkDTOBuilder();
   }

   public TechArtifactProcessFileLinkDTO() {
   }

   public TechArtifactProcessFileLinkDTO(
      final Long id,
      final ProjectInfo project,
      final Long monomerId,
      final String monomerName,
      final Long structureClassId,
      final String structureClassName,
      final String name,
      final String serialNumber,
      final String specification,
      final String material,
      final Long processFileId,
      final Integer processType
   ) {
      this.id = id;
      this.project = project;
      this.monomerId = monomerId;
      this.monomerName = monomerName;
      this.structureClassId = structureClassId;
      this.structureClassName = structureClassName;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.material = material;
      this.processFileId = processFileId;
      this.processType = processType;
   }

   public Long getId() {
      return this.id;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getStructureClassId() {
      return this.structureClassId;
   }

   public String getStructureClassName() {
      return this.structureClassName;
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

   public Long getProcessFileId() {
      return this.processFileId;
   }

   public Integer getProcessType() {
      return this.processType;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setStructureClassId(final Long structureClassId) {
      this.structureClassId = structureClassId;
   }

   public void setStructureClassName(final String structureClassName) {
      this.structureClassName = structureClassName;
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

   public void setProcessFileId(final Long processFileId) {
      this.processFileId = processFileId;
   }

   public void setProcessType(final Integer processType) {
      this.processType = processType;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechArtifactProcessFileLinkDTO)) {
         return false;
      }

      TechArtifactProcessFileLinkDTO other = (TechArtifactProcessFileLinkDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$structureClassId = this.getStructureClassId();
            Object other$structureClassId = other.getStructureClassId();
            if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
               Object this$processFileId = this.getProcessFileId();
               Object other$processFileId = other.getProcessFileId();
               if (this$processFileId == null ? other$processFileId == null : this$processFileId.equals(other$processFileId)) {
                  Object this$processType = this.getProcessType();
                  Object other$processType = other.getProcessType();
                  if (this$processType == null ? other$processType == null : this$processType.equals(other$processType)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$monomerName = this.getMonomerName();
                        Object other$monomerName = other.getMonomerName();
                        if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                           Object this$structureClassName = this.getStructureClassName();
                           Object other$structureClassName = other.getStructureClassName();
                           if (this$structureClassName == null ? other$structureClassName == null : this$structureClassName.equals(other$structureClassName)) {
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
      return other instanceof TechArtifactProcessFileLinkDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $processFileId = this.getProcessFileId();
      result = result * 59 + ($processFileId == null ? 43 : $processFileId.hashCode());
      Object $processType = this.getProcessType();
      result = result * 59 + ($processType == null ? 43 : $processType.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $structureClassName = this.getStructureClassName();
      result = result * 59 + ($structureClassName == null ? 43 : $structureClassName.hashCode());
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
      return "TechArtifactProcessFileLinkDTO(id="
         + this.getId()
         + ", project="
         + this.getProject()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", structureClassName="
         + this.getStructureClassName()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", processFileId="
         + this.getProcessFileId()
         + ", processType="
         + this.getProcessType()
         + ")";
   }

   public static class TechArtifactProcessFileLinkDTOBuilder {
      private Long id;
      private ProjectInfo project;
      private Long monomerId;
      private String monomerName;
      private Long structureClassId;
      private String structureClassName;
      private String name;
      private String serialNumber;
      private String specification;
      private String material;
      private Long processFileId;
      private Integer processType;

      TechArtifactProcessFileLinkDTOBuilder() {
      }

      public TechArtifactProcessFileLinkDTO.TechArtifactProcessFileLinkDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechArtifactProcessFileLinkDTO.TechArtifactProcessFileLinkDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public TechArtifactProcessFileLinkDTO.TechArtifactProcessFileLinkDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechArtifactProcessFileLinkDTO.TechArtifactProcessFileLinkDTOBuilder monomerName(final String monomerName) {
         this.monomerName = monomerName;
         return this;
      }

      public TechArtifactProcessFileLinkDTO.TechArtifactProcessFileLinkDTOBuilder structureClassId(final Long structureClassId) {
         this.structureClassId = structureClassId;
         return this;
      }

      public TechArtifactProcessFileLinkDTO.TechArtifactProcessFileLinkDTOBuilder structureClassName(final String structureClassName) {
         this.structureClassName = structureClassName;
         return this;
      }

      public TechArtifactProcessFileLinkDTO.TechArtifactProcessFileLinkDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechArtifactProcessFileLinkDTO.TechArtifactProcessFileLinkDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechArtifactProcessFileLinkDTO.TechArtifactProcessFileLinkDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechArtifactProcessFileLinkDTO.TechArtifactProcessFileLinkDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechArtifactProcessFileLinkDTO.TechArtifactProcessFileLinkDTOBuilder processFileId(final Long processFileId) {
         this.processFileId = processFileId;
         return this;
      }

      public TechArtifactProcessFileLinkDTO.TechArtifactProcessFileLinkDTOBuilder processType(final Integer processType) {
         this.processType = processType;
         return this;
      }

      public TechArtifactProcessFileLinkDTO build() {
         return new TechArtifactProcessFileLinkDTO(
            this.id,
            this.project,
            this.monomerId,
            this.monomerName,
            this.structureClassId,
            this.structureClassName,
            this.name,
            this.serialNumber,
            this.specification,
            this.material,
            this.processFileId,
            this.processType
         );
      }

      @Override
      public String toString() {
         return "TechArtifactProcessFileLinkDTO.TechArtifactProcessFileLinkDTOBuilder(id="
            + this.id
            + ", project="
            + this.project
            + ", monomerId="
            + this.monomerId
            + ", monomerName="
            + this.monomerName
            + ", structureClassId="
            + this.structureClassId
            + ", structureClassName="
            + this.structureClassName
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", material="
            + this.material
            + ", processFileId="
            + this.processFileId
            + ", processType="
            + this.processType
            + ")";
      }
   }
}
