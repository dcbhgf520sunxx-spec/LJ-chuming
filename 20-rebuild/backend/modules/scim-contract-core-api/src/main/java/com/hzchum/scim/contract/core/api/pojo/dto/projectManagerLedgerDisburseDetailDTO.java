package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.common.core.api.pojo.common.ProjectInfo;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class projectManagerLedgerDisburseDetailDTO {
   @ApiModelProperty("项目信息")
   private ProjectInfo project;
   @ApiModelProperty("日期")
   private LocalDateTime date;
   @ApiModelProperty("凭证号")
   private String voucherNumber;
   @ApiModelProperty("收支形式")
   private String type;
   @ApiModelProperty("摘要")
   private String summary;
   @ApiModelProperty("收入")
   private BigDecimal income;
   @ApiModelProperty("支出")
   private BigDecimal expenditure;
   @ApiModelProperty("余额")
   private BigDecimal balance;

   public static projectManagerLedgerDisburseDetailDTO.projectManagerLedgerDisburseDetailDTOBuilder builder() {
      return new projectManagerLedgerDisburseDetailDTO.projectManagerLedgerDisburseDetailDTOBuilder();
   }

   public ProjectInfo getProject() {
      return this.project;
   }

   public LocalDateTime getDate() {
      return this.date;
   }

   public String getVoucherNumber() {
      return this.voucherNumber;
   }

   public String getType() {
      return this.type;
   }

   public String getSummary() {
      return this.summary;
   }

   public BigDecimal getIncome() {
      return this.income;
   }

   public BigDecimal getExpenditure() {
      return this.expenditure;
   }

   public BigDecimal getBalance() {
      return this.balance;
   }

   public void setProject(final ProjectInfo project) {
      this.project = project;
   }

   public void setDate(final LocalDateTime date) {
      this.date = date;
   }

   public void setVoucherNumber(final String voucherNumber) {
      this.voucherNumber = voucherNumber;
   }

   public void setType(final String type) {
      this.type = type;
   }

   public void setSummary(final String summary) {
      this.summary = summary;
   }

   public void setIncome(final BigDecimal income) {
      this.income = income;
   }

   public void setExpenditure(final BigDecimal expenditure) {
      this.expenditure = expenditure;
   }

   public void setBalance(final BigDecimal balance) {
      this.balance = balance;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof projectManagerLedgerDisburseDetailDTO)) {
         return false;
      }

      projectManagerLedgerDisburseDetailDTO other = (projectManagerLedgerDisburseDetailDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$project = this.getProject();
      Object other$project = other.getProject();
      if (this$project == null ? other$project == null : this$project.equals(other$project)) {
         Object this$date = this.getDate();
         Object other$date = other.getDate();
         if (this$date == null ? other$date == null : this$date.equals(other$date)) {
            Object this$voucherNumber = this.getVoucherNumber();
            Object other$voucherNumber = other.getVoucherNumber();
            if (this$voucherNumber == null ? other$voucherNumber == null : this$voucherNumber.equals(other$voucherNumber)) {
               Object this$type = this.getType();
               Object other$type = other.getType();
               if (this$type == null ? other$type == null : this$type.equals(other$type)) {
                  Object this$summary = this.getSummary();
                  Object other$summary = other.getSummary();
                  if (this$summary == null ? other$summary == null : this$summary.equals(other$summary)) {
                     Object this$income = this.getIncome();
                     Object other$income = other.getIncome();
                     if (this$income == null ? other$income == null : this$income.equals(other$income)) {
                        Object this$expenditure = this.getExpenditure();
                        Object other$expenditure = other.getExpenditure();
                        if (this$expenditure == null ? other$expenditure == null : this$expenditure.equals(other$expenditure)) {
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
      return other instanceof projectManagerLedgerDisburseDetailDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $project = this.getProject();
      result = result * 59 + ($project == null ? 43 : $project.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $voucherNumber = this.getVoucherNumber();
      result = result * 59 + ($voucherNumber == null ? 43 : $voucherNumber.hashCode());
      Object $type = this.getType();
      result = result * 59 + ($type == null ? 43 : $type.hashCode());
      Object $summary = this.getSummary();
      result = result * 59 + ($summary == null ? 43 : $summary.hashCode());
      Object $income = this.getIncome();
      result = result * 59 + ($income == null ? 43 : $income.hashCode());
      Object $expenditure = this.getExpenditure();
      result = result * 59 + ($expenditure == null ? 43 : $expenditure.hashCode());
      Object $balance = this.getBalance();
      return result * 59 + ($balance == null ? 43 : $balance.hashCode());
   }

   @Override
   public String toString() {
      return "projectManagerLedgerDisburseDetailDTO(project="
         + this.getProject()
         + ", date="
         + this.getDate()
         + ", voucherNumber="
         + this.getVoucherNumber()
         + ", type="
         + this.getType()
         + ", summary="
         + this.getSummary()
         + ", income="
         + this.getIncome()
         + ", expenditure="
         + this.getExpenditure()
         + ", balance="
         + this.getBalance()
         + ")";
   }

   public projectManagerLedgerDisburseDetailDTO() {
   }

   public projectManagerLedgerDisburseDetailDTO(
      final ProjectInfo project,
      final LocalDateTime date,
      final String voucherNumber,
      final String type,
      final String summary,
      final BigDecimal income,
      final BigDecimal expenditure,
      final BigDecimal balance
   ) {
      this.project = project;
      this.date = date;
      this.voucherNumber = voucherNumber;
      this.type = type;
      this.summary = summary;
      this.income = income;
      this.expenditure = expenditure;
      this.balance = balance;
   }

   public static class projectManagerLedgerDisburseDetailDTOBuilder {
      private ProjectInfo project;
      private LocalDateTime date;
      private String voucherNumber;
      private String type;
      private String summary;
      private BigDecimal income;
      private BigDecimal expenditure;
      private BigDecimal balance;

      projectManagerLedgerDisburseDetailDTOBuilder() {
      }

      public projectManagerLedgerDisburseDetailDTO.projectManagerLedgerDisburseDetailDTOBuilder project(final ProjectInfo project) {
         this.project = project;
         return this;
      }

      public projectManagerLedgerDisburseDetailDTO.projectManagerLedgerDisburseDetailDTOBuilder date(final LocalDateTime date) {
         this.date = date;
         return this;
      }

      public projectManagerLedgerDisburseDetailDTO.projectManagerLedgerDisburseDetailDTOBuilder voucherNumber(final String voucherNumber) {
         this.voucherNumber = voucherNumber;
         return this;
      }

      public projectManagerLedgerDisburseDetailDTO.projectManagerLedgerDisburseDetailDTOBuilder type(final String type) {
         this.type = type;
         return this;
      }

      public projectManagerLedgerDisburseDetailDTO.projectManagerLedgerDisburseDetailDTOBuilder summary(final String summary) {
         this.summary = summary;
         return this;
      }

      public projectManagerLedgerDisburseDetailDTO.projectManagerLedgerDisburseDetailDTOBuilder income(final BigDecimal income) {
         this.income = income;
         return this;
      }

      public projectManagerLedgerDisburseDetailDTO.projectManagerLedgerDisburseDetailDTOBuilder expenditure(final BigDecimal expenditure) {
         this.expenditure = expenditure;
         return this;
      }

      public projectManagerLedgerDisburseDetailDTO.projectManagerLedgerDisburseDetailDTOBuilder balance(final BigDecimal balance) {
         this.balance = balance;
         return this;
      }

      public projectManagerLedgerDisburseDetailDTO build() {
         return new projectManagerLedgerDisburseDetailDTO(
            this.project, this.date, this.voucherNumber, this.type, this.summary, this.income, this.expenditure, this.balance
         );
      }

      @Override
      public String toString() {
         return "projectManagerLedgerDisburseDetailDTO.projectManagerLedgerDisburseDetailDTOBuilder(project="
            + this.project
            + ", date="
            + this.date
            + ", voucherNumber="
            + this.voucherNumber
            + ", type="
            + this.type
            + ", summary="
            + this.summary
            + ", income="
            + this.income
            + ", expenditure="
            + this.expenditure
            + ", balance="
            + this.balance
            + ")";
      }
   }
}
