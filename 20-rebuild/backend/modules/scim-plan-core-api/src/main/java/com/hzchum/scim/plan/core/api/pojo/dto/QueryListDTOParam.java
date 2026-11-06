package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("构件清单查询 参数类")
public class QueryListDTOParam {
   @ApiModelProperty(name = "projectId", value = "项目id")
   @NotNull(message = "项目id不能为空")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "artifactName", value = "构件名称")
   private String artifactName;
   @ApiModelProperty(name = "artifactSerialNumber", value = "构件编号")
   private String artifactSerialNumber;
   @ApiModelProperty(name = "machinePartSerialNumber", value = "零件编号")
   private String machinePartSerialNumber;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public String getArtifactName() {
      return this.artifactName;
   }

   public String getArtifactSerialNumber() {
      return this.artifactSerialNumber;
   }

   public String getMachinePartSerialNumber() {
      return this.machinePartSerialNumber;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setArtifactName(final String artifactName) {
      this.artifactName = artifactName;
   }

   public void setArtifactSerialNumber(final String artifactSerialNumber) {
      this.artifactSerialNumber = artifactSerialNumber;
   }

   public void setMachinePartSerialNumber(final String machinePartSerialNumber) {
      this.machinePartSerialNumber = machinePartSerialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof QueryListDTOParam)) {
         return false;
      }

      QueryListDTOParam other = (QueryListDTOParam)o;
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
               Object this$artifactName = this.getArtifactName();
               Object other$artifactName = other.getArtifactName();
               if (this$artifactName == null ? other$artifactName == null : this$artifactName.equals(other$artifactName)) {
                  Object this$artifactSerialNumber = this.getArtifactSerialNumber();
                  Object other$artifactSerialNumber = other.getArtifactSerialNumber();
                  if (this$artifactSerialNumber == null ? other$artifactSerialNumber == null : this$artifactSerialNumber.equals(other$artifactSerialNumber)) {
                     Object this$machinePartSerialNumber = this.getMachinePartSerialNumber();
                     Object other$machinePartSerialNumber = other.getMachinePartSerialNumber();
                     return this$machinePartSerialNumber == null
                        ? other$machinePartSerialNumber == null
                        : this$machinePartSerialNumber.equals(other$machinePartSerialNumber);
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
      return other instanceof QueryListDTOParam;
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
      Object $artifactName = this.getArtifactName();
      result = result * 59 + ($artifactName == null ? 43 : $artifactName.hashCode());
      Object $artifactSerialNumber = this.getArtifactSerialNumber();
      result = result * 59 + ($artifactSerialNumber == null ? 43 : $artifactSerialNumber.hashCode());
      Object $machinePartSerialNumber = this.getMachinePartSerialNumber();
      return result * 59 + ($machinePartSerialNumber == null ? 43 : $machinePartSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "QueryListDTOParam(projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", artifactName="
         + this.getArtifactName()
         + ", artifactSerialNumber="
         + this.getArtifactSerialNumber()
         + ", machinePartSerialNumber="
         + this.getMachinePartSerialNumber()
         + ")";
   }
}
