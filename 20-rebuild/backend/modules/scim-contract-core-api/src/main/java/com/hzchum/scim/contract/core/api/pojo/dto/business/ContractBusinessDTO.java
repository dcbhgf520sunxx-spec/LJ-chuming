package com.hzchum.scim.contract.core.api.pojo.dto.business;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(description = "客户交易汇总")
public class ContractBusinessDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("客户名称")
   private String name;
   @ApiModelProperty("订单类型")
   private Integer businessType;
   @ApiModelProperty("订单数")
   private Integer quantity;
   @ApiModelProperty("累计合同额")
   private BigDecimal totalContractAmount;
   @ApiModelProperty("累计结算额")
   private BigDecimal totalSettlementAmount;

   public String getName() {
      return this.name;
   }

   public Integer getBusinessType() {
      return this.businessType;
   }

   public Integer getQuantity() {
      return this.quantity;
   }

   public BigDecimal getTotalContractAmount() {
      return this.totalContractAmount;
   }

   public BigDecimal getTotalSettlementAmount() {
      return this.totalSettlementAmount;
   }

   public void setName(final String name) {
      this.name = name;
   }

   public void setBusinessType(final Integer businessType) {
      this.businessType = businessType;
   }

   public void setQuantity(final Integer quantity) {
      this.quantity = quantity;
   }

   public void setTotalContractAmount(final BigDecimal totalContractAmount) {
      this.totalContractAmount = totalContractAmount;
   }

   public void setTotalSettlementAmount(final BigDecimal totalSettlementAmount) {
      this.totalSettlementAmount = totalSettlementAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractBusinessDTO)) {
         return false;
      }

      ContractBusinessDTO other = (ContractBusinessDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$businessType = this.getBusinessType();
      Object other$businessType = other.getBusinessType();
      if (this$businessType == null ? other$businessType == null : this$businessType.equals(other$businessType)) {
         Object this$quantity = this.getQuantity();
         Object other$quantity = other.getQuantity();
         if (this$quantity == null ? other$quantity == null : this$quantity.equals(other$quantity)) {
            Object this$name = this.getName();
            Object other$name = other.getName();
            if (this$name == null ? other$name == null : this$name.equals(other$name)) {
               Object this$totalContractAmount = this.getTotalContractAmount();
               Object other$totalContractAmount = other.getTotalContractAmount();
               if (this$totalContractAmount == null ? other$totalContractAmount == null : this$totalContractAmount.equals(other$totalContractAmount)) {
                  Object this$totalSettlementAmount = this.getTotalSettlementAmount();
                  Object other$totalSettlementAmount = other.getTotalSettlementAmount();
                  return this$totalSettlementAmount == null
                     ? other$totalSettlementAmount == null
                     : this$totalSettlementAmount.equals(other$totalSettlementAmount);
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
      return other instanceof ContractBusinessDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $businessType = this.getBusinessType();
      result = result * 59 + ($businessType == null ? 43 : $businessType.hashCode());
      Object $quantity = this.getQuantity();
      result = result * 59 + ($quantity == null ? 43 : $quantity.hashCode());
      Object $name = this.getName();
      result = result * 59 + ($name == null ? 43 : $name.hashCode());
      Object $totalContractAmount = this.getTotalContractAmount();
      result = result * 59 + ($totalContractAmount == null ? 43 : $totalContractAmount.hashCode());
      Object $totalSettlementAmount = this.getTotalSettlementAmount();
      return result * 59 + ($totalSettlementAmount == null ? 43 : $totalSettlementAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ContractBusinessDTO(name="
         + this.getName()
         + ", businessType="
         + this.getBusinessType()
         + ", quantity="
         + this.getQuantity()
         + ", totalContractAmount="
         + this.getTotalContractAmount()
         + ", totalSettlementAmount="
         + this.getTotalSettlementAmount()
         + ")";
   }
}
