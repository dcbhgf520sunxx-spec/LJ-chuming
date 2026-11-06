package com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.screen;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ScreenProcessCompletionRateDTO", description = "构建，零件，部件工序完成率")
public class ScreenProcessCompletionRateVO {
   @ApiModelProperty(name = "工序名称", notes = "产品工序名称（零件，构件，部件）")
   private String 工序名称;
   @ApiModelProperty(name = "任务总数", notes = "任务总数")
   private Double 任务总数;
   @ApiModelProperty(name = "任务完成数", notes = "任务完成数")
   private Double 任务完成数;
   @ApiModelProperty(name = "完成率", notes = "完成率")
   private Double 完成率;

   public static ScreenProcessCompletionRateVO.ScreenProcessCompletionRateVOBuilder builder() {
      return new ScreenProcessCompletionRateVO.ScreenProcessCompletionRateVOBuilder();
   }

   public ScreenProcessCompletionRateVO() {
   }

   public ScreenProcessCompletionRateVO(final String 工序名称, final Double 任务总数, final Double 任务完成数, final Double 完成率) {
      this.工序名称 = 工序名称;
      this.任务总数 = 任务总数;
      this.任务完成数 = 任务完成数;
      this.完成率 = 完成率;
   }

   public String get工序名称() {
      return this.工序名称;
   }

   public Double get任务总数() {
      return this.任务总数;
   }

   public Double get任务完成数() {
      return this.任务完成数;
   }

   public Double get完成率() {
      return this.完成率;
   }

   public ScreenProcessCompletionRateVO set工序名称(final String 工序名称) {
      this.工序名称 = 工序名称;
      return this;
   }

   public ScreenProcessCompletionRateVO set任务总数(final Double 任务总数) {
      this.任务总数 = 任务总数;
      return this;
   }

   public ScreenProcessCompletionRateVO set任务完成数(final Double 任务完成数) {
      this.任务完成数 = 任务完成数;
      return this;
   }

   public ScreenProcessCompletionRateVO set完成率(final Double 完成率) {
      this.完成率 = 完成率;
      return this;
   }

   @Override
   public String toString() {
      return "ScreenProcessCompletionRateVO(工序名称="
         + this.get工序名称()
         + ", 任务总数="
         + this.get任务总数()
         + ", 任务完成数="
         + this.get任务完成数()
         + ", 完成率="
         + this.get完成率()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ScreenProcessCompletionRateVO)) {
         return false;
      }

      ScreenProcessCompletionRateVO other = (ScreenProcessCompletionRateVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$任务总数 = this.get任务总数();
      Object other$任务总数 = other.get任务总数();
      if (this$任务总数 == null ? other$任务总数 == null : this$任务总数.equals(other$任务总数)) {
         Object this$任务完成数 = this.get任务完成数();
         Object other$任务完成数 = other.get任务完成数();
         if (this$任务完成数 == null ? other$任务完成数 == null : this$任务完成数.equals(other$任务完成数)) {
            Object this$完成率 = this.get完成率();
            Object other$完成率 = other.get完成率();
            if (this$完成率 == null ? other$完成率 == null : this$完成率.equals(other$完成率)) {
               Object this$工序名称 = this.get工序名称();
               Object other$工序名称 = other.get工序名称();
               return this$工序名称 == null ? other$工序名称 == null : this$工序名称.equals(other$工序名称);
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
      return other instanceof ScreenProcessCompletionRateVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $任务总数 = this.get任务总数();
      result = result * 59 + ($任务总数 == null ? 43 : $任务总数.hashCode());
      Object $任务完成数 = this.get任务完成数();
      result = result * 59 + ($任务完成数 == null ? 43 : $任务完成数.hashCode());
      Object $完成率 = this.get完成率();
      result = result * 59 + ($完成率 == null ? 43 : $完成率.hashCode());
      Object $工序名称 = this.get工序名称();
      return result * 59 + ($工序名称 == null ? 43 : $工序名称.hashCode());
   }

   public static class ScreenProcessCompletionRateVOBuilder {
      private String 工序名称;
      private Double 任务总数;
      private Double 任务完成数;
      private Double 完成率;

      ScreenProcessCompletionRateVOBuilder() {
      }

      public ScreenProcessCompletionRateVO.ScreenProcessCompletionRateVOBuilder 工序名称(final String 工序名称) {
         this.工序名称 = 工序名称;
         return this;
      }

      public ScreenProcessCompletionRateVO.ScreenProcessCompletionRateVOBuilder 任务总数(final Double 任务总数) {
         this.任务总数 = 任务总数;
         return this;
      }

      public ScreenProcessCompletionRateVO.ScreenProcessCompletionRateVOBuilder 任务完成数(final Double 任务完成数) {
         this.任务完成数 = 任务完成数;
         return this;
      }

      public ScreenProcessCompletionRateVO.ScreenProcessCompletionRateVOBuilder 完成率(final Double 完成率) {
         this.完成率 = 完成率;
         return this;
      }

      public ScreenProcessCompletionRateVO build() {
         return new ScreenProcessCompletionRateVO(this.工序名称, this.任务总数, this.任务完成数, this.完成率);
      }

      @Override
      public String toString() {
         return "ScreenProcessCompletionRateVO.ScreenProcessCompletionRateVOBuilder(工序名称="
            + this.工序名称
            + ", 任务总数="
            + this.任务总数
            + ", 任务完成数="
            + this.任务完成数
            + ", 完成率="
            + this.完成率
            + ")";
      }
   }
}
