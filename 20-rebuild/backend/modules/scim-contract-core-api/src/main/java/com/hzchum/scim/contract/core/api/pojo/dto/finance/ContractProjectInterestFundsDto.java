package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ContractProjectInterestFundsDto {
   @ApiModelProperty
   private Long projectId;
   @ApiModelProperty("创建时间")
   private LocalDateTime createTime;
   @ApiModelProperty("结息日期")
   private LocalDateTime interestTime;
   @ApiModelProperty("到期日期")
   private LocalDateTime expireTime;
   @ApiModelProperty("结息天数")
   private Integer settlementDay;
   @ApiModelProperty(name = "settlementInterest", value = "结算利息金额", notes = "结算利息金额")
   private BigDecimal settlementInterest;
   @ApiModelProperty(name = "liabilities", value = "本次结算利息", notes = "本次结算利息")
   private BigDecimal liabilities;
   @ApiModelProperty(name = "dailyAmount", value = "日积数", notes = "日积数")
   private BigDecimal dailyAmount;
   @ApiModelProperty(name = "annualInterest", value = "日息", notes = "日息")
   private String annualInterest;
   @ApiModelProperty(name = "negativeAmount", value = "负数金额", notes = "负数金额")
   private BigDecimal negativeAmount;

   public static ContractProjectInterestFundsDto.ContractProjectInterestFundsDtoBuilder builder() {
      return new ContractProjectInterestFundsDto.ContractProjectInterestFundsDtoBuilder();
   }

   public ContractProjectInterestFundsDto() {
   }

   public ContractProjectInterestFundsDto(
      final Long projectId,
      final LocalDateTime createTime,
      final LocalDateTime interestTime,
      final LocalDateTime expireTime,
      final Integer settlementDay,
      final BigDecimal settlementInterest,
      final BigDecimal liabilities,
      final BigDecimal dailyAmount,
      final String annualInterest,
      final BigDecimal negativeAmount
   ) {
      this.projectId = projectId;
      this.createTime = createTime;
      this.interestTime = interestTime;
      this.expireTime = expireTime;
      this.settlementDay = settlementDay;
      this.settlementInterest = settlementInterest;
      this.liabilities = liabilities;
      this.dailyAmount = dailyAmount;
      this.annualInterest = annualInterest;
      this.negativeAmount = negativeAmount;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public LocalDateTime getInterestTime() {
      return this.interestTime;
   }

   public LocalDateTime getExpireTime() {
      return this.expireTime;
   }

   public Integer getSettlementDay() {
      return this.settlementDay;
   }

   public BigDecimal getSettlementInterest() {
      return this.settlementInterest;
   }

   public BigDecimal getLiabilities() {
      return this.liabilities;
   }

   public BigDecimal getDailyAmount() {
      return this.dailyAmount;
   }

   public String getAnnualInterest() {
      return this.annualInterest;
   }

   public BigDecimal getNegativeAmount() {
      return this.negativeAmount;
   }

   public ContractProjectInterestFundsDto setProjectId(final Long projectId) {
      this.projectId = projectId;
      return this;
   }

   public ContractProjectInterestFundsDto setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public ContractProjectInterestFundsDto setInterestTime(final LocalDateTime interestTime) {
      this.interestTime = interestTime;
      return this;
   }

   public ContractProjectInterestFundsDto setExpireTime(final LocalDateTime expireTime) {
      this.expireTime = expireTime;
      return this;
   }

   public ContractProjectInterestFundsDto setSettlementDay(final Integer settlementDay) {
      this.settlementDay = settlementDay;
      return this;
   }

   public ContractProjectInterestFundsDto setSettlementInterest(final BigDecimal settlementInterest) {
      this.settlementInterest = settlementInterest;
      return this;
   }

   public ContractProjectInterestFundsDto setLiabilities(final BigDecimal liabilities) {
      this.liabilities = liabilities;
      return this;
   }

   public ContractProjectInterestFundsDto setDailyAmount(final BigDecimal dailyAmount) {
      this.dailyAmount = dailyAmount;
      return this;
   }

   public ContractProjectInterestFundsDto setAnnualInterest(final String annualInterest) {
      this.annualInterest = annualInterest;
      return this;
   }

   public ContractProjectInterestFundsDto setNegativeAmount(final BigDecimal negativeAmount) {
      this.negativeAmount = negativeAmount;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractProjectInterestFundsDto)) {
         return false;
      }

      ContractProjectInterestFundsDto other = (ContractProjectInterestFundsDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$settlementDay = this.getSettlementDay();
         Object other$settlementDay = other.getSettlementDay();
         if (this$settlementDay == null ? other$settlementDay == null : this$settlementDay.equals(other$settlementDay)) {
            Object this$createTime = this.getCreateTime();
            Object other$createTime = other.getCreateTime();
            if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
               Object this$interestTime = this.getInterestTime();
               Object other$interestTime = other.getInterestTime();
               if (this$interestTime == null ? other$interestTime == null : this$interestTime.equals(other$interestTime)) {
                  Object this$expireTime = this.getExpireTime();
                  Object other$expireTime = other.getExpireTime();
                  if (this$expireTime == null ? other$expireTime == null : this$expireTime.equals(other$expireTime)) {
                     Object this$settlementInterest = this.getSettlementInterest();
                     Object other$settlementInterest = other.getSettlementInterest();
                     if (this$settlementInterest == null ? other$settlementInterest == null : this$settlementInterest.equals(other$settlementInterest)) {
                        Object this$liabilities = this.getLiabilities();
                        Object other$liabilities = other.getLiabilities();
                        if (this$liabilities == null ? other$liabilities == null : this$liabilities.equals(other$liabilities)) {
                           Object this$dailyAmount = this.getDailyAmount();
                           Object other$dailyAmount = other.getDailyAmount();
                           if (this$dailyAmount == null ? other$dailyAmount == null : this$dailyAmount.equals(other$dailyAmount)) {
                              Object this$annualInterest = this.getAnnualInterest();
                              Object other$annualInterest = other.getAnnualInterest();
                              if (this$annualInterest == null ? other$annualInterest == null : this$annualInterest.equals(other$annualInterest)) {
                                 Object this$negativeAmount = this.getNegativeAmount();
                                 Object other$negativeAmount = other.getNegativeAmount();
                                 return this$negativeAmount == null ? other$negativeAmount == null : this$negativeAmount.equals(other$negativeAmount);
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
      return other instanceof ContractProjectInterestFundsDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $settlementDay = this.getSettlementDay();
      result = result * 59 + ($settlementDay == null ? 43 : $settlementDay.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $interestTime = this.getInterestTime();
      result = result * 59 + ($interestTime == null ? 43 : $interestTime.hashCode());
      Object $expireTime = this.getExpireTime();
      result = result * 59 + ($expireTime == null ? 43 : $expireTime.hashCode());
      Object $settlementInterest = this.getSettlementInterest();
      result = result * 59 + ($settlementInterest == null ? 43 : $settlementInterest.hashCode());
      Object $liabilities = this.getLiabilities();
      result = result * 59 + ($liabilities == null ? 43 : $liabilities.hashCode());
      Object $dailyAmount = this.getDailyAmount();
      result = result * 59 + ($dailyAmount == null ? 43 : $dailyAmount.hashCode());
      Object $annualInterest = this.getAnnualInterest();
      result = result * 59 + ($annualInterest == null ? 43 : $annualInterest.hashCode());
      Object $negativeAmount = this.getNegativeAmount();
      return result * 59 + ($negativeAmount == null ? 43 : $negativeAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ContractProjectInterestFundsDto(projectId="
         + this.getProjectId()
         + ", createTime="
         + this.getCreateTime()
         + ", interestTime="
         + this.getInterestTime()
         + ", expireTime="
         + this.getExpireTime()
         + ", settlementDay="
         + this.getSettlementDay()
         + ", settlementInterest="
         + this.getSettlementInterest()
         + ", liabilities="
         + this.getLiabilities()
         + ", dailyAmount="
         + this.getDailyAmount()
         + ", annualInterest="
         + this.getAnnualInterest()
         + ", negativeAmount="
         + this.getNegativeAmount()
         + ")";
   }

   public static class ContractProjectInterestFundsDtoBuilder {
      private Long projectId;
      private LocalDateTime createTime;
      private LocalDateTime interestTime;
      private LocalDateTime expireTime;
      private Integer settlementDay;
      private BigDecimal settlementInterest;
      private BigDecimal liabilities;
      private BigDecimal dailyAmount;
      private String annualInterest;
      private BigDecimal negativeAmount;

      ContractProjectInterestFundsDtoBuilder() {
      }

      public ContractProjectInterestFundsDto.ContractProjectInterestFundsDtoBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ContractProjectInterestFundsDto.ContractProjectInterestFundsDtoBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ContractProjectInterestFundsDto.ContractProjectInterestFundsDtoBuilder interestTime(final LocalDateTime interestTime) {
         this.interestTime = interestTime;
         return this;
      }

      public ContractProjectInterestFundsDto.ContractProjectInterestFundsDtoBuilder expireTime(final LocalDateTime expireTime) {
         this.expireTime = expireTime;
         return this;
      }

      public ContractProjectInterestFundsDto.ContractProjectInterestFundsDtoBuilder settlementDay(final Integer settlementDay) {
         this.settlementDay = settlementDay;
         return this;
      }

      public ContractProjectInterestFundsDto.ContractProjectInterestFundsDtoBuilder settlementInterest(final BigDecimal settlementInterest) {
         this.settlementInterest = settlementInterest;
         return this;
      }

      public ContractProjectInterestFundsDto.ContractProjectInterestFundsDtoBuilder liabilities(final BigDecimal liabilities) {
         this.liabilities = liabilities;
         return this;
      }

      public ContractProjectInterestFundsDto.ContractProjectInterestFundsDtoBuilder dailyAmount(final BigDecimal dailyAmount) {
         this.dailyAmount = dailyAmount;
         return this;
      }

      public ContractProjectInterestFundsDto.ContractProjectInterestFundsDtoBuilder annualInterest(final String annualInterest) {
         this.annualInterest = annualInterest;
         return this;
      }

      public ContractProjectInterestFundsDto.ContractProjectInterestFundsDtoBuilder negativeAmount(final BigDecimal negativeAmount) {
         this.negativeAmount = negativeAmount;
         return this;
      }

      public ContractProjectInterestFundsDto build() {
         return new ContractProjectInterestFundsDto(
            this.projectId,
            this.createTime,
            this.interestTime,
            this.expireTime,
            this.settlementDay,
            this.settlementInterest,
            this.liabilities,
            this.dailyAmount,
            this.annualInterest,
            this.negativeAmount
         );
      }

      @Override
      public String toString() {
         return "ContractProjectInterestFundsDto.ContractProjectInterestFundsDtoBuilder(projectId="
            + this.projectId
            + ", createTime="
            + this.createTime
            + ", interestTime="
            + this.interestTime
            + ", expireTime="
            + this.expireTime
            + ", settlementDay="
            + this.settlementDay
            + ", settlementInterest="
            + this.settlementInterest
            + ", liabilities="
            + this.liabilities
            + ", dailyAmount="
            + this.dailyAmount
            + ", annualInterest="
            + this.annualInterest
            + ", negativeAmount="
            + this.negativeAmount
            + ")";
      }
   }
}
