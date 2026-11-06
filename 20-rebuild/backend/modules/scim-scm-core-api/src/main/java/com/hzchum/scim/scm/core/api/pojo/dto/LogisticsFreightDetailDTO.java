package com.hzchum.scim.scm.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("物流费详情")
public class LogisticsFreightDetailDTO {
   @ApiModelProperty("类型 1原材料 2制成品")
   private Integer type;
   @ApiModelProperty("费用")
   private BigDecimal freight;
   @ApiModelProperty("已付款额")
   private BigDecimal paymentAmount;
   @ApiModelProperty("已开票额")
   private BigDecimal invoiceAmount;

   public static LogisticsFreightDetailDTO.LogisticsFreightDetailDTOBuilder builder() {
      return new LogisticsFreightDetailDTO.LogisticsFreightDetailDTOBuilder();
   }

   public LogisticsFreightDetailDTO(final Integer type, final BigDecimal freight, final BigDecimal paymentAmount, final BigDecimal invoiceAmount) {
      this.type = type;
      this.freight = freight;
      this.paymentAmount = paymentAmount;
      this.invoiceAmount = invoiceAmount;
   }

   public LogisticsFreightDetailDTO() {
   }

   public Integer getType() {
      return this.type;
   }

   public BigDecimal getFreight() {
      return this.freight;
   }

   public BigDecimal getPaymentAmount() {
      return this.paymentAmount;
   }

   public BigDecimal getInvoiceAmount() {
      return this.invoiceAmount;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setFreight(final BigDecimal freight) {
      this.freight = freight;
   }

   public void setPaymentAmount(final BigDecimal paymentAmount) {
      this.paymentAmount = paymentAmount;
   }

   public void setInvoiceAmount(final BigDecimal invoiceAmount) {
      this.invoiceAmount = invoiceAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LogisticsFreightDetailDTO)) {
         return false;
      }

      LogisticsFreightDetailDTO other = (LogisticsFreightDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$type = this.getType();
      Object other$type = other.getType();
      if (this$type == null ? other$type == null : this$type.equals(other$type)) {
         Object this$freight = this.getFreight();
         Object other$freight = other.getFreight();
         if (this$freight == null ? other$freight == null : this$freight.equals(other$freight)) {
            Object this$paymentAmount = this.getPaymentAmount();
            Object other$paymentAmount = other.getPaymentAmount();
            if (this$paymentAmount == null ? other$paymentAmount == null : this$paymentAmount.equals(other$paymentAmount)) {
               Object this$invoiceAmount = this.getInvoiceAmount();
               Object other$invoiceAmount = other.getInvoiceAmount();
               return this$invoiceAmount == null ? other$invoiceAmount == null : this$invoiceAmount.equals(other$invoiceAmount);
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
      return other instanceof LogisticsFreightDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $freight = this.getFreight();
      result = result * 59 + ($freight == null ? 43 : $freight.hashCode());
      Object $paymentAmount = this.getPaymentAmount();
      result = result * 59 + ($paymentAmount == null ? 43 : $paymentAmount.hashCode());
      Object $invoiceAmount = this.getInvoiceAmount();
      return result * 59 + ($invoiceAmount == null ? 43 : $invoiceAmount.hashCode());
   }

   @Override
   public String toString() {
      return "LogisticsFreightDetailDTO(type="
         + this.getType()
         + ", freight="
         + this.getFreight()
         + ", paymentAmount="
         + this.getPaymentAmount()
         + ", invoiceAmount="
         + this.getInvoiceAmount()
         + ")";
   }

   public static class LogisticsFreightDetailDTOBuilder {
      private Integer type;
      private BigDecimal freight;
      private BigDecimal paymentAmount;
      private BigDecimal invoiceAmount;

      LogisticsFreightDetailDTOBuilder() {
      }

      public LogisticsFreightDetailDTO.LogisticsFreightDetailDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public LogisticsFreightDetailDTO.LogisticsFreightDetailDTOBuilder freight(final BigDecimal freight) {
         this.freight = freight;
         return this;
      }

      public LogisticsFreightDetailDTO.LogisticsFreightDetailDTOBuilder paymentAmount(final BigDecimal paymentAmount) {
         this.paymentAmount = paymentAmount;
         return this;
      }

      public LogisticsFreightDetailDTO.LogisticsFreightDetailDTOBuilder invoiceAmount(final BigDecimal invoiceAmount) {
         this.invoiceAmount = invoiceAmount;
         return this;
      }

      public LogisticsFreightDetailDTO build() {
         return new LogisticsFreightDetailDTO(this.type, this.freight, this.paymentAmount, this.invoiceAmount);
      }

      @Override
      public String toString() {
         return "LogisticsFreightDetailDTO.LogisticsFreightDetailDTOBuilder(type="
            + this.type
            + ", freight="
            + this.freight
            + ", paymentAmount="
            + this.paymentAmount
            + ", invoiceAmount="
            + this.invoiceAmount
            + ")";
      }
   }
}
