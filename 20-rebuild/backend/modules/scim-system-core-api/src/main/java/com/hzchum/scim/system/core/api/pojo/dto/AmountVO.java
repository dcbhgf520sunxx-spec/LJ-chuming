package com.hzchum.scim.system.core.api.pojo.dto;

import javax.validation.constraints.NotNull;

public class AmountVO {
   @NotNull(message = "是否显示项目全称不能为空")
   private Integer yuanDecimal;

   public Integer getYuanDecimal() {
      return this.yuanDecimal;
   }

   public void setYuanDecimal(final Integer yuanDecimal) {
      this.yuanDecimal = yuanDecimal;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof AmountVO)) {
         return false;
      }

      AmountVO other = (AmountVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$yuanDecimal = this.getYuanDecimal();
      Object other$yuanDecimal = other.getYuanDecimal();
      return this$yuanDecimal == null ? other$yuanDecimal == null : this$yuanDecimal.equals(other$yuanDecimal);
   }

   protected boolean canEqual(final Object other) {
      return other instanceof AmountVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $yuanDecimal = this.getYuanDecimal();
      return result * 59 + ($yuanDecimal == null ? 43 : $yuanDecimal.hashCode());
   }

   @Override
   public String toString() {
      return "AmountVO(yuanDecimal=" + this.getYuanDecimal() + ")";
   }
}
