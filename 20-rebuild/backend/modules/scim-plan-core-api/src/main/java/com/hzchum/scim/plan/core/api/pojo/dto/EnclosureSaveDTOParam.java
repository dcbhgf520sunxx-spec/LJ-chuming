package com.hzchum.scim.plan.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@ApiModel("围护 增加类")
public class EnclosureSaveDTOParam {
   @ApiModelProperty(name = "dictionaryId", value = "字典类型")
   private Long dictionaryId;
   @ApiModelProperty(name = "name", value = "名称")
   @NotBlank(message = "名称不能为空")
   @Size(max = 32, message = "名称字符数超出限制!")
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @NotBlank(message = "编号不能为空")
   @Size(max = 32, message = "编号字符数超出限制!")
   private String serialNumber;
   @ApiModelProperty(name = "plate", value = "版型")
   @Size(max = 32, message = "板型字符数超出限制!")
   private String plate;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)")
   @DecimalMin(value = "0.0001", message = "展宽数据过小!")
   @DecimalMax(value = "9999999999", message = "展宽数据过大!")
   @NotNull(message = "展宽(mm)不能为空")
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "width", value = "(有效)宽度（mm）")
   @DecimalMin(value = "0.0001", message = "有效宽度数据过小!")
   @DecimalMax(value = "9999999999", message = "有效宽度数据过大!")
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚度（mm）")
   @DecimalMin(value = "0.0001", message = "厚度数据过小!")
   @DecimalMax(value = "9999999999", message = "厚度数据过大!")
   @NotNull(message = "厚度（mm）不能为空")
   private BigDecimal thickness;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @NotNull(message = "单长不能为空")
   @DecimalMin(value = "0.0001", message = "长度数据过小!")
   @DecimalMax(value = "9999999999", message = "长度数据过大!")
   private BigDecimal length;
   @ApiModelProperty(name = "unit", value = "计量单位")
   @NotNull(message = "计量单位不能为空")
   private String unit;
   @ApiModelProperty(name = "quantity", value = "数量(张)")
   @NotNull(message = "数量不能为空")
   @Min(value = 1L, message = "数量最小为1")
   @Max(value = 999999999L, message = "数量过大!")
   private Integer quantity;
   @ApiModelProperty(name = "accountingVolume", value = "核算量(米)")
   private BigDecimal accountingVolume;
   @ApiModelProperty(name = "surfaceArea", value = "单面积(mm²)")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "weight", value = "单重量(kg)")
   private BigDecimal weight;
   @ApiModelProperty(name = "remark", value = "备注")
   @Size(max = 50, message = "备注字数超出50字限制!")
   private String remark;
   @ApiModelProperty(name = "brand", value = "品牌")
   @Size(max = 32, message = "品牌字符数超出限制!")
   private String brand;
   @ApiModelProperty(name = "color", value = "颜色")
   @Size(max = 32, message = "颜色字符数超出限制!")
   private String color;
   @ApiModelProperty(name = "material", value = "材质")
   @Size(max = 32, message = "材质字符数超出限制!")
   private String material;
   @ApiModelProperty(name = "coating", value = "涂层")
   @Size(max = 32, message = "涂层字符数超出限制!")
   private String coating;
   @ApiModelProperty(name = "plating", value = "镀层")
   @Size(max = 32, message = "镀层字符数超出限制!")
   private String plating;
   @ApiModelProperty(name = "bendTimes", value = "折边件弯折次数")
   @Min(value = 1L, message = "折边件弯折次数最小为1次")
   @Max(value = 999999999L, message = "折边件弯折次数数量过大!")
   private Integer bendTimes;

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public String getName() {
      return this.name;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getPlate() {
      return this.plate;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public String getUnit() {
      return this.unit;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getAccountingVolume() {
      return this.accountingVolume;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getWeight() {
      return this.weight;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getColor() {
      return this.color;
   }

   public String getMaterial() {
      return this.material;
   }

   public String getCoating() {
      return this.coating;
   }

   public String getPlating() {
      return this.plating;
   }

   public Integer getBendTimes() {
      return this.bendTimes;
   }

   public void setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   public void setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setUnit(final String unit) {
      this.unit = unit;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setAccountingVolume(final BigDecimal accountingVolume) {
      this.accountingVolume = accountingVolume;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setMaterial(final String material) {
      this.material = material;
   }

   public void setCoating(final String coating) {
      this.coating = coating;
   }

   public void setPlating(final String plating) {
      this.plating = plating;
   }

   public void setBendTimes(final Integer bendTimes) {
      this.bendTimes = bendTimes;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureSaveDTOParam)) {
         return false;
      }

      EnclosureSaveDTOParam other = (EnclosureSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$dictionaryId = this.getDictionaryId();
      Object other$dictionaryId = other.getDictionaryId();
      if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$bendTimes = this.getBendTimes();
            Object other$bendTimes = other.getBendTimes();
            if (this$bendTimes == null ? other$bendTimes == null : this$bendTimes.equals(other$bendTimes)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$plate = this.getPlate();
                     Object other$plate = other.getPlate();
                     if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                        Object this$unfoldedWidth = this.getUnfoldedWidth();
                        Object other$unfoldedWidth = other.getUnfoldedWidth();
                        if (this$unfoldedWidth == null ? other$unfoldedWidth == null : this$unfoldedWidth.equals(other$unfoldedWidth)) {
                           Object this$width = this.getWidth();
                           Object other$width = other.getWidth();
                           if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                              Object this$thickness = this.getThickness();
                              Object other$thickness = other.getThickness();
                              if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                 Object this$length = this.getLength();
                                 Object other$length = other.getLength();
                                 if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                    Object this$unit = this.getUnit();
                                    Object other$unit = other.getUnit();
                                    if (this$unit == null ? other$unit == null : this$unit.equals(other$unit)) {
                                       Object this$accountingVolume = this.getAccountingVolume();
                                       Object other$accountingVolume = other.getAccountingVolume();
                                       if (this$accountingVolume == null
                                          ? other$accountingVolume == null
                                          : this$accountingVolume.equals(other$accountingVolume)) {
                                          Object this$surfaceArea = this.getSurfaceArea();
                                          Object other$surfaceArea = other.getSurfaceArea();
                                          if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                             Object this$weight = this.getWeight();
                                             Object other$weight = other.getWeight();
                                             if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                                Object this$remark = this.getRemark();
                                                Object other$remark = other.getRemark();
                                                if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                                   Object this$brand = this.getBrand();
                                                   Object other$brand = other.getBrand();
                                                   if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                      Object this$color = this.getColor();
                                                      Object other$color = other.getColor();
                                                      if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                         Object this$material = this.getMaterial();
                                                         Object other$material = other.getMaterial();
                                                         if (this$material == null ? other$material == null : this$material.equals(other$material)) {
                                                            Object this$coating = this.getCoating();
                                                            Object other$coating = other.getCoating();
                                                            if (this$coating == null ? other$coating == null : this$coating.equals(other$coating)) {
                                                               Object this$plating = this.getPlating();
                                                               Object other$plating = other.getPlating();
                                                               return this$plating == null ? other$plating == null : this$plating.equals(other$plating);
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
      return other instanceof EnclosureSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $bendTimes = this.getBendTimes();
      result = result * 59 + ($bendTimes == null ? 43 : $bendTimes.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $unit = this.getUnit();
      result = result * 59 + ($unit == null ? 43 : $unit.hashCode());
      Object $accountingVolume = this.getAccountingVolume();
      result = result * 59 + ($accountingVolume == null ? 43 : $accountingVolume.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $coating = this.getCoating();
      result = result * 59 + ($coating == null ? 43 : $coating.hashCode());
      Object $plating = this.getPlating();
      return result * 59 + ($plating == null ? 43 : $plating.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureSaveDTOParam(dictionaryId="
         + this.getDictionaryId()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", plate="
         + this.getPlate()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", length="
         + this.getLength()
         + ", unit="
         + this.getUnit()
         + ", quantity="
         + this.getQuantity()
         + ", accountingVolume="
         + this.getAccountingVolume()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", weight="
         + this.getWeight()
         + ", remark="
         + this.getRemark()
         + ", brand="
         + this.getBrand()
         + ", color="
         + this.getColor()
         + ", material="
         + this.getMaterial()
         + ", coating="
         + this.getCoating()
         + ", plating="
         + this.getPlating()
         + ", bendTimes="
         + this.getBendTimes()
         + ")";
   }
}
