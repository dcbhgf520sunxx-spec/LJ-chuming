package com.hzchum.scim.business.core.api.pojo.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class BusinessBriceProductDTO {
   @ApiModelProperty(notes = "项目")
   @JsonInclude(Include.NON_NULL)
   private ProjectInfo project;
   @ApiModelProperty(notes = "单体")
   @JsonInclude(Include.NON_NULL)
   private NameInfo monomer;
   @ApiModelProperty(notes = "区域")
   @JsonInclude(Include.NON_NULL)
   private NameInfo area;
   @ApiModelProperty("产品类型")
   private Integer productType;
   @ApiModelProperty("产品id")
   private Long productId;
   @ApiModelProperty("围护分类")
   @JsonInclude(Include.NON_NULL)
   private Integer category;
   @ApiModelProperty("围护类型名称")
   @JsonInclude(Include.NON_NULL)
   private String enclosureType;
   @ApiModelProperty("名称")
   private String name;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("规格")
   private String specification;
   @ApiModelProperty("材质")
   @JsonInclude(Include.NON_NULL)
   private String material;
   @ApiModelProperty("配套件使用范围 1工地使用 2工厂使用")
   @JsonInclude(Include.NON_NULL)
   private Integer useProperty;
   @ApiModelProperty("数量")
   private Integer quantity;
   @ApiModelProperty("单净重（kg）")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal netWeight;
   @ApiModelProperty("总净重（kg）")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalNetWeight;
   @ApiModelProperty("单毛重（kg）")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal grossWeight;
   @ApiModelProperty("总毛重（kg）")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalGrossWeight;
   @ApiModelProperty(name = "drawingWeight", value = "单图纸重量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal drawingWeight;
   @ApiModelProperty(name = "drawingTotalWeight", value = "总图纸重量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal drawingTotalWeight;
   @ApiModelProperty("长度(mm)")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal length;
   @ApiModelProperty(name = "totalLength", value = "总长度(m)")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalLength;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "width", value = "有效宽度（mm）")
   private BigDecimal width;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)")
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "surfaceArea", value = "单面积(m²)")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "totalArea", value = "总面积(m²)")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalArea;
   @ApiModelProperty(name = "weight", value = "单重(kg)")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal weight;
   @ApiModelProperty(name = "totalWeight", value = "总重(kg)")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "measureUnit", value = "计量单位", notes = "计量单位")
   @JsonInclude(Include.NON_NULL)
   private String measureUnit;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   @JsonInclude(Include.NON_NULL)
   private String accountingUnit;

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
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

   public Integer getCategory() {
      return this.category;
   }

   public String getEnclosureType() {
      return this.enclosureType;
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

   public String getMaterial() {
      return this.material;
   }

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getNetWeight() {
      return this.netWeight;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public BigDecimal getGrossWeight() {
      return this.grossWeight;
   }

   public BigDecimal getTotalGrossWeight() {
      return this.totalGrossWeight;
   }

   public BigDecimal getDrawingWeight() {
      return this.drawingWeight;
   }

   public BigDecimal getDrawingTotalWeight() {
      return this.drawingTotalWeight;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
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

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setProductId(final Long productId) {
      this.productId = productId;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setEnclosureType(final String enclosureType) {
      this.enclosureType = enclosureType;
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

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setNetWeight(final BigDecimal netWeight) {
      this.netWeight = netWeight;
   }

   public void setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
   }

   public void setGrossWeight(final BigDecimal grossWeight) {
      this.grossWeight = grossWeight;
   }

   public void setTotalGrossWeight(final BigDecimal totalGrossWeight) {
      this.totalGrossWeight = totalGrossWeight;
   }

   public void setDrawingWeight(final BigDecimal drawingWeight) {
      this.drawingWeight = drawingWeight;
   }

   public void setDrawingTotalWeight(final BigDecimal drawingTotalWeight) {
      this.drawingTotalWeight = drawingTotalWeight;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessBriceProductDTO)) {
         return false;
      }

      BusinessBriceProductDTO other = (BusinessBriceProductDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productType = this.getProductType();
      Object other$productType = other.getProductType();
      if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
         Object this$productId = this.getProductId();
         Object other$productId = other.getProductId();
         if (this$productId == null ? other$productId == null : this$productId.equals(other$productId)) {
            Object this$category = this.getCategory();
            Object other$category = other.getCategory();
            if (this$category == null ? other$category == null : this$category.equals(other$category)) {
               Object this$useProperty = this.getUseProperty();
               Object other$useProperty = other.getUseProperty();
               if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$project = this.getProject();
                     Object other$project = other.getProject();
                     if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                        Object this$monomer = this.getMonomer();
                        Object other$monomer = other.getMonomer();
                        if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                           Object this$area = this.getArea();
                           Object other$area = other.getArea();
                           if (this$area == null ? other$area == null : this$area.equals(other$area)) {
                              Object this$enclosureType = this.getEnclosureType();
                              Object other$enclosureType = other.getEnclosureType();
                              if (this$enclosureType == null ? other$enclosureType == null : this$enclosureType.equals(other$enclosureType)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$serialNumber = this.getSerialNumber();
                                    Object other$serialNumber = other.getSerialNumber();
                                    if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                       Object this$specification = this.getSpecification();
                                       Object other$specification = other.getSpecification();
                                       if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                          Object this$material = this.getMaterial();
                                          Object other$material = other.getMaterial();
                                          if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                             Object this$netWeight = this.getNetWeight();
                                             Object other$netWeight = other.getNetWeight();
                                             if (this$netWeight == null ? other$netWeight == null : this$netWeight.equals(other$netWeight)) {
                                                Object this$totalNetWeight = this.getTotalNetWeight();
                                                Object other$totalNetWeight = other.getTotalNetWeight();
                                                if (this$totalNetWeight == null
                                                   ? other$totalNetWeight == null
                                                   : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                   Object this$grossWeight = this.getGrossWeight();
                                                   Object other$grossWeight = other.getGrossWeight();
                                                   if (this$grossWeight == null ? other$grossWeight == null : this$grossWeight.equals(other$grossWeight)) {
                                                      Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                      Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                      if (this$totalGrossWeight == null
                                                         ? other$totalGrossWeight == null
                                                         : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                         Object this$drawingWeight = this.getDrawingWeight();
                                                         Object other$drawingWeight = other.getDrawingWeight();
                                                         if (this$drawingWeight == null
                                                            ? other$drawingWeight == null
                                                            : this$drawingWeight.equals(other$drawingWeight)) {
                                                            Object this$drawingTotalWeight = this.getDrawingTotalWeight();
                                                            Object other$drawingTotalWeight = other.getDrawingTotalWeight();
                                                            if (this$drawingTotalWeight == null
                                                               ? other$drawingTotalWeight == null
                                                               : this$drawingTotalWeight.equals(other$drawingTotalWeight)) {
                                                               Object this$length = this.getLength();
                                                               Object other$length = other.getLength();
                                                               if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                                  Object this$totalLength = this.getTotalLength();
                                                                  Object other$totalLength = other.getTotalLength();
                                                                  if (this$totalLength == null
                                                                     ? other$totalLength == null
                                                                     : this$totalLength.equals(other$totalLength)) {
                                                                     Object this$width = this.getWidth();
                                                                     Object other$width = other.getWidth();
                                                                     if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                        Object this$unfoldedWidth = this.getUnfoldedWidth();
                                                                        Object other$unfoldedWidth = other.getUnfoldedWidth();
                                                                        if (this$unfoldedWidth == null
                                                                           ? other$unfoldedWidth == null
                                                                           : this$unfoldedWidth.equals(other$unfoldedWidth)) {
                                                                           Object this$surfaceArea = this.getSurfaceArea();
                                                                           Object other$surfaceArea = other.getSurfaceArea();
                                                                           if (this$surfaceArea == null
                                                                              ? other$surfaceArea == null
                                                                              : this$surfaceArea.equals(other$surfaceArea)) {
                                                                              Object this$totalArea = this.getTotalArea();
                                                                              Object other$totalArea = other.getTotalArea();
                                                                              if (this$totalArea == null
                                                                                 ? other$totalArea == null
                                                                                 : this$totalArea.equals(other$totalArea)) {
                                                                                 Object this$weight = this.getWeight();
                                                                                 Object other$weight = other.getWeight();
                                                                                 if (this$weight == null
                                                                                    ? other$weight == null
                                                                                    : this$weight.equals(other$weight)) {
                                                                                    Object this$totalWeight = this.getTotalWeight();
                                                                                    Object other$totalWeight = other.getTotalWeight();
                                                                                    if (this$totalWeight == null
                                                                                       ? other$totalWeight == null
                                                                                       : this$totalWeight.equals(other$totalWeight)) {
                                                                                       Object this$measureUnit = this.getMeasureUnit();
                                                                                       Object other$measureUnit = other.getMeasureUnit();
                                                                                       if (this$measureUnit == null
                                                                                          ? other$measureUnit == null
                                                                                          : this$measureUnit.equals(other$measureUnit)) {
                                                                                          Object this$mete = this.getMete();
                                                                                          Object other$mete = other.getMete();
                                                                                          if (this$mete == null
                                                                                             ? other$mete == null
                                                                                             : this$mete.equals(other$mete)) {
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
      return other instanceof BusinessBriceProductDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $productId = this.getProductId();
      result = result * 59 + ($productId == null ? 43 : $productId.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $area = this.getArea();
      result = result * 59 + ($area == null ? 43 : $area.hashCode());
      Object $enclosureType = this.getEnclosureType();
      result = result * 59 + ($enclosureType == null ? 43 : $enclosureType.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $drawingWeight = this.getDrawingWeight();
      result = result * 59 + ($drawingWeight == null ? 43 : $drawingWeight.hashCode());
      Object $drawingTotalWeight = this.getDrawingTotalWeight();
      result = result * 59 + ($drawingTotalWeight == null ? 43 : $drawingTotalWeight.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      return result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessBriceProductDTO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", area="
         + this.getArea()
         + ", productType="
         + this.getProductType()
         + ", productId="
         + this.getProductId()
         + ", category="
         + this.getCategory()
         + ", enclosureType="
         + this.getEnclosureType()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", material="
         + this.getMaterial()
         + ", useProperty="
         + this.getUseProperty()
         + ", quantity="
         + this.getQuantity()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", drawingWeight="
         + this.getDrawingWeight()
         + ", drawingTotalWeight="
         + this.getDrawingTotalWeight()
         + ", length="
         + this.getLength()
         + ", totalLength="
         + this.getTotalLength()
         + ", width="
         + this.getWidth()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalArea="
         + this.getTotalArea()
         + ", weight="
         + this.getWeight()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ")";
   }
}
