package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import java.math.BigDecimal;

public class ContractTestingFeeStatisticsDto {
   private String projectCode;
   private BigDecimal yield;
   private Integer yclCheck;
   private Integer hjsbCheck;
   private Integer khyCheck;
   private Integer sjCheck;
   private Integer hfCheck;
   private Integer total;
   private BigDecimal avgMoney;

   public String getProjectCode() {
      return this.projectCode;
   }

   public BigDecimal getYield() {
      return this.yield;
   }

   public Integer getYclCheck() {
      return this.yclCheck;
   }

   public Integer getHjsbCheck() {
      return this.hjsbCheck;
   }

   public Integer getKhyCheck() {
      return this.khyCheck;
   }

   public Integer getSjCheck() {
      return this.sjCheck;
   }

   public Integer getHfCheck() {
      return this.hfCheck;
   }

   public Integer getTotal() {
      return this.total;
   }

   public BigDecimal getAvgMoney() {
      return this.avgMoney;
   }

   public void setProjectCode(final String projectCode) {
      this.projectCode = projectCode;
   }

   public void setYield(final BigDecimal yield) {
      this.yield = yield;
   }

   public void setYclCheck(final Integer yclCheck) {
      this.yclCheck = yclCheck;
   }

   public void setHjsbCheck(final Integer hjsbCheck) {
      this.hjsbCheck = hjsbCheck;
   }

   public void setKhyCheck(final Integer khyCheck) {
      this.khyCheck = khyCheck;
   }

   public void setSjCheck(final Integer sjCheck) {
      this.sjCheck = sjCheck;
   }

   public void setHfCheck(final Integer hfCheck) {
      this.hfCheck = hfCheck;
   }

   public void setTotal(final Integer total) {
      this.total = total;
   }

   public void setAvgMoney(final BigDecimal avgMoney) {
      this.avgMoney = avgMoney;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractTestingFeeStatisticsDto)) {
         return false;
      }

      ContractTestingFeeStatisticsDto other = (ContractTestingFeeStatisticsDto)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$yclCheck = this.getYclCheck();
      Object other$yclCheck = other.getYclCheck();
      if (this$yclCheck == null ? other$yclCheck == null : this$yclCheck.equals(other$yclCheck)) {
         Object this$hjsbCheck = this.getHjsbCheck();
         Object other$hjsbCheck = other.getHjsbCheck();
         if (this$hjsbCheck == null ? other$hjsbCheck == null : this$hjsbCheck.equals(other$hjsbCheck)) {
            Object this$khyCheck = this.getKhyCheck();
            Object other$khyCheck = other.getKhyCheck();
            if (this$khyCheck == null ? other$khyCheck == null : this$khyCheck.equals(other$khyCheck)) {
               Object this$sjCheck = this.getSjCheck();
               Object other$sjCheck = other.getSjCheck();
               if (this$sjCheck == null ? other$sjCheck == null : this$sjCheck.equals(other$sjCheck)) {
                  Object this$hfCheck = this.getHfCheck();
                  Object other$hfCheck = other.getHfCheck();
                  if (this$hfCheck == null ? other$hfCheck == null : this$hfCheck.equals(other$hfCheck)) {
                     Object this$total = this.getTotal();
                     Object other$total = other.getTotal();
                     if (this$total == null ? other$total == null : this$total.equals(other$total)) {
                        Object this$projectCode = this.getProjectCode();
                        Object other$projectCode = other.getProjectCode();
                        if (this$projectCode == null ? other$projectCode == null : this$projectCode.equals(other$projectCode)) {
                           Object this$yield = this.getYield();
                           Object other$yield = other.getYield();
                           if (this$yield == null ? other$yield == null : this$yield.equals(other$yield)) {
                              Object this$avgMoney = this.getAvgMoney();
                              Object other$avgMoney = other.getAvgMoney();
                              return this$avgMoney == null ? other$avgMoney == null : this$avgMoney.equals(other$avgMoney);
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
      return other instanceof ContractTestingFeeStatisticsDto;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $yclCheck = this.getYclCheck();
      result = result * 59 + ($yclCheck == null ? 43 : $yclCheck.hashCode());
      Object $hjsbCheck = this.getHjsbCheck();
      result = result * 59 + ($hjsbCheck == null ? 43 : $hjsbCheck.hashCode());
      Object $khyCheck = this.getKhyCheck();
      result = result * 59 + ($khyCheck == null ? 43 : $khyCheck.hashCode());
      Object $sjCheck = this.getSjCheck();
      result = result * 59 + ($sjCheck == null ? 43 : $sjCheck.hashCode());
      Object $hfCheck = this.getHfCheck();
      result = result * 59 + ($hfCheck == null ? 43 : $hfCheck.hashCode());
      Object $total = this.getTotal();
      result = result * 59 + ($total == null ? 43 : $total.hashCode());
      Object $projectCode = this.getProjectCode();
      result = result * 59 + ($projectCode == null ? 43 : $projectCode.hashCode());
      Object $yield = this.getYield();
      result = result * 59 + ($yield == null ? 43 : $yield.hashCode());
      Object $avgMoney = this.getAvgMoney();
      return result * 59 + ($avgMoney == null ? 43 : $avgMoney.hashCode());
   }

   @Override
   public String toString() {
      return "ContractTestingFeeStatisticsDto(projectCode="
         + this.getProjectCode()
         + ", yield="
         + this.getYield()
         + ", yclCheck="
         + this.getYclCheck()
         + ", hjsbCheck="
         + this.getHjsbCheck()
         + ", khyCheck="
         + this.getKhyCheck()
         + ", sjCheck="
         + this.getSjCheck()
         + ", hfCheck="
         + this.getHfCheck()
         + ", total="
         + this.getTotal()
         + ", avgMoney="
         + this.getAvgMoney()
         + ")";
   }

   public ContractTestingFeeStatisticsDto(
      final String projectCode,
      final BigDecimal yield,
      final Integer yclCheck,
      final Integer hjsbCheck,
      final Integer khyCheck,
      final Integer sjCheck,
      final Integer hfCheck,
      final Integer total,
      final BigDecimal avgMoney
   ) {
      this.projectCode = projectCode;
      this.yield = yield;
      this.yclCheck = yclCheck;
      this.hjsbCheck = hjsbCheck;
      this.khyCheck = khyCheck;
      this.sjCheck = sjCheck;
      this.hfCheck = hfCheck;
      this.total = total;
      this.avgMoney = avgMoney;
   }

   public ContractTestingFeeStatisticsDto() {
   }
}
