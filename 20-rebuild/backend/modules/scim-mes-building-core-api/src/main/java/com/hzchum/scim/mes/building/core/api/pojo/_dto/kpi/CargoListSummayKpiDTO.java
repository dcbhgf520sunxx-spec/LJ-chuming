package com.hzchum.scim.mes.building.core.api.pojo._dto.kpi;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "CargoListSummayKpiDTO", description = "发运kpi汇总")
public class CargoListSummayKpiDTO {
   @ApiModelProperty(name = "cargoListAmount", notes = "今年度累计发运量", value = "今年度累计发运量")
   @JsonProperty("cargoListAmount")
   @JSONField(name = "cargoListAmount")
   private BigDecimal cargoListAmount;
   @ApiModelProperty(name = "cargoListQuantity", notes = "今年发运车次", value = "今年发运车次")
   @JsonProperty("cargoListQuantity")
   @JSONField(name = "cargoListQuantity")
   private Integer cargoListQuantity;
   @ApiModelProperty(name = "lastDayAmount", notes = "昨天发运量", value = "昨天发运量")
   @JsonProperty("lastDayAmount")
   @JSONField(name = "lastDayAmount")
   private BigDecimal lastDayAmount;
   @ApiModelProperty(name = "amount", notes = "今日发运量", value = "今日发运量")
   @JsonProperty("amount")
   @JSONField(name = "amount")
   private BigDecimal amount;
   @ApiModelProperty(name = "lastDayQuantity", notes = "昨天发运车次", value = "昨天发运车次")
   @JsonProperty("lastDayQuantity")
   @JSONField(name = "lastDayQuantity")
   private Integer lastDayQuantity;
   @ApiModelProperty(name = "quantity", notes = "今日发运车次", value = "今日发运车次")
   @JsonProperty("quantity")
   @JSONField(name = "quantity")
   private Integer quantity;
   @ApiModelProperty(name = "stock", notes = "库存", value = "库存")
   @JsonProperty("stock")
   @JSONField(name = "stock")
   private BigDecimal stock;

   public static CargoListSummayKpiDTO.CargoListSummayKpiDTOBuilder builder() {
      return new CargoListSummayKpiDTO.CargoListSummayKpiDTOBuilder();
   }

   public CargoListSummayKpiDTO(
      final BigDecimal cargoListAmount,
      final Integer cargoListQuantity,
      final BigDecimal lastDayAmount,
      final BigDecimal amount,
      final Integer lastDayQuantity,
      final Integer quantity,
      final BigDecimal stock
   ) {
      this.cargoListAmount = cargoListAmount;
      this.cargoListQuantity = cargoListQuantity;
      this.lastDayAmount = lastDayAmount;
      this.amount = amount;
      this.lastDayQuantity = lastDayQuantity;
      this.quantity = quantity;
      this.stock = stock;
   }

   public CargoListSummayKpiDTO() {
   }

   public BigDecimal getCargoListAmount() {
      return this.cargoListAmount;
   }

   public Integer getCargoListQuantity() {
      return this.cargoListQuantity;
   }

   public BigDecimal getLastDayAmount() {
      return this.lastDayAmount;
   }

   public BigDecimal getAmount() {
      return this.amount;
   }

   public Integer getLastDayQuantity() {
      return this.lastDayQuantity;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getStock() {
      return this.stock;
   }

   @JsonProperty("cargoListAmount")
   public CargoListSummayKpiDTO setCargoListAmount(final BigDecimal cargoListAmount) {
      this.cargoListAmount = cargoListAmount;
      return this;
   }

   @JsonProperty("cargoListQuantity")
   public CargoListSummayKpiDTO setCargoListQuantity(final Integer cargoListQuantity) {
      this.cargoListQuantity = cargoListQuantity;
      return this;
   }

   @JsonProperty("lastDayAmount")
   public CargoListSummayKpiDTO setLastDayAmount(final BigDecimal lastDayAmount) {
      this.lastDayAmount = lastDayAmount;
      return this;
   }

   @JsonProperty("amount")
   public CargoListSummayKpiDTO setAmount(final BigDecimal amount) {
      this.amount = amount;
      return this;
   }

   @JsonProperty("lastDayQuantity")
   public CargoListSummayKpiDTO setLastDayQuantity(final Integer lastDayQuantity) {
      this.lastDayQuantity = lastDayQuantity;
      return this;
   }

   @JsonProperty("quantity")
   public CargoListSummayKpiDTO setQuantity(final Integer quantity) {
      this.quantity = quantity;
      return this;
   }

   @JsonProperty("stock")
   public CargoListSummayKpiDTO setStock(final BigDecimal stock) {
      this.stock = stock;
      return this;
   }

   @Override
   public String toString() {
      return "CargoListSummayKpiDTO(cargoListAmount="
         + this.getCargoListAmount()
         + ", cargoListQuantity="
         + this.getCargoListQuantity()
         + ", lastDayAmount="
         + this.getLastDayAmount()
         + ", amount="
         + this.getAmount()
         + ", lastDayQuantity="
         + this.getLastDayQuantity()
         + ", quantity="
         + this.getQuantity()
         + ", stock="
         + this.getStock()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CargoListSummayKpiDTO)) {
         return false;
      }

      CargoListSummayKpiDTO other = (CargoListSummayKpiDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$cargoListQuantity = this.getCargoListQuantity();
      Object other$cargoListQuantity = other.getCargoListQuantity();
      if (this$cargoListQuantity == null ? other$cargoListQuantity == null : this$cargoListQuantity.equals(other$cargoListQuantity)) {
         Object this$lastDayQuantity = this.getLastDayQuantity();
         Object other$lastDayQuantity = other.getLastDayQuantity();
         if (this$lastDayQuantity == null ? other$lastDayQuantity == null : this$lastDayQuantity.equals(other$lastDayQuantity)) {
            Object this$quantity = this.getQuantity();
            Object other$quantity = other.getQuantity();
            if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
               Object this$cargoListAmount = this.getCargoListAmount();
               Object other$cargoListAmount = other.getCargoListAmount();
               if (this$cargoListAmount == null ? other$cargoListAmount == null : this$cargoListAmount.equals(other$cargoListAmount)) {
                  Object this$lastDayAmount = this.getLastDayAmount();
                  Object other$lastDayAmount = other.getLastDayAmount();
                  if (this$lastDayAmount == null ? other$lastDayAmount == null : this$lastDayAmount.equals(other$lastDayAmount)) {
                     Object this$amount = this.getAmount();
                     Object other$amount = other.getAmount();
                     if (this$amount == null ? other$amount == null : this$amount.equals(other$amount)) {
                        Object this$stock = this.getStock();
                        Object other$stock = other.getStock();
                        return this$stock == null ? other$stock == null : this$stock.equals(other$stock);
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
      return other instanceof CargoListSummayKpiDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $cargoListQuantity = this.getCargoListQuantity();
      result = result * 59 + ($cargoListQuantity == null ? 43 : $cargoListQuantity.hashCode());
      Object $lastDayQuantity = this.getLastDayQuantity();
      result = result * 59 + ($lastDayQuantity == null ? 43 : $lastDayQuantity.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $cargoListAmount = this.getCargoListAmount();
      result = result * 59 + ($cargoListAmount == null ? 43 : $cargoListAmount.hashCode());
      Object $lastDayAmount = this.getLastDayAmount();
      result = result * 59 + ($lastDayAmount == null ? 43 : $lastDayAmount.hashCode());
      Object $amount = this.getAmount();
      result = result * 59 + ($amount == null ? 43 : $amount.hashCode());
      Object $stock = this.getStock();
      return result * 59 + ($stock == null ? 43 : $stock.hashCode());
   }

   public static class CargoListSummayKpiDTOBuilder {
      private BigDecimal cargoListAmount;
      private Integer cargoListQuantity;
      private BigDecimal lastDayAmount;
      private BigDecimal amount;
      private Integer lastDayQuantity;
      private Integer quantity;
      private BigDecimal stock;

      CargoListSummayKpiDTOBuilder() {
      }

      @JsonProperty("cargoListAmount")
      public CargoListSummayKpiDTO.CargoListSummayKpiDTOBuilder cargoListAmount(final BigDecimal cargoListAmount) {
         this.cargoListAmount = cargoListAmount;
         return this;
      }

      @JsonProperty("cargoListQuantity")
      public CargoListSummayKpiDTO.CargoListSummayKpiDTOBuilder cargoListQuantity(final Integer cargoListQuantity) {
         this.cargoListQuantity = cargoListQuantity;
         return this;
      }

      @JsonProperty("lastDayAmount")
      public CargoListSummayKpiDTO.CargoListSummayKpiDTOBuilder lastDayAmount(final BigDecimal lastDayAmount) {
         this.lastDayAmount = lastDayAmount;
         return this;
      }

      @JsonProperty("amount")
      public CargoListSummayKpiDTO.CargoListSummayKpiDTOBuilder amount(final BigDecimal amount) {
         this.amount = amount;
         return this;
      }

      @JsonProperty("lastDayQuantity")
      public CargoListSummayKpiDTO.CargoListSummayKpiDTOBuilder lastDayQuantity(final Integer lastDayQuantity) {
         this.lastDayQuantity = lastDayQuantity;
         return this;
      }

      @JsonProperty("quantity")
      public CargoListSummayKpiDTO.CargoListSummayKpiDTOBuilder quantity(final Integer quantity) {
         this.quantity = quantity;
         return this;
      }

      @JsonProperty("stock")
      public CargoListSummayKpiDTO.CargoListSummayKpiDTOBuilder stock(final BigDecimal stock) {
         this.stock = stock;
         return this;
      }

      public CargoListSummayKpiDTO build() {
         return new CargoListSummayKpiDTO(
            this.cargoListAmount, this.cargoListQuantity, this.lastDayAmount, this.amount, this.lastDayQuantity, this.quantity, this.stock
         );
      }

      @Override
      public String toString() {
         return "CargoListSummayKpiDTO.CargoListSummayKpiDTOBuilder(cargoListAmount="
            + this.cargoListAmount
            + ", cargoListQuantity="
            + this.cargoListQuantity
            + ", lastDayAmount="
            + this.lastDayAmount
            + ", amount="
            + this.amount
            + ", lastDayQuantity="
            + this.lastDayQuantity
            + ", quantity="
            + this.quantity
            + ", stock="
            + this.stock
            + ")";
      }
   }
}
