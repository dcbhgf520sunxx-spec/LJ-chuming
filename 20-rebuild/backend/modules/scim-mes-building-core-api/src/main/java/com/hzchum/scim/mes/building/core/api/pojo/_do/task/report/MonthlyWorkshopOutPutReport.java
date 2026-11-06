package com.hzchum.scim.mes.building.core.api.pojo._do.task.report;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "MonthlyWorkshopOutPutDO", description = "车间制作产量月报")
public class MonthlyWorkshopOutPutReport {
   private String serialNumber;
   private String projectName;
   private BigDecimal totalNetWeight;

   public static MonthlyWorkshopOutPutReport.MonthlyWorkshopOutPutReportBuilder builder() {
      return new MonthlyWorkshopOutPutReport.MonthlyWorkshopOutPutReportBuilder();
   }

   public MonthlyWorkshopOutPutReport() {
   }

   public MonthlyWorkshopOutPutReport(final String serialNumber, final String projectName, final BigDecimal totalNetWeight) {
      this.serialNumber = serialNumber;
      this.projectName = projectName;
      this.totalNetWeight = totalNetWeight;
   }

   public String getSerialNumber() {
      return this.serialNumber;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public BigDecimal getTotalNetWeight() {
      return this.totalNetWeight;
   }

   public MonthlyWorkshopOutPutReport setSerialNumber(final String serialNumber) {
      this.serialNumber = serialNumber;
      return this;
   }

   public MonthlyWorkshopOutPutReport setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public MonthlyWorkshopOutPutReport setTotalNetWeight(final BigDecimal totalNetWeight) {
      this.totalNetWeight = totalNetWeight;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MonthlyWorkshopOutPutReport)) {
         return false;
      }

      MonthlyWorkshopOutPutReport other = (MonthlyWorkshopOutPutReport)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$serialNumber = this.getSerialNumber();
      Object other$serialNumber = other.getSerialNumber();
      if (this$serialNumber == null ? other$serialNumber == null : this$serialNumber.equals(other$serialNumber)) {
         Object this$projectName = this.getProjectName();
         Object other$projectName = other.getProjectName();
         if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
            Object this$totalNetWeight = this.getTotalNetWeight();
            Object other$totalNetWeight = other.getTotalNetWeight();
            return this$totalNetWeight == null ? other$totalNetWeight == null : this$totalNetWeight.equals(other$totalNetWeight);
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MonthlyWorkshopOutPutReport;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $serialNumber = this.getSerialNumber();
      result = result * 59 + ($serialNumber == null ? 43 : $serialNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $totalNetWeight = this.getTotalNetWeight();
      return result * 59 + ($totalNetWeight == null ? 43 : $totalNetWeight.hashCode());
   }

   @Override
   public String toString() {
      return "MonthlyWorkshopOutPutReport(serialNumber="
         + this.getSerialNumber()
         + ", projectName="
         + this.getProjectName()
         + ", totalNetWeight="
         + this.getTotalNetWeight()
         + ")";
   }

   public static class MonthlyWorkshopOutPutReportBuilder {
      private String serialNumber;
      private String projectName;
      private BigDecimal totalNetWeight;

      MonthlyWorkshopOutPutReportBuilder() {
      }

      public MonthlyWorkshopOutPutReport.MonthlyWorkshopOutPutReportBuilder serialNumber(final String serialNumber) {
         this.serialNumber = serialNumber;
         return this;
      }

      public MonthlyWorkshopOutPutReport.MonthlyWorkshopOutPutReportBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public MonthlyWorkshopOutPutReport.MonthlyWorkshopOutPutReportBuilder totalNetWeight(final BigDecimal totalNetWeight) {
         this.totalNetWeight = totalNetWeight;
         return this;
      }

      public MonthlyWorkshopOutPutReport build() {
         return new MonthlyWorkshopOutPutReport(this.serialNumber, this.projectName, this.totalNetWeight);
      }

      @Override
      public String toString() {
         return "MonthlyWorkshopOutPutReport.MonthlyWorkshopOutPutReportBuilder(serialNumber="
            + this.serialNumber
            + ", projectName="
            + this.projectName
            + ", totalNetWeight="
            + this.totalNetWeight
            + ")";
      }
   }
}
