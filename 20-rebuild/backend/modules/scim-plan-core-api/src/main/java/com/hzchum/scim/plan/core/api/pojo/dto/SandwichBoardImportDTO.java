package com.hzchum.scim.plan.core.api.pojo.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelCollection;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@ExcelTarget("sandwichBoardImportDTO")
public class SandwichBoardImportDTO implements Serializable {
   @ApiModelProperty(name = "orderNo", value = "序号")
   @Excel(name = "序号", needMerge = true)
   private Integer orderNo;
   @ApiModelProperty(name = "name", value = "名称")
   @Excel(name = "名称", needMerge = true)
   private String name;
   @ApiModelProperty(name = "plate", value = "版型")
   @Excel(name = "版型", needMerge = true)
   private String plate;
   @ApiModelProperty(name = "thickness", value = "厚度（mm）")
   @Excel(name = "板厚(mm)", needMerge = true)
   private BigDecimal thickness;
   @ApiModelProperty(name = "width", value = "宽度（mm）")
   @Excel(name = "有效宽度(mm)", needMerge = true)
   private BigDecimal width;
   @ApiModelProperty(name = "length", value = "长度（mm）")
   @Excel(name = "单长(mm)", needMerge = true)
   private BigDecimal length;
   @ApiModelProperty(name = "quantity", value = "数量")
   @Excel(name = "数量(张)", needMerge = true)
   private Integer quantity;
   @ApiModelProperty(name = "totalLength", value = "总长度（m）")
   @Excel(name = "总长度(m)", needMerge = true)
   private BigDecimal totalLength;
   @ApiModelProperty(name = "totalArea", value = "总面积（m²）")
   @Excel(name = "总面积(m²)", needMerge = true)
   private BigDecimal totalArea;
   @ApiModelProperty(name = "remark", value = "备注")
   @Excel(name = "备注", needMerge = true)
   private String remark;
   @Excel(name = "芯材品牌", needMerge = true)
   private String brand;
   @Excel(name = "芯材种类", needMerge = true)
   private String type;
   @Excel(name = "芯材容重(kg/m³)", needMerge = true)
   private BigDecimal capacity;
   @ApiModelProperty(name = "sandwichBoardImportList", value = "彩板信息列表")
   @ExcelCollection(name = "彩板信息")
   private List<SandwichColorBoardDTO> sandwichBoardImportList;

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getName() {
      return this.name;
   }

   public String getPlate() {
      return this.plate;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalLength() {
      return this.totalLength;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
   }

   public String getRemark() {
      return this.remark;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getType() {
      return this.type;
   }

   public BigDecimal getCapacity() {
      return this.capacity;
   }

   public List<SandwichColorBoardDTO> getSandwichBoardImportList() {
      return this.sandwichBoardImportList;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setPlate(final String plate) {
      this.plate = plate;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTotalLength(final BigDecimal totalLength) {
      this.totalLength = totalLength;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setType(final String type) {
      this.type = type;
   }

   public void setCapacity(final BigDecimal capacity) {
      this.capacity = capacity;
   }

   public void setSandwichBoardImportList(final List<SandwichColorBoardDTO> sandwichBoardImportList) {
      this.sandwichBoardImportList = sandwichBoardImportList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SandwichBoardImportDTO)) {
         return false;
      }

      SandwichBoardImportDTO other = (SandwichBoardImportDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$plate = this.getPlate();
               Object other$plate = other.getPlate();
               if (this$plate == null ? other$plate == null : this$plate.equals(other$plate)) {
                  Object this$thickness = this.getThickness();
                  Object other$thickness = other.getThickness();
                  if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                     Object this$width = this.getWidth();
                     Object other$width = other.getWidth();
                     if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                        Object this$length = this.getLength();
                        Object other$length = other.getLength();
                        if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                           Object this$totalLength = this.getTotalLength();
                           Object other$totalLength = other.getTotalLength();
                           if (this$totalLength == null ? other$totalLength == null : this$totalLength.equals(other$totalLength)) {
                              Object this$totalArea = this.getTotalArea();
                              Object other$totalArea = other.getTotalArea();
                              if (this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea)) {
                                 Object this$remark = this.getRemark();
                                 Object other$remark = other.getRemark();
                                 if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                                    Object this$brand = this.getBrand();
                                    Object other$brand = other.getBrand();
                                    if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                       Object this$type = this.getType();
                                       Object other$type = other.getType();
                                       if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                                          Object this$capacity = this.getCapacity();
                                          Object other$capacity = other.getCapacity();
                                          if (this$capacity == null ? other$capacity == null : this$capacity.equals(other$capacity)) {
                                             Object this$sandwichBoardImportList = this.getSandwichBoardImportList();
                                             Object other$sandwichBoardImportList = other.getSandwichBoardImportList();
                                             return this$sandwichBoardImportList == null
                                                ? other$sandwichBoardImportList == null
                                                : this$sandwichBoardImportList.equals(other$sandwichBoardImportList);
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
      return other instanceof SandwichBoardImportDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $plate = this.getPlate();
      result = result * 59 + ($plate == null ? 43 : $plate.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $totalLength = this.getTotalLength();
      result = result * 59 + ($totalLength == null ? 43 : $totalLength.hashCode());
      Object $totalArea = this.getTotalArea();
      result = result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $capacity = this.getCapacity();
      result = result * 59 + ($capacity == null ? 43 : $capacity.hashCode());
      Object $sandwichBoardImportList = this.getSandwichBoardImportList();
      return result * 59 + ($sandwichBoardImportList == null ? 43 : $sandwichBoardImportList.hashCode());
   }

   @Override
   public String toString() {
      return "SandwichBoardImportDTO(orderNo="
         + this.getOrderNo()
         + ", name="
         + this.getName()
         + ", plate="
         + this.getPlate()
         + ", thickness="
         + this.getThickness()
         + ", width="
         + this.getWidth()
         + ", length="
         + this.getLength()
         + ", quantity="
         + this.getQuantity()
         + ", totalLength="
         + this.getTotalLength()
         + ", totalArea="
         + this.getTotalArea()
         + ", remark="
         + this.getRemark()
         + ", brand="
         + this.getBrand()
         + ", type="
         + this.getType()
         + ", capacity="
         + this.getCapacity()
         + ", sandwichBoardImportList="
         + this.getSandwichBoardImportList()
         + ")";
   }
}
