package com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.screen;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "ScreenProjectProcessCompletionRateVO", description = "构建，零件，部件工序完成率")
public class ScreenProjectProcessCompletionRateVO {
   @ApiModelProperty(name = "项目名称", notes = "项目名称")
   private String 项目名称;
   List<ScreenProjectProcessCompletionRate1VO> 图表数据;
   Object chartData;

   public static ScreenProjectProcessCompletionRateVO.ScreenProjectProcessCompletionRateVOBuilder builder() {
      return new ScreenProjectProcessCompletionRateVO.ScreenProjectProcessCompletionRateVOBuilder();
   }

   public ScreenProjectProcessCompletionRateVO() {
   }

   public ScreenProjectProcessCompletionRateVO(final String 项目名称, final List<ScreenProjectProcessCompletionRate1VO> 图表数据, final Object chartData) {
      this.项目名称 = 项目名称;
      this.图表数据 = 图表数据;
      this.chartData = chartData;
   }

   public String get项目名称() {
      return this.项目名称;
   }

   public List<ScreenProjectProcessCompletionRate1VO> get图表数据() {
      return this.图表数据;
   }

   public Object getChartData() {
      return this.chartData;
   }

   public ScreenProjectProcessCompletionRateVO set项目名称(final String 项目名称) {
      this.项目名称 = 项目名称;
      return this;
   }

   public ScreenProjectProcessCompletionRateVO set图表数据(final List<ScreenProjectProcessCompletionRate1VO> 图表数据) {
      this.图表数据 = 图表数据;
      return this;
   }

   public ScreenProjectProcessCompletionRateVO setChartData(final Object chartData) {
      this.chartData = chartData;
      return this;
   }

   @Override
   public String toString() {
      return "ScreenProjectProcessCompletionRateVO(项目名称=" + this.get项目名称() + ", 图表数据=" + this.get图表数据() + ", chartData=" + this.getChartData() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScreenProjectProcessCompletionRateVO)) {
         return false;
      }

      ScreenProjectProcessCompletionRateVO other = (ScreenProjectProcessCompletionRateVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$项目名称 = this.get项目名称();
      Object other$项目名称 = other.get项目名称();
      if (this$项目名称 == null ? other$项目名称 == null : this$项目名称.equals(other$项目名称)) {
         Object this$图表数据 = this.get图表数据();
         Object other$图表数据 = other.get图表数据();
         if (this$图表数据 == null ? other$图表数据 == null : this$图表数据.equals(other$图表数据)) {
            Object this$chartData = this.getChartData();
            Object other$chartData = other.getChartData();
            return this$chartData == null ? other$chartData == null : this$chartData.equals(other$chartData);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ScreenProjectProcessCompletionRateVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $项目名称 = this.get项目名称();
      result = result * 59 + ($项目名称 == null ? 43 : $项目名称.hashCode());
      Object $图表数据 = this.get图表数据();
      result = result * 59 + ($图表数据 == null ? 43 : $图表数据.hashCode());
      Object $chartData = this.getChartData();
      return result * 59 + ($chartData == null ? 43 : $chartData.hashCode());
   }

   public static class ScreenProjectProcessCompletionRateVOBuilder {
      private String 项目名称;
      private List<ScreenProjectProcessCompletionRate1VO> 图表数据;
      private Object chartData;

      ScreenProjectProcessCompletionRateVOBuilder() {
      }

      public ScreenProjectProcessCompletionRateVO.ScreenProjectProcessCompletionRateVOBuilder 项目名称(final String 项目名称) {
         this.项目名称 = 项目名称;
         return this;
      }

      public ScreenProjectProcessCompletionRateVO.ScreenProjectProcessCompletionRateVOBuilder 图表数据(final List<ScreenProjectProcessCompletionRate1VO> 图表数据) {
         this.图表数据 = 图表数据;
         return this;
      }

      public ScreenProjectProcessCompletionRateVO.ScreenProjectProcessCompletionRateVOBuilder chartData(final Object chartData) {
         this.chartData = chartData;
         return this;
      }

      public ScreenProjectProcessCompletionRateVO build() {
         return new ScreenProjectProcessCompletionRateVO(this.项目名称, this.图表数据, this.chartData);
      }

      @Override
      public String toString() {
         return "ScreenProjectProcessCompletionRateVO.ScreenProjectProcessCompletionRateVOBuilder(项目名称="
            + this.项目名称
            + ", 图表数据="
            + this.图表数据
            + ", chartData="
            + this.chartData
            + ")";
      }
   }
}
