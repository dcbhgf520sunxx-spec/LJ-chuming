package com.hzchum.scim.mes.building.core.api.pojo._dto.workshopStatistics;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "WorkshopProductionStatisticsVO", description = "车间产量统计报表返回对象")
public class WorkshopProductionStatisticsVO {
   @ApiModelProperty("车间id")
   private Long workshopId;
   @Excel(name = "生产车间名称", orderNum = "1")
   @ApiModelProperty("生产车间名称")
   private String workshopName;
   @Excel(name = "年度目标产量（吨）", orderNum = "2")
   @ApiModelProperty("年度目标产量（吨）")
   private BigDecimal annualTargetTon;
   @Excel(name = "计划排产量（吨）", orderNum = "3")
   @ApiModelProperty("计划排产量（吨）")
   private BigDecimal planSchedulingTon;
   @Excel(name = "计划排产项目数", orderNum = "4")
   @ApiModelProperty("计划排产项目数")
   private Integer planSchedulingProjectCount;
   @Excel(name = "已分配排产量（吨）", orderNum = "5")
   @ApiModelProperty("已分配排产量（吨）")
   private BigDecimal assignedSchedulingTon;
   @Excel(name = "已分配排产项目数", orderNum = "6")
   @ApiModelProperty("已分配排产项目数")
   private Integer assignedSchedulingProjectCount;
   @Excel(name = "实际完成产量（吨）", orderNum = "7")
   @ApiModelProperty("实际完成产量（吨）")
   private BigDecimal actualCompleteTon;
   @Excel(name = "实际计划占比（%）", orderNum = "8")
   @ApiModelProperty("实际计划占比（%），计划产量为0时返回null")
   private BigDecimal actualPlanRatio;
   @Excel(name = "目标达成率（%）", orderNum = "9")
   @ApiModelProperty("目标达成率（%），年度目标为0时返回null")
   private BigDecimal targetAchievementRate;
   @Excel(name = "排名", orderNum = "10")
   @ApiModelProperty("排名（按目标达成率降序）")
   private Integer rank;

   public static WorkshopProductionStatisticsVO.WorkshopProductionStatisticsVOBuilder builder() {
      return new WorkshopProductionStatisticsVO.WorkshopProductionStatisticsVOBuilder();
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public String getWorkshopName() {
      return this.workshopName;
   }

   public BigDecimal getAnnualTargetTon() {
      return this.annualTargetTon;
   }

   public BigDecimal getPlanSchedulingTon() {
      return this.planSchedulingTon;
   }

   public Integer getPlanSchedulingProjectCount() {
      return this.planSchedulingProjectCount;
   }

   public BigDecimal getAssignedSchedulingTon() {
      return this.assignedSchedulingTon;
   }

   public Integer getAssignedSchedulingProjectCount() {
      return this.assignedSchedulingProjectCount;
   }

   public BigDecimal getActualCompleteTon() {
      return this.actualCompleteTon;
   }

   public BigDecimal getActualPlanRatio() {
      return this.actualPlanRatio;
   }

   public BigDecimal getTargetAchievementRate() {
      return this.targetAchievementRate;
   }

   public Integer getRank() {
      return this.rank;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setWorkshopName(final String workshopName) {
      this.workshopName = workshopName;
   }

   public void setAnnualTargetTon(final BigDecimal annualTargetTon) {
      this.annualTargetTon = annualTargetTon;
   }

   public void setPlanSchedulingTon(final BigDecimal planSchedulingTon) {
      this.planSchedulingTon = planSchedulingTon;
   }

   public void setPlanSchedulingProjectCount(final Integer planSchedulingProjectCount) {
      this.planSchedulingProjectCount = planSchedulingProjectCount;
   }

   public void setAssignedSchedulingTon(final BigDecimal assignedSchedulingTon) {
      this.assignedSchedulingTon = assignedSchedulingTon;
   }

   public void setAssignedSchedulingProjectCount(final Integer assignedSchedulingProjectCount) {
      this.assignedSchedulingProjectCount = assignedSchedulingProjectCount;
   }

   public void setActualCompleteTon(final BigDecimal actualCompleteTon) {
      this.actualCompleteTon = actualCompleteTon;
   }

   public void setActualPlanRatio(final BigDecimal actualPlanRatio) {
      this.actualPlanRatio = actualPlanRatio;
   }

   public void setTargetAchievementRate(final BigDecimal targetAchievementRate) {
      this.targetAchievementRate = targetAchievementRate;
   }

   public void setRank(final Integer rank) {
      this.rank = rank;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkshopProductionStatisticsVO)) {
         return false;
      }

      WorkshopProductionStatisticsVO other = (WorkshopProductionStatisticsVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$planSchedulingProjectCount = this.getPlanSchedulingProjectCount();
         Object other$planSchedulingProjectCount = other.getPlanSchedulingProjectCount();
         if (this$planSchedulingProjectCount == null
            ? other$planSchedulingProjectCount == null
            : this$planSchedulingProjectCount.equals(other$planSchedulingProjectCount)) {
            Object this$assignedSchedulingProjectCount = this.getAssignedSchedulingProjectCount();
            Object other$assignedSchedulingProjectCount = other.getAssignedSchedulingProjectCount();
            if (this$assignedSchedulingProjectCount == null
               ? other$assignedSchedulingProjectCount == null
               : this$assignedSchedulingProjectCount.equals(other$assignedSchedulingProjectCount)) {
               Object this$rank = this.getRank();
               Object other$rank = other.getRank();
               if (this$rank == null ? other$rank == null : this$rank.equals(other$rank)) {
                  Object this$workshopName = this.getWorkshopName();
                  Object other$workshopName = other.getWorkshopName();
                  if (this$workshopName == null ? other$workshopName == null : this$workshopName.equals(other$workshopName)) {
                     Object this$annualTargetTon = this.getAnnualTargetTon();
                     Object other$annualTargetTon = other.getAnnualTargetTon();
                     if (this$annualTargetTon == null ? other$annualTargetTon == null : this$annualTargetTon.equals(other$annualTargetTon)) {
                        Object this$planSchedulingTon = this.getPlanSchedulingTon();
                        Object other$planSchedulingTon = other.getPlanSchedulingTon();
                        if (this$planSchedulingTon == null ? other$planSchedulingTon == null : this$planSchedulingTon.equals(other$planSchedulingTon)) {
                           Object this$assignedSchedulingTon = this.getAssignedSchedulingTon();
                           Object other$assignedSchedulingTon = other.getAssignedSchedulingTon();
                           if (this$assignedSchedulingTon == null
                              ? other$assignedSchedulingTon == null
                              : this$assignedSchedulingTon.equals(other$assignedSchedulingTon)) {
                              Object this$actualCompleteTon = this.getActualCompleteTon();
                              Object other$actualCompleteTon = other.getActualCompleteTon();
                              if (this$actualCompleteTon == null ? other$actualCompleteTon == null : this$actualCompleteTon.equals(other$actualCompleteTon)) {
                                 Object this$actualPlanRatio = this.getActualPlanRatio();
                                 Object other$actualPlanRatio = other.getActualPlanRatio();
                                 if (this$actualPlanRatio == null ? other$actualPlanRatio == null : this$actualPlanRatio.equals(other$actualPlanRatio)) {
                                    Object this$targetAchievementRate = this.getTargetAchievementRate();
                                    Object other$targetAchievementRate = other.getTargetAchievementRate();
                                    return this$targetAchievementRate == null
                                       ? other$targetAchievementRate == null
                                       : this$targetAchievementRate.equals(other$targetAchievementRate);
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WorkshopProductionStatisticsVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $planSchedulingProjectCount = this.getPlanSchedulingProjectCount();
      result = result * 59 + ($planSchedulingProjectCount == null ? 43 : $planSchedulingProjectCount.hashCode());
      Object $assignedSchedulingProjectCount = this.getAssignedSchedulingProjectCount();
      result = result * 59 + ($assignedSchedulingProjectCount == null ? 43 : $assignedSchedulingProjectCount.hashCode());
      Object $rank = this.getRank();
      result = result * 59 + ($rank == null ? 43 : $rank.hashCode());
      Object $workshopName = this.getWorkshopName();
      result = result * 59 + ($workshopName == null ? 43 : $workshopName.hashCode());
      Object $annualTargetTon = this.getAnnualTargetTon();
      result = result * 59 + ($annualTargetTon == null ? 43 : $annualTargetTon.hashCode());
      Object $planSchedulingTon = this.getPlanSchedulingTon();
      result = result * 59 + ($planSchedulingTon == null ? 43 : $planSchedulingTon.hashCode());
      Object $assignedSchedulingTon = this.getAssignedSchedulingTon();
      result = result * 59 + ($assignedSchedulingTon == null ? 43 : $assignedSchedulingTon.hashCode());
      Object $actualCompleteTon = this.getActualCompleteTon();
      result = result * 59 + ($actualCompleteTon == null ? 43 : $actualCompleteTon.hashCode());
      Object $actualPlanRatio = this.getActualPlanRatio();
      result = result * 59 + ($actualPlanRatio == null ? 43 : $actualPlanRatio.hashCode());
      Object $targetAchievementRate = this.getTargetAchievementRate();
      return result * 59 + ($targetAchievementRate == null ? 43 : $targetAchievementRate.hashCode());
   }

   @Override
   public String toString() {
      return "WorkshopProductionStatisticsVO(workshopId="
         + this.getWorkshopId()
         + ", workshopName="
         + this.getWorkshopName()
         + ", annualTargetTon="
         + this.getAnnualTargetTon()
         + ", planSchedulingTon="
         + this.getPlanSchedulingTon()
         + ", planSchedulingProjectCount="
         + this.getPlanSchedulingProjectCount()
         + ", assignedSchedulingTon="
         + this.getAssignedSchedulingTon()
         + ", assignedSchedulingProjectCount="
         + this.getAssignedSchedulingProjectCount()
         + ", actualCompleteTon="
         + this.getActualCompleteTon()
         + ", actualPlanRatio="
         + this.getActualPlanRatio()
         + ", targetAchievementRate="
         + this.getTargetAchievementRate()
         + ", rank="
         + this.getRank()
         + ")";
   }

   public WorkshopProductionStatisticsVO() {
   }

   public WorkshopProductionStatisticsVO(
      final Long workshopId,
      final String workshopName,
      final BigDecimal annualTargetTon,
      final BigDecimal planSchedulingTon,
      final Integer planSchedulingProjectCount,
      final BigDecimal assignedSchedulingTon,
      final Integer assignedSchedulingProjectCount,
      final BigDecimal actualCompleteTon,
      final BigDecimal actualPlanRatio,
      final BigDecimal targetAchievementRate,
      final Integer rank
   ) {
      this.workshopId = workshopId;
      this.workshopName = workshopName;
      this.annualTargetTon = annualTargetTon;
      this.planSchedulingTon = planSchedulingTon;
      this.planSchedulingProjectCount = planSchedulingProjectCount;
      this.assignedSchedulingTon = assignedSchedulingTon;
      this.assignedSchedulingProjectCount = assignedSchedulingProjectCount;
      this.actualCompleteTon = actualCompleteTon;
      this.actualPlanRatio = actualPlanRatio;
      this.targetAchievementRate = targetAchievementRate;
      this.rank = rank;
   }

   public static class WorkshopProductionStatisticsVOBuilder {
      private Long workshopId;
      private String workshopName;
      private BigDecimal annualTargetTon;
      private BigDecimal planSchedulingTon;
      private Integer planSchedulingProjectCount;
      private BigDecimal assignedSchedulingTon;
      private Integer assignedSchedulingProjectCount;
      private BigDecimal actualCompleteTon;
      private BigDecimal actualPlanRatio;
      private BigDecimal targetAchievementRate;
      private Integer rank;

      WorkshopProductionStatisticsVOBuilder() {
      }

      public WorkshopProductionStatisticsVO.WorkshopProductionStatisticsVOBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public WorkshopProductionStatisticsVO.WorkshopProductionStatisticsVOBuilder workshopName(final String workshopName) {
         this.workshopName = workshopName;
         return this;
      }

      public WorkshopProductionStatisticsVO.WorkshopProductionStatisticsVOBuilder annualTargetTon(final BigDecimal annualTargetTon) {
         this.annualTargetTon = annualTargetTon;
         return this;
      }

      public WorkshopProductionStatisticsVO.WorkshopProductionStatisticsVOBuilder planSchedulingTon(final BigDecimal planSchedulingTon) {
         this.planSchedulingTon = planSchedulingTon;
         return this;
      }

      public WorkshopProductionStatisticsVO.WorkshopProductionStatisticsVOBuilder planSchedulingProjectCount(final Integer planSchedulingProjectCount) {
         this.planSchedulingProjectCount = planSchedulingProjectCount;
         return this;
      }

      public WorkshopProductionStatisticsVO.WorkshopProductionStatisticsVOBuilder assignedSchedulingTon(final BigDecimal assignedSchedulingTon) {
         this.assignedSchedulingTon = assignedSchedulingTon;
         return this;
      }

      public WorkshopProductionStatisticsVO.WorkshopProductionStatisticsVOBuilder assignedSchedulingProjectCount(final Integer assignedSchedulingProjectCount) {
         this.assignedSchedulingProjectCount = assignedSchedulingProjectCount;
         return this;
      }

      public WorkshopProductionStatisticsVO.WorkshopProductionStatisticsVOBuilder actualCompleteTon(final BigDecimal actualCompleteTon) {
         this.actualCompleteTon = actualCompleteTon;
         return this;
      }

      public WorkshopProductionStatisticsVO.WorkshopProductionStatisticsVOBuilder actualPlanRatio(final BigDecimal actualPlanRatio) {
         this.actualPlanRatio = actualPlanRatio;
         return this;
      }

      public WorkshopProductionStatisticsVO.WorkshopProductionStatisticsVOBuilder targetAchievementRate(final BigDecimal targetAchievementRate) {
         this.targetAchievementRate = targetAchievementRate;
         return this;
      }

      public WorkshopProductionStatisticsVO.WorkshopProductionStatisticsVOBuilder rank(final Integer rank) {
         this.rank = rank;
         return this;
      }

      public WorkshopProductionStatisticsVO build() {
         return new WorkshopProductionStatisticsVO(
            this.workshopId,
            this.workshopName,
            this.annualTargetTon,
            this.planSchedulingTon,
            this.planSchedulingProjectCount,
            this.assignedSchedulingTon,
            this.assignedSchedulingProjectCount,
            this.actualCompleteTon,
            this.actualPlanRatio,
            this.targetAchievementRate,
            this.rank
         );
      }

      @Override
      public String toString() {
         return "WorkshopProductionStatisticsVO.WorkshopProductionStatisticsVOBuilder(workshopId="
            + this.workshopId
            + ", workshopName="
            + this.workshopName
            + ", annualTargetTon="
            + this.annualTargetTon
            + ", planSchedulingTon="
            + this.planSchedulingTon
            + ", planSchedulingProjectCount="
            + this.planSchedulingProjectCount
            + ", assignedSchedulingTon="
            + this.assignedSchedulingTon
            + ", assignedSchedulingProjectCount="
            + this.assignedSchedulingProjectCount
            + ", actualCompleteTon="
            + this.actualCompleteTon
            + ", actualPlanRatio="
            + this.actualPlanRatio
            + ", targetAchievementRate="
            + this.targetAchievementRate
            + ", rank="
            + this.rank
            + ")";
      }
   }
}
