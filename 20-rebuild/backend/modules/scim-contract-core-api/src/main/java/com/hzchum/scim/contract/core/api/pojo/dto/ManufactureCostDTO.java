package com.hzchum.scim.contract.core.api.pojo.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel("制造成本统计")
public class ManufactureCostDTO {
   private static final long serialVersionUID = 1L;
   @ApiModelProperty("立项日期")
   private String createTime;
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("项目名称")
   private String projectName;
   @ApiModelProperty("项目编号")
   private String serialNumber;
   @ApiModelProperty("项目状态")
   private Integer status;
   @ApiModelProperty("非主营业务收入")
   private BigDecimal nonMainBusinessIncome;
   @ApiModelProperty("主营业务收入")
   private BigDecimal mainBusinessIncome;
   @ApiModelProperty("收入合计")
   private BigDecimal incomeTotal;
   @ApiModelProperty("累计成本")
   private BigDecimal cumulativeCost;
   @ApiModelProperty("毛利润")
   private BigDecimal grossProfit;
   @ApiModelProperty("毛利率")
   private BigDecimal grossProfitRate;

   public static ManufactureCostDTO.ManufactureCostDTOBuilder builder() {
      return new ManufactureCostDTO.ManufactureCostDTOBuilder();
   }

   public String getCreateTime() {
      return this.createTime;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public Integer getStatus() {
      return this.status;
   }

   public BigDecimal getNonMainBusinessIncome() {
      return this.nonMainBusinessIncome;
   }

   public BigDecimal getMainBusinessIncome() {
      return this.mainBusinessIncome;
   }

   public BigDecimal getIncomeTotal() {
      return this.incomeTotal;
   }

   public BigDecimal getCumulativeCost() {
      return this.cumulativeCost;
   }

   public BigDecimal getGrossProfit() {
      return this.grossProfit;
   }

   public BigDecimal getGrossProfitRate() {
      return this.grossProfitRate;
   }

   public void setCreateTime(final String createTime) {
      this.createTime = createTime;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProjectName(final String projectName) {
      this.projectName = projectName;
   }

   public void setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
   }

   public void setStatus(final Integer status) {
      this.status = status;
   }

   public void setNonMainBusinessIncome(final BigDecimal nonMainBusinessIncome) {
      this.nonMainBusinessIncome = nonMainBusinessIncome;
   }

   public void setMainBusinessIncome(final BigDecimal mainBusinessIncome) {
      this.mainBusinessIncome = mainBusinessIncome;
   }

   public void setIncomeTotal(final BigDecimal incomeTotal) {
      this.incomeTotal = incomeTotal;
   }

   public void setCumulativeCost(final BigDecimal cumulativeCost) {
      this.cumulativeCost = cumulativeCost;
   }

   public void setGrossProfit(final BigDecimal grossProfit) {
      this.grossProfit = grossProfit;
   }

   public void setGrossProfitRate(final BigDecimal grossProfitRate) {
      this.grossProfitRate = grossProfitRate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ManufactureCostDTO)) {
         return false;
      }

      ManufactureCostDTO other = (ManufactureCostDTO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$status = this.getStatus();
         Object other$status = other.getStatus();
         if (this$status == null ? other$status == null : this$status.equals(other$status)) {
            Object this$createTime = this.getCreateTime();
            Object other$createTime = other.getCreateTime();
            if (this$createTime == null ? other$createTime == null : this$createTime.equals(other$createTime)) {
               Object this$projectName = this.getProjectName();
               Object other$projectName = other.getProjectName();
               if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
                  Object this$serialNumber = this.getSerialNumber();
                  Object other$serialNumber = other.getSerialNumber();
                  if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
                     Object this$nonMainBusinessIncome = this.getNonMainBusinessIncome();
                     Object other$nonMainBusinessIncome = other.getNonMainBusinessIncome();
                     if (this$nonMainBusinessIncome == null
                        ? other$nonMainBusinessIncome == null
                        : this$nonMainBusinessIncome.equals(other$nonMainBusinessIncome)) {
                        Object this$mainBusinessIncome = this.getMainBusinessIncome();
                        Object other$mainBusinessIncome = other.getMainBusinessIncome();
                        if (this$mainBusinessIncome == null ? other$mainBusinessIncome == null : this$mainBusinessIncome.equals(other$mainBusinessIncome)) {
                           Object this$incomeTotal = this.getIncomeTotal();
                           Object other$incomeTotal = other.getIncomeTotal();
                           if (this$incomeTotal == null ? other$incomeTotal == null : this$incomeTotal.equals(other$incomeTotal)) {
                              Object this$cumulativeCost = this.getCumulativeCost();
                              Object other$cumulativeCost = other.getCumulativeCost();
                              if (this$cumulativeCost == null ? other$cumulativeCost == null : this$cumulativeCost.equals(other$cumulativeCost)) {
                                 Object this$grossProfit = this.getGrossProfit();
                                 Object other$grossProfit = other.getGrossProfit();
                                 if (this$grossProfit == null ? other$grossProfit == null : this$grossProfit.equals(other$grossProfit)) {
                                    Object this$grossProfitRate = this.getGrossProfitRate();
                                    Object other$grossProfitRate = other.getGrossProfitRate();
                                    return this$grossProfitRate == null ? other$grossProfitRate == null : this$grossProfitRate.equals(other$grossProfitRate);
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
      return other instanceof ManufactureCostDTO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $status = this.getStatus();
      result = result * 59 + ($status == null ? 43 : $status.hashCode());
      Object $createTime = this.getCreateTime();
      result = result * 59 + ($createTime == null ? 43 : $createTime.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $nonMainBusinessIncome = this.getNonMainBusinessIncome();
      result = result * 59 + ($nonMainBusinessIncome == null ? 43 : $nonMainBusinessIncome.hashCode());
      Object $mainBusinessIncome = this.getMainBusinessIncome();
      result = result * 59 + ($mainBusinessIncome == null ? 43 : $mainBusinessIncome.hashCode());
      Object $incomeTotal = this.getIncomeTotal();
      result = result * 59 + ($incomeTotal == null ? 43 : $incomeTotal.hashCode());
      Object $cumulativeCost = this.getCumulativeCost();
      result = result * 59 + ($cumulativeCost == null ? 43 : $cumulativeCost.hashCode());
      Object $grossProfit = this.getGrossProfit();
      result = result * 59 + ($grossProfit == null ? 43 : $grossProfit.hashCode());
      Object $grossProfitRate = this.getGrossProfitRate();
      return result * 59 + ($grossProfitRate == null ? 43 : $grossProfitRate.hashCode());
   }

   @Override
   public String toString() {
      return "ManufactureCostDTO(createTime="
         + this.getCreateTime()
         + ", projectId="
         + this.getProjectId()
         + ", projectName="
         + this.getProjectName()
         + ", serialNumber="
         + this.getSerialNumber()
         + ", status="
         + this.getStatus()
         + ", nonMainBusinessIncome="
         + this.getNonMainBusinessIncome()
         + ", mainBusinessIncome="
         + this.getMainBusinessIncome()
         + ", incomeTotal="
         + this.getIncomeTotal()
         + ", cumulativeCost="
         + this.getCumulativeCost()
         + ", grossProfit="
         + this.getGrossProfit()
         + ", grossProfitRate="
         + this.getGrossProfitRate()
         + ")";
   }

   public ManufactureCostDTO() {
   }

   public ManufactureCostDTO(
      final String createTime,
      final Long projectId,
      final String projectName,
      final String serialNumber,
      final Integer status,
      final BigDecimal nonMainBusinessIncome,
      final BigDecimal mainBusinessIncome,
      final BigDecimal incomeTotal,
      final BigDecimal cumulativeCost,
      final BigDecimal grossProfit,
      final BigDecimal grossProfitRate
   ) {
      this.createTime = createTime;
      this.projectId = projectId;
      this.projectName = projectName;
      this.serialNumber = serialNumber;
      this.status = status;
      this.nonMainBusinessIncome = nonMainBusinessIncome;
      this.mainBusinessIncome = mainBusinessIncome;
      this.incomeTotal = incomeTotal;
      this.cumulativeCost = cumulativeCost;
      this.grossProfit = grossProfit;
      this.grossProfitRate = grossProfitRate;
   }

   public static class ManufactureCostDTOBuilder {
      private String createTime;
      private Long projectId;
      private String projectName;
      private String serialNumber;
      private Integer status;
      private BigDecimal nonMainBusinessIncome;
      private BigDecimal mainBusinessIncome;
      private BigDecimal incomeTotal;
      private BigDecimal cumulativeCost;
      private BigDecimal grossProfit;
      private BigDecimal grossProfitRate;

      ManufactureCostDTOBuilder() {
      }

      public ManufactureCostDTO.ManufactureCostDTOBuilder createTime(final String createTime) {
         this.createTime = createTime;
         return this;
      }

      public ManufactureCostDTO.ManufactureCostDTOBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public ManufactureCostDTO.ManufactureCostDTOBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public ManufactureCostDTO.ManufactureCostDTOBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public ManufactureCostDTO.ManufactureCostDTOBuilder status(final Integer status) {
         this.status = status;
         return this;
      }

      public ManufactureCostDTO.ManufactureCostDTOBuilder nonMainBusinessIncome(final BigDecimal nonMainBusinessIncome) {
         this.nonMainBusinessIncome = nonMainBusinessIncome;
         return this;
      }

      public ManufactureCostDTO.ManufactureCostDTOBuilder mainBusinessIncome(final BigDecimal mainBusinessIncome) {
         this.mainBusinessIncome = mainBusinessIncome;
         return this;
      }

      public ManufactureCostDTO.ManufactureCostDTOBuilder incomeTotal(final BigDecimal incomeTotal) {
         this.incomeTotal = incomeTotal;
         return this;
      }

      public ManufactureCostDTO.ManufactureCostDTOBuilder cumulativeCost(final BigDecimal cumulativeCost) {
         this.cumulativeCost = cumulativeCost;
         return this;
      }

      public ManufactureCostDTO.ManufactureCostDTOBuilder grossProfit(final BigDecimal grossProfit) {
         this.grossProfit = grossProfit;
         return this;
      }

      public ManufactureCostDTO.ManufactureCostDTOBuilder grossProfitRate(final BigDecimal grossProfitRate) {
         this.grossProfitRate = grossProfitRate;
         return this;
      }

      public ManufactureCostDTO build() {
         return new ManufactureCostDTO(
            this.createTime,
            this.projectId,
            this.projectName,
            this.serialNumber,
            this.status,
            this.nonMainBusinessIncome,
            this.mainBusinessIncome,
            this.incomeTotal,
            this.cumulativeCost,
            this.grossProfit,
            this.grossProfitRate
         );
      }

      @Override
      public String toString() {
         return "ManufactureCostDTO.ManufactureCostDTOBuilder(createTime="
            + this.createTime
            + ", projectId="
            + this.projectId
            + ", projectName="
            + this.projectName
            + ", serialNumber="
            + this.serialNumber
            + ", status="
            + this.status
            + ", nonMainBusinessIncome="
            + this.nonMainBusinessIncome
            + ", mainBusinessIncome="
            + this.mainBusinessIncome
            + ", incomeTotal="
            + this.incomeTotal
            + ", cumulativeCost="
            + this.cumulativeCost
            + ", grossProfit="
            + this.grossProfit
            + ", grossProfitRate="
            + this.grossProfitRate
            + ")";
      }
   }
}
