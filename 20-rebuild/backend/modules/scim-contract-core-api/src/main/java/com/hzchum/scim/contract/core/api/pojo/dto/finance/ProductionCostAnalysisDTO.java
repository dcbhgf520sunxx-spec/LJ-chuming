package com.hzchum.scim.contract.core.api.pojo.dto.finance;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("生产成本分析-返回类")
public class ProductionCostAnalysisDTO {
   @ApiModelProperty("年份")
   private Integer year;
   @ApiModelProperty("月份")
   private Integer month;
   @ApiModelProperty("产量")
   private BigDecimal productionMete;
   @ApiModelProperty("人工费")
   private BigDecimal laborFee;
   @ApiModelProperty("辅材费")
   private BigDecimal auxiliaryFee;
   @ApiModelProperty("气体费")
   private BigDecimal gasFee;
   @ApiModelProperty("水电费")
   private BigDecimal waterElectricityFee;
   @ApiModelProperty("厂房折旧费")
   private BigDecimal plantDepreciationFee;
   @ApiModelProperty("设备折旧费")
   private BigDecimal deviceDepreciationFee;
   @ApiModelProperty("检测费")
   private BigDecimal testingFee;
   @ApiModelProperty("管理费")
   private BigDecimal managementFee;
   @ApiModelProperty("总费用")
   private BigDecimal totalFee;
   @ApiModelProperty("平均单价(金额/产量(t))")
   private BigDecimal avgProductionFee;
   @ApiModelProperty("考勤人数")
   private Integer attendanceQuantity;
   @ApiModelProperty("人均产量")
   private BigDecimal avgWorkerProductionMete;

   public static ProductionCostAnalysisDTO.ProductionCostAnalysisDTOBuilder builder() {
      return new ProductionCostAnalysisDTO.ProductionCostAnalysisDTOBuilder();
   }

   public ProductionCostAnalysisDTO() {
   }

   public ProductionCostAnalysisDTO(
      final Integer year,
      final Integer month,
      final BigDecimal productionMete,
      final BigDecimal laborFee,
      final BigDecimal auxiliaryFee,
      final BigDecimal gasFee,
      final BigDecimal waterElectricityFee,
      final BigDecimal plantDepreciationFee,
      final BigDecimal deviceDepreciationFee,
      final BigDecimal testingFee,
      final BigDecimal managementFee,
      final BigDecimal totalFee,
      final BigDecimal avgProductionFee,
      final Integer attendanceQuantity,
      final BigDecimal avgWorkerProductionMete
   ) {
      this.year = year;
      this.month = month;
      this.productionMete = productionMete;
      this.laborFee = laborFee;
      this.auxiliaryFee = auxiliaryFee;
      this.gasFee = gasFee;
      this.waterElectricityFee = waterElectricityFee;
      this.plantDepreciationFee = plantDepreciationFee;
      this.deviceDepreciationFee = deviceDepreciationFee;
      this.testingFee = testingFee;
      this.managementFee = managementFee;
      this.totalFee = totalFee;
      this.avgProductionFee = avgProductionFee;
      this.attendanceQuantity = attendanceQuantity;
      this.avgWorkerProductionMete = avgWorkerProductionMete;
   }

   public Integer getYear() {
      return this.year;
   }

   public Integer getMonth() {
      return this.month;
   }

   public BigDecimal getProductionMete() {
      return this.productionMete;
   }

   public BigDecimal getLaborFee() {
      return this.laborFee;
   }

   public BigDecimal getAuxiliaryFee() {
      return this.auxiliaryFee;
   }

   public BigDecimal getGasFee() {
      return this.gasFee;
   }

   public BigDecimal getWaterElectricityFee() {
      return this.waterElectricityFee;
   }

   public BigDecimal getPlantDepreciationFee() {
      return this.plantDepreciationFee;
   }

   public BigDecimal getDeviceDepreciationFee() {
      return this.deviceDepreciationFee;
   }

   public BigDecimal getTestingFee() {
      return this.testingFee;
   }

   public BigDecimal getManagementFee() {
      return this.managementFee;
   }

   public BigDecimal getTotalFee() {
      return this.totalFee;
   }

   public BigDecimal getAvgProductionFee() {
      return this.avgProductionFee;
   }

   public Integer getAttendanceQuantity() {
      return this.attendanceQuantity;
   }

   public BigDecimal getAvgWorkerProductionMete() {
      return this.avgWorkerProductionMete;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setMonth(final Integer month) {
      this.month = month;
   }

   public void setProductionMete(final BigDecimal productionMete) {
      this.productionMete = productionMete;
   }

   public void setLaborFee(final BigDecimal laborFee) {
      this.laborFee = laborFee;
   }

   public void setAuxiliaryFee(final BigDecimal auxiliaryFee) {
      this.auxiliaryFee = auxiliaryFee;
   }

   public void setGasFee(final BigDecimal gasFee) {
      this.gasFee = gasFee;
   }

   public void setWaterElectricityFee(final BigDecimal waterElectricityFee) {
      this.waterElectricityFee = waterElectricityFee;
   }

   public void setPlantDepreciationFee(final BigDecimal plantDepreciationFee) {
      this.plantDepreciationFee = plantDepreciationFee;
   }

   public void setDeviceDepreciationFee(final BigDecimal deviceDepreciationFee) {
      this.deviceDepreciationFee = deviceDepreciationFee;
   }

   public void setTestingFee(final BigDecimal testingFee) {
      this.testingFee = testingFee;
   }

   public void setManagementFee(final BigDecimal managementFee) {
      this.managementFee = managementFee;
   }

   public void setTotalFee(final BigDecimal totalFee) {
      this.totalFee = totalFee;
   }

   public void setAvgProductionFee(final BigDecimal avgProductionFee) {
      this.avgProductionFee = avgProductionFee;
   }

   public void setAttendanceQuantity(final Integer attendanceQuantity) {
      this.attendanceQuantity = attendanceQuantity;
   }

   public void setAvgWorkerProductionMete(final BigDecimal avgWorkerProductionMete) {
      this.avgWorkerProductionMete = avgWorkerProductionMete;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ProductionCostAnalysisDTO)) {
         return false;
      }

      ProductionCostAnalysisDTO other = (ProductionCostAnalysisDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$year = this.getYear();
      Object other$year = other.getYear();
      if (this$year == null ? other$year == null : this$year.equals(other$year)) {
         Object this$month = this.getMonth();
         Object other$month = other.getMonth();
         if (this$month == null ? other$month == null : this$month.equals(other$month)) {
            Object this$attendanceQuantity = this.getAttendanceQuantity();
            Object other$attendanceQuantity = other.getAttendanceQuantity();
            if (this$attendanceQuantity == null ? other$attendanceQuantity == null : this$attendanceQuantity.equals(other$attendanceQuantity)) {
               Object this$productionMete = this.getProductionMete();
               Object other$productionMete = other.getProductionMete();
               if (this$productionMete == null ? other$productionMete == null : this$productionMete.equals(other$productionMete)) {
                  Object this$laborFee = this.getLaborFee();
                  Object other$laborFee = other.getLaborFee();
                  if (this$laborFee == null ? other$laborFee == null : this$laborFee.equals(other$laborFee)) {
                     Object this$auxiliaryFee = this.getAuxiliaryFee();
                     Object other$auxiliaryFee = other.getAuxiliaryFee();
                     if (this$auxiliaryFee == null ? other$auxiliaryFee == null : this$auxiliaryFee.equals(other$auxiliaryFee)) {
                        Object this$gasFee = this.getGasFee();
                        Object other$gasFee = other.getGasFee();
                        if (this$gasFee == null ? other$gasFee == null : this$gasFee.equals(other$gasFee)) {
                           Object this$waterElectricityFee = this.getWaterElectricityFee();
                           Object other$waterElectricityFee = other.getWaterElectricityFee();
                           if (this$waterElectricityFee == null
                              ? other$waterElectricityFee == null
                              : this$waterElectricityFee.equals(other$waterElectricityFee)) {
                              Object this$plantDepreciationFee = this.getPlantDepreciationFee();
                              Object other$plantDepreciationFee = other.getPlantDepreciationFee();
                              if (this$plantDepreciationFee == null
                                 ? other$plantDepreciationFee == null
                                 : this$plantDepreciationFee.equals(other$plantDepreciationFee)) {
                                 Object this$deviceDepreciationFee = this.getDeviceDepreciationFee();
                                 Object other$deviceDepreciationFee = other.getDeviceDepreciationFee();
                                 if (this$deviceDepreciationFee == null
                                    ? other$deviceDepreciationFee == null
                                    : this$deviceDepreciationFee.equals(other$deviceDepreciationFee)) {
                                    Object this$testingFee = this.getTestingFee();
                                    Object other$testingFee = other.getTestingFee();
                                    if (this$testingFee == null ? other$testingFee == null : this$testingFee.equals(other$testingFee)) {
                                       Object this$managementFee = this.getManagementFee();
                                       Object other$managementFee = other.getManagementFee();
                                       if (this$managementFee == null ? other$managementFee == null : this$managementFee.equals(other$managementFee)) {
                                          Object this$totalFee = this.getTotalFee();
                                          Object other$totalFee = other.getTotalFee();
                                          if (this$totalFee == null ? other$totalFee == null : this$totalFee.equals(other$totalFee)) {
                                             Object this$avgProductionFee = this.getAvgProductionFee();
                                             Object other$avgProductionFee = other.getAvgProductionFee();
                                             if (this$avgProductionFee == null
                                                ? other$avgProductionFee == null
                                                : this$avgProductionFee.equals(other$avgProductionFee)) {
                                                Object this$avgWorkerProductionMete = this.getAvgWorkerProductionMete();
                                                Object other$avgWorkerProductionMete = other.getAvgWorkerProductionMete();
                                                return this$avgWorkerProductionMete == null
                                                   ? other$avgWorkerProductionMete == null
                                                   : this$avgWorkerProductionMete.equals(other$avgWorkerProductionMete);
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
      return other instanceof ProductionCostAnalysisDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $month = this.getMonth();
      result = result * 59 + ($month == null ? 43 : $month.hashCode());
      Object $attendanceQuantity = this.getAttendanceQuantity();
      result = result * 59 + ($attendanceQuantity == null ? 43 : $attendanceQuantity.hashCode());
      Object $productionMete = this.getProductionMete();
      result = result * 59 + ($productionMete == null ? 43 : $productionMete.hashCode());
      Object $laborFee = this.getLaborFee();
      result = result * 59 + ($laborFee == null ? 43 : $laborFee.hashCode());
      Object $auxiliaryFee = this.getAuxiliaryFee();
      result = result * 59 + ($auxiliaryFee == null ? 43 : $auxiliaryFee.hashCode());
      Object $gasFee = this.getGasFee();
      result = result * 59 + ($gasFee == null ? 43 : $gasFee.hashCode());
      Object $waterElectricityFee = this.getWaterElectricityFee();
      result = result * 59 + ($waterElectricityFee == null ? 43 : $waterElectricityFee.hashCode());
      Object $plantDepreciationFee = this.getPlantDepreciationFee();
      result = result * 59 + ($plantDepreciationFee == null ? 43 : $plantDepreciationFee.hashCode());
      Object $deviceDepreciationFee = this.getDeviceDepreciationFee();
      result = result * 59 + ($deviceDepreciationFee == null ? 43 : $deviceDepreciationFee.hashCode());
      Object $testingFee = this.getTestingFee();
      result = result * 59 + ($testingFee == null ? 43 : $testingFee.hashCode());
      Object $managementFee = this.getManagementFee();
      result = result * 59 + ($managementFee == null ? 43 : $managementFee.hashCode());
      Object $totalFee = this.getTotalFee();
      result = result * 59 + ($totalFee == null ? 43 : $totalFee.hashCode());
      Object $avgProductionFee = this.getAvgProductionFee();
      result = result * 59 + ($avgProductionFee == null ? 43 : $avgProductionFee.hashCode());
      Object $avgWorkerProductionMete = this.getAvgWorkerProductionMete();
      return result * 59 + ($avgWorkerProductionMete == null ? 43 : $avgWorkerProductionMete.hashCode());
   }

   @Override
   public String toString() {
      return "ProductionCostAnalysisDTO(year="
         + this.getYear()
         + ", month="
         + this.getMonth()
         + ", productionMete="
         + this.getProductionMete()
         + ", laborFee="
         + this.getLaborFee()
         + ", auxiliaryFee="
         + this.getAuxiliaryFee()
         + ", gasFee="
         + this.getGasFee()
         + ", waterElectricityFee="
         + this.getWaterElectricityFee()
         + ", plantDepreciationFee="
         + this.getPlantDepreciationFee()
         + ", deviceDepreciationFee="
         + this.getDeviceDepreciationFee()
         + ", testingFee="
         + this.getTestingFee()
         + ", managementFee="
         + this.getManagementFee()
         + ", totalFee="
         + this.getTotalFee()
         + ", avgProductionFee="
         + this.getAvgProductionFee()
         + ", attendanceQuantity="
         + this.getAttendanceQuantity()
         + ", avgWorkerProductionMete="
         + this.getAvgWorkerProductionMete()
         + ")";
   }

   public static class ProductionCostAnalysisDTOBuilder {
      private Integer year;
      private Integer month;
      private BigDecimal productionMete;
      private BigDecimal laborFee;
      private BigDecimal auxiliaryFee;
      private BigDecimal gasFee;
      private BigDecimal waterElectricityFee;
      private BigDecimal plantDepreciationFee;
      private BigDecimal deviceDepreciationFee;
      private BigDecimal testingFee;
      private BigDecimal managementFee;
      private BigDecimal totalFee;
      private BigDecimal avgProductionFee;
      private Integer attendanceQuantity;
      private BigDecimal avgWorkerProductionMete;

      ProductionCostAnalysisDTOBuilder() {
      }

      public ProductionCostAnalysisDTO.ProductionCostAnalysisDTOBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public ProductionCostAnalysisDTO.ProductionCostAnalysisDTOBuilder month(final Integer month) {
         this.month = month;
         return this;
      }

      public ProductionCostAnalysisDTO.ProductionCostAnalysisDTOBuilder productionMete(final BigDecimal productionMete) {
         this.productionMete = productionMete;
         return this;
      }

      public ProductionCostAnalysisDTO.ProductionCostAnalysisDTOBuilder laborFee(final BigDecimal laborFee) {
         this.laborFee = laborFee;
         return this;
      }

      public ProductionCostAnalysisDTO.ProductionCostAnalysisDTOBuilder auxiliaryFee(final BigDecimal auxiliaryFee) {
         this.auxiliaryFee = auxiliaryFee;
         return this;
      }

      public ProductionCostAnalysisDTO.ProductionCostAnalysisDTOBuilder gasFee(final BigDecimal gasFee) {
         this.gasFee = gasFee;
         return this;
      }

      public ProductionCostAnalysisDTO.ProductionCostAnalysisDTOBuilder waterElectricityFee(final BigDecimal waterElectricityFee) {
         this.waterElectricityFee = waterElectricityFee;
         return this;
      }

      public ProductionCostAnalysisDTO.ProductionCostAnalysisDTOBuilder plantDepreciationFee(final BigDecimal plantDepreciationFee) {
         this.plantDepreciationFee = plantDepreciationFee;
         return this;
      }

      public ProductionCostAnalysisDTO.ProductionCostAnalysisDTOBuilder deviceDepreciationFee(final BigDecimal deviceDepreciationFee) {
         this.deviceDepreciationFee = deviceDepreciationFee;
         return this;
      }

      public ProductionCostAnalysisDTO.ProductionCostAnalysisDTOBuilder testingFee(final BigDecimal testingFee) {
         this.testingFee = testingFee;
         return this;
      }

      public ProductionCostAnalysisDTO.ProductionCostAnalysisDTOBuilder managementFee(final BigDecimal managementFee) {
         this.managementFee = managementFee;
         return this;
      }

      public ProductionCostAnalysisDTO.ProductionCostAnalysisDTOBuilder totalFee(final BigDecimal totalFee) {
         this.totalFee = totalFee;
         return this;
      }

      public ProductionCostAnalysisDTO.ProductionCostAnalysisDTOBuilder avgProductionFee(final BigDecimal avgProductionFee) {
         this.avgProductionFee = avgProductionFee;
         return this;
      }

      public ProductionCostAnalysisDTO.ProductionCostAnalysisDTOBuilder attendanceQuantity(final Integer attendanceQuantity) {
         this.attendanceQuantity = attendanceQuantity;
         return this;
      }

      public ProductionCostAnalysisDTO.ProductionCostAnalysisDTOBuilder avgWorkerProductionMete(final BigDecimal avgWorkerProductionMete) {
         this.avgWorkerProductionMete = avgWorkerProductionMete;
         return this;
      }

      public ProductionCostAnalysisDTO build() {
         return new ProductionCostAnalysisDTO(
            this.year,
            this.month,
            this.productionMete,
            this.laborFee,
            this.auxiliaryFee,
            this.gasFee,
            this.waterElectricityFee,
            this.plantDepreciationFee,
            this.deviceDepreciationFee,
            this.testingFee,
            this.managementFee,
            this.totalFee,
            this.avgProductionFee,
            this.attendanceQuantity,
            this.avgWorkerProductionMete
         );
      }

      @Override
      public String toString() {
         return "ProductionCostAnalysisDTO.ProductionCostAnalysisDTOBuilder(year="
            + this.year
            + ", month="
            + this.month
            + ", productionMete="
            + this.productionMete
            + ", laborFee="
            + this.laborFee
            + ", auxiliaryFee="
            + this.auxiliaryFee
            + ", gasFee="
            + this.gasFee
            + ", waterElectricityFee="
            + this.waterElectricityFee
            + ", plantDepreciationFee="
            + this.plantDepreciationFee
            + ", deviceDepreciationFee="
            + this.deviceDepreciationFee
            + ", testingFee="
            + this.testingFee
            + ", managementFee="
            + this.managementFee
            + ", totalFee="
            + this.totalFee
            + ", avgProductionFee="
            + this.avgProductionFee
            + ", attendanceQuantity="
            + this.attendanceQuantity
            + ", avgWorkerProductionMete="
            + this.avgWorkerProductionMete
            + ")";
      }
   }
}
