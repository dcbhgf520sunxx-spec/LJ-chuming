package com.hzchum.scim.system.core.api.pojo.dto;

import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Range;

public class SafetyFactorVO {
   @NotNull(message = "安全系数不能为空")
   @Range(min = 0L, max = 100L, message = "安全系数范围为0~100")
   private BigDecimal safetyFactor;

   public BigDecimal getSafetyFactor() {
      return this.safetyFactor;
   }

   public void setSafetyFactor(final BigDecimal safetyFactor) {
      this.safetyFactor = safetyFactor;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SafetyFactorVO)) {
         return false;
      }

      SafetyFactorVO other = (SafetyFactorVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$safetyFactor = this.getSafetyFactor();
      Object other$safetyFactor = other.getSafetyFactor();
      return this$safetyFactor == null ? other$safetyFactor == null : this$safetyFactor.equals(other$safetyFactor);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof SafetyFactorVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $safetyFactor = this.getSafetyFactor();
      return result * 59 + ($safetyFactor == null ? 43 : $safetyFactor.hashCode());
   }

   @Override
   public String toString() {
      return "SafetyFactorVO(safetyFactor=" + this.getSafetyFactor() + ")";
   }
}
