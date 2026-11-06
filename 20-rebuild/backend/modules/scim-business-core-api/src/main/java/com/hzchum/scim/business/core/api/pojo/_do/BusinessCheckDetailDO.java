package com.hzchum.scim.business.core.api.pojo._do;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.hzchum.scim.common.core.api.pojo.common.NameInfo;
import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class BusinessCheckDetailDO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "project", value = "项目")
   private ProjectInfo project;
   @ApiModelProperty(name = "monomer", value = "单体")
   @JsonInclude(Include.NON_NULL)
   private NameInfo monomer;
   @ApiModelProperty(name = "type", value = "类型")
   private Integer type;
   @ApiModelProperty(name = "category", value = "品类  2压型板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   @JsonInclude(Include.NON_NULL)
   private Integer category;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "totalQuantity", value = "数量")
   private Integer totalQuantity;
   @ApiModelProperty(name = "plate", value = "板型")
   @JsonInclude(Include.NON_NULL)
   private String plate;
   @ApiModelProperty(name = "color", value = "颜色")
   @JsonInclude(Include.NON_NULL)
   private String color;
   @ApiModelProperty(name = "material", value = "材质")
   @JsonInclude(Include.NON_NULL)
   private String material;
   @ApiModelProperty(name = "thickness", value = "厚度(mm)")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal thickness;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal length;
   @ApiModelProperty("分类全称(冗余字段)")
   @JsonInclude(Include.NON_NULL)
   private String classifyFullName;
   @ApiModelProperty(name = "classifyName", value = "科目名称")
   @JsonInclude(Include.NON_NULL)
   private String classifyName;
   @ApiModelProperty("编号(冗余字段)")
   @JsonInclude(Include.NON_NULL)
   private String serialNumber;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "oldUnitPrice", value = "原有单价")
   private BigDecimal oldUnitPrice;
   @ApiModelProperty(name = "unitPrice", value = "单价")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "newUnitPrice", value = "原有单价")
   private BigDecimal newUnitPrice;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "oldPricingManner", value = "结构原有计价方式")
   private Integer oldPricingManner;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "newPricingManner", value = "结构新计价方式")
   private Integer newPricingManner;
   @ApiModelProperty(name = "totalWeight", value = "总重", notes = "总重")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "totalWeight", value = "总长", notes = "总长/米")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal totalLength;
   @ApiModelProperty(name = "brand", value = "品牌")
   private String brand;
   @ApiModelProperty(name = "totalArea", value = "总面积(m²)")
   private BigDecimal totalArea;
   @ApiModelProperty(name = "bendTimes", value = "弯折次数")
   private Integer bendTimes;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽厚度(mm)")
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地 2工厂", notes = "使用属性 1工地 2工厂")
   private Integer useProperty;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   private BigDecimal mete;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位", notes = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "measureUnit", value = "单位", notes = "单位")
   private String measureUnit;

   public static BusinessCheckDetailDO.BusinessCheckDetailDOBuilder builder() {
      return new BusinessCheckDetailDO.BusinessCheckDetailDOBuilder();
   }

   public BusinessCheckDetailDO() {
   }

   public BusinessCheckDetailDO(
      final ProjectInfo project,
      final NameInfo monomer,
      final Integer type,
      final Integer category,
      final String name,
      final Integer totalQuantity,
      final String plate,
      final String color,
      final String material,
      final BigDecimal thickness,
      final BigDecimal length,
      final String classifyFullName,
      final String classifyName,
      final String serialNumber,
      final String specification,
      final BigDecimal oldUnitPrice,
      final BigDecimal unitPrice,
      final BigDecimal newUnitPrice,
      final Integer oldPricingManner,
      final Integer newPricingManner,
      final BigDecimal totalWeight,
      final BigDecimal totalLength,
      final String brand,
      final BigDecimal totalArea,
      final Integer bendTimes,
      final BigDecimal unfoldedWidth,
      final Integer useProperty,
      final BigDecimal mete,
      final String accountingUnit,
      final String measureUnit
   ) {
      this.project = project;
      this.monomer = monomer;
      this.type = type;
      this.category = category;
      this.name = name;
      this.totalQuantity = totalQuantity;
      this.plate = plate;
      this.color = color;
      this.material = material;
      this.thickness = thickness;
      this.length = length;
      this.classifyFullName = classifyFullName;
      this.classifyName = classifyName;
      this.serialNumber = serialNumber;
      this.specification = specification;
      this.oldUnitPrice = oldUnitPrice;
      this.unitPrice = unitPrice;
      this.newUnitPrice = newUnitPrice;
      this.oldPricingManner = oldPricingManner;
      this.newPricingManner = newPricingManner;
      this.totalWeight = totalWeight;
      this.totalLength = totalLength;
      this.brand = brand;
      this.totalArea = totalArea;
      this.bendTimes = bendTimes;
      this.unfoldedWidth = unfoldedWidth;
      this.useProperty = useProperty;
      this.mete = mete;
      this.accountingUnit = accountingUnit;
      this.measureUnit = measureUnit;
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public NameInfo getMonomer() {
      return this.monomer;
   }

   public Integer getType() {
      return this.type;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getName() {
      return this.name;
   }

   public Integer getTotalQuantity() {
      return this.totalQuantity;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getColor() {
      return this.color;
   }

   public String getMaterial() {
      return this.material;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getClassifyFullName() {
      return this.classifyFullName;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getOldUnitPrice() {
      return this.oldUnitPrice;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getNewUnitPrice() {
      return this.newUnitPrice;
   }

   public Integer getOldPricingManner() {
      return this.oldPricingManner;
   }

   public Integer getNewPricingManner() {
      return this.newPricingManner;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public String getBrand() {
      return this.brand;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public Integer getBendTimes() {
      return this.bendTimes;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setMonomer(final NameInfo monomer) {
      this.monomer = monomer;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setTotalQuantity(final Integer totalQuantity) {
      this.totalQuantity = totalQuantity;
   }

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setClassifyFullName(final String classifyFullName) {
      this.classifyFullName = classifyFullName;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setOldUnitPrice(final BigDecimal oldUnitPrice) {
      this.oldUnitPrice = oldUnitPrice;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setNewUnitPrice(final BigDecimal newUnitPrice) {
      this.newUnitPrice = newUnitPrice;
   }

   public void setOldPricingManner(final Integer oldPricingManner) {
      this.oldPricingManner = oldPricingManner;
   }

   public void setNewPricingManner(final Integer newPricingManner) {
      this.newPricingManner = newPricingManner;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setBendTimes(final Integer bendTimes) {
      this.bendTimes = bendTimes;
   }

   public void setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
   }

   public void setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof BusinessCheckDetailDO)) {
         return false;
      }

      BusinessCheckDetailDO other = (BusinessCheckDetailDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$category = this.getCategory();
         Object other$category = other.getCategory();
         if (this$category == null ? other$category == null : this$category.equals(other$category)) {
            Object this$totalQuantity = this.getTotalQuantity();
            Object other$totalQuantity = other.getTotalQuantity();
            if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
               Object this$oldPricingManner = this.getOldPricingManner();
               Object other$oldPricingManner = other.getOldPricingManner();
               if (this$oldPricingManner == null ? other$oldPricingManner == null : this$oldPricingManner.equals(other$oldPricingManner)) {
                  Object this$newPricingManner = this.getNewPricingManner();
                  Object other$newPricingManner = other.getNewPricingManner();
                  if (this$newPricingManner == null ? other$newPricingManner == null : this$newPricingManner.equals(other$newPricingManner)) {
                     Object this$bendTimes = this.getBendTimes();
                     Object other$bendTimes = other.getBendTimes();
                     if (this$bendTimes == null ? other$bendTimes == null : this$bendTimes.equals(other$bendTimes)) {
                        Object this$useProperty = this.getUseProperty();
                        Object other$useProperty = other.getUseProperty();
                        if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
                           Object this$project = this.getProject();
                           Object other$project = other.getProject();
                           if (this$project == null ? other$project == null : this$project.equals(other$project)) {
                              Object this$monomer = this.getMonomer();
                              Object other$monomer = other.getMonomer();
                              if (this$monomer == null ? other$monomer == null : this$monomer.equals(other$monomer)) {
                                 Object this$name = this.getName();
                                 Object other$name = other.getName();
                                 if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                    Object this$plate = this.getPlate();
                                    Object other$plate = other.getPlate();
                                    if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                       Object this$color = this.getColor();
                                       Object other$color = other.getColor();
                                       if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                          Object this$material = this.getMaterial();
                                          Object other$material = other.getMaterial();
                                          if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                             Object this$thickness = this.getThickness();
                                             Object other$thickness = other.getThickness();
                                             if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                                Object this$length = this.getLength();
                                                Object other$length = other.getLength();
                                                if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                   Object this$classifyFullName = this.getClassifyFullName();
                                                   Object other$classifyFullName = other.getClassifyFullName();
                                                   if (this$classifyFullName == null
                                                      ? other$classifyFullName == null
                                                      : this$classifyFullName.equals(other$classifyFullName)) {
                                                      Object this$classifyName = this.getClassifyName();
                                                      Object other$classifyName = other.getClassifyName();
                                                      if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)
                                                         )
                                                       {
                                                         Object this$serialNumber = this.getSerialNumber();
                                                         Object other$serialNumber = other.getSerialNumber();
                                                         if (this$serialNumber == null
                                                            ? other$serialNumber == null
                                                            : this$serialNumber.equals(other$serialNumber)) {
                                                            Object this$specification = this.getSpecification();
                                                            Object other$specification = other.getSpecification();
                                                            if (this$specification == null
                                                               ? other$specification == null
                                                               : this$specification.equals(other$specification)) {
                                                               Object this$oldUnitPrice = this.getOldUnitPrice();
                                                               Object other$oldUnitPrice = other.getOldUnitPrice();
                                                               if (this$oldUnitPrice == null
                                                                  ? other$oldUnitPrice == null
                                                                  : this$oldUnitPrice.equals(other$oldUnitPrice)) {
                                                                  Object this$unitPrice = this.getUnitPrice();
                                                                  Object other$unitPrice = other.getUnitPrice();
                                                                  if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)
                                                                     )
                                                                   {
                                                                     Object this$newUnitPrice = this.getNewUnitPrice();
                                                                     Object other$newUnitPrice = other.getNewUnitPrice();
                                                                     if (this$newUnitPrice == null
                                                                        ? other$newUnitPrice == null
                                                                        : this$newUnitPrice.equals(other$newUnitPrice)) {
                                                                        Object this$totalWeight = this.getTotalWeight();
                                                                        Object other$totalWeight = other.getTotalWeight();
                                                                        if (this$totalWeight == null
                                                                           ? other$totalWeight == null
                                                                           : this$totalWeight.equals(other$totalWeight)) {
                                                                           Object this$totalLength = this.getTotalLength();
                                                                           Object other$totalLength = other.getTotalLength();
                                                                           if (this$totalLength == null
                                                                              ? other$totalLength == null
                                                                              : this$totalLength.equals(other$totalLength)) {
                                                                              Object this$brand = this.getBrand();
                                                                              Object other$brand = other.getBrand();
                                                                              if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                                                 Object this$totalArea = this.getTotalArea();
                                                                                 Object other$totalArea = other.getTotalArea();
                                                                                 if (this$totalArea == null
                                                                                    ? other$totalArea == null
                                                                                    : this$totalArea.equals(other$totalArea)) {
                                                                                    Object this$unfoldedWidth = this.getUnfoldedWidth();
                                                                                    Object other$unfoldedWidth = other.getUnfoldedWidth();
                                                                                    if (this$unfoldedWidth == null
                                                                                       ? other$unfoldedWidth == null
                                                                                       : this$unfoldedWidth.equals(other$unfoldedWidth)) {
                                                                                       Object this$mete = this.getMete();
                                                                                       Object other$mete = other.getMete();
                                                                                       if (this$mete == null
                                                                                          ? other$mete == null
                                                                                          : this$mete.equals(other$mete)) {
                                                                                          Object this$accountingUnit = this.getAccountingUnit();
                                                                                          Object other$accountingUnit = other.getAccountingUnit();
                                                                                          if (this$accountingUnit == null
                                                                                             ? other$accountingUnit == null
                                                                                             : this$accountingUnit.equals(other$accountingUnit)) {
                                                                                             Object this$measureUnit = this.getMeasureUnit();
                                                                                             Object other$measureUnit = other.getMeasureUnit();
                                                                                             return this$measureUnit == null
                                                                                                ? other$measureUnit == null
                                                                                                : this$measureUnit.equals(other$measureUnit);
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
      return other instanceof BusinessCheckDetailDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $oldPricingManner = this.getOldPricingManner();
      result = result * 59 + ($oldPricingManner == null ? 43 : $oldPricingManner.hashCode());
      Object $newPricingManner = this.getNewPricingManner();
      result = result * 59 + ($newPricingManner == null ? 43 : $newPricingManner.hashCode());
      Object $bendTimes = this.getBendTimes();
      result = result * 59 + ($bendTimes == null ? 43 : $bendTimes.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $monomer = this.getMonomer();
      result = result * 59 + ($monomer == null ? 43 : $monomer.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $classifyFullName = this.getClassifyFullName();
      result = result * 59 + ($classifyFullName == null ? 43 : $classifyFullName.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $oldUnitPrice = this.getOldUnitPrice();
      result = result * 59 + ($oldUnitPrice == null ? 43 : $oldUnitPrice.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $newUnitPrice = this.getNewUnitPrice();
      result = result * 59 + ($newUnitPrice == null ? 43 : $newUnitPrice.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      return result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
   }

   @Override
   public String toString() {
      return "BusinessCheckDetailDO(project="
         + this.getProject()
         + ", monomer="
         + this.getMonomer()
         + ", type="
         + this.getType()
         + ", category="
         + this.getCategory()
         + ", name="
         + this.getName()
         + ", totalQuantity="
         + this.getTotalQuantity()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", material="
         + this.getMaterial()
         + ", thickness="
         + this.getThickness()
         + ", length="
         + this.getLength()
         + ", classifyFullName="
         + this.getClassifyFullName()
         + ", classifyName="
         + this.getClassifyName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", specification="
         + this.getSpecification()
         + ", oldUnitPrice="
         + this.getOldUnitPrice()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", newUnitPrice="
         + this.getNewUnitPrice()
         + ", oldPricingManner="
         + this.getOldPricingManner()
         + ", newPricingManner="
         + this.getNewPricingManner()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", totalLength="
         + this.getTotalLength()
         + ", brand="
         + this.getBrand()
         + ", totalArea="
         + this.getTotalArea()
         + ", bendTimes="
         + this.getBendTimes()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", useProperty="
         + this.getUseProperty()
         + ", mete="
         + this.getMete()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ")";
   }

   public static class BusinessCheckDetailDOBuilder {
      private ProjectInfo project;
      private NameInfo monomer;
      private Integer type;
      private Integer category;
      private String name;
      private Integer totalQuantity;
      private String plate;
      private String color;
      private String material;
      private BigDecimal thickness;
      private BigDecimal length;
      private String classifyFullName;
      private String classifyName;
      private String serialNumber;
      private String specification;
      private BigDecimal oldUnitPrice;
      private BigDecimal unitPrice;
      private BigDecimal newUnitPrice;
      private Integer oldPricingManner;
      private Integer newPricingManner;
      private BigDecimal totalWeight;
      private BigDecimal totalLength;
      private String brand;
      private BigDecimal totalArea;
      private Integer bendTimes;
      private BigDecimal unfoldedWidth;
      private Integer useProperty;
      private BigDecimal mete;
      private String accountingUnit;
      private String measureUnit;

      BusinessCheckDetailDOBuilder() {
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder monomer(final NameInfo monomer) {
         this.monomer = monomer;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder totalQuantity(final Integer totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder classifyFullName(final String classifyFullName) {
         this.classifyFullName = classifyFullName;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder oldUnitPrice(final BigDecimal oldUnitPrice) {
         this.oldUnitPrice = oldUnitPrice;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder newUnitPrice(final BigDecimal newUnitPrice) {
         this.newUnitPrice = newUnitPrice;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder oldPricingManner(final Integer oldPricingManner) {
         this.oldPricingManner = oldPricingManner;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder newPricingManner(final Integer newPricingManner) {
         this.newPricingManner = newPricingManner;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder totalWeight(final BigDecimal totalWeight) {
         this.totalWeight = totalWeight;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder bendTimes(final Integer bendTimes) {
         this.bendTimes = bendTimes;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public BusinessCheckDetailDO.BusinessCheckDetailDOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public BusinessCheckDetailDO build() {
         return new BusinessCheckDetailDO(
            this.project,
            this.monomer,
            this.type,
            this.category,
            this.name,
            this.totalQuantity,
            this.plate,
            this.color,
            this.material,
            this.thickness,
            this.length,
            this.classifyFullName,
            this.classifyName,
            this.serialNumber,
            this.specification,
            this.oldUnitPrice,
            this.unitPrice,
            this.newUnitPrice,
            this.oldPricingManner,
            this.newPricingManner,
            this.totalWeight,
            this.totalLength,
            this.brand,
            this.totalArea,
            this.bendTimes,
            this.unfoldedWidth,
            this.useProperty,
            this.mete,
            this.accountingUnit,
            this.measureUnit
         );
      }

      @Override
      public String toString() {
         return "BusinessCheckDetailDO.BusinessCheckDetailDOBuilder(project="
            + this.project
            + ", monomer="
            + this.monomer
            + ", type="
            + this.type
            + ", category="
            + this.category
            + ", name="
            + this.name
            + ", totalQuantity="
            + this.totalQuantity
            + ", plate="
            + this.plate
            + ", color="
            + this.color
            + ", material="
            + this.material
            + ", thickness="
            + this.thickness
            + ", length="
            + this.length
            + ", classifyFullName="
            + this.classifyFullName
            + ", classifyName="
            + this.classifyName
            + ", serialNumber="
            + this.serialNumber
            + ", specification="
            + this.specification
            + ", oldUnitPrice="
            + this.oldUnitPrice
            + ", unitPrice="
            + this.unitPrice
            + ", newUnitPrice="
            + this.newUnitPrice
            + ", oldPricingManner="
            + this.oldPricingManner
            + ", newPricingManner="
            + this.newPricingManner
            + ", totalWeight="
            + this.totalWeight
            + ", totalLength="
            + this.totalLength
            + ", brand="
            + this.brand
            + ", totalArea="
            + this.totalArea
            + ", bendTimes="
            + this.bendTimes
            + ", unfoldedWidth="
            + this.unfoldedWidth
            + ", useProperty="
            + this.useProperty
            + ", mete="
            + this.mete
            + ", accountingUnit="
            + this.accountingUnit
            + ", measureUnit="
            + this.measureUnit
            + ")";
      }
   }
}
