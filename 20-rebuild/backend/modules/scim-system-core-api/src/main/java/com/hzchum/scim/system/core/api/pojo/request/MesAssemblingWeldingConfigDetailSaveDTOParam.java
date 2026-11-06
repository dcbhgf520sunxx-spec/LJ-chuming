package com.hzchum.scim.system.core.api.pojo.request;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.EnumValidator;
import com.hzchum.pangu.common.valid.Update;
import com.hzchum.scim.system.core.api.common.enums.ComparisonOperatorEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel("装焊配置详情新增类")
public class MesAssemblingWeldingConfigDetailSaveDTOParam {
   @EnumValidator(groups = {Add.class, Update.class}, value = ComparisonOperatorEnum.class, message = "比较运算符不存在")
   @ApiModelProperty(name = "comparisonOperatorOne", value = "比较运算符1", notes = "比较运算符1")
   private Integer comparisonOperatorOne;
   @ApiModelProperty(name = "numberOne", value = "数字1", notes = "数字1")
   private Integer numberOne;
   @EnumValidator(groups = {Add.class, Update.class}, value = ComparisonOperatorEnum.class, message = "比较运算符不存在")
   @ApiModelProperty(name = "comparisonOperatorTwo", value = "比较运算符2", notes = "比较运算符2")
   private Integer comparisonOperatorTwo;
   @ApiModelProperty(name = "numberTwo", value = "数字2", notes = "数字2")
   private Integer numberTwo;
   @NotNull(groups = {Add.class, Update.class}, message = "编制内单价不能为空")
   @Positive(groups = {Add.class, Update.class}, message = "编制内单价要大于0")
   @ApiModelProperty(name = "organizationInsidePrice", value = "编制内单价(元)", notes = "编制内单价(元)")
   private BigDecimal organizationInsidePrice;
   @NotNull(groups = {Add.class, Update.class}, message = "编制外单价不能为空")
   @Positive(groups = {Add.class, Update.class}, message = "编制外单价要大于0")
   @ApiModelProperty(name = "organizationOutsidePrice", value = "编制外单价(元)", notes = "编制外单价(元)")
   private BigDecimal organizationOutsidePrice;

   public Integer getComparisonOperatorOne() {
      return this.comparisonOperatorOne;
   }

   public Integer getNumberOne() {
      return this.numberOne;
   }

   public Integer getComparisonOperatorTwo() {
      return this.comparisonOperatorTwo;
   }

   public Integer getNumberTwo() {
      return this.numberTwo;
   }

   public BigDecimal getOrganizationInsidePrice() {
      return this.organizationInsidePrice;
   }

   public BigDecimal getOrganizationOutsidePrice() {
      return this.organizationOutsidePrice;
   }

   public void setComparisonOperatorOne(final Integer comparisonOperatorOne) {
      this.comparisonOperatorOne = comparisonOperatorOne;
   }

   public void setNumberOne(final Integer numberOne) {
      this.numberOne = numberOne;
   }

   public void setComparisonOperatorTwo(final Integer comparisonOperatorTwo) {
      this.comparisonOperatorTwo = comparisonOperatorTwo;
   }

   public void setNumberTwo(final Integer numberTwo) {
      this.numberTwo = numberTwo;
   }

   public void setOrganizationInsidePrice(final BigDecimal organizationInsidePrice) {
      this.organizationInsidePrice = organizationInsidePrice;
   }

   public void setOrganizationOutsidePrice(final BigDecimal organizationOutsidePrice) {
      this.organizationOutsidePrice = organizationOutsidePrice;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesAssemblingWeldingConfigDetailSaveDTOParam)) {
         return false;
      }

      MesAssemblingWeldingConfigDetailSaveDTOParam other = (MesAssemblingWeldingConfigDetailSaveDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$comparisonOperatorOne = this.getComparisonOperatorOne();
      Object other$comparisonOperatorOne = other.getComparisonOperatorOne();
      if (this$comparisonOperatorOne == null ? other$comparisonOperatorOne == null : this$comparisonOperatorOne.equals(other$comparisonOperatorOne)) {
         Object this$numberOne = this.getNumberOne();
         Object other$numberOne = other.getNumberOne();
         if (this$numberOne == null ? other$numberOne == null : this$numberOne.equals(other$numberOne)) {
            Object this$comparisonOperatorTwo = this.getComparisonOperatorTwo();
            Object other$comparisonOperatorTwo = other.getComparisonOperatorTwo();
            if (this$comparisonOperatorTwo == null ? other$comparisonOperatorTwo == null : this$comparisonOperatorTwo.equals(other$comparisonOperatorTwo)) {
               Object this$numberTwo = this.getNumberTwo();
               Object other$numberTwo = other.getNumberTwo();
               if (this$numberTwo == null ? other$numberTwo == null : this$numberTwo.equals(other$numberTwo)) {
                  Object this$organizationInsidePrice = this.getOrganizationInsidePrice();
                  Object other$organizationInsidePrice = other.getOrganizationInsidePrice();
                  if (this$organizationInsidePrice == null
                     ? other$organizationInsidePrice == null
                     : this$organizationInsidePrice.equals(other$organizationInsidePrice)) {
                     Object this$organizationOutsidePrice = this.getOrganizationOutsidePrice();
                     Object other$organizationOutsidePrice = other.getOrganizationOutsidePrice();
                     return this$organizationOutsidePrice == null
                        ? other$organizationOutsidePrice == null
                        : this$organizationOutsidePrice.equals(other$organizationOutsidePrice);
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
      return other instanceof MesAssemblingWeldingConfigDetailSaveDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $comparisonOperatorOne = this.getComparisonOperatorOne();
      result = result * 59 + ($comparisonOperatorOne == null ? 43 : $comparisonOperatorOne.hashCode());
      Object $numberOne = this.getNumberOne();
      result = result * 59 + ($numberOne == null ? 43 : $numberOne.hashCode());
      Object $comparisonOperatorTwo = this.getComparisonOperatorTwo();
      result = result * 59 + ($comparisonOperatorTwo == null ? 43 : $comparisonOperatorTwo.hashCode());
      Object $numberTwo = this.getNumberTwo();
      result = result * 59 + ($numberTwo == null ? 43 : $numberTwo.hashCode());
      Object $organizationInsidePrice = this.getOrganizationInsidePrice();
      result = result * 59 + ($organizationInsidePrice == null ? 43 : $organizationInsidePrice.hashCode());
      Object $organizationOutsidePrice = this.getOrganizationOutsidePrice();
      return result * 59 + ($organizationOutsidePrice == null ? 43 : $organizationOutsidePrice.hashCode());
   }

   @Override
   public String toString() {
      return "MesAssemblingWeldingConfigDetailSaveDTOParam(comparisonOperatorOne="
         + this.getComparisonOperatorOne()
         + ", numberOne="
         + this.getNumberOne()
         + ", comparisonOperatorTwo="
         + this.getComparisonOperatorTwo()
         + ", numberTwo="
         + this.getNumberTwo()
         + ", organizationInsidePrice="
         + this.getOrganizationInsidePrice()
         + ", organizationOutsidePrice="
         + this.getOrganizationOutsidePrice()
         + ")";
   }
}
