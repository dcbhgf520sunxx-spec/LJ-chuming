package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SecurityDepositAndManagementCostDetailDTO {
   @ApiModelProperty("日期")
   private LocalDateTime date;
   @ApiModelProperty("凭证号")
   private String voucherNumber;
   @ApiModelProperty("金额")
   private BigDecimal amount;
   @ApiModelProperty("费率")
   private String rate;
   @ApiModelProperty("扣款")
   private BigDecimal deduct;

   public static SecurityDepositAndManagementCostDetailDTO.SecurityDepositAndManagementCostDetailDTOBuilder builder() {
      return new SecurityDepositAndManagementCostDetailDTO.SecurityDepositAndManagementCostDetailDTOBuilder();
   }

   public LocalDateTime getDate() {
      return this.date;
   }

   public String getVoucherNumber() {
      return this.voucherNumber;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public String getRate() {
      return this.rate;
   }

   public BigDecimal getDeduct() {
      return this.deduct;
   }

   public void setDate(final LocalDateTime date) {
      this.date = date;
   }

   public void setVoucherNumber(final String voucherNumber) {
      this.voucherNumber = voucherNumber;
   }

   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   public void setRate(final String rate) {
      this.rate = rate;
   }

   public void setDeduct(final BigDecimal deduct) {
      this.deduct = deduct;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SecurityDepositAndManagementCostDetailDTO)) {
         return false;
      }

      SecurityDepositAndManagementCostDetailDTO other = (SecurityDepositAndManagementCostDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$date = this.getDate();
      Object other$date = other.getDate();
      if (this$date == null ? other$date == null : this$date.equals(other$date)) {
         Object this$voucherNumber = this.getVoucherNumber();
         Object other$voucherNumber = other.getVoucherNumber();
         if (this$voucherNumber == null ? other$voucherNumber == null : this$voucherNumber.equals(other$voucherNumber)) {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
               Object this$rate = this.getRate();
               Object other$rate = other.getRate();
               if (this$rate == null ? other$rate == null : this$rate.equals(other$rate)) {
                  Object this$deduct = this.getDeduct();
                  Object other$deduct = other.getDeduct();
                  return this$deduct == null ? other$deduct == null : this$deduct.equals(other$deduct);
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
      return other instanceof SecurityDepositAndManagementCostDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $voucherNumber = this.getVoucherNumber();
      result = result * 59 + ($voucherNumber == null ? 43 : $voucherNumber.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $rate = this.getRate();
      result = result * 59 + ($rate == null ? 43 : $rate.hashCode());
      Object $deduct = this.getDeduct();
      return result * 59 + ($deduct == null ? 43 : $deduct.hashCode());
   }

   @Override
   public String toString() {
      return "SecurityDepositAndManagementCostDetailDTO(date="
         + this.getDate()
         + ", voucherNumber="
         + this.getVoucherNumber()
         + ", amount="
         + this.getAmount()
         + ", rate="
         + this.getRate()
         + ", deduct="
         + this.getDeduct()
         + ")";
   }

   public SecurityDepositAndManagementCostDetailDTO(
      final LocalDateTime date, final String voucherNumber, final BigDecimal amount, final String rate, final BigDecimal deduct
   ) {
      this.date = date;
      this.voucherNumber = voucherNumber;
      this.amount = amount;
      this.rate = rate;
      this.deduct = deduct;
   }

   public SecurityDepositAndManagementCostDetailDTO() {
   }

   public static class SecurityDepositAndManagementCostDetailDTOBuilder {
      private LocalDateTime date;
      private String voucherNumber;
      private BigDecimal amount;
      private String rate;
      private BigDecimal deduct;

      SecurityDepositAndManagementCostDetailDTOBuilder() {
      }

      public SecurityDepositAndManagementCostDetailDTO.SecurityDepositAndManagementCostDetailDTOBuilder date(final LocalDateTime date) {
         this.date = date;
         return this;
      }

      public SecurityDepositAndManagementCostDetailDTO.SecurityDepositAndManagementCostDetailDTOBuilder voucherNumber(final String voucherNumber) {
         this.voucherNumber = voucherNumber;
         return this;
      }

      public SecurityDepositAndManagementCostDetailDTO.SecurityDepositAndManagementCostDetailDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public SecurityDepositAndManagementCostDetailDTO.SecurityDepositAndManagementCostDetailDTOBuilder rate(final String rate) {
         this.rate = rate;
         return this;
      }

      public SecurityDepositAndManagementCostDetailDTO.SecurityDepositAndManagementCostDetailDTOBuilder deduct(final BigDecimal deduct) {
         this.deduct = deduct;
         return this;
      }

      public SecurityDepositAndManagementCostDetailDTO build() {
         return new SecurityDepositAndManagementCostDetailDTO(this.date, this.voucherNumber, this.amount, this.rate, this.deduct);
      }

      @Override
      public String toString() {
         return "SecurityDepositAndManagementCostDetailDTO.SecurityDepositAndManagementCostDetailDTOBuilder(date="
            + this.date
            + ", voucherNumber="
            + this.voucherNumber
            + ", amount="
            + this.amount
            + ", rate="
            + this.rate
            + ", deduct="
            + this.deduct
            + ")";
      }
   }
}
