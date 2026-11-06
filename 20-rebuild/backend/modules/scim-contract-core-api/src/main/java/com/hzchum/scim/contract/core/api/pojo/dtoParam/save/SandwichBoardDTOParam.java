package com.hzchum.scim.contract.core.api.pojo.dtoParam.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("夹芯板 新增类")
public class SandwichBoardDTOParam {
   private String id;
   @ApiModelProperty(name = "thickness", notes = "厚度(mm)")
   private BigDecimal thickness;
   @ApiModelProperty(name = "plateType", notes = "版型")
   private String plateType;
   @ApiModelProperty(name = "effectiveWidth", notes = "有效宽度(mm)")
   private BigDecimal effectiveWidth;
   @ApiModelProperty(name = "quantity", notes = "数量(m)")
   private BigDecimal quantity;
   @ApiModelProperty(name = "intCoating", notes = "内板钢板涂层")
   private String intCoating;
   @ApiModelProperty(name = "intColour", notes = "内板钢板颜色")
   private String intColour;
   @ApiModelProperty(name = "intEffectiveWidth", notes = "内板钢板宽度(mm)")
   private BigDecimal intEffectiveWidth;
   @ApiModelProperty(name = "intMaterial", notes = "内板钢板材质")
   private String intMaterial;
   @ApiModelProperty(name = "intPlateShape", notes = "内板钢板形状")
   private String intPlateShape;
   @ApiModelProperty(name = "intPlating", notes = "内板钢板镀层")
   private String intPlating;
   @ApiModelProperty(name = "intSteelPlateBrand", notes = "内板钢板品牌")
   private String intSteelPlateBrand;
   @ApiModelProperty(name = "intThickness", notes = "内板钢板厚度(mm)")
   private BigDecimal intThickness;
   @ApiModelProperty(name = "outCoating", notes = "外板钢板涂层")
   private String outCoating;
   @ApiModelProperty(name = "outColour", notes = "外板钢板颜色")
   private String outColour;
   @ApiModelProperty(name = "outEffectiveWidth", notes = "外板钢板宽度(mm)")
   private BigDecimal outEffectiveWidth;
   @ApiModelProperty(name = "outMaterial", notes = "外板钢板材质")
   private String outMaterial;
   @ApiModelProperty(name = "outPlateShape", notes = "外板钢板形状")
   private String outPlateShape;
   @ApiModelProperty(name = "outPlating", notes = "外板钢板镀层")
   private String outPlating;
   @ApiModelProperty(name = "outSteelPlateBrand", notes = "外板钢板品牌")
   private String outSteelPlateBrand;
   @ApiModelProperty(name = "outThickness", notes = "外板钢板厚度 mm")
   private BigDecimal outThickness;
   @ApiModelProperty(name = "coreBrand", notes = "芯材品牌名")
   private String coreBrand;
   @ApiModelProperty(name = "typeName", notes = "芯材种类名")
   private String typeName;
   @ApiModelProperty(name = "unitWeight", notes = "芯材容重 kg/m3")
   private BigDecimal unitWeight;

   public String getId() {
      return this.id;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getPlateType() {
      return this.plateType;
   }

   public BigDecimal getEffectiveWidth() {
      return this.effectiveWidth;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getIntCoating() {
      return this.intCoating;
   }

   public String getIntColour() {
      return this.intColour;
   }

   public BigDecimal getIntEffectiveWidth() {
      return this.intEffectiveWidth;
   }

   public String getIntMaterial() {
      return this.intMaterial;
   }

   public String getIntPlateShape() {
      return this.intPlateShape;
   }

   public String getIntPlating() {
      return this.intPlating;
   }

   public String getIntSteelPlateBrand() {
      return this.intSteelPlateBrand;
   }

   public BigDecimal getIntThickness() {
      return this.intThickness;
   }

   public String getOutCoating() {
      return this.outCoating;
   }

   public String getOutColour() {
      return this.outColour;
   }

   public BigDecimal getOutEffectiveWidth() {
      return this.outEffectiveWidth;
   }

   public String getOutMaterial() {
      return this.outMaterial;
   }

   public String getOutPlateShape() {
      return this.outPlateShape;
   }

   public String getOutPlating() {
      return this.outPlating;
   }

   public String getOutSteelPlateBrand() {
      return this.outSteelPlateBrand;
   }

   public BigDecimal getOutThickness() {
      return this.outThickness;
   }

   public String getCoreBrand() {
      return this.coreBrand;
   }

   public String getTypeName() {
      return this.typeName;
   }

   public BigDecimal getUnitWeight() {
      return this.unitWeight;
   }

   public void setId(final String id) {
      this.id = id;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setPlateType(final String plateType) {
      this.plateType = plateType;
   }

   public void setEffectiveWidth(final BigDecimal effectiveWidth) {
      this.effectiveWidth = effectiveWidth;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setIntCoating(final String intCoating) {
      this.intCoating = intCoating;
   }

   public void setIntColour(final String intColour) {
      this.intColour = intColour;
   }

   public void setIntEffectiveWidth(final BigDecimal intEffectiveWidth) {
      this.intEffectiveWidth = intEffectiveWidth;
   }

   public void setIntMaterial(final String intMaterial) {
      this.intMaterial = intMaterial;
   }

   public void setIntPlateShape(final String intPlateShape) {
      this.intPlateShape = intPlateShape;
   }

   public void setIntPlating(final String intPlating) {
      this.intPlating = intPlating;
   }

   public void setIntSteelPlateBrand(final String intSteelPlateBrand) {
      this.intSteelPlateBrand = intSteelPlateBrand;
   }

   public void setIntThickness(final BigDecimal intThickness) {
      this.intThickness = intThickness;
   }

   public void setOutCoating(final String outCoating) {
      this.outCoating = outCoating;
   }

   public void setOutColour(final String outColour) {
      this.outColour = outColour;
   }

   public void setOutEffectiveWidth(final BigDecimal outEffectiveWidth) {
      this.outEffectiveWidth = outEffectiveWidth;
   }

   public void setOutMaterial(final String outMaterial) {
      this.outMaterial = outMaterial;
   }

   public void setOutPlateShape(final String outPlateShape) {
      this.outPlateShape = outPlateShape;
   }

   public void setOutPlating(final String outPlating) {
      this.outPlating = outPlating;
   }

   public void setOutSteelPlateBrand(final String outSteelPlateBrand) {
      this.outSteelPlateBrand = outSteelPlateBrand;
   }

   public void setOutThickness(final BigDecimal outThickness) {
      this.outThickness = outThickness;
   }

   public void setCoreBrand(final String coreBrand) {
      this.coreBrand = coreBrand;
   }

   public void setTypeName(final String typeName) {
      this.typeName = typeName;
   }

   public void setUnitWeight(final BigDecimal unitWeight) {
      this.unitWeight = unitWeight;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SandwichBoardDTOParam)) {
         return false;
      }

      SandwichBoardDTOParam other = (SandwichBoardDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$thickness = this.getThickness();
         Object other$thickness = other.getThickness();
         if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
            Object this$plateType = this.getPlateType();
            Object other$plateType = other.getPlateType();
            if (this$plateType == null ? other$plateType == null : this$plateType.equals(other$plateType)) {
               Object this$effectiveWidth = this.getEffectiveWidth();
               Object other$effectiveWidth = other.getEffectiveWidth();
               if (this$effectiveWidth == null ? other$effectiveWidth == null : this$effectiveWidth.equals(other$effectiveWidth)) {
                  Object this$quantity = this.getQuantity();
                  Object other$quantity = other.getQuantity();
                  if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                     Object this$intCoating = this.getIntCoating();
                     Object other$intCoating = other.getIntCoating();
                     if (this$intCoating == null ? other$intCoating == null : this$intCoating.equals(other$intCoating)) {
                        Object this$intColour = this.getIntColour();
                        Object other$intColour = other.getIntColour();
                        if (this$intColour == null ? other$intColour == null : this$intColour.equals(other$intColour)) {
                           Object this$intEffectiveWidth = this.getIntEffectiveWidth();
                           Object other$intEffectiveWidth = other.getIntEffectiveWidth();
                           if (this$intEffectiveWidth == null ? other$intEffectiveWidth == null : this$intEffectiveWidth.equals(other$intEffectiveWidth)) {
                              Object this$intMaterial = this.getIntMaterial();
                              Object other$intMaterial = other.getIntMaterial();
                              if (this$intMaterial == null ? other$intMaterial == null : this$intMaterial.equals(other$intMaterial)) {
                                 Object this$intPlateShape = this.getIntPlateShape();
                                 Object other$intPlateShape = other.getIntPlateShape();
                                 if (this$intPlateShape == null ? other$intPlateShape == null : this$intPlateShape.equals(other$intPlateShape)) {
                                    Object this$intPlating = this.getIntPlating();
                                    Object other$intPlating = other.getIntPlating();
                                    if (this$intPlating == null ? other$intPlating == null : this$intPlating.equals(other$intPlating)) {
                                       Object this$intSteelPlateBrand = this.getIntSteelPlateBrand();
                                       Object other$intSteelPlateBrand = other.getIntSteelPlateBrand();
                                       if (this$intSteelPlateBrand == null
                                          ? other$intSteelPlateBrand == null
                                          : this$intSteelPlateBrand.equals(other$intSteelPlateBrand)) {
                                          Object this$intThickness = this.getIntThickness();
                                          Object other$intThickness = other.getIntThickness();
                                          if (this$intThickness == null ? other$intThickness == null : this$intThickness.equals(other$intThickness)) {
                                             Object this$outCoating = this.getOutCoating();
                                             Object other$outCoating = other.getOutCoating();
                                             if (this$outCoating == null ? other$outCoating == null : this$outCoating.equals(other$outCoating)) {
                                                Object this$outColour = this.getOutColour();
                                                Object other$outColour = other.getOutColour();
                                                if (this$outColour == null ? other$outColour == null : this$outColour.equals(other$outColour)) {
                                                   Object this$outEffectiveWidth = this.getOutEffectiveWidth();
                                                   Object other$outEffectiveWidth = other.getOutEffectiveWidth();
                                                   if (this$outEffectiveWidth == null
                                                      ? other$outEffectiveWidth == null
                                                      : this$outEffectiveWidth.equals(other$outEffectiveWidth)) {
                                                      Object this$outMaterial = this.getOutMaterial();
                                                      Object other$outMaterial = other.getOutMaterial();
                                                      if (this$outMaterial == null ? other$outMaterial == null : this$outMaterial.equals(other$outMaterial)) {
                                                         Object this$outPlateShape = this.getOutPlateShape();
                                                         Object other$outPlateShape = other.getOutPlateShape();
                                                         if (this$outPlateShape == null
                                                            ? other$outPlateShape == null
                                                            : this$outPlateShape.equals(other$outPlateShape)) {
                                                            Object this$outPlating = this.getOutPlating();
                                                            Object other$outPlating = other.getOutPlating();
                                                            if (this$outPlating == null ? other$outPlating == null : this$outPlating.equals(other$outPlating)) {
                                                               Object this$outSteelPlateBrand = this.getOutSteelPlateBrand();
                                                               Object other$outSteelPlateBrand = other.getOutSteelPlateBrand();
                                                               if (this$outSteelPlateBrand == null
                                                                  ? other$outSteelPlateBrand == null
                                                                  : this$outSteelPlateBrand.equals(other$outSteelPlateBrand)) {
                                                                  Object this$outThickness = this.getOutThickness();
                                                                  Object other$outThickness = other.getOutThickness();
                                                                  if (this$outThickness == null
                                                                     ? other$outThickness == null
                                                                     : this$outThickness.equals(other$outThickness)) {
                                                                     Object this$coreBrand = this.getCoreBrand();
                                                                     Object other$coreBrand = other.getCoreBrand();
                                                                     if (this$coreBrand == null
                                                                        ? other$coreBrand == null
                                                                        : this$coreBrand.equals(other$coreBrand)) {
                                                                        Object this$typeName = this.getTypeName();
                                                                        Object other$typeName = other.getTypeName();
                                                                        if (this$typeName == null
                                                                           ? other$typeName == null
                                                                           : this$typeName.equals(other$typeName)) {
                                                                           Object this$unitWeight = this.getUnitWeight();
                                                                           Object other$unitWeight = other.getUnitWeight();
                                                                           return this$unitWeight == null
                                                                              ? other$unitWeight == null
                                                                              : this$unitWeight.equals(other$unitWeight);
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
      return other instanceof SandwichBoardDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $plateType = this.getPlateType();
      result = result * 59 + ($plateType == null ? 43 : $plateType.hashCode());
      Object $effectiveWidth = this.getEffectiveWidth();
      result = result * 59 + ($effectiveWidth == null ? 43 : $effectiveWidth.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $intCoating = this.getIntCoating();
      result = result * 59 + ($intCoating == null ? 43 : $intCoating.hashCode());
      Object $intColour = this.getIntColour();
      result = result * 59 + ($intColour == null ? 43 : $intColour.hashCode());
      Object $intEffectiveWidth = this.getIntEffectiveWidth();
      result = result * 59 + ($intEffectiveWidth == null ? 43 : $intEffectiveWidth.hashCode());
      Object $intMaterial = this.getIntMaterial();
      result = result * 59 + ($intMaterial == null ? 43 : $intMaterial.hashCode());
      Object $intPlateShape = this.getIntPlateShape();
      result = result * 59 + ($intPlateShape == null ? 43 : $intPlateShape.hashCode());
      Object $intPlating = this.getIntPlating();
      result = result * 59 + ($intPlating == null ? 43 : $intPlating.hashCode());
      Object $intSteelPlateBrand = this.getIntSteelPlateBrand();
      result = result * 59 + ($intSteelPlateBrand == null ? 43 : $intSteelPlateBrand.hashCode());
      Object $intThickness = this.getIntThickness();
      result = result * 59 + ($intThickness == null ? 43 : $intThickness.hashCode());
      Object $outCoating = this.getOutCoating();
      result = result * 59 + ($outCoating == null ? 43 : $outCoating.hashCode());
      Object $outColour = this.getOutColour();
      result = result * 59 + ($outColour == null ? 43 : $outColour.hashCode());
      Object $outEffectiveWidth = this.getOutEffectiveWidth();
      result = result * 59 + ($outEffectiveWidth == null ? 43 : $outEffectiveWidth.hashCode());
      Object $outMaterial = this.getOutMaterial();
      result = result * 59 + ($outMaterial == null ? 43 : $outMaterial.hashCode());
      Object $outPlateShape = this.getOutPlateShape();
      result = result * 59 + ($outPlateShape == null ? 43 : $outPlateShape.hashCode());
      Object $outPlating = this.getOutPlating();
      result = result * 59 + ($outPlating == null ? 43 : $outPlating.hashCode());
      Object $outSteelPlateBrand = this.getOutSteelPlateBrand();
      result = result * 59 + ($outSteelPlateBrand == null ? 43 : $outSteelPlateBrand.hashCode());
      Object $outThickness = this.getOutThickness();
      result = result * 59 + ($outThickness == null ? 43 : $outThickness.hashCode());
      Object $coreBrand = this.getCoreBrand();
      result = result * 59 + ($coreBrand == null ? 43 : $coreBrand.hashCode());
      Object $typeName = this.getTypeName();
      result = result * 59 + ($typeName == null ? 43 : $typeName.hashCode());
      Object $unitWeight = this.getUnitWeight();
      return result * 59 + ($unitWeight == null ? 43 : $unitWeight.hashCode());
   }

   @Override
   public String toString() {
      return "SandwichBoardDTOParam(id="
         + this.getId()
         + ", thickness="
         + this.getThickness()
         + ", plateType="
         + this.getPlateType()
         + ", effectiveWidth="
         + this.getEffectiveWidth()
         + ", quantity="
         + this.getQuantity()
         + ", intCoating="
         + this.getIntCoating()
         + ", intColour="
         + this.getIntColour()
         + ", intEffectiveWidth="
         + this.getIntEffectiveWidth()
         + ", intMaterial="
         + this.getIntMaterial()
         + ", intPlateShape="
         + this.getIntPlateShape()
         + ", intPlating="
         + this.getIntPlating()
         + ", intSteelPlateBrand="
         + this.getIntSteelPlateBrand()
         + ", intThickness="
         + this.getIntThickness()
         + ", outCoating="
         + this.getOutCoating()
         + ", outColour="
         + this.getOutColour()
         + ", outEffectiveWidth="
         + this.getOutEffectiveWidth()
         + ", outMaterial="
         + this.getOutMaterial()
         + ", outPlateShape="
         + this.getOutPlateShape()
         + ", outPlating="
         + this.getOutPlating()
         + ", outSteelPlateBrand="
         + this.getOutSteelPlateBrand()
         + ", outThickness="
         + this.getOutThickness()
         + ", coreBrand="
         + this.getCoreBrand()
         + ", typeName="
         + this.getTypeName()
         + ", unitWeight="
         + this.getUnitWeight()
         + ")";
   }
}
