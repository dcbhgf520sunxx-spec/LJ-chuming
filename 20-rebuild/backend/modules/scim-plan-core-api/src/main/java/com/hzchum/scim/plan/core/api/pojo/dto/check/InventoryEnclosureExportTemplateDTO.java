package com.hzchum.scim.plan.core.api.pojo.dto.check;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import io.swagger.annotations.ApiModel;
import java.io.Serializable;
import java.math.BigDecimal;

@ExcelTarget("InventoryEnclosureExportTemplateDTO")
@ApiModel("清单操作记录-导出DTO")
public class InventoryEnclosureExportTemplateDTO implements Serializable {
   @Excel(name = "序号", width = 5.0)
   private Integer orderNo;
   private Long dictionaryId;
   @Excel(name = "字典名称", width = 15.0)
   private String dictionaryName;
   @Excel(name = "编号", width = 15.0)
   private String serialNumber;
   @Excel(name = "规格", width = 15.0)
   private String plate;
   @Excel(name = "展宽(mm)", width = 15.0)
   private BigDecimal unfoldedWidth;
   @Excel(name = "有效宽度(mm)", width = 15.0)
   private BigDecimal width;
   @Excel(name = "板厚(mm)", width = 15.0)
   private BigDecimal thickness;
   @Excel(name = "单长度(mm)", width = 15.0)
   private BigDecimal length;
   @Excel(name = "计量单位", width = 15.0)
   private String unit;
   @Excel(name = "数量", width = 15.0)
   private Integer quantity;
   @Excel(name = "核算量(米)", width = 15.0)
   private BigDecimal accountingVolume;
   @Excel(name = "重量(kg)", width = 15.0)
   private BigDecimal weight;
   @Excel(name = "总重量(kg)", width = 15.0)
   private BigDecimal totalWeight;
   @Excel(name = "单面积(mm²)", width = 15.0)
   private BigDecimal surfaceArea;
   @Excel(name = "总面积(mm²)", width = 15.0)
   private BigDecimal totalArea;

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public Long getDictionaryId() {
      return this.dictionaryId;
   }

   public String getDictionaryName() {
      return this.dictionaryName;
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

   public BigDecimal getWeight() {
      return this.weight;
   }

   public BigDecimal getTotalWeight() {
      return this.totalWeight;
   }

   public BigDecimal getSurfaceArea() {
      return this.surfaceArea;
   }

   public BigDecimal getTotalArea() {
      return this.totalArea;
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

   public void setWeight(final BigDecimal weight) {
      this.weight = weight;
   }

   public void setTotalWeight(final BigDecimal totalWeight) {
      this.totalWeight = totalWeight;
   }

   public void setSurfaceArea(final BigDecimal surfaceArea) {
      this.surfaceArea = surfaceArea;
   }

   public void setTotalArea(final BigDecimal totalArea) {
      this.totalArea = totalArea;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryEnclosureExportTemplateDTO)) {
         return false;
      }

      InventoryEnclosureExportTemplateDTO other = (InventoryEnclosureExportTemplateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$dictionaryId = this.getDictionaryId();
         Object other$dictionaryId = other.getDictionaryId();
         if (this$dictionaryId == null ? other$dictionaryId == null : this$dictionaryId.equals(other$dictionaryId)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$dictionaryName = this.getDictionaryName();
               Object other$dictionaryName = other.getDictionaryName();
               if (this$dictionaryName == null ? other$dictionaryName == null : this$dictionaryName.equals(other$dictionaryName)) {
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
                                          Object this$weight = this.getWeight();
                                          Object other$weight = other.getWeight();
                                          if (this$weight == null ? other$weight == null : this$weight.equals(other$weight)) {
                                             Object this$totalWeight = this.getTotalWeight();
                                             Object other$totalWeight = other.getTotalWeight();
                                             if (this$totalWeight == null ? other$totalWeight == null : this$totalWeight.equals(other$totalWeight)) {
                                                Object this$surfaceArea = this.getSurfaceArea();
                                                Object other$surfaceArea = other.getSurfaceArea();
                                                if (this$surfaceArea == null ? other$surfaceArea == null : this$surfaceArea.equals(other$surfaceArea)) {
                                                   Object this$totalArea = this.getTotalArea();
                                                   Object other$totalArea = other.getTotalArea();
                                                   return this$totalArea == null ? other$totalArea == null : this$totalArea.equals(other$totalArea);
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
      return other instanceof InventoryEnclosureExportTemplateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $dictionaryId = this.getDictionaryId();
      result = result * 59 + ($dictionaryId == null ? 43 : $dictionaryId.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $dictionaryName = this.getDictionaryName();
      result = result * 59 + ($dictionaryName == null ? 43 : $dictionaryName.hashCode());
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
      Object $weight = this.getWeight();
      result = result * 59 + ($weight == null ? 43 : $weight.hashCode());
      Object $totalWeight = this.getTotalWeight();
      result = result * 59 + ($totalWeight == null ? 43 : $totalWeight.hashCode());
      Object $surfaceArea = this.getSurfaceArea();
      result = result * 59 + ($surfaceArea == null ? 43 : $surfaceArea.hashCode());
      Object $totalArea = this.getTotalArea();
      return result * 59 + ($totalArea == null ? 43 : $totalArea.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryEnclosureExportTemplateDTO(orderNo="
         + this.getOrderNo()
         + ", dictionaryId="
         + this.getDictionaryId()
         + ", dictionaryName="
         + this.getDictionaryName()
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
         + ", weight="
         + this.getWeight()
         + ", totalWeight="
         + this.getTotalWeight()
         + ", surfaceArea="
         + this.getSurfaceArea()
         + ", totalArea="
         + this.getTotalArea()
         + ")";
   }
}
