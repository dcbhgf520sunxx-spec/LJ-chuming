package com.hzchum.scim.system.core.api.pojo.dto.config;

import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.scim.system.core.api.common.enums.config.PriceEditModeEnum;
import javax.validation.constraints.NotNull;

public class ContractPriceEditMode {
   @NotNull(message = "价格编辑模式不能为空!")
   @EnumValidator(value = PriceEditModeEnum.class, message = "价格编辑模式有误!")
   private Integer priceEditMode;

   public static ContractPriceEditMode.ContractPriceEditModeBuilder builder() {
      return new ContractPriceEditMode.ContractPriceEditModeBuilder();
   }

   public Integer getPriceEditMode() {
      return this.priceEditMode;
   }

   public void setPriceEditMode(final Integer priceEditMode) {
      this.priceEditMode = priceEditMode;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractPriceEditMode)) {
         return false;
      }

      ContractPriceEditMode other = (ContractPriceEditMode)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$priceEditMode = this.getPriceEditMode();
      Object other$priceEditMode = other.getPriceEditMode();
      return this$priceEditMode == null ? other$priceEditMode == null : this$priceEditMode.equals(other$priceEditMode);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractPriceEditMode;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $priceEditMode = this.getPriceEditMode();
      return result * 59 + ($priceEditMode == null ? 43 : $priceEditMode.hashCode());
   }

   @Override
   public String toString() {
      return "ContractPriceEditMode(priceEditMode=" + this.getPriceEditMode() + ")";
   }

   public ContractPriceEditMode(final Integer priceEditMode) {
      this.priceEditMode = priceEditMode;
   }

   public ContractPriceEditMode() {
   }

   public static class ContractPriceEditModeBuilder {
      private Integer priceEditMode;

      ContractPriceEditModeBuilder() {
      }

      public ContractPriceEditMode.ContractPriceEditModeBuilder priceEditMode(final Integer priceEditMode) {
         this.priceEditMode = priceEditMode;
         return this;
      }

      public ContractPriceEditMode build() {
         return new ContractPriceEditMode(this.priceEditMode);
      }

      @Override
      public String toString() {
         return "ContractPriceEditMode.ContractPriceEditModeBuilder(priceEditMode=" + this.priceEditMode + ")";
      }
   }
}
