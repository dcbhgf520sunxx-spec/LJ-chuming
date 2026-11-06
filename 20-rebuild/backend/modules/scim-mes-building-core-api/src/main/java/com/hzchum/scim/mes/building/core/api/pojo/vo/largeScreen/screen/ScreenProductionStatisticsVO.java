package com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.screen;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ScreenProductionStatisticsVO", description = "班组产量统计")
public class ScreenProductionStatisticsVO {
   @ApiModelProperty(name = "todayInspectionQuantity", notes = "今日产量")
   private Double 今日产量;
   @ApiModelProperty(name = "yesterdayInspectionQuantity", notes = "昨日产量")
   private Double 昨日产量;
   @ApiModelProperty(name = "teamName", notes = "班组名称")
   private String 班组;
   @ApiModelProperty(name = "processName", notes = "工序名称")
   private String 工序;

   public static ScreenProductionStatisticsVO.ScreenProductionStatisticsVOBuilder builder() {
      return new ScreenProductionStatisticsVO.ScreenProductionStatisticsVOBuilder();
   }

   public ScreenProductionStatisticsVO() {
   }

   public ScreenProductionStatisticsVO(final Double 今日产量, final Double 昨日产量, final String 班组, final String 工序) {
      this.今日产量 = 今日产量;
      this.昨日产量 = 昨日产量;
      this.班组 = 班组;
      this.工序 = 工序;
   }

   public Double get今日产量() {
      return this.今日产量;
   }

   public Double get昨日产量() {
      return this.昨日产量;
   }

   public String get班组() {
      return this.班组;
   }

   public String get工序() {
      return this.工序;
   }

   public ScreenProductionStatisticsVO set今日产量(final Double 今日产量) {
      this.今日产量 = 今日产量;
      return this;
   }

   public ScreenProductionStatisticsVO set昨日产量(final Double 昨日产量) {
      this.昨日产量 = 昨日产量;
      return this;
   }

   public ScreenProductionStatisticsVO set班组(final String 班组) {
      this.班组 = 班组;
      return this;
   }

   public ScreenProductionStatisticsVO set工序(final String 工序) {
      this.工序 = 工序;
      return this;
   }

   @Override
   public String toString() {
      return "ScreenProductionStatisticsVO(今日产量=" + this.get今日产量() + ", 昨日产量=" + this.get昨日产量() + ", 班组=" + this.get班组() + ", 工序=" + this.get工序() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScreenProductionStatisticsVO)) {
         return false;
      }

      ScreenProductionStatisticsVO other = (ScreenProductionStatisticsVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$今日产量 = this.get今日产量();
      Object other$今日产量 = other.get今日产量();
      if (this$今日产量 == null ? other$今日产量 == null : this$今日产量.equals(other$今日产量)) {
         Object this$昨日产量 = this.get昨日产量();
         Object other$昨日产量 = other.get昨日产量();
         if (this$昨日产量 == null ? other$昨日产量 == null : this$昨日产量.equals(other$昨日产量)) {
            Object this$班组 = this.get班组();
            Object other$班组 = other.get班组();
            if (this$班组 == null ? other$班组 == null : this$班组.equals(other$班组)) {
               Object this$工序 = this.get工序();
               Object other$工序 = other.get工序();
               return this$工序 == null ? other$工序 == null : this$工序.equals(other$工序);
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
      return other instanceof ScreenProductionStatisticsVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $今日产量 = this.get今日产量();
      result = result * 59 + ($今日产量 == null ? 43 : $今日产量.hashCode());
      Object $昨日产量 = this.get昨日产量();
      result = result * 59 + ($昨日产量 == null ? 43 : $昨日产量.hashCode());
      Object $班组 = this.get班组();
      result = result * 59 + ($班组 == null ? 43 : $班组.hashCode());
      Object $工序 = this.get工序();
      return result * 59 + ($工序 == null ? 43 : $工序.hashCode());
   }

   public static class ScreenProductionStatisticsVOBuilder {
      private Double 今日产量;
      private Double 昨日产量;
      private String 班组;
      private String 工序;

      ScreenProductionStatisticsVOBuilder() {
      }

      public ScreenProductionStatisticsVO.ScreenProductionStatisticsVOBuilder 今日产量(final Double 今日产量) {
         this.今日产量 = 今日产量;
         return this;
      }

      public ScreenProductionStatisticsVO.ScreenProductionStatisticsVOBuilder 昨日产量(final Double 昨日产量) {
         this.昨日产量 = 昨日产量;
         return this;
      }

      public ScreenProductionStatisticsVO.ScreenProductionStatisticsVOBuilder 班组(final String 班组) {
         this.班组 = 班组;
         return this;
      }

      public ScreenProductionStatisticsVO.ScreenProductionStatisticsVOBuilder 工序(final String 工序) {
         this.工序 = 工序;
         return this;
      }

      public ScreenProductionStatisticsVO build() {
         return new ScreenProductionStatisticsVO(this.今日产量, this.昨日产量, this.班组, this.工序);
      }

      @Override
      public String toString() {
         return "ScreenProductionStatisticsVO.ScreenProductionStatisticsVOBuilder(今日产量="
            + this.今日产量
            + ", 昨日产量="
            + this.昨日产量
            + ", 班组="
            + this.班组
            + ", 工序="
            + this.工序
            + ")";
      }
   }
}
