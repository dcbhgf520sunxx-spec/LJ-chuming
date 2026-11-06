package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiOperation("项目收支明细详情返回类")
public class incomeAndExpenditureDTO {
   @ApiModelProperty("项目id")
   private Long id;
   @ApiModelProperty("日期")
   private LocalDateTime startDate;
   @ApiModelProperty("凭证号")
   private String voucherNumber;
   @ApiModelProperty("备注")
   private String remark;
   @ApiModelProperty("收支类型")
   private Integer type;
   @ApiModelProperty("收入金额")
   private BigDecimal income;
   @ApiModelProperty("支出金额")
   private BigDecimal expense;
   @ApiModelProperty("结余")
   private BigDecimal balance;

   incomeAndExpenditureDTO(
      final Long id,
      final LocalDateTime startDate,
      final String voucherNumber,
      final String remark,
      final Integer type,
      final BigDecimal income,
      final BigDecimal expense,
      final BigDecimal balance
   ) {
      this.id = id;
      this.startDate = startDate;
      this.voucherNumber = voucherNumber;
      this.remark = remark;
      this.type = type;
      this.income = income;
      this.expense = expense;
      this.balance = balance;
   }

   public static incomeAndExpenditureDTO.incomeAndExpenditureDTOBuilder builder() {
      return new incomeAndExpenditureDTO.incomeAndExpenditureDTOBuilder();
   }

   public Long getId() {
      return this.id;
   }

   public LocalDateTime getStartDate() {
      return this.startDate;
   }

   public String getVoucherNumber() {
      return this.voucherNumber;
   }

   public String getRemark() {
      return this.remark;
   }

   public Integer getType() {
      return this.type;
   }

   public BigDecimal getIncome() {
      return this.income;
   }

   public BigDecimal getExpense() {
      return this.expense;
   }

   public BigDecimal getBalance() {
      return this.balance;
   }

   public void setId(final Long id) {
      this.id = id;
   }

   public void setStartDate(final LocalDateTime startDate) {
      this.startDate = startDate;
   }

   public void setVoucherNumber(final String voucherNumber) {
      this.voucherNumber = voucherNumber;
   }

   public void setRemark(final String remark) {
      this.remark = remark;
   }

   public void setType(final Integer type) {
      this.type = type;
   }

   public void setIncome(final BigDecimal income) {
      this.income = income;
   }

   public void setExpense(final BigDecimal expense) {
      this.expense = expense;
   }

   public void setBalance(final BigDecimal balance) {
      this.balance = balance;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof incomeAndExpenditureDTO)) {
         return false;
      }

      incomeAndExpenditureDTO other = (incomeAndExpenditureDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$type = this.getType();
         Object other$type = other.getType();
         if (this$type == null ? other$type == null : this$type.equals(other$type)) {
            Object this$startDate = this.getStartDate();
            Object other$startDate = other.getStartDate();
            if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
               Object this$voucherNumber = this.getVoucherNumber();
               Object other$voucherNumber = other.getVoucherNumber();
               if (this$voucherNumber == null ? other$voucherNumber == null : this$voucherNumber.equals(other$voucherNumber)) {
                  Object this$remark = this.getRemark();
                  Object other$remark = other.getRemark();
                  if (this$remark == null ? other$remark == null : this$remark.equals(other$remark)) {
                     Object this$income = this.getIncome();
                     Object other$income = other.getIncome();
                     if (this$income == null ? other$income == null : this$income.equals(other$income)) {
                        Object this$expense = this.getExpense();
                        Object other$expense = other.getExpense();
                        if (this$expense == null ? other$expense == null : this$expense.equals(other$expense)) {
                           Object this$balance = this.getBalance();
                           Object other$balance = other.getBalance();
                           return this$balance == null ? other$balance == null : this$balance.equals(other$balance);
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
      return other instanceof incomeAndExpenditureDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $voucherNumber = this.getVoucherNumber();
      result = result * 59 + ($voucherNumber == null ? 43 : $voucherNumber.hashCode());
      Object $remark = this.getRemark();
      result = result * 59 + ($remark == null ? 43 : $remark.hashCode());
      Object $income = this.getIncome();
      result = result * 59 + ($income == null ? 43 : $income.hashCode());
      Object $expense = this.getExpense();
      result = result * 59 + ($expense == null ? 43 : $expense.hashCode());
      Object $balance = this.getBalance();
      return result * 59 + ($balance == null ? 43 : $balance.hashCode());
   }

   @Override
   public String toString() {
      return "incomeAndExpenditureDTO(id="
         + this.getId()
         + ", startDate="
         + this.getStartDate()
         + ", voucherNumber="
         + this.getVoucherNumber()
         + ", remark="
         + this.getRemark()
         + ", type="
         + this.getType()
         + ", income="
         + this.getIncome()
         + ", expense="
         + this.getExpense()
         + ", balance="
         + this.getBalance()
         + ")";
   }

   public static class incomeAndExpenditureDTOBuilder {
      private Long id;
      private LocalDateTime startDate;
      private String voucherNumber;
      private String remark;
      private Integer type;
      private BigDecimal income;
      private BigDecimal expense;
      private BigDecimal balance;

      incomeAndExpenditureDTOBuilder() {
      }

      public incomeAndExpenditureDTO.incomeAndExpenditureDTOBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public incomeAndExpenditureDTO.incomeAndExpenditureDTOBuilder startDate(final LocalDateTime startDate) {
         this.startDate = startDate;
         return this;
      }

      public incomeAndExpenditureDTO.incomeAndExpenditureDTOBuilder voucherNumber(final String voucherNumber) {
         this.voucherNumber = voucherNumber;
         return this;
      }

      public incomeAndExpenditureDTO.incomeAndExpenditureDTOBuilder remark(final String remark) {
         this.remark = remark;
         return this;
      }

      public incomeAndExpenditureDTO.incomeAndExpenditureDTOBuilder type(final Integer type) {
         this.type = type;
         return this;
      }

      public incomeAndExpenditureDTO.incomeAndExpenditureDTOBuilder income(final BigDecimal income) {
         this.income = income;
         return this;
      }

      public incomeAndExpenditureDTO.incomeAndExpenditureDTOBuilder expense(final BigDecimal expense) {
         this.expense = expense;
         return this;
      }

      public incomeAndExpenditureDTO.incomeAndExpenditureDTOBuilder balance(final BigDecimal balance) {
         this.balance = balance;
         return this;
      }

      public incomeAndExpenditureDTO build() {
         return new incomeAndExpenditureDTO(this.id, this.startDate, this.voucherNumber, this.remark, this.type, this.income, this.expense, this.balance);
      }

      @Override
      public String toString() {
         return "incomeAndExpenditureDTO.incomeAndExpenditureDTOBuilder(id="
            + this.id
            + ", startDate="
            + this.startDate
            + ", voucherNumber="
            + this.voucherNumber
            + ", remark="
            + this.remark
            + ", type="
            + this.type
            + ", income="
            + this.income
            + ", expense="
            + this.expense
            + ", balance="
            + this.balance
            + ")";
      }
   }
}
