package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.quota_config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import java.util.List;

@ApiModel("报工审核Query")
public class MesProductionReportingApprovalQuery {
   @ApiModelProperty("年月")
   LocalDate yearMonth;
   @ApiModelProperty("日期")
   LocalDate date;
   @ApiModelProperty("车间id")
   Long workshopId;
   @ApiModelProperty("产品类型")
   Integer productTypeEnum;
   @ApiModelProperty("工序id")
   Long processId;
   @ApiModelProperty("班组id")
   Long teamId;
   @ApiModelProperty("日期List")
   List<LocalDate> dateList;
   @ApiModelProperty("项目id")
   private Long projectId;
   @ApiModelProperty("产品编号")
   private String productSerialNumber;

   public LocalDate getYearMonth() {
      return this.yearMonth;
   }

   public LocalDate getDate() {
      return this.date;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Integer getProductTypeEnum() {
      return this.productTypeEnum;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public Long getTeamId() {
      return this.teamId;
   }

   public List<LocalDate> getDateList() {
      return this.dateList;
   }

   public Long getProjectId() {
      return this.projectId;
   }

   public String getProductSerialNumber() {
      return this.productSerialNumber;
   }

   public void setYearMonth(final LocalDate yearMonth) {
      this.yearMonth = yearMonth;
   }

   public void setDate(final LocalDate date) {
      this.date = date;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setProductTypeEnum(final Integer productTypeEnum) {
      this.productTypeEnum = productTypeEnum;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setTeamId(final Long teamId) {
      this.teamId = teamId;
   }

   public void setDateList(final List<LocalDate> dateList) {
      this.dateList = dateList;
   }

   public void setProjectId(final Long projectId) {
      this.projectId = projectId;
   }

   public void setProductSerialNumber(final String productSerialNumber) {
      this.productSerialNumber = productSerialNumber;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof MesProductionReportingApprovalQuery)) {
         return false;
      }

      MesProductionReportingApprovalQuery other = (MesProductionReportingApprovalQuery)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$productTypeEnum = this.getProductTypeEnum();
         Object other$productTypeEnum = other.getProductTypeEnum();
         if (this$productTypeEnum == null ? other$productTypeEnum == null : this$productTypeEnum.equals(other$productTypeEnum)) {
            Object this$processId = this.getProcessId();
            Object other$processId = other.getProcessId();
            if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
               Object this$teamId = this.getTeamId();
               Object other$teamId = other.getTeamId();
               if (this$teamId == null ? other$teamId == null : this$teamId.equals(other$teamId)) {
                  Object this$projectId = this.getProjectId();
                  Object other$projectId = other.getProjectId();
                  if (this$projectId == null ? other$projectId == null : this$projectId.equals(other$projectId)) {
                     Object this$yearMonth = this.getYearMonth();
                     Object other$yearMonth = other.getYearMonth();
                     if (this$yearMonth == null ? other$yearMonth == null : this$yearMonth.equals(other$yearMonth)) {
                        Object this$date = this.getDate();
                        Object other$date = other.getDate();
                        if (this$date == null ? other$date == null : this$date.equals(other$date)) {
                           Object this$dateList = this.getDateList();
                           Object other$dateList = other.getDateList();
                           if (this$dateList == null ? other$dateList == null : this$dateList.equals(other$dateList)) {
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
      } else {
         return false;
      }
   }

   protected boolean canEqual(final Object other) {
      return other instanceof MesProductionReportingApprovalQuery;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $productTypeEnum = this.getProductTypeEnum();
      result = result * 59 + ($productTypeEnum == null ? 43 : $productTypeEnum.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamId = this.getTeamId();
      result = result * 59 + ($teamId == null ? 43 : $teamId.hashCode());
      Object $projectId = this.getProjectId();
      result = result * 59 + ($projectId == null ? 43 : $projectId.hashCode());
      Object $yearMonth = this.getYearMonth();
      result = result * 59 + ($yearMonth == null ? 43 : $yearMonth.hashCode());
      Object $date = this.getDate();
      result = result * 59 + ($date == null ? 43 : $date.hashCode());
      Object $dateList = this.getDateList();
      result = result * 59 + ($dateList == null ? 43 : $dateList.hashCode());
      Object $productSerialNumber = this.getProductSerialNumber();
      return result * 59 + ($productSerialNumber == null ? 43 : $productSerialNumber.hashCode());
   }

   @Override
   public String toString() {
      return "MesProductionReportingApprovalQuery(yearMonth="
         + this.getYearMonth()
         + ", date="
         + this.getDate()
         + ", workshopId="
         + this.getWorkshopId()
         + ", productTypeEnum="
         + this.getProductTypeEnum()
         + ", processId="
         + this.getProcessId()
         + ", teamId="
         + this.getTeamId()
         + ", dateList="
         + this.getDateList()
         + ", projectId="
         + this.getProjectId()
         + ", productSerialNumber="
         + this.getProductSerialNumber()
         + ")";
   }
}
