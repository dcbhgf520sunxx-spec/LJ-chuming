package com.hzchum.scim.mes.enclosure.core.api.pojo._dto.kpi;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "CargoListKpiDTO", description = "每月产量kpi")
public class CargoListKpiDTO {
   @ApiModelProperty(name = "month", notes = "月份", value = "月份")
   @JsonProperty("month")
   @JSONField(name = "month")
   private String month;
   @ApiModelProperty(name = "quantity", notes = "车次量", value = "车次量")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   @JsonInclude(Include.NON_NULL)
   private Integer quantity;
   @ApiModelProperty(name = "amount", notes = "发运量", value = "发运量")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   @JsonInclude(Include.NON_NULL)
   private BigDecimal amount;

   public static CargoListKpiDTO.CargoListKpiDTOBuilder builder() {
      return new CargoListKpiDTO.CargoListKpiDTOBuilder();
   }

   public CargoListKpiDTO(final String month, final Integer quantity, final BigDecimal amount) {
      this.month = month;
      this.quantity = quantity;
      this.amount = amount;
   }

   public CargoListKpiDTO() {
   }

   public String getMonth() {
      return this.month;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   @JsonProperty("month")
   public CargoListKpiDTO setMonth(final String month) {
      this.month = month;
      return this;
   }

   @JsonProperty("quantity")
   public CargoListKpiDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("amount")
   public CargoListKpiDTO setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @Override
   public String toString() {
      return "CargoListKpiDTO(month=" + this.getMonth() + ", quantity=" + this.getQuantity() + ", amount=" + this.getAmount() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListKpiDTO)) {
         return false;
      }

      CargoListKpiDTO other = (CargoListKpiDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$quantity = this.getQuantity();
      Object other$quantity = other.getQuantity();
      if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
         Object this$month = this.getMonth();
         Object other$month = other.getMonth();
         if (this$month == null ? other$month == null : this$month.equals(other$month)) {
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
      return other instanceof CargoListKpiDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $amount = this.getAmount();
      return result * 59 + ($amount == null ? 43 : $amount.hashCode());
   }

   public static class CargoListKpiDTOBuilder {
      private String month;
      private Integer quantity;
      private BigDecimal amount;

      CargoListKpiDTOBuilder() {
      }

      @JsonProperty("month")
      public CargoListKpiDTO.CargoListKpiDTOBuilder month(final String month) {
         this.month = month;
         return this;
      }

      @JsonProperty("quantity")
      public CargoListKpiDTO.CargoListKpiDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("amount")
      public CargoListKpiDTO.CargoListKpiDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      public CargoListKpiDTO build() {
         return new CargoListKpiDTO(this.month, this.quantity, this.amount);
      }

      @Override
      public String toString() {
         return "CargoListKpiDTO.CargoListKpiDTOBuilder(month=" + this.month + ", quantity=" + this.quantity + ", amount=" + this.amount + ")";
      }
   }
}
