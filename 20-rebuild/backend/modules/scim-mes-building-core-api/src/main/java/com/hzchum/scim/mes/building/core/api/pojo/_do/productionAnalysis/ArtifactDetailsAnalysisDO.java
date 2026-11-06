package com.hzchum.scim.mes.building.core.api.pojo._do.productionAnalysis;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import com.hzchum.scim.mes.building.core.api.pojo._do.projectKanban.ProcessSummaryDetailsDO;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

public class ArtifactDetailsAnalysisDO extends ArtifactAnalysisDO {
   @ApiModelProperty(notes = "产品id")
   private Long id;
   @ApiModelProperty(notes = "编号")
   private String serialNumber;
   @ApiModelProperty(notes = "项目信息")
   private ProjectInfo project;
   @ApiModelProperty(notes = "单体信息")
   private NameInfo monomer;
   @ApiModelProperty(notes = "区域信息")
   private NameInfo area;
   @ApiModelProperty(notes = "名称")
   private String name;
   @ApiModelProperty(notes = "材质")
   private String material;
   List<ProcessSummaryDetailsDO> processSummaryList;

   public Long getId() {
      return this.id;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public String getName() {
      return this.name;
   }

   public String getMaterial() {
      return this.material;
   }

   public List<ProcessSummaryDetailsDO> getProcessSummaryList() {
      return this.processSummaryList;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setProcessSummaryList(final List<ProcessSummaryDetailsDO> processSummaryList) {
      this.processSummaryList = processSummaryList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ArtifactDetailsAnalysisDO)) {
         return false;
      }

      ArtifactDetailsAnalysisDO other = (ArtifactDetailsAnalysisDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$project = this.getProject();
            Object other$project = other.getProject();
            if (this$project == null ? other$project == null : this$project.equals(other$project)) {
               Object this$monomer = this.getMonomer();
               Object other$monomer = other.getMonomer();
               if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                  Object this$area = this.getArea();
                  Object other$area = other.getArea();
                  if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                     Object this$name = this.getName();
                     Object other$name = other.getName();
                     if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                        Object this$material = this.getMaterial();
                        Object other$material = other.getMaterial();
                        if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                           Object this$processSummaryList = this.getProcessSummaryList();
                           Object other$processSummaryList = other.getProcessSummaryList();
                           return this$processSummaryList == null ? other$processSummaryList == null : this$processSummaryList.equals(other$processSummaryList);
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

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ArtifactDetailsAnalysisDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $processSummaryList = this.getProcessSummaryList();
      return result * 59 + ($processSummaryList == null ? 43 : $processSummaryList.hashCode());
   }

   @Override
   public String toString() {
      return "ArtifactDetailsAnalysisDO(id="
         + this.getId()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", name="
         + this.getName()
         + ", material="
         + this.getMaterial()
         + ", processSummaryList="
         + this.getProcessSummaryList()
         + ")";
   }
}
