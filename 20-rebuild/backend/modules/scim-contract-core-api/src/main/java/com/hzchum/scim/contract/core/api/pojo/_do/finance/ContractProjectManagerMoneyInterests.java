package com.hzchum.scim.contract.core.api.pojo._do.finance;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.hzchum.pangu.mybatisplus.pojo.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@ApiModel(value = "ContractProjectManagerMoneyInterests对象", description = "金额变更利息表 ")
@Entity
@TableName("contract_project_manager_money_interests")
@Table(name = "contract_project_manager_money_interests")
@org.hibernate.annotations.Table(appliesTo = "contract_project_manager_money_interests", comment = "金额变更利息表 ")
public class ContractProjectManagerMoneyInterests extends BaseEntity<Long> {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   @TableId(type = IdType.AUTO)
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Long id;
   @ApiModelProperty(name = "userId", value = "创建人", notes = "创建人")
   @TableField("user_id")
   @Column(name = "user_id", columnDefinition = "bigint(20)  COMMENT '创建人'", nullable = true)
   private Long userId;
   @ApiModelProperty(name = "income", value = "收入", notes = "收入")
   @TableField("income")
   @Column(name = "income", columnDefinition = "decimal(32,4)  COMMENT '收入'", nullable = true)
   private BigDecimal income;
   @ApiModelProperty(name = "projectId", value = "项目id", notes = "项目id")
   @TableField("project_id")
   @Column(name = "project_id", columnDefinition = "bigint(20)  COMMENT '项目id'", nullable = true)
   private Long projectId;
   @ApiModelProperty(name = "expenditure", value = "支出", notes = "支出")
   @TableField("expenditure")
   @Column(name = "expenditure", columnDefinition = "decimal(32,4)  COMMENT '支出'", nullable = true)
   private BigDecimal expenditure;
   @ApiModelProperty(name = "remainingSum", value = "余额", notes = "余额")
   @TableField("remaining_sum")
   @Column(name = "remaining_sum", columnDefinition = "decimal(32,4)  COMMENT '余额'", nullable = true)
   private BigDecimal remainingSum;
   @ApiModelProperty(name = "liabilities", value = "负数金额", notes = "负数金额")
   @TableField("liabilities")
   @Column(name = "liabilities", columnDefinition = "decimal(32,4)  COMMENT '负数金额'", nullable = true)
   private BigDecimal liabilities;
   @ApiModelProperty(name = "liabilitiesDay", value = "负数天数", notes = "负数天数")
   @TableField("liabilities_day")
   @Column(name = "liabilities_day", columnDefinition = "int(11)  COMMENT '负数天数'", nullable = true)
   private Integer liabilitiesDay;
   @ApiModelProperty(name = "dailyAmount", value = "日积数", notes = "日积数")
   @TableField("daily_amount")
   @Column(name = "daily_amount", columnDefinition = "decimal(32,4)  COMMENT '日积数'", nullable = true)
   private BigDecimal dailyAmount;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理id", notes = "项目经理id")
   @TableField("project_manager_id")
   @Column(name = "project_manager_id", columnDefinition = "bigint(20)  COMMENT '项目经理id'", nullable = false)
   private Long projectManagerId;

   public static ContractProjectManagerMoneyInterests.ContractProjectManagerMoneyInterestsBuilder builder() {
      return new ContractProjectManagerMoneyInterests.ContractProjectManagerMoneyInterestsBuilder();
   }

   public ContractProjectManagerMoneyInterests() {
   }

   public ContractProjectManagerMoneyInterests(
      final Long id,
      final Long userId,
      final BigDecimal income,
      final Long projectId,
      final BigDecimal expenditure,
      final BigDecimal remainingSum,
      final BigDecimal liabilities,
      final Integer liabilitiesDay,
      final BigDecimal dailyAmount,
      final Long projectManagerId
   ) {
      this.id = id;
      this.userId = userId;
      this.income = income;
      this.projectId = projectId;
      this.expenditure = expenditure;
      this.remainingSum = remainingSum;
      this.liabilities = liabilities;
      this.liabilitiesDay = liabilitiesDay;
      this.dailyAmount = dailyAmount;
      this.projectManagerId = projectManagerId;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public BigDecimal getIncome() {
      return this.income;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getExpenditure() {
      return this.expenditure;
   }

   public BigDecimal getRemainingSum() {
      return this.remainingSum;
   }

   public BigDecimal getLiabilities() {
      return this.liabilities;
   }

   public Integer getLiabilitiesDay() {
      return this.liabilitiesDay;
   }

   public BigDecimal getDailyAmount() {
      return this.dailyAmount;
   }

   public Long getProjectManagerId() {
      return this.projectManagerId;
   }

   public ContractProjectManagerMoneyInterests setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractProjectManagerMoneyInterests setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractProjectManagerMoneyInterests setIncome(final BigDecimal income) {
      this.income = income;
      return this;
   }

   public ContractProjectManagerMoneyInterests setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractProjectManagerMoneyInterests setExpenditure(final BigDecimal expenditure) {
      this.expenditure = expenditure;
      return this;
   }

   public ContractProjectManagerMoneyInterests setRemainingSum(final BigDecimal remainingSum) {
      this.remainingSum = remainingSum;
      return this;
   }

   public ContractProjectManagerMoneyInterests setLiabilities(final BigDecimal liabilities) {
      this.liabilities = liabilities;
      return this;
   }

   public ContractProjectManagerMoneyInterests setLiabilitiesDay(final Integer liabilitiesDay) {
      this.liabilitiesDay = liabilitiesDay;
      return this;
   }

   public ContractProjectManagerMoneyInterests setDailyAmount(final BigDecimal dailyAmount) {
      this.dailyAmount = dailyAmount;
      return this;
   }

   public ContractProjectManagerMoneyInterests setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   @Override
   public String toString() {
      return "ContractProjectManagerMoneyInterests(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", income="
         + this.getIncome()
         + ", projectId="
         + this.getProjectId()
         + ", expenditure="
         + this.getExpenditure()
         + ", remainingSum="
         + this.getRemainingSum()
         + ", liabilities="
         + this.getLiabilities()
         + ", liabilitiesDay="
         + this.getLiabilitiesDay()
         + ", dailyAmount="
         + this.getDailyAmount()
         + ", projectManagerId="
         + this.getProjectManagerId()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectManagerMoneyInterests)) {
         return false;
      }

      ContractProjectManagerMoneyInterests other = (ContractProjectManagerMoneyInterests)o;
      if (!other.canEqual(this)) {
         return false;
      }

      if (!super.equals(o)) {
         return false;
      }

      Object this$id = this.getId();
      Object other$id = other.getId();
      if (this$id == null ? other$id == null : this$id.equals(other$id)) {
         Object this$userId = this.getUserId();
         Object other$userId = other.getUserId();
         if (this$userId == null ? other$userId == null : this$userId.equals(other$userId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$liabilitiesDay = this.getLiabilitiesDay();
               Object other$liabilitiesDay = other.getLiabilitiesDay();
               if (this$liabilitiesDay == null ? other$liabilitiesDay == null : this$liabilitiesDay.equals(other$liabilitiesDay)) {
                  Object this$projectManagerId = this.getProjectManagerId();
                  Object other$projectManagerId = other.getProjectManagerId();
                  if (this$projectManagerId == null ? other$projectManagerId == null : this$projectManagerId.equals(other$projectManagerId)) {
                     Object this$income = this.getIncome();
                     Object other$income = other.getIncome();
                     if (this$income == null ? other$income == null : this$income.equals(other$income)) {
                        Object this$expenditure = this.getExpenditure();
                        Object other$expenditure = other.getExpenditure();
                        if (this$expenditure == null ? other$expenditure == null : this$expenditure.equals(other$expenditure)) {
                           Object this$remainingSum = this.getRemainingSum();
                           Object other$remainingSum = other.getRemainingSum();
                           if (this$remainingSum == null ? other$remainingSum == null : this$remainingSum.equals(other$remainingSum)) {
                              Object this$liabilities = this.getLiabilities();
                              Object other$liabilities = other.getLiabilities();
                              if (this$liabilities == null ? other$liabilities == null : this$liabilities.equals(other$liabilities)) {
                                 Object this$dailyAmount = this.getDailyAmount();
                                 Object other$dailyAmount = other.getDailyAmount();
                                 return this$dailyAmount == null ? other$dailyAmount == null : this$dailyAmount.equals(other$dailyAmount);
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
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   protected boolean canEqual(final Object other) {
      return other instanceof ContractProjectManagerMoneyInterests;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = super.hashCode();
      Object $id = this.getId();
      result = result * 59 + ($id == null ? 43 : $id.hashCode());
      Object $userId = this.getUserId();
      result = result * 59 + ($userId == null ? 43 : $userId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $liabilitiesDay = this.getLiabilitiesDay();
      result = result * 59 + ($liabilitiesDay == null ? 43 : $liabilitiesDay.hashCode());
      Object $projectManagerId = this.getProjectManagerId();
      result = result * 59 + ($projectManagerId == null ? 43 : $projectManagerId.hashCode());
      Object $income = this.getIncome();
      result = result * 59 + ($income == null ? 43 : $income.hashCode());
      Object $expenditure = this.getExpenditure();
      result = result * 59 + ($expenditure == null ? 43 : $expenditure.hashCode());
      Object $remainingSum = this.getRemainingSum();
      result = result * 59 + ($remainingSum == null ? 43 : $remainingSum.hashCode());
      Object $liabilities = this.getLiabilities();
      result = result * 59 + ($liabilities == null ? 43 : $liabilities.hashCode());
      Object $dailyAmount = this.getDailyAmount();
      return result * 59 + ($dailyAmount == null ? 43 : $dailyAmount.hashCode());
   }

   public static class ContractProjectManagerMoneyInterestsBuilder {
      private Long id;
      private Long userId;
      private BigDecimal income;
      private Long projectId;
      private BigDecimal expenditure;
      private BigDecimal remainingSum;
      private BigDecimal liabilities;
      private Integer liabilitiesDay;
      private BigDecimal dailyAmount;
      private Long projectManagerId;

      ContractProjectManagerMoneyInterestsBuilder() {
      }

      public ContractProjectManagerMoneyInterests.ContractProjectManagerMoneyInterestsBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractProjectManagerMoneyInterests.ContractProjectManagerMoneyInterestsBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractProjectManagerMoneyInterests.ContractProjectManagerMoneyInterestsBuilder income(final BigDecimal income) {
         this.income = income;
         return this;
      }

      public ContractProjectManagerMoneyInterests.ContractProjectManagerMoneyInterestsBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractProjectManagerMoneyInterests.ContractProjectManagerMoneyInterestsBuilder expenditure(final BigDecimal expenditure) {
         this.expenditure = expenditure;
         return this;
      }

      public ContractProjectManagerMoneyInterests.ContractProjectManagerMoneyInterestsBuilder remainingSum(final BigDecimal remainingSum) {
         this.remainingSum = remainingSum;
         return this;
      }

      public ContractProjectManagerMoneyInterests.ContractProjectManagerMoneyInterestsBuilder liabilities(final BigDecimal liabilities) {
         this.liabilities = liabilities;
         return this;
      }

      public ContractProjectManagerMoneyInterests.ContractProjectManagerMoneyInterestsBuilder liabilitiesDay(final Integer liabilitiesDay) {
         this.liabilitiesDay = liabilitiesDay;
         return this;
      }

      public ContractProjectManagerMoneyInterests.ContractProjectManagerMoneyInterestsBuilder dailyAmount(final BigDecimal dailyAmount) {
         this.dailyAmount = dailyAmount;
         return this;
      }

      public ContractProjectManagerMoneyInterests.ContractProjectManagerMoneyInterestsBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ContractProjectManagerMoneyInterests build() {
         return new ContractProjectManagerMoneyInterests(
            this.id,
            this.userId,
            this.income,
            this.projectId,
            this.expenditure,
            this.remainingSum,
            this.liabilities,
            this.liabilitiesDay,
            this.dailyAmount,
            this.projectManagerId
         );
      }

      @Override
      public String toString() {
         return "ContractProjectManagerMoneyInterests.ContractProjectManagerMoneyInterestsBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", income="
            + this.income
            + ", projectId="
            + this.projectId
            + ", expenditure="
            + this.expenditure
            + ", remainingSum="
            + this.remainingSum
            + ", liabilities="
            + this.liabilities
            + ", liabilitiesDay="
            + this.liabilitiesDay
            + ", dailyAmount="
            + this.dailyAmount
            + ", projectManagerId="
            + this.projectManagerId
            + ")";
      }
   }
}
