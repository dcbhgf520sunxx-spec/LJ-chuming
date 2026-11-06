package com.hzchum.scim.mes.building.core.api.pojo.vo.largeScreen.screen;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "ScreenMonthlyOutputVO", description = "月度产量")
public class ScreenMonthlyOutputVO {
   @ApiModelProperty(name = "inspectionQuantity", notes = "产量")
   private Double 产量;
   @ApiModelProperty(name = "teamName", notes = "班组名称")
   private String 班组;

   public static ScreenMonthlyOutputVO.ScreenMonthlyOutputVOBuilder builder() {
      return new ScreenMonthlyOutputVO.ScreenMonthlyOutputVOBuilder();
   }

   public ScreenMonthlyOutputVO() {
   }

   public ScreenMonthlyOutputVO(final Double 产量, final String 班组) {
      this.产量 = 产量;
      this.班组 = 班组;
   }

   public Double get产量() {
      return this.产量;
   }

   public String get班组() {
      return this.班组;
   }

   public ScreenMonthlyOutputVO set产量(final Double 产量) {
      this.产量 = 产量;
      return this;
   }

   public ScreenMonthlyOutputVO set班组(final String 班组) {
      this.班组 = 班组;
      return this;
   }

   @Override
   public String toString() {
      return "ScreenMonthlyOutputVO(产量=" + this.get产量() + ", 班组=" + this.get班组() + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof ScreenMonthlyOutputVO)) {
         return false;
      } else {
         ScreenMonthlyOutputVO other = (ScreenMonthlyOutputVO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$产量 = this.get产量();
            Object other$产量 = other.get产量();
            if (this$产量 == null ? other$产量 == null : this$产量.equals(other$产量)) {
               Object this$班组 = this.get班组();
               Object other$班组 = other.get班组();
               return this$班组 == null ? other$班组 == null : this$班组.equals(other$班组);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ScreenMonthlyOutputVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $产量 = this.get产量();
      result = result * 59 + ($产量 == null ? 43 : $产量.hashCode());
      Object $班组 = this.get班组();
      return result * 59 + ($班组 == null ? 43 : $班组.hashCode());
   }

   public static class ScreenMonthlyOutputVOBuilder {
      private Double 产量;
      private String 班组;

      ScreenMonthlyOutputVOBuilder() {
      }

      public ScreenMonthlyOutputVO.ScreenMonthlyOutputVOBuilder 产量(final Double 产量) {
         this.产量 = 产量;
         return this;
      }

      public ScreenMonthlyOutputVO.ScreenMonthlyOutputVOBuilder 班组(final String 班组) {
         this.班组 = 班组;
         return this;
      }

      public ScreenMonthlyOutputVO build() {
         return new ScreenMonthlyOutputVO(this.产量, this.班组);
      }

      @Override
      public String toString() {
         return "ScreenMonthlyOutputVO.ScreenMonthlyOutputVOBuilder(产量=" + this.产量 + ", 班组=" + this.班组 + ")";
      }
   }
}
