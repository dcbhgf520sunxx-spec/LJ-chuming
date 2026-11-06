package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "计划管理-项目执行动态-产品明细DTO类")
public class ProjectExecutionDynamicsDetailProductDTO {
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("项目编号")
   private String projectSerialNumber;
   @ApiModelProperty("项目简称")
   private String projectShortName;
   @ApiModelProperty("单体ID")
   private Long monomerId;
   @ApiModelProperty("单体名称")
   private String monomerName;
   @ApiModelProperty("区域ID")
   private Long areaId;
   @ApiModelProperty("区域名称")
   private String areaName;
   @ApiModelProperty("产品ID")
   private Long productId;
   @ApiModelProperty("产品名称")
   private String productName;
   @ApiModelProperty("产品编号")
   private String productSerialNumber;
   @ApiModelProperty("产品规格")
   private String productSpecification;
   @ApiModelProperty("产品长度(mm)")
   private BigDecimal productLength;
   @ApiModelProperty("产品材质")
   private String productMaterial;
   @ApiModelProperty("数量")
   private BigDecimal quantity;
   @ApiModelProperty("产品单净重")
   private BigDecimal productNetWeight;
   @ApiModelProperty("产品总净重")
   private BigDecimal productTotalNetWeight;
   @ApiModelProperty("产品导入日期")
   private String importDate;

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectSerialNumber() {
      return this.projectSerialNumber;
   }

   public String getProjectShortName() {
      return this.projectShortName;
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

   public Long getProductId() {
      return this.productId;
   }

   public String getProductName() {
      return this.productName;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public String getProductSpecification() {
      return this.productSpecification;
   }

   public BigDecimal getProductLength() {
      return this.productLength;
   }

   public String getProductMaterial() {
      return this.productMaterial;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getProductNetWeight() {
      return this.productNetWeight;
   }

   public BigDecimal getProductTotalNetWeight() {
      return this.productTotalNetWeight;
   }

   public String getImportDate() {
      return this.importDate;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectSerialNumber(final String projectSerialNumber) {
      this.projectSerialNumber = projectSerialNumber;
   }

   public void setProjectShortName(final String projectShortName) {
      this.projectShortName = projectShortName;
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

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setProductName(final String productName) {
      this.productName = productName;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   public void setProductSpecification(final String productSpecification) {
      this.productSpecification = productSpecification;
   }

   public void setProductLength(final BigDecimal productLength) {
      this.productLength = productLength;
   }

   public void setProductMaterial(final String productMaterial) {
      this.productMaterial = productMaterial;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setProductNetWeight(final BigDecimal productNetWeight) {
      this.productNetWeight = productNetWeight;
   }

   public void setProductTotalNetWeight(final BigDecimal productTotalNetWeight) {
      this.productTotalNetWeight = productTotalNetWeight;
   }

   public void setImportDate(final String importDate) {
      this.importDate = importDate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectExecutionDynamicsDetailProductDTO)) {
         return false;
      }

      ProjectExecutionDynamicsDetailProductDTO other = (ProjectExecutionDynamicsDetailProductDTO)o;
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
               Object this$productId = this.getProductId();
               Object other$productId = other.getProductId();
               if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
                  Object this$projectSerialNumber = this.getProjectSerialNumber();
                  Object other$projectSerialNumber = other.getProjectSerialNumber();
                  if (this$projectSerialNumber == null ? other$projectSerialNumber == null : this$projectSerialNumber.equals(other$projectSerialNumber)) {
                     Object this$projectShortName = this.getProjectShortName();
                     Object other$projectShortName = other.getProjectShortName();
                     if (this$projectShortName == null ? other$projectShortName == null : this$projectShortName.equals(other$projectShortName)) {
                        Object this$monomerName = this.getMonomerName();
                        Object other$monomerName = other.getMonomerName();
                        if (this$monomerName == null ? other$monomerName == null : this$monomerName.equals(other$monomerName)) {
                           Object this$areaName = this.getAreaName();
                           Object other$areaName = other.getAreaName();
                           if (this$areaName == null ? other$areaName == null : this$areaName.equals(other$areaName)) {
                              Object this$productName = this.getProductName();
                              Object other$productName = other.getProductName();
                              if (this$productName == null ? other$productName == null : this$productName.equals(other$productName)) {
                                 Object this$productSerialNumber = this.getProductSerialNumber();
                                 Object other$productSerialNumber = other.getProductSerialNumber();
                                 if (this$productSerialNumber == null
                                    ? other$productSerialNumber == null
                                    : this$productSerialNumber.equals(other$productSerialNumber)) {
                                    Object this$productSpecification = this.getProductSpecification();
                                    Object other$productSpecification = other.getProductSpecification();
                                    if (this$productSpecification == null
                                       ? other$productSpecification == null
                                       : this$productSpecification.equals(other$productSpecification)) {
                                       Object this$productLength = this.getProductLength();
                                       Object other$productLength = other.getProductLength();
                                       if (this$productLength == null ? other$productLength == null : this$productLength.equals(other$productLength)) {
                                          Object this$productMaterial = this.getProductMaterial();
                                          Object other$productMaterial = other.getProductMaterial();
                                          if (this$productMaterial == null ? other$productMaterial == null : this$productMaterial.equals(other$productMaterial)
                                             )
                                           {
                                             Object this$quantity = this.getQuantity();
                                             Object other$quantity = other.getQuantity();
                                             if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                                Object this$productNetWeight = this.getProductNetWeight();
                                                Object other$productNetWeight = other.getProductNetWeight();
                                                if (this$productNetWeight == null
                                                   ? other$productNetWeight == null
                                                   : this$productNetWeight.equals(other$productNetWeight)) {
                                                   Object this$productTotalNetWeight = this.getProductTotalNetWeight();
                                                   Object other$productTotalNetWeight = other.getProductTotalNetWeight();
                                                   if (this$productTotalNetWeight == null
                                                      ? other$productTotalNetWeight == null
                                                      : this$productTotalNetWeight.equals(other$productTotalNetWeight)) {
                                                      Object this$importDate = this.getImportDate();
                                                      Object other$importDate = other.getImportDate();
                                                      return this$importDate == null ? other$importDate == null : this$importDate.equals(other$importDate);
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
      return other instanceof ProjectExecutionDynamicsDetailProductDTO;
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
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $projectSerialNumber = this.getProjectSerialNumber();
      result = result * 59 + ($projectSerialNumber == null ? 43 : $projectSerialNumber.hashCode());
      Object $projectShortName = this.getProjectShortName();
      result = result * 59 + ($projectShortName == null ? 43 : $projectShortName.hashCode());
      Object $monomerName = this.getMonomerName();
      result = result * 59 + ($monomerName == null ? 43 : $monomerName.hashCode());
      Object $areaName = this.getAreaName();
      result = result * 59 + ($areaName == null ? 43 : $areaName.hashCode());
      Object $productName = this.getProductName();
      result = result * 59 + ($productName == null ? 43 : $productName.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      result = result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
      Object $productSpecification = this.getProductSpecification();
      result = result * 59 + ($productSpecification == null ? 43 : $productSpecification.hashCode());
      Object $productLength = this.getProductLength();
      result = result * 59 + ($productLength == null ? 43 : $productLength.hashCode());
      Object $productMaterial = this.getProductMaterial();
      result = result * 59 + ($productMaterial == null ? 43 : $productMaterial.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $productNetWeight = this.getProductNetWeight();
      result = result * 59 + ($productNetWeight == null ? 43 : $productNetWeight.hashCode());
      Object $productTotalNetWeight = this.getProductTotalNetWeight();
      result = result * 59 + ($productTotalNetWeight == null ? 43 : $productTotalNetWeight.hashCode());
      Object $importDate = this.getImportDate();
      return result * 59 + ($importDate == null ? 43 : $importDate.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectExecutionDynamicsDetailProductDTO(projectId="
         + this.getProjectId()
         + ", projectSerialNumber="
         + this.getProjectSerialNumber()
         + ", projectShortName="
         + this.getProjectShortName()
         + ", monomerId="
         + this.getMonomerId()
         + ", monomerName="
         + this.getMonomerName()
         + ", areaId="
         + this.getAreaId()
         + ", areaName="
         + this.getAreaName()
         + ", productId="
         + this.getProductId()
         + ", productName="
         + this.getProductName()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ", productSpecification="
         + this.getProductSpecification()
         + ", productLength="
         + this.getProductLength()
         + ", productMaterial="
         + this.getProductMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", productNetWeight="
         + this.getProductNetWeight()
         + ", productTotalNetWeight="
         + this.getProductTotalNetWeight()
         + ", importDate="
         + this.getImportDate()
         + ")";
   }
}
