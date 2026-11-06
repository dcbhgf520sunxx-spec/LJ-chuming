package com.hzchum.scim.mes.building.core.api.pojo.vo.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;

@ApiModel(value = "YearlyOutputComparisonDO", description = "年度产量报表数据")
public class YearlyOutputComparisonVO {
   @ApiModelProperty("构件类别")
   private String structureType;
   @ApiModelProperty("各类别月份集合")
   private List<YearlyOutputComparisonMonthVO> yearlyOutputComparisonMonthVOList;

   public static YearlyOutputComparisonVO.YearlyOutputComparisonVOBuilder builder() {
      return new YearlyOutputComparisonVO.YearlyOutputComparisonVOBuilder();
   }

   public YearlyOutputComparisonVO() {
   }

   public YearlyOutputComparisonVO(final String structureType, final List<YearlyOutputComparisonMonthVO> yearlyOutputComparisonMonthVOList) {
      this.structureType = structureType;
      this.yearlyOutputComparisonMonthVOList = yearlyOutputComparisonMonthVOList;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public List<YearlyOutputComparisonMonthVO> getYearlyOutputComparisonMonthVOList() {
      return this.yearlyOutputComparisonMonthVOList;
   }

   public YearlyOutputComparisonVO setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   public YearlyOutputComparisonVO setYearlyOutputComparisonMonthVOList(final List<YearlyOutputComparisonMonthVO> yearlyOutputComparisonMonthVOList) {
      this.yearlyOutputComparisonMonthVOList = yearlyOutputComparisonMonthVOList;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof YearlyOutputComparisonVO)) {
         return false;
      } else {
         YearlyOutputComparisonVO other = (YearlyOutputComparisonVO)o;
         if (!other.canEqual(this)) {
            return false;
         } else {
            Object this$structureType = this.getStructureType();
            Object other$structureType = other.getStructureType();
            if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
               Object this$yearlyOutputComparisonMonthVOList = this.getYearlyOutputComparisonMonthVOList();
               Object other$yearlyOutputComparisonMonthVOList = other.getYearlyOutputComparisonMonthVOList();
               return this$yearlyOutputComparisonMonthVOList == null
                  ? other$yearlyOutputComparisonMonthVOList == null
                  : this$yearlyOutputComparisonMonthVOList.equals(other$yearlyOutputComparisonMonthVOList);
            } else {
               return false;
            }
         }
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof YearlyOutputComparisonVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $yearlyOutputComparisonMonthVOList = this.getYearlyOutputComparisonMonthVOList();
      return result * 59 + ($yearlyOutputComparisonMonthVOList == null ? 43 : $yearlyOutputComparisonMonthVOList.hashCode());
   }

   @Override
   public String toString() {
      return "YearlyOutputComparisonVO(structureType="
         + this.getStructureType()
         + ", yearlyOutputComparisonMonthVOList="
         + this.getYearlyOutputComparisonMonthVOList()
         + ")";
   }

   public static class YearlyOutputComparisonVOBuilder {
      private String structureType;
      private List<YearlyOutputComparisonMonthVO> yearlyOutputComparisonMonthVOList;

      YearlyOutputComparisonVOBuilder() {
      }

      public YearlyOutputComparisonVO.YearlyOutputComparisonVOBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      public YearlyOutputComparisonVO.YearlyOutputComparisonVOBuilder yearlyOutputComparisonMonthVOList(
         final List<YearlyOutputComparisonMonthVO> yearlyOutputComparisonMonthVOList
      ) {
         this.yearlyOutputComparisonMonthVOList = yearlyOutputComparisonMonthVOList;
         return this;
      }

      public YearlyOutputComparisonVO build() {
         return new YearlyOutputComparisonVO(this.structureType, this.yearlyOutputComparisonMonthVOList);
      }

      @Override
      public String toString() {
         return "YearlyOutputComparisonVO.YearlyOutputComparisonVOBuilder(structureType="
            + this.structureType
            + ", yearlyOutputComparisonMonthVOList="
            + this.yearlyOutputComparisonMonthVOList
            + ")";
      }
   }
}
