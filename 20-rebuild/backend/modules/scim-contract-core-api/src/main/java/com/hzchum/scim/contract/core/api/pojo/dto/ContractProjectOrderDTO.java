package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("项目订单统计返回类")
public class ContractProjectOrderDTO {
   @ApiModelProperty("月份")
   Integer month;
   @ApiModelProperty("业务类型 1加工承揽 2项目承包")
   Integer businessType;
   @ApiModelProperty("项目数量")
   Integer count;
   @ApiModelProperty("合同总额(万元)")
   BigDecimal contractAmount;

   public Integer getMonth() {
      return this.month;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public Integer getCount() {
      return this.count;
   }

   public BigDecimal getContractAmount() {
      return this.contractAmount;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setCount(final Integer count) {
      this.count = count;
   }

   public void setContractAmount(final BigDecimal contractAmount) {
      this.contractAmount = contractAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectOrderDTO)) {
         return false;
      }

      ContractProjectOrderDTO other = (ContractProjectOrderDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$month = this.getMonth();
      Object other$month = other.getMonth();
      if (this$month == null ? other$month == null : this$month.equals(other$month)) {
         Object this$businessType = this.getBusinessType();
         Object other$businessType = other.getBusinessType();
         if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
            Object this$count = this.getCount();
            Object other$count = other.getCount();
            if (this$count == null ? other$count == null : this$count.equals(other$count)) {
               Object this$contractAmount = this.getContractAmount();
               Object other$contractAmount = other.getContractAmount();
               return this$contractAmount == null ? other$contractAmount == null : this$contractAmount.equals(other$contractAmount);
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
      return other instanceof ContractProjectOrderDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $count = this.getCount();
      result = result * 59 + ($count == null ? 43 : $count.hashCode());
      Object $contractAmount = this.getContractAmount();
      return result * 59 + ($contractAmount == null ? 43 : $contractAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectOrderDTO(month="
         + this.getMonth()
         + ", businessType="
         + this.getBusinessType()
         + ", count="
         + this.getCount()
         + ", contractAmount="
         + this.getContractAmount()
         + ")";
   }
}
