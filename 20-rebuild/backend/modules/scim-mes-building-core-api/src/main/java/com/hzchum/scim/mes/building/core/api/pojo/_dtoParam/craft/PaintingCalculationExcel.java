package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.craft;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("涂装计算Excel")
@ExcelTarget("PaintingCalculationExcel")
public class PaintingCalculationExcel {
   @ApiModelProperty("序号")
   @Excel(name = "序号", width = 5.0)
   private Integer orderNo;
   @ApiModelProperty("涂装类型")
   @Excel(name = "油漆类型")
   private String paintingTypeEnum;
   @ApiModelProperty("油漆品牌")
   @Excel(name = "品牌")
   private String paintBrand;
   @ApiModelProperty("油漆类型")
   @Excel(name = "材质")
   private String paintType;
   @ApiModelProperty("比重（kg/L）")
   @Excel(name = "比重（kg/L）")
   private BigDecimal specificGravity;
   @ApiModelProperty("体积固含量（%）")
   @Excel(name = "体积固含量（%）")
   private BigDecimal volumeSolidContent;
   @ApiModelProperty("包装重量")
   @Excel(name = "包装重量")
   private BigDecimal packageWeight;
   @ApiModelProperty("单位")
   @Excel(name = "单位")
   private String unit;
   @ApiModelProperty("实际涂布率（㎡/kg）")
   @Excel(name = "实际涂布率（㎡/kg）")
   private BigDecimal practicalSpreadingRate;
   @ApiModelProperty("数量")
   @Excel(name = "数量")
   private BigDecimal quantity;
   @ApiModelProperty("数量单位")
   @Excel(name = "数量单位")
   private String packageUnit;
   @ApiModelProperty("重量(㎏)")
   @Excel(name = "重量(㎏)")
   private BigDecimal weight;
   @ApiModelProperty("单价(元)")
   @Excel(name = "采购单价（元）")
   private BigDecimal price;
   @ApiModelProperty("总价(元)")
   @Excel(name = "金额（元）")
   private BigDecimal totalPrice;

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getPaintingTypeEnum() {
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

   public BigDecimal getPracticalSpreadingRate() {
      return this.practicalSpreadingRate;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getPackageUnit() {
      return this.packageUnit;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public BigDecimal getTotalPrice() {
      return this.totalPrice;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setPaintingTypeEnum(final String paintingTypeEnum) {
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

   public void setPracticalSpreadingRate(final BigDecimal practicalSpreadingRate) {
      this.practicalSpreadingRate = practicalSpreadingRate;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setPackageUnit(final String packageUnit) {
      this.packageUnit = packageUnit;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   public void setTotalPrice(final BigDecimal totalPrice) {
      this.totalPrice = totalPrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof PaintingCalculationExcel)) {
         return false;
      }

      PaintingCalculationExcel other = (PaintingCalculationExcel)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
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
                              Object this$practicalSpreadingRate = this.getPracticalSpreadingRate();
                              Object other$practicalSpreadingRate = other.getPracticalSpreadingRate();
                              if (this$practicalSpreadingRate == null
                                 ? other$practicalSpreadingRate == null
                                 : this$practicalSpreadingRate.equals(other$practicalSpreadingRate)) {
                                 Object this$quantity = this.getQuantity();
                                 Object other$quantity = other.getQuantity();
                                 if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                    Object this$packageUnit = this.getPackageUnit();
                                    Object other$packageUnit = other.getPackageUnit();
                                    if (this$packageUnit == null ? other$packageUnit == null : this$packageUnit.equals(other$packageUnit)) {
                                       Object this$weight = this.getWeight();
                                       Object other$weight = other.getWeight();
                                       if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                          Object this$price = this.getPrice();
                                          Object other$price = other.getPrice();
                                          if (this$price == null ? other$price == null : this$price.equals(other$price)) {
                                             Object this$totalPrice = this.getTotalPrice();
                                             Object other$totalPrice = other.getTotalPrice();
                                             return this$totalPrice == null ? other$totalPrice == null : this$totalPrice.equals(other$totalPrice);
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
      return other instanceof PaintingCalculationExcel;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
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
      Object $practicalSpreadingRate = this.getPracticalSpreadingRate();
      result = result * 59 + ($practicalSpreadingRate == null ? 43 : $practicalSpreadingRate.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $packageUnit = this.getPackageUnit();
      result = result * 59 + ($packageUnit == null ? 43 : $packageUnit.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $price = this.getPrice();
      result = result * 59 + ($price == null ? 43 : $price.hashCode());
      Object $totalPrice = this.getTotalPrice();
      return result * 59 + ($totalPrice == null ? 43 : $totalPrice.hashCode());
   }

   @Override
   public String toString() {
      return "PaintingCalculationExcel(orderNo="
         + this.getOrderNo()
         + ", paintingTypeEnum="
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
         + ", practicalSpreadingRate="
         + this.getPracticalSpreadingRate()
         + ", quantity="
         + this.getQuantity()
         + ", packageUnit="
         + this.getPackageUnit()
         + ", weight="
         + this.getWeight()
         + ", price="
         + this.getPrice()
         + ", totalPrice="
         + this.getTotalPrice()
         + ")";
   }
}
