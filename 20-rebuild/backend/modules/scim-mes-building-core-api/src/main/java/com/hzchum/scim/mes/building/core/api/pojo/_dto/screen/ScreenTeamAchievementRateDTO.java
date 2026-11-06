package com.hzchum.scim.mes.building.core.api.pojo._dto.screen;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ScreenTeamAchievementRateDTO", description = "班组达成率")
public class ScreenTeamAchievementRateDTO {
   @ApiModelProperty(name = "totalQuantity", notes = "年度总数")
   private Double totalQuantity;
   @ApiModelProperty(name = "inspectionQuantity", notes = "通过质检数")
   private Double inspectionQuantity;
   @ApiModelProperty(name = "monthTotalQuantity", notes = "上个月总数")
   private Double monthTotalQuantity;
   @ApiModelProperty(name = "monthInspectionQuantity", notes = "上月质检数")
   private Double monthInspectionQuantity;
   @ApiModelProperty(name = "teamName", notes = "班组名称")
   private String teamName;

   public static ScreenTeamAchievementRateDTO.ScreenTeamAchievementRateDTOBuilder builder() {
      return new ScreenTeamAchievementRateDTO.ScreenTeamAchievementRateDTOBuilder();
   }

   public ScreenTeamAchievementRateDTO() {
   }

   public ScreenTeamAchievementRateDTO(
      final Double totalQuantity, final Double inspectionQuantity, final Double monthTotalQuantity, final Double monthInspectionQuantity, final String teamName
   ) {
      this.totalQuantity = totalQuantity;
      this.inspectionQuantity = inspectionQuantity;
      this.monthTotalQuantity = monthTotalQuantity;
      this.monthInspectionQuantity = monthInspectionQuantity;
      this.teamName = teamName;
   }

   public Double getTotalQuantity() {
      return this.totalQuantity;
   }

   public Double getInspectionQuantity() {
      return this.inspectionQuantity;
   }

   public Double getMonthTotalQuantity() {
      return this.monthTotalQuantity;
   }

   public Double getMonthInspectionQuantity() {
      return this.monthInspectionQuantity;
   }

   public String getTeamName() {
      return this.teamName;
   }

   public ScreenTeamAchievementRateDTO setTotalQuantity(final Double totalQuantity) {
      this.totalQuantity = totalQuantity;
      return this;
   }

   public ScreenTeamAchievementRateDTO setInspectionQuantity(final Double inspectionQuantity) {
      this.inspectionQuantity = inspectionQuantity;
      return this;
   }

   public ScreenTeamAchievementRateDTO setMonthTotalQuantity(final Double monthTotalQuantity) {
      this.monthTotalQuantity = monthTotalQuantity;
      return this;
   }

   public ScreenTeamAchievementRateDTO setMonthInspectionQuantity(final Double monthInspectionQuantity) {
      this.monthInspectionQuantity = monthInspectionQuantity;
      return this;
   }

   public ScreenTeamAchievementRateDTO setTeamName(final String teamName) {
      this.teamName = teamName;
      return this;
   }

   @Override
   public String toString() {
      return "ScreenTeamAchievementRateDTO(totalQuantity="
         + this.getTotalQuantity()
         + ", inspectionQuantity="
         + this.getInspectionQuantity()
         + ", monthTotalQuantity="
         + this.getMonthTotalQuantity()
         + ", monthInspectionQuantity="
         + this.getMonthInspectionQuantity()
         + ", teamName="
         + this.getTeamName()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScreenTeamAchievementRateDTO)) {
         return false;
      }

      ScreenTeamAchievementRateDTO other = (ScreenTeamAchievementRateDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalQuantity = this.getTotalQuantity();
      Object other$totalQuantity = other.getTotalQuantity();
      if (this$totalQuantity == null ? other$totalQuantity == null : this$totalQuantity.equals(other$totalQuantity)) {
         Object this$inspectionQuantity = this.getInspectionQuantity();
         Object other$inspectionQuantity = other.getInspectionQuantity();
         if (this$inspectionQuantity == null ? other$inspectionQuantity == null : this$inspectionQuantity.equals(other$inspectionQuantity)) {
            Object this$monthTotalQuantity = this.getMonthTotalQuantity();
            Object other$monthTotalQuantity = other.getMonthTotalQuantity();
            if (this$monthTotalQuantity == null ? other$monthTotalQuantity == null : this$monthTotalQuantity.equals(other$monthTotalQuantity)) {
               Object this$monthInspectionQuantity = this.getMonthInspectionQuantity();
               Object other$monthInspectionQuantity = other.getMonthInspectionQuantity();
               if (this$monthInspectionQuantity == null
                  ? other$monthInspectionQuantity == null
                  : this$monthInspectionQuantity.equals(other$monthInspectionQuantity)) {
                  Object this$teamName = this.getTeamName();
                  Object other$teamName = other.getTeamName();
                  return this$teamName == null ? other$teamName == null : this$teamName.equals(other$teamName);
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
      return other instanceof ScreenTeamAchievementRateDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalQuantity = this.getTotalQuantity();
      result = result * 59 + ($totalQuantity == null ? 43 : $totalQuantity.hashCode());
      Object $inspectionQuantity = this.getInspectionQuantity();
      result = result * 59 + ($inspectionQuantity == null ? 43 : $inspectionQuantity.hashCode());
      Object $monthTotalQuantity = this.getMonthTotalQuantity();
      result = result * 59 + ($monthTotalQuantity == null ? 43 : $monthTotalQuantity.hashCode());
      Object $monthInspectionQuantity = this.getMonthInspectionQuantity();
      result = result * 59 + ($monthInspectionQuantity == null ? 43 : $monthInspectionQuantity.hashCode());
      Object $teamName = this.getTeamName();
      return result * 59 + ($teamName == null ? 43 : $teamName.hashCode());
   }

   public static class ScreenTeamAchievementRateDTOBuilder {
      private Double totalQuantity;
      private Double inspectionQuantity;
      private Double monthTotalQuantity;
      private Double monthInspectionQuantity;
      private String teamName;

      ScreenTeamAchievementRateDTOBuilder() {
      }

      public ScreenTeamAchievementRateDTO.ScreenTeamAchievementRateDTOBuilder totalQuantity(final Double totalQuantity) {
         this.totalQuantity = totalQuantity;
         return this;
      }

      public ScreenTeamAchievementRateDTO.ScreenTeamAchievementRateDTOBuilder inspectionQuantity(final Double inspectionQuantity) {
         this.inspectionQuantity = inspectionQuantity;
         return this;
      }

      public ScreenTeamAchievementRateDTO.ScreenTeamAchievementRateDTOBuilder monthTotalQuantity(final Double monthTotalQuantity) {
         this.monthTotalQuantity = monthTotalQuantity;
         return this;
      }

      public ScreenTeamAchievementRateDTO.ScreenTeamAchievementRateDTOBuilder monthInspectionQuantity(final Double monthInspectionQuantity) {
         this.monthInspectionQuantity = monthInspectionQuantity;
         return this;
      }

      public ScreenTeamAchievementRateDTO.ScreenTeamAchievementRateDTOBuilder teamName(final String teamName) {
         this.teamName = teamName;
         return this;
      }

      public ScreenTeamAchievementRateDTO build() {
         return new ScreenTeamAchievementRateDTO(
            this.totalQuantity, this.inspectionQuantity, this.monthTotalQuantity, this.monthInspectionQuantity, this.teamName
         );
      }

      @Override
      public String toString() {
         return "ScreenTeamAchievementRateDTO.ScreenTeamAchievementRateDTOBuilder(totalQuantity="
            + this.totalQuantity
            + ", inspectionQuantity="
            + this.inspectionQuantity
            + ", monthTotalQuantity="
            + this.monthTotalQuantity
            + ", monthInspectionQuantity="
            + this.monthInspectionQuantity
            + ", teamName="
            + this.teamName
            + ")";
      }
   }
}
