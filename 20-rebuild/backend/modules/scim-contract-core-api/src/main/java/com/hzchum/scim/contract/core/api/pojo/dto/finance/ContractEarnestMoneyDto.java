package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;

public class ContractEarnestMoneyDto {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "projectAttribute", value = "项目类型", notes = "项目类型")
   private Integer projectAttribute;
   @NotNull(message = "合同额不能为空")
   @ApiModelProperty(name = "amountMax", value = "合同额(大)", notes = "合同额(大)")
   private BigDecimal amountMax;
   @NotNull(message = "合同额不能为空")
   @ApiModelProperty(name = "amountMin", value = "合同额(小)", notes = "合同额(小)")
   private BigDecimal amountMin;
   @ApiModelProperty(name = "cashDeposit", value = "保证金", notes = "保证金")
   private BigDecimal cashDeposit;
   @ApiModelProperty(name = "status", value = "状态 0启用1禁用", notes = "状态 0启用1禁用")
   private Integer status;

   public ContractEarnestMoneyDto() {
   }

   public ContractEarnestMoneyDto(
      final Long id, final Integer projectAttribute, final BigDecimal amountMax, final BigDecimal amountMin, final BigDecimal cashDeposit, final Integer status
   ) {
      this.id = id;
      this.projectAttribute = projectAttribute;
      this.amountMax = amountMax;
      this.amountMin = amountMin;
      this.cashDeposit = cashDeposit;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public Integer getProjectAttribute() {
      return this.projectAttribute;
   }

   public BigDecimal getAmountMax() {
      return this.amountMax;
   }

   public BigDecimal getAmountMin() {
      return this.amountMin;
   }

   public BigDecimal getCashDeposit() {
      return this.cashDeposit;
   }

   public Integer getStatus() {
      return this.status;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setProjectAttribute(final Integer projectAttribute) {
      this.projectAttribute = projectAttribute;
   }

   public void setAmountMax(final BigDecimal amountMax) {
      this.amountMax = amountMax;
   }

   public void setAmountMin(final BigDecimal amountMin) {
      this.amountMin = amountMin;
   }

   public void setCashDeposit(final BigDecimal cashDeposit) {
      this.cashDeposit = cashDeposit;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractEarnestMoneyDto)) {
         return false;
      }

      ContractEarnestMoneyDto other = (ContractEarnestMoneyDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectAttribute = this.getProjectAttribute();
         Object other$projectAttribute = other.getProjectAttribute();
         if (this$projectAttribute == null ? other$projectAttribute == null : this$projectAttribute.equals(other$projectAttribute)) {
            Object this$status = this.getStatus();
            Object other$status = other.getStatus();
            if (this$status == null ? other$status == null : this$status.equals(other$status)) {
               Object this$amountMax = this.getAmountMax();
               Object other$amountMax = other.getAmountMax();
               if (this$amountMax == null ? other$amountMax == null : this$amountMax.equals(other$amountMax)) {
                  Object this$amountMin = this.getAmountMin();
                  Object other$amountMin = other.getAmountMin();
                  if (this$amountMin == null ? other$amountMin == null : this$amountMin.equals(other$amountMin)) {
                     Object this$cashDeposit = this.getCashDeposit();
                     Object other$cashDeposit = other.getCashDeposit();
                     return this$cashDeposit == null ? other$cashDeposit == null : this$cashDeposit.equals(other$cashDeposit);
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
      return other instanceof ContractEarnestMoneyDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectAttribute = this.getProjectAttribute();
      result = result * 59 + ($projectAttribute == null ? 43 : $projectAttribute.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $amountMax = this.getAmountMax();
      result = result * 59 + ($amountMax == null ? 43 : $amountMax.hashCode());
      Object $amountMin = this.getAmountMin();
      result = result * 59 + ($amountMin == null ? 43 : $amountMin.hashCode());
      Object $cashDeposit = this.getCashDeposit();
      return result * 59 + ($cashDeposit == null ? 43 : $cashDeposit.hashCode());
   }

   @Override
   public String toString() {
      return "ContractEarnestMoneyDto(id="
         + this.getId()
         + ", projectAttribute="
         + this.getProjectAttribute()
         + ", amountMax="
         + this.getAmountMax()
         + ", amountMin="
         + this.getAmountMin()
         + ", cashDeposit="
         + this.getCashDeposit()
         + ", status="
         + this.getStatus()
         + ")";
   }
}
