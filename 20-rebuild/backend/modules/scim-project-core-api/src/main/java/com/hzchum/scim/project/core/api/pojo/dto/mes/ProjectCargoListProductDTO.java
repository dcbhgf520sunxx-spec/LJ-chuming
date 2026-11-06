package com.hzchum.scim.project.core.api.pojo.dto.mes;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目管理-收货产品类")
public class ProjectCargoListProductDTO {
   @ApiModelProperty(name = "linkId")
   private Long linkId;
   @ApiModelProperty(name = "productId", value = "产品id", notes = "产品id")
   private Long productId;
   @ApiModelProperty(name = "productType", value = "产品类型", notes = "产品类型 2构件 4围护 8配套件")
   private Integer productType;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "projectId", value = "项目ID", notes = "项目ID")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体ID", notes = "单体ID")
   private Long monomerId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "areaId", value = "区域ID", notes = "区域ID")
   private Long areaId;
   @ApiModelProperty("项目")
   private ProjectInfo project;
   @ApiModelProperty("单体")
   private NameInfo monomer;
   @ApiModelProperty("区域")
   private NameInfo area;
   @ApiModelProperty(name = "quantity", value = "装车数量", notes = "装车数量")
   private BigDecimal quantity;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   private String measureUnit;
   @ApiModelProperty("核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "accountingMete", value = "核算总量")
   private BigDecimal accountingMete;
   @ApiModelProperty(name = "boolProblemReceiving", value = "是否问题收货 1问题收货 0正常收货 ", notes = "是否问题收货 1问题收货 0正常收货")
   private Boolean boolProblemReceiving;
   @ApiModelProperty(name = "problemDesc", value = "问题收货描述 ", notes = "问题收货描述")
   private String problemDesc;

   public static ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder builder() {
      return new ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder();
   }

   public Long getLinkId() {
      return this.linkId;
   }

   public Long getProductId() {
      return this.productId;
   }

   public Integer getProductType() {
      return this.productType;
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

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getMonomerId() {
      return this.monomerId;
   }

   public Long getAreaId() {
      return this.areaId;
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

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getAccountingMete() {
      return this.accountingMete;
   }

   public Boolean getBoolProblemReceiving() {
      return this.boolProblemReceiving;
   }

   public String getProblemDesc() {
      return this.problemDesc;
   }

   public void setLinkId(final Long linkId) {
      this.linkId = linkId;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
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

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setMonomerId(final Long monomerId) {
      this.monomerId = monomerId;
   }

   public void setAreaId(final Long areaId) {
      this.areaId = areaId;
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

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setAccountingMete(final BigDecimal accountingMete) {
      this.accountingMete = accountingMete;
   }

   public void setBoolProblemReceiving(final Boolean boolProblemReceiving) {
      this.boolProblemReceiving = boolProblemReceiving;
   }

   public void setProblemDesc(final String problemDesc) {
      this.problemDesc = problemDesc;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectCargoListProductDTO)) {
         return false;
      }

      ProjectCargoListProductDTO other = (ProjectCargoListProductDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$linkId = this.getLinkId();
      Object other$linkId = other.getLinkId();
      if (this$linkId == null ? other$linkId == null : this$linkId.equals(other$linkId)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$projectId = this.getProjectId();
               Object other$projectId = other.getProjectId();
               if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                  Object this$monomerId = this.getMonomerId();
                  Object other$monomerId = other.getMonomerId();
                  if (this$monomerId == null ? other$monomerId == null : this$monomerId.equals(other$monomerId)) {
                     Object this$areaId = this.getAreaId();
                     Object other$areaId = other.getAreaId();
                     if (this$areaId == null ? other$areaId == null : this$areaId.equals(other$areaId)) {
                        Object this$boolProblemReceiving = this.getBoolProblemReceiving();
                        Object other$boolProblemReceiving = other.getBoolProblemReceiving();
                        if (this$boolProblemReceiving == null
                           ? other$boolProblemReceiving == null
                           : this$boolProblemReceiving.equals(other$boolProblemReceiving)) {
                           Object this$name = this.getName();
                           Object other$name = other.getName();
                           if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                              Object this$serialNumber = this.getSerialNumber();
                              Object other$serialNumber = other.getSerialNumber();
                              if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                 Object this$specification = this.getSpecification();
                                 Object other$specification = other.getSpecification();
                                 if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                    Object this$project = this.getProject();
                                    Object other$project = other.getProject();
                                    if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                                       Object this$monomer = this.getMonomer();
                                       Object other$monomer = other.getMonomer();
                                       if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                          Object this$area = this.getArea();
                                          Object other$area = other.getArea();
                                          if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                                             Object this$quantity = this.getQuantity();
                                             Object other$quantity = other.getQuantity();
                                             if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                Object this$measureUnit = this.getMeasureUnit();
                                                Object other$measureUnit = other.getMeasureUnit();
                                                if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                   Object this$accountingUnit = this.getAccountingUnit();
                                                   Object other$accountingUnit = other.getAccountingUnit();
                                                   if (this$accountingUnit == null
                                                      ? other$accountingUnit == null
                                                      : this$accountingUnit.equals(other$accountingUnit)) {
                                                      Object this$accountingMete = this.getAccountingMete();
                                                      Object other$accountingMete = other.getAccountingMete();
                                                      if (this$accountingMete == null
                                                         ? other$accountingMete == null
                                                         : this$accountingMete.equals(other$accountingMete)) {
                                                         Object this$problemDesc = this.getProblemDesc();
                                                         Object other$problemDesc = other.getProblemDesc();
                                                         return this$problemDesc == null
                                                            ? other$problemDesc == null
                                                            : this$problemDesc.equals(other$problemDesc);
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
      return other instanceof ProjectCargoListProductDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $linkId = this.getLinkId();
      result = result * 59 + ($linkId == null ? 43 : $linkId.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $monomerId = this.getMonomerId();
      result = result * 59 + ($monomerId == null ? 43 : $monomerId.hashCode());
      Object $areaId = this.getAreaId();
      result = result * 59 + ($areaId == null ? 43 : $areaId.hashCode());
      Object $boolProblemReceiving = this.getBoolProblemReceiving();
      result = result * 59 + ($boolProblemReceiving == null ? 43 : $boolProblemReceiving.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $accountingMete = this.getAccountingMete();
      result = result * 59 + ($accountingMete == null ? 43 : $accountingMete.hashCode());
      Object $problemDesc = this.getProblemDesc();
      return result * 59 + ($problemDesc == null ? 43 : $problemDesc.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectCargoListProductDTO(linkId="
         + this.getLinkId()
         + ", productId="
         + this.getProductId()
         + ", productType="
         + this.getProductType()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", quantity="
         + this.getQuantity()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", accountingMete="
         + this.getAccountingMete()
         + ", boolProblemReceiving="
         + this.getBoolProblemReceiving()
         + ", problemDesc="
         + this.getProblemDesc()
         + ")";
   }

   public ProjectCargoListProductDTO() {
   }

   public ProjectCargoListProductDTO(
      final Long linkId,
      final Long productId,
      final Integer productType,
      final String name,
      final String serialNumber,
      final String specification,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final ProjectInfo project,
      final NameInfo monomer,
      final NameInfo area,
      final BigDecimal quantity,
      final String measureUnit,
      final String accountingUnit,
      final BigDecimal accountingMete,
      final Boolean boolProblemReceiving,
      final String problemDesc
   ) {
      this.linkId = linkId;
      this.productId = productId;
      this.productType = productType;
      this.name = name;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.project = project;
      this.monomer = monomer;
      this.area = area;
      this.quantity = quantity;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.accountingMete = accountingMete;
      this.boolProblemReceiving = boolProblemReceiving;
      this.problemDesc = problemDesc;
   }

   public static class ProjectCargoListProductDTOBuilder {
      private Long linkId;
      private Long productId;
      private Integer productType;
      private String name;
      private String serialNumber;
      private String specification;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private ProjectInfo project;
      private NameInfo monomer;
      private NameInfo area;
      private BigDecimal quantity;
      private String measureUnit;
      private String accountingUnit;
      private BigDecimal accountingMete;
      private Boolean boolProblemReceiving;
      private String problemDesc;

      ProjectCargoListProductDTOBuilder() {
      }

      public ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder linkId(final Long linkId) {
         this.linkId = linkId;
         return this;
      }

      public ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder productId(final Long productId) {
         this.productId = productId;
         return this;
      }

      public ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder productType(final Integer productType) {
         this.productType = productType;
         return this;
      }

      public ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder area(final NameInfo area) {
         this.area = area;
         return this;
      }

      public ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder accountingMete(final BigDecimal accountingMete) {
         this.accountingMete = accountingMete;
         return this;
      }

      public ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder boolProblemReceiving(final Boolean boolProblemReceiving) {
         this.boolProblemReceiving = boolProblemReceiving;
         return this;
      }

      public ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder problemDesc(final String problemDesc) {
         this.problemDesc = problemDesc;
         return this;
      }

      public ProjectCargoListProductDTO build() {
         return new ProjectCargoListProductDTO(
            this.linkId,
            this.productId,
            this.productType,
            this.name,
            this.serialNumber,
            this.specification,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.project,
            this.monomer,
            this.area,
            this.quantity,
            this.measureUnit,
            this.accountingUnit,
            this.accountingMete,
            this.boolProblemReceiving,
            this.problemDesc
         );
      }

      @Override
      public String toString() {
         return "ProjectCargoListProductDTO.ProjectCargoListProductDTOBuilder(linkId="
            + this.linkId
            + ", productId="
            + this.productId
            + ", productType="
            + this.productType
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", area="
            + this.area
            + ", quantity="
            + this.quantity
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", accountingMete="
            + this.accountingMete
            + ", boolProblemReceiving="
            + this.boolProblemReceiving
            + ", problemDesc="
            + this.problemDesc
            + ")";
      }
   }
}
