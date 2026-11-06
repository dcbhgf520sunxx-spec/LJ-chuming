package com.hzchum.scim.plan.core.api.pojo.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;

@ExcelTarget("enclosureImportDto")
public class EnclosureImportAllDTO implements Serializable {
   @ApiModelProperty(name = "orderNo", value = "序号")
   @Excel(name = "序号", width = 5.0)
   private Integer orderNo;
   @ApiModelProperty(name = "category", value = "类型id")
   private Long dictionaryId;
   @ApiModelProperty(name = "categoryName", value = "类型")
   @Excel(name = "类型")
   private String dictionaryName;
   @ApiModelProperty(name = "name", value = "名称")
   @Excel(name = "名称", width = 15.0)
   private String name;
   @ApiModelProperty(name = "serialNumber", value = "编号")
   @Excel(name = "编号", width = 15.0)
   private String serialNumber;
   @ApiModelProperty(name = "plate", value = "规格")
   @Excel(name = "规格")
   private String plate;
   @ApiModelProperty(name = "unfoldedWidth", value = "展开宽度")
   @Excel(name = "展开宽度")
   private BigDecimal unfoldedWidth;
   @ApiModelProperty(name = "width", value = "有效宽度")
   @Excel(name = "有效宽度", width = 13.0)
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚度(mm)")
   @Excel(name = "厚度(mm)")
   private BigDecimal thickness;
   @ApiModelProperty(name = "length", value = "单长(mm)")
   @Excel(name = "单长(mm)")
   private BigDecimal length;
   @ApiModelProperty(name = "bendTimes", value = "折弯次数")
   @Excel(name = "折弯次数")
   private Integer bendTimes;
   @ApiModelProperty(name = "unit", value = "计量单位")
   @Excel(name = "计量单位")
   private String unit;
   @ApiModelProperty(name = "quantity", value = "数量")
   @Excel(name = "数量", width = 10.0)
   private Integer quantity;
   @ApiModelProperty(name = "accountingVolume", value = "核算量(米)")
   @Excel(name = "核算量(米)")
   private BigDecimal accountingVolume;
   @ApiModelProperty(name = "surfaceArea", value = "单面积(m²)")
   @Excel(name = "单面积(m²)")
   private BigDecimal surfaceArea;
   @ApiModelProperty(name = "weight", value = "单重量(kg)")
   @Excel(name = "单重量(kg)")
   private BigDecimal weight;
   @ApiModelProperty(name = "remark", value = "备注")
   @Excel(name = "备注", width = 20.0)
   private String remark;

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public String getDictionaryName() {
      return this.dictionaryName;
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

   public Integer getBendTimes() {
      return this.bendTimes;
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

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setDictionaryId(final Long dictionaryId) {
      this.dictionaryId = dictionaryId;
   }

   public void setDictionaryName(final String dictionaryName) {
      this.dictionaryName = dictionaryName;
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

   public void setBendTimes(final Integer bendTimes) {
      this.bendTimes = bendTimes;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof EnclosureImportAllDTO)) {
         return false;
      }

      EnclosureImportAllDTO other = (EnclosureImportAllDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$dictionaryId = this.getDictionaryId();
         Object other$dictionaryId = other.getDictionaryId();
         if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
            Object this$bendTimes = this.getBendTimes();
            Object other$bendTimes = other.getBendTimes();
            if (this$bendTimes == null ? other$bendTimes == null : this$bendTimes.equals(other$bendTimes)) {
               Object this$quantity = this.getQuantity();
               Object other$quantity = other.getQuantity();
               if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                  Object this$dictionaryName = this.getDictionaryName();
                  Object other$dictionaryName = other.getDictionaryName();
                  if (this$dictionaryName == null ? other$dictionaryName == null : this$dictionaryName.equals(other$dictionaryName)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof EnclosureImportAllDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $bendTimes = this.getBendTimes();
      result = result * 59 + ($bendTimes == null ? 43 : $bendTimes.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $dictionaryName = this.getDictionaryName();
      result = result * 59 + ($dictionaryName == null ? 43 : $dictionaryName.hashCode());
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
      return result * 59 + ($remark == null ? 43 : $remark.hashCode());
   }

   @Override
   public String toString() {
      return "EnclosureImportAllDTO(orderNo="
         + this.getOrderNo()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", dictionaryName="
         + this.getDictionaryName()
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
         + ", bendTimes="
         + this.getBendTimes()
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
         + ")";
   }
}
