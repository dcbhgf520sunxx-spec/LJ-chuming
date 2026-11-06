package com.hzchum.scim.mes.building.core.api.pojo._do.task;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "YearlyOutputComparisonDO", description = "年度产量对比")
public class YearlyOutputComparisonDO {
   private String structureType;
   private String productMonth;
   private BigDecimal totalNetWeight;

   public static YearlyOutputComparisonDO.YearlyOutputComparisonDOBuilder builder() {
      return new YearlyOutputComparisonDO.YearlyOutputComparisonDOBuilder();
   }

   public YearlyOutputComparisonDO() {
   }

   public YearlyOutputComparisonDO(final String structureType, final String productMonth, final BigDecimal totalNetWeight) {
      this.structureType = structureType;
      this.productMonth = productMonth;
      this.totalNetWeight = totalNetWeight;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public String getProductMonth() {
      return this.productMonth;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public YearlyOutputComparisonDO setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   public YearlyOutputComparisonDO setProductMonth(final String productMonth) {
      this.productMonth = productMonth;
      return this;
   }

   public YearlyOutputComparisonDO setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof YearlyOutputComparisonDO)) {
         return false;
      }

      YearlyOutputComparisonDO other = (YearlyOutputComparisonDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$structureType = this.getStructureType();
      Object other$structureType = other.getStructureType();
      if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
         Object this$productMonth = this.getProductMonth();
         Object other$productMonth = other.getProductMonth();
         if (this$productMonth == null ? other$productMonth == null : this$productMonth.equals(other$productMonth)) {
            Object this$totalNetWeight = this.getTotalNetWeight();
            Object other$totalNetWeight = other.getTotalNetWeight();
            return this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof YearlyOutputComparisonDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $productMonth = this.getProductMonth();
      result = result * 59 + ($productMonth == null ? 43 : $productMonth.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      return result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
   }

   @Override
   public String toString() {
      return "YearlyOutputComparisonDO(structureType="
         + this.getStructureType()
         + ", productMonth="
         + this.getProductMonth()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ")";
   }

   public static class YearlyOutputComparisonDOBuilder {
      private String structureType;
      private String productMonth;
      private BigDecimal totalNetWeight;

      YearlyOutputComparisonDOBuilder() {
      }

      public YearlyOutputComparisonDO.YearlyOutputComparisonDOBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      public YearlyOutputComparisonDO.YearlyOutputComparisonDOBuilder productMonth(final String productMonth) {
         this.productMonth = productMonth;
         return this;
      }

      public YearlyOutputComparisonDO.YearlyOutputComparisonDOBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public YearlyOutputComparisonDO build() {
         return new YearlyOutputComparisonDO(this.structureType, this.productMonth, this.totalNetWeight);
      }

      @Override
      public String toString() {
         return "YearlyOutputComparisonDO.YearlyOutputComparisonDOBuilder(structureType="
            + this.structureType
            + ", productMonth="
            + this.productMonth
            + ", totalNetWeight="
            + this.totalNetWeight
            + ")";
      }
   }
}
