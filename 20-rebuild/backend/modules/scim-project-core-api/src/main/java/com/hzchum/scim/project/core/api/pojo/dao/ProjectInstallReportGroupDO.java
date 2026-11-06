package com.hzchum.scim.project.core.api.pojo.dao;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("安装填报分组对象DO")
public class ProjectInstallReportGroupDO {
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty(name = "reportDate", value = "上报日期", notes = "上报日期")
   private String reportDate;
   @ApiModelProperty(name = "supplierId", value = "安装供应商id", notes = "安装供应商id")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "安装供应商名称", notes = "安装供应商名称")
   private String supplierName;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢项目 2桥梁项目", notes = "项目类型 1建钢项目 2桥梁项目")
   private Integer projectType;
   @ApiModelProperty(name = "productType", value = "产品类型(2构件 , 4围护 , 8配套件)", notes = "产品类型(2构件 , 4围护 , 8配套件)")
   private Integer productType;
   @ApiModelProperty(name = "category", value = "围护分类")
   private Integer category;
   @ApiModelProperty(name = "reportQuantity", value = "填报数量", notes = "填报数量")
   private Integer reportQuantity;
   @ApiModelProperty(name = "reportMete", value = "填报量(重量kg/长度mm)", notes = "填报量(重量kg/长度mm)")
   private BigDecimal reportMete;
   @ApiModelProperty(name = "reportTotalArea", value = "填报总面积(m2)", notes = "填报总面积(m2)")
   private BigDecimal reportTotalArea;
   @ApiModelProperty(name = "actualQuantity", value = "实际数量", notes = "实际数量")
   private Integer actualQuantity;
   @ApiModelProperty(name = "actualMete", value = "实际量(重量kg/长度mm)", notes = "实际量(重量kg/长度mm)")
   private BigDecimal actualMete;
   @ApiModelProperty(name = "actualTotalArea", value = "实际总面积(mm2)", notes = "实际总面积(mm2)")
   private BigDecimal actualTotalArea;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;

   public static ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder builder() {
      return new ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder();
   }

   public ProjectInstallReportGroupDO() {
   }

   public ProjectInstallReportGroupDO(
      final Long projectId,
      final ProjectInfo project,
      final String reportDate,
      final Long supplierId,
      final String supplierName,
      final Integer projectType,
      final Integer productType,
      final Integer category,
      final Integer reportQuantity,
      final BigDecimal reportMete,
      final BigDecimal reportTotalArea,
      final Integer actualQuantity,
      final BigDecimal actualMete,
      final BigDecimal actualTotalArea,
      final String measureUnit,
      final String accountingUnit
   ) {
      this.projectId = projectId;
      this.project = project;
      this.reportDate = reportDate;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.projectType = projectType;
      this.productType = productType;
      this.category = category;
      this.reportQuantity = reportQuantity;
      this.reportMete = reportMete;
      this.reportTotalArea = reportTotalArea;
      this.actualQuantity = actualQuantity;
      this.actualMete = actualMete;
      this.actualTotalArea = actualTotalArea;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public String getReportDate() {
      return this.reportDate;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Integer getReportQuantity() {
      return this.reportQuantity;
   }

   public BigDecimal getReportMete() {
      return this.reportMete;
   }

   public BigDecimal getReportTotalArea() {
      return this.reportTotalArea;
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

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setReportDate(final String reportDate) {
      this.reportDate = reportDate;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setReportQuantity(final Integer reportQuantity) {
      this.reportQuantity = reportQuantity;
   }

   public void setReportMete(final BigDecimal reportMete) {
      this.reportMete = reportMete;
   }

   public void setReportTotalArea(final BigDecimal reportTotalArea) {
      this.reportTotalArea = reportTotalArea;
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

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInstallReportGroupDO)) {
         return false;
      }

      ProjectInstallReportGroupDO other = (ProjectInstallReportGroupDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$projectType = this.getProjectType();
            Object other$projectType = other.getProjectType();
            if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
               Object this$productType = this.getProductType();
               Object other$productType = other.getProductType();
               if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                  Object this$category = this.getCategory();
                  Object other$category = other.getCategory();
                  if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                     Object this$reportQuantity = this.getReportQuantity();
                     Object other$reportQuantity = other.getReportQuantity();
                     if (this$reportQuantity == null ? other$reportQuantity == null : this$reportQuantity.equals(other$reportQuantity)) {
                        Object this$actualQuantity = this.getActualQuantity();
                        Object other$actualQuantity = other.getActualQuantity();
                        if (this$actualQuantity == null ? other$actualQuantity == null : this$actualQuantity.equals(other$actualQuantity)) {
                           Object this$project = this.getProject();
                           Object other$project = other.getProject();
                           if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                              Object this$reportDate = this.getReportDate();
                              Object other$reportDate = other.getReportDate();
                              if (this$reportDate == null ? other$reportDate == null : this$reportDate.equals(other$reportDate)) {
                                 Object this$supplierName = this.getSupplierName();
                                 Object other$supplierName = other.getSupplierName();
                                 if (this$supplierName == null ? other$supplierName == null : this$supplierName.equals(other$supplierName)) {
                                    Object this$reportMete = this.getReportMete();
                                    Object other$reportMete = other.getReportMete();
                                    if (this$reportMete == null ? other$reportMete == null : this$reportMete.equals(other$reportMete)) {
                                       Object this$reportTotalArea = this.getReportTotalArea();
                                       Object other$reportTotalArea = other.getReportTotalArea();
                                       if (this$reportTotalArea == null ? other$reportTotalArea == null : this$reportTotalArea.equals(other$reportTotalArea)) {
                                          Object this$actualMete = this.getActualMete();
                                          Object other$actualMete = other.getActualMete();
                                          if (this$actualMete == null ? other$actualMete == null : this$actualMete.equals(other$actualMete)) {
                                             Object this$actualTotalArea = this.getActualTotalArea();
                                             Object other$actualTotalArea = other.getActualTotalArea();
                                             if (this$actualTotalArea == null
                                                ? other$actualTotalArea == null
                                                : this$actualTotalArea.equals(other$actualTotalArea)) {
                                                Object this$measureUnit = this.getMeasureUnit();
                                                Object other$measureUnit = other.getMeasureUnit();
                                                if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                   Object this$accountingUnit = this.getAccountingUnit();
                                                   Object other$accountingUnit = other.getAccountingUnit();
                                                   return this$accountingUnit == null
                                                      ? other$accountingUnit == null
                                                      : this$accountingUnit.equals(other$accountingUnit);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInstallReportGroupDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $actualQuantity = this.getActualQuantity();
      result = result * 59 + ($actualQuantity == null ? 43 : $actualQuantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $reportDate = this.getReportDate();
      result = result * 59 + ($reportDate == null ? 43 : $reportDate.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $reportMete = this.getReportMete();
      result = result * 59 + ($reportMete == null ? 43 : $reportMete.hashCode());
      Object $reportTotalArea = this.getReportTotalArea();
      result = result * 59 + ($reportTotalArea == null ? 43 : $reportTotalArea.hashCode());
      Object $actualMete = this.getActualMete();
      result = result * 59 + ($actualMete == null ? 43 : $actualMete.hashCode());
      Object $actualTotalArea = this.getActualTotalArea();
      result = result * 59 + ($actualTotalArea == null ? 43 : $actualTotalArea.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      return result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInstallReportGroupDO(projectId="
         + this.getProjectId()
         + ", project="
         + this.getProject()
         + ", reportDate="
         + this.getReportDate()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", projectType="
         + this.getProjectType()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", reportMete="
         + this.getReportMete()
         + ", reportTotalArea="
         + this.getReportTotalArea()
         + ", actualQuantity="
         + this.getActualQuantity()
         + ", actualMete="
         + this.getActualMete()
         + ", actualTotalArea="
         + this.getActualTotalArea()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ")";
   }

   public static class ProjectInstallReportGroupDOBuilder {
      private Long projectId;
      private ProjectInfo project;
      private String reportDate;
      private Long supplierId;
      private String supplierName;
      private Integer projectType;
      private Integer productType;
      private Integer category;
      private Integer reportQuantity;
      private BigDecimal reportMete;
      private BigDecimal reportTotalArea;
      private Integer actualQuantity;
      private BigDecimal actualMete;
      private BigDecimal actualTotalArea;
      private String measureUnit;
      private String accountingUnit;

      ProjectInstallReportGroupDOBuilder() {
      }

      public ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder reportDate(final String reportDate) {
         this.reportDate = reportDate;
         return this;
      }

      public ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder reportQuantity(final Integer reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      public ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder reportMete(final BigDecimal reportMete) {
         this.reportMete = reportMete;
         return this;
      }

      public ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder reportTotalArea(final BigDecimal reportTotalArea) {
         this.reportTotalArea = reportTotalArea;
         return this;
      }

      public ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder actualQuantity(final Integer actualQuantity) {
         this.actualQuantity = actualQuantity;
         return this;
      }

      public ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder actualMete(final BigDecimal actualMete) {
         this.actualMete = actualMete;
         return this;
      }

      public ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder actualTotalArea(final BigDecimal actualTotalArea) {
         this.actualTotalArea = actualTotalArea;
         return this;
      }

      public ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ProjectInstallReportGroupDO build() {
         return new ProjectInstallReportGroupDO(
            this.projectId,
            this.project,
            this.reportDate,
            this.supplierId,
            this.supplierName,
            this.projectType,
            this.productType,
            this.category,
            this.reportQuantity,
            this.reportMete,
            this.reportTotalArea,
            this.actualQuantity,
            this.actualMete,
            this.actualTotalArea,
            this.measureUnit,
            this.accountingUnit
         );
      }

      @Override
      public String toString() {
         return "ProjectInstallReportGroupDO.ProjectInstallReportGroupDOBuilder(projectId="
            + this.projectId
            + ", project="
            + this.project
            + ", reportDate="
            + this.reportDate
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", projectType="
            + this.projectType
            + ", productType="
            + this.productType
            + ", category="
            + this.category
            + ", reportQuantity="
            + this.reportQuantity
            + ", reportMete="
            + this.reportMete
            + ", reportTotalArea="
            + this.reportTotalArea
            + ", actualQuantity="
            + this.actualQuantity
            + ", actualMete="
            + this.actualMete
            + ", actualTotalArea="
            + this.actualTotalArea
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ")";
      }
   }
}
