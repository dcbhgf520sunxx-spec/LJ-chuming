package com.hzchum.scim.mes.building.core.api.pojo._do.report;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.hzchum.scim.mes.building.core.api.utils.CustomBigDecimalSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;

@ApiModel(value = "ReportWastageDO", description = "损耗统计报表 ")
public class ReportWastageDO {
   @ApiModelProperty(name = "totalYearProduction", value = "年度累计生产量（吨）")
   @JsonProperty("totalYearProduction")
   @JsonSerialize(using = CustomBigDecimalSerializer.class)
   private BigDecimal totalYearProduction = BigDecimal.ZERO;
   @ApiModelProperty(name = "totalYearSteelPicking", value = "年度累计钢材领用量（吨）")
   @JsonProperty("totalYearSteelPicking")
   @JsonSerialize(using = CustomBigDecimalSerializer.class)
   private BigDecimal totalYearSteelPicking = BigDecimal.ZERO;
   @ApiModelProperty(name = "totalYearWastage", value = "年度累计损耗量（吨）")
   @JsonProperty("totalYearWastage")
   @JsonSerialize(using = CustomBigDecimalSerializer.class)
   private BigDecimal totalYearWastage = BigDecimal.ZERO;
   @ApiModelProperty(name = "totalYearWastageRate", value = "年度平均损耗率（%）")
   @JsonProperty("totalYearWastageRate")
   private BigDecimal totalYearWastageRate = BigDecimal.ZERO;

   public static ReportWastageDO.ReportWastageDOBuilder builder() {
      return new ReportWastageDO.ReportWastageDOBuilder();
   }

   public ReportWastageDO() {
   }

   public ReportWastageDO(
      final BigDecimal totalYearProduction, final BigDecimal totalYearSteelPicking, final BigDecimal totalYearWastage, final BigDecimal totalYearWastageRate
   ) {
      this.totalYearProduction = totalYearProduction;
      this.totalYearSteelPicking = totalYearSteelPicking;
      this.totalYearWastage = totalYearWastage;
      this.totalYearWastageRate = totalYearWastageRate;
   }

   public BigDecimal getTotalYearProduction() {
      return this.totalYearProduction;
   }

   public BigDecimal getTotalYearSteelPicking() {
      return this.totalYearSteelPicking;
   }

   public BigDecimal getTotalYearWastage() {
      return this.totalYearWastage;
   }

   public BigDecimal getTotalYearWastageRate() {
      return this.totalYearWastageRate;
   }

   @JsonProperty("totalYearProduction")
   public ReportWastageDO setTotalYearProduction(final BigDecimal totalYearProduction) {
      this.totalYearProduction = totalYearProduction;
      return this;
   }

   @JsonProperty("totalYearSteelPicking")
   public ReportWastageDO setTotalYearSteelPicking(final BigDecimal totalYearSteelPicking) {
      this.totalYearSteelPicking = totalYearSteelPicking;
      return this;
   }

   @JsonProperty("totalYearWastage")
   public ReportWastageDO setTotalYearWastage(final BigDecimal totalYearWastage) {
      this.totalYearWastage = totalYearWastage;
      return this;
   }

   @JsonProperty("totalYearWastageRate")
   public ReportWastageDO setTotalYearWastageRate(final BigDecimal totalYearWastageRate) {
      this.totalYearWastageRate = totalYearWastageRate;
      return this;
   }

   @Override
   public String toString() {
      return "ReportWastageDO(totalYearProduction="
         + this.getTotalYearProduction()
         + ", totalYearSteelPicking="
         + this.getTotalYearSteelPicking()
         + ", totalYearWastage="
         + this.getTotalYearWastage()
         + ", totalYearWastageRate="
         + this.getTotalYearWastageRate()
         + ")";
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReportWastageDO)) {
         return false;
      }

      ReportWastageDO other = (ReportWastageDO)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$totalYearProduction = this.getTotalYearProduction();
      Object other$totalYearProduction = other.getTotalYearProduction();
      if (this$totalYearProduction == null ? other$totalYearProduction == null : this$totalYearProduction.equals(other$totalYearProduction)) {
         Object this$totalYearSteelPicking = this.getTotalYearSteelPicking();
         Object other$totalYearSteelPicking = other.getTotalYearSteelPicking();
         if (this$totalYearSteelPicking == null ? other$totalYearSteelPicking == null : this$totalYearSteelPicking.equals(other$totalYearSteelPicking)) {
            Object this$totalYearWastage = this.getTotalYearWastage();
            Object other$totalYearWastage = other.getTotalYearWastage();
            if (this$totalYearWastage == null ? other$totalYearWastage == null : this$totalYearWastage.equals(other$totalYearWastage)) {
               Object this$totalYearWastageRate = this.getTotalYearWastageRate();
               Object other$totalYearWastageRate = other.getTotalYearWastageRate();
               return this$totalYearWastageRate == null ? other$totalYearWastageRate == null : this$totalYearWastageRate.equals(other$totalYearWastageRate);
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
      return other instanceof ReportWastageDO;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $totalYearProduction = this.getTotalYearProduction();
      result = result * 59 + ($totalYearProduction == null ? 43 : $totalYearProduction.hashCode());
      Object $totalYearSteelPicking = this.getTotalYearSteelPicking();
      result = result * 59 + ($totalYearSteelPicking == null ? 43 : $totalYearSteelPicking.hashCode());
      Object $totalYearWastage = this.getTotalYearWastage();
      result = result * 59 + ($totalYearWastage == null ? 43 : $totalYearWastage.hashCode());
      Object $totalYearWastageRate = this.getTotalYearWastageRate();
      return result * 59 + ($totalYearWastageRate == null ? 43 : $totalYearWastageRate.hashCode());
   }

   public static class ReportWastageDOBuilder {
      private BigDecimal totalYearProduction;
      private BigDecimal totalYearSteelPicking;
      private BigDecimal totalYearWastage;
      private BigDecimal totalYearWastageRate;

      ReportWastageDOBuilder() {
      }

      @JsonProperty("totalYearProduction")
      public ReportWastageDO.ReportWastageDOBuilder totalYearProduction(final BigDecimal totalYearProduction) {
         this.totalYearProduction = totalYearProduction;
         return this;
      }

      @JsonProperty("totalYearSteelPicking")
      public ReportWastageDO.ReportWastageDOBuilder totalYearSteelPicking(final BigDecimal totalYearSteelPicking) {
         this.totalYearSteelPicking = totalYearSteelPicking;
         return this;
      }

      @JsonProperty("totalYearWastage")
      public ReportWastageDO.ReportWastageDOBuilder totalYearWastage(final BigDecimal totalYearWastage) {
         this.totalYearWastage = totalYearWastage;
         return this;
      }

      @JsonProperty("totalYearWastageRate")
      public ReportWastageDO.ReportWastageDOBuilder totalYearWastageRate(final BigDecimal totalYearWastageRate) {
         this.totalYearWastageRate = totalYearWastageRate;
         return this;
      }

      public ReportWastageDO build() {
         return new ReportWastageDO(this.totalYearProduction, this.totalYearSteelPicking, this.totalYearWastage, this.totalYearWastageRate);
      }

      @Override
      public String toString() {
         return "ReportWastageDO.ReportWastageDOBuilder(totalYearProduction="
            + this.totalYearProduction
            + ", totalYearSteelPicking="
            + this.totalYearSteelPicking
            + ", totalYearWastage="
            + this.totalYearWastage
            + ", totalYearWastageRate="
            + this.totalYearWastageRate
            + ")";
      }
   }
}
