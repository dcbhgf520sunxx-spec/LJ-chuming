package com.hzchum.scim.plan.core.api.pojo.dto.production_scheduling;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "清单排期-车间排期明细DTO")
public class ListSchedulingWorkshopSchedulingDetailDTO {
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("单体ID")
   private Long monomerId;
   @ApiModelProperty("单体名称")
   private String monomerName;
   @ApiModelProperty("区域ID")
   private Long areaId;
   @ApiModelProperty("区域名称")
   private String areaName;
   @ApiModelProperty("构件ID")
   private Long artifactId;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("长度(mm)")
   private BigDecimal length;
   @ApiModelProperty("材质")
   private String material;
   @ApiModelProperty("任务量")
   private Integer taskVolume;
   @ApiModelProperty("是否排期 false未排期 true已排期")
   private Boolean boolScheduling;

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public String getMonomerName() {
      return this.monomerName;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getAreaName() {
      return this.areaName;
   }

   public Long getArtifactId() {
      return this.artifactId;
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

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getTaskVolume() {
      return this.taskVolume;
   }

   public Boolean getBoolScheduling() {
      return this.boolScheduling;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomerName(final String monomerName) {
      this.monomerName = monomerName;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setAreaName(final String areaName) {
      this.areaName = areaName;
   }

   public void setArtifactId(final Long artifactId) {
      this.artifactId = artifactId;
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

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setTaskVolume(final Integer taskVolume) {
      this.taskVolume = taskVolume;
   }

   public void setBoolScheduling(final Boolean boolScheduling) {
      this.boolScheduling = boolScheduling;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ListSchedulingWorkshopSchedulingDetailDTO)) {
         return false;
      }

      ListSchedulingWorkshopSchedulingDetailDTO other = (ListSchedulingWorkshopSchedulingDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$monomerId = this.getMonomerId();
         Object other$monomerId = other.getMonomerId();
         if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
            Object this$areaId = this.getAreaId();
            Object other$areaId = other.getAreaId();
            if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
               Object this$artifactId = this.getArtifactId();
               Object other$artifactId = other.getArtifactId();
               if (this$artifactId == null ? other$artifactId == null : this$artifactId.equals(other$artifactId)) {
                  Object this$taskVolume = this.getTaskVolume();
                  Object other$taskVolume = other.getTaskVolume();
                  if (this$taskVolume == null ? other$taskVolume == null : this$taskVolume.equals(other$taskVolume)) {
                     Object this$boolScheduling = this.getBoolScheduling();
                     Object other$boolScheduling = other.getBoolScheduling();
                     if (this$boolScheduling == null ? other$boolScheduling == null : this$boolScheduling.equals(other$boolScheduling)) {
                        Object this$projectName = this.getProjectName();
                        Object other$projectName = other.getProjectName();
                        if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                           Object this$monomerName = this.getMonomerName();
                           Object other$monomerName = other.getMonomerName();
                           if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                              Object this$areaName = this.getAreaName();
                              Object other$areaName = other.getAreaName();
                              if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$specification = this.getSpecification();
                                       Object other$specification = other.getSpecification();
                                       if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                          Object this$length = this.getLength();
                                          Object other$length = other.getLength();
                                          if (this$length == null ? other$length == null : this$length.equals(other$length)) {
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ListSchedulingWorkshopSchedulingDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $artifactId = this.getArtifactId();
      result = result * 59 + ($artifactId == null ? 43 : $artifactId.hashCode());
      Object $taskVolume = this.getTaskVolume();
      result = result * 59 + ($taskVolume == null ? 43 : $taskVolume.hashCode());
      Object $boolScheduling = this.getBoolScheduling();
      result = result * 59 + ($boolScheduling == null ? 43 : $boolScheduling.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      return result * 59 + ($material == null ? 43 : $material.hashCode());
   }

   @Override
   public String toString() {
      return "ListSchedulingWorkshopSchedulingDetailDTO(projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", artifactId="
         + this.getArtifactId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", taskVolume="
         + this.getTaskVolume()
         + ", boolScheduling="
         + this.getBoolScheduling()
         + ")";
   }
}
