package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel("涂装工艺详情新增编辑Param")
public class MesPaintingCraftDetailParam {
   @ApiModelProperty("涂装类型")
   @NotNull(groups = {Add.class, Update.class}, message = "涂装类型不能为空")
   private Integer paintingTypeEnum;
   @ApiModelProperty("油漆品牌")
   @NotBlank(groups = {Add.class, Update.class}, message = "油漆品牌不能为空")
   private String paintBrand;
   @ApiModelProperty("油漆类型")
   @NotBlank(groups = {Add.class, Update.class}, message = "油漆类型不能为空")
   private String paintType;
   @ApiModelProperty("比重(㎏/L)")
   private BigDecimal specificGravity;
   @ApiModelProperty("体积固含量(%)")
   private BigDecimal volumeSolidContent;
   @ApiModelProperty("包装重量(㎏)")
   private BigDecimal packageWeight;
   @ApiModelProperty("单位(㎏,L)")
   private String unit;
   @ApiModelProperty("包装单位(桶,组)")
   private String packageUnit;
   @ApiModelProperty("漆膜厚度(µm)")
   @NotNull(groups = {Add.class, Update.class}, message = "漆膜厚度不能为空")
   private BigDecimal paintFilmThickness;
   @ApiModelProperty("损耗系数")
   @NotNull(groups = {Add.class, Update.class}, message = "损耗系数不能为空")
   private BigDecimal lossCoefficient;
   @Positive(groups = {Add.class, Update.class}, message = "重量不能小于等于0")
   @ApiModelProperty("重量(㎏)")
   private BigDecimal weight;
   @Positive(groups = {Add.class, Update.class}, message = "数量不能小于等于0")
   @ApiModelProperty("数量")
   private BigDecimal quantity;

   public Integer getPaintingTypeEnum() {
      return this.paintingTypeEnum;
   }

   public String getPaintBrand() {
      return this.paintBrand;
   }

   public String getPaintType() {
      return this.paintType;
   }

   public BigDecimal getSpecificGravity() {
      return this.specificGravity;
   }

   public BigDecimal getVolumeSolidContent() {
      return this.volumeSolidContent;
   }

   public BigDecimal getPackageWeight() {
      return this.packageWeight;
   }

   public String getUnit() {
      return this.unit;
   }

   public String getPackageUnit() {
      return this.packageUnit;
   }

   public BigDecimal getPaintFilmThickness() {
      return this.paintFilmThickness;
   }

   public BigDecimal getLossCoefficient() {
      return this.lossCoefficient;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public void setPaintingTypeEnum(final Integer paintingTypeEnum) {
      this.paintingTypeEnum = paintingTypeEnum;
   }

   public void setPaintBrand(final String paintBrand) {
      this.paintBrand = paintBrand;
   }

   public void setPaintType(final String paintType) {
      this.paintType = paintType;
   }

   public void setSpecificGravity(final BigDecimal specificGravity) {
      this.specificGravity = specificGravity;
   }

   public void setVolumeSolidContent(final BigDecimal volumeSolidContent) {
      this.volumeSolidContent = volumeSolidContent;
   }

   public void setPackageWeight(final BigDecimal packageWeight) {
      this.packageWeight = packageWeight;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setPackageUnit(final String packageUnit) {
      this.packageUnit = packageUnit;
   }

   public void setPaintFilmThickness(final BigDecimal paintFilmThickness) {
      this.paintFilmThickness = paintFilmThickness;
   }

   public void setLossCoefficient(final BigDecimal lossCoefficient) {
      this.lossCoefficient = lossCoefficient;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPaintingCraftDetailParam)) {
         return false;
      }

      MesPaintingCraftDetailParam other = (MesPaintingCraftDetailParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$paintingTypeEnum = this.getPaintingTypeEnum();
      Object other$paintingTypeEnum = other.getPaintingTypeEnum();
      if (this$paintingTypeEnum == null ? other$paintingTypeEnum == null : this$paintingTypeEnum.equals(other$paintingTypeEnum)) {
         Object this$paintBrand = this.getPaintBrand();
         Object other$paintBrand = other.getPaintBrand();
         if (this$paintBrand == null ? other$paintBrand == null : this$paintBrand.equals(other$paintBrand)) {
            Object this$paintType = this.getPaintType();
            Object other$paintType = other.getPaintType();
            if (this$paintType == null ? other$paintType == null : this$paintType.equals(other$paintType)) {
               Object this$specificGravity = this.getSpecificGravity();
               Object other$specificGravity = other.getSpecificGravity();
               if (this$specificGravity == null ? other$specificGravity == null : this$specificGravity.equals(other$specificGravity)) {
                  Object this$volumeSolidContent = this.getVolumeSolidContent();
                  Object other$volumeSolidContent = other.getVolumeSolidContent();
                  if (this$volumeSolidContent == null ? other$volumeSolidContent == null : this$volumeSolidContent.equals(other$volumeSolidContent)) {
                     Object this$packageWeight = this.getPackageWeight();
                     Object other$packageWeight = other.getPackageWeight();
                     if (this$packageWeight == null ? other$packageWeight == null : this$packageWeight.equals(other$packageWeight)) {
                        Object this$unit = this.getUnit();
                        Object other$unit = other.getUnit();
                        if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                           Object this$packageUnit = this.getPackageUnit();
                           Object other$packageUnit = other.getPackageUnit();
                           if (this$packageUnit == null ? other$packageUnit == null : this$packageUnit.equals(other$packageUnit)) {
                              Object this$paintFilmThickness = this.getPaintFilmThickness();
                              Object other$paintFilmThickness = other.getPaintFilmThickness();
                              if (this$paintFilmThickness == null ? other$paintFilmThickness == null : this$paintFilmThickness.equals(other$paintFilmThickness)
                                 )
                               {
                                 Object this$lossCoefficient = this.getLossCoefficient();
                                 Object other$lossCoefficient = other.getLossCoefficient();
                                 if (this$lossCoefficient == null ? other$lossCoefficient == null : this$lossCoefficient.equals(other$lossCoefficient)) {
                                    Object this$weight = this.getWeight();
                                    Object other$weight = other.getWeight();
                                    if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                       Object this$quantity = this.getQuantity();
                                       Object other$quantity = other.getQuantity();
                                       return this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity);
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
      return other instanceof MesPaintingCraftDetailParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $paintingTypeEnum = this.getPaintingTypeEnum();
      result = result * 59 + ($paintingTypeEnum == null ? 43 : $paintingTypeEnum.hashCode());
      Object $paintBrand = this.getPaintBrand();
      result = result * 59 + ($paintBrand == null ? 43 : $paintBrand.hashCode());
      Object $paintType = this.getPaintType();
      result = result * 59 + ($paintType == null ? 43 : $paintType.hashCode());
      Object $specificGravity = this.getSpecificGravity();
      result = result * 59 + ($specificGravity == null ? 43 : $specificGravity.hashCode());
      Object $volumeSolidContent = this.getVolumeSolidContent();
      result = result * 59 + ($volumeSolidContent == null ? 43 : $volumeSolidContent.hashCode());
      Object $packageWeight = this.getPackageWeight();
      result = result * 59 + ($packageWeight == null ? 43 : $packageWeight.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $packageUnit = this.getPackageUnit();
      result = result * 59 + ($packageUnit == null ? 43 : $packageUnit.hashCode());
      Object $paintFilmThickness = this.getPaintFilmThickness();
      result = result * 59 + ($paintFilmThickness == null ? 43 : $paintFilmThickness.hashCode());
      Object $lossCoefficient = this.getLossCoefficient();
      result = result * 59 + ($lossCoefficient == null ? 43 : $lossCoefficient.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $quantity = this.getQuantity();
      return result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
   }

   @Override
   public String toString() {
      return "MesPaintingCraftDetailParam(paintingTypeEnum="
         + this.getPaintingTypeEnum()
         + ", paintBrand="
         + this.getPaintBrand()
         + ", paintType="
         + this.getPaintType()
         + ", specificGravity="
         + this.getSpecificGravity()
         + ", volumeSolidContent="
         + this.getVolumeSolidContent()
         + ", packageWeight="
         + this.getPackageWeight()
         + ", unit="
         + this.getUnit()
         + ", packageUnit="
         + this.getPackageUnit()
         + ", paintFilmThickness="
         + this.getPaintFilmThickness()
         + ", lossCoefficient="
         + this.getLossCoefficient()
         + ", weight="
         + this.getWeight()
         + ", quantity="
         + this.getQuantity()
         + ")";
   }
}
