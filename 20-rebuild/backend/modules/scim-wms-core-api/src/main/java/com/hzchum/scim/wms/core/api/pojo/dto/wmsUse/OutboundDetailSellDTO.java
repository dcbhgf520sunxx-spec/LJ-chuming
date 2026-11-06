package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import com.hzchum.scim.wms.core.api.pojo.dto.common.BriefIdAndNameDTO;
import java.math.BigDecimal;

public class OutboundDetailSellDTO {
   private BigDecimal inputMete;
   private BigDecimal sellUnitPrice;
   private BigDecimal sellAmount;
   private BigDecimal sellAmountExcludingVat;
   private BigDecimal sellInputVat;
   private BigDecimal profitAmount;
   private BigDecimal differenceMete;
   private Integer invoiceType;
   private BigDecimal taxRate;
   private BriefIdAndNameDTO branchCompany;
   private Integer weightMeasurementMode;
   private String purchaser;

   public static OutboundDetailSellDTO.OutboundDetailSellDTOBuilder builder() {
      return new OutboundDetailSellDTO.OutboundDetailSellDTOBuilder();
   }

   public BigDecimal getInputMete() {
      return this.inputMete;
   }

   public BigDecimal getSellUnitPrice() {
      return this.sellUnitPrice;
   }

   public BigDecimal getSellAmount() {
      return this.sellAmount;
   }

   public BigDecimal getSellAmountExcludingVat() {
      return this.sellAmountExcludingVat;
   }

   public BigDecimal getSellInputVat() {
      return this.sellInputVat;
   }

   public BigDecimal getProfitAmount() {
      return this.profitAmount;
   }

   public BigDecimal getDifferenceMete() {
      return this.differenceMete;
   }

   public Integer getInvoiceType() {
      return this.invoiceType;
   }

   public BigDecimal getTaxRate() {
      return this.taxRate;
   }

   public BriefIdAndNameDTO getBranchCompany() {
      return this.branchCompany;
   }

   public Integer getWeightMeasurementMode() {
      return this.weightMeasurementMode;
   }

   public String getPurchaser() {
      return this.purchaser;
   }

   public void setInputMete(final BigDecimal inputMete) {
      this.inputMete = inputMete;
   }

   public void setSellUnitPrice(final BigDecimal sellUnitPrice) {
      this.sellUnitPrice = sellUnitPrice;
   }

   public void setSellAmount(final BigDecimal sellAmount) {
      this.sellAmount = sellAmount;
   }

   public void setSellAmountExcludingVat(final BigDecimal sellAmountExcludingVat) {
      this.sellAmountExcludingVat = sellAmountExcludingVat;
   }

   public void setSellInputVat(final BigDecimal sellInputVat) {
      this.sellInputVat = sellInputVat;
   }

   public void setProfitAmount(final BigDecimal profitAmount) {
      this.profitAmount = profitAmount;
   }

   public void setDifferenceMete(final BigDecimal differenceMete) {
      this.differenceMete = differenceMete;
   }

   public void setInvoiceType(final Integer invoiceType) {
      this.invoiceType = invoiceType;
   }

   public void setTaxRate(final BigDecimal taxRate) {
      this.taxRate = taxRate;
   }

   public void setBranchCompany(final BriefIdAndNameDTO branchCompany) {
      this.branchCompany = branchCompany;
   }

   public void setWeightMeasurementMode(final Integer weightMeasurementMode) {
      this.weightMeasurementMode = weightMeasurementMode;
   }

   public void setPurchaser(final String purchaser) {
      this.purchaser = purchaser;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof OutboundDetailSellDTO)) {
         return false;
      }

      OutboundDetailSellDTO other = (OutboundDetailSellDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$invoiceType = this.getInvoiceType();
      Object other$invoiceType = other.getInvoiceType();
      if (this$invoiceType == null ? other$invoiceType == null : this$invoiceType.equals(other$invoiceType)) {
         Object this$weightMeasurementMode = this.getWeightMeasurementMode();
         Object other$weightMeasurementMode = other.getWeightMeasurementMode();
         if (this$weightMeasurementMode == null ? other$weightMeasurementMode == null : this$weightMeasurementMode.equals(other$weightMeasurementMode)) {
            Object this$inputMete = this.getInputMete();
            Object other$inputMete = other.getInputMete();
            if (this$inputMete == null ? other$inputMete == null : this$inputMete.equals(other$inputMete)) {
               Object this$sellUnitPrice = this.getSellUnitPrice();
               Object other$sellUnitPrice = other.getSellUnitPrice();
               if (this$sellUnitPrice == null ? other$sellUnitPrice == null : this$sellUnitPrice.equals(other$sellUnitPrice)) {
                  Object this$sellAmount = this.getSellAmount();
                  Object other$sellAmount = other.getSellAmount();
                  if (this$sellAmount == null ? other$sellAmount == null : this$sellAmount.equals(other$sellAmount)) {
                     Object this$sellAmountExcludingVat = this.getSellAmountExcludingVat();
                     Object other$sellAmountExcludingVat = other.getSellAmountExcludingVat();
                     if (this$sellAmountExcludingVat == null
                        ? other$sellAmountExcludingVat == null
                        : this$sellAmountExcludingVat.equals(other$sellAmountExcludingVat)) {
                        Object this$sellInputVat = this.getSellInputVat();
                        Object other$sellInputVat = other.getSellInputVat();
                        if (this$sellInputVat == null ? other$sellInputVat == null : this$sellInputVat.equals(other$sellInputVat)) {
                           Object this$profitAmount = this.getProfitAmount();
                           Object other$profitAmount = other.getProfitAmount();
                           if (this$profitAmount == null ? other$profitAmount == null : this$profitAmount.equals(other$profitAmount)) {
                              Object this$differenceMete = this.getDifferenceMete();
                              Object other$differenceMete = other.getDifferenceMete();
                              if (this$differenceMete == null ? other$differenceMete == null : this$differenceMete.equals(other$differenceMete)) {
                                 Object this$taxRate = this.getTaxRate();
                                 Object other$taxRate = other.getTaxRate();
                                 if (this$taxRate == null ? other$taxRate == null : this$taxRate.equals(other$taxRate)) {
                                    Object this$branchCompany = this.getBranchCompany();
                                    Object other$branchCompany = other.getBranchCompany();
                                    if (this$branchCompany == null ? other$branchCompany == null : this$branchCompany.equals(other$branchCompany)) {
                                       Object this$purchaser = this.getPurchaser();
                                       Object other$purchaser = other.getPurchaser();
                                       return this$purchaser == null ? other$purchaser == null : this$purchaser.equals(other$purchaser);
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
      return other instanceof OutboundDetailSellDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $invoiceType = this.getInvoiceType();
      result = result * 59 + ($invoiceType == null ? 43 : $invoiceType.hashCode());
      Object $weightMeasurementMode = this.getWeightMeasurementMode();
      result = result * 59 + ($weightMeasurementMode == null ? 43 : $weightMeasurementMode.hashCode());
      Object $inputMete = this.getInputMete();
      result = result * 59 + ($inputMete == null ? 43 : $inputMete.hashCode());
      Object $sellUnitPrice = this.getSellUnitPrice();
      result = result * 59 + ($sellUnitPrice == null ? 43 : $sellUnitPrice.hashCode());
      Object $sellAmount = this.getSellAmount();
      result = result * 59 + ($sellAmount == null ? 43 : $sellAmount.hashCode());
      Object $sellAmountExcludingVat = this.getSellAmountExcludingVat();
      result = result * 59 + ($sellAmountExcludingVat == null ? 43 : $sellAmountExcludingVat.hashCode());
      Object $sellInputVat = this.getSellInputVat();
      result = result * 59 + ($sellInputVat == null ? 43 : $sellInputVat.hashCode());
      Object $profitAmount = this.getProfitAmount();
      result = result * 59 + ($profitAmount == null ? 43 : $profitAmount.hashCode());
      Object $differenceMete = this.getDifferenceMete();
      result = result * 59 + ($differenceMete == null ? 43 : $differenceMete.hashCode());
      Object $taxRate = this.getTaxRate();
      result = result * 59 + ($taxRate == null ? 43 : $taxRate.hashCode());
      Object $branchCompany = this.getBranchCompany();
      result = result * 59 + ($branchCompany == null ? 43 : $branchCompany.hashCode());
      Object $purchaser = this.getPurchaser();
      return result * 59 + ($purchaser == null ? 43 : $purchaser.hashCode());
   }

   @Override
   public String toString() {
      return "OutboundDetailSellDTO(inputMete="
         + this.getInputMete()
         + ", sellUnitPrice="
         + this.getSellUnitPrice()
         + ", sellAmount="
         + this.getSellAmount()
         + ", sellAmountExcludingVat="
         + this.getSellAmountExcludingVat()
         + ", sellInputVat="
         + this.getSellInputVat()
         + ", profitAmount="
         + this.getProfitAmount()
         + ", differenceMete="
         + this.getDifferenceMete()
         + ", invoiceType="
         + this.getInvoiceType()
         + ", taxRate="
         + this.getTaxRate()
         + ", branchCompany="
         + this.getBranchCompany()
         + ", weightMeasurementMode="
         + this.getWeightMeasurementMode()
         + ", purchaser="
         + this.getPurchaser()
         + ")";
   }

   public OutboundDetailSellDTO(
      final BigDecimal inputMete,
      final BigDecimal sellUnitPrice,
      final BigDecimal sellAmount,
      final BigDecimal sellAmountExcludingVat,
      final BigDecimal sellInputVat,
      final BigDecimal profitAmount,
      final BigDecimal differenceMete,
      final Integer invoiceType,
      final BigDecimal taxRate,
      final BriefIdAndNameDTO branchCompany,
      final Integer weightMeasurementMode,
      final String purchaser
   ) {
      this.inputMete = inputMete;
      this.sellUnitPrice = sellUnitPrice;
      this.sellAmount = sellAmount;
      this.sellAmountExcludingVat = sellAmountExcludingVat;
      this.sellInputVat = sellInputVat;
      this.profitAmount = profitAmount;
      this.differenceMete = differenceMete;
      this.invoiceType = invoiceType;
      this.taxRate = taxRate;
      this.branchCompany = branchCompany;
      this.weightMeasurementMode = weightMeasurementMode;
      this.purchaser = purchaser;
   }

   public OutboundDetailSellDTO() {
   }

   public static class OutboundDetailSellDTOBuilder {
      private BigDecimal inputMete;
      private BigDecimal sellUnitPrice;
      private BigDecimal sellAmount;
      private BigDecimal sellAmountExcludingVat;
      private BigDecimal sellInputVat;
      private BigDecimal profitAmount;
      private BigDecimal differenceMete;
      private Integer invoiceType;
      private BigDecimal taxRate;
      private BriefIdAndNameDTO branchCompany;
      private Integer weightMeasurementMode;
      private String purchaser;

      OutboundDetailSellDTOBuilder() {
      }

      public OutboundDetailSellDTO.OutboundDetailSellDTOBuilder inputMete(final BigDecimal inputMete) {
         this.inputMete = inputMete;
         return this;
      }

      public OutboundDetailSellDTO.OutboundDetailSellDTOBuilder sellUnitPrice(final BigDecimal sellUnitPrice) {
         this.sellUnitPrice = sellUnitPrice;
         return this;
      }

      public OutboundDetailSellDTO.OutboundDetailSellDTOBuilder sellAmount(final BigDecimal sellAmount) {
         this.sellAmount = sellAmount;
         return this;
      }

      public OutboundDetailSellDTO.OutboundDetailSellDTOBuilder sellAmountExcludingVat(final BigDecimal sellAmountExcludingVat) {
         this.sellAmountExcludingVat = sellAmountExcludingVat;
         return this;
      }

      public OutboundDetailSellDTO.OutboundDetailSellDTOBuilder sellInputVat(final BigDecimal sellInputVat) {
         this.sellInputVat = sellInputVat;
         return this;
      }

      public OutboundDetailSellDTO.OutboundDetailSellDTOBuilder profitAmount(final BigDecimal profitAmount) {
         this.profitAmount = profitAmount;
         return this;
      }

      public OutboundDetailSellDTO.OutboundDetailSellDTOBuilder differenceMete(final BigDecimal differenceMete) {
         this.differenceMete = differenceMete;
         return this;
      }

      public OutboundDetailSellDTO.OutboundDetailSellDTOBuilder invoiceType(final Integer invoiceType) {
         this.invoiceType = invoiceType;
         return this;
      }

      public OutboundDetailSellDTO.OutboundDetailSellDTOBuilder taxRate(final BigDecimal taxRate) {
         this.taxRate = taxRate;
         return this;
      }

      public OutboundDetailSellDTO.OutboundDetailSellDTOBuilder branchCompany(final BriefIdAndNameDTO branchCompany) {
         this.branchCompany = branchCompany;
         return this;
      }

      public OutboundDetailSellDTO.OutboundDetailSellDTOBuilder weightMeasurementMode(final Integer weightMeasurementMode) {
         this.weightMeasurementMode = weightMeasurementMode;
         return this;
      }

      public OutboundDetailSellDTO.OutboundDetailSellDTOBuilder purchaser(final String purchaser) {
         this.purchaser = purchaser;
         return this;
      }

      public OutboundDetailSellDTO build() {
         return new OutboundDetailSellDTO(
            this.inputMete,
            this.sellUnitPrice,
            this.sellAmount,
            this.sellAmountExcludingVat,
            this.sellInputVat,
            this.profitAmount,
            this.differenceMete,
            this.invoiceType,
            this.taxRate,
            this.branchCompany,
            this.weightMeasurementMode,
            this.purchaser
         );
      }

      @Override
      public String toString() {
         return "OutboundDetailSellDTO.OutboundDetailSellDTOBuilder(inputMete="
            + this.inputMete
            + ", sellUnitPrice="
            + this.sellUnitPrice
            + ", sellAmount="
            + this.sellAmount
            + ", sellAmountExcludingVat="
            + this.sellAmountExcludingVat
            + ", sellInputVat="
            + this.sellInputVat
            + ", profitAmount="
            + this.profitAmount
            + ", differenceMete="
            + this.differenceMete
            + ", invoiceType="
            + this.invoiceType
            + ", taxRate="
            + this.taxRate
            + ", branchCompany="
            + this.branchCompany
            + ", weightMeasurementMode="
            + this.weightMeasurementMode
            + ", purchaser="
            + this.purchaser
            + ")";
      }
   }
}
