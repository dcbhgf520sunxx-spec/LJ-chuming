package com.hzchum.scim.mes.building.core.api.pojo._dtoParam.wage_manage.request;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.time.LocalDate;
import javax.validation.constraints.NotNull;

@ApiModel("反推模式生产明细下载参数")
public class ReverseInferenceModeExportParam {
   @NotNull(message = "车间ID不能为空")
   @ApiModelProperty("车间ID")
   private Long workshopId;
   @NotNull(message = "工序ID不能为空")
   @ApiModelProperty("工序ID")
   private Long processId;
   @NotNull(message = "组长名称不能为空")
   @ApiModelProperty("组长名称")
   private String teamLeaderName;
   @NotNull(message = "开始日期不能为空")
   @ApiModelProperty("开始日期")
   private LocalDate startDate;
   @NotNull(message = "结束日期不能为空")
   @ApiModelProperty("结束日期")
   private LocalDate endDate;

   public Long getWorkshopId() {
      return this.workshopId;
   }

   public Long getProcessId() {
      return this.processId;
   }

   public String getTeamLeaderName() {
      return this.teamLeaderName;
   }

   public LocalDate getStartDate() {
      return this.startDate;
   }

   public LocalDate getEndDate() {
      return this.endDate;
   }

   public void setWorkshopId(final Long workshopId) {
      this.workshopId = workshopId;
   }

   public void setProcessId(final Long processId) {
      this.processId = processId;
   }

   public void setTeamLeaderName(final String teamLeaderName) {
      this.teamLeaderName = teamLeaderName;
   }

   public void setStartDate(final LocalDate startDate) {
      this.startDate = startDate;
   }

   public void setEndDate(final LocalDate endDate) {
      this.endDate = endDate;
   }

   @Override
   public boolean equals(final Object o) {
      if (o == this) {
         return true;
      }

      if (!(o instanceof ReverseInferenceModeExportParam)) {
         return false;
      }

      ReverseInferenceModeExportParam other = (ReverseInferenceModeExportParam)o;
      if (!other.canEqual(this)) {
         return false;
      }

      Object this$workshopId = this.getWorkshopId();
      Object other$workshopId = other.getWorkshopId();
      if (this$workshopId == null ? other$workshopId == null : this$workshopId.equals(other$workshopId)) {
         Object this$processId = this.getProcessId();
         Object other$processId = other.getProcessId();
         if (this$processId == null ? other$processId == null : this$processId.equals(other$processId)) {
            Object this$teamLeaderName = this.getTeamLeaderName();
            Object other$teamLeaderName = other.getTeamLeaderName();
            if (this$teamLeaderName == null ? other$teamLeaderName == null : this$teamLeaderName.equals(other$teamLeaderName)) {
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
   }

   protected boolean canEqual(final Object other) {
      return other instanceof ReverseInferenceModeExportParam;
   }

   @Override
   public int hashCode() {
      int PRIME = 59;
      int result = 1;
      Object $workshopId = this.getWorkshopId();
      result = result * 59 + ($workshopId == null ? 43 : $workshopId.hashCode());
      Object $processId = this.getProcessId();
      result = result * 59 + ($processId == null ? 43 : $processId.hashCode());
      Object $teamLeaderName = this.getTeamLeaderName();
      result = result * 59 + ($teamLeaderName == null ? 43 : $teamLeaderName.hashCode());
      Object $startDate = this.getStartDate();
      result = result * 59 + ($startDate == null ? 43 : $startDate.hashCode());
      Object $endDate = this.getEndDate();
      return result * 59 + ($endDate == null ? 43 : $endDate.hashCode());
   }

   @Override
   public String toString() {
      return "ReverseInferenceModeExportParam(workshopId="
         + this.getWorkshopId()
         + ", processId="
         + this.getProcessId()
         + ", teamLeaderName="
         + this.getTeamLeaderName()
         + ", startDate="
         + this.getStartDate()
         + ", endDate="
         + this.getEndDate()
         + ")";
   }
}
