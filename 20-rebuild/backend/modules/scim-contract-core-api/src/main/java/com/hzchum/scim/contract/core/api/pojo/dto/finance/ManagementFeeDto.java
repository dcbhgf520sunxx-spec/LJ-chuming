package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ManagementFeeDto {
   @ApiModelProperty(name = "month", value = "月份")
   @Excel(name = "月份", width = 10.0)
   private Object month;
   @ApiModelProperty(name = "monthCapacity", value = "月产")
   @Excel(name = "月产", width = 10.0)
   private BigDecimal monthCapacity;
   @ApiModelProperty(name = "managementUserCount", value = "管理人员数量")
   @Excel(name = "管理人员数量", width = 15.0)
   private Integer managementUserCount;
   @ApiModelProperty(name = "managementUserMoney", value = "应发工资")
   @Excel(name = "应发工资", width = 15.0)
   private BigDecimal managementUserMoney;
   @ApiModelProperty(name = "reimbursementMoney", value = "报销费用")
   @Excel(name = "报销费用", width = 15.0)
   private BigDecimal reimbursementMoney;
   @ApiModelProperty(name = "otherMoney", value = "其他费用")
   @Excel(name = "其他费用", width = 15.0)
   private BigDecimal otherMoney;
   @ApiModelProperty(name = "sumMoney", value = "合计金额")
   @Excel(name = "合计金额", width = 15.0)
   private BigDecimal sumMoney;
   @ApiModelProperty(name = "avgMoney", value = "平均单价(元/吨)")
   @Excel(name = "平均单价(元/吨)", width = 15.0)
   private BigDecimal avgMoney;

   public Object getMonth() {
      return this.month;
   }

   public BigDecimal getMonthCapacity() {
      return this.monthCapacity;
   }

   public Integer getManagementUserCount() {
      return this.managementUserCount;
   }

   public BigDecimal getManagementUserMoney() {
      return this.managementUserMoney;
   }

   public BigDecimal getReimbursementMoney() {
      return this.reimbursementMoney;
   }

   public BigDecimal getOtherMoney() {
      return this.otherMoney;
   }

   public BigDecimal getSumMoney() {
      return this.sumMoney;
   }

   public BigDecimal getAvgMoney() {
      return this.avgMoney;
   }

   public void setMonth(final Object month) {
      this.month = month;
   }

   public void setMonthCapacity(final BigDecimal monthCapacity) {
      this.monthCapacity = monthCapacity;
   }

   public void setManagementUserCount(final Integer managementUserCount) {
      this.managementUserCount = managementUserCount;
   }

   public void setManagementUserMoney(final BigDecimal managementUserMoney) {
      this.managementUserMoney = managementUserMoney;
   }

   public void setReimbursementMoney(final BigDecimal reimbursementMoney) {
      this.reimbursementMoney = reimbursementMoney;
   }

   public void setOtherMoney(final BigDecimal otherMoney) {
      this.otherMoney = otherMoney;
   }

   public void setSumMoney(final BigDecimal sumMoney) {
      this.sumMoney = sumMoney;
   }

   public void setAvgMoney(final BigDecimal avgMoney) {
      this.avgMoney = avgMoney;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ManagementFeeDto)) {
         return false;
      }

      ManagementFeeDto other = (ManagementFeeDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$managementUserCount = this.getManagementUserCount();
      Object other$managementUserCount = other.getManagementUserCount();
      if (this$managementUserCount == null ? other$managementUserCount == null : this$managementUserCount.equals(other$managementUserCount)) {
         Object this$month = this.getMonth();
         Object other$month = other.getMonth();
         if (this$month == null ? other$month == null : this$month.equals(other$month)) {
            Object this$monthCapacity = this.getMonthCapacity();
            Object other$monthCapacity = other.getMonthCapacity();
            if (this$monthCapacity == null ? other$monthCapacity == null : this$monthCapacity.equals(other$monthCapacity)) {
               Object this$managementUserMoney = this.getManagementUserMoney();
               Object other$managementUserMoney = other.getManagementUserMoney();
               if (this$managementUserMoney == null ? other$managementUserMoney == null : this$managementUserMoney.equals(other$managementUserMoney)) {
                  Object this$reimbursementMoney = this.getReimbursementMoney();
                  Object other$reimbursementMoney = other.getReimbursementMoney();
                  if (this$reimbursementMoney == null ? other$reimbursementMoney == null : this$reimbursementMoney.equals(other$reimbursementMoney)) {
                     Object this$otherMoney = this.getOtherMoney();
                     Object other$otherMoney = other.getOtherMoney();
                     if (this$otherMoney == null ? other$otherMoney == null : this$otherMoney.equals(other$otherMoney)) {
                        Object this$sumMoney = this.getSumMoney();
                        Object other$sumMoney = other.getSumMoney();
                        if (this$sumMoney == null ? other$sumMoney == null : this$sumMoney.equals(other$sumMoney)) {
                           Object this$avgMoney = this.getAvgMoney();
                           Object other$avgMoney = other.getAvgMoney();
                           return this$avgMoney == null ? other$avgMoney == null : this$avgMoney.equals(other$avgMoney);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ManagementFeeDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $managementUserCount = this.getManagementUserCount();
      result = result * 59 + ($managementUserCount == null ? 43 : $managementUserCount.hashCode());
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $monthCapacity = this.getMonthCapacity();
      result = result * 59 + ($monthCapacity == null ? 43 : $monthCapacity.hashCode());
      Object $managementUserMoney = this.getManagementUserMoney();
      result = result * 59 + ($managementUserMoney == null ? 43 : $managementUserMoney.hashCode());
      Object $reimbursementMoney = this.getReimbursementMoney();
      result = result * 59 + ($reimbursementMoney == null ? 43 : $reimbursementMoney.hashCode());
      Object $otherMoney = this.getOtherMoney();
      result = result * 59 + ($otherMoney == null ? 43 : $otherMoney.hashCode());
      Object $sumMoney = this.getSumMoney();
      result = result * 59 + ($sumMoney == null ? 43 : $sumMoney.hashCode());
      Object $avgMoney = this.getAvgMoney();
      return result * 59 + ($avgMoney == null ? 43 : $avgMoney.hashCode());
   }

   @Override
   public String toString() {
      return "ManagementFeeDto(month="
         + this.getMonth()
         + ", monthCapacity="
         + this.getMonthCapacity()
         + ", managementUserCount="
         + this.getManagementUserCount()
         + ", managementUserMoney="
         + this.getManagementUserMoney()
         + ", reimbursementMoney="
         + this.getReimbursementMoney()
         + ", otherMoney="
         + this.getOtherMoney()
         + ", sumMoney="
         + this.getSumMoney()
         + ", avgMoney="
         + this.getAvgMoney()
         + ")";
   }

   public ManagementFeeDto(
      final Object month,
      final BigDecimal monthCapacity,
      final Integer managementUserCount,
      final BigDecimal managementUserMoney,
      final BigDecimal reimbursementMoney,
      final BigDecimal otherMoney,
      final BigDecimal sumMoney,
      final BigDecimal avgMoney
   ) {
      this.month = month;
      this.monthCapacity = monthCapacity;
      this.managementUserCount = managementUserCount;
      this.managementUserMoney = managementUserMoney;
      this.reimbursementMoney = reimbursementMoney;
      this.otherMoney = otherMoney;
      this.sumMoney = sumMoney;
      this.avgMoney = avgMoney;
   }

   public ManagementFeeDto() {
   }
}
