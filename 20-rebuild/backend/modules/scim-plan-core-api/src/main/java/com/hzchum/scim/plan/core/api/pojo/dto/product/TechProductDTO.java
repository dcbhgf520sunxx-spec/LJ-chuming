package com.hzchum.scim.plan.core.api.pojo.dto.product;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel
public class TechProductDTO {
   @ApiModelProperty(name = "id", value = "主键ID")
   private Long id;
   @ApiModelProperty(name = "name", value = "名称")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   private String serialNumber;
   @ApiModelProperty(name = "projectId", value = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "monomerId", value = "单体id")
   private Long monomerId;
   @ApiModelProperty(name = "areaId", value = "区域id")
   private Long areaId;
   @ApiModelProperty(name = "enclosurePlanId", value = "围护计划id")
   private Long enclosurePlanId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "boolStatusEnum", value = "状态 0暂停1进行中")
   private Boolean boolStatusEnum;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "category", value = "围护分类 2压型彩板 4夹芯板 8桁架楼承板 16压型楼承板 32折边件")
   private Integer category;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   private BigDecimal length;
   @ApiModelProperty(name = "material", value = "材质")
   private String material;
   @ApiModelProperty(name = "quantity", value = "数量")
   private Integer quantity;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "plate", value = "版型")
   private String plate;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "color", value = "颜色")
   private String color;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "weight", value = "重量")
   private BigDecimal weight;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "thickness", value = "厚度（mm）")
   private BigDecimal thickness;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "width", value = "有效宽度(mm)")
   private BigDecimal width;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)")
   private BigDecimal unfoldedWidth;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "totalLength", value = "总长度（m）")
   private BigDecimal totalLength;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "totalArea", value = "总面积（㎡）")
   private BigDecimal totalArea;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "netWeight", value = "单净重（kg）")
   private BigDecimal netWeight;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "totalNetWeight", value = "总净重（kg）")
   private BigDecimal totalNetWeight;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "grossWeight", value = "单毛重（kg）")
   private BigDecimal grossWeight;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "totalGrossWeight", value = "总毛重（kg）")
   private BigDecimal totalGrossWeight;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "surfaceArea", value = "面积（㎡）")
   private BigDecimal surfaceArea;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "classifyFullName", value = "分类全称 ")
   private String classifyFullName;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "classifyId", value = "科目id")
   private Long classifyId;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "classifyName", value = "科目名称")
   private String classifyName;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "measureUnit", value = "计量单位")
   private String measureUnit;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "measurePrecision", value = "计量精度")
   private Integer measurePrecision;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   private String accountingUnit;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "mete", value = "核算量")
   private BigDecimal mete;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "accountingPrecision", value = "核算精度")
   private Integer accountingPrecision;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "unitNet", value = "单位净量")
   private BigDecimal unitNet;
   @JsonInclude(Include.NON_NULL)
   @ApiModelProperty(name = "brand", value = "品牌")
   private String brand;
   @ApiModelProperty(name = "useProperty", value = "使用属性 1工地使用 2工厂使用")
   private Integer useProperty;
   @ApiModelProperty(name = "businessId", value = "商务id")
   private Long businessId;
   @ApiModelProperty(name = "boolAllPartSendDirectly", value = "是否全部零件都是直发件 true 是 false 否")
   private Boolean boolAllPartSendDirectly;

   public static TechProductDTO.TechProductDTOBuilder builder() {
      return new TechProductDTO.TechProductDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
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

   public Long getEnclosurePlanId() {
      return this.enclosurePlanId;
   }

   public Boolean getBoolStatusEnum() {
      return this.boolStatusEnum;
   }

   public Integer getCategory() {
      return this.category;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getMaterial() {
      return this.material;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getPlate() {
      return this.plate;
   }

   public String getColor() {
      return this.color;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
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

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public String getClassifyFullName() {
      return this.classifyFullName;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public Integer getMeasurePrecision() {
      return this.measurePrecision;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public Integer getAccountingPrecision() {
      return this.accountingPrecision;
   }

   public BigDecimal getUnitNet() {
      return this.unitNet;
   }

   public String getBrand() {
      return this.brand;
   }

   public Integer getUseProperty() {
      return this.useProperty;
   }

   public Long getBusinessId() {
      return this.businessId;
   }

   public Boolean getBoolAllPartSendDirectly() {
      return this.boolAllPartSendDirectly;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
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

   public void setEnclosurePlanId(final Long enclosurePlanId) {
      this.enclosurePlanId = enclosurePlanId;
   }

   public void setBoolStatusEnum(final Boolean boolStatusEnum) {
      this.boolStatusEnum = boolStatusEnum;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
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

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setClassifyFullName(final String classifyFullName) {
      this.classifyFullName = classifyFullName;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setMeasurePrecision(final Integer measurePrecision) {
      this.measurePrecision = measurePrecision;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setAccountingPrecision(final Integer accountingPrecision) {
      this.accountingPrecision = accountingPrecision;
   }

   public void setUnitNet(final BigDecimal unitNet) {
      this.unitNet = unitNet;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setUseProperty(final Integer useProperty) {
      this.useProperty = useProperty;
   }

   public void setBusinessId(final Long businessId) {
      this.businessId = businessId;
   }

   public void setBoolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TechProductDTO)) {
         return false;
      }

      TechProductDTO other = (TechProductDTO)o;
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
                  Object this$enclosurePlanId = this.getEnclosurePlanId();
                  Object other$enclosurePlanId = other.getEnclosurePlanId();
                  if (this$enclosurePlanId == null ? other$enclosurePlanId == null : this$enclosurePlanId.equals(other$enclosurePlanId)) {
                     Object this$boolStatusEnum = this.getBoolStatusEnum();
                     Object other$boolStatusEnum = other.getBoolStatusEnum();
                     if (this$boolStatusEnum == null ? other$boolStatusEnum == null : this$boolStatusEnum.equals(other$boolStatusEnum)) {
                        Object this$category = this.getCategory();
                        Object other$category = other.getCategory();
                        if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$classifyId = this.getClassifyId();
                              Object other$classifyId = other.getClassifyId();
                              if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                                 Object this$measurePrecision = this.getMeasurePrecision();
                                 Object other$measurePrecision = other.getMeasurePrecision();
                                 if (this$measurePrecision == null ? other$measurePrecision == null : this$measurePrecision.equals(other$measurePrecision)) {
                                    Object this$accountingPrecision = this.getAccountingPrecision();
                                    Object other$accountingPrecision = other.getAccountingPrecision();
                                    if (this$accountingPrecision == null
                                       ? other$accountingPrecision == null
                                       : this$accountingPrecision.equals(other$accountingPrecision)) {
                                       Object this$useProperty = this.getUseProperty();
                                       Object other$useProperty = other.getUseProperty();
                                       if (this$useProperty == null ? other$useProperty == null : this$useProperty.equals(other$useProperty)) {
                                          Object this$businessId = this.getBusinessId();
                                          Object other$businessId = other.getBusinessId();
                                          if (this$businessId == null ? other$businessId == null : this$businessId.equals(other$businessId)) {
                                             Object this$boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
                                             Object other$boolAllPartSendDirectly = other.getBoolAllPartSendDirectly();
                                             if (this$boolAllPartSendDirectly == null
                                                ? other$boolAllPartSendDirectly == null
                                                : this$boolAllPartSendDirectly.equals(other$boolAllPartSendDirectly)) {
                                                Object this$name = this.getName();
                                                Object other$name = other.getName();
                                                if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                                                   Object this$serialNumber = this.getSerialNumber();
                                                   Object other$serialNumber = other.getSerialNumber();
                                                   if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                                                      Object this$specification = this.getSpecification();
                                                      Object other$specification = other.getSpecification();
                                                      if (this$specification == null
                                                         ? other$specification == null
                                                         : this$specification.equals(other$specification)) {
                                                         Object this$length = this.getLength();
                                                         Object other$length = other.getLength();
                                                         if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                            Object this$material = this.getMaterial();
                                                            Object other$material = other.getMaterial();
                                                            if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                               Object this$plate = this.getPlate();
                                                               Object other$plate = other.getPlate();
                                                               if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                                                                  Object this$color = this.getColor();
                                                                  Object other$color = other.getColor();
                                                                  if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                                     Object this$weight = this.getWeight();
                                                                     Object other$weight = other.getWeight();
                                                                     if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                                        Object this$thickness = this.getThickness();
                                                                        Object other$thickness = other.getThickness();
                                                                        if (this$thickness == null
                                                                           ? other$thickness == null
                                                                           : this$thickness.equals(other$thickness)) {
                                                                           Object this$width = this.getWidth();
                                                                           Object other$width = other.getWidth();
                                                                           if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                                                              Object this$unfoldedWidth = this.getUnfoldedWidth();
                                                                              Object other$unfoldedWidth = other.getUnfoldedWidth();
                                                                              if (this$unfoldedWidth == null
                                                                                 ? other$unfoldedWidth == null
                                                                                 : this$unfoldedWidth.equals(other$unfoldedWidth)) {
                                                                                 Object this$totalLength = this.getTotalLength();
                                                                                 Object other$totalLength = other.getTotalLength();
                                                                                 if (this$totalLength == null
                                                                                    ? other$totalLength == null
                                                                                    : this$totalLength.equals(other$totalLength)) {
                                                                                    Object this$totalArea = this.getTotalArea();
                                                                                    Object other$totalArea = other.getTotalArea();
                                                                                    if (this$totalArea == null
                                                                                       ? other$totalArea == null
                                                                                       : this$totalArea.equals(other$totalArea)) {
                                                                                       Object this$netWeight = this.getNetWeight();
                                                                                       Object other$netWeight = other.getNetWeight();
                                                                                       if (this$netWeight == null
                                                                                          ? other$netWeight == null
                                                                                          : this$netWeight.equals(other$netWeight)) {
                                                                                          Object this$totalNetWeight = this.getTotalNetWeight();
                                                                                          Object other$totalNetWeight = other.getTotalNetWeight();
                                                                                          if (this$totalNetWeight == null
                                                                                             ? other$totalNetWeight == null
                                                                                             : this$totalNetWeight.equals(other$totalNetWeight)) {
                                                                                             Object this$grossWeight = this.getGrossWeight();
                                                                                             Object other$grossWeight = other.getGrossWeight();
                                                                                             if (this$grossWeight == null
                                                                                                ? other$grossWeight == null
                                                                                                : this$grossWeight.equals(other$grossWeight)) {
                                                                                                Object this$totalGrossWeight = this.getTotalGrossWeight();
                                                                                                Object other$totalGrossWeight = other.getTotalGrossWeight();
                                                                                                if (this$totalGrossWeight == null
                                                                                                   ? other$totalGrossWeight == null
                                                                                                   : this$totalGrossWeight.equals(other$totalGrossWeight)) {
                                                                                                   Object this$surfaceArea = this.getSurfaceArea();
                                                                                                   Object other$surfaceArea = other.getSurfaceArea();
                                                                                                   if (this$surfaceArea == null
                                                                                                      ? other$surfaceArea == null
                                                                                                      : this$surfaceArea.equals(other$surfaceArea)) {
                                                                                                      Object this$classifyFullName = this.getClassifyFullName();
                                                                                                      Object other$classifyFullName = other.getClassifyFullName();
                                                                                                      if (this$classifyFullName == null
                                                                                                         ? other$classifyFullName == null
                                                                                                         : this$classifyFullName.equals(other$classifyFullName)
                                                                                                         )
                                                                                                       {
                                                                                                         Object this$classifyName = this.getClassifyName();
                                                                                                         Object other$classifyName = other.getClassifyName();
                                                                                                         if (this$classifyName == null
                                                                                                            ? other$classifyName == null
                                                                                                            : this$classifyName.equals(other$classifyName)) {
                                                                                                            Object this$measureUnit = this.getMeasureUnit();
                                                                                                            Object other$measureUnit = other.getMeasureUnit();
                                                                                                            if (this$measureUnit == null
                                                                                                               ? other$measureUnit == null
                                                                                                               : this$measureUnit.equals(other$measureUnit)) {
                                                                                                               Object this$accountingUnit = this.getAccountingUnit();
                                                                                                               Object other$accountingUnit = other.getAccountingUnit();
                                                                                                               if (this$accountingUnit == null
                                                                                                                  ? other$accountingUnit == null
                                                                                                                  : this$accountingUnit.equals(
                                                                                                                     other$accountingUnit
                                                                                                                  )) {
                                                                                                                  Object this$mete = this.getMete();
                                                                                                                  Object other$mete = other.getMete();
                                                                                                                  if (this$mete == null
                                                                                                                     ? other$mete == null
                                                                                                                     : this$mete.equals(other$mete)) {
                                                                                                                     Object this$unitNet = this.getUnitNet();
                                                                                                                     Object other$unitNet = other.getUnitNet();
                                                                                                                     if (this$unitNet == null
                                                                                                                        ? other$unitNet == null
                                                                                                                        : this$unitNet.equals(other$unitNet)) {
                                                                                                                        Object this$brand = this.getBrand();
                                                                                                                        Object other$brand = other.getBrand();
                                                                                                                        return this$brand == null
                                                                                                                           ? other$brand == null
                                                                                                                           : this$brand.equals(other$brand);
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
      return other instanceof TechProductDTO;
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
      Object $enclosurePlanId = this.getEnclosurePlanId();
      result = result * 59 + ($enclosurePlanId == null ? 43 : $enclosurePlanId.hashCode());
      Object $boolStatusEnum = this.getBoolStatusEnum();
      result = result * 59 + ($boolStatusEnum == null ? 43 : $boolStatusEnum.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $measurePrecision = this.getMeasurePrecision();
      result = result * 59 + ($measurePrecision == null ? 43 : $measurePrecision.hashCode());
      Object $accountingPrecision = this.getAccountingPrecision();
      result = result * 59 + ($accountingPrecision == null ? 43 : $accountingPrecision.hashCode());
      Object $useProperty = this.getUseProperty();
      result = result * 59 + ($useProperty == null ? 43 : $useProperty.hashCode());
      Object $businessId = this.getBusinessId();
      result = result * 59 + ($businessId == null ? 43 : $businessId.hashCode());
      Object $boolAllPartSendDirectly = this.getBoolAllPartSendDirectly();
      result = result * 59 + ($boolAllPartSendDirectly == null ? 43 : $boolAllPartSendDirectly.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $netWeight = this.getNetWeight();
      result = result * 59 + ($netWeight == null ? 43 : $netWeight.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      result = result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
      Object $grossWeight = this.getGrossWeight();
      result = result * 59 + ($grossWeight == null ? 43 : $grossWeight.hashCode());
      Object $totalGrossWeight = this.getTotalGrossWeight();
      result = result * 59 + ($totalGrossWeight == null ? 43 : $totalGrossWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $classifyFullName = this.getClassifyFullName();
      result = result * 59 + ($classifyFullName == null ? 43 : $classifyFullName.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitNet = this.getUnitNet();
      result = result * 59 + ($unitNet == null ? 43 : $unitNet.hashCode());
      Object $brand = this.getBrand();
      return result * 59 + ($brand == null ? 43 : $brand.hashCode());
   }

   @Override
   public String toString() {
      return "TechProductDTO(id="
         + this.getId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", projectId="
         + this.getProjectId()
         + ", monomerId="
         + this.getMonomerId()
         + ", areaId="
         + this.getAreaId()
         + ", enclosurePlanId="
         + this.getEnclosurePlanId()
         + ", boolStatusEnum="
         + this.getBoolStatusEnum()
         + ", category="
         + this.getCategory()
         + ", specification="
         + this.getSpecification()
         + ", length="
         + this.getLength()
         + ", material="
         + this.getMaterial()
         + ", quantity="
         + this.getQuantity()
         + ", plate="
         + this.getPlate()
         + ", color="
         + this.getColor()
         + ", weight="
         + this.getWeight()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", netWeight="
         + this.getNetWeight()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ", grossWeight="
         + this.getGrossWeight()
         + ", totalGrossWeight="
         + this.getTotalGrossWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", classifyFullName="
         + this.getClassifyFullName()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", measurePrecision="
         + this.getMeasurePrecision()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", accountingPrecision="
         + this.getAccountingPrecision()
         + ", unitNet="
         + this.getUnitNet()
         + ", brand="
         + this.getBrand()
         + ", useProperty="
         + this.getUseProperty()
         + ", businessId="
         + this.getBusinessId()
         + ", boolAllPartSendDirectly="
         + this.getBoolAllPartSendDirectly()
         + ")";
   }

   public TechProductDTO(
      final Long id,
      final String name,
      final String serialNumber,
      final Long projectId,
      final Long monomerId,
      final Long areaId,
      final Long enclosurePlanId,
      final Boolean boolStatusEnum,
      final Integer category,
      final String specification,
      final BigDecimal length,
      final String material,
      final Integer quantity,
      final String plate,
      final String color,
      final BigDecimal weight,
      final BigDecimal thickness,
      final BigDecimal width,
      final BigDecimal unfoldedWidth,
      final BigDecimal totalLength,
      final BigDecimal totalArea,
      final BigDecimal netWeight,
      final BigDecimal totalNetWeight,
      final BigDecimal grossWeight,
      final BigDecimal totalGrossWeight,
      final BigDecimal surfaceArea,
      final String classifyFullName,
      final Long classifyId,
      final String classifyName,
      final String measureUnit,
      final Integer measurePrecision,
      final String accountingUnit,
      final BigDecimal mete,
      final Integer accountingPrecision,
      final BigDecimal unitNet,
      final String brand,
      final Integer useProperty,
      final Long businessId,
      final Boolean boolAllPartSendDirectly
   ) {
      this.id = id;
      this.name = name;
      this.serialNumber = serialNumber;
      this.projectId = projectId;
      this.monomerId = monomerId;
      this.areaId = areaId;
      this.enclosurePlanId = enclosurePlanId;
      this.boolStatusEnum = boolStatusEnum;
      this.category = category;
      this.specification = specification;
      this.length = length;
      this.material = material;
      this.quantity = quantity;
      this.plate = plate;
      this.color = color;
      this.weight = weight;
      this.thickness = thickness;
      this.width = width;
      this.unfoldedWidth = unfoldedWidth;
      this.totalLength = totalLength;
      this.totalArea = totalArea;
      this.netWeight = netWeight;
      this.totalNetWeight = totalNetWeight;
      this.grossWeight = grossWeight;
      this.totalGrossWeight = totalGrossWeight;
      this.surfaceArea = surfaceArea;
      this.classifyFullName = classifyFullName;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.measureUnit = measureUnit;
      this.measurePrecision = measurePrecision;
      this.accountingUnit = accountingUnit;
      this.mete = mete;
      this.accountingPrecision = accountingPrecision;
      this.unitNet = unitNet;
      this.brand = brand;
      this.useProperty = useProperty;
      this.businessId = businessId;
      this.boolAllPartSendDirectly = boolAllPartSendDirectly;
   }

   public TechProductDTO() {
   }

   public static class TechProductDTOBuilder {
      private Long id;
      private String name;
      private String serialNumber;
      private Long projectId;
      private Long monomerId;
      private Long areaId;
      private Long enclosurePlanId;
      private Boolean boolStatusEnum;
      private Integer category;
      private String specification;
      private BigDecimal length;
      private String material;
      private Integer quantity;
      private String plate;
      private String color;
      private BigDecimal weight;
      private BigDecimal thickness;
      private BigDecimal width;
      private BigDecimal unfoldedWidth;
      private BigDecimal totalLength;
      private BigDecimal totalArea;
      private BigDecimal netWeight;
      private BigDecimal totalNetWeight;
      private BigDecimal grossWeight;
      private BigDecimal totalGrossWeight;
      private BigDecimal surfaceArea;
      private String classifyFullName;
      private Long classifyId;
      private String classifyName;
      private String measureUnit;
      private Integer measurePrecision;
      private String accountingUnit;
      private BigDecimal mete;
      private Integer accountingPrecision;
      private BigDecimal unitNet;
      private String brand;
      private Integer useProperty;
      private Long businessId;
      private Boolean boolAllPartSendDirectly;

      TechProductDTOBuilder() {
      }

      public TechProductDTO.TechProductDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder name(final String name) {
         this.name = name;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder monomerId(final Long monomerId) {
         this.monomerId = monomerId;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder areaId(final Long areaId) {
         this.areaId = areaId;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder enclosurePlanId(final Long enclosurePlanId) {
         this.enclosurePlanId = enclosurePlanId;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder boolStatusEnum(final Boolean boolStatusEnum) {
         this.boolStatusEnum = boolStatusEnum;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder category(final Integer category) {
         this.category = category;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder material(final String material) {
         this.material = material;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder plate(final String plate) {
         this.plate = plate;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder weight(final BigDecimal weight) {
         this.weight = weight;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder unfoldedWidth(final BigDecimal unfoldedWidth) {
         this.unfoldedWidth = unfoldedWidth;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder totalLength(final BigDecimal totalLength) {
         this.totalLength = totalLength;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder totalArea(final BigDecimal totalArea) {
         this.totalArea = totalArea;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder netWeight(final BigDecimal netWeight) {
         this.netWeight = netWeight;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder grossWeight(final BigDecimal grossWeight) {
         this.grossWeight = grossWeight;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder totalGrossWeight(final BigDecimal totalGrossWeight) {
         this.totalGrossWeight = totalGrossWeight;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder surfaceArea(final BigDecimal surfaceArea) {
         this.surfaceArea = surfaceArea;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder classifyFullName(final String classifyFullName) {
         this.classifyFullName = classifyFullName;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder measurePrecision(final Integer measurePrecision) {
         this.measurePrecision = measurePrecision;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder accountingPrecision(final Integer accountingPrecision) {
         this.accountingPrecision = accountingPrecision;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder unitNet(final BigDecimal unitNet) {
         this.unitNet = unitNet;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder useProperty(final Integer useProperty) {
         this.useProperty = useProperty;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder businessId(final Long businessId) {
         this.businessId = businessId;
         return this;
      }

      public TechProductDTO.TechProductDTOBuilder boolAllPartSendDirectly(final Boolean boolAllPartSendDirectly) {
         this.boolAllPartSendDirectly = boolAllPartSendDirectly;
         return this;
      }

      public TechProductDTO build() {
         return new TechProductDTO(
            this.id,
            this.name,
            this.serialNumber,
            this.projectId,
            this.monomerId,
            this.areaId,
            this.enclosurePlanId,
            this.boolStatusEnum,
            this.category,
            this.specification,
            this.length,
            this.material,
            this.quantity,
            this.plate,
            this.color,
            this.weight,
            this.thickness,
            this.width,
            this.unfoldedWidth,
            this.totalLength,
            this.totalArea,
            this.netWeight,
            this.totalNetWeight,
            this.grossWeight,
            this.totalGrossWeight,
            this.surfaceArea,
            this.classifyFullName,
            this.classifyId,
            this.classifyName,
            this.measureUnit,
            this.measurePrecision,
            this.accountingUnit,
            this.mete,
            this.accountingPrecision,
            this.unitNet,
            this.brand,
            this.useProperty,
            this.businessId,
            this.boolAllPartSendDirectly
         );
      }

      @Override
      public String toString() {
         return "TechProductDTO.TechProductDTOBuilder(id="
            + this.id
            + ", name="
            + this.name
            + ", serialNumber="
            + this.serialNumber
            + ", projectId="
            + this.projectId
            + ", monomerId="
            + this.monomerId
            + ", areaId="
            + this.areaId
            + ", enclosurePlanId="
            + this.enclosurePlanId
            + ", boolStatusEnum="
            + this.boolStatusEnum
            + ", category="
            + this.category
            + ", specification="
            + this.specification
            + ", length="
            + this.length
            + ", material="
            + this.material
            + ", quantity="
            + this.quantity
            + ", plate="
            + this.plate
            + ", color="
            + this.color
            + ", weight="
            + this.weight
            + ", thickness="
            + this.thickness
            + ", width="
            + this.width
            + ", unfoldedWidth="
            + this.unfoldedWidth
            + ", totalLength="
            + this.totalLength
            + ", totalArea="
            + this.totalArea
            + ", netWeight="
            + this.netWeight
            + ", totalNetWeight="
            + this.totalNetWeight
            + ", grossWeight="
            + this.grossWeight
            + ", totalGrossWeight="
            + this.totalGrossWeight
            + ", surfaceArea="
            + this.surfaceArea
            + ", classifyFullName="
            + this.classifyFullName
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", measureUnit="
            + this.measureUnit
            + ", measurePrecision="
            + this.measurePrecision
            + ", accountingUnit="
            + this.accountingUnit
            + ", mete="
            + this.mete
            + ", accountingPrecision="
            + this.accountingPrecision
            + ", unitNet="
            + this.unitNet
            + ", brand="
            + this.brand
            + ", useProperty="
            + this.useProperty
            + ", businessId="
            + this.businessId
            + ", boolAllPartSendDirectly="
            + this.boolAllPartSendDirectly
            + ")";
      }
   }
}
