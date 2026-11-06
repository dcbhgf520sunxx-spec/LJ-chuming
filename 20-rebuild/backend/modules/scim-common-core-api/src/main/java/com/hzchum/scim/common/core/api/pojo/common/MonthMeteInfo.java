package com.hzchum.scim.common.core.api.pojo.common;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("月份-量")
public class MonthMeteInfo {
   @ApiModelProperty("月份")
   private Integer month;
   @ApiModelProperty("量")
   private BigDecimal mete;

   public static MonthMeteInfo.MonthMeteInfoBuilder builder() {
      return new MonthMeteInfo.MonthMeteInfoBuilder();
   }

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getMete() {
      return this.mete;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setMete(final BigDecimal mete) {
      this.mete = mete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof MonthMeteInfo)) {
         return false;
      } else {
         MonthMeteInfo other = (MonthMeteInfo)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$month = this.getMonth();
            Object other$month = other.getMonth();
            if (this$month == null ? other$month == null : this$month.equals(other$month)) {
               Object this$mete = this.getMete();
               Object other$mete = other.getMete();
               return this$mete == null ? other$mete == null : this$mete.equals(other$mete);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MonthMeteInfo;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $mete = this.getMete();
      return result * 59 + ($mete == null ? 43 : $mete.hashCode());
   }

   @Override
   public String toString() {
      return "MonthMeteInfo(month=" + this.getMonth() + ", mete=" + this.getMete() + ")";
   }

   public MonthMeteInfo(final Integer month, final BigDecimal mete) {
      this.month = month;
      this.mete = mete;
   }

   public MonthMeteInfo() {
   }

   public static class MonthMeteInfoBuilder {
      private Integer month;
      private BigDecimal mete;

      MonthMeteInfoBuilder() {
      }

      public MonthMeteInfo.MonthMeteInfoBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public MonthMeteInfo.MonthMeteInfoBuilder mete(final BigDecimal mete) {
         this.mete = mete;
         return this;
      }

      public MonthMeteInfo build() {
         return new MonthMeteInfo(this.month, this.mete);
      }

      @Override
      public String toString() {
         return "MonthMeteInfo.MonthMeteInfoBuilder(month=" + this.month + ", mete=" + this.mete + ")";
      }
   }
}
