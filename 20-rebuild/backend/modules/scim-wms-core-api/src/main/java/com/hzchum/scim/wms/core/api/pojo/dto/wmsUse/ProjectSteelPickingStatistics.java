package com.hzchum.scim.wms.core.api.pojo.dto.wmsUse;

import java.math.BigDecimal;

public class ProjectSteelPickingStatistics {
   private Long projectId;
   private BigDecimal YearMete;
   private BigDecimal MonthMete;
   private BigDecimal aboveMonthMete;

   public static ProjectSteelPickingStatistics.ProjectSteelPickingStatisticsBuilder builder() {
      return new ProjectSteelPickingStatistics.ProjectSteelPickingStatisticsBuilder();
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getYearMete() {
      return this.YearMete;
   }

   public BigDecimal getMonthMete() {
      return this.MonthMete;
   }

   public BigDecimal getAboveMonthMete() {
      return this.aboveMonthMete;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setYearMete(final BigDecimal YearMete) {
      this.YearMete = YearMete;
   }

   public void setMonthMete(final BigDecimal MonthMete) {
      this.MonthMete = MonthMete;
   }

   public void setAboveMonthMete(final BigDecimal aboveMonthMete) {
      this.aboveMonthMete = aboveMonthMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectSteelPickingStatistics)) {
         return false;
      }

      ProjectSteelPickingStatistics other = (ProjectSteelPickingStatistics)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$YearMete = this.getYearMete();
         Object other$YearMete = other.getYearMete();
         if (this$YearMete == null ? other$YearMete == null : this$YearMete.equals(other$YearMete)) {
            Object this$MonthMete = this.getMonthMete();
            Object other$MonthMete = other.getMonthMete();
            if (this$MonthMete == null ? other$MonthMete == null : this$MonthMete.equals(other$MonthMete)) {
               Object this$aboveMonthMete = this.getAboveMonthMete();
               Object other$aboveMonthMete = other.getAboveMonthMete();
               return this$aboveMonthMete == null ? other$aboveMonthMete == null : this$aboveMonthMete.equals(other$aboveMonthMete);
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
      return other instanceof ProjectSteelPickingStatistics;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $YearMete = this.getYearMete();
      result = result * 59 + ($YearMete == null ? 43 : $YearMete.hashCode());
      Object $MonthMete = this.getMonthMete();
      result = result * 59 + ($MonthMete == null ? 43 : $MonthMete.hashCode());
      Object $aboveMonthMete = this.getAboveMonthMete();
      return result * 59 + ($aboveMonthMete == null ? 43 : $aboveMonthMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectSteelPickingStatistics(projectId="
         + this.getProjectId()
         + ", YearMete="
         + this.getYearMete()
         + ", MonthMete="
         + this.getMonthMete()
         + ", aboveMonthMete="
         + this.getAboveMonthMete()
         + ")";
   }

   public ProjectSteelPickingStatistics(final Long projectId, final BigDecimal YearMete, final BigDecimal MonthMete, final BigDecimal aboveMonthMete) {
      this.projectId = projectId;
      this.YearMete = YearMete;
      this.MonthMete = MonthMete;
      this.aboveMonthMete = aboveMonthMete;
   }

   public ProjectSteelPickingStatistics() {
   }

   public static class ProjectSteelPickingStatisticsBuilder {
      private Long projectId;
      private BigDecimal YearMete;
      private BigDecimal MonthMete;
      private BigDecimal aboveMonthMete;

      ProjectSteelPickingStatisticsBuilder() {
      }

      public ProjectSteelPickingStatistics.ProjectSteelPickingStatisticsBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ProjectSteelPickingStatistics.ProjectSteelPickingStatisticsBuilder YearMete(final BigDecimal YearMete) {
         this.YearMete = YearMete;
         return this;
      }

      public ProjectSteelPickingStatistics.ProjectSteelPickingStatisticsBuilder MonthMete(final BigDecimal MonthMete) {
         this.MonthMete = MonthMete;
         return this;
      }

      public ProjectSteelPickingStatistics.ProjectSteelPickingStatisticsBuilder aboveMonthMete(final BigDecimal aboveMonthMete) {
         this.aboveMonthMete = aboveMonthMete;
         return this;
      }

      public ProjectSteelPickingStatistics build() {
         return new ProjectSteelPickingStatistics(this.projectId, this.YearMete, this.MonthMete, this.aboveMonthMete);
      }

      @Override
      public String toString() {
         return "ProjectSteelPickingStatistics.ProjectSteelPickingStatisticsBuilder(projectId="
            + this.projectId
            + ", YearMete="
            + this.YearMete
            + ", MonthMete="
            + this.MonthMete
            + ", aboveMonthMete="
            + this.aboveMonthMete
            + ")";
      }
   }
}
