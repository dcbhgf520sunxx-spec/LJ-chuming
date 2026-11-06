package com.hzchum.scim.mes.building.core.api.pojo.vo.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel(value = "YearlyOutputComparisonDO", description = "车间制作产量月报")
public class MonthlyWorkshopOutPutVO {
   @ApiModelProperty("构件类别")
   private String structureType;
   private BigDecimal totalNetWeightAll;
   @ApiModelProperty("项目及项目产量")
   private List<MonthlyWorkshopOutPutProjectVO> monthlyWorkshopOutPutProjectVOList;

   public static MonthlyWorkshopOutPutVO.MonthlyWorkshopOutPutVOBuilder builder() {
      return new MonthlyWorkshopOutPutVO.MonthlyWorkshopOutPutVOBuilder();
   }

   public MonthlyWorkshopOutPutVO() {
   }

   public MonthlyWorkshopOutPutVO(
      final String structureType, final BigDecimal totalNetWeightAll, final List<MonthlyWorkshopOutPutProjectVO> monthlyWorkshopOutPutProjectVOList
   ) {
      this.structureType = structureType;
      this.totalNetWeightAll = totalNetWeightAll;
      this.monthlyWorkshopOutPutProjectVOList = monthlyWorkshopOutPutProjectVOList;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public BigDecimal getTotalNetWeightAll() {
      return this.totalNetWeightAll;
   }

   public List<MonthlyWorkshopOutPutProjectVO> getMonthlyWorkshopOutPutProjectVOList() {
      return this.monthlyWorkshopOutPutProjectVOList;
   }

   public MonthlyWorkshopOutPutVO setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   public MonthlyWorkshopOutPutVO setTotalNetWeightAll(final BigDecimal totalNetWeightAll) {
      this.totalNetWeightAll = totalNetWeightAll;
      return this;
   }

   public MonthlyWorkshopOutPutVO setMonthlyWorkshopOutPutProjectVOList(final List<MonthlyWorkshopOutPutProjectVO> monthlyWorkshopOutPutProjectVOList) {
      this.monthlyWorkshopOutPutProjectVOList = monthlyWorkshopOutPutProjectVOList;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonthlyWorkshopOutPutVO)) {
         return false;
      }

      MonthlyWorkshopOutPutVO other = (MonthlyWorkshopOutPutVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$structureType = this.getStructureType();
      Object other$structureType = other.getStructureType();
      if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
         Object this$totalNetWeightAll = this.getTotalNetWeightAll();
         Object other$totalNetWeightAll = other.getTotalNetWeightAll();
         if (this$totalNetWeightAll == null ? other$totalNetWeightAll == null : this$totalNetWeightAll.equals(other$totalNetWeightAll)) {
            Object this$monthlyWorkshopOutPutProjectVOList = this.getMonthlyWorkshopOutPutProjectVOList();
            Object other$monthlyWorkshopOutPutProjectVOList = other.getMonthlyWorkshopOutPutProjectVOList();
            return this$monthlyWorkshopOutPutProjectVOList == null
               ? other$monthlyWorkshopOutPutProjectVOList == null
               : this$monthlyWorkshopOutPutProjectVOList.equals(other$monthlyWorkshopOutPutProjectVOList);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MonthlyWorkshopOutPutVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $totalNetWeightAll = this.getTotalNetWeightAll();
      result = result * 59 + ($totalNetWeightAll == null ? 43 : $totalNetWeightAll.hashCode());
      Object $monthlyWorkshopOutPutProjectVOList = this.getMonthlyWorkshopOutPutProjectVOList();
      return result * 59 + ($monthlyWorkshopOutPutProjectVOList == null ? 43 : $monthlyWorkshopOutPutProjectVOList.hashCode());
   }

   @Override
   public String toString() {
      return "MonthlyWorkshopOutPutVO(structureType="
         + this.getStructureType()
         + ", totalNetWeightAll="
         + this.getTotalNetWeightAll()
         + ", monthlyWorkshopOutPutProjectVOList="
         + this.getMonthlyWorkshopOutPutProjectVOList()
         + ")";
   }

   public static class MonthlyWorkshopOutPutVOBuilder {
      private String structureType;
      private BigDecimal totalNetWeightAll;
      private List<MonthlyWorkshopOutPutProjectVO> monthlyWorkshopOutPutProjectVOList;

      MonthlyWorkshopOutPutVOBuilder() {
      }

      public MonthlyWorkshopOutPutVO.MonthlyWorkshopOutPutVOBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      public MonthlyWorkshopOutPutVO.MonthlyWorkshopOutPutVOBuilder totalNetWeightAll(final BigDecimal totalNetWeightAll) {
         this.totalNetWeightAll = totalNetWeightAll;
         return this;
      }

      public MonthlyWorkshopOutPutVO.MonthlyWorkshopOutPutVOBuilder monthlyWorkshopOutPutProjectVOList(
         final List<MonthlyWorkshopOutPutProjectVO> monthlyWorkshopOutPutProjectVOList
      ) {
         this.monthlyWorkshopOutPutProjectVOList = monthlyWorkshopOutPutProjectVOList;
         return this;
      }

      public MonthlyWorkshopOutPutVO build() {
         return new MonthlyWorkshopOutPutVO(this.structureType, this.totalNetWeightAll, this.monthlyWorkshopOutPutProjectVOList);
      }

      @Override
      public String toString() {
         return "MonthlyWorkshopOutPutVO.MonthlyWorkshopOutPutVOBuilder(structureType="
            + this.structureType
            + ", totalNetWeightAll="
            + this.totalNetWeightAll
            + ", monthlyWorkshopOutPutProjectVOList="
            + this.monthlyWorkshopOutPutProjectVOList
            + ")";
      }
   }
}
