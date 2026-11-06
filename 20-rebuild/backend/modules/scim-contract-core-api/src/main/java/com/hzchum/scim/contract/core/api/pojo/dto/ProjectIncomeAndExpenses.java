package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiModel("项目收支明细详情返回类")
public class ProjectIncomeAndExpenses {
   @ApiModelProperty("项目id")
   private Long id;
   @ApiModelProperty("日期")
   private LocalDateTime startDate;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("收入类型")
   private Integer incomeType;
   @ApiModelProperty("收入金额")
   private BigDecimal income;
   @ApiModelProperty("支出类型")
   private Integer expenseType;
   @ApiModelProperty("支出金额")
   private BigDecimal expense;

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getIncomeType() {
      return this.incomeType;
   }

   public BigDecimal getIncome() {
      return this.income;
   }

   public Integer getExpenseType() {
      return this.expenseType;
   }

   public BigDecimal getExpense() {
      return this.expense;
   }

   public ProjectIncomeAndExpenses setId(final Long id) {
      this.id = id;
      return this;
   }

   public ProjectIncomeAndExpenses setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
      return this;
   }

   public ProjectIncomeAndExpenses setRemark(final String remark) {
      this.remark = remark;
      return this;
   }

   public ProjectIncomeAndExpenses setIncomeType(final Integer incomeType) {
      this.incomeType = incomeType;
      return this;
   }

   public ProjectIncomeAndExpenses setIncome(final BigDecimal income) {
      this.income = income;
      return this;
   }

   public ProjectIncomeAndExpenses setExpenseType(final Integer expenseType) {
      this.expenseType = expenseType;
      return this;
   }

   public ProjectIncomeAndExpenses setExpense(final BigDecimal expense) {
      this.expense = expense;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProjectIncomeAndExpenses)) {
         return false;
      }

      ProjectIncomeAndExpenses other = (ProjectIncomeAndExpenses)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$incomeType = this.getIncomeType();
         Object other$incomeType = other.getIncomeType();
         if (this$incomeType == null ? other$incomeType == null : this$incomeType.equals(other$incomeType)) {
            Object this$expenseType = this.getExpenseType();
            Object other$expenseType = other.getExpenseType();
            if (this$expenseType == null ? other$expenseType == null : this$expenseType.equals(other$expenseType)) {
               Object this$startDate = this.getStartDate();
               Object other$startDate = other.getStartDate();
               if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                  Object this$remark = this.getRemark();
                  Object other$remark = other.getRemark();
                  if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                     Object this$income = this.getIncome();
                     Object other$income = other.getIncome();
                     if (this$income == null ? other$income == null : this$income.equals(other$income)) {
                        Object this$expense = this.getExpense();
                        Object other$expense = other.getExpense();
                        return this$expense == null ? other$expense == null : this$expense.equals(other$expense);
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
      return other instanceof ProjectIncomeAndExpenses;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $incomeType = this.getIncomeType();
      result = result * 59 + ($incomeType == null ? 43 : $incomeType.hashCode());
      Object $expenseType = this.getExpenseType();
      result = result * 59 + ($expenseType == null ? 43 : $expenseType.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $income = this.getIncome();
      result = result * 59 + ($income == null ? 43 : $income.hashCode());
      Object $expense = this.getExpense();
      return result * 59 + ($expense == null ? 43 : $expense.hashCode());
   }

   @Override
   public String toString() {
      return "ProjectIncomeAndExpenses(id="
         + this.getId()
         + ", startDate="
         + this.getStartDate()
         + ", remark="
         + this.getRemark()
         + ", incomeType="
         + this.getIncomeType()
         + ", income="
         + this.getIncome()
         + ", expenseType="
         + this.getExpenseType()
         + ", expense="
         + this.getExpense()
         + ")";
   }
}
