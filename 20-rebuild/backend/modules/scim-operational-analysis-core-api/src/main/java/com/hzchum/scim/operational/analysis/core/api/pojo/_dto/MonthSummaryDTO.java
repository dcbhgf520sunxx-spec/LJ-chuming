package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class MonthSummaryDTO {
   @ApiModelProperty(name = "date", value = "月份", notes = "月份")
   @JsonProperty("date")
   @JSONField(name = "date")
   private Integer date;
   @ApiModelProperty(name = "mete", value = "核算量", notes = "核算量")
   @JsonProperty("mete")
   @JSONField(name = "mete")
   private BigDecimal mete;
   @ApiModelProperty(name = "amount", value = "金额", notes = "金额")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   private BigDecimal amount;

   public static MonthSummaryDTO.MonthSummaryDTOBuilder builder() {
      return new MonthSummaryDTO.MonthSummaryDTOBuilder();
   }

   public Integer getDate() {
      return this.date;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   @JsonProperty("date")
   public void setDate(final Integer date) {
      this.date = date;
   }

   @JsonProperty("mete")
   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @JsonProperty("amount")
   public void setAmount(final BigDecimal amount) {
      this.amount = amount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonthSummaryDTO)) {
         return false;
      }

      MonthSummaryDTO other = (MonthSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$date = this.getDate();
      Object other$date = other.getDate();
      if (this$date == null ? other$date == null : this$date.equals(other$date)) {
         Object this$mete = this.getMete();
         Object other$mete = other.getMete();
         if (this$mete == null ? other$mete == null : this$mete.equals(other$mete)) {
            Object this$amount = this.getAmount();
            Object other$amount = other.getAmount();
            return this$amount == null ? other$amount == null : this$amount.equals(other$amount);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MonthSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $mete = this.getMete();
      result = result * 59 + ($mete == null ? 43 : $mete.hashCode());
      Object $amount = this.getAmount();
      return result * 59 + ($amount == null ? 43 : $amount.hashCode());
   }

   @Override
   public String toString() {
      return "MonthSummaryDTO(date=" + this.getDate() + ", mete=" + this.getMete() + ", amount=" + this.getAmount() + ")";
   }

   public MonthSummaryDTO(final Integer date, final BigDecimal mete, final BigDecimal amount) {
      this.date = date;
      this.mete = mete;
      this.amount = amount;
   }

   public MonthSummaryDTO() {
   }

   public static class MonthSummaryDTOBuilder {
      private Integer date;
      private BigDecimal mete;
      private BigDecimal amount;

      MonthSummaryDTOBuilder() {
      }

      @JsonProperty("date")
      public MonthSummaryDTO.MonthSummaryDTOBuilder date(final Integer date) {
         this.date = date;
         return this;
      }

      @JsonProperty("mete")
      public MonthSummaryDTO.MonthSummaryDTOBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      @JsonProperty("amount")
      public MonthSummaryDTO.MonthSummaryDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public MonthSummaryDTO build() {
         return new MonthSummaryDTO(this.date, this.mete, this.amount);
      }

      @Override
      public String toString() {
         return "MonthSummaryDTO.MonthSummaryDTOBuilder(date=" + this.date + ", mete=" + this.mete + ", amount=" + this.amount + ")";
      }
   }
}
