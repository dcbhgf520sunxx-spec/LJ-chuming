package com.hzchum.scim.wms.core.api.pojo.dto.wmsReport;

import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndSNDTO;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class InventoryDetailsRecordDetailDTO {
   private BriefIdAndSNDTO receipt;
   private LocalDateTime createTime;
   private String summary;
   private BigDecimal inboundMete;
   private BigDecimal inboundQuantity;
   private BigDecimal inboundAmount;
   private BigDecimal inboundAmountExcludingVat;
   private BigDecimal inboundUnitPrice;
   private BigDecimal inboundUnitPriceExcludingVat;
   private BigDecimal outboundMete;
   private BigDecimal outboundQuantity;
   private BigDecimal outboundAmount;
   private BigDecimal outboundAmountExcludingVat;
   private BigDecimal outboundUnitPrice;
   private BigDecimal outboundUnitPriceExcludingVat;
   private BigDecimal endMete;
   private BigDecimal endQuantity;
   private BigDecimal endAmount;
   private BigDecimal endAmountExcludingVat;
   private BigDecimal endUnitPrice;
   private BigDecimal endUnitPriceExcludingVat;

   public static InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder builder() {
      return new InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder();
   }

   public BriefIdAndSNDTO getReceipt() {
      return this.receipt;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getSummary() {
      return this.summary;
   }

   public BigDecimal getInboundMete() {
      return this.inboundMete;
   }

   public BigDecimal getInboundQuantity() {
      return this.inboundQuantity;
   }

   public BigDecimal getInboundAmount() {
      return this.inboundAmount;
   }

   public BigDecimal getInboundAmountExcludingVat() {
      return this.inboundAmountExcludingVat;
   }

   public BigDecimal getInboundUnitPrice() {
      return this.inboundUnitPrice;
   }

   public BigDecimal getInboundUnitPriceExcludingVat() {
      return this.inboundUnitPriceExcludingVat;
   }

   public BigDecimal getOutboundMete() {
      return this.outboundMete;
   }

   public BigDecimal getOutboundQuantity() {
      return this.outboundQuantity;
   }

   public BigDecimal getOutboundAmount() {
      return this.outboundAmount;
   }

   public BigDecimal getOutboundAmountExcludingVat() {
      return this.outboundAmountExcludingVat;
   }

   public BigDecimal getOutboundUnitPrice() {
      return this.outboundUnitPrice;
   }

   public BigDecimal getOutboundUnitPriceExcludingVat() {
      return this.outboundUnitPriceExcludingVat;
   }

   public BigDecimal getEndMete() {
      return this.endMete;
   }

   public BigDecimal getEndQuantity() {
      return this.endQuantity;
   }

   public BigDecimal getEndAmount() {
      return this.endAmount;
   }

   public BigDecimal getEndAmountExcludingVat() {
      return this.endAmountExcludingVat;
   }

   public BigDecimal getEndUnitPrice() {
      return this.endUnitPrice;
   }

   public BigDecimal getEndUnitPriceExcludingVat() {
      return this.endUnitPriceExcludingVat;
   }

   public void setReceipt(final BriefIdAndSNDTO receipt) {
      this.receipt = receipt;
   }

   public void setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
   }

   public void setSummary(final String summary) {
      this.summary = summary;
   }

   public void setInboundMete(final BigDecimal inboundMete) {
      this.inboundMete = inboundMete;
   }

   public void setInboundQuantity(final BigDecimal inboundQuantity) {
      this.inboundQuantity = inboundQuantity;
   }

   public void setInboundAmount(final BigDecimal inboundAmount) {
      this.inboundAmount = inboundAmount;
   }

   public void setInboundAmountExcludingVat(final BigDecimal inboundAmountExcludingVat) {
      this.inboundAmountExcludingVat = inboundAmountExcludingVat;
   }

   public void setInboundUnitPrice(final BigDecimal inboundUnitPrice) {
      this.inboundUnitPrice = inboundUnitPrice;
   }

   public void setInboundUnitPriceExcludingVat(final BigDecimal inboundUnitPriceExcludingVat) {
      this.inboundUnitPriceExcludingVat = inboundUnitPriceExcludingVat;
   }

   public void setOutboundMete(final BigDecimal outboundMete) {
      this.outboundMete = outboundMete;
   }

   public void setOutboundQuantity(final BigDecimal outboundQuantity) {
      this.outboundQuantity = outboundQuantity;
   }

   public void setOutboundAmount(final BigDecimal outboundAmount) {
      this.outboundAmount = outboundAmount;
   }

   public void setOutboundAmountExcludingVat(final BigDecimal outboundAmountExcludingVat) {
      this.outboundAmountExcludingVat = outboundAmountExcludingVat;
   }

   public void setOutboundUnitPrice(final BigDecimal outboundUnitPrice) {
      this.outboundUnitPrice = outboundUnitPrice;
   }

   public void setOutboundUnitPriceExcludingVat(final BigDecimal outboundUnitPriceExcludingVat) {
      this.outboundUnitPriceExcludingVat = outboundUnitPriceExcludingVat;
   }

   public void setEndMete(final BigDecimal endMete) {
      this.endMete = endMete;
   }

   public void setEndQuantity(final BigDecimal endQuantity) {
      this.endQuantity = endQuantity;
   }

   public void setEndAmount(final BigDecimal endAmount) {
      this.endAmount = endAmount;
   }

   public void setEndAmountExcludingVat(final BigDecimal endAmountExcludingVat) {
      this.endAmountExcludingVat = endAmountExcludingVat;
   }

   public void setEndUnitPrice(final BigDecimal endUnitPrice) {
      this.endUnitPrice = endUnitPrice;
   }

   public void setEndUnitPriceExcludingVat(final BigDecimal endUnitPriceExcludingVat) {
      this.endUnitPriceExcludingVat = endUnitPriceExcludingVat;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InventoryDetailsRecordDetailDTO)) {
         return false;
      }

      InventoryDetailsRecordDetailDTO other = (InventoryDetailsRecordDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$receipt = this.getReceipt();
      Object other$receipt = other.getReceipt();
      if (this$receipt == null ? other$receipt == null : this$receipt.equals(other$receipt)) {
         Object this$createTime = this.getCreateTime();
         Object other$createTime = other.getCreateTime();
         if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
            Object this$summary = this.getSummary();
            Object other$summary = other.getSummary();
            if (this$summary == null ? other$summary == null : this$summary.equals(other$summary)) {
               Object this$inboundMete = this.getInboundMete();
               Object other$inboundMete = other.getInboundMete();
               if (this$inboundMete == null ? other$inboundMete == null : this$inboundMete.equals(other$inboundMete)) {
                  Object this$inboundQuantity = this.getInboundQuantity();
                  Object other$inboundQuantity = other.getInboundQuantity();
                  if (this$inboundQuantity == null ? other$inboundQuantity == null : this$inboundQuantity.equals(other$inboundQuantity)) {
                     Object this$inboundAmount = this.getInboundAmount();
                     Object other$inboundAmount = other.getInboundAmount();
                     if (this$inboundAmount == null ? other$inboundAmount == null : this$inboundAmount.equals(other$inboundAmount)) {
                        Object this$inboundAmountExcludingVat = this.getInboundAmountExcludingVat();
                        Object other$inboundAmountExcludingVat = other.getInboundAmountExcludingVat();
                        if (this$inboundAmountExcludingVat == null
                           ? other$inboundAmountExcludingVat == null
                           : this$inboundAmountExcludingVat.equals(other$inboundAmountExcludingVat)) {
                           Object this$inboundUnitPrice = this.getInboundUnitPrice();
                           Object other$inboundUnitPrice = other.getInboundUnitPrice();
                           if (this$inboundUnitPrice == null ? other$inboundUnitPrice == null : this$inboundUnitPrice.equals(other$inboundUnitPrice)) {
                              Object this$inboundUnitPriceExcludingVat = this.getInboundUnitPriceExcludingVat();
                              Object other$inboundUnitPriceExcludingVat = other.getInboundUnitPriceExcludingVat();
                              if (this$inboundUnitPriceExcludingVat == null
                                 ? other$inboundUnitPriceExcludingVat == null
                                 : this$inboundUnitPriceExcludingVat.equals(other$inboundUnitPriceExcludingVat)) {
                                 Object this$outboundMete = this.getOutboundMete();
                                 Object other$outboundMete = other.getOutboundMete();
                                 if (this$outboundMete == null ? other$outboundMete == null : this$outboundMete.equals(other$outboundMete)) {
                                    Object this$outboundQuantity = this.getOutboundQuantity();
                                    Object other$outboundQuantity = other.getOutboundQuantity();
                                    if (this$outboundQuantity == null ? other$outboundQuantity == null : this$outboundQuantity.equals(other$outboundQuantity)) {
                                       Object this$outboundAmount = this.getOutboundAmount();
                                       Object other$outboundAmount = other.getOutboundAmount();
                                       if (this$outboundAmount == null ? other$outboundAmount == null : this$outboundAmount.equals(other$outboundAmount)) {
                                          Object this$outboundAmountExcludingVat = this.getOutboundAmountExcludingVat();
                                          Object other$outboundAmountExcludingVat = other.getOutboundAmountExcludingVat();
                                          if (this$outboundAmountExcludingVat == null
                                             ? other$outboundAmountExcludingVat == null
                                             : this$outboundAmountExcludingVat.equals(other$outboundAmountExcludingVat)) {
                                             Object this$outboundUnitPrice = this.getOutboundUnitPrice();
                                             Object other$outboundUnitPrice = other.getOutboundUnitPrice();
                                             if (this$outboundUnitPrice == null
                                                ? other$outboundUnitPrice == null
                                                : this$outboundUnitPrice.equals(other$outboundUnitPrice)) {
                                                Object this$outboundUnitPriceExcludingVat = this.getOutboundUnitPriceExcludingVat();
                                                Object other$outboundUnitPriceExcludingVat = other.getOutboundUnitPriceExcludingVat();
                                                if (this$outboundUnitPriceExcludingVat == null
                                                   ? other$outboundUnitPriceExcludingVat == null
                                                   : this$outboundUnitPriceExcludingVat.equals(other$outboundUnitPriceExcludingVat)) {
                                                   Object this$endMete = this.getEndMete();
                                                   Object other$endMete = other.getEndMete();
                                                   if (this$endMete == null ? other$endMete == null : this$endMete.equals(other$endMete)) {
                                                      Object this$endQuantity = this.getEndQuantity();
                                                      Object other$endQuantity = other.getEndQuantity();
                                                      if (this$endQuantity == null ? other$endQuantity == null : this$endQuantity.equals(other$endQuantity)) {
                                                         Object this$endAmount = this.getEndAmount();
                                                         Object other$endAmount = other.getEndAmount();
                                                         if (this$endAmount == null ? other$endAmount == null : this$endAmount.equals(other$endAmount)) {
                                                            Object this$endAmountExcludingVat = this.getEndAmountExcludingVat();
                                                            Object other$endAmountExcludingVat = other.getEndAmountExcludingVat();
                                                            if (this$endAmountExcludingVat == null
                                                               ? other$endAmountExcludingVat == null
                                                               : this$endAmountExcludingVat.equals(other$endAmountExcludingVat)) {
                                                               Object this$endUnitPrice = this.getEndUnitPrice();
                                                               Object other$endUnitPrice = other.getEndUnitPrice();
                                                               if (this$endUnitPrice == null
                                                                  ? other$endUnitPrice == null
                                                                  : this$endUnitPrice.equals(other$endUnitPrice)) {
                                                                  Object this$endUnitPriceExcludingVat = this.getEndUnitPriceExcludingVat();
                                                                  Object other$endUnitPriceExcludingVat = other.getEndUnitPriceExcludingVat();
                                                                  return this$endUnitPriceExcludingVat == null
                                                                     ? other$endUnitPriceExcludingVat == null
                                                                     : this$endUnitPriceExcludingVat.equals(other$endUnitPriceExcludingVat);
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
      return other instanceof InventoryDetailsRecordDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $receipt = this.getReceipt();
      result = result * 59 + ($receipt == null ? 43 : $receipt.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $summary = this.getSummary();
      result = result * 59 + ($summary == null ? 43 : $summary.hashCode());
      Object $inboundMete = this.getInboundMete();
      result = result * 59 + ($inboundMete == null ? 43 : $inboundMete.hashCode());
      Object $inboundQuantity = this.getInboundQuantity();
      result = result * 59 + ($inboundQuantity == null ? 43 : $inboundQuantity.hashCode());
      Object $inboundAmount = this.getInboundAmount();
      result = result * 59 + ($inboundAmount == null ? 43 : $inboundAmount.hashCode());
      Object $inboundAmountExcludingVat = this.getInboundAmountExcludingVat();
      result = result * 59 + ($inboundAmountExcludingVat == null ? 43 : $inboundAmountExcludingVat.hashCode());
      Object $inboundUnitPrice = this.getInboundUnitPrice();
      result = result * 59 + ($inboundUnitPrice == null ? 43 : $inboundUnitPrice.hashCode());
      Object $inboundUnitPriceExcludingVat = this.getInboundUnitPriceExcludingVat();
      result = result * 59 + ($inboundUnitPriceExcludingVat == null ? 43 : $inboundUnitPriceExcludingVat.hashCode());
      Object $outboundMete = this.getOutboundMete();
      result = result * 59 + ($outboundMete == null ? 43 : $outboundMete.hashCode());
      Object $outboundQuantity = this.getOutboundQuantity();
      result = result * 59 + ($outboundQuantity == null ? 43 : $outboundQuantity.hashCode());
      Object $outboundAmount = this.getOutboundAmount();
      result = result * 59 + ($outboundAmount == null ? 43 : $outboundAmount.hashCode());
      Object $outboundAmountExcludingVat = this.getOutboundAmountExcludingVat();
      result = result * 59 + ($outboundAmountExcludingVat == null ? 43 : $outboundAmountExcludingVat.hashCode());
      Object $outboundUnitPrice = this.getOutboundUnitPrice();
      result = result * 59 + ($outboundUnitPrice == null ? 43 : $outboundUnitPrice.hashCode());
      Object $outboundUnitPriceExcludingVat = this.getOutboundUnitPriceExcludingVat();
      result = result * 59 + ($outboundUnitPriceExcludingVat == null ? 43 : $outboundUnitPriceExcludingVat.hashCode());
      Object $endMete = this.getEndMete();
      result = result * 59 + ($endMete == null ? 43 : $endMete.hashCode());
      Object $endQuantity = this.getEndQuantity();
      result = result * 59 + ($endQuantity == null ? 43 : $endQuantity.hashCode());
      Object $endAmount = this.getEndAmount();
      result = result * 59 + ($endAmount == null ? 43 : $endAmount.hashCode());
      Object $endAmountExcludingVat = this.getEndAmountExcludingVat();
      result = result * 59 + ($endAmountExcludingVat == null ? 43 : $endAmountExcludingVat.hashCode());
      Object $endUnitPrice = this.getEndUnitPrice();
      result = result * 59 + ($endUnitPrice == null ? 43 : $endUnitPrice.hashCode());
      Object $endUnitPriceExcludingVat = this.getEndUnitPriceExcludingVat();
      return result * 59 + ($endUnitPriceExcludingVat == null ? 43 : $endUnitPriceExcludingVat.hashCode());
   }

   @Override
   public String toString() {
      return "InventoryDetailsRecordDetailDTO(receipt="
         + this.getReceipt()
         + ", createTime="
         + this.getCreateTime()
         + ", summary="
         + this.getSummary()
         + ", inboundMete="
         + this.getInboundMete()
         + ", inboundQuantity="
         + this.getInboundQuantity()
         + ", inboundAmount="
         + this.getInboundAmount()
         + ", inboundAmountExcludingVat="
         + this.getInboundAmountExcludingVat()
         + ", inboundUnitPrice="
         + this.getInboundUnitPrice()
         + ", inboundUnitPriceExcludingVat="
         + this.getInboundUnitPriceExcludingVat()
         + ", outboundMete="
         + this.getOutboundMete()
         + ", outboundQuantity="
         + this.getOutboundQuantity()
         + ", outboundAmount="
         + this.getOutboundAmount()
         + ", outboundAmountExcludingVat="
         + this.getOutboundAmountExcludingVat()
         + ", outboundUnitPrice="
         + this.getOutboundUnitPrice()
         + ", outboundUnitPriceExcludingVat="
         + this.getOutboundUnitPriceExcludingVat()
         + ", endMete="
         + this.getEndMete()
         + ", endQuantity="
         + this.getEndQuantity()
         + ", endAmount="
         + this.getEndAmount()
         + ", endAmountExcludingVat="
         + this.getEndAmountExcludingVat()
         + ", endUnitPrice="
         + this.getEndUnitPrice()
         + ", endUnitPriceExcludingVat="
         + this.getEndUnitPriceExcludingVat()
         + ")";
   }

   public InventoryDetailsRecordDetailDTO(
      final BriefIdAndSNDTO receipt,
      final LocalDateTime createTime,
      final String summary,
      final BigDecimal inboundMete,
      final BigDecimal inboundQuantity,
      final BigDecimal inboundAmount,
      final BigDecimal inboundAmountExcludingVat,
      final BigDecimal inboundUnitPrice,
      final BigDecimal inboundUnitPriceExcludingVat,
      final BigDecimal outboundMete,
      final BigDecimal outboundQuantity,
      final BigDecimal outboundAmount,
      final BigDecimal outboundAmountExcludingVat,
      final BigDecimal outboundUnitPrice,
      final BigDecimal outboundUnitPriceExcludingVat,
      final BigDecimal endMete,
      final BigDecimal endQuantity,
      final BigDecimal endAmount,
      final BigDecimal endAmountExcludingVat,
      final BigDecimal endUnitPrice,
      final BigDecimal endUnitPriceExcludingVat
   ) {
      this.receipt = receipt;
      this.createTime = createTime;
      this.summary = summary;
      this.inboundMete = inboundMete;
      this.inboundQuantity = inboundQuantity;
      this.inboundAmount = inboundAmount;
      this.inboundAmountExcludingVat = inboundAmountExcludingVat;
      this.inboundUnitPrice = inboundUnitPrice;
      this.inboundUnitPriceExcludingVat = inboundUnitPriceExcludingVat;
      this.outboundMete = outboundMete;
      this.outboundQuantity = outboundQuantity;
      this.outboundAmount = outboundAmount;
      this.outboundAmountExcludingVat = outboundAmountExcludingVat;
      this.outboundUnitPrice = outboundUnitPrice;
      this.outboundUnitPriceExcludingVat = outboundUnitPriceExcludingVat;
      this.endMete = endMete;
      this.endQuantity = endQuantity;
      this.endAmount = endAmount;
      this.endAmountExcludingVat = endAmountExcludingVat;
      this.endUnitPrice = endUnitPrice;
      this.endUnitPriceExcludingVat = endUnitPriceExcludingVat;
   }

   public InventoryDetailsRecordDetailDTO() {
   }

   public static class InventoryDetailsRecordDetailDTOBuilder {
      private BriefIdAndSNDTO receipt;
      private LocalDateTime createTime;
      private String summary;
      private BigDecimal inboundMete;
      private BigDecimal inboundQuantity;
      private BigDecimal inboundAmount;
      private BigDecimal inboundAmountExcludingVat;
      private BigDecimal inboundUnitPrice;
      private BigDecimal inboundUnitPriceExcludingVat;
      private BigDecimal outboundMete;
      private BigDecimal outboundQuantity;
      private BigDecimal outboundAmount;
      private BigDecimal outboundAmountExcludingVat;
      private BigDecimal outboundUnitPrice;
      private BigDecimal outboundUnitPriceExcludingVat;
      private BigDecimal endMete;
      private BigDecimal endQuantity;
      private BigDecimal endAmount;
      private BigDecimal endAmountExcludingVat;
      private BigDecimal endUnitPrice;
      private BigDecimal endUnitPriceExcludingVat;

      InventoryDetailsRecordDetailDTOBuilder() {
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder receipt(final BriefIdAndSNDTO receipt) {
         this.receipt = receipt;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder summary(final String summary) {
         this.summary = summary;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder inboundMete(final BigDecimal inboundMete) {
         this.inboundMete = inboundMete;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder inboundQuantity(final BigDecimal inboundQuantity) {
         this.inboundQuantity = inboundQuantity;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder inboundAmount(final BigDecimal inboundAmount) {
         this.inboundAmount = inboundAmount;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder inboundAmountExcludingVat(final BigDecimal inboundAmountExcludingVat) {
         this.inboundAmountExcludingVat = inboundAmountExcludingVat;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder inboundUnitPrice(final BigDecimal inboundUnitPrice) {
         this.inboundUnitPrice = inboundUnitPrice;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder inboundUnitPriceExcludingVat(final BigDecimal inboundUnitPriceExcludingVat) {
         this.inboundUnitPriceExcludingVat = inboundUnitPriceExcludingVat;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder outboundMete(final BigDecimal outboundMete) {
         this.outboundMete = outboundMete;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder outboundQuantity(final BigDecimal outboundQuantity) {
         this.outboundQuantity = outboundQuantity;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder outboundAmount(final BigDecimal outboundAmount) {
         this.outboundAmount = outboundAmount;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder outboundAmountExcludingVat(final BigDecimal outboundAmountExcludingVat) {
         this.outboundAmountExcludingVat = outboundAmountExcludingVat;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder outboundUnitPrice(final BigDecimal outboundUnitPrice) {
         this.outboundUnitPrice = outboundUnitPrice;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder outboundUnitPriceExcludingVat(
         final BigDecimal outboundUnitPriceExcludingVat
      ) {
         this.outboundUnitPriceExcludingVat = outboundUnitPriceExcludingVat;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder endMete(final BigDecimal endMete) {
         this.endMete = endMete;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder endQuantity(final BigDecimal endQuantity) {
         this.endQuantity = endQuantity;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder endAmount(final BigDecimal endAmount) {
         this.endAmount = endAmount;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder endAmountExcludingVat(final BigDecimal endAmountExcludingVat) {
         this.endAmountExcludingVat = endAmountExcludingVat;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder endUnitPrice(final BigDecimal endUnitPrice) {
         this.endUnitPrice = endUnitPrice;
         return this;
      }

      public InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder endUnitPriceExcludingVat(final BigDecimal endUnitPriceExcludingVat) {
         this.endUnitPriceExcludingVat = endUnitPriceExcludingVat;
         return this;
      }

      public InventoryDetailsRecordDetailDTO build() {
         return new InventoryDetailsRecordDetailDTO(
            this.receipt,
            this.createTime,
            this.summary,
            this.inboundMete,
            this.inboundQuantity,
            this.inboundAmount,
            this.inboundAmountExcludingVat,
            this.inboundUnitPrice,
            this.inboundUnitPriceExcludingVat,
            this.outboundMete,
            this.outboundQuantity,
            this.outboundAmount,
            this.outboundAmountExcludingVat,
            this.outboundUnitPrice,
            this.outboundUnitPriceExcludingVat,
            this.endMete,
            this.endQuantity,
            this.endAmount,
            this.endAmountExcludingVat,
            this.endUnitPrice,
            this.endUnitPriceExcludingVat
         );
      }

      @Override
      public String toString() {
         return "InventoryDetailsRecordDetailDTO.InventoryDetailsRecordDetailDTOBuilder(receipt="
            + this.receipt
            + ", createTime="
            + this.createTime
            + ", summary="
            + this.summary
            + ", inboundMete="
            + this.inboundMete
            + ", inboundQuantity="
            + this.inboundQuantity
            + ", inboundAmount="
            + this.inboundAmount
            + ", inboundAmountExcludingVat="
            + this.inboundAmountExcludingVat
            + ", inboundUnitPrice="
            + this.inboundUnitPrice
            + ", inboundUnitPriceExcludingVat="
            + this.inboundUnitPriceExcludingVat
            + ", outboundMete="
            + this.outboundMete
            + ", outboundQuantity="
            + this.outboundQuantity
            + ", outboundAmount="
            + this.outboundAmount
            + ", outboundAmountExcludingVat="
            + this.outboundAmountExcludingVat
            + ", outboundUnitPrice="
            + this.outboundUnitPrice
            + ", outboundUnitPriceExcludingVat="
            + this.outboundUnitPriceExcludingVat
            + ", endMete="
            + this.endMete
            + ", endQuantity="
            + this.endQuantity
            + ", endAmount="
            + this.endAmount
            + ", endAmountExcludingVat="
            + this.endAmountExcludingVat
            + ", endUnitPrice="
            + this.endUnitPrice
            + ", endUnitPriceExcludingVat="
            + this.endUnitPriceExcludingVat
            + ")";
      }
   }
}
