package com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.screen;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ScreenProjectProcessCompletionRate1VO", description = "构建，零件，部件工序完成率")
public class ScreenProjectProcessCompletionRate1VO {
   @ApiModelProperty(name = "工序名称", notes = "产品工序名称（零件，构件，部件）")
   private String 工序名称;
   @ApiModelProperty(name = "完成率", notes = "完成率")
   private Double 完成率;

   public static ScreenProjectProcessCompletionRate1VO.ScreenProjectProcessCompletionRate1VOBuilder builder() {
      return new ScreenProjectProcessCompletionRate1VO.ScreenProjectProcessCompletionRate1VOBuilder();
   }

   public ScreenProjectProcessCompletionRate1VO() {
   }

   public ScreenProjectProcessCompletionRate1VO(final String 工序名称, final Double 完成率) {
      this.工序名称 = 工序名称;
      this.完成率 = 完成率;
   }

   public String get工序名称() {
      return this.工序名称;
   }

   public Double get完成率() {
      return this.完成率;
   }

   public ScreenProjectProcessCompletionRate1VO set工序名称(final String 工序名称) {
      this.工序名称 = 工序名称;
      return this;
   }

   public ScreenProjectProcessCompletionRate1VO set完成率(final Double 完成率) {
      this.完成率 = 完成率;
      return this;
   }

   @Override
   public String toString() {
      return "ScreenProjectProcessCompletionRate1VO(工序名称=" + this.get工序名称() + ", 完成率=" + this.get完成率() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ScreenProjectProcessCompletionRate1VO)) {
         return false;
      } else {
         ScreenProjectProcessCompletionRate1VO other = (ScreenProjectProcessCompletionRate1VO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$完成率 = this.get完成率();
            Object other$完成率 = other.get完成率();
            if (this$完成率 == null ? other$完成率 == null : this$完成率.equals(other$完成率)) {
               Object this$工序名称 = this.get工序名称();
               Object other$工序名称 = other.get工序名称();
               return this$工序名称 == null ? other$工序名称 == null : this$工序名称.equals(other$工序名称);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ScreenProjectProcessCompletionRate1VO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $完成率 = this.get完成率();
      result = result * 59 + ($完成率 == null ? 43 : $完成率.hashCode());
      Object $工序名称 = this.get工序名称();
      return result * 59 + ($工序名称 == null ? 43 : $工序名称.hashCode());
   }

   public static class ScreenProjectProcessCompletionRate1VOBuilder {
      private String 工序名称;
      private Double 完成率;

      ScreenProjectProcessCompletionRate1VOBuilder() {
      }

      public ScreenProjectProcessCompletionRate1VO.ScreenProjectProcessCompletionRate1VOBuilder 工序名称(final String 工序名称) {
         this.工序名称 = 工序名称;
         return this;
      }

      public ScreenProjectProcessCompletionRate1VO.ScreenProjectProcessCompletionRate1VOBuilder 完成率(final Double 完成率) {
         this.完成率 = 完成率;
         return this;
      }

      public ScreenProjectProcessCompletionRate1VO build() {
         return new ScreenProjectProcessCompletionRate1VO(this.工序名称, this.完成率);
      }

      @Override
      public String toString() {
         return "ScreenProjectProcessCompletionRate1VO.ScreenProjectProcessCompletionRate1VOBuilder(工序名称=" + this.工序名称 + ", 完成率=" + this.完成率 + ")";
      }
   }
}
