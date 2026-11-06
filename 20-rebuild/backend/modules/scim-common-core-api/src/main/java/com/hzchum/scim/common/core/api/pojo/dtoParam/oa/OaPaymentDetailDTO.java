package com.hzchum.scim.common.core.api.pojo.dtoParam.oa;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel("OaPaymentDetailDTO")
public class OaPaymentDetailDTO {
   private String serialNumber;
   private BigDecimal paymentAmount;

   public static OaPaymentDetailDTO.OaPaymentDetailDTOBuilder builder() {
      return new OaPaymentDetailDTO.OaPaymentDetailDTOBuilder();
   }

   public OaPaymentDetailDTO(final String serialNumber, final BigDecimal paymentAmount) {
      this.serialNumber = serialNumber;
      this.paymentAmount = paymentAmount;
   }

   public OaPaymentDetailDTO() {
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public OaPaymentDetailDTO setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public OaPaymentDetailDTO setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
      return this;
   }

   @Override
   public String toString() {
      return "OaPaymentDetailDTO(serialNumber=" + this.getSerialNumber() + ", paymentAmount=" + this.getPaymentAmount() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof OaPaymentDetailDTO)) {
         return false;
      } else {
         OaPaymentDetailDTO other = (OaPaymentDetailDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$serialNumber = this.getSerialNumber();
            Object other$serialNumber = other.getSerialNumber();
            if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
               Object this$paymentAmount = this.getPaymentAmount();
               Object other$paymentAmount = other.getPaymentAmount();
               return this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof OaPaymentDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      return result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
   }

   public static class OaPaymentDetailDTOBuilder {
      private String serialNumber;
      private BigDecimal paymentAmount;

      OaPaymentDetailDTOBuilder() {
      }

      public OaPaymentDetailDTO.OaPaymentDetailDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public OaPaymentDetailDTO.OaPaymentDetailDTOBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public OaPaymentDetailDTO build() {
         return new OaPaymentDetailDTO(this.serialNumber, this.paymentAmount);
      }

      @Override
      public String toString() {
         return "OaPaymentDetailDTO.OaPaymentDetailDTOBuilder(serialNumber=" + this.serialNumber + ", paymentAmount=" + this.paymentAmount + ")";
      }
   }
}
