package com.hzchum.scim.mes.building.core.api.pojo._dto.quota_config;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.collection.CollUtil;
import com.google.common.base.Preconditions;
import com.hzchum.scim.mes.building.core.api.utils.MaxAndMin;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;

@ApiModel("定额配置条件")
public class MesQuotaConfigCondition {
   @ApiModelProperty("比较运算符1")
   private Integer comparisonOperatorOne;
   @ApiModelProperty("数字1")
   private BigDecimal numberOne;
   @ApiModelProperty("比较运算符2")
   private Integer comparisonOperatorTwo;
   @ApiModelProperty("数字2")
   private BigDecimal numberTwo;

   public static Boolean isIntersection(List<MesQuotaConfigCondition> list) {
      Preconditions.checkArgument(CollUtil.isNotEmpty(list), "参数不能为空");
      if (list.size() > 1) {
         for (int i = 0; i < list.size() - 1; i++) {
            MesQuotaConfigCondition iDetail = list.get(i);
            Preconditions.checkArgument(BeanUtil.isNotEmpty(iDetail), "范围不能为空");
            MaxAndMin imm = MaxAndMin.getMaxAndMin(
               iDetail.getComparisonOperatorOne(), iDetail.getNumberOne(), iDetail.getComparisonOperatorTwo(), iDetail.getNumberTwo()
            );

            for (int j = i + 1; j < list.size(); j++) {
               MesQuotaConfigCondition jDetail = list.get(j);
               Preconditions.checkArgument(BeanUtil.isNotEmpty(jDetail), "范围不能为空");
               MaxAndMin jmm = MaxAndMin.getMaxAndMin(
                  jDetail.getComparisonOperatorOne(), jDetail.getNumberOne(), jDetail.getComparisonOperatorTwo(), jDetail.getNumberTwo()
               );
               if (MaxAndMin.isTwoRegionIntersection(imm.getMin(), imm.getMax(), jmm.getMin(), jmm.getMax())) {
                  return true;
               }
            }
         }
      }

      MesQuotaConfigCondition detail = list.get(0);
      Preconditions.checkArgument(BeanUtil.isNotEmpty(detail), "范围不能为空");
      MaxAndMin.getMaxAndMin(detail.getComparisonOperatorOne(), detail.getNumberOne(), detail.getComparisonOperatorTwo(), detail.getNumberTwo());
      return false;
   }

   public static MesQuotaConfigCondition.MesQuotaConfigConditionBuilder builder() {
      return new MesQuotaConfigCondition.MesQuotaConfigConditionBuilder();
   }

   public Integer getComparisonOperatorOne() {
      return this.comparisonOperatorOne;
   }

   public BigDecimal getNumberOne() {
      return this.numberOne;
   }

   public Integer getComparisonOperatorTwo() {
      return this.comparisonOperatorTwo;
   }

   public BigDecimal getNumberTwo() {
      return this.numberTwo;
   }

   public void setComparisonOperatorOne(final Integer comparisonOperatorOne) {
      this.comparisonOperatorOne = comparisonOperatorOne;
   }

   public void setNumberOne(final BigDecimal numberOne) {
      this.numberOne = numberOne;
   }

   public void setComparisonOperatorTwo(final Integer comparisonOperatorTwo) {
      this.comparisonOperatorTwo = comparisonOperatorTwo;
   }

   public void setNumberTwo(final BigDecimal numberTwo) {
      this.numberTwo = numberTwo;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesQuotaConfigCondition)) {
         return false;
      }

      MesQuotaConfigCondition other = (MesQuotaConfigCondition)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$comparisonOperatorOne = this.getComparisonOperatorOne();
      Object other$comparisonOperatorOne = other.getComparisonOperatorOne();
      if (this$comparisonOperatorOne == null ? other$comparisonOperatorOne == null : this$comparisonOperatorOne.equals(other$comparisonOperatorOne)) {
         Object this$comparisonOperatorTwo = this.getComparisonOperatorTwo();
         Object other$comparisonOperatorTwo = other.getComparisonOperatorTwo();
         if (this$comparisonOperatorTwo == null ? other$comparisonOperatorTwo == null : this$comparisonOperatorTwo.equals(other$comparisonOperatorTwo)) {
            Object this$numberOne = this.getNumberOne();
            Object other$numberOne = other.getNumberOne();
            if (this$numberOne == null ? other$numberOne == null : this$numberOne.equals(other$numberOne)) {
               Object this$numberTwo = this.getNumberTwo();
               Object other$numberTwo = other.getNumberTwo();
               return this$numberTwo == null ? other$numberTwo == null : this$numberTwo.equals(other$numberTwo);
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
      return other instanceof MesQuotaConfigCondition;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $comparisonOperatorOne = this.getComparisonOperatorOne();
      result = result * 59 + ($comparisonOperatorOne == null ? 43 : $comparisonOperatorOne.hashCode());
      Object $comparisonOperatorTwo = this.getComparisonOperatorTwo();
      result = result * 59 + ($comparisonOperatorTwo == null ? 43 : $comparisonOperatorTwo.hashCode());
      Object $numberOne = this.getNumberOne();
      result = result * 59 + ($numberOne == null ? 43 : $numberOne.hashCode());
      Object $numberTwo = this.getNumberTwo();
      return result * 59 + ($numberTwo == null ? 43 : $numberTwo.hashCode());
   }

   @Override
   public String toString() {
      return "MesQuotaConfigCondition(comparisonOperatorOne="
         + this.getComparisonOperatorOne()
         + ", numberOne="
         + this.getNumberOne()
         + ", comparisonOperatorTwo="
         + this.getComparisonOperatorTwo()
         + ", numberTwo="
         + this.getNumberTwo()
         + ")";
   }

   public MesQuotaConfigCondition() {
   }

   public MesQuotaConfigCondition(
      final Integer comparisonOperatorOne, final BigDecimal numberOne, final Integer comparisonOperatorTwo, final BigDecimal numberTwo
   ) {
      this.comparisonOperatorOne = comparisonOperatorOne;
      this.numberOne = numberOne;
      this.comparisonOperatorTwo = comparisonOperatorTwo;
      this.numberTwo = numberTwo;
   }

   public static class MesQuotaConfigConditionBuilder {
      private Integer comparisonOperatorOne;
      private BigDecimal numberOne;
      private Integer comparisonOperatorTwo;
      private BigDecimal numberTwo;

      MesQuotaConfigConditionBuilder() {
      }

      public MesQuotaConfigCondition.MesQuotaConfigConditionBuilder comparisonOperatorOne(final Integer comparisonOperatorOne) {
         this.comparisonOperatorOne = comparisonOperatorOne;
         return this;
      }

      public MesQuotaConfigCondition.MesQuotaConfigConditionBuilder numberOne(final BigDecimal numberOne) {
         this.numberOne = numberOne;
         return this;
      }

      public MesQuotaConfigCondition.MesQuotaConfigConditionBuilder comparisonOperatorTwo(final Integer comparisonOperatorTwo) {
         this.comparisonOperatorTwo = comparisonOperatorTwo;
         return this;
      }

      public MesQuotaConfigCondition.MesQuotaConfigConditionBuilder numberTwo(final BigDecimal numberTwo) {
         this.numberTwo = numberTwo;
         return this;
      }

      public MesQuotaConfigCondition build() {
         return new MesQuotaConfigCondition(this.comparisonOperatorOne, this.numberOne, this.comparisonOperatorTwo, this.numberTwo);
      }

      @Override
      public String toString() {
         return "MesQuotaConfigCondition.MesQuotaConfigConditionBuilder(comparisonOperatorOne="
            + this.comparisonOperatorOne
            + ", numberOne="
            + this.numberOne
            + ", comparisonOperatorTwo="
            + this.comparisonOperatorTwo
            + ", numberTwo="
            + this.numberTwo
            + ")";
      }
   }
}
