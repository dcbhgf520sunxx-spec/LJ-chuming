package com.hzchum.scim.mes.building.core.api.pojo._dto.LargeScreen;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "电视机投屏看板")
public class LargeScreenSummaryDTO {
   @ApiModelProperty("项目总数")
   private Integer totalProject;
   @ApiModelProperty("已完成")
   private Integer completeProject;
   @ApiModelProperty("年度完成量(吨)")
   private Integer annualCompletions;
   @ApiModelProperty("本月新任务")
   private Integer currentMonthCount;
   @ApiModelProperty("本月任务量(吨)")
   private Integer currentMonthTon;
   @ApiModelProperty("任务达成率")
   private BigDecimal achievementRate;

   public static LargeScreenSummaryDTO.LargeScreenSummaryDTOBuilder builder() {
      return new LargeScreenSummaryDTO.LargeScreenSummaryDTOBuilder();
   }

   public Integer getTotalProject() {
      return this.totalProject;
   }

   public Integer getCompleteProject() {
      return this.completeProject;
   }

   public Integer getAnnualCompletions() {
      return this.annualCompletions;
   }

   public Integer getCurrentMonthCount() {
      return this.currentMonthCount;
   }

   public Integer getCurrentMonthTon() {
      return this.currentMonthTon;
   }

   public BigDecimal getAchievementRate() {
      return this.achievementRate;
   }

   public void setTotalProject(final Integer totalProject) {
      this.totalProject = totalProject;
   }

   public void setCompleteProject(final Integer completeProject) {
      this.completeProject = completeProject;
   }

   public void setAnnualCompletions(final Integer annualCompletions) {
      this.annualCompletions = annualCompletions;
   }

   public void setCurrentMonthCount(final Integer currentMonthCount) {
      this.currentMonthCount = currentMonthCount;
   }

   public void setCurrentMonthTon(final Integer currentMonthTon) {
      this.currentMonthTon = currentMonthTon;
   }

   public void setAchievementRate(final BigDecimal achievementRate) {
      this.achievementRate = achievementRate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof LargeScreenSummaryDTO)) {
         return false;
      }

      LargeScreenSummaryDTO other = (LargeScreenSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalProject = this.getTotalProject();
      Object other$totalProject = other.getTotalProject();
      if (this$totalProject == null ? other$totalProject == null : this$totalProject.equals(other$totalProject)) {
         Object this$completeProject = this.getCompleteProject();
         Object other$completeProject = other.getCompleteProject();
         if (this$completeProject == null ? other$completeProject == null : this$completeProject.equals(other$completeProject)) {
            Object this$annualCompletions = this.getAnnualCompletions();
            Object other$annualCompletions = other.getAnnualCompletions();
            if (this$annualCompletions == null ? other$annualCompletions == null : this$annualCompletions.equals(other$annualCompletions)) {
               Object this$currentMonthCount = this.getCurrentMonthCount();
               Object other$currentMonthCount = other.getCurrentMonthCount();
               if (this$currentMonthCount == null ? other$currentMonthCount == null : this$currentMonthCount.equals(other$currentMonthCount)) {
                  Object this$currentMonthTon = this.getCurrentMonthTon();
                  Object other$currentMonthTon = other.getCurrentMonthTon();
                  if (this$currentMonthTon == null ? other$currentMonthTon == null : this$currentMonthTon.equals(other$currentMonthTon)) {
                     Object this$achievementRate = this.getAchievementRate();
                     Object other$achievementRate = other.getAchievementRate();
                     return this$achievementRate == null ? other$achievementRate == null : this$achievementRate.equals(other$achievementRate);
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
      return other instanceof LargeScreenSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalProject = this.getTotalProject();
      result = result * 59 + ($totalProject == null ? 43 : $totalProject.hashCode());
      Object $completeProject = this.getCompleteProject();
      result = result * 59 + ($completeProject == null ? 43 : $completeProject.hashCode());
      Object $annualCompletions = this.getAnnualCompletions();
      result = result * 59 + ($annualCompletions == null ? 43 : $annualCompletions.hashCode());
      Object $currentMonthCount = this.getCurrentMonthCount();
      result = result * 59 + ($currentMonthCount == null ? 43 : $currentMonthCount.hashCode());
      Object $currentMonthTon = this.getCurrentMonthTon();
      result = result * 59 + ($currentMonthTon == null ? 43 : $currentMonthTon.hashCode());
      Object $achievementRate = this.getAchievementRate();
      return result * 59 + ($achievementRate == null ? 43 : $achievementRate.hashCode());
   }

   @Override
   public String toString() {
      return "LargeScreenSummaryDTO(super="
         + super.toString()
         + ", totalProject="
         + this.getTotalProject()
         + ", completeProject="
         + this.getCompleteProject()
         + ", annualCompletions="
         + this.getAnnualCompletions()
         + ", currentMonthCount="
         + this.getCurrentMonthCount()
         + ", currentMonthTon="
         + this.getCurrentMonthTon()
         + ", achievementRate="
         + this.getAchievementRate()
         + ")";
   }

   public LargeScreenSummaryDTO(
      final Integer totalProject,
      final Integer completeProject,
      final Integer annualCompletions,
      final Integer currentMonthCount,
      final Integer currentMonthTon,
      final BigDecimal achievementRate
   ) {
      this.totalProject = totalProject;
      this.completeProject = completeProject;
      this.annualCompletions = annualCompletions;
      this.currentMonthCount = currentMonthCount;
      this.currentMonthTon = currentMonthTon;
      this.achievementRate = achievementRate;
   }

   public LargeScreenSummaryDTO() {
   }

   public static class LargeScreenSummaryDTOBuilder {
      private Integer totalProject;
      private Integer completeProject;
      private Integer annualCompletions;
      private Integer currentMonthCount;
      private Integer currentMonthTon;
      private BigDecimal achievementRate;

      LargeScreenSummaryDTOBuilder() {
      }

      public LargeScreenSummaryDTO.LargeScreenSummaryDTOBuilder totalProject(final Integer totalProject) {
         this.totalProject = totalProject;
         return this;
      }

      public LargeScreenSummaryDTO.LargeScreenSummaryDTOBuilder completeProject(final Integer completeProject) {
         this.completeProject = completeProject;
         return this;
      }

      public LargeScreenSummaryDTO.LargeScreenSummaryDTOBuilder annualCompletions(final Integer annualCompletions) {
         this.annualCompletions = annualCompletions;
         return this;
      }

      public LargeScreenSummaryDTO.LargeScreenSummaryDTOBuilder currentMonthCount(final Integer currentMonthCount) {
         this.currentMonthCount = currentMonthCount;
         return this;
      }

      public LargeScreenSummaryDTO.LargeScreenSummaryDTOBuilder currentMonthTon(final Integer currentMonthTon) {
         this.currentMonthTon = currentMonthTon;
         return this;
      }

      public LargeScreenSummaryDTO.LargeScreenSummaryDTOBuilder achievementRate(final BigDecimal achievementRate) {
         this.achievementRate = achievementRate;
         return this;
      }

      public LargeScreenSummaryDTO build() {
         return new LargeScreenSummaryDTO(
            this.totalProject, this.completeProject, this.annualCompletions, this.currentMonthCount, this.currentMonthTon, this.achievementRate
         );
      }

      @Override
      public String toString() {
         return "LargeScreenSummaryDTO.LargeScreenSummaryDTOBuilder(totalProject="
            + this.totalProject
            + ", completeProject="
            + this.completeProject
            + ", annualCompletions="
            + this.annualCompletions
            + ", currentMonthCount="
            + this.currentMonthCount
            + ", currentMonthTon="
            + this.currentMonthTon
            + ", achievementRate="
            + this.achievementRate
            + ")";
      }
   }
}
