package com.hzchum.scim.contract.core.api.pojo.dtoParam.finance;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

public class ContractManagementCostDtoParam {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "projectAttribute", value = "项目类型", notes = "项目类型")
   private Integer projectAttribute;
   @NotNull(message = "合同额不能为空")
   @DecimalMin(value = "0", message = "合同额必须大于0")
   @ApiModelProperty(name = "amountMax", value = "合同额(大)", notes = "合同额(大)")
   private BigDecimal amountMax;
   @NotNull(message = "合同额不能为空")
   @DecimalMin(value = "0", message = "合同额必须大于0")
   @ApiModelProperty(name = "amountMin", value = "合同额(小)", notes = "合同额(小)")
   private BigDecimal amountMin;
   @NotNull(message = "管理费不能为空")
   @DecimalMax(value = "100", message = "管理费超出范围")
   @DecimalMin(value = "0", message = "管理费超出范围")
   @ApiModelProperty(name = "cashDeposit", value = "管理费", notes = "管理费")
   private BigDecimal cashDeposit;
   @ApiModelProperty(name = "status", value = "状态 0启用1禁用", notes = "状态 0启用1禁用")
   private Integer status;

   public static ContractManagementCostDtoParam.ContractManagementCostDtoParamBuilder builder() {
      return new ContractManagementCostDtoParam.ContractManagementCostDtoParamBuilder();
   }

   public ContractManagementCostDtoParam() {
   }

   public ContractManagementCostDtoParam(
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

      if (!(o instanceof ContractManagementCostDtoParam)) {
         return false;
      }

      ContractManagementCostDtoParam other = (ContractManagementCostDtoParam)o;
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
      return other instanceof ContractManagementCostDtoParam;
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
      return "ContractManagementCostDtoParam(id="
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

   public static class ContractManagementCostDtoParamBuilder {
      private Long id;
      private Integer projectAttribute;
      private BigDecimal amountMax;
      private BigDecimal amountMin;
      private BigDecimal cashDeposit;
      private Integer status;

      ContractManagementCostDtoParamBuilder() {
      }

      public ContractManagementCostDtoParam.ContractManagementCostDtoParamBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractManagementCostDtoParam.ContractManagementCostDtoParamBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public ContractManagementCostDtoParam.ContractManagementCostDtoParamBuilder amountMax(final BigDecimal amountMax) {
         this.amountMax = amountMax;
         return this;
      }

      public ContractManagementCostDtoParam.ContractManagementCostDtoParamBuilder amountMin(final BigDecimal amountMin) {
         this.amountMin = amountMin;
         return this;
      }

      public ContractManagementCostDtoParam.ContractManagementCostDtoParamBuilder cashDeposit(final BigDecimal cashDeposit) {
         this.cashDeposit = cashDeposit;
         return this;
      }

      public ContractManagementCostDtoParam.ContractManagementCostDtoParamBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ContractManagementCostDtoParam build() {
         return new ContractManagementCostDtoParam(this.id, this.projectAttribute, this.amountMax, this.amountMin, this.cashDeposit, this.status);
      }

      @Override
      public String toString() {
         return "ContractManagementCostDtoParam.ContractManagementCostDtoParamBuilder(id="
            + this.id
            + ", projectAttribute="
            + this.projectAttribute
            + ", amountMax="
            + this.amountMax
            + ", amountMin="
            + this.amountMin
            + ", cashDeposit="
            + this.cashDeposit
            + ", status="
            + this.status
            + ")";
      }
   }
}
