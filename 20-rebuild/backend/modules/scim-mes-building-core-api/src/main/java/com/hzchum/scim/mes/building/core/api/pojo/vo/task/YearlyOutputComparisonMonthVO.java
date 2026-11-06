package com.hzchum.scim.mes.building.core.api.pojo.vo.task;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "YearlyOutputComparisonMonthVO", description = "年度产量报表每月数据")
public class YearlyOutputComparisonMonthVO {
   private String productMonth;
   private BigDecimal totalNetWeight;

   public static YearlyOutputComparisonMonthVO.YearlyOutputComparisonMonthVOBuilder builder() {
      return new YearlyOutputComparisonMonthVO.YearlyOutputComparisonMonthVOBuilder();
   }

   public YearlyOutputComparisonMonthVO() {
   }

   public YearlyOutputComparisonMonthVO(final String productMonth, final BigDecimal totalNetWeight) {
      this.productMonth = productMonth;
      this.totalNetWeight = totalNetWeight;
   }

   public String getProductMonth() {
      return this.productMonth;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public YearlyOutputComparisonMonthVO setProductMonth(final String productMonth) {
      this.productMonth = productMonth;
      return this;
   }

   public YearlyOutputComparisonMonthVO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof YearlyOutputComparisonMonthVO)) {
         return false;
      } else {
         YearlyOutputComparisonMonthVO other = (YearlyOutputComparisonMonthVO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$productMonth = this.getProductMonth();
            Object other$productMonth = other.getProductMonth();
            if (this$productMonth == null ? other$productMonth == null : this$productMonth.equals(other$productMonth)) {
               Object this$totalNetWeight = this.getTotalNetWeight();
               Object other$totalNetWeight = other.getTotalNetWeight();
               return this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof YearlyOutputComparisonMonthVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productMonth = this.getProductMonth();
      result = result * 59 + ($productMonth == null ? 43 : $productMonth.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      return result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
   }

   @Override
   public String toString() {
      return "YearlyOutputComparisonMonthVO(productMonth=" + this.getProductMonth() + ", totalNetWeight=" + this.getTotalNetWeight() + ")";
   }

   public static class YearlyOutputComparisonMonthVOBuilder {
      private String productMonth;
      private BigDecimal totalNetWeight;

      YearlyOutputComparisonMonthVOBuilder() {
      }

      public YearlyOutputComparisonMonthVO.YearlyOutputComparisonMonthVOBuilder productMonth(final String productMonth) {
         this.productMonth = productMonth;
         return this;
      }

      public YearlyOutputComparisonMonthVO.YearlyOutputComparisonMonthVOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public YearlyOutputComparisonMonthVO build() {
         return new YearlyOutputComparisonMonthVO(this.productMonth, this.totalNetWeight);
      }

      @Override
      public String toString() {
         return "YearlyOutputComparisonMonthVO.YearlyOutputComparisonMonthVOBuilder(productMonth="
            + this.productMonth
            + ", totalNetWeight="
            + this.totalNetWeight
            + ")";
      }
   }
}
