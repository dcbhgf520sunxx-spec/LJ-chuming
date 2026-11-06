package com.hzchum.scim.project.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("ProjectInstallSummary对象dto")
public class ProjectInstallSummaryDTO {
   @ApiModelProperty(name = "id", value = "主键ID", notes = "主键ID")
   @JsonInclude(Include.NON_NULL)
   private Long id;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   private Long monomerId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "monomer", value = "单体", notes = "单体")
   private NameInfo monomer;
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   private Long areaId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "area", value = "区域", notes = "区域")
   private NameInfo area;
   @ApiModelProperty(name = "projectType", value = "项目类型 1建钢项目 2桥梁项目 4立体停车库", notes = "项目类型 1建钢项目 2桥梁项目 4立体停车库")
   private Integer projectType;
   @ApiModelProperty(name = "productType", value = "产品类型(2,4,8)", notes = "产品类型(2,4,8)")
   private Integer productType;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "category", value = "围护类型", notes = "围护类型")
   private Integer category;
   @ApiModelProperty(name = "productId", value = "产品ID(构件、围护、配套件id)", notes = "产品ID(构件、围护、配套件id)")
   private Long productId;
   @ApiModelProperty(name = "name", value = "产品名称", notes = "产品名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "产品编号", notes = "产品编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格", notes = "规格")
   private String specification;
   @ApiModelProperty(name = "actualQuantity", value = "实际数量", notes = "实际数量")
   private Integer actualQuantity;
   @ApiModelProperty(name = "actualMete", value = "实际量(重量kg/长度mm)", notes = "实际量(重量kg/长度mm)")
   private BigDecimal actualMete;
   @ApiModelProperty(name = "actualTotalArea", value = "实际安装面积(mm2)", notes = "实际安装面积(mm2)")
   private BigDecimal actualTotalArea;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "supplierId", value = "安装供应商id", notes = "安装供应商id")
   private Long supplierId;
   @ApiModelProperty(name = "supplierName", value = "安装供应商名称", notes = "安装供应商名称")
   private String supplierName;

   public static ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder builder() {
      return new ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder();
   }

   public ProjectInstallSummaryDTO() {
   }

   public ProjectInstallSummaryDTO(
      final Long id,
      final Long projectId,
      final Long monomerId,
      final NameInfo monomer,
      final Long areaId,
      final NameInfo area,
      final Integer projectType,
      final Integer productType,
      final Integer category,
      final Long productId,
      final String name,
      final String serialNumber,
      final String specification,
      final Integer actualQuantity,
      final BigDecimal actualMete,
      final BigDecimal actualTotalArea,
      final String measureUnit,
      final String accountingUnit,
      final Long supplierId,
      final String supplierName
   ) {
      this.id = id;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.monomer = monomer;
      this.areaId = areaId;
      this.area = area;
      this.projectType = projectType;
      this.productType = productType;
      this.category = category;
      this.productId = productId;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.actualQuantity = actualQuantity;
      this.actualMete = actualMete;
      this.actualTotalArea = actualTotalArea;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.supplierId = supplierId;
      this.supplierName = supplierName;
   }

   public Long getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
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

   public Integer getProjectType() {
      return this.projectType;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Long getProductId() {
      return this.productId;
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

   public Long getSupplierId() {
      return this.supplierId;
   }

   public String getSupplierName() {
      return this.supplierName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
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

   public void setProjectType(final Integer projectType) {
      this.projectType = projectType;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
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

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setSupplierName(final String supplierName) {
      this.supplierName = supplierName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectInstallSummaryDTO)) {
         return false;
      }

      ProjectInstallSummaryDTO other = (ProjectInstallSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$monomerId = this.getMonomerId();
            Object other$monomerId = other.getMonomerId();
            if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
               Object this$areaId = this.getAreaId();
               Object other$areaId = other.getAreaId();
               if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                  Object this$projectType = this.getProjectType();
                  Object other$projectType = other.getProjectType();
                  if (this$projectType == null ? other$projectType == null : this$projectType.equals(other$projectType)) {
                     Object this$productType = this.getProductType();
                     Object other$productType = other.getProductType();
                     if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
                        Object this$category = this.getCategory();
                        Object other$category = other.getCategory();
                        if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                           Object this$productId = this.getProductId();
                           Object other$productId = other.getProductId();
                           if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                              Object this$actualQuantity = this.getActualQuantity();
                              Object other$actualQuantity = other.getActualQuantity();
                              if (this$actualQuantity == null ? other$actualQuantity == null : this$actualQuantity.equals(other$actualQuantity)) {
                                 Object this$supplierId = this.getSupplierId();
                                 Object other$supplierId = other.getSupplierId();
                                 if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
                                    Object this$monomer = this.getMonomer();
                                    Object other$monomer = other.getMonomer();
                                    if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                       Object this$area = this.getArea();
                                       Object other$area = other.getArea();
                                       if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                          Object this$name = this.getName();
                                          Object other$name = other.getName();
                                          if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                             Object this$serialNumber = this.getSerialNumber();
                                             Object other$serialNumber = other.getSerialNumber();
                                             if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                Object this$specification = this.getSpecification();
                                                Object other$specification = other.getSpecification();
                                                if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
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
                                                            if (this$accountingUnit == null
                                                               ? other$accountingUnit == null
                                                               : this$accountingUnit.equals(other$accountingUnit)) {
                                                               Object this$supplierName = this.getSupplierName();
                                                               Object other$supplierName = other.getSupplierName();
                                                               return this$supplierName == null
                                                                  ? other$supplierName == null
                                                                  : this$supplierName.equals(other$supplierName);
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
      return other instanceof ProjectInstallSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $projectType = this.getProjectType();
      result = result * 59 + ($projectType == null ? 43 : $projectType.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $actualQuantity = this.getActualQuantity();
      result = result * 59 + ($actualQuantity == null ? 43 : $actualQuantity.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $actualMete = this.getActualMete();
      result = result * 59 + ($actualMete == null ? 43 : $actualMete.hashCode());
      Object $actualTotalArea = this.getActualTotalArea();
      result = result * 59 + ($actualTotalArea == null ? 43 : $actualTotalArea.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $supplierName = this.getSupplierName();
      return result * 59 + ($supplierName == null ? 43 : $supplierName.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectInstallSummaryDTO(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomer="
         + this.getMonomer()
         + ", areaId="
         + this.getAreaId()
         + ", area="
         + this.getArea()
         + ", projectType="
         + this.getProjectType()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", productId="
         + this.getProductId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
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
         + ", supplierId="
         + this.getSupplierId()
         + ", supplierName="
         + this.getSupplierName()
         + ")";
   }

   public static class ProjectInstallSummaryDTOBuilder {
      private Long id;
      private Long projectId;
      private Long monomerId;
      private NameInfo monomer;
      private Long areaId;
      private NameInfo area;
      private Integer projectType;
      private Integer productType;
      private Integer category;
      private Long productId;
      private String name;
      private String serialNumber;
      private String specification;
      private Integer actualQuantity;
      private BigDecimal actualMete;
      private BigDecimal actualTotalArea;
      private String measureUnit;
      private String accountingUnit;
      private Long supplierId;
      private String supplierName;

      ProjectInstallSummaryDTOBuilder() {
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder projectType(final Integer projectType) {
         this.projectType = projectType;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder actualQuantity(final Integer actualQuantity) {
         this.actualQuantity = actualQuantity;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder actualMete(final BigDecimal actualMete) {
         this.actualMete = actualMete;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder actualTotalArea(final BigDecimal actualTotalArea) {
         this.actualTotalArea = actualTotalArea;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder supplierId(final Long supplierId) {
         this.supplierId = supplierId;
         return this;
      }

      public ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder supplierName(final String supplierName) {
         this.supplierName = supplierName;
         return this;
      }

      public ProjectInstallSummaryDTO build() {
         return new ProjectInstallSummaryDTO(
            this.id,
            this.projectId,
            this.monomerId,
            this.monomer,
            this.areaId,
            this.area,
            this.projectType,
            this.productType,
            this.category,
            this.productId,
            this.name,
            this.serialNumber,
            this.specification,
            this.actualQuantity,
            this.actualMete,
            this.actualTotalArea,
            this.measureUnit,
            this.accountingUnit,
            this.supplierId,
            this.supplierName
         );
      }

      @Override
      public String toString() {
         return "ProjectInstallSummaryDTO.ProjectInstallSummaryDTOBuilder(id="
            + this.id
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", monomer="
            + this.monomer
            + ", areaId="
            + this.areaId
            + ", area="
            + this.area
            + ", projectType="
            + this.projectType
            + ", productType="
            + this.productType
            + ", category="
            + this.category
            + ", productId="
            + this.productId
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
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
            + ", supplierId="
            + this.supplierId
            + ", supplierName="
            + this.supplierName
            + ")";
      }
   }
}
