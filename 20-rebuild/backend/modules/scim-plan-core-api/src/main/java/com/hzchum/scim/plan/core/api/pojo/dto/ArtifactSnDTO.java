package com.hzchum.scim.plan.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;

public class ArtifactSnDTO {
   @ApiModelProperty("项目")
   private ProjectInfo project;
   @ApiModelProperty("单体id")
   private Long monomerId;
   @ApiModelProperty("单体名称")
   private String monomerName;
   @ApiModelProperty("构件种类id")
   private Long structureClassId;
   @ApiModelProperty("构件种类")
   private String structureClassName;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("材质")
   private String material;
   @ApiModelProperty("绑定状态 未绑定")
   private Integer bindStatus;
   private TechArtifactProcessFileDTO processFileDTO;

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

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getName() {
      return this.name;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getBindStatus() {
      return this.bindStatus;
   }

   public TechArtifactProcessFileDTO getProcessFileDTO() {
      return this.processFileDTO;
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

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setBindStatus(final Integer bindStatus) {
      this.bindStatus = bindStatus;
   }

   public void setProcessFileDTO(final TechArtifactProcessFileDTO processFileDTO) {
      this.processFileDTO = processFileDTO;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactSnDTO)) {
         return false;
      }

      ArtifactSnDTO other = (ArtifactSnDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$monomerId = this.getMonomerId();
      Object other$monomerId = other.getMonomerId();
      if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
         Object this$structureClassId = this.getStructureClassId();
         Object other$structureClassId = other.getStructureClassId();
         if (this$structureClassId == null ? other$structureClassId == null : this$structureClassId.equals(other$structureClassId)) {
            Object this$bindStatus = this.getBindStatus();
            Object other$bindStatus = other.getBindStatus();
            if (this$bindStatus == null ? other$bindStatus == null : this$bindStatus.equals(other$bindStatus)) {
               Object this$project = this.getProject();
               Object other$project = other.getProject();
               if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                  Object this$monomerName = this.getMonomerName();
                  Object other$monomerName = other.getMonomerName();
                  if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                     Object this$structureClassName = this.getStructureClassName();
                     Object other$structureClassName = other.getStructureClassName();
                     if (this$structureClassName == null ? other$structureClassName == null : this$structureClassName.equals(other$structureClassName)) {
                        Object this$serialNumber = this.getSerialNumber();
                        Object other$serialNumber = other.getSerialNumber();
                        if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$specification = this.getSpecification();
                              Object other$specification = other.getSpecification();
                              if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                 Object this$material = this.getMaterial();
                                 Object other$material = other.getMaterial();
                                 if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                    Object this$processFileDTO = this.getProcessFileDTO();
                                    Object other$processFileDTO = other.getProcessFileDTO();
                                    return this$processFileDTO == null ? other$processFileDTO == null : this$processFileDTO.equals(other$processFileDTO);
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
      return other instanceof ArtifactSnDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $structureClassId = this.getStructureClassId();
      result = result * 59 + ($structureClassId == null ? 43 : $structureClassId.hashCode());
      Object $bindStatus = this.getBindStatus();
      result = result * 59 + ($bindStatus == null ? 43 : $bindStatus.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $structureClassName = this.getStructureClassName();
      result = result * 59 + ($structureClassName == null ? 43 : $structureClassName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $processFileDTO = this.getProcessFileDTO();
      return result * 59 + ($processFileDTO == null ? 43 : $processFileDTO.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactSnDTO(project="
         + this.getProject()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", structureClassId="
         + this.getStructureClassId()
         + ", structureClassName="
         + this.getStructureClassName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", name="
         + this.getName()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", bindStatus="
         + this.getBindStatus()
         + ", processFileDTO="
         + this.getProcessFileDTO()
         + ")";
   }
}
