package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;

@ApiModel("定额配置构件条件新增编辑Param")
public class MesQuotaConfigArtifactConditionParam {
   @ApiModelProperty("条件")
   @NotNull(groups = {Add.class, Update.class}, message = "条件类型不能为空")
   private Integer conditionEnum;
   @ApiModelProperty("比较运算符1")
   private Integer comparisonOperatorOne;
   @ApiModelProperty("数字1")
   @PositiveOrZero(groups = {Add.class, Update.class}, message = "左边数据不能小于0")
   private BigDecimal numberOne;
   @ApiModelProperty("比较运算符2")
   private Integer comparisonOperatorTwo;
   @ApiModelProperty("数字2")
   @Positive(groups = {Add.class, Update.class}, message = "右边数据不能小于等于0")
   private BigDecimal numberTwo;

   @AssertTrue(groups = {Add.class, Update.class}, message = "左边条件不能为空")
   public boolean isVerifyLeftSide() {
      return this.comparisonOperatorOne == null && this.numberOne == null ? true : this.comparisonOperatorOne != null && this.numberOne != null;
   }

   @AssertTrue(groups = {Add.class, Update.class}, message = "右边条件不能为空")
   public boolean isVerifyRightSide() {
      return this.comparisonOperatorTwo == null && this.numberTwo == null ? true : this.comparisonOperatorTwo != null && this.numberTwo != null;
   }

   @AssertTrue(groups = {Add.class, Update.class}, message = "两边条件不能同时为空")
   public boolean isVerifyLeftRightSide() {
      return this.comparisonOperatorOne != null || this.numberOne != null || this.comparisonOperatorTwo != null || this.numberTwo != null;
   }

   public Integer getConditionEnum() {
      return this.conditionEnum;
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

   public void setConditionEnum(final Integer conditionEnum) {
      this.conditionEnum = conditionEnum;
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

      if (!(o instanceof MesQuotaConfigArtifactConditionParam)) {
         return false;
      }

      MesQuotaConfigArtifactConditionParam other = (MesQuotaConfigArtifactConditionParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$conditionEnum = this.getConditionEnum();
      Object other$conditionEnum = other.getConditionEnum();
      if (this$conditionEnum == null ? other$conditionEnum == null : this$conditionEnum.equals(other$conditionEnum)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesQuotaConfigArtifactConditionParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $conditionEnum = this.getConditionEnum();
      result = result * 59 + ($conditionEnum == null ? 43 : $conditionEnum.hashCode());
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
      return "MesQuotaConfigArtifactConditionParam(conditionEnum="
         + this.getConditionEnum()
         + ", comparisonOperatorOne="
         + this.getComparisonOperatorOne()
         + ", numberOne="
         + this.getNumberOne()
         + ", comparisonOperatorTwo="
         + this.getComparisonOperatorTwo()
         + ", numberTwo="
         + this.getNumberTwo()
         + ")";
   }
}
