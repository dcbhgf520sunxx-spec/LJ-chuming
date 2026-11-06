package com.hzchum.scim.operational.analysis.core.api.pojo._dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("生产成本分析-返回类")
public class ProductionCostAnalysisDTOV2 {
   @ApiModelProperty(name = "index", value = "序号", notes = "序号")
   @JsonInclude(Include.NON_NULL)
   private Integer index;
   @ApiModelProperty(name = "className", value = "类别", notes = "类别")
   private String className;
   @ApiModelProperty(name = "costInfoList", value = "每月产量/每月费用(固定12月)", notes = "每月产量/每月费用(固定12月)")
   private List<MonthCostOrMeteDTO> costInfoList;
   @ApiModelProperty(name = "sumMete", value = "合计(元)", notes = "合计(元)")
   private BigDecimal sumMete;
   @ApiModelProperty(name = "avgMete", value = "平均(元/吨)", notes = "平均(元/吨)")
   private BigDecimal avgMete;
   @ApiModelProperty(name = "sort", value = "排序", notes = "排序")
   private int sort;

   public static ProductionCostAnalysisDTOV2.ProductionCostAnalysisDTOV2Builder builder() {
      return new ProductionCostAnalysisDTOV2.ProductionCostAnalysisDTOV2Builder();
   }

   public ProductionCostAnalysisDTOV2() {
   }

   public ProductionCostAnalysisDTOV2(
      final Integer index,
      final String className,
      final List<MonthCostOrMeteDTO> costInfoList,
      final BigDecimal sumMete,
      final BigDecimal avgMete,
      final int sort
   ) {
      this.index = index;
      this.className = className;
      this.costInfoList = costInfoList;
      this.sumMete = sumMete;
      this.avgMete = avgMete;
      this.sort = sort;
   }

   public Integer getIndex() {
      return this.index;
   }

   public String getClassName() {
      return this.className;
   }

   public List<MonthCostOrMeteDTO> getCostInfoList() {
      return this.costInfoList;
   }

   public BigDecimal getSumMete() {
      return this.sumMete;
   }

   public BigDecimal getAvgMete() {
      return this.avgMete;
   }

   public int getSort() {
      return this.sort;
   }

   public void setIndex(final Integer index) {
      this.index = index;
   }

   public void setClassName(final String className) {
      this.className = className;
   }

   public void setCostInfoList(final List<MonthCostOrMeteDTO> costInfoList) {
      this.costInfoList = costInfoList;
   }

   public void setSumMete(final BigDecimal sumMete) {
      this.sumMete = sumMete;
   }

   public void setAvgMete(final BigDecimal avgMete) {
      this.avgMete = avgMete;
   }

   public void setSort(final int sort) {
      this.sort = sort;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionCostAnalysisDTOV2)) {
         return false;
      }

      ProductionCostAnalysisDTOV2 other = (ProductionCostAnalysisDTOV2)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (this.getSort() != other.getSort()) {
         return false;
      }

      Object this$index = this.getIndex();
      Object other$index = other.getIndex();
      if (this$index == null ? other$index == null : this$index.equals(other$index)) {
         Object this$className = this.getClassName();
         Object other$className = other.getClassName();
         if (this$className == null ? other$className == null : this$className.equals(other$className)) {
            Object this$costInfoList = this.getCostInfoList();
            Object other$costInfoList = other.getCostInfoList();
            if (this$costInfoList == null ? other$costInfoList == null : this$costInfoList.equals(other$costInfoList)) {
               Object this$sumMete = this.getSumMete();
               Object other$sumMete = other.getSumMete();
               if (this$sumMete == null ? other$sumMete == null : this$sumMete.equals(other$sumMete)) {
                  Object this$avgMete = this.getAvgMete();
                  Object other$avgMete = other.getAvgMete();
                  return this$avgMete == null ? other$avgMete == null : this$avgMete.equals(other$avgMete);
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
      return other instanceof ProductionCostAnalysisDTOV2;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      result = result * 59 + this.getSort();
      Object $index = this.getIndex();
      result = result * 59 + ($index == null ? 43 : $index.hashCode());
      Object $className = this.getClassName();
      result = result * 59 + ($className == null ? 43 : $className.hashCode());
      Object $costInfoList = this.getCostInfoList();
      result = result * 59 + ($costInfoList == null ? 43 : $costInfoList.hashCode());
      Object $sumMete = this.getSumMete();
      result = result * 59 + ($sumMete == null ? 43 : $sumMete.hashCode());
      Object $avgMete = this.getAvgMete();
      return result * 59 + ($avgMete == null ? 43 : $avgMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProductionCostAnalysisDTOV2(index="
         + this.getIndex()
         + ", className="
         + this.getClassName()
         + ", costInfoList="
         + this.getCostInfoList()
         + ", sumMete="
         + this.getSumMete()
         + ", avgMete="
         + this.getAvgMete()
         + ", sort="
         + this.getSort()
         + ")";
   }

   public static class ProductionCostAnalysisDTOV2Builder {
      private Integer index;
      private String className;
      private List<MonthCostOrMeteDTO> costInfoList;
      private BigDecimal sumMete;
      private BigDecimal avgMete;
      private int sort;

      ProductionCostAnalysisDTOV2Builder() {
      }

      public ProductionCostAnalysisDTOV2.ProductionCostAnalysisDTOV2Builder index(final Integer index) {
         this.index = index;
         return this;
      }

      public ProductionCostAnalysisDTOV2.ProductionCostAnalysisDTOV2Builder className(final String className) {
         this.className = className;
         return this;
      }

      public ProductionCostAnalysisDTOV2.ProductionCostAnalysisDTOV2Builder costInfoList(final List<MonthCostOrMeteDTO> costInfoList) {
         this.costInfoList = costInfoList;
         return this;
      }

      public ProductionCostAnalysisDTOV2.ProductionCostAnalysisDTOV2Builder sumMete(final BigDecimal sumMete) {
         this.sumMete = sumMete;
         return this;
      }

      public ProductionCostAnalysisDTOV2.ProductionCostAnalysisDTOV2Builder avgMete(final BigDecimal avgMete) {
         this.avgMete = avgMete;
         return this;
      }

      public ProductionCostAnalysisDTOV2.ProductionCostAnalysisDTOV2Builder sort(final int sort) {
         this.sort = sort;
         return this;
      }

      public ProductionCostAnalysisDTOV2 build() {
         return new ProductionCostAnalysisDTOV2(this.index, this.className, this.costInfoList, this.sumMete, this.avgMete, this.sort);
      }

      @Override
      public String toString() {
         return "ProductionCostAnalysisDTOV2.ProductionCostAnalysisDTOV2Builder(index="
            + this.index
            + ", className="
            + this.className
            + ", costInfoList="
            + this.costInfoList
            + ", sumMete="
            + this.sumMete
            + ", avgMete="
            + this.avgMete
            + ", sort="
            + this.sort
            + ")";
      }
   }
}
