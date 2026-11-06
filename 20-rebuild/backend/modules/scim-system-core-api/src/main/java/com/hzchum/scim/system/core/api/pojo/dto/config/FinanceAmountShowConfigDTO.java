package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

public class FinanceAmountShowConfigDTO {
   @NotNull(message = "参数传值不能为空!")
   @ApiModelProperty("是否显示:未结算项目的未收款额: true显示(合同额-已收款额) false不显示")
   private Boolean boolShowUnsettledUncollectedAmount;
   @NotNull(message = "参数传值不能为空!")
   @ApiModelProperty("是否显示:未结算采购单的未付款额: true:显示(合同额-已付款额) false不显示")
   private Boolean boolShowUnsettledUnpaidAmount;

   public static FinanceAmountShowConfigDTO.FinanceAmountShowConfigDTOBuilder builder() {
      return new FinanceAmountShowConfigDTO.FinanceAmountShowConfigDTOBuilder();
   }

   public FinanceAmountShowConfigDTO(final Boolean boolShowUnsettledUncollectedAmount, final Boolean boolShowUnsettledUnpaidAmount) {
      this.boolShowUnsettledUncollectedAmount = boolShowUnsettledUncollectedAmount;
      this.boolShowUnsettledUnpaidAmount = boolShowUnsettledUnpaidAmount;
   }

   public FinanceAmountShowConfigDTO() {
   }

   public Boolean getBoolShowUnsettledUncollectedAmount() {
      return this.boolShowUnsettledUncollectedAmount;
   }

   public Boolean getBoolShowUnsettledUnpaidAmount() {
      return this.boolShowUnsettledUnpaidAmount;
   }

   public void setBoolShowUnsettledUncollectedAmount(final Boolean boolShowUnsettledUncollectedAmount) {
      this.boolShowUnsettledUncollectedAmount = boolShowUnsettledUncollectedAmount;
   }

   public void setBoolShowUnsettledUnpaidAmount(final Boolean boolShowUnsettledUnpaidAmount) {
      this.boolShowUnsettledUnpaidAmount = boolShowUnsettledUnpaidAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof FinanceAmountShowConfigDTO)) {
         return false;
      } else {
         FinanceAmountShowConfigDTO other = (FinanceAmountShowConfigDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$boolShowUnsettledUncollectedAmount = this.getBoolShowUnsettledUncollectedAmount();
            Object other$boolShowUnsettledUncollectedAmount = other.getBoolShowUnsettledUncollectedAmount();
            if (this$boolShowUnsettledUncollectedAmount == null
               ? other$boolShowUnsettledUncollectedAmount == null
               : this$boolShowUnsettledUncollectedAmount.equals(other$boolShowUnsettledUncollectedAmount)) {
               Object this$boolShowUnsettledUnpaidAmount = this.getBoolShowUnsettledUnpaidAmount();
               Object other$boolShowUnsettledUnpaidAmount = other.getBoolShowUnsettledUnpaidAmount();
               return this$boolShowUnsettledUnpaidAmount == null
                  ? other$boolShowUnsettledUnpaidAmount == null
                  : this$boolShowUnsettledUnpaidAmount.equals(other$boolShowUnsettledUnpaidAmount);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof FinanceAmountShowConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolShowUnsettledUncollectedAmount = this.getBoolShowUnsettledUncollectedAmount();
      result = result * 59 + ($boolShowUnsettledUncollectedAmount == null ? 43 : $boolShowUnsettledUncollectedAmount.hashCode());
      Object $boolShowUnsettledUnpaidAmount = this.getBoolShowUnsettledUnpaidAmount();
      return result * 59 + ($boolShowUnsettledUnpaidAmount == null ? 43 : $boolShowUnsettledUnpaidAmount.hashCode());
   }

   @Override
   public String toString() {
      return "FinanceAmountShowConfigDTO(boolShowUnsettledUncollectedAmount="
         + this.getBoolShowUnsettledUncollectedAmount()
         + ", boolShowUnsettledUnpaidAmount="
         + this.getBoolShowUnsettledUnpaidAmount()
         + ")";
   }

   public static class FinanceAmountShowConfigDTOBuilder {
      private Boolean boolShowUnsettledUncollectedAmount;
      private Boolean boolShowUnsettledUnpaidAmount;

      FinanceAmountShowConfigDTOBuilder() {
      }

      public FinanceAmountShowConfigDTO.FinanceAmountShowConfigDTOBuilder boolShowUnsettledUncollectedAmount(final Boolean boolShowUnsettledUncollectedAmount) {
         this.boolShowUnsettledUncollectedAmount = boolShowUnsettledUncollectedAmount;
         return this;
      }

      public FinanceAmountShowConfigDTO.FinanceAmountShowConfigDTOBuilder boolShowUnsettledUnpaidAmount(final Boolean boolShowUnsettledUnpaidAmount) {
         this.boolShowUnsettledUnpaidAmount = boolShowUnsettledUnpaidAmount;
         return this;
      }

      public FinanceAmountShowConfigDTO build() {
         return new FinanceAmountShowConfigDTO(this.boolShowUnsettledUncollectedAmount, this.boolShowUnsettledUnpaidAmount);
      }

      @Override
      public String toString() {
         return "FinanceAmountShowConfigDTO.FinanceAmountShowConfigDTOBuilder(boolShowUnsettledUncollectedAmount="
            + this.boolShowUnsettledUncollectedAmount
            + ", boolShowUnsettledUnpaidAmount="
            + this.boolShowUnsettledUnpaidAmount
            + ")";
      }
   }
}
