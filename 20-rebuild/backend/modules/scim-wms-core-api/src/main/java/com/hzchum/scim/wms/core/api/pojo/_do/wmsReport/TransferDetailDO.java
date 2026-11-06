package com.hzchum.scim.wms.core.api.pojo._do.wmsReport;

import com.hzchum.scim.contract.core.api.pojo.dto.BriefIdAndSNDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransferDetailDO {
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
   private TransferDO transferReceipt;
   private BriefIdAndSNDTO outboundReceipt;
   private BigDecimal quantityCount;
   private BigDecimal meteCount;
   private BigDecimal amountCount;
   private BigDecimal amountExcludingVatCount;
   private Long materialCodeConfigId;
   private String materialSnNew;
   private LocalDateTime realTime;

   public static TransferDetailDO.TransferDetailDOBuilder builder() {
      return new TransferDetailDO.TransferDetailDOBuilder();
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

   public TransferDO getTransferReceipt() {
      return this.transferReceipt;
   }

   public BriefIdAndSNDTO getOutboundReceipt() {
      return this.outboundReceipt;
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

   public Long getMaterialCodeConfigId() {
      return this.materialCodeConfigId;
   }

   public String getMaterialSnNew() {
      return this.materialSnNew;
   }

   public LocalDateTime getRealTime() {
      return this.realTime;
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

   public void setTransferReceipt(final TransferDO transferReceipt) {
      this.transferReceipt = transferReceipt;
   }

   public void setOutboundReceipt(final BriefIdAndSNDTO outboundReceipt) {
      this.outboundReceipt = outboundReceipt;
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

   public void setMaterialCodeConfigId(final Long materialCodeConfigId) {
      this.materialCodeConfigId = materialCodeConfigId;
   }

   public void setMaterialSnNew(final String materialSnNew) {
      this.materialSnNew = materialSnNew;
   }

   public void setRealTime(final LocalDateTime realTime) {
      this.realTime = realTime;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof TransferDetailDO)) {
         return false;
      }

      TransferDetailDO other = (TransferDetailDO)o;
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
                        Object this$materialCodeConfigId = this.getMaterialCodeConfigId();
                        Object other$materialCodeConfigId = other.getMaterialCodeConfigId();
                        if (this$materialCodeConfigId == null
                           ? other$materialCodeConfigId == null
                           : this$materialCodeConfigId.equals(other$materialCodeConfigId)) {
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
                                                                           Object this$transferReceipt = this.getTransferReceipt();
                                                                           Object other$transferReceipt = other.getTransferReceipt();
                                                                           if (this$transferReceipt == null
                                                                              ? other$transferReceipt == null
                                                                              : this$transferReceipt.equals(other$transferReceipt)) {
                                                                              Object this$outboundReceipt = this.getOutboundReceipt();
                                                                              Object other$outboundReceipt = other.getOutboundReceipt();
                                                                              if (this$outboundReceipt == null
                                                                                 ? other$outboundReceipt == null
                                                                                 : this$outboundReceipt.equals(other$outboundReceipt)) {
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
                                                                                             : this$amountExcludingVatCount.equals(
                                                                                                other$amountExcludingVatCount
                                                                                             )) {
                                                                                             Object this$materialSnNew = this.getMaterialSnNew();
                                                                                             Object other$materialSnNew = other.getMaterialSnNew();
                                                                                             if (this$materialSnNew == null
                                                                                                ? other$materialSnNew == null
                                                                                                : this$materialSnNew.equals(other$materialSnNew)) {
                                                                                                Object this$realTime = this.getRealTime();
                                                                                                Object other$realTime = other.getRealTime();
                                                                                                return this$realTime == null
                                                                                                   ? other$realTime == null
                                                                                                   : this$realTime.equals(other$realTime);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof TransferDetailDO;
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
      Object $materialCodeConfigId = this.getMaterialCodeConfigId();
      result = result * 59 + ($materialCodeConfigId == null ? 43 : $materialCodeConfigId.hashCode());
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
      Object $transferReceipt = this.getTransferReceipt();
      result = result * 59 + ($transferReceipt == null ? 43 : $transferReceipt.hashCode());
      Object $outboundReceipt = this.getOutboundReceipt();
      result = result * 59 + ($outboundReceipt == null ? 43 : $outboundReceipt.hashCode());
      Object $quantityCount = this.getQuantityCount();
      result = result * 59 + ($quantityCount == null ? 43 : $quantityCount.hashCode());
      Object $meteCount = this.getMeteCount();
      result = result * 59 + ($meteCount == null ? 43 : $meteCount.hashCode());
      Object $amountCount = this.getAmountCount();
      result = result * 59 + ($amountCount == null ? 43 : $amountCount.hashCode());
      Object $amountExcludingVatCount = this.getAmountExcludingVatCount();
      result = result * 59 + ($amountExcludingVatCount == null ? 43 : $amountExcludingVatCount.hashCode());
      Object $materialSnNew = this.getMaterialSnNew();
      result = result * 59 + ($materialSnNew == null ? 43 : $materialSnNew.hashCode());
      Object $realTime = this.getRealTime();
      return result * 59 + ($realTime == null ? 43 : $realTime.hashCode());
   }

   @Override
   public String toString() {
      return "TransferDetailDO(id="
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
         + ", transferReceipt="
         + this.getTransferReceipt()
         + ", outboundReceipt="
         + this.getOutboundReceipt()
         + ", quantityCount="
         + this.getQuantityCount()
         + ", meteCount="
         + this.getMeteCount()
         + ", amountCount="
         + this.getAmountCount()
         + ", amountExcludingVatCount="
         + this.getAmountExcludingVatCount()
         + ", materialCodeConfigId="
         + this.getMaterialCodeConfigId()
         + ", materialSnNew="
         + this.getMaterialSnNew()
         + ", realTime="
         + this.getRealTime()
         + ")";
   }

   public TransferDetailDO(
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
      final TransferDO transferReceipt,
      final BriefIdAndSNDTO outboundReceipt,
      final BigDecimal quantityCount,
      final BigDecimal meteCount,
      final BigDecimal amountCount,
      final BigDecimal amountExcludingVatCount,
      final Long materialCodeConfigId,
      final String materialSnNew,
      final LocalDateTime realTime
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
      this.transferReceipt = transferReceipt;
      this.outboundReceipt = outboundReceipt;
      this.quantityCount = quantityCount;
      this.meteCount = meteCount;
      this.amountCount = amountCount;
      this.amountExcludingVatCount = amountExcludingVatCount;
      this.materialCodeConfigId = materialCodeConfigId;
      this.materialSnNew = materialSnNew;
      this.realTime = realTime;
   }

   public TransferDetailDO() {
   }

   public static class TransferDetailDOBuilder {
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
      private TransferDO transferReceipt;
      private BriefIdAndSNDTO outboundReceipt;
      private BigDecimal quantityCount;
      private BigDecimal meteCount;
      private BigDecimal amountCount;
      private BigDecimal amountExcludingVatCount;
      private Long materialCodeConfigId;
      private String materialSnNew;
      private LocalDateTime realTime;

      TransferDetailDOBuilder() {
      }

      public TransferDetailDO.TransferDetailDOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder boolPartyA(final Boolean boolPartyA) {
         this.boolPartyA = boolPartyA;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder classifyId(final Long classifyId) {
         this.classifyId = classifyId;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder basicClass(final Integer basicClass) {
         this.basicClass = basicClass;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder specification(final String specification) {
         this.specification = specification;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder quantity(final BigDecimal quantity) {
         this.quantity = quantity;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder thickness(final BigDecimal thickness) {
         this.thickness = thickness;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder length(final BigDecimal length) {
         this.length = length;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder width(final BigDecimal width) {
         this.width = width;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder brand(final String brand) {
         this.brand = brand;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder heatNoAndBatchNo(final String heatNoAndBatchNo) {
         this.heatNoAndBatchNo = heatNoAndBatchNo;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder color(final String color) {
         this.color = color;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder unitPrice(final BigDecimal unitPrice) {
         this.unitPrice = unitPrice;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder unitPriceExcludingVAT(final BigDecimal unitPriceExcludingVAT) {
         this.unitPriceExcludingVAT = unitPriceExcludingVAT;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder amountExcludingVAT(final BigDecimal amountExcludingVAT) {
         this.amountExcludingVAT = amountExcludingVAT;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder inputVAT(final BigDecimal inputVAT) {
         this.inputVAT = inputVAT;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder standardId(final Long standardId) {
         this.standardId = standardId;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder nationalStandard(final String nationalStandard) {
         this.nationalStandard = nationalStandard;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder transferReceipt(final TransferDO transferReceipt) {
         this.transferReceipt = transferReceipt;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder outboundReceipt(final BriefIdAndSNDTO outboundReceipt) {
         this.outboundReceipt = outboundReceipt;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder quantityCount(final BigDecimal quantityCount) {
         this.quantityCount = quantityCount;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder meteCount(final BigDecimal meteCount) {
         this.meteCount = meteCount;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder amountCount(final BigDecimal amountCount) {
         this.amountCount = amountCount;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder amountExcludingVatCount(final BigDecimal amountExcludingVatCount) {
         this.amountExcludingVatCount = amountExcludingVatCount;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder materialCodeConfigId(final Long materialCodeConfigId) {
         this.materialCodeConfigId = materialCodeConfigId;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder materialSnNew(final String materialSnNew) {
         this.materialSnNew = materialSnNew;
         return this;
      }

      public TransferDetailDO.TransferDetailDOBuilder realTime(final LocalDateTime realTime) {
         this.realTime = realTime;
         return this;
      }

      public TransferDetailDO build() {
         return new TransferDetailDO(
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
            this.transferReceipt,
            this.outboundReceipt,
            this.quantityCount,
            this.meteCount,
            this.amountCount,
            this.amountExcludingVatCount,
            this.materialCodeConfigId,
            this.materialSnNew,
            this.realTime
         );
      }

      @Override
      public String toString() {
         return "TransferDetailDO.TransferDetailDOBuilder(id="
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
            + ", transferReceipt="
            + this.transferReceipt
            + ", outboundReceipt="
            + this.outboundReceipt
            + ", quantityCount="
            + this.quantityCount
            + ", meteCount="
            + this.meteCount
            + ", amountCount="
            + this.amountCount
            + ", amountExcludingVatCount="
            + this.amountExcludingVatCount
            + ", materialCodeConfigId="
            + this.materialCodeConfigId
            + ", materialSnNew="
            + this.materialSnNew
            + ", realTime="
            + this.realTime
            + ")";
      }
   }
}
