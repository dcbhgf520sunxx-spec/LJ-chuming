package com.hzchum.scim.project.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("安装填报分组对象DTO")
public class ProjectInstallReportGroupDTO {
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
   @ApiModelProperty(name = "productType", value = "产品类型(2构件 , 4围护 , 8配套件)", notes = "产品类型(2构件 , 4围护 , 8配套件)")
   private Integer productType;
   @ApiModelProperty(name = "category", value = "围护分类")
   private Integer category;
   @ApiModelProperty(name = "reportQuantity", value = "填报数量", notes = "填报数量")
   private Integer reportQuantity;
   @ApiModelProperty(name = "reportMete", value = "填报量(重量kg/长度m)", notes = "填报量(重量kg/长度m)")
   private BigDecimal reportMete;
   @ApiModelProperty(name = "actualQuantity", value = "实际数量", notes = "实际数量")
   private Integer actualQuantity;
   @ApiModelProperty(name = "actualMete", value = "实际量(重量kg/长度m)", notes = "实际量(重量kg/长度m)")
   private BigDecimal actualMete;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "boolAuditStatus", value = "审核状态 false未审核 true已审核")
   private Boolean boolAuditStatus;

   public static ProjectInstallReportGroupDTO.ProjectInstallReportGroupDTOBuilder builder() {
      return new ProjectInstallReportGroupDTO.ProjectInstallReportGroupDTOBuilder();
   }

   public ProjectInstallReportGroupDTO() {
   }

   public ProjectInstallReportGroupDTO(
      final Long projectId,
      final ProjectInfo project,
      final String reportDate,
      final Long supplierId,
      final String supplierName,
      final Integer productType,
      final Integer category,
      final Integer reportQuantity,
      final BigDecimal reportMete,
      final Integer actualQuantity,
      final BigDecimal actualMete,
      final String measureUnit,
      final String accountingUnit,
      final Boolean boolAuditStatus
   ) {
      this.projectId = projectId;
      this.project = project;
      this.reportDate = reportDate;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
      this.productType = productType;
      this.category = category;
      this.reportQuantity = reportQuantity;
      this.reportMete = reportMete;
      this.actualQuantity = actualQuantity;
      this.actualMete = actualMete;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.boolAuditStatus = boolAuditStatus;
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

   public Integer getActualQuantity() {
      return this.actualQuantity;
   }

   public BigDecimal getActualMete() {
      return this.actualMete;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public Boolean getBoolAuditStatus() {
      return this.boolAuditStatus;
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

   public void setActualQuantity(final Integer actualQuantity) {
      this.actualQuantity = actualQuantity;
   }

   public void setActualMete(final BigDecimal actualMete) {
      this.actualMete = actualMete;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setBoolAuditStatus(final Boolean boolAuditStatus) {
      this.boolAuditStatus = boolAuditStatus;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInstallReportGroupDTO)) {
         return false;
      }

      ProjectInstallReportGroupDTO other = (ProjectInstallReportGroupDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
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
                        Object this$boolAuditStatus = this.getBoolAuditStatus();
                        Object other$boolAuditStatus = other.getBoolAuditStatus();
                        if (this$boolAuditStatus == null ? other$boolAuditStatus == null : this$boolAuditStatus.equals(other$boolAuditStatus)) {
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
                                       Object this$actualMete = this.getActualMete();
                                       Object other$actualMete = other.getActualMete();
                                       if (this$actualMete == null ? other$actualMete == null : this$actualMete.equals(other$actualMete)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ProjectInstallReportGroupDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $reportQuantity = this.getReportQuantity();
      result = result * 59 + ($reportQuantity == null ? 43 : $reportQuantity.hashCode());
      Object $actualQuantity = this.getActualQuantity();
      result = result * 59 + ($actualQuantity == null ? 43 : $actualQuantity.hashCode());
      Object $boolAuditStatus = this.getBoolAuditStatus();
      result = result * 59 + ($boolAuditStatus == null ? 43 : $boolAuditStatus.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $reportDate = this.getReportDate();
      result = result * 59 + ($reportDate == null ? 43 : $reportDate.hashCode());
      Object $supplierName = this.getSupplierName();
      result = result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
      Object $reportMete = this.getReportMete();
      result = result * 59 + ($reportMete == null ? 43 : $reportMete.hashCode());
      Object $actualMete = this.getActualMete();
      result = result * 59 + ($actualMete == null ? 43 : $actualMete.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      return result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInstallReportGroupDTO(projectId="
         + this.getProjectId()
         + ", project="
         + this.getProject()
         + ", reportDate="
         + this.getReportDate()
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", reportQuantity="
         + this.getReportQuantity()
         + ", reportMete="
         + this.getReportMete()
         + ", actualQuantity="
         + this.getActualQuantity()
         + ", actualMete="
         + this.getActualMete()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", boolAuditStatus="
         + this.getBoolAuditStatus()
         + ")";
   }

   public static class ProjectInstallReportGroupDTOBuilder {
      private Long projectId;
      private ProjectInfo project;
      private String reportDate;
      private Long supplierId;
      private String supplierName;
      private Integer productType;
      private Integer category;
      private Integer reportQuantity;
      private BigDecimal reportMete;
      private Integer actualQuantity;
      private BigDecimal actualMete;
      private String measureUnit;
      private String accountingUnit;
      private Boolean boolAuditStatus;

      ProjectInstallReportGroupDTOBuilder() {
      }

      public ProjectInstallReportGroupDTO.ProjectInstallReportGroupDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectInstallReportGroupDTO.ProjectInstallReportGroupDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectInstallReportGroupDTO.ProjectInstallReportGroupDTOBuilder reportDate(final String reportDate) {
         this.reportDate = reportDate;
         return this;
      }

      public ProjectInstallReportGroupDTO.ProjectInstallReportGroupDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectInstallReportGroupDTO.ProjectInstallReportGroupDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectInstallReportGroupDTO.ProjectInstallReportGroupDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectInstallReportGroupDTO.ProjectInstallReportGroupDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public ProjectInstallReportGroupDTO.ProjectInstallReportGroupDTOBuilder reportQuantity(final Integer reportQuantity) {
         this.reportQuantity = reportQuantity;
         return this;
      }

      public ProjectInstallReportGroupDTO.ProjectInstallReportGroupDTOBuilder reportMete(final BigDecimal reportMete) {
         this.reportMete = reportMete;
         return this;
      }

      public ProjectInstallReportGroupDTO.ProjectInstallReportGroupDTOBuilder actualQuantity(final Integer actualQuantity) {
         this.actualQuantity = actualQuantity;
         return this;
      }

      public ProjectInstallReportGroupDTO.ProjectInstallReportGroupDTOBuilder actualMete(final BigDecimal actualMete) {
         this.actualMete = actualMete;
         return this;
      }

      public ProjectInstallReportGroupDTO.ProjectInstallReportGroupDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectInstallReportGroupDTO.ProjectInstallReportGroupDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ProjectInstallReportGroupDTO.ProjectInstallReportGroupDTOBuilder boolAuditStatus(final Boolean boolAuditStatus) {
         this.boolAuditStatus = boolAuditStatus;
         return this;
      }

      public ProjectInstallReportGroupDTO build() {
         return new ProjectInstallReportGroupDTO(
            this.projectId,
            this.project,
            this.reportDate,
            this.supplierId,
            this.supplierName,
            this.productType,
            this.category,
            this.reportQuantity,
            this.reportMete,
            this.actualQuantity,
            this.actualMete,
            this.measureUnit,
            this.accountingUnit,
            this.boolAuditStatus
         );
      }

      @Override
      public String toString() {
         return "ProjectInstallReportGroupDTO.ProjectInstallReportGroupDTOBuilder(projectId="
            + this.projectId
            + ", project="
            + this.project
            + ", reportDate="
            + this.reportDate
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ", productType="
            + this.productType
            + ", category="
            + this.category
            + ", reportQuantity="
            + this.reportQuantity
            + ", reportMete="
            + this.reportMete
            + ", actualQuantity="
            + this.actualQuantity
            + ", actualMete="
            + this.actualMete
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", boolAuditStatus="
            + this.boolAuditStatus
            + ")";
      }
   }
}
