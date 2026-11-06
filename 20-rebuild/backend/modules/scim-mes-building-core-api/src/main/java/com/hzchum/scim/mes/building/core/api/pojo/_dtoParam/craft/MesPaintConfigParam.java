package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.mes.building.core.api.enums.PaintingTypeEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel("油漆配置新增修改Param")
public class MesPaintConfigParam {
   @ApiModelProperty("主键ID")
   @NotNull(groups = Update.class, message = "ID不能为空")
   private Long id;
   @ApiModelProperty("涂装类型")
   @NotNull(groups = {Add.class, Update.class}, message = "涂装类型不能为空")
   @EnumValidator(groups = {Add.class, Update.class}, value = PaintingTypeEnum.class, message = "涂装类型参数有误")
   private Integer paintingTypeEnum;
   @ApiModelProperty("油漆品牌")
   @NotBlank(groups = {Add.class, Update.class}, message = "油漆品牌不能为空")
   private String paintBrand;
   @ApiModelProperty("油漆类型")
   @NotBlank(groups = {Add.class, Update.class}, message = "油漆类型不能为空")
   private String paintType;
   @Positive(groups = {Add.class, Update.class}, message = "体积固含量不能小于等于0")
   @NotNull(groups = {Add.class, Update.class}, message = "体积固含量(%)不能为空")
   @ApiModelProperty("体积固含量(%)")
   private BigDecimal volumeSolidContent;
   @NotBlank(groups = {Add.class, Update.class}, message = "单位(kg或L)不能为空")
   @ApiModelProperty("单位(kg或L)")
   private String unit;
   @Positive(groups = {Add.class, Update.class}, message = "比重不能小于等于0")
   @NotNull(groups = {Add.class, Update.class}, message = "比重(kg/L)不能为空")
   @ApiModelProperty("比重(kg/L)")
   private BigDecimal specificGravity;
   @Positive(groups = {Add.class, Update.class}, message = "包装重量不能小于等于0")
   @NotNull(groups = {Add.class, Update.class}, message = "包装重量不能为空")
   @ApiModelProperty("包装重量")
   private BigDecimal packageWeight;
   @ApiModelProperty("包装单位(桶或组)")
   @NotBlank(groups = {Add.class, Update.class}, message = "包装单位(桶或组)不能为空")
   private String packageUnit;

   public Long getId() {
      return this.id;
   }

   public Integer getPaintingTypeEnum() {
      return this.paintingTypeEnum;
   }

   public String getPaintBrand() {
      return this.paintBrand;
   }

   public String getPaintType() {
      return this.paintType;
   }

   public BigDecimal getVolumeSolidContent() {
      return this.volumeSolidContent;
   }

   public String getUnit() {
      return this.unit;
   }

   public BigDecimal getSpecificGravity() {
      return this.specificGravity;
   }

   public BigDecimal getPackageWeight() {
      return this.packageWeight;
   }

   public String getPackageUnit() {
      return this.packageUnit;
   }

   public void setId(final Long id) {
      this.id = id;
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

   public void setVolumeSolidContent(final BigDecimal volumeSolidContent) {
      this.volumeSolidContent = volumeSolidContent;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setSpecificGravity(final BigDecimal specificGravity) {
      this.specificGravity = specificGravity;
   }

   public void setPackageWeight(final BigDecimal packageWeight) {
      this.packageWeight = packageWeight;
   }

   public void setPackageUnit(final String packageUnit) {
      this.packageUnit = packageUnit;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesPaintConfigParam)) {
         return false;
      }

      MesPaintConfigParam other = (MesPaintConfigParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$paintingTypeEnum = this.getPaintingTypeEnum();
         Object other$paintingTypeEnum = other.getPaintingTypeEnum();
         if (this$paintingTypeEnum == null ? other$paintingTypeEnum == null : this$paintingTypeEnum.equals(other$paintingTypeEnum)) {
            Object this$paintBrand = this.getPaintBrand();
            Object other$paintBrand = other.getPaintBrand();
            if (this$paintBrand == null ? other$paintBrand == null : this$paintBrand.equals(other$paintBrand)) {
               Object this$paintType = this.getPaintType();
               Object other$paintType = other.getPaintType();
               if (this$paintType == null ? other$paintType == null : this$paintType.equals(other$paintType)) {
                  Object this$volumeSolidContent = this.getVolumeSolidContent();
                  Object other$volumeSolidContent = other.getVolumeSolidContent();
                  if (this$volumeSolidContent == null ? other$volumeSolidContent == null : this$volumeSolidContent.equals(other$volumeSolidContent)) {
                     Object this$unit = this.getUnit();
                     Object other$unit = other.getUnit();
                     if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                        Object this$specificGravity = this.getSpecificGravity();
                        Object other$specificGravity = other.getSpecificGravity();
                        if (this$specificGravity == null ? other$specificGravity == null : this$specificGravity.equals(other$specificGravity)) {
                           Object this$packageWeight = this.getPackageWeight();
                           Object other$packageWeight = other.getPackageWeight();
                           if (this$packageWeight == null ? other$packageWeight == null : this$packageWeight.equals(other$packageWeight)) {
                              Object this$packageUnit = this.getPackageUnit();
                              Object other$packageUnit = other.getPackageUnit();
                              return this$packageUnit == null ? other$packageUnit == null : this$packageUnit.equals(other$packageUnit);
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
      return other instanceof MesPaintConfigParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $paintingTypeEnum = this.getPaintingTypeEnum();
      result = result * 59 + ($paintingTypeEnum == null ? 43 : $paintingTypeEnum.hashCode());
      Object $paintBrand = this.getPaintBrand();
      result = result * 59 + ($paintBrand == null ? 43 : $paintBrand.hashCode());
      Object $paintType = this.getPaintType();
      result = result * 59 + ($paintType == null ? 43 : $paintType.hashCode());
      Object $volumeSolidContent = this.getVolumeSolidContent();
      result = result * 59 + ($volumeSolidContent == null ? 43 : $volumeSolidContent.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $specificGravity = this.getSpecificGravity();
      result = result * 59 + ($specificGravity == null ? 43 : $specificGravity.hashCode());
      Object $packageWeight = this.getPackageWeight();
      result = result * 59 + ($packageWeight == null ? 43 : $packageWeight.hashCode());
      Object $packageUnit = this.getPackageUnit();
      return result * 59 + ($packageUnit == null ? 43 : $packageUnit.hashCode());
   }

   @Override
   public String toString() {
      return "MesPaintConfigParam(id="
         + this.getId()
         + ", paintingTypeEnum="
         + this.getPaintingTypeEnum()
         + ", paintBrand="
         + this.getPaintBrand()
         + ", paintType="
         + this.getPaintType()
         + ", volumeSolidContent="
         + this.getVolumeSolidContent()
         + ", unit="
         + this.getUnit()
         + ", specificGravity="
         + this.getSpecificGravity()
         + ", packageWeight="
         + this.getPackageWeight()
         + ", packageUnit="
         + this.getPackageUnit()
         + ")";
   }
}
