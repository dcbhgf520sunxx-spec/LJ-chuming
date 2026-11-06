package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class ContractManagementCostDto {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "userId", value = "创建人", notes = "创建人")
   private Long userId;
   @ApiModelProperty(name = "projectAttribute", value = "项目类型", notes = "项目类型")
   private Integer projectAttribute;
   @ApiModelProperty(name = "amountMax", value = "合同额(大)", notes = "合同额(大)")
   private BigDecimal amountMax;
   @ApiModelProperty(name = "amountMin", value = "合同额(小)", notes = "合同额(小)")
   private BigDecimal amountMin;
   @ApiModelProperty(name = "cashDeposit", value = "保证金", notes = "保证金")
   private BigDecimal cashDeposit;
   @ApiModelProperty(name = "status", value = "状态 0启用1禁用", notes = "状态 0启用1禁用")
   private Integer status;

   public static ContractManagementCostDto.ContractManagementCostDtoBuilder builder() {
      return new ContractManagementCostDto.ContractManagementCostDtoBuilder();
   }

   public ContractManagementCostDto() {
   }

   public ContractManagementCostDto(
      final Long id,
      final Long userId,
      final Integer projectAttribute,
      final BigDecimal amountMax,
      final BigDecimal amountMin,
      final BigDecimal cashDeposit,
      final Integer status
   ) {
      this.id = id;
      this.userId = userId;
      this.projectAttribute = projectAttribute;
      this.amountMax = amountMax;
      this.amountMin = amountMin;
      this.cashDeposit = cashDeposit;
      this.status = status;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
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

   public void setUserId(final Long userId) {
      this.userId = userId;
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

      if (!(o instanceof ContractManagementCostDto)) {
         return false;
      }

      ContractManagementCostDto other = (ContractManagementCostDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ContractManagementCostDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
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
      return "ContractManagementCostDto(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
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

   public static class ContractManagementCostDtoBuilder {
      private Long id;
      private Long userId;
      private Integer projectAttribute;
      private BigDecimal amountMax;
      private BigDecimal amountMin;
      private BigDecimal cashDeposit;
      private Integer status;

      ContractManagementCostDtoBuilder() {
      }

      public ContractManagementCostDto.ContractManagementCostDtoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractManagementCostDto.ContractManagementCostDtoBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractManagementCostDto.ContractManagementCostDtoBuilder projectAttribute(final Integer projectAttribute) {
         this.projectAttribute = projectAttribute;
         return this;
      }

      public ContractManagementCostDto.ContractManagementCostDtoBuilder amountMax(final BigDecimal amountMax) {
         this.amountMax = amountMax;
         return this;
      }

      public ContractManagementCostDto.ContractManagementCostDtoBuilder amountMin(final BigDecimal amountMin) {
         this.amountMin = amountMin;
         return this;
      }

      public ContractManagementCostDto.ContractManagementCostDtoBuilder cashDeposit(final BigDecimal cashDeposit) {
         this.cashDeposit = cashDeposit;
         return this;
      }

      public ContractManagementCostDto.ContractManagementCostDtoBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ContractManagementCostDto build() {
         return new ContractManagementCostDto(this.id, this.userId, this.projectAttribute, this.amountMax, this.amountMin, this.cashDeposit, this.status);
      }

      @Override
      public String toString() {
         return "ContractManagementCostDto.ContractManagementCostDtoBuilder(id="
            + this.id
            + ", userId="
            + this.userId
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
