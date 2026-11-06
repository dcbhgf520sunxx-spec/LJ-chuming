package com.hzchum.scim.mes.building.core.api.pojo._dto.screen;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ScreenProductionStatisticsDTO", description = "班组产量统计")
public class ScreenProductionStatisticsDTO {
   @ApiModelProperty(name = "今日产量", notes = "今日产量")
   private Double todayInspectionQuantity;
   @ApiModelProperty(name = "昨日产量", notes = "昨日产量")
   private Double yesterdayInspectionQuantity;
   @ApiModelProperty(name = "班组", notes = "班组名称")
   private String teamName;
   @ApiModelProperty(name = "工序", notes = "工序名称")
   private String processName;

   public static ScreenProductionStatisticsDTO.ScreenProductionStatisticsDTOBuilder builder() {
      return new ScreenProductionStatisticsDTO.ScreenProductionStatisticsDTOBuilder();
   }

   public ScreenProductionStatisticsDTO() {
   }

   public ScreenProductionStatisticsDTO(
      final Double todayInspectionQuantity, final Double yesterdayInspectionQuantity, final String teamName, final String processName
   ) {
      this.todayInspectionQuantity = todayInspectionQuantity;
      this.yesterdayInspectionQuantity = yesterdayInspectionQuantity;
      this.teamName = teamName;
      this.processName = processName;
   }

   public Double getTodayInspectionQuantity() {
      return this.todayInspectionQuantity;
   }

   public Double getYesterdayInspectionQuantity() {
      return this.yesterdayInspectionQuantity;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public String getProcessName() {
      return this.processName;
   }

   public ScreenProductionStatisticsDTO setTodayInspectionQuantity(final Double todayInspectionQuantity) {
      this.todayInspectionQuantity = todayInspectionQuantity;
      return this;
   }

   public ScreenProductionStatisticsDTO setYesterdayInspectionQuantity(final Double yesterdayInspectionQuantity) {
      this.yesterdayInspectionQuantity = yesterdayInspectionQuantity;
      return this;
   }

   public ScreenProductionStatisticsDTO setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   public ScreenProductionStatisticsDTO setProcessName(final String processName) {
      this.processName = processName;
      return this;
   }

   @Override
   public String toString() {
      return "ScreenProductionStatisticsDTO(todayInspectionQuantity="
         + this.getTodayInspectionQuantity()
         + ", yesterdayInspectionQuantity="
         + this.getYesterdayInspectionQuantity()
         + ", teamName="
         + this.getTeamName()
         + ", processName="
         + this.getProcessName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScreenProductionStatisticsDTO)) {
         return false;
      }

      ScreenProductionStatisticsDTO other = (ScreenProductionStatisticsDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$todayInspectionQuantity = this.getTodayInspectionQuantity();
      Object other$todayInspectionQuantity = other.getTodayInspectionQuantity();
      if (this$todayInspectionQuantity == null ? other$todayInspectionQuantity == null : this$todayInspectionQuantity.equals(other$todayInspectionQuantity)) {
         Object this$yesterdayInspectionQuantity = this.getYesterdayInspectionQuantity();
         Object other$yesterdayInspectionQuantity = other.getYesterdayInspectionQuantity();
         if (this$yesterdayInspectionQuantity == null
            ? other$yesterdayInspectionQuantity == null
            : this$yesterdayInspectionQuantity.equals(other$yesterdayInspectionQuantity)) {
            Object this$teamName = this.getTeamName();
            Object other$teamName = other.getTeamName();
            if (this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName)) {
               Object this$processName = this.getProcessName();
               Object other$processName = other.getProcessName();
               return this$processName == null ? other$processName == null : this$processName.equals(other$processName);
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
      return other instanceof ScreenProductionStatisticsDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $todayInspectionQuantity = this.getTodayInspectionQuantity();
      result = result * 59 + ($todayInspectionQuantity == null ? 43 : $todayInspectionQuantity.hashCode());
      Object $yesterdayInspectionQuantity = this.getYesterdayInspectionQuantity();
      result = result * 59 + ($yesterdayInspectionQuantity == null ? 43 : $yesterdayInspectionQuantity.hashCode());
      Object $teamName = this.getTeamName();
      result = result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
      Object $processName = this.getProcessName();
      return result * 59 + ($processName == null ? 43 : $processName.hashCode());
   }

   public static class ScreenProductionStatisticsDTOBuilder {
      private Double todayInspectionQuantity;
      private Double yesterdayInspectionQuantity;
      private String teamName;
      private String processName;

      ScreenProductionStatisticsDTOBuilder() {
      }

      public ScreenProductionStatisticsDTO.ScreenProductionStatisticsDTOBuilder todayInspectionQuantity(final Double todayInspectionQuantity) {
         this.todayInspectionQuantity = todayInspectionQuantity;
         return this;
      }

      public ScreenProductionStatisticsDTO.ScreenProductionStatisticsDTOBuilder yesterdayInspectionQuantity(final Double yesterdayInspectionQuantity) {
         this.yesterdayInspectionQuantity = yesterdayInspectionQuantity;
         return this;
      }

      public ScreenProductionStatisticsDTO.ScreenProductionStatisticsDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      public ScreenProductionStatisticsDTO.ScreenProductionStatisticsDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public ScreenProductionStatisticsDTO build() {
         return new ScreenProductionStatisticsDTO(this.todayInspectionQuantity, this.yesterdayInspectionQuantity, this.teamName, this.processName);
      }

      @Override
      public String toString() {
         return "ScreenProductionStatisticsDTO.ScreenProductionStatisticsDTOBuilder(todayInspectionQuantity="
            + this.todayInspectionQuantity
            + ", yesterdayInspectionQuantity="
            + this.yesterdayInspectionQuantity
            + ", teamName="
            + this.teamName
            + ", processName="
            + this.processName
            + ")";
      }
   }
}
