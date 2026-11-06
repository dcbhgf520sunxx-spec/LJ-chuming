package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

import java.math.BigDecimal;

public class MoveMaterialMaterialDO {
   private Long id;
   private Boolean boolPartyA;
   private Long classifyId;
   private Integer basicClass;
   private String specification;
   private BigDecimal quantity;
   private BigDecimal thickness;
   private BigDecimal length;
   private BigDecimal width;
   private String brand;
   private String heatNoAndBatchNo;
   private String color;
   private Integer invoiceType;
   private BigDecimal taxRate;
   private BigDecimal mete;
   private BigDecimal unitPrice;
   private BigDecimal unitPriceExcludingVAT;
   private BigDecimal amount;
   private BigDecimal amountExcludingVAT;
   private BigDecimal inputVAT;
   private Long standardId;
   private String nationalStandard;
   private MoveMaterialDO receipt;
   private BigDecimal quantityCount;
   private BigDecimal meteCount;
   private BigDecimal amountCount;
   private BigDecimal amountExcludingVatCount;
   private String serialNumber;

   public static MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder builder() {
      return new MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Boolean getBoolPartyA() {
      return this.boolPartyA;
   }

   public Long getClassifyId() {
      return this.classifyId;
   }

   public Integer getBasicClass() {
      return this.basicClass;
   }

   public String getSpecification() {
      return this.specification;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public BigDecimal getThickness() {
      return this.thickness;
   }

   public BigDecimal getLength() {
      return this.length;
   }

   public BigDecimal getWidth() {
      return this.width;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getColor() {
      return this.color;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public BigDecimal getUnitPriceExcludingVAT() {
      return this.unitPriceExcludingVAT;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getAmountExcludingVAT() {
      return this.amountExcludingVAT;
   }

   public BigDecimal getInputVAT() {
      return this.inputVAT;
   }

   public Long getStandardId() {
      return this.standardId;
   }

   public String getNationalStandard() {
      return this.nationalStandard;
   }

   public MoveMaterialDO getReceipt() {
      return this.receipt;
   }

   public BigDecimal getQuantityCount() {
      return this.quantityCount;
   }

   public BigDecimal getMeteCount() {
      return this.meteCount;
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

   public void setId(final Long id) {
      this.id = id;
   }

   public void setBoolPartyA(final Boolean boolPartyA) {
      this.boolPartyA = boolPartyA;
   }

   public void setClassifyId(final Long classifyId) {
      this.classifyId = classifyId;
   }

   public void setBasicClass(final Integer basicClass) {
      this.basicClass = basicClass;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setThickness(final BigDecimal thickness) {
      this.thickness = thickness;
   }

   public void setLength(final BigDecimal length) {
      this.length = length;
   }

   public void setWidth(final BigDecimal width) {
      this.width = width;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setUnitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setAmountExcludingVAT(final BigDecimal amountExcludingVAT) {
      this.amountExcludingVAT = amountExcludingVAT;
   }

   public void setInputVAT(final BigDecimal inputVAT) {
      this.inputVAT = inputVAT;
   }

   public void setStandardId(final Long standardId) {
      this.standardId = standardId;
   }

   public void setNationalStandard(final String nationalStandard) {
      this.nationalStandard = nationalStandard;
   }

   public void setReceipt(final MoveMaterialDO receipt) {
      this.receipt = receipt;
   }

   public void setQuantityCount(final BigDecimal quantityCount) {
      this.quantityCount = quantityCount;
   }

   public void setMeteCount(final BigDecimal meteCount) {
      this.meteCount = meteCount;
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

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MoveMaterialMaterialDO)) {
         return false;
      }

      MoveMaterialMaterialDO other = (MoveMaterialMaterialDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$boolPartyA = this.getBoolPartyA();
         Object other$boolPartyA = other.getBoolPartyA();
         if (this$boolPartyA == null ? other$boolPartyA == null : this$boolPartyA.equals(other$boolPartyA)) {
            Object this$classifyId = this.getClassifyId();
            Object other$classifyId = other.getClassifyId();
            if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
               Object this$basicClass = this.getBasicClass();
               Object other$basicClass = other.getBasicClass();
               if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                  Object this$invoiceType = this.getInvoiceType();
                  Object other$invoiceType = other.getInvoiceType();
                  if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                     Object this$standardId = this.getStandardId();
                     Object other$standardId = other.getStandardId();
                     if (this$standardId == null ? other$standardId == null : this$standardId.equals(other$standardId)) {
                        Object this$specification = this.getSpecification();
                        Object other$specification = other.getSpecification();
                        if (this$specification == null ? other$specification == null : this$specification.equals(other$specification)) {
                           Object this$quantity = this.getQuantity();
                           Object other$quantity = other.getQuantity();
                           if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                              Object this$thickness = this.getThickness();
                              Object other$thickness = other.getThickness();
                              if (this$thickness == null ? other$thickness == null : this$thickness.equals(other$thickness)) {
                                 Object this$length = this.getLength();
                                 Object other$length = other.getLength();
                                 if (this$length == null ? other$length == null : this$length.equals(other$length)) {
                                    Object this$width = this.getWidth();
                                    Object other$width = other.getWidth();
                                    if (this$width == null ? other$width == null : this$width.equals(other$width)) {
                                       Object this$brand = this.getBrand();
                                       Object other$brand = other.getBrand();
                                       if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                          Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                          Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                          if (this$heatNoAndBatchNo == null
                                             ? other$heatNoAndBatchNo == null
                                             : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                             Object this$color = this.getColor();
                                             Object other$color = other.getColor();
                                             if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                Object this$taxRate = this.getTaxRate();
                                                Object other$taxRate = other.getTaxRate();
                                                if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                                   Object this$mete = this.getMete();
                                                   Object other$mete = other.getMete();
                                                   if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                      Object this$unitPrice = this.getUnitPrice();
                                                      Object other$unitPrice = other.getUnitPrice();
                                                      if (this$unitPrice == null ? other$unitPrice == null : this$unitPrice.equals(other$unitPrice)) {
                                                         Object this$unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
                                                         Object other$unitPriceExcludingVAT = other.getUnitPriceExcludingVAT();
                                                         if (this$unitPriceExcludingVAT == null
                                                            ? other$unitPriceExcludingVAT == null
                                                            : this$unitPriceExcludingVAT.equals(other$unitPriceExcludingVAT)) {
                                                            Object this$amount = this.getAmount();
                                                            Object other$amount = other.getAmount();
                                                            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                               Object this$amountExcludingVAT = this.getAmountExcludingVAT();
                                                               Object other$amountExcludingVAT = other.getAmountExcludingVAT();
                                                               if (this$amountExcludingVAT == null
                                                                  ? other$amountExcludingVAT == null
                                                                  : this$amountExcludingVAT.equals(other$amountExcludingVAT)) {
                                                                  Object this$inputVAT = this.getInputVAT();
                                                                  Object other$inputVAT = other.getInputVAT();
                                                                  if (this$inputVAT == null ? other$inputVAT == null : this$inputVAT.equals(other$inputVAT)) {
                                                                     Object this$nationalStandard = this.getNationalStandard();
                                                                     Object other$nationalStandard = other.getNationalStandard();
                                                                     if (this$nationalStandard == null
                                                                        ? other$nationalStandard == null
                                                                        : this$nationalStandard.equals(other$nationalStandard)) {
                                                                        Object this$receipt = this.getReceipt();
                                                                        Object other$receipt = other.getReceipt();
                                                                        if (this$receipt == null ? other$receipt == null : this$receipt.equals(other$receipt)) {
                                                                           Object this$quantityCount = this.getQuantityCount();
                                                                           Object other$quantityCount = other.getQuantityCount();
                                                                           if (this$quantityCount == null
                                                                              ? other$quantityCount == null
                                                                              : this$quantityCount.equals(other$quantityCount)) {
                                                                              Object this$meteCount = this.getMeteCount();
                                                                              Object other$meteCount = other.getMeteCount();
                                                                              if (this$meteCount == null
                                                                                 ? other$meteCount == null
                                                                                 : this$meteCount.equals(other$meteCount)) {
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
                                                                                       return this$serialNumber == null
                                                                                          ? other$serialNumber == null
                                                                                          : this$serialNumber.equals(other$serialNumber);
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
      return other instanceof MoveMaterialMaterialDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $boolPartyA = this.getBoolPartyA();
      result = result * 59 + ($boolPartyA == null ? 43 : $boolPartyA.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $standardId = this.getStandardId();
      result = result * 59 + ($standardId == null ? 43 : $standardId.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $unitPriceExcludingVAT = this.getUnitPriceExcludingVAT();
      result = result * 59 + ($unitPriceExcludingVAT == null ? 43 : $unitPriceExcludingVAT.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $amountExcludingVAT = this.getAmountExcludingVAT();
      result = result * 59 + ($amountExcludingVAT == null ? 43 : $amountExcludingVAT.hashCode());
      Object $inputVAT = this.getInputVAT();
      result = result * 59 + ($inputVAT == null ? 43 : $inputVAT.hashCode());
      Object $nationalStandard = this.getNationalStandard();
      result = result * 59 + ($nationalStandard == null ? 43 : $nationalStandard.hashCode());
      Object $receipt = this.getReceipt();
      result = result * 59 + ($receipt == null ? 43 : $receipt.hashCode());
      Object $quantityCount = this.getQuantityCount();
      result = result * 59 + ($quantityCount == null ? 43 : $quantityCount.hashCode());
      Object $meteCount = this.getMeteCount();
      result = result * 59 + ($meteCount == null ? 43 : $meteCount.hashCode());
      Object $amountCount = this.getAmountCount();
      result = result * 59 + ($amountCount == null ? 43 : $amountCount.hashCode());
      Object $amountExcludingVatCount = this.getAmountExcludingVatCount();
      result = result * 59 + ($amountExcludingVatCount == null ? 43 : $amountExcludingVatCount.hashCode());
      Object $serialNumber = this.getSerialNumber();
      return result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "MoveMaterialMaterialDO(id="
         + this.getId()
         + ", boolPartyA="
         + this.getBoolPartyA()
         + ", classifyId="
         + this.getClassifyId()
         + ", basicClass="
         + this.getBasicClass()
         + ", specification="
         + this.getSpecification()
         + ", quantity="
         + this.getQuantity()
         + ", thickness="
         + this.getThickness()
         + ", length="
         + this.getLength()
         + ", width="
         + this.getWidth()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", color="
         + this.getColor()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", mete="
         + this.getMete()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", unitPriceExcludingVAT="
         + this.getUnitPriceExcludingVAT()
         + ", amount="
         + this.getAmount()
         + ", amountExcludingVAT="
         + this.getAmountExcludingVAT()
         + ", inputVAT="
         + this.getInputVAT()
         + ", standardId="
         + this.getStandardId()
         + ", nationalStandard="
         + this.getNationalStandard()
         + ", receipt="
         + this.getReceipt()
         + ", quantityCount="
         + this.getQuantityCount()
         + ", meteCount="
         + this.getMeteCount()
         + ", amountCount="
         + this.getAmountCount()
         + ", amountExcludingVatCount="
         + this.getAmountExcludingVatCount()
         + ", serialNumber="
         + this.getSerialNumber()
         + ")";
   }

   public MoveMaterialMaterialDO(
      final Long id,
      final Boolean boolPartyA,
      final Long classifyId,
      final Integer basicClass,
      final String specification,
      final BigDecimal quantity,
      final BigDecimal thickness,
      final BigDecimal length,
      final BigDecimal width,
      final String brand,
      final String heatNoAndBatchNo,
      final String color,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final BigDecimal mete,
      final BigDecimal unitPrice,
      final BigDecimal unitPriceExcludingVAT,
      final BigDecimal amount,
      final BigDecimal amountExcludingVAT,
      final BigDecimal inputVAT,
      final Long standardId,
      final String nationalStandard,
      final MoveMaterialDO receipt,
      final BigDecimal quantityCount,
      final BigDecimal meteCount,
      final BigDecimal amountCount,
      final BigDecimal amountExcludingVatCount,
      final String serialNumber
   ) {
      this.id = id;
      this.boolPartyA = boolPartyA;
      this.classifyId = classifyId;
      this.basicClass = basicClass;
      this.specification = specification;
      this.quantity = quantity;
      this.thickness = thickness;
      this.length = length;
      this.width = width;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.color = color;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.mete = mete;
      this.unitPrice = unitPrice;
      this.unitPriceExcludingVAT = unitPriceExcludingVAT;
      this.amount = amount;
      this.amountExcludingVAT = amountExcludingVAT;
      this.inputVAT = inputVAT;
      this.standardId = standardId;
      this.nationalStandard = nationalStandard;
      this.receipt = receipt;
      this.quantityCount = quantityCount;
      this.meteCount = meteCount;
      this.amountCount = amountCount;
      this.amountExcludingVatCount = amountExcludingVatCount;
      this.serialNumber = serialNumber;
   }

   public MoveMaterialMaterialDO() {
   }

   public static class MoveMaterialMaterialDOBuilder {
      private Long id;
      private Boolean boolPartyA;
      private Long classifyId;
      private Integer basicClass;
      private String specification;
      private BigDecimal quantity;
      private BigDecimal thickness;
      private BigDecimal length;
      private BigDecimal width;
      private String brand;
      private String heatNoAndBatchNo;
      private String color;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private BigDecimal mete;
      private BigDecimal unitPrice;
      private BigDecimal unitPriceExcludingVAT;
      private BigDecimal amount;
      private BigDecimal amountExcludingVAT;
      private BigDecimal inputVAT;
      private Long standardId;
      private String nationalStandard;
      private MoveMaterialDO receipt;
      private BigDecimal quantityCount;
      private BigDecimal meteCount;
      private BigDecimal amountCount;
      private BigDecimal amountExcludingVatCount;
      private String serialNumber;

      MoveMaterialMaterialDOBuilder() {
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder unitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
         this.unitPriceExcludingVAT = unitPriceExcludingVAT;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder inputVAT(final BigDecimal inputVAT) {
         this.inputVAT = inputVAT;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder receipt(final MoveMaterialDO receipt) {
         this.receipt = receipt;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder quantityCount(final BigDecimal quantityCount) {
         this.quantityCount = quantityCount;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder meteCount(final BigDecimal meteCount) {
         this.meteCount = meteCount;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder amountCount(final BigDecimal amountCount) {
         this.amountCount = amountCount;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder amountExcludingVatCount(final BigDecimal amountExcludingVatCount) {
         this.amountExcludingVatCount = amountExcludingVatCount;
         return this;
      }

      public MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MoveMaterialMaterialDO build() {
         return new MoveMaterialMaterialDO(
            this.id,
            this.boolPartyA,
            this.classifyId,
            this.basicClass,
            this.specification,
            this.quantity,
            this.thickness,
            this.length,
            this.width,
            this.brand,
            this.heatNoAndBatchNo,
            this.color,
            this.invoiceType,
            this.taxRate,
            this.mete,
            this.unitPrice,
            this.unitPriceExcludingVAT,
            this.amount,
            this.amountExcludingVAT,
            this.inputVAT,
            this.standardId,
            this.nationalStandard,
            this.receipt,
            this.quantityCount,
            this.meteCount,
            this.amountCount,
            this.amountExcludingVatCount,
            this.serialNumber
         );
      }

      @Override
      public String toString() {
         return "MoveMaterialMaterialDO.MoveMaterialMaterialDOBuilder(id="
            + this.id
            + ", boolPartyA="
            + this.boolPartyA
            + ", classifyId="
            + this.classifyId
            + ", basicClass="
            + this.basicClass
            + ", specification="
            + this.specification
            + ", quantity="
            + this.quantity
            + ", thickness="
            + this.thickness
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", color="
            + this.color
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", mete="
            + this.mete
            + ", unitPrice="
            + this.unitPrice
            + ", unitPriceExcludingVAT="
            + this.unitPriceExcludingVAT
            + ", amount="
            + this.amount
            + ", amountExcludingVAT="
            + this.amountExcludingVAT
            + ", inputVAT="
            + this.inputVAT
            + ", standardId="
            + this.standardId
            + ", nationalStandard="
            + this.nationalStandard
            + ", receipt="
            + this.receipt
            + ", quantityCount="
            + this.quantityCount
            + ", meteCount="
            + this.meteCount
            + ", amountCount="
            + this.amountCount
            + ", amountExcludingVatCount="
            + this.amountExcludingVatCount
            + ", serialNumber="
            + this.serialNumber
            + ")";
      }
   }
}
