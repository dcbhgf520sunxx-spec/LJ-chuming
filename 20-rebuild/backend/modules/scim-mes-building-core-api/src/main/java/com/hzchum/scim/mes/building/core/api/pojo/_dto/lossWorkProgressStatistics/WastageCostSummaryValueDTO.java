package com.hzchum.scim.mes.building.core.api.pojo._dto.lossWorkProgressStatistics;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("损耗及在制品汇总值")
public class WastageCostSummaryValueDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("是否为当月")
   private Boolean boolNowMonth;
   @ApiModelProperty("汇总量")
   private BigDecimal productMonthOutput;
   @ApiModelProperty("年月份")
   private String yearMonth;
   @ApiModelProperty("产品枚举")
   private Integer lossWorkProgressStatisticsEnum;
   @ApiModelProperty("工序Id")
   private Long processId;
   @ApiModelProperty("工序名称")
   private String processName;
   @ApiModelProperty("产品类型")
   private Integer taskTypeEnum;

   public static WastageCostSummaryValueDTO.WastageCostSummaryValueDTOBuilder builder() {
      return new WastageCostSummaryValueDTO.WastageCostSummaryValueDTOBuilder();
   }

   public Boolean getBoolNowMonth() {
      return this.boolNowMonth;
   }

   public BigDecimal getProductMonthOutput() {
      return this.productMonthOutput;
   }

   public String getYearMonth() {
      return this.yearMonth;
   }

   public Integer getLossWorkProgressStatisticsEnum() {
      return this.lossWorkProgressStatisticsEnum;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getProcessName() {
      return this.processName;
   }

   public Integer getTaskTypeEnum() {
      return this.taskTypeEnum;
   }

   public void setBoolNowMonth(final Boolean boolNowMonth) {
      this.boolNowMonth = boolNowMonth;
   }

   public void setProductMonthOutput(final BigDecimal productMonthOutput) {
      this.productMonthOutput = productMonthOutput;
   }

   public void setYearMonth(final String yearMonth) {
      this.yearMonth = yearMonth;
   }

   public void setLossWorkProgressStatisticsEnum(final Integer lossWorkProgressStatisticsEnum) {
      this.lossWorkProgressStatisticsEnum = lossWorkProgressStatisticsEnum;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setProcessName(final String processName) {
      this.processName = processName;
   }

   public void setTaskTypeEnum(final Integer taskTypeEnum) {
      this.taskTypeEnum = taskTypeEnum;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WastageCostSummaryValueDTO)) {
         return false;
      }

      WastageCostSummaryValueDTO other = (WastageCostSummaryValueDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$boolNowMonth = this.getBoolNowMonth();
      Object other$boolNowMonth = other.getBoolNowMonth();
      if (this$boolNowMonth == null ? other$boolNowMonth == null : this$boolNowMonth.equals(other$boolNowMonth)) {
         Object this$lossWorkProgressStatisticsEnum = this.getLossWorkProgressStatisticsEnum();
         Object other$lossWorkProgressStatisticsEnum = other.getLossWorkProgressStatisticsEnum();
         if (this$lossWorkProgressStatisticsEnum == null
            ? other$lossWorkProgressStatisticsEnum == null
            : this$lossWorkProgressStatisticsEnum.equals(other$lossWorkProgressStatisticsEnum)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$taskTypeEnum = this.getTaskTypeEnum();
               Object other$taskTypeEnum = other.getTaskTypeEnum();
               if (this$taskTypeEnum == null ? other$taskTypeEnum == null : this$taskTypeEnum.equals(other$taskTypeEnum)) {
                  Object this$productMonthOutput = this.getProductMonthOutput();
                  Object other$productMonthOutput = other.getProductMonthOutput();
                  if (this$productMonthOutput == null ? other$productMonthOutput == null : this$productMonthOutput.equals(other$productMonthOutput)) {
                     Object this$yearMonth = this.getYearMonth();
                     Object other$yearMonth = other.getYearMonth();
                     if (this$yearMonth == null ? other$yearMonth == null : this$yearMonth.equals(other$yearMonth)) {
                        Object this$processName = this.getProcessName();
                        Object other$processName = other.getProcessName();
                        return this$processName == null ? other$processName == null : this$processName.equals(other$processName);
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
      return other instanceof WastageCostSummaryValueDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $boolNowMonth = this.getBoolNowMonth();
      result = result * 59 + ($boolNowMonth == null ? 43 : $boolNowMonth.hashCode());
      Object $lossWorkProgressStatisticsEnum = this.getLossWorkProgressStatisticsEnum();
      result = result * 59 + ($lossWorkProgressStatisticsEnum == null ? 43 : $lossWorkProgressStatisticsEnum.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $taskTypeEnum = this.getTaskTypeEnum();
      result = result * 59 + ($taskTypeEnum == null ? 43 : $taskTypeEnum.hashCode());
      Object $productMonthOutput = this.getProductMonthOutput();
      result = result * 59 + ($productMonthOutput == null ? 43 : $productMonthOutput.hashCode());
      Object $yearMonth = this.getYearMonth();
      result = result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
      Object $processName = this.getProcessName();
      return result * 59 + ($processName == null ? 43 : $processName.hashCode());
   }

   @Override
   public String toString() {
      return "WastageCostSummaryValueDTO(boolNowMonth="
         + this.getBoolNowMonth()
         + ", productMonthOutput="
         + this.getProductMonthOutput()
         + ", yearMonth="
         + this.getYearMonth()
         + ", lossWorkProgressStatisticsEnum="
         + this.getLossWorkProgressStatisticsEnum()
         + ", processId="
         + this.getProcessId()
         + ", processName="
         + this.getProcessName()
         + ", taskTypeEnum="
         + this.getTaskTypeEnum()
         + ")";
   }

   public WastageCostSummaryValueDTO() {
   }

   public WastageCostSummaryValueDTO(
      final Boolean boolNowMonth,
      final BigDecimal productMonthOutput,
      final String yearMonth,
      final Integer lossWorkProgressStatisticsEnum,
      final Long processId,
      final String processName,
      final Integer taskTypeEnum
   ) {
      this.boolNowMonth = boolNowMonth;
      this.productMonthOutput = productMonthOutput;
      this.yearMonth = yearMonth;
      this.lossWorkProgressStatisticsEnum = lossWorkProgressStatisticsEnum;
      this.processId = processId;
      this.processName = processName;
      this.taskTypeEnum = taskTypeEnum;
   }

   public static class WastageCostSummaryValueDTOBuilder {
      private Boolean boolNowMonth;
      private BigDecimal productMonthOutput;
      private String yearMonth;
      private Integer lossWorkProgressStatisticsEnum;
      private Long processId;
      private String processName;
      private Integer taskTypeEnum;

      WastageCostSummaryValueDTOBuilder() {
      }

      public WastageCostSummaryValueDTO.WastageCostSummaryValueDTOBuilder boolNowMonth(final Boolean boolNowMonth) {
         this.boolNowMonth = boolNowMonth;
         return this;
      }

      public WastageCostSummaryValueDTO.WastageCostSummaryValueDTOBuilder productMonthOutput(final BigDecimal productMonthOutput) {
         this.productMonthOutput = productMonthOutput;
         return this;
      }

      public WastageCostSummaryValueDTO.WastageCostSummaryValueDTOBuilder yearMonth(final String yearMonth) {
         this.yearMonth = yearMonth;
         return this;
      }

      public WastageCostSummaryValueDTO.WastageCostSummaryValueDTOBuilder lossWorkProgressStatisticsEnum(final Integer lossWorkProgressStatisticsEnum) {
         this.lossWorkProgressStatisticsEnum = lossWorkProgressStatisticsEnum;
         return this;
      }

      public WastageCostSummaryValueDTO.WastageCostSummaryValueDTOBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public WastageCostSummaryValueDTO.WastageCostSummaryValueDTOBuilder processName(final String processName) {
         this.processName = processName;
         return this;
      }

      public WastageCostSummaryValueDTO.WastageCostSummaryValueDTOBuilder taskTypeEnum(final Integer taskTypeEnum) {
         this.taskTypeEnum = taskTypeEnum;
         return this;
      }

      public WastageCostSummaryValueDTO build() {
         return new WastageCostSummaryValueDTO(
            this.boolNowMonth,
            this.productMonthOutput,
            this.yearMonth,
            this.lossWorkProgressStatisticsEnum,
            this.processId,
            this.processName,
            this.taskTypeEnum
         );
      }

      @Override
      public String toString() {
         return "WastageCostSummaryValueDTO.WastageCostSummaryValueDTOBuilder(boolNowMonth="
            + this.boolNowMonth
            + ", productMonthOutput="
            + this.productMonthOutput
            + ", yearMonth="
            + this.yearMonth
            + ", lossWorkProgressStatisticsEnum="
            + this.lossWorkProgressStatisticsEnum
            + ", processId="
            + this.processId
            + ", processName="
            + this.processName
            + ", taskTypeEnum="
            + this.taskTypeEnum
            + ")";
      }
   }
}
