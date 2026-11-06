package com.hzchum.scim.project.core.api.pojo.dtoParam.query;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("填报列表查询类")
public class InstallReportQueryDTOParam {
   @ApiModelProperty("项目ID")
   Long projectId;
   @ApiModelProperty("劳务分包商ID")
   Long supplierId;
   @ApiModelProperty("产品类型")
   Integer productType;
   @ApiModelProperty("围护分类")
   Integer category;
   @ApiModelProperty("审核状态 1未审核 2审核通过 4驳回")
   Integer auditStatus;
   @ApiModelProperty("年月 2022-07")
   String yearMonth;
   @ApiModelProperty("年月日 2022/07/08")
   String yearMonthDay;
   @ApiModelProperty("开始日期")
   LocalDate startDate;
   @ApiModelProperty("结束日期")
   LocalDate endDate;
   @ApiModelProperty(name = "reportMethod", value = "填报类型 1:app端 0:pc端(后台填报)")
   private Integer reportMethod;

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getSupplierId() {
      return this.supplierId;
   }

   public Integer getProductType() {
      return this.productType;
   }

   public Integer getCategory() {
      return this.category;
   }

   public Integer getAuditStatus() {
      return this.auditStatus;
   }

   public String getYearMonth() {
      return this.yearMonth;
   }

   public String getYearMonthDay() {
      return this.yearMonthDay;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Integer getReportMethod() {
      return this.reportMethod;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setSupplierId(final Long supplierId) {
      this.supplierId = supplierId;
   }

   public void setProductType(final Integer productType) {
      this.productType = productType;
   }

   public void setCategory(final Integer category) {
      this.category = category;
   }

   public void setAuditStatus(final Integer auditStatus) {
      this.auditStatus = auditStatus;
   }

   public void setYearMonth(final String yearMonth) {
      this.yearMonth = yearMonth;
   }

   public void setYearMonthDay(final String yearMonthDay) {
      this.yearMonthDay = yearMonthDay;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setReportMethod(final Integer reportMethod) {
      this.reportMethod = reportMethod;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof InstallReportQueryDTOParam)) {
         return false;
      }

      InstallReportQueryDTOParam other = (InstallReportQueryDTOParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$projectId = this.getProjectId();
      Object other$projectId = other.getProjectId();
      if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
         Object this$supplierId = this.getSupplierId();
         Object other$supplierId = other.getSupplierId();
         if (this$supplierId == null ? other$supplierId == null : this$supplierId.equals(other$supplierId)) {
            Object this$productType = this.getProductType();
            Object other$productType = other.getProductType();
            if (this$productType == null ? other$productType == null : this$productType.equals(other$productType)) {
               Object this$category = this.getCategory();
               Object other$category = other.getCategory();
               if (this$category == null ? other$category == null : this$category.equals(other$category)) {
                  Object this$auditStatus = this.getAuditStatus();
                  Object other$auditStatus = other.getAuditStatus();
                  if (this$auditStatus == null ? other$auditStatus == null : this$auditStatus.equals(other$auditStatus)) {
                     Object this$reportMethod = this.getReportMethod();
                     Object other$reportMethod = other.getReportMethod();
                     if (this$reportMethod == null ? other$reportMethod == null : this$reportMethod.equals(other$reportMethod)) {
                        Object this$yearMonth = this.getYearMonth();
                        Object other$yearMonth = other.getYearMonth();
                        if (this$yearMonth == null ? other$yearMonth == null : this$yearMonth.equals(other$yearMonth)) {
                           Object this$yearMonthDay = this.getYearMonthDay();
                           Object other$yearMonthDay = other.getYearMonthDay();
                           if (this$yearMonthDay == null ? other$yearMonthDay == null : this$yearMonthDay.equals(other$yearMonthDay)) {
                              Object this$startDate = this.getStartDate();
                              Object other$startDate = other.getStartDate();
                              if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                                 Object this$endDate = this.getEndDate();
                                 Object other$endDate = other.getEndDate();
                                 return this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate);
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
      return other instanceof InstallReportQueryDTOParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $supplierId = this.getSupplierId();
      result = result * 59 + ($supplierId == null ? 43 : $supplierId.hashCode());
      Object $productType = this.getProductType();
      result = result * 59 + ($productType == null ? 43 : $productType.hashCode());
      Object $category = this.getCategory();
      result = result * 59 + ($category == null ? 43 : $category.hashCode());
      Object $auditStatus = this.getAuditStatus();
      result = result * 59 + ($auditStatus == null ? 43 : $auditStatus.hashCode());
      Object $reportMethod = this.getReportMethod();
      result = result * 59 + ($reportMethod == null ? 43 : $reportMethod.hashCode());
      Object $yearMonth = this.getYearMonth();
      result = result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
      Object $yearMonthDay = this.getYearMonthDay();
      result = result * 59 + ($yearMonthDay == null ? 43 : $yearMonthDay.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "InstallReportQueryDTOParam(projectId="
         + this.getProjectId()
         + ", supplierId="
         + this.getSupplierId()
         + ", productType="
         + this.getProductType()
         + ", category="
         + this.getCategory()
         + ", auditStatus="
         + this.getAuditStatus()
         + ", yearMonth="
         + this.getYearMonth()
         + ", yearMonthDay="
         + this.getYearMonthDay()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", reportMethod="
         + this.getReportMethod()
         + ")";
   }
}
