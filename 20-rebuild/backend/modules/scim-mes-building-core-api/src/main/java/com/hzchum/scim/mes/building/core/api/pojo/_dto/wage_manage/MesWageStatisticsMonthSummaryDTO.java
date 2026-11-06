package com.hzchum.scim.mes.building.core.api.pojo._dto.wage_manage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("工价统计月份汇总DTO类")
public class MesWageStatisticsMonthSummaryDTO {
   @ApiModelProperty("车间ID")
   private Long workshopId;
   @ApiModelProperty("车间名称")
   private String workshopName;
   @ApiModelProperty("工序ID")
   private Integer processId;
   @ApiModelProperty("工序名称")
   private String processName;
   @ApiModelProperty("组长名称")
   private String teamLeaderName;
   @ApiModelProperty(name = "teamOrganizationType", value = "班组属性 [0 编制外, 1 编制内]", notes = "班组属性 [0 编制外, 1 编制内]")
   private Boolean teamOrganizationType;
   @ApiModelProperty("本月数据产量（吨）")
   private BigDecimal yield;
   @ApiModelProperty("本月数据金额（元）")
   private BigDecimal money;
   @ApiModelProperty("上月产量（吨）")
   private BigDecimal lastMonthYield;
   @ApiModelProperty("上月金额（元）")
   private BigDecimal lastMonthMoney;

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public Integer getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   public Boolean getTeamOrganizationType() {
      return this.teamOrganizationType;
   }

   public BigDecimal getYield() {
      return this.yield;
   }

   public BigDecimal getMoney() {
      return this.money;
   }

   public BigDecimal getLastMonthYield() {
      return this.lastMonthYield;
   }

   public BigDecimal getLastMonthMoney() {
      return this.lastMonthMoney;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setProcessId(final Integer processId) {
      this.processId = processId;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
   }

   public void setTeamOrganizationType(final Boolean teamOrganizationType) {
      this.teamOrganizationType = teamOrganizationType;
   }

   public void setYield(final BigDecimal yield) {
      this.yield = yield;
   }

   public void setMoney(final BigDecimal money) {
      this.money = money;
   }

   public void setLastMonthYield(final BigDecimal lastMonthYield) {
      this.lastMonthYield = lastMonthYield;
   }

   public void setLastMonthMoney(final BigDecimal lastMonthMoney) {
      this.lastMonthMoney = lastMonthMoney;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesWageStatisticsMonthSummaryDTO)) {
         return false;
      }

      MesWageStatisticsMonthSummaryDTO other = (MesWageStatisticsMonthSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$teamOrganizationType = this.getTeamOrganizationType();
            Object other$teamOrganizationType = other.getTeamOrganizationType();
            if (this$teamOrganizationType == null ? other$teamOrganizationType == null : this$teamOrganizationType.equals(other$teamOrganizationType)) {
               Object this$workshopName = this.getWorkshopName();
               Object other$workshopName = other.getWorkshopName();
               if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                  Object this$processName = this.getProcessName();
                  Object other$processName = other.getProcessName();
                  if (this$processName == null ? other$processName == null : this$processName.equals(other$processName)) {
                     Object this$teamLeaderName = this.getTeamLeaderName();
                     Object other$teamLeaderName = other.getTeamLeaderName();
                     if (this$teamLeaderName == null ? other$teamLeaderName == null : this$teamLeaderName.equals(other$teamLeaderName)) {
                        Object this$yield = this.getYield();
                        Object other$yield = other.getYield();
                        if (this$yield == null ? other$yield == null : this$yield.equals(other$yield)) {
                           Object this$money = this.getMoney();
                           Object other$money = other.getMoney();
                           if (this$money == null ? other$money == null : this$money.equals(other$money)) {
                              Object this$lastMonthYield = this.getLastMonthYield();
                              Object other$lastMonthYield = other.getLastMonthYield();
                              if (this$lastMonthYield == null ? other$lastMonthYield == null : this$lastMonthYield.equals(other$lastMonthYield)) {
                                 Object this$lastMonthMoney = this.getLastMonthMoney();
                                 Object other$lastMonthMoney = other.getLastMonthMoney();
                                 return this$lastMonthMoney == null ? other$lastMonthMoney == null : this$lastMonthMoney.equals(other$lastMonthMoney);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesWageStatisticsMonthSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamOrganizationType = this.getTeamOrganizationType();
      result = result * 59 + ($teamOrganizationType == null ? 43 : $teamOrganizationType.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $processName = this.getProcessName();
      result = result * 59 + ($processName == null ? 43 : $processName.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      result = result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
      Object $yield = this.getYield();
      result = result * 59 + ($yield == null ? 43 : $yield.hashCode());
      Object $money = this.getMoney();
      result = result * 59 + ($money == null ? 43 : $money.hashCode());
      Object $lastMonthYield = this.getLastMonthYield();
      result = result * 59 + ($lastMonthYield == null ? 43 : $lastMonthYield.hashCode());
      Object $lastMonthMoney = this.getLastMonthMoney();
      return result * 59 + ($lastMonthMoney == null ? 43 : $lastMonthMoney.hashCode());
   }

   @Override
   public String toString() {
      return "MesWageStatisticsMonthSummaryDTO(workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ", teamOrganizationType="
         + this.getTeamOrganizationType()
         + ", yield="
         + this.getYield()
         + ", money="
         + this.getMoney()
         + ", lastMonthYield="
         + this.getLastMonthYield()
         + ", lastMonthMoney="
         + this.getLastMonthMoney()
         + ")";
   }
}
