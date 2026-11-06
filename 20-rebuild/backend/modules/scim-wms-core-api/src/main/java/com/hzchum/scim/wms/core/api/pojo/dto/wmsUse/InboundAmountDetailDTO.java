package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InboundAmountDetailDTO {
   private Long id;
   private Long inboundId;
   private Long purchaseId;
   private BigDecimal taxRate;
   private Integer invoiceType;
   private Integer basicClass;
   private Long classifyId;
   private String classifyName;
   private BigDecimal length;
   private BigDecimal width;
   private BigDecimal thickness;
   private BigDecimal theoryThickness;
   private BigDecimal quantity;
   private String brand;
   private String heatNoAndBatchNo;
   private String specification;
   private String color;
   private String measureUnit;
   private String accountingUnit;
   private BigDecimal mete;
   private BigDecimal priceExcludingVat;
   private BigDecimal amountExcludingVat;
   private BigDecimal inputVat;
   private BigDecimal amount;
   private BigDecimal unitPrice;
   private LocalDateTime reviewTime;
   private String serialNumber;
   private String applicantName;
   private String reviewerName;

   public static InboundAmountDetailDTO.InboundAmountDetailDTOBuilder builder() {
      return new InboundAmountDetailDTO.InboundAmountDetailDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public Long getInboundId() {
      return this.inboundId;
   }

   public Long getPurchaseId() {
      return this.purchaseId;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public Integer getBasicClass() {
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

   public BigDecimal getTheoryThickness() {
      return this.theoryThickness;
   }

   public BigDecimal getQuantity() {
      return this.quantity;
   }

   public String getBrand() {
      return this.brand;
   }

   public String getHeatNoAndBatchNo() {
      return this.heatNoAndBatchNo;
   }

   public String getSpecification() {
      return this.specification;
   }

   public String getColor() {
      return this.color;
   }

   public String getMeasureUnit() {
      return this.measureUnit;
   }

   public String getAccountingUnit() {
      return this.accountingUnit;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getPriceExcludingVat() {
      return this.priceExcludingVat;
   }

   public BigDecimal getAmountExcludingVat() {
      return this.amountExcludingVat;
   }

   public BigDecimal getInputVat() {
      return this.inputVat;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public BigDecimal getUnitPrice() {
      return this.unitPrice;
   }

   public LocalDateTime getReviewTime() {
      return this.reviewTime;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getApplicantName() {
      return this.applicantName;
   }

   public String getReviewerName() {
      return this.reviewerName;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setInboundId(final Long inboundId) {
      this.inboundId = inboundId;
   }

   public void setPurchaseId(final Long purchaseId) {
      this.purchaseId = purchaseId;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setBasicClass(final Integer basicClass) {
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

   public void setTheoryThickness(final BigDecimal theoryThickness) {
      this.theoryThickness = theoryThickness;
   }

   public void setQuantity(final BigDecimal quantity) {
      this.quantity = quantity;
   }

   public void setBrand(final String brand) {
      this.brand = brand;
   }

   public void setHeatNoAndBatchNo(final String heatNoAndBatchNo) {
      this.heatNoAndBatchNo = heatNoAndBatchNo;
   }

   public void setSpecification(final String specification) {
      this.specification = specification;
   }

   public void setColor(final String color) {
      this.color = color;
   }

   public void setMeasureUnit(final String measureUnit) {
      this.measureUnit = measureUnit;
   }

   public void setAccountingUnit(final String accountingUnit) {
      this.accountingUnit = accountingUnit;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   public void setPriceExcludingVat(final BigDecimal priceExcludingVat) {
      this.priceExcludingVat = priceExcludingVat;
   }

   public void setAmountExcludingVat(final BigDecimal amountExcludingVat) {
      this.amountExcludingVat = amountExcludingVat;
   }

   public void setInputVat(final BigDecimal inputVat) {
      this.inputVat = inputVat;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setUnitPrice(final BigDecimal unitPrice) {
      this.unitPrice = unitPrice;
   }

   public void setReviewTime(final LocalDateTime reviewTime) {
      this.reviewTime = reviewTime;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setApplicantName(final String applicantName) {
      this.applicantName = applicantName;
   }

   public void setReviewerName(final String reviewerName) {
      this.reviewerName = reviewerName;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InboundAmountDetailDTO)) {
         return false;
      }

      InboundAmountDetailDTO other = (InboundAmountDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$inboundId = this.getInboundId();
         Object other$inboundId = other.getInboundId();
         if (this$inboundId == null ? other$inboundId == null : this$inboundId.equals(other$inboundId)) {
            Object this$purchaseId = this.getPurchaseId();
            Object other$purchaseId = other.getPurchaseId();
            if (this$purchaseId == null ? other$purchaseId == null : this$purchaseId.equals(other$purchaseId)) {
               Object this$invoiceType = this.getInvoiceType();
               Object other$invoiceType = other.getInvoiceType();
               if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
                  Object this$basicClass = this.getBasicClass();
                  Object other$basicClass = other.getBasicClass();
                  if (this$basicClass == null ? other$basicClass == null : this$basicClass.equals(other$basicClass)) {
                     Object this$classifyId = this.getClassifyId();
                     Object other$classifyId = other.getClassifyId();
                     if (this$classifyId == null ? other$classifyId == null : this$classifyId.equals(other$classifyId)) {
                        Object this$taxRate = this.getTaxRate();
                        Object other$taxRate = other.getTaxRate();
                        if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
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
                                       Object this$theoryThickness = this.getTheoryThickness();
                                       Object other$theoryThickness = other.getTheoryThickness();
                                       if (this$theoryThickness == null ? other$theoryThickness == null : this$theoryThickness.equals(other$theoryThickness)) {
                                          Object this$quantity = this.getQuantity();
                                          Object other$quantity = other.getQuantity();
                                          if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
                                             Object this$brand = this.getBrand();
                                             Object other$brand = other.getBrand();
                                             if (this$brand == null ? other$brand == null : this$brand.equals(other$brand)) {
                                                Object this$heatNoAndBatchNo = this.getHeatNoAndBatchNo();
                                                Object other$heatNoAndBatchNo = other.getHeatNoAndBatchNo();
                                                if (this$heatNoAndBatchNo == null
                                                   ? other$heatNoAndBatchNo == null
                                                   : this$heatNoAndBatchNo.equals(other$heatNoAndBatchNo)) {
                                                   Object this$specification = this.getSpecification();
                                                   Object other$specification = other.getSpecification();
                                                   if (this$specification == null
                                                      ? other$specification == null
                                                      : this$specification.equals(other$specification)) {
                                                      Object this$color = this.getColor();
                                                      Object other$color = other.getColor();
                                                      if (this$color == null ? other$color == null : this$color.equals(other$color)) {
                                                         Object this$measureUnit = this.getMeasureUnit();
                                                         Object other$measureUnit = other.getMeasureUnit();
                                                         if (this$measureUnit == null ? other$measureUnit == null : this$measureUnit.equals(other$measureUnit)) {
                                                            Object this$accountingUnit = this.getAccountingUnit();
                                                            Object other$accountingUnit = other.getAccountingUnit();
                                                            if (this$accountingUnit == null
                                                               ? other$accountingUnit == null
                                                               : this$accountingUnit.equals(other$accountingUnit)) {
                                                               Object this$mete = this.getMete();
                                                               Object other$mete = other.getMete();
                                                               if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
                                                                  Object this$priceExcludingVat = this.getPriceExcludingVat();
                                                                  Object other$priceExcludingVat = other.getPriceExcludingVat();
                                                                  if (this$priceExcludingVat == null
                                                                     ? other$priceExcludingVat == null
                                                                     : this$priceExcludingVat.equals(other$priceExcludingVat)) {
                                                                     Object this$amountExcludingVat = this.getAmountExcludingVat();
                                                                     Object other$amountExcludingVat = other.getAmountExcludingVat();
                                                                     if (this$amountExcludingVat == null
                                                                        ? other$amountExcludingVat == null
                                                                        : this$amountExcludingVat.equals(other$amountExcludingVat)) {
                                                                        Object this$inputVat = this.getInputVat();
                                                                        Object other$inputVat = other.getInputVat();
                                                                        if (this$inputVat == null
                                                                           ? other$inputVat == null
                                                                           : this$inputVat.equals(other$inputVat)) {
                                                                           Object this$amount = this.getAmount();
                                                                           Object other$amount = other.getAmount();
                                                                           if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                                                                              Object this$unitPrice = this.getUnitPrice();
                                                                              Object other$unitPrice = other.getUnitPrice();
                                                                              if (this$unitPrice == null
                                                                                 ? other$unitPrice == null
                                                                                 : this$unitPrice.equals(other$unitPrice)) {
                                                                                 Object this$reviewTime = this.getReviewTime();
                                                                                 Object other$reviewTime = other.getReviewTime();
                                                                                 if (this$reviewTime == null
                                                                                    ? other$reviewTime == null
                                                                                    : this$reviewTime.equals(other$reviewTime)) {
                                                                                    Object this$serialNumber = this.getSerialNumber();
                                                                                    Object other$serialNumber = other.getSerialNumber();
                                                                                    if (this$serialNumber == null
                                                                                       ? other$serialNumber == null
                                                                                       : this$serialNumber.equals(other$serialNumber)) {
                                                                                       Object this$applicantName = this.getApplicantName();
                                                                                       Object other$applicantName = other.getApplicantName();
                                                                                       if (this$applicantName == null
                                                                                          ? other$applicantName == null
                                                                                          : this$applicantName.equals(other$applicantName)) {
                                                                                          Object this$reviewerName = this.getReviewerName();
                                                                                          Object other$reviewerName = other.getReviewerName();
                                                                                          return this$reviewerName == null
                                                                                             ? other$reviewerName == null
                                                                                             : this$reviewerName.equals(other$reviewerName);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof InboundAmountDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $inboundId = this.getInboundId();
      result = result * 59 + ($inboundId == null ? 43 : $inboundId.hashCode());
      Object $purchaseId = this.getPurchaseId();
      result = result * 59 + ($purchaseId == null ? 43 : $purchaseId.hashCode());
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $basicClass = this.getBasicClass();
      result = result * 59 + ($basicClass == null ? 43 : $basicClass.hashCode());
      Object $classifyId = this.getClassifyId();
      result = result * 59 + ($classifyId == null ? 43 : $classifyId.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $classifyName = this.getClassifyName();
      result = result * 59 + ($classifyName == null ? 43 : $classifyName.hashCode());
      Object $length = this.getLength();
      result = result * 59 + ($length == null ? 43 : $length.hashCode());
      Object $width = this.getWidth();
      result = result * 59 + ($width == null ? 43 : $width.hashCode());
      Object $thickness = this.getThickness();
      result = result * 59 + ($thickness == null ? 43 : $thickness.hashCode());
      Object $theoryThickness = this.getTheoryThickness();
      result = result * 59 + ($theoryThickness == null ? 43 : $theoryThickness.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $brand = this.getBrand();
      result = result * 59 + ($brand == null ? 43 : $brand.hashCode());
      Object $heatNoAndBatchNo = this.getHeatNoAndBatchNo();
      result = result * 59 + ($heatNoAndBatchNo == null ? 43 : $heatNoAndBatchNo.hashCode());
      Object $specification = this.getSpecification();
      result = result * 59 + ($specification == null ? 43 : $specification.hashCode());
      Object $color = this.getColor();
      result = result * 59 + ($color == null ? 43 : $color.hashCode());
      Object $measureUnit = this.getMeasureUnit();
      result = result * 59 + ($measureUnit == null ? 43 : $measureUnit.hashCode());
      Object $accountingUnit = this.getAccountingUnit();
      result = result * 59 + ($accountingUnit == null ? 43 : $accountingUnit.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $priceExcludingVat = this.getPriceExcludingVat();
      result = result * 59 + ($priceExcludingVat == null ? 43 : $priceExcludingVat.hashCode());
      Object $amountExcludingVat = this.getAmountExcludingVat();
      result = result * 59 + ($amountExcludingVat == null ? 43 : $amountExcludingVat.hashCode());
      Object $inputVat = this.getInputVat();
      result = result * 59 + ($inputVat == null ? 43 : $inputVat.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $unitPrice = this.getUnitPrice();
      result = result * 59 + ($unitPrice == null ? 43 : $unitPrice.hashCode());
      Object $reviewTime = this.getReviewTime();
      result = result * 59 + ($reviewTime == null ? 43 : $reviewTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $applicantName = this.getApplicantName();
      result = result * 59 + ($applicantName == null ? 43 : $applicantName.hashCode());
      Object $reviewerName = this.getReviewerName();
      return result * 59 + ($reviewerName == null ? 43 : $reviewerName.hashCode());
   }

   @Override
   public String toString() {
      return "InboundAmountDetailDTO(id="
         + this.getId()
         + ", inboundId="
         + this.getInboundId()
         + ", purchaseId="
         + this.getPurchaseId()
         + ", taxRate="
         + this.getTaxRate()
         + ", invoiceType="
         + this.getInvoiceType()
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
         + ", theoryThickness="
         + this.getTheoryThickness()
         + ", quantity="
         + this.getQuantity()
         + ", brand="
         + this.getBrand()
         + ", heatNoAndBatchNo="
         + this.getHeatNoAndBatchNo()
         + ", specification="
         + this.getSpecification()
         + ", color="
         + this.getColor()
         + ", measureUnit="
         + this.getMeasureUnit()
         + ", accountingUnit="
         + this.getAccountingUnit()
         + ", mete="
         + this.getMete()
         + ", priceExcludingVat="
         + this.getPriceExcludingVat()
         + ", amountExcludingVat="
         + this.getAmountExcludingVat()
         + ", inputVat="
         + this.getInputVat()
         + ", amount="
         + this.getAmount()
         + ", unitPrice="
         + this.getUnitPrice()
         + ", reviewTime="
         + this.getReviewTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", applicantName="
         + this.getApplicantName()
         + ", reviewerName="
         + this.getReviewerName()
         + ")";
   }

   public InboundAmountDetailDTO(
      final Long id,
      final Long inboundId,
      final Long purchaseId,
      final BigDecimal taxRate,
      final Integer invoiceType,
      final Integer basicClass,
      final Long classifyId,
      final String classifyName,
      final BigDecimal length,
      final BigDecimal width,
      final BigDecimal thickness,
      final BigDecimal theoryThickness,
      final BigDecimal quantity,
      final String brand,
      final String heatNoAndBatchNo,
      final String specification,
      final String color,
      final String measureUnit,
      final String accountingUnit,
      final BigDecimal mete,
      final BigDecimal priceExcludingVat,
      final BigDecimal amountExcludingVat,
      final BigDecimal inputVat,
      final BigDecimal amount,
      final BigDecimal unitPrice,
      final LocalDateTime reviewTime,
      final String serialNumber,
      final String applicantName,
      final String reviewerName
   ) {
      this.id = id;
      this.inboundId = inboundId;
      this.purchaseId = purchaseId;
      this.taxRate = taxRate;
      this.invoiceType = invoiceType;
      this.basicClass = basicClass;
      this.classifyId = classifyId;
      this.classifyName = classifyName;
      this.length = length;
      this.width = width;
      this.thickness = thickness;
      this.theoryThickness = theoryThickness;
      this.quantity = quantity;
      this.brand = brand;
      this.heatNoAndBatchNo = heatNoAndBatchNo;
      this.specification = specification;
      this.color = color;
      this.measureUnit = measureUnit;
      this.accountingUnit = accountingUnit;
      this.mete = mete;
      this.priceExcludingVat = priceExcludingVat;
      this.amountExcludingVat = amountExcludingVat;
      this.inputVat = inputVat;
      this.amount = amount;
      this.unitPrice = unitPrice;
      this.reviewTime = reviewTime;
      this.serialNumber = serialNumber;
      this.applicantName = applicantName;
      this.reviewerName = reviewerName;
   }

   public InboundAmountDetailDTO() {
   }

   public static class InboundAmountDetailDTOBuilder {
      private Long id;
      private Long inboundId;
      private Long purchaseId;
      private BigDecimal taxRate;
      private Integer invoiceType;
      private Integer basicClass;
      private Long classifyId;
      private String classifyName;
      private BigDecimal length;
      private BigDecimal width;
      private BigDecimal thickness;
      private BigDecimal theoryThickness;
      private BigDecimal quantity;
      private String brand;
      private String heatNoAndBatchNo;
      private String specification;
      private String color;
      private String measureUnit;
      private String accountingUnit;
      private BigDecimal mete;
      private BigDecimal priceExcludingVat;
      private BigDecimal amountExcludingVat;
      private BigDecimal inputVat;
      private BigDecimal amount;
      private BigDecimal unitPrice;
      private LocalDateTime reviewTime;
      private String serialNumber;
      private String applicantName;
      private String reviewerName;

      InboundAmountDetailDTOBuilder() {
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder inboundId(final Long inboundId) {
         this.inboundId = inboundId;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder purchaseId(final Long purchaseId) {
         this.purchaseId = purchaseId;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder classifyName(final String classifyName) {
         this.classifyName = classifyName;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder theoryThickness(final BigDecimal theoryThickness) {
         this.theoryThickness = theoryThickness;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder measureUnit(final String measureUnit) {
         this.measureUnit = measureUnit;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder accountingUnit(final String accountingUnit) {
         this.accountingUnit = accountingUnit;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder priceExcludingVat(final BigDecimal priceExcludingVat) {
         this.priceExcludingVat = priceExcludingVat;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder amountExcludingVat(final BigDecimal amountExcludingVat) {
         this.amountExcludingVat = amountExcludingVat;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder inputVat(final BigDecimal inputVat) {
         this.inputVat = inputVat;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder reviewTime(final LocalDateTime reviewTime) {
         this.reviewTime = reviewTime;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder applicantName(final String applicantName) {
         this.applicantName = applicantName;
         return this;
      }

      public InboundAmountDetailDTO.InboundAmountDetailDTOBuilder reviewerName(final String reviewerName) {
         this.reviewerName = reviewerName;
         return this;
      }

      public InboundAmountDetailDTO build() {
         return new InboundAmountDetailDTO(
            this.id,
            this.inboundId,
            this.purchaseId,
            this.taxRate,
            this.invoiceType,
            this.basicClass,
            this.classifyId,
            this.classifyName,
            this.length,
            this.width,
            this.thickness,
            this.theoryThickness,
            this.quantity,
            this.brand,
            this.heatNoAndBatchNo,
            this.specification,
            this.color,
            this.measureUnit,
            this.accountingUnit,
            this.mete,
            this.priceExcludingVat,
            this.amountExcludingVat,
            this.inputVat,
            this.amount,
            this.unitPrice,
            this.reviewTime,
            this.serialNumber,
            this.applicantName,
            this.reviewerName
         );
      }

      @Override
      public String toString() {
         return "InboundAmountDetailDTO.InboundAmountDetailDTOBuilder(id="
            + this.id
            + ", inboundId="
            + this.inboundId
            + ", purchaseId="
            + this.purchaseId
            + ", taxRate="
            + this.taxRate
            + ", invoiceType="
            + this.invoiceType
            + ", basicClass="
            + this.basicClass
            + ", classifyId="
            + this.classifyId
            + ", classifyName="
            + this.classifyName
            + ", length="
            + this.length
            + ", width="
            + this.width
            + ", thickness="
            + this.thickness
            + ", theoryThickness="
            + this.theoryThickness
            + ", quantity="
            + this.quantity
            + ", brand="
            + this.brand
            + ", heatNoAndBatchNo="
            + this.heatNoAndBatchNo
            + ", specification="
            + this.specification
            + ", color="
            + this.color
            + ", measureUnit="
            + this.measureUnit
            + ", accountingUnit="
            + this.accountingUnit
            + ", mete="
            + this.mete
            + ", priceExcludingVat="
            + this.priceExcludingVat
            + ", amountExcludingVat="
            + this.amountExcludingVat
            + ", inputVat="
            + this.inputVat
            + ", amount="
            + this.amount
            + ", unitPrice="
            + this.unitPrice
            + ", reviewTime="
            + this.reviewTime
            + ", serialNumber="
            + this.serialNumber
            + ", applicantName="
            + this.applicantName
            + ", reviewerName="
            + this.reviewerName
            + ")";
      }
   }
}
