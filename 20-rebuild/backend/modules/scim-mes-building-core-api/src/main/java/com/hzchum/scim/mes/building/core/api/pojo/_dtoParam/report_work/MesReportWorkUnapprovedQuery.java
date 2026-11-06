package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.report_work;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;

@ApiModel("报工未审批Query")
public class MesReportWorkUnapprovedQuery {
   @ApiModelProperty("产品类型")
   private Integer productTypeEnum;
   @ApiModelProperty("车间ID")
   private Long workshopId;
   @ApiModelProperty("项目ID")
   private Long projectId;
   @ApiModelProperty("工序ID")
   private Long processId;
   @ApiModelProperty("开始日期")
   private LocalDate startDate;
   @ApiModelProperty("结束日期")
   private LocalDate endDate;
   @ApiModelProperty("年份")
   private Integer year;
   @ApiModelProperty("产品编号")
   private String productSerialNumber;

   MesReportWorkUnapprovedQuery(
      final Integer productTypeEnum,
      final Long workshopId,
      final Long projectId,
      final Long processId,
      final LocalDate startDate,
      final LocalDate endDate,
      final Integer year,
      final String productSerialNumber
   ) {
      this.productTypeEnum = productTypeEnum;
      this.workshopId = workshopId;
      this.projectId = projectId;
      this.processId = processId;
      this.startDate = startDate;
      this.endDate = endDate;
      this.year = year;
      this.productSerialNumber = productSerialNumber;
   }

   public static MesReportWorkUnapprovedQuery.MesReportWorkUnapprovedQueryBuilder builder() {
      return new MesReportWorkUnapprovedQuery.MesReportWorkUnapprovedQueryBuilder();
   }

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Integer getYear() {
      return this.year;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public void setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setYear(final Integer year) {
      this.year = year;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesReportWorkUnapprovedQuery)) {
         return false;
      }

      MesReportWorkUnapprovedQuery other = (MesReportWorkUnapprovedQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$productTypeEnum = this.getProductTypeEnum();
      Object other$productTypeEnum = other.getProductTypeEnum();
      if (this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum)) {
         Object this$workshopId = this.getWorkshopId();
         Object other$workshopId = other.getWorkshopId();
         if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
            Object this$projectId = this.getProjectId();
            Object other$projectId = other.getProjectId();
            if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
               Object this$processId = this.getProcessId();
               Object other$processId = other.getProcessId();
               if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
                  Object this$year = this.getYear();
                  Object other$year = other.getYear();
                  if (this$year == null ? other$year == null : this$year.equals(other$year)) {
                     Object this$startDate = this.getStartDate();
                     Object other$startDate = other.getStartDate();
                     if (this$startDate == null ? other$startDate == null : this$startDate.equals(other$startDate)) {
                        Object this$endDate = this.getEndDate();
                        Object other$endDate = other.getEndDate();
                        if (this$endDate == null ? other$endDate == null : this$endDate.equals(other$endDate)) {
                           Object this$productSerialNumber = this.getProductSerialNumber();
                           Object other$productSerialNumber = other.getProductSerialNumber();
                           return this$productSerialNumber == null
                              ? other$productSerialNumber == null
                              : this$productSerialNumber.equals(other$productSerialNumber);
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
      return other instanceof MesReportWorkUnapprovedQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $productTypeEnum = this.getProductTypeEnum();
      result = result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $year = this.getYear();
      result = result * 59 + ($year == null ? 43 : $year.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      result = result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      return result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "MesReportWorkUnapprovedQuery(productTypeEnum="
         + this.getProductTypeEnum()
         + ", workshopId="
         + this.getWorkshopId()
         + ", projectId="
         + this.getProjectId()
         + ", processId="
         + this.getProcessId()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", year="
         + this.getYear()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ")";
   }

   public static class MesReportWorkUnapprovedQueryBuilder {
      private Integer productTypeEnum;
      private Long workshopId;
      private Long projectId;
      private Long processId;
      private LocalDate startDate;
      private LocalDate endDate;
      private Integer year;
      private String productSerialNumber;

      MesReportWorkUnapprovedQueryBuilder() {
      }

      public MesReportWorkUnapprovedQuery.MesReportWorkUnapprovedQueryBuilder productTypeEnum(final Integer productTypeEnum) {
         this.productTypeEnum = productTypeEnum;
         return this;
      }

      public MesReportWorkUnapprovedQuery.MesReportWorkUnapprovedQueryBuilder workshopId(final Long workshopId) {
         this.workshopId = workshopId;
         return this;
      }

      public MesReportWorkUnapprovedQuery.MesReportWorkUnapprovedQueryBuilder projectId(final Long projectId) {
         this.projectId = projectId;
         return this;
      }

      public MesReportWorkUnapprovedQuery.MesReportWorkUnapprovedQueryBuilder processId(final Long processId) {
         this.processId = processId;
         return this;
      }

      public MesReportWorkUnapprovedQuery.MesReportWorkUnapprovedQueryBuilder startDate(final LocalDate startDate) {
         this.startDate = startDate;
         return this;
      }

      public MesReportWorkUnapprovedQuery.MesReportWorkUnapprovedQueryBuilder endDate(final LocalDate endDate) {
         this.endDate = endDate;
         return this;
      }

      public MesReportWorkUnapprovedQuery.MesReportWorkUnapprovedQueryBuilder year(final Integer year) {
         this.year = year;
         return this;
      }

      public MesReportWorkUnapprovedQuery.MesReportWorkUnapprovedQueryBuilder productSerialNumber(final String productSerialNumber) {
         this.productSerialNumber = productSerialNumber;
         return this;
      }

      public MesReportWorkUnapprovedQuery build() {
         return new MesReportWorkUnapprovedQuery(
            this.productTypeEnum, this.workshopId, this.projectId, this.processId, this.startDate, this.endDate, this.year, this.productSerialNumber
         );
      }

      @Override
      public String toString() {
         return "MesReportWorkUnapprovedQuery.MesReportWorkUnapprovedQueryBuilder(productTypeEnum="
            + this.productTypeEnum
            + ", workshopId="
            + this.workshopId
            + ", projectId="
            + this.projectId
            + ", processId="
            + this.processId
            + ", startDate="
            + this.startDate
            + ", endDate="
            + this.endDate
            + ", year="
            + this.year
            + ", productSerialNumber="
            + this.productSerialNumber
            + ")";
      }
   }
}
