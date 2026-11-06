package com.hzchum.scim.plan.core.api.pojo.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hzchum.scim.plan.core.api.util.BigDecimalSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ExcelTarget("enclosureImportDto")
public class EnclosureImportDTO implements Serializable {
   @ApiModelProperty(name = "orderNo", value = "序号")
   @Excel(name = "序号", width = 5.0)
   private Integer orderNo;
   @ApiModelProperty(name = "name", value = "名称")
   @Excel(name = "名称", width = 15.0)
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @Excel(name = "编号", width = 15.0)
   private String serialNumber;
   @ApiModelProperty(name = "plate", value = "板型")
   @Excel(name = "板型")
   private String plate;
   @ApiModelProperty(name = "brand", value = "品牌")
   @Excel(name = "品牌")
   private String brand;
   @ApiModelProperty(name = "color", value = "颜色")
   @Excel(name = "颜色")
   private String color;
   @ApiModelProperty(name = "material", value = "材质")
   @Excel(name = "材质")
   private String material;
   @ApiModelProperty(name = "coating", value = "涂层")
   @Excel(name = "涂层")
   private String coating;
   @ApiModelProperty(name = "plating", value = "镀层")
   @Excel(name = "镀层")
   private String plating;
   @ApiModelProperty(name = "bendTimes", value = "折边件弯折次数")
   @Excel(name = "弯折次数")
   private Integer bendTimes;
   @ApiModelProperty(name = "thickness", value = "厚度（mm）")
   @Excel(name = "板厚(mm)")
   private BigDecimal thickness;
   @ApiModelProperty(name = "width", value = "有效宽度（mm）")
   @Excel(name = "有效宽度(mm)", width = 13.0)
   private BigDecimal width;
   @ApiModelProperty(name = "unfoldedWidth", value = "展宽(mm)")
   @Excel(name = "展宽(mm)")
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "length", value = "单长(mm)")
   @Excel(name = "单长(mm)")
   private BigDecimal length;
   @ApiModelProperty(name = "quantity", value = "数量")
   @Excel(name = "数量(张)", width = 10.0)
   private Integer quantity;
   @JsonSerialize(using = BigDecimalSerializer.class)
   @ApiModelProperty(name = "totalLength", value = "总长度（m）")
   @Excel(name = "总长度(m)")
   private String totalLength;
   @JsonSerialize(using = BigDecimalSerializer.class)
   @ApiModelProperty(name = "totalArea", value = "总面积(m²)")
   @Excel(name = "总面积(m²)")
   private String totalArea;
   @ApiModelProperty(name = "totalWeight", value = "总重")
   @Excel(name = "总重(kg)")
   private BigDecimal totalWeight;
   @ApiModelProperty(name = "remark", value = "备注")
   @Excel(name = "备注", width = 20.0)
   private String remark;

   public Integer getOrderNo() {
      return this.orderNo;
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

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getUnfoldedWidth() {
      return this.unfoldedWidth;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public String getTotalLength() {
      return this.totalLength;
   }

   public String getTotalArea() {
      return this.totalArea;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public String getRemark() {
      return this.remark;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
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

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setUnfoldedWidth(final BigDecimal unfoldedWidth) {
      this.unfoldedWidth = unfoldedWidth;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTotalLength(final String totalLength) {
      this.totalLength = totalLength;
   }

   public void setTotalArea(final String totalArea) {
      this.totalArea = totalArea;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureImportDTO)) {
         return false;
      }

      EnclosureImportDTO other = (EnclosureImportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$bendTimes = this.getBendTimes();
         Object other$bendTimes = other.getBendTimes();
         if (this$bendTimes == null ? other$bendTimes == null : this$bendTimes.equals(other$bendTimes)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$name = this.getName();
               Object other$name = other.getName();
               if (this$name == null ? other$name == null : this$name.equals(other$name)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$plate = this.getPlate();
                     Object other$plate = other.getPlate();
                     if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
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
                                    if (this$plating == null ? other$plating == null : this$plating.equals(other$plating)) {
                                       Object this$thickness = this.getThickness();
                                       Object other$thickness = other.getThickness();
                                       if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                          Object this$width = this.getWidth();
                                          Object other$width = other.getWidth();
                                          if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                             Object this$unfoldedWidth = this.getUnfoldedWidth();
                                             Object other$unfoldedWidth = other.getUnfoldedWidth();
                                             if (this$unfoldedWidth == null ? other$unfoldedWidth == null : this$unfoldedWidth.equals(other$unfoldedWidth)) {
                                                Object this$length = this.getLength();
                                                Object other$length = other.getLength();
                                                if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                                   Object this$totalLength = this.getTotalLength();
                                                   Object other$totalLength = other.getTotalLength();
                                                   if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                                                      Object this$totalArea = this.getTotalArea();
                                                      Object other$totalArea = other.getTotalArea();
                                                      if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                                                         Object this$totalWeight = this.getTotalWeight();
                                                         Object other$totalWeight = other.getTotalWeight();
                                                         if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                                                            Object this$remark = this.getRemark();
                                                            Object other$remark = other.getRemark();
                                                            return this$remark == null ? other$remark == null : this$remark.equals(other$remark);
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
      return other instanceof EnclosureImportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $bendTimes = this.getBendTimes();
      result = result * 59 + ($bendTimes == null ? 43 : $bendTimes.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $material = this.getMaterial();
      result = result * 59 + ($material == null ? 43 : $material.hashCode());
      Object $coating = this.getCoating();
      result = result * 59 + ($coating == null ? 43 : $coating.hashCode());
      Object $plating = this.getPlating();
      result = result * 59 + ($plating == null ? 43 : $plating.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $unfoldedWidth = this.getUnfoldedWidth();
      result = result * 59 + ($unfoldedWidth == null ? 43 : $unfoldedWidth.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $remark = this.getRemark();
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureImportDTO(orderNo="
         + this.getOrderNo()
         + ", name="
         + this.getName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", plate="
         + this.getPlate()
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
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", unfoldedWidth="
         + this.getUnfoldedWidth()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", remark="
         + this.getRemark()
         + ")";
   }
}
