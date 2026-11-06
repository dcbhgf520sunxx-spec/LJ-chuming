package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("工价统计年度汇总DTO类")
public class MesWageStatisticsYearSummaryDTO {
   @ApiModelProperty("年月")
   private String yearMonth;
   @ApiModelProperty("入库总量（吨）")
   private BigDecimal totalInboundQuantity;
   @ApiModelProperty("工资总额（元）")
   private BigDecimal totalSalary;

   public String getYearMonth() {
      return this.yearMonth;
   }

   public BigDecimal getTotalInboundQuantity() {
      return this.totalInboundQuantity;
   }

   public BigDecimal getTotalSalary() {
      return this.totalSalary;
   }

   public void setYearMonth(final String yearMonth) {
      this.yearMonth = yearMonth;
   }

   public void setTotalInboundQuantity(final BigDecimal totalInboundQuantity) {
      this.totalInboundQuantity = totalInboundQuantity;
   }

   public void setTotalSalary(final BigDecimal totalSalary) {
      this.totalSalary = totalSalary;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesWageStatisticsYearSummaryDTO)) {
         return false;
      }

      MesWageStatisticsYearSummaryDTO other = (MesWageStatisticsYearSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$yearMonth = this.getYearMonth();
      Object other$yearMonth = other.getYearMonth();
      if (this$yearMonth == null ? other$yearMonth == null : this$yearMonth.equals(other$yearMonth)) {
         Object this$totalInboundQuantity = this.getTotalInboundQuantity();
         Object other$totalInboundQuantity = other.getTotalInboundQuantity();
         if (this$totalInboundQuantity == null ? other$totalInboundQuantity == null : this$totalInboundQuantity.equals(other$totalInboundQuantity)) {
            Object this$totalSalary = this.getTotalSalary();
            Object other$totalSalary = other.getTotalSalary();
            return this$totalSalary == null ? other$totalSalary == null : this$totalSalary.equals(other$totalSalary);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesWageStatisticsYearSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $yearMonth = this.getYearMonth();
      result = result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
      Object $totalInboundQuantity = this.getTotalInboundQuantity();
      result = result * 59 + ($totalInboundQuantity == null ? 43 : $totalInboundQuantity.hashCode());
      Object $totalSalary = this.getTotalSalary();
      return result * 59 + ($totalSalary == null ? 43 : $totalSalary.hashCode());
   }

   @Override
   public String toString() {
      return "MesWageStatisticsYearSummaryDTO(yearMonth="
         + this.getYearMonth()
         + ", totalInboundQuantity="
         + this.getTotalInboundQuantity()
         + ", totalSalary="
         + this.getTotalSalary()
         + ")";
   }
}
