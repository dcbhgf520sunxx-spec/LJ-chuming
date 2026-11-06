package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage;

import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.annotation.ExcelTarget;
import java.math.BigDecimal;

@ExcelTarget("MesWageStatisticsMonthSummaryExcelDTO")
public class MesWageStatisticsMonthSummaryExcelDTO {
   @Excel(name = "序号", width = 5.0)
   private Integer orderNo;
   @Excel(name = "车间", width = 15.0)
   private String workshopName;
   @Excel(name = "工序", width = 15.0)
   private String processName;
   @Excel(name = "班组", width = 15.0)
   private String teamLeaderName;
   @Excel(name = "班组属性", width = 15.0)
   private String teamOrganizationTypeName;
   @Excel(name = "上月产量（吨）", width = 18.0)
   private BigDecimal lastMonthYield;
   @Excel(name = "上月金额（元）", width = 18.0)
   private BigDecimal lastMonthMoney;
   @Excel(name = "本月数据产量（吨）", width = 18.0)
   private BigDecimal yield;
   @Excel(name = "本月数据金额（元）", width = 18.0)
   private BigDecimal money;

   public BigDecimal getLastMonthYield() {
      return this.lastMonthYield.compareTo(BigDecimal.ZERO) == 0 ? this.lastMonthYield.stripTrailingZeros() : this.lastMonthYield;
   }

   public BigDecimal getLastMonthMoney() {
      return this.lastMonthMoney.compareTo(BigDecimal.ZERO) == 0 ? this.lastMonthMoney.stripTrailingZeros() : this.lastMonthMoney;
   }

   public BigDecimal getYield() {
      return this.yield.compareTo(BigDecimal.ZERO) == 0 ? this.yield.stripTrailingZeros() : this.yield;
   }

   public BigDecimal getMoney() {
      return this.money.compareTo(BigDecimal.ZERO) == 0 ? this.money.stripTrailingZeros() : this.money;
   }

   public Integer getOrderNo() {
      return this.orderNo;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   public String getTeamOrganizationTypeName() {
      return this.teamOrganizationTypeName;
   }

   public void setOrderNo(final Integer orderNo) {
      this.orderNo = orderNo;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
   }

   public void setTeamOrganizationTypeName(final String teamOrganizationTypeName) {
      this.teamOrganizationTypeName = teamOrganizationTypeName;
   }

   public void setLastMonthYield(final BigDecimal lastMonthYield) {
      this.lastMonthYield = lastMonthYield;
   }

   public void setLastMonthMoney(final BigDecimal lastMonthMoney) {
      this.lastMonthMoney = lastMonthMoney;
   }

   public void setYield(final BigDecimal yield) {
      this.yield = yield;
   }

   public void setMoney(final BigDecimal money) {
      this.money = money;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesWageStatisticsMonthSummaryExcelDTO)) {
         return false;
      }

      MesWageStatisticsMonthSummaryExcelDTO other = (MesWageStatisticsMonthSummaryExcelDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$orderNo = this.getOrderNo();
      Object other$orderNo = other.getOrderNo();
      if (this$orderNo == null ? other$orderNo == null : this$orderNo.equals(other$orderNo)) {
         Object this$workshopName = this.getWorkshopName();
         Object other$workshopName = other.getWorkshopName();
         if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
            Object this$processName = this.getProcessName();
            Object other$processName = other.getProcessName();
            if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
               Object this$teamLeaderName = this.getTeamLeaderName();
               Object other$teamLeaderName = other.getTeamLeaderName();
               if (this$teamLeaderName == null ? other$teamLeaderName == null : this$teamLeaderName.equals(other$teamLeaderName)) {
                  Object this$teamOrganizationTypeName = this.getTeamOrganizationTypeName();
                  Object other$teamOrganizationTypeName = other.getTeamOrganizationTypeName();
                  if (this$teamOrganizationTypeName == null
                     ? other$teamOrganizationTypeName == null
                     : this$teamOrganizationTypeName.equals(other$teamOrganizationTypeName)) {
                     Object this$lastMonthYield = this.getLastMonthYield();
                     Object other$lastMonthYield = other.getLastMonthYield();
                     if (this$lastMonthYield == null ? other$lastMonthYield == null : this$lastMonthYield.equals(other$lastMonthYield)) {
                        Object this$lastMonthMoney = this.getLastMonthMoney();
                        Object other$lastMonthMoney = other.getLastMonthMoney();
                        if (this$lastMonthMoney == null ? other$lastMonthMoney == null : this$lastMonthMoney.equals(other$lastMonthMoney)) {
                           Object this$yield = this.getYield();
                           Object other$yield = other.getYield();
                           if (this$yield == null ? other$yield == null : this$yield.equals(other$yield)) {
                              Object this$money = this.getMoney();
                              Object other$money = other.getMoney();
                              return this$money == null ? other$money == null : this$money.equals(other$money);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesWageStatisticsMonthSummaryExcelDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $orderNo = this.getOrderNo();
      result = result * 59 + ($orderNo == null ? 43 : $orderNo.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      result = result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
      Object $teamOrganizationTypeName = this.getTeamOrganizationTypeName();
      result = result * 59 + ($teamOrganizationTypeName == null ? 43 : $teamOrganizationTypeName.hashCode());
      Object $lastMonthYield = this.getLastMonthYield();
      result = result * 59 + ($lastMonthYield == null ? 43 : $lastMonthYield.hashCode());
      Object $lastMonthMoney = this.getLastMonthMoney();
      result = result * 59 + ($lastMonthMoney == null ? 43 : $lastMonthMoney.hashCode());
      Object $yield = this.getYield();
      result = result * 59 + ($yield == null ? 43 : $yield.hashCode());
      Object $money = this.getMoney();
      return result * 59 + ($money == null ? 43 : $money.hashCode());
   }

   @Override
   public String toString() {
      return "MesWageStatisticsMonthSummaryExcelDTO(orderNo="
         + this.getOrderNo()
         + ", workshopName="
         + this.getWorkshopName()
         + ", processName="
         + this.getProcessName()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ", teamOrganizationTypeName="
         + this.getTeamOrganizationTypeName()
         + ", lastMonthYield="
         + this.getLastMonthYield()
         + ", lastMonthMoney="
         + this.getLastMonthMoney()
         + ", yield="
         + this.getYield()
         + ", money="
         + this.getMoney()
         + ")";
   }
}
