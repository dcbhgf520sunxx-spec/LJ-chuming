package com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.screen;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ScreenTeamAchievementRateVO", description = "班组达成率")
public class ScreenTeamAchievementRateVO {
   @ApiModelProperty(name = "annualAverage", notes = "年度平均")
   private Double 年度平均;
   @ApiModelProperty(name = "lastMonth", notes = "上月")
   private Double 上月;
   @ApiModelProperty(name = "teamName", notes = "班组名称")
   private String 班组;

   public static ScreenTeamAchievementRateVO.ScreenTeamAchievementRateVOBuilder builder() {
      return new ScreenTeamAchievementRateVO.ScreenTeamAchievementRateVOBuilder();
   }

   public ScreenTeamAchievementRateVO() {
   }

   public ScreenTeamAchievementRateVO(final Double 年度平均, final Double 上月, final String 班组) {
      this.年度平均 = 年度平均;
      this.上月 = 上月;
      this.班组 = 班组;
   }

   public Double get年度平均() {
      return this.年度平均;
   }

   public Double get上月() {
      return this.上月;
   }

   public String get班组() {
      return this.班组;
   }

   public ScreenTeamAchievementRateVO set年度平均(final Double 年度平均) {
      this.年度平均 = 年度平均;
      return this;
   }

   public ScreenTeamAchievementRateVO set上月(final Double 上月) {
      this.上月 = 上月;
      return this;
   }

   public ScreenTeamAchievementRateVO set班组(final String 班组) {
      this.班组 = 班组;
      return this;
   }

   @Override
   public String toString() {
      return "ScreenTeamAchievementRateVO(年度平均=" + this.get年度平均() + ", 上月=" + this.get上月() + ", 班组=" + this.get班组() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScreenTeamAchievementRateVO)) {
         return false;
      }

      ScreenTeamAchievementRateVO other = (ScreenTeamAchievementRateVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$年度平均 = this.get年度平均();
      Object other$年度平均 = other.get年度平均();
      if (this$年度平均 == null ? other$年度平均 == null : this$年度平均.equals(other$年度平均)) {
         Object this$上月 = this.get上月();
         Object other$上月 = other.get上月();
         if (this$上月 == null ? other$上月 == null : this$上月.equals(other$上月)) {
            Object this$班组 = this.get班组();
            Object other$班组 = other.get班组();
            return this$班组 == null ? other$班组 == null : this$班组.equals(other$班组);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ScreenTeamAchievementRateVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $年度平均 = this.get年度平均();
      result = result * 59 + ($年度平均 == null ? 43 : $年度平均.hashCode());
      Object $上月 = this.get上月();
      result = result * 59 + ($上月 == null ? 43 : $上月.hashCode());
      Object $班组 = this.get班组();
      return result * 59 + ($班组 == null ? 43 : $班组.hashCode());
   }

   public static class ScreenTeamAchievementRateVOBuilder {
      private Double 年度平均;
      private Double 上月;
      private String 班组;

      ScreenTeamAchievementRateVOBuilder() {
      }

      public ScreenTeamAchievementRateVO.ScreenTeamAchievementRateVOBuilder 年度平均(final Double 年度平均) {
         this.年度平均 = 年度平均;
         return this;
      }

      public ScreenTeamAchievementRateVO.ScreenTeamAchievementRateVOBuilder 上月(final Double 上月) {
         this.上月 = 上月;
         return this;
      }

      public ScreenTeamAchievementRateVO.ScreenTeamAchievementRateVOBuilder 班组(final String 班组) {
         this.班组 = 班组;
         return this;
      }

      public ScreenTeamAchievementRateVO build() {
         return new ScreenTeamAchievementRateVO(this.年度平均, this.上月, this.班组);
      }

      @Override
      public String toString() {
         return "ScreenTeamAchievementRateVO.ScreenTeamAchievementRateVOBuilder(年度平均=" + this.年度平均 + ", 上月=" + this.上月 + ", 班组=" + this.班组 + ")";
      }
   }
}
