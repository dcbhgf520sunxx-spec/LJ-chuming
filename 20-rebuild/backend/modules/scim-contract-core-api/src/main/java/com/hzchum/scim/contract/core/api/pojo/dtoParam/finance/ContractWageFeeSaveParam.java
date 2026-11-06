package com.hzchum.scim.contract.core.api.pojo.dtoParam.finance;

import com.hzchum.pangu.common.valid.Add;
import com.hzchum.pangu.common.valid.Update;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

@ApiModel(description = "合同管理-工资费用")
public class ContractWageFeeSaveParam {
   @ApiModelProperty(name = "id")
   @NotNull(groups = Update.class, message = "ID 不能为空")
   private Long id;
   @ApiModelProperty("填写日期")
   @NotNull(groups = {Add.class, Update.class}, message = "填写日期 不能为空")
   private LocalDateTime fillInDate;
   @ApiModelProperty("分支机构ID")
   @NotNull(groups = {Add.class, Update.class}, message = "费用归属 不能为空")
   private Long branchCompanyId;
   @ApiModelProperty("费用类型")
   @NotNull(groups = {Add.class, Update.class}, message = "费用类型 不能为空")
   private Long expenseTypeId;
   @ApiModelProperty("工资总额(元)")
   @NotNull(groups = {Add.class, Update.class}, message = "工资总额 不能为空")
   @Positive(groups = {Add.class, Update.class}, message = "工资总额 不能小于等于0")
   private BigDecimal totalWage;
   @ApiModelProperty("员工数量")
   @NotNull(groups = {Add.class, Update.class}, message = "员工数量 不能为空")
   @Positive(groups = {Add.class, Update.class}, message = "员工数量 不能小于等于0")
   private Integer employeeQuantity;

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getFillInDate() {
      return this.fillInDate;
   }

   public Long getBranchCompanyId() {
      return this.branchCompanyId;
   }

   public Long getExpenseTypeId() {
      return this.expenseTypeId;
   }

   public BigDecimal getTotalWage() {
      return this.totalWage;
   }

   public Integer getEmployeeQuantity() {
      return this.employeeQuantity;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setFillInDate(final LocalDateTime fillInDate) {
      this.fillInDate = fillInDate;
   }

   public void setBranchCompanyId(final Long branchCompanyId) {
      this.branchCompanyId = branchCompanyId;
   }

   public void setExpenseTypeId(final Long expenseTypeId) {
      this.expenseTypeId = expenseTypeId;
   }

   public void setTotalWage(final BigDecimal totalWage) {
      this.totalWage = totalWage;
   }

   public void setEmployeeQuantity(final Integer employeeQuantity) {
      this.employeeQuantity = employeeQuantity;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractWageFeeSaveParam)) {
         return false;
      }

      ContractWageFeeSaveParam other = (ContractWageFeeSaveParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$branchCompanyId = this.getBranchCompanyId();
         Object other$branchCompanyId = other.getBranchCompanyId();
         if (this$branchCompanyId == null ? other$branchCompanyId == null : this$branchCompanyId.equals(other$branchCompanyId)) {
            Object this$expenseTypeId = this.getExpenseTypeId();
            Object other$expenseTypeId = other.getExpenseTypeId();
            if (this$expenseTypeId == null ? other$expenseTypeId == null : this$expenseTypeId.equals(other$expenseTypeId)) {
               Object this$employeeQuantity = this.getEmployeeQuantity();
               Object other$employeeQuantity = other.getEmployeeQuantity();
               if (this$employeeQuantity == null ? other$employeeQuantity == null : this$employeeQuantity.equals(other$employeeQuantity)) {
                  Object this$fillInDate = this.getFillInDate();
                  Object other$fillInDate = other.getFillInDate();
                  if (this$fillInDate == null ? other$fillInDate == null : this$fillInDate.equals(other$fillInDate)) {
                     Object this$totalWage = this.getTotalWage();
                     Object other$totalWage = other.getTotalWage();
                     return this$totalWage == null ? other$totalWage == null : this$totalWage.equals(other$totalWage);
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
      return other instanceof ContractWageFeeSaveParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $branchCompanyId = this.getBranchCompanyId();
      result = result * 59 + ($branchCompanyId == null ? 43 : $branchCompanyId.hashCode());
      Object $expenseTypeId = this.getExpenseTypeId();
      result = result * 59 + ($expenseTypeId == null ? 43 : $expenseTypeId.hashCode());
      Object $employeeQuantity = this.getEmployeeQuantity();
      result = result * 59 + ($employeeQuantity == null ? 43 : $employeeQuantity.hashCode());
      Object $fillInDate = this.getFillInDate();
      result = result * 59 + ($fillInDate == null ? 43 : $fillInDate.hashCode());
      Object $totalWage = this.getTotalWage();
      return result * 59 + ($totalWage == null ? 43 : $totalWage.hashCode());
   }

   @Override
   public String toString() {
      return "ContractWageFeeSaveParam(id="
         + this.getId()
         + ", fillInDate="
         + this.getFillInDate()
         + ", branchCompanyId="
         + this.getBranchCompanyId()
         + ", expenseTypeId="
         + this.getExpenseTypeId()
         + ", totalWage="
         + this.getTotalWage()
         + ", employeeQuantity="
         + this.getEmployeeQuantity()
         + ")";
   }
}
