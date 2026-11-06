package com.hzchum.scim.mes.building.core.api.pojo._doParam.workshopStatistics;

import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

public class WorkshopProductionStatisticsQueryParam {
   @NotNull(message = "统计起始日期不能为空")
   @ApiModelProperty(name = "startDate", value = "统计起始日期", required = true)
   private LocalDate startDate;
   @NotNull(message = "统计结束日期不能为空")
   @ApiModelProperty(name = "endDate", value = "统计结束日期", required = true)
   private LocalDate endDate;
   @ApiModelProperty(name = "workshopId", value = "车间id，不传则查询全部车间")
   private Long workshopId;

   @AssertTrue(message = "统计起始日期不能晚于结束日期")
   public boolean isDateRangeValid() {
      return this.startDate != null && this.endDate != null ? !this.startDate.isAfter(this.endDate) : true;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof WorkshopProductionStatisticsQueryParam)) {
         return false;
      }

      WorkshopProductionStatisticsQueryParam other = (WorkshopProductionStatisticsQueryParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof WorkshopProductionStatisticsQueryParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "WorkshopProductionStatisticsQueryParam(startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ", workshopId="
         + this.getWorkshopId()
         + ")";
   }
}
