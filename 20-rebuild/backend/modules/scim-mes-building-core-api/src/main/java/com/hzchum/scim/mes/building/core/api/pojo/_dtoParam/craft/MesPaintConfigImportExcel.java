package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("油漆配置excel导入")
public class MesPaintConfigImportExcel {
   @ApiModelProperty("序号")
   @Excel(name = "序号")
   private Integer orderNo;
   @ApiModelProperty("涂装类型")
   @Excel(name = "涂装类型", width = 15.0)
   private String paintingTypeName;
   @ApiModelProperty("油漆品牌")
   @Excel(name = "油漆品牌", width = 15.0)
   private String paintBrand;
   @ApiModelProperty("油漆类型")
   @Excel(name = "油漆类型", width = 20.0)
   private String paintType;
   @ApiModelProperty("体积固含量(%)")
   @Excel(name = "体积固含量(%)", width = 15.0)
   private BigDecimal volumeSolidContent;
   @ApiModelProperty("单位(kg或L)")
   @Excel(name = "单位(kg或L)", width = 20.0)
   private String unit;
   @ApiModelProperty("比重(kg/L)")
   @Excel(name = "比重(kg/L)", width = 15.0)
   private BigDecimal specificGravity;
   @ApiModelProperty("包装重量")
   @Excel(name = "包装重量", width = 15.0)
   private BigDecimal packageWeight;
   @ApiModelProperty("包装单位(桶或组)")
   @Excel(name = "包装单位(桶或组)", width = 20.0)
   private String packageUnit;

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getPaintingTypeName() {
      return this.paintingTypeName;
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

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setPaintingTypeName(final String paintingTypeName) {
      this.paintingTypeName = paintingTypeName;
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

      if (!(o instanceof MesPaintConfigImportExcel)) {
         return false;
      }

      MesPaintConfigImportExcel other = (MesPaintConfigImportExcel)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$paintingTypeName = this.getPaintingTypeName();
         Object other$paintingTypeName = other.getPaintingTypeName();
         if (this$paintingTypeName == null ? other$paintingTypeName == null : this$paintingTypeName.equals(other$paintingTypeName)) {
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
      return other instanceof MesPaintConfigImportExcel;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $paintingTypeName = this.getPaintingTypeName();
      result = result * 59 + ($paintingTypeName == null ? 43 : $paintingTypeName.hashCode());
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
      return "MesPaintConfigImportExcel(orderNo="
         + this.getOrderNo()
         + ", paintingTypeName="
         + this.getPaintingTypeName()
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
