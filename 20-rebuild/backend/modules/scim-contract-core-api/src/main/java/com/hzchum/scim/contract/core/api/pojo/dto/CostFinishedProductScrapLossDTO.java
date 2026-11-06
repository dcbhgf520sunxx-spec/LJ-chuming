package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("制成品报废损失")
public class CostFinishedProductScrapLossDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("年月")
   private String yearMonth;
   @ApiModelProperty("报废量（吨）")
   private BigDecimal scrapAmount;
   @ApiModelProperty("报废金额（元）")
   private BigDecimal scrapAmountMoney;

   public String getYearMonth() {
      return this.yearMonth;
   }

   public BigDecimal getScrapAmount() {
      return this.scrapAmount;
   }

   public BigDecimal getScrapAmountMoney() {
      return this.scrapAmountMoney;
   }

   public void setYearMonth(final String yearMonth) {
      this.yearMonth = yearMonth;
   }

   public void setScrapAmount(final BigDecimal scrapAmount) {
      this.scrapAmount = scrapAmount;
   }

   public void setScrapAmountMoney(final BigDecimal scrapAmountMoney) {
      this.scrapAmountMoney = scrapAmountMoney;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof CostFinishedProductScrapLossDTO)) {
         return false;
      }

      CostFinishedProductScrapLossDTO other = (CostFinishedProductScrapLossDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$yearMonth = this.getYearMonth();
      Object other$yearMonth = other.getYearMonth();
      if (this$yearMonth == null ? other$yearMonth == null : this$yearMonth.equals(other$yearMonth)) {
         Object this$scrapAmount = this.getScrapAmount();
         Object other$scrapAmount = other.getScrapAmount();
         if (this$scrapAmount == null ? other$scrapAmount == null : this$scrapAmount.equals(other$scrapAmount)) {
            Object this$scrapAmountMoney = this.getScrapAmountMoney();
            Object other$scrapAmountMoney = other.getScrapAmountMoney();
            return this$scrapAmountMoney == null ? other$scrapAmountMoney == null : this$scrapAmountMoney.equals(other$scrapAmountMoney);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof CostFinishedProductScrapLossDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $yearMonth = this.getYearMonth();
      result = result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
      Object $scrapAmount = this.getScrapAmount();
      result = result * 59 + ($scrapAmount == null ? 43 : $scrapAmount.hashCode());
      Object $scrapAmountMoney = this.getScrapAmountMoney();
      return result * 59 + ($scrapAmountMoney == null ? 43 : $scrapAmountMoney.hashCode());
   }

   @Override
   public String toString() {
      return "CostFinishedProductScrapLossDTO(yearMonth="
         + this.getYearMonth()
         + ", scrapAmount="
         + this.getScrapAmount()
         + ", scrapAmountMoney="
         + this.getScrapAmountMoney()
         + ")";
   }

   public CostFinishedProductScrapLossDTO() {
   }

   public CostFinishedProductScrapLossDTO(final String yearMonth, final BigDecimal scrapAmount, final BigDecimal scrapAmountMoney) {
      this.yearMonth = yearMonth;
      this.scrapAmount = scrapAmount;
      this.scrapAmountMoney = scrapAmountMoney;
   }
}
