package com.hzchum.scim.project.core.api.pojo.dao;

import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("产品安装信息类")
public class ProjectProductInstallSummaryDO {
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "project", value = "项目", notes = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   private Long monomerId;
   @ApiModelProperty(name = "monomer", value = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   private Long areaId;
   @ApiModelProperty(name = "area")
   private NameInfo area;
   @ApiModelProperty(name = "productType", value = "产品类型 2构件 4围护 8配套件")
   private Integer productType;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "actualQuantity", value = "实际数量", notes = "实际数量")
   private Integer actualQuantity;
   @ApiModelProperty(name = "actualMete", value = "实际安装量(重量kg/长度mm)", notes = "实际量(重量kg/长度mm)")
   private BigDecimal actualMete;
   @ApiModelProperty(name = "actualTotalArea", value = "实际安装面积(mm2)", notes = "实际安装面积(mm2)")
   private BigDecimal actualTotalArea;

   public static ProjectProductInstallSummaryDO.ProjectProductInstallSummaryDOBuilder builder() {
      return new ProjectProductInstallSummaryDO.ProjectProductInstallSummaryDOBuilder();
   }

   public ProjectProductInstallSummaryDO() {
   }

   public ProjectProductInstallSummaryDO(
      final Long projectId,
      final ProjectInfo project,
      final Long monomerId,
      final NameInfo monomer,
      final Long areaId,
      final NameInfo area,
      final Integer productType,
      final Long productId,
      final Integer actualQuantity,
      final BigDecimal actualMete,
      final BigDecimal actualTotalArea
   ) {
      this.projectId = projectId;
      this.project = project;
      this.monomerId = monomerId;
      this.monomer = monomer;
      this.areaId = areaId;
      this.area = area;
      this.productType = productType;
      this.productId = productId;
      this.actualQuantity = actualQuantity;
      this.actualMete = actualMete;
      this.actualTotalArea = actualTotalArea;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public Long getAreaId() {
      return this.areaId;
   }

   public NameInfo getArea() {
      return this.area;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getActualQuantity() {
      return this.actualQuantity;
   }

   public BigDecimal getActualMete() {
      return this.actualMete;
   }

   public BigDecimal getActualTotalArea() {
      return this.actualTotalArea;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
   }

   public void setArea(final NameInfo area) {
      this.area = area;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setActualQuantity(final Integer actualQuantity) {
      this.actualQuantity = actualQuantity;
   }

   public void setActualMete(final BigDecimal actualMete) {
      this.actualMete = actualMete;
   }

   public void setActualTotalArea(final BigDecimal actualTotalArea) {
      this.actualTotalArea = actualTotalArea;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectProductInstallSummaryDO)) {
         return false;
      }

      ProjectProductInstallSummaryDO other = (ProjectProductInstallSummaryDO)o;
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
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$productId = this.getProductId();
                  Object other$productId = other.getProductId();
                  if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                     Object this$actualQuantity = this.getActualQuantity();
                     Object other$actualQuantity = other.getActualQuantity();
                     if (this$actualQuantity == null ? other$actualQuantity == null : this$actualQuantity.equals(other$actualQuantity)) {
                        Object this$project = this.getProject();
                        Object other$project = other.getProject();
                        if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                           Object this$monomer = this.getMonomer();
                           Object other$monomer = other.getMonomer();
                           if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                              Object this$area = this.getArea();
                              Object other$area = other.getArea();
                              if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                 Object this$actualMete = this.getActualMete();
                                 Object other$actualMete = other.getActualMete();
                                 if (this$actualMete == null ? other$actualMete == null : this$actualMete.equals(other$actualMete)) {
                                    Object this$actualTotalArea = this.getActualTotalArea();
                                    Object other$actualTotalArea = other.getActualTotalArea();
                                    return this$actualTotalArea == null ? other$actualTotalArea == null : this$actualTotalArea.equals(other$actualTotalArea);
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
      return other instanceof ProjectProductInstallSummaryDO;
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
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $actualQuantity = this.getActualQuantity();
      result = result * 59 + ($actualQuantity == null ? 43 : $actualQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $actualMete = this.getActualMete();
      result = result * 59 + ($actualMete == null ? 43 : $actualMete.hashCode());
      Object $actualTotalArea = this.getActualTotalArea();
      return result * 59 + ($actualTotalArea == null ? 43 : $actualTotalArea.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectProductInstallSummaryDO(projectId="
         + this.getProjectId()
         + ", project="
         + this.getProject()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomer="
         + this.getMonomer()
         + ", areaId="
         + this.getAreaId()
         + ", area="
         + this.getArea()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", actualQuantity="
         + this.getActualQuantity()
         + ", actualMete="
         + this.getActualMete()
         + ", actualTotalArea="
         + this.getActualTotalArea()
         + ")";
   }

   public static class ProjectProductInstallSummaryDOBuilder {
      private Long projectId;
      private ProjectInfo project;
      private Long monomerId;
      private NameInfo monomer;
      private Long areaId;
      private NameInfo area;
      private Integer productType;
      private Long productId;
      private Integer actualQuantity;
      private BigDecimal actualMete;
      private BigDecimal actualTotalArea;

      ProjectProductInstallSummaryDOBuilder() {
      }

      public ProjectProductInstallSummaryDO.ProjectProductInstallSummaryDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectProductInstallSummaryDO.ProjectProductInstallSummaryDOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectProductInstallSummaryDO.ProjectProductInstallSummaryDOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectProductInstallSummaryDO.ProjectProductInstallSummaryDOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public ProjectProductInstallSummaryDO.ProjectProductInstallSummaryDOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectProductInstallSummaryDO.ProjectProductInstallSummaryDOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public ProjectProductInstallSummaryDO.ProjectProductInstallSummaryDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectProductInstallSummaryDO.ProjectProductInstallSummaryDOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ProjectProductInstallSummaryDO.ProjectProductInstallSummaryDOBuilder actualQuantity(final Integer actualQuantity) {
         this.actualQuantity = actualQuantity;
         return this;
      }

      public ProjectProductInstallSummaryDO.ProjectProductInstallSummaryDOBuilder actualMete(final BigDecimal actualMete) {
         this.actualMete = actualMete;
         return this;
      }

      public ProjectProductInstallSummaryDO.ProjectProductInstallSummaryDOBuilder actualTotalArea(final BigDecimal actualTotalArea) {
         this.actualTotalArea = actualTotalArea;
         return this;
      }

      public ProjectProductInstallSummaryDO build() {
         return new ProjectProductInstallSummaryDO(
            this.projectId,
            this.project,
            this.monomerId,
            this.monomer,
            this.areaId,
            this.area,
            this.productType,
            this.productId,
            this.actualQuantity,
            this.actualMete,
            this.actualTotalArea
         );
      }

      @Override
      public String toString() {
         return "ProjectProductInstallSummaryDO.ProjectProductInstallSummaryDOBuilder(projectId="
            + this.projectId
            + ", project="
            + this.project
            + ", monomerId="
            + this.monomerId
            + ", monomer="
            + this.monomer
            + ", areaId="
            + this.areaId
            + ", area="
            + this.area
            + ", productType="
            + this.productType
            + ", productId="
            + this.productId
            + ", actualQuantity="
            + this.actualQuantity
            + ", actualMete="
            + this.actualMete
            + ", actualTotalArea="
            + this.actualTotalArea
            + ")";
      }
   }
}
