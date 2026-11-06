package com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.screen;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ScreenTeamAchievementRateProductionLineVO", description = "班组达成率")
public class ScreenTeamAchievementRateProductionLineVO {
   @ApiModelProperty(name = "annualAverage", notes = "年度平均")
   private Double 年度平均;
   @ApiModelProperty(name = "lastMonth", notes = "上月")
   private Double 上月;
   @ApiModelProperty(name = "teamName", notes = "产线名称")
   private String 产线;

   public static ScreenTeamAchievementRateProductionLineVO.ScreenTeamAchievementRateProductionLineVOBuilder builder() {
      return new ScreenTeamAchievementRateProductionLineVO.ScreenTeamAchievementRateProductionLineVOBuilder();
   }

   public ScreenTeamAchievementRateProductionLineVO() {
   }

   public ScreenTeamAchievementRateProductionLineVO(final Double 年度平均, final Double 上月, final String 产线) {
      this.年度平均 = 年度平均;
      this.上月 = 上月;
      this.产线 = 产线;
   }

   public Double get年度平均() {
      return this.年度平均;
   }

   public Double get上月() {
      return this.上月;
   }

   public String get产线() {
      return this.产线;
   }

   public ScreenTeamAchievementRateProductionLineVO set年度平均(final Double 年度平均) {
      this.年度平均 = 年度平均;
      return this;
   }

   public ScreenTeamAchievementRateProductionLineVO set上月(final Double 上月) {
      this.上月 = 上月;
      return this;
   }

   public ScreenTeamAchievementRateProductionLineVO set产线(final String 产线) {
      this.产线 = 产线;
      return this;
   }

   @Override
   public String toString() {
      return "ScreenTeamAchievementRateProductionLineVO(年度平均=" + this.get年度平均() + ", 上月=" + this.get上月() + ", 产线=" + this.get产线() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScreenTeamAchievementRateProductionLineVO)) {
         return false;
      }

      ScreenTeamAchievementRateProductionLineVO other = (ScreenTeamAchievementRateProductionLineVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$年度平均 = this.get年度平均();
      Object other$年度平均 = other.get年度平均();
      if (this$年度平均 == null ? other$年度平均 == null : this$年度平均.equals(other$年度平均)) {
         Object this$上月 = this.get上月();
         Object other$上月 = other.get上月();
         if (this$上月 == null ? other$上月 == null : this$上月.equals(other$上月)) {
            Object this$产线 = this.get产线();
            Object other$产线 = other.get产线();
            return this$产线 == null ? other$产线 == null : this$产线.equals(other$产线);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ScreenTeamAchievementRateProductionLineVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $年度平均 = this.get年度平均();
      result = result * 59 + ($年度平均 == null ? 43 : $年度平均.hashCode());
      Object $上月 = this.get上月();
      result = result * 59 + ($上月 == null ? 43 : $上月.hashCode());
      Object $产线 = this.get产线();
      return result * 59 + ($产线 == null ? 43 : $产线.hashCode());
   }

   public static class ScreenTeamAchievementRateProductionLineVOBuilder {
      private Double 年度平均;
      private Double 上月;
      private String 产线;

      ScreenTeamAchievementRateProductionLineVOBuilder() {
      }

      public ScreenTeamAchievementRateProductionLineVO.ScreenTeamAchievementRateProductionLineVOBuilder 年度平均(final Double 年度平均) {
         this.年度平均 = 年度平均;
         return this;
      }

      public ScreenTeamAchievementRateProductionLineVO.ScreenTeamAchievementRateProductionLineVOBuilder 上月(final Double 上月) {
         this.上月 = 上月;
         return this;
      }

      public ScreenTeamAchievementRateProductionLineVO.ScreenTeamAchievementRateProductionLineVOBuilder 产线(final String 产线) {
         this.产线 = 产线;
         return this;
      }

      public ScreenTeamAchievementRateProductionLineVO build() {
         return new ScreenTeamAchievementRateProductionLineVO(this.年度平均, this.上月, this.产线);
      }

      @Override
      public String toString() {
         return "ScreenTeamAchievementRateProductionLineVO.ScreenTeamAchievementRateProductionLineVOBuilder(年度平均="
            + this.年度平均
            + ", 上月="
            + this.上月
            + ", 产线="
            + this.产线
            + ")";
      }
   }
}
