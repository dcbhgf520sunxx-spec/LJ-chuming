package com.hzchum.scim.system.core.api.pojo.dto.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;

@ApiModel("业财金额额度配置类")
public class FinanceAmountLimitConfigDTO {
   @NotNull(message = "数据不可为空!")
   @ApiModelProperty("结算前,是否允许超过合同额")
   private Boolean boolAllowOverContractAmount;
   @NotNull(message = "数据不可为空!")
   @ApiModelProperty("结算后,是否允许超过结算额")
   private Boolean boolAllowOverSettleAmount;

   public static FinanceAmountLimitConfigDTO.FinanceAmountLimitConfigDTOBuilder builder() {
      return new FinanceAmountLimitConfigDTO.FinanceAmountLimitConfigDTOBuilder();
   }

   public FinanceAmountLimitConfigDTO(final Boolean boolAllowOverContractAmount, final Boolean boolAllowOverSettleAmount) {
      this.boolAllowOverContractAmount = boolAllowOverContractAmount;
      this.boolAllowOverSettleAmount = boolAllowOverSettleAmount;
   }

   public FinanceAmountLimitConfigDTO() {
   }

   public Boolean getBoolAllowOverContractAmount() {
      return this.boolAllowOverContractAmount;
   }

   public Boolean getBoolAllowOverSettleAmount() {
      return this.boolAllowOverSettleAmount;
   }

   public void setBoolAllowOverContractAmount(final Boolean boolAllowOverContractAmount) {
      this.boolAllowOverContractAmount = boolAllowOverContractAmount;
   }

   public void setBoolAllowOverSettleAmount(final Boolean boolAllowOverSettleAmount) {
      this.boolAllowOverSettleAmount = boolAllowOverSettleAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof FinanceAmountLimitConfigDTO)) {
         return false;
      } else {
         FinanceAmountLimitConfigDTO other = (FinanceAmountLimitConfigDTO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$boolAllowOverContractAmount = this.getBoolAllowOverContractAmount();
            Object other$boolAllowOverContractAmount = other.getBoolAllowOverContractAmount();
            if (this$boolAllowOverContractAmount == null
               ? other$boolAllowOverContractAmount == null
               : this$boolAllowOverContractAmount.equals(other$boolAllowOverContractAmount)) {
               Object this$boolAllowOverSettleAmount = this.getBoolAllowOverSettleAmount();
               Object other$boolAllowOverSettleAmount = other.getBoolAllowOverSettleAmount();
               return this$boolAllowOverSettleAmount == null
                  ? other$boolAllowOverSettleAmount == null
                  : this$boolAllowOverSettleAmount.equals(other$boolAllowOverSettleAmount);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof FinanceAmountLimitConfigDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolAllowOverContractAmount = this.getBoolAllowOverContractAmount();
      result = result * 59 + ($boolAllowOverContractAmount == null ? 43 : $boolAllowOverContractAmount.hashCode());
      Object $boolAllowOverSettleAmount = this.getBoolAllowOverSettleAmount();
      return result * 59 + ($boolAllowOverSettleAmount == null ? 43 : $boolAllowOverSettleAmount.hashCode());
   }

   @Override
   public String toString() {
      return "FinanceAmountLimitConfigDTO(boolAllowOverContractAmount="
         + this.getBoolAllowOverContractAmount()
         + ", boolAllowOverSettleAmount="
         + this.getBoolAllowOverSettleAmount()
         + ")";
   }

   public static class FinanceAmountLimitConfigDTOBuilder {
      private Boolean boolAllowOverContractAmount;
      private Boolean boolAllowOverSettleAmount;

      FinanceAmountLimitConfigDTOBuilder() {
      }

      public FinanceAmountLimitConfigDTO.FinanceAmountLimitConfigDTOBuilder boolAllowOverContractAmount(final Boolean boolAllowOverContractAmount) {
         this.boolAllowOverContractAmount = boolAllowOverContractAmount;
         return this;
      }

      public FinanceAmountLimitConfigDTO.FinanceAmountLimitConfigDTOBuilder boolAllowOverSettleAmount(final Boolean boolAllowOverSettleAmount) {
         this.boolAllowOverSettleAmount = boolAllowOverSettleAmount;
         return this;
      }

      public FinanceAmountLimitConfigDTO build() {
         return new FinanceAmountLimitConfigDTO(this.boolAllowOverContractAmount, this.boolAllowOverSettleAmount);
      }

      @Override
      public String toString() {
         return "FinanceAmountLimitConfigDTO.FinanceAmountLimitConfigDTOBuilder(boolAllowOverContractAmount="
            + this.boolAllowOverContractAmount
            + ", boolAllowOverSettleAmount="
            + this.boolAllowOverSettleAmount
            + ")";
      }
   }
}
