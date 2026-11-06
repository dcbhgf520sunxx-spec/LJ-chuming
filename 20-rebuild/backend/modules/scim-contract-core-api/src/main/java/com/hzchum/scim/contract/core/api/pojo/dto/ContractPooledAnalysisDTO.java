package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Map;

public class ContractPooledAnalysisDTO {
   @ApiModelProperty(name = "firstLevelDept", value = "所属一级部门")
   private Long firstLevelDept;
   @ApiModelProperty(name = "firstLevelDeptValue", value = "所属一级部门")
   private String firstLevelDeptValue;
   @ApiModelProperty(name = "secondLevelDept", value = "所属二级部门")
   private Long secondLevelDept;
   @ApiModelProperty(name = "secondLevelDeptValue", value = "所属二级部门")
   private String secondLevelDeptValue;
   @ApiModelProperty(name = "monthStr", value = "月份")
   private String monthStr;
   @ApiModelProperty(name = "signerName", value = "签订人姓名")
   private String signerName;
   @ApiModelProperty(name = "totalAmount", value = "总合同额")
   private BigDecimal totalAmount;
   @ApiModelProperty(name = "signAmount", value = "已签订合同额")
   private BigDecimal signAmount;
   @ApiModelProperty(name = "unSignAmount", value = "未签订合同额")
   private BigDecimal unSignAmount;
   @ApiModelProperty(name = "coordinateAmount", value = "配合项目")
   private BigDecimal coordinateAmount;
   @ApiModelProperty(name = "unCoordinateAmount", value = "自主承接")
   private BigDecimal unCoordinateAmount;
   @ApiModelProperty(name = "coordinateProjectAmount", value = "配合项目合同额")
   private BigDecimal coordinateProjectAmount;
   @ApiModelProperty(name = "lastYearAmount", value = "上年度合同额")
   private BigDecimal lastYearAmount;
   @ApiModelProperty(name = "targetAmount", value = "目标合同额")
   private BigDecimal targetAmount;
   @ApiModelProperty(name = "completeRate", value = "完成率")
   private BigDecimal completeRate;
   @ApiModelProperty(name = "mapAmount", value = "map金额")
   private Map<String, BigDecimal> mapAmount;

   ContractPooledAnalysisDTO(
      final Long firstLevelDept,
      final String firstLevelDeptValue,
      final Long secondLevelDept,
      final String secondLevelDeptValue,
      final String monthStr,
      final String signerName,
      final BigDecimal totalAmount,
      final BigDecimal signAmount,
      final BigDecimal unSignAmount,
      final BigDecimal coordinateAmount,
      final BigDecimal unCoordinateAmount,
      final BigDecimal coordinateProjectAmount,
      final BigDecimal lastYearAmount,
      final BigDecimal targetAmount,
      final BigDecimal completeRate,
      final Map<String, BigDecimal> mapAmount
   ) {
      this.firstLevelDept = firstLevelDept;
      this.firstLevelDeptValue = firstLevelDeptValue;
      this.secondLevelDept = secondLevelDept;
      this.secondLevelDeptValue = secondLevelDeptValue;
      this.monthStr = monthStr;
      this.signerName = signerName;
      this.totalAmount = totalAmount;
      this.signAmount = signAmount;
      this.unSignAmount = unSignAmount;
      this.coordinateAmount = coordinateAmount;
      this.unCoordinateAmount = unCoordinateAmount;
      this.coordinateProjectAmount = coordinateProjectAmount;
      this.lastYearAmount = lastYearAmount;
      this.targetAmount = targetAmount;
      this.completeRate = completeRate;
      this.mapAmount = mapAmount;
   }

   public static ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder builder() {
      return new ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder();
   }

   public Long getFirstLevelDept() {
      return this.firstLevelDept;
   }

   public String getFirstLevelDeptValue() {
      return this.firstLevelDeptValue;
   }

   public Long getSecondLevelDept() {
      return this.secondLevelDept;
   }

   public String getSecondLevelDeptValue() {
      return this.secondLevelDeptValue;
   }

   public String getMonthStr() {
      return this.monthStr;
   }

   public String getSignerName() {
      return this.signerName;
   }

   public BigDecimal getTotalAmount() {
      return this.totalAmount;
   }

   public BigDecimal getSignAmount() {
      return this.signAmount;
   }

   public BigDecimal getUnSignAmount() {
      return this.unSignAmount;
   }

   public BigDecimal getCoordinateAmount() {
      return this.coordinateAmount;
   }

   public BigDecimal getUnCoordinateAmount() {
      return this.unCoordinateAmount;
   }

   public BigDecimal getCoordinateProjectAmount() {
      return this.coordinateProjectAmount;
   }

   public BigDecimal getLastYearAmount() {
      return this.lastYearAmount;
   }

   public BigDecimal getTargetAmount() {
      return this.targetAmount;
   }

   public BigDecimal getCompleteRate() {
      return this.completeRate;
   }

   public Map<String, BigDecimal> getMapAmount() {
      return this.mapAmount;
   }

   public void setFirstLevelDept(final Long firstLevelDept) {
      this.firstLevelDept = firstLevelDept;
   }

   public void setFirstLevelDeptValue(final String firstLevelDeptValue) {
      this.firstLevelDeptValue = firstLevelDeptValue;
   }

   public void setSecondLevelDept(final Long secondLevelDept) {
      this.secondLevelDept = secondLevelDept;
   }

   public void setSecondLevelDeptValue(final String secondLevelDeptValue) {
      this.secondLevelDeptValue = secondLevelDeptValue;
   }

   public void setMonthStr(final String monthStr) {
      this.monthStr = monthStr;
   }

   public void setSignerName(final String signerName) {
      this.signerName = signerName;
   }

   public void setTotalAmount(final BigDecimal totalAmount) {
      this.totalAmount = totalAmount;
   }

   public void setSignAmount(final BigDecimal signAmount) {
      this.signAmount = signAmount;
   }

   public void setUnSignAmount(final BigDecimal unSignAmount) {
      this.unSignAmount = unSignAmount;
   }

   public void setCoordinateAmount(final BigDecimal coordinateAmount) {
      this.coordinateAmount = coordinateAmount;
   }

   public void setUnCoordinateAmount(final BigDecimal unCoordinateAmount) {
      this.unCoordinateAmount = unCoordinateAmount;
   }

   public void setCoordinateProjectAmount(final BigDecimal coordinateProjectAmount) {
      this.coordinateProjectAmount = coordinateProjectAmount;
   }

   public void setLastYearAmount(final BigDecimal lastYearAmount) {
      this.lastYearAmount = lastYearAmount;
   }

   public void setTargetAmount(final BigDecimal targetAmount) {
      this.targetAmount = targetAmount;
   }

   public void setCompleteRate(final BigDecimal completeRate) {
      this.completeRate = completeRate;
   }

   public void setMapAmount(final Map<String, BigDecimal> mapAmount) {
      this.mapAmount = mapAmount;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ContractPooledAnalysisDTO)) {
         return false;
      }

      ContractPooledAnalysisDTO other = (ContractPooledAnalysisDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$firstLevelDept = this.getFirstLevelDept();
      Object other$firstLevelDept = other.getFirstLevelDept();
      if (this$firstLevelDept == null ? other$firstLevelDept == null : this$firstLevelDept.equals(other$firstLevelDept)) {
         Object this$secondLevelDept = this.getSecondLevelDept();
         Object other$secondLevelDept = other.getSecondLevelDept();
         if (this$secondLevelDept == null ? other$secondLevelDept == null : this$secondLevelDept.equals(other$secondLevelDept)) {
            Object this$firstLevelDeptValue = this.getFirstLevelDeptValue();
            Object other$firstLevelDeptValue = other.getFirstLevelDeptValue();
            if (this$firstLevelDeptValue == null ? other$firstLevelDeptValue == null : this$firstLevelDeptValue.equals(other$firstLevelDeptValue)) {
               Object this$secondLevelDeptValue = this.getSecondLevelDeptValue();
               Object other$secondLevelDeptValue = other.getSecondLevelDeptValue();
               if (this$secondLevelDeptValue == null ? other$secondLevelDeptValue == null : this$secondLevelDeptValue.equals(other$secondLevelDeptValue)) {
                  Object this$monthStr = this.getMonthStr();
                  Object other$monthStr = other.getMonthStr();
                  if (this$monthStr == null ? other$monthStr == null : this$monthStr.equals(other$monthStr)) {
                     Object this$signerName = this.getSignerName();
                     Object other$signerName = other.getSignerName();
                     if (this$signerName == null ? other$signerName == null : this$signerName.equals(other$signerName)) {
                        Object this$totalAmount = this.getTotalAmount();
                        Object other$totalAmount = other.getTotalAmount();
                        if (this$totalAmount == null ? other$totalAmount == null : this$totalAmount.equals(other$totalAmount)) {
                           Object this$signAmount = this.getSignAmount();
                           Object other$signAmount = other.getSignAmount();
                           if (this$signAmount == null ? other$signAmount == null : this$signAmount.equals(other$signAmount)) {
                              Object this$unSignAmount = this.getUnSignAmount();
                              Object other$unSignAmount = other.getUnSignAmount();
                              if (this$unSignAmount == null ? other$unSignAmount == null : this$unSignAmount.equals(other$unSignAmount)) {
                                 Object this$coordinateAmount = this.getCoordinateAmount();
                                 Object other$coordinateAmount = other.getCoordinateAmount();
                                 if (this$coordinateAmount == null ? other$coordinateAmount == null : this$coordinateAmount.equals(other$coordinateAmount)) {
                                    Object this$unCoordinateAmount = this.getUnCoordinateAmount();
                                    Object other$unCoordinateAmount = other.getUnCoordinateAmount();
                                    if (this$unCoordinateAmount == null
                                       ? other$unCoordinateAmount == null
                                       : this$unCoordinateAmount.equals(other$unCoordinateAmount)) {
                                       Object this$coordinateProjectAmount = this.getCoordinateProjectAmount();
                                       Object other$coordinateProjectAmount = other.getCoordinateProjectAmount();
                                       if (this$coordinateProjectAmount == null
                                          ? other$coordinateProjectAmount == null
                                          : this$coordinateProjectAmount.equals(other$coordinateProjectAmount)) {
                                          Object this$lastYearAmount = this.getLastYearAmount();
                                          Object other$lastYearAmount = other.getLastYearAmount();
                                          if (this$lastYearAmount == null ? other$lastYearAmount == null : this$lastYearAmount.equals(other$lastYearAmount)) {
                                             Object this$targetAmount = this.getTargetAmount();
                                             Object other$targetAmount = other.getTargetAmount();
                                             if (this$targetAmount == null ? other$targetAmount == null : this$targetAmount.equals(other$targetAmount)) {
                                                Object this$completeRate = this.getCompleteRate();
                                                Object other$completeRate = other.getCompleteRate();
                                                if (this$completeRate == null ? other$completeRate == null : this$completeRate.equals(other$completeRate)) {
                                                   Object this$mapAmount = this.getMapAmount();
                                                   Object other$mapAmount = other.getMapAmount();
                                                   return this$mapAmount == null ? other$mapAmount == null : this$mapAmount.equals(other$mapAmount);
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
      return other instanceof ContractPooledAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $firstLevelDept = this.getFirstLevelDept();
      result = result * 59 + ($firstLevelDept == null ? 43 : $firstLevelDept.hashCode());
      Object $secondLevelDept = this.getSecondLevelDept();
      result = result * 59 + ($secondLevelDept == null ? 43 : $secondLevelDept.hashCode());
      Object $firstLevelDeptValue = this.getFirstLevelDeptValue();
      result = result * 59 + ($firstLevelDeptValue == null ? 43 : $firstLevelDeptValue.hashCode());
      Object $secondLevelDeptValue = this.getSecondLevelDeptValue();
      result = result * 59 + ($secondLevelDeptValue == null ? 43 : $secondLevelDeptValue.hashCode());
      Object $monthStr = this.getMonthStr();
      result = result * 59 + ($monthStr == null ? 43 : $monthStr.hashCode());
      Object $signerName = this.getSignerName();
      result = result * 59 + ($signerName == null ? 43 : $signerName.hashCode());
      Object $totalAmount = this.getTotalAmount();
      result = result * 59 + ($totalAmount == null ? 43 : $totalAmount.hashCode());
      Object $signAmount = this.getSignAmount();
      result = result * 59 + ($signAmount == null ? 43 : $signAmount.hashCode());
      Object $unSignAmount = this.getUnSignAmount();
      result = result * 59 + ($unSignAmount == null ? 43 : $unSignAmount.hashCode());
      Object $coordinateAmount = this.getCoordinateAmount();
      result = result * 59 + ($coordinateAmount == null ? 43 : $coordinateAmount.hashCode());
      Object $unCoordinateAmount = this.getUnCoordinateAmount();
      result = result * 59 + ($unCoordinateAmount == null ? 43 : $unCoordinateAmount.hashCode());
      Object $coordinateProjectAmount = this.getCoordinateProjectAmount();
      result = result * 59 + ($coordinateProjectAmount == null ? 43 : $coordinateProjectAmount.hashCode());
      Object $lastYearAmount = this.getLastYearAmount();
      result = result * 59 + ($lastYearAmount == null ? 43 : $lastYearAmount.hashCode());
      Object $targetAmount = this.getTargetAmount();
      result = result * 59 + ($targetAmount == null ? 43 : $targetAmount.hashCode());
      Object $completeRate = this.getCompleteRate();
      result = result * 59 + ($completeRate == null ? 43 : $completeRate.hashCode());
      Object $mapAmount = this.getMapAmount();
      return result * 59 + ($mapAmount == null ? 43 : $mapAmount.hashCode());
   }

   @Override
   public String toString() {
      return "ContractPooledAnalysisDTO(firstLevelDept="
         + this.getFirstLevelDept()
         + ", firstLevelDeptValue="
         + this.getFirstLevelDeptValue()
         + ", secondLevelDept="
         + this.getSecondLevelDept()
         + ", secondLevelDeptValue="
         + this.getSecondLevelDeptValue()
         + ", monthStr="
         + this.getMonthStr()
         + ", signerName="
         + this.getSignerName()
         + ", totalAmount="
         + this.getTotalAmount()
         + ", signAmount="
         + this.getSignAmount()
         + ", unSignAmount="
         + this.getUnSignAmount()
         + ", coordinateAmount="
         + this.getCoordinateAmount()
         + ", unCoordinateAmount="
         + this.getUnCoordinateAmount()
         + ", coordinateProjectAmount="
         + this.getCoordinateProjectAmount()
         + ", lastYearAmount="
         + this.getLastYearAmount()
         + ", targetAmount="
         + this.getTargetAmount()
         + ", completeRate="
         + this.getCompleteRate()
         + ", mapAmount="
         + this.getMapAmount()
         + ")";
   }

   public static class ContractPooledAnalysisDTOBuilder {
      private Long firstLevelDept;
      private String firstLevelDeptValue;
      private Long secondLevelDept;
      private String secondLevelDeptValue;
      private String monthStr;
      private String signerName;
      private BigDecimal totalAmount;
      private BigDecimal signAmount;
      private BigDecimal unSignAmount;
      private BigDecimal coordinateAmount;
      private BigDecimal unCoordinateAmount;
      private BigDecimal coordinateProjectAmount;
      private BigDecimal lastYearAmount;
      private BigDecimal targetAmount;
      private BigDecimal completeRate;
      private Map<String, BigDecimal> mapAmount;

      ContractPooledAnalysisDTOBuilder() {
      }

      public ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder firstLevelDept(final Long firstLevelDept) {
         this.firstLevelDept = firstLevelDept;
         return this;
      }

      public ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder firstLevelDeptValue(final String firstLevelDeptValue) {
         this.firstLevelDeptValue = firstLevelDeptValue;
         return this;
      }

      public ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder secondLevelDept(final Long secondLevelDept) {
         this.secondLevelDept = secondLevelDept;
         return this;
      }

      public ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder secondLevelDeptValue(final String secondLevelDeptValue) {
         this.secondLevelDeptValue = secondLevelDeptValue;
         return this;
      }

      public ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder monthStr(final String monthStr) {
         this.monthStr = monthStr;
         return this;
      }

      public ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder signerName(final String signerName) {
         this.signerName = signerName;
         return this;
      }

      public ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder totalAmount(final BigDecimal totalAmount) {
         this.totalAmount = totalAmount;
         return this;
      }

      public ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder signAmount(final BigDecimal signAmount) {
         this.signAmount = signAmount;
         return this;
      }

      public ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder unSignAmount(final BigDecimal unSignAmount) {
         this.unSignAmount = unSignAmount;
         return this;
      }

      public ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder coordinateAmount(final BigDecimal coordinateAmount) {
         this.coordinateAmount = coordinateAmount;
         return this;
      }

      public ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder unCoordinateAmount(final BigDecimal unCoordinateAmount) {
         this.unCoordinateAmount = unCoordinateAmount;
         return this;
      }

      public ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder coordinateProjectAmount(final BigDecimal coordinateProjectAmount) {
         this.coordinateProjectAmount = coordinateProjectAmount;
         return this;
      }

      public ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder lastYearAmount(final BigDecimal lastYearAmount) {
         this.lastYearAmount = lastYearAmount;
         return this;
      }

      public ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder targetAmount(final BigDecimal targetAmount) {
         this.targetAmount = targetAmount;
         return this;
      }

      public ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder completeRate(final BigDecimal completeRate) {
         this.completeRate = completeRate;
         return this;
      }

      public ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder mapAmount(final Map<String, BigDecimal> mapAmount) {
         this.mapAmount = mapAmount;
         return this;
      }

      public ContractPooledAnalysisDTO build() {
         return new ContractPooledAnalysisDTO(
            this.firstLevelDept,
            this.firstLevelDeptValue,
            this.secondLevelDept,
            this.secondLevelDeptValue,
            this.monthStr,
            this.signerName,
            this.totalAmount,
            this.signAmount,
            this.unSignAmount,
            this.coordinateAmount,
            this.unCoordinateAmount,
            this.coordinateProjectAmount,
            this.lastYearAmount,
            this.targetAmount,
            this.completeRate,
            this.mapAmount
         );
      }

      @Override
      public String toString() {
         return "ContractPooledAnalysisDTO.ContractPooledAnalysisDTOBuilder(firstLevelDept="
            + this.firstLevelDept
            + ", firstLevelDeptValue="
            + this.firstLevelDeptValue
            + ", secondLevelDept="
            + this.secondLevelDept
            + ", secondLevelDeptValue="
            + this.secondLevelDeptValue
            + ", monthStr="
            + this.monthStr
            + ", signerName="
            + this.signerName
            + ", totalAmount="
            + this.totalAmount
            + ", signAmount="
            + this.signAmount
            + ", unSignAmount="
            + this.unSignAmount
            + ", coordinateAmount="
            + this.coordinateAmount
            + ", unCoordinateAmount="
            + this.unCoordinateAmount
            + ", coordinateProjectAmount="
            + this.coordinateProjectAmount
            + ", lastYearAmount="
            + this.lastYearAmount
            + ", targetAmount="
            + this.targetAmount
            + ", completeRate="
            + this.completeRate
            + ", mapAmount="
            + this.mapAmount
            + ")";
      }
   }
}
