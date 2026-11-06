package com.hzchum.scim.contract.core.api.pojo.dto;

import com.hzchum.scim.contract.core.api.pojo._do.CommonDetailsDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

@ApiModel("制造成本统计-摊销DTO")
public class ManufactureCostAmortizationDTO {
   @ApiModelProperty("年月")
   private String yearMonth;
   @ApiModelProperty("总产量(吨)")
   private BigDecimal totalYield;
   @ApiModelProperty("项目产量(吨)")
   private BigDecimal projectYield;
   @ApiModelProperty("占比")
   private BigDecimal proportion;
   @ApiModelProperty("总金额(元)")
   private BigDecimal totalFee;
   @ApiModelProperty("摊销金额(元)")
   private BigDecimal amortizationAmount;
   @ApiModelProperty("辅材明细List")
   private List<Map<String, List<CommonDetailsDO>>> auxiliaryMaterialDetailList;

   public String getYearMonth() {
      return this.yearMonth;
   }

   public BigDecimal getTotalYield() {
      return this.totalYield;
   }

   public BigDecimal getProjectYield() {
      return this.projectYield;
   }

   public BigDecimal getProportion() {
      return this.proportion;
   }

   public BigDecimal getTotalFee() {
      return this.totalFee;
   }

   public BigDecimal getAmortizationAmount() {
      return this.amortizationAmount;
   }

   public List<Map<String, List<CommonDetailsDO>>> getAuxiliaryMaterialDetailList() {
      return this.auxiliaryMaterialDetailList;
   }

   public void setYearMonth(final String yearMonth) {
      this.yearMonth = yearMonth;
   }

   public void setTotalYield(final BigDecimal totalYield) {
      this.totalYield = totalYield;
   }

   public void setProjectYield(final BigDecimal projectYield) {
      this.projectYield = projectYield;
   }

   public void setProportion(final BigDecimal proportion) {
      this.proportion = proportion;
   }

   public void setTotalFee(final BigDecimal totalFee) {
      this.totalFee = totalFee;
   }

   public void setAmortizationAmount(final BigDecimal amortizationAmount) {
      this.amortizationAmount = amortizationAmount;
   }

   public void setAuxiliaryMaterialDetailList(final List<Map<String, List<CommonDetailsDO>>> auxiliaryMaterialDetailList) {
      this.auxiliaryMaterialDetailList = auxiliaryMaterialDetailList;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ManufactureCostAmortizationDTO)) {
         return false;
      }

      ManufactureCostAmortizationDTO other = (ManufactureCostAmortizationDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$yearMonth = this.getYearMonth();
      Object other$yearMonth = other.getYearMonth();
      if (this$yearMonth == null ? other$yearMonth == null : this$yearMonth.equals(other$yearMonth)) {
         Object this$totalYield = this.getTotalYield();
         Object other$totalYield = other.getTotalYield();
         if (this$totalYield == null ? other$totalYield == null : this$totalYield.equals(other$totalYield)) {
            Object this$projectYield = this.getProjectYield();
            Object other$projectYield = other.getProjectYield();
            if (this$projectYield == null ? other$projectYield == null : this$projectYield.equals(other$projectYield)) {
               Object this$proportion = this.getProportion();
               Object other$proportion = other.getProportion();
               if (this$proportion == null ? other$proportion == null : this$proportion.equals(other$proportion)) {
                  Object this$totalFee = this.getTotalFee();
                  Object other$totalFee = other.getTotalFee();
                  if (this$totalFee == null ? other$totalFee == null : this$totalFee.equals(other$totalFee)) {
                     Object this$amortizationAmount = this.getAmortizationAmount();
                     Object other$amortizationAmount = other.getAmortizationAmount();
                     if (this$amortizationAmount == null ? other$amortizationAmount == null : this$amortizationAmount.equals(other$amortizationAmount)) {
                        Object this$auxiliaryMaterialDetailList = this.getAuxiliaryMaterialDetailList();
                        Object other$auxiliaryMaterialDetailList = other.getAuxiliaryMaterialDetailList();
                        return this$auxiliaryMaterialDetailList == null
                           ? other$auxiliaryMaterialDetailList == null
                           : this$auxiliaryMaterialDetailList.equals(other$auxiliaryMaterialDetailList);
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
      return other instanceof ManufactureCostAmortizationDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $yearMonth = this.getYearMonth();
      result = result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
      Object $totalYield = this.getTotalYield();
      result = result * 59 + ($totalYield == null ? 43 : $totalYield.hashCode());
      Object $projectYield = this.getProjectYield();
      result = result * 59 + ($projectYield == null ? 43 : $projectYield.hashCode());
      Object $proportion = this.getProportion();
      result = result * 59 + ($proportion == null ? 43 : $proportion.hashCode());
      Object $totalFee = this.getTotalFee();
      result = result * 59 + ($totalFee == null ? 43 : $totalFee.hashCode());
      Object $amortizationAmount = this.getAmortizationAmount();
      result = result * 59 + ($amortizationAmount == null ? 43 : $amortizationAmount.hashCode());
      Object $auxiliaryMaterialDetailList = this.getAuxiliaryMaterialDetailList();
      return result * 59 + ($auxiliaryMaterialDetailList == null ? 43 : $auxiliaryMaterialDetailList.hashCode());
   }

   @Override
   public String toString() {
      return "ManufactureCostAmortizationDTO(yearMonth="
         + this.getYearMonth()
         + ", totalYield="
         + this.getTotalYield()
         + ", projectYield="
         + this.getProjectYield()
         + ", proportion="
         + this.getProportion()
         + ", totalFee="
         + this.getTotalFee()
         + ", amortizationAmount="
         + this.getAmortizationAmount()
         + ", auxiliaryMaterialDetailList="
         + this.getAuxiliaryMaterialDetailList()
         + ")";
   }
}
