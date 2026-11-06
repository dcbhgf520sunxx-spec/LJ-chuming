package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class CommonDetailsDO {
   @ApiModelProperty(name = "yearMonth", value = "出/退库日期")
   private String yearMonth;
   @ApiModelProperty(name = "type", value = "类型")
   private String type;
   @ApiModelProperty(name = "basicClass", value = "物料基础类型")
   private Long basicClass;
   @ApiModelProperty(name = "classifyId", value = "物料种类ID")
   private Long classifyId;
   @ApiModelProperty(name = "classifyName", value = "物料种类")
   private String classifyName;
   @ApiModelProperty(name = "length", value = "长度")
   private BigDecimal length;
   @ApiModelProperty(name = "width", value = "宽度")
   private BigDecimal width;
   @ApiModelProperty(name = "thickness", value = "厚度")
   private BigDecimal thickness;
   @ApiModelProperty(name = "specification", value = "规格")
   private String specification;
   @ApiModelProperty(name = "model", value = "材质(型号)")
   private String model;
   @ApiModelProperty(name = "brand", value = "品牌")
   private String brand;
   @ApiModelProperty(name = "measureUnit", value = "计量单位")
   private String measureUnit;
   @ApiModelProperty(name = "quantityCount", value = "数量")
   private BigDecimal quantityCount;
   @ApiModelProperty(name = "accountingUnit", value = "核算单位")
   private String accountingUnit;
   @ApiModelProperty(name = "meteCount", value = "核算量")
   private BigDecimal meteCount;
   @ApiModelProperty(name = "unitPrice", value = "含税-单价(元)")
   private BigDecimal unitPrice;
   @ApiModelProperty(name = "unitPrice", value = "不含税-单价(元)")
   private BigDecimal unitPriceExcludingVAT;
   @ApiModelProperty(name = "amount", value = "含税-金额汇总")
   private BigDecimal amountCount;
   @ApiModelProperty(name = "amount", value = "不含税-金额汇总")
   private BigDecimal amountExcludingVatCount;
   @ApiModelProperty(name = "serialNumber", value = "出/退库单据号")
   private String serialNumber;
   @ApiModelProperty(name = "workshopId", value = "领用车间ID")
   private Long workshopId;
   @ApiModelProperty(name = "workshopName", value = "领用车间")
   private String workshopName;
   @ApiModelProperty(name = "boolWeighting", value = "是否加权")
   private Boolean boolWeighting;

   public String getYearMonth() {
      return this.yearMonth;
   }

   public String getType() {
      return this.type;
   }

   public Long getBasicClass() {
      return this.basicClass;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public String getClassifyName() {
      return this.classifyName;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getModel() {
      return this.model;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public BigDecimal getQuantityCount() {
      return this.quantityCount;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMeteCount() {
      return this.meteCount;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getUnitPriceExcludingVAT() {
      return this.unitPriceExcludingVAT;
   }

   public BigDecimal getAmountCount() {
      return this.amountCount;
   }

   public BigDecimal getAmountExcludingVatCount() {
      return this.amountExcludingVatCount;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Boolean getBoolWeighting() {
      return this.boolWeighting;
   }

   public void setYearMonth(final String yearMonth) {
      this.yearMonth = yearMonth;
   }

   public void setType(final String type) {
      this.type = type;
   }

   public void setBasicClass(final Long basicClass) {
      this.basicClass = basicClass;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setClassifyName(final String classifyName) {
      this.classifyName = classifyName;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setModel(final String model) {
      this.model = model;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setQuantityCount(final BigDecimal quantityCount) {
      this.quantityCount = quantityCount;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMeteCount(final BigDecimal meteCount) {
      this.meteCount = meteCount;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setUnitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
   }

   public void setAmountCount(final BigDecimal amountCount) {
      this.amountCount = amountCount;
   }

   public void setAmountExcludingVatCount(final BigDecimal amountExcludingVatCount) {
      this.amountExcludingVatCount = amountExcludingVatCount;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setBoolWeighting(final Boolean boolWeighting) {
      this.boolWeighting = boolWeighting;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CommonDetailsDO)) {
         return false;
      }

      CommonDetailsDO other = (CommonDetailsDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$basicClass = this.getBasicClass();
      Object other$basicClass = other.getBasicClass();
      if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
         Object this$classifyId = this.getClassifyId();
         Object other$classifyId = other.getClassifyId();
         if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
            Object this$workshopId = this.getWorkshopId();
            Object other$workshopId = other.getWorkshopId();
            if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
               Object this$boolWeighting = this.getBoolWeighting();
               Object other$boolWeighting = other.getBoolWeighting();
               if (this$boolWeighting == null ? other$boolWeighting == null : this$boolWeighting.equals(other$boolWeighting)) {
                  Object this$yearMonth = this.getYearMonth();
                  Object other$yearMonth = other.getYearMonth();
                  if (this$yearMonth == null ? other$yearMonth == null : this$yearMonth.equals(other$yearMonth)) {
                     Object this$type = this.getType();
                     Object other$type = other.getType();
                     if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                        Object this$classifyName = this.getClassifyName();
                        Object other$classifyName = other.getClassifyName();
                        if (this$classifyName == null ? other$classifyName == null : this$classifyName.equals(other$classifyName)) {
                           Object this$length = this.getLength();
                           Object other$length = other.getLength();
                           if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                              Object this$width = this.getWidth();
                              Object other$width = other.getWidth();
                              if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                 Object this$thickness = this.getThickness();
                                 Object other$thickness = other.getThickness();
                                 if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                    Object this$specification = this.getSpecification();
                                    Object other$specification = other.getSpecification();
                                    if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                                       Object this$model = this.getModel();
                                       Object other$model = other.getModel();
                                       if (this$model == null ? other$model == null : this$model.equals(other$model)) {
                                          Object this$brand = this.getBrand();
                                          Object other$brand = other.getBrand();
                                          if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                             Object this$measureUnit = this.getMeasureUnit();
                                             Object other$measureUnit = other.getMeasureUnit();
                                             if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                Object this$quantityCount = this.getQuantityCount();
                                                Object other$quantityCount = other.getQuantityCount();
                                                if (this$quantityCount == null ? other$quantityCount == null : this$quantityCount.equals(other$quantityCount)) {
                                                   Object this$accountingUnit = this.getAccountingUnit();
                                                   Object other$accountingUnit = other.getAccountingUnit();
                                                   if (this$accountingUnit == null
                                                      ? other$accountingUnit == null
                                                      : this$accountingUnit.equals(other$accountingUnit)) {
                                                      Object this$meteCount = this.getMeteCount();
                                                      Object other$meteCount = other.getMeteCount();
                                                      if (this$meteCount == null ? other$meteCount == null : this$meteCount.equals(other$meteCount)) {
                                                         Object this$unitPrice = this.getUnitPrice();
                                                         Object other$unitPrice = other.getUnitPrice();
                                                         if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                                            Object this$unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
                                                            Object other$unitPriceExcludingVAT = other.getUnitPriceExcludingVAT();
                                                            if (this$unitPriceExcludingVAT == null
                                                               ? other$unitPriceExcludingVAT == null
                                                               : this$unitPriceExcludingVAT.equals(other$unitPriceExcludingVAT)) {
                                                               Object this$amountCount = this.getAmountCount();
                                                               Object other$amountCount = other.getAmountCount();
                                                               if (this$amountCount == null
                                                                  ? other$amountCount == null
                                                                  : this$amountCount.equals(other$amountCount)) {
                                                                  Object this$amountExcludingVatCount = this.getAmountExcludingVatCount();
                                                                  Object other$amountExcludingVatCount = other.getAmountExcludingVatCount();
                                                                  if (this$amountExcludingVatCount == null
                                                                     ? other$amountExcludingVatCount == null
                                                                     : this$amountExcludingVatCount.equals(other$amountExcludingVatCount)) {
                                                                     Object this$serialNumber = this.getSerialNumber();
                                                                     Object other$serialNumber = other.getSerialNumber();
                                                                     if (this$serialNumber == null
                                                                        ? other$serialNumber == null
                                                                        : this$serialNumber.equals(other$serialNumber)) {
                                                                        Object this$workshopName = this.getWorkshopName();
                                                                        Object other$workshopName = other.getWorkshopName();
                                                                        return this$workshopName == null
                                                                           ? other$workshopName == null
                                                                           : this$workshopName.equals(other$workshopName);
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
      return other instanceof CommonDetailsDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $boolWeighting = this.getBoolWeighting();
      result = result * 59 + ($boolWeighting == null ? 43 : $boolWeighting.hashCode());
      Object $yearMonth = this.getYearMonth();
      result = result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $model = this.getModel();
      result = result * 59 + ($model == null ? 43 : $model.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $quantityCount = this.getQuantityCount();
      result = result * 59 + ($quantityCount == null ? 43 : $quantityCount.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $meteCount = this.getMeteCount();
      result = result * 59 + ($meteCount == null ? 43 : $meteCount.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
      result = result * 59 + ($unitPriceExcludingVAT == null ? 43 : $unitPriceExcludingVAT.hashCode());
      Object $amountCount = this.getAmountCount();
      result = result * 59 + ($amountCount == null ? 43 : $amountCount.hashCode());
      Object $amountExcludingVatCount = this.getAmountExcludingVatCount();
      result = result * 59 + ($amountExcludingVatCount == null ? 43 : $amountExcludingVatCount.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $workshopName = this.getWorkshopName();
      return result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
   }

   @Override
   public String toString() {
      return "CommonDetailsDO(yearMonth="
         + this.getYearMonth()
         + ", type="
         + this.getType()
         + ", basicClass="
         + this.getBasicClass()
         + ", classifyId="
         + this.getClassifyId()
         + ", classifyName="
         + this.getClassifyName()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", thickness="
         + this.getThickness()
         + ", specification="
         + this.getSpecification()
         + ", model="
         + this.getModel()
         + ", brand="
         + this.getBrand()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", quantityCount="
         + this.getQuantityCount()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", meteCount="
         + this.getMeteCount()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceExcludingVAT="
         + this.getUnitPriceExcludingVAT()
         + ", amountCount="
         + this.getAmountCount()
         + ", amountExcludingVatCount="
         + this.getAmountExcludingVatCount()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", boolWeighting="
         + this.getBoolWeighting()
         + ")";
   }
}
