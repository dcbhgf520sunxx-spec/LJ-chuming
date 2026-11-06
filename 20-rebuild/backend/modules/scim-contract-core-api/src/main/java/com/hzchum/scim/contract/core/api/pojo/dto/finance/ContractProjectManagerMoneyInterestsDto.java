package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContractProjectManagerMoneyInterestsDto {
   @ApiModelProperty(name = "id", value = "id", notes = "id")
   private Long id;
   @ApiModelProperty(name = "userId", value = "创建人", notes = "创建人")
   private Long userId;
   @ApiModelProperty
   private String userName;
   @ApiModelProperty("创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty
   private Long projectId;
   @ApiModelProperty(name = "income", value = "收入", notes = "收入")
   private BigDecimal income;
   @ApiModelProperty(name = "expenditure", value = "支出", notes = "支出")
   private BigDecimal expenditure;
   @ApiModelProperty(name = "remainingSum", value = "余额", notes = "余额")
   private BigDecimal remainingSum;
   @ApiModelProperty(name = "liabilities", value = "负数金额", notes = "负数金额")
   private BigDecimal liabilities;
   @ApiModelProperty(name = "liabilitiesDay", value = "负数天数", notes = "负数天数")
   private Integer liabilitiesDay;
   @ApiModelProperty(name = "dailyAmount", value = "日积数", notes = "日积数")
   private BigDecimal dailyAmount;
   @ApiModelProperty(name = "projectManagerId", value = "项目经理id", notes = "项目经理id")
   private Long projectManagerId;
   @ApiModelProperty("项目经理名称")
   private String projectManagerName;
   @ApiModelProperty(name = "suretyName", value = "担保人", notes = "担保人")
   private String suretyName;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty(name = "annualInterest", value = "日息", notes = "日息")
   private String annualInterest;

   public static ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder builder() {
      return new ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder();
   }

   public ContractProjectManagerMoneyInterestsDto() {
   }

   public ContractProjectManagerMoneyInterestsDto(
      final Long id,
      final Long userId,
      final String userName,
      final LocalDateTime createTime,
      final Long projectId,
      final BigDecimal income,
      final BigDecimal expenditure,
      final BigDecimal remainingSum,
      final BigDecimal liabilities,
      final Integer liabilitiesDay,
      final BigDecimal dailyAmount,
      final Long projectManagerId,
      final String projectManagerName,
      final String suretyName,
      final String projectName,
      final String annualInterest
   ) {
      this.id = id;
      this.userId = userId;
      this.userName = userName;
      this.createTime = createTime;
      this.projectId = projectId;
      this.income = income;
      this.expenditure = expenditure;
      this.remainingSum = remainingSum;
      this.liabilities = liabilities;
      this.liabilitiesDay = liabilitiesDay;
      this.dailyAmount = dailyAmount;
      this.projectManagerId = projectManagerId;
      this.projectManagerName = projectManagerName;
      this.suretyName = suretyName;
      this.projectName = projectName;
      this.annualInterest = annualInterest;
   }

   public Long getId() {
      return this.id;
   }

   public Long getUserId() {
      return this.userId;
   }

   public String getUserName() {
      return this.userName;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public BigDecimal getIncome() {
      return this.income;
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

   public String getProjectManagerName() {
      return this.projectManagerName;
   }

   public String getSuretyName() {
      return this.suretyName;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getAnnualInterest() {
      return this.annualInterest;
   }

   public ContractProjectManagerMoneyInterestsDto setId(final Long id) {
      this.id = id;
      return this;
   }

   public ContractProjectManagerMoneyInterestsDto setUserId(final Long userId) {
      this.userId = userId;
      return this;
   }

   public ContractProjectManagerMoneyInterestsDto setUserName(final String userName) {
      this.userName = userName;
      return this;
   }

   public ContractProjectManagerMoneyInterestsDto setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public ContractProjectManagerMoneyInterestsDto setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractProjectManagerMoneyInterestsDto setIncome(final BigDecimal income) {
      this.income = income;
      return this;
   }

   public ContractProjectManagerMoneyInterestsDto setExpenditure(final BigDecimal expenditure) {
      this.expenditure = expenditure;
      return this;
   }

   public ContractProjectManagerMoneyInterestsDto setRemainingSum(final BigDecimal remainingSum) {
      this.remainingSum = remainingSum;
      return this;
   }

   public ContractProjectManagerMoneyInterestsDto setLiabilities(final BigDecimal liabilities) {
      this.liabilities = liabilities;
      return this;
   }

   public ContractProjectManagerMoneyInterestsDto setLiabilitiesDay(final Integer liabilitiesDay) {
      this.liabilitiesDay = liabilitiesDay;
      return this;
   }

   public ContractProjectManagerMoneyInterestsDto setDailyAmount(final BigDecimal dailyAmount) {
      this.dailyAmount = dailyAmount;
      return this;
   }

   public ContractProjectManagerMoneyInterestsDto setProjectManagerId(final Long projectManagerId) {
      this.projectManagerId = projectManagerId;
      return this;
   }

   public ContractProjectManagerMoneyInterestsDto setProjectManagerName(final String projectManagerName) {
      this.projectManagerName = projectManagerName;
      return this;
   }

   public ContractProjectManagerMoneyInterestsDto setSuretyName(final String suretyName) {
      this.suretyName = suretyName;
      return this;
   }

   public ContractProjectManagerMoneyInterestsDto setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public ContractProjectManagerMoneyInterestsDto setAnnualInterest(final String annualInterest) {
      this.annualInterest = annualInterest;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectManagerMoneyInterestsDto)) {
         return false;
      }

      ContractProjectManagerMoneyInterestsDto other = (ContractProjectManagerMoneyInterestsDto)o;
      if (!other.canEqual(this)) {
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
                     Object this$userName = this.getUserName();
                     Object other$userName = other.getUserName();
                     if (this$userName == null ? other$userName == null : this$userName.equals(other$userName)) {
                        Object this$createTime = this.getCreateTime();
                        Object other$createTime = other.getCreateTime();
                        if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
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
                                       if (this$dailyAmount == null ? other$dailyAmount == null : this$dailyAmount.equals(other$dailyAmount)) {
                                          Object this$projectManagerName = this.getProjectManagerName();
                                          Object other$projectManagerName = other.getProjectManagerName();
                                          if (this$projectManagerName == null
                                             ? other$projectManagerName == null
                                             : this$projectManagerName.equals(other$projectManagerName)) {
                                             Object this$suretyName = this.getSuretyName();
                                             Object other$suretyName = other.getSuretyName();
                                             if (this$suretyName == null ? other$suretyName == null : this$suretyName.equals(other$suretyName)) {
                                                Object this$projectName = this.getProjectName();
                                                Object other$projectName = other.getProjectName();
                                                if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                                                   Object this$annualInterest = this.getAnnualInterest();
                                                   Object other$annualInterest = other.getAnnualInterest();
                                                   return this$annualInterest == null
                                                      ? other$annualInterest == null
                                                      : this$annualInterest.equals(other$annualInterest);
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
      return other instanceof ContractProjectManagerMoneyInterestsDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
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
      Object $userName = this.getUserName();
      result = result * 59 + ($userName == null ? 43 : $userName.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $income = this.getIncome();
      result = result * 59 + ($income == null ? 43 : $income.hashCode());
      Object $expenditure = this.getExpenditure();
      result = result * 59 + ($expenditure == null ? 43 : $expenditure.hashCode());
      Object $remainingSum = this.getRemainingSum();
      result = result * 59 + ($remainingSum == null ? 43 : $remainingSum.hashCode());
      Object $liabilities = this.getLiabilities();
      result = result * 59 + ($liabilities == null ? 43 : $liabilities.hashCode());
      Object $dailyAmount = this.getDailyAmount();
      result = result * 59 + ($dailyAmount == null ? 43 : $dailyAmount.hashCode());
      Object $projectManagerName = this.getProjectManagerName();
      result = result * 59 + ($projectManagerName == null ? 43 : $projectManagerName.hashCode());
      Object $suretyName = this.getSuretyName();
      result = result * 59 + ($suretyName == null ? 43 : $suretyName.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $annualInterest = this.getAnnualInterest();
      return result * 59 + ($annualInterest == null ? 43 : $annualInterest.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectManagerMoneyInterestsDto(id="
         + this.getId()
         + ", userId="
         + this.getUserId()
         + ", userName="
         + this.getUserName()
         + ", createTime="
         + this.getCreateTime()
         + ", projectId="
         + this.getProjectId()
         + ", income="
         + this.getIncome()
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
         + ", projectManagerName="
         + this.getProjectManagerName()
         + ", suretyName="
         + this.getSuretyName()
         + ", projectName="
         + this.getProjectName()
         + ", annualInterest="
         + this.getAnnualInterest()
         + ")";
   }

   public static class ContractProjectManagerMoneyInterestsDtoBuilder {
      private Long id;
      private Long userId;
      private String userName;
      private LocalDateTime createTime;
      private Long projectId;
      private BigDecimal income;
      private BigDecimal expenditure;
      private BigDecimal remainingSum;
      private BigDecimal liabilities;
      private Integer liabilitiesDay;
      private BigDecimal dailyAmount;
      private Long projectManagerId;
      private String projectManagerName;
      private String suretyName;
      private String projectName;
      private String annualInterest;

      ContractProjectManagerMoneyInterestsDtoBuilder() {
      }

      public ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder id(final Long id) {
         this.id = id;
         return this;
      }

      public ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder userId(final Long userId) {
         this.userId = userId;
         return this;
      }

      public ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder userName(final String userName) {
         this.userName = userName;
         return this;
      }

      public ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder income(final BigDecimal income) {
         this.income = income;
         return this;
      }

      public ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder expenditure(final BigDecimal expenditure) {
         this.expenditure = expenditure;
         return this;
      }

      public ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder remainingSum(final BigDecimal remainingSum) {
         this.remainingSum = remainingSum;
         return this;
      }

      public ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder liabilities(final BigDecimal liabilities) {
         this.liabilities = liabilities;
         return this;
      }

      public ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder liabilitiesDay(final Integer liabilitiesDay) {
         this.liabilitiesDay = liabilitiesDay;
         return this;
      }

      public ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder dailyAmount(final BigDecimal dailyAmount) {
         this.dailyAmount = dailyAmount;
         return this;
      }

      public ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder projectManagerId(final Long projectManagerId) {
         this.projectManagerId = projectManagerId;
         return this;
      }

      public ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder projectManagerName(final String projectManagerName) {
         this.projectManagerName = projectManagerName;
         return this;
      }

      public ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder suretyName(final String suretyName) {
         this.suretyName = suretyName;
         return this;
      }

      public ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder annualInterest(final String annualInterest) {
         this.annualInterest = annualInterest;
         return this;
      }

      public ContractProjectManagerMoneyInterestsDto build() {
         return new ContractProjectManagerMoneyInterestsDto(
            this.id,
            this.userId,
            this.userName,
            this.createTime,
            this.projectId,
            this.income,
            this.expenditure,
            this.remainingSum,
            this.liabilities,
            this.liabilitiesDay,
            this.dailyAmount,
            this.projectManagerId,
            this.projectManagerName,
            this.suretyName,
            this.projectName,
            this.annualInterest
         );
      }

      @Override
      public String toString() {
         return "ContractProjectManagerMoneyInterestsDto.ContractProjectManagerMoneyInterestsDtoBuilder(id="
            + this.id
            + ", userId="
            + this.userId
            + ", userName="
            + this.userName
            + ", createTime="
            + this.createTime
            + ", projectId="
            + this.projectId
            + ", income="
            + this.income
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
            + ", projectManagerName="
            + this.projectManagerName
            + ", suretyName="
            + this.suretyName
            + ", projectName="
            + this.projectName
            + ", annualInterest="
            + this.annualInterest
            + ")";
      }
   }
}
