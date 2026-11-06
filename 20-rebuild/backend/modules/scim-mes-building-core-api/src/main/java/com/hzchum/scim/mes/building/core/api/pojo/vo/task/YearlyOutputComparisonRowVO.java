package com.hzchum.scim.mes.building.core.api.pojo.vo.task;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "YearlyOutputComparisonMonthRowVO", description = "年度产量报表每月数据行数据")
public class YearlyOutputComparisonRowVO {
   @ApiModelProperty("构件类别")
   private String structureType;
   @ApiModelProperty("一月产量")
   private BigDecimal januaryOutput;
   @ApiModelProperty("二月产量")
   private BigDecimal februaryOutput;
   @ApiModelProperty("三月产量")
   private BigDecimal marchOutput;
   @ApiModelProperty("四月产量")
   private BigDecimal aprilOutput;
   @ApiModelProperty("五月产量")
   private BigDecimal mayOutput;
   @ApiModelProperty("六月产量")
   private BigDecimal juneOutput;
   @ApiModelProperty("1-6月产量")
   private BigDecimal firstHalfOutput;
   @ApiModelProperty("七月产量")
   private BigDecimal julyOutput;
   @ApiModelProperty("八月产量")
   private BigDecimal augustOutput;
   @ApiModelProperty("九月产量")
   private BigDecimal septemberOutput;
   @ApiModelProperty("十月产量")
   private BigDecimal octoberOutput;
   @ApiModelProperty("十一月产量")
   private BigDecimal novemberOutput;
   @ApiModelProperty("十二月产量")
   private BigDecimal decemberOutput;
   @ApiModelProperty("7-12月产量")
   private BigDecimal secondHalfOutput;
   @ApiModelProperty("全年")
   private BigDecimal yearlyOutput;

   public static YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder builder() {
      return new YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder();
   }

   public YearlyOutputComparisonRowVO() {
   }

   public YearlyOutputComparisonRowVO(
      final String structureType,
      final BigDecimal januaryOutput,
      final BigDecimal februaryOutput,
      final BigDecimal marchOutput,
      final BigDecimal aprilOutput,
      final BigDecimal mayOutput,
      final BigDecimal juneOutput,
      final BigDecimal firstHalfOutput,
      final BigDecimal julyOutput,
      final BigDecimal augustOutput,
      final BigDecimal septemberOutput,
      final BigDecimal octoberOutput,
      final BigDecimal novemberOutput,
      final BigDecimal decemberOutput,
      final BigDecimal secondHalfOutput,
      final BigDecimal yearlyOutput
   ) {
      this.structureType = structureType;
      this.januaryOutput = januaryOutput;
      this.februaryOutput = februaryOutput;
      this.marchOutput = marchOutput;
      this.aprilOutput = aprilOutput;
      this.mayOutput = mayOutput;
      this.juneOutput = juneOutput;
      this.firstHalfOutput = firstHalfOutput;
      this.julyOutput = julyOutput;
      this.augustOutput = augustOutput;
      this.septemberOutput = septemberOutput;
      this.octoberOutput = octoberOutput;
      this.novemberOutput = novemberOutput;
      this.decemberOutput = decemberOutput;
      this.secondHalfOutput = secondHalfOutput;
      this.yearlyOutput = yearlyOutput;
   }

   public String getStructureType() {
      return this.structureType;
   }

   public BigDecimal getJanuaryOutput() {
      return this.januaryOutput;
   }

   public BigDecimal getFebruaryOutput() {
      return this.februaryOutput;
   }

   public BigDecimal getMarchOutput() {
      return this.marchOutput;
   }

   public BigDecimal getAprilOutput() {
      return this.aprilOutput;
   }

   public BigDecimal getMayOutput() {
      return this.mayOutput;
   }

   public BigDecimal getJuneOutput() {
      return this.juneOutput;
   }

   public BigDecimal getFirstHalfOutput() {
      return this.firstHalfOutput;
   }

   public BigDecimal getJulyOutput() {
      return this.julyOutput;
   }

   public BigDecimal getAugustOutput() {
      return this.augustOutput;
   }

   public BigDecimal getSeptemberOutput() {
      return this.septemberOutput;
   }

   public BigDecimal getOctoberOutput() {
      return this.octoberOutput;
   }

   public BigDecimal getNovemberOutput() {
      return this.novemberOutput;
   }

   public BigDecimal getDecemberOutput() {
      return this.decemberOutput;
   }

   public BigDecimal getSecondHalfOutput() {
      return this.secondHalfOutput;
   }

   public BigDecimal getYearlyOutput() {
      return this.yearlyOutput;
   }

   public YearlyOutputComparisonRowVO setStructureType(final String structureType) {
      this.structureType = structureType;
      return this;
   }

   public YearlyOutputComparisonRowVO setJanuaryOutput(final BigDecimal januaryOutput) {
      this.januaryOutput = januaryOutput;
      return this;
   }

   public YearlyOutputComparisonRowVO setFebruaryOutput(final BigDecimal februaryOutput) {
      this.februaryOutput = februaryOutput;
      return this;
   }

   public YearlyOutputComparisonRowVO setMarchOutput(final BigDecimal marchOutput) {
      this.marchOutput = marchOutput;
      return this;
   }

   public YearlyOutputComparisonRowVO setAprilOutput(final BigDecimal aprilOutput) {
      this.aprilOutput = aprilOutput;
      return this;
   }

   public YearlyOutputComparisonRowVO setMayOutput(final BigDecimal mayOutput) {
      this.mayOutput = mayOutput;
      return this;
   }

   public YearlyOutputComparisonRowVO setJuneOutput(final BigDecimal juneOutput) {
      this.juneOutput = juneOutput;
      return this;
   }

   public YearlyOutputComparisonRowVO setFirstHalfOutput(final BigDecimal firstHalfOutput) {
      this.firstHalfOutput = firstHalfOutput;
      return this;
   }

   public YearlyOutputComparisonRowVO setJulyOutput(final BigDecimal julyOutput) {
      this.julyOutput = julyOutput;
      return this;
   }

   public YearlyOutputComparisonRowVO setAugustOutput(final BigDecimal augustOutput) {
      this.augustOutput = augustOutput;
      return this;
   }

   public YearlyOutputComparisonRowVO setSeptemberOutput(final BigDecimal septemberOutput) {
      this.septemberOutput = septemberOutput;
      return this;
   }

   public YearlyOutputComparisonRowVO setOctoberOutput(final BigDecimal octoberOutput) {
      this.octoberOutput = octoberOutput;
      return this;
   }

   public YearlyOutputComparisonRowVO setNovemberOutput(final BigDecimal novemberOutput) {
      this.novemberOutput = novemberOutput;
      return this;
   }

   public YearlyOutputComparisonRowVO setDecemberOutput(final BigDecimal decemberOutput) {
      this.decemberOutput = decemberOutput;
      return this;
   }

   public YearlyOutputComparisonRowVO setSecondHalfOutput(final BigDecimal secondHalfOutput) {
      this.secondHalfOutput = secondHalfOutput;
      return this;
   }

   public YearlyOutputComparisonRowVO setYearlyOutput(final BigDecimal yearlyOutput) {
      this.yearlyOutput = yearlyOutput;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof YearlyOutputComparisonRowVO)) {
         return false;
      }

      YearlyOutputComparisonRowVO other = (YearlyOutputComparisonRowVO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$structureType = this.getStructureType();
      Object other$structureType = other.getStructureType();
      if (this$structureType == null ? other$structureType == null : this$structureType.equals(other$structureType)) {
         Object this$januaryOutput = this.getJanuaryOutput();
         Object other$januaryOutput = other.getJanuaryOutput();
         if (this$januaryOutput == null ? other$januaryOutput == null : this$januaryOutput.equals(other$januaryOutput)) {
            Object this$februaryOutput = this.getFebruaryOutput();
            Object other$februaryOutput = other.getFebruaryOutput();
            if (this$februaryOutput == null ? other$februaryOutput == null : this$februaryOutput.equals(other$februaryOutput)) {
               Object this$marchOutput = this.getMarchOutput();
               Object other$marchOutput = other.getMarchOutput();
               if (this$marchOutput == null ? other$marchOutput == null : this$marchOutput.equals(other$marchOutput)) {
                  Object this$aprilOutput = this.getAprilOutput();
                  Object other$aprilOutput = other.getAprilOutput();
                  if (this$aprilOutput == null ? other$aprilOutput == null : this$aprilOutput.equals(other$aprilOutput)) {
                     Object this$mayOutput = this.getMayOutput();
                     Object other$mayOutput = other.getMayOutput();
                     if (this$mayOutput == null ? other$mayOutput == null : this$mayOutput.equals(other$mayOutput)) {
                        Object this$juneOutput = this.getJuneOutput();
                        Object other$juneOutput = other.getJuneOutput();
                        if (this$juneOutput == null ? other$juneOutput == null : this$juneOutput.equals(other$juneOutput)) {
                           Object this$firstHalfOutput = this.getFirstHalfOutput();
                           Object other$firstHalfOutput = other.getFirstHalfOutput();
                           if (this$firstHalfOutput == null ? other$firstHalfOutput == null : this$firstHalfOutput.equals(other$firstHalfOutput)) {
                              Object this$julyOutput = this.getJulyOutput();
                              Object other$julyOutput = other.getJulyOutput();
                              if (this$julyOutput == null ? other$julyOutput == null : this$julyOutput.equals(other$julyOutput)) {
                                 Object this$augustOutput = this.getAugustOutput();
                                 Object other$augustOutput = other.getAugustOutput();
                                 if (this$augustOutput == null ? other$augustOutput == null : this$augustOutput.equals(other$augustOutput)) {
                                    Object this$septemberOutput = this.getSeptemberOutput();
                                    Object other$septemberOutput = other.getSeptemberOutput();
                                    if (this$septemberOutput == null ? other$septemberOutput == null : this$septemberOutput.equals(other$septemberOutput)) {
                                       Object this$octoberOutput = this.getOctoberOutput();
                                       Object other$octoberOutput = other.getOctoberOutput();
                                       if (this$octoberOutput == null ? other$octoberOutput == null : this$octoberOutput.equals(other$octoberOutput)) {
                                          Object this$novemberOutput = this.getNovemberOutput();
                                          Object other$novemberOutput = other.getNovemberOutput();
                                          if (this$novemberOutput == null ? other$novemberOutput == null : this$novemberOutput.equals(other$novemberOutput)) {
                                             Object this$decemberOutput = this.getDecemberOutput();
                                             Object other$decemberOutput = other.getDecemberOutput();
                                             if (this$decemberOutput == null ? other$decemberOutput == null : this$decemberOutput.equals(other$decemberOutput)) {
                                                Object this$secondHalfOutput = this.getSecondHalfOutput();
                                                Object other$secondHalfOutput = other.getSecondHalfOutput();
                                                if (this$secondHalfOutput == null
                                                   ? other$secondHalfOutput == null
                                                   : this$secondHalfOutput.equals(other$secondHalfOutput)) {
                                                   Object this$yearlyOutput = this.getYearlyOutput();
                                                   Object other$yearlyOutput = other.getYearlyOutput();
                                                   return this$yearlyOutput == null ? other$yearlyOutput == null : this$yearlyOutput.equals(other$yearlyOutput);
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
      return other instanceof YearlyOutputComparisonRowVO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $structureType = this.getStructureType();
      result = result * 59 + ($structureType == null ? 43 : $structureType.hashCode());
      Object $januaryOutput = this.getJanuaryOutput();
      result = result * 59 + ($januaryOutput == null ? 43 : $januaryOutput.hashCode());
      Object $februaryOutput = this.getFebruaryOutput();
      result = result * 59 + ($februaryOutput == null ? 43 : $februaryOutput.hashCode());
      Object $marchOutput = this.getMarchOutput();
      result = result * 59 + ($marchOutput == null ? 43 : $marchOutput.hashCode());
      Object $aprilOutput = this.getAprilOutput();
      result = result * 59 + ($aprilOutput == null ? 43 : $aprilOutput.hashCode());
      Object $mayOutput = this.getMayOutput();
      result = result * 59 + ($mayOutput == null ? 43 : $mayOutput.hashCode());
      Object $juneOutput = this.getJuneOutput();
      result = result * 59 + ($juneOutput == null ? 43 : $juneOutput.hashCode());
      Object $firstHalfOutput = this.getFirstHalfOutput();
      result = result * 59 + ($firstHalfOutput == null ? 43 : $firstHalfOutput.hashCode());
      Object $julyOutput = this.getJulyOutput();
      result = result * 59 + ($julyOutput == null ? 43 : $julyOutput.hashCode());
      Object $augustOutput = this.getAugustOutput();
      result = result * 59 + ($augustOutput == null ? 43 : $augustOutput.hashCode());
      Object $septemberOutput = this.getSeptemberOutput();
      result = result * 59 + ($septemberOutput == null ? 43 : $septemberOutput.hashCode());
      Object $octoberOutput = this.getOctoberOutput();
      result = result * 59 + ($octoberOutput == null ? 43 : $octoberOutput.hashCode());
      Object $novemberOutput = this.getNovemberOutput();
      result = result * 59 + ($novemberOutput == null ? 43 : $novemberOutput.hashCode());
      Object $decemberOutput = this.getDecemberOutput();
      result = result * 59 + ($decemberOutput == null ? 43 : $decemberOutput.hashCode());
      Object $secondHalfOutput = this.getSecondHalfOutput();
      result = result * 59 + ($secondHalfOutput == null ? 43 : $secondHalfOutput.hashCode());
      Object $yearlyOutput = this.getYearlyOutput();
      return result * 59 + ($yearlyOutput == null ? 43 : $yearlyOutput.hashCode());
   }

   @Override
   public String toString() {
      return "YearlyOutputComparisonRowVO(structureType="
         + this.getStructureType()
         + ", januaryOutput="
         + this.getJanuaryOutput()
         + ", februaryOutput="
         + this.getFebruaryOutput()
         + ", marchOutput="
         + this.getMarchOutput()
         + ", aprilOutput="
         + this.getAprilOutput()
         + ", mayOutput="
         + this.getMayOutput()
         + ", juneOutput="
         + this.getJuneOutput()
         + ", firstHalfOutput="
         + this.getFirstHalfOutput()
         + ", julyOutput="
         + this.getJulyOutput()
         + ", augustOutput="
         + this.getAugustOutput()
         + ", septemberOutput="
         + this.getSeptemberOutput()
         + ", octoberOutput="
         + this.getOctoberOutput()
         + ", novemberOutput="
         + this.getNovemberOutput()
         + ", decemberOutput="
         + this.getDecemberOutput()
         + ", secondHalfOutput="
         + this.getSecondHalfOutput()
         + ", yearlyOutput="
         + this.getYearlyOutput()
         + ")";
   }

   public static class YearlyOutputComparisonRowVOBuilder {
      private String structureType;
      private BigDecimal januaryOutput;
      private BigDecimal februaryOutput;
      private BigDecimal marchOutput;
      private BigDecimal aprilOutput;
      private BigDecimal mayOutput;
      private BigDecimal juneOutput;
      private BigDecimal firstHalfOutput;
      private BigDecimal julyOutput;
      private BigDecimal augustOutput;
      private BigDecimal septemberOutput;
      private BigDecimal octoberOutput;
      private BigDecimal novemberOutput;
      private BigDecimal decemberOutput;
      private BigDecimal secondHalfOutput;
      private BigDecimal yearlyOutput;

      YearlyOutputComparisonRowVOBuilder() {
      }

      public YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder structureType(final String structureType) {
         this.structureType = structureType;
         return this;
      }

      public YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder januaryOutput(final BigDecimal januaryOutput) {
         this.januaryOutput = januaryOutput;
         return this;
      }

      public YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder februaryOutput(final BigDecimal februaryOutput) {
         this.februaryOutput = februaryOutput;
         return this;
      }

      public YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder marchOutput(final BigDecimal marchOutput) {
         this.marchOutput = marchOutput;
         return this;
      }

      public YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder aprilOutput(final BigDecimal aprilOutput) {
         this.aprilOutput = aprilOutput;
         return this;
      }

      public YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder mayOutput(final BigDecimal mayOutput) {
         this.mayOutput = mayOutput;
         return this;
      }

      public YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder juneOutput(final BigDecimal juneOutput) {
         this.juneOutput = juneOutput;
         return this;
      }

      public YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder firstHalfOutput(final BigDecimal firstHalfOutput) {
         this.firstHalfOutput = firstHalfOutput;
         return this;
      }

      public YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder julyOutput(final BigDecimal julyOutput) {
         this.julyOutput = julyOutput;
         return this;
      }

      public YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder augustOutput(final BigDecimal augustOutput) {
         this.augustOutput = augustOutput;
         return this;
      }

      public YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder septemberOutput(final BigDecimal septemberOutput) {
         this.septemberOutput = septemberOutput;
         return this;
      }

      public YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder octoberOutput(final BigDecimal octoberOutput) {
         this.octoberOutput = octoberOutput;
         return this;
      }

      public YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder novemberOutput(final BigDecimal novemberOutput) {
         this.novemberOutput = novemberOutput;
         return this;
      }

      public YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder decemberOutput(final BigDecimal decemberOutput) {
         this.decemberOutput = decemberOutput;
         return this;
      }

      public YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder secondHalfOutput(final BigDecimal secondHalfOutput) {
         this.secondHalfOutput = secondHalfOutput;
         return this;
      }

      public YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder yearlyOutput(final BigDecimal yearlyOutput) {
         this.yearlyOutput = yearlyOutput;
         return this;
      }

      public YearlyOutputComparisonRowVO build() {
         return new YearlyOutputComparisonRowVO(
            this.structureType,
            this.januaryOutput,
            this.februaryOutput,
            this.marchOutput,
            this.aprilOutput,
            this.mayOutput,
            this.juneOutput,
            this.firstHalfOutput,
            this.julyOutput,
            this.augustOutput,
            this.septemberOutput,
            this.octoberOutput,
            this.novemberOutput,
            this.decemberOutput,
            this.secondHalfOutput,
            this.yearlyOutput
         );
      }

      @Override
      public String toString() {
         return "YearlyOutputComparisonRowVO.YearlyOutputComparisonRowVOBuilder(structureType="
            + this.structureType
            + ", januaryOutput="
            + this.januaryOutput
            + ", februaryOutput="
            + this.februaryOutput
            + ", marchOutput="
            + this.marchOutput
            + ", aprilOutput="
            + this.aprilOutput
            + ", mayOutput="
            + this.mayOutput
            + ", juneOutput="
            + this.juneOutput
            + ", firstHalfOutput="
            + this.firstHalfOutput
            + ", julyOutput="
            + this.julyOutput
            + ", augustOutput="
            + this.augustOutput
            + ", septemberOutput="
            + this.septemberOutput
            + ", octoberOutput="
            + this.octoberOutput
            + ", novemberOutput="
            + this.novemberOutput
            + ", decemberOutput="
            + this.decemberOutput
            + ", secondHalfOutput="
            + this.secondHalfOutput
            + ", yearlyOutput="
            + this.yearlyOutput
            + ")";
      }
   }
}
