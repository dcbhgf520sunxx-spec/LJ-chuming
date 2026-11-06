package com.hzchum.scim.contract.core.api.pojo.dtoParam.finance;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

public class SecurityDepositAndManagementCostDtoParam {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Integer id;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   private Long projectId;
   @ApiModelProperty(name = "income", value = "收入", notes = "收入")
   private BigDecimal income;
   @ApiModelProperty(name = "securityDeductIncome", value = "保证金扣除金额", notes = "保证金扣除金额")
   private BigDecimal securityDeductIncome;
   @ApiModelProperty(name = "securityRecord", value = "保证金退还记录", notes = "保证金退还记录")
   private BigDecimal securityRecord;
   @ApiModelProperty(name = "managementDeductIncome", value = "管理费扣除记录", notes = "管理费扣除记录")
   private BigDecimal managementDeductIncome;
   @ApiModelProperty(name = "managementRecord", value = "管理费退还记录", notes = "管理费退还记录")
   private BigDecimal managementRecord;
   @ApiModelProperty(name = "finalAmount", value = "最终金额", notes = "最终金额")
   private BigDecimal finalAmount;

   public SecurityDepositAndManagementCostDtoParam() {
   }

   public SecurityDepositAndManagementCostDtoParam(
      final Integer id,
      final Long projectId,
      final BigDecimal income,
      final BigDecimal securityDeductIncome,
      final BigDecimal securityRecord,
      final BigDecimal managementDeductIncome,
      final BigDecimal managementRecord,
      final BigDecimal finalAmount
   ) {
      this.id = id;
      this.projectId = projectId;
      this.income = income;
      this.securityDeductIncome = securityDeductIncome;
      this.securityRecord = securityRecord;
      this.managementDeductIncome = managementDeductIncome;
      this.managementRecord = managementRecord;
      this.finalAmount = finalAmount;
   }

   public Integer getId() {
      return this.id;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getIncome() {
      return this.income;
   }

   public BigDecimal getSecurityDeductIncome() {
      return this.securityDeductIncome;
   }

   public BigDecimal getSecurityRecord() {
      return this.securityRecord;
   }

   public BigDecimal getManagementDeductIncome() {
      return this.managementDeductIncome;
   }

   public BigDecimal getManagementRecord() {
      return this.managementRecord;
   }

   public BigDecimal getFinalAmount() {
      return this.finalAmount;
   }

   public void setId(final Integer id) {
      this.id = id;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setIncome(final BigDecimal income) {
      this.income = income;
   }

   public void setSecurityDeductIncome(final BigDecimal securityDeductIncome) {
      this.securityDeductIncome = securityDeductIncome;
   }

   public void setSecurityRecord(final BigDecimal securityRecord) {
      this.securityRecord = securityRecord;
   }

   public void setManagementDeductIncome(final BigDecimal managementDeductIncome) {
      this.managementDeductIncome = managementDeductIncome;
   }

   public void setManagementRecord(final BigDecimal managementRecord) {
      this.managementRecord = managementRecord;
   }

   public void setFinalAmount(final BigDecimal finalAmount) {
      this.finalAmount = finalAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof SecurityDepositAndManagementCostDtoParam)) {
         return false;
      }

      SecurityDepositAndManagementCostDtoParam other = (SecurityDepositAndManagementCostDtoParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$projectId = this.getProjectId();
         Object other$projectId = other.getProjectId();
         if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
            Object this$income = this.getIncome();
            Object other$income = other.getIncome();
            if (this$income == null ? other$income == null : this$income.equals(other$income)) {
               Object this$securityDeductIncome = this.getSecurityDeductIncome();
               Object other$securityDeductIncome = other.getSecurityDeductIncome();
               if (this$securityDeductIncome == null ? other$securityDeductIncome == null : this$securityDeductIncome.equals(other$securityDeductIncome)) {
                  Object this$securityRecord = this.getSecurityRecord();
                  Object other$securityRecord = other.getSecurityRecord();
                  if (this$securityRecord == null ? other$securityRecord == null : this$securityRecord.equals(other$securityRecord)) {
                     Object this$managementDeductIncome = this.getManagementDeductIncome();
                     Object other$managementDeductIncome = other.getManagementDeductIncome();
                     if (this$managementDeductIncome == null
                        ? other$managementDeductIncome == null
                        : this$managementDeductIncome.equals(other$managementDeductIncome)) {
                        Object this$managementRecord = this.getManagementRecord();
                        Object other$managementRecord = other.getManagementRecord();
                        if (this$managementRecord == null ? other$managementRecord == null : this$managementRecord.equals(other$managementRecord)) {
                           Object this$finalAmount = this.getFinalAmount();
                           Object other$finalAmount = other.getFinalAmount();
                           return this$finalAmount == null ? other$finalAmount == null : this$finalAmount.equals(other$finalAmount);
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
      return other instanceof SecurityDepositAndManagementCostDtoParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $income = this.getIncome();
      result = result * 59 + ($income == null ? 43 : $income.hashCode());
      Object $securityDeductIncome = this.getSecurityDeductIncome();
      result = result * 59 + ($securityDeductIncome == null ? 43 : $securityDeductIncome.hashCode());
      Object $securityRecord = this.getSecurityRecord();
      result = result * 59 + ($securityRecord == null ? 43 : $securityRecord.hashCode());
      Object $managementDeductIncome = this.getManagementDeductIncome();
      result = result * 59 + ($managementDeductIncome == null ? 43 : $managementDeductIncome.hashCode());
      Object $managementRecord = this.getManagementRecord();
      result = result * 59 + ($managementRecord == null ? 43 : $managementRecord.hashCode());
      Object $finalAmount = this.getFinalAmount();
      return result * 59 + ($finalAmount == null ? 43 : $finalAmount.hashCode());
   }

   @Override
   public String toString() {
      return "SecurityDepositAndManagementCostDtoParam(id="
         + this.getId()
         + ", projectId="
         + this.getProjectId()
         + ", income="
         + this.getIncome()
         + ", securityDeductIncome="
         + this.getSecurityDeductIncome()
         + ", securityRecord="
         + this.getSecurityRecord()
         + ", managementDeductIncome="
         + this.getManagementDeductIncome()
         + ", managementRecord="
         + this.getManagementRecord()
         + ", finalAmount="
         + this.getFinalAmount()
         + ")";
   }
}
