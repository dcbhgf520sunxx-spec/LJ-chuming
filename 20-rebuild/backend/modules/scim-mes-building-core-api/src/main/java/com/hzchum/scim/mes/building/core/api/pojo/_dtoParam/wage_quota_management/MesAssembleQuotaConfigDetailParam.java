package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_quota_management;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel("部件定额配置详情新增修改参数")
public class MesAssembleQuotaConfigDetailParam {
   @ApiModelProperty("截面高度比较运算符1")
   private Integer sectionHeightComparisonOperatorOne;
   @ApiModelProperty("截面高度数字1")
   private BigDecimal sectionHeightNumberOne;
   @ApiModelProperty("截面高度比较运算符2")
   private Integer sectionHeightComparisonOperatorTwo;
   @ApiModelProperty("截面高度数字2")
   private BigDecimal sectionHeightNumberTwo;
   @ApiModelProperty("腹板厚度比较运算符1")
   private Integer webThicknessComparisonOperatorOne;
   @ApiModelProperty("腹板厚度数字1")
   private BigDecimal webThicknessNumberOne;
   @ApiModelProperty("腹板厚度比较运算符2")
   private Integer webThicknessComparisonOperatorTwo;
   @ApiModelProperty("腹板厚度数字2")
   private BigDecimal webThicknessNumberTwo;
   @ApiModelProperty("单价(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "单价不能为空")
   @Positive(groups = {Add.class, Update.class}, message = "单价不能小于等于0")
   private BigDecimal price;

   public Integer getSectionHeightComparisonOperatorOne() {
      return this.sectionHeightComparisonOperatorOne;
   }

   public BigDecimal getSectionHeightNumberOne() {
      return this.sectionHeightNumberOne;
   }

   public Integer getSectionHeightComparisonOperatorTwo() {
      return this.sectionHeightComparisonOperatorTwo;
   }

   public BigDecimal getSectionHeightNumberTwo() {
      return this.sectionHeightNumberTwo;
   }

   public Integer getWebThicknessComparisonOperatorOne() {
      return this.webThicknessComparisonOperatorOne;
   }

   public BigDecimal getWebThicknessNumberOne() {
      return this.webThicknessNumberOne;
   }

   public Integer getWebThicknessComparisonOperatorTwo() {
      return this.webThicknessComparisonOperatorTwo;
   }

   public BigDecimal getWebThicknessNumberTwo() {
      return this.webThicknessNumberTwo;
   }

   public BigDecimal getPrice() {
      return this.price;
   }

   public void setSectionHeightComparisonOperatorOne(final Integer sectionHeightComparisonOperatorOne) {
      this.sectionHeightComparisonOperatorOne = sectionHeightComparisonOperatorOne;
   }

   public void setSectionHeightNumberOne(final BigDecimal sectionHeightNumberOne) {
      this.sectionHeightNumberOne = sectionHeightNumberOne;
   }

   public void setSectionHeightComparisonOperatorTwo(final Integer sectionHeightComparisonOperatorTwo) {
      this.sectionHeightComparisonOperatorTwo = sectionHeightComparisonOperatorTwo;
   }

   public void setSectionHeightNumberTwo(final BigDecimal sectionHeightNumberTwo) {
      this.sectionHeightNumberTwo = sectionHeightNumberTwo;
   }

   public void setWebThicknessComparisonOperatorOne(final Integer webThicknessComparisonOperatorOne) {
      this.webThicknessComparisonOperatorOne = webThicknessComparisonOperatorOne;
   }

   public void setWebThicknessNumberOne(final BigDecimal webThicknessNumberOne) {
      this.webThicknessNumberOne = webThicknessNumberOne;
   }

   public void setWebThicknessComparisonOperatorTwo(final Integer webThicknessComparisonOperatorTwo) {
      this.webThicknessComparisonOperatorTwo = webThicknessComparisonOperatorTwo;
   }

   public void setWebThicknessNumberTwo(final BigDecimal webThicknessNumberTwo) {
      this.webThicknessNumberTwo = webThicknessNumberTwo;
   }

   public void setPrice(final BigDecimal price) {
      this.price = price;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesAssembleQuotaConfigDetailParam)) {
         return false;
      }

      MesAssembleQuotaConfigDetailParam other = (MesAssembleQuotaConfigDetailParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$sectionHeightComparisonOperatorOne = this.getSectionHeightComparisonOperatorOne();
      Object other$sectionHeightComparisonOperatorOne = other.getSectionHeightComparisonOperatorOne();
      if (this$sectionHeightComparisonOperatorOne == null
         ? other$sectionHeightComparisonOperatorOne == null
         : this$sectionHeightComparisonOperatorOne.equals(other$sectionHeightComparisonOperatorOne)) {
         Object this$sectionHeightComparisonOperatorTwo = this.getSectionHeightComparisonOperatorTwo();
         Object other$sectionHeightComparisonOperatorTwo = other.getSectionHeightComparisonOperatorTwo();
         if (this$sectionHeightComparisonOperatorTwo == null
            ? other$sectionHeightComparisonOperatorTwo == null
            : this$sectionHeightComparisonOperatorTwo.equals(other$sectionHeightComparisonOperatorTwo)) {
            Object this$webThicknessComparisonOperatorOne = this.getWebThicknessComparisonOperatorOne();
            Object other$webThicknessComparisonOperatorOne = other.getWebThicknessComparisonOperatorOne();
            if (this$webThicknessComparisonOperatorOne == null
               ? other$webThicknessComparisonOperatorOne == null
               : this$webThicknessComparisonOperatorOne.equals(other$webThicknessComparisonOperatorOne)) {
               Object this$webThicknessComparisonOperatorTwo = this.getWebThicknessComparisonOperatorTwo();
               Object other$webThicknessComparisonOperatorTwo = other.getWebThicknessComparisonOperatorTwo();
               if (this$webThicknessComparisonOperatorTwo == null
                  ? other$webThicknessComparisonOperatorTwo == null
                  : this$webThicknessComparisonOperatorTwo.equals(other$webThicknessComparisonOperatorTwo)) {
                  Object this$sectionHeightNumberOne = this.getSectionHeightNumberOne();
                  Object other$sectionHeightNumberOne = other.getSectionHeightNumberOne();
                  if (this$sectionHeightNumberOne == null
                     ? other$sectionHeightNumberOne == null
                     : this$sectionHeightNumberOne.equals(other$sectionHeightNumberOne)) {
                     Object this$sectionHeightNumberTwo = this.getSectionHeightNumberTwo();
                     Object other$sectionHeightNumberTwo = other.getSectionHeightNumberTwo();
                     if (this$sectionHeightNumberTwo == null
                        ? other$sectionHeightNumberTwo == null
                        : this$sectionHeightNumberTwo.equals(other$sectionHeightNumberTwo)) {
                        Object this$webThicknessNumberOne = this.getWebThicknessNumberOne();
                        Object other$webThicknessNumberOne = other.getWebThicknessNumberOne();
                        if (this$webThicknessNumberOne == null
                           ? other$webThicknessNumberOne == null
                           : this$webThicknessNumberOne.equals(other$webThicknessNumberOne)) {
                           Object this$webThicknessNumberTwo = this.getWebThicknessNumberTwo();
                           Object other$webThicknessNumberTwo = other.getWebThicknessNumberTwo();
                           if (this$webThicknessNumberTwo == null
                              ? other$webThicknessNumberTwo == null
                              : this$webThicknessNumberTwo.equals(other$webThicknessNumberTwo)) {
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
      return other instanceof MesAssembleQuotaConfigDetailParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $sectionHeightComparisonOperatorOne = this.getSectionHeightComparisonOperatorOne();
      result = result * 59 + ($sectionHeightComparisonOperatorOne == null ? 43 : $sectionHeightComparisonOperatorOne.hashCode());
      Object $sectionHeightComparisonOperatorTwo = this.getSectionHeightComparisonOperatorTwo();
      result = result * 59 + ($sectionHeightComparisonOperatorTwo == null ? 43 : $sectionHeightComparisonOperatorTwo.hashCode());
      Object $webThicknessComparisonOperatorOne = this.getWebThicknessComparisonOperatorOne();
      result = result * 59 + ($webThicknessComparisonOperatorOne == null ? 43 : $webThicknessComparisonOperatorOne.hashCode());
      Object $webThicknessComparisonOperatorTwo = this.getWebThicknessComparisonOperatorTwo();
      result = result * 59 + ($webThicknessComparisonOperatorTwo == null ? 43 : $webThicknessComparisonOperatorTwo.hashCode());
      Object $sectionHeightNumberOne = this.getSectionHeightNumberOne();
      result = result * 59 + ($sectionHeightNumberOne == null ? 43 : $sectionHeightNumberOne.hashCode());
      Object $sectionHeightNumberTwo = this.getSectionHeightNumberTwo();
      result = result * 59 + ($sectionHeightNumberTwo == null ? 43 : $sectionHeightNumberTwo.hashCode());
      Object $webThicknessNumberOne = this.getWebThicknessNumberOne();
      result = result * 59 + ($webThicknessNumberOne == null ? 43 : $webThicknessNumberOne.hashCode());
      Object $webThicknessNumberTwo = this.getWebThicknessNumberTwo();
      result = result * 59 + ($webThicknessNumberTwo == null ? 43 : $webThicknessNumberTwo.hashCode());
      Object $price = this.getPrice();
      return result * 59 + ($price == null ? 43 : $price.hashCode());
   }

   @Override
   public String toString() {
      return "MesAssembleQuotaConfigDetailParam(sectionHeightComparisonOperatorOne="
         + this.getSectionHeightComparisonOperatorOne()
         + ", sectionHeightNumberOne="
         + this.getSectionHeightNumberOne()
         + ", sectionHeightComparisonOperatorTwo="
         + this.getSectionHeightComparisonOperatorTwo()
         + ", sectionHeightNumberTwo="
         + this.getSectionHeightNumberTwo()
         + ", webThicknessComparisonOperatorOne="
         + this.getWebThicknessComparisonOperatorOne()
         + ", webThicknessNumberOne="
         + this.getWebThicknessNumberOne()
         + ", webThicknessComparisonOperatorTwo="
         + this.getWebThicknessComparisonOperatorTwo()
         + ", webThicknessNumberTwo="
         + this.getWebThicknessNumberTwo()
         + ", price="
         + this.getPrice()
         + ")";
   }
}
