package com.hzchum.scim.mes.building.core.api.pojo._do.task.report;

import io.swagger.annotations.ApiModel;
import java.math.BigDecimal;

@ApiModel(value = "FinishedProductWarehousingSummaryDO", description = "成品入库汇总(按月查询)")
public class FinishedProductWarehousingSummaryDetailReport {
   private Integer typeNumber;
   private String projectName;
   private BigDecimal beginPutPart;
   private BigDecimal beginFinishProduct;
   private BigDecimal beginHalfProduct;
   private BigDecimal beginConvertFinishProduct;
   private BigDecimal thisMonthPutPart;
   private BigDecimal thisMonthFinishProduct;
   private BigDecimal thisMonthHalfProduct;
   private BigDecimal thisMonthConvertFinishProduct;
   private BigDecimal totalPutPart;
   private BigDecimal totalFinishProduct;
   private BigDecimal thisMonthFinishOutput;
   private String workRemark;

   public static FinishedProductWarehousingSummaryDetailReport.FinishedProductWarehousingSummaryDetailReportBuilder builder() {
      return new FinishedProductWarehousingSummaryDetailReport.FinishedProductWarehousingSummaryDetailReportBuilder();
   }

   public FinishedProductWarehousingSummaryDetailReport() {
   }

   public FinishedProductWarehousingSummaryDetailReport(
      final Integer typeNumber,
      final String projectName,
      final BigDecimal beginPutPart,
      final BigDecimal beginFinishProduct,
      final BigDecimal beginHalfProduct,
      final BigDecimal beginConvertFinishProduct,
      final BigDecimal thisMonthPutPart,
      final BigDecimal thisMonthFinishProduct,
      final BigDecimal thisMonthHalfProduct,
      final BigDecimal thisMonthConvertFinishProduct,
      final BigDecimal totalPutPart,
      final BigDecimal totalFinishProduct,
      final BigDecimal thisMonthFinishOutput,
      final String workRemark
   ) {
      this.typeNumber = typeNumber;
      this.projectName = projectName;
      this.beginPutPart = beginPutPart;
      this.beginFinishProduct = beginFinishProduct;
      this.beginHalfProduct = beginHalfProduct;
      this.beginConvertFinishProduct = beginConvertFinishProduct;
      this.thisMonthPutPart = thisMonthPutPart;
      this.thisMonthFinishProduct = thisMonthFinishProduct;
      this.thisMonthHalfProduct = thisMonthHalfProduct;
      this.thisMonthConvertFinishProduct = thisMonthConvertFinishProduct;
      this.totalPutPart = totalPutPart;
      this.totalFinishProduct = totalFinishProduct;
      this.thisMonthFinishOutput = thisMonthFinishOutput;
      this.workRemark = workRemark;
   }

   public Integer getTypeNumber() {
      return this.typeNumber;
   }

   public String getProjectName() {
      return this.projectName;
   }

   public BigDecimal getBeginPutPart() {
      return this.beginPutPart;
   }

   public BigDecimal getBeginFinishProduct() {
      return this.beginFinishProduct;
   }

   public BigDecimal getBeginHalfProduct() {
      return this.beginHalfProduct;
   }

   public BigDecimal getBeginConvertFinishProduct() {
      return this.beginConvertFinishProduct;
   }

   public BigDecimal getThisMonthPutPart() {
      return this.thisMonthPutPart;
   }

   public BigDecimal getThisMonthFinishProduct() {
      return this.thisMonthFinishProduct;
   }

   public BigDecimal getThisMonthHalfProduct() {
      return this.thisMonthHalfProduct;
   }

   public BigDecimal getThisMonthConvertFinishProduct() {
      return this.thisMonthConvertFinishProduct;
   }

   public BigDecimal getTotalPutPart() {
      return this.totalPutPart;
   }

   public BigDecimal getTotalFinishProduct() {
      return this.totalFinishProduct;
   }

   public BigDecimal getThisMonthFinishOutput() {
      return this.thisMonthFinishOutput;
   }

   public String getWorkRemark() {
      return this.workRemark;
   }

   public FinishedProductWarehousingSummaryDetailReport setTypeNumber(final Integer typeNumber) {
      this.typeNumber = typeNumber;
      return this;
   }

   public FinishedProductWarehousingSummaryDetailReport setProjectName(final String projectName) {
      this.projectName = projectName;
      return this;
   }

   public FinishedProductWarehousingSummaryDetailReport setBeginPutPart(final BigDecimal beginPutPart) {
      this.beginPutPart = beginPutPart;
      return this;
   }

   public FinishedProductWarehousingSummaryDetailReport setBeginFinishProduct(final BigDecimal beginFinishProduct) {
      this.beginFinishProduct = beginFinishProduct;
      return this;
   }

   public FinishedProductWarehousingSummaryDetailReport setBeginHalfProduct(final BigDecimal beginHalfProduct) {
      this.beginHalfProduct = beginHalfProduct;
      return this;
   }

   public FinishedProductWarehousingSummaryDetailReport setBeginConvertFinishProduct(final BigDecimal beginConvertFinishProduct) {
      this.beginConvertFinishProduct = beginConvertFinishProduct;
      return this;
   }

   public FinishedProductWarehousingSummaryDetailReport setThisMonthPutPart(final BigDecimal thisMonthPutPart) {
      this.thisMonthPutPart = thisMonthPutPart;
      return this;
   }

   public FinishedProductWarehousingSummaryDetailReport setThisMonthFinishProduct(final BigDecimal thisMonthFinishProduct) {
      this.thisMonthFinishProduct = thisMonthFinishProduct;
      return this;
   }

   public FinishedProductWarehousingSummaryDetailReport setThisMonthHalfProduct(final BigDecimal thisMonthHalfProduct) {
      this.thisMonthHalfProduct = thisMonthHalfProduct;
      return this;
   }

   public FinishedProductWarehousingSummaryDetailReport setThisMonthConvertFinishProduct(final BigDecimal thisMonthConvertFinishProduct) {
      this.thisMonthConvertFinishProduct = thisMonthConvertFinishProduct;
      return this;
   }

   public FinishedProductWarehousingSummaryDetailReport setTotalPutPart(final BigDecimal totalPutPart) {
      this.totalPutPart = totalPutPart;
      return this;
   }

   public FinishedProductWarehousingSummaryDetailReport setTotalFinishProduct(final BigDecimal totalFinishProduct) {
      this.totalFinishProduct = totalFinishProduct;
      return this;
   }

   public FinishedProductWarehousingSummaryDetailReport setThisMonthFinishOutput(final BigDecimal thisMonthFinishOutput) {
      this.thisMonthFinishOutput = thisMonthFinishOutput;
      return this;
   }

   public FinishedProductWarehousingSummaryDetailReport setWorkRemark(final String workRemark) {
      this.workRemark = workRemark;
      return this;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof FinishedProductWarehousingSummaryDetailReport)) {
         return false;
      }

      FinishedProductWarehousingSummaryDetailReport other = (FinishedProductWarehousingSummaryDetailReport)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$typeNumber = this.getTypeNumber();
      Object other$typeNumber = other.getTypeNumber();
      if (this$typeNumber == null ? other$typeNumber == null : this$typeNumber.equals(other$typeNumber)) {
         Object this$projectName = this.getProjectName();
         Object other$projectName = other.getProjectName();
         if (this$projectName == null ? other$projectName == null : this$projectName.equals(other$projectName)) {
            Object this$beginPutPart = this.getBeginPutPart();
            Object other$beginPutPart = other.getBeginPutPart();
            if (this$beginPutPart == null ? other$beginPutPart == null : this$beginPutPart.equals(other$beginPutPart)) {
               Object this$beginFinishProduct = this.getBeginFinishProduct();
               Object other$beginFinishProduct = other.getBeginFinishProduct();
               if (this$beginFinishProduct == null ? other$beginFinishProduct == null : this$beginFinishProduct.equals(other$beginFinishProduct)) {
                  Object this$beginHalfProduct = this.getBeginHalfProduct();
                  Object other$beginHalfProduct = other.getBeginHalfProduct();
                  if (this$beginHalfProduct == null ? other$beginHalfProduct == null : this$beginHalfProduct.equals(other$beginHalfProduct)) {
                     Object this$beginConvertFinishProduct = this.getBeginConvertFinishProduct();
                     Object other$beginConvertFinishProduct = other.getBeginConvertFinishProduct();
                     if (this$beginConvertFinishProduct == null
                        ? other$beginConvertFinishProduct == null
                        : this$beginConvertFinishProduct.equals(other$beginConvertFinishProduct)) {
                        Object this$thisMonthPutPart = this.getThisMonthPutPart();
                        Object other$thisMonthPutPart = other.getThisMonthPutPart();
                        if (this$thisMonthPutPart == null ? other$thisMonthPutPart == null : this$thisMonthPutPart.equals(other$thisMonthPutPart)) {
                           Object this$thisMonthFinishProduct = this.getThisMonthFinishProduct();
                           Object other$thisMonthFinishProduct = other.getThisMonthFinishProduct();
                           if (this$thisMonthFinishProduct == null
                              ? other$thisMonthFinishProduct == null
                              : this$thisMonthFinishProduct.equals(other$thisMonthFinishProduct)) {
                              Object this$thisMonthHalfProduct = this.getThisMonthHalfProduct();
                              Object other$thisMonthHalfProduct = other.getThisMonthHalfProduct();
                              if (this$thisMonthHalfProduct == null
                                 ? other$thisMonthHalfProduct == null
                                 : this$thisMonthHalfProduct.equals(other$thisMonthHalfProduct)) {
                                 Object this$thisMonthConvertFinishProduct = this.getThisMonthConvertFinishProduct();
                                 Object other$thisMonthConvertFinishProduct = other.getThisMonthConvertFinishProduct();
                                 if (this$thisMonthConvertFinishProduct == null
                                    ? other$thisMonthConvertFinishProduct == null
                                    : this$thisMonthConvertFinishProduct.equals(other$thisMonthConvertFinishProduct)) {
                                    Object this$totalPutPart = this.getTotalPutPart();
                                    Object other$totalPutPart = other.getTotalPutPart();
                                    if (this$totalPutPart == null ? other$totalPutPart == null : this$totalPutPart.equals(other$totalPutPart)) {
                                       Object this$totalFinishProduct = this.getTotalFinishProduct();
                                       Object other$totalFinishProduct = other.getTotalFinishProduct();
                                       if (this$totalFinishProduct == null
                                          ? other$totalFinishProduct == null
                                          : this$totalFinishProduct.equals(other$totalFinishProduct)) {
                                          Object this$thisMonthFinishOutput = this.getThisMonthFinishOutput();
                                          Object other$thisMonthFinishOutput = other.getThisMonthFinishOutput();
                                          if (this$thisMonthFinishOutput == null
                                             ? other$thisMonthFinishOutput == null
                                             : this$thisMonthFinishOutput.equals(other$thisMonthFinishOutput)) {
                                             Object this$workRemark = this.getWorkRemark();
                                             Object other$workRemark = other.getWorkRemark();
                                             return this$workRemark == null ? other$workRemark == null : this$workRemark.equals(other$workRemark);
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
      return other instanceof FinishedProductWarehousingSummaryDetailReport;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $typeNumber = this.getTypeNumber();
      result = result * 59 + ($typeNumber == null ? 43 : $typeNumber.hashCode());
      Object $projectName = this.getProjectName();
      result = result * 59 + ($projectName == null ? 43 : $projectName.hashCode());
      Object $beginPutPart = this.getBeginPutPart();
      result = result * 59 + ($beginPutPart == null ? 43 : $beginPutPart.hashCode());
      Object $beginFinishProduct = this.getBeginFinishProduct();
      result = result * 59 + ($beginFinishProduct == null ? 43 : $beginFinishProduct.hashCode());
      Object $beginHalfProduct = this.getBeginHalfProduct();
      result = result * 59 + ($beginHalfProduct == null ? 43 : $beginHalfProduct.hashCode());
      Object $beginConvertFinishProduct = this.getBeginConvertFinishProduct();
      result = result * 59 + ($beginConvertFinishProduct == null ? 43 : $beginConvertFinishProduct.hashCode());
      Object $thisMonthPutPart = this.getThisMonthPutPart();
      result = result * 59 + ($thisMonthPutPart == null ? 43 : $thisMonthPutPart.hashCode());
      Object $thisMonthFinishProduct = this.getThisMonthFinishProduct();
      result = result * 59 + ($thisMonthFinishProduct == null ? 43 : $thisMonthFinishProduct.hashCode());
      Object $thisMonthHalfProduct = this.getThisMonthHalfProduct();
      result = result * 59 + ($thisMonthHalfProduct == null ? 43 : $thisMonthHalfProduct.hashCode());
      Object $thisMonthConvertFinishProduct = this.getThisMonthConvertFinishProduct();
      result = result * 59 + ($thisMonthConvertFinishProduct == null ? 43 : $thisMonthConvertFinishProduct.hashCode());
      Object $totalPutPart = this.getTotalPutPart();
      result = result * 59 + ($totalPutPart == null ? 43 : $totalPutPart.hashCode());
      Object $totalFinishProduct = this.getTotalFinishProduct();
      result = result * 59 + ($totalFinishProduct == null ? 43 : $totalFinishProduct.hashCode());
      Object $thisMonthFinishOutput = this.getThisMonthFinishOutput();
      result = result * 59 + ($thisMonthFinishOutput == null ? 43 : $thisMonthFinishOutput.hashCode());
      Object $workRemark = this.getWorkRemark();
      return result * 59 + ($workRemark == null ? 43 : $workRemark.hashCode());
   }

   @Override
   public String toString() {
      return "FinishedProductWarehousingSummaryDetailReport(typeNumber="
         + this.getTypeNumber()
         + ", projectName="
         + this.getProjectName()
         + ", beginPutPart="
         + this.getBeginPutPart()
         + ", beginFinishProduct="
         + this.getBeginFinishProduct()
         + ", beginHalfProduct="
         + this.getBeginHalfProduct()
         + ", beginConvertFinishProduct="
         + this.getBeginConvertFinishProduct()
         + ", thisMonthPutPart="
         + this.getThisMonthPutPart()
         + ", thisMonthFinishProduct="
         + this.getThisMonthFinishProduct()
         + ", thisMonthHalfProduct="
         + this.getThisMonthHalfProduct()
         + ", thisMonthConvertFinishProduct="
         + this.getThisMonthConvertFinishProduct()
         + ", totalPutPart="
         + this.getTotalPutPart()
         + ", totalFinishProduct="
         + this.getTotalFinishProduct()
         + ", thisMonthFinishOutput="
         + this.getThisMonthFinishOutput()
         + ", workRemark="
         + this.getWorkRemark()
         + ")";
   }

   public static class FinishedProductWarehousingSummaryDetailReportBuilder {
      private Integer typeNumber;
      private String projectName;
      private BigDecimal beginPutPart;
      private BigDecimal beginFinishProduct;
      private BigDecimal beginHalfProduct;
      private BigDecimal beginConvertFinishProduct;
      private BigDecimal thisMonthPutPart;
      private BigDecimal thisMonthFinishProduct;
      private BigDecimal thisMonthHalfProduct;
      private BigDecimal thisMonthConvertFinishProduct;
      private BigDecimal totalPutPart;
      private BigDecimal totalFinishProduct;
      private BigDecimal thisMonthFinishOutput;
      private String workRemark;

      FinishedProductWarehousingSummaryDetailReportBuilder() {
      }

      public FinishedProductWarehousingSummaryDetailReport.FinishedProductWarehousingSummaryDetailReportBuilder typeNumber(final Integer typeNumber) {
         this.typeNumber = typeNumber;
         return this;
      }

      public FinishedProductWarehousingSummaryDetailReport.FinishedProductWarehousingSummaryDetailReportBuilder projectName(final String projectName) {
         this.projectName = projectName;
         return this;
      }

      public FinishedProductWarehousingSummaryDetailReport.FinishedProductWarehousingSummaryDetailReportBuilder beginPutPart(final BigDecimal beginPutPart) {
         this.beginPutPart = beginPutPart;
         return this;
      }

      public FinishedProductWarehousingSummaryDetailReport.FinishedProductWarehousingSummaryDetailReportBuilder beginFinishProduct(
         final BigDecimal beginFinishProduct
      ) {
         this.beginFinishProduct = beginFinishProduct;
         return this;
      }

      public FinishedProductWarehousingSummaryDetailReport.FinishedProductWarehousingSummaryDetailReportBuilder beginHalfProduct(
         final BigDecimal beginHalfProduct
      ) {
         this.beginHalfProduct = beginHalfProduct;
         return this;
      }

      public FinishedProductWarehousingSummaryDetailReport.FinishedProductWarehousingSummaryDetailReportBuilder beginConvertFinishProduct(
         final BigDecimal beginConvertFinishProduct
      ) {
         this.beginConvertFinishProduct = beginConvertFinishProduct;
         return this;
      }

      public FinishedProductWarehousingSummaryDetailReport.FinishedProductWarehousingSummaryDetailReportBuilder thisMonthPutPart(
         final BigDecimal thisMonthPutPart
      ) {
         this.thisMonthPutPart = thisMonthPutPart;
         return this;
      }

      public FinishedProductWarehousingSummaryDetailReport.FinishedProductWarehousingSummaryDetailReportBuilder thisMonthFinishProduct(
         final BigDecimal thisMonthFinishProduct
      ) {
         this.thisMonthFinishProduct = thisMonthFinishProduct;
         return this;
      }

      public FinishedProductWarehousingSummaryDetailReport.FinishedProductWarehousingSummaryDetailReportBuilder thisMonthHalfProduct(
         final BigDecimal thisMonthHalfProduct
      ) {
         this.thisMonthHalfProduct = thisMonthHalfProduct;
         return this;
      }

      public FinishedProductWarehousingSummaryDetailReport.FinishedProductWarehousingSummaryDetailReportBuilder thisMonthConvertFinishProduct(
         final BigDecimal thisMonthConvertFinishProduct
      ) {
         this.thisMonthConvertFinishProduct = thisMonthConvertFinishProduct;
         return this;
      }

      public FinishedProductWarehousingSummaryDetailReport.FinishedProductWarehousingSummaryDetailReportBuilder totalPutPart(final BigDecimal totalPutPart) {
         this.totalPutPart = totalPutPart;
         return this;
      }

      public FinishedProductWarehousingSummaryDetailReport.FinishedProductWarehousingSummaryDetailReportBuilder totalFinishProduct(
         final BigDecimal totalFinishProduct
      ) {
         this.totalFinishProduct = totalFinishProduct;
         return this;
      }

      public FinishedProductWarehousingSummaryDetailReport.FinishedProductWarehousingSummaryDetailReportBuilder thisMonthFinishOutput(
         final BigDecimal thisMonthFinishOutput
      ) {
         this.thisMonthFinishOutput = thisMonthFinishOutput;
         return this;
      }

      public FinishedProductWarehousingSummaryDetailReport.FinishedProductWarehousingSummaryDetailReportBuilder workRemark(final String workRemark) {
         this.workRemark = workRemark;
         return this;
      }

      public FinishedProductWarehousingSummaryDetailReport build() {
         return new FinishedProductWarehousingSummaryDetailReport(
            this.typeNumber,
            this.projectName,
            this.beginPutPart,
            this.beginFinishProduct,
            this.beginHalfProduct,
            this.beginConvertFinishProduct,
            this.thisMonthPutPart,
            this.thisMonthFinishProduct,
            this.thisMonthHalfProduct,
            this.thisMonthConvertFinishProduct,
            this.totalPutPart,
            this.totalFinishProduct,
            this.thisMonthFinishOutput,
            this.workRemark
         );
      }

      @Override
      public String toString() {
         return "FinishedProductWarehousingSummaryDetailReport.FinishedProductWarehousingSummaryDetailReportBuilder(typeNumber="
            + this.typeNumber
            + ", projectName="
            + this.projectName
            + ", beginPutPart="
            + this.beginPutPart
            + ", beginFinishProduct="
            + this.beginFinishProduct
            + ", beginHalfProduct="
            + this.beginHalfProduct
            + ", beginConvertFinishProduct="
            + this.beginConvertFinishProduct
            + ", thisMonthPutPart="
            + this.thisMonthPutPart
            + ", thisMonthFinishProduct="
            + this.thisMonthFinishProduct
            + ", thisMonthHalfProduct="
            + this.thisMonthHalfProduct
            + ", thisMonthConvertFinishProduct="
            + this.thisMonthConvertFinishProduct
            + ", totalPutPart="
            + this.totalPutPart
            + ", totalFinishProduct="
            + this.totalFinishProduct
            + ", thisMonthFinishOutput="
            + this.thisMonthFinishOutput
            + ", workRemark="
            + this.workRemark
            + ")";
      }
   }
}
