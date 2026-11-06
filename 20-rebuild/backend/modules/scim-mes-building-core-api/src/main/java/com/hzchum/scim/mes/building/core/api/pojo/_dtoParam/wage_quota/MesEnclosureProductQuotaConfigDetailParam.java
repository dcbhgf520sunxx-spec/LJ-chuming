package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

@ApiModel("围护产品定额配置详情新增修改Param")
public class MesEnclosureProductQuotaConfigDetailParam {
   @ApiModelProperty("比较运算符1")
   private Integer comparisonOperatorOne;
   @ApiModelProperty("数字1")
   private BigDecimal numberOne;
   @ApiModelProperty("比较运算符2")
   private Integer comparisonOperatorTwo;
   @ApiModelProperty("数字2")
   private BigDecimal numberTwo;
   @ApiModelProperty("单价(元/米)")
   @NotNull(groups = {Add.class, Update.class}, message = "单价不能为空")
   private BigDecimal price;

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

   public BigDecimal getPrice() {
      return this.price;
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

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesEnclosureProductQuotaConfigDetailParam)) {
         return false;
      }

      MesEnclosureProductQuotaConfigDetailParam other = (MesEnclosureProductQuotaConfigDetailParam)o;
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
               if (this$numberTwo == null ? other$numberTwo == null : this$numberTwo.equals(other$numberTwo)) {
                  Object this$price = this.getPrice();
                  Object other$price = other.getPrice();
                  return this$price == null ? other$price == null : this$price.equals(other$price);
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
      return other instanceof MesEnclosureProductQuotaConfigDetailParam;
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
      result = result * 59 + ($numberTwo == null ? 43 : $numberTwo.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "MesEnclosureProductQuotaConfigDetailParam(comparisonOperatorOne="
         + this.getComparisonOperatorOne()
         + ", numberOne="
         + this.getNumberOne()
         + ", comparisonOperatorTwo="
         + this.getComparisonOperatorTwo()
         + ", numberTwo="
         + this.getNumberTwo()
         + ", price="
         + this.getPrice()
         + ")";
   }
}
