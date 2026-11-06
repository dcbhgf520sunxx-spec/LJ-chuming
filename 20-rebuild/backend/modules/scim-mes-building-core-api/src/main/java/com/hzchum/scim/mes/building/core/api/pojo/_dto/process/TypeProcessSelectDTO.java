package com.hzchum.scim.mes.building.core.api.pojo._dto.process;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel("类型及工序DTO类")
public class TypeProcessSelectDTO {
   @ApiModelProperty(name = "typeId", value = "类型ID")
   private Long typeId;
   @ApiModelProperty(name = "typeName", value = "类型名称")
   private String typeName;
   @ApiModelProperty(name = "artifactClassification", value = "构件分类")
   private Integer artifactClassification;
   @ApiModelProperty(name = "machinePartClassification", value = "零件分类")
   private Integer machinePartClassification;
   @ApiModelProperty(name = "processList", value = "工序列表")
   private List<NameInfo> processList;
   @ApiModelProperty(name = "artifactNameList", value = "构件名称列表")
   private List<String> artifactNameList;

   public Long getTypeId() {
      return this.typeId;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public Integer getArtifactClassification() {
      return this.artifactClassification;
   }

   public Integer getMachinePartClassification() {
      return this.machinePartClassification;
   }

   public List<NameInfo> getProcessList() {
      return this.processList;
   }

   public List<String> getArtifactNameList() {
      return this.artifactNameList;
   }

   public void setTypeId(final Long typeId) {
      this.typeId = typeId;
   }

   public void setTypeName(final String typeName) {
      this.typeName = typeName;
   }

   public void setArtifactClassification(final Integer artifactClassification) {
      this.artifactClassification = artifactClassification;
   }

   public void setMachinePartClassification(final Integer machinePartClassification) {
      this.machinePartClassification = machinePartClassification;
   }

   public void setProcessList(final List<NameInfo> processList) {
      this.processList = processList;
   }

   public void setArtifactNameList(final List<String> artifactNameList) {
      this.artifactNameList = artifactNameList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TypeProcessSelectDTO)) {
         return false;
      }

      TypeProcessSelectDTO other = (TypeProcessSelectDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$typeId = this.getTypeId();
      Object other$typeId = other.getTypeId();
      if (this$typeId == null ? other$typeId == null : this$typeId.equals(other$typeId)) {
         Object this$artifactClassification = this.getArtifactClassification();
         Object other$artifactClassification = other.getArtifactClassification();
         if (this$artifactClassification == null ? other$artifactClassification == null : this$artifactClassification.equals(other$artifactClassification)) {
            Object this$machinePartClassification = this.getMachinePartClassification();
            Object other$machinePartClassification = other.getMachinePartClassification();
            if (this$machinePartClassification == null
               ? other$machinePartClassification == null
               : this$machinePartClassification.equals(other$machinePartClassification)) {
               Object this$typeName = this.getTypeName();
               Object other$typeName = other.getTypeName();
               if (this$typeName == null ? other$typeName == null : this$typeName.equals(other$typeName)) {
                  Object this$processList = this.getProcessList();
                  Object other$processList = other.getProcessList();
                  if (this$processList == null ? other$processList == null : this$processList.equals(other$processList)) {
                     Object this$artifactNameList = this.getArtifactNameList();
                     Object other$artifactNameList = other.getArtifactNameList();
                     return this$artifactNameList == null ? other$artifactNameList == null : this$artifactNameList.equals(other$artifactNameList);
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
      return other instanceof TypeProcessSelectDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $typeId = this.getTypeId();
      result = result * 59 + ($typeId == null ? 43 : $typeId.hashCode());
      Object $artifactClassification = this.getArtifactClassification();
      result = result * 59 + ($artifactClassification == null ? 43 : $artifactClassification.hashCode());
      Object $machinePartClassification = this.getMachinePartClassification();
      result = result * 59 + ($machinePartClassification == null ? 43 : $machinePartClassification.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $processList = this.getProcessList();
      result = result * 59 + ($processList == null ? 43 : $processList.hashCode());
      Object $artifactNameList = this.getArtifactNameList();
      return result * 59 + ($artifactNameList == null ? 43 : $artifactNameList.hashCode());
   }

   @Override
   public String toString() {
      return "TypeProcessSelectDTO(typeId="
         + this.getTypeId()
         + ", typeName="
         + this.getTypeName()
         + ", artifactClassification="
         + this.getArtifactClassification()
         + ", machinePartClassification="
         + this.getMachinePartClassification()
         + ", processList="
         + this.getProcessList()
         + ", artifactNameList="
         + this.getArtifactNameList()
         + ")";
   }
}
