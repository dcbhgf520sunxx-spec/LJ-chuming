package com.hzchum.scim.mes.building.core.api.pojo._dto.app;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "app工序看板汇总")
public class ProcessKanBanSummaryDTO {
   @ApiModelProperty("年度累计完成")
   private Integer annualTotal;
   @ApiModelProperty("上月累计完成")
   private Integer lastMonthTotal;
   @ApiModelProperty("本月累计完成")
   private Integer currentMonthTotal;
   @ApiModelProperty("当前项目数")
   private Integer currentProjects;
   @ApiModelProperty("当前未完成数")
   private Integer currentIncomplete;
   @ApiModelProperty("昨日完成")
   private Integer yesterdayTotal;
   @ApiModelProperty("今日完成")
   private Integer todayTotal;

   public static ProcessKanBanSummaryDTO.ProcessKanBanSummaryDTOBuilder builder() {
      return new ProcessKanBanSummaryDTO.ProcessKanBanSummaryDTOBuilder();
   }

   public ProcessKanBanSummaryDTO(
      final Integer annualTotal,
      final Integer lastMonthTotal,
      final Integer currentMonthTotal,
      final Integer currentProjects,
      final Integer currentIncomplete,
      final Integer yesterdayTotal,
      final Integer todayTotal
   ) {
      this.annualTotal = annualTotal;
      this.lastMonthTotal = lastMonthTotal;
      this.currentMonthTotal = currentMonthTotal;
      this.currentProjects = currentProjects;
      this.currentIncomplete = currentIncomplete;
      this.yesterdayTotal = yesterdayTotal;
      this.todayTotal = todayTotal;
   }

   public ProcessKanBanSummaryDTO() {
   }

   public Integer getAnnualTotal() {
      return this.annualTotal;
   }

   public Integer getLastMonthTotal() {
      return this.lastMonthTotal;
   }

   public Integer getCurrentMonthTotal() {
      return this.currentMonthTotal;
   }

   public Integer getCurrentProjects() {
      return this.currentProjects;
   }

   public Integer getCurrentIncomplete() {
      return this.currentIncomplete;
   }

   public Integer getYesterdayTotal() {
      return this.yesterdayTotal;
   }

   public Integer getTodayTotal() {
      return this.todayTotal;
   }

   public ProcessKanBanSummaryDTO setAnnualTotal(final Integer annualTotal) {
      this.annualTotal = annualTotal;
      return this;
   }

   public ProcessKanBanSummaryDTO setLastMonthTotal(final Integer lastMonthTotal) {
      this.lastMonthTotal = lastMonthTotal;
      return this;
   }

   public ProcessKanBanSummaryDTO setCurrentMonthTotal(final Integer currentMonthTotal) {
      this.currentMonthTotal = currentMonthTotal;
      return this;
   }

   public ProcessKanBanSummaryDTO setCurrentProjects(final Integer currentProjects) {
      this.currentProjects = currentProjects;
      return this;
   }

   public ProcessKanBanSummaryDTO setCurrentIncomplete(final Integer currentIncomplete) {
      this.currentIncomplete = currentIncomplete;
      return this;
   }

   public ProcessKanBanSummaryDTO setYesterdayTotal(final Integer yesterdayTotal) {
      this.yesterdayTotal = yesterdayTotal;
      return this;
   }

   public ProcessKanBanSummaryDTO setTodayTotal(final Integer todayTotal) {
      this.todayTotal = todayTotal;
      return this;
   }

   @Override
   public String toString() {
      return "ProcessKanBanSummaryDTO(annualTotal="
         + this.getAnnualTotal()
         + ", lastMonthTotal="
         + this.getLastMonthTotal()
         + ", currentMonthTotal="
         + this.getCurrentMonthTotal()
         + ", currentProjects="
         + this.getCurrentProjects()
         + ", currentIncomplete="
         + this.getCurrentIncomplete()
         + ", yesterdayTotal="
         + this.getYesterdayTotal()
         + ", todayTotal="
         + this.getTodayTotal()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProcessKanBanSummaryDTO)) {
         return false;
      }

      ProcessKanBanSummaryDTO other = (ProcessKanBanSummaryDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$annualTotal = this.getAnnualTotal();
      Object other$annualTotal = other.getAnnualTotal();
      if (this$annualTotal == null ? other$annualTotal == null : this$annualTotal.equals(other$annualTotal)) {
         Object this$lastMonthTotal = this.getLastMonthTotal();
         Object other$lastMonthTotal = other.getLastMonthTotal();
         if (this$lastMonthTotal == null ? other$lastMonthTotal == null : this$lastMonthTotal.equals(other$lastMonthTotal)) {
            Object this$currentMonthTotal = this.getCurrentMonthTotal();
            Object other$currentMonthTotal = other.getCurrentMonthTotal();
            if (this$currentMonthTotal == null ? other$currentMonthTotal == null : this$currentMonthTotal.equals(other$currentMonthTotal)) {
               Object this$currentProjects = this.getCurrentProjects();
               Object other$currentProjects = other.getCurrentProjects();
               if (this$currentProjects == null ? other$currentProjects == null : this$currentProjects.equals(other$currentProjects)) {
                  Object this$currentIncomplete = this.getCurrentIncomplete();
                  Object other$currentIncomplete = other.getCurrentIncomplete();
                  if (this$currentIncomplete == null ? other$currentIncomplete == null : this$currentIncomplete.equals(other$currentIncomplete)) {
                     Object this$yesterdayTotal = this.getYesterdayTotal();
                     Object other$yesterdayTotal = other.getYesterdayTotal();
                     if (this$yesterdayTotal == null ? other$yesterdayTotal == null : this$yesterdayTotal.equals(other$yesterdayTotal)) {
                        Object this$todayTotal = this.getTodayTotal();
                        Object other$todayTotal = other.getTodayTotal();
                        return this$todayTotal == null ? other$todayTotal == null : this$todayTotal.equals(other$todayTotal);
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
      return other instanceof ProcessKanBanSummaryDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $annualTotal = this.getAnnualTotal();
      result = result * 59 + ($annualTotal == null ? 43 : $annualTotal.hashCode());
      Object $lastMonthTotal = this.getLastMonthTotal();
      result = result * 59 + ($lastMonthTotal == null ? 43 : $lastMonthTotal.hashCode());
      Object $currentMonthTotal = this.getCurrentMonthTotal();
      result = result * 59 + ($currentMonthTotal == null ? 43 : $currentMonthTotal.hashCode());
      Object $currentProjects = this.getCurrentProjects();
      result = result * 59 + ($currentProjects == null ? 43 : $currentProjects.hashCode());
      Object $currentIncomplete = this.getCurrentIncomplete();
      result = result * 59 + ($currentIncomplete == null ? 43 : $currentIncomplete.hashCode());
      Object $yesterdayTotal = this.getYesterdayTotal();
      result = result * 59 + ($yesterdayTotal == null ? 43 : $yesterdayTotal.hashCode());
      Object $todayTotal = this.getTodayTotal();
      return result * 59 + ($todayTotal == null ? 43 : $todayTotal.hashCode());
   }

   public static class ProcessKanBanSummaryDTOBuilder {
      private Integer annualTotal;
      private Integer lastMonthTotal;
      private Integer currentMonthTotal;
      private Integer currentProjects;
      private Integer currentIncomplete;
      private Integer yesterdayTotal;
      private Integer todayTotal;

      ProcessKanBanSummaryDTOBuilder() {
      }

      public ProcessKanBanSummaryDTO.ProcessKanBanSummaryDTOBuilder annualTotal(final Integer annualTotal) {
         this.annualTotal = annualTotal;
         return this;
      }

      public ProcessKanBanSummaryDTO.ProcessKanBanSummaryDTOBuilder lastMonthTotal(final Integer lastMonthTotal) {
         this.lastMonthTotal = lastMonthTotal;
         return this;
      }

      public ProcessKanBanSummaryDTO.ProcessKanBanSummaryDTOBuilder currentMonthTotal(final Integer currentMonthTotal) {
         this.currentMonthTotal = currentMonthTotal;
         return this;
      }

      public ProcessKanBanSummaryDTO.ProcessKanBanSummaryDTOBuilder currentProjects(final Integer currentProjects) {
         this.currentProjects = currentProjects;
         return this;
      }

      public ProcessKanBanSummaryDTO.ProcessKanBanSummaryDTOBuilder currentIncomplete(final Integer currentIncomplete) {
         this.currentIncomplete = currentIncomplete;
         return this;
      }

      public ProcessKanBanSummaryDTO.ProcessKanBanSummaryDTOBuilder yesterdayTotal(final Integer yesterdayTotal) {
         this.yesterdayTotal = yesterdayTotal;
         return this;
      }

      public ProcessKanBanSummaryDTO.ProcessKanBanSummaryDTOBuilder todayTotal(final Integer todayTotal) {
         this.todayTotal = todayTotal;
         return this;
      }

      public ProcessKanBanSummaryDTO build() {
         return new ProcessKanBanSummaryDTO(
            this.annualTotal, this.lastMonthTotal, this.currentMonthTotal, this.currentProjects, this.currentIncomplete, this.yesterdayTotal, this.todayTotal
         );
      }

      @Override
      public String toString() {
         return "ProcessKanBanSummaryDTO.ProcessKanBanSummaryDTOBuilder(annualTotal="
            + this.annualTotal
            + ", lastMonthTotal="
            + this.lastMonthTotal
            + ", currentMonthTotal="
            + this.currentMonthTotal
            + ", currentProjects="
            + this.currentProjects
            + ", currentIncomplete="
            + this.currentIncomplete
            + ", yesterdayTotal="
            + this.yesterdayTotal
            + ", todayTotal="
            + this.todayTotal
            + ")";
      }
   }
}
