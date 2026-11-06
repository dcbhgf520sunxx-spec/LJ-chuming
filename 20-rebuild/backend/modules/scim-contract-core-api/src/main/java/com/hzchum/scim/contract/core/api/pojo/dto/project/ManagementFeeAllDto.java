package com.hzchum.scim.contract.core.api.pojo.dto.project;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@ApiOperation("成本报表返回表-管理费")
public class ManagementFeeAllDto {
   @ApiModelProperty("日期")
   private LocalDateTime createTime;
   @ApiModelProperty("编号")
   private String serialNumber;
   @ApiModelProperty("收入金额")
   private BigDecimal incomeAmount;
   @ApiModelProperty("管理费率")
   private String managementFeeRate;
   @ApiModelProperty("管理费")
   private BigDecimal managementFee;

   public static ManagementFeeAllDto.ManagementFeeAllDtoBuilder builder() {
      return new ManagementFeeAllDto.ManagementFeeAllDtoBuilder();
   }

   public LocalDateTime getCreateTime() {
      return this.createTime;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public BigDecimal getIncomeAmount() {
      return this.incomeAmount;
   }

   public String getManagementFeeRate() {
      return this.managementFeeRate;
   }

   public BigDecimal getManagementFee() {
      return this.managementFee;
   }

   public ManagementFeeAllDto setCreateTime(final LocalDateTime createTime) {
      this.createTime = createTime;
      return this;
   }

   public ManagementFeeAllDto setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public ManagementFeeAllDto setIncomeAmount(final BigDecimal incomeAmount) {
      this.incomeAmount = incomeAmount;
      return this;
   }

   public ManagementFeeAllDto setManagementFeeRate(final String managementFeeRate) {
      this.managementFeeRate = managementFeeRate;
      return this;
   }

   public ManagementFeeAllDto setManagementFee(final BigDecimal managementFee) {
      this.managementFee = managementFee;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ManagementFeeAllDto)) {
         return false;
      }

      ManagementFeeAllDto other = (ManagementFeeAllDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$createTime = this.getCreateTime();
      Object other$createTime = other.getCreateTime();
      if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
         Object this$serialNumber = this.getSerialNumber();
         Object other$serialNumber = other.getSerialNumber();
         if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
            Object this$incomeAmount = this.getIncomeAmount();
            Object other$incomeAmount = other.getIncomeAmount();
            if (this$incomeAmount == null ? other$incomeAmount == null : this$incomeAmount.equals(other$incomeAmount)) {
               Object this$managementFeeRate = this.getManagementFeeRate();
               Object other$managementFeeRate = other.getManagementFeeRate();
               if (this$managementFeeRate == null ? other$managementFeeRate == null : this$managementFeeRate.equals(other$managementFeeRate)) {
                  Object this$managementFee = this.getManagementFee();
                  Object other$managementFee = other.getManagementFee();
                  return this$managementFee == null ? other$managementFee == null : this$managementFee.equals(other$managementFee);
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
      return other instanceof ManagementFeeAllDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $incomeAmount = this.getIncomeAmount();
      result = result * 59 + ($incomeAmount == null ? 43 : $incomeAmount.hashCode());
      Object $managementFeeRate = this.getManagementFeeRate();
      result = result * 59 + ($managementFeeRate == null ? 43 : $managementFeeRate.hashCode());
      Object $managementFee = this.getManagementFee();
      return result * 59 + ($managementFee == null ? 43 : $managementFee.hashCode());
   }

   @Override
   public String toString() {
      return "ManagementFeeAllDto(createTime="
         + this.getCreateTime()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", incomeAmount="
         + this.getIncomeAmount()
         + ", managementFeeRate="
         + this.getManagementFeeRate()
         + ", managementFee="
         + this.getManagementFee()
         + ")";
   }

   public ManagementFeeAllDto(
      final LocalDateTime createTime, final String serialNumber, final BigDecimal incomeAmount, final String managementFeeRate, final BigDecimal managementFee
   ) {
      this.createTime = createTime;
      this.serialNumber = serialNumber;
      this.incomeAmount = incomeAmount;
      this.managementFeeRate = managementFeeRate;
      this.managementFee = managementFee;
   }

   public ManagementFeeAllDto() {
   }

   public static class ManagementFeeAllDtoBuilder {
      private LocalDateTime createTime;
      private String serialNumber;
      private BigDecimal incomeAmount;
      private String managementFeeRate;
      private BigDecimal managementFee;

      ManagementFeeAllDtoBuilder() {
      }

      public ManagementFeeAllDto.ManagementFeeAllDtoBuilder createTime(final LocalDateTime createTime) {
         this.createTime = createTime;
         return this;
      }

      public ManagementFeeAllDto.ManagementFeeAllDtoBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ManagementFeeAllDto.ManagementFeeAllDtoBuilder incomeAmount(final BigDecimal incomeAmount) {
         this.incomeAmount = incomeAmount;
         return this;
      }

      public ManagementFeeAllDto.ManagementFeeAllDtoBuilder managementFeeRate(final String managementFeeRate) {
         this.managementFeeRate = managementFeeRate;
         return this;
      }

      public ManagementFeeAllDto.ManagementFeeAllDtoBuilder managementFee(final BigDecimal managementFee) {
         this.managementFee = managementFee;
         return this;
      }

      public ManagementFeeAllDto build() {
         return new ManagementFeeAllDto(this.createTime, this.serialNumber, this.incomeAmount, this.managementFeeRate, this.managementFee);
      }

      @Override
      public String toString() {
         return "ManagementFeeAllDto.ManagementFeeAllDtoBuilder(createTime="
            + this.createTime
            + ", serialNumber="
            + this.serialNumber
            + ", incomeAmount="
            + this.incomeAmount
            + ", managementFeeRate="
            + this.managementFeeRate
            + ", managementFee="
            + this.managementFee
            + ")";
      }
   }
}
